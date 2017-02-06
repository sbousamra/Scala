package challenge289

object Challenge289 {
  def main(args: Array[String]) {
    val readFile: String = scala.io.Source.fromFile("C:\\Users\\Administrator\\Desktop\\Programming\\Scala\\src\\main\\resources\\PokemonData.txt").getLines.mkString("\n")
    println(formatInput(readFile))
  }

  def formatInput(input: String): List[List[String]] = {
    input.split("\n").toList.map (line => line.split(" ").toList.filter (x => x != ""))
  }

  def solve(data: List[List[String]]): Int = {
    val normalData = data(1)
    val fireData = data(2)
  }
}