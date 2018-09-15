package com.hgoyal.scala.exercices

import scala.collection.mutable.Map;

//1. Write a function to count number of occurrences of a word in a text String. 
//   The output should be in the form of Map(e.g cat->2 mat->3)
object WordCount 
{
  def main(args: Array[String]): Unit = 
  {
    val input = "Write a function to count number of occurrences of a word in a text String." + 
                "The output should be in the form of Map"
    
    val words = input.split(" ").toList
    
    var wordCounts = Map[String, Int](); //using a mutable map as by default scala map is immutable.
    for (word <- words)
    {
      var count = 1;
      if (wordCounts.contains(word))
      {
        count += wordCounts(word);
      }
      wordCounts.put(word, count)
    }
    
    print(wordCounts)
  }  
}