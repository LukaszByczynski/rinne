package org.vaadin.addons.rinne.internal

import com.vaadin.server.Sizeable.Unit

case class Measure(value: Float, unit: Unit = Unit.PIXELS) {

  override def toString = s"$value $unit"

  def px: Measure = copy(unit = Unit.PIXELS)

  def percentage: Measure = copy(unit = Unit.PERCENTAGE)

  def pct: Measure = copy(unit = Unit.PERCENTAGE)

  def em: Measure = copy(unit = Unit.EM)

  def rem: Measure = copy(unit = Unit.REM)

  def ex: Measure = copy(unit = Unit.EX)

  def in: Measure = copy(unit = Unit.INCH)

  def cm: Measure = copy(unit = Unit.CM)

  def mm: Measure = copy(unit = Unit.MM)

  def pt: Measure = copy(unit = Unit.POINTS)

  def pc: Measure = copy(unit = Unit.PICAS)
}
