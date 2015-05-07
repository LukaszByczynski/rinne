package org.vaadin.addons.rinne.mixins

import java.util

import com.vaadin.data.Container.ItemSetChangeEvent
import com.vaadin.data.{Container, Property}
import com.vaadin.data.Property.{ValueChangeEvent, ValueChangeListener}
import com.vaadin.ui.AbstractComponent
import org.vaadin.addons.rinne.events.ListenersSet

trait ContainerItemSetChangeNotifierMixin2 {
  this: AbstractComponent with Container.ItemSetChangeNotifier =>

  lazy val itemSetChangeListeners = new ListenersSet[Container.ItemSetChangeEvent, Container.ItemSetChangeListener] {

    override protected def addListener(listener: ListenerLambda): Unit = addItemSetChangeListener(
      new Listener(listener) with Container.ItemSetChangeListener {
        override def containerItemSetChange(event: ItemSetChangeEvent): Unit = listener(event)
      }
    )

    override protected def removeListener(listener: Container.ItemSetChangeListener): Unit = removeItemSetChangeListener(listener)

    override protected def listeners: util.Collection[_] = getListeners(classOf[Container.ItemSetChangeEvent])
  }
}
