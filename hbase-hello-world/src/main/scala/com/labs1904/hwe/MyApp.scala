package com.labs1904.hwe

import com.labs1904.hwe.ConnectionTest.logger
import org.apache.hadoop.hbase.{HBaseConfiguration, TableName}
import org.apache.hadoop.hbase.client.{Connection, ConnectionFactory, Delete, Get, Put, Scan}
import org.apache.hadoop.hbase.util.Bytes
import org.apache.logging.log4j.{LogManager, Logger}

import java.util
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

      val get = new Get(Bytes.toBytes("99"))
      val newUser = table.get(get);
      logger.debug(newUser)
      val get1 = new Get(Bytes.toBytes("9005729"))
      val get2 = new Get(Bytes.toBytes("500600"))
      val get3 = new Get(Bytes.toBytes("30059640"))
      val get4 = new Get(Bytes.toBytes("6005263"))
      val get5 = new Get(Bytes.toBytes("800182"))

//      val get = new Get(Bytes.toBytes("10000001")).addColumn(Bytes.toBytes("f1"), Bytes.toBytes("mail"))
      import java.util
      val queryRowList = new util.ArrayList[Get]
      queryRowList.add(get1)
      queryRowList.add(get2)
      queryRowList.add(get3)
      queryRowList.add(get4)
      queryRowList.add(get5)
      val result = table.get(queryRowList)
//      val message = Bytes.toString(result.getFamilyMap(Bytes.toBytes("f1")).get(Bytes.toBytes("mail")))
//      logger.debug(message)
      result.foreach(r => logger.debug(s"Email : ${Bytes.toString(r.getValue(Bytes.toBytes("f1"), Bytes.toBytes("mail")))}"))
      logger.debug(result)
      table.delete(new Delete(Bytes.toBytes("99")))
      val newResult = table.get(get)
      logger.debug(s"here is the new result $newResult")

    } catch {
      case e: Exception => logger.error("Error in main", e)
    } finally {
      if (connection != null) connection.close()
    }
  }
}
