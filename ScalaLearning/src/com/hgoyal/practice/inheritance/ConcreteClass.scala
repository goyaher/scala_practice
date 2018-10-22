package com.hgoyal.practice.inheritance

/**
 * This class extends abstract class created in a separate file.
 */
class ConcreteClass extends InheritanceExample
{
  def print()
  {
    println("inConcreteClass");
  }
  
  def run()
  {
    println("run..")
  }
}

object InheritanceExample1
{
  def main(args: Array[String]): Unit = {
    val obj = new ConcreteClass();
    obj.print();
  }
}