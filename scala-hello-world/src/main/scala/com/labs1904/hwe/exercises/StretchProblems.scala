package com.labs1904.hwe.exercises

import scala.collection.mutable.ListBuffer
import scala.util.control.Breaks.{break, breakable}

object StretchProblems {

  /*
  Checks if a string is palindrome.
 */
  def isPalindrome(s: String): Boolean = s == s.reverse

  /*
For a given number, return the next largest number that can be created by rearranging that number's digits.
If no larger number can be created, return -1
 */
  def getNextBiggestNumber(i: Integer): Int = {
    //TODO: Implement me!
    var intCopy = i
    var ints = new ListBuffer[Int]()
    while(intCopy > 0) {
      ints.append(i % 10)
      intCopy = intCopy / 10
    }
    val lB = swapElements(ints)
    val s = new StringBuilder
    lB.map(n => s.append(n))
    s.toInt

  }

  def swapElements(e: ListBuffer[Int]): ListBuffer[Int] = {
    e.grouped(1).flatMap{
      case ListBuffer(x, y) => ListBuffer(y, x)
    }.toArray.to[ListBuffer]
  }
}
