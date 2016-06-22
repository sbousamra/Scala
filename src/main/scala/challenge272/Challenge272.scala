package challenge272

object Challenge272 {
	def main(args: Array[String]): Unit = {
		println(remainingPieces("LQTOONOEFFJZT"))
	}

	val bagOfPieces: Map[Char, Int] = Map('A' -> 9, 'B' -> 2, 'C' -> 2, 'D' -> 4, 'E' -> 12, 'F' -> 2, 'G' -> 3, 'H' -> 2, 'I' -> 9, 'J' -> 1, 'K' -> 1, 'L' -> 4, 'M' -> 2, 'N' -> 6, 'O' -> 8, 'P' -> 2, 'Q' -> 1, 'R' -> 6, 'S' -> 4, 'T' -> 6, 'U' -> 4, 'V' -> 2, 'W' -> 2, 'X' -> 1, 'Y' -> 2, 'Z' -> 1, '_' -> 2)

	def remainingPieces(pieces: String): String = {
		val lettersToList: List[String] = pieces.split("").toList
		val remainingPieces: Map[Char, Int] = bagOfPieces.map{case (x,y) =>
			if (y < 0) {
			println("Invalid input. More Q's have been taken from the bag than possible.")
			} else if (inBagOfPieces(x, lettersToList)) {
				(x, (y - 1))
			} else {
				(x, y)
			}
		}
		val formattedList: Map[Char, Int] = remainingPieces.map{case (x,y) => y + ": " + x + "\n"}
		val remainingPiecesString: String = formattedList.mkString
		remainingPiecesString
	}

	def inBagOfPieces(letter: Char, lettersToList: List[String]): Boolean = {
		lettersToList.contains(letter.toUpper)
	}
}








/*
Pseudocode
	1. Create Map[String, Int] of scrabble pieces, bagOfPieces.
	2. Take in input, compare to bagOfPieces (.contains), then create newList that has removed pieces
	3. Convert newList to ascending order, and map newList to add count: Int + ":" + "\n"
	4. Add if statement that says if input > pieces in bagOfPieces, return error*/