package org.vaadin.addons.rinne.mixins

import com.vaadin.ui.AbstractComponentContainer

trait AbstractComponentContainerMixin extends ComponentContainerMixin with AbstractComponentMixin {
  this: AbstractComponentContainer =>
}
