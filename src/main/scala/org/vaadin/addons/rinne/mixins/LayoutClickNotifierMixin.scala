package org.vaadin.addons.rinne.mixins

import java.util

import com.vaadin.event.LayoutEvents.{LayoutClickEvent, LayoutClickListener, LayoutClickNotifier}
import com.vaadin.ui.AbstractComponent
import org.vaadin.addons.rinne.events.ListenersSet

trait LayoutClickNotifierMixin {
  this: AbstractComponent with LayoutClickNotifier =>

  lazy val layoutClickListeners = new ListenersSet[LayoutClickEvent, LayoutClickListener] {

    override protected def addListener(listener: ListenerLambda): Unit = addLayoutClickListener(
      (layoutClickEvent: LayoutClickEvent) => listener(layoutClickEvent)
    )

    override protected def removeListener(listener: LayoutClickListener): Unit = removeLayoutClickListener(listener)

    override protected def listeners: util.Collection[_] = getListeners(classOf[LayoutClickEvent])
  }
}
