package org.vaadin.addons.rinne

import com.vaadin.server.Resource
import com.vaadin.ui.Embedded
import org.vaadin.addons.rinne.mixins.AbstractComponentMixin

import scala.collection.mutable

class VEmbedded extends Embedded with AbstractComponentMixin {

  lazy val parameters: mutable.Map[String, String] = new mutable.Map[String, String] with Serializable {
    def -=(name: String): this.type = {
      removeParameter(name)
      this
    }

    def +=(parameter: (String, String)): this.type = {
      update(parameter._1, parameter._2)
      this
    }

    override def update(name: String, value: String) {
      setParameter(name, value)
    }

    def get(name: String): Option[String] = Option(getParameter(name))

    override def size = {
      import scala.collection.JavaConverters._
      getParameterNames.asScala.size
    }

    def iterator: Iterator[(String, String)] = {
      import scala.collection.JavaConverters._
      getParameterNames.asScala.map { name => (name, getParameter(name)) }
    }
  }

  def alternateText: Option[String] = Option(getAlternateText)

  def alternateText_=(alternateText: Option[String]) = setAlternateText(alternateText.orNull)

  def alternateText_=(alternateText: String) = setAlternateText(alternateText)

  def source: Option[Resource] = Option(getSource)

  def source_=(source: Resource) = setSource(source)

  def source_=(source: Option[Resource]) = setSource(source.orNull)

  def codebase: Option[String] = Option(getCodebase)

  def codebase_=(codebase: String) = setCodebase(codebase)

  def codebase_=(codebase: Option[String]) = setCodebase(codebase.orNull)

  def codetype: Option[String] = Option(getCodetype)

  def codetype_=(codetype: String) = setCodetype(codetype)

  def codetype_=(codetype: Option[String]) = setCodetype(codetype.orNull)

  def standby: Option[String] = Option(getStandby)

  def standby_=(standby: String) = setStandby(standby)

  def standby_=(standby: Option[String]) = setStandby(standby.orNull)

  def mimeType: Option[String] = Option(getMimeType)

  def mimeType_=(mimeType: String) = setMimeType(mimeType)

  def mimeType_=(mimeType: Option[String]) = setMimeType(mimeType.orNull)

  def classId: Option[String] = Option(getClassId)

  def classId_=(classId: String) = setClassId(classId)

  def classId_=(classId: Option[String]) = setClassId(classId.orNull)

  def archive: Option[String] = Option(getArchive)

  def archive_=(archive: String) = setArchive(archive)

  def archive_=(archive: Option[String]) = setArchive(archive.orNull)
}
