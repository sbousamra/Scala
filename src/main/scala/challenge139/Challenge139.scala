package challenge139

object Challenge139 {
  def main(args: Array[String]): Unit = {    
    val input: String = """3
      |The quick brown fox jumps over the lazy dog.
      |Pack my box with five dozen liquor jugs
      |Saxophones quickly blew over my jazzy hair"""
   
    val lines: List[String] = input.stripMargin.toLowerCase.split("\n").toList.tail
    val pangrams: List[Boolean] = lines.map{x => pangramChecker(x)}
    println(pangrams.mkString("\n"))

  }
  def pangramChecker(input: String): Boolean = {
    val alphabetList: List[Char] = ('a' to 'z').toList
    val chars: List[String] = input.split("").toList.filter(x => x != "." && x != " ")
    val checker: List[Boolean] = alphabetList.map{x => chars.contains(x.toString)}
    val checkertwo: Boolean = checker.contains(false)
    checkertwo
  }
}

/*Pseudocode

1. Take input of number of lines and each string. Remove spaces and period from strings. Split string by "" and put into list called inputList.
2. Make list of alphabet, numbers
3. Make function that returns true if inputList contains all elements of list of alphabet. Do this by mapping each element of alphabet with the .contain function on inputList. Else return false*/