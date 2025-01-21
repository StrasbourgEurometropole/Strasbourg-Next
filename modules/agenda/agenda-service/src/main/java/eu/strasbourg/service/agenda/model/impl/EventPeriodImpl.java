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

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.Validator;
import eu.strasbourg.utils.DateHelper;
import org.osgi.annotation.versioning.ProviderType;

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

	/**
	 * Si endDate = startDate OU
	 * Si (endDate = startDate + 1 ET endTime < startTime ET endTime ≤ 8H du matin) OU
	 * Si (endDate > startDate + 1 ET endDate - startDate <=5)
	 *  -> Le date/horaire (N fois)
	 * Sinon
	 * 	-> Du date[/heure de début] au date[/heure de début]/heure de fin
	 */
	@Override
	public List<String> getDisplay(Locale locale) {
		List<String> result = new ArrayList<>();

		// Cas où une ou les deux dates sont null
		if (this.getStartDate() == null || this.getEndDate() == null) {
			return result;
		}

		LocalDate startLocalDate = this.getStartDate().toInstant().atZone(ZoneId.systemDefault()).
				toLocalDate();
		LocalTime startLocalTime = LocalTime.parse("00:00");
		if(Validator.isNotNull(this.getStartTime()))
			startLocalTime = LocalTime.parse(this.getStartTime());
		LocalDateTime startLocalDateTime = LocalDateTime.of(startLocalDate,startLocalTime);

		LocalDate endLocalDate = this.getCalculateEndDate().toInstant().atZone(ZoneId.systemDefault()).
				toLocalDate();
		LocalTime endLocalTime = LocalTime.parse("00:00");
		if(Validator.isNotNull(this.getEndTime()))
			endLocalTime = LocalTime.parse(this.getEndTime());
		LocalDateTime endLocalDateTime = LocalDateTime.of(endLocalDate,endLocalTime);

		// Si endDate = startDate OU
		// Si (endDate = startDate + 1 ET endTime < startTime ET endTime ≤ 8H du matin) OU
		// Si (endDate > startDate + 1 ET endDate - startDate <=5)
		if (endLocalDate.equals(startLocalDate) ||
				(endLocalDate.equals(startLocalDate.plusDays(1)) &&
						endLocalTime.isBefore(startLocalTime) &&
						!endLocalTime.isAfter(LocalTime.parse("08:00"))) ||
				(endLocalDate.isAfter(startLocalDate.plusDays(1)) &&
						endLocalDate.isBefore(startLocalDate.plusDays(5)))) {
			result.add(displayDateTime(locale, false, startLocalDateTime, endLocalDateTime));

			// Si c'est une période récurrente ET endDate >= startDate + 1
			startLocalDateTime = startLocalDateTime.plusDays(1);
			if(this.getIsRecurrent() && !endLocalDate.isBefore(startLocalDate)) {
				// on ajoute les journées concernées
				while(endLocalDate.isAfter(startLocalDateTime.toLocalDate())) {
					result.add(displayDateTime(locale, false, startLocalDateTime, endLocalDateTime));
					startLocalDateTime = startLocalDateTime.plusDays(1);
				}
			}
		} else {
			// S'il dure plus longtemps
			result.add(displayDateTime(locale, true, startLocalDateTime, endLocalDateTime));
		}

		return result;
	}

	/**
	* Si period == true
	* 	 -> Du dd MMMM[Si non récurrent OU Si année de startDate > année de endDate : yyyy] [Si non récurrent : heure de début]
	* 		au dd MMMM yyyy [Si récurrent : heure de début] heure de fin
	* Sinon
	* 	 -> Le dd MMMM yyyy horaire
	*/
	private String displayDateTime(Locale locale, Boolean period, LocalDateTime startDateTime, LocalDateTime endDateTime){
		String result = "";

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMMM yyyy");
		if (locale.equals(Locale.GERMANY)) {
			dtf = DateTimeFormatter.ofPattern("dd. MMMM yyyy");
		}
		if(period){
			// Du dd MMMM[ yyyy]
			DateTimeFormatter dtfWithoutYear = DateTimeFormatter.ofPattern("dd MMMM");
			if (locale.equals(Locale.GERMANY)) {
				dtfWithoutYear = DateTimeFormatter.ofPattern("dd. MMMM");
			}
			result = LanguageUtil.get(locale, "eu.event.from-date") + " ";
			result += startDateTime.format(dtfWithoutYear);
			if (startDateTime.getYear() != endDateTime.getYear() || !this.getIsRecurrent()) {
				result += " " + startDateTime.getYear();
			}
			// si c'est une période non récurrente, on affiche l'heure de début ici
			if(Validator.isNotNull(this.getStartTime()) && !this.getIsRecurrent()) {
				result += displayTime(locale, startDateTime);
			}
			// au dd MMMM yyyy ...
			result += " " + LanguageUtil.get(locale, "eu.event.to") + " ";
			result += endDateTime.format(dtf);
			// si c'est une période non récurrente, on affiche l'heure de fin ici
			if(!this.getIsRecurrent()) {
				if(Validator.isNotNull(this.getEndTime())) {
					result += displayTime(locale, endDateTime);
				}
			}else {
				// Sinon on affiche l'horaire
				result += displayTime(locale, startDateTime, endDateTime);
			}
		}else{
			// Le dd MMMM yyyy ...
			result = LanguageUtil.get(locale, "eu.event.the") + " ";
			result += startDateTime.format(dtf);
			result += displayTime(locale, startDateTime, endDateTime);
		}

		return result;
	}

	/**
	 * Si startTime != null
	 * 	 Si endTime est null
	 * 	   ->  à partir de ...
	 * 	 Sinon
	 *     ->  de ... à ...
	 */
	private String displayTime(Locale locale, LocalDateTime startDateTime, LocalDateTime endDateTime){
		String result = "";

		if(Validator.isNotNull(this.getStartTime())){
			if(Validator.isNull(this.getEndTime())){
				// à partir de ...
				if (locale.equals(Locale.FRANCE)) {
					result += " &agrave; partir de ";
				} else if (locale.equals(Locale.GERMANY)) {
					result += " &agrave; partir de en allemand ";
				} else if (locale.equals(Locale.US)) {
					result += " &agrave; partir de en anglais ";
				}
				result += displayTime(locale, startDateTime);
			} else {
				// de ...
				if (locale.equals(Locale.FRANCE)) {
					result += " de ";
				} else if (locale.equals(Locale.GERMANY)) {
					result += " de en allemand ";
				} else if (locale.equals(Locale.US)) {
					result += " de en anglais ";
				}
				result += displayTime(locale, startDateTime);
				// à ...
				if (locale.equals(Locale.FRANCE)) {
					result += " &agrave; ";
				} else if (locale.equals(Locale.GERMANY)) {
					result += " &agrave; en allemand ";
				} else if (locale.equals(Locale.US)) {
					result += " &agrave; en anglais ";
				}
				result += displayTime(locale, endDateTime);
			}
		}

		return result;
	}

	/**
	 * Si time == minuit
	 * 	 ->   à minuit
	 * Sinon
	 * 	 ->   à HHh[mm]
	 */
	private String displayTime(Locale locale, LocalDateTime dateTime){
		String result = " ";
		if (locale.equals(Locale.FRANCE)) {
			result += "&agrave; ";
		} else if (locale.equals(Locale.GERMANY)) {
			result += "&agrave; en allemand ";
		} else if (locale.equals(Locale.US)) {
			result += "&agrave; en anglais ";
		}

		if(Validator.isNotNull(dateTime)) {
			if (dateTime.toLocalTime().equals(LocalTime.parse("00:00"))) {
				// minuit
				if (locale.equals(Locale.FRANCE)) {
					result += " minuit";
				} else if (locale.equals(Locale.GERMANY)) {
					result += " minuit en allemand";
				} else if (locale.equals(Locale.US)) {
					result += " minuit en anglais";
				}
			} else {
				// HHh[mm]
				result += dateTime.getHour() + "h";
				if (dateTime.getMinute() > 0) {
					result += dateTime.getMinute();
				}
			}
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
	 * 		- si endTime < startTime => ajouter endDate+1j à minuit
	 *
	 * 	Si pas de startTime -> minuit
	 *
	 * 	Utilisé pour l'indexer
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
		// on prend tous les jours de la période (sans l'heure de fin)
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

	/**
	 * Retourne la vrai endDate :
	 * Si la période est récurrente et que endTime < startTime => endDate + 1
	 * Sinon endDate
	 */
	@Override
	public Date getCalculateEndDate() {

		LocalTime startLocalTime = LocalTime.parse("00:00");
		if(Validator.isNotNull(this.getStartTime()))
			startLocalTime = LocalTime.parse(this.getStartTime());

		LocalDate endLocalDate = this.getEndDate().toInstant().atZone(ZoneId.systemDefault()).
				toLocalDate();
		LocalTime endLocalTime = LocalTime.parse("00:00");
		if(Validator.isNotNull(this.getEndTime()))
			endLocalTime = LocalTime.parse(this.getEndTime());

		if(this.getIsRecurrent() && endLocalTime.isBefore(startLocalTime))
			endLocalDate = endLocalDate.plusDays(1);

		return Date.from(endLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}
}