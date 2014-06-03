/*
 * Copyright (c) 2012 SnowPlow Analytics Ltd. All rights reserved.
 *
 * This program is licensed to you under the Apache License Version 2.0,
 * and you may not use this file except in compliance with the Apache License Version 2.0.
 * You may obtain a copy of the Apache License Version 2.0 at http://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the Apache License Version 2.0 is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Apache License Version 2.0 for the specific language governing permissions and limitations there under.
 */
import sbt._

object Dependencies {
  val resolutionRepos = Seq(
    "ScalaTools snapshots at Sonatype" at "https://oss.sonatype.org/content/repositories/snapshots/",
    "Concurrent Maven Repo" at "http://conjars.org/repo" // For Scalding, Cascading etc
  )

  object V {
    val scalding  = "0.9.0rc4"
    val hadoop    = "1.2.1"
    val specs2    = "1.13" //  -> "2.3.12" when we go to Scala 2.11
    // Add versions for your additional libraries here...
  }

  object Libraries {
    val scaldingCore= "com.twitter" % "scalding-core_2.10" % V.scalding
    val scaldingAvro= "com.twitter" % "scalding-avro_2.10" % V.scalding
    val hadoopCore= "org.apache.hadoop" % "hadoop-core" % V.hadoop
    // to run on Hadoop cluster you would want val hadoopCore= "org.apache.hadoop" % "hadoop-core" % V.hadoop % "provided"
    // Add additional libraries from mvnrepository.com (SBT syntax) here...

    // Scala (test only)
    val specs2       = "org.specs2"                 %% "specs2"               % V.specs2       % "test"
  }
}
