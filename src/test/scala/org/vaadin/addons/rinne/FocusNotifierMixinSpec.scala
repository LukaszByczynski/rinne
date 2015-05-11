package org.vaadin.addons.rinne

import com.vaadin.event.FieldEvents.{FocusEvent, FocusListener}
import org.scalatest.FunSpec

class FocusNotifierMixinSpec extends FunSpec {

  val listener1 = (e: FocusEvent) => println("1")
  val listener2 = (e: FocusEvent) => println(e)

  describe("focusListeners should") {
    it("focusListeners.add a listener to button") {
      val button = new VButton

      button.focusListeners += (println(_))

      assert(button.focusListeners.size === 1)
    }

    it("focusListeners.remove a listener from button") {
      val button = new VButton

      button.focusListeners += listener1
      button.focusListeners -= listener1

      assert(button.focusListeners.size === 0)
    }

    it("focusListeners.iterator returns added listeners") {
      val button = new VButton

      button.focusListeners += listener1
      button.focusListeners += listener2

      val iter = button.focusListeners.iterator
      assert(iter.next() === listener1)
      assert(iter.next() === listener2)
      assert(!iter.hasNext)
    }

    it("focusListeners.contains returns true for added listener") {
      val button = new VButton

      button.focusListeners += listener1
      assert(button.focusListeners.contains(listener1))
    }

    it("focusListeners.contains returns false for non-added listener") {
      val button = new VButton

      assert(!button.focusListeners.contains(listener2))
    }

    it("execute listeners") {
      var executed = false
      val button = new VButton {
        focusListeners += {
          executed = true
        }
      }

      import scala.collection.JavaConverters._
      button.getListeners(classOf[FocusEvent]).asScala
        .foreach { case e: FocusListener => e.focus(null) }
      assert(executed)
    }
  }
}