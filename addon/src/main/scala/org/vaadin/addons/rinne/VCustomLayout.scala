package org.vaadin.addons.rinne

import com.vaadin.ui.{Component, CustomLayout}
import org.vaadin.addons.rinne.mixins.AbstractLayoutMixin

class VCustomLayout extends CustomLayout with AbstractLayoutMixin {

  def templateName = Option(getTemplateName)

  def templateName_=(templateName: String) = setTemplateName(templateName)

  def templateContents = Option(getTemplateContents)

  def templateContents_=(templateContents: String) = setTemplateContents(templateContents)

  def add[C <: Component](component: C, location: String): C = {
    addComponent(component, location)
    component
  }

}
