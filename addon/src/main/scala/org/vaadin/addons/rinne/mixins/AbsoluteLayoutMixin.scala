package org.vaadin.addons.rinne.mixins

import com.vaadin.ui.{Component, AbsoluteLayout}

trait AbsoluteLayoutMixin extends AbsoluteLayout with AbstractLayoutMixin {

  def add[C <: Component](component: C, location: String): C = {
    addComponent(component, location)
    component
  }

}
