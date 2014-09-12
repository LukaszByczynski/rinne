package org.vaadin.addons.rinne.event

import com.vaadin.data.Property
import com.vaadin.ui.AbstractField


trait FieldReadOnlyStatusChangeNotifier[T]
  extends AbstractField[T] with Property.ReadOnlyStatusChangeNotifier {

  lazy val readOnlyStatusChangeListeners = new ListenersTrait[Property.ReadOnlyStatusChangeEvent, ReadOnlyStatusChangeListener] {
    override def listeners = getListeners(classOf[Property.ReadOnlyStatusChangeEvent])

    override def addListener(elem: Property.ReadOnlyStatusChangeEvent => Unit): Unit = {
      addReadOnlyStatusChangeListener(new ReadOnlyStatusChangeListener(elem))
    }

    override def removeListener(elem: ReadOnlyStatusChangeListener): Unit = {
      removeReadOnlyStatusChangeListener(elem)
    }
  }
}