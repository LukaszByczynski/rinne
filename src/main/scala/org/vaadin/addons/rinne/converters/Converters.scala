package org.vaadin.addons.rinne.converters

import java.util.Locale

import com.vaadin.data.util.converter.Converter

object Converters {

  lazy val anyToOption = new Converter[Object, Object] {
    override def getModelType: Class[Object] = classOf[Object]

    override def getPresentationType: Class[Object] = classOf[Object]

    override def convertToModel(value: Object, targetType: Class[_ <: Object], locale: Locale) = {
      value match {
        case Some(v) => v.asInstanceOf[Object]
        case _ => value
      }
    }

    override def convertToPresentation(value: Object, targetType: Class[_ <: Object], locale: Locale) = {
      value match {
        case Option => value
        case _ => Option(value)
      }
    }
  }

  lazy val optionToAny = new Converter[Object, Option[Object]] {
    override def getPresentationType: Class[Object] = classOf[Object]

    override def getModelType: Class[Option[Object]] = classOf[Option[Object]]

    override def convertToPresentation(value: Option[Object], targetType: Class[_ <: Object], locale: Locale) = {
      value.orNull
    }

    override def convertToModel(value: Object, targetType: Class[_ <: Option[Object]], locale: Locale) = Option(value)
  }

  lazy val optionToString = new Converter[String, Option[String]] {
    override def getPresentationType = classOf[String]

    override def getModelType = classOf[Option[String]]

    override def convertToPresentation(value: Option[String], targetType: Class[_ <: String], locale: Locale) = {
      value.orNull
    }

    override def convertToModel(value: String, targetType: Class[_ <: Option[String]], locale: Locale) = {
      Option(value)
    }
  }

}
