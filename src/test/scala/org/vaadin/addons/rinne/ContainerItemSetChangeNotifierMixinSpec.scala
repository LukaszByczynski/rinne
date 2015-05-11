package org.vaadin.addons.rinne

import com.vaadin.data.Container
import org.scalatest.FunSpec

class ContainerItemSetChangeNotifierMixinSpec extends FunSpec {

  describe("itemSetChangeListeners should") {

    val listener1 = (e: Container.ItemSetChangeEvent) => println("1")
    val listener2 = (e: Container.ItemSetChangeEvent) => println(e)

    it("itemSetChangeListeners.add a listener to listSelect") {
      val listSelect = new VListSelect

      listSelect.itemSetChangeListeners += (println(_))

      assert(listSelect.itemSetChangeListeners.size === 1)
    }

    it("itemSetChangeListeners.remove a listener from listSelect") {
      val listSelect = new VListSelect

      listSelect.itemSetChangeListeners += listener1
      listSelect.itemSetChangeListeners -= listener1

      assert(listSelect.itemSetChangeListeners.size === 0)
    }

    it("itemSetChangeListeners.iterator returns added listeners") {
      val listSelect = new VListSelect

      listSelect.itemSetChangeListeners += listener1
      listSelect.itemSetChangeListeners += listener2

      val iter = listSelect.itemSetChangeListeners.iterator
      assert(iter.next() === listener1)
      assert(iter.next() === listener2)
      assert(!iter.hasNext)
    }

    it("itemSetChangeListeners.contains returns true for added listener") {
      val listSelect = new VListSelect

      listSelect.itemSetChangeListeners += listener1
      assert(listSelect.itemSetChangeListeners.contains(listener1))
    }

    it("itemSetChangeListeners.contains returns false for non-added listener") {
      val listSelect = new VListSelect

      assert(!listSelect.itemSetChangeListeners.contains(listener2))
    }

    it("execute listeners") {
      var executed = false
      val listSelect = new VListSelect {
        itemSetChangeListeners += {
          executed = true
        }
      }

      import scala.collection.JavaConverters._
      listSelect.getListeners(classOf[Container.ItemSetChangeEvent]).asScala
        .foreach { case e: Container.ItemSetChangeListener => e.containerItemSetChange(null) }
      assert(executed)
    }
  }
}
