/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Campaign}.
 * </p>
 *
 * @author BenjaminBini
 * @see Campaign
 * @generated
 */
public class CampaignWrapper
	extends BaseModelWrapper<Campaign>
	implements Campaign, ModelWrapper<Campaign> {

	public CampaignWrapper(Campaign campaign) {
		super(campaign);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("campaignId", getCampaignId());
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
		attributes.put("defaultImageId", getDefaultImageId());
		attributes.put("defaultImageCopyright", getDefaultImageCopyright());
		attributes.put("managersIds", getManagersIds());
		attributes.put("exportEnabled", getExportEnabled());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long campaignId = (Long)attributes.get("campaignId");

		if (campaignId != null) {
			setCampaignId(campaignId);
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

		Long defaultImageId = (Long)attributes.get("defaultImageId");

		if (defaultImageId != null) {
			setDefaultImageId(defaultImageId);
		}

		String defaultImageCopyright = (String)attributes.get(
			"defaultImageCopyright");

		if (defaultImageCopyright != null) {
			setDefaultImageCopyright(defaultImageCopyright);
		}

		String managersIds = (String)attributes.get("managersIds");

		if (managersIds != null) {
			setManagersIds(managersIds);
		}

		Boolean exportEnabled = (Boolean)attributes.get("exportEnabled");

		if (exportEnabled != null) {
			setExportEnabled(exportEnabled);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}
	}

	@Override
	public Campaign cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Génère l'export et place le fichier dans le dossier d'import des
	 * événements
	 */
	@Override
	public void export() {
		model.export();
	}

	/**
	 * Génère l'export JSON
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONObject generateExport() {
		return model.generateExport();
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
	 * Returns the campaign ID of this campaign.
	 *
	 * @return the campaign ID of this campaign
	 */
	@Override
	public long getCampaignId() {
		return model.getCampaignId();
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
	 * Returns the company ID of this campaign.
	 *
	 * @return the company ID of this campaign
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this campaign.
	 *
	 * @return the create date of this campaign
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the default image copyright of this campaign.
	 *
	 * @return the default image copyright of this campaign
	 */
	@Override
	public String getDefaultImageCopyright() {
		return model.getDefaultImageCopyright();
	}

	/**
	 * Returns the localized default image copyright of this campaign in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized default image copyright of this campaign
	 */
	@Override
	public String getDefaultImageCopyright(java.util.Locale locale) {
		return model.getDefaultImageCopyright(locale);
	}

	/**
	 * Returns the localized default image copyright of this campaign in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized default image copyright of this campaign. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getDefaultImageCopyright(
		java.util.Locale locale, boolean useDefault) {

		return model.getDefaultImageCopyright(locale, useDefault);
	}

	/**
	 * Returns the localized default image copyright of this campaign in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized default image copyright of this campaign
	 */
	@Override
	public String getDefaultImageCopyright(String languageId) {
		return model.getDefaultImageCopyright(languageId);
	}

	/**
	 * Returns the localized default image copyright of this campaign in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized default image copyright of this campaign
	 */
	@Override
	public String getDefaultImageCopyright(
		String languageId, boolean useDefault) {

		return model.getDefaultImageCopyright(languageId, useDefault);
	}

	@Override
	public String getDefaultImageCopyrightCurrentLanguageId() {
		return model.getDefaultImageCopyrightCurrentLanguageId();
	}

	@Override
	public String getDefaultImageCopyrightCurrentValue() {
		return model.getDefaultImageCopyrightCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized default image copyrights of this campaign.
	 *
	 * @return the locales and localized default image copyrights of this campaign
	 */
	@Override
	public Map<java.util.Locale, String> getDefaultImageCopyrightMap() {
		return model.getDefaultImageCopyrightMap();
	}

	/**
	 * Returns the default image ID of this campaign.
	 *
	 * @return the default image ID of this campaign
	 */
	@Override
	public long getDefaultImageId() {
		return model.getDefaultImageId();
	}

	/**
	 * Retourne l'URL de l'image à partir de l'id du DLFileEntry
	 */
	@Override
	public String getDefaultImageURL() {
		return model.getDefaultImageURL();
	}

	@Override
	public String getDefaultLanguageId() {
		return model.getDefaultLanguageId();
	}

	/**
	 * Returns the end date of this campaign.
	 *
	 * @return the end date of this campaign
	 */
	@Override
	public Date getEndDate() {
		return model.getEndDate();
	}

	/**
	 * Retourne la liste des événements de la campagne
	 */
	@Override
	public java.util.List<CampaignEvent> getEvents() {
		return model.getEvents();
	}

	/**
	 * Returns the export enabled of this campaign.
	 *
	 * @return the export enabled of this campaign
	 */
	@Override
	public Boolean getExportEnabled() {
		return model.getExportEnabled();
	}

	/**
	 * Returns the group ID of this campaign.
	 *
	 * @return the group ID of this campaign
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the last publish date of this campaign.
	 *
	 * @return the last publish date of this campaign
	 */
	@Override
	public Date getLastPublishDate() {
		return model.getLastPublishDate();
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.model.User> getManagers() {
		return model.getManagers();
	}

	/**
	 * Returns the managers IDs of this campaign.
	 *
	 * @return the managers IDs of this campaign
	 */
	@Override
	public String getManagersIds() {
		return model.getManagersIds();
	}

	/**
	 * Returns the modified date of this campaign.
	 *
	 * @return the modified date of this campaign
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this campaign.
	 *
	 * @return the primary key of this campaign
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the start date of this campaign.
	 *
	 * @return the start date of this campaign
	 */
	@Override
	public Date getStartDate() {
		return model.getStartDate();
	}

	/**
	 * Returns the status of this campaign.
	 *
	 * @return the status of this campaign
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this campaign.
	 *
	 * @return the status by user ID of this campaign
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this campaign.
	 *
	 * @return the status by user name of this campaign
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this campaign.
	 *
	 * @return the status by user uuid of this campaign
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this campaign.
	 *
	 * @return the status date of this campaign
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Retourne les themes de la campagne
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getThemes() {

		return model.getThemes();
	}

	/**
	 * Returns the title of this campaign.
	 *
	 * @return the title of this campaign
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the localized title of this campaign in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized title of this campaign
	 */
	@Override
	public String getTitle(java.util.Locale locale) {
		return model.getTitle(locale);
	}

	/**
	 * Returns the localized title of this campaign in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this campaign. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getTitle(java.util.Locale locale, boolean useDefault) {
		return model.getTitle(locale, useDefault);
	}

	/**
	 * Returns the localized title of this campaign in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized title of this campaign
	 */
	@Override
	public String getTitle(String languageId) {
		return model.getTitle(languageId);
	}

	/**
	 * Returns the localized title of this campaign in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this campaign
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
	 * Returns a map of the locales and localized titles of this campaign.
	 *
	 * @return the locales and localized titles of this campaign
	 */
	@Override
	public Map<java.util.Locale, String> getTitleMap() {
		return model.getTitleMap();
	}

	/**
	 * Retourne les types de la campagne
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getTypes() {

		return model.getTypes();
	}

	/**
	 * Returns the user ID of this campaign.
	 *
	 * @return the user ID of this campaign
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this campaign.
	 *
	 * @return the user name of this campaign
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this campaign.
	 *
	 * @return the user uuid of this campaign
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this campaign.
	 *
	 * @return the uuid of this campaign
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this campaign is approved.
	 *
	 * @return <code>true</code> if this campaign is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this campaign is denied.
	 *
	 * @return <code>true</code> if this campaign is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this campaign is a draft.
	 *
	 * @return <code>true</code> if this campaign is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this campaign is expired.
	 *
	 * @return <code>true</code> if this campaign is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this campaign is inactive.
	 *
	 * @return <code>true</code> if this campaign is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this campaign is incomplete.
	 *
	 * @return <code>true</code> if this campaign is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Retourne true si l'utilisateur passé en paramètre est manager de la
	 * campagne
	 */
	@Override
	public boolean isManagedByUser(long userId) {
		return model.isManagedByUser(userId);
	}

	/**
	 * Returns <code>true</code> if this campaign is pending.
	 *
	 * @return <code>true</code> if this campaign is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this campaign is scheduled.
	 *
	 * @return <code>true</code> if this campaign is scheduled; <code>false</code> otherwise
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
	 * Sets the campaign ID of this campaign.
	 *
	 * @param campaignId the campaign ID of this campaign
	 */
	@Override
	public void setCampaignId(long campaignId) {
		model.setCampaignId(campaignId);
	}

	/**
	 * Sets the company ID of this campaign.
	 *
	 * @param companyId the company ID of this campaign
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this campaign.
	 *
	 * @param createDate the create date of this campaign
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the default image copyright of this campaign.
	 *
	 * @param defaultImageCopyright the default image copyright of this campaign
	 */
	@Override
	public void setDefaultImageCopyright(String defaultImageCopyright) {
		model.setDefaultImageCopyright(defaultImageCopyright);
	}

	/**
	 * Sets the localized default image copyright of this campaign in the language.
	 *
	 * @param defaultImageCopyright the localized default image copyright of this campaign
	 * @param locale the locale of the language
	 */
	@Override
	public void setDefaultImageCopyright(
		String defaultImageCopyright, java.util.Locale locale) {

		model.setDefaultImageCopyright(defaultImageCopyright, locale);
	}

	/**
	 * Sets the localized default image copyright of this campaign in the language, and sets the default locale.
	 *
	 * @param defaultImageCopyright the localized default image copyright of this campaign
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDefaultImageCopyright(
		String defaultImageCopyright, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setDefaultImageCopyright(
			defaultImageCopyright, locale, defaultLocale);
	}

	@Override
	public void setDefaultImageCopyrightCurrentLanguageId(String languageId) {
		model.setDefaultImageCopyrightCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized default image copyrights of this campaign from the map of locales and localized default image copyrights.
	 *
	 * @param defaultImageCopyrightMap the locales and localized default image copyrights of this campaign
	 */
	@Override
	public void setDefaultImageCopyrightMap(
		Map<java.util.Locale, String> defaultImageCopyrightMap) {

		model.setDefaultImageCopyrightMap(defaultImageCopyrightMap);
	}

	/**
	 * Sets the localized default image copyrights of this campaign from the map of locales and localized default image copyrights, and sets the default locale.
	 *
	 * @param defaultImageCopyrightMap the locales and localized default image copyrights of this campaign
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDefaultImageCopyrightMap(
		Map<java.util.Locale, String> defaultImageCopyrightMap,
		java.util.Locale defaultLocale) {

		model.setDefaultImageCopyrightMap(
			defaultImageCopyrightMap, defaultLocale);
	}

	/**
	 * Sets the default image ID of this campaign.
	 *
	 * @param defaultImageId the default image ID of this campaign
	 */
	@Override
	public void setDefaultImageId(long defaultImageId) {
		model.setDefaultImageId(defaultImageId);
	}

	/**
	 * Sets the end date of this campaign.
	 *
	 * @param endDate the end date of this campaign
	 */
	@Override
	public void setEndDate(Date endDate) {
		model.setEndDate(endDate);
	}

	/**
	 * Sets the export enabled of this campaign.
	 *
	 * @param exportEnabled the export enabled of this campaign
	 */
	@Override
	public void setExportEnabled(Boolean exportEnabled) {
		model.setExportEnabled(exportEnabled);
	}

	/**
	 * Sets the group ID of this campaign.
	 *
	 * @param groupId the group ID of this campaign
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the last publish date of this campaign.
	 *
	 * @param lastPublishDate the last publish date of this campaign
	 */
	@Override
	public void setLastPublishDate(Date lastPublishDate) {
		model.setLastPublishDate(lastPublishDate);
	}

	/**
	 * Sets the managers IDs of this campaign.
	 *
	 * @param managersIds the managers IDs of this campaign
	 */
	@Override
	public void setManagersIds(String managersIds) {
		model.setManagersIds(managersIds);
	}

	/**
	 * Sets the modified date of this campaign.
	 *
	 * @param modifiedDate the modified date of this campaign
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this campaign.
	 *
	 * @param primaryKey the primary key of this campaign
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the start date of this campaign.
	 *
	 * @param startDate the start date of this campaign
	 */
	@Override
	public void setStartDate(Date startDate) {
		model.setStartDate(startDate);
	}

	/**
	 * Sets the status of this campaign.
	 *
	 * @param status the status of this campaign
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this campaign.
	 *
	 * @param statusByUserId the status by user ID of this campaign
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this campaign.
	 *
	 * @param statusByUserName the status by user name of this campaign
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this campaign.
	 *
	 * @param statusByUserUuid the status by user uuid of this campaign
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this campaign.
	 *
	 * @param statusDate the status date of this campaign
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the title of this campaign.
	 *
	 * @param title the title of this campaign
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the localized title of this campaign in the language.
	 *
	 * @param title the localized title of this campaign
	 * @param locale the locale of the language
	 */
	@Override
	public void setTitle(String title, java.util.Locale locale) {
		model.setTitle(title, locale);
	}

	/**
	 * Sets the localized title of this campaign in the language, and sets the default locale.
	 *
	 * @param title the localized title of this campaign
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
	 * Sets the localized titles of this campaign from the map of locales and localized titles.
	 *
	 * @param titleMap the locales and localized titles of this campaign
	 */
	@Override
	public void setTitleMap(Map<java.util.Locale, String> titleMap) {
		model.setTitleMap(titleMap);
	}

	/**
	 * Sets the localized titles of this campaign from the map of locales and localized titles, and sets the default locale.
	 *
	 * @param titleMap the locales and localized titles of this campaign
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setTitleMap(
		Map<java.util.Locale, String> titleMap,
		java.util.Locale defaultLocale) {

		model.setTitleMap(titleMap, defaultLocale);
	}

	/**
	 * Sets the user ID of this campaign.
	 *
	 * @param userId the user ID of this campaign
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this campaign.
	 *
	 * @param userName the user name of this campaign
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this campaign.
	 *
	 * @param userUuid the user uuid of this campaign
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this campaign.
	 *
	 * @param uuid the uuid of this campaign
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
	protected CampaignWrapper wrap(Campaign campaign) {
		return new CampaignWrapper(campaign);
	}

}