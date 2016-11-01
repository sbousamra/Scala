package challenge240
import scala.util.Random
object Challenge240 {
  def main(args: Array[String]): Unit = {
    val input: String = "According to a research team at Cambridge University, it doesn't matter in what order the letters in a word are, the only important thing is that the first and last letter be in the right place. The rest can be a total mess and you can still read it without a problem. This is because the human mind does not read every letter by itself, but the word as a whole. Such a condition is appropriately called Typoglycemia."
    val inputToList: List[String] = input.split(" ").toList
    println(typoglycemia(inputToList))
  }
  def shuffler(input: String): String = {
    val stringList: List[String] = input.split("").toList.tail.init
    val shuffledString: String = Random.shuffle(stringList).mkString
    val shuffleString: String = input.head + shuffledString + input.last
    shuffleString
  }

  def typoglycemia(input: List[String]): String = {
    val typo: List[String] = input.map{x => shuffler(x)}
    typo.mkString
  }
} 


/*
Pseudocode

Input
1. Take input: String, split on " ", then call .toList, to create a List[String].

Problemdealer
1. Using this List[String], we want to map a function on the strings inside this list. Remove the first and last letters of each word, then call shuffle to shuffle the letters in between the first and last characters. Then make a string with the first, shuffled output and last letters.

Output
1. Once List[String] has been mapped over with shuffle, called .mkstring and print output in main.*/