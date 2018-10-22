package com.hgoyal.sparkpractice

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object WikipediaAssignment {

  def main(args: Array[String]): Unit = {
    //Used in windows to set hadoop binaries
    System.setProperty("hadoop.home.dir", "G:\\Softwares\\hadoop_home\\")

    val FILE_I_PATH = "G:\\Study\\Git_Repository\\scala_practice\\ScalaLearning\\resources\\input\\"
    val FILE_O_PATH = "G:\\Study\\Git_Repository\\scala_practice\\ScalaLearning\\resources\\output\\"

    val conf = new SparkConf().setAppName("WikipediaAssignment").setMaster("local[1]") //since running on windows so set master = local, local[1] is used to specify no. of threads, used 1 as more than 1 gives a problem while writing files seems like a bug 
    val sc = new SparkContext(conf)

    val filecontent = sc.textFile(FILE_I_PATH + "wikipedia.dat")
    println("FileSize = " + filecontent.count())

    //Exercise 1
    val words = filecontent.flatMap(l => l.split(" "))
    val wordCount = words.map(w => (w, 1)).reduceByKey(_ + _)
    wordCount.saveAsTextFile(FILE_O_PATH + "wikipedia_wordcount")

    //Exercise 2
    val javaWordCount = wordCount.filter(t => (t._1.toUpperCase == "JAVA"))
    println("Java word count = " + javaWordCount.count())
    javaWordCount.foreach(println)
    javaWordCount.saveAsTextFile(FILE_O_PATH + "wikipedia_java_count")

    //Exercise 3
    val scalaFirst10Lines = filecontent.filter(l => l.contains("scala")).take(10)
    sc.parallelize(scalaFirst10Lines).saveAsTextFile(FILE_O_PATH + "wikipedia_scala10lines")

    sc.stop

  }
}