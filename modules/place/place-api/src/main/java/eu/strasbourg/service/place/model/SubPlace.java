/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.place.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the SubPlace service. Represents a row in the &quot;place_SubPlace&quot; database table, with each column mapped to a property of this class.
 *
 * @author Angelique Zunino Champougny
 * @see SubPlaceModel
 * @generated
 */
@ImplementationClassName("eu.strasbourg.service.place.model.impl.SubPlaceImpl")
@ProviderType
public interface SubPlace extends PersistedModel, SubPlaceModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.place.model.impl.SubPlaceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<SubPlace, Long> SUB_PLACE_ID_ACCESSOR =
		new Accessor<SubPlace, Long>() {

			@Override
			public Long get(SubPlace subPlace) {
				return subPlace.getSubPlaceId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<SubPlace> getTypeClass() {
				return SubPlace.class;
			}

		};

	/**
	 * Retourne les ScheduleExceptions du sous-lieu
	 */
	public java.util.List<ScheduleException> getScheduleExceptions();

	/**
	 * Retourne les Periods du lieu auquel appartient le sous-lieu
	 */
	public java.util.List<Period> getPeriods();

	/**
	 * Retourne les périodes qui ne sont pas par défaut
	 */
	public java.util.List<Period> getNonDefaultPeriod();

	/**
	 * Retourne la période par défaut
	 */
	public Period getDefaultPeriod();

	/**
	 * Retourne le lieu parent du sous-lieu
	 */
	public Place getParentPlace();

	/**
	 * Retourne le lieu parent du sous-lieu
	 */
	public Place getPlaceByPlaceId(long placeId);

	/**
	 * Retourne les PublicHolidays
	 */
	public java.util.List<PublicHoliday> getPublicHolidays();

	/**
	 * Retourne une map contennant les horaires de chaque jour des 7 jours
	 * suivants "startDate" (inclus)
	 */
	public java.util.Map<String, java.util.List<PlaceSchedule>>
		getFollowingWeekSchedules(
			java.util.Date startDate, java.util.Locale locale);

	/**
	 * Retourne une map contennant le jour et une liste de PlaceSchedule de la
	 * semaine en cours
	 */
	public java.util.Map<String, java.util.List<PlaceSchedule>> getHoraire(
		java.util.Date dateJour, java.util.Locale locale);

	/**
	 * Retourne les horaires d'ouverture du jour passé en paramètre jusqu'à
	 * "date" + "daysCount"
	 */
	public java.util.Map<String, java.util.List<PlaceSchedule>>
		getSubPlaceSchedule(
			java.util.Date date, int daysCount, java.util.Locale locale);

	/**
	 * Retourne les horaires d'ouverture du jour voulu
	 */
	public java.util.List<PlaceSchedule> getSubPlaceSchedule(
		java.util.GregorianCalendar jourSemaine, java.util.Locale locale);

	/**
	 * Retourne les PlaceSchedule des exceptions d'ouverture à partir du lundi
	 * de la semaine en cours
	 *
	 * @param surPeriode
	 (false = horaires d'une journée uniquement , true = horaires
	 sur une semaine)
	 */
	public java.util.List<PlaceSchedule> getSubPlaceScheduleException(
		java.util.GregorianCalendar premierJour, Boolean surPeriode,
		java.util.Locale locale);

	/**
	 * Retourne les PlaceSchedule des exceptions d'ouverture à partir du lundi
	 * de la semaine en cours, jusqu'à dans 2 mois (pour freemarker)
	 */
	public java.util.List<PlaceSchedule> getSubPlaceScheduleExceptionFreeMarker(
		java.util.Date dateDeb, Boolean surPeriode, java.util.Locale locale);

}