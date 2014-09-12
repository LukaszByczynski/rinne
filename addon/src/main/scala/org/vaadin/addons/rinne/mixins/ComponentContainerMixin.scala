package org.vaadin.addons.rinne.mixins

import com.vaadin.ui.{Component, ComponentContainer}
import scala.collection.mutable

trait ComponentContainerMixin extends ComponentContainer with ComponentMixin {

  def add[C <: Component](component: C) = {
    addComponent(component)
    component
  }

  lazy val componentSet = new mutable.Set[Component] with Serializable {

    import scala.collection.JavaConverters._

    def contains(key: Component) = {
      iterator.contains(key)
    }

    def iterator: Iterator[Component] = {
      ComponentContainerMixin.this.iterator().asScala
    }

    def +=(elem: Component) = { addComponent(elem); this }

    def -=(elem: Component) = { removeComponent(elem); this }
  }

}
