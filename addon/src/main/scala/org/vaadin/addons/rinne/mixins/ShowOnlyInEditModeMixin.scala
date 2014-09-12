package org.vaadin.addons.rinne.mixins

import com.vaadin.data.Property.{ReadOnlyStatusChangeEvent, ReadOnlyStatusChangeListener}

trait ShowOnlyInEditModeMixin[T] extends AbstractFieldMixin[T] {

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
    visible = !readOnly
  }
}
