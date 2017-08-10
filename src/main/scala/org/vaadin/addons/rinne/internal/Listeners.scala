package org.vaadin.addons.rinne.v8.internal

import com.vaadin.shared.Registration

import scala.collection.mutable

trait ListenersSet[T, L] extends mutable.Set[L] {

  protected var listenersMap: Map[L, Registration] = Map()

  protected def addListener(listener: L): Registration
  protected def createListener(action: => Unit): L

  def +=(elem: => Unit): ListenersSet.this.type = {
    +=(createListener(elem))
    this
  }

  override def +=(elem: L): ListenersSet.this.type = {
    listenersMap = listenersMap + (elem -> addListener(elem))
    this
  }

  override def -=(elem: L): ListenersSet.this.type = {
    listenersMap.get(elem).foreach {
      registration =>
        listenersMap = listenersMap - elem
        registration.remove()
    }
    this
  }

  override def contains(elem: L): Boolean = {
    listenersMap.contains(elem)
  }

  override def iterator: Iterator[L] = {
    listenersMap.keysIterator
  }

  override def clear(): Unit = {
    super.clear()
    listenersMap.keys.foreach(-=)
  }
}
