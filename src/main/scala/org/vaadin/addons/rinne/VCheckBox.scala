package org.vaadin.addons.rinne

import java.util

import com.vaadin.event.FieldEvents.{BlurEvent, BlurListener, FocusEvent, FocusListener}
import com.vaadin.v7.ui.CheckBox
import org.vaadin.addons.rinne.events.ListenersSet
import org.vaadin.addons.rinne.mixins.AbstractFieldMixin

class VCheckBox extends CheckBox with AbstractFieldMixin[java.lang.Boolean] {

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

  def value_=(value: Boolean): Unit = {
    setValue(value)
  }

  def boolValue: Boolean = getValue

}