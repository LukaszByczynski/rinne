package org.vaadin.addons.rinne

import com.vaadin.server.ThemeResource
import org.scalatest.FunSpec

class VVideoSpec extends FunSpec {

  describe("A VVideo") {

    describe("should allow to set") {

      it("poster") {
        val video = new VVideo
        val res = new ThemeResource("img.png")

        assert(video.poster === None)
        video.poster = res
        assert(video.poster === Some(res))

        video.poster = None
        assert(video.poster === None)
      }
    }
  }
}