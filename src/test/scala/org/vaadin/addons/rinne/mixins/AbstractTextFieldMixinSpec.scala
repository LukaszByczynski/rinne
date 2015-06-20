package org.vaadin.addons.rinne.mixins

import com.vaadin.event.FieldEvents.{TextChangeEvent, TextChangeListener}
import com.vaadin.ui.AbstractTextField
import org.mockito.Mockito
import org.scalatest.FunSpec
import org.vaadin.addons.rinne.VTextField

class AbstractTextFieldMixinSpec extends FunSpec {

  describe("An AbstractTextFieldMixin") {

    val abstractTextField = Mockito.spy(new VTextField)

    it("nullSettingAllowed") {
      assert(!abstractTextField.nullSettingAllowed)

      abstractTextField.nullSettingAllowed = true
      assert(abstractTextField.nullSettingAllowed)
    }

    it("nullRepresentation") {
      abstractTextField.nullRepresentation = "test"
      assert(abstractTextField.nullRepresentation === "test")
    }

    it("prompt") {
      abstractTextField.prompt = "prompt"
      assert(abstractTextField.prompt === Some("prompt"))
      abstractTextField.prompt = None
      assert(abstractTextField.prompt === None)
    }

    it("maxLength") {
      assert(abstractTextField.maxLength === -1)

      abstractTextField.maxLength = 10
      assert(abstractTextField.maxLength === 10)
    }

    it("columns") {
      assert(abstractTextField.columns === 0)

      abstractTextField.columns = 5
      assert(abstractTextField.columns === 5)
    }

    it("selectAll()") {
      abstractTextField.selectAll()
      Mockito.verify(abstractTextField).selectAll()
    }

    it("cursorPosition") {
      assert(abstractTextField.cursorPosition === 0)

      abstractTextField.cursorPosition = 10
      assert(abstractTextField.cursorPosition === 10)
    }

    it("textChangeTimeout") {
      assert(abstractTextField.textChangeTimeout === 400)

      abstractTextField.textChangeTimeout = 100
      assert(abstractTextField.textChangeTimeout === 100)
    }

    it("textChangeEventMode") {
      assert(abstractTextField.textChangeEventMode === AbstractTextField.TextChangeEventMode.LAZY)

      abstractTextField.textChangeEventMode = AbstractTextField.TextChangeEventMode.TIMEOUT
      assert(abstractTextField.textChangeEventMode === AbstractTextField.TextChangeEventMode.TIMEOUT)
    }

    describe("textChangeListeners should") {

      val listener1 = (e: TextChangeEvent) => println("1")
      val listener2 = (e: TextChangeEvent) => println(e)

      it("textChangeListeners.add a listener to textField") {
        val textField = new VTextField

        textField.textChangeListeners += (println(_))

        assert(textField.textChangeListeners.size === 1)
      }

      it("textChangeListeners.remove a listener from textField") {
        val textField = new VTextField

        textField.textChangeListeners += listener1
        textField.textChangeListeners -= listener1

        assert(textField.textChangeListeners.size === 0)
      }

      it("textChangeListeners.iterator returns added listeners") {
        val textField = new VTextField

        textField.textChangeListeners += listener1
        textField.textChangeListeners += listener2

        val iter = textField.textChangeListeners.iterator
        assert(iter.next() === listener1)
        assert(iter.next() === listener2)
        assert(!iter.hasNext)
      }

      it("textChangeListeners.contains returns true for added listener") {
        val textField = new VTextField

        textField.textChangeListeners += listener1
        assert(textField.textChangeListeners.contains(listener1))
      }

      it("textChangeListeners.contains returns false for non-added listener") {
        val textField = new VTextField

        assert(!textField.textChangeListeners.contains(listener2))
      }

      it("execute listeners") {
        var executed = false
        val textField = new VTextField {
          textChangeListeners += {
            executed = true
          }
        }

        import scala.collection.JavaConverters._
        textField.getListeners(classOf[TextChangeEvent]).asScala
          .foreach { case e: TextChangeListener => e.textChange(null) }
        assert(executed)
      }
    }

  }
}
