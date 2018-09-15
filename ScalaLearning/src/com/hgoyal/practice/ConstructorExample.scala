package com.hgoyal.practice

/**
 * Constructors in scala are created using a this keyword.
 * 
 * If there is no specific constructor, a PRIMARY constructor or default constructor initializes the fields.
 * There can be 1 or more AUXILIARY constructors which can call other constructors by using this)...
 * 
 */
class ConstructorExample (name:String, age:Int) { //default is val, if its a mutating object, we can change to var)
  def print()
  {
    println(name + " " + age);
  }
  
  def this(name: String)
  {
    this(name, 0);
  }
}

object ConstructorExample
{
  def main(args: Array[String]): Unit = {
    var ce = new ConstructorExample("Hershit", 35)
    ce.print();
    
    var ce1 = new ConstructorExample("Hershit")
    ce1.print();
  }
}

