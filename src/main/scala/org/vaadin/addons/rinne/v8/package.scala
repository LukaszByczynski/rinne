package org.vaadin.addons.rinne

import com.vaadin.server.ClientConnector
import com.vaadin.shared.Connector
import com.vaadin.ui.{AbstractField, Component}

package object v8 {

  import scala.language.implicitConversions

  implicit def VConnectorWrapper(connector: Connector): VConnector = {
    new VConnector(connector)
  }

  implicit def VClientConnectorWrapper(clientConnector: ClientConnector): VClientConnector = {
    new VClientConnector(clientConnector)
  }

  implicit def VComponentWrapper(component: Component): VComponent = {
    new VComponent(component)
  }

  implicit def VAbstractFieldWrapper[T](field: AbstractField[T]): VAbstractField[T] = {
    new VAbstractField(field)
  }

}