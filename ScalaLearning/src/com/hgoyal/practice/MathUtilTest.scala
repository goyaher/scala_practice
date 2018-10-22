package com.hgoyal.practice

import com.hgoyal.practice.util.MathUtil

object MathUtilTest 
{
  def main(args: Array[String]): Unit = 
  {
    var maximum = MathUtil.max(args(0).toInt, args(1).toInt)
    println(maximum)
    
    var result = MathUtil.isEven(23)
    println(result)
    
    println(MathUtil.isEven(12))
  }
}