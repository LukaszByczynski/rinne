package org.vaadin.addons.rinne.mixins

import com.vaadin.ui.{Alignment, Component, Layout}

trait LayoutAlignmentHandlerMixin {
  this: Layout.AlignmentHandler =>

  def componentAlignment(component: Component): Alignment = getComponentAlignment(component)

  def componentAlignment_=(component: Component, alignment: Alignment): Unit =
    setComponentAlignment(component, alignment)

  def defaultComponentAlignment: Alignment = getDefaultComponentAlignment

  def defaultComponentAlignment_=(defaultComponentAlignment: Alignment): Unit =
    setDefaultComponentAlignment(defaultComponentAlignment)

}
