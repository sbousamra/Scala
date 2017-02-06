package challenge290

case class Numbers(start: Int, finish: Int)

object Challenge290 {
  def main(args: Array[String]): Unit = {
    val input = "101\n9000"
    val formattedInput = inputFormat(input)
    val solved = solve(formattedInput)
    println(solved.mkString(" "))
  }

  def inputFormat(input: String): Numbers = {
    val inputSplit = input.split("\n").toList.map (x => x.toInt)
    Numbers(inputSplit.head, inputSplit.last)
  }
  
  def solve(numbers: Numbers): List[Int] = {
    val range = Range(numbers.start, numbers.finish + 1)
    val squared = range.map ( x => x * x).filter(y => y > 10)
    val toStr = squared.map ( x => x.toString)
    val split = toStr.map ( x => x.splitAt(x.length/2))
    val splitToInt = split.map ( x => List(x._1, x._2).map (y => y.toInt))
    val sumList = splitToInt.map ( x => x.sum).zipWithIndex
    val rangeWithIndex = range.filter( x => (x * x) > 10).zipWithIndex
    val compare = rangeWithIndex.filter ( x => sumList.contains(x))
    val result = compare.toList.map (x => x._1)
    result
  }
}