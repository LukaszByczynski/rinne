package org.vaadin.addons.rinne

import com.vaadin.ui.Upload
import org.mockito.Mockito
import org.scalatest.FunSpec
import org.scalatest.mock.MockitoSugar

class VUploadSpec extends FunSpec with MockitoSugar {

  describe("A VUpload") {

    describe("should allow to set") {
      val upload = Mockito.spy(new VUpload)

      it("receiver") {
        assert(upload.receiver === None)

        val receiver = mock[Upload.Receiver]

        upload.receiver = receiver
        assert(upload.receiver === Some(receiver))

        upload.receiver = None
        assert(upload.receiver === None)

        upload.receiver = Some(receiver)
        assert(upload.receiver === Some(receiver))
      }

      it("interruptUpload()") {
        upload.interruptUpload()
        Mockito.verify(upload).interruptUpload()
      }

      it("uploading") {
        assert(!upload.uploading)
        Mockito.verify(upload).isUploading
      }

      it("bytesRead") {
        assert(upload.bytesRead === 0)
        Mockito.verify(upload).getBytesRead
      }

      it("uploadSize") {
        assert(upload.uploadSize === -1)
        Mockito.verify(upload).getUploadSize
      }

      it("buttonCaption") {
        assert(upload.buttonCaption === Some("Upload"))

        upload.buttonCaption = None
        assert(upload.buttonCaption === None)

        upload.buttonCaption = "Test"
        assert(upload.buttonCaption === Some("Test"))

        upload.buttonCaption = Some("upload")
        assert(upload.buttonCaption === Some("upload"))
      }

      it("submitUpload()") {
        upload.submitUpload()
        Mockito.verify(upload).submitUpload()
      }
    }
  }
}