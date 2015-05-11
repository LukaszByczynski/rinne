package org.vaadin.addons.rinne

import org.scalatest.FunSpec

class VCheckBoxSpec extends FunSpec {

  describe("A VCheckBox") {

    describe("should allow to set") {

      it("value") {
        val checkBox = new VCheckBox()

        assert(checkBox.value === Some(false))

        checkBox.value = true
        assert(checkBox.value === Some(true))
      }

      it("boolValue") {
        val checkBox = new VCheckBox()

        assert(checkBox.boolValue === false)

        checkBox.value = true
        assert(checkBox.boolValue === true)
      }
    }
  }
}