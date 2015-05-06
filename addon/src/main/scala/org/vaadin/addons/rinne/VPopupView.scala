package org.vaadin.addons.rinne

import com.vaadin.ui.{Component, HasComponents, PopupView}
import org.vaadin.addons.rinne.mixins.AbstractComponentMixin

class VPopupView extends PopupView("", null) with AbstractComponentMixin with HasComponents {

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

  //  lazy val popupVisibilityListeners: ListenersSet[PopupView.PopupVisibilityEvent => Unit] =
  //    new ListenersTrait[PopupView.PopupVisibilityEvent, PopupVisibilityListener] {
  //      override def listeners = getListeners(classOf[PopupView.PopupVisibilityEvent])
  //
  //      override def addListener(elem: PopupView.PopupVisibilityEvent => Unit) =
  //        addPopupVisibilityListener(new PopupVisibilityListener(elem))
  //
  //      override def removeListener(elem: PopupVisibilityListener) = removePopupVisibilityListener(elem)
  //    }
}
