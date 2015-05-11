package org.vaadin.addons.rinne

import org.scalatest.FunSpec

class VPopupDateFieldSpec extends FunSpec {

  describe("A VPopupDateField") {

    describe("should allow to set") {

      it("contentMode") {
        val dateField = new VPopupDateField

        assert(dateField.prompt === None)
        dateField.prompt = "asaw"
        assert(dateField.prompt === Some("asaw"))

        dateField.prompt = None
        assert(dateField.prompt === None)
      }
    }
  }
}