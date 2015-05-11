package org.vaadin.addons.rinne

import org.scalatest.FunSpec

class VTextAreaSpec extends FunSpec {

  describe("A VTextArea") {

    describe("should allow to set") {

      it("wordwrap") {
        val field = new VTextArea

        field.wordwrap = true
        assert(field.wordwrap === true)
      }

      it("rows") {
        val field = new VTextArea

        field.rows = 213
        assert(field.rows === 213)
      }
    }
  }
}