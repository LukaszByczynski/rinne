package org.vaadin.addons.rinne

import org.scalatest.FunSpec

class VRichTextAreaSpec extends FunSpec {

  describe("A VRichTextArea") {

    describe("should allow to set") {

      it("nullRepresentation") {
        val field = new VRichTextArea

        field.nullRepresentation = "qwe"
        assert(field.nullRepresentation === "qwe")
      }

      it("nullSettingAllowed") {
        val field = new VRichTextArea

        field.nullSettingAllowed = true
        assert(field.nullSettingAllowed === true)
      }
    }
  }
}