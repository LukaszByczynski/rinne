package org.vaadin.addons.rinne

import com.vaadin.server.ThemeResource
import org.scalatest.FunSpec

class VEmbeddedSpec extends FunSpec {

  describe("A VEmbedded") {

    describe("should allow to set") {

      it("parameters") {
        val embedded = new VEmbedded
        embedded.parameters += "param1" -> "value1"
        embedded.parameters += "param2" -> "value2"
        embedded.parameters += "param3" -> "value3"

        assert(embedded.parameters.size === 3)
        assert(embedded.parameters === Map("param1" -> "value1", "param2" -> "value2", "param3" -> "value3"))

        assert(embedded.parameters.get("param2") === Some("value2"))
        assert(embedded.parameters.get("param7") === None)

        embedded.parameters += "param2" -> "new value 2"
        assert(embedded.parameters === Map("param1" -> "value1", "param2" -> "new value 2", "param3" -> "value3"))

        embedded.parameters -= "param1"
        assert(embedded.parameters.size === 2)
        assert(embedded.parameters === Map("param2" -> "new value 2", "param3" -> "value3"))
      }

      it("alternateText") {
        val embedded = new VEmbedded
        assert(embedded.alternateText === None)

        embedded.alternateText = "alternate"
        assert(embedded.alternateText === Some("alternate"))

        embedded.alternateText = None
        assert(embedded.alternateText === None)

        embedded.alternateText = Some("alternate")
        assert(embedded.alternateText === Some("alternate"))
      }

      it("source") {
        val embedded = new VEmbedded

        val res = new ThemeResource("img.png")
        embedded.source = res
        assert(embedded.source === Some(res))

        // quite interesing, vaadin didn't reset property
        embedded.source = None
        assert(embedded.source === Some(res))
      }

      it("codebase") {
        val embedded = new VEmbedded
        embedded.codebase = "codebase"
        assert(embedded.codebase === Some("codebase"))

        embedded.codebase = Option("codebase")
        assert(embedded.codebase === Some("codebase"))

        embedded.codebase = None
        assert(embedded.codebase === None)
      }

      it("codetype") {
        val embedded = new VEmbedded
        embedded.codetype = "codetype"
        assert(embedded.codetype === Some("codetype"))

        embedded.codetype = Option("codetype")
        assert(embedded.codetype === Some("codetype"))

        embedded.codetype = None
        assert(embedded.codetype === None)
      }

      it("standby") {
        val embedded = new VEmbedded
        embedded.standby = "standby"
        assert(embedded.standby === Some("standby"))
      }

      it("standby, Option") {
        val embedded = new VEmbedded
        embedded.standby = Option("standby")
        assert(embedded.standby === Some("standby"))
      }

      it("standby, None") {
        val embedded = new VEmbedded
        embedded.standby = None
        assert(embedded.standby === None)
      }

      it("classId") {
        val embedded = new VEmbedded
        embedded.classId = "classId"
        assert(embedded.classId === Some("classId"))

        embedded.classId = Option("classId")
        assert(embedded.classId === Some("classId"))

        embedded.classId = None
        assert(embedded.classId === None)
      }

      it("archive") {
        val embedded = new VEmbedded
        embedded.archive = "archive"
        assert(embedded.archive === Some("archive"))

        embedded.archive = Option("archive")
        assert(embedded.archive === Some("archive"))

        embedded.archive = None
        assert(embedded.archive === None)
      }

      it("mimeType") {
        val embedded = new VEmbedded
        embedded.mimeType = "mimeType"
        assert(embedded.mimeType === Some("mimeType"))

        embedded.mimeType = Option("mimeType")
        assert(embedded.mimeType === Some("mimeType"))

        embedded.mimeType = None
        assert(embedded.mimeType === None)
      }
    }
  }
}