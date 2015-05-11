package org.vaadin.addons.rinne

import com.vaadin.data.Property
import org.scalatest.FunSpec

class PropertyValueChangeNotifierMixinSpec extends FunSpec {
  describe("valueChangeListeners should") {

    val listener1 = (e: Property.ValueChangeEvent) => println("1")
    val listener2 = (e: Property.ValueChangeEvent) => println(e)

    it("valueChangeListeners.add a listener to table") {
      val table = new VTable

      table.valueChangeListeners += (println(_))

      assert(table.valueChangeListeners.size === 1)
    }

    it("valueChangeListeners.remove a listener from table") {
      val table = new VTable

      table.valueChangeListeners += listener1
      table.valueChangeListeners -= listener1

      assert(table.valueChangeListeners.size === 0)
    }

    it("valueChangeListeners.iterator returns added listeners") {
      val table = new VTable

      table.valueChangeListeners += listener1
      table.valueChangeListeners += listener2

      val iter = table.valueChangeListeners.iterator
      assert(iter.next() === listener1)
      assert(iter.next() === listener2)
      assert(!iter.hasNext)
    }

    it("valueChangeListeners.contains returns true for added listener") {
      val table = new VTable

      table.valueChangeListeners += listener1
      assert(table.valueChangeListeners.contains(listener1))
    }

    it("valueChangeListeners.contains returns false for non-added listener") {
      val table = new VTable

      assert(!table.valueChangeListeners.contains(listener2))
    }

    it("execute listeners") {
      var executed = false
      val table = new VTable {
        valueChangeListeners += {
          executed = true
        }
      }

      import scala.collection.JavaConverters._
      table.getListeners(classOf[Property.ValueChangeEvent]).asScala
        .foreach { case e: Property.ValueChangeListener => e.valueChange(null) }
      assert(executed)
    }
  }

}