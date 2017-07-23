

object Dependencies {

  private val vaadinVersion = "7.7.10"

  def addon(scalaVersion: String) = Seq(
    "org.scala-lang" % "scala-reflect" % scalaVersion,
    "com.vaadin" % "vaadin-server" % vaadinVersion % "provided",
    "javax.servlet" % "servlet-api" % "2.5" % "provided",

    "org.scalatest" %% "scalatest" % "3.0.3" % "test",
    "org.mockito" % "mockito-core" % "2.8.47" % "test"
  )
}