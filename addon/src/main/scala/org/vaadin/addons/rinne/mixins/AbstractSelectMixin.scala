package org.vaadin.addons.rinne.mixins

import com.vaadin.ui.AbstractSelect
import com.vaadin.ui.AbstractSelect.ItemCaptionMode

trait AbstractSelectMixin extends AbstractSelect with AbstractFieldMixin[Object] with ComponentMixin {

  def newItemsAllowed: Boolean = isNewItemsAllowed

  def newItemsAllowed_=(newItemsAllowed: Boolean): Unit = setNewItemsAllowed(newItemsAllowed)

  def itemCaptionMode: ItemCaptionMode = getItemCaptionMode

  def itemCaptionMode_=(itemCaptionMode: ItemCaptionMode) {
    setItemCaptionMode(itemCaptionMode)
  }

  def itemCaptionPropertyId: Option[Any] = Option(getItemCaptionPropertyId)

  def itemCaptionPropertyId_=(itemCaptionPropertyId: Option[Any]) {
    setItemCaptionPropertyId(itemCaptionPropertyId.orNull)
  }

  def itemCaptionPropertyId_=(itemCaptionPropertyId: Any) {
    setItemCaptionPropertyId(itemCaptionPropertyId)
  }

  def itemIconPropertyId: Option[Any] = Option(getItemIconPropertyId)

  def itemIconPropertyId_=(itemIconPropertyId: Option[Any]) {
    setItemIconPropertyId(itemIconPropertyId.orNull)
  }

  def itemIconPropertyId_=(itemIconPropertyId: Any) {
    setItemIconPropertyId(itemIconPropertyId)
  }

  def nullSelectionAllowed: Boolean = isNullSelectionAllowed

  def nullSelectionAllowed_=(nullSelectionAllowed: Boolean) {
    setNullSelectionAllowed(nullSelectionAllowed)
  }

  def nullSelectionItemId: Option[Any] = Option(getNullSelectionItemId)

  def nullSelectionItemId_=(nullSelectionItemId: Option[Any]) {
    setNullSelectionItemId(nullSelectionItemId.orNull)
  }

  def nullSelectionItemId_=(nullSelectionItemId: Any) {
    setNullSelectionItemId(nullSelectionItemId)
  }

}