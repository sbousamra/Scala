package challenge277intermediate

object Challenge277int {
  def main(args: Array[String]): Unit = {
    val input = "a b left\na c equal"
    val inputToList = input.split("\n").toList
    val inputMapOne = inputToList.map { x => x.split(" ").toList}
    val inputMapTwo = inputMapOne.map { x => ((x(0), 0), (x(1), 0), x(2))}
  }
  
  def weigher(leftCoin: (String, Int), rightCoin: (String, Int), tipData: String) = {

    if (tipData == "left") {
      ((leftCoin._1, leftCoin._2 + 1), rightCoin)
    } else if (tipData == "right") {
        (leftCoin, (rightCoin._1, rightCoin._2 + 1))
    } else if (tipData == "equal") {
        (leftCoin, rightCoin)
    } else 
        "Error"
  }


}