package com.labs1904.spark

import caseClasses.EnrichedReviewConstructor.createEnrichedReview
import caseClasses.RawReviewConstructor.rawReviewFromCSV
import caseClasses.UserInfoConstructor.getUserInfo
import org.apache.hadoop.hbase.client.ConnectionFactory
import org.apache.hadoop.hbase.{HBaseConfiguration, TableName}
import org.apache.log4j.Logger
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.streaming.{OutputMode, Trigger}


/**
 * Spark Structured Streaming app
 *
 */

object StreamingPipeline {

  lazy val logger: Logger = Logger.getLogger(this.getClass)
  val jobName = "StreamingPipeline"

  val hdfsUrl = "CHANGEME"
  val bootstrapServers = "CHANGEME"
  val username = "CHANGEME"
  val password = "CHANGEME"
  val hdfsUsername = "CHANGEME" // TODO: set this to your handle

  val trustStore: String = "src/main/resources/kafka.client.truststore.jks"
  val Topic: String = "reviews"
  def main(args: Array[String]): Unit = {
    try {
      val spark = SparkSession.builder()
        .config("spark.sql.shuffle.partitions", "3")
        .config("spark.hadoop.dfs.client.use.datanode.hostname", "true")
        .config("spark.hadoop.fs.defaultFS", hdfsUrl)
        .appName(jobName)
        .master("local[*]")
        .getOrCreate()

      import spark.implicits._

      val ds = spark
        .readStream
        .format("kafka")
        .option("kafka.bootstrap.servers", bootstrapServers)
        .option("subscribe", "reviews")
        .option("startingOffsets", "earliest")
        .option("maxOffsetsPerTrigger", "20")
        .option("startingOffsets","earliest")
        .option("kafka.security.protocol", "SASL_SSL")
        .option("kafka.sasl.mechanism", "SCRAM-SHA-512")
        .option("kafka.ssl.truststore.location", trustStore)
        .option("kafka.sasl.jaas.config", getScramAuthString(username, password))
        .load()
        .selectExpr("CAST(value AS STRING)").as[String]

      val enrichedReviews = ds.mapPartitions(partition => {
        val conf = HBaseConfiguration.create()
        conf.set("hbase.zookeeper.quorum", "CHANGEME")
        val connection = ConnectionFactory.createConnection(conf)
        val table = connection.getTable(TableName.valueOf("CHANGEME"))

        val enrichedReview = partition.map(row => {
          val rawReview = rawReviewFromCSV(row)
          val userInfo = getUserInfo(rawReview, table)

          createEnrichedReview(rawReview, userInfo)
        }).toList.iterator

        connection.close()

        enrichedReview
      })

      // Write output to console
//      val query = customers.writeStream
//        .outputMode(OutputMode.Append())
//        .format("console")
//        .option("truncate", false)
//        .trigger(Trigger.ProcessingTime("5 seconds"))
//        .start()

      // Write output to HDFS
      val query = enrichedReviews.writeStream
        .outputMode(OutputMode.Append())
        .format("json")
        .option("path", s"/user/${hdfsUsername}/reviews_json")
        .option("checkpointLocation", s"/user/${hdfsUsername}/reviews_checkpoint")
        .trigger(Trigger.ProcessingTime("5 seconds"))
        .start()
      query.awaitTermination()
    } catch {
      case e: Exception => logger.error(s"$jobName error in main", e)
    }
  }

  def getScramAuthString(username: String, password: String) = {
    s"""org.apache.kafka.common.security.scram.ScramLoginModule required
   username=\"$username\"
   password=\"$password\";"""
  }
}
