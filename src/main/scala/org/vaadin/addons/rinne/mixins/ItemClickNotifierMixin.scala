package org.vaadin.addons.rinne.mixins

import java.util

import com.vaadin.v7.event.ItemClickEvent
import com.vaadin.v7.event.ItemClickEvent.{ItemClickListener, ItemClickNotifier}
import com.vaadin.v7.ui.AbstractLegacyComponent
import org.vaadin.addons.rinne.events.ListenersSet

trait ItemClickNotifierMixin {
  this: AbstractLegacyComponent with ItemClickNotifier =>

  lazy val itemClickListeners = new ListenersSet[ItemClickEvent, ItemClickListener] {

    override protected def addListener(listener: ListenerLambda): Unit = ItemClickNotifierMixin.this.addListener(
      (event: ItemClickEvent) => listener(event)
    )

    override protected def removeListener(listener: ItemClickListener): Unit = ItemClickNotifierMixin.this.removeListener(listener)

    override protected def listeners: util.Collection[_] = ItemClickNotifierMixin.this.getListeners(classOf[ItemClickEvent])
  }
}
