package challenge144

object Challenge144 {
  def main(args: Array[String]): Unit = {
    val input: String = "4\nCarriageBolt 45\nEyebolt 50\nWasher 120\nRivet 10\nCarriageBolt 45\nEyebolt 45\nWasher 140\nRivet 10"
    val inputList: List[String] = input.split("\n").toList  
    val number: Int = inputList(0).toInt
    val alteredList: List[String] = inputList.tail
    val newList: List[(String, Int)] = alteredList.map{x => x.split(" ")}.map{x => (x.head, x.last.toInt)}
    val incorrectList: List[(String, Int)] = newList.slice(0, number)
    val correctList: List[(String, Int)] = newList.slice((number), (number * 2))
    val zippedList: List[((String, Int), (String, Int))] = correctList.zip(incorrectList)
    val corrector: List[(String, Int)] = zippedList.map{x => (x._1._1, x._1._2 - x._2._2)}
    val filteredCorrector: List[String] = corrector.filter{x => x._2 != 0}.map{x => x._1 + " " + x._2}
    val correctorString: String = filteredCorrector.mkString("\n")
    println(correctorString)
  }
}

/*Pseudocode
1. Take input string, split at "\n" and put into list called "inputList"
2. Make two lists called "incorrect" and "correct". Make first list by slicing input from 0 to N rows. Make second list by slicing input from N to (N * 2).
3. Compare both lists and compute the differences aswell as the sign (- or +). Put these differences into a list called "difference".
4. Convert "difference" to string with .mkString and print result.*/