package challenge260

object Challenge260 {
  def main(args: Array[String]): Unit = {
    val input: String = "button_clicked\ncycle_complete\nbutton_clicked\nbutton_clicked\nbutton_clicked\nbutton_clicked\nbutton_clicked\ncycle_complete"
    val inputSplit: List[String] = input.split("\n").toList
    val commands: List[GarageCommand] = inputSplit.map{x => commandFromString(x)}
    val simulation: GarageSimulation = 
      commands.foldLeft(GarageSimulation()){ (simulation, command) =>
        val newState = transitionState(simulation.currentState, command)
        val newHistory: List[(GarageState, GarageCommand)] = simulation.history :+ (newState, command)
        simulation.copy(history = newHistory)
      }
    println(simulation.render)
  }

  case class GarageSimulation(
    history: List[(GarageState, GarageCommand)] = List.empty[(GarageState, GarageCommand)], 
    initialState: GarageState = Closed
  ) {
    def currentState: GarageState = { 
      if (history.length > 0)
        history.last._1
      else
        initialState
    }

    def render: String = {
      initialState.render + "\n" + history.map {x => x._2.render + "\n" + x._1.render}.mkString("\n")
    }
  }


  sealed trait GarageState{
    def render: String = {
      "Door: " + this.toString 
    }
  }
  case object Closed extends GarageState
  case object Open extends GarageState
  case object Closing extends GarageState
  case object Opening extends GarageState 
  case object StoppedWhileClosing extends GarageState
  case object StoppedWhileOpening extends GarageState


  sealed trait GarageCommand {
    def render: String = {
      val result = this match {
        case ButtonClicked => "Button Clicked."
        case CycleComplete => "Cycle Complete."
      }
      "> " + result
    }
  }
  case object ButtonClicked extends GarageCommand
  case object CycleComplete extends GarageCommand


  def commandFromString(input: String): GarageCommand = input.toLowerCase match {
    case "button_clicked" => ButtonClicked
    case "cycle_complete" => CycleComplete
  }

  def transitionState(initialState: GarageState, command: GarageCommand): GarageState = command match {
    case ButtonClicked => initialState match {
      case Closed              => Opening
      case Opening             => StoppedWhileOpening
      case StoppedWhileOpening => Closing
      case StoppedWhileClosing => Opening
      case Closing             => StoppedWhileClosing
      case Open                => Closing
    }
    case CycleComplete => initialState match {
      case Opening              => Open
      case Closing              => Closed
      case Open                 => initialState
      case Closed               => initialState
      case StoppedWhileClosing  => initialState
      case StoppedWhileOpening  => initialState
    }
  }

  def stateToString(newState: GarageState): String = newState match {
    case Opening => "Door: Open"
    case Closing => "Door: Closing"
    case Open => "Door: Open"
    case Closed => "Door: Closed"
    case StoppedWhileClosing => "Door: Stopped_While_Closing"
    case StoppedWhileOpening => "Door: Stopped_While_Opening"
  }

  def commandToString(command: GarageCommand): String = command match {
    case ButtonClicked => "Button Clicked"
    case CycleComplete => "Cycle Complete"
  } 
}

/*“Commands”, “GarageDoorState”*/