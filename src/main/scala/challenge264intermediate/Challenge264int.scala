package challenge264intermediate

case class BusDriver(id: Int, route: List[String], gossips: List[Int])
case class Simulation(drivers: List[BusDriver])

object Challenge264int {
  def main(args: Array[String]) {
    val input = "3 1 2 3\n3 2 3 1 \n4 2 3 4 5"
    val inputSplit = input.split("\n").toList
    val duration = 10
    val drivers = inputSplit.zipWithIndex.map { case(x, id) =>
      val routes = Stream.continually(x.split(" ").toList).flatten.take(duration).toList
      BusDriver(id, routes, List(id))
    }
    println(drivers)
    val simulation = Simulation(drivers)
    println(finishedGossiping(simulation))
  }

  def finishedGossiping(sim: Simulation): Boolean = {
    val driverIds = sim.drivers.map(_.id).toSet
    println(driverIds)
    val checker = sim.drivers.forall { driver =>
      driverIds.subsetOf(driver.gossips.toSet)
    }
    checker
  }

//  def meetUp(sim: Simulation): List[Int] = {
//    val routeMatcher = sim.drivers.map { driver =>
//      if (driver.route == )
//    }
//  }

}