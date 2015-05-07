package org.vaadin.addons.rinne.mixins

import com.vaadin.server.Resource
import com.vaadin.ui.AbstractEmbedded

trait AbstractEmbeddedMixin extends AbstractComponentMixin {
  this: AbstractEmbedded =>

  def source: Option[Resource] = Option(getSource)

  def source_=(source: Option[Resource]): Unit = setSource(source.orNull)

  def source_=(source: Resource): Unit = setSource(source)

  def alternateText: Option[String] = Option(getAlternateText)

  def alternateText_=(alternateText: String): Unit = setAlternateText(alternateText)

  def alternateText_=(alternateText: Option[String]): Unit = setAlternateText(alternateText.orNull)
}
