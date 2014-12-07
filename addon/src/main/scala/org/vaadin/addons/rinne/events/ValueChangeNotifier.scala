package org.vaadin.addons.rinne.events

import com.vaadin.data.Property
import com.vaadin.data.Property.ValueChangeEvent
import com.vaadin.ui.AbstractComponent


trait ValueChangeNotifier extends AbstractComponent with Property.ValueChangeNotifier {

  lazy val valueChangeListeners = new ListenersTrait[ValueChangeEvent, ValueChangeListener] {
    override def listeners = getListeners(classOf[com.vaadin.data.Property.ValueChangeEvent])

    override def addListener(elem: ValueChangeEvent => Unit) = addValueChangeListener(new ValueChangeListener(elem))

    override def removeListener(elem: ValueChangeListener) = removeListener(elem)
  }
}