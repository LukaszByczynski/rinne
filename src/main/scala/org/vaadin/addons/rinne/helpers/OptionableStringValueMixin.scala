package org.vaadin.addons.rinne.helpers

import com.vaadin.v7.ui.AbstractField
import org.vaadin.addons.rinne.converters.Converters
import org.vaadin.addons.rinne.mixins.AbstractFieldMixin

trait OptionableStringValueMixin extends AbstractFieldMixin[String] {
  this: AbstractField[String] =>

  setConverter(Converters.optionToString)
}
