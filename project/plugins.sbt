// Comment to get more information during initialization
logLevel := Level.Warn

// The Typesafe repository
resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"


// Use the Play sbt plugin for Play projects
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.2.2")

// codehaus repository
resolvers += "codehaus" at "http://repository.codehaus.org/org/codehaus/"

val appDependencies = Seq(
  "org.codehaus.jackson" % "jackson-mapper-asl" % "11.8.5"
)