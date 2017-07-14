lazy val root = (project in file(".")).
  settings(
    organization := "jp.pigumer",
    name := "nextsibling",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := "2.12.2",
    libraryDependencies ++= Seq(
      "org.scala-lang.modules" %% "scala-xml" % "1.0.6",

      "org.specs2" %% "specs2-core" % "3.8.6" % Test,
      "org.specs2" %% "specs2-mock" % "3.8.6" % Test,
      "org.specs2" %% "specs2-junit" % "3.8.6" % Test
    )
  )