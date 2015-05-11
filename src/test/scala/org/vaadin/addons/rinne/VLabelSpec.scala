package org.vaadin.addons.rinne

import com.vaadin.shared.ui.label.ContentMode
import org.scalatest.FunSpec
import org.vaadin.addons.rinne.converters.Converters

class VLabelSpec extends FunSpec {

  describe("A VLabel") {

    describe("should allow to set") {

      it("contentMode") {
        val label = new VLabel

        assert(label.contentMode != ContentMode.HTML)
        label.contentMode = ContentMode.HTML
        assert(label.contentMode === ContentMode.HTML)
      }

      it("converter") {
        val label = new VLabel

        assert(label.converter === None)
        label.converter = Converters.optionToString
        assert(label.converter === Some(Converters.optionToString))

        label.converter = None
        assert(label.converter === None)
      }
    }
  }
}