package com.hgoyal.scala.exercices

object FindMin 
{
  def main(args: Array[String]): Unit = 
  {
    val minimum = (1 to 10).toList.reduce((x,y) => if (x<y) x else y)
    println(minimum)
    
    // OR
    
    val min = (1 to 10).toList.reduce(_.min(_))
    println(min)

    // OR
    
    val mini = (1 to 10).toList.reduce((x, y) => Math.min(x,y))
    println(mini)
    
  }  
}