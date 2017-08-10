package org.vaadin.addons.rinne.mixins


import com.vaadin.ui.Component.Focusable
import com.vaadin.v7.data.BufferedValidatable
import com.vaadin.v7.ui.Field

trait FieldMixin[T] extends Field[T]
  with ComponentMixin with PropertyMixin[T] with BufferedValidatable with Focusable {

  def required: Boolean = isRequired

  def required_=(required: Boolean) {
    setRequired(required)
  }

  def requiredError: Option[String] = Option(getRequiredError)

  def requiredError_=(requiredError: String) {
    setRequiredError(requiredError)
  }

  def requiredError_=(requiredError: Option[String]) {
    setRequiredError(requiredError.orNull)
  }
}
