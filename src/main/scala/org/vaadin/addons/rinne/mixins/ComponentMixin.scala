package org.vaadin.addons.rinne.mixins

import java.util.Locale

import com.vaadin.server.Resource
import com.vaadin.ui.{Component, UI}

import scala.collection.mutable

trait ComponentMixin extends SizeableMixin {
  this: Component =>

  lazy val styleNames = new mutable.Set[String] with Serializable {
    def contains(key: String) = getStyleName.split(" ").iterator.contains(key)

    def iterator: Iterator[String] = getStyleName.split(" ").iterator

    def +=(elem: String) = {
      elem.split(" ").foreach(addStyleName);
      this
    }

    def -=(elem: String) = {
      removeStyleName(elem);
      this
    }
  }

  def styleName: Option[String] = Option(getStyleName)

  def styleName_=(styleName: Option[String]) {
    setStyleName(styleName.orNull)
  }

  def styleName_=(styleName: String) {
    setStyleName(styleName)
  }

  def enabled: Boolean = isEnabled

  def enabled_=(enabled: Boolean) {
    setEnabled(enabled)
  }

  def visible: Boolean = isVisible

  def visible_=(visible: Boolean) {
    setVisible(visible)
  }

  def caption: Option[String] = Option(getCaption)

  def caption_=(caption: Option[String]) {
    setCaption(caption.orNull)
  }

  def caption_=(caption: String) {
    setCaption(caption)
  }

  def icon: Option[Resource] = Option(getIcon)

  def icon_=(icon: Option[Resource]) {
    setIcon(icon.orNull)
  }

  def icon_=(icon: Resource) {
    setIcon(icon)
  }

  def ui: UI = getUI

  def locale: Option[Locale] = Option(getLocale)

  def id: Option[String] = Option(getId)

  def id_=(id: Option[String]) {
    setId(id.orNull)
  }

  def id_=(id: String) {
    setId(id)
  }
}