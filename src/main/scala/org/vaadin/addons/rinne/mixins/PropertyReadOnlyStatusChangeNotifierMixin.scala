package org.vaadin.addons.rinne.mixins

import java.util

import com.vaadin.data.Property
import com.vaadin.ui.AbstractComponent
import org.vaadin.addons.rinne.events.ListenersSet

trait PropertyReadOnlyStatusChangeNotifierMixin {
  this: AbstractComponent with Property.ReadOnlyStatusChangeNotifier =>

  lazy val readOnlyStatusChangeListeners = new ListenersSet[Property.ReadOnlyStatusChangeEvent, Property.ReadOnlyStatusChangeListener] {

    override protected def addListener(listener: ListenerLambda): Unit = addReadOnlyStatusChangeListener(
      new Listener(listener) with Property.ReadOnlyStatusChangeListener {
        override def readOnlyStatusChange(event: Property.ReadOnlyStatusChangeEvent): Unit = listener(event)
      }
    )

    override protected def removeListener(listener: Property.ReadOnlyStatusChangeListener): Unit = removeReadOnlyStatusChangeListener(listener)

    override protected def listeners: util.Collection[_] = getListeners(classOf[Property.ReadOnlyStatusChangeEvent])
  }
}
