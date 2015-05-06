package org.vaadin.addons.rinne.events

import java.util.{Collection => JCollection}

import scala.collection.mutable

trait ListenersSet[E, L] extends mutable.Set[E => Unit] with Serializable {
  type ListenerLambda = E => Unit

  import scala.collection.JavaConverters._

  abstract class Listener(val action: ListenerLambda) extends L

  protected def addListener(listener: ListenerLambda): Unit

  protected def removeListener(listener: L): Unit

  protected def listeners: JCollection[_]

  override def contains(elem: ListenerLambda): Boolean = {
    iterator.contains(elem)
  }

  override def iterator: Iterator[ListenerLambda] = {
    listeners.asScala.map {
      case l: L with Listener => Some(l.action)
      case _ => None
    }.flatten.toIterator
  }

  override def +=(elem: ListenerLambda): ListenersSet[E, L] = {
    addListener(elem)
    this
  }

  override def -=(elem: E => Unit): ListenersSet[E, L] = {
    listeners.asScala.foreach {
      case e: L with Listener if e == elem => removeListener(e)
      case _ =>
    }
    this
  }
}