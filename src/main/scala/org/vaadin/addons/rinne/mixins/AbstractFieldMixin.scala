package org.vaadin.addons.rinne.mixins

import com.vaadin.ui.AbstractField

trait AbstractFieldMixin[T] extends AbstractComponentMixin
with PropertyValueChangeNotifierMixin with PropertyReadOnlyStatusChangeNotifierMixin {
  this: AbstractField[T] =>

  def validationVisible: Boolean = isValidationVisible

  def validationVisible_=(isValidationVisible: Boolean): Unit = setValidationVisible(isValidationVisible)

  def conversionError: String = getConversionError

  def conversionError_=(conversionError: String): Unit = setConversionError(conversionError)

  def value: Option[T] = Option(getValue)

  def value_=(v: Option[T]): Unit = setValue(v.getOrElse(null).asInstanceOf[T])

  def value_=(v: T): Unit = setValue(v)
}
