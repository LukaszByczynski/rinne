package org.vaadin.addons.rinne.mixins

import com.vaadin.ui.ListSelect

trait ListSelectMixin extends ListSelect with AbstractSelectMixin with MultiSelectableMixin {

  def rows: Int = getRows

  def rows_=(rows: Int) {
    setRows(rows)
  }
}
