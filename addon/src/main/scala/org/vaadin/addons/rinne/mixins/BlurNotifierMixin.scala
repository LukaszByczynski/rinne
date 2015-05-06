package org.vaadin.addons.rinne.mixins

import java.util

import com.vaadin.event.FieldEvents.{BlurEvent, BlurListener, BlurNotifier}
import com.vaadin.ui.AbstractComponent
import org.vaadin.addons.rinne.events._

trait BlurNotifierMixin {
  this: AbstractComponent with BlurNotifier =>

  lazy val blurListeners = new ListenersSet[BlurEvent, BlurListener] {

    override protected def addListener(listener: ListenerLambda): Unit = addBlurListener(
      new Listener(listener) with BlurListener {
        override def blur(blurEvent: BlurEvent): Unit = listener(blurEvent)
      }
    )

    override protected def removeListener(listener: BlurListener): Unit = removeBlurListener(listener)

    override protected def listeners: util.Collection[_] = getListeners(classOf[BlurEvent])
  }
}
