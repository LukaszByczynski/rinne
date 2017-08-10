package org.vaadin.addons.rinne

import com.vaadin.v7.ui.PopupDateField
import org.vaadin.addons.rinne.mixins.DateFieldMixin

class VPopupDateField extends PopupDateField with DateFieldMixin {

  def prompt: Option[String] = Option(getInputPrompt)

  def prompt_=(prompt: Option[String]) {
    setInputPrompt(prompt.orNull)
  }

  def prompt_=(prompt: String) {
    setInputPrompt(prompt)
  }

}
