import sbt._

object Dependencies {

  private val vaadinVersion = "7.3.6"
  private val jettyVersion = "7.3.0.v20110203"

  private val vaadinClientCompiled = "com.vaadin" % "vaadin-client-compiled" % vaadinVersion
  private val vaadinThemes = "com.vaadin" % "vaadin-themes" % vaadinVersion
  private val vaadin = "com.vaadin" % "vaadin-server" % vaadinVersion % "provided"
  private val servletApi = "javax.servlet" % "servlet-api" % "2.4" % "provided"
  private val jetty = "org.eclipse.jetty" % "jetty-webapp" % jettyVersion % "container"

  val addon = Seq(
    vaadin,
    servletApi
  )

  val demo = Seq(
    vaadin,
    vaadinClientCompiled,
    vaadinThemes,
    jetty
  )

}