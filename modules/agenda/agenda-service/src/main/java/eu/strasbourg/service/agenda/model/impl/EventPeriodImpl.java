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

import java.time.LocalTime;
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
		return DateHelper.displayPeriod(this.getStartDate(), this.getEndDate(), locale, true, false);
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
	 */
	@Override
	public List<Date> getDays() {
		List<Date> dates = new ArrayList<>();
		Calendar now = new GregorianCalendar();
		now.set(Calendar.HOUR_OF_DAY, 0);
		now.set(Calendar.MINUTE, 0);
		now.set(Calendar.SECOND, 0);
		now.set(Calendar.MILLISECOND, 0);

		Date startDate = this.getStartDate();
		LocalTime startLocalTime = LocalTime.parse(this.getStartTime());

		Date endDate = this.getEndDate();
		LocalTime endLocalTime = LocalTime.parse(this.getEndTime());

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

}