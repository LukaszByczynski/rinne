package org.vaadin.addons.rinne.mixins

import org.vaadin.addons.rinne.event._
import com.vaadin.ui.Component.Focusable
import com.vaadin.ui.{Component, TabSheet}

trait TabSheetMixin extends TabSheet with AbstractComponentMixin with Focusable with FocusNotifier with BlurNotifier {


  override def addTab(component: Component, caption: String): TabSheet.Tab = super.addTab(component, caption)

  //  def addTab(component: Component, caption: String, icon: Resource): TabSheet.Tab =
  //    register(p.addTab(component.p, caption, icon.p))
  //  def addTab(component: Component, caption: String, icon: Resource, position: Int): TabSheet.Tab =
  //    register(p.addTab(component.p, caption, icon.p, position))
  //  def addTab(component: Component, position: Int): TabSheet.Tab = register(p.addTab(component.p, position))

  def add[C <: Component](component: C): C = {
    addTab(component)
    component
  }


  def tabsVisible: Boolean = !areTabsHidden

  def tabsVisible_=(tabsVisible: Boolean) { hideTabs(!tabsVisible) }

  def selectedComponent: Component = getSelectedTab

  def selectedComponent_=(component: Component) { setSelectedTab(component) }

  def selectedTab: TabSheet.Tab = getTab(selectedComponent)

  def selectedTab_=(tab: TabSheet.Tab) { selectedComponent = tab.getComponent }

  lazy val selectedTabChangeListeners: ListenersSet[TabSheet.SelectedTabChangeEvent => Unit] =
    new ListenersTrait[TabSheet.SelectedTabChangeEvent, SelectedTabChangeListener] {
      override def listeners = getListeners(classOf[com.vaadin.ui.TabSheet.SelectedTabChangeEvent])

      override def addListener(elem: TabSheet.SelectedTabChangeEvent => Unit) =
        addSelectedTabChangeListener(new SelectedTabChangeListener(elem))

      override def removeListener(elem: SelectedTabChangeListener) = removeSelectedTabChangeListener(elem)
    }
}
