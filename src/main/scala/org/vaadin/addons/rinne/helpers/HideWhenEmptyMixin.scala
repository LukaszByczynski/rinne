package org.vaadin.addons.rinne.helpers

import com.vaadin.v7.data.Property.{ReadOnlyStatusChangeEvent, ReadOnlyStatusChangeListener}
import com.vaadin.v7.ui.AbstractField
import org.vaadin.addons.rinne.mixins.AbstractFieldMixin

trait HideWhenEmptyMixin[T] extends AbstractFieldMixin[T] {
  this: AbstractField[T] =>

  readOnlyStatusChangeListeners += (_ => _visibilityTest())
  valueChangeListeners += (_ => _visibilityTest())
  _visibilityTest()

  private def _visibilityTest() {
    if (!readOnly) {
      // edit mode -> visible always
      visible = true
    }
    else if (value.isDefined) {
      visible = value.get match {
        case v: String =>
          v.size > 0
        case v: Option[_] =>
          v.isDefined && v.get.toString.length > 0
        case _ =>
          value.toString.length > 0
      }
    }
    else visible = false
  }
}
