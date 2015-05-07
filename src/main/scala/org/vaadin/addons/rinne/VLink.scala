package org.vaadin.addons.rinne

import com.vaadin.server.Resource
import com.vaadin.shared.ui.BorderStyle
import com.vaadin.ui.Link
import org.vaadin.addons.rinne.mixins.AbstractComponentMixin

class VLink extends Link with AbstractComponentMixin {

  def targetName: Option[String] = Option(getTargetName)

  def targetName_=(targetName: String): Unit = {
    setTargetName(targetName)
  }

  def targetName_=(targetName: Option[String]): Unit = {
    setTargetName(caption.orNull)
  }

  def targetBorder: BorderStyle = getTargetBorder

  def targetBorder_=(targetBorder: BorderStyle): Unit = setTargetBorder(targetBorder)

  def targetWidth: Int = getTargetWidth

  def targetWidth_=(targetWidth: Int): Unit = {
    setTargetWidth(targetWidth)
  }

  def targetHeight: Int = getTargetHeight

  def targetHeight_=(targetHeight: Int): Unit = {
    setTargetHeight(targetHeight)
  }

  def resource: Option[Resource] = Option(getResource)

  def resource_=(resource: Resource): Unit = {
    setResource(resource)
  }

  def resource_=(resource: Option[Resource]): Unit = {
    setResource(resource.orNull)
  }
}
