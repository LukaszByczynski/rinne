package org.vaadin.addons.rinne

import com.vaadin.shared.Connector

class VConnector(connector: Connector) {

  def connectorId: String = connector.getConnectorId

  def parent: Connector = connector.getParent

}
