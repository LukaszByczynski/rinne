package org.vaadin.addons.rinne.helpers

import com.vaadin.data.Property.{ReadOnlyStatusChangeEvent, ReadOnlyStatusChangeListener}
import com.vaadin.ui.AbstractField
import org.vaadin.addons.rinne.mixins.AbstractFieldMixin

trait HideWhenReadOnlyMixin[T] extends AbstractFieldMixin[T] {
  this: AbstractField[T] =>

  readOnlyStatusChangeListeners += (_ => _visibilityTest())
  valueChangeListeners += (_ => _visibilityTest())
  _visibilityTest()

  private def _visibilityTest() {
    visible = !readOnly
  }
}
