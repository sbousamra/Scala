package projecteuler

object Problem16 {
  def main(args: Array[String]) {
    println(numberPowerToSummed(2, 1000))
  }

  def numberPowerToSummed(number: Int, power: Int): Int = {
    val result = BigInt(number).pow(power)
    val resultToList = result.toString.split("").map { x => x.toInt}
    val summedList = resultToList.sum
    summedList
  }
}

//Create BigInt taking in 2 ^ 1000
//Split BigInt result on "", convert to List[Int]
//Sum all Ints in list for final result