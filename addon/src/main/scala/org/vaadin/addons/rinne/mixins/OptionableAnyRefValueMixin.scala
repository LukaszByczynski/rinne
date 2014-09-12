package org.vaadin.addons.rinne.mixins

import org.vaadin.addons.rinne.converters.Converters

trait OptionableAnyRefValueMixin extends AbstractFieldMixin[AnyRef] {
  setConverter(Converters.optionToAny)
}
