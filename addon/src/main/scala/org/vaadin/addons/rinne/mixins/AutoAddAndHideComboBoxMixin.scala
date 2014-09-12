package org.vaadin.addons.rinne.mixins

import org.vaadin.addons.rinne.VComboBox

trait AutoAddAndHideComboBoxMixin extends VComboBox with HideWhenEmptyMixin[AnyRef] {
  nullSelectionAllowed = false
  newItemsAllowed = true
  immediate = true

  valueChangeListeners += (_ => {
    if (value.isDefined && !containsId(value.get) && !value.get.toString.isEmpty)
      addItem(value.get)
  })
}
