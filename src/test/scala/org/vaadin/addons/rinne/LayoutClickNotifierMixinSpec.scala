package org.vaadin.addons.rinne

import com.vaadin.event.LayoutEvents.{LayoutClickEvent, LayoutClickListener}
import org.scalatest.FunSpec

class LayoutClickNotifierMixinSpec extends FunSpec {

  describe("layoutClickListeners should") {

    val listener1 = (e: LayoutClickEvent) => println("1")
    val listener2 = (e: LayoutClickEvent) => println(e)

    it("layoutClickListeners.add a listener to layout") {
      val layout = new VVerticalLayout

      layout.layoutClickListeners += (println(_))

      assert(layout.layoutClickListeners.size === 1)
    }

    it("layoutClickListeners.remove a listener from layout") {
      val layout = new VVerticalLayout

      layout.layoutClickListeners += listener1
      layout.layoutClickListeners -= listener1

      assert(layout.layoutClickListeners.size === 0)
    }

    it("layoutClickListeners.iterator returns added listeners") {
      val layout = new VVerticalLayout

      layout.layoutClickListeners += listener1
      layout.layoutClickListeners += listener2

      val iter = layout.layoutClickListeners.iterator
      assert(iter.next() === listener1)
      assert(iter.next() === listener2)
      assert(!iter.hasNext)
    }

    it("layoutClickListeners.contains returns true for added listener") {
      val layout = new VVerticalLayout

      layout.layoutClickListeners += listener1
      assert(layout.layoutClickListeners.contains(listener1))
    }

    it("layoutClickListeners.contains returns false for non-added listener") {
      val layout = new VVerticalLayout

      assert(!layout.layoutClickListeners.contains(listener2))
    }

    it("execute listeners") {
      var executed = false
      val layout = new VVerticalLayout {
        layoutClickListeners += {
          executed = true
        }
      }

      import scala.collection.JavaConverters._
      layout.getListeners(classOf[LayoutClickEvent]).asScala
        .foreach { case e: LayoutClickListener => e.layoutClick(null) }
      assert(executed)
    }
  }
}
