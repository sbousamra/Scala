package projecteuler

object Problem18 {
  def main(args: Array[String]) {
    val input: List[List[Int]] = """75
                  |95 64
                  |17 47 82
                  |18 35 87 10
                  |20 04 82 47 65
                  |19 01 23 75 03 34
                  |88 02 77 73 07 63 67
                  |99 65 04 28 06 16 70 92
                  |41 41 26 56 83 40 80 70 33
                  |41 48 72 33 47 32 37 16 94 29
                  |53 71 44 65 25 43 91 52 97 51 14
                  |70 11 33 28 77 73 17 78 39 68 17 57
                  |91 71 52 38 17 14 91 43 58 50 27 29 48
                  |63 66 04 68 89 53 67 30 73 16 69 87 40 31
                  |04 62 98 27 23 09 70 98 73 93 38 53 60 04 23""".stripMargin
      .split("\n")
      .map (line => line.split(" ")
        .map (x => x.toInt).toList)
      .reverse
      .toList
    val result: List[Int] = input
      .reduce((currentLine, nextLine) => maxPath(currentLine, nextLine))
    println(result.mkString)
  }

  def maxPath(bottomLine: List[Int], nextLine: List[Int]): List[Int] = {
    val maxAdjacentNumber: List[Int] = bottomLine
      .sliding(2, 1)
      .map (potentialPath => potentialPath.max)
      .toList
    val addToNextLine: List[Int] = nextLine
      .zip(maxAdjacentNumber)
      .map (max => max._1 + max._2)
    addToNextLine
  }
}

/*
Create List[List[Int]], representing each line of the triangle.
Make function that takes the second line in the triangle from the bottom and sums it with the largest adjacent number of the two on the last line.
This will build up a new line of the sum of the previous line. This new line will become the last line of the triangle, and we will repeat this iteration until the top of the triangle.
Fold this function over the List[List[Int]] representing the triangle.*/
