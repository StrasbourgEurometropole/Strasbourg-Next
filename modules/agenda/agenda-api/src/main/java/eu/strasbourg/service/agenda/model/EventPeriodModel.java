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

package eu.strasbourg.service.agenda.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.LocalizedModel;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the EventPeriod service. Represents a row in the &quot;agenda_EventPeriod&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>eu.strasbourg.service.agenda.model.impl.EventPeriodModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>eu.strasbourg.service.agenda.model.impl.EventPeriodImpl</code>.
 * </p>
 *
 * @author BenjaminBini
 * @see EventPeriod
 * @generated
 */
@ProviderType
public interface EventPeriodModel
	extends BaseModel<EventPeriod>, LocalizedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a event period model instance should use the {@link EventPeriod} interface instead.
	 */

	/**
	 * Returns the primary key of this event period.
	 *
	 * @return the primary key of this event period
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this event period.
	 *
	 * @param primaryKey the primary key of this event period
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this event period.
	 *
	 * @return the uuid of this event period
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this event period.
	 *
	 * @param uuid the uuid of this event period
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the event period ID of this event period.
	 *
	 * @return the event period ID of this event period
	 */
	public long getEventPeriodId();

	/**
	 * Sets the event period ID of this event period.
	 *
	 * @param eventPeriodId the event period ID of this event period
	 */
	public void setEventPeriodId(long eventPeriodId);

	/**
	 * Returns the start date of this event period.
	 *
	 * @return the start date of this event period
	 */
	public Date getStartDate();

	/**
	 * Sets the start date of this event period.
	 *
	 * @param startDate the start date of this event period
	 */
	public void setStartDate(Date startDate);

	/**
	 * Returns the end date of this event period.
	 *
	 * @return the end date of this event period
	 */
	public Date getEndDate();

	/**
	 * Sets the end date of this event period.
	 *
	 * @param endDate the end date of this event period
	 */
	public void setEndDate(Date endDate);

	/**
	 * Returns the time detail of this event period.
	 *
	 * @return the time detail of this event period
	 */
	public String getTimeDetail();

	/**
	 * Returns the localized time detail of this event period in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized time detail of this event period
	 */
	@AutoEscape
	public String getTimeDetail(Locale locale);

	/**
	 * Returns the localized time detail of this event period in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized time detail of this event period. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getTimeDetail(Locale locale, boolean useDefault);

	/**
	 * Returns the localized time detail of this event period in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized time detail of this event period
	 */
	@AutoEscape
	public String getTimeDetail(String languageId);

	/**
	 * Returns the localized time detail of this event period in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized time detail of this event period
	 */
	@AutoEscape
	public String getTimeDetail(String languageId, boolean useDefault);

	@AutoEscape
	public String getTimeDetailCurrentLanguageId();

	@AutoEscape
	public String getTimeDetailCurrentValue();

	/**
	 * Returns a map of the locales and localized time details of this event period.
	 *
	 * @return the locales and localized time details of this event period
	 */
	public Map<Locale, String> getTimeDetailMap();

	/**
	 * Sets the time detail of this event period.
	 *
	 * @param timeDetail the time detail of this event period
	 */
	public void setTimeDetail(String timeDetail);

	/**
	 * Sets the localized time detail of this event period in the language.
	 *
	 * @param timeDetail the localized time detail of this event period
	 * @param locale the locale of the language
	 */
	public void setTimeDetail(String timeDetail, Locale locale);

	/**
	 * Sets the localized time detail of this event period in the language, and sets the default locale.
	 *
	 * @param timeDetail the localized time detail of this event period
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setTimeDetail(
		String timeDetail, Locale locale, Locale defaultLocale);

	public void setTimeDetailCurrentLanguageId(String languageId);

	/**
	 * Sets the localized time details of this event period from the map of locales and localized time details.
	 *
	 * @param timeDetailMap the locales and localized time details of this event period
	 */
	public void setTimeDetailMap(Map<Locale, String> timeDetailMap);

	/**
	 * Sets the localized time details of this event period from the map of locales and localized time details, and sets the default locale.
	 *
	 * @param timeDetailMap the locales and localized time details of this event period
	 * @param defaultLocale the default locale
	 */
	public void setTimeDetailMap(
		Map<Locale, String> timeDetailMap, Locale defaultLocale);

	/**
	 * Returns the event ID of this event period.
	 *
	 * @return the event ID of this event period
	 */
	public long getEventId();

	/**
	 * Sets the event ID of this event period.
	 *
	 * @param eventId the event ID of this event period
	 */
	public void setEventId(long eventId);

	/**
	 * Returns the campaign event ID of this event period.
	 *
	 * @return the campaign event ID of this event period
	 */
	public long getCampaignEventId();

	/**
	 * Sets the campaign event ID of this event period.
	 *
	 * @param campaignEventId the campaign event ID of this event period
	 */
	public void setCampaignEventId(long campaignEventId);

	@Override
	public String[] getAvailableLanguageIds();

	@Override
	public String getDefaultLanguageId();

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException;

	@Override
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException;

	@Override
	public EventPeriod cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}