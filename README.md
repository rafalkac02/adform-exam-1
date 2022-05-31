# Challenge #1

Table of contents
1. [About The Project](#about-the-project)
    - [Adform's exam](#adforms-exam)
    - [Project description](#project-description)
2. [Getting Started](#getting-started)
3. [Usage](#usage)
4. [Troubleshooting](#troubleshooting)


## About the Project

### Adform's exam
This project is a part of a final exam after 3-months of Scala Academy at [Adform](https://site.adform.com/). The exam consists of 7 exercises. You can navigate to them in Exam TOC below.

<details>
  <summary>Exam TOC</summary>

1. [Challenge #1](https://github.com/rafalkac02/adform-exam-1)
2. [Challenge #2](https://github.com/rafalkac02/adform-exam-2)
3. [Challenge #3](https://github.com/rafalkac02/adform-exam-3)
4. [Challenge #4](https://github.com/rafalkac02/adform-exam-4)
5. [Challenge #5](https://github.com/rafalkac02/adform-exam-5)
6. [Challenge #6](https://github.com/rafalkac02/adform-exam-6)
7. [Challenge #7](https://github.com/rafalkac02/adform-exam-7)
</details>

### Project description
This task is about Spark, Kafka and Hadoop.

- task description:

```text
Write a Spark application that reads records from a Kafka topic.
This application does the following transformations:

- Writes records to Kafka in JSON format
JSON example:
{
"name": "John",
"surname": "Doe",
"cats": 1,
"dogs": 2
}
- Reads the data from the topic
- Parses the JSONs
- Surname to upper case letters
- Sum cats and dogs fields and write the result to the new field “animals”.
- The result should be written as a parquet file in which every record consists of 3 columns: name (String), surname (String), animals (Integer).

```

## Getting Started
The project is built with:
- Scala
- sbt
- Spark
- Kafka

## Usage
- Clone the repository to the chosen directory with `git clone https://github.com/rafalkac02/adform-exam-1` command.
- Run the application with `sbt run` command in the same directory
- Test the application with `sbt test` command

The application reads from kafka topic named `my-topic` 
To produce messages, do the following in `kafka/bin` directory on `ubuntu`:
1. run zookeeper
```     
bin/zookeeper-server-start.sh config/zookeeper.properties
```
2. start broker
```
bin/kafka-server-start.sh config/server.properties
```
3. create `my-input` topic
```
bin/kafka-topics.sh --create --topic input --bootstrap-server localhost:9092
```
4. start producer
```
bin/kafka-console-producer.sh --topic input --bootstrap-server localhost:9092
```


## Troubleshooting
- Make sure that your project does not contain outdated project files using:
```
sbt clean
```
- Make sure that your environment variables are set properly, including `JAVA_HOME`, `SPARK_HOME`, `HADOOP_HOME`
