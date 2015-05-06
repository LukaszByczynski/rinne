package org.vaadin.addons.rinne

import com.vaadin.ui.{Button, NativeButton}
import org.vaadin.addons.rinne.events._
import org.vaadin.addons.rinne.mixins.{AbstractComponentMixin, FocusableMixin}

class VNativeButton extends NativeButton with AbstractComponentMixin with BlurNotifier with FocusNotifier with FocusableMixin {

  lazy val clickListeners: ListenersSet[Button.ClickEvent => Unit] =
    new ListenersTrait[Button.ClickEvent, ButtonClickListener] {
      override def listeners = getListeners(classOf[Button.ClickEvent])

      override def addListener(elem: Button.ClickEvent => Unit) = addClickListener(new ButtonClickListener(elem))

      override def removeListener(elem: ButtonClickListener) = removeClickListener(elem)
    }
  private var _clickKeyShortcut: Option[KeyShortcut] = None

  def clickShortcut_=(clickShortcut: KeyShortcut) {
    this.clickKeyShortcut = Option(clickShortcut)
  }

  def clickKeyShortcut: Option[KeyShortcut] = _clickKeyShortcut

  def clickKeyShortcut_=(clickShortcut: Option[KeyShortcut]) {
    _clickKeyShortcut = clickShortcut
    clickShortcut match {
      case None => removeClickShortcut()
      case Some(shortcut) => setClickShortcut(shortcut.keyCode.value, shortcut.modifiers.map(_.value): _*)
    }
  }

  def disableOnClick: Boolean = isDisableOnClick

  def disableOnClick_=(disableOnClick: Boolean) {
    setDisableOnClick(disableOnClick)
  }

  def htmlContentAllowed: Boolean = isHtmlContentAllowed

  def htmlContentAllowed_=(htmlContentAllowed: Boolean) {
    setHtmlContentAllowed(htmlContentAllowed)
  }
}
