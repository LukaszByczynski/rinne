package org.vaadin.addons.rinne.mixins

import java.util

import com.vaadin.event.MouseEvents
import com.vaadin.ui.AbstractComponent
import org.vaadin.addons.rinne.events.ListenersSet

trait MouseDoubleClickNotifierMixin {
  this: AbstractComponent =>

  lazy val clickListeners = new ListenersSet[MouseEvents.DoubleClickEvent, MouseEvents.DoubleClickListener] {

    override protected def addListener(listener: ListenerLambda): Unit = addClickListener(
      new Listener(listener) with MouseEvents.DoubleClickListener {
        override def doubleClick(event: MouseEvents.DoubleClickEvent): Unit = listener(event)
      }
    )

    override protected def removeListener(listener: MouseEvents.DoubleClickListener): Unit = removeClickListener(listener)

    override protected def listeners: util.Collection[_] = getListeners(classOf[MouseEvents.DoubleClickEvent])
  }

  def addClickListener(listener: MouseEvents.DoubleClickListener): Unit

  def removeClickListener(listener: MouseEvents.DoubleClickListener): Unit
}
