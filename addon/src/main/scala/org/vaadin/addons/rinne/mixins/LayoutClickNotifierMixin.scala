package org.vaadin.addons.rinne.mixins

import java.util

import com.vaadin.event.FieldEvents.{BlurEvent, BlurListener, BlurNotifier}
import com.vaadin.event.LayoutEvents.{LayoutClickEvent, LayoutClickListener, LayoutClickNotifier}
import com.vaadin.ui.AbstractComponent
import org.vaadin.addons.rinne.events._

trait LayoutClickNotifierMixin {
  this: AbstractComponent with LayoutClickNotifier =>

  lazy val layoutClickListeners = new ListenersSet[LayoutClickEvent, LayoutClickListener] {

    override protected def addListener(listener: ListenerLambda): Unit = addLayoutClickListener(
      new Listener(listener) with LayoutClickListener {
        override def layoutClick(layoutClickEvent: LayoutClickEvent): Unit = listener(layoutClickEvent)
      }
    )

    override protected def removeListener(listener: LayoutClickListener): Unit = removeLayoutClickListener(listener)

    override protected def listeners: util.Collection[_] = getListeners(classOf[LayoutClickEvent])
  }
}
