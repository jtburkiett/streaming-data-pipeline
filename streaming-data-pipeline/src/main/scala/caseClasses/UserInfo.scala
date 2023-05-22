package caseClasses

import org.apache.hadoop.hbase.client.{Get, Table}
import org.apache.hadoop.hbase.util.Bytes

case class UserInfo(username: String, name: String, sex: String, birthdate: String, mail: String)

object UserInfoConstructor {
  def getUserInfo(rawReview: RawReview, table: Table) : UserInfo = {
    val columnFamily = "f1"
    val get = new Get(Bytes.toBytes(rawReview.customerId.toString)).addFamily(Bytes.toBytes(columnFamily))
    val result = table.get(get)
    UserInfo(
      Bytes.toString(result.getValue(Bytes.toBytes(columnFamily), Bytes.toBytes("username"))),
      Bytes.toString(result.getValue(Bytes.toBytes(columnFamily), Bytes.toBytes("name"))),
      Bytes.toString(result.getValue(Bytes.toBytes(columnFamily), Bytes.toBytes("sex"))),
      Bytes.toString(result.getValue(Bytes.toBytes(columnFamily), Bytes.toBytes("birthdate"))),
      Bytes.toString(result.getValue(Bytes.toBytes(columnFamily), Bytes.toBytes("mail")))
    )
  }
}
