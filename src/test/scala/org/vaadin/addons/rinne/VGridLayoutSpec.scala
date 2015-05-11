package org.vaadin.addons.rinne

import com.vaadin.ui.Alignment
import org.mockito.Mockito
import org.scalatest.FunSpec
import org.scalatest.mock.MockitoSugar

class VGridLayoutSpec extends FunSpec with MockitoSugar {

  describe("A VGridLayout") {

    var layout = Mockito.spy(new VGridLayout)

    describe("should allow to set") {

      it("rows and columns") {
        layout.rows = 10
        layout.columns = 10

        assert(layout.rows === 10)
        assert(layout.columns === 10)
      }

      it("curosrX and cursorY") {
        layout.cursorX = 8
        layout.cursorY = 9

        assert(layout.cursorX === 8)
        assert(layout.cursorY === 9)
      }
    }

    it("add(component)") {
      val label = new VLabel
      layout.add(label)
      Mockito.verify(layout).addComponent(label)
    }

    it("add(component, alignment)") {
      val label = new VLabel
      layout.add(label, alignment = Alignment.BOTTOM_CENTER)
      Mockito.verify(layout).setComponentAlignment(label, Alignment.BOTTOM_CENTER)
    }

    it("add(component, row, col)") {
      val label = new VLabel
      layout.add(label, 5, 5)
      Mockito.verify(layout).addComponent(label, 5, 5)
    }

    it("add(component, row, col, row2, col2)") {
      val label = new VLabel
      layout.add(label, 1, 2, 3, 4)
      Mockito.verify(layout).addComponent(label, 1, 2, 3, 4)
    }
  }
}