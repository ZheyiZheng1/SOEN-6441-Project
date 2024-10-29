lazy val root = (project in file("."))
  .enablePlugins(PlayJava)
  //.enablePlugins(PlayNettyServer).disablePlugins(PlayPekkoHttpServer) // uncomment to use the Netty backend
  .settings(
    name := """play-java-starter-example""",
    version := "1.0-SNAPSHOT",
    crossScalaVersions := Seq("2.13.14", "3.3.3"),
    scalaVersion := crossScalaVersions.value.head,
    libraryDependencies ++= Seq(
      guice,
      // Test Database
      "com.h2database" % "h2" % "2.3.232",
      // Google API client dependency
      "com.google.apis" % "google-api-services-youtube" % "v3-rev222-1.25.0",
      //JUnit
      "org.junit.jupiter" % "junit-jupiter" % "5.8.2" % Test,
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
