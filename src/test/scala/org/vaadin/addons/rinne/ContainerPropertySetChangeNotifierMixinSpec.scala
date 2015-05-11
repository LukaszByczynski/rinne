package org.vaadin.addons.rinne

import com.vaadin.data.Container
import org.scalatest.FunSpec

class ContainerPropertySetChangeNotifierMixinSpec extends FunSpec {

  describe("propertySetChangeListeners should") {

    val listener1 = (e: Container.PropertySetChangeEvent) => println("1")
    val listener2 = (e: Container.PropertySetChangeEvent) => println(e)

    it("propertySetChangeListeners.add a listener to listSelect") {
      val listSelect = new VListSelect

      listSelect.propertySetChangeListeners += (println(_))

      assert(listSelect.propertySetChangeListeners.size === 1)
    }

    it("propertySetChangeListeners.remove a listener from listSelect") {
      val listSelect = new VListSelect

      listSelect.propertySetChangeListeners += listener1
      listSelect.propertySetChangeListeners -= listener1

      assert(listSelect.propertySetChangeListeners.size === 0)
    }

    it("propertySetChangeListeners.iterator returns added listeners") {
      val listSelect = new VListSelect

      listSelect.propertySetChangeListeners += listener1
      listSelect.propertySetChangeListeners += listener2

      val iter = listSelect.propertySetChangeListeners.iterator
      assert(iter.next() === listener1)
      assert(iter.next() === listener2)
      assert(!iter.hasNext)
    }

    it("propertySetChangeListeners.contains returns true for added listener") {
      val listSelect = new VListSelect

      listSelect.propertySetChangeListeners += listener1
      assert(listSelect.propertySetChangeListeners.contains(listener1))
    }

    it("propertySetChangeListeners.contains returns false for non-added listener") {
      val listSelect = new VListSelect

      assert(!listSelect.propertySetChangeListeners.contains(listener2))
    }

    it("execute listeners") {
      var executed = false
      val listSelect = new VListSelect {
        propertySetChangeListeners += {
          executed = true
        }
      }

      import scala.collection.JavaConverters._
      listSelect.getListeners(classOf[Container.PropertySetChangeEvent]).asScala
        .foreach { case e: Container.PropertySetChangeListener => e.containerPropertySetChange(null) }
      assert(executed)
    }
  }
}
