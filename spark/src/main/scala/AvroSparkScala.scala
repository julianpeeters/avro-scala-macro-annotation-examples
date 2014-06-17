//Adapted from: https://github.com/jcrobak/avro-examples/blob/master/avro-spark/src/main/scala/AvroSparkScala.scala

package com.miguno.avro

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.avro.mapred.AvroKey
import org.apache.avro.mapreduce.AvroJob
import org.apache.avro.mapreduce.AvroKeyInputFormat
import org.apache.hadoop.io.NullWritable
import org.apache.hadoop.mapreduce.Job
import org.apache.hadoop.conf.Configuration
import org.apache.commons.lang.StringEscapeUtils.escapeCsv
import com.julianpeeters.avro.annotations._

//@AvroRecord
//case class twitter_schema(var username: String, var tweet: String, var timestamp: Long)

//TODO after Avro 1.7.7 is released `pos` becomes non-transient and saveAsNewAPIHadoopDataset arrives:
//object AvroSpecificWriteJob {} 

@AvroTypeProvider("twitter.avro")
@AvroRecord
case class twitter_schema()

object AvroSpecificReadJob {
  def main(args: Array[String]) {
    val sc = new SparkContext("local", "Avro Specific Spark Scala")

    // A Schema must be specified (avro.mapreduce tries to make one reflectively but fails since Scala fields are private)
    val c = new Configuration()
    val job = new Job(c)
    val conf = job.getConfiguration
    AvroJob.setInputKeySchema(job, twitter_schema().getSchema)

    val avroRdd = sc.newAPIHadoopFile("twitter.avro",
                      classOf[AvroKeyInputFormat[twitter_schema]],
                      classOf[AvroKey[twitter_schema]],
                      classOf[NullWritable],
                      conf)

    val specificRecords = avroRdd.map{case (ak, _) => ak.datum()}

    val wordCounts = specificRecords.map((sr: twitter_schema) => sr.get(1).asInstanceOf[String])
      .flatMap{tweet: String => tweet.split(" ")}
      .map(word => (word, 1))
      .reduceByKey((a, b) => a + b)

    val wordCountsFormatted = wordCounts.map{case (word, count) => (escapeCsv(word), count)}
      .map{case (word, count) => s"$word,$count"}

    wordCountsFormatted.saveAsTextFile("output/twitter-wordcount-scala-spark-specific.tsv")
  }
}

