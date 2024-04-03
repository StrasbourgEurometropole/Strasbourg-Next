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
 * This class is a wrapper for {@link Price}.
 * </p>
 *
 * @author Angelique Zunino Champougny
 * @see Price
 * @generated
 */
public class PriceWrapper
	extends BaseModelWrapper<Price> implements ModelWrapper<Price>, Price {

	public PriceWrapper(Price price) {
		super(price);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("priceId", getPriceId());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("title", getTitle());
		attributes.put("priceDescription", getPriceDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long priceId = (Long)attributes.get("priceId");

		if (priceId != null) {
			setPriceId(priceId);
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

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String priceDescription = (String)attributes.get("priceDescription");

		if (priceDescription != null) {
			setPriceDescription(priceDescription);
		}
	}

	@Override
	public Price cloneWithOriginalValues() {
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
	 * Retourne les lieux du tarif
	 */
	@Override
	public java.util.List<eu.strasbourg.service.place.model.Place> getPlaces() {
		return model.getPlaces();
	}

	/**
	 * Renvoie la liste des IDs des lieux auxquelles ce tarif
	 * appartient sous forme de String
	 */
	@Override
	public String getPlacesIds() {
		return model.getPlacesIds();
	}

	/**
	 * Returns the price description of this price.
	 *
	 * @return the price description of this price
	 */
	@Override
	public String getPriceDescription() {
		return model.getPriceDescription();
	}

	/**
	 * Returns the localized price description of this price in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized price description of this price
	 */
	@Override
	public String getPriceDescription(java.util.Locale locale) {
		return model.getPriceDescription(locale);
	}

	/**
	 * Returns the localized price description of this price in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized price description of this price. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getPriceDescription(
		java.util.Locale locale, boolean useDefault) {

		return model.getPriceDescription(locale, useDefault);
	}

	/**
	 * Returns the localized price description of this price in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized price description of this price
	 */
	@Override
	public String getPriceDescription(String languageId) {
		return model.getPriceDescription(languageId);
	}

	/**
	 * Returns the localized price description of this price in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized price description of this price
	 */
	@Override
	public String getPriceDescription(String languageId, boolean useDefault) {
		return model.getPriceDescription(languageId, useDefault);
	}

	@Override
	public String getPriceDescriptionCurrentLanguageId() {
		return model.getPriceDescriptionCurrentLanguageId();
	}

	@Override
	public String getPriceDescriptionCurrentValue() {
		return model.getPriceDescriptionCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized price descriptions of this price.
	 *
	 * @return the locales and localized price descriptions of this price
	 */
	@Override
	public Map<java.util.Locale, String> getPriceDescriptionMap() {
		return model.getPriceDescriptionMap();
	}

	/**
	 * Returns the price ID of this price.
	 *
	 * @return the price ID of this price
	 */
	@Override
	public long getPriceId() {
		return model.getPriceId();
	}

	/**
	 * Returns the primary key of this price.
	 *
	 * @return the primary key of this price
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this price.
	 *
	 * @return the status of this price
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this price.
	 *
	 * @return the status by user ID of this price
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this price.
	 *
	 * @return the status by user name of this price
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this price.
	 *
	 * @return the status by user uuid of this price
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this price.
	 *
	 * @return the status date of this price
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the title of this price.
	 *
	 * @return the title of this price
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the localized title of this price in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized title of this price
	 */
	@Override
	public String getTitle(java.util.Locale locale) {
		return model.getTitle(locale);
	}

	/**
	 * Returns the localized title of this price in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this price. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getTitle(java.util.Locale locale, boolean useDefault) {
		return model.getTitle(locale, useDefault);
	}

	/**
	 * Returns the localized title of this price in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized title of this price
	 */
	@Override
	public String getTitle(String languageId) {
		return model.getTitle(languageId);
	}

	/**
	 * Returns the localized title of this price in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this price
	 */
	@Override
	public String getTitle(String languageId, boolean useDefault) {
		return model.getTitle(languageId, useDefault);
	}

	@Override
	public String getTitleCurrentLanguageId() {
		return model.getTitleCurrentLanguageId();
	}

	@Override
	public String getTitleCurrentValue() {
		return model.getTitleCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized titles of this price.
	 *
	 * @return the locales and localized titles of this price
	 */
	@Override
	public Map<java.util.Locale, String> getTitleMap() {
		return model.getTitleMap();
	}

	/**
	 * Returns the uuid of this price.
	 *
	 * @return the uuid of this price
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this price is approved.
	 *
	 * @return <code>true</code> if this price is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this price is denied.
	 *
	 * @return <code>true</code> if this price is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this price is a draft.
	 *
	 * @return <code>true</code> if this price is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this price is expired.
	 *
	 * @return <code>true</code> if this price is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this price is inactive.
	 *
	 * @return <code>true</code> if this price is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this price is incomplete.
	 *
	 * @return <code>true</code> if this price is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this price is pending.
	 *
	 * @return <code>true</code> if this price is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this price is scheduled.
	 *
	 * @return <code>true</code> if this price is scheduled; <code>false</code> otherwise
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
	 * Sets the price description of this price.
	 *
	 * @param priceDescription the price description of this price
	 */
	@Override
	public void setPriceDescription(String priceDescription) {
		model.setPriceDescription(priceDescription);
	}

	/**
	 * Sets the localized price description of this price in the language.
	 *
	 * @param priceDescription the localized price description of this price
	 * @param locale the locale of the language
	 */
	@Override
	public void setPriceDescription(
		String priceDescription, java.util.Locale locale) {

		model.setPriceDescription(priceDescription, locale);
	}

	/**
	 * Sets the localized price description of this price in the language, and sets the default locale.
	 *
	 * @param priceDescription the localized price description of this price
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setPriceDescription(
		String priceDescription, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setPriceDescription(priceDescription, locale, defaultLocale);
	}

	@Override
	public void setPriceDescriptionCurrentLanguageId(String languageId) {
		model.setPriceDescriptionCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized price descriptions of this price from the map of locales and localized price descriptions.
	 *
	 * @param priceDescriptionMap the locales and localized price descriptions of this price
	 */
	@Override
	public void setPriceDescriptionMap(
		Map<java.util.Locale, String> priceDescriptionMap) {

		model.setPriceDescriptionMap(priceDescriptionMap);
	}

	/**
	 * Sets the localized price descriptions of this price from the map of locales and localized price descriptions, and sets the default locale.
	 *
	 * @param priceDescriptionMap the locales and localized price descriptions of this price
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setPriceDescriptionMap(
		Map<java.util.Locale, String> priceDescriptionMap,
		java.util.Locale defaultLocale) {

		model.setPriceDescriptionMap(priceDescriptionMap, defaultLocale);
	}

	/**
	 * Sets the price ID of this price.
	 *
	 * @param priceId the price ID of this price
	 */
	@Override
	public void setPriceId(long priceId) {
		model.setPriceId(priceId);
	}

	/**
	 * Sets the primary key of this price.
	 *
	 * @param primaryKey the primary key of this price
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this price.
	 *
	 * @param status the status of this price
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this price.
	 *
	 * @param statusByUserId the status by user ID of this price
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this price.
	 *
	 * @param statusByUserName the status by user name of this price
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this price.
	 *
	 * @param statusByUserUuid the status by user uuid of this price
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this price.
	 *
	 * @param statusDate the status date of this price
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the title of this price.
	 *
	 * @param title the title of this price
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the localized title of this price in the language.
	 *
	 * @param title the localized title of this price
	 * @param locale the locale of the language
	 */
	@Override
	public void setTitle(String title, java.util.Locale locale) {
		model.setTitle(title, locale);
	}

	/**
	 * Sets the localized title of this price in the language, and sets the default locale.
	 *
	 * @param title the localized title of this price
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setTitle(
		String title, java.util.Locale locale, java.util.Locale defaultLocale) {

		model.setTitle(title, locale, defaultLocale);
	}

	@Override
	public void setTitleCurrentLanguageId(String languageId) {
		model.setTitleCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized titles of this price from the map of locales and localized titles.
	 *
	 * @param titleMap the locales and localized titles of this price
	 */
	@Override
	public void setTitleMap(Map<java.util.Locale, String> titleMap) {
		model.setTitleMap(titleMap);
	}

	/**
	 * Sets the localized titles of this price from the map of locales and localized titles, and sets the default locale.
	 *
	 * @param titleMap the locales and localized titles of this price
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setTitleMap(
		Map<java.util.Locale, String> titleMap,
		java.util.Locale defaultLocale) {

		model.setTitleMap(titleMap, defaultLocale);
	}

	/**
	 * Sets the uuid of this price.
	 *
	 * @param uuid the uuid of this price
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
	protected PriceWrapper wrap(Price price) {
		return new PriceWrapper(price);
	}

}