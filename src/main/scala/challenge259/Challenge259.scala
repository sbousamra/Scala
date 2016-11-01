package challenge259

object Challenge259 {
  def main(args: Array[String]): Unit = {
    ???
  }

  case class Coordinate(x: Int, y: Int)
  sealed trait Key
  case object One extends Key
  case object Two extends Key
  case object Three extends Key
  case object Four extends Key
  case object Five extends Key
  case object Six extends Key
  case object Seven extends Key
  case object Eight extends Key
  case object Nine extends Key
  case object Dot extends Key
  case object Zero extends Key

   def keyToCoordinate(k: Key): Coordinate = k match {
      case One => Coordinate(0, 0)
      case Two => Coordinate(1, 0)
      case Three => Coordinate(2, 0)
      case Four => Coordinate(0, 1)
      case Five => Coordinate(1, 1)
      case Six => Coordinate(2, 1)
      case Seven => Coordinate(0, 2)
      case Eight => Coordinate(1, 2)
      case Nine => Coordinate(2, 2)
      case Dot => Coordinate(0, 3)
      case Zero => Coordinate(1, 3)
    }

  // def distance(coordinateOne: Coordinate, coordinateTwo: Coordinate): Double = ???
  //   initialKey match {
  //   case One => nextKey match {
  //     case Two => 1
  //     case Three => 2
  //     case Four => 1
  //     case Five => math.sqrt(2)
  //     case Six => math.sqrt(2) + 1
  //     case Seven => 2
  //     case Eight => math.sqrt(2) + 1
  //     case Nine => math.sqrt(2) * 2
  //   }
  //   case Two => nextKey match {
  //     case One => 1
  //     case Three => 1
  //     case Four => math.sqrt(2)
  //     case Five => 1
  //     case Six => math.sqrt(2)
  //     case Seven => math.sqrt(2) + 1
  //     case Eight => 2
  //     case Nine => math.sqrt(2) + 1
  //   }
  //   }
}