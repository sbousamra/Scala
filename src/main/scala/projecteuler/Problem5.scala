package projecteuler

object Problem5 {
  def main(args: Array[String]) {
    val multiples = Range(2, 21).toList
    println(multiples)
    val possibleNumbers = Stream.from(20, 20)
    val filteredNumbers = possibleNumbers.find { x => smallestMultiple(x, multiples)}.min
    println(filteredNumbers)
  }

  def smallestMultiple(number: Int, multiples: List[Int]): Boolean = {
    multiples.forall ( x => (number % x == 0))
    }
  }
