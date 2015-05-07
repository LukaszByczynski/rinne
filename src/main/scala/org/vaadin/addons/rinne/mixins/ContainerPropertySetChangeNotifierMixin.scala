package org.vaadin.addons.rinne.mixins

import java.util

import com.vaadin.data.Container
import com.vaadin.data.Container.{PropertySetChangeEvent, ItemSetChangeEvent}
import com.vaadin.ui.AbstractComponent
import org.vaadin.addons.rinne.events.ListenersSet

trait ContainerPropertySetChangeNotifierMixin {
  this: AbstractComponent with Container.PropertySetChangeNotifier =>

  lazy val propertySetChangeListeners = new ListenersSet[Container.PropertySetChangeEvent, Container.PropertySetChangeListener] {

    override protected def addListener(listener: ListenerLambda): Unit = addPropertySetChangeListener(
      new Listener(listener) with Container.PropertySetChangeListener {
        override def containerPropertySetChange(event: PropertySetChangeEvent): Unit = listener(event)
      }
    )

    override protected def removeListener(listener: Container.PropertySetChangeListener): Unit = removePropertySetChangeListener(listener)

    override protected def listeners: util.Collection[_] = getListeners(classOf[Container.PropertySetChangeEvent])
  }
}
