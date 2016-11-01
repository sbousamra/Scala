package projecteuler

object Example {
  def main(args: Array[String]) {

    case class User(id: Int, name: String)
    case class Camera(id: Int, model: String)

    val domIsAFaggotId = 7
    val fag = List[Int]().map(x => x * 3)
    println(fag)

    def getUser(id: Int): Option[User] = ???

    def getUsersCamera(user: User): Option[Camera] = ???

//    def getCameraFromUserId(id: Int): Option[Camera] = {
//      val userId: Option[User] = getUser(domIsAFaggotId).map { x => x}
//      val userCamera = getUsersCamera(userId)
//    }
  }
}
