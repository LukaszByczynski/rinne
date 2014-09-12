package org.vaadin.addons.rinne.mixins

import com.vaadin.ui.RichTextArea

trait RichTextAreaMixin extends RichTextArea with AbstractFieldMixin[String] {

  nullRepresentation = ""

  def nullRepresentation = getNullRepresentation

  def nullRepresentation_=(nullRepresentation: String) = {
    require(nullRepresentation != null)
    setNullRepresentation(nullRepresentation)
  }

  def nullSettingAllowed = isNullSettingAllowed

  def nullSettingAllowed_=(nullSettingAllowed: Boolean) = setNullSettingAllowed(nullSettingAllowed)
}
