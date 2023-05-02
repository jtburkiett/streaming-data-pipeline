package com.labs1904.hwe

import com.labs1904.hwe.ConnectionTest.logger
import org.apache.hadoop.hbase.{HBaseConfiguration, TableName}
import org.apache.hadoop.hbase.client.{Connection, ConnectionFactory, Get, Put, Scan}
import org.apache.hadoop.hbase.util.Bytes
import org.apache.logging.log4j.{LogManager, Logger}

import scala.collection.JavaConverters.iterableAsScalaIterableConverter

object MyApp {
  lazy val logger: Logger = LogManager.getLogger(this.getClass)

  def main(args: Array[String]): Unit = {
    logger.info("MyApp starting...")
    var connection: Connection = null
    try {
      val conf = HBaseConfiguration.create()
      conf.set("hbase.zookeeper.quorum", "CHANGE ME")
      connection = ConnectionFactory.createConnection(conf)
      // Example code... change me
      val table = connection.getTable(TableName.valueOf("jburkiett:users"))
      val put = new Put(Bytes.toBytes("99")).addColumn(Bytes.toBytes("f1"), Bytes.toBytes("favorite_color"), Bytes.toBytes("pink"))
      put.addColumn(Bytes.toBytes("f1"), Bytes.toBytes("username"), Bytes.toBytes("DE-HWE"))
      put.addColumn(Bytes.toBytes("f1"), Bytes.toBytes("name"), Bytes.toBytes("The Panther"))
      put.addColumn(Bytes.toBytes("f1"), Bytes.toBytes("sex"), Bytes.toBytes("F"))
      table.put(put)
      val scan = table.getScanner(new Scan().withStartRow(Bytes.toBytes("10000001")).withStopRow(Bytes.toBytes("10006001")))
//      val scan = table.getScanner(new Scan())
      var count = 0
      scan.asScala.foreach(result => {
        count += 1
        logger.debug(result)
      })
      logger.debug(s"final count is $count")
//      var count = 0
//      scan.asScala.foreach(result =>
//        if(result.containsNonEmptyColumn(Bytes.toBytes("f1"), Bytes.toBytes("ID"))){
//          count+=1
//          logger.debug(result.getValue(Bytes.toBytes("f1"), Bytes.toBytes("ID")))
//        })
//      logger.debug(s"here is the count $count")
      val get = new Get(Bytes.toBytes("99"))

//      val get = new Get(Bytes.toBytes("10000001")).addColumn(Bytes.toBytes("f1"), Bytes.toBytes("mail"))
      val result = table.get(get)
//      val message = Bytes.toString(result.getFamilyMap(Bytes.toBytes("f1")).get(Bytes.toBytes("mail")))
//      logger.debug(message)
      logger.debug(result)

    } catch {
      case e: Exception => logger.error("Error in main", e)
    } finally {
      if (connection != null) connection.close()
    }
  }
}
