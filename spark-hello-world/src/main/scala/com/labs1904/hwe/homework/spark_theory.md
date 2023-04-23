# Overview

Similar to the work you did for Kafka, this is your crash course into Spark through different questions. In this homework, your
challenge is to write answers that make sense to you, and most importantly, **in your own words!**
Two of the best skills you can get from this class are to find answers to your questions using any means possible, and to
reword confusing descriptions in a way that makes sense to you. 

### Tips
* You don't need to write novels, just write enough that you feel like you've fully answered the question
* Use the helpful resources that we post next to the questions as a starting point, but carve your own path by searching on Google, YouTube, books in a library, etc to get answers!
* We're here if you need us. Reach out anytime if you want to ask deeper questions about a topic 
* This file is a markdown file. We don't expect you to do any fancy markdown, but you're welcome to format however you like
* Spark By Examples is a great resources to start with - [Spark By Examples](https://sparkbyexamples.com/)

### Your Challenge
1. Create a new branch for your answers 
2. Complete all of the questions below by writing your answers under each question
3. Commit your changes and push to your forked repository

## Questions
#### What problem does Spark help solve? Use a specific use case in your answer 
* Helpful resource: [Apache Spark Use Cases](https://www.toptal.com/spark/introduction-to-apache-spark)
* [Overivew of Apache Spark](https://www.youtube.com/watch?v=znBa13Earms&t=42s)
###### Spark helps simplify processing high volumes of data whether it be archived or real time. A specific use case would be a fraud detection system. The spark stack can harvest huge amounts of archived logs and combine it with external data sources about data breaches and compromised accounts, etc... 

#### What is Apache Spark?
* Helpful resource: [Spark Overview](https://www.youtube.com/watch?v=ymtq8yjmD9I)
###### Spark is a lightning fast cluster computing engine. It can delegate parallel data processing on clusters of computers

#### What is distributed data processing? How does it relate to Apache Spark?  
[Apache Spark for Beginners](https://medium.com/@aristo_alex/apache-spark-for-beginners-d3b3791e259e)
Distributed data process is when data is processed on multiple machines. With apache spark, the data is distrubted acrossed multiple nodes in cluster. 

#### On the physical side of a spark cluster, you have a driver and executors. Define each and give an example of how they work together to process data
A driver communicates to the cluster manager. The cluster manager handles if certain machines are overloaded or fails then spreads work to available machines. The executors are the worker bees. Worker bees simple run tasks and return results to the driver. 

#### Define each and explain how they are different from each other 
* RDD (Resilient Distributed Dataset) - A Resilient Distributed Dataset (RDD), is the primary data abstraction in Apache Spark and the core of Spark. Represents an immutable, partitioned collection of elements that can be operated on in parallel.
* DataFrame - kinda like excel worksheet. It has rows and columns. Each column has a name and a data time. Unlike excel, there is no row limit and process data can be stored on hundreds or thousands of machines
* DataSet

#### What is a spark transformation?
[Spark By Examples-Transformations](https://sparkbyexamples.com/apache-spark-rdd/spark-rdd-transformations/)
A spark transformation takes in a dataframe and transforms it to a new dataframe. 

#### What is a spark action? How do actions differ from transformations? 
Spark actions are simple manipluations of data without transforming it. Printing the data would be an action. No changes made to the data just simply showing it. 

#### What is a partition in spark? Why would you ever need to repartition? 
[Spark Partitioning](https://sparkbyexamples.com/spark/spark-repartition-vs-coalesce/)
A partition in spark is an atomic chunk of data (logical division of data) stored on a node in the cluster. Partitions are basic units of parallelism in Apache Spark. RDDs in Apache Spark are collection of partitions.
Spark RDD repartition() method is used to increase or decrease the partitions. Spark repartition() is a very expensive operations as they shuffle the data across many partitions hence try to minimize repartition as much as possible.
#### What was the most fascinating aspect of Spark to you while learning? 
How simple it seems to transform or perform actions on data from various file types.
