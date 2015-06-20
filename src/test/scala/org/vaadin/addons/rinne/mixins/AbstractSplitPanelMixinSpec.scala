package org.vaadin.addons.rinne.mixins

import com.vaadin.ui.AbstractSplitPanel.{SplitterClickEvent, SplitterClickListener}
import org.scalatest.FunSpec
import org.vaadin.addons.rinne._

class AbstractSplitPanelMixinSpec extends FunSpec {

  describe("An AbstractSplitPanelMixin") {

    it("default splitPosition") {
      val splitPanel = new VVerticalSplitPanel()

      assert(splitPanel.splitPosition === Measure(50, Units.pct))
      assert(splitPanel.getSplitPosition === 50)
      assert(splitPanel.getSplitPositionUnit === com.vaadin.server.Sizeable.Unit.PERCENTAGE)
    }

    it("set firstComponent") {
      val splitPanel = new VVerticalSplitPanel()
      val label = new VLabel

      assert(splitPanel.firstComponent === None)
      splitPanel.firstComponent = label
      assert(splitPanel.firstComponent === Some(label))
      splitPanel.firstComponent = None
      assert(splitPanel.firstComponent === None)
    }

    it("set secondComponent") {
      val splitPanel = new VVerticalSplitPanel()
      val label = new VLabel

      assert(splitPanel.secondComponent === None)
      splitPanel.secondComponent = label
      assert(splitPanel.secondComponent === Some(label))
      splitPanel.secondComponent = None
      assert(splitPanel.secondComponent === None)
    }

    it("set locked") {
      val splitPanel = new VVerticalSplitPanel()

      splitPanel.locked = true
      assert(splitPanel.locked === true)
      splitPanel.locked = false
      assert(splitPanel.locked === false)
    }

    it("set splitPosition to 100px") {
      val splitPanel = new VVerticalSplitPanel()

      splitPanel.splitPosition = 100.px
      assert(splitPanel.splitPosition === 100.px.get)
      assert(splitPanel.getSplitPosition === 100)
      assert(splitPanel.getSplitPositionUnit === com.vaadin.server.Sizeable.Unit.PIXELS)
    }

    it("set splitPosition to None") {
      val splitPanel = new VVerticalSplitPanel

      splitPanel.splitPosition = None
      assert(splitPanel.splitPosition === Measure(50, Units.pct))
      assert(splitPanel.getSplitPosition === 50)
      assert(splitPanel.getSplitPositionUnit === com.vaadin.server.Sizeable.Unit.PERCENTAGE)
    }

    it("minSplitPosition") {
      val splitPanel = new VVerticalSplitPanel

      assert(Some(splitPanel.minSplitPosition) === 0.pct)

      splitPanel.minSplitPosition = 10.px

      assert(Some(splitPanel.minSplitPosition) === 10.px)

      splitPanel.minSplitPosition = None
      assert(Some(splitPanel.minSplitPosition) === 0.pct)
    }

    it("maxSplitPosition") {
      val splitPanel = new VVerticalSplitPanel()

      assert(Some(splitPanel.maxSplitPosition) === 100.pct)

      splitPanel.maxSplitPosition = 10.px

      assert(Some(splitPanel.maxSplitPosition) === 10.px)

      splitPanel.maxSplitPosition = None
      assert(Some(splitPanel.maxSplitPosition) === 100.pct)
    }
    describe("splitterClickListeners should") {

      val listener1 = (e: SplitterClickEvent) => println("1")
      val listener2 = (e: SplitterClickEvent) => println(e)

      it("splitterClickListeners.add a listener to splitPanel") {
        val splitPanel = new VVerticalSplitPanel

        splitPanel.splitterClickListeners += (println(_))

        assert(splitPanel.splitterClickListeners.size === 1)
      }

      it("splitterClickListeners.remove a listener from splitPanel") {
        val splitPanel = new VVerticalSplitPanel

        splitPanel.splitterClickListeners += listener1
        splitPanel.splitterClickListeners -= listener1

        assert(splitPanel.splitterClickListeners.size === 0)
      }

      it("splitterClickListeners.iterator returns added listeners") {
        val splitPanel = new VVerticalSplitPanel

        splitPanel.splitterClickListeners += listener1
        splitPanel.splitterClickListeners += listener2

        val iter = splitPanel.splitterClickListeners.iterator
        assert(iter.next() === listener1)
        assert(iter.next() === listener2)
        assert(!iter.hasNext)
      }

      it("splitterClickListeners.contains returns true for added listener") {
        val splitPanel = new VVerticalSplitPanel

        splitPanel.splitterClickListeners += listener1
        assert(splitPanel.splitterClickListeners.contains(listener1))
      }

      it("splitterClickListeners.contains returns false for non-added listener") {
        val splitPanel = new VVerticalSplitPanel

        assert(!splitPanel.splitterClickListeners.contains(listener2))
      }

      it("execute listeners") {
        var executed = false
        val splitPanel = new VVerticalSplitPanel {
          splitterClickListeners += {
            executed = true
          }
        }

        import scala.collection.JavaConverters._
        splitPanel.getListeners(classOf[SplitterClickEvent]).asScala
          .foreach { case e: SplitterClickListener => e.splitterClick(null) }
        assert(executed)
      }
    }

  }
}
