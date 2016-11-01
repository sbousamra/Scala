package challenge279intermediate

object Challenge279int {
  def main(args: Array[String]) {
    val input: String = "In the beginning God created the heavens and the earth. Now the earth was\nformless and empty, darkness was over the surface of the deep, and the Spirit of\nGod was hovering over the waters.\n\nAnd God said, Let there be light, and there was light. God saw that the light\nwas good, and he separated the light from the darkness. God called the light\nday, and the darkness he called night. And there was evening, and there was\nmorning - the first day."
    val result: List[List[String]] = widthChanger(input, 40)
    println(formatter(result))
  }

  def widthChanger(input: String, wrapLength: Int): List[List[String]] = {
    val inputSplit: List[String] = input.replaceAll("\n", " ").split(" ").toList
    val inputFold = inputSplit.foldLeft(List.empty[List[String]]) { case (b, word) =>
      b match {
        case Nil => List(List(word))
        case prevLines :+ currentLine => {
          if ((currentLine :+ word).mkString(" ").length > wrapLength)
            prevLines :+ currentLine :+ List(word)
          else
            prevLines :+ (currentLine :+ word)
        }
      }
    }
    inputFold
  }

  def formatter(input: List[List[String]]): String = {
    val formattedInput = input.map { x => x.mkString(" ")}.mkString("\n")
    formattedInput
  }
}