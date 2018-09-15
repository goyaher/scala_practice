package com.hgoyal.sparkpractice

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object Wordcount 
{
  def main(args: Array[String]) 
  {
    System.setProperty("hadoop.home.dir", "G:\\Softwares\\hadoop_home\\")

    //Create conf object
    val conf = new SparkConf().setAppName("WordCount").setMaster("local")

    //create spark context object
    val sc = new SparkContext(conf)

    //Check whether sufficient params are supplied
    if (args.length < 2) 
    {
      println("Usage: WordCount <input> <output>")
      System.exit(1)
    }
    
    //Read file and create RDD
    val rawData = sc.textFile(args(0))

    //convert the lines into words using flatMap operation
    val words = rawData.flatMap(line => line.split(" "))

    //count the individual words using map and reduceByKey operation
    val wordCount = words.map(word => (word, 1)).reduceByKey(_ + _)

    //Save the result
    wordCount.saveAsTextFile(args(1))

    //stop the spark context
    sc.stop
  }
}