package org.vaadin.addons.rinne

import com.vaadin.data.{HasValue, Validator}
import com.vaadin.shared.Registration
import org.vaadin.addons.rinne.v8.internal.ListenersSet

class VHasValue[T](hasValue: HasValue[T]) {

  lazy val valueChangeListeners = new ListenersSet[HasValue.ValueChangeEvent[T], HasValue.ValueChangeListener[T]] {
    override protected def addListener(listener: HasValue.ValueChangeListener[T]): Registration = {
      hasValue.addValueChangeListener(listener)
    }

    override protected def createListener(action: => Unit): HasValue.ValueChangeListener[T] = {
      (_: HasValue.ValueChangeEvent[T]) => action
    }
  }

  def value: Option[T] = {
    Option(hasValue.getValue)
  }

  def value_=(value: T): Unit = {
    hasValue.setValue(value)
  }

  def empty: Boolean = {
    hasValue.isEmpty
  }

  def emptyValue: T = {
    hasValue.getEmptyValue
  }

  def readOnly: Boolean = {
    hasValue.isReadOnly
  }

  def readOnly_=(value: Boolean): Unit = {
    hasValue.setReadOnly(value)
  }

  def requiredIndicatorVisible: Boolean = {
    hasValue.isRequiredIndicatorVisible
  }

  def requiredIndicatorVisible_=(value: Boolean): Unit = {
    hasValue.setRequiredIndicatorVisible(value)
  }

  def defaultValidator: Validator[T] = {
    hasValue.getDefaultValidator
  }

}
