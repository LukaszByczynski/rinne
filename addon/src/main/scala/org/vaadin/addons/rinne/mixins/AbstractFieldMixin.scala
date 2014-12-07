package org.vaadin.addons.rinne.mixins

import org.vaadin.addons.rinne.events.ValueChangeNotifier
import com.vaadin.ui.AbstractField

trait AbstractFieldMixin[T] extends AbstractField[T]
with FieldMixin[T] with AbstractComponentMixin with ValueChangeNotifier {

  def validationVisible: Boolean = isValidationVisible

  def validationVisible_=(isValidationVisible: Boolean): Unit = setValidationVisible(isValidationVisible)

  def conversionError: String = getConversionError

  def conversionError_=(conversionError: String): Unit = setConversionError(conversionError)

  //  override def value: Option[T] = Option(getValue)

}
