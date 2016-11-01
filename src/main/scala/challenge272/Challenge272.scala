package challenge272

object Challenge272 {
  def main(args: Array[String]): Unit = {
    println(remainingPieces("LQTOONOEFFJZT"))
  }

  val bagOfPieces: Map[Char, Int] = Map('A' -> 9, 'B' -> 2, 'C' -> 2, 'D' -> 4, 'E' -> 12, 'F' -> 2, 'G' -> 3, 'H' -> 2, 'I' -> 9, 'J' -> 1, 'K' -> 1, 'L' -> 4, 'M' -> 2, 'N' -> 6, 'O' -> 8, 'P' -> 2, 'Q' -> 1, 'R' -> 6, 'S' -> 4, 'T' -> 6, 'U' -> 4, 'V' -> 2, 'W' -> 2, 'X' -> 1, 'Y' -> 2, 'Z' -> 1, '_' -> 2)

  def remainingPieces(pieces: String): String = {
    val lettersToList: List[String] = pieces.split("").toList
    val remainingPieces: Map[Char, Int] = bagOfPieces.map{case (x,y) => 
      (x, y - lettersToList.count(_ == x))
    }
    val remainingPiecesCheck: Unit = remainingPieces.map{case (x,y) => 
      if (y < 0) {
        println("Invalid input. More Q's have been taken from the bag than possible.")
      }
    }
    val alteredList: List[String] = remainingPieces.map{case (x,y) => 
      y + ": " + x + "\n"}.toList
    val formattedList: String = alteredList.mkString
/*    
    remainingPiecesCheck*/
    formattedList
  }
}