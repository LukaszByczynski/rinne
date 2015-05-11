package org.vaadin.addons.rinne

import org.scalatest.FunSpec

class VOptionGroupSpec extends FunSpec {

  describe("A VOptionGroup") {

    describe("should allow to set") {

      it("htmlContentAllowed") {
        val group = new VOptionGroup

        group.htmlContentAllowed = true
        assert(group.htmlContentAllowed === true)
      }
    }
  }
}