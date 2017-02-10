package scratchpad

import scala.collection.immutable.HashMap

object MapTest {
  def main(args: Array[String]) {
    val x: Map[Int, String] = HashMap((1, "one"), (2, "two"))
    val y = x.getOrElse(1, "bass")
  }
}
