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

 publishTo := Some(
   "My resolver" at "https://github.com/Alioune-Cisse/UVS"
 ),
 
 credentials += Credentials(
   "Repo", "https://github.com/Alioune-Cisse/UVS", "Alioune-CISSE", "AliouneCisse1997"
 )

play.Project.playScalaSettings
