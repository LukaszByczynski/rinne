package org.vaadin.addons.rinne.mixins

import com.vaadin.ui.AbstractComponent

trait AbstractComponentMixin extends AbstractComponent with ComponentMixin {

  def description: Option[String] = Option(getDescription)

  def description_=(description: Option[String]) {
    setDescription(description.orNull)
  }

  def description_=(description: String) {
    setDescription(description)
  }

  def immediate: Boolean = isImmediate

  def immediate_=(immediate: Boolean) {
    setImmediate(immediate)
  }

  def data: Any = getData

  def data_=(data: Any) {
    setData(data)
  }

}
