package org.vaadin.addons.rinne

import com.vaadin.data.HasItems
import com.vaadin.data.provider.DataProvider

class VHasItems[T](hasItems: HasItems[T]) {

  import java.util.stream.StreamSupport

  import scala.collection.JavaConverters._

  def dataProvider: Option[DataProvider[T, _]] = {
    Option(hasItems.getDataProvider)
  }

  def items_=(value: Seq[T]): Unit = {
    hasItems.setItems(value.asJava)
  }

  def items_=(value: Stream[T]): Unit = {
    hasItems.setItems(StreamSupport.stream(value.asJava.spliterator, false))
  }
}