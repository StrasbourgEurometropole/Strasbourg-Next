/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.link.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Link}.
 * </p>
 *
 * @author BenjaminBini
 * @see Link
 * @generated
 */
public class LinkWrapper
	extends BaseModelWrapper<Link> implements Link, ModelWrapper<Link> {

	public LinkWrapper(Link link) {
		super(link);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("linkId", getLinkId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("lastPublishDate", getLastPublishDate());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("title", getTitle());
		attributes.put("URL", getURL());
		attributes.put("hoverText", getHoverText());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long linkId = (Long)attributes.get("linkId");

		if (linkId != null) {
			setLinkId(linkId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Date lastPublishDate = (Date)attributes.get("lastPublishDate");

		if (lastPublishDate != null) {
			setLastPublishDate(lastPublishDate);
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

		String URL = (String)attributes.get("URL");

		if (URL != null) {
			setURL(URL);
		}

		String hoverText = (String)attributes.get("hoverText");

		if (hoverText != null) {
			setHoverText(hoverText);
		}
	}

	@Override
	public Link cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Retourne l'AssetEntry rattaché cet item
	 */
	@Override
	public com.liferay.asset.kernel.model.AssetEntry getAssetEntry() {
		return model.getAssetEntry();
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Renvoie la liste des AssetCategory rattachées à cet item (via
	 * l'assetEntry)
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCategories() {

		return model.getCategories();
	}

	/**
	 * Returns the company ID of this link.
	 *
	 * @return the company ID of this link
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this link.
	 *
	 * @return the create date of this link
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	@Override
	public String getDefaultLanguageId() {
		return model.getDefaultLanguageId();
	}

	/**
	 * Returns the group ID of this link.
	 *
	 * @return the group ID of this link
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the hover text of this link.
	 *
	 * @return the hover text of this link
	 */
	@Override
	public String getHoverText() {
		return model.getHoverText();
	}

	/**
	 * Returns the localized hover text of this link in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized hover text of this link
	 */
	@Override
	public String getHoverText(java.util.Locale locale) {
		return model.getHoverText(locale);
	}

	/**
	 * Returns the localized hover text of this link in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized hover text of this link. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getHoverText(java.util.Locale locale, boolean useDefault) {
		return model.getHoverText(locale, useDefault);
	}

	/**
	 * Returns the localized hover text of this link in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized hover text of this link
	 */
	@Override
	public String getHoverText(String languageId) {
		return model.getHoverText(languageId);
	}

	/**
	 * Returns the localized hover text of this link in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized hover text of this link
	 */
	@Override
	public String getHoverText(String languageId, boolean useDefault) {
		return model.getHoverText(languageId, useDefault);
	}

	@Override
	public String getHoverTextCurrentLanguageId() {
		return model.getHoverTextCurrentLanguageId();
	}

	@Override
	public String getHoverTextCurrentValue() {
		return model.getHoverTextCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized hover texts of this link.
	 *
	 * @return the locales and localized hover texts of this link
	 */
	@Override
	public Map<java.util.Locale, String> getHoverTextMap() {
		return model.getHoverTextMap();
	}

	/**
	 * Returns the last publish date of this link.
	 *
	 * @return the last publish date of this link
	 */
	@Override
	public Date getLastPublishDate() {
		return model.getLastPublishDate();
	}

	/**
	 * Returns the link ID of this link.
	 *
	 * @return the link ID of this link
	 */
	@Override
	public long getLinkId() {
		return model.getLinkId();
	}

	/**
	 * Renvoie la version live du lien, si elle existe
	 */
	@Override
	public eu.strasbourg.service.link.model.Link getLiveVersion() {
		return model.getLiveVersion();
	}

	/**
	 * Returns the modified date of this link.
	 *
	 * @return the modified date of this link
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this link.
	 *
	 * @return the primary key of this link
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this link.
	 *
	 * @return the status of this link
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this link.
	 *
	 * @return the status by user ID of this link
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this link.
	 *
	 * @return the status by user name of this link
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this link.
	 *
	 * @return the status by user uuid of this link
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this link.
	 *
	 * @return the status date of this link
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the title of this link.
	 *
	 * @return the title of this link
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the localized title of this link in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized title of this link
	 */
	@Override
	public String getTitle(java.util.Locale locale) {
		return model.getTitle(locale);
	}

	/**
	 * Returns the localized title of this link in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this link. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getTitle(java.util.Locale locale, boolean useDefault) {
		return model.getTitle(locale, useDefault);
	}

	/**
	 * Returns the localized title of this link in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized title of this link
	 */
	@Override
	public String getTitle(String languageId) {
		return model.getTitle(languageId);
	}

	/**
	 * Returns the localized title of this link in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this link
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
	 * Returns a map of the locales and localized titles of this link.
	 *
	 * @return the locales and localized titles of this link
	 */
	@Override
	public Map<java.util.Locale, String> getTitleMap() {
		return model.getTitleMap();
	}

	/**
	 * Returns the url of this link.
	 *
	 * @return the url of this link
	 */
	@Override
	public String getURL() {
		return model.getURL();
	}

	/**
	 * Returns the localized url of this link in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized url of this link
	 */
	@Override
	public String getURL(java.util.Locale locale) {
		return model.getURL(locale);
	}

	/**
	 * Returns the localized url of this link in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized url of this link. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getURL(java.util.Locale locale, boolean useDefault) {
		return model.getURL(locale, useDefault);
	}

	/**
	 * Returns the localized url of this link in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized url of this link
	 */
	@Override
	public String getURL(String languageId) {
		return model.getURL(languageId);
	}

	/**
	 * Returns the localized url of this link in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized url of this link
	 */
	@Override
	public String getURL(String languageId, boolean useDefault) {
		return model.getURL(languageId, useDefault);
	}

	@Override
	public String getURLCurrentLanguageId() {
		return model.getURLCurrentLanguageId();
	}

	@Override
	public String getURLCurrentValue() {
		return model.getURLCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized urls of this link.
	 *
	 * @return the locales and localized urls of this link
	 */
	@Override
	public Map<java.util.Locale, String> getURLMap() {
		return model.getURLMap();
	}

	/**
	 * Returns the user ID of this link.
	 *
	 * @return the user ID of this link
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this link.
	 *
	 * @return the user name of this link
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this link.
	 *
	 * @return the user uuid of this link
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this link.
	 *
	 * @return the uuid of this link
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this link is approved.
	 *
	 * @return <code>true</code> if this link is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this link is denied.
	 *
	 * @return <code>true</code> if this link is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this link is a draft.
	 *
	 * @return <code>true</code> if this link is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this link is expired.
	 *
	 * @return <code>true</code> if this link is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this link is inactive.
	 *
	 * @return <code>true</code> if this link is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this link is incomplete.
	 *
	 * @return <code>true</code> if this link is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this link is pending.
	 *
	 * @return <code>true</code> if this link is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this link is scheduled.
	 *
	 * @return <code>true</code> if this link is scheduled; <code>false</code> otherwise
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
	 * Sets the company ID of this link.
	 *
	 * @param companyId the company ID of this link
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this link.
	 *
	 * @param createDate the create date of this link
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this link.
	 *
	 * @param groupId the group ID of this link
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the hover text of this link.
	 *
	 * @param hoverText the hover text of this link
	 */
	@Override
	public void setHoverText(String hoverText) {
		model.setHoverText(hoverText);
	}

	/**
	 * Sets the localized hover text of this link in the language.
	 *
	 * @param hoverText the localized hover text of this link
	 * @param locale the locale of the language
	 */
	@Override
	public void setHoverText(String hoverText, java.util.Locale locale) {
		model.setHoverText(hoverText, locale);
	}

	/**
	 * Sets the localized hover text of this link in the language, and sets the default locale.
	 *
	 * @param hoverText the localized hover text of this link
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setHoverText(
		String hoverText, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setHoverText(hoverText, locale, defaultLocale);
	}

	@Override
	public void setHoverTextCurrentLanguageId(String languageId) {
		model.setHoverTextCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized hover texts of this link from the map of locales and localized hover texts.
	 *
	 * @param hoverTextMap the locales and localized hover texts of this link
	 */
	@Override
	public void setHoverTextMap(Map<java.util.Locale, String> hoverTextMap) {
		model.setHoverTextMap(hoverTextMap);
	}

	/**
	 * Sets the localized hover texts of this link from the map of locales and localized hover texts, and sets the default locale.
	 *
	 * @param hoverTextMap the locales and localized hover texts of this link
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setHoverTextMap(
		Map<java.util.Locale, String> hoverTextMap,
		java.util.Locale defaultLocale) {

		model.setHoverTextMap(hoverTextMap, defaultLocale);
	}

	/**
	 * Sets the last publish date of this link.
	 *
	 * @param lastPublishDate the last publish date of this link
	 */
	@Override
	public void setLastPublishDate(Date lastPublishDate) {
		model.setLastPublishDate(lastPublishDate);
	}

	/**
	 * Sets the link ID of this link.
	 *
	 * @param linkId the link ID of this link
	 */
	@Override
	public void setLinkId(long linkId) {
		model.setLinkId(linkId);
	}

	/**
	 * Sets the modified date of this link.
	 *
	 * @param modifiedDate the modified date of this link
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this link.
	 *
	 * @param primaryKey the primary key of this link
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this link.
	 *
	 * @param status the status of this link
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this link.
	 *
	 * @param statusByUserId the status by user ID of this link
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this link.
	 *
	 * @param statusByUserName the status by user name of this link
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this link.
	 *
	 * @param statusByUserUuid the status by user uuid of this link
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this link.
	 *
	 * @param statusDate the status date of this link
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the title of this link.
	 *
	 * @param title the title of this link
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the localized title of this link in the language.
	 *
	 * @param title the localized title of this link
	 * @param locale the locale of the language
	 */
	@Override
	public void setTitle(String title, java.util.Locale locale) {
		model.setTitle(title, locale);
	}

	/**
	 * Sets the localized title of this link in the language, and sets the default locale.
	 *
	 * @param title the localized title of this link
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
	 * Sets the localized titles of this link from the map of locales and localized titles.
	 *
	 * @param titleMap the locales and localized titles of this link
	 */
	@Override
	public void setTitleMap(Map<java.util.Locale, String> titleMap) {
		model.setTitleMap(titleMap);
	}

	/**
	 * Sets the localized titles of this link from the map of locales and localized titles, and sets the default locale.
	 *
	 * @param titleMap the locales and localized titles of this link
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setTitleMap(
		Map<java.util.Locale, String> titleMap,
		java.util.Locale defaultLocale) {

		model.setTitleMap(titleMap, defaultLocale);
	}

	/**
	 * Sets the url of this link.
	 *
	 * @param URL the url of this link
	 */
	@Override
	public void setURL(String URL) {
		model.setURL(URL);
	}

	/**
	 * Sets the localized url of this link in the language.
	 *
	 * @param URL the localized url of this link
	 * @param locale the locale of the language
	 */
	@Override
	public void setURL(String URL, java.util.Locale locale) {
		model.setURL(URL, locale);
	}

	/**
	 * Sets the localized url of this link in the language, and sets the default locale.
	 *
	 * @param URL the localized url of this link
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setURL(
		String URL, java.util.Locale locale, java.util.Locale defaultLocale) {

		model.setURL(URL, locale, defaultLocale);
	}

	@Override
	public void setURLCurrentLanguageId(String languageId) {
		model.setURLCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized urls of this link from the map of locales and localized urls.
	 *
	 * @param URLMap the locales and localized urls of this link
	 */
	@Override
	public void setURLMap(Map<java.util.Locale, String> URLMap) {
		model.setURLMap(URLMap);
	}

	/**
	 * Sets the localized urls of this link from the map of locales and localized urls, and sets the default locale.
	 *
	 * @param URLMap the locales and localized urls of this link
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setURLMap(
		Map<java.util.Locale, String> URLMap, java.util.Locale defaultLocale) {

		model.setURLMap(URLMap, defaultLocale);
	}

	/**
	 * Sets the user ID of this link.
	 *
	 * @param userId the user ID of this link
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this link.
	 *
	 * @param userName the user name of this link
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this link.
	 *
	 * @param userUuid the user uuid of this link
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this link.
	 *
	 * @param uuid the uuid of this link
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
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected LinkWrapper wrap(Link link) {
		return new LinkWrapper(link);
	}

}