package org.vaadin.addons.rinne

import com.vaadin.ui.RichTextArea
import org.vaadin.addons.rinne.mixins.AbstractFieldMixin

class VRichTextArea extends RichTextArea with AbstractFieldMixin[String] {

  nullRepresentation = ""

  def nullRepresentation = getNullRepresentation

  def nullRepresentation_=(nullRepresentation: String) = {
    require(nullRepresentation != null)
    setNullRepresentation(nullRepresentation)
  }

  def nullSettingAllowed = isNullSettingAllowed

  def nullSettingAllowed_=(nullSettingAllowed: Boolean) = setNullSettingAllowed(nullSettingAllowed)
}
