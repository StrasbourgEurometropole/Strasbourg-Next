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

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.LocalizedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedGroupedModel;
import com.liferay.portal.kernel.model.WorkflowedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * The base model interface for the AgendaExport service. Represents a row in the &quot;agenda_AgendaExport&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link eu.strasbourg.service.agenda.model.impl.AgendaExportModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link eu.strasbourg.service.agenda.model.impl.AgendaExportImpl}.
 * </p>
 *
 * @author BenjaminBini
 * @see AgendaExport
 * @see eu.strasbourg.service.agenda.model.impl.AgendaExportImpl
 * @see eu.strasbourg.service.agenda.model.impl.AgendaExportModelImpl
 * @generated
 */
@ProviderType
public interface AgendaExportModel extends BaseModel<AgendaExport>,
	LocalizedModel, ShardedModel, StagedGroupedModel, WorkflowedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a agenda export model instance should use the {@link AgendaExport} interface instead.
	 */

	/**
	 * Returns the primary key of this agenda export.
	 *
	 * @return the primary key of this agenda export
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this agenda export.
	 *
	 * @param primaryKey the primary key of this agenda export
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this agenda export.
	 *
	 * @return the uuid of this agenda export
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this agenda export.
	 *
	 * @param uuid the uuid of this agenda export
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the agenda export ID of this agenda export.
	 *
	 * @return the agenda export ID of this agenda export
	 */
	public long getAgendaExportId();

	/**
	 * Sets the agenda export ID of this agenda export.
	 *
	 * @param agendaExportId the agenda export ID of this agenda export
	 */
	public void setAgendaExportId(long agendaExportId);

	/**
	 * Returns the group ID of this agenda export.
	 *
	 * @return the group ID of this agenda export
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this agenda export.
	 *
	 * @param groupId the group ID of this agenda export
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this agenda export.
	 *
	 * @return the company ID of this agenda export
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this agenda export.
	 *
	 * @param companyId the company ID of this agenda export
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this agenda export.
	 *
	 * @return the user ID of this agenda export
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this agenda export.
	 *
	 * @param userId the user ID of this agenda export
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this agenda export.
	 *
	 * @return the user uuid of this agenda export
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this agenda export.
	 *
	 * @param userUuid the user uuid of this agenda export
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this agenda export.
	 *
	 * @return the user name of this agenda export
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this agenda export.
	 *
	 * @param userName the user name of this agenda export
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this agenda export.
	 *
	 * @return the create date of this agenda export
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this agenda export.
	 *
	 * @param createDate the create date of this agenda export
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this agenda export.
	 *
	 * @return the modified date of this agenda export
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this agenda export.
	 *
	 * @param modifiedDate the modified date of this agenda export
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the last publish date of this agenda export.
	 *
	 * @return the last publish date of this agenda export
	 */
	@Override
	public Date getLastPublishDate();

	/**
	 * Sets the last publish date of this agenda export.
	 *
	 * @param lastPublishDate the last publish date of this agenda export
	 */
	@Override
	public void setLastPublishDate(Date lastPublishDate);

	/**
	 * Returns the status of this agenda export.
	 *
	 * @return the status of this agenda export
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this agenda export.
	 *
	 * @param status the status of this agenda export
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this agenda export.
	 *
	 * @return the status by user ID of this agenda export
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this agenda export.
	 *
	 * @param statusByUserId the status by user ID of this agenda export
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this agenda export.
	 *
	 * @return the status by user uuid of this agenda export
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this agenda export.
	 *
	 * @param statusByUserUuid the status by user uuid of this agenda export
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this agenda export.
	 *
	 * @return the status by user name of this agenda export
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this agenda export.
	 *
	 * @param statusByUserName the status by user name of this agenda export
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this agenda export.
	 *
	 * @return the status date of this agenda export
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this agenda export.
	 *
	 * @param statusDate the status date of this agenda export
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns the title of this agenda export.
	 *
	 * @return the title of this agenda export
	 */
	public String getTitle();

	/**
	 * Returns the localized title of this agenda export in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized title of this agenda export
	 */
	@AutoEscape
	public String getTitle(Locale locale);

	/**
	 * Returns the localized title of this agenda export in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this agenda export. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getTitle(Locale locale, boolean useDefault);

	/**
	 * Returns the localized title of this agenda export in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized title of this agenda export
	 */
	@AutoEscape
	public String getTitle(String languageId);

	/**
	 * Returns the localized title of this agenda export in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this agenda export
	 */
	@AutoEscape
	public String getTitle(String languageId, boolean useDefault);

	@AutoEscape
	public String getTitleCurrentLanguageId();

	@AutoEscape
	public String getTitleCurrentValue();

	/**
	 * Returns a map of the locales and localized titles of this agenda export.
	 *
	 * @return the locales and localized titles of this agenda export
	 */
	public Map<Locale, String> getTitleMap();

	/**
	 * Sets the title of this agenda export.
	 *
	 * @param title the title of this agenda export
	 */
	public void setTitle(String title);

	/**
	 * Sets the localized title of this agenda export in the language.
	 *
	 * @param title the localized title of this agenda export
	 * @param locale the locale of the language
	 */
	public void setTitle(String title, Locale locale);

	/**
	 * Sets the localized title of this agenda export in the language, and sets the default locale.
	 *
	 * @param title the localized title of this agenda export
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setTitle(String title, Locale locale, Locale defaultLocale);

	public void setTitleCurrentLanguageId(String languageId);

	/**
	 * Sets the localized titles of this agenda export from the map of locales and localized titles.
	 *
	 * @param titleMap the locales and localized titles of this agenda export
	 */
	public void setTitleMap(Map<Locale, String> titleMap);

	/**
	 * Sets the localized titles of this agenda export from the map of locales and localized titles, and sets the default locale.
	 *
	 * @param titleMap the locales and localized titles of this agenda export
	 * @param defaultLocale the default locale
	 */
	public void setTitleMap(Map<Locale, String> titleMap, Locale defaultLocale);

	/**
	 * Returns the language of this agenda export.
	 *
	 * @return the language of this agenda export
	 */
	@AutoEscape
	public String getLanguage();

	/**
	 * Sets the language of this agenda export.
	 *
	 * @param language the language of this agenda export
	 */
	public void setLanguage(String language);

	/**
	 * Returns the export format of this agenda export.
	 *
	 * @return the export format of this agenda export
	 */
	@AutoEscape
	public String getExportFormat();

	/**
	 * Sets the export format of this agenda export.
	 *
	 * @param exportFormat the export format of this agenda export
	 */
	public void setExportFormat(String exportFormat);

	/**
	 * Returns the template ID of this agenda export.
	 *
	 * @return the template ID of this agenda export
	 */
	public long getTemplateId();

	/**
	 * Sets the template ID of this agenda export.
	 *
	 * @param templateId the template ID of this agenda export
	 */
	public void setTemplateId(long templateId);

	/**
	 * Returns the event categories of this agenda export.
	 *
	 * @return the event categories of this agenda export
	 */
	@AutoEscape
	public String getEventCategories();

	/**
	 * Sets the event categories of this agenda export.
	 *
	 * @param eventCategories the event categories of this agenda export
	 */
	public void setEventCategories(String eventCategories);

	/**
	 * Returns the aggregations of this agenda export.
	 *
	 * @return the aggregations of this agenda export
	 */
	@AutoEscape
	public String getAggregations();

	/**
	 * Sets the aggregations of this agenda export.
	 *
	 * @param aggregations the aggregations of this agenda export
	 */
	public void setAggregations(String aggregations);

	/**
	 * Returns <code>true</code> if this agenda export is approved.
	 *
	 * @return <code>true</code> if this agenda export is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this agenda export is denied.
	 *
	 * @return <code>true</code> if this agenda export is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this agenda export is a draft.
	 *
	 * @return <code>true</code> if this agenda export is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this agenda export is expired.
	 *
	 * @return <code>true</code> if this agenda export is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this agenda export is inactive.
	 *
	 * @return <code>true</code> if this agenda export is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this agenda export is incomplete.
	 *
	 * @return <code>true</code> if this agenda export is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this agenda export is pending.
	 *
	 * @return <code>true</code> if this agenda export is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this agenda export is scheduled.
	 *
	 * @return <code>true</code> if this agenda export is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled();

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

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
	public Object clone();

	@Override
	public int compareTo(
		eu.strasbourg.service.agenda.model.AgendaExport agendaExport);

	@Override
	public int hashCode();

	@Override
	public CacheModel<eu.strasbourg.service.agenda.model.AgendaExport> toCacheModel();

	@Override
	public eu.strasbourg.service.agenda.model.AgendaExport toEscapedModel();

	@Override
	public eu.strasbourg.service.agenda.model.AgendaExport toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}