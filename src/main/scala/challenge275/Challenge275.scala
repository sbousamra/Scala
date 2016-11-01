package challenge275

object Challenge275 {
  def main(args: Array[String]): Unit = {
    val input: String = "Spenglerium, Ee\nZeddemorium, Zr\nVenkmine, Kn\nStantzon, Zt\nMelintzum, Nn\nTullium, Ty\n"
    val inputToList: List[String] = input.split("\n").toList
    val mappedList: List[List[String]] = inputToList.map{x => x.split(',').toList}
    val elementAndSymbol: List[ElementAndSymbol] = mappedList.map{x => ElementAndSymbol(x(0).toLowerCase, x(1).toLowerCase)}
    val isValid: List[Boolean] = elementAndSymbol.map{x => isValidSymbol(x.element, x.symbol)}
    println(isValid)
  }

  case class ElementAndSymbol(element: String, symbol: String)

  def isValidSymbol(element: String, symbol: String): Boolean = {
    val elementChars: List[String] = element.split("").toList
    val symbolChars: List[String] = symbol.replaceAll(" ", "").split("").toList
    val ruleOne: Boolean = symbolChars.length == 2
    val ruleTwo: Boolean = symbolChars.forall(x => elementChars.contains(x))
    val ruleThree: Boolean = elementChars.indexOf(symbolChars(0)) <= elementChars.indexOf(symbolChars(1)) || elementChars.lastIndexOf(symbolChars(0)) <= elementChars.lastIndexOf(symbolChars(1))
    val ruleFour: Boolean = 
      if (symbolChars(0) == symbolChars(1))
        elementChars.count(x => x == symbolChars(0)) == 2
      else
        true
    ruleOne && ruleTwo && ruleThree && ruleFour
  }
}

