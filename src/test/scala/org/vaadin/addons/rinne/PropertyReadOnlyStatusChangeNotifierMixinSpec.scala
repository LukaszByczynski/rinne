package org.vaadin.addons.rinne

import com.vaadin.data.Property
import org.scalatest.FunSpec

class PropertyReadOnlyStatusChangeNotifierMixinSpec extends FunSpec {
  describe("readOnlyStatusChangeListeners should") {

    val listener1 = (e: Property.ReadOnlyStatusChangeEvent) => println("1")
    val listener2 = (e: Property.ReadOnlyStatusChangeEvent) => println(e)

    it("readOnlyStatusChangeListeners.add a listener to table") {
      val table = new VTable

      table.readOnlyStatusChangeListeners += (println(_))

      assert(table.readOnlyStatusChangeListeners.size === 1)
    }

    it("readOnlyStatusChangeListeners.remove a listener from table") {
      val table = new VTable

      table.readOnlyStatusChangeListeners += listener1
      table.readOnlyStatusChangeListeners -= listener1

      assert(table.readOnlyStatusChangeListeners.size === 0)
    }

    it("readOnlyStatusChangeListeners.iterator returns added listeners") {
      val table = new VTable

      table.readOnlyStatusChangeListeners += listener1
      table.readOnlyStatusChangeListeners += listener2

      val iter = table.readOnlyStatusChangeListeners.iterator
      assert(iter.next() === listener1)
      assert(iter.next() === listener2)
      assert(!iter.hasNext)
    }

    it("readOnlyStatusChangeListeners.contains returns true for added listener") {
      val table = new VTable

      table.readOnlyStatusChangeListeners += listener1
      assert(table.readOnlyStatusChangeListeners.contains(listener1))
    }

    it("readOnlyStatusChangeListeners.contains returns false for non-added listener") {
      val table = new VTable

      assert(!table.readOnlyStatusChangeListeners.contains(listener2))
    }

    it("execute listeners") {
      var executed = false
      val table = new VTable {
        readOnlyStatusChangeListeners += {
          executed = true
        }
      }

      import scala.collection.JavaConverters._
      table.getListeners(classOf[Property.ReadOnlyStatusChangeEvent]).asScala
        .foreach { case e: Property.ReadOnlyStatusChangeListener => e.readOnlyStatusChange(null) }
      assert(executed)
    }
  }

}