package org.vaadin.addons.rinne

import com.vaadin.ui.{Component, CssLayout}
import org.vaadin.addons.rinne.events.LayoutClickNotifierMixin
import org.vaadin.addons.rinne.mixins.AbstractLayoutMixin

class VCssLayout extends CssLayout with AbstractLayoutMixin with LayoutClickNotifierMixin {

  private var _cssMap = Map.empty[Component, String]

  def add[C <: Component](component: C, css: => String = null): C = {
    add(component)
    if (css != null) {
      _cssMap += component -> css
    }
    component
  }

  override def getCss(component: Component): String = _cssMap.getOrElse(component, "")

  override def removeComponent(component: Component) = {
    super.removeComponent(component)
    _cssMap -= component
  }
}
