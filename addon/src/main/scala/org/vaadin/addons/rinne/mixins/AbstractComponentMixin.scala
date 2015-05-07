package org.vaadin.addons.rinne.mixins

import com.vaadin.ui.AbstractComponent

trait AbstractComponentMixin extends ComponentMixin {
  this: AbstractComponent =>

  def description: Option[String] = Option(getDescription)

  def description_=(description: Option[String]): Unit = setDescription(description.orNull)

  def description_=(description: String): Unit = setDescription(description)

  def immediate: Boolean = isImmediate

  def immediate_=(immediate: Boolean): Unit = setImmediate(immediate)

  def data: Any = getData

  def data_=(data: Any): Unit = setData(data)
}

