import sbt._

object Dependencies {

  private val vaadinVersion = "7.4.5"

  def addon(scalaVersion: String) = Seq(
    "org.scala-lang" % "scala-reflect" % scalaVersion,
    "com.vaadin" % "vaadin-server" % vaadinVersion % "provided",
    "javax.servlet" % "servlet-api" % "2.4" % "provided"
  )
}