package org.vaadin.addons.rinne.mixins

import com.vaadin.data.Property

trait PropertyMixin[T] extends Property[T] {

  def value: Option[T] = Option(getValue)

  def value_=(value: Option[T]): Unit = value_=(value.getOrElse(null).asInstanceOf[T])

  def value_=(value: T): Unit = setValue(value.asInstanceOf[T])

}