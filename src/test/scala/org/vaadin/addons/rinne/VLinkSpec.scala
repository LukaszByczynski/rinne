package org.vaadin.addons.rinne

import com.vaadin.server.ThemeResource
import com.vaadin.shared.ui.BorderStyle
import org.scalatest.FunSpec

class VLinkSpec extends FunSpec {

  describe("A VLink") {

    describe("should allow to set") {

      it("targetName") {
        val link = new VLink

        assert(link.targetName === None)
        link.targetName = "targetName"
        assert(link.targetName === Some("targetName"))

        link.targetName = None
        assert(link.targetName === None)
      }

      it("resource") {
        val link = new VLink
        val res = new ThemeResource("img.png")

        assert(link.resource === None)
        link.resource = res
        assert(link.resource === Some(res))

        link.resource = None
        assert(link.resource === None)
      }

      it("targetWidth") {
        val link = new VLink

        link.targetWidth = 200
        assert(link.targetWidth === 200)
      }

      it("targetHeight") {
        val link = new VLink

        link.targetHeight = 200
        assert(link.targetHeight === 200)
      }

      it("targetBorder") {
        val link = new VLink

        link.targetBorder = BorderStyle.MINIMAL
        assert(link.targetBorder === BorderStyle.MINIMAL)
      }
    }
  }
}