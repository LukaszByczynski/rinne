package org.vaadin.addons.rinne

import java.util

import com.vaadin.ui.PopupView.{PopupVisibilityEvent, PopupVisibilityListener}
import com.vaadin.ui.{Component, HasComponents, PopupView}
import org.vaadin.addons.rinne.events.ListenersSet
import org.vaadin.addons.rinne.mixins.AbstractComponentMixin

class VPopupView extends PopupView("", null) with AbstractComponentMixin with HasComponents {

  lazy val popupVisibilityListeners = new ListenersSet[PopupVisibilityEvent, PopupVisibilityListener] {
    override protected def addListener(listener: ListenerLambda): Unit = addPopupVisibilityListener(
      new Listener(listener) with PopupVisibilityListener {
        override def popupVisibilityChange(event: PopupVisibilityEvent): Unit = listener(event)
      }
    )

    override protected def removeListener(listener: PopupVisibilityListener): Unit = removePopupVisibilityListener(listener)

    override protected def listeners: util.Collection[_] = getListeners(classOf[PopupVisibilityEvent])
  }

  def minimizedHtmlValue: String = getContent.getMinimizedValueAsHTML

  def minimizedHtmlValue_=(minimizedHtmlValue: String): Unit = {
    val c = getContent.getPopupComponent
    setContent(
      new PopupView.Content {
        def getMinimizedValueAsHTML = minimizedHtmlValue

        def getPopupComponent = c
      }
    )
  }

  def popupContent_=(popupContent: Component) {
    this.popupContent = () => popupContent
  }

  def popupContent: Option[Component] = Option(getContent.getPopupComponent)

  def popupContent_=(popupContent: () => Component) {
    val html = getContent.getMinimizedValueAsHTML
    setContent(new PopupView.Content {
      def getMinimizedValueAsHTML = html

      def getPopupComponent = popupContent()
    })
  }

  def popupVisible: Boolean = isPopupVisible

  def popupVisible_=(popupVisible: Boolean) {
    setPopupVisible(popupVisible)
  }

  def hideOnMouseOut: Boolean = isHideOnMouseOut

  def hideOnMouseOut_=(hideOnMouseOut: Boolean): Unit = setHideOnMouseOut(hideOnMouseOut)
}