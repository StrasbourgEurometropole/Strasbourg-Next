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
 * This class is a wrapper for {@link Period}.
 * </p>
 *
 * @author Angelique Zunino Champougny
 * @see Period
 * @generated
 */
public class PeriodWrapper
	extends BaseModelWrapper<Period> implements ModelWrapper<Period>, Period {

	public PeriodWrapper(Period period) {
		super(period);
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
	public Period cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Retourne les Slots de la période pour un lieu
	 */
	@Override
	public java.util.List<Slot> getAllSlots() {
		return model.getAllSlots();
	}

	/**
	 * Returns the always open of this period.
	 *
	 * @return the always open of this period
	 */
	@Override
	public Boolean getAlwaysOpen() {
		return model.getAlwaysOpen();
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
	 * Returns the default period of this period.
	 *
	 * @return the default period of this period
	 */
	@Override
	public Boolean getDefaultPeriod() {
		return model.getDefaultPeriod();
	}

	@Override
	public String getDisplay(java.util.Locale locale) {
		return model.getDisplay(locale);
	}

	/**
	 * Returns the end date of this period.
	 *
	 * @return the end date of this period
	 */
	@Override
	public Date getEndDate() {
		return model.getEndDate();
	}

	/**
	 * Returns the name of this period.
	 *
	 * @return the name of this period
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the localized name of this period in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized name of this period
	 */
	@Override
	public String getName(java.util.Locale locale) {
		return model.getName(locale);
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
		return model.getName(locale, useDefault);
	}

	/**
	 * Returns the localized name of this period in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized name of this period
	 */
	@Override
	public String getName(String languageId) {
		return model.getName(languageId);
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
	 * Returns a map of the locales and localized names of this period.
	 *
	 * @return the locales and localized names of this period
	 */
	@Override
	public Map<java.util.Locale, String> getNameMap() {
		return model.getNameMap();
	}

	/**
	 * Returns the period ID of this period.
	 *
	 * @return the period ID of this period
	 */
	@Override
	public long getPeriodId() {
		return model.getPeriodId();
	}

	/**
	 * Returns the place ID of this period.
	 *
	 * @return the place ID of this period
	 */
	@Override
	public long getPlaceId() {
		return model.getPlaceId();
	}

	/**
	 * Returns the primary key of this period.
	 *
	 * @return the primary key of this period
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the rt green threshold of this period.
	 *
	 * @return the rt green threshold of this period
	 */
	@Override
	public long getRTGreenThreshold() {
		return model.getRTGreenThreshold();
	}

	/**
	 * Returns the rt max threshold of this period.
	 *
	 * @return the rt max threshold of this period
	 */
	@Override
	public long getRTMaxThreshold() {
		return model.getRTMaxThreshold();
	}

	/**
	 * Returns the rt orange threshold of this period.
	 *
	 * @return the rt orange threshold of this period
	 */
	@Override
	public long getRTOrangeThreshold() {
		return model.getRTOrangeThreshold();
	}

	/**
	 * Returns the rt red threshold of this period.
	 *
	 * @return the rt red threshold of this period
	 */
	@Override
	public long getRTRedThreshold() {
		return model.getRTRedThreshold();
	}

	/**
	 * Retourne les Slots de la période pour un lieu
	 */
	@Override
	public java.util.List<Slot> getSlots() {
		return model.getSlots();
	}

	/**
	 * Retourne les Slots de la période pour un sous-lieu
	 */
	@Override
	public java.util.List<Slot> getSlots(long subPlaceId) {
		return model.getSlots(subPlaceId);
	}

	/**
	 * Returns the start date of this period.
	 *
	 * @return the start date of this period
	 */
	@Override
	public Date getStartDate() {
		return model.getStartDate();
	}

	/**
	 * Returns the uuid of this period.
	 *
	 * @return the uuid of this period
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Retourne la liste des horaires par jour (0 = lundi, 1 = mardi, etc.)
	 */
	@Override
	public java.util.List<PlaceSchedule> getWeekSchedule() {
		return model.getWeekSchedule();
	}

	/**
	 * Retourne la liste des horaires par jour pour le sous lieu (0 = lundi, 1 = mardi, etc.)
	 */
	@Override
	public java.util.List<PlaceSchedule> getWeekSchedule(long subPlaceId) {
		return model.getWeekSchedule(subPlaceId);
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
	 * Sets the always open of this period.
	 *
	 * @param alwaysOpen the always open of this period
	 */
	@Override
	public void setAlwaysOpen(Boolean alwaysOpen) {
		model.setAlwaysOpen(alwaysOpen);
	}

	/**
	 * Sets the default period of this period.
	 *
	 * @param defaultPeriod the default period of this period
	 */
	@Override
	public void setDefaultPeriod(Boolean defaultPeriod) {
		model.setDefaultPeriod(defaultPeriod);
	}

	/**
	 * Sets the end date of this period.
	 *
	 * @param endDate the end date of this period
	 */
	@Override
	public void setEndDate(Date endDate) {
		model.setEndDate(endDate);
	}

	/**
	 * Sets the name of this period.
	 *
	 * @param name the name of this period
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the localized name of this period in the language.
	 *
	 * @param name the localized name of this period
	 * @param locale the locale of the language
	 */
	@Override
	public void setName(String name, java.util.Locale locale) {
		model.setName(name, locale);
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

		model.setName(name, locale, defaultLocale);
	}

	@Override
	public void setNameCurrentLanguageId(String languageId) {
		model.setNameCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized names of this period from the map of locales and localized names.
	 *
	 * @param nameMap the locales and localized names of this period
	 */
	@Override
	public void setNameMap(Map<java.util.Locale, String> nameMap) {
		model.setNameMap(nameMap);
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

		model.setNameMap(nameMap, defaultLocale);
	}

	/**
	 * Sets the period ID of this period.
	 *
	 * @param periodId the period ID of this period
	 */
	@Override
	public void setPeriodId(long periodId) {
		model.setPeriodId(periodId);
	}

	/**
	 * Sets the place ID of this period.
	 *
	 * @param placeId the place ID of this period
	 */
	@Override
	public void setPlaceId(long placeId) {
		model.setPlaceId(placeId);
	}

	/**
	 * Sets the primary key of this period.
	 *
	 * @param primaryKey the primary key of this period
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the rt green threshold of this period.
	 *
	 * @param RTGreenThreshold the rt green threshold of this period
	 */
	@Override
	public void setRTGreenThreshold(long RTGreenThreshold) {
		model.setRTGreenThreshold(RTGreenThreshold);
	}

	/**
	 * Sets the rt max threshold of this period.
	 *
	 * @param RTMaxThreshold the rt max threshold of this period
	 */
	@Override
	public void setRTMaxThreshold(long RTMaxThreshold) {
		model.setRTMaxThreshold(RTMaxThreshold);
	}

	/**
	 * Sets the rt orange threshold of this period.
	 *
	 * @param RTOrangeThreshold the rt orange threshold of this period
	 */
	@Override
	public void setRTOrangeThreshold(long RTOrangeThreshold) {
		model.setRTOrangeThreshold(RTOrangeThreshold);
	}

	/**
	 * Sets the rt red threshold of this period.
	 *
	 * @param RTRedThreshold the rt red threshold of this period
	 */
	@Override
	public void setRTRedThreshold(long RTRedThreshold) {
		model.setRTRedThreshold(RTRedThreshold);
	}

	/**
	 * Sets the start date of this period.
	 *
	 * @param startDate the start date of this period
	 */
	@Override
	public void setStartDate(Date startDate) {
		model.setStartDate(startDate);
	}

	/**
	 * Sets the uuid of this period.
	 *
	 * @param uuid the uuid of this period
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Retourne la version JSON de la période
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONObject toJSON() {
		return model.toJSON();
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected PeriodWrapper wrap(Period period) {
		return new PeriodWrapper(period);
	}

}