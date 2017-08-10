lazy val bizbeamResolver = {
  Resolver.sftp("bizbeam", "test.bizbeam.com", "repository")(
    Patterns(
      Nil, Resolver.mavenStyleBasePattern :: Nil, isMavenCompatible = true, descriptorOptional = true,
      skipConsistencyCheck = true
    )
  ) as("ismdev", Path.userHome / ".ssh" / "id_bizbeam_rsa")
}

organization := "org.vaadin.addons"
name := "rinne"
version := "0.8.3"

scalaVersion in ThisBuild := "2.12.3"
scalacOptions ++= Seq("-unchecked", "-feature", "-Yrangepos")
parallelExecution := false

publishTo := Some(bizbeamResolver)

libraryDependencies ++= {

  val vaadinVersion = "8.1.0"

  Seq(
    "org.scala-lang" % "scala-reflect" % scalaVersion.value,
    "com.vaadin" % "vaadin-server" % vaadinVersion % "provided",
    "com.vaadin" % "vaadin-compatibility-server" % vaadinVersion % "provided",
    "javax.servlet" % "servlet-api" % "2.5" % "provided",

    "org.scalatest" %% "scalatest" % "3.0.3" % "test",
    "org.specs2" %% "specs2-core" % "3.9.1" % "test",

    "org.mockito" % "mockito-core" % "2.8.47" % "test"
  )
}

vaadinAddOnSettings
