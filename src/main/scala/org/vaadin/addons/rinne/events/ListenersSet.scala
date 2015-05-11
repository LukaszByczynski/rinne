package org.vaadin.addons.rinne.events

import java.util.{Collection => JCollection}

import scala.collection.mutable

trait ListenersSet[E, L] extends mutable.Set[E => Unit] with Serializable {
  type ListenerLambda = E => Unit

  import scala.collection.JavaConverters._

  abstract class Listener(val action: ListenerLambda)

  protected def addListener(listener: ListenerLambda): Unit

  protected def removeListener(listener: L): Unit

  protected def listeners: JCollection[_]

  override def contains(elem: ListenerLambda): Boolean = {
    iterator.contains(elem)
  }

  override def iterator: Iterator[ListenerLambda] = {
    listeners.asScala.map {
      case l: Listener => Some(l.action)
      case _ => None
    }.flatten.toIterator
  }

  override def +=(elem: ListenerLambda) = {
    addListener(elem)
    this
  }

  def +=(elem: => Unit) = {
    addListener(_ => elem)
    this
  }

  override def -=(elem: E => Unit) = {
    listeners.asScala.foreach {
      case e: Listener if e.action == elem => removeListener(e.asInstanceOf[L])
      case _ =>
    }
    this
  }

  override def clear(): Unit = {
    super.clear()
    listeners.asScala.foreach(_ => removeListener(_))
  }
}