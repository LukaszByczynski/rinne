package org.vaadin.addons.rinne.mixins

import org.vaadin.addons.rinne.event.ReadOnlyStatusChangeNotifier
import com.vaadin.data.util.AbstractProperty

trait AbstractPropertyMixin[T] extends AbstractProperty[T] with PropertyMixin[T] with ReadOnlyStatusChangeNotifier[T]