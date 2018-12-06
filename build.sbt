// Turn this project into a Scala.js project by importing these settings
enablePlugins(ScalaJSPlugin)

name := "Example"

version := "0.1-SNAPSHOT"

scalaVersion := "2.12.8"

scalaJSUseMainModuleInitializer := true

val bindingVersion = "11.3.0"


libraryDependencies ++= Seq(
    "org.scala-js" %%% "scalajs-dom" % "0.9.1",
      "com.thoughtworks.binding" %%% "dom" % bindingVersion,
      "com.thoughtworks.binding" %%% "futurebinding" % bindingVersion,
      "com.thoughtworks.binding" %%% "jspromisebinding" % bindingVersion,
"org.julienrf" %%% "play-json-derived-codecs" % "4.0.1",
    "com.lihaoyi" %%% "utest" % "0.4.5" % "test"
)

addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.full)
