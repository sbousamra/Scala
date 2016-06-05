object chapter1 {
	def main(args: Array[String]): Unit = {    
		alien.greet(person)
	}

	object Oswald {
		val Colour: String = "Black"
		val Food: String = "Milk"
	}

	object Henderson {
		val Colour: String = "Ginger"
		val Food: String = "Chips"
	}

	object Quentin {
		val Colour: String = "Tabby and white"
		val Food: String = "Curry"
	}

	object calc {
		def square(input: Double) = input * input
		def cube(input: Double) = input * square(input)
	}

	object calc2 {
		def square(input: Double) = input * input
		def cube(input: Double) = input * square(input)

		def square(input: Int) = input * input
		def cube(input: Int) = input * square(input)
	}

	object person {
		val firstName: String = "Sebastian"
		val lastName: String = "Bou-Samra"
	}

	object alien {
		def greet(inputPerson: person.type) = "Greetings " + inputPerson.firstName + " " + inputPerson.lastName
	}
}