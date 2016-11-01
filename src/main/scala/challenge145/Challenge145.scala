package challenge145

object Challenge145 {
  def main(args: Array[String]): Unit = {
    val input = "21 @ #"
    val inputSeperate: List[String] = input.split(" ").toList
    val size: Int = inputSeperate(0).toInt
    val trunk: String = inputSeperate(1)
    val leaf: String = inputSeperate(2)
    println(treeBuilder(size, trunk, leaf))
  }

  def treeBuilder(size: Int, trunk: String, leaf: String) = {
    val padding: String = " "
    val trunkPadding: String = padding * ((size/2) - 1)
    val treeTrunkString: String = trunkPadding + (trunk * 3) + trunkPadding
    val treeLeafString: List[String] = Range(1 , size, 2).map{z => ((padding * ((size - z)/2)) + (leaf * z) + ((padding * ((size - z)/2))))}.toList :+ treeTrunkString
    val totalTree: String = treeLeafString.mkString("\n")
    
    totalTree
  }
}

/*Pseudocode

1. Take input, print strings seperated by "\n" of size 1, then 1 + 2, all the way up to (1 + 2^x) == integer in input and of character leaf in input. Trunk is always of size 3 and of character trunk in input.*/

