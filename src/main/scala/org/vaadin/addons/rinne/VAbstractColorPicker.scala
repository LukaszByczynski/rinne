package org.vaadin.addons.rinne

import com.vaadin.ui.AbstractColorPicker

class VAbstractColorPicker(colorPicker: AbstractColorPicker) {

//  lazy val colorChangeListeners = new ListenersSet[ColorChangeEvent, ColorChangeListener] {
//  }

  def defaultCaptionEnabled: Boolean = colorPicker.isDefaultCaptionEnabled

  def defaultCaptionEnabled_=(value: Boolean): Unit = {
    colorPicker.setDefaultCaptionEnabled(value)
  }

  def popupStyle: AbstractColorPicker.PopupStyle = colorPicker.getPopupStyle

  def popupStyle_(value: AbstractColorPicker.PopupStyle): Unit = {
    colorPicker.setPopupStyle(value)
  }

  def rgbVisibility: Boolean = colorPicker.getRGBVisibility

  def rgbVisibility_=(value: Boolean): Unit = {
    colorPicker.setRGBVisibility(value)
  }

  def hsvVisibility: Boolean = colorPicker.getHSVVisibility

  def hsvVisibility_=(value: Boolean): Unit = {
    colorPicker.s(value)
  }


}
