package org.vaadin.addons.rinne.mixins

import com.vaadin.ui.Component

trait FocusableMixin extends Component.Focusable with ComponentMixin {

  def tabIndex: Int = getTabIndex

  def tabIndex_=(tabIndex: Int) { setTabIndex(tabIndex) }
}