package org.vaadin.addons.rinne.mixins

import java.util.Locale

import com.vaadin.server.ClientConnector.{AttachEvent, AttachListener, DetachEvent, DetachListener}
import org.mockito.Mockito
import org.scalatest.FunSpec
import org.scalatest.mock.MockitoSugar
import org.vaadin.addons.rinne.{VLabel, VTextField}

class AbstractComponentMixinSpec extends FunSpec with MockitoSugar {

  describe("An AbstractComponentMixinSpec") {

    val abstractComponent = Mockito.spy(new VLabel)

    it("captionAsHtml") {
      assert(!abstractComponent.captionAsHtml)
      Mockito.verify(abstractComponent).isCaptionAsHtml

      abstractComponent.captionAsHtml = true
      Mockito.verify(abstractComponent).setCaptionAsHtml(true)
    }

    it("locale") {
      assert(abstractComponent.locale.isEmpty)

      val locale = Locale.ENGLISH
      Mockito.when(abstractComponent.getLocale).thenReturn(locale)
      assert(Some(locale) === abstractComponent.locale)

      Mockito.reset(abstractComponent)
      abstractComponent.locale = Some(Locale.US)
      Mockito.verify(abstractComponent).setLocale(Locale.US)

      Mockito.reset(abstractComponent)
      abstractComponent.locale = None
      Mockito.verify(abstractComponent).setLocale(null)

      Mockito.reset(abstractComponent)
      abstractComponent.locale = Locale.US
      Mockito.verify(abstractComponent).setLocale(Locale.US)
    }

    describe("attachListeners should") {

      val listener1 = (e: AttachEvent) => println("1")
      val listener2 = (e: AttachEvent) => println(e)

      it("attachListeners.add a listener to textField") {
        val textField = new VTextField

        textField.attachListeners += (println(_))

        assert(textField.attachListeners.size === 1)
      }

      it("attachListeners.remove a listener from textField") {
        val textField = new VTextField

        textField.attachListeners += listener1
        textField.attachListeners -= listener1

        assert(textField.attachListeners.size === 0)
      }

      it("attachListeners.iterator returns added listeners") {
        val textField = new VTextField

        textField.attachListeners += listener1
        textField.attachListeners += listener2

        val iter = textField.attachListeners.iterator
        assert(iter.next() === listener1)
        assert(iter.next() === listener2)
        assert(!iter.hasNext)
      }

      it("attachListeners.contains returns true for added listener") {
        val textField = new VTextField

        textField.attachListeners += listener1
        assert(textField.attachListeners.contains(listener1))
      }

      it("attachListeners.contains returns false for non-added listener") {
        val textField = new VTextField

        assert(!textField.attachListeners.contains(listener2))
      }

      it("execute listeners") {
        var executed = false
        val textField = new VTextField {
          attachListeners += {
            executed = true
          }
        }

        import scala.collection.JavaConverters._
        textField.getListeners(classOf[AttachEvent]).asScala
          .foreach { case e: AttachListener => e.attach(null) }
        assert(executed)
      }
    }

    describe("detachListeners should") {

      val listener1 = (e: DetachEvent) => println("1")
      val listener2 = (e: DetachEvent) => println(e)

      it("detachListeners.add a listener to textField") {
        val textField = new VTextField

        textField.detachListeners += (println(_))

        assert(textField.detachListeners.size === 1)
      }

      it("detachListeners.remove a listener from textField") {
        val textField = new VTextField

        textField.detachListeners += listener1
        textField.detachListeners -= listener1

        assert(textField.detachListeners.size === 0)
      }

      it("detachListeners.iterator returns added listeners") {
        val textField = new VTextField

        textField.detachListeners += listener1
        textField.detachListeners += listener2

        val iter = textField.detachListeners.iterator
        assert(iter.next() === listener1)
        assert(iter.next() === listener2)
        assert(!iter.hasNext)
      }

      it("detachListeners.contains returns true for added listener") {
        val textField = new VTextField

        textField.detachListeners += listener1
        assert(textField.detachListeners.contains(listener1))
      }

      it("detachListeners.contains returns false for non-added listener") {
        val textField = new VTextField

        assert(!textField.detachListeners.contains(listener2))
      }

      it("execute listeners") {
        var executed = false
        val textField = new VTextField {
          detachListeners += {
            executed = true
          }
        }

        import scala.collection.JavaConverters._
        textField.getListeners(classOf[DetachEvent]).asScala
          .foreach { case e: DetachListener => e.detach(null) }
        assert(executed)
      }
    }
  }
}
