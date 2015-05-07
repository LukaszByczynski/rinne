package org.vaadin.addons.rinne.mixins

import java.util

import com.vaadin.ui.Button
import com.vaadin.ui.Button.ClickEvent
import org.vaadin.addons.rinne.KeyShortcut
import org.vaadin.addons.rinne.events.ListenersSet

trait ButtonMixin extends AbstractComponentMixin with BlurNotifierMixin with FocusNotifierMixin with FocusableMixin {
  this: Button =>

  lazy val clickListeners = new ListenersSet[Button.ClickEvent, Button.ClickListener] {
    override protected def addListener(listener: ListenerLambda): Unit = addClickListener(
      new Listener(listener) with Button.ClickListener {
        override def buttonClick(event: ClickEvent): Unit = listener(event)
      }
    )

    override protected def removeListener(listener: Button.ClickListener): Unit = removeClickListener(listener)

    override protected def listeners: util.Collection[_] = getListeners(classOf[Button.ClickEvent])
  }
  private var _clickKeyShortcut: Option[KeyShortcut] = None

  def clickKeyShortcut_=(clickShortcut: Option[KeyShortcut]): Unit = {
    _clickKeyShortcut = clickShortcut
    clickShortcut match {
      case Some(shortcut) => setClickShortcut(shortcut.keyCode.value, shortcut.modifiers.map(_.value): _*)
      case None => removeClickShortcut()
    }
  }

  def clickKeyShortcut: Option[KeyShortcut] = _clickKeyShortcut

  def disableOnClick: Boolean = isDisableOnClick

  def disableOnClick_=(disableOnClick: Boolean): Unit = {
    setDisableOnClick(disableOnClick)
  }

  def htmlContentAllowed: Boolean = isHtmlContentAllowed

  def clickKeyShortcut_=(clickShortcut: KeyShortcut): Unit =
  {
    this.clickKeyShortcut = Option(clickShortcut)
  }

  def htmlContentAllowed_=(htmlContentAllowed: Boolean): Unit = {
    setHtmlContentAllowed(htmlContentAllowed)
  }


}