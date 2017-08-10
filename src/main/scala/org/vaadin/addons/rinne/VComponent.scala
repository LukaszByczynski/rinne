package org.vaadin.addons.rinne

import java.util.Locale

import com.vaadin.server.Resource
import com.vaadin.ui.{Component, HasComponents, UI}

import scala.collection.mutable

class VComponent(component: Component) {

  lazy val styleNames = new mutable.Set[String] {

    def contains(key: String): Boolean = {
      component.getStyleName.split(" ").iterator.contains(key)
    }

    def iterator: Iterator[String] = {
      component.getStyleName.split(" ").iterator
    }

    def +=(elem: String): this.type = {
      elem.split(" ").foreach(component.addStyleName)
      this
    }

    def -=(elem: String): this.type = {
      component.removeStyleName(elem)
      this
    }
  }

  def styleName: Option[String] = Option(component.getStyleName)

  def styleName_=(styleName: Option[String]): Unit = {
    component.setStyleName(styleName.orNull)
  }

  def styleName_=(styleName: String): Unit = {
    component.setStyleName(styleName)
  }

  def primaryStyleName: Option[String] = {
    Option(component.getPrimaryStyleName)
  }

  def primaryStyleName_=(styleName: Option[String]): Unit = {
    component.setPrimaryStyleName(styleName.orNull)
  }

  def primaryStyleName_=(styleName: String): Unit = {
    component.setPrimaryStyleName(styleName)
  }

  def enabled: Boolean = component.isEnabled

  def enabled_=(enabled: Boolean): Unit = {
    component.setEnabled(enabled)
  }

  def visible: Boolean = component.isVisible

  def visible_=(visible: Boolean): Unit = {
    component.setVisible(visible)
  }

  def caption: Option[String] = Option(component.getCaption)

  def caption_=(caption: Option[String]): Unit = {
    component.setCaption(caption.orNull)
  }

  def caption_=(caption: String): Unit = {
    component.setCaption(caption)
  }

  def icon: Option[Resource] = {
    Option(component.getIcon)
  }

  def icon_=(icon: Option[Resource]): Unit = {
    component.setIcon(icon.orNull)
  }

  def icon_=(icon: Resource): Unit = {
    component.setIcon(icon)
  }

  def ui: UI = {
    component.getUI
  }

  def locale: Option[Locale] = {
    Option(component.getLocale)
  }

  def id: Option[String] = {
    Option(component.getId)
  }

  def id_=(id: Option[String]): Unit = {
    component.setId(id.orNull)
  }

  def id_=(id: String): Unit = {
    component.setId(id)
  }

  def description: Option[String] = {
    Option(component.getDescription)
  }

  def parent: HasComponents = {
    component.getParent
  }

}
