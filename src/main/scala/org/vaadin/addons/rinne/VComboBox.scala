package org.vaadin.addons.rinne

import java.util

import com.vaadin.event.FieldEvents.{BlurEvent, BlurListener, FocusEvent, FocusListener}
import com.vaadin.v7.shared.ui.combobox.FilteringMode
import com.vaadin.v7.ui.ComboBox
import org.vaadin.addons.rinne.events.ListenersSet
import org.vaadin.addons.rinne.mixins.AbstractSelectMixin

class VComboBox extends ComboBox with AbstractSelectMixin {

  lazy val focusListeners = new ListenersSet[FocusEvent, FocusListener] {

    override protected def addListener(listener: ListenerLambda): Unit = addFocusListener(
      (focusEvent: FocusEvent) => listener(focusEvent)
    )

    override protected def removeListener(listener: FocusListener): Unit = removeListener(listener)

    override protected def listeners: util.Collection[_] = getListeners(classOf[FocusEvent])
  }

  lazy val blurListeners = new ListenersSet[BlurEvent, BlurListener] {

    override protected def addListener(listener: ListenerLambda): Unit = addBlurListener(
      (blurEvent: BlurEvent) => listener(blurEvent)
    )

    override protected def removeListener(listener: BlurListener): Unit = removeListener(listener)

    override protected def listeners: java.util.Collection[_] = getListeners(classOf[BlurEvent])
  }

  def inputPrompt: Option[String] = Option(getInputPrompt)

  def inputPrompt_=(inputPrompt: String) {
    setInputPrompt(inputPrompt)
  }

  def inputPrompt_=(inputPrompt: Option[String]) {
    setInputPrompt(inputPrompt.orNull)
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
