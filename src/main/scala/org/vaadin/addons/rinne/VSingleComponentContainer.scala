package org.vaadin.addons.rinne

import com.vaadin.ui.{Component, SingleComponentContainer}

class VSingleComponentContainer(singleComponentContainer: SingleComponentContainer) {

  def content: Component = {
    singleComponentContainer.getContent
  }

  def content_=(component: Component): Unit = {
    singleComponentContainer.setContent(component)
  }

}
