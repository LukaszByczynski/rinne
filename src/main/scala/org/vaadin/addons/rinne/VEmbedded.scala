package org.vaadin.addons.rinne

import com.vaadin.server.Resource
import com.vaadin.ui.Embedded
import org.vaadin.addons.rinne.mixins.{AbstractComponentMixin, ComponentMixin, MouseClickNotifierMixin}

import scala.collection.mutable

class VEmbedded extends Embedded with AbstractComponentMixin with ComponentMixin with MouseClickNotifierMixin {

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

  def codebase: Option[String] = Option(getCodebase)

  def codebase_=(codebase: Option[String]): Unit = setCodebase(codebase.orNull)

  def codebase_=(codebase: String): Unit = setCodebase(codebase)

  def codetype: Option[String] = Option(getCodetype)

  def codetype_=(codetype: Option[String]): Unit = setCodetype(codetype.orNull)

  def codetype_=(codetype: String): Unit = setCodetype(codetype)

  def standby: Option[String] = Option(getStandby)

  def standby_=(standby: Option[String]): Unit = setStandby(standby.orNull)

  def standby_=(standby: String): Unit = setStandby(standby)

  def mimeType: Option[String] = Option(getMimeType)

  def mimeType_=(mimeType: Option[String]): Unit = setMimeType(mimeType.orNull)

  def mimeType_=(mimeType: String): Unit = setMimeType(mimeType)

  def classId: Option[String] = Option(getClassId)

  def classId_=(classId: Option[String]): Unit = setClassId(classId.orNull)

  def classId_=(classId: String): Unit = setClassId(classId)

  def archive: Option[String] = Option(getArchive)

  def archive_=(archive: Option[String]): Unit = setArchive(archive.orNull)

  def archive_=(archive: String): Unit = setArchive(archive)

  def alternateText: Option[String] = Option(getAlternateText)

  def alternateText_=(alternateText: Option[String]): Unit = setAlternateText(alternateText.orNull)

  def alternateText_=(alternateText: String): Unit = setAlternateText(alternateText)

  def source: Option[Resource] = Option(getSource)

  def source_=(source: Resource): Unit = setSource(source)

  def source_=(source: Option[Resource]): Unit = setSource(source.orNull)
}
