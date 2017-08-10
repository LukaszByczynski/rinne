package org.vaadin.addons.rinne

import java.util.Date

import com.vaadin.event.dd.DropHandler
import com.vaadin.v7.ui.Calendar
import com.vaadin.v7.ui.components.calendar.event.CalendarEventProvider
import org.vaadin.addons.rinne.mixins.AbstractComponentMixin

class VCalendar extends Calendar with AbstractComponentMixin {

  def eventProvider: Option[CalendarEventProvider] = Option(getEventProvider)

  def eventProvider_=(value: CalendarEventProvider): Unit = setEventProvider(value)

  def dayNamesShort: Array[String] = getDayNamesShort

  def dropHandler: Option[DropHandler] = Option(getDropHandler)

  def dropHandler_=(value: DropHandler): Unit = setDropHandler(value)

  def dropHandler_=(value: Option[DropHandler]): Unit = setDropHandler(value.orNull)

  def calendarEndDate: Date = getEndDate

  def calendarEndDate_=(value: Date): Unit = setEndDate(value)

  def firstVisibleDayOfWeek: Int = getFirstVisibleDayOfWeek

  def firstVisibleDayOfWeek_=(value: Int): Unit = setFirstVisibleDayOfWeek(value)

  def firstVisibleHourOfDay: Int = getFirstVisibleHourOfDay

  def firstVisibleHourOfDay_=(value: Int): Unit = setFirstVisibleHourOfDay(value)

  def internalCalendar: java.util.Calendar = getInternalCalendar

  def lastVisibleDayOfWeek: Int = getLastVisibleDayOfWeek

  def lastVisibleHourOfDay: Int = getLastVisibleHourOfDay

  def monthNamesShort: Array[String] = getMonthNamesShort

  def calendarStartDate: Date = getStartDate

  def calendarStartDate_=(value: Date): Unit = setStartDate(value)

  def timeFormat: Calendar.TimeFormat = getTimeFormat

  def timeFormat_=(value: Calendar.TimeFormat): Unit = setTimeFormat(value)

  def timeZone: java.util.TimeZone = getTimeZone

  def timeZone_=(value: java.util.TimeZone) = setTimeZone(value)

  def weeklyCaptionFormat: String = getWeeklyCaptionFormat

  def weeklyCaptionFormat_=(value: String): Unit = setWeeklyCaptionFormat(value)
}


