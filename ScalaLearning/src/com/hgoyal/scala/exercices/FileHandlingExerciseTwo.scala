package com.hgoyal.scala.exercices

/**
 * 3. Read file orders in scala and get count of COMPLETE orders using loops.
 * Also get count of complete/closed orders that are placed in 2014 Feb.
 */
object FileHandlingExerciseTwo 
{
  def main(args: Array[String]): Unit = 
  {
		  //Read file and store as a list
		  val filePath = "G:\\Study\\Git_Repository\\scala_practice\\ScalaLearning\\resources\\input\\"
		  val orders = scala.io.Source.fromFile(filePath + "orders").getLines.toList
		  
		  println("Total Orders = " + orders.size)
		  
		  //complete orders
		  val completeOrders = orders.map(o => o.split("\\s+"))
		                              .filter(o => o.size == 5) // weed out bad records
		                              .filter(o => o(4) == "COMPLETE")
		                              .size
		                              
      println("Complete Order = " + completeOrders)
		  
		  val completeOrdersInFeb = orders.map(o => o.split("\\s+"))
		                              .filter(o => o.size == 5) // weed out bad records
		                              .filter(o => o(4) == "COMPLETE" && o(1).startsWith("2014-02"))
		                              .size
      println("Complete Orders In Feb 2014 = " + completeOrdersInFeb)
      
		  val closedOrdersInFeb = orders.map(o => o.split("\\s+"))
		                              .filter(o => o.size == 5) // weed out bad records
		                              .filter(o => o(4) == "CLOSED" && o(1).startsWith("2014-02"))
		                              .size
                            
      println("Closed Orders In Feb 2014 = " + closedOrdersInFeb)
  }
}