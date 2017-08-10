package org.vaadin.addons.rinne

import com.vaadin.v7.ui.ListSelect
import org.vaadin.addons.rinne.mixins.AbstractSelectMixin

class VListSelect extends ListSelect with AbstractSelectMixin {

  def rows: Int = getRows

  def rows_=(rows: Int) {
    setRows(rows)
  }
}
