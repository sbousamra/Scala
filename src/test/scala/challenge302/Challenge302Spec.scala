package challenge302

import Challenge302._
import atto._
import Atto._
import compat.scalaz._
import scalaz._
import org.scalatest.{FunSpec, Matchers}

class Challenge302Spec extends FunSpec with Matchers {

  describe("parsing line of AtomicDetails") {
    it ("should return AtomicDetails") {
      atomicDetailsP.parseOnly("1,\" H \",\" Hydrogen\",\" 1.00794\"").done.either should be (\/-(AtomicDetails("H", "Hydrogen")))
      atomicDetailsP.parseOnly("8,\" O \",\" Oxygen\",\" 15.9994\"").done.either should be (\/-(AtomicDetails("O", "Oxygen")))
      atomicDetailsP.parseOnly("31,\" Ga \",\" Gallium\",\" 69.723\"").done.either should be (\/-(AtomicDetails("Ga", "Gallium")))
    }
  }

  describe("parsing list of AtomicDetails") {
    it ("should return list of AtomicDetails") {
      val testStringList = List(
        "1,\" H \",\" Hydrogen\",\" 1.00794\"",
        "8,\" O \",\" Oxygen\",\" 15.9994\"",
        "31,\" Ga \",\" Gallium\",\" 69.723\""
      ).mkString("\n")
      val parseTestList = atomicDetailsListP.parseOnly(testStringList).done.either
      parseTestList should be (\/-(List(
        AtomicDetails("H", "Hydrogen"),
        AtomicDetails("O", "Oxygen"),
        AtomicDetails("Ga", "Gallium")
      )))
    }
  }
}