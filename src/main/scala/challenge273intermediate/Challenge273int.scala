package challenge273intermediate
import java.util.Random

object Challenge273int {
  def main(args: Array[String]): Unit = {
    println(englishToChar("For"))
  }

  def randomizer(input: List[String]): String = {
    util.Random.shuffle(input).head
  }

  def englishToChar(letter: String) = {
    val inputToList: List[String] = letter.split("").toList
    val czech: String = "Áá Čč Ďď Éé Ěě Íí Ňň Óó Řř Šš Ťť Úú Ůů Ýý Žž"
    val vietnamese: String = "Áá Àà Ãã Ảả Ạạ Ââ Ấấ Ầầ Ẫẫ Ẩẩ Ậậ Ăă Ắắ Ằằ Ẵẵ Ẳẳ Ặặ Đđ Éé Èè Ẽẽ Ẻẻ Ẹẹ Êê Ếế Ềề Ễễ Ểể Ệệ Íí Ìì Ĩĩ Ỉỉ Ịị Óó Òò Õõ Ỏỏ Ọọ Ôô Ốố Ồồ Ỗỗ Ổổ Ộộ Ơơ Ớớ Ờờ Ỡỡ Ởở Ợợ Úú Ùù Ũũ Ủủ Ụụ Ưư Ứứ Ừừ Ữữ Ửử Ựự Ýý Ỳỳ Ỹỹ Ỷỷ Ỵỵ"

    val vietnameseList: List[String] = vietnamese.split(" ").toList
    val vietnameseListMap: List[List[String]] = vietnameseList.map { x => x.split("").toList}
    val vietnameseUpper: List[String] = vietnameseListMap.map {x => x(0)}
    val vietnameseLower: List[String] = vietnameseListMap.map {x => x(1)}

    val A: List[String] = vietnameseUpper.slice(0, 17)
    val a: List[String] = vietnameseLower.slice(0, 17)
    val B: List[String] = List()
    val b: List[String] = List()
    val C: List[String] = List()
    val c: List[String] = List()
    val D: List[String] = vietnameseUpper.slice(17, 18)
    val d: List[String] = vietnameseLower.slice(17, 18)
    val E: List[String] = vietnameseUpper.slice(18, 29)
    val e: List[String] = vietnameseLower.slice(18, 29)
    val F: List[String] = List()
    val f: List[String] = List()
    val G: List[String] = List()
    val g: List[String] = List()
    val H: List[String] = List()
    val h: List[String] = List()
    val I: List[String] = vietnameseUpper.slice(29, 34)
    val i: List[String] = vietnameseLower.slice(29, 34)
    val J: List[String] = List()
    val j: List[String] = List()
    val K: List[String] = List()
    val k: List[String] = List()
    val L: List[String] = List()
    val l: List[String] = List()
    val M: List[String] = List()
    val m: List[String] = List()
    val N: List[String] = List()
    val n: List[String] = List()
    val O: List[String] = vietnameseUpper.slice(34, 51)
    val o: List[String] = vietnameseLower.slice(34, 51)
    val P: List[String] = List()
    val p: List[String] = List()
    val Q: List[String] = List()
    val q: List[String] = List()
    val R: List[String] = List()
    val r: List[String] = List()
    val S: List[String] = List()
    val s: List[String] = List()
    val T: List[String] = List()
    val t: List[String] = List()
    val U: List[String] = vietnameseUpper.slice(51, 62)
    val u: List[String] = vietnameseLower.slice(51, 62)
    val V: List[String] = List()
    val v: List[String] = List()
    val W: List[String] = List()
    val w: List[String] = List()
    val X: List[String] = List()
    val x: List[String] = List()
    val Y: List[String] = vietnameseUpper.slice(62, 67)
    val y: List[String] = vietnameseLower.slice(62, 67)
    val Z: List[String] = List()
    val z: List[String] = List()


    val twist = inputToList.map { twister => twister match {
      case "A" => A
      case "a" => a
      case "B" => B
      case "b" => b
      case "C" => C
      case "c" => c
      case "D" => D
      case "d" => d
      case "E" => E
      case "e" => e
      case "F" => F
      case "f" => f
      case "G" => G
      case "g" => g
      case "H" => H
      case "h" => h
      case "I" => I
      case "i" => i
      case "J" => J
      case "j" => j
      case "K" => K
      case "k" => k
      case "L" => L
      case "l" => l
      case "M" => M
      case "m" => m
      case "N" => N
      case "n" => n
      case "O" => O
      case "o" => o
      case "P" => P
      case "p" => p
      case "Q" => Q
      case "q" => q
      case "R" => R
      case "r" => r
      case "S" => S
      case "s" => s
      case "T" => T
      case "t" => t
      case "U" => U
      case "u" => u
      case "V" => V
      case "v" => v
      case "W" => W
      case "w" => w
      case "X" => X
      case "x" => x
      case "Y" => Y
      case "y" => y
      case "Z" => Z
      case "z" => z
      case _ => twister
      }
    }
   U
  }
}