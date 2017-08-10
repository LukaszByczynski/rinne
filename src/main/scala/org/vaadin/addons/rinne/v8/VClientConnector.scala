package org.vaadin.addons.rinne.v8

import com.vaadin.server.{ClientConnector, ErrorHandler, Extension}
import com.vaadin.shared.communication.SharedState
import com.vaadin.ui.UI

class VClientConnector(clientConnector: ClientConnector) {

  import scala.collection.JavaConverters._

  def stateType: Class[_ <: SharedState] = clientConnector.getStateType

  def extensions: Iterable[Extension] = clientConnector.getExtensions.asScala

  def ui: UI = clientConnector.getUI

  def errorHandler: ErrorHandler = clientConnector.getErrorHandler

  def errorHandler_=(errorHandler: ErrorHandler): Unit = clientConnector.setErrorHandler(errorHandler)

}
