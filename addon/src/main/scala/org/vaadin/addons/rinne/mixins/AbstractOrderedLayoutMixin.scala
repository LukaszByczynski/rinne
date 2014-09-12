package org.vaadin.addons.rinne.mixins

import org.vaadin.addons.rinne.event.LayoutClickNotifierMixin
import com.vaadin.ui.{Alignment, Component, AbstractOrderedLayout}

trait AbstractOrderedLayoutMixin extends AbstractOrderedLayout
with AbstractLayoutMixin with SpacingHandlerMixin with MarginHandlerMixin with LayoutClickNotifierMixin {

  def add[C <: Component](component: C, ratio: Float = -1, alignment: Alignment = null, index: Int = -1): C = {

    if (index < 0)
      addComponent(component)
    else
      addComponent(component, index)

    if (alignment != null) {
      setComponentAlignment(component, alignment)
    }

    if (ratio >= 0) {
      setExpandRatio(component, ratio)
    }

    component
  }
}
