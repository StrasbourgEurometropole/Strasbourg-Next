/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.notif.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link NatureNotif}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NatureNotif
 * @generated
 */
public class NatureNotifWrapper
	extends BaseModelWrapper<NatureNotif>
	implements ModelWrapper<NatureNotif>, NatureNotif {

	public NatureNotifWrapper(NatureNotif natureNotif) {
		super(natureNotif);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("natureId", getNatureId());
		attributes.put("serviceId", getServiceId());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long natureId = (Long)attributes.get("natureId");

		if (natureId != null) {
			setNatureId(natureId);
		}

		Long serviceId = (Long)attributes.get("serviceId");

		if (serviceId != null) {
			setServiceId(serviceId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	@Override
	public NatureNotif cloneWithOriginalValues() {
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
	 * Returns the name of this nature notif.
	 *
	 * @return the name of this nature notif
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the localized name of this nature notif in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized name of this nature notif
	 */
	@Override
	public String getName(java.util.Locale locale) {
		return model.getName(locale);
	}

	/**
	 * Returns the localized name of this nature notif in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this nature notif. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getName(java.util.Locale locale, boolean useDefault) {
		return model.getName(locale, useDefault);
	}

	/**
	 * Returns the localized name of this nature notif in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized name of this nature notif
	 */
	@Override
	public String getName(String languageId) {
		return model.getName(languageId);
	}

	/**
	 * Returns the localized name of this nature notif in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this nature notif
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
	 * Returns a map of the locales and localized names of this nature notif.
	 *
	 * @return the locales and localized names of this nature notif
	 */
	@Override
	public Map<java.util.Locale, String> getNameMap() {
		return model.getNameMap();
	}

	/**
	 * Returns the nature ID of this nature notif.
	 *
	 * @return the nature ID of this nature notif
	 */
	@Override
	public long getNatureId() {
		return model.getNatureId();
	}

	/**
	 * Returns the primary key of this nature notif.
	 *
	 * @return the primary key of this nature notif
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the service ID of this nature notif.
	 *
	 * @return the service ID of this nature notif
	 */
	@Override
	public long getServiceId() {
		return model.getServiceId();
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
	 * Sets the name of this nature notif.
	 *
	 * @param name the name of this nature notif
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the localized name of this nature notif in the language.
	 *
	 * @param name the localized name of this nature notif
	 * @param locale the locale of the language
	 */
	@Override
	public void setName(String name, java.util.Locale locale) {
		model.setName(name, locale);
	}

	/**
	 * Sets the localized name of this nature notif in the language, and sets the default locale.
	 *
	 * @param name the localized name of this nature notif
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
	 * Sets the localized names of this nature notif from the map of locales and localized names.
	 *
	 * @param nameMap the locales and localized names of this nature notif
	 */
	@Override
	public void setNameMap(Map<java.util.Locale, String> nameMap) {
		model.setNameMap(nameMap);
	}

	/**
	 * Sets the localized names of this nature notif from the map of locales and localized names, and sets the default locale.
	 *
	 * @param nameMap the locales and localized names of this nature notif
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setNameMap(
		Map<java.util.Locale, String> nameMap, java.util.Locale defaultLocale) {

		model.setNameMap(nameMap, defaultLocale);
	}

	/**
	 * Sets the nature ID of this nature notif.
	 *
	 * @param natureId the nature ID of this nature notif
	 */
	@Override
	public void setNatureId(long natureId) {
		model.setNatureId(natureId);
	}

	/**
	 * Sets the primary key of this nature notif.
	 *
	 * @param primaryKey the primary key of this nature notif
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the service ID of this nature notif.
	 *
	 * @param serviceId the service ID of this nature notif
	 */
	@Override
	public void setServiceId(long serviceId) {
		model.setServiceId(serviceId);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected NatureNotifWrapper wrap(NatureNotif natureNotif) {
		return new NatureNotifWrapper(natureNotif);
	}

}