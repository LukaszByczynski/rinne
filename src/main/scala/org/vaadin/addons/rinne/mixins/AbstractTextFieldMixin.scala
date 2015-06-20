package org.vaadin.addons.rinne.mixins

import java.util

import com.vaadin.event.FieldEvents.{TextChangeEvent, TextChangeListener}
import com.vaadin.ui.AbstractTextField
import org.vaadin.addons.rinne.events.ListenersSet

trait AbstractTextFieldMixin extends AbstractFieldMixin[String] with BlurNotifierMixin with FocusNotifierMixin {
  this: AbstractTextField =>

  nullRepresentation = ""

  lazy val textChangeListeners = new ListenersSet[TextChangeEvent, TextChangeListener] {

    override protected def addListener(listener: ListenerLambda): Unit = addTextChangeListener(
      new Listener(listener) with TextChangeListener {
        override def textChange(event: TextChangeEvent): Unit = listener(event)
      }
    )

    override protected def removeListener(listener: TextChangeListener): Unit = removeTextChangeListener(listener)

    override protected def listeners: util.Collection[_] = getListeners(classOf[TextChangeEvent])
  }

  def prompt: Option[String] = Option(getInputPrompt)

  def prompt_=(prompt: String) {
    setInputPrompt(prompt)
  }

  def prompt_=(prompt: Option[String]) {
    setInputPrompt(prompt.orNull)
  }

  def nullRepresentation: String = getNullRepresentation

  def nullRepresentation_=(nullRepresentation: String) {
    setNullRepresentation(nullRepresentation)
  }

  def nullSettingAllowed: Boolean = isNullSettingAllowed

  def nullSettingAllowed_=(nullSettingAllowed: Boolean) {
    setNullSettingAllowed(nullSettingAllowed)
  }

  def maxLength: Int = getMaxLength

  def maxLength_=(maxLength: Int) {
    setMaxLength(maxLength)
  }

  def columns: Int = getColumns

  def columns_=(columns: Int) {
    setColumns(columns)
  }

  def cursorPosition: Int = getCursorPosition

  def cursorPosition_=(cursorPosition: Int) {
    setCursorPosition(cursorPosition)
  }

  def textChangeEventMode = getTextChangeEventMode

  def textChangeEventMode_=(textChangeEventMode: AbstractTextField.TextChangeEventMode) {
    setTextChangeEventMode(textChangeEventMode)
  }

  def textChangeTimeout = getTextChangeTimeout

  def textChangeTimeout_=(textChangeTimeout: Int) = setTextChangeTimeout(textChangeTimeout)
}