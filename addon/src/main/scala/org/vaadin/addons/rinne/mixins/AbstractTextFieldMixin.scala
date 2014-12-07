package org.vaadin.addons.rinne.mixins

import org.vaadin.addons.rinne.events.{BlurNotifier, FocusNotifier}
import com.vaadin.ui.AbstractTextField

trait AbstractTextFieldMixin extends AbstractTextField
with AbstractFieldMixin[String] with BlurNotifier with FocusNotifier {

  nullRepresentation = ""

  def prompt: Option[String] = Option(getInputPrompt)

  def prompt_=(prompt: Option[String]) {
    setInputPrompt(prompt.orNull)
  }

  def prompt_=(prompt: String) {
    setInputPrompt(prompt)
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

  //  lazy val textChangeListeners: ListenersSet[AbstractTextField.TextChangeEvent => Unit] =
  //    new ListenersTrait[AbstractTextField.TextChangeEvent, TextChangeListener] {
  //      override def listeners = p.getListeners(classOf[com.vaadin.event.FieldEvents.TextChangeEvent])
  //
  //      override def addListener(elem: AbstractTextField.TextChangeEvent => Unit) =
  //        p.addTextChangeListener(new TextChangeListener(elem))
  //
  //      override def removeListener(elem: TextChangeListener) = p.removeTextChangeListener(elem)
  //    }
}