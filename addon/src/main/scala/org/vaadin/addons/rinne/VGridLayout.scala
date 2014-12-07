package org.vaadin.addons.rinne

import com.vaadin.ui.{Alignment, Component, GridLayout}
import org.vaadin.addons.rinne.mixins.{AbstractLayoutMixin, MarginHandlerMixin, SpacingHandlerMixin}

class VGridLayout extends GridLayout with AbstractLayoutMixin with SpacingHandlerMixin with MarginHandlerMixin {

  def add[C <: Component](
    component: C = null,
    col: Int = -1,
    row: Int = -1,
    col2: Int = -1,
    row2: Int = -1,
    alignment: Alignment = null
    ): C = {

    if (col >= 0 && row >= 0 && col2 >= 0 && row2 >= 0)
      addComponent(component, col, row, col2, row2)
    else if (col >= 0 && row >= 0)
      addComponent(component, col, row)
    else
      addComponent(component)

    if (alignment != null) {
      setComponentAlignment(component, alignment)
    }

    component
  }

  def columns: Int = getColumns

  def columns_=(columns: Int) {
    setColumns(columns)
  }

  def rows: Int = getRows

  def rows_=(rows: Int) {
    setRows(rows)
  }

  def cursorX: Int = getCursorX

  def cursorX_=(cursorX: Int) {
    setCursorX(cursorX)
  }

  def cursorY: Int = getCursorY

  def cursorY_=(cursorY: Int) {
    setCursorY(cursorY)
  }

}
