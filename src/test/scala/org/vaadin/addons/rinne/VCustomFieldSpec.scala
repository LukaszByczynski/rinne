package org.vaadin.addons.rinne

import com.vaadin.ui.Component
import org.scalatest.FunSpec

class VCustomFieldSpec extends FunSpec {

  describe("A VCustomField") {

    it("should return field type") {
      val field = new VCustomField[String] {
        override def initContent(): Component = new VLabel
      }

      assert(field.getType === classOf[String])
    }
  }
}