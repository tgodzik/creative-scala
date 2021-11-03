lazy val root = project
  .in(file("."))
  .settings(
    name := "scala3-example-project",
    description := "Example sbt project that compiles using Scala 3",
    version := "0.1.0",
    scalacOptions ++= Seq(
        "-Xsemanticdb",
        "-sourceroot",
        baseDirectory.in(ThisBuild).value.toString
    ),
    libraryDependencies += "org.creativescala" %% "doodle" % "0.9.25",
    scalaVersion := "3.1.0"
  )
