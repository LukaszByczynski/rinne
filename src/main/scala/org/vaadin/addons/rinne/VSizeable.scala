package org.vaadin.addons.rinne

import com.vaadin.server.Sizeable
import org.vaadin.addons.rinne.internal.Measure

class VSizeable(sizable: Sizeable) {

  def width: Option[Measure] = {
    if (sizable.getWidth < 0)
      None
    else
      Some(Measure(sizable.getWidth, sizable.getWidthUnits))
  }

  def width_=(width: Option[Measure]): Unit = {
    if (width.isEmpty)
      sizable.setWidthUndefined()
    else
      width.foreach(w => sizable.setWidth(w.value, w.unit))
  }

  def width_=(width: Measure): Unit = {
    sizable.setWidth(width.value, width.unit)
  }

  def height: Option[Measure] = {
    if (sizable.getHeight < 0)
      None
    else
      Some(Measure(sizable.getHeight, sizable.getHeightUnits))
  }

  def height_=(height: Option[Measure]): Unit = {
    if (height.isEmpty)
      sizable.setHeightUndefined()
    else
      width.foreach(w => sizable.setWidth(w.value, w.unit))
  }

  def height_=(height: Measure): Unit = {
    sizable.setHeight(height.value, height.unit)
  }

  def sizeFull = sizable.setSizeFull()

  def sizeUndefined = sizable.setSizeUndefined()

  def size(width: Measure, height: Measure) = {
    this.width = width
    this.height = height
  }

  def size(width: Option[Measure], height: Option[Measure]) = {
    this.width = width
    this.height = height
  }

}
