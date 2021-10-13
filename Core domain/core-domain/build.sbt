name := """Core domain"""
organization := "nvt"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.6"

libraryDependencies += guice
libraryDependencies+= "org.scalatest" %% "scalatest" % "3.2.9" % "test"
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test
libraryDependencies ++= Seq(
  jdbc
  )
libraryDependencies ++= Seq(
  "mysql" % "mysql-connector-java" % "5.1.44"
)
libraryDependencies += jdbc % Test
libraryDependencies += ws

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "nvt.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "nvt.binders._"
