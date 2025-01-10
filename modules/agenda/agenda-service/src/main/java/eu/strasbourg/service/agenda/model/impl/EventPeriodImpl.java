/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package eu.strasbourg.service.agenda.model.impl;

import com.liferay.portal.kernel.util.Validator;
import eu.strasbourg.service.place.model.Place;
import eu.strasbourg.service.place.service.PlaceLocalServiceUtil;
import org.osgi.annotation.versioning.ProviderType;
import eu.strasbourg.utils.DateHelper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

/**
 * The extended model implementation for the EventPeriod service. Represents a row in the &quot;event_EventPeriod&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link eu.strasbourg.service.agenda.model.EventPeriod} interface.
 * </p>
 *
 * @author BenjaminBini
 */
@ProviderType
public class EventPeriodImpl extends EventPeriodBaseImpl {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6986209394295845493L;

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a event period model instance should use the {@link eu.strasbourg.service.agenda.model.EventPeriod} interface instead.
	 */
	public EventPeriodImpl() {
	}
	
	@Override
	public String getDisplay(Locale locale) {
		String result = "";

		// Cas où une ou les deux dates sont null
		if (this.getStartDate() == null || this.getEndDate() == null) {
			return "";
		}

		LocalDate startLocalDate = this.getStartDate().toInstant().atZone(ZoneId.systemDefault()).
				toLocalDate();
		LocalTime startLocalTime = LocalTime.parse("00:00");
		if(Validator.isNotNull(this.getStartTime()))
			startLocalTime = LocalTime.parse(this.getStartTime());
		LocalDateTime startLocalDateTime = LocalDateTime.of(startLocalDate,startLocalTime);

		LocalDate endLocalDate = this.getEndDate().toInstant().atZone(ZoneId.systemDefault()).
				toLocalDate();
		LocalTime endLocalTime = LocalTime.parse("00:00");
		if(Validator.isNotNull(this.getEndTime()))
			endLocalTime = LocalTime.parse(this.getEndTime());
		LocalDateTime endLocalDateTime = LocalDateTime.of(endLocalDate,endLocalTime);

		// Si endDate = startDate
		// OU
		// Si (endDate = startDate + 1 ET endTime < startTime ET endTime ≤ 8H du matin)
		if (endLocalDate.equals(startLocalDate) ||
				(endLocalDate.equals(startLocalDate.plusDays(1)) &&
						endLocalTime.isBefore(startLocalTime) &&
						!endLocalTime.isAfter(LocalTime.parse("08:00")))) {

			result = displayDateTime(locale, startLocalDateTime, endLocalTime);

			// Si c'est une période récurrente ET endDate != startDate
			// on ajoute une journée
			if(this.getIsRecurrent() && !endLocalDate.equals(startLocalDate)) {
				result += "<br/>" + displayDateTime(locale, startLocalDateTime.plusDays(1), endLocalTime);
			}/*
		} else {
			// S'il dure plus longtemps
			if (locale.equals(Locale.FRANCE)) {
				result = "Du ";
				if (startCal.getMonth() == endCal.getMonth()
						&& startCal.getYear() == endCal.getYear()) {
					DateFormat df = new SimpleDateFormat("dd", Locale.FRANCE);
					result += df.format(this.getStartDate());
				} else if (startCal.getYear() == endCal.getYear()) {
					DateFormat df = new SimpleDateFormat("dd MMMM", Locale.FRANCE);
					result += df.format(this.getStartDate());
				} else {
					DateFormat df = new SimpleDateFormat("dd MMMM yyyy", Locale.FRANCE);
					result += df.format(this.getStartDate());
				}
				DateFormat df = new SimpleDateFormat("dd MMMM yyyy", Locale.FRANCE);
				result += " au " + df.format(this.getEndDate());
			} else if (locale.equals(Locale.GERMANY)) {
				result = "Vom ";
				if (startCal.getMonth() == endCal.getMonth()
						&& startCal.getYear() == endCal.getYear()) {
					DateFormat df = new SimpleDateFormat("dd.", Locale.GERMANY);
					result += df.format(this.getStartDate());
				} else if (startCal.getYear() == endCal.getYear()) {
					DateFormat df = new SimpleDateFormat("dd. MMMM", Locale.GERMANY);
					result += df.format(this.getStartDate());
				} else {
					DateFormat df = new SimpleDateFormat("dd. MMMM yyyy", Locale.GERMANY);
					result += df.format(this.getStartDate());
				}
				DateFormat df = new SimpleDateFormat("dd. MMMM yyyy", Locale.GERMANY);
				result += " bis zum " + df.format(this.getEndDate());
			} else if (locale.equals(Locale.US)) {
				result = "From ";
				if (startCal.getMonth() == endCal.getMonth()
						&& startCal.getYear() == endCal.getYear()) {
					DateFormat df = new SimpleDateFormat("dd", Locale.US);
					result += df.format(this.getStartDate());
				} else if (startCal.getYear() == endCal.getYear()) {
					DateFormat df = new SimpleDateFormat("dd MMMM", Locale.US);
					result += df.format(this.getStartDate());
				} else {
					DateFormat df = new SimpleDateFormat("dd MMMM yyyy", Locale.US);
					result += df.format(this.getStartDate());
				}
				DateFormat df = new SimpleDateFormat("dd MMMM yyyy", Locale.US);
				result += " to " + df.format(this.getEndDate());
			}*/
		}

		return result;
	}
	
	@Override
	public String getDisplay(Locale locale, boolean dispYear, boolean dispShortMonth) {
		return DateHelper.displayPeriod(this.getStartDate(), this.getEndDate(), locale, dispYear, dispShortMonth);
	}

