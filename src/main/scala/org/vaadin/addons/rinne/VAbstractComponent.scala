package org.vaadin.addons.rinne

import java.util.Locale

import com.vaadin.server.ErrorMessage
import com.vaadin.ui.AbstractComponent

class VAbstractComponent(component: AbstractComponent) {

  def locale_=(locale: Option[Locale]): Unit = {
    component.setLocale(locale.orNull)
  }

  def locale_=(locale: Locale): Unit = {
    component.setLocale(locale)
  }

  def captionAsHtml: Boolean = {
    component.isCaptionAsHtml
  }

  def captionAsHtml_=(captionAsHtml: Boolean): Unit = {
    component.setCaptionAsHtml(captionAsHtml)
  }

  def componentError: Option[ErrorMessage] = {
    Option(component.getComponentError)
  }

  def componentError_=(message: Option[ErrorMessage]): Unit = {
    component.setComponentError(message.orNull)
  }

  def componentError_=(message: ErrorMessage): Unit = {
    component.setComponentError(message)
  }

  def description_=(description: Option[String]): Unit = {
    component.setDescription(description.orNull)
  }

  def description_=(description: String): Unit = {
    component.setDescription(description)
  }

  def data: Any = {
    component.getData
  }

  def data_=(data: Any): Unit = {
    component.setData(data)
  }

  def responsive: Boolean = {
    component.isResponsive
  }

  def responsive_=(value: Boolean): Unit = {
    component.setResponsive(value)
  }
}
