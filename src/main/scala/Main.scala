import org.apache.spark.sql.Row.empty.schema
import org.apache.spark.sql.{DataFrame, SparkSession}

object Main {
  val myTopic = "my-topic"
  val spark = SparkSession
    .builder()
    .appName("Spark App")
    .getOrCreate()

  val records: DataFrame = spark
    .readStream
    .format("kafka")
    .option("kafka.bootstrap.servers", ":9092")
    .option("subscribe", myTopic)
    .load()

  import org.apache.spark.sql.functions.{col,from_json}

  // parse json
  import org.apache.spark.sql.functions.{col,from_json}
  val dfJSON = records.withColumn("jsonData",from_json(col("value"),schema))
    .select("jsonData.*")
  dfJSON.printSchema()
  dfJSON.show(false)

  // write in json format
  val query = dfJSON
    .writeStream
    .format("console")
    .option("truncate", false)
    .start()

    query.awaitTermination()
}