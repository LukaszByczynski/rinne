package org.vaadin.addons.rinne.mixins

import java.util

import com.vaadin.v7.data.Property
import com.vaadin.v7.ui.AbstractLegacyComponent
import org.vaadin.addons.rinne.events.ListenersSet

trait PropertyReadOnlyStatusChangeNotifierMixin {
  this: AbstractLegacyComponent with Property.ReadOnlyStatusChangeNotifier =>

  lazy val readOnlyStatusChangeListeners = new ListenersSet[Property.ReadOnlyStatusChangeEvent, Property.ReadOnlyStatusChangeListener] {

    override protected def addListener(listener: ListenerLambda): Unit = addReadOnlyStatusChangeListener(
      (event: Property.ReadOnlyStatusChangeEvent) => listener(event)
    )

    override protected def removeListener(listener: Property.ReadOnlyStatusChangeListener): Unit = removeReadOnlyStatusChangeListener(listener)

    override protected def listeners: util.Collection[_] = getListeners(classOf[Property.ReadOnlyStatusChangeEvent])
  }
}
