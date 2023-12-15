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
 * This class is a wrapper for {@link PublicHoliday}.
 * </p>
 *
 * @author Angelique Zunino Champougny
 * @see PublicHoliday
 * @generated
 */
public class PublicHolidayWrapper
	extends BaseModelWrapper<PublicHoliday>
	implements ModelWrapper<PublicHoliday>, PublicHoliday {

	public PublicHolidayWrapper(PublicHoliday publicHoliday) {
		super(publicHoliday);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("publicHolidayId", getPublicHolidayId());
		attributes.put("name", getName());
		attributes.put("date", getDate());
		attributes.put("recurrent", isRecurrent());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long publicHolidayId = (Long)attributes.get("publicHolidayId");

		if (publicHolidayId != null) {
			setPublicHolidayId(publicHolidayId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Date date = (Date)attributes.get("date");

		if (date != null) {
			setDate(date);
		}

		Boolean recurrent = (Boolean)attributes.get("recurrent");

		if (recurrent != null) {
			setRecurrent(recurrent);
		}
	}

	@Override
	public PublicHoliday cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the date of this public holiday.
	 *
	 * @return the date of this public holiday
	 */
	@Override
	public Date getDate() {
		return model.getDate();
	}

	@Override
	public String getDefaultLanguageId() {
		return model.getDefaultLanguageId();
	}

	/**
	 * Returns the name of this public holiday.
	 *
	 * @return the name of this public holiday
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the localized name of this public holiday in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized name of this public holiday
	 */
	@Override
	public String getName(java.util.Locale locale) {
		return model.getName(locale);
	}

	/**
	 * Returns the localized name of this public holiday in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this public holiday. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getName(java.util.Locale locale, boolean useDefault) {
		return model.getName(locale, useDefault);
	}

	/**
	 * Returns the localized name of this public holiday in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized name of this public holiday
	 */
	@Override
	public String getName(String languageId) {
		return model.getName(languageId);
	}

	/**
	 * Returns the localized name of this public holiday in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this public holiday
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
	 * Returns a map of the locales and localized names of this public holiday.
	 *
	 * @return the locales and localized names of this public holiday
	 */
	@Override
	public Map<java.util.Locale, String> getNameMap() {
		return model.getNameMap();
	}

	/**
	 * Returns the primary key of this public holiday.
	 *
	 * @return the primary key of this public holiday
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the public holiday ID of this public holiday.
	 *
	 * @return the public holiday ID of this public holiday
	 */
	@Override
	public long getPublicHolidayId() {
		return model.getPublicHolidayId();
	}

	/**
	 * Returns the recurrent of this public holiday.
	 *
	 * @return the recurrent of this public holiday
	 */
	@Override
	public boolean getRecurrent() {
		return model.getRecurrent();
	}

	/**
	 * Returns the uuid of this public holiday.
	 *
	 * @return the uuid of this public holiday
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this public holiday is recurrent.
	 *
	 * @return <code>true</code> if this public holiday is recurrent; <code>false</code> otherwise
	 */
	@Override
	public boolean isRecurrent() {
		return model.isRecurrent();
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
	 * Sets the date of this public holiday.
	 *
	 * @param date the date of this public holiday
	 */
	@Override
	public void setDate(Date date) {
		model.setDate(date);
	}

	/**
	 * Sets the name of this public holiday.
	 *
	 * @param name the name of this public holiday
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the localized name of this public holiday in the language.
	 *
	 * @param name the localized name of this public holiday
	 * @param locale the locale of the language
	 */
	@Override
	public void setName(String name, java.util.Locale locale) {
		model.setName(name, locale);
	}

	/**
	 * Sets the localized name of this public holiday in the language, and sets the default locale.
	 *
	 * @param name the localized name of this public holiday
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
	 * Sets the localized names of this public holiday from the map of locales and localized names.
	 *
	 * @param nameMap the locales and localized names of this public holiday
	 */
	@Override
	public void setNameMap(Map<java.util.Locale, String> nameMap) {
		model.setNameMap(nameMap);
	}

	/**
	 * Sets the localized names of this public holiday from the map of locales and localized names, and sets the default locale.
	 *
	 * @param nameMap the locales and localized names of this public holiday
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setNameMap(
		Map<java.util.Locale, String> nameMap, java.util.Locale defaultLocale) {

		model.setNameMap(nameMap, defaultLocale);
	}

	/**
	 * Sets the primary key of this public holiday.
	 *
	 * @param primaryKey the primary key of this public holiday
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the public holiday ID of this public holiday.
	 *
	 * @param publicHolidayId the public holiday ID of this public holiday
	 */
	@Override
	public void setPublicHolidayId(long publicHolidayId) {
		model.setPublicHolidayId(publicHolidayId);
	}

	/**
	 * Sets whether this public holiday is recurrent.
	 *
	 * @param recurrent the recurrent of this public holiday
	 */
	@Override
	public void setRecurrent(boolean recurrent) {
		model.setRecurrent(recurrent);
	}

	/**
	 * Sets the uuid of this public holiday.
	 *
	 * @param uuid the uuid of this public holiday
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
	protected PublicHolidayWrapper wrap(PublicHoliday publicHoliday) {
		return new PublicHolidayWrapper(publicHoliday);
	}

}