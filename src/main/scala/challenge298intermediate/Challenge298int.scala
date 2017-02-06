object Challenge298int {
  def main(args: Array[String]): Unit = {
    val input: String  = ")(asdf)))\n((((asdf)))\n((((asdf))\n(ab)((cd)(asdf)))\n(ab)((cd)(asdf)())\n(ab)(((cd)(asdf)\n(ab)(((cd)(asdf\n(ab)(((cd)(asdf)))))"
    val formattedInput = formatInput(input)
    val solved = solve(formattedInput)
    println(solved)
  }

  def formatInput(input: String): Array[Array[(String, Int)]] = {
    var stack = List.empty
    val splitInputIntoLines = input.split("\n")
    splitInputIntoLines.map(line => line.split(("")).zipWithIndex)
  }

  def solve(input: Array[Array[(String, Int)]]) = {
    println(input.toList.map (x => x.toList))
    var stack = scala.collection.mutable.ListBuffer.empty[Int]
    val pairPar: Unit = input.foreach (line => line.foreach {character => 
      if (character._1 == "(") {
        stack += character._2
      } else if (character._1 == ")") {
        if (stack.length == 0) {
          println(character._2)
        } else {
          stack.dropRight(1)
        }
      }
    }
    )
    pairPar
  }
}