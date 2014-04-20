name := "chessmap"

version := "1.1"

resolvers ++= Seq(
  "SnowPlow Repo" at "http://maven.snplow.com/releases/",
  "Twitter Maven Repo" at "http://maven.twttr.com/"
)

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  "com.snowplowanalytics"  %% "scala-maxmind-geoip"  % "0.0.5",
  "com.google.guava" % "guava" % "16.0.1",
  "com.google.code.findbugs" % "jsr305" % "2.0.3"
)

scalacOptions := Seq("-deprecation", "-unchecked", "-feature", "-language:_")

play.Project.playScalaSettings
