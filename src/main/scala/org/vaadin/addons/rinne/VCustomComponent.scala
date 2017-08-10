package org.vaadin.addons.rinne

import com.vaadin.ui.{Component, CustomComponent}

class VCustomComponent extends CustomComponent {

  def compositionRoot: Option[Component] = Option(getCompositionRoot)

  def compositionRoot_=(component: Component): Unit = {
    setCompositionRoot(component)
  }

  def compositionRoot_=(component: Option[Component]): Unit = {
    setCompositionRoot(component.orNull)
  }
}