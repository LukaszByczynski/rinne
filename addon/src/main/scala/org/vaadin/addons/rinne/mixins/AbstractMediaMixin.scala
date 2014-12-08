package org.vaadin.addons.rinne.mixins

import com.vaadin.server.Resource
import com.vaadin.ui.AbstractMedia

trait AbstractMediaMixin extends AbstractMedia with AbstractComponentMixin {

  import scala.collection.JavaConverters._

  def source: Option[Resource] = getSources.asScala.headOption

  def source_=(source: Resource) {
    setSource(source)
  }

  def sources: Seq[Resource] = getSources.asScala

  def showControls: Boolean = isShowControls

  def showControls_=(showControls: Boolean) {
    setShowControls(showControls)
  }

  def altText: Option[String] = Option(getAltText)

  def altText_=(altText: Option[String]) {
    setAltText(altText.orNull)
  }

  def altText_=(altText: String) {
    setAltText(altText)
  }

  def htmlContentAllowed: Boolean = isHtmlContentAllowed

  def htmlContentAllowed_=(htmlContentAllowed: Boolean) {
    setHtmlContentAllowed(htmlContentAllowed)
  }

  def autoplay: Boolean = isAutoplay

  def autoplay_=(autoplay: Boolean) {
    setAutoplay(autoplay)
  }

  def muted: Boolean = isMuted

  def muted_=(muted: Boolean) {
    setMuted(muted)
  }

}
