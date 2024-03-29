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
 * This class is a wrapper for {@link Period}.
 * </p>
 *
 * @author Angelique Zunino Champougny
 * @see Period
 * @generated
 */
public class PeriodWrapper implements ModelWrapper<Period>, Period {

	public PeriodWrapper(Period period) {
		_period = period;
	}

	@Override
	public Class<?> getModelClass() {
		return Period.class;
	}

	@Override
	public String getModelClassName() {
		return Period.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("periodId", getPeriodId());
		attributes.put("name", getName());
		attributes.put("defaultPeriod", getDefaultPeriod());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("alwaysOpen", getAlwaysOpen());
		attributes.put("RTGreenThreshold", getRTGreenThreshold());
		attributes.put("RTOrangeThreshold", getRTOrangeThreshold());
		attributes.put("RTRedThreshold", getRTRedThreshold());
		attributes.put("RTMaxThreshold", getRTMaxThreshold());
		attributes.put("placeId", getPlaceId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long periodId = (Long)attributes.get("periodId");

		if (periodId != null) {
			setPeriodId(periodId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Boolean defaultPeriod = (Boolean)attributes.get("defaultPeriod");

		if (defaultPeriod != null) {
			setDefaultPeriod(defaultPeriod);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Boolean alwaysOpen = (Boolean)attributes.get("alwaysOpen");

		if (alwaysOpen != null) {
			setAlwaysOpen(alwaysOpen);
		}

		Long RTGreenThreshold = (Long)attributes.get("RTGreenThreshold");

		if (RTGreenThreshold != null) {
			setRTGreenThreshold(RTGreenThreshold);
		}

		Long RTOrangeThreshold = (Long)attributes.get("RTOrangeThreshold");

		if (RTOrangeThreshold != null) {
			setRTOrangeThreshold(RTOrangeThreshold);
		}

		Long RTRedThreshold = (Long)attributes.get("RTRedThreshold");

		if (RTRedThreshold != null) {
			setRTRedThreshold(RTRedThreshold);
		}

		Long RTMaxThreshold = (Long)attributes.get("RTMaxThreshold");

		if (RTMaxThreshold != null) {
			setRTMaxThreshold(RTMaxThreshold);
		}

		Long placeId = (Long)attributes.get("placeId");

		if (placeId != null) {
			setPlaceId(placeId);
		}
	}

	@Override
	public Object clone() {
		return new PeriodWrapper((Period)_period.clone());
	}

	@Override
	public int compareTo(eu.strasbourg.service.place.model.Period period) {
		return _period.compareTo(period);
	}

	/**
	 * Retourne les Slots de la période pour un lieu
	 */
	@Override
	public java.util.List<eu.strasbourg.service.place.model.Slot>
		getAllSlots() {

		return _period.getAllSlots();
	}

	/**
	 * Returns the always open of this period.
	 *
	 * @return the always open of this period
	 */
	@Override
	public Boolean getAlwaysOpen() {
		return _period.getAlwaysOpen();
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return _period.getAvailableLanguageIds();
	}

	@Override
	public String getDefaultLanguageId() {
		return _period.getDefaultLanguageId();
	}

	/**
	 * Returns the default period of this period.
	 *
	 * @return the default period of this period
	 */
	@Override
	public Boolean getDefaultPeriod() {
		return _period.getDefaultPeriod();
	}

	@Override
	public String getDisplay(java.util.Locale locale) {
		return _period.getDisplay(locale);
	}

	/**
	 * Returns the end date of this period.
	 *
	 * @return the end date of this period
	 */
	@Override
	public Date getEndDate() {
		return _period.getEndDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _period.getExpandoBridge();
	}

	/**
	 * Returns the name of this period.
	 *
	 * @return the name of this period
	 */
	@Override
	public String getName() {
		return _period.getName();
	}

	/**
	 * Returns the localized name of this period in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized name of this period
	 */
	@Override
	public String getName(java.util.Locale locale) {
		return _period.getName(locale);
	}

	/**
	 * Returns the localized name of this period in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this period. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getName(java.util.Locale locale, boolean useDefault) {
		return _period.getName(locale, useDefault);
	}

	/**
	 * Returns the localized name of this period in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized name of this period
	 */
	@Override
	public String getName(String languageId) {
		return _period.getName(languageId);
	}

	/**
	 * Returns the localized name of this period in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this period
	 */
	@Override
	public String getName(String languageId, boolean useDefault) {
		return _period.getName(languageId, useDefault);
	}

	@Override
	public String getNameCurrentLanguageId() {
		return _period.getNameCurrentLanguageId();
	}

	@Override
	public String getNameCurrentValue() {
		return _period.getNameCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized names of this period.
	 *
	 * @return the locales and localized names of this period
	 */
	@Override
	public Map<java.util.Locale, String> getNameMap() {
		return _period.getNameMap();
	}

	/**
	 * Returns the period ID of this period.
	 *
	 * @return the period ID of this period
	 */
	@Override
	public long getPeriodId() {
		return _period.getPeriodId();
	}

	/**
	 * Returns the place ID of this period.
	 *
	 * @return the place ID of this period
	 */
	@Override
	public long getPlaceId() {
		return _period.getPlaceId();
	}

	/**
	 * Returns the primary key of this period.
	 *
	 * @return the primary key of this period
	 */
	@Override
	public long getPrimaryKey() {
		return _period.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _period.getPrimaryKeyObj();
	}

	/**
	 * Returns the rt green threshold of this period.
	 *
	 * @return the rt green threshold of this period
	 */
	@Override
	public long getRTGreenThreshold() {
		return _period.getRTGreenThreshold();
	}

	/**
	 * Returns the rt max threshold of this period.
	 *
	 * @return the rt max threshold of this period
	 */
	@Override
	public long getRTMaxThreshold() {
		return _period.getRTMaxThreshold();
	}

	/**
	 * Returns the rt orange threshold of this period.
	 *
	 * @return the rt orange threshold of this period
	 */
	@Override
	public long getRTOrangeThreshold() {
		return _period.getRTOrangeThreshold();
	}

	/**
	 * Returns the rt red threshold of this period.
	 *
	 * @return the rt red threshold of this period
	 */
	@Override
	public long getRTRedThreshold() {
		return _period.getRTRedThreshold();
	}

	/**
	 * Retourne les Slots de la période pour un lieu
	 */
	@Override
	public java.util.List<eu.strasbourg.service.place.model.Slot> getSlots() {
		return _period.getSlots();
	}

	/**
	 * Retourne les Slots de la période pour un sous-lieu
	 */
	@Override
	public java.util.List<eu.strasbourg.service.place.model.Slot> getSlots(
		long subPlaceId) {

		return _period.getSlots(subPlaceId);
	}

	/**
	 * Returns the start date of this period.
	 *
	 * @return the start date of this period
	 */
	@Override
	public Date getStartDate() {
		return _period.getStartDate();
	}

	/**
	 * Returns the uuid of this period.
	 *
	 * @return the uuid of this period
	 */
	@Override
	public String getUuid() {
		return _period.getUuid();
	}

	/**
	 * Retourne la liste des horaires par jour (0 = lundi, 1 = mardi, etc.)
	 */
	@Override
	public java.util.List<eu.strasbourg.service.place.model.PlaceSchedule>
		getWeekSchedule() {

		return _period.getWeekSchedule();
	}

	/**
	 * Retourne la liste des horaires par jour pour le sous lieu (0 = lundi, 1 = mardi, etc.)
	 */
	@Override
	public java.util.List<eu.strasbourg.service.place.model.PlaceSchedule>
		getWeekSchedule(long subPlaceId) {

		return _period.getWeekSchedule(subPlaceId);
	}

	@Override
	public int hashCode() {
		return _period.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _period.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _period.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _period.isNew();
	}

	@Override
	public void persist() {
		_period.persist();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.kernel.exception.LocaleException {

		_period.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
			java.util.Locale defaultImportLocale)
		throws com.liferay.portal.kernel.exception.LocaleException {

		_period.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	/**
	 * Sets the always open of this period.
	 *
	 * @param alwaysOpen the always open of this period
	 */
	@Override
	public void setAlwaysOpen(Boolean alwaysOpen) {
		_period.setAlwaysOpen(alwaysOpen);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_period.setCachedModel(cachedModel);
	}

	/**
	 * Sets the default period of this period.
	 *
	 * @param defaultPeriod the default period of this period
	 */
	@Override
	public void setDefaultPeriod(Boolean defaultPeriod) {
		_period.setDefaultPeriod(defaultPeriod);
	}

	/**
	 * Sets the end date of this period.
	 *
	 * @param endDate the end date of this period
	 */
	@Override
	public void setEndDate(Date endDate) {
		_period.setEndDate(endDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_period.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_period.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_period.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the name of this period.
	 *
	 * @param name the name of this period
	 */
	@Override
	public void setName(String name) {
		_period.setName(name);
	}

	/**
	 * Sets the localized name of this period in the language.
	 *
	 * @param name the localized name of this period
	 * @param locale the locale of the language
	 */
	@Override
	public void setName(String name, java.util.Locale locale) {
		_period.setName(name, locale);
	}

	/**
	 * Sets the localized name of this period in the language, and sets the default locale.
	 *
	 * @param name the localized name of this period
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setName(
		String name, java.util.Locale locale, java.util.Locale defaultLocale) {

		_period.setName(name, locale, defaultLocale);
	}

	@Override
	public void setNameCurrentLanguageId(String languageId) {
		_period.setNameCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized names of this period from the map of locales and localized names.
	 *
	 * @param nameMap the locales and localized names of this period
	 */
	@Override
	public void setNameMap(Map<java.util.Locale, String> nameMap) {
		_period.setNameMap(nameMap);
	}

	/**
	 * Sets the localized names of this period from the map of locales and localized names, and sets the default locale.
	 *
	 * @param nameMap the locales and localized names of this period
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setNameMap(
		Map<java.util.Locale, String> nameMap, java.util.Locale defaultLocale) {

		_period.setNameMap(nameMap, defaultLocale);
	}

	@Override
	public void setNew(boolean n) {
		_period.setNew(n);
	}

	/**
	 * Sets the period ID of this period.
	 *
	 * @param periodId the period ID of this period
	 */
	@Override
	public void setPeriodId(long periodId) {
		_period.setPeriodId(periodId);
	}

	/**
	 * Sets the place ID of this period.
	 *
	 * @param placeId the place ID of this period
	 */
	@Override
	public void setPlaceId(long placeId) {
		_period.setPlaceId(placeId);
	}

	/**
	 * Sets the primary key of this period.
	 *
	 * @param primaryKey the primary key of this period
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_period.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_period.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the rt green threshold of this period.
	 *
	 * @param RTGreenThreshold the rt green threshold of this period
	 */
	@Override
	public void setRTGreenThreshold(long RTGreenThreshold) {
		_period.setRTGreenThreshold(RTGreenThreshold);
	}

	/**
	 * Sets the rt max threshold of this period.
	 *
	 * @param RTMaxThreshold the rt max threshold of this period
	 */
	@Override
	public void setRTMaxThreshold(long RTMaxThreshold) {
		_period.setRTMaxThreshold(RTMaxThreshold);
	}

	/**
	 * Sets the rt orange threshold of this period.
	 *
	 * @param RTOrangeThreshold the rt orange threshold of this period
	 */
	@Override
	public void setRTOrangeThreshold(long RTOrangeThreshold) {
		_period.setRTOrangeThreshold(RTOrangeThreshold);
	}

	/**
	 * Sets the rt red threshold of this period.
	 *
	 * @param RTRedThreshold the rt red threshold of this period
	 */
	@Override
	public void setRTRedThreshold(long RTRedThreshold) {
		_period.setRTRedThreshold(RTRedThreshold);
	}

	/**
	 * Sets the start date of this period.
	 *
	 * @param startDate the start date of this period
	 */
	@Override
	public void setStartDate(Date startDate) {
		_period.setStartDate(startDate);
	}

	/**
	 * Sets the uuid of this period.
	 *
	 * @param uuid the uuid of this period
	 */
	@Override
	public void setUuid(String uuid) {
		_period.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<eu.strasbourg.service.place.model.Period> toCacheModel() {

		return _period.toCacheModel();
	}

	@Override
	public eu.strasbourg.service.place.model.Period toEscapedModel() {
		return new PeriodWrapper(_period.toEscapedModel());
	}

	/**
	 * Retourne la version JSON de la période
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONObject toJSON() {
		return _period.toJSON();
	}

	@Override
	public String toString() {
		return _period.toString();
	}

	@Override
	public eu.strasbourg.service.place.model.Period toUnescapedModel() {
		return new PeriodWrapper(_period.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _period.toXmlString();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PeriodWrapper)) {
			return false;
		}

		PeriodWrapper periodWrapper = (PeriodWrapper)object;

		if (Objects.equals(_period, periodWrapper._period)) {
			return true;
		}

		return false;
	}

	@Override
	public Period getWrappedModel() {
		return _period;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _period.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _period.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_period.resetOriginalValues();
	}

	private final Period _period;

}