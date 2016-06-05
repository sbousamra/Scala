object Day1 {

	def main(args: Array[String]) = {
		val listOfNumbers = List(1, 2, 3, 4)
		val listOfStrings = listOfNumbers.map(_.toString())
		println(listOfStrings)
	}
}