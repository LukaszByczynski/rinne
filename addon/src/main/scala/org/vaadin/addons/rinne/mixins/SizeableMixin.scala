package org.vaadin.addons.rinne.mixins

import org.vaadin.addons.rinne.{Measure, Units}
import com.vaadin.server.Sizeable

trait SizeableMixin extends Sizeable {


  def width: Option[Measure] = if (getWidth < 0) None else Option(Measure(getWidth, Units(getWidthUnits.ordinal)))

  def width_=(width: Option[Measure]) = setWidth(if (width.isDefined) width.get.toString else null)

  def width_=(width: Measure) = setWidth(if (width != null) width.toString else null)

  def height: Option[Measure] = if (getHeight < 0) None else Option(Measure(getHeight, Units(getHeightUnits.ordinal)))

  def height_=(height: Option[Measure]) = setHeight(if (height.isDefined) height.get.toString else null)

  def height_=(height: Measure) = setHeight(if (height != null) height.toString else null)

  def sizeFull() = setSizeFull()

  def sizeUndefined() = setSizeUndefined()

  def size(width: Measure, height: Measure) = {
    this.width = width
    this.height = height
  }

  def size(width: Option[Measure], height: Option[Measure]) = {
    this.width = width
    this.height = height
  }
}