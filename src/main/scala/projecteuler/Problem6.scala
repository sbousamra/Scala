package projecteuler

object Problem6 {
  def main(args: Array[String]) {
    val numbers = Range(1, 101).toList
    val sumOfSquares = numbers.foldLeft(0)((acc, e) => acc + math.pow(e, 2).toInt)
    val squareOfSum = math.pow(numbers.foldLeft(0)((acc, e) => acc + e), 2).toInt
    val difference = squareOfSum - sumOfSquares
    println(difference)
  }
}
