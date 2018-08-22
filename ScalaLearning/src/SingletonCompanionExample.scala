/**
 * In this example, we created a class SingletonCompanionExample and a companion
 * (static) class. The static class has a variable which stores count of instances
 * of the original class and a method to print the count.
 */
class SingletonCompanionExample {
  SingletonCompanionExample.instanceCount += 1
}

object SingletonCompanionExample 
{
  var instanceCount:Int = 0
  def printInstanceCount(): Unit =
  {
    println(instanceCount);
  }
}

object Main
{
  def main(args: Array[String]): Unit = 
  {
    for (i <- 1 to 10)
    {
       new SingletonCompanionExample()
    }
    SingletonCompanionExample.printInstanceCount()
  }
}

