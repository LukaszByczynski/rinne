package org.vaadin.addons.rinne.mixins

import java.util

import com.vaadin.event.FieldEvents.{FocusEvent, FocusListener, FocusNotifier}
import com.vaadin.ui.AbstractComponent
import org.vaadin.addons.rinne.events.ListenersSet

trait FocusNotifierMixin extends AbstractComponentMixin with FocusNotifier {
  this: AbstractComponent =>

  lazy val focusListeners = new ListenersSet[FocusEvent, FocusListener] {

    override protected def addListener(listener: ListenerLambda): Unit = addFocusListener(
      (focusEvent: FocusEvent) => listener(focusEvent)
    )

    override protected def removeListener(listener: FocusListener): Unit = removeListener(listener)

    override protected def listeners: util.Collection[_] = getListeners(classOf[FocusEvent])
  }
}
