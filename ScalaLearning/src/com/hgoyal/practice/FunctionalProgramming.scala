package com.hgoyal.practice

object FunctionalProgramming
{
  def main(args: Array[String]): Unit = {
    
    println(sum(id, 1, 10)) // sum of numbers from 1 to 10
    println(sum(square, 1, 10)) // sum of squares of nos from 1 to 10
    println(sum(cube, 1, 10)) // sum of cubes of nos from 1 to 10
    
    def sum(func:Int => Int, st:Int, end:Int):Int =
    {  
      var total = 0
      for (index <- st to end)
      {
        total += func(index)
      }
      total
    }
  }
  
  def cube(i:Int) = i*i*i;
  def square(i:Int) = i*i;
  def id(i:Int) = i;
  
}
