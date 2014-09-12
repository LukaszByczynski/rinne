package org.vaadin.addons.rinne.mixins

import com.vaadin.data.BufferedValidatable
import com.vaadin.ui.{Field, Component}

trait FieldMixin[T] extends Field[T]
with ComponentMixin with PropertyMixin[T] with BufferedValidatable with Component.Focusable {

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
