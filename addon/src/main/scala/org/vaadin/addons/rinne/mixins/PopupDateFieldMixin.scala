package org.vaadin.addons.rinne.mixins

import org.vaadin.addons.rinne.converters.Converters
import com.vaadin.ui.PopupDateField

trait PopupDateFieldMixin extends PopupDateField with DateFieldMixin {

  def prompt: Option[String] = Option(getInputPrompt)

  def prompt_=(prompt: Option[String]) {
    setInputPrompt(prompt.orNull)
  }

  def prompt_=(prompt: String) {
    setInputPrompt(prompt)
  }

}
