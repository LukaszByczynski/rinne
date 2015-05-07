organization := "org.vaadin.addons"
name := "rinne"
version := "0.5.0-SNAPSHOT"

scalaVersion := "2.11.6"
crossScalaVersions := Seq("2.10.5", "2.11.6")

libraryDependencies ++= Dependencies.addon(scalaVersion.value)

vaadinAddOnSettings
