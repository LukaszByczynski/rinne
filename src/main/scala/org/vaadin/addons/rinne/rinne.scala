package org.vaadin.addons

import com.vaadin.data.{HasItems, HasValue}
import com.vaadin.server.{ClientConnector, Sizeable}
import com.vaadin.shared.Connector
import com.vaadin.ui.Component.Focusable
import com.vaadin.ui.{AbstractComponent, Component, ComponentContainer, SingleComponentContainer}
import org.vaadin.addons.rinne.internal.Measure

package object rinne {

  import scala.language.implicitConversions

  implicit def intToMeasureOption(value: Int): Measure = {
    Measure(value)
  }

  implicit def doubleToMeasureOption(value: Double): Measure = {
    Measure(value.toFloat)
  }

  implicit def VSizeableWrapper(sizeable: Sizeable): VSizeable = {
    new VSizeable(sizeable)
  }

  implicit def VFocusableWrapper(focusable: Focusable): VFocusable = {
    new VFocusable(focusable)
  }

  implicit def VHasValueWrapper[T](hasValue: HasValue[T]): VHasValue[T] = {
    new VHasValue[T](hasValue)
  }

  implicit def VConnectorWrapper(connector: Connector): VConnector = {
    new VConnector(connector)
  }

  implicit def VClientConnectorWrapper(clientConnector: ClientConnector): VClientConnector = {
    new VClientConnector(clientConnector)
  }

  implicit def VComponentWrapper(component: Component): VComponent = {
    new VComponent(component)
  }

  implicit def VAbstractComponentWrapper(component: AbstractComponent): VAbstractComponent = {
    new VAbstractComponent(component)
  }

  implicit def VHasItemsWrapper[T](hasItems: HasItems[T]): VHasItems[T] = {
    new VHasItems(hasItems)
  }

  implicit def VComponentContainerWrapper[T](componentContainer: ComponentContainer): VComponentContainer = {
    new VComponentContainer(componentContainer)
  }

  implicit def VSingleComponentContainerWrapper[T](singleComponentContainer: SingleComponentContainer): VSingleComponentContainer = {
    new VSingleComponentContainer(singleComponentContainer)
  }

}
