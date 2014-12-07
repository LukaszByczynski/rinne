package org.vaadin.addons

import scala.language.implicitConversions

package object rinne {

  implicit def intToMeasureOption(value: Int): MeasureExtent = new MeasureExtent(value)

  implicit def doubleToMeasureOption(value: Double): MeasureExtent = new MeasureExtent(value)

}