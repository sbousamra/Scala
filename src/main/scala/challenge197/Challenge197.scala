package challenge197

object Challenge197 {
	def main(args: Array[String]): Unit = {
		println(isbn_Validator("0747532699"))
	}

	def isbn_Validator(number: String): Boolean = {
		val listNumber: List[Int] = number.split("").toList.map(_.toInt)
		val zippedList: List[(Int, Int)] = listNumber.zipWithIndex
		val newList: List[Int] = zippedList.map { case (a, index) => a * (10 - index)}
		val sumNumbers: Int = newList.sum
		val trueOrFalse = (sumNumbers % 11 == 0)
		trueOrFalse
	}
}