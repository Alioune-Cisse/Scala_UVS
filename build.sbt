name := "scolarite_project"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  "javax.inject" % "javax.inject" % "1"
)

// https://mvnrepository.com/artifact/mysql/mysql-connector-java
//libraryDependencies += "mysql" % "mysql-connector-java" % "8.0.16"

play.Project.playScalaSettings
