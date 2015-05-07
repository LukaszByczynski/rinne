package org.vaadin.addons.rinne.mixins

import com.vaadin.ui.AbstractSelect
import com.vaadin.ui.AbstractSelect.ItemCaptionMode

trait AbstractSelectMixin extends AbstractFieldMixin[AnyRef] with ComponentMixin
with ContainerMixin with ContainerViewerMixin with ContainerItemSetChangeNotifierMixin
with ContainerPropertySetChangeNotifierMixin {
  this: AbstractSelect =>

  def newItemsAllowed: Boolean = isNewItemsAllowed

  def newItemsAllowed_=(newItemsAllowed: Boolean): Unit = setNewItemsAllowed(newItemsAllowed)

  def itemCaptionMode: ItemCaptionMode = getItemCaptionMode

  def itemCaptionMode_=(itemCaptionMode: ItemCaptionMode): Unit = setItemCaptionMode(itemCaptionMode)

  def itemCaptionPropertyId: Option[Any] = Option(getItemCaptionPropertyId)

  def itemCaptionPropertyId_=(itemCaptionPropertyId: Option[Any]): Unit = {
    setItemCaptionPropertyId(itemCaptionPropertyId.orNull)
  }

  def itemCaptionPropertyId_=(itemCaptionPropertyId: Any): Unit = setItemCaptionPropertyId(itemCaptionPropertyId)

  def itemIconPropertyId: Option[Any] = Option(getItemIconPropertyId)

  def itemIconPropertyId_=(itemIconPropertyId: Option[Any]): Unit = setItemIconPropertyId(itemIconPropertyId.orNull)

  def itemIconPropertyId_=(itemIconPropertyId: Any): Unit = setItemIconPropertyId(itemIconPropertyId)

  def nullSelectionAllowed: Boolean = isNullSelectionAllowed

  def nullSelectionAllowed_=(nullSelectionAllowed: Boolean): Unit = setNullSelectionAllowed(nullSelectionAllowed)

  def nullSelectionItemId: Option[Any] = Option(getNullSelectionItemId)

  def nullSelectionItemId_=(nullSelectionItemId: Option[Any]): Unit = setNullSelectionItemId(nullSelectionItemId.orNull)

  def nullSelectionItemId_=(nullSelectionItemId: Any): Unit = setNullSelectionItemId(nullSelectionItemId)

  def multiSelect: Boolean = isMultiSelect

  def multiSelect_=(multiSelect: Boolean): Unit = setMultiSelect(multiSelect)
}