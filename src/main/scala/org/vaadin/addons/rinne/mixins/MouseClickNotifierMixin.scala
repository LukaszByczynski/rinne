package org.vaadin.addons.rinne.mixins

import java.util

import com.vaadin.event.MouseEvents
import com.vaadin.shared.Registration
import com.vaadin.ui.AbstractComponent
import org.vaadin.addons.rinne.events.ListenersSet

trait MouseClickNotifierMixin {
  this: AbstractComponent =>

  lazy val clickListeners = new ListenersSet[MouseEvents.ClickEvent, MouseEvents.ClickListener] {

    override protected def addListener(listener: ListenerLambda): Unit = addClickListener(
      (event: MouseEvents.ClickEvent) => listener(event)
    )

    override protected def removeListener(listener: MouseEvents.ClickListener): Unit = removeClickListener(listener)

    override protected def listeners: util.Collection[_] = getListeners(classOf[MouseEvents.ClickEvent])
  }

  def addClickListener(listener: MouseEvents.ClickListener): Registration

  def removeClickListener(listener: MouseEvents.ClickListener): Unit
}
