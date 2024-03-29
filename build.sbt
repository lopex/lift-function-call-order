name := "Lift 2.5 starter template"

version := "0.0.1"

organization := "net.liftweb"

scalaVersion := "2.9.2"

resolvers ++= Seq(
    "snapshots"     at "http://oss.sonatype.org/content/repositories/snapshots",
     "releases"        at "http://oss.sonatype.org/content/repositories/releases"
)

seq(com.github.siasia.WebPlugin.webSettings :_*)

unmanagedResourceDirectories in Test <+= (baseDirectory) { _ / "src/main/webapp" }

scalacOptions ++= Seq("-deprecation", "-unchecked")

libraryDependencies ++= {
  val liftVersion = "2.5-SNAPSHOT"
  Seq(
    "net.liftweb"       %% "lift-webkit"        % liftVersion        % "compile",
    "ch.qos.logback"    % "logback-classic"     % "1.0.6",
    "org.mortbay.jetty" % "jetty" % "6.1.26" % "container"
  )
}

