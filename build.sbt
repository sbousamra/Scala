name := "scalabasschallenges"
version := "0.0.1"
scalacOptions := Seq("-unchecked", "-feature", "-deprecation", "-encoding", "utf8", "-Xfatal-warnings", "-language:postfixOps")
scalaVersion := "2.11.8"
mainClass := Some("challenges.Challenges")

libraryDependencies ++= Seq(
  "org.scalaz"                  %% "scalaz-core"                    % "7.1.5",
  "org.http4s"                  %% "http4s-blaze-client"            % "0.15.3",
  "org.http4s"                  %% "http4s-argonaut"                % "0.15.3",
  "org.scalatest"               %% "scalatest"                      % "2.2.1" % "test",
  "org.scalacheck"              %% "scalacheck"                     % "1.12.1" % "test",
  "org.tpolecat"                %% "atto-core"                      % "0.5.1",
  "org.tpolecat"                %% "atto-compat-scalaz71"           % "0.5.1",
  "org.tpolecat"                %% "atto-compat-scalaz72"           % "0.5.1",
  "org.tpolecat"                %% "atto-compat-cats"               % "0.5.1"
)