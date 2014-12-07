organization in ThisBuild := "org.vaadin.addons"

version in ThisBuild := "0.1.1"

scalaVersion in ThisBuild := "2.11.4"

crossScalaVersions in ThisBuild := Seq("2.10.4", "2.11.4")

name := "rinne-root"

lazy val addon = project in file("addon")

lazy val demo = (project in file("demo"))
  .dependsOn(addon)

lazy val root = (project in file("."))
  .aggregate(addon, demo)
