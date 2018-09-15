object FunctionalProgramming
{
  def main(args: Array[String]): Unit = {
    
    print(sum(id, 1, 10))
    
    def sum(func:Int => Int, st:Int, end:Int)
    {  
      var total = 0
      for (index <- st to end)
      {
        total += (index)
      }
      total
    }
  
    def cube(i:Int) = i*i*i;
    def square(i:Int) = i*i;
    def id(i:Int) = i;
    
    
  }
  
}
