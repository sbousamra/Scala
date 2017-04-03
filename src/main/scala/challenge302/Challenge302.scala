package challenge302

import java.io.Serializable

import atto._
import Atto._
import compat.scalaz._

import scala.io.Source
import scalaz.{-\/, NonEmptyList, \/-}


case class AtomicDetails(siSymbol: String, element: String)

//Hints:
//Use Map of Symbol -> Element
//Given a word, use fold to build up a list of elements

object Challenge302 {
  def main(args: Array[String]): Unit = {
    val input = Source.fromFile("/Users/bass/Code/scala/dailyprogrammers-scala/src/main/resources/ptdata2.csv").mkString
    val inputP: List[AtomicDetails] = atomicDetailsListP.parseOnly(input).done.either match {
      case -\/(error) => List(AtomicDetails(error, error))
      case \/-(result) => result
    }
    val mapOfAtomicDetails = mapOfSymbolAndElement(inputP)
    val checkForElement = solve("geniusboy", mapOfAtomicDetails, List.empty[AtomicDetails], 3)
    val formatted = checkForElement.map(line => line.siSymbol).mkString + checkForElement.map(line => line.element.toLowerCase).mkString(" (", " ",")")
    println(formatted)
  }

  def atomicDetailsP: Parser[AtomicDetails] = {
      for {
        _ <- int
        _ <- char(',')
        _ <- char('"')
        _ <- many1(spaceChar)
        siSymbol <- many1(letter).map(l => l.list.toList.mkString)
        _ <- many1(spaceChar)
        _ <- char('"')
        _ <- char(',')
        _ <- char('"')
        _ <- many1(spaceChar)
        element <- many1(letter).map(l => l.list.toList.mkString)
        _ <- many1(anyChar.filter(char => (char != '\n')))
      } yield (AtomicDetails(siSymbol, element))
    }

  def atomicDetailsListP: Parser[List[AtomicDetails]] = {
    sepBy(atomicDetailsP, many(char('\n')))
  }

  def mapOfSymbolAndElement(listOfAtomicDetails: List[AtomicDetails]): Map[String, AtomicDetails] = {
    listOfAtomicDetails.map (line => line.siSymbol.toLowerCase -> line).toMap
  }

  def solve(word: String, map: Map[String, AtomicDetails], listOfAtomicElements: List[AtomicDetails], takeNumber: Int): List[AtomicDetails] = {
    if (word.length == 0) {
      listOfAtomicElements
    } else if (takeNumber <= 0){
      solve(word.takeRight(3), map, listOfAtomicElements, 3)
    } else {
      map.get(word.take(takeNumber)) match {
        case Some(exists) => {
          val acc = listOfAtomicElements :+ (exists)
          solve(word.takeRight(word.length - takeNumber), map, acc, takeNumber)
        }
        case None => {
          solve(word, map, listOfAtomicElements, takeNumber - 1)
        }
      }
    }
  }

}