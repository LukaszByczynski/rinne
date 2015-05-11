package org.vaadin.addons.rinne

import com.vaadin.event.FieldEvents.{BlurEvent, BlurListener}
import org.scalatest.FunSpec

class BlurNotifierMixinSpec extends FunSpec {

  val listener1 = (e: BlurEvent) => println("1")
  val listener2 = (e: BlurEvent) => println(e)

  describe("blurListeners should") {
    it("blurListeners.add a listener to button") {
      val button = new VButton

      button.blurListeners += (println(_))

      assert(button.blurListeners.size === 1)
    }

    it("blurListeners.remove a listener from button") {
      val button = new VButton

      button.blurListeners += listener1
      button.blurListeners -= listener1

      assert(button.blurListeners.size === 0)
    }

    it("blurListeners.iterator returns added listeners") {
      val button = new VButton

      button.blurListeners += listener1
      button.blurListeners += listener2

      val iter = button.blurListeners.iterator
      assert(iter.next() === listener1)
      assert(iter.next() === listener2)
      assert(!iter.hasNext)
    }

    it("blurListeners.contains returns true for added listener") {
      val button = new VButton

      button.blurListeners += listener1
      assert(button.blurListeners.contains(listener1))
    }

    it("blurListeners.contains returns false for non-added listener") {
      val button = new VButton

      assert(!button.blurListeners.contains(listener2))
    }

    it("execute listeners") {
      var executed = false
      val button = new VButton {
        blurListeners += {
          executed = true
        }
      }

      import scala.collection.JavaConverters._
      button.getListeners(classOf[BlurEvent]).asScala
        .foreach { case e: BlurListener => e.blur(null) }
      assert(executed)
    }
  }
}