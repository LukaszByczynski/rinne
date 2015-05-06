package org.vaadin.addons.rinne

import com.vaadin.ui.Window
import org.vaadin.addons.rinne.events._
import org.vaadin.addons.rinne.mixins.PanelMixin

class VWindow extends Window with PanelMixin with BlurNotifier with FocusNotifier {

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
  private var _closeKeyShortcut: Option[KeyShortcut] = None

  def closeKeyShortcut_=(cs: Option[KeyShortcut]): Unit = {
    _closeKeyShortcut = cs
    closeKeyShortcut match {
      case None => removeCloseShortcut()
      case Some(closeKeyShortcut) =>
        setCloseShortcut(closeKeyShortcut.keyCode.value, closeKeyShortcut.modifiers.map(_.value): _*)
    }
  }

  def closeKeyShortcut: Option[KeyShortcut] = _closeKeyShortcut

  def closeKeyShortcut_=(cs: KeyShortcut): Unit = this.closeKeyShortcut = Option(cs)

  def positionX: Int = getPositionX

  def positionX_=(positionX: Int): Unit = setPositionX(positionX)

  def positionY: Int = getPositionY

  def positionY_=(positionY: Int): Unit = setPositionY(positionY)

  def resizable: Boolean = isResizable

  def resizable_=(resizable: Boolean): Unit = setResizable(resizable)

  def modal: Boolean = isModal

  def modal_=(modal: Boolean): Unit = setModal(modal)

  def closable: Boolean = isClosable

  def closable_=(closable: Boolean): Unit = setClosable(closable)

  def draggable: Boolean = isDraggable

  def draggable_=(draggable: Boolean) = setDraggable(draggable)




}
