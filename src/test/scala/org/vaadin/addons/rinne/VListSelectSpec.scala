package org.vaadin.addons.rinne

import org.scalatest.FunSpec

class VListSelectSpec extends FunSpec {

  describe("A VListSelect") {

    describe("should allow to set") {

      it("rows") {
        val list = new VListSelect

        list.rows = 22
        assert(list.rows === 22)
      }
    }
  }
}