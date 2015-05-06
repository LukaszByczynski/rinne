package org.vaadin.addons.rinne

import com.vaadin.ui.{AbsoluteLayout, Component}
import org.vaadin.addons.rinne.mixins.{AbstractLayoutMixin, ComponentContainerMixin, ComponentMixin, LayoutClickNotifierMixin}

class VAbsoluteLayout extends AbsoluteLayout
with AbstractLayoutMixin with ComponentContainerMixin with ComponentMixin with LayoutClickNotifierMixin {

  def add[C <: Component](component: C, location: String): C = {
    addComponent(component, location)
    component
  }

}
