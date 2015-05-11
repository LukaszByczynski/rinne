package org.vaadin.addons.rinne

import org.scalatest.FunSpec

class VProgressBarSpec extends FunSpec {

  describe("A VPopupDateField") {

    describe("should allow to set") {

      it("contentMode") {
        val progressBar = new VProgressBar

        progressBar.indeterminate = true
        assert(progressBar.indeterminate === true)
      }
    }
  }
}