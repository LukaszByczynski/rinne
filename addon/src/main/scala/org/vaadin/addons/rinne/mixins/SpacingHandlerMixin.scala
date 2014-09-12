package org.vaadin.addons.rinne.mixins

import com.vaadin.ui.Layout.SpacingHandler

trait SpacingHandlerMixin extends SpacingHandler {

  def spacing: Boolean = isSpacing

  def spacing_=(spacing: Boolean) { setSpacing(spacing) }

}
