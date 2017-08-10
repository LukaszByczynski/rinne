package org.vaadin.addons.rinne.v8.internal

import com.vaadin.ui.Button

class ListenersSetSpec extends org.specs2.mutable.Specification {

  "The ListenerSet" should {

    val listenersSet = new ListenersSet[Button.ClickEvent, Button.ClickListener] {
      override protected def addListener(listener: Button.ClickListener) = () => {}

      override protected def createListener(action: => Unit) = (_ => action)
    }

    val listener: Button.ClickListener = (_: Button.ClickEvent) => ()

    "be empty at beginning" in {
      listenersSet must beEmpty
    }

    "add Listener to the ListenerSet" in {
      listenersSet must beEmpty
      listenersSet += listener
      listenersSet contains listener
    }

    "clear ListenerSet" in {
      listenersSet must beEmpty
      listenersSet += listener
      listenersSet contains listener
      listenersSet.clear()
      listenersSet must beEmpty
    }

    "add and remove Listener to the ListenerSet" in {
      listenersSet must beEmpty
      listenersSet += listener
      listenersSet contains listener

      listenersSet -= listener
      listenersSet must not contain listener
      listenersSet must beEmpty
    }

    "add unit like Listener to the ListenerSet" in {
      listenersSet must beEmpty
      listenersSet += {}
      listenersSet must not(beEmpty)
    }
  }
}