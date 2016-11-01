package challenge277

object Challenge277 {
  def main(args: Array[String]): Unit = {
    val input ="4 8\n1536 78360\n51478 5536\n46410 119340\n7673 4729\n4096 1024"
    val inputSplitLines = input.split("\n").toList
    val inputSplitSpaces = inputSplitLines.map { x => x.split(" ").toList}
    val inputTuples = inputSplitSpaces.map { x => (x.head, x.last)}
    val reducedFractions = inputTuples.map { x => reduceFraction(x._1.toInt, x._2.toInt)}
    println(reducedFractions)
  } 
  def cd(numerator: Int, denominator: Int): Int = {
    if (denominator == 0)
      numerator
    else
      cd(denominator, numerator % denominator)
  }

  def reduceFraction(numerator: Int, denominator: Int): (Int, Int) = {
    val comd = cd(numerator, denominator)

    ((numerator/comd), (denominator/comd))  
  }

}