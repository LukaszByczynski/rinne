package org.vaadin.addons.rinne

import org.scalatest.FunSpec

class VAbsoluteLayoutSpec extends FunSpec {

  describe("An VAbsoluteLayout") {

    val label = new VLabel
    val layout = new VAbsoluteLayout {
      add(label, "top: 10px; left: 100em")
    }

    it("getPosition returns None for non-contained Component") {
      assert(Option(layout.getPosition(new VLabel))
        === None)
    }

    it("ComponentPosition.cssString") {
      assert(layout.getPosition(label).getCSSString === "top:10.0px;left:100.0em;")
    }
  }
}