package com.hgoyal.practice.util

/**
 * Utility scala class containing math functions.
 */
object MathUtil 
{
  def max(n1:Int, n2:Int):Int =
  {
    if (n1>n2) n1 else n2
  } 
  
  def isEven(n:Int):Boolean =
  {
    n%2==0
  }
}