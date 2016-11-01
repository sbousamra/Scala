package challenge273

object Challenge273 {
  def main(args: Array[String]): Unit = {
    val inputToString: String = "3.1416rd\n90dr"
    val inputToList: List[String] = inputToString.split("\n").toList
    val ints: List[Float] = inputToList.map{x => x.split("").toList.dropRight(2).mkString.toFloat}
    val firstUnit: List[String] = inputToList.map{x => x.split("").toList.takeRight(2).dropRight(1).mkString}
    val secondUnit: List[String] = inputToList.map{x => x.split("").toList.takeRight(1).mkString}
/*    println(converter(ints, firstUnit, secondUnit))*/
  }
  def converter(ints: Float, firstUnit: String, secondUnit: String): String = {   
    val conversion = firstUnit + secondUnit
    if(conversion == "rd") {
      (ints * (180/math.Pi)).toString + secondUnit
    } else if(conversion == "dr") {
        (ints * (math.Pi/180)).toString + secondUnit
    } else if(conversion == "cf") {
        (ints * 1.8 + 32).toString + secondUnit
    } else if(conversion == "fc") {
        ((ints - 32)/1.8).toString + secondUnit
    } else if(conversion == "ck") {
        (ints + 273.15).toString + secondUnit
    } else if(conversion == "kc") {
        (ints - 273.15).toString + secondUnit
    } else if(conversion == "fk") {
        ((ints + 459.67) * (5/9)).toString + secondUnit
    } else if(conversion == "kf") {
        ((ints * (9/5)) - 459.67).toString + secondUnit
    } else {
        "Error"
      }
    val conversionToString = conversion.mkString 
    conversionToString
  }
}
/*
Pseudocode

1. Input -> (Array[String]) -> List[String] #should be a list containing strings of the int, the initial unit and the conversion unit
2. Isolate List(2) #the initial unit, and then make a series of if statements deciding what expression to go to. #if List(2) == "r", go to val r.
3. Make expressions for each unit, with a series of if statements returning their respective conversions. 
   #i.e. val r = if(List(3) == "d")
              return rd conversion*/
