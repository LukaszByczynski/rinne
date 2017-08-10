package org.vaadin.addons.rinne.mixins

import com.vaadin.ui.Component


trait FocusableMixin {
  this: Component.Focusable =>

  def tabIndex: Int = getTabIndex

  def tabIndex_=(tabIndex: Int) { setTabIndex(tabIndex) }
}