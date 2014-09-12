package org.vaadin.addons.rinne.mixins

import com.vaadin.ui.TextArea

trait TextAreaMixin extends TextArea with AbstractTextFieldMixin {
  def rows: Int = getRows

  def rows_=(rows: Int) {
    setRows(rows)
  }

  def wordwrap: Boolean = isWordwrap

  def wordwrap_=(wordwrap: Boolean) {
    setWordwrap(wordwrap)
  }
}
