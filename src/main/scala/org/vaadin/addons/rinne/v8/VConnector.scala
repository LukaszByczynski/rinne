package org.vaadin.addons.rinne.v8

import com.vaadin.shared.Connector

class VConnector(connector: Connector) {

  def connectorId: String = connector.getConnectorId

  def parent: Connector = connector.getParent

}
