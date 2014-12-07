package org.vaadin.addons.rinne

import com.vaadin.ui.ListSelect
import org.vaadin.addons.rinne.mixins.{AbstractSelectMixin, MultiSelectableMixin}

class VListSelect extends ListSelect with AbstractSelectMixin with MultiSelectableMixin {

  def rows: Int = getRows

  def rows_=(rows: Int) {
    setRows(rows)
  }
}
