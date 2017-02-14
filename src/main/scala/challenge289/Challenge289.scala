package challenge289

import argonaut.{DecodeJson, Json}
import org.http4s.{Request, Uri}
import org.http4s.client.blaze.SimpleHttp1Client
import org.http4s.argonaut.jsonDecoder

import scalaz.concurrent.Task

object Challenge289 {
  def main(args: Array[String]) {
    val pokemonWeWant = "fire,grass\nfighting,ice\npsychic,poison\nwater,normal\nfire,rock"
    val pokemonWeWantFormatted: List[(Pokemon, Pokemon)] = pokemonWeWant.split("\n").toList.map(line => line.split(",").toList).map(pairs => (pairs.head, pairs.last)).map(line => (Pokemon.fromString(line._1), Pokemon.fromString(line._2)))
    val useTable = false

    val result: List[String] = pokemonWeWantFormatted.flatMap { case (p1, p2) =>
      val effectiveness = if (useTable) {
        fightEffectivenessFromTable(p1, p2)
      } else {
        fightEffectivenessFromApi(p1, p2).orElse(Some(1.0))
      }
      effectiveness.map(formatResult)
    }
    result.foreach(println)
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

  def pokemonDataFromTable(input: String): Map[Pokemon, Map[Pokemon, Double]] = {
    val inputFormat = input.split("\n").toList.map (line => line.split(" ").toList.filter (x => x != ""))
    val pokemons: List[Pokemon] = inputFormat.head.map(Pokemon.fromString)
    val pokemonToFight: List[Map[Pokemon, Double]] = inputFormat.tail.map(values => pokemons.zip(values.map(x => x.toDouble)).toMap)
    pokemons.zip(pokemonToFight).toMap
  }

  def fightEffectivenessFromTable(p1: Pokemon, p2: Pokemon): Option[Double] = {
    val readPokemonDataTableFromFile = scala.io.Source.fromFile("src\\main\\resources\\PokemonData.txt").getLines.mkString("\n")
    val pokemonDataFromTableFormatted = pokemonDataFromTable(readPokemonDataTableFromFile)
    println(pokemonDataFromTableFormatted)
    pokemonDataFromTableFormatted.get(p1).flatMap(pokemon => pokemon.get(p2))
  }

  case class Effectiveness(name: String)
  case class PokemonApiDamageEffectiveness(noDamage: List[Effectiveness], halfDamage: List[Effectiveness], doubleDamage: List[Effectiveness])

  implicit def pokemonApiDamageEffectivenessDecodeJson: DecodeJson[PokemonApiDamageEffectiveness] = { DecodeJson { h =>
    for {
      noDamage <- (h --\ "damage_relations").get[List[Effectiveness]]("no_damage_to")
      halfDamage <- (h --\ "damage_relations").get[List[Effectiveness]]("half_damage_to")
      doubleDamage <- (h --\ "damage_relations").get[List[Effectiveness]]("double_damage_to")
    } yield PokemonApiDamageEffectiveness(noDamage, halfDamage, doubleDamage)
  }
  }

  implicit def effectivenessDecodeJson: DecodeJson[Effectiveness] = {
    DecodeJson { h =>
      for {
        name <- h.get[String]("name")
      } yield Effectiveness(name)
    }
  }

  def pokemonDataFromApi(p1: Pokemon): Map[Pokemon, Double] = {
    // 1. Make request to API to get back list of effectiveness of p1.
    // 2. Turn the JSON returned into Map[Pokemon, Double]
    val url: Uri = Uri.unsafeFromString("http://pokeapi.co/api/v2/type/" + p1.toString.toLowerCase + "/")
    val responseAsJson = SimpleHttp1Client().expect[Json](url).run
    val effectiveness = responseAsJson.as[PokemonApiDamageEffectiveness].toOption.get
    val noDamage: List[(String, Double)] = effectiveness.noDamage.map(x => (x.name, 0.0))
    val halfDamage: List[(String, Double)] = effectiveness.halfDamage.map(x => (x.name, 0.5))
    val doubleDamage: List[(String, Double)] = effectiveness.doubleDamage.map(x => (x.name, 2.0))
    val allTogether: List[(String, Double)] = noDamage ++ halfDamage ++ doubleDamage
    allTogether.toMap.map(x => (Pokemon.fromString(x._1), x._2))
  }

  def fightEffectivenessFromApi(p1: Pokemon, p2: Pokemon): Option[Double] = {
      pokemonDataFromApi(p1).get(p2)
  }

  def formatResult(result: Double): String = {
    result.toString + "x"
  }
}