package org.vaadin.addons.rinne.mixins

import com.vaadin.data.Property.{ReadOnlyStatusChangeEvent, ReadOnlyStatusChangeListener}

trait HideWhenEmptyMixin[T] extends AbstractFieldMixin[T] {

  valueChangeListeners += _visibilityTest()
  _visibilityTest()

  addReadOnlyStatusChangeListener(
    new ReadOnlyStatusChangeListener {
      override def readOnlyStatusChange(event: ReadOnlyStatusChangeEvent) {
        _visibilityTest()
      }
    }
  )

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
          v.isDefined && v.get.toString.size > 0
        case _ =>
          value.toString.size > 0
      }
    }
    else visible = false
  }
}
