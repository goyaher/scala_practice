
/**
 * Equivalent to java bean with getter/setters. The beauty here is that
 * we don't need to write constructors and getter/setters.
 * 
 * no boiler plate code
 * free methods like hashcode, equals, tostring
 * can be created without the use of "new" keyword.
 * == in scala compares by calling "equals" method.
 * 
 */
case class CaseClassExample(name:String, age:Int, sex:String)

object CaseClassExample
{
  def main(args: Array[String]): Unit = {
    val male = new CaseClassExample("Hershit", 18, "M")
    val female = new CaseClassExample("Nitika", 18, "F")
    println(male==female) //should print false
    val maleClone = male.copy()
    println(male==maleClone) //true
    
    val maleNotClone = male.copy(age=19);
    println(male==maleNotClone); //false
  }
}