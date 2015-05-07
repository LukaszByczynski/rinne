package org.vaadin.addons.rinne

import com.vaadin.ui.TextArea
import org.vaadin.addons.rinne.mixins.AbstractTextFieldMixin

class VTextArea extends TextArea with AbstractTextFieldMixin {
  def rows: Int = getRows

  def rows_=(rows: Int) {
    setRows(rows)
  }

  def wordwrap: Boolean = isWordwrap

  def wordwrap_=(wordwrap: Boolean) {
    setWordwrap(wordwrap)
  }
}
