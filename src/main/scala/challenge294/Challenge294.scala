object Challenge294 {
  def main(args: Array[String]): Unit = {
    val input = "ladilmy,daily\neerriin,eerie\norrpgma,program\norppgma,program"
    val formattedInput = parseLines(input)
    val solvedInput = formattedInput.map (_.solve)
    println(solvedInput)
  }

  def parseScrabbleMove(line: String): ScrabbleMove = {
    val splitLineOnComma = line.split(",")
    ScrabbleMove(splitLineOnComma(0), splitLineOnComma(1))
  }

  def parseLines(input: String): List[ScrabbleMove] = {
    input.split("\n").map (line => parseScrabbleMove(line)).toList
  }
}

case class ScrabbleMove(tiles: String, word: String) {

  def solve: Boolean = {
    val checkIfWordContainsLetters: String = word.diff(tiles)
    if (tiles.length >= word.length) {
      if (checkIfWordContainsLetters.length == 0) {
        true
      } else {
        false
      }
    } else {
      false
    }
  }
}
