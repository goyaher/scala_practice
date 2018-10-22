package com.hgoyal.practice

import scala.collection.mutable.ArrayBuffer

object Collections 
{
  def main(args: Array[String]): Unit = 
  {
    //Array - mutable, fixed size
    var firstTenNumbers = new Array[Int](10); //an array containing Int of size=10
    for (i <- 0 to 9)
    {
      firstTenNumbers(i)=i+1
    }
    println(firstTenNumbers.toList)
    firstTenNumbers(9) +=1
    println(firstTenNumbers.toList)
    
    
    //ArrayBuffer - Same as Array, but dynamic size
    var numbers = ArrayBuffer[Int](); //an array containing Int of initial size=10
    println(numbers.toList)
    numbers += 20 //add 20 to the numbers arraybuffer
    numbers += 21
    println(numbers.toList)
    
    
    //List - lists are immutable
    val colors:List[String] = List("blue", "green", "yellow"); //lists are immutable.
    println(colors)
    println(colors.head) // will print blue
    println(colors.tail) // will print a list with green & yellow
    println(colors.isEmpty)
    
    //higher order methods - map, flatMap, filter, reduce, foreach
    var newList = colors.map((s:String) => s.split("")) //will produce a list of arrays
    println(newList)
    var newList1 = colors.flatMap(s => s.split(""))
    println(newList1)
    
    var list = (1 to 100).toList
    var evenNumbers = list.filter(i=> (i%2==0)) //or list.filter(_%2==0)
    println(evenNumbers)
    
    
    var list1 = List(2, 4, 6, 8)
    var sum = list1.reduce((x,y) => x+y) // will sum all numbers in the list1
    var max = list1.reduce((x,y) => if (x>y) x else y)
    println(sum)
    println(max)
    
    list1.foreach(print(_))
    
    //Map - default is immutable, for using an immutable map use scala.collection.mutable.Map
    var aMap = Map[Int, String]() //empty map
    var numbersMap = Map[Int, String](1->"One", 2->"Two", 3 -> "Three")
    println(numbersMap);
    println(aMap)
  }
}