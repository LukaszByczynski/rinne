package org.vaadin.addons.rinne.mixins

import org.vaadin.addons.rinne.converters.Converters

trait OptionableStringValueMixin extends AbstractFieldMixin[String] {
  setConverter(Converters.optionToString)
}
