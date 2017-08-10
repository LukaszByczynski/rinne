package org.vaadin.addons.rinne.mixins

import com.vaadin.v7.data.Property

trait PropertyViewerMixin {
  this: Property.Viewer =>

  def dataSource: Option[Property[_]] = Option(getPropertyDataSource)

  def dataSource_=(newDataSource: Property[_]): Unit = dataSource_=(Some(newDataSource))

  def dataSource_=(newDataSource: Option[Property[_]]): Unit = setPropertyDataSource(newDataSource.orNull)

}
