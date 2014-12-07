package org.vaadin.addons.rinne.mixins

import com.vaadin.ui.Panel

trait PanelMixin extends Panel with AbstractSingleComponentContainerMixin with FocusableMixin {

  def scrollLeft: Int = getScrollLeft

  def scrollLeft_=(scrollLeft: Int) {
    setScrollLeft(scrollLeft)
  }

  def scrollTop: Int = getScrollTop

  def scrollTop_=(scrollTop: Int) {
    setScrollTop(scrollTop)
  }

}
