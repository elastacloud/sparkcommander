organization  := "org.apache.spark.commander"

version       := "0.1"

scalaVersion  := "2.10.4"

libraryDependencies ++= {
  Seq(
    "org.scalatra" %% "scalatra-json" % "2.3.0",
    "org.scalatra" %% "scalatra" % "2.3.0",
    "org.scalatra" %% "scalatra-scalate" % "2.2.2",
    "org.apache.spark"    %%  "spark-core"    % "1.0.2",
    "ch.qos.logback" % "logback-classic" % "1.0.13",
    "org.eclipse.jetty" % "jetty-webapp" % "8.1.10.v20130312",
    "org.eclipse.jetty.orbit" % "javax.servlet" % "3.0.0.v201112011016"
  )
}

resolvers += "Sonatype Nexus Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

resolvers += "Akka Repo" at "http://repo.akka.io/repository"

    