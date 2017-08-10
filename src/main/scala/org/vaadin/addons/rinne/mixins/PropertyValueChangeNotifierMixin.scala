package org.vaadin.addons.rinne.mixins

import java.util

import com.vaadin.v7.data.Property
import com.vaadin.v7.data.Property.{ValueChangeEvent, ValueChangeListener}
import com.vaadin.v7.ui.AbstractLegacyComponent
import org.vaadin.addons.rinne.events.ListenersSet

trait PropertyValueChangeNotifierMixin {
  this: AbstractLegacyComponent with Property.ValueChangeNotifier =>

  lazy val valueChangeListeners = new ListenersSet[ValueChangeEvent, ValueChangeListener] {

    override protected def addListener(listener: ListenerLambda): Unit = addValueChangeListener(
      (event: ValueChangeEvent) => listener(event)
    )

    override protected def removeListener(listener: ValueChangeListener): Unit = removeValueChangeListener(listener)

    override protected def listeners: util.Collection[_] = getListeners(classOf[ValueChangeEvent])
  }
}
