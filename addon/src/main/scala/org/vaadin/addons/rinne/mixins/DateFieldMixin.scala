package org.vaadin.addons.rinne.mixins

import java.util.{TimeZone, Date}

import com.vaadin.shared.ui.datefield.Resolution
import com.vaadin.ui.DateField
import org.vaadin.addons.rinne.events.{FocusNotifier, BlurNotifier}

trait DateFieldMixin extends DateField with AbstractFieldMixin[Date] with BlurNotifier with FocusNotifier {

  resolution = Resolution.SECOND

  def resolution = getResolution

  def resolution_=(resolution: Resolution) {
    setResolution(resolution)
  }

  def dateFormat: Option[String] = Option(getDateFormat)

  def dateFormat_=(dateFormat: Option[String]) {
    setDateFormat(dateFormat.orNull)
  }

  def dateFormat_=(dateFormat: String) {
    setDateFormat(dateFormat)
  }

  def lenient: Boolean = isLenient

  def lenient_=(lenient: Boolean) {
    setLenient(lenient)
  }

  def showISOWeekNumbers: Boolean = isShowISOWeekNumbers

  def showISOWeekNumbers_=(showISOWeekNumbers: Boolean) {
    setShowISOWeekNumbers(showISOWeekNumbers)
  }

  def parseErrorMessage: Option[String] = Option(getParseErrorMessage)

  def parseErrorMessage_=(parseErrorMessage: Option[String]) {
    setParseErrorMessage(parseErrorMessage.orNull)
  }

  def parseErrorMessage_=(parseErrorMessage: String) {
    setParseErrorMessage(parseErrorMessage)
  }

  def timeZone: Option[TimeZone] = Option(getTimeZone)

  def timeZone_=(timeZone: Option[java.util.TimeZone]) {
    setTimeZone(timeZone.orNull)
  }

  def timeZone_=(timeZone: java.util.TimeZone) {
    setTimeZone(timeZone)
  }

}
