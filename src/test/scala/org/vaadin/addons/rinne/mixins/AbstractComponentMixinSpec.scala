package org.vaadin.addons.rinne.mixins

import java.util.Locale

import org.mockito.Mockito
import org.scalatest.FunSpec
import org.scalatest.mock.MockitoSugar
import org.vaadin.addons.rinne.VLabel

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
  }
}
