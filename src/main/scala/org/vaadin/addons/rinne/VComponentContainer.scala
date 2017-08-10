package org.vaadin.addons.rinne

import com.vaadin.ui.{Component, ComponentContainer}

import scala.collection.mutable

class VComponentContainer(componentContainer: ComponentContainer) {

  lazy val components = new mutable.Set[Component] {

    import scala.collection.JavaConverters._

    def contains(key: Component): Boolean = {
      iterator.contains(key)
    }

    def iterator: Iterator[Component] = {
      componentContainer.iterator().asScala
    }

    def +=(elem: Component): this.type = {
      componentContainer.addComponent(elem)
      this
    }

    def -=(elem: Component): this.type = {
      componentContainer.removeComponent(elem)
      this
    }

    override def size = {
      componentContainer.getComponentCount
    }

    override def clear(): Unit = {
      componentContainer.removeAllComponents()
    }
  }
  
}
