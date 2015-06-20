organization := "org.vaadin.addons"
name := "rinne"
version := "0.5.0"

scalaVersion := "2.11.6"
scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature")
crossScalaVersions := Seq("2.10.5", "2.11.6")

libraryDependencies ++= Dependencies.addon(scalaVersion.value)

vaadinAddOnSettings
