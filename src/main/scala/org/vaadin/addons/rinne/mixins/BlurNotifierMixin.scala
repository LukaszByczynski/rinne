package org.vaadin.addons.rinne.mixins

import com.vaadin.event.FieldEvents.{BlurEvent, BlurListener, BlurNotifier}
import com.vaadin.ui.AbstractComponent
import org.vaadin.addons.rinne.events.ListenersSet

trait BlurNotifierMixin extends AbstractComponentMixin  with BlurNotifier {
  this: AbstractComponent =>

  lazy val blurListeners = new ListenersSet[BlurEvent, BlurListener] {

    override protected def addListener(listener: ListenerLambda): Unit = addBlurListener(
      (blurEvent: BlurEvent) => listener(blurEvent)
    )

    override protected def removeListener(listener: BlurListener): Unit = removeListener(listener)

    override protected def listeners: java.util.Collection[_] = getListeners(classOf[BlurEvent])
  }
}
