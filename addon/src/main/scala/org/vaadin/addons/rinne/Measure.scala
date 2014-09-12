package org.vaadin.addons.rinne

object Units extends Enumeration {

  import com.vaadin.server.Sizeable.Unit._

  val px = Value(PIXELS.ordinal, "px")
  val pt = Value(POINTS.ordinal, "pt")
  val pc = Value(PICAS.ordinal, "pc")
  val em = Value(EM.ordinal, "em")
  val ex = Value(EX.ordinal, "ex")
  val mm = Value(MM.ordinal, "mm")
  val cm = Value(CM.ordinal, "cm")
  val in = Value(INCH.ordinal, "in")
  val pct = Value(PERCENTAGE.ordinal, "%")
}

case class Measure(value: Number, unit: Units.Value) {
  override def toString = value + unit.toString
}

class MeasureExtent(value: Number) {
  def px: Option[Measure] = Option(Measure(value, Units.px))

  def percent: Option[Measure] = Option(new Measure(value, Units.pct))

  def pct: Option[Measure] = Option(new Measure(value, Units.pct))

  def em: Option[Measure] = Option(new Measure(value, Units.em))

  def ex: Option[Measure] = Option(new Measure(value, Units.ex))

  def in: Option[Measure] = Option(new Measure(value, Units.in))

  def cm: Option[Measure] = Option(new Measure(value, Units.cm))

  def mm: Option[Measure] = Option(new Measure(value, Units.mm))

  def pt: Option[Measure] = Option(new Measure(value, Units.pt))

  def pc: Option[Measure] = Option(new Measure(value, Units.pc))
}
