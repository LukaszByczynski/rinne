package org.vaadin.addons.rinne

import com.vaadin.ui.{Component, CssLayout}
import org.vaadin.addons.rinne.mixins.{LayoutClickNotifierMixin, AbstractLayoutMixin}

class VCssLayout extends CssLayout with AbstractLayoutMixin with LayoutClickNotifierMixin {

  private var _cssMap = Map[Component, String]()

  def add[C <: Component](component: C, css: => String = null): C = {
    add(component)
    if (css != null) {
      _cssMap += component -> css
    }
    component
  }

  def getCssForComponent(component: Component): Option[String] = _cssMap.get(component)

  override def removeComponent(component: Component) = {
    super.removeComponent(component)
    _cssMap -= component
  }
}
