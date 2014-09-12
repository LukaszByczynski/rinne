name := "rinne-root"

organization in ThisBuild := "org.vaadin.addons"

version in ThisBuild := "0.1.0"

scalaVersion in ThisBuild := "2.11.2"

lazy val addon = project in file("addon")

lazy val demo = (project in file("demo")).dependsOn(addon)

lazy val root = (project in file("."))
  .aggregate(addon, demo)
