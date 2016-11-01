package projecteuler

import java.math.BigInteger

object Problem2 {
  def main(args: Array[String]) {
    val highestNumber = 33
    val result = fibonacciGenerator(highestNumber)
    val resultTwo = result.filter(number => number < 4000000L)
    val resultThree = resultTwo.filter(number => (number % 2L) == 0L)
    val resultFour = resultThree.foldLeft(0L)((acc, e) => acc + e)
    println(resultFour)
  }

  def fibonacciGenerator(limit: Int): List[Long] = {
    def gen(list: List[Long], number: Int): List[Long] = {
      println(list.zipWithIndex.mkString)
      if(number >= limit || number < 2)
        list
      else {
        val tail = list(number - 2)
        val head = list(number - 1)
        val newList = list ::: List(tail + head)
        gen(newList, number + 1)
      }
    }
    gen(List(1L, 2L, 3L), 3).take(limit)
  }


}
