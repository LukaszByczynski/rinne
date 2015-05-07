package org.vaadin.addons.rinne.mixins

import java.util

import com.vaadin.data.Property
import com.vaadin.data.Property.{ValueChangeListener, ValueChangeEvent}
import com.vaadin.ui.AbstractComponent
import org.vaadin.addons.rinne.events.ListenersSet

trait PropertyValueChangeNotifierMixin {
  this: AbstractComponent with Property.ValueChangeNotifier =>

  lazy val valueChangeListeners = new ListenersSet[ValueChangeEvent, ValueChangeListener] {

    override protected def addListener(listener: ListenerLambda): Unit = addValueChangeListener(
      new Listener(listener) with ValueChangeListener {
        override def valueChange(event: ValueChangeEvent): Unit = listener(event)
      }
    )

    override protected def removeListener(listener: ValueChangeListener): Unit = removeValueChangeListener(listener)

    override protected def listeners: util.Collection[_] = getListeners(classOf[ValueChangeEvent])
  }
}
