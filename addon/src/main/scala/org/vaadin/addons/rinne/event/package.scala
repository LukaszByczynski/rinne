package org.vaadin.addons.rinne

import com.vaadin.data.Property
import com.vaadin.data.Property.ReadOnlyStatusChangeEvent
import com.vaadin.event.ItemClickEvent
import com.vaadin.event.LayoutEvents.LayoutClickEvent
import com.vaadin.ui._
import scala.collection.mutable

package object event {

  trait ListenersSet[E] extends mutable.Set[E] {
    def +=(elem: => Unit): this.type
  }

  trait Listener {
    def action: Any
  }

  trait ListenersTrait[E, L <: Listener] extends mutable.Set[E => Unit] with ListenersSet[E => Unit] with Serializable {

    import scala.collection.JavaConverters._

    def contains(key: E => Unit): Boolean = {
      iterator.contains(key)
    }

    def iterator: Iterator[E => Unit] = {
      val list = listeners.asScala.map(_.asInstanceOf[L].action)
      list.iterator.asInstanceOf[Iterator[E => Unit]]
    }

    def +=(elem: => Unit) = {
      addListener((e: E) => elem); this
    }

    def +=(elem: E => Unit) = {
      addListener(elem); this
    }

    def -=(elem: E => Unit) = {
      listeners.asScala.foreach {
        e =>
          if (e.asInstanceOf[L].action == elem) {
            removeListener(e.asInstanceOf[L])
            this
          }
      }
      this
    }

    protected def listeners: java.util.Collection[_]

    protected def addListener(elem: E => Unit)

    protected def removeListener(elem: L)
  }

  class ButtonClickListener(val action: Button.ClickEvent => Unit)
    extends Button.ClickListener with Listener {
    def buttonClick(e: Button.ClickEvent) = action(e)
  }

  class WindowCloseListener(val action: Window.CloseEvent => Unit)
    extends Window.CloseListener with Listener {
    def windowClose(e: Window.CloseEvent) = action(e)
  }

  class WindowResizeListener(val action: Window.ResizeEvent => Unit)
    extends Window.ResizeListener with Listener {
    def windowResized(e: Window.ResizeEvent) = action(e)
  }

  class ValueChangeListener(val action: com.vaadin.data.Property.ValueChangeEvent => Unit)
    extends com.vaadin.data.Property.ValueChangeListener with Listener {
    def valueChange(e: com.vaadin.data.Property.ValueChangeEvent) = action(e)
  }

  class SelectedTabChangeListener(val action: TabSheet.SelectedTabChangeEvent => Unit)
    extends TabSheet.SelectedTabChangeListener with Listener {
    def selectedTabChange(e: TabSheet.SelectedTabChangeEvent) = action(e)
  }

  class LayoutClickListener(val action: LayoutClickEvent => Unit)
    extends com.vaadin.event.LayoutEvents.LayoutClickListener with Listener {
    def layoutClick(e: com.vaadin.event.LayoutEvents.LayoutClickEvent) = action(e)
  }

  class FooterClickListener(val action: Table.FooterClickEvent => Unit)
    extends Table.FooterClickListener with Listener {
    def footerClick(e: Table.FooterClickEvent) = action(e)
  }

  class HeaderClickListener(val action: Table.HeaderClickEvent => Unit)
    extends Table.HeaderClickListener with Listener {
    def headerClick(e: Table.HeaderClickEvent) = action(e)
  }

  class ColumnResizeListener(val action: Table.ColumnResizeEvent => Unit)
    extends Table.ColumnResizeListener with Listener {
    def columnResize(e: Table.ColumnResizeEvent) = action(e)
  }

  class ColumnReorderListener(val action: Table.ColumnReorderEvent => Unit)
    extends Table.ColumnReorderListener with Listener {
    def columnReorder(e: Table.ColumnReorderEvent) = action(e)
  }

  case class TableColumnGenerationEvent(table: Table, itemId: Any, propertyId: Any)

  class ColumnGenerationListener(val action: TableColumnGenerationEvent => Unit)
    extends Table.ColumnGenerator with Listener {
    override def generateCell(source: Table, itemId: Any, columnId: Any): AnyRef = {
      TableColumnGenerationEvent(source, itemId, columnId)
    }
  }

  class ItemClickListener(val action: ItemClickEvent => Unit)
    extends ItemClickEvent.ItemClickListener with Listener {
    override def itemClick(e: ItemClickEvent): Unit = action(e)
  }

  class ReadOnlyStatusChangeListener(val action: Property.ReadOnlyStatusChangeEvent => Unit)
    extends Property.ReadOnlyStatusChangeListener with Listener {
    override def readOnlyStatusChange(e: ReadOnlyStatusChangeEvent): Unit = action(e)
  }

}
