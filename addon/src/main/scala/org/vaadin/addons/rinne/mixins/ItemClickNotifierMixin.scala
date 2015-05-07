package org.vaadin.addons.rinne.mixins

import java.util

import com.vaadin.event.ItemClickEvent
import com.vaadin.event.ItemClickEvent.{ItemClickListener, ItemClickNotifier}
import com.vaadin.ui.AbstractComponent
import org.vaadin.addons.rinne.events.ListenersSet

trait ItemClickNotifierMixin {
  this: AbstractComponent with ItemClickNotifier =>

  lazy val itemClickListeners = new ListenersSet[ItemClickEvent, ItemClickListener] {

    override protected def addListener(listener: ListenerLambda): Unit = addItemClickListener(
      new Listener(listener) with ItemClickListener {
        override def itemClick(event: ItemClickEvent): Unit = listener(event)
      }
    )

    override protected def removeListener(listener: ItemClickListener): Unit = removeItemClickListener(listener)

    override protected def listeners: util.Collection[_] = getListeners(classOf[ItemClickEvent])
  }
}
