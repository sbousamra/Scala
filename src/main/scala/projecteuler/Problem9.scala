package projecteuler

object Problem9 {
  def main(args: Array[String]): Unit = {
    val a = (1 to 1000).toStream.flatMap { x =>
      (x to (1000 - x)).toStream.flatMap { y =>
        (y to (1000 - y)).toStream.map {z =>
          (x, y, z)}}}
    val filtered = a.find { x => triplet(x._1, x._2, x._3)}
    println(filtered)
  }

  def triplet(a: Int, b: Int, c: Int): Boolean = {
    (((math.pow(a, 2) + math.pow(b, 2)) == math.pow(c, 2)) && (a + b + c == 1000))
  }
}