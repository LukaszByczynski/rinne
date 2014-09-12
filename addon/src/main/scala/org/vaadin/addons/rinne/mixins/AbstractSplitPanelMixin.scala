package org.vaadin.addons.rinne.mixins

import org.vaadin.addons.rinne.{Units, Measure}
import com.vaadin.server.Sizeable.{Unit => VaadinUnit}
import com.vaadin.ui.{Component, AbstractSplitPanel}

trait AbstractSplitPanelMixin extends AbstractSplitPanel with ComponentContainerMixin with SizeableMixin {

  def firstComponent: Option[Component] = Option(getFirstComponent)

  def firstComponent_=(component: Component) { setFirstComponent(component) }

  def firstComponent_=(component: Option[Component]) { setFirstComponent(component.orNull) }

  def secondComponent: Option[Component] = Option(getSecondComponent)

  def secondComponent_=(component: Component) { setSecondComponent(component) }

  def secondComponent_=(component: Option[Component]) { setSecondComponent(component.orNull) }

  var reserved = false

  def splitPosition: Measure = new Measure(getSplitPosition, Units(getSplitPositionUnit.ordinal))

  def splitPosition_=(position: Option[Measure]) {
    position match {
      case None => setSplitPosition(50, VaadinUnit.PERCENTAGE, reserved)
      case Some(pos) => setSplitPosition(pos.value.intValue, VaadinUnit.values().apply(pos.unit.id), reserved)
    }
  }

  def splitPosition_=(position: Measure) { splitPosition = Some(position) }

  def minSplitPosition: Measure = Measure(getMinSplitPosition, Units(getMinSplitPositionUnit.ordinal))

  def minSplitPosition_=(minSplitPosition: Option[Measure]) {
    minSplitPosition match {
      case None => setMinSplitPosition(0, com.vaadin.server.Sizeable.Unit.PERCENTAGE)
      case Some(pos) => setMinSplitPosition(pos.value.intValue, VaadinUnit.values.apply(pos.unit.id))
    }
  }

  def maxSplitPosition: Measure = Measure(getMaxSplitPosition, Units(getMaxSplitPositionUnit.ordinal))

  def maxSplitPosition_=(maxSplitPosition: Option[Measure]) {
    maxSplitPosition match {
      case None => setMaxSplitPosition(100, VaadinUnit.PERCENTAGE)
      case Some(pos) => setMaxSplitPosition(pos.value.floatValue, VaadinUnit.values.apply(pos.unit.id))
    }
  }

  def locked: Boolean = isLocked

  def locked_=(locked: Boolean) { setLocked(locked) }

  //  lazy val splitterClickListeners: ListenersSet[AbstractSplitPanel.SplitterClickEvent => Unit] =
  //    new ListenersTrait[AbstractSplitPanel.SplitterClickEvent, SplitterClickListener] {
  //      override def listeners = getListeners(classOf[com.vaadin.ui.AbstractSplitPanel.SplitterClickEvent])
  //      override def addListener(elem: AbstractSplitPanel.SplitterClickEvent => Unit) =
  //        addSplitterClickListener(new SplitterClickListener(elem))
  //      override def removeListener(elem: SplitterClickListener) = removeSplitterClickListener(elem)
  //    }
}
