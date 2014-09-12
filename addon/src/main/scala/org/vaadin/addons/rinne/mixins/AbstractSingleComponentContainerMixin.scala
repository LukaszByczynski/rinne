package org.vaadin.addons.rinne.mixins

import com.vaadin.ui.{Component, AbstractSingleComponentContainer}

trait AbstractSingleComponentContainerMixin extends AbstractSingleComponentContainer {
  def componentCount: Int = getComponentCount

  def content: Option[Component] = Option(getContent)

  def content_=(content: Option[Component]) {
    setContent(content.orNull)
  }

  def content_=(content: Component) {
    setContent(content)
  }
}
