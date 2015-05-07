package org.vaadin.addons.rinne

import com.vaadin.server.Resource
import com.vaadin.ui.Video
import org.vaadin.addons.rinne.mixins.AbstractMediaMixin

class VVideo extends Video with AbstractMediaMixin {

  def poster: Option[Resource] = Option(getPoster)

  def poster_=(poster: Option[Resource]) {
    setPoster(poster.orNull)
  }

  def poster_=(poster: Resource) {
    setPoster(poster)
  }

}
