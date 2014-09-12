package org.vaadin.addons.rinne

import com.vaadin.annotations.Theme
import com.vaadin.server.VaadinRequest
import com.vaadin.ui.UI
import com.vaadin.ui.themes.ValoTheme

@Theme("valo")
class RinneUI extends UI {
  override def init(p1: VaadinRequest): Unit = {
    setContent(new VVerticalLayout {
      sizeFull()

      componentSet += new VLabel {
        styleName = ValoTheme.LABEL_H1
        value = "RinneUI"
      }
    })
  }
}