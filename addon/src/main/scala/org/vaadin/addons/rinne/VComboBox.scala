package org.vaadin.addons.rinne

import com.vaadin.shared.ui.combobox.FilteringMode
import com.vaadin.ui.ComboBox
import org.vaadin.addons.rinne.mixins.{ContainerMixin, ComponentMixin, AbstractSelectMixin}

class VComboBox extends ComboBox with AbstractSelectMixin with ContainerMixin {

  def inputPrompt: Option[String] = Option(getInputPrompt)

  def inputPrompt_=(inputPrompt: Option[String]) {
    setInputPrompt(inputPrompt.orNull)
  }

  def inputPrompt_=(inputPrompt: String) {
    setInputPrompt(inputPrompt)
  }

  def textInputAllowed: Boolean = isTextInputAllowed

  def textInputAllowed_=(textInputAllowed: Boolean) {
    setTextInputAllowed(textInputAllowed)
  }

  def filteringMode: FilteringMode = getFilteringMode

  def filteringMode_=(filteringMode: FilteringMode) {
    setFilteringMode(filteringMode)
  }

  def scrollToSelectedItem: Boolean = isScrollToSelectedItem

  def scrollToSelectedItem_=(scrollToSelectedItem: Boolean) {
    setScrollToSelectedItem(scrollToSelectedItem)
  }

  def addItemWithCaption(itemId: Object, caption: String) = {
    addItem(itemId)
    setItemCaption(itemId, caption)
  }
}
