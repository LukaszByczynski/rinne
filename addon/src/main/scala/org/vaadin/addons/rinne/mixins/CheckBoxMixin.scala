package org.vaadin.addons.rinne.mixins

trait CheckBoxMixin extends AbstractFieldMixin[java.lang.Boolean] {

  def value_=(value: Boolean) {
    setValue(value)
  }

  def boolValue: Boolean = getValue
}