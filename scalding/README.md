Strata2014ScaldingTutorial
==========================

This is a template project for a tutorial on [Effective Data Science With Scalding](http://strataconf.com/strata2014/public/schedule/detail/31957)
at [Strata 2014 Conference](http://strataconf.com/strata2014).

This project is based on amazingly simple [Scalding Example Project by Snowplow Analytics](https://github.com/snowplow/scalding-example-project).

To make best use of your time at the tutorial, please do the following preparation steps:


1. Install SBT
--------------

We use [SBT build tool](http://www.scala-sbt.org/) version [0.12.3](http://www.scala-sbt.org/0.12.3/docs/home.html).

If you don't have it installed on your machine, one way to install it on Mac OS X would be
by using [Homebrew](http://brew.sh/):

     > brew install sbt

[The SBT documentation](http://www.scala-sbt.org/0.12.3/docs/Getting-Started/Setup.html) contains
detailed information about install on other systems.

2. Clone this project
---------------------

     > git clone https://github.com/vitalyg/Strata2014ScaldingTutorial.git
     > cd Strata2014ScaldingTutorial

Some people reported problems with git command. As an alternative, you can download the [zip file](http://github.com/vitalyg/Strata2014ScaldingTutorial/archive/master.zip) and uncompress it:

     > wget http://github.com/vitalyg/Strata2014ScaldingTutorial/archive/master.zip
     > unzip master.zip
     > cd Strata2014ScaldingTutorial-master

3. Enter SBT Command Line
-------------------------

     > sbt
     ...
     Tutorial >

This step may take quite a bit of time downloading all the parts and dependencies so it
makes so much sense to run it in advance.

4. Compile and Run the WordCount Example
----------------------------------------

     Tutorial > run tutorial.WordCountJob
     ...
     [success] Total time: 2 s, completed Feb 3, 2014 9:15:12 PM
     Tutorial >

This step can also take quite a bit of time.


5. See the Results
------------------

The file `grimmWordCounts.tsv` should be created in the `data` directory.

FAQ
---

### I am getting java.lang.OutOfMemoryError ###

You will need to set JVM runtime parameters. Depending on the type of error you will need to increase
heap size (`-Xmx` or PermGen space `-XX:MaxPermSize`).

You can set up options in the SBT command or in file located at `~/.sbtconfig`, for example:

     > cat > ~/.sbtconfig
     export SBT_OPTS="-Xmx1024m -XX:MaxPermSize=256m"
     <ctrl>D
     >


Copyright and license
---------------------

Copyright 2012-2013 Snowplow Analytics Ltd, with significant portions copyright 2012 Twitter, Inc.

Licensed under the [Apache License, Version 2.0] [license] (the "License");
you may not use this software except in compliance with the License.

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

[license]: http://www.apache.org/licenses/LICENSE-2.0


