package org.vaadin.addons.rinne

import com.vaadin.ui.Window
import com.vaadin.ui.Window.{CloseEvent, CloseListener, ResizeListener}
import org.mockito.Mockito
import org.scalatest.FunSpec

class VWindowSpec extends FunSpec {

  describe("A VWindow") {

    val window = Mockito.spy(new VWindow)

    describe("should allow to set") {

      it("content") {
        assert(window.content === None)
      }

      it("positionX") {
        assert(window.positionX === -1)

        window.positionX = 200
        assert(window.positionX === 200)
      }

      it("positionY") {
        assert(window.positionY === -1)

        window.positionY = 200
        assert(window.positionY === 200)
      }

      it("resizable") {
        assert(window.resizable)

        window.resizable = false
        assert(!window.resizable)
      }

      it("center()") {
        window.center()
        Mockito.verify(window).center()
      }

      it("modal") {
        assert(!window.modal)

        window.modal = true
        assert(window.modal)
      }

      it("closable") {
        assert(window.closable)

        window.closable = false
        assert(!window.closable)
      }

      it("draggable") {
        assert(window.draggable)

        window.draggable = false
        assert(!window.draggable)
      }

      it("closeShortcut") {
        val window = new VWindow

        val clickShortcut = KeyShortcut(KeyCode.Enter, KeyModifier.Alt)

        assert(window.closeKeyShortcut === None)

        window.closeKeyShortcut = clickShortcut
        assert(window.closeKeyShortcut === Some(clickShortcut))

        window.closeKeyShortcut = None
        assert(window.closeKeyShortcut === None)

        window.closeKeyShortcut = Some(clickShortcut)
        assert(window.closeKeyShortcut === Some(clickShortcut))
      }
    }

    describe("resizeListeners should") {

      val listener1 = (e: Window.ResizeEvent) => println("1")
      val listener2 = (e: Window.ResizeEvent) => println(e)

      it("resizeListeners.add a listener to window") {
        val window = new VWindow

        window.resizeListeners += (println(_))

        assert(window.resizeListeners.size === 1)
      }

      it("resizeListeners.remove a listener from window") {
        val window = new VWindow

        window.resizeListeners += listener1
        window.resizeListeners -= listener1

        assert(window.resizeListeners.size === 0)
      }

      it("resizeListeners.iterator returns added listeners") {
        val window = new VWindow

        window.resizeListeners += listener1
        window.resizeListeners += listener2

        val iter = window.resizeListeners.iterator
        assert(iter.next() === listener1)
        assert(iter.next() === listener2)
        assert(!iter.hasNext)
      }

      it("resizeListeners.contains returns true for added listener") {
        val window = new VWindow

        window.resizeListeners += listener1
        assert(window.resizeListeners.contains(listener1))
      }

      it("resizeListeners.contains returns false for non-added listener") {
        val window = new VWindow

        assert(!window.resizeListeners.contains(listener2))
      }

      it("execute listeners") {
        var executed = false
        val window = new VWindow {
          resizeListeners += {
            executed = true
          }
        }

        import scala.collection.JavaConverters._
        window.getListeners(classOf[Window.ResizeEvent]).asScala
          .foreach { case e: ResizeListener => e.windowResized(null) }
        assert(executed)
      }
    }

    describe("closeListeners should") {

      val listener1 = (e: Window.CloseEvent) => println("1")
      val listener2 = (e: Window.CloseEvent) => println(e)

      it("closeListeners.add a listener to window") {
        val window = new VWindow

        window.closeListeners += (println(_))

        assert(window.closeListeners.size === 1)
      }

      it("closeListeners.remove a listener from window") {
        val window = new VWindow

        window.closeListeners += listener1
        window.closeListeners -= listener1

        assert(window.closeListeners.size === 0)
      }

      it("closeListeners.iterator returns added listeners") {
        val window = new VWindow

        window.closeListeners += listener1
        window.closeListeners += listener2

        val iter = window.closeListeners.iterator
        assert(iter.next() === listener1)
        assert(iter.next() === listener2)
        assert(!iter.hasNext)
      }

      it("closeListeners.contains returns true for added listener") {
        val window = new VWindow

        window.closeListeners += listener1
        assert(window.closeListeners.contains(listener1))
      }

      it("closeListeners.contains returns false for non-added listener") {
        val window = new VWindow

        assert(!window.closeListeners.contains(listener2))
      }

      it("execute listeners") {
        var executed = false
        val window = new VWindow {
          closeListeners += {
            executed = true
          }
        }

        import scala.collection.JavaConverters._
        window.getListeners(classOf[CloseEvent]).asScala
          .foreach { case e: CloseListener => e.windowClose(null) }
        assert(executed)
      }
    }
  }
}