	/**
	 * Retourne la liste des dates
	 * 		pour une période non récurrente :
	 * 		- firstDate + startTime
	 * 		- toutes les autres dates à minuit
	 *
	 * 		pour une période récurrente :
	 * 		- toutes les dates à startTime
	 * 		- si endTime < startTime => faut ajouter endDate+1j à minuit
	 *
	 * 	Si pas de startTime -> minuit
	 */
	@Override
	public List<Date> getDays() {
		List<Date> dates = new ArrayList<>();
		Calendar now = new GregorianCalendar();
		now.set(Calendar.HOUR_OF_DAY, 0);
		now.set(Calendar.MINUTE, 0);
		now.set(Calendar.SECOND, 0);
		now.set(Calendar.MILLISECOND, 0);

		LocalTime minuit = LocalTime.parse("00:00");
		Date startDate = this.getStartDate();
		LocalTime startLocalTime;
		try {
			startLocalTime = LocalTime.parse(this.getStartTime());
		}catch (Exception e){
			startLocalTime = minuit;
		}

		Date endDate = this.getEndDate();
		LocalTime endLocalTime;
		try {
			endLocalTime = LocalTime.parse(this.getEndTime());
		}catch (Exception e){
			endLocalTime = minuit;
		}

		Calendar calendar = new GregorianCalendar();
		calendar.setTime(startDate);
		// on ne prend que les jours avant la date de fin de la période (sans l'heure de fin)
		while (!calendar.getTime().after(endDate)) {
			// si le jour (sans l'heure) est passé, on passe
			if(!calendar.getTime().before(now.getTime())) {
				Calendar day = new GregorianCalendar();
				day.setTime(calendar.getTime());
				// si la période est récurrente ou si c'est le 1er jour de la période on lui set l'horaire de début
				if (this.getIsRecurrent() || calendar.getTime().equals(startDate)) {
					day.set(Calendar.HOUR_OF_DAY, startLocalTime.getHour());
					day.set(Calendar.MINUTE, startLocalTime.getMinute());
				} else {
					// sinon on le set à minuit (event déjà commencé à cette date)
					day.set(Calendar.HOUR_OF_DAY, 0);
					day.set(Calendar.MINUTE, 0);
				}
				day.set(Calendar.SECOND, 0);
				day.set(Calendar.MILLISECOND, 0);
				Date result = day.getTime();
				dates.add(result);
			}
			calendar.add(Calendar.DATE, 1);
		}

		// si la période est récurrente et que l'heure de fin est avant l'heure de début,
		// on ajoute 1 jour, car l'event se terminera donc le lendemain du dernier jour de la période
		if(this.getIsRecurrent() && endLocalTime.isBefore(startLocalTime)){
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			Date result = calendar.getTime();
			dates.add(result);
		}
		return dates;
	}

	/*
	* Si startTime est null
	*  -> Le dd MMMM yyyy
	* Sinon
	* 	Si endTime est null
	* 	 -> Le dd MMMM yyyy à partir de HHh[mm]
	* 	Sinon
	* 		Si endTime == minuit
	* 		 -> Le dd MMMM yyyy de HHh[mm] à minuit
	* 		Sinon
	* 		 -> Le dd MMMM yyyy de HHh[mm] à HHh[mm]
	* */
	private String displayDateTime(Locale locale, LocalDateTime startDateTime, LocalTime endTime){
		String result = "";
		// Le dd MMMM yyyy
		if (locale.equals(Locale.FRANCE)) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMMM yyyy");
			result = "Le " + startDateTime.format(dtf);
		} else if (locale.equals(Locale.GERMANY)) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd. MMMM yyyy");
			result = startDateTime.format(dtf);
		} else if (locale.equals(Locale.US)) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMMM yyyy");
			result = startDateTime.format(dtf);
		}

		if(Validator.isNotNull(this.getStartTime())){
			if(Validator.isNull(this.getEndTime())){
				// à partir de HHh[mm]
				if (locale.equals(Locale.FRANCE)) {
					result += " &agrave; partir de " + startDateTime.getHour() + "h";
				} else if (locale.equals(Locale.GERMANY)) {
					result += " à partir de en allemand " + startDateTime.getHour() + "h";
				} else if (locale.equals(Locale.US)) {
					result += " à partir de en anglais " + startDateTime.getHour() + "h";
				}
				if (startDateTime.getMinute() > 0) {
					result += startDateTime.getMinute();
				}
			} else {
				// de HHh[MM]
				result += " de " + startDateTime.getHour() + "h";
				if (startDateTime.getMinute() > 0) {
					result += startDateTime.getMinute();
				}
				if (this.getEndTime().equals("00:00")) {
					// à minuit
					if (locale.equals(Locale.FRANCE)) {
						result += " &agrave; minuit";
					} else if (locale.equals(Locale.GERMANY)) {
						result += " &agrave; minuit";
					} else if (locale.equals(Locale.US)) {
						result += " &agrave; minuit";
					}
				} else {
					//  à HHh[MM]
					if (locale.equals(Locale.FRANCE)) {
						result += " &agrave; " + endTime.getHour() + "h";
					} else if (locale.equals(Locale.GERMANY)) {
						result += " &agrave; " + endTime.getHour() + "h";
					} else if (locale.equals(Locale.US)) {
						result += " &agrave; " + endTime.getHour() + "h";
					}
					if (startDateTime.getMinute() > 0) {
						result += startDateTime.getMinute();
					}
				}
			}
		}

		return result;
	}

}