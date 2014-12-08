package org.vaadin.addons.rinne

import com.vaadin.shared.ui.slider.SliderOrientation
import com.vaadin.ui.Slider
import org.vaadin.addons.rinne.mixins.AbstractFieldMixin

class VSlider extends Slider with AbstractFieldMixin[java.lang.Double] {

  def min: Double = getMin

  def min_=(min: Double): Unit = setMin(min)

  def max: Double = getMax

  def max_=(max: Double): Unit = setMax(max)

  def resolution: Int = getResolution

  def resolution_=(resolution: Int): Unit = setResolution(resolution)

  def value_=(value: Double): Unit = setValue(value)

  def orientation: SliderOrientation = getOrientation

  def orientation_=(orientation: SliderOrientation): Unit = setOrientation(orientation)
}
