package challenge276

object Challenge276 {
  def main(args: Array[String]): Unit = {
    val string = "DOMINICBOU-SAMRABLAHBLAHTESTESTTTER"
    val stringLength = string.length
    val width = 2
    val height = 2
    val stringList = firstLine(string) + "\n" + middleLines(string).mkString + lastLine(string)
    println(stringList)
  }

  def firstLine(string: String): String = {
    string
  }

  def middleLines(string: String): List[String] = {
    val stringLength = string.length
    val zippedString = string.slice(1, (stringLength - 1)).zipWithIndex
    val mappedString = zippedString.map {x => 
      x._1 + (" " * (stringLength - 2)) + zippedString(stringLength - x._2 - 3)._1 + "\n"
    }.toList
    mappedString
  }

  def lastLine(string: String): String = {
    string.reverse
  }

  
}