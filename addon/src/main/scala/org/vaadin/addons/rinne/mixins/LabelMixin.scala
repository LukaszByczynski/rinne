package org.vaadin.addons.rinne.mixins

import com.vaadin.data.util.converter.Converter
import com.vaadin.shared.ui.label.ContentMode
import com.vaadin.ui.Label

trait LabelMixin extends Label with AbstractComponentMixin with PropertyMixin[String] {

  def contentMode: ContentMode = getContentMode

  def contentMode_=(contentMode: ContentMode) {
    setContentMode(contentMode)
  }

  def converter: Option[Converter[String, _]] = Option(getConverter)

  def converter_=(converter: Converter[String, _]) {
    setConverter(converter)
  }
}