package org.vaadin.addons.rinne

import com.vaadin.ui.Button
import org.scalatest.FunSpec

class ButtonMixinSpec extends FunSpec {

  val listener1 = (e: Button.ClickEvent) => println("1")
  val listener2 = (e: Button.ClickEvent) => println(e)

  describe("VButton") {

    describe("should allow to set") {

      it("disableOnClick") {
        val button = new VButton
        assert(!button.disableOnClick)
        button.disableOnClick = true
        assert(button.disableOnClick)
      }

      it("caption") {
        val button = new VButton
        assert(button.caption === None)

        button.caption = "Test"
        assert(button.caption === Some("Test"))

        button.caption = Some("Test")
        assert(button.caption === Some("Test"))
      }

      it("clickShortcut") {
        val clickShortcut = KeyShortcut(KeyCode.Enter, KeyModifier.Shift)
        val button = new VButton
        assert(button.clickKeyShortcut === None)

        button.clickKeyShortcut = clickShortcut
        assert(button.clickKeyShortcut === Some(clickShortcut))

        button.clickKeyShortcut = None
        assert(button.clickKeyShortcut === None)

        button.clickKeyShortcut = Some(clickShortcut)
        assert(button.clickKeyShortcut === Some(clickShortcut))
      }

      it("htmlContentAllowed") {
        val button = new VButton

        assert(!button.htmlContentAllowed)

        button.htmlContentAllowed = true
        assert(button.htmlContentAllowed)
      }
    }

    describe("clickListeners should") {
      it("clickListeners.add a listener to button") {
        val button = new VButton

        button.clickListeners += (println(_))

        assert(button.clickListeners.size === 1)
      }

      it("clickListeners.remove a listener from button") {
        val button = new VButton

        button.clickListeners += listener1
        button.clickListeners -= listener1

        assert(button.clickListeners.size === 0)
      }

      it("clickListeners.iterator returns added listeners") {
        val button = new VButton

        button.clickListeners += listener1
        button.clickListeners += listener2

        val iter = button.clickListeners.iterator
        assert(iter.next() === listener1)
        assert(iter.next() === listener2)
        assert(!iter.hasNext)
      }

      it("clickListeners.contains returns true for added listener") {
        val button = new VButton

        button.clickListeners += listener1
        assert(button.clickListeners.contains(listener1))
      }

      it("clickListeners.contains returns false for non-added listener") {
        val button = new VButton

        assert(!button.clickListeners.contains(listener2))
      }

      it("execute listeners") {
        var executed = false
        val button = new VButton {
          clickListeners += {
            executed = true
          }
        }

        import scala.collection.JavaConverters._
        button.getListeners(classOf[Button.ClickEvent]).asScala
          .foreach { case e: Button.ClickListener => e.buttonClick(null) }
        assert(executed)
      }
    }
  }

  describe("VNativeButton") {
    it("should be created") {
      val btn = new VNativeButton
    }
  }

}