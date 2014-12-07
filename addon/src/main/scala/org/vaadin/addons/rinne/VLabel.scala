package org.vaadin.addons.rinne

import com.vaadin.data.util.converter.Converter
import com.vaadin.shared.ui.label.ContentMode
import com.vaadin.ui.Label
import org.vaadin.addons.rinne.mixins.{AbstractComponentMixin, PropertyMixin}

class VLabel extends Label with AbstractComponentMixin with PropertyMixin[String] {

  def contentMode: ContentMode = getContentMode

  def contentMode_=(contentMode: ContentMode) {
    setContentMode(contentMode)
  }

  def converter: Option[Converter[String, _]] = Option(getConverter)

  def converter_=(converter: Converter[String, _]) {
    setConverter(converter)
  }
}