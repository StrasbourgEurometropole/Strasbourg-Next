/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.place.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SubPlace}.
 * </p>
 *
 * @author Angelique Zunino Champougny
 * @see SubPlace
 * @generated
 */
public class SubPlaceWrapper
	extends BaseModelWrapper<SubPlace>
	implements ModelWrapper<SubPlace>, SubPlace {

	public SubPlaceWrapper(SubPlace subPlace) {
		super(subPlace);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("subPlaceId", getSubPlaceId());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("placeId", getPlaceId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long subPlaceId = (Long)attributes.get("subPlaceId");

		if (subPlaceId != null) {
			setSubPlaceId(subPlaceId);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long placeId = (Long)attributes.get("placeId");

		if (placeId != null) {
			setPlaceId(placeId);
		}
	}

	@Override
	public SubPlace cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	@Override
	public String getDefaultLanguageId() {
		return model.getDefaultLanguageId();
	}

	/**
	 * Retourne la période par défaut
	 */
	@Override
	public eu.strasbourg.service.place.model.Period getDefaultPeriod() {
		return model.getDefaultPeriod();
	}

	/**
	 * Returns the description of this sub place.
	 *
	 * @return the description of this sub place
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the localized description of this sub place in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description of this sub place
	 */
	@Override
	public String getDescription(java.util.Locale locale) {
		return model.getDescription(locale);
	}

	/**
	 * Returns the localized description of this sub place in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this sub place. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getDescription(java.util.Locale locale, boolean useDefault) {
		return model.getDescription(locale, useDefault);
	}

	/**
	 * Returns the localized description of this sub place in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description of this sub place
	 */
	@Override
	public String getDescription(String languageId) {
		return model.getDescription(languageId);
	}

	/**
	 * Returns the localized description of this sub place in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this sub place
	 */
	@Override
	public String getDescription(String languageId, boolean useDefault) {
		return model.getDescription(languageId, useDefault);
	}

	@Override
	public String getDescriptionCurrentLanguageId() {
		return model.getDescriptionCurrentLanguageId();
	}

	@Override
	public String getDescriptionCurrentValue() {
		return model.getDescriptionCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized descriptions of this sub place.
	 *
	 * @return the locales and localized descriptions of this sub place
	 */
	@Override
	public Map<java.util.Locale, String> getDescriptionMap() {
		return model.getDescriptionMap();
	}

	/**
	 * Retourne une map contennant les horaires de chaque jour des 7 jours
	 * suivants "startDate" (inclus)
	 */
	@Override
	public Map
		<String,
		 java.util.List<eu.strasbourg.service.place.model.PlaceSchedule>>
			getFollowingWeekSchedules(Date startDate, java.util.Locale locale) {

		return model.getFollowingWeekSchedules(startDate, locale);
	}

	/**
	 * Retourne une map contennant le jour et une liste de PlaceSchedule de la
	 * semaine en cours
	 */
	@Override
	public Map
		<String,
		 java.util.List<eu.strasbourg.service.place.model.PlaceSchedule>>
			getHoraire(Date dateJour, java.util.Locale locale) {

		return model.getHoraire(dateJour, locale);
	}

	/**
	 * Returns the name of this sub place.
	 *
	 * @return the name of this sub place
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the localized name of this sub place in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized name of this sub place
	 */
	@Override
	public String getName(java.util.Locale locale) {
		return model.getName(locale);
	}

	/**
	 * Returns the localized name of this sub place in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this sub place. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getName(java.util.Locale locale, boolean useDefault) {
		return model.getName(locale, useDefault);
	}

	/**
	 * Returns the localized name of this sub place in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized name of this sub place
	 */
	@Override
	public String getName(String languageId) {
		return model.getName(languageId);
	}

	/**
	 * Returns the localized name of this sub place in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this sub place
	 */
	@Override
	public String getName(String languageId, boolean useDefault) {
		return model.getName(languageId, useDefault);
	}

	@Override
	public String getNameCurrentLanguageId() {
		return model.getNameCurrentLanguageId();
	}

	@Override
	public String getNameCurrentValue() {
		return model.getNameCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized names of this sub place.
	 *
	 * @return the locales and localized names of this sub place
	 */
	@Override
	public Map<java.util.Locale, String> getNameMap() {
		return model.getNameMap();
	}

	/**
	 * Retourne les périodes qui ne sont pas par défaut
	 */
	@Override
	public java.util.List<eu.strasbourg.service.place.model.Period>
		getNonDefaultPeriod() {

		return model.getNonDefaultPeriod();
	}

	/**
	 * Retourne le lieu parent du sous-lieu
	 */
	@Override
	public eu.strasbourg.service.place.model.Place getParentPlace() {
		return model.getParentPlace();
	}

	/**
	 * Retourne les Periods du lieu auquel appartient le sous-lieu
	 */
	@Override
	public java.util.List<eu.strasbourg.service.place.model.Period>
		getPeriods() {

		return model.getPeriods();
	}

	/**
	 * Retourne le lieu parent du sous-lieu
	 */
	@Override
	public eu.strasbourg.service.place.model.Place getPlaceByPlaceId(
		long placeId) {

		return model.getPlaceByPlaceId(placeId);
	}

	/**
	 * Returns the place ID of this sub place.
	 *
	 * @return the place ID of this sub place
	 */
	@Override
	public long getPlaceId() {
		return model.getPlaceId();
	}

	/**
	 * Returns the primary key of this sub place.
	 *
	 * @return the primary key of this sub place
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Retourne les PublicHolidays
	 */
	@Override
	public java.util.List<eu.strasbourg.service.place.model.PublicHoliday>
		getPublicHolidays() {

		return model.getPublicHolidays();
	}

	/**
	 * Retourne les ScheduleExceptions du sous-lieu
	 */
	@Override
	public java.util.List<eu.strasbourg.service.place.model.ScheduleException>
		getScheduleExceptions() {

		return model.getScheduleExceptions();
	}

	/**
	 * Returns the status of this sub place.
	 *
	 * @return the status of this sub place
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this sub place.
	 *
	 * @return the status by user ID of this sub place
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this sub place.
	 *
	 * @return the status by user name of this sub place
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this sub place.
	 *
	 * @return the status by user uuid of this sub place
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this sub place.
	 *
	 * @return the status date of this sub place
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the sub place ID of this sub place.
	 *
	 * @return the sub place ID of this sub place
	 */
	@Override
	public long getSubPlaceId() {
		return model.getSubPlaceId();
	}

	/**
	 * Retourne les horaires d'ouverture du jour passé en paramètre jusqu'à
	 * "date" + "daysCount"
	 */
	@Override
	public Map
		<String,
		 java.util.List<eu.strasbourg.service.place.model.PlaceSchedule>>
			getSubPlaceSchedule(
				Date date, int daysCount, java.util.Locale locale) {

		return model.getSubPlaceSchedule(date, daysCount, locale);
	}

	/**
	 * Retourne les horaires d'ouverture du jour voulu
	 */
	@Override
	public java.util.List<eu.strasbourg.service.place.model.PlaceSchedule>
		getSubPlaceSchedule(
			java.util.GregorianCalendar jourSemaine, java.util.Locale locale) {

		return model.getSubPlaceSchedule(jourSemaine, locale);
	}

	/**
	 * Retourne les PlaceSchedule des exceptions d'ouverture à partir du lundi
	 * de la semaine en cours
	 *
	 * @param surPeriode
	 (false = horaires d'une journée uniquement , true = horaires
	 sur une semaine)
	 */
	@Override
	public java.util.List<eu.strasbourg.service.place.model.PlaceSchedule>
		getSubPlaceScheduleException(
			java.util.GregorianCalendar premierJour, Boolean surPeriode,
			java.util.Locale locale) {

		return model.getSubPlaceScheduleException(
			premierJour, surPeriode, locale);
	}

	/**
	 * Retourne les PlaceSchedule des exceptions d'ouverture à partir du lundi
	 * de la semaine en cours, jusqu'à dans 2 mois (pour freemarker)
	 */
	@Override
	public java.util.List<eu.strasbourg.service.place.model.PlaceSchedule>
		getSubPlaceScheduleExceptionFreeMarker(
			Date dateDeb, Boolean surPeriode, java.util.Locale locale) {

		return model.getSubPlaceScheduleExceptionFreeMarker(
			dateDeb, surPeriode, locale);
	}

	/**
	 * Returns the uuid of this sub place.
	 *
	 * @return the uuid of this sub place
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this sub place is approved.
	 *
	 * @return <code>true</code> if this sub place is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this sub place is denied.
	 *
	 * @return <code>true</code> if this sub place is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this sub place is a draft.
	 *
	 * @return <code>true</code> if this sub place is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this sub place is expired.
	 *
	 * @return <code>true</code> if this sub place is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this sub place is inactive.
	 *
	 * @return <code>true</code> if this sub place is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this sub place is incomplete.
	 *
	 * @return <code>true</code> if this sub place is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this sub place is pending.
	 *
	 * @return <code>true</code> if this sub place is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this sub place is scheduled.
	 *
	 * @return <code>true</code> if this sub place is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
	}

	@Override
	public void persist() {
		model.persist();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.kernel.exception.LocaleException {

		model.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
			java.util.Locale defaultImportLocale)
		throws com.liferay.portal.kernel.exception.LocaleException {

		model.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	/**
	 * Sets the description of this sub place.
	 *
	 * @param description the description of this sub place
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the localized description of this sub place in the language.
	 *
	 * @param description the localized description of this sub place
	 * @param locale the locale of the language
	 */
	@Override
	public void setDescription(String description, java.util.Locale locale) {
		model.setDescription(description, locale);
	}

	/**
	 * Sets the localized description of this sub place in the language, and sets the default locale.
	 *
	 * @param description the localized description of this sub place
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDescription(
		String description, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setDescription(description, locale, defaultLocale);
	}

	@Override
	public void setDescriptionCurrentLanguageId(String languageId) {
		model.setDescriptionCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized descriptions of this sub place from the map of locales and localized descriptions.
	 *
	 * @param descriptionMap the locales and localized descriptions of this sub place
	 */
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, String> descriptionMap) {

		model.setDescriptionMap(descriptionMap);
	}

	/**
	 * Sets the localized descriptions of this sub place from the map of locales and localized descriptions, and sets the default locale.
	 *
	 * @param descriptionMap the locales and localized descriptions of this sub place
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, String> descriptionMap,
		java.util.Locale defaultLocale) {

		model.setDescriptionMap(descriptionMap, defaultLocale);
	}

	/**
	 * Sets the name of this sub place.
	 *
	 * @param name the name of this sub place
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the localized name of this sub place in the language.
	 *
	 * @param name the localized name of this sub place
	 * @param locale the locale of the language
	 */
	@Override
	public void setName(String name, java.util.Locale locale) {
		model.setName(name, locale);
	}

	/**
	 * Sets the localized name of this sub place in the language, and sets the default locale.
	 *
	 * @param name the localized name of this sub place
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setName(
		String name, java.util.Locale locale, java.util.Locale defaultLocale) {

		model.setName(name, locale, defaultLocale);
	}

	@Override
	public void setNameCurrentLanguageId(String languageId) {
		model.setNameCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized names of this sub place from the map of locales and localized names.
	 *
	 * @param nameMap the locales and localized names of this sub place
	 */
	@Override
	public void setNameMap(Map<java.util.Locale, String> nameMap) {
		model.setNameMap(nameMap);
	}

	/**
	 * Sets the localized names of this sub place from the map of locales and localized names, and sets the default locale.
	 *
	 * @param nameMap the locales and localized names of this sub place
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setNameMap(
		Map<java.util.Locale, String> nameMap, java.util.Locale defaultLocale) {

		model.setNameMap(nameMap, defaultLocale);
	}

	/**
	 * Sets the place ID of this sub place.
	 *
	 * @param placeId the place ID of this sub place
	 */
	@Override
	public void setPlaceId(long placeId) {
		model.setPlaceId(placeId);
	}

	/**
	 * Sets the primary key of this sub place.
	 *
	 * @param primaryKey the primary key of this sub place
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this sub place.
	 *
	 * @param status the status of this sub place
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this sub place.
	 *
	 * @param statusByUserId the status by user ID of this sub place
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this sub place.
	 *
	 * @param statusByUserName the status by user name of this sub place
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this sub place.
	 *
	 * @param statusByUserUuid the status by user uuid of this sub place
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this sub place.
	 *
	 * @param statusDate the status date of this sub place
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the sub place ID of this sub place.
	 *
	 * @param subPlaceId the sub place ID of this sub place
	 */
	@Override
	public void setSubPlaceId(long subPlaceId) {
		model.setSubPlaceId(subPlaceId);
	}

	/**
	 * Sets the uuid of this sub place.
	 *
	 * @param uuid the uuid of this sub place
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected SubPlaceWrapper wrap(SubPlace subPlace) {
		return new SubPlaceWrapper(subPlace);
	}

}