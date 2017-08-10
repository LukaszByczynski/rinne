package org.vaadin.addons.rinne.mixins

import com.vaadin.v7.data.Property.ReadOnlyStatusChangeNotifier
import com.vaadin.v7.data.util.AbstractProperty

trait AbstractPropertyMixin[T] extends PropertyMixin[T] with ReadOnlyStatusChangeNotifier {
  this: AbstractProperty[T] =>
}