package challenge170

object Challenge170 {
  def main(args: Array[String]): Unit = {
    val input: String = "3\nAlice: Ace of Diamonds, Ten of Clubs\nBob: Three of Hearts, Six of Spades, Seven of Spades\nChris: Ten of Hearts, Three of Diamonds, Jack of Clubs\nBass: Ace of Diamonds, Jack of Clubs"
    val inputList: List[String] = input.split("\n").tail.toList
    println(output(inputList))
  }

  def counter(input: String): (String, Int) = {
    val cards: List[(String, Int)]  = List(("One", 1), ("Two", 2), ("Three", 3), ("Four", 4), ("Five", 5), ("Six", 6), ("Seven", 7), ("Eight", 8), ("Nine", 9), ("Ten", 10), ("Jack", 10), ("Queen", 10), ("King", 10), ("Ace", 11))
    val inputSplit: List[String] = input.split(" ").toList
    val inputFilter: List[String] = inputSplit.map{x => x.replaceAll(",", "")}.map{x => x.replaceAll(":", "")}
    val filter: List[(String, Int)] = cards.filter{x => inputFilter.contains(x._1)}
    val integers: List[Int] = filter.map{x => x._2}
    val names: String = inputFilter.head
    val summed: Int = integers.sum
    val pairs: (String, Int) = (names, summed)
    pairs
  } 

  def output(input: List[String]): String = {
    val valueList: List[(String, Int)] = input.map{x => counter(x)}
    val filtered: List[(String, Int)] = valueList.filter{x => (x._2 <= 21)}
    val winner: (String, Int) = filtered.maxBy(_._2)
    val winnerFormatted: String = winner._1 + " has won with " + winner._2 + "!"
    winnerFormatted
/*    if (len(counter.integers == 5) && summed <= 21){
        counter.names + " has won with a 5-card trick!"
    } else {
        winnerFormatted
    }*/
  }
}
