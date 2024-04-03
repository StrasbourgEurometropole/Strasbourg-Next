/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link EventPeriod}.
 * </p>
 *
 * @author BenjaminBini
 * @see EventPeriod
 * @generated
 */
public class EventPeriodWrapper
	extends BaseModelWrapper<EventPeriod>
	implements EventPeriod, ModelWrapper<EventPeriod> {

	public EventPeriodWrapper(EventPeriod eventPeriod) {
		super(eventPeriod);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("eventPeriodId", getEventPeriodId());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("timeDetail", getTimeDetail());
		attributes.put("eventId", getEventId());
		attributes.put("campaignEventId", getCampaignEventId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long eventPeriodId = (Long)attributes.get("eventPeriodId");

		if (eventPeriodId != null) {
			setEventPeriodId(eventPeriodId);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		String timeDetail = (String)attributes.get("timeDetail");

		if (timeDetail != null) {
			setTimeDetail(timeDetail);
		}

		Long eventId = (Long)attributes.get("eventId");

		if (eventId != null) {
			setEventId(eventId);
		}

		Long campaignEventId = (Long)attributes.get("campaignEventId");

		if (campaignEventId != null) {
			setCampaignEventId(campaignEventId);
		}
	}

	@Override
	public EventPeriod cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the campaign event ID of this event period.
	 *
	 * @return the campaign event ID of this event period
	 */
	@Override
	public long getCampaignEventId() {
		return model.getCampaignEventId();
	}

	@Override
	public String getDefaultLanguageId() {
		return model.getDefaultLanguageId();
	}

	@Override
	public String getDisplay(java.util.Locale locale) {
		return model.getDisplay(locale);
	}

	@Override
	public String getDisplay(
		java.util.Locale locale, boolean dispYear, boolean dispShortMonth) {

		return model.getDisplay(locale, dispYear, dispShortMonth);
	}

	/**
	 * Returns the end date of this event period.
	 *
	 * @return the end date of this event period
	 */
	@Override
	public Date getEndDate() {
		return model.getEndDate();
	}

	/**
	 * Returns the event ID of this event period.
	 *
	 * @return the event ID of this event period
	 */
	@Override
	public long getEventId() {
		return model.getEventId();
	}

	/**
	 * Returns the event period ID of this event period.
	 *
	 * @return the event period ID of this event period
	 */
	@Override
	public long getEventPeriodId() {
		return model.getEventPeriodId();
	}

	/**
	 * Returns the primary key of this event period.
	 *
	 * @return the primary key of this event period
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the start date of this event period.
	 *
	 * @return the start date of this event period
	 */
	@Override
	public Date getStartDate() {
		return model.getStartDate();
	}

	/**
	 * Returns the time detail of this event period.
	 *
	 * @return the time detail of this event period
	 */
	@Override
	public String getTimeDetail() {
		return model.getTimeDetail();
	}

	/**
	 * Returns the localized time detail of this event period in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized time detail of this event period
	 */
	@Override
	public String getTimeDetail(java.util.Locale locale) {
		return model.getTimeDetail(locale);
	}

	/**
	 * Returns the localized time detail of this event period in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized time detail of this event period. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getTimeDetail(java.util.Locale locale, boolean useDefault) {
		return model.getTimeDetail(locale, useDefault);
	}

	/**
	 * Returns the localized time detail of this event period in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized time detail of this event period
	 */
	@Override
	public String getTimeDetail(String languageId) {
		return model.getTimeDetail(languageId);
	}

	/**
	 * Returns the localized time detail of this event period in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized time detail of this event period
	 */
	@Override
	public String getTimeDetail(String languageId, boolean useDefault) {
		return model.getTimeDetail(languageId, useDefault);
	}

	@Override
	public String getTimeDetailCurrentLanguageId() {
		return model.getTimeDetailCurrentLanguageId();
	}

	@Override
	public String getTimeDetailCurrentValue() {
		return model.getTimeDetailCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized time details of this event period.
	 *
	 * @return the locales and localized time details of this event period
	 */
	@Override
	public Map<java.util.Locale, String> getTimeDetailMap() {
		return model.getTimeDetailMap();
	}

	/**
	 * Returns the uuid of this event period.
	 *
	 * @return the uuid of this event period
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
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
	 * Sets the campaign event ID of this event period.
	 *
	 * @param campaignEventId the campaign event ID of this event period
	 */
	@Override
	public void setCampaignEventId(long campaignEventId) {
		model.setCampaignEventId(campaignEventId);
	}

	/**
	 * Sets the end date of this event period.
	 *
	 * @param endDate the end date of this event period
	 */
	@Override
	public void setEndDate(Date endDate) {
		model.setEndDate(endDate);
	}

	/**
	 * Sets the event ID of this event period.
	 *
	 * @param eventId the event ID of this event period
	 */
	@Override
	public void setEventId(long eventId) {
		model.setEventId(eventId);
	}

	/**
	 * Sets the event period ID of this event period.
	 *
	 * @param eventPeriodId the event period ID of this event period
	 */
	@Override
	public void setEventPeriodId(long eventPeriodId) {
		model.setEventPeriodId(eventPeriodId);
	}

	/**
	 * Sets the primary key of this event period.
	 *
	 * @param primaryKey the primary key of this event period
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the start date of this event period.
	 *
	 * @param startDate the start date of this event period
	 */
	@Override
	public void setStartDate(Date startDate) {
		model.setStartDate(startDate);
	}

	/**
	 * Sets the time detail of this event period.
	 *
	 * @param timeDetail the time detail of this event period
	 */
	@Override
	public void setTimeDetail(String timeDetail) {
		model.setTimeDetail(timeDetail);
	}

	/**
	 * Sets the localized time detail of this event period in the language.
	 *
	 * @param timeDetail the localized time detail of this event period
	 * @param locale the locale of the language
	 */
	@Override
	public void setTimeDetail(String timeDetail, java.util.Locale locale) {
		model.setTimeDetail(timeDetail, locale);
	}

	/**
	 * Sets the localized time detail of this event period in the language, and sets the default locale.
	 *
	 * @param timeDetail the localized time detail of this event period
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setTimeDetail(
		String timeDetail, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setTimeDetail(timeDetail, locale, defaultLocale);
	}

	@Override
	public void setTimeDetailCurrentLanguageId(String languageId) {
		model.setTimeDetailCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized time details of this event period from the map of locales and localized time details.
	 *
	 * @param timeDetailMap the locales and localized time details of this event period
	 */
	@Override
	public void setTimeDetailMap(Map<java.util.Locale, String> timeDetailMap) {
		model.setTimeDetailMap(timeDetailMap);
	}

	/**
	 * Sets the localized time details of this event period from the map of locales and localized time details, and sets the default locale.
	 *
	 * @param timeDetailMap the locales and localized time details of this event period
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setTimeDetailMap(
		Map<java.util.Locale, String> timeDetailMap,
		java.util.Locale defaultLocale) {

		model.setTimeDetailMap(timeDetailMap, defaultLocale);
	}

	/**
	 * Sets the uuid of this event period.
	 *
	 * @param uuid the uuid of this event period
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
	protected EventPeriodWrapper wrap(EventPeriod eventPeriod) {
		return new EventPeriodWrapper(eventPeriod);
	}

}