name := "algorithms"

version := "1.0"

scalaVersion := "2.12.1"

lazy val commonSettings = Seq(
  organization := "com.bilalalp.algorithms",
  scalaVersion := "2.12.1",
  scalacOptions ++= Seq("-encoding", "UTF-8"),
  libraryDependencies ++= Seq("org.scalatest" % "scalatest_2.12" % "3.0.1" % "test")
)

lazy val algorithms = Project(id = "algorithms", base = file(".")).aggregate(searching, sorting, datastructure)

lazy val searching = Project(id = "searching", base = file("./searching")).settings(commonSettings: _*)

lazy val datastructure = Project(id = "datastructure", base = file("./datastructure")).settings(commonSettings: _*)

lazy val sorting = Project(id = "sorting", base = file("./sorting")).settings(commonSettings: _*).dependsOn(datastructure)