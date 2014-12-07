package org.vaadin.addons.rinne.events

import com.vaadin.event.LayoutEvents
import com.vaadin.event.LayoutEvents.LayoutClickEvent
import com.vaadin.ui.AbstractComponent

trait LayoutClickNotifierMixin extends AbstractComponent with LayoutEvents.LayoutClickNotifier {

  lazy val layoutClickListeners = new ListenersTrait[LayoutClickEvent, LayoutClickListener] {
    override def listeners = getListeners(classOf[com.vaadin.event.LayoutEvents.LayoutClickEvent])

    override def addListener(elem: LayoutClickEvent => Unit) = addLayoutClickListener(new LayoutClickListener(elem))

    override def removeListener(elem: LayoutClickListener) = removeLayoutClickListener(elem)
  }
}
