package org.vaadin.addons.rinne.mixins

import com.vaadin.ui.{AbstractComponentContainer, Component, ComponentContainer}

import scala.collection.mutable

trait ComponentContainerMixin extends ComponentMixin {
  this: ComponentContainer =>

  lazy val componentSet = new mutable.Set[Component] with Serializable {

    import scala.collection.JavaConverters._

    def contains(key: Component): Boolean = {
      iterator.contains(key)
    }

    def iterator: Iterator[Component] = {
      ComponentContainerMixin.this.iterator().asScala
    }

    def +=(elem: Component) = {
      addComponent(elem)
      this
    }

    def -=(elem: Component) = {
      removeComponent(elem)
      this
    }
  }

  def add[C <: Component](component: C): C = {
    addComponent(component)
    component
  }

}
