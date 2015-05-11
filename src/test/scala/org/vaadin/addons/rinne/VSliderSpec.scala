package org.vaadin.addons.rinne

import com.vaadin.shared.ui.slider.SliderOrientation
import org.scalatest.FunSpec

class VSliderSpec extends FunSpec {

  describe("A VSlider") {

    describe("should allow to set") {

      it("min") {
        val field = new VSlider

        field.min = 213
        assert(field.min === 213)
      }

      it("max") {
        val field = new VSlider

        field.max = 213
        assert(field.max === 213)
      }

      it("resolution") {
        val field = new VSlider

        field.resolution = 213
        assert(field.resolution === 213)
      }

      it("value") {
        val field = new VSlider

        assert(field.value === Some(0.0))

        field.value = 13.0
        assert(field.value === Some(13.0))
      }

      it("orientation") {
        val field = new VSlider

        field.orientation = SliderOrientation.VERTICAL
        assert(field.orientation === SliderOrientation.VERTICAL)
      }
    }
  }
}