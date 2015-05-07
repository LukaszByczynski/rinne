package org.vaadin.addons.rinne.helpers

import org.vaadin.addons.rinne.VComboBox

trait AutoAddAndHideComboBoxMixin extends HideWhenEmptyMixin[AnyRef] {
  this: VComboBox =>

  nullSelectionAllowed = false
  newItemsAllowed = true
  immediate = true

  valueChangeListeners += (_ => {
    value.foreach(v =>
      if (!containsId(v) && !v.toString.isEmpty)
        addItem(v)
    )
  })
}
