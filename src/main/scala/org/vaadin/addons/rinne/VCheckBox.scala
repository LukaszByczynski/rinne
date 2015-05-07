package org.vaadin.addons.rinne

import com.vaadin.event.FieldEvents.{BlurNotifier, FocusNotifier}
import com.vaadin.ui.CheckBox
import org.vaadin.addons.rinne.mixins.{AbstractFieldMixin, BlurNotifierMixin, FocusNotifierMixin}

class VCheckBox extends CheckBox
with AbstractFieldMixin[java.lang.Boolean] with BlurNotifierMixin with BlurNotifier with FocusNotifierMixin with FocusNotifier {

  def value_=(value: Boolean): Unit = {
    setValue(value)
  }

  def boolValue: Boolean = getValue

}