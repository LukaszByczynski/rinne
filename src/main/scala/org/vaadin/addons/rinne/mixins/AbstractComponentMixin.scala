package org.vaadin.addons.rinne.mixins

import java.util
import java.util.Locale

import com.vaadin.event.ShortcutListener
import com.vaadin.server.ClientConnector.{AttachEvent, AttachListener, DetachEvent, DetachListener}
import com.vaadin.ui.AbstractComponent
import org.vaadin.addons.rinne.KeyShortcutAction
import org.vaadin.addons.rinne.events.ListenersSet

trait AbstractComponentMixin extends ComponentMixin {
  this: AbstractComponent =>

  lazy val shortcutListeners = new ShortcutListenersSet()

  lazy val attachListeners = new ListenersSet[AttachEvent, AttachListener] {

    override protected def addListener(listener: ListenerLambda): Unit = addAttachListener(
      (attachEvent: AttachEvent) => listener.apply(attachEvent)
    )

    override protected def removeListener(listener: AttachListener): Unit = removeAttachListener(listener)

    override protected def listeners: util.Collection[_] = getListeners(classOf[AttachEvent])
  }

  lazy val detachListeners = new ListenersSet[DetachEvent, DetachListener] {

    override protected def addListener(listener: ListenerLambda): Unit = addDetachListener(
      (detachEvent: DetachEvent) => listener.apply(detachEvent)
    )

    override protected def removeListener(listener: DetachListener): Unit = removeDetachListener(listener)

    override protected def listeners: util.Collection[_] = getListeners(classOf[DetachEvent])
  }

  def locale_=(locale: Option[Locale]): Unit = setLocale(locale.orNull)

  def locale_=(locale: Locale): Unit = setLocale(locale)

  def captionAsHtml: Boolean = isCaptionAsHtml

  def captionAsHtml_=(captionAsHtml: Boolean): Unit = setCaptionAsHtml(captionAsHtml)

  def description: Option[String] = Option(getDescription)

  def description_=(description: Option[String]): Unit = setDescription(description.orNull)

  def description_=(description: String): Unit = setDescription(description)
  
  def data: Any = getData

  def data_=(data: Any): Unit = setData(data)

  class ShortcutListenersSet extends ListenersSet[Any, ShortcutListener] {

    private val _listenersToKeyShortcutActionMap = new util.HashMap[KeyShortcutAction, ShortcutListener]()

    def +=(elem: KeyShortcutAction) = {
      val listener = elem match {
        case KeyShortcutAction(Some(caption), None, None, key, action) =>
          new ShortcutListener(caption, key.keyCode.value, key.modifiers.map(_.value).toArray: _*) {
            override def handleAction(sender: scala.Any, target: scala.Any): Unit = action(sender, target)
          }
        case KeyShortcutAction(Some(caption), None, Some(icon), key, action) =>
          new ShortcutListener(caption, icon, key.keyCode.value, key.modifiers.map(_.value).toArray: _*) {
            override def handleAction(sender: scala.Any, target: scala.Any): Unit = action(sender, target)
          }
        case KeyShortcutAction(None, Some(shorthandCaption), None, key, action) =>
          new ShortcutListener(shorthandCaption, key.modifiers.map(_.value).toArray: _*) {
            override def handleAction(sender: scala.Any, target: scala.Any): Unit = action(sender, target)
          }
        case _ => throw new IllegalArgumentException("Unknow KeyShortcutAction argument configuration")
      }
      addShortcutListener(listener)
      _listenersToKeyShortcutActionMap.put(elem, listener)
      this
    }

    def -=(elem: KeyShortcutAction) = {
      Option(_listenersToKeyShortcutActionMap.remove(elem)) match {
        case Some(listener) => removeShortcutListener(listener)
        case _ =>
      }
      this
    }

    override def iterator: Iterator[ListenerLambda] = {
      import scala.collection.JavaConverters._
      _listenersToKeyShortcutActionMap.keySet().asScala.map { e =>
        new ListenerLambda {
          override def apply(v1: Any): Unit = e.action(v1, v1)
        }
      }.toIterator
    }

    override def listeners: util.Collection[_] = _listenersToKeyShortcutActionMap.values()

    override protected def addListener(listener: ListenerLambda): Unit = {
      throw new IllegalArgumentException("Use KeyShortcutAction instead ListenerLambda")
    }

    override protected def removeListener(listener: ShortcutListener): Unit = {
      throw new IllegalArgumentException("Use KeyShortcutAction instead ListenerLambda")
    }
  }

}
