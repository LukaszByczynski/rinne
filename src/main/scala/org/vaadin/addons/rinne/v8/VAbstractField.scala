package org.vaadin.addons.rinne.v8

import com.vaadin.data.HasValue
import com.vaadin.shared.Registration
import com.vaadin.ui.AbstractField
import org.vaadin.addons.rinne.v8.internal.ListenersSet

class VAbstractField[T](field: AbstractField[T]) {

  def value: T = field.getValue

  def value_=(value: T): Unit = field.setValue(value)

  def readOnly: Boolean = field.isReadOnly

  def readOnly_=(value: Boolean): Unit = field.setReadOnly(value)

  def emptyValue: T = field.getEmptyValue

  def tabIndex: Int = field.getTabIndex

  //    def tabIndex_=(value: Int): Unit = set

  lazy val valueChangeListeners = new ListenersSet[HasValue.ValueChangeEvent[T], HasValue.ValueChangeListener[T]] {
    override protected def addListener(listener: HasValue.ValueChangeListener[T]): Registration = {
      field.addValueChangeListener(listener)
    }

    override protected def createListener(action: => Unit): HasValue.ValueChangeListener[T] = {
      (_: HasValue.ValueChangeEvent[T]) => action
    }
  }
}