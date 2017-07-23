organization := "org.vaadin.addons"
name := "rinne"
version := "0.6.0"

scalaVersion := "2.12.2"
scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature")
crossScalaVersions := Seq("2.10.5", "2.11.11")

libraryDependencies ++= Dependencies.addon(scalaVersion.value)

vaadinAddOnSettings
