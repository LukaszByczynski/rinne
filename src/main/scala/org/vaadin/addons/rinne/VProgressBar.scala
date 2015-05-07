package org.vaadin.addons.rinne

import com.vaadin.ui.ProgressBar
import org.vaadin.addons.rinne.mixins.{PropertyValueChangeNotifierMixin, PropertyViewerMixin, AbstractFieldMixin}

class VProgressBar extends ProgressBar with AbstractFieldMixin[java.lang.Float]
with PropertyViewerMixin with PropertyValueChangeNotifierMixin {

  def indeterminate: Boolean = isIndeterminate

  def indeterminate_=(indeterminate: Boolean): Unit = setIndeterminate(indeterminate)

}
