organization in ThisBuild := "org.vaadin.addons"

version in ThisBuild := "0.5.0-SNAPSHOT"

scalaVersion in ThisBuild := "2.11.6"

crossScalaVersions in ThisBuild := Seq("2.10.5", "2.11.6")

name := "rinne-root"

lazy val addon = project in file("addon")

lazy val demo = (project in file("demo"))
  .dependsOn(addon)

lazy val root = (project in file("."))
  .aggregate(addon, demo)
