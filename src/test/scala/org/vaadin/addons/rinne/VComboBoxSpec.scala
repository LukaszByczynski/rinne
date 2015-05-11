package org.vaadin.addons.rinne

import com.vaadin.shared.ui.combobox.FilteringMode
import org.scalatest.FunSpec

class VComboBoxSpec extends FunSpec {

  describe("VComboBox") {

    describe("should allow to set") {

      it("inputPrompt") {
        val comboBox = new VComboBox

        assert(comboBox.inputPrompt === None)
        comboBox.inputPrompt = "test"
        assert(comboBox.inputPrompt === Some("test"))

        comboBox.inputPrompt = Some("test2")
        assert(comboBox.inputPrompt === Some("test2"))
      }

      it("textInputAllowed") {
        val comboBox = new VComboBox

        assert(comboBox.textInputAllowed === true)
        comboBox.textInputAllowed = false
        assert(comboBox.textInputAllowed === false)
      }

      it("filteringMode") {
        val comboBox = new VComboBox

        assert(comboBox.filteringMode === FilteringMode.STARTSWITH)
        comboBox.filteringMode = FilteringMode.CONTAINS
        assert(comboBox.filteringMode === FilteringMode.CONTAINS)
      }

      it("scrollToSelectedItem") {
        val comboBox = new VComboBox

        assert(comboBox.scrollToSelectedItem === true)
        comboBox.scrollToSelectedItem = false
        assert(comboBox.scrollToSelectedItem === false)
      }
    }

    describe("should addItemWithCaption") {
      val comboBox = new VComboBox

      comboBox.addItemWithCaption(Int.box(1), "test")
      assert(comboBox.getItemCaption(Int.box(1)) === "test")
    }
  }
}
