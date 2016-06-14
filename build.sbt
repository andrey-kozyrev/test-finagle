name := "test-finagle"

version := "0.1"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "ch.qos.logback" % "logback-classic" % "1.1.7",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.4.0",
  "com.twitter" %% "finagle-http" % "6.35.0"
)

fork := true

connectInput in run := true

outputStrategy := Some(StdoutOutput)

