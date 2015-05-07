package org.vaadin.addons.rinne

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

  def codebase_=(codebase: String): Unit = setCodebase(codebase)

  def codebase_=(codebase: Option[String]): Unit = setCodebase(codebase.orNull)

  def codetype: Option[String] = Option(getCodetype)

  def codetype_=(codetype: String): Unit = setCodetype(codetype)

  def codetype_=(codetype: Option[String]): Unit = setCodetype(codetype.orNull)

  def standby: Option[String] = Option(getStandby)

  def standby_=(standby: String): Unit = setStandby(standby)

  def standby_=(standby: Option[String]): Unit = setStandby(standby.orNull)

  def mimeType: Option[String] = Option(getMimeType)

  def mimeType_=(mimeType: String): Unit = setMimeType(mimeType)

  def mimeType_=(mimeType: Option[String]): Unit = setMimeType(mimeType.orNull)

  def classId: Option[String] = Option(getClassId)

  def classId_=(classId: String): Unit = setClassId(classId)

  def classId_=(classId: Option[String]): Unit = setClassId(classId.orNull)

  def archive: Option[String] = Option(getArchive)

  def archive_=(archive: String): Unit = setArchive(archive)

  def archive_=(archive: Option[String]): Unit = setArchive(archive.orNull)
}
