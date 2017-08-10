package org.vaadin.addons.rinne.mixins

import java.util

import com.vaadin.v7.data.Container
import com.vaadin.v7.data.Container.PropertySetChangeEvent
import com.vaadin.v7.ui.AbstractLegacyComponent
import org.vaadin.addons.rinne.events.ListenersSet

trait ContainerPropertySetChangeNotifierMixin extends AbstractComponentMixin {
  this: AbstractLegacyComponent with Container.PropertySetChangeNotifier =>

  lazy val propertySetChangeListeners = new ListenersSet[Container.PropertySetChangeEvent, Container.PropertySetChangeListener] {

    override protected def addListener(listener: ListenerLambda): Unit = addPropertySetChangeListener(
      (event: PropertySetChangeEvent) => listener(event)
    )

    override protected def removeListener(listener: Container.PropertySetChangeListener): Unit = removePropertySetChangeListener(listener)

    override protected def listeners: util.Collection[_] = getListeners(classOf[Container.PropertySetChangeEvent])
  }
}
