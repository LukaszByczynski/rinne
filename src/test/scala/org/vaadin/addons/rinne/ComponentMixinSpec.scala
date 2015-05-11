package org.vaadin.addons.rinne

import org.scalatest.FunSpec

class ComponentMixinSpec extends FunSpec {

  describe("A ComponentMixinSpec") {

    describe("should allow to set") {

      //      it("id") {
      //        Mockito.when(mockedVaadinComponent.getId).thenReturn("test-id")
      //        assert(component.id === Some("test-id"))
      //        Mockito.verify(mockedVaadinComponent).getId
      //
      //        Mockito.reset(mockedVaadinComponent)
      //
      //        Mockito.when(mockedVaadinComponent.getId).thenReturn(null)
      //        assert(component.id === None)
      //        Mockito.verify(mockedVaadinComponent).getId
      //
      //        component.id = None
      //        Mockito.verify(mockedVaadinComponent).setId(null)
      //
      //        component.id = "myId"
      //        Mockito.verify(mockedVaadinComponent).setId("myId")
      //      }
      //
      //      ignore("requestRepaint()") {
      //        //component.requestRepaint()
      //        //Mockito.verify(mockedVaadinComponent).requestRepaint()
      //      }

      it("Link, default constructor") {
        val link = new VLink
        assert(link.caption === None)
        assert(link.resource === None)
        assert(link.targetName === None)
        assert(link.targetWidth === -1)
        assert(link.targetHeight === -1)
      }

      it("Component.styleNames.contains") {
        val label = new VLabel
        label.styleNames += "style1"
        label.styleNames += "styleName2"

        assert(label.styleNames.contains("style1"))
      }

      it("Component.styleNames.iterator") {
        val label = new VLabel
        label.styleNames += "style1"
        label.styleNames += "styleName2"
        label.styleNames += "stylez"

        val iter = label.styleNames.iterator
        assert(iter.next === "style1")
        assert(iter.next === "styleName2")
        assert(iter.next === "stylez")
        assert(!iter.hasNext)
      }

      it("VLabel, default constructor") {
        val label = new VLabel
        label.styleNames += "style1"
        label.styleNames += "styleName2"

        assert(label.getStyleName === "style1 styleName2")
      }

      it("Component.styleNames +=, spaces are splitted") {
        val label = new VLabel
        label.styleNames += "  style1  "
        label.styleNames += "  styleName2    foobar  "
        label.styleNames += " stylez "

        assert(label.getStyleName === "style1 styleName2 foobar stylez")
        assert(label.styleNames.size === 4)
      }

      it("Component.styleNames -=") {
        val label = new VLabel
        label.styleNames += "style1"
        label.styleNames += "styleName2"
        label.styleNames += "stylez"

        label.styleNames -= "styleName2"

        assert(label.getStyleName === "style1 stylez")
      }

      it("Component.styleNames.size") {
        val label = new VLabel
        label.styleNames += "style1"
        label.styleNames += "style2"
        label.styleNames += "style3"

        assert(label.styleNames.size === 3)
      }

      it("width, defined size") {
        val label = new VLabel()
        label.width = 25.px

        assert(label.width.get === Measure(25, Units.px))
      }

      it("width, undefined size") {
        val label = new VLabel()
        label.width = None
        assert(label.width === None)
      }

      it("height, defined size em") {
        val label = new VLabel
        label.height = 25.em

        assert(label.height.get === Measure(25, Units.em))
      }

      it("height, defined size ex") {
        val label = new VLabel
        label.height = 25.ex

        assert(label.height.get === Measure(25, Units.ex))
      }

      it("height, defined size pct") {
        val label = new VLabel
        label.height = 25.pct

        assert(label.height.get === Measure(25, Units.pct))
      }

      it("height, defined size pc") {
        val label = new VLabel
        label.height = 25.pc

        assert(label.height.get === Measure(25, Units.pc))
      }

      it("height, defined size pt") {
        val label = new VLabel
        label.height = 25.pt

        assert(label.height.get === Measure(25, Units.pt))
      }

      it("height, defined size mm") {
        val label = new VLabel
        label.height = 25.mm

        assert(label.height.get === Measure(25, Units.mm))
      }

      it("height, defined size cm") {
        val label = new VLabel
        label.height = 25.cm

        assert(label.height.get === Measure(25, Units.cm))
      }

      it("height, defined size in") {
        val label = new VLabel
        label.height = 25.in

        assert(label.height.get === Measure(25, Units.in))
      }

      it("height, defined size percent") {
        val label = new VLabel
        label.height = 25.0.percent

        assert(label.height.get === Measure(25, Units.pct))
      }

      it("height, undefined size") {
        val label = new VLabel()
        label.height = None
        assert(label.height === None)
      }

      it("sizeFull()") {
        val label = new VLabel
        label.sizeFull()
        assert(label.width.get === Measure(100.0, Units.pct))
        assert(label.height.get === Measure(100, Units.pct))
      }

      it("sizeUndefined()") {
        val label = new VLabel
        label.sizeUndefined()
        assert(label.width === None)
        assert(label.height === None)
      }

      it("size(width, height)") {
        val label = new VLabel
        label.size(Measure(200, Units.px), Measure(50, Units.pct))
        assert(label.width.get === Measure(200, Units.px))
        assert(label.height.get === Measure(50, Units.pct))
      }

      it("size(Option[width], Option[height])") {
        val label = new VLabel
        label.size(200.px, None)
        assert(label.width.get === Measure(200, Units.px))
        assert(label.height === None)
      }
    }
  }
}