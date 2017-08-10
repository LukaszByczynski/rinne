package org.vaadin.addons.rinne.mixins

import java.util.{TimeZone, Date}

import com.vaadin.event.FieldEvents.{BlurEvent, BlurListener, FocusEvent, FocusListener}
import com.vaadin.ui.AbstractComponent
import com.vaadin.v7.shared.ui.datefield.Resolution
import com.vaadin.v7.ui.DateField
import org.vaadin.addons.rinne.events.ListenersSet

trait DateFieldMixin extends AbstractComponent with AbstractFieldMixin[Date]  {
  this: DateField =>

  resolution = Resolution.SECOND

  lazy val focusListeners = new ListenersSet[FocusEvent, FocusListener] {

    override protected def addListener(listener: ListenerLambda): Unit = addFocusListener(
      (focusEvent: FocusEvent) => listener(focusEvent)
    )

    override protected def removeListener(listener: FocusListener): Unit = removeListener(listener)

    override protected def listeners: java.util.Collection[_] = getListeners(classOf[FocusEvent])
  }

  lazy val blurListeners = new ListenersSet[BlurEvent, BlurListener] {

    override protected def addListener(listener: ListenerLambda): Unit = addBlurListener(
      (blurEvent: BlurEvent) => listener(blurEvent)
    )

    override protected def removeListener(listener: BlurListener): Unit = removeListener(listener)

    override protected def listeners: java.util.Collection[_] = getListeners(classOf[BlurEvent])
  }


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
