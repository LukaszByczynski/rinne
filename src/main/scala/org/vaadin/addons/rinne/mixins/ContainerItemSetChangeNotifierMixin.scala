package org.vaadin.addons.rinne.mixins

import java.util

import com.vaadin.v7.data.Container
import com.vaadin.v7.data.Container.ItemSetChangeEvent
import com.vaadin.v7.ui.AbstractLegacyComponent
import org.vaadin.addons.rinne.events.ListenersSet

trait ContainerItemSetChangeNotifierMixin {
  this: AbstractLegacyComponent with Container.ItemSetChangeNotifier =>

  lazy val itemSetChangeListeners = new ListenersSet[Container.ItemSetChangeEvent, Container.ItemSetChangeListener] {

    override protected def addListener(listener: ListenerLambda): Unit = addItemSetChangeListener(
      (event: ItemSetChangeEvent) => listener(event)
    )

    override protected def removeListener(listener: Container.ItemSetChangeListener): Unit = removeItemSetChangeListener(listener)

    override protected def listeners: util.Collection[_] = getListeners(classOf[Container.ItemSetChangeEvent])
  }
}
