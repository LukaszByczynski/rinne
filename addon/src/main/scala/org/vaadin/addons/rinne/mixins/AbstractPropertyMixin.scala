package org.vaadin.addons.rinne.mixins

import com.vaadin.data.Property.ReadOnlyStatusChangeNotifier
import com.vaadin.data.util.AbstractProperty

trait AbstractPropertyMixin[T] extends PropertyMixin[T] with ReadOnlyStatusChangeNotifier {
  this: AbstractProperty[T] =>
}