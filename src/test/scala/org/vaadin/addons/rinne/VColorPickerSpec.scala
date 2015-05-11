package org.vaadin.addons.rinne

import com.vaadin.ui.components.colorpicker.{ColorChangeEvent, ColorChangeListener}
import org.scalatest.FunSpec

class VColorPickerSpec extends FunSpec {
  val listener1 = (e: ColorChangeEvent) => println("1")
  val listener2 = (e: ColorChangeEvent) => println(e)

  describe("A VColorPicker") {

    describe("colorChangeListeners should") {

      it("colorChangeListeners.add a listener to colorPicker") {
        val colorPicker = new VColorPicker

        colorPicker.colorChangeListeners += (println(_))

        assert(colorPicker.colorChangeListeners.size === 1)
      }

      it("colorChangeListeners.remove a listener from colorPicker") {
        val colorPicker = new VColorPicker

        colorPicker.colorChangeListeners += listener1
        colorPicker.colorChangeListeners -= listener1

        assert(colorPicker.colorChangeListeners.size === 0)
      }

      it("colorChangeListeners.iterator returns added listeners") {
        val colorPicker = new VColorPicker

        colorPicker.colorChangeListeners += listener1
        colorPicker.colorChangeListeners += listener2

        val iter = colorPicker.colorChangeListeners.iterator
        assert(iter.next() === listener1)
        assert(iter.next() === listener2)
        assert(!iter.hasNext)
      }

      it("colorChangeListeners.contains returns true for added listener") {
        val colorPicker = new VColorPicker

        colorPicker.colorChangeListeners += listener1
        assert(colorPicker.colorChangeListeners.contains(listener1))
      }

      it("colorChangeListeners.contains returns false for non-added listener") {
        val colorPicker = new VColorPicker

        assert(!colorPicker.colorChangeListeners.contains(listener2))
      }

      it("execute listeners") {
        var executed = false
        val colorPicker = new VColorPicker {
          colorChangeListeners += {
            executed = true
          }
        }

        import scala.collection.JavaConverters._
        colorPicker.getListeners(classOf[ColorChangeEvent]).asScala
          .foreach { case e: ColorChangeListener => e.colorChanged(null) }
        assert(executed)
      }
    }
  }
}