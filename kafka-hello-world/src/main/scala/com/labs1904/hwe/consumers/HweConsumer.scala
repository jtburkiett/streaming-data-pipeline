package com.labs1904.hwe.consumers

import com.labs1904.hwe.util.Constants._
import com.labs1904.hwe.util.Util
import com.labs1904.hwe.util.Util.mapNumberToWord
import net.liftweb.json.DefaultFormats
import org.apache.kafka.clients.consumer.{ConsumerRecord, ConsumerRecords, KafkaConsumer}
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}
import org.slf4j.LoggerFactory

import java.time.Duration
import java.util.Arrays

case class RawUser(id: Int, username: String, fullName: String, email: String, birthday: String)
case class EnrichedUser(id: Int, username: String, fullName: String, email: String, birthday: String, numberAsWord: String, hweDeveloper: String)
object HweConsumer {
  val joeB : String = "Joe B"
  private val logger = LoggerFactory.getLogger(getClass)

  val consumerTopic: String = "question-1"
  val producerTopic: String = "question-1-output"

  implicit val formats: DefaultFormats.type = DefaultFormats

  def main(args: Array[String]): Unit = {

    // Create the KafkaConsumer
    val consumerProperties = Util.getConsumerProperties(BOOTSTRAP_SERVER)
    val consumer: KafkaConsumer[String, String] = new KafkaConsumer[String, String](consumerProperties)

    // Create the KafkaProducer
    val producerProperties = Util.getProperties(BOOTSTRAP_SERVER)
    val producer = new KafkaProducer[String, String](producerProperties)

    // Subscribe to the topic
    consumer.subscribe(Arrays.asList(consumerTopic))

    while ( {
      true
    }) {
      // poll for new data
      val duration: Duration = Duration.ofMillis(100)
      val records: ConsumerRecords[String, String] = consumer.poll(duration)

      records.forEach((record: ConsumerRecord[String, String]) => {
        // Retrieve the message from each record
        val message = record.value()
        logger.info(s"Message Received: $message")
        // TODO: Add business logic here!
        println(s"Here is your message $message")
        val splitMessage = message.split("\t")
        val rawUser = RawUser(splitMessage(0).toInt, splitMessage(1), splitMessage(2), splitMessage(3), splitMessage(4))
        val enrichedUser = EnrichedUser(rawUser.id, rawUser.username, rawUser.fullName, rawUser.email, rawUser.birthday, mapNumberToWord(rawUser.id), joeB)
        println(s"Here is the enrichedUser $enrichedUser")
        val testEnrichedUser = enrichedUser.productIterator.mkString(",")
        println(s"Here is the test ${testEnrichedUser}")
//        val commaSeparatedEnrichedUser = enrichedUser.id + "," + enrichedUser.username +
//          enrichedUser.fullName + "," + enrichedUser.email + "," + enrichedUser.birthday +
//          enrichedUser.numberAsWord + "," + enrichedUser.hweDeveloper
//        producer.send(new ProducerRecord[String, String](producerTopic, commaSeparatedEnrichedUser))

      })
    }
  }
}