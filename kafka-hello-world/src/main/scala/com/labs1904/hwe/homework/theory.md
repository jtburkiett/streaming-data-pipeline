# Overview

Kafka has many moving pieces, but also has a ton of helpful resources to learn available online. In this homework, your
challenge is to write answers that make sense to you, and most importantly, **in your own words!**
Two of the best skills you can get from this class are to find answers to your questions using any means possible, and to
reword confusing descriptions in a way that makes sense to you. 

### Tips
* You don't need to write novels, just write enough that you feel like you've fully answered the question
* Use the helpful resources that we post next to the questions as a starting point, but carve your own path by searching on Google, YouTube, books in a library, etc to get answers!
* We're here if you need us. Reach out anytime if you want to ask deeper questions about a topic 
* This file is a markdown file. We don't expect you to do any fancy markdown, but you're welcome to format however you like

### Your Challenge
1. Create a new branch for your answers 
2. Complete all of the questions below by writing your answers under each question
3. Commit your changes and push to your forked repository

## Questions
#### What problem does Kafka help solve? Use a specific use case in your answer 
* Helpful resource: [Confluent Motivations and Use Cases](https://youtu.be/BsojaA1XnpM)
Processing real-time events from multiple sources all in one centralized location. One use case might
be getting all the news from many outlets all over the world and streaming them via news feeds. 

#### What is Kafka?
* Helpful resource: [Kafka in 6 minutes](https://youtu.be/Ch5VhJzaoaI) 
Kafka is the answer to the problems faced by the distribution and scaling of messaging systems.
#### Describe each of the following with an example of how they all fit together: 
 * Topic
 a topic is a stream of data to which messages are stored. Producer apps write data to 
 topics and consumer applications read from topics. 
 * Producer
 A producer is an application that publishes data to the kafka cluster for consumers to read from
 * Consumer 
 Consumers are applications that read data from the cluster that has been published from the producer. 
 * Broker
 A server running on the Kafka cluster where data is published and consumed from.
 * Partition
 Partitions are where topics are stored. They are what make kafka scalable. 
 Producers and consumers can read and write to multiple partitions at the same time. 

#### Describe Kafka Producers and Consumers
Producers "produce" the data for the consumers to "consume"

#### How are consumers and consumer groups different in Kafka? 
* Helpful resource: [Consumers](https://youtu.be/lAdG16KaHLs)
* Helpful resource: [Confluent Consumer Overview](https://youtu.be/Z9g4jMQwog0)
 Consumers read data from a topic. Individually, consumers can read from multiple topics. Consumer groups are a consolidation of consumers. each consumer in a group reads from exclusive partitions
#### How are Kafka offsets different than partitions? 
Each partition is a logfile with new messages appended to the end. Each message in a partition is numbered sequentially which are called the offsets.
#### How is data assigned to a specific partition in Kafka? 
A producer can user a partition key to direct messages to a specific partition. If a procuder doesn't specifiy a partition key, kafka will use a round-robin partition assignment.
#### Describe immutability - Is data on a Kafka topic immutable?
Immutability means something that can not be changed after initialization. A kafka topic is an immutable log of events.  

#### How is data replicated across brokers in kafka? If you have a replication factor of 3 and 3 brokers, explain how data is spread across brokers
* Helpful resource [Brokers and Replication factors](https://youtu.be/ZOU7PJWZU9w)
A replication factor is specified when creating a topic. This number is how many copies of a partition to have for a topic.
For replication factor of 3 and 3 brokers, each broker will contain one leader partition and in-sync replicas will be stored on other brokers. 
#### What was the most fascinating aspect of Kafka to you while learning? 
How it is able to scale with such large data sets.
