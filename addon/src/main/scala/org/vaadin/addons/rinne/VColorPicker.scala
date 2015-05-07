package org.vaadin.addons.rinne

import java.util

import com.vaadin.ui.ColorPicker
import com.vaadin.ui.components.colorpicker.{ColorChangeEvent, ColorChangeListener}
import org.vaadin.addons.rinne.events.ListenersSet
import org.vaadin.addons.rinne.mixins.AbstractComponentMixin

class VColorPicker extends ColorPicker with AbstractComponentMixin {

  lazy val colorChangeListeners = new ListenersSet[ColorChangeEvent, ColorChangeListener] {
    override protected def addListener(listener: ListenerLambda): Unit = addColorChangeListener(
      new Listener(listener) with ColorChangeListener {
        override def colorChanged(event: ColorChangeEvent): Unit = listener(event)
      }
    )

    override protected def removeListener(listener: ColorChangeListener): Unit = removeColorChangeListener(listener)

    override protected def listeners: util.Collection[_] = getListeners(classOf[ColorChangeEvent])
  }
}