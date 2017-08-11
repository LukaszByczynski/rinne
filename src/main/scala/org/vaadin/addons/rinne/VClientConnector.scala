package org.vaadin.addons.rinne

import com.vaadin.server.ClientConnector.{AttachEvent, AttachListener, DetachEvent, DetachListener}
import com.vaadin.server.{ClientConnector, ErrorHandler, Extension}
import com.vaadin.shared.Registration
import com.vaadin.shared.communication.SharedState
import com.vaadin.ui.UI
import org.vaadin.addons.rinne.internal.ListenersSet

class VClientConnector(clientConnector: ClientConnector) {

  import scala.collection.JavaConverters._

  lazy val attachListeners = new ListenersSet[AttachEvent, AttachListener] {
    override protected def addListener(listener: AttachListener): Registration = {
      clientConnector.addAttachListener(listener)
    }

    override protected def createListener(action: => Unit): AttachListener = {
      (_: AttachEvent) => action
    }
  }

  lazy val detachListeners = new ListenersSet[DetachEvent, DetachListener] {
    override protected def addListener(listener: DetachListener): Registration = {
      clientConnector.addDetachListener(listener)
    }

    override protected def createListener(action: => Unit): DetachListener = {
      (_: DetachEvent) => action
    }
  }

  def attached: Boolean = clientConnector.isAttached

  def connectorEnabled: Boolean = clientConnector.isConnectorEnabled

  def stateType: Class[_ <: SharedState] = clientConnector.getStateType

  def extensions: Iterable[Extension] = clientConnector.getExtensions.asScala

  def ui: UI = clientConnector.getUI

  def errorHandler: ErrorHandler = clientConnector.getErrorHandler

  def errorHandler_=(errorHandler: ErrorHandler): Unit = clientConnector.setErrorHandler(errorHandler)

  def parent: ClientConnector = clientConnector.getParent
}
