package org.vaadin.addons.rinne

import com.vaadin.ui.OptionGroup
import org.vaadin.addons.rinne.events.{BlurNotifier, FocusNotifier}
import org.vaadin.addons.rinne.mixins.{AbstractSelectMixin, MultiSelectableMixin}

class VOptionGroup extends OptionGroup
with AbstractSelectMixin with MultiSelectableMixin with BlurNotifier with FocusNotifier {

  def htmlContentAllowed: Boolean = isHtmlContentAllowed

  def htmlContentAllowed_=(htmlContentAllowed: Boolean): Unit = setHtmlContentAllowed(htmlContentAllowed)
}