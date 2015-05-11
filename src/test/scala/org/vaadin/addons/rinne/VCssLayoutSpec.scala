package org.vaadin.addons.rinne

import org.scalatest.FunSpec

class VCssLayoutSpec extends FunSpec {

  describe("A VCssLayout should") {

    it("add component with css") {
      val layout = new VCssLayout

      layout.add(new VLabel, "css")
      assert(layout.componentSet.size === 1)
    }

    it("get CSS for component") {
      val layout = new VCssLayout
      var label = new VLabel

      assert(layout.add(label, "css") === label)
      assert(layout.getCssForComponent(label) === Some("css"))
    }

    it("get None if CSS is not set for component") {
      val layout = new VCssLayout
      var label = new VLabel

      layout.add(label)
      assert(layout.getCssForComponent(label) === None)
    }

    it("remove from map") {
      val layout = new VCssLayout
      var label = new VLabel

      layout.add(label, "css")
      assert(layout.getCssForComponent(label) === Some("css"))
      layout.removeComponent(label)
      assert(layout.getCssForComponent(label) === None)
    }
  }
}
