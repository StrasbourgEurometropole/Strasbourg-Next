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

package eu.strasbourg.service.place.model;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link SubPlace}.
 * </p>
 *
 * @author Angelique Zunino Champougny
 * @see SubPlace
 * @generated
 */
public class SubPlaceWrapper implements ModelWrapper<SubPlace>, SubPlace {

	public SubPlaceWrapper(SubPlace subPlace) {
		_subPlace = subPlace;
	}

	@Override
	public Class<?> getModelClass() {
		return SubPlace.class;
	}

	@Override
	public String getModelClassName() {
		return SubPlace.class.getName();
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
	public Object clone() {
		return new SubPlaceWrapper((SubPlace)_subPlace.clone());
	}

	@Override
	public int compareTo(eu.strasbourg.service.place.model.SubPlace subPlace) {
		return _subPlace.compareTo(subPlace);
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return _subPlace.getAvailableLanguageIds();
	}

	@Override
	public String getDefaultLanguageId() {
		return _subPlace.getDefaultLanguageId();
	}

	/**
	 * Retourne la période par défaut
	 */
	@Override
	public eu.strasbourg.service.place.model.Period getDefaultPeriod() {
		return _subPlace.getDefaultPeriod();
	}

	/**
	 * Returns the description of this sub place.
	 *
	 * @return the description of this sub place
	 */
	@Override
	public String getDescription() {
		return _subPlace.getDescription();
	}

	/**
	 * Returns the localized description of this sub place in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description of this sub place
	 */
	@Override
	public String getDescription(java.util.Locale locale) {
		return _subPlace.getDescription(locale);
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
		return _subPlace.getDescription(locale, useDefault);
	}

	/**
	 * Returns the localized description of this sub place in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description of this sub place
	 */
	@Override
	public String getDescription(String languageId) {
		return _subPlace.getDescription(languageId);
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
		return _subPlace.getDescription(languageId, useDefault);
	}

	@Override
	public String getDescriptionCurrentLanguageId() {
		return _subPlace.getDescriptionCurrentLanguageId();
	}

	@Override
	public String getDescriptionCurrentValue() {
		return _subPlace.getDescriptionCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized descriptions of this sub place.
	 *
	 * @return the locales and localized descriptions of this sub place
	 */
	@Override
	public Map<java.util.Locale, String> getDescriptionMap() {
		return _subPlace.getDescriptionMap();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _subPlace.getExpandoBridge();
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

		return _subPlace.getFollowingWeekSchedules(startDate, locale);
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

		return _subPlace.getHoraire(dateJour, locale);
	}

	/**
	 * Returns the name of this sub place.
	 *
	 * @return the name of this sub place
	 */
	@Override
	public String getName() {
		return _subPlace.getName();
	}

	/**
	 * Returns the localized name of this sub place in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized name of this sub place
	 */
	@Override
	public String getName(java.util.Locale locale) {
		return _subPlace.getName(locale);
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
		return _subPlace.getName(locale, useDefault);
	}

	/**
	 * Returns the localized name of this sub place in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized name of this sub place
	 */
	@Override
	public String getName(String languageId) {
		return _subPlace.getName(languageId);
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
		return _subPlace.getName(languageId, useDefault);
	}

	@Override
	public String getNameCurrentLanguageId() {
		return _subPlace.getNameCurrentLanguageId();
	}

	@Override
	public String getNameCurrentValue() {
		return _subPlace.getNameCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized names of this sub place.
	 *
	 * @return the locales and localized names of this sub place
	 */
	@Override
	public Map<java.util.Locale, String> getNameMap() {
		return _subPlace.getNameMap();
	}

	/**
	 * Retourne les périodes qui ne sont pas par défaut
	 */
	@Override
	public java.util.List<eu.strasbourg.service.place.model.Period>
		getNonDefaultPeriod() {

		return _subPlace.getNonDefaultPeriod();
	}

	/**
	 * Retourne le lieu parent du sous-lieu
	 */
	@Override
	public eu.strasbourg.service.place.model.Place getParentPlace() {
		return _subPlace.getParentPlace();
	}

	/**
	 * Retourne les Periods du lieu auquel appartient le sous-lieu
	 */
	@Override
	public java.util.List<eu.strasbourg.service.place.model.Period>
		getPeriods() {

		return _subPlace.getPeriods();
	}

	/**
	 * Retourne le lieu parent du sous-lieu
	 */
	@Override
	public eu.strasbourg.service.place.model.Place getPlaceByPlaceId(
		long placeId) {

		return _subPlace.getPlaceByPlaceId(placeId);
	}

	/**
	 * Returns the place ID of this sub place.
	 *
	 * @return the place ID of this sub place
	 */
	@Override
	public long getPlaceId() {
		return _subPlace.getPlaceId();
	}

	/**
	 * Returns the primary key of this sub place.
	 *
	 * @return the primary key of this sub place
	 */
	@Override
	public long getPrimaryKey() {
		return _subPlace.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _subPlace.getPrimaryKeyObj();
	}

	/**
	 * Retourne les PublicHolidays
	 */
	@Override
	public java.util.List<eu.strasbourg.service.place.model.PublicHoliday>
		getPublicHolidays() {

		return _subPlace.getPublicHolidays();
	}

	/**
	 * Retourne les ScheduleExceptions du sous-lieu
	 */
	@Override
	public java.util.List<eu.strasbourg.service.place.model.ScheduleException>
		getScheduleExceptions() {

		return _subPlace.getScheduleExceptions();
	}

	/**
	 * Returns the status of this sub place.
	 *
	 * @return the status of this sub place
	 */
	@Override
	public int getStatus() {
		return _subPlace.getStatus();
	}

	/**
	 * Returns the status by user ID of this sub place.
	 *
	 * @return the status by user ID of this sub place
	 */
	@Override
	public long getStatusByUserId() {
		return _subPlace.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this sub place.
	 *
	 * @return the status by user name of this sub place
	 */
	@Override
	public String getStatusByUserName() {
		return _subPlace.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this sub place.
	 *
	 * @return the status by user uuid of this sub place
	 */
	@Override
	public String getStatusByUserUuid() {
		return _subPlace.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this sub place.
	 *
	 * @return the status date of this sub place
	 */
	@Override
	public Date getStatusDate() {
		return _subPlace.getStatusDate();
	}

	/**
	 * Returns the sub place ID of this sub place.
	 *
	 * @return the sub place ID of this sub place
	 */
	@Override
	public long getSubPlaceId() {
		return _subPlace.getSubPlaceId();
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

		return _subPlace.getSubPlaceSchedule(date, daysCount, locale);
	}

	/**
	 * Retourne les horaires d'ouverture du jour voulu
	 */
	@Override
	public java.util.List<eu.strasbourg.service.place.model.PlaceSchedule>
		getSubPlaceSchedule(
			java.util.GregorianCalendar jourSemaine, java.util.Locale locale) {

		return _subPlace.getSubPlaceSchedule(jourSemaine, locale);
	}

	/**
	 * Retourne les PlaceSchedule des exceptions d'ouverture à partir du lundi
	 * de la semaine en cours
	 *
	 * @param surPériode
	 (false = horaires d'une journée uniquement , true = horaires
	 sur une semaine)
	 */
	@Override
	public java.util.List<eu.strasbourg.service.place.model.PlaceSchedule>
		getSubPlaceScheduleException(
			java.util.GregorianCalendar premierJour, Boolean surPeriode,
			java.util.Locale locale) {

		return _subPlace.getSubPlaceScheduleException(
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

		return _subPlace.getSubPlaceScheduleExceptionFreeMarker(
			dateDeb, surPeriode, locale);
	}

	/**
	 * Returns the uuid of this sub place.
	 *
	 * @return the uuid of this sub place
	 */
	@Override
	public String getUuid() {
		return _subPlace.getUuid();
	}

	@Override
	public int hashCode() {
		return _subPlace.hashCode();
	}

	/**
	 * Returns <code>true</code> if this sub place is approved.
	 *
	 * @return <code>true</code> if this sub place is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return _subPlace.isApproved();
	}

	@Override
	public boolean isCachedModel() {
		return _subPlace.isCachedModel();
	}

	/**
	 * Returns <code>true</code> if this sub place is denied.
	 *
	 * @return <code>true</code> if this sub place is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return _subPlace.isDenied();
	}

	/**
	 * Returns <code>true</code> if this sub place is a draft.
	 *
	 * @return <code>true</code> if this sub place is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return _subPlace.isDraft();
	}

	@Override
	public boolean isEscapedModel() {
		return _subPlace.isEscapedModel();
	}

	/**
	 * Returns <code>true</code> if this sub place is expired.
	 *
	 * @return <code>true</code> if this sub place is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return _subPlace.isExpired();
	}

	/**
	 * Returns <code>true</code> if this sub place is inactive.
	 *
	 * @return <code>true</code> if this sub place is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return _subPlace.isInactive();
	}

	/**
	 * Returns <code>true</code> if this sub place is incomplete.
	 *
	 * @return <code>true</code> if this sub place is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return _subPlace.isIncomplete();
	}

	@Override
	public boolean isNew() {
		return _subPlace.isNew();
	}

	/**
	 * Returns <code>true</code> if this sub place is pending.
	 *
	 * @return <code>true</code> if this sub place is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return _subPlace.isPending();
	}

	/**
	 * Returns <code>true</code> if this sub place is scheduled.
	 *
	 * @return <code>true</code> if this sub place is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return _subPlace.isScheduled();
	}

	@Override
	public void persist() {
		_subPlace.persist();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.kernel.exception.LocaleException {

		_subPlace.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
			java.util.Locale defaultImportLocale)
		throws com.liferay.portal.kernel.exception.LocaleException {

		_subPlace.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_subPlace.setCachedModel(cachedModel);
	}

	/**
	 * Sets the description of this sub place.
	 *
	 * @param description the description of this sub place
	 */
	@Override
	public void setDescription(String description) {
		_subPlace.setDescription(description);
	}

	/**
	 * Sets the localized description of this sub place in the language.
	 *
	 * @param description the localized description of this sub place
	 * @param locale the locale of the language
	 */
	@Override
	public void setDescription(String description, java.util.Locale locale) {
		_subPlace.setDescription(description, locale);
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

		_subPlace.setDescription(description, locale, defaultLocale);
	}

	@Override
	public void setDescriptionCurrentLanguageId(String languageId) {
		_subPlace.setDescriptionCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized descriptions of this sub place from the map of locales and localized descriptions.
	 *
	 * @param descriptionMap the locales and localized descriptions of this sub place
	 */
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, String> descriptionMap) {

		_subPlace.setDescriptionMap(descriptionMap);
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

		_subPlace.setDescriptionMap(descriptionMap, defaultLocale);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_subPlace.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_subPlace.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_subPlace.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the name of this sub place.
	 *
	 * @param name the name of this sub place
	 */
	@Override
	public void setName(String name) {
		_subPlace.setName(name);
	}

	/**
	 * Sets the localized name of this sub place in the language.
	 *
	 * @param name the localized name of this sub place
	 * @param locale the locale of the language
	 */
	@Override
	public void setName(String name, java.util.Locale locale) {
		_subPlace.setName(name, locale);
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

		_subPlace.setName(name, locale, defaultLocale);
	}

	@Override
	public void setNameCurrentLanguageId(String languageId) {
		_subPlace.setNameCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized names of this sub place from the map of locales and localized names.
	 *
	 * @param nameMap the locales and localized names of this sub place
	 */
	@Override
	public void setNameMap(Map<java.util.Locale, String> nameMap) {
		_subPlace.setNameMap(nameMap);
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

		_subPlace.setNameMap(nameMap, defaultLocale);
	}

	@Override
	public void setNew(boolean n) {
		_subPlace.setNew(n);
	}

	/**
	 * Sets the place ID of this sub place.
	 *
	 * @param placeId the place ID of this sub place
	 */
	@Override
	public void setPlaceId(long placeId) {
		_subPlace.setPlaceId(placeId);
	}

	/**
	 * Sets the primary key of this sub place.
	 *
	 * @param primaryKey the primary key of this sub place
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_subPlace.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_subPlace.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the status of this sub place.
	 *
	 * @param status the status of this sub place
	 */
	@Override
	public void setStatus(int status) {
		_subPlace.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this sub place.
	 *
	 * @param statusByUserId the status by user ID of this sub place
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_subPlace.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this sub place.
	 *
	 * @param statusByUserName the status by user name of this sub place
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		_subPlace.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this sub place.
	 *
	 * @param statusByUserUuid the status by user uuid of this sub place
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		_subPlace.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this sub place.
	 *
	 * @param statusDate the status date of this sub place
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		_subPlace.setStatusDate(statusDate);
	}

	/**
	 * Sets the sub place ID of this sub place.
	 *
	 * @param subPlaceId the sub place ID of this sub place
	 */
	@Override
	public void setSubPlaceId(long subPlaceId) {
		_subPlace.setSubPlaceId(subPlaceId);
	}

	/**
	 * Sets the uuid of this sub place.
	 *
	 * @param uuid the uuid of this sub place
	 */
	@Override
	public void setUuid(String uuid) {
		_subPlace.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<eu.strasbourg.service.place.model.SubPlace> toCacheModel() {

		return _subPlace.toCacheModel();
	}

	@Override
	public eu.strasbourg.service.place.model.SubPlace toEscapedModel() {
		return new SubPlaceWrapper(_subPlace.toEscapedModel());
	}

	@Override
	public String toString() {
		return _subPlace.toString();
	}

	@Override
	public eu.strasbourg.service.place.model.SubPlace toUnescapedModel() {
		return new SubPlaceWrapper(_subPlace.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _subPlace.toXmlString();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SubPlaceWrapper)) {
			return false;
		}

		SubPlaceWrapper subPlaceWrapper = (SubPlaceWrapper)object;

		if (Objects.equals(_subPlace, subPlaceWrapper._subPlace)) {
			return true;
		}

		return false;
	}

	@Override
	public SubPlace getWrappedModel() {
		return _subPlace;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _subPlace.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _subPlace.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_subPlace.resetOriginalValues();
	}

	private final SubPlace _subPlace;

}