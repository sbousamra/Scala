object Dogs {
	def main(args: Array[String]) {
		val place: Int = 15
		val NumberOfDogs: Int = 100
	}

	def otherPlaces(place: Int, NumberOfDogs: Int) = {
		for (i <- 1 to NumberOfDogs) {
			if (place != i) {
				val OtherPlacesString = List(i).map(_.toString())
				println("You didn't place at any of these places: " + OtherPlacesString)
			}
		}
	}
	otherPlaces(15, 100)
}