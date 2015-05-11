package org.vaadin.addons.rinne

import org.scalatest.FunSpec

class VTwinColSelectSpec extends FunSpec {

  describe("A VTextArea") {

    describe("should allow to set") {

      it("rows") {
        val twinColSelect = new VTwinColSelect

        assert(twinColSelect.rows === 0)

        twinColSelect.rows = 7
        assert(twinColSelect.rows === 7)
      }

      it("rightColumnCaption, String") {
        val twinColSelect = new VTwinColSelect

        twinColSelect.rightColumnCaption = "caption"
        assert(twinColSelect.rightColumnCaption === Some("caption"))
      }

      it("rightColumnCaption, Some") {
        val twinColSelect = new VTwinColSelect

        twinColSelect.rightColumnCaption = Some("caption")
        assert(twinColSelect.rightColumnCaption === Some("caption"))
      }

      it("rightColumnCaption, None") {
        val twinColSelect = new VTwinColSelect

        twinColSelect.rightColumnCaption = None
        assert(twinColSelect.rightColumnCaption === None)
      }

      it("leftColumnCaption, String") {
        val twinColSelect = new VTwinColSelect

        twinColSelect.leftColumnCaption = "caption"
        assert(twinColSelect.leftColumnCaption === Some("caption"))
      }

      it("leftColumnCaption, Some") {
        val twinColSelect = new VTwinColSelect

        twinColSelect.leftColumnCaption = Some("caption")
        assert(twinColSelect.leftColumnCaption === Some("caption"))
      }

      it("leftColumnCaption, None") {
        val twinColSelect = new VTwinColSelect

        twinColSelect.leftColumnCaption = None
        assert(twinColSelect.leftColumnCaption === None)
      }
    }
  }
}
