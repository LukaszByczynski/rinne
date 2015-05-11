package org.vaadin.addons.rinne.mixins

import com.vaadin.ui.Panel

trait PanelMixin extends AbstractSingleComponentContainerMixin with FocusableMixin with MouseClickNotifierMixin {
  this: Panel =>

  def scrollLeft: Int = getScrollLeft

  def scrollLeft_=(scrollLeft: Int) {
    setScrollLeft(scrollLeft)
  }

  def scrollTop: Int = getScrollTop

  def scrollTop_=(scrollTop: Int) {
    setScrollTop(scrollTop)
  }

}
