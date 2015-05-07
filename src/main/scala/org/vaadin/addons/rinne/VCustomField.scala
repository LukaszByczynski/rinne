package org.vaadin.addons.rinne

import com.vaadin.ui.CustomField
import org.vaadin.addons.rinne.mixins.AbstractFieldMixin

import scala.reflect._

abstract class VCustomField[T: ClassTag] extends CustomField[T] with AbstractFieldMixin[T] {
  private val _type = classTag[T].runtimeClass.asInstanceOf[Class[_ <: T]]

  override def getType: Class[_ <: T] = _type
}