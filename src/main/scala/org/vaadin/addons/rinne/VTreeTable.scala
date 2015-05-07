package org.vaadin.addons.rinne

import com.vaadin.ui.TreeTable
import org.vaadin.addons.rinne.mixins.TableMixin

class VTreeTable extends TreeTable with TableMixin {

  def hierarchyColumn: Option[Any] = Option(getHierarchyColumnId)

  def hierarchyColumn_=(hierarchyColumn: Option[Any]) {
    setHierarchyColumn(hierarchyColumn.orNull)
  }

  def hierarchyColumn_=(hierarchyColumn: Any) {
    setHierarchyColumn(hierarchyColumn)
  }

  def animationsEnabled: Boolean = isAnimationsEnabled

  def animationsEnabled_=(animationsEnabled: Boolean): Unit = setAnimationsEnabled(animationsEnabled)
}
