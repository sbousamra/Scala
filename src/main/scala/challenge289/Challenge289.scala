package challenge289

object Challenge289 {
  def main(args: Array[String]) {
    val input = "fire,grass\nfighting,ice\npsychic,poison\nwater,normal\nfire,rock"
    val inputFormatted = input.split("\n").toList.map(line => line.split(",").toList).map(pairs => (pairs.head, pairs.last))
    val pokemonWeWantToCheck = inputFormatted.map(line => (Pokemon.fromString(line._1), Pokemon.fromString(line._2)))
    val readPokemonDataFromFile = scala.io.Source.fromFile("src\\main\\resources\\PokemonData.txt").getLines.mkString("\n")
    val pokemonData = pokemonDataFormatted(readPokemonDataFromFile)
    val effectiveness: List[Option[Double]] = pokemonWeWantToCheck.map(line => fightEffectiveness(line._1, line._2, pokemonData))
    effectiveness.map(effectiveness => effectiveness match {
      case Some(effect) => println(effect)
      case None => println("could not compute value")
    }
    )
  }

  sealed trait Pokemon
  case object Normal extends Pokemon
  case object Fire extends Pokemon
  case object Water extends Pokemon
  case object Electric extends Pokemon
  case object Grass extends Pokemon
  case object Ice extends Pokemon
  case object Fighting extends Pokemon
  case object Poison extends Pokemon
  case object Ground extends Pokemon
  case object Flying extends Pokemon
  case object Psychic extends Pokemon
  case object Bug extends Pokemon
  case object Rock extends Pokemon
  case object Ghost extends Pokemon
  case object Dragon extends Pokemon
  case object Dark extends Pokemon
  case object Steel extends Pokemon
  case object Fairy extends Pokemon

  object Pokemon {
    def fromString(string: String): Pokemon = {
      string.toLowerCase match {
        case "normal" => Normal
        case "fire" => Fire
        case "water" => Water
        case "electric" => Electric
        case "grass" => Grass
        case "ice" => Ice
        case "fighting" => Fighting
        case "poison" => Poison
        case "ground" => Ground
        case "flying" => Flying
        case "psychic" => Psychic
        case "bug" => Bug
        case "rock" => Rock
        case "ghost" => Ghost
        case "dragon" => Dragon
        case "dark" => Dark
        case "steel" => Steel
        case "fairy" => Fairy
      }
    }
  }

  def pokemonDataFormatted(input: String): Map[Pokemon, Map[Pokemon, Double]] = {
    val inputFormat = input.split("\n").toList.map (line => line.split(" ").toList.filter (x => x != ""))
    val pokemons: List[Pokemon] = inputFormat.head.map(Pokemon.fromString)
    val pokemonToFight: List[Map[Pokemon, Double]] = inputFormat.tail.map(values => pokemons.zip(values.map(x => x.toDouble)).toMap)
    pokemons.zip(pokemonToFight).toMap
  }

  def fightEffectiveness(p1: Pokemon, p2: Pokemon, pokemonData: Map[Pokemon, Map[Pokemon, Double]]): Option[Double] = {
    pokemonData.get(p1).flatMap(pokemon => pokemon.get(p2))
  }

  def pokemonDataFromApi(p1: Pokemon, p2: Pokemon): Double = {
    ???
  }
}