name := "avro-scala-macro-annotation-examples"

version := "0.0.1-SNAPSHOT"

organization := "com.julianpeeters"

scalaVersion := "2.10.3"

libraryDependencies += "com.julianpeeters" % "avro-scala-macro-annotations_2.10" % "0.1-SNAPSHOT"

addCompilerPlugin("org.scalamacros" % "paradise" % "2.0.0" cross CrossVersion.full)
