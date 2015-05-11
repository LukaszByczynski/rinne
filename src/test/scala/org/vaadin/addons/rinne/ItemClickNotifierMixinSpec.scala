package org.vaadin.addons.rinne

import com.vaadin.event.ItemClickEvent
import com.vaadin.event.ItemClickEvent.ItemClickListener
import org.scalatest.FunSpec

class ItemClickNotifierMixinSpec extends FunSpec {

  describe("itemClickListeners should") {

    val listener1 = (e: ItemClickEvent) => println("1")
    val listener2 = (e: ItemClickEvent) => println(e)

    it("itemClickListeners.add a listener to table") {
      val table = new VTable

      table.itemClickListeners += (println(_))

      assert(table.itemClickListeners.size === 1)
    }

    it("itemClickListeners.remove a listener from table") {
      val table = new VTable

      table.itemClickListeners += listener1
      table.itemClickListeners -= listener1

      assert(table.itemClickListeners.size === 0)
    }

    it("itemClickListeners.iterator returns added listeners") {
      val table = new VTable

      table.itemClickListeners += listener1
      table.itemClickListeners += listener2

      val iter = table.itemClickListeners.iterator
      assert(iter.next() === listener1)
      assert(iter.next() === listener2)
      assert(!iter.hasNext)
    }

    it("itemClickListeners.contains returns true for added listener") {
      val table = new VTable

      table.itemClickListeners += listener1
      assert(table.itemClickListeners.contains(listener1))
    }

    it("itemClickListeners.contains returns false for non-added listener") {
      val table = new VTable

      assert(!table.itemClickListeners.contains(listener2))
    }

    it("execute listeners") {
      var executed = false
      val table = new VTable {
        itemClickListeners += {
          executed = true
        }
      }

      import scala.collection.JavaConverters._
      table.getListeners(classOf[ItemClickEvent]).asScala
        .foreach { case e: ItemClickListener => e.itemClick(null) }
      assert(executed)
    }
  }
}
