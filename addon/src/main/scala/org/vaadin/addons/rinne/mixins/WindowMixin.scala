package org.vaadin.addons.rinne.mixins

import org.vaadin.addons.rinne.KeyShortcut
import org.vaadin.addons.rinne.event._
import com.vaadin.ui.Window

trait WindowMixin extends Window with PanelMixin with BlurNotifier with FocusNotifier {

  private var _closeKeyShortcut: Option[KeyShortcut] = None

  def closeKeyShortcut: Option[KeyShortcut] = _closeKeyShortcut

  def closeKeyShortcut_=(cs: Option[KeyShortcut]): Unit = {
    _closeKeyShortcut = cs
    closeKeyShortcut match {
      case None => removeCloseShortcut()
      case Some(closeKeyShortcut) =>
        setCloseShortcut(closeKeyShortcut.keyCode.value, closeKeyShortcut.modifiers.map(_.value): _*)
    }
  }

  def closeKeyShortcut_=(cs: KeyShortcut): Unit = this.closeKeyShortcut = Option(cs)

  def positionX_=(positionX: Int): Unit = setPositionX(positionX)

  def positionX: Int = getPositionX

  def positionY_=(positionY: Int): Unit = setPositionY(positionY)

  def positionY: Int = getPositionY

  def resizable_=(resizable: Boolean): Unit = setResizable(resizable)

  def resizable: Boolean = isResizable

  def modal_=(modal: Boolean): Unit = setModal(modal)

  def modal: Boolean = isModal

  def closable_=(closable: Boolean): Unit = setClosable(closable)

  def closable: Boolean = isClosable

  def draggable_=(draggable: Boolean) = setDraggable(draggable)

  def draggable: Boolean = isDraggable

  lazy val closeListeners: ListenersSet[Window.CloseEvent => Unit] =
    new ListenersTrait[Window.CloseEvent, WindowCloseListener] {
      override def listeners = getListeners(classOf[com.vaadin.ui.Window.CloseListener])

      override def addListener(elem: Window.CloseEvent => Unit) = addCloseListener(new WindowCloseListener(elem))

      override def removeListener(elem: WindowCloseListener) = removeCloseListener(elem)
    }

  lazy val resizeListeners: ListenersSet[Window.ResizeEvent => Unit] =
    new ListenersTrait[Window.ResizeEvent, WindowResizeListener] {
      override def listeners = getListeners(classOf[com.vaadin.ui.Window.CloseListener])

      override def addListener(elem: Window.ResizeEvent => Unit) = addResizeListener(new WindowResizeListener(elem))

      override def removeListener(elem: WindowResizeListener) = removeResizeListener(elem)
    }
}
