package org.vaadin.addons.rinne.event

import com.vaadin.data.Property
import com.vaadin.data.util.AbstractProperty

trait ReadOnlyStatusChangeNotifier[T] extends AbstractProperty[T]
with Property.ReadOnlyStatusChangeNotifier with Property.ReadOnlyStatusChangeEvent {

  lazy val readOnlyStatusChangeListeners = new ListenersTrait[Property.ReadOnlyStatusChangeEvent, ReadOnlyStatusChangeListener] {
    override def listeners = getListeners(classOf[Property.ReadOnlyStatusChangeEvent])

    override def addListener(elem: Property.ReadOnlyStatusChangeEvent => Unit) = {
      addReadOnlyStatusChangeListener(new ReadOnlyStatusChangeListener(elem))
    }

    override def removeListener(elem: ReadOnlyStatusChangeListener) = {
      removeReadOnlyStatusChangeListener(elem)
    }
  }
}
