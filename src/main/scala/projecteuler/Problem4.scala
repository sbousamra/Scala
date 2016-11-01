package projecteuler

object Problem4 {
  def main(args: Array[String]) {
    val first = Range(100, 1000)
    val second = Range(100, 1000)
    val numbers = first.flatMap { x => second.map { y =>
      x * y
      }
    }.toList.sorted
    println(maxPalindrome(numbers))
  }

  def maxPalindrome(numbers: List[Int]): List[Int] = {
    val possiblePalindromes = numbers.filter(x => checkIfPalindrome(x))
    val reverseList = possiblePalindromes.reverse
    reverseList
  }

  def checkIfPalindrome(number: Int): Boolean = {
    number.toString == number.toString.reverse
  }
}
