package org.vaadin.addons.rinne.mixins

import com.vaadin.ui.AbstractSelect

trait MultiSelectableMixin extends AbstractSelect {
  def multiSelect: Boolean = isMultiSelect

  def multiSelect_=(multiSelect: Boolean) { setMultiSelect(multiSelect) }
}
