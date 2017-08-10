package org.vaadin.addons.rinne

import com.vaadin.v7.data.util.converter.Converter
import com.vaadin.v7.shared.ui.label.ContentMode
import com.vaadin.v7.ui.Label
import org.vaadin.addons.rinne.mixins.{AbstractComponentMixin, PropertyMixin, PropertyValueChangeNotifierMixin, PropertyViewerMixin}

class VLabel extends Label with AbstractComponentMixin
with PropertyMixin[String] with PropertyValueChangeNotifierMixin with PropertyViewerMixin {

  def contentMode: ContentMode = getContentMode

  def contentMode_=(contentMode: ContentMode) {
    setContentMode(contentMode)
  }

  def converter: Option[Converter[String, _]] = Option(getConverter)

  def converter_=(converter: Option[Converter[String, _]]) {
    setConverter(converter.orNull)
  }

  def converter_=(converter: Converter[String, _]) {
    setConverter(converter)
  }
}