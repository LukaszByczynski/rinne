package org.vaadin.addons.rinne

import com.vaadin.ui.CheckBox
import org.vaadin.addons.rinne.mixins.AbstractFieldMixin

class VCheckBox extends CheckBox with AbstractFieldMixin[java.lang.Boolean] {

  def value_=(value: Boolean) {
    setValue(value)
  }

  def boolValue: Boolean = getValue
}