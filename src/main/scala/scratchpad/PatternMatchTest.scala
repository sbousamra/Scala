package scratchpad

object PatternMatchTest {
  def main(args: Array[String]) {

    // Pattern type 1
    // Literal pattern
    val x = "test"
    x match {
      case "dom" => 1
      case "hello" => 2
      case _ => 3
    }

    // Pattern type 2
    val y = x match {
      case "hello" => "we recieved hello"
      case dom => "we recieved" + dom
    }

    // Pattern type 3
    case class Job(name: String, salary: Int)
    case class Person(name: String, age: Int, job: Job)
    val dom = Person("dom", 27, Job("programmer", 1230120))
    dom match {
      case Person("bass", 24, Job("test", 0)) => "lol"
      case Person(name, 27, Job("no", salary)) => "we recieved 27 year old"
//      case p => "we recieved" + p
      case _ => "we recieved something unknown"
    }
    val test: Option[Person] = Some(dom)
     test match {
       case Some(dom) => "we have a dom"
       case None => "no type"
    }
    println(y)
  }
}
