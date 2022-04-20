name := "Sbt-Scala"

version := "0.1"

scalaVersion := "2.13.8"

lazy val common = project.in(file("common"))
  .settings(
    libraryDependencies ++= Seq(
      "io.github.embeddedkafka" %% "embedded-kafka" % "3.1.0",
      "org.json4s" %% "json4s-ast" % "4.0.5",
      "org.scalactic" %% "scalactic" % "3.2.11",
      "org.scalatest" %% "scalatest" % "3.2.11" % "test",
      "org.mockito" %% "mockito-scala" % "1.17.5" % "test"

    )
  )

lazy val actor = project.in(file("actor"))
  .settings(
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-actor-typed" % "2.6.19",
      "com.typesafe.akka" %% "akka-actor" % "2.6.19",
      "com.typesafe.akka" %% "akka-persistence-typed" % "2.6.19",
      "com.typesafe.akka" %% "akka-actor-testkit-typed" % "2.6.19" % "test",
      "org.scalatest" %% "scalatest" % "3.2.11" % "test"
    )
  )
  .dependsOn(common)

addSbtPlugin("io.github.knoldus" % "codesquad-sbt-plugin" % "0.2.1")
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.9.3")

lazy val root = project.in(file(".")).aggregate(common, actor)