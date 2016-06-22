package challenge239

object Challenge239 {
	def main(args: Array[String]): Unit = {
		val result: List[(Int, Int)] = gameOfThrees(100, List())
		val printresult: List[String] = result.map(format)
		printresult.foreach(println)
	}

	def gameOfThrees(number: Int, steps: List[(Int, Int)]): List[(Int, Int)] = {
		if (number == 1) {
			val newSteps = steps :+ (number, 0)
			newSteps
		}	else if(number % 3 == 0) {
			val newSteps = steps :+ (number, 0)
			val newnumber = (number/3)
			gameOfThrees(newnumber, newSteps)
		} else if (number % 3 == 1) {
			val newSteps = steps :+ (number, -1)
			val newnumber = ((number - 1)/3)
			gameOfThrees(newnumber, newSteps)
		}	else {
			val newSteps = steps :+ (number, +1)
			val newnumber = ((number + 1)/3)
			gameOfThrees(newnumber, newSteps)

		}
	}
	def format(a: (Int, Int)): String = {
		a._1.toString + " " + a._2.toString

	}
}