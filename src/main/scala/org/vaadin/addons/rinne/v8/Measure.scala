package org.vaadin.addons.rinne.v8

import com.vaadin.server.Sizeable.Unit

case class Measure8(value: Float, unit: Unit = Unit.PIXELS) {

  override def toString = s"$value $unit"

  def px: Measure8 = copy(unit = Unit.PIXELS)

  def percentage: Measure8 = copy(unit = Unit.PERCENTAGE)

  def pct: Measure8 = copy(unit = Unit.PERCENTAGE)

  def em: Measure8 = copy(unit = Unit.EM)

  def rem: Measure8 = copy(unit = Unit.REM)

  def ex: Measure8 = copy(unit = Unit.EX)

  def in: Measure8 = copy(unit = Unit.INCH)

  def cm: Measure8 = copy(unit = Unit.CM)

  def mm: Measure8 = copy(unit = Unit.MM)

  def pt: Measure8 = copy(unit = Unit.POINTS)

  def pc: Measure8 = copy(unit = Unit.PICAS)
}
