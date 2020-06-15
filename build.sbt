lazy val root = project
  .in(file("."))
  .settings(
    name := "dotty-example-project",
    description := "Example sbt project that compiles using Dotty",
    version := "0.1.0",
    scalacOptions ++= Seq(
        "-Ysemanticdb",
        "-sourceroot",
        baseDirectory.in(ThisBuild).value.toString
    ),
    scalaVersion := "0.24.0-RC1"
  )
