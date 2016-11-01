package projecteuler

object Problem12 {
  def main(args: Array[String]) {
    val result = triangleNumbers(5000)
    println(result)
  }

  def triangleNumbers(limit: Int): List[Int] = {
    val range = Range(1, limit)
    val triangleNumbers = range.foldLeft[List[Int]](List(0)){ (acc, e) =>
      acc :+ (e + acc.last)
    }
    val filteredNumbers = triangleNumbers.map { x =>
      factors(x)}.filter { y =>
      y.length == 500
    }.flatten
    filteredNumbers
  }

  def factors(number: Int): List[Int] = {
    val potentialFactors = Range(1, number).toList
    val filteredList = potentialFactors.filter ( x => (number % x) == 0)
    filteredList
  }
}
