package org.vaadin.addons.rinne.mixins

import java.util

import com.vaadin.server.Sizeable.{Unit => VaadinUnit}
import com.vaadin.ui.AbstractSplitPanel.{SplitterClickEvent, SplitterClickListener}
import com.vaadin.ui.{AbstractSplitPanel, Component}
import org.vaadin.addons.rinne.events.ListenersSet
import org.vaadin.addons.rinne.{Measure, Units}

trait AbstractSplitPanelMixin extends ComponentContainerMixin with SizeableMixin {
  this: AbstractSplitPanel =>

  lazy val splitterClickListeners = new ListenersSet[SplitterClickEvent, SplitterClickListener] {

    override protected def addListener(listener: ListenerLambda): Unit = addSplitterClickListener(
      new Listener(listener) with SplitterClickListener {
        override def splitterClick(event: SplitterClickEvent): Unit = listener(event)
      }
    )

    override protected def removeListener(listener: SplitterClickListener): Unit = removeSplitterClickListener(listener)

    override protected def listeners: util.Collection[_] = getListeners(classOf[SplitterClickEvent])
  }
  var reserved = false

  def firstComponent: Option[Component] = Option(getFirstComponent)

  def firstComponent_=(component: Option[Component]): Unit = setFirstComponent(component.orNull)

  def firstComponent_=(component: Component): Unit = setFirstComponent(component)

  def secondComponent: Option[Component] = Option(getSecondComponent)

  def secondComponent_=(component: Option[Component]): Unit = setSecondComponent(component.orNull)

  def secondComponent_=(component: Component): Unit = setSecondComponent(component)

  def splitPosition_=(position: Option[Measure]): Unit = {
    position match {
      case Some(pos) => setSplitPosition(pos.value.intValue, VaadinUnit.values().apply(pos.unit.id), reserved)
      case None => setSplitPosition(50, VaadinUnit.PERCENTAGE, reserved)
    }
  }

  def minSplitPosition: Measure = Measure(getMinSplitPosition, Units(getMinSplitPositionUnit.ordinal))

  def splitPosition: Measure = new Measure(getSplitPosition, Units(getSplitPositionUnit.ordinal))

  def minSplitPosition_=(minSplitPosition: Option[Measure]): Unit = {
    minSplitPosition match {
      case Some(pos) => setMinSplitPosition(pos.value.intValue, VaadinUnit.values.apply(pos.unit.id))
      case None => setMinSplitPosition(0, com.vaadin.server.Sizeable.Unit.PERCENTAGE)
    }
  }

  def maxSplitPosition: Measure = Measure(getMaxSplitPosition, Units(getMaxSplitPositionUnit.ordinal))

  def maxSplitPosition_=(maxSplitPosition: Option[Measure]): Unit = {
    maxSplitPosition match {
      case Some(pos) => setMaxSplitPosition(pos.value.floatValue, VaadinUnit.values.apply(pos.unit.id))
      case None => setMaxSplitPosition(100, VaadinUnit.PERCENTAGE)
    }
  }

  def locked: Boolean = isLocked

  def splitPosition_=(position: Measure): Unit =
  {
    splitPosition = Some(position)
  }

  def locked_=(locked: Boolean) {
    setLocked(locked)
  }


}
