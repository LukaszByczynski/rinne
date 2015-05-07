package org.vaadin.addons.rinne.mixins

import java.util

import com.vaadin.ui.TabSheet.{SelectedTabChangeEvent, SelectedTabChangeListener}
import com.vaadin.ui.{Component, TabSheet}
import org.vaadin.addons.rinne.events._

trait TabSheetMixin extends AbstractComponentMixin with FocusNotifierMixin with BlurNotifierMixin {
  this: TabSheet =>

  lazy val selectedTabChangeListeners = new ListenersSet[TabSheet.SelectedTabChangeEvent, SelectedTabChangeListener] {
    override protected def addListener(listener: ListenerLambda): Unit = addSelectedTabChangeListener(
      new Listener(listener) with SelectedTabChangeListener {
        override def selectedTabChange(selectedTabChangeEvent: SelectedTabChangeEvent): Unit = listener(selectedTabChangeEvent)
      }
    )

    override protected def removeListener(listener: SelectedTabChangeListener): Unit = removeSelectedTabChangeListener(listener)

    override protected def listeners: util.Collection[_] = getListeners(classOf[TabSheet.SelectedTabChangeListener])
  }

  def add[C <: Component](component: C): C = {
    addTab(component)
    component
  }

  def tabsVisible: Boolean = !areTabsHidden

  def tabsVisible_=(tabsVisible: Boolean): Unit = hideTabs(!tabsVisible)

  def selectedTab: TabSheet.Tab = getTab(selectedComponent)

  def selectedTab_=(tab: TabSheet.Tab): Unit = selectedComponent = tab.getComponent

  def selectedComponent: Component = getSelectedTab

  def selectedComponent_=(component: Component): Unit = setSelectedTab(component)
}