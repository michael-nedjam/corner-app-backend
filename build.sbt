name := "testApp01"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaJpa,
  "org.apache.directory.api" % "api-all" % "1.0.0-M14",
  "postgresql" % "postgresql" % "9.1-901-1.jdbc4",
  "org.hibernate" % "hibernate-core" % "4.3.0.Final",
  "org.hibernate" % "hibernate-entitymanager" % "4.3.0.Final",
  "org.json" % "json" % "20080701",
  "com.notnoop.apns" % "apns" % "1.0.0.Beta6"
)     

play.Project.playJavaSettings
