name := "algorithms"

version := "1.0"

scalaVersion := "2.12.1"

lazy val commonSettings = Seq(
  organization := "com.bilalalp.algorithms",
  scalaVersion := "2.12.1",
  scalacOptions ++= Seq("-encoding", "UTF-8"),
  libraryDependencies ++= Seq("org.scalatest" % "scalatest_2.12" % "3.0.1" % "test")
)

lazy val algorithms = (project in file(".")).aggregate(searching,sorting)

lazy val searching = project.in(file("./searching")).settings(commonSettings: _*)

lazy val sorting = project.in(file("./sorting")).settings(commonSettings: _*)