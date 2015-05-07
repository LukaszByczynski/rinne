package org.vaadin.addons.rinne.mixins

import com.vaadin.ui.Layout.SpacingHandler

trait LayoutSpacingHandlerMixin {
  this: SpacingHandler =>

  def spacing: Boolean = isSpacing

  def spacing_=(spacing: Boolean) { setSpacing(spacing) }

}
