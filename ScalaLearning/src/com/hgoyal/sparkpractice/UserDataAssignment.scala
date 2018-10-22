package com.hgoyal.sparkpractice

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD

/**
 * EXERCISE 1: Load the data from file “attachment_userdata.txt” into HDFS.
 * EXERCISE 2: Return the RDD as a set of tuples.
 * EXERCISE 3: Find the number of unique professions in the data file.
 * EXERCISE 4: How many different users belong to unique profession.
 * EXERCISE 5: How many different users belong to unique zip code.
 * EXERCISE 6: Find how many users are male and female.
 */
object UserDataAssignment {
  def main(args: Array[String]): Unit = {

    //Used in windows to set hadoop binaries winutils.exe
    System.setProperty("hadoop.home.dir", "G:\\Softwares\\hadoop_home\\")

    val FILE_I_PATH = "G:\\Study\\Git_Repository\\scala_practice\\ScalaLearning\\resources\\input\\"

    val conf = new SparkConf().setAppName("UserDataAssignment").setMaster("local[1]") //since running on windows so set master = local, local[1] is used to specify no. of threads, used 1 as more than 1 gives a problem while writing files seems like a bug
    val sc = new SparkContext(conf)
    
    val fileContent = sc.textFile(FILE_I_PATH + "attachment_userdata.txt")
    println("Total Records = " + fileContent.count()) //should print 943
    
    //Ex 3
    val uniqueProfCount = noOfUniqueProfessions(fileContent)
    println(s"Unique Professions Count = $uniqueProfCount")
    
    //Ex 4 - users by profession
    println("Users By Profession = ")
    getUsersByX(fileContent, 3) //3 index = Profession
    
    //Ex 5 - users by zip code
    println("Users By Zip Code = ")
    getUsersByX(fileContent, 4) //4 index = zip code
  
    //Ex 6 - users by gender
    println("Users By Zip Code = ")
    getUsersByX(fileContent, 2) //2 index = gender
    
    sc.stop

  }
  
  def noOfUniqueProfessions(records:RDD[String]):Long =
  {
    records.map(record => record.split(",")(3))
           .distinct()
           .count()
  }
  
  def getUsersByX(records: RDD[String], fieldIndex:Int):Unit =
  {
    records.map(record => (record.split(",")(fieldIndex),record.split(",")(0)))
           .groupBy(r => r._1)
           .map(g => (g._1, g._2.size))
           .sortBy(_._2)
           .foreach(println)
           
           //OR
  }
}