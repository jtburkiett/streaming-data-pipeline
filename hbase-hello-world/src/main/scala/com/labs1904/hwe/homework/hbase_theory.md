# Overview

By now you've seen some different Big Data frameworks such as Kafka and Spark. Now we'll be focusing in on HBase. In this homework, your
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
#### What is a NoSQL database? 
It's a non-relational database. 

#### In your own words, what is Apache HBase? 
IT is a distributed, scalable, big data store. Data and processing occurs across multiple clusters. It scales by adding nodes to the clusters to increase the amount of data it can store. It is designed to support billions of rows with millions of columns.

#### What are some strengths and limitations of HBase? 
* [HBase By Examples](https://sparkbyexamples.com/apache-hbase-tutorial/)
Strengths would be speed and efficiency, scalability, no fixed schemas, API accesss for clients.
Limitations are that replacement of models are not easy, it is not like SQL therefore it can't be used like SQL, 
HBase does not provide a mechanism to start a transaction and roll it back. It doesn't support JOIN operations.
HBase is expensive in terms of hardware requirements and memory allocation. 
HBase has no default indexing. 
#### Explain the following concepts: 
* Rowkey - key is what you would use to access data in a specific row. This is crucial. Without the key you can't store or access data. 
* Column Qualifier - this is the column index, think of this as the column name. 
* Column Family = this is group or set of columns that are physically stored together on disk. 


#### What are the differences between Get and Put commands in HBase? 
* [HBase commands](https://www.tutorialspoint.com/hbase/hbase_create_data.htm)
The get command would be used to access a row in a hbase table. The put command would be used to put data in a row. 

#### What is the HBase Scan command for? 
* [HBase Scan](https://www.tutorialspoint.com/hbase/hbase_scan.htm)
The scan command is used to view the data in HTable. Using the scan command, you can get the table data.
#### What was the most interesting aspect of HBase when went through all the questions? 
I'll never get over how the scale of data that can be stored using HBase. To me, it's like storing the entirety of the Grand Canyon in a mason jar. 