import fizzbuzz.FizzBuzz
import org.scalatest.{FunSpec, Matchers}

class FizzBuzzSpec extends FunSpec with Matchers {
  describe("FizzBuzz") {
    describe("For multiple of 3 print Fizz") {
      it("For 9") {
        FizzBuzz.fizzBuzz(9) should be ("Fizz")
      }
      it("For 6") {
        FizzBuzz.fizzBuzz(6) should be ("Fizz")
      }
      it("For 3") {
        FizzBuzz.fizzBuzz(3) should be ("Fizz")
      }
      it("For 999") {
        FizzBuzz.fizzBuzz(999) should be ("Fizz")
      }
    }

    describe("For multiple of 5 print Buzz") {
      it("For 5") {
        FizzBuzz.fizzBuzz(5) should be ("Buzz")
      }
      it("For 10") {
        FizzBuzz.fizzBuzz(10) should be ("Buzz")
      }
      it("For 50") {
        FizzBuzz.fizzBuzz(50) should be ("Buzz")
      }
      it("For 65") {
        FizzBuzz.fizzBuzz(65) should be ("Buzz")
      }
    }

    describe("For multiple of both 3 and 5 print FizzBuzz") {
      it("For 15") {
        FizzBuzz.fizzBuzz(15) should be ("FizzBuzz")
      }
      it("For 45") {
        FizzBuzz.fizzBuzz(45) should be ("FizzBuzz")
      }
      it("For 330") {
        FizzBuzz.fizzBuzz(330) should be ("FizzBuzz")
      }
      it("For 990") {
        FizzBuzz.fizzBuzz(990) should be ("FizzBuzz")
      }
    }

    describe("For all other numbers") {
      it("For 1") {
        FizzBuzz.fizzBuzz(1) should be ("1")
      }
      it("For 2") {
        FizzBuzz.fizzBuzz(2) should be ("2")
      }
      it("For 10") {
        FizzBuzz.fizzBuzz(8) should be ("8")
      }
      it("For 11") {
        FizzBuzz.fizzBuzz(11) should be ("11")
      }
    }
  }

}
