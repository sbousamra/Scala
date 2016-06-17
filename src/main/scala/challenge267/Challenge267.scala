import scala.collection.mutable.ListBuffer

object Dogs {
	def main(args: Array[String]) {
		println(otherPlaces(15, 100).mkString("[", ", ", "]"))
	}

	def otherPlaces(place: Int, NumberOfDogs: Int) = {
		val ListOfPlaces: ListBuffer[String] = ListBuffer()
		for (i <- 1 to NumberOfDogs) {
			if (place != i) {
				if (i % 10 == 1 && i != 11) {
					ListOfPlaces += i.toString + "st"
				}
				else if (i % 10 == 2 && i != 12) {
					ListOfPlaces += i.toString + "nd"
				}
				else if (i % 10 == 3 && i != 13) {
					ListOfPlaces += i.toString + "rd"
				}
				else {
					ListOfPlaces += i.toString + "th"
				}
			}
		}
		ListOfPlaces
	}
}