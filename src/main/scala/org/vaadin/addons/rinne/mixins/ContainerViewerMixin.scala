package org.vaadin.addons.rinne.mixins

import com.vaadin.data.Container

trait ContainerViewerMixin {
  this: Container.Viewer =>

  def dataSource_=(newDataSource: Container): Unit = dataSource = Some(newDataSource)

  def dataSource: Option[Container] = Option(getContainerDataSource)

  def dataSource_=(newDataSource: Option[Container]): Unit = setContainerDataSource(newDataSource.orNull)

}
