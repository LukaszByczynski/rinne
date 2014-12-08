package org.vaadin.addons.rinne

import com.vaadin.ui.ProgressBar
import org.vaadin.addons.rinne.mixins.AbstractFieldMixin

class VProgressBar extends ProgressBar with AbstractFieldMixin[java.lang.Float] {

  def indeterminate: Boolean = isIndeterminate

  def indeterminate_=(indeterminate: Boolean): Unit = setIndeterminate(indeterminate)

}
