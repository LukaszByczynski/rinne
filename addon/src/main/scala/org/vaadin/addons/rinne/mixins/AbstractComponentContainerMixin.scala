package org.vaadin.addons.rinne.mixins

import com.vaadin.ui.AbstractComponentContainer

trait AbstractComponentContainerMixin {
  this: AbstractComponentContainer with ContainerMixin =>
}
