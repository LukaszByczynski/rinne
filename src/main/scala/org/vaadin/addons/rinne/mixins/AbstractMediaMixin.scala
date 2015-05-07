package org.vaadin.addons.rinne.mixins

import com.vaadin.server.Resource
import com.vaadin.ui.AbstractMedia

trait AbstractMediaMixin extends AbstractComponentMixin {
  this: AbstractMedia =>

  import scala.collection.JavaConverters._

  def source: Option[Resource] = getSources.asScala.headOption

  def source_=(source: Resource): Unit = setSource(source)

  def sources: Seq[Resource] = getSources.asScala

  def showControls: Boolean = isShowControls

  def showControls_=(showControls: Boolean): Unit = setShowControls(showControls)

  def altText: Option[String] = Option(getAltText)

  def altText_=(altText: Option[String]): Unit = setAltText(altText.orNull)

  def altText_=(altText: String): Unit = setAltText(altText)

  def htmlContentAllowed: Boolean = isHtmlContentAllowed

  def htmlContentAllowed_=(htmlContentAllowed: Boolean): Unit = setHtmlContentAllowed(htmlContentAllowed)

  def autoplay: Boolean = isAutoplay

  def autoplay_=(autoplay: Boolean): Unit = setAutoplay(autoplay)

  def muted: Boolean = isMuted

  def muted_=(muted: Boolean): Unit = setMuted(muted)

}
