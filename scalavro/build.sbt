name := "avro-example"

version := "0.0.1-SNAPSHOT"

organization := "com.julianpeeters"

scalaVersion := "2.10.3"

libraryDependencies += "com.julianpeeters" %% "avro-scala-macro-annotations" % "0.1-SNAPSHOT"

libraryDependencies += "org.apache.avro" % "avro" % "1.7.6"

addCompilerPlugin("org.scalamacros" % "paradise" % "2.0.0" cross CrossVersion.full)
