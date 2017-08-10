package org.vaadin.addons.rinne.v8

import com.vaadin.server.Sizeable

class VSizeable(sizable: Sizeable) {

  def width_=(width: Measure8): Unit = {
    sizable.setWidth(width.value, width.unit)
  }

  def height_=(height: Measure8): Unit = {
    sizable.setHeight(height.value, height.unit)
  }

  def sizeFull = sizable.setSizeFull()

  def sizeUndefined = sizable.setSizeUndefined()

  def size(width: Measure8, height: Measure8) = {
    this.width = width
    this.height = height
  }

  def size(width: Option[Measure8], height: Option[Measure8]) = {
    this.width = width
    this.height = height
  }

  def height: Option[Measure8] = {
    if (sizable.getHeight < 0)
      None
    else
      Some(Measure8(sizable.getHeight, sizable.getHeightUnits))
  }

  def height_=(height: Option[Measure8]): Unit = {
    if (height.isEmpty)
      sizable.setHeightUndefined()
    else
      width.foreach(w => sizable.setWidth(w.value, w.unit))
  }

  def width: Option[Measure8] = {
    if (sizable.getWidth < 0)
      None
    else
      Some(Measure8(sizable.getWidth, sizable.getWidthUnits))
  }

  def width_=(width: Option[Measure8]): Unit = {
    if (width.isEmpty)
      sizable.setWidthUndefined()
    else
      width.foreach(w => sizable.setWidth(w.value, w.unit))
  }

}
