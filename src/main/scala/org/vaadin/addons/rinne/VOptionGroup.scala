package org.vaadin.addons.rinne

import com.vaadin.ui.OptionGroup
import org.vaadin.addons.rinne.mixins.{FocusNotifierMixin, BlurNotifierMixin, AbstractSelectMixin}

class VOptionGroup extends OptionGroup with AbstractSelectMixin with BlurNotifierMixin with FocusNotifierMixin {

  def htmlContentAllowed: Boolean = isHtmlContentAllowed

  def htmlContentAllowed_=(htmlContentAllowed: Boolean): Unit = setHtmlContentAllowed(htmlContentAllowed)
}