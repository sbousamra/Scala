package projecteuler

object Problem1 {
  def main(args: Array[String]) {
    val multipleOfThreeAndFive = (n: Int) => multipleChecker(n, 3) || multipleChecker(n, 5)
    val result = Range(0, 1000)
      .filter(multipleOfThreeAndFive)
      .foldLeft(0)(_ + _)
    println(result)
  }

  def multipleChecker(number: Int, multiple: Int): Boolean = {
    number % multiple == 0
  }

}
