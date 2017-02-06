package challenge293

case class Wire(color: String)

object Challenge293 {
  def main(args: Array[String]): Unit = {
    val input: String = "white\nred\ngreen\nwhite"
    val formattedInput: List[Wire] = formatInput(input)
    val solvedInput: String = solveWireInput(formattedInput)
    println(solvedInput)
  }

  def formatInput(input: String): List[Wire] = {
    val inputSplitIntoLines: List[String] = input.split("\n").toList
    inputSplitIntoLines.map (line => Wire(line))
  }

  def solve(wire: Wire): List[Wire] = {
    if (wire.color == "white") {
      List(Wire("red"), Wire("orange"), Wire("green"), Wire("purple"))
    } else if (wire.color == "red") {
      List(Wire("green"))
    } else if (wire.color == "black") {
      List(Wire("red"), Wire("black"), Wire("purple"))
    } else if (wire.color == "orange") {
      List(Wire("red"), Wire("black"))
    } else if (wire.color == "green") {
      List(Wire("orange"), Wire("white"))
    } else if (wire.color == "purple") {
      List(Wire("red"), Wire("black"))
    } else {
      List(Wire("Wire does not exist"))
    }
  }

  def solveWireInput(input: List[Wire]): String = {
    val firstWire = Some(input.head)
    val res: Option[Wire] = input.tail.foldLeft[Option[Wire]](firstWire) { case (curr: Option[Wire], next: Wire) => 
      curr.filter(wire => solve(wire).contains(next)).map (_ => next)
    }
    if (res.isDefined) {
      "Bomb Defused"
    } else {
      "BOOM"
    }
  }
}