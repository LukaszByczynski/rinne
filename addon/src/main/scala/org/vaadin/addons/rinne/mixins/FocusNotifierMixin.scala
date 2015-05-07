package org.vaadin.addons.rinne.mixins

import java.util

import com.vaadin.event.FieldEvents.{FocusListener, FocusEvent, FocusNotifier}
import com.vaadin.ui.AbstractComponent
import org.vaadin.addons.rinne.events.ListenersSet

trait FocusNotifierMixin {
  this: AbstractComponent with FocusNotifier =>

  lazy val focusListeners = new ListenersSet[FocusEvent, FocusListener] {

    override protected def addListener(listener: ListenerLambda): Unit = addFocusListener(
      new Listener(listener) with FocusListener {
        override def focus(focusEvent: FocusEvent): Unit = listener(focusEvent)
      }
    )

    override protected def removeListener(listener: FocusListener): Unit = removeFocusListener(listener)

    override protected def listeners: util.Collection[_] = getListeners(classOf[FocusEvent])
  }
}
