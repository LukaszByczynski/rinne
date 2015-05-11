package org.vaadin.addons.rinne

import com.vaadin.event.ShortcutListener
import com.vaadin.server.ThemeResource
import org.scalatest.FunSpec

class AbstractComponentMixinSpec extends FunSpec {

  describe("An AbstractComponentMixinSpec") {

    describe("should allow to set") {

      it("data") {
        val field = new VTextField

        field.data = "opa"
        assert(field.data === "opa")
      }

      it("immediate") {
        val field = new VTextField

        assert(field.immediate === false)
        field.immediate = true
        assert(field.immediate === true)
      }

      it("description") {
        val field = new VTextField

        field.description = "qwe"
        assert(field.description === Some("qwe"))

        field.description = None
        assert(field.description === None)
      }
    }
  }

  describe("shortcutListeners should") {

    val listener1 = (e: Any) => println(e)

    it("shortcutListeners.add a listener to table") {
      val table = new VTable
      val action = new KeyShortcutAction("aaa", KeyShortcut(KeyCode.A, KeyModifier.Shift), {})

      table.shortcutListeners += action
      assert(table.shortcutListeners.size === 1)
    }

    it("shortcutListeners.remove an action from table") {
      val table = new VTable
      val action = new KeyShortcutAction("aaa", KeyShortcut(KeyCode.A), {})

      table.shortcutListeners += action
      table.shortcutListeners -= action

      assert(table.shortcutListeners.size === 0)
    }

    it("shortcutListeners.remove a listener from table") {
      val table = new VTable
      val action2 = new KeyShortcutAction("aac", new ThemeResource("aaa"), KeyShortcut(KeyCode.C), {})

      table.shortcutListeners += action2
      table.shortcutListeners -= action2

      assert(table.shortcutListeners.size === 0)
    }

    it("shortcutListeners.iterator returns added listeners") {
      val table = new VTable

      var action1executed = false
      var action2executed = false

      val action1 = new KeyShortcutAction("aaa", {
        action1executed = true
      }, KeyModifier.Shift)
      val action2 = new KeyShortcutAction("aac", KeyShortcut(KeyCode.C), {
        action2executed = true
      })

      table.shortcutListeners += action1
      table.shortcutListeners += action2

      val iter = table.shortcutListeners.iterator
      iter.next().apply(null)
      iter.next().apply(null)
      assert(!iter.hasNext)
      assert(action1executed)
      assert(action2executed)
    }

    it("shortcutListeners.contains returns false for non-added listener") {
      val table = new VTable

      assert(!table.shortcutListeners.contains(listener1))
    }

    it("execute listeners") {
      var executed = false
      val table = new VTable {
        shortcutListeners += new KeyShortcutAction("aaa", (_, _) => {
          executed = true
        }, KeyModifier.Shift)
      }

      import scala.collection.JavaConverters._
      table.shortcutListeners.listeners.asScala
        .foreach { case e: ShortcutListener => e.handleAction(null, null) }
      assert(executed)
    }
  }
}
