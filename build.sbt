name := "scalaplay01"

version := "1.0"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.2"

libraryDependencies ++= Seq(
  guice, jdbc , ehcache , ws,
  "com.typesafe.play" %% "play-json" % "2.6.0",
  "org.scalacheck" %% "scalacheck" % "1.13.4" % Test,
  "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.0" % Test
)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
