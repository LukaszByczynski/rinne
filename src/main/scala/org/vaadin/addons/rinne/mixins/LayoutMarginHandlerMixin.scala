package org.vaadin.addons.rinne.mixins

import com.vaadin.ui.Layout.MarginHandler
import org.vaadin.addons.rinne.Margin

trait LayoutMarginHandlerMixin {
  this: MarginHandler =>

  def margin_=(margin: Boolean) {
    setMargin(margin)
  }

  def margin(top: Boolean = false, right: Boolean = false, bottom: Boolean = false, left: Boolean = false) {
    margin = Margin(top, right, bottom, left)
  }

  def margin: Margin = {
    val margin = getMargin
    Margin(margin.hasTop, margin.hasRight, margin.hasBottom, margin.hasLeft)
  }

  def margin_=(margin: Margin) {
    setMargin(new com.vaadin.shared.ui.MarginInfo(margin.top, margin.right, margin.bottom, margin.left))
  }

}
