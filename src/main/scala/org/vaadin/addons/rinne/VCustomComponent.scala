package org.vaadin.addons.rinne

import com.vaadin.ui.{Component, CustomComponent}
import org.vaadin.addons.rinne.mixins.ComponentMixin

class VCustomComponent extends CustomComponent with ComponentMixin {

  def compositionRoot: Option[Component] = Option(getCompositionRoot)

  def compositionRoot_=(component: Component): Unit = {
    setCompositionRoot(component)
  }

  def compositionRoot_=(component: Option[Component]): Unit = {
    setCompositionRoot(component.orNull)
  }
}