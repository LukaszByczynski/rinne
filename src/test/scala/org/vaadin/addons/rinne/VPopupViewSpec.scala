package org.vaadin.addons.rinne

import com.vaadin.ui.PopupView.{PopupVisibilityEvent, PopupVisibilityListener}
import org.scalatest.FunSpec

class VPopupViewSpec extends FunSpec {

  describe("A VPopupView") {

    describe("should allow to set") {

      it("popupVisible") {
        val popupView = new VPopupView

        popupView.popupContent = new VLabel // popupVisible = true requires that popup component has been set

        assert(popupView.popupVisible === false)

        popupView.popupVisible = true
        assert(popupView.popupVisible === true)
      }

      it("hideOnMouseOut") {
        val popupView = new VPopupView

        assert(popupView.hideOnMouseOut === true)

        popupView.hideOnMouseOut = false
        assert(popupView.hideOnMouseOut === false)
      }

      it("minimizedHtmlValue") {
        val popupView = new VPopupView

        val label = new VLabel
        assert(popupView.minimizedHtmlValue === "")

        popupView.popupContent = label
        popupView.minimizedHtmlValue = "test"
        assert(popupView.minimizedHtmlValue === "test")
        assert(popupView.popupContent === Some(label))
      }

      it("popupContent") {
        val popupView = new VPopupView

        val label = new VLabel
        assert(popupView.popupContent === None)

        popupView.minimizedHtmlValue = "test"
        popupView.popupContent = label
        assert(popupView.minimizedHtmlValue === "test")
        assert(popupView.popupContent === Some(label))
      }

      it("popupContent_=(() => component) should init component lazily when popup gets visible") {
        val popupView = new VPopupView

        var cnt = 0

        popupView.popupContent = () => new VLabel {
          cnt = cnt + 1
        }
        assert(cnt === 0)

        popupView.popupVisible = true
        assert(cnt === 1)
        popupView.popupVisible = false
        popupView.popupVisible = true
        assert(cnt === 2)
      }
    }

    describe("popupVisibilityListeners should") {
      val listener1 = (e: PopupVisibilityEvent) => println("1")
      val listener2 = (e: PopupVisibilityEvent) => println(e)


      it("popupVisibilityListeners.add a listener to popupView") {
        val popupView = new VPopupView

        popupView.popupVisibilityListeners += (println(_))

        assert(popupView.popupVisibilityListeners.size === 1)
      }

      it("popupVisibilityListeners.remove a listener from popupView") {
        val popupView = new VPopupView

        popupView.popupVisibilityListeners += listener1
        popupView.popupVisibilityListeners -= listener1

        assert(popupView.popupVisibilityListeners.size === 0)
      }

      it("popupVisibilityListeners.iterator returns added listeners") {
        val popupView = new VPopupView

        popupView.popupVisibilityListeners += listener1
        popupView.popupVisibilityListeners += listener2

        val iter = popupView.popupVisibilityListeners.iterator
        assert(iter.next() === listener1)
        assert(iter.next() === listener2)
        assert(!iter.hasNext)
      }

      it("popupVisibilityListeners.contains returns true for added listener") {
        val popupView = new VPopupView

        popupView.popupVisibilityListeners += listener1
        assert(popupView.popupVisibilityListeners.contains(listener1))
      }

      it("popupVisibilityListeners.contains returns false for non-added listener") {
        val popupView = new VPopupView

        assert(!popupView.popupVisibilityListeners.contains(listener2))
      }

      it("execute listeners") {
        var executed = false
        val popupView = new VPopupView {
          popupVisibilityListeners += {
            executed = true
          }
        }

        import scala.collection.JavaConverters._
        popupView.getListeners(classOf[PopupVisibilityEvent]).asScala
          .foreach { case e: PopupVisibilityListener => e.popupVisibilityChange(null) }
        assert(executed)
      }
    }
  }
}
