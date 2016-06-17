object Exercise3 {
    def main(args: Array[String]): Unit = {
        oswald.printCat
        henderson.printCat
        quentin.printCat
        ChipShop.willServe(oswald)
        print(eastwood.yearOfBirth) // should be 1930
        print(dieHard.director.name) // should be "John McTiernan"
        print(invictus.isDirectedBy(nolan)) // should be false
    }

    def print(input: Any): Unit = {
        println(input)
    }

    val oswald = new Cat("Black", "Milk")
    val henderson = new Cat("Ginger", "Chips")
    val quentin = new Cat("Tabby and White", "Curry")

    class Cat(val colour: String, val food: String) {
        def printCat = {
            println(this.colour, this.food)
        }

        def willEat(food: String): Boolean = {
            this.food == food
        } 
    }

    object ChipShop {
        def willServe(cat: Cat): Boolean = {
            cat.willEat("Chips")
        }
    }

    val eastwood = new Director("Clint", "Eastwood", 1930)
    val mcTiernan = new Director("John", "McTiernan", 1951)
    val nolan = new Director("Christopher", "Nolan", 1970)
    val someBody = new Director("Just", "Some Body", 1990)
    val memento = new Film("Memento", 2000, 8.5, nolan)
    val darkKnight = new Film("Dark Knight", 2008, 9.0, nolan)
    val inception = new Film("Inception", 2010, 8.8, nolan)
    val highPlainsDrifter = new Film("High Plains Drifter", 1973, 7.7, eastwood)
    val outlawJoseyWales = new Film("The Outlaw Josey Wales", 1976, 7.9, eastwood)
    val unforgiven = new Film("Unforgiven", 1992, 8.3, eastwood)
    val granTorino = new Film("Gran Torino", 2008, 8.2, eastwood)
    val invictus = new Film("Invictus", 2009, 7.4, eastwood)
    val predator = new Film("Predator", 1987, 7.9, mcTiernan)
    val dieHard = new Film("Die Hard", 1988, 8.3, mcTiernan)
    val huntForRedOctober = new Film("The Hunt for Red October", 1990, 7.6, mcTiernan)
    val thomasCrownAffair = new Film("The Thomas Crown Affair", 1999, 6.8, mcTiernan)

    class Director(firstname: String, lastname: String, yearofbirth: Int) {
        val firstName: String = this.firstname
        val lastName: String = this.lastname
        val yearOfBirth: Int = this.yearofbirth

        def name: String = { 
            firstName + " " + lastName
        }
    }

    class Film(filmName: String, yearofrelease: Int, rating: Double, filmDirector: Director) {
        val name: String = this.filmName
        val yearOfRelease: Int = this.yearofrelease
        val imdbRating: Double = this.rating
        val director: Director = this.filmDirector

        def directorsAge: Int = { 
            yearOfRelease - director.yearOfBirth
        }

        def isDirectedBy(filmDirector: Director): Boolean = {
            filmDirector == director
        }
    }
}
