package challenge212

object Challenge212 {
	def main(args: Array[String]): Unit = {
		println(codeTranslator("Jag talar Rövarspråket!"))
	}

	def codeTranslator(inputText: String): String = {
		val inputToList: List[String] = inputText.split("").toList
		val translatedList: List[String] = inputToList.map{a => 
			if (isConsonant(a)) {
	 		a + "o" + a.toLowerCase
		 	} else {
		 		a
		 	}
		}
		val newString: String = translatedList.mkString
		newString
	}

	def isConsonant(character: String): Boolean = {
		val Consonants: List[String] = List("B", "C", "D", "F", "G", "H", "J", "K", "L", "M", "N", "P", "Q", "R", "S", "T", "V", "W", "X", "Z")
		(Consonants.contains(character.toUpperCase))
	}
}