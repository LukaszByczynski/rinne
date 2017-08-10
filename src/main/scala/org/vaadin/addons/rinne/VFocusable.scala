package org.vaadin.addons.rinne

import com.vaadin.ui.Component.Focusable

class VFocusable(focusable: Focusable) {

  def tabIndex: Int = {
    focusable.getTabIndex
  }

  def tabIndex_=(value: Int): Unit = {
    focusable.setTabIndex(value)
  }

}
