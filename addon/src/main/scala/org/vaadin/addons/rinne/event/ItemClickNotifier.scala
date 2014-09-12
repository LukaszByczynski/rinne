package org.vaadin.addons.rinne.event

import com.vaadin.event.ItemClickEvent
import com.vaadin.ui.AbstractComponent


trait ItemClickNotifier extends AbstractComponent with ItemClickEvent.ItemClickNotifier {

  lazy val itemClickListeners = new ListenersTrait[ItemClickEvent, ItemClickListener] {
    override def listeners = getListeners(classOf[ItemClickEvent.ItemClickListener])

    override def addListener(elem: ItemClickEvent => Unit) = addItemClickListener(new ItemClickListener(elem))

    override def removeListener(elem: ItemClickListener) = removeListener(elem)
  }
}
