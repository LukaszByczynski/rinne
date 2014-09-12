package org.vaadin.addons.rinne.mixins

import org.vaadin.addons.rinne.SelectionMode
import org.vaadin.addons.rinne.event._
import com.vaadin.server.Resource
import com.vaadin.shared.ui.MultiSelectMode
import com.vaadin.ui.Table
import scala.collection.mutable


trait TableMixin extends Table with AbstractSelectMixin with ItemClickNotifier {

  private val _columnGeneratorIds: mutable.Set[Any] = mutable.Set.empty[Any]

  def visibleColumns: Seq[Any] = getVisibleColumns

  def visibleColumns_=(visibleColumns: Seq[Any]) {
    setVisibleColumns(visibleColumns map {
      _.asInstanceOf[Object]
    }: _*)
  }

  def columnHeaders: Seq[Option[String]] = getColumnHeaders.map(Option(_)).toSeq

  def columnHeaders_=(columnHeaders: => Seq[String]): Unit = setColumnHeaders(columnHeaders: _*)

  def columnHeaders_=(columnHeaders: Seq[Option[String]]): Unit = setColumnHeaders(columnHeaders map {
    _.orNull
  }: _*)

  def columnIcons: Seq[Option[Resource]] = getColumnIcons.map(Option(_)).toSeq

  def columnIcons_=(columnIcons: => Seq[Resource]): Unit = setColumnIcons(columnIcons: _*)

  def columnIcons_=(columnIcons: Seq[Option[Resource]]): Unit = setColumnIcons(columnIcons map {
    _.orNull
  }: _*)

  def columnAlignments: Seq[Table.Align] = getColumnAlignments.toSeq

  def columnAlignments_=(columnAlignments: Seq[Table.Align]) {
    setColumnAlignments(columnAlignments: _ *)
  }

  def pageLength: Int = getPageLength

  def pageLength_=(pageLength: Int) {
    setPageLength(pageLength)
  }

  def cacheRate: Double = getCacheRate

  def cacheRate_=(cacheRate: Double) {
    setCacheRate(cacheRate)
  }

  def currentPageFirstItemIndex: Int = getCurrentPageFirstItemIndex

  def currentPageFirstItemIndex_=(currentPageFirstItemIndex: Int) {
    setCurrentPageFirstItemIndex(currentPageFirstItemIndex)
  }

  def currentPageFirstItemId: Option[Any] = Option(getCurrentPageFirstItemId)

  def currentPageFirstItemId_=(currentPageFirstItemId: Any) {
    setCurrentPageFirstItemId(currentPageFirstItemId)
  }

  def columnCollapsingAllowed: Boolean = isColumnCollapsingAllowed

  def columnCollapsingAllowed_=(columnCollapsingAllowed: Boolean) {
    setColumnCollapsingAllowed(columnCollapsingAllowed)
  }

  def columnReorderingAllowed: Boolean = isColumnReorderingAllowed

  def columnReorderingAllowed_=(columnReorderingAllowed: Boolean) {
    setColumnReorderingAllowed(columnReorderingAllowed)
  }

  def editable: Boolean = isEditable

  def editable_=(editable: Boolean) {
    setEditable(editable)
  }

  def sortable: Boolean = isSortEnabled

  def sortable_=(sortable: Boolean) {
    setSortEnabled(sortable)
  }

  def sortContainerPropertyId: Option[Any] = Option(getSortContainerPropertyId)

  def sortContainerPropertyId_=(sortContainerPropertyId: Option[Any]) {
    setSortContainerPropertyId(sortContainerPropertyId.orNull)
  }

  def sortContainerPropertyId_=(sortContainerPropertyId: Any) {
    setSortContainerPropertyId(sortContainerPropertyId)
  }

  def sortAscending: Boolean = isSortAscending

  def sortAscending_=(sortAscending: Boolean) {
    setSortAscending(true)
  }

  def selectionMode: SelectionMode.Value = {
    if (!isSelectable)
      SelectionMode.None
    else if (isMultiSelect && getMultiSelectMode == MultiSelectMode.SIMPLE)
      SelectionMode.MultiSimple
    else if (isMultiSelect)
      SelectionMode.Multi
    else
      SelectionMode.Single
  }

  def selectionMode_=(selectionMode: SelectionMode.Value) {
    selectionMode match {
      case SelectionMode.None =>
        setSelectable(false)
      case SelectionMode.Single =>
        setSelectable(true)
        setMultiSelect(false)
      case SelectionMode.Multi =>
        setSelectable(true)
        setMultiSelect(true)
        setMultiSelectMode(MultiSelectMode.DEFAULT)
      case SelectionMode.MultiSimple =>
        setSelectable(true)
        setMultiSelect(true)
        setMultiSelectMode(MultiSelectMode.SIMPLE)
    }
  }

  def columnHeaderMode: Table.ColumnHeaderMode = getColumnHeaderMode

  def columnHeaderMode_=(columnHeaderMode: Table.ColumnHeaderMode) {
    setColumnHeaderMode(columnHeaderMode)
  }

  def rowHeaderMode: Table.RowHeaderMode = getRowHeaderMode

  def rowHeaderMode_=(rowHeaderMode: Table.RowHeaderMode) {
    setRowHeaderMode(rowHeaderMode)
  }

  def footerVisible: Boolean = isFooterVisible

  def footerVisible_=(footerVisible: Boolean) {
    setFooterVisible(footerVisible)
  }

  lazy val headerClickListeners: ListenersSet[Table.HeaderClickEvent => Unit] =
    new ListenersTrait[Table.HeaderClickEvent, HeaderClickListener] {
      override def listeners = getListeners(classOf[com.vaadin.ui.Table.HeaderClickListener])

      override def addListener(elem: Table.HeaderClickEvent => Unit) {
        addHeaderClickListener(new HeaderClickListener(elem))
      }

      override def removeListener(elem: HeaderClickListener) {
        removeHeaderClickListener(elem)
      }
    }

  lazy val footerClickListeners: ListenersSet[Table.FooterClickEvent => Unit] =
    new ListenersTrait[Table.FooterClickEvent, FooterClickListener] {
      override def listeners = getListeners(classOf[com.vaadin.ui.Table.FooterClickListener])

      override def addListener(elem: Table.FooterClickEvent => Unit) {
        addFooterClickListener(new FooterClickListener(elem))
      }

      override def removeListener(elem: FooterClickListener) {
        removeFooterClickListener(elem)
      }
    }

  lazy val columnResizeListeners: ListenersSet[Table.ColumnResizeEvent => Unit] =
    new ListenersTrait[Table.ColumnResizeEvent, ColumnResizeListener] {
      override def listeners = getListeners(classOf[com.vaadin.ui.Table.ColumnReorderListener])

      override def addListener(elem: Table.ColumnResizeEvent => Unit) {
        addColumnResizeListener(new ColumnResizeListener(elem))
      }

      override def removeListener(elem: ColumnResizeListener) {
        removeColumnResizeListener(elem)
      }
    }

  lazy val columnReorderListeners: ListenersSet[Table.ColumnReorderEvent => Unit] =
    new ListenersTrait[Table.ColumnReorderEvent, ColumnReorderListener] {
      override def listeners = getListeners(classOf[com.vaadin.ui.Table.ColumnReorderListener])

      override def addListener(elem: Table.ColumnReorderEvent => Unit) {
        addColumnReorderListener(new ColumnReorderListener(elem))
      }

      override def removeListener(elem: ColumnReorderListener) {
        removeColumnReorderListener(elem)
      }
    }
}
