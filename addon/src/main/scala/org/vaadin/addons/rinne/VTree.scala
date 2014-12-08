package org.vaadin.addons.rinne

import com.vaadin.shared.ui.MultiSelectMode
import com.vaadin.ui.Tree
import org.vaadin.addons.rinne.mixins.AbstractSelectMixin

class VTree extends Tree with AbstractSelectMixin {

  def multiSelect: Boolean = isMultiSelect

  def multiSelect_=(multiSelect: Boolean) {
    setMultiSelect(multiSelect)
  }

  def expanded(itemId: Any): Boolean = isExpanded(itemId)

  def selectionMode = {
    if (!isSelectable)
      SelectionMode.None
    else if (isMultiSelect && getMultiselectMode == MultiSelectMode.SIMPLE)
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
        setMultiselectMode(MultiSelectMode.DEFAULT)
      case SelectionMode.MultiSimple =>
        setSelectable(true)
        setMultiSelect(true)
        setMultiselectMode(MultiSelectMode.SIMPLE)
    }
  }
}