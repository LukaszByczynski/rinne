package org.vaadin.addons.rinne

import com.vaadin.ui.TwinColSelect
import org.vaadin.addons.rinne.mixins.AbstractSelectMixin

class VTwinColSelect extends TwinColSelect with AbstractSelectMixin {

  def rows: Int = getRows

  def rows_=(rows: Int) {
    setRows(rows)
  }

  def rightColumnCaption: Option[String] = Option(getRightColumnCaption)

  def rightColumnCaption_=(rightColumnCaption: Option[String]) {
    setRightColumnCaption(rightColumnCaption.orNull)
  }

  def rightColumnCaption_=(rightColumnCaption: String) {
    setRightColumnCaption(rightColumnCaption)
  }

  def leftColumnCaption: Option[String] = Option(getLeftColumnCaption)

  def leftColumnCaption_=(leftColumnCaption: Option[String]) {
    setLeftColumnCaption(leftColumnCaption.orNull)
  }

  def leftColumnCaption_=(leftColumnCaption: String) {
    setLeftColumnCaption(leftColumnCaption)
  }
}
