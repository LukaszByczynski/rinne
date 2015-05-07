package org.vaadin.addons.rinne.mixins

import com.vaadin.data.Container

trait ContainerMixin {
  this: Container =>

  import scala.collection.JavaConverters._

  def itemIds: Iterable[Any] = getItemIds.asScala

  def addContainerProperty(propertyId: Any, propertyType: Class[_], defaultValue: Option[Any] = None): Boolean =
    addContainerProperty(propertyId, propertyType, defaultValue.orNull)

  def addItemOption(): Option[Any] = Option(addItem())

  def propertyIds: Iterable[Any] = getContainerPropertyIds.asScala

}