package challenge295

case class Words (initialWord: String, finalWord: String)

object Challenge295 {
  def main(args: Array[String]): Unit = {
    val input = "floor\nbrake"
    val inputFormatted = inputFormat(input)
    println(replaceLetters(inputFormatted, 0))
  }

  def inputFormat(input: String): Words = {
    val inputSplit: List[String] = input.split("\n").toList
    Words(inputSplit.head, inputSplit.last)
  }

  def replaceLetters(word: Words, recurseNum: Int): String = {
    val changedChar = word.initialWord.updated(recurseNum, word.finalWord(recurseNum))
    if (changedChar == word.finalWord) {
      changedChar
    } else {
      val newWords = Words(changedChar, word.finalWord)
      println(changedChar)
      replaceLetters(newWords, (recurseNum + 1))
    }
  } 
}