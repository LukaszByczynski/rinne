package org.vaadin.addons.rinne

import java.util

import com.vaadin.ui.Window
import com.vaadin.ui.Window.{CloseEvent, CloseListener, ResizeEvent, ResizeListener}
import org.vaadin.addons.rinne.events.ListenersSet
import org.vaadin.addons.rinne.mixins.{BlurNotifierMixin, FocusNotifierMixin, PanelMixin}

class VWindow extends Window with PanelMixin with BlurNotifierMixin with FocusNotifierMixin {

  lazy val closeListeners = new ListenersSet[CloseEvent, CloseListener] {

    override protected def addListener(listener: ListenerLambda): Unit = addCloseListener(
      new Listener(listener) with CloseListener {
        override def windowClose(e: CloseEvent): Unit = listener(e)
      }
    )

    override protected def removeListener(listener: CloseListener): Unit = removeCloseListener(listener)

    override protected def listeners: util.Collection[_] = getListeners(classOf[CloseEvent])
  }

  lazy val resizeListeners = new ListenersSet[ResizeEvent, ResizeListener] {

    override protected def addListener(listener: ListenerLambda): Unit = addResizeListener(
      new Listener(listener) with ResizeListener {
        override def windowResized(e: ResizeEvent): Unit = listener(e)
      }
    )

    override protected def removeListener(listener: ResizeListener): Unit = removeResizeListener(listener)

    override protected def listeners: util.Collection[_] = getListeners(classOf[ResizeEvent])
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

  def positionX: Int = getPositionX

  def positionX_=(positionX: Int): Unit = setPositionX(positionX)

  def closeKeyShortcut: Option[KeyShortcut] = _closeKeyShortcut

  def positionY: Int = getPositionY

  def positionY_=(positionY: Int): Unit = setPositionY(positionY)

  def closeKeyShortcut_=(cs: KeyShortcut): Unit = this.closeKeyShortcut = Option(cs)

  def resizable: Boolean = isResizable

  def resizable_=(resizable: Boolean): Unit = setResizable(resizable)

  def modal: Boolean = isModal

  def modal_=(modal: Boolean): Unit = setModal(modal)

  def closable: Boolean = isClosable

  def closable_=(closable: Boolean): Unit = setClosable(closable)

  def draggable: Boolean = isDraggable

  def draggable_=(draggable: Boolean) = setDraggable(draggable)


}
