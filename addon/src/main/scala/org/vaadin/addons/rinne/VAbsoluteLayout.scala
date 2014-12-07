package org.vaadin.addons.rinne

import com.vaadin.ui.{AbsoluteLayout, Component}
import org.vaadin.addons.rinne.mixins.AbstractLayoutMixin

class VAbsoluteLayout extends AbsoluteLayout with AbstractLayoutMixin {

  def add[C <: Component](component: C, location: String): C = {
    addComponent(component, location)
    component
  }

}
