package org.vaadin.addons.rinne.mixins

import com.vaadin.v7.ui.AbstractField

trait AbstractFieldMixin[T] extends AbstractComponentMixin
with PropertyValueChangeNotifierMixin with PropertyReadOnlyStatusChangeNotifierMixin {
  this: AbstractField[T] =>

  def immediate: Boolean = isImmediate

  def immediate_=(immediate: Boolean): Unit = setImmediate(immediate)

  def readOnly: Boolean = isReadOnly

  def readOnly_=(readOnly: Boolean) {
    setReadOnly(readOnly)
  }

  def conversionError: String = getConversionError

  def conversionError_=(conversionError: String): Unit = setConversionError(conversionError)

  def value: Option[T] = Option(getValue)

  def value_=(v: Option[T]): Unit = setValue(v.getOrElse(null).asInstanceOf[T])

  def value_=(v: T): Unit = setValue(v)
}
