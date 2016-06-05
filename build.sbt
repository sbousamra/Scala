name := "scalabass"

scalacOptions := Seq("-unchecked", "-feature", "-deprecation", "-encoding", "utf8", "-Xfatal-warnings", "-language:postfixOps")

mainClass := "day2.Day2"

libraryDependencies ++= Seq(
  "org.scalaz"                  %% "scalaz-core"                    % "7.1.5",
  "org.scalatest"               %% "scalatest"                      % "2.2.1" % "test",
  "org.scalacheck"              %% "scalacheck"                     % "1.12.1" % "test"
)