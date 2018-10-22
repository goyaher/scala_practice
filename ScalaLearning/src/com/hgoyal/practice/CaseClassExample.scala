
package com.hgoyal.practice
/**
 * Equivalent to java bean with getter/setters. The beauty here is that
 * we don't need to write constructors and getter/setters.
 * 
 * no boiler plate code like getter/setters or using 'new' keyword to instantiate an object
 * free methods like hashcode, equals, tostring
 * can be created without the use of "new" keyword.
 * == in scala compares by calling "equals" method.
 * Useful for creating DTOs to pass arounds
 * 
 */
case class CaseClassExample(name:String, age:Int, sex:String)

object CaseClassExample
{
  def main(args: Array[String]): Unit = {
    val male = CaseClassExample("Hershit", 18, "M") //'new' not needed
    val female = new CaseClassExample("Nitika", 18, "F")
    println(male==female) //should print false
    val maleClone = male.copy() // will do a deep copy field by field
    println(male==maleClone) //true
    
    val maleNotClone = male.copy(age=19); //doing a copy but overriding age property.
    println(male==maleNotClone); //false
  }
}