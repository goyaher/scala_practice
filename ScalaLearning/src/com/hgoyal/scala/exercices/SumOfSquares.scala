package com.hgoyal.scala.exercices

//Exercise 1->
//Find sum of squares of all even numbers for a list of numbers from 1 to 100. 
//Hint-Use filter then map and finally add them using reduce function.
object SumOfSquares 
{
  def main(args: Array[String]): Unit = 
  {
    println((1 to 100).toList.filter(_%2==0).map(i=>i*i).reduce(_+_))
    
    //break-up
  /*  var l = (1 to 100).toList;
    println(l)
    l = l.filter(_%2 == 0)
    println(l)
    l = l.map(i => i*i)
    println(l)
    val sum = l.reduce(_+_)
    println(sum)
  */
  }  
}