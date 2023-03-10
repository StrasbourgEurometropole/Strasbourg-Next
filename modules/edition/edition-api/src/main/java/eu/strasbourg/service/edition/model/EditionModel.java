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

package eu.strasbourg.service.edition.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.LocalizedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedGroupedModel;
import com.liferay.portal.kernel.model.WorkflowedModel;
import org.osgi.annotation.versioning.ProviderType;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * The base model interface for the Edition service. Represents a row in the &quot;edition_Edition&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>eu.strasbourg.service.edition.model.impl.EditionModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>eu.strasbourg.service.edition.model.impl.EditionImpl</code>.
 * </p>
 *
 * @author BenjaminBini
 * @see Edition
 * @generated
 */
@ProviderType
public interface EditionModel
	extends BaseModel<Edition>, LocalizedModel, ShardedModel,
			StagedGroupedModel, WorkflowedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a edition model instance should use the {@link Edition} interface instead.
	 */

	/**
	 * Returns the primary key of this edition.
	 *
	 * @return the primary key of this edition
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this edition.
	 *
	 * @param primaryKey the primary key of this edition
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this edition.
	 *
	 * @return the uuid of this edition
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this edition.
	 *
	 * @param uuid the uuid of this edition
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the edition ID of this edition.
	 *
	 * @return the edition ID of this edition
	 */
	public long getEditionId();

	/**
	 * Sets the edition ID of this edition.
	 *
	 * @param editionId the edition ID of this edition
	 */
	public void setEditionId(long editionId);

	/**
	 * Returns the group ID of this edition.
	 *
	 * @return the group ID of this edition
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this edition.
	 *
	 * @param groupId the group ID of this edition
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this edition.
	 *
	 * @return the company ID of this edition
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this edition.
	 *
	 * @param companyId the company ID of this edition
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this edition.
	 *
	 * @return the user ID of this edition
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this edition.
	 *
	 * @param userId the user ID of this edition
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this edition.
	 *
	 * @return the user uuid of this edition
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this edition.
	 *
	 * @param userUuid the user uuid of this edition
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this edition.
	 *
	 * @return the user name of this edition
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this edition.
	 *
	 * @param userName the user name of this edition
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this edition.
	 *
	 * @return the create date of this edition
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this edition.
	 *
	 * @param createDate the create date of this edition
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this edition.
	 *
	 * @return the modified date of this edition
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this edition.
	 *
	 * @param modifiedDate the modified date of this edition
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the last publish date of this edition.
	 *
	 * @return the last publish date of this edition
	 */
	@Override
	public Date getLastPublishDate();

	/**
	 * Sets the last publish date of this edition.
	 *
	 * @param lastPublishDate the last publish date of this edition
	 */
	@Override
	public void setLastPublishDate(Date lastPublishDate);

	/**
	 * Returns the status of this edition.
	 *
	 * @return the status of this edition
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this edition.
	 *
	 * @param status the status of this edition
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this edition.
	 *
	 * @return the status by user ID of this edition
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this edition.
	 *
	 * @param statusByUserId the status by user ID of this edition
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this edition.
	 *
	 * @return the status by user uuid of this edition
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this edition.
	 *
	 * @param statusByUserUuid the status by user uuid of this edition
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this edition.
	 *
	 * @return the status by user name of this edition
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this edition.
	 *
	 * @param statusByUserName the status by user name of this edition
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this edition.
	 *
	 * @return the status date of this edition
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this edition.
	 *
	 * @param statusDate the status date of this edition
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns the title of this edition.
	 *
	 * @return the title of this edition
	 */
	public String getTitle();

	/**
	 * Returns the localized title of this edition in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized title of this edition
	 */
	@AutoEscape
	public String getTitle(Locale locale);

	/**
	 * Returns the localized title of this edition in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this edition. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getTitle(Locale locale, boolean useDefault);

	/**
	 * Returns the localized title of this edition in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized title of this edition
	 */
	@AutoEscape
	public String getTitle(String languageId);

	/**
	 * Returns the localized title of this edition in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this edition
	 */
	@AutoEscape
	public String getTitle(String languageId, boolean useDefault);

	@AutoEscape
	public String getTitleCurrentLanguageId();

	@AutoEscape
	public String getTitleCurrentValue();

	/**
	 * Returns a map of the locales and localized titles of this edition.
	 *
	 * @return the locales and localized titles of this edition
	 */
	public Map<Locale, String> getTitleMap();

	/**
	 * Sets the title of this edition.
	 *
	 * @param title the title of this edition
	 */
	public void setTitle(String title);

	/**
	 * Sets the localized title of this edition in the language.
	 *
	 * @param title the localized title of this edition
	 * @param locale the locale of the language
	 */
	public void setTitle(String title, Locale locale);

	/**
	 * Sets the localized title of this edition in the language, and sets the default locale.
	 *
	 * @param title the localized title of this edition
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setTitle(String title, Locale locale, Locale defaultLocale);

	public void setTitleCurrentLanguageId(String languageId);

	/**
	 * Sets the localized titles of this edition from the map of locales and localized titles.
	 *
	 * @param titleMap the locales and localized titles of this edition
	 */
	public void setTitleMap(Map<Locale, String> titleMap);

	/**
	 * Sets the localized titles of this edition from the map of locales and localized titles, and sets the default locale.
	 *
	 * @param titleMap the locales and localized titles of this edition
	 * @param defaultLocale the default locale
	 */
	public void setTitleMap(Map<Locale, String> titleMap, Locale defaultLocale);

	/**
	 * Returns the subtitle of this edition.
	 *
	 * @return the subtitle of this edition
	 */
	public String getSubtitle();

	/**
	 * Returns the localized subtitle of this edition in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized subtitle of this edition
	 */
	@AutoEscape
	public String getSubtitle(Locale locale);

	/**
	 * Returns the localized subtitle of this edition in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized subtitle of this edition. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getSubtitle(Locale locale, boolean useDefault);

	/**
	 * Returns the localized subtitle of this edition in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized subtitle of this edition
	 */
	@AutoEscape
	public String getSubtitle(String languageId);

	/**
	 * Returns the localized subtitle of this edition in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized subtitle of this edition
	 */
	@AutoEscape
	public String getSubtitle(String languageId, boolean useDefault);

	@AutoEscape
	public String getSubtitleCurrentLanguageId();

	@AutoEscape
	public String getSubtitleCurrentValue();

	/**
	 * Returns a map of the locales and localized subtitles of this edition.
	 *
	 * @return the locales and localized subtitles of this edition
	 */
	public Map<Locale, String> getSubtitleMap();

	/**
	 * Sets the subtitle of this edition.
	 *
	 * @param subtitle the subtitle of this edition
	 */
	public void setSubtitle(String subtitle);

	/**
	 * Sets the localized subtitle of this edition in the language.
	 *
	 * @param subtitle the localized subtitle of this edition
	 * @param locale the locale of the language
	 */
	public void setSubtitle(String subtitle, Locale locale);

	/**
	 * Sets the localized subtitle of this edition in the language, and sets the default locale.
	 *
	 * @param subtitle the localized subtitle of this edition
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setSubtitle(
		String subtitle, Locale locale, Locale defaultLocale);

	public void setSubtitleCurrentLanguageId(String languageId);

	/**
	 * Sets the localized subtitles of this edition from the map of locales and localized subtitles.
	 *
	 * @param subtitleMap the locales and localized subtitles of this edition
	 */
	public void setSubtitleMap(Map<Locale, String> subtitleMap);

	/**
	 * Sets the localized subtitles of this edition from the map of locales and localized subtitles, and sets the default locale.
	 *
	 * @param subtitleMap the locales and localized subtitles of this edition
	 * @param defaultLocale the default locale
	 */
	public void setSubtitleMap(
		Map<Locale, String> subtitleMap, Locale defaultLocale);

	/**
	 * Returns the description of this edition.
	 *
	 * @return the description of this edition
	 */
	public String getDescription();

	/**
	 * Returns the localized description of this edition in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description of this edition
	 */
	@AutoEscape
	public String getDescription(Locale locale);

	/**
	 * Returns the localized description of this edition in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this edition. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getDescription(Locale locale, boolean useDefault);

	/**
	 * Returns the localized description of this edition in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description of this edition
	 */
	@AutoEscape
	public String getDescription(String languageId);

	/**
	 * Returns the localized description of this edition in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this edition
	 */
	@AutoEscape
	public String getDescription(String languageId, boolean useDefault);

	@AutoEscape
	public String getDescriptionCurrentLanguageId();

	@AutoEscape
	public String getDescriptionCurrentValue();

	/**
	 * Returns a map of the locales and localized descriptions of this edition.
	 *
	 * @return the locales and localized descriptions of this edition
	 */
	public Map<Locale, String> getDescriptionMap();

	/**
	 * Sets the description of this edition.
	 *
	 * @param description the description of this edition
	 */
	public void setDescription(String description);

	/**
	 * Sets the localized description of this edition in the language.
	 *
	 * @param description the localized description of this edition
	 * @param locale the locale of the language
	 */
	public void setDescription(String description, Locale locale);

	/**
	 * Sets the localized description of this edition in the language, and sets the default locale.
	 *
	 * @param description the localized description of this edition
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setDescription(
		String description, Locale locale, Locale defaultLocale);

	public void setDescriptionCurrentLanguageId(String languageId);

	/**
	 * Sets the localized descriptions of this edition from the map of locales and localized descriptions.
	 *
	 * @param descriptionMap the locales and localized descriptions of this edition
	 */
	public void setDescriptionMap(Map<Locale, String> descriptionMap);

	/**
	 * Sets the localized descriptions of this edition from the map of locales and localized descriptions, and sets the default locale.
	 *
	 * @param descriptionMap the locales and localized descriptions of this edition
	 * @param defaultLocale the default locale
	 */
	public void setDescriptionMap(
		Map<Locale, String> descriptionMap, Locale defaultLocale);

	/**
	 * Returns the url of this edition.
	 *
	 * @return the url of this edition
	 */
	public String getURL();

	/**
	 * Returns the localized url of this edition in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized url of this edition
	 */
	@AutoEscape
	public String getURL(Locale locale);

	/**
	 * Returns the localized url of this edition in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized url of this edition. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getURL(Locale locale, boolean useDefault);

	/**
	 * Returns the localized url of this edition in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized url of this edition
	 */
	@AutoEscape
	public String getURL(String languageId);

	/**
	 * Returns the localized url of this edition in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized url of this edition
	 */
	@AutoEscape
	public String getURL(String languageId, boolean useDefault);

	@AutoEscape
	public String getURLCurrentLanguageId();

	@AutoEscape
	public String getURLCurrentValue();

	/**
	 * Returns a map of the locales and localized urls of this edition.
	 *
	 * @return the locales and localized urls of this edition
	 */
	public Map<Locale, String> getURLMap();

	/**
	 * Sets the url of this edition.
	 *
	 * @param URL the url of this edition
	 */
	public void setURL(String URL);

	/**
	 * Sets the localized url of this edition in the language.
	 *
	 * @param URL the localized url of this edition
	 * @param locale the locale of the language
	 */
	public void setURL(String URL, Locale locale);

	/**
	 * Sets the localized url of this edition in the language, and sets the default locale.
	 *
	 * @param URL the localized url of this edition
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setURL(String URL, Locale locale, Locale defaultLocale);

	public void setURLCurrentLanguageId(String languageId);

	/**
	 * Sets the localized urls of this edition from the map of locales and localized urls.
	 *
	 * @param URLMap the locales and localized urls of this edition
	 */
	public void setURLMap(Map<Locale, String> URLMap);

	/**
	 * Sets the localized urls of this edition from the map of locales and localized urls, and sets the default locale.
	 *
	 * @param URLMap the locales and localized urls of this edition
	 * @param defaultLocale the default locale
	 */
	public void setURLMap(Map<Locale, String> URLMap, Locale defaultLocale);

	/**
	 * Returns the author of this edition.
	 *
	 * @return the author of this edition
	 */
	public String getAuthor();

	/**
	 * Returns the localized author of this edition in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized author of this edition
	 */
	@AutoEscape
	public String getAuthor(Locale locale);

	/**
	 * Returns the localized author of this edition in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized author of this edition. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getAuthor(Locale locale, boolean useDefault);

	/**
	 * Returns the localized author of this edition in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized author of this edition
	 */
	@AutoEscape
	public String getAuthor(String languageId);

	/**
	 * Returns the localized author of this edition in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized author of this edition
	 */
	@AutoEscape
	public String getAuthor(String languageId, boolean useDefault);

	@AutoEscape
	public String getAuthorCurrentLanguageId();

	@AutoEscape
	public String getAuthorCurrentValue();

	/**
	 * Returns a map of the locales and localized authors of this edition.
	 *
	 * @return the locales and localized authors of this edition
	 */
	public Map<Locale, String> getAuthorMap();

	/**
	 * Sets the author of this edition.
	 *
	 * @param author the author of this edition
	 */
	public void setAuthor(String author);

	/**
	 * Sets the localized author of this edition in the language.
	 *
	 * @param author the localized author of this edition
	 * @param locale the locale of the language
	 */
	public void setAuthor(String author, Locale locale);

	/**
	 * Sets the localized author of this edition in the language, and sets the default locale.
	 *
	 * @param author the localized author of this edition
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setAuthor(String author, Locale locale, Locale defaultLocale);

	public void setAuthorCurrentLanguageId(String languageId);

	/**
	 * Sets the localized authors of this edition from the map of locales and localized authors.
	 *
	 * @param authorMap the locales and localized authors of this edition
	 */
	public void setAuthorMap(Map<Locale, String> authorMap);

	/**
	 * Sets the localized authors of this edition from the map of locales and localized authors, and sets the default locale.
	 *
	 * @param authorMap the locales and localized authors of this edition
	 * @param defaultLocale the default locale
	 */
	public void setAuthorMap(
		Map<Locale, String> authorMap, Locale defaultLocale);

	/**
	 * Returns the editor of this edition.
	 *
	 * @return the editor of this edition
	 */
	public String getEditor();

	/**
	 * Returns the localized editor of this edition in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized editor of this edition
	 */
	@AutoEscape
	public String getEditor(Locale locale);

	/**
	 * Returns the localized editor of this edition in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized editor of this edition. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getEditor(Locale locale, boolean useDefault);

	/**
	 * Returns the localized editor of this edition in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized editor of this edition
	 */
	@AutoEscape
	public String getEditor(String languageId);

	/**
	 * Returns the localized editor of this edition in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized editor of this edition
	 */
	@AutoEscape
	public String getEditor(String languageId, boolean useDefault);

	@AutoEscape
	public String getEditorCurrentLanguageId();

	@AutoEscape
	public String getEditorCurrentValue();

	/**
	 * Returns a map of the locales and localized editors of this edition.
	 *
	 * @return the locales and localized editors of this edition
	 */
	public Map<Locale, String> getEditorMap();

	/**
	 * Sets the editor of this edition.
	 *
	 * @param editor the editor of this edition
	 */
	public void setEditor(String editor);

	/**
	 * Sets the localized editor of this edition in the language.
	 *
	 * @param editor the localized editor of this edition
	 * @param locale the locale of the language
	 */
	public void setEditor(String editor, Locale locale);

	/**
	 * Sets the localized editor of this edition in the language, and sets the default locale.
	 *
	 * @param editor the localized editor of this edition
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setEditor(String editor, Locale locale, Locale defaultLocale);

	public void setEditorCurrentLanguageId(String languageId);

	/**
	 * Sets the localized editors of this edition from the map of locales and localized editors.
	 *
	 * @param editorMap the locales and localized editors of this edition
	 */
	public void setEditorMap(Map<Locale, String> editorMap);

	/**
	 * Sets the localized editors of this edition from the map of locales and localized editors, and sets the default locale.
	 *
	 * @param editorMap the locales and localized editors of this edition
	 * @param defaultLocale the default locale
	 */
	public void setEditorMap(
		Map<Locale, String> editorMap, Locale defaultLocale);

	/**
	 * Returns the distribution of this edition.
	 *
	 * @return the distribution of this edition
	 */
	@AutoEscape
	public String getDistribution();

	/**
	 * Sets the distribution of this edition.
	 *
	 * @param distribution the distribution of this edition
	 */
	public void setDistribution(String distribution);

	/**
	 * Returns the isbn of this edition.
	 *
	 * @return the isbn of this edition
	 */
	@AutoEscape
	public String getISBN();

	/**
	 * Sets the isbn of this edition.
	 *
	 * @param ISBN the isbn of this edition
	 */
	public void setISBN(String ISBN);

	/**
	 * Returns the price of this edition.
	 *
	 * @return the price of this edition
	 */
	@AutoEscape
	public String getPrice();

	/**
	 * Sets the price of this edition.
	 *
	 * @param price the price of this edition
	 */
	public void setPrice(String price);

	/**
	 * Returns the available for exchange of this edition.
	 *
	 * @return the available for exchange of this edition
	 */
	public boolean getAvailableForExchange();

	/**
	 * Returns <code>true</code> if this edition is available for exchange.
	 *
	 * @return <code>true</code> if this edition is available for exchange; <code>false</code> otherwise
	 */
	public boolean isAvailableForExchange();

	/**
	 * Sets whether this edition is available for exchange.
	 *
	 * @param availableForExchange the available for exchange of this edition
	 */
	public void setAvailableForExchange(boolean availableForExchange);

	/**
	 * Returns the in stock of this edition.
	 *
	 * @return the in stock of this edition
	 */
	public boolean getInStock();

	/**
	 * Returns <code>true</code> if this edition is in stock.
	 *
	 * @return <code>true</code> if this edition is in stock; <code>false</code> otherwise
	 */
	public boolean isInStock();

	/**
	 * Sets whether this edition is in stock.
	 *
	 * @param inStock the in stock of this edition
	 */
	public void setInStock(boolean inStock);

	/**
	 * Returns the diffusion date year of this edition.
	 *
	 * @return the diffusion date year of this edition
	 */
	@AutoEscape
	public String getDiffusionDateYear();

	/**
	 * Sets the diffusion date year of this edition.
	 *
	 * @param diffusionDateYear the diffusion date year of this edition
	 */
	public void setDiffusionDateYear(String diffusionDateYear);

	/**
	 * Returns the diffusion date month of this edition.
	 *
	 * @return the diffusion date month of this edition
	 */
	@AutoEscape
	public String getDiffusionDateMonth();

	/**
	 * Sets the diffusion date month of this edition.
	 *
	 * @param diffusionDateMonth the diffusion date month of this edition
	 */
	public void setDiffusionDateMonth(String diffusionDateMonth);

	/**
	 * Returns the page number of this edition.
	 *
	 * @return the page number of this edition
	 */
	@AutoEscape
	public String getPageNumber();

	/**
	 * Sets the page number of this edition.
	 *
	 * @param pageNumber the page number of this edition
	 */
	public void setPageNumber(String pageNumber);

	/**
	 * Returns the picture number of this edition.
	 *
	 * @return the picture number of this edition
	 */
	@AutoEscape
	public String getPictureNumber();

	/**
	 * Sets the picture number of this edition.
	 *
	 * @param pictureNumber the picture number of this edition
	 */
	public void setPictureNumber(String pictureNumber);

	/**
	 * Returns the publication date of this edition.
	 *
	 * @return the publication date of this edition
	 */
	public Date getPublicationDate();

	/**
	 * Sets the publication date of this edition.
	 *
	 * @param publicationDate the publication date of this edition
	 */
	public void setPublicationDate(Date publicationDate);

	/**
	 * Returns the image ID of this edition.
	 *
	 * @return the image ID of this edition
	 */
	public Long getImageId();

	/**
	 * Sets the image ID of this edition.
	 *
	 * @param imageId the image ID of this edition
	 */
	public void setImageId(Long imageId);

	/**
	 * Returns the file ID of this edition.
	 *
	 * @return the file ID of this edition
	 */
	public String getFileId();

	/**
	 * Returns the localized file ID of this edition in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized file ID of this edition
	 */
	@AutoEscape
	public String getFileId(Locale locale);

	/**
	 * Returns the localized file ID of this edition in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized file ID of this edition. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getFileId(Locale locale, boolean useDefault);

	/**
	 * Returns the localized file ID of this edition in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized file ID of this edition
	 */
	@AutoEscape
	public String getFileId(String languageId);

	/**
	 * Returns the localized file ID of this edition in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized file ID of this edition
	 */
	@AutoEscape
	public String getFileId(String languageId, boolean useDefault);

	@AutoEscape
	public String getFileIdCurrentLanguageId();

	@AutoEscape
	public String getFileIdCurrentValue();

	/**
	 * Returns a map of the locales and localized file IDs of this edition.
	 *
	 * @return the locales and localized file IDs of this edition
	 */
	public Map<Locale, String> getFileIdMap();

	/**
	 * Sets the file ID of this edition.
	 *
	 * @param fileId the file ID of this edition
	 */
	public void setFileId(String fileId);

	/**
	 * Sets the localized file ID of this edition in the language.
	 *
	 * @param fileId the localized file ID of this edition
	 * @param locale the locale of the language
	 */
	public void setFileId(String fileId, Locale locale);

	/**
	 * Sets the localized file ID of this edition in the language, and sets the default locale.
	 *
	 * @param fileId the localized file ID of this edition
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setFileId(String fileId, Locale locale, Locale defaultLocale);

	public void setFileIdCurrentLanguageId(String languageId);

	/**
	 * Sets the localized file IDs of this edition from the map of locales and localized file IDs.
	 *
	 * @param fileIdMap the locales and localized file IDs of this edition
	 */
	public void setFileIdMap(Map<Locale, String> fileIdMap);

	/**
	 * Sets the localized file IDs of this edition from the map of locales and localized file IDs, and sets the default locale.
	 *
	 * @param fileIdMap the locales and localized file IDs of this edition
	 * @param defaultLocale the default locale
	 */
	public void setFileIdMap(
		Map<Locale, String> fileIdMap, Locale defaultLocale);

	/**
	 * Returns <code>true</code> if this edition is approved.
	 *
	 * @return <code>true</code> if this edition is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this edition is denied.
	 *
	 * @return <code>true</code> if this edition is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this edition is a draft.
	 *
	 * @return <code>true</code> if this edition is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this edition is expired.
	 *
	 * @return <code>true</code> if this edition is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this edition is inactive.
	 *
	 * @return <code>true</code> if this edition is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this edition is incomplete.
	 *
	 * @return <code>true</code> if this edition is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this edition is pending.
	 *
	 * @return <code>true</code> if this edition is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this edition is scheduled.
	 *
	 * @return <code>true</code> if this edition is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled();

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
	public Edition cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}