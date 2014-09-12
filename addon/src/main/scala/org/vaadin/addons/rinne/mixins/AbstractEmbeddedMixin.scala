package org.vaadin.addons.rinne.mixins

import com.vaadin.server.Resource
import com.vaadin.ui.AbstractEmbedded

trait AbstractEmbeddedMixin extends AbstractEmbedded with AbstractComponentMixin {

  def source: Option[Resource] = Option(getSource)

  def source_=(source: Option[Resource]) { setSource(source.orNull) }

  def source_=(source: Resource) { setSource(source) }

  def alternateText: Option[String] = Option(getAlternateText)

  def alternateText_=(alternateText: String) { setAlternateText(alternateText) }

  def alternateText_=(alternateText: Option[String]) { setAlternateText(alternateText.orNull) }
}
