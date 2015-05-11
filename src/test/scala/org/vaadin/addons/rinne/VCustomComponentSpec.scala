package org.vaadin.addons.rinne

import org.scalatest.FunSpec

class VCustomComponentSpec extends FunSpec {

  describe("A VCCustomComponent") {

    describe("should allow to set") {

      it("compositionRoot") {
        val component = new VCustomComponent
        val label = new VLabel

        assert(component.compositionRoot === None)
        component.compositionRoot = label
        assert(component.compositionRoot === Some(label))

        component.compositionRoot = None
        assert(component.compositionRoot === None)
      }
    }
  }
}
