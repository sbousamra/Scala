package challenge140

object Challenge140 {
  def main(args: Array[String]): Unit = {
    val input: String = "0\nhello world\n\n1\nuser id\n\n2\nmap controller delegate manager"
    val inputList: List[String] = input.split("\n\n").toList
    val inputPairs: List[(String, Int)] = inputList.map{x => x.split("\n")}.map{x => (x.last, x.head.toInt)}
    val string: List[String] = inputPairs.map{x => x._1}
    println(notator(inputPairs))
  }

  def prepareInput(input: String, modify: String => String): List[String] = {
    modify(input).split(" ").toList
  }

  def camelCase(input: String): String  = {
    val splitted: List[String] = prepareInput(input, x => x.toLowerCase)
    val tailed: List[String] = splitted.tail.map{x => x.capitalize}
    val camelString: List[String] = splitted.head.toLowerCase :: tailed
    camelString.mkString("")
  }

  def snakeCase(input: String): String = {
    val splitted: List[String] = prepareInput(input, x => x.toLowerCase)
    val snakeString: String = splitted.mkString("_")
    snakeString
  }

  def capSnakeCase(input: String): String = {
    val splitted: List[String] = prepareInput(input, x => x.toUpperCase)
    val capSnakeString: String = splitted.mkString("_")
    capSnakeString
  }

  def notator(input: List[(String, Int)]): String = {
   val notator: List[String] = input.map{x => 
      if (x._2 == 0) {
        x._2.toString + "\n" + camelCase(x._1) + "\n"
      } else if (x._2 == 1) {
          x._2.toString + "\n" + snakeCase(x._1) + "\n"
      } else if (x._2 == 2) {
          x._2.toString + "\n" + capSnakeCase(x._1) + "\n"
      } else {
          x._2.toString + "\n" + x._1 + "\n"
      }
    }
    val notatorToString: String = notator.mkString("\n")
    notatorToString
  }
}