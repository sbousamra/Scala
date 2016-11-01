package projecteuler

object Problem14 {
  def main(args: Array[String]) {
    val numbers = Range(1, 1000000)
    val findLargestCollatzLength = numbers.map ( x => (x, collatzSeq(x))).maxBy(x => x._2)
    println(findLargestCollatzLength)
  }

  def collatzSeq(startingNumber: Long) = {
    def recurse(currentNumber: Long, count: Int): Int = {
      if (currentNumber == 1) {
        count
      } else if (currentNumber % 2 == 0) {
        val newNumber = (currentNumber/2)
        recurse(newNumber, (count + 1))
      } else {
        val newNumber = ((3 * currentNumber) + 1)
        recurse(newNumber, (count + 1))
      }
    }
    recurse(startingNumber, 1)
  }
}

/*Make 2 functions, one for even integers, one for odd
Create list of integers from 13 to 1,000,000
For each integer in this list, fold, performing odd function if number is odd, even function if number is even, until number equals one
A list of each step in the fold should be appended to a newlist for each int (List[List[Int]])
Filter this List[List[Int]] by max length, and return the head of the list, since this is the starting value, thus giving us the result*/

