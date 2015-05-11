package org.vaadin.addons.rinne

import org.scalatest.FunSpec

class VCustomLayoutSpec extends FunSpec {

  describe("A VCCustomComponent") {

    describe("should allow to set") {

      it("templateContents") {
        val layout = new VCustomLayout

        assert(layout.templateContents === None)
        layout.templateContents = "aaaa"
        assert(layout.templateContents === Some("aaaa"))
      }

      it("templateName") {
        val layout = new VCustomLayout

        assert(layout.templateName === None)
        layout.templateName = "aaaa"
        assert(layout.templateName === Some("aaaa"))
      }
    }

    it("should add component with location") {
      val layout = new VCustomLayout
      val label = new VLabel

      layout.add(label, "bbb")
      assert(Option(layout.getComponent("ccc")) === None)
      assert(layout.getComponent("bbb") === label)
    }
  }
}