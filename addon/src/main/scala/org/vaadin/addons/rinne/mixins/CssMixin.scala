package org.vaadin.addons.rinne.mixins

import org.vaadin.addons.rinne.events.LayoutClickNotifierMixin
import com.vaadin.ui.CssLayout

trait CssMixin extends CssLayout with AbstractLayoutMixin with LayoutClickNotifierMixin {

  private var _cssMap = Map.empty[com.vaadin.ui.Component, String]

  def add[C <: com.vaadin.ui.Component](component: C, css: => String = null): C = {
    add(component)
    if (css != null) {
      _cssMap += component -> css
    }
    component
  }

  override def getCss(component: com.vaadin.ui.Component): String = _cssMap.getOrElse(component, "")

  override def removeComponent(component: com.vaadin.ui.Component) = {
    super.removeComponent(component)
    _cssMap -= component
  }
}
