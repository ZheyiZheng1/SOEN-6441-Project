lazy val root = (project in file("."))
  .enablePlugins(PlayJava)
  .settings(
    name := """play-java-starter-example""",
    version := "1.0-SNAPSHOT",
    crossScalaVersions := Seq("2.13.14", "3.3.3"),
    scalaVersion := crossScalaVersions.value.head,
    libraryDependencies ++= Seq(
      guice,
      "com.typesafe.play" %% "play" % "2.9.5",
      // Test Database
      "com.h2database" % "h2" % "2.3.232",
      // Google API client dependency
      "com.google.apis" % "google-api-services-youtube" % "v3-rev222-1.25.0",
      //json unit
      "org.json" % "json" % "20210307",
      "com.fasterxml.jackson.core" % "jackson-databind" % "2.12.3",
      //Akka dependency
      "com.typesafe.akka" %% "akka-actor" % "2.6.21",
      "com.typesafe.akka" %% "akka-stream" % "2.6.21",
      "com.typesafe.akka" %% "akka-testkit" % "2.6.21" % Test,
      // Mockito
      "org.mockito" % "mockito-core" % "5.3.1" % Test,
      //JUnit
      "org.junit.jupiter" % "junit-jupiter-api" % "5.8.2" % Test,
      "org.junit.jupiter" % "junit-jupiter-engine" % "5.8.2" % Test,
      // Testing libraries for dealing with CompletionStage...
      "org.assertj" % "assertj-core" % "3.26.3" % Test,
      "org.awaitility" % "awaitility" % "4.2.2" % Test,
    ),
    javacOptions ++= Seq(
      "-encoding", "UTF-8",
      "-parameters",
      "-Xlint:unchecked",
      "-Xlint:deprecation",
      "-Werror"
    ),
    (Test / javaOptions) += "-Dtestserver.port=19001",
    // Make verbose tests
    (Test / testOptions) := Seq(Tests.Argument(TestFrameworks.JUnit, "-a", "-v"))
  )
