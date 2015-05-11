package org.vaadin.addons.rinne

import com.vaadin.server.ThemeResource
import org.scalatest.FunSpec

class VFlashSpec extends FunSpec {

  describe("A VFlash") {

    describe("should allow to set") {

      it("parameters") {
        val flash = new VFlash
        flash.parameters += "param1" -> "value1"
        flash.parameters += "param2" -> "value2"
        flash.parameters += "param3" -> "value3"

        assert(flash.parameters.size === 3)
        assert(flash.parameters === Map("param1" -> "value1", "param2" -> "value2", "param3" -> "value3"))

        assert(flash.parameters.get("param2") === Some("value2"))
        assert(flash.parameters.get("param7") === None)

        flash.parameters += "param2" -> "new value 2"
        assert(flash.parameters === Map("param1" -> "value1", "param2" -> "new value 2", "param3" -> "value3"))

        flash.parameters -= "param1"
        assert(flash.parameters.size === 2)
        assert(flash.parameters === Map("param2" -> "new value 2", "param3" -> "value3"))
      }

      it("alternateText") {
        val flash = new VFlash
        assert(flash.alternateText === None)

        flash.alternateText = "alternate"
        assert(flash.alternateText === Some("alternate"))

        flash.alternateText = None
        assert(flash.alternateText === None)

        flash.alternateText = Some("alternate")
        assert(flash.alternateText === Some("alternate"))
      }

      it("source") {
        val flash = new VFlash

        val res = new ThemeResource("img.png")
        flash.source = res
        assert(flash.source === Some(res))

        flash.source = None
        assert(flash.source === None)
      }

      it("codebase") {
        val flash = new VFlash
        flash.codebase = "codebase"
        assert(flash.codebase === Some("codebase"))

        flash.codebase = Option("codebase")
        assert(flash.codebase === Some("codebase"))

        flash.codebase = None
        assert(flash.codebase === None)
      }

      it("codetype") {
        val flash = new VFlash
        flash.codetype = "codetype"
        assert(flash.codetype === Some("codetype"))

        flash.codetype = Option("codetype")
        assert(flash.codetype === Some("codetype"))

        flash.codetype = None
        assert(flash.codetype === None)
      }

      it("standby") {
        val flash = new VFlash
        flash.standby = "standby"
        assert(flash.standby === Some("standby"))
      }

      it("standby, Option") {
        val flash = new VFlash
        flash.standby = Option("standby")
        assert(flash.standby === Some("standby"))
      }

      it("standby, None") {
        val flash = new VFlash
        flash.standby = None
        assert(flash.standby === None)
      }

      it("archive") {
        val flash = new VFlash
        flash.archive = "archive"
        assert(flash.archive === Some("archive"))

        flash.archive = Option("archive")
        assert(flash.archive === Some("archive"))

        flash.archive = None
        assert(flash.archive === None)
      }
    }
  }
}