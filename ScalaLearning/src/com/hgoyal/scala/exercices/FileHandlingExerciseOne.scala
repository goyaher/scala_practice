package com.hgoyal.scala.exercices

/**
 * 2. Read the file order_items in scala and store it as list. 
 * Now Get revenue for order id using loops. 
 * For each item subtotal can be computed by multiplying quantity (4th field) with price (6th field).
 */
object FileHandlingExerciseOne 
{
  def main(args: Array[String]): Unit = 
  {
		  //Read file and store as a list
		  val filePath = "G:\\Study\\Git_Repository\\scala_practice\\ScalaLearning\\resources\\input\\"
		  val orderItems = scala.io.Source.fromFile(filePath + "order_items").getLines.toList
		  //		  println(orderItems.size)
      println(getRevenueForOrder(orderItems, 17211))
      println(getRevenueForOrderUsingFilterFn(orderItems, 17211))
      
      printRevenueForAllOrders(orderItems)
  }
  
  def printRevenueForAllOrders(orderItems:List[String]): Unit =
  {
    val grouped = orderItems.map(o => (o.split(",")(1).toInt, o.split(",")(4).toFloat)) //will give a list of tuples
                  .groupBy(k => k._1) //will group by first field in the tuple (first field is accessed by _1)
                  .map(o => (o._1, o._2.map(t => t._2).sum))
                  .foreach(println)
  }
  
  
  def getRevenueForOrder(orderItems:List[String], orderId:Int): Float =
  {
    var revenue = 0.0f
    for (orderItem <- orderItems)
    {
      val splits = orderItem.split(",")
      if (splits(1).toInt == orderId)
      {
        revenue += splits(4).toFloat //value at index = 4 is already value at 3 * value at 5
      }
    }
    revenue
  }
  
  def getRevenueForOrderUsingFilterFn(orderItems:List[String], orderId:Int): Float =
  {
    val filterd = orderItems.filter(o => (o.split(",")(1).toInt == orderId))
		var revenue = 0.0f
    for (orderItem <- filterd)
    {
      val splits = orderItem.split(",")
      revenue += splits(4).toFloat //value at index = 4 is already value at 3 * value at 5
    }
    revenue
  }
}