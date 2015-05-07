package org.vaadin.addons.rinne.mixins

import com.vaadin.server.Resource
import com.vaadin.shared.ui.MultiSelectMode
import com.vaadin.ui.Table
import com.vaadin.ui.Table._
import org.vaadin.addons.rinne.SelectionMode
import org.vaadin.addons.rinne.events._

trait TableMixin extends AbstractSelectMixin with ItemClickNotifierMixin {
  this: Table =>

  lazy val headerClickListeners = new ListenersSet[HeaderClickEvent, HeaderClickListener] {
    override def listeners = getListeners(classOf[HeaderClickEvent])

    override protected def addListener(listener: ListenerLambda): Unit = addHeaderClickListener(
      new HeaderClickListener {
        override def headerClick(event: HeaderClickEvent): Unit = listener(event)
      }
    )

    override protected def removeListener(listener: HeaderClickListener): Unit = removeHeaderClickListener(listener)
  }
  lazy val footerClickListeners = new ListenersSet[FooterClickEvent, FooterClickListener] {
    override def listeners = getListeners(classOf[FooterClickEvent])

    override protected def addListener(listener: ListenerLambda): Unit = addFooterClickListener(
      new FooterClickListener {
        override def footerClick(event: FooterClickEvent): Unit = listener(event)
      }
    )

    override protected def removeListener(listener: FooterClickListener): Unit = removeFooterClickListener(listener)
  }
  lazy val columnResizeListeners = new ListenersSet[ColumnResizeEvent, ColumnResizeListener] {
    override def listeners = getListeners(classOf[ColumnResizeEvent])

    override protected def addListener(listener: ListenerLambda): Unit = addColumnResizeListener(
      new ColumnResizeListener {
        override def columnResize(event: ColumnResizeEvent): Unit = listener(event)
      }
    )

    override protected def removeListener(listener: ColumnResizeListener): Unit = removeColumnResizeListener(listener)
  }
  lazy val columnReorderListeners = new ListenersSet[ColumnReorderEvent, ColumnReorderListener] {
    override def listeners = getListeners(classOf[ColumnResizeEvent])

    override protected def addListener(listener: ListenerLambda): Unit = addColumnReorderListener(
      new ColumnReorderListener {
        override def columnReorder(event: ColumnReorderEvent): Unit = listener(event)
      }
    )

    override protected def removeListener(listener: ColumnReorderListener): Unit = removeColumnReorderListener(listener)
  }

  def visibleColumns: Seq[Any] = getVisibleColumns

  def visibleColumns_=(visibleColumns: Seq[Any]) {
    setVisibleColumns(visibleColumns map {
      _.asInstanceOf[Object]
    }: _*)
  }

  def columnHeaders: Seq[Option[String]] = getColumnHeaders.map(Option(_)).toSeq

  def columnHeaders_=(columnHeaders: => Seq[String]): Unit = setColumnHeaders(columnHeaders: _*)

  def columnHeaders_=(columnHeaders: Seq[Option[String]]): Unit =
    setColumnHeaders(columnHeaders map {
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
}
