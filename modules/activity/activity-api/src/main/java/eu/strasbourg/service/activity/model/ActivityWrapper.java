/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.activity.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Activity}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Activity
 * @generated
 */
public class ActivityWrapper
	extends BaseModelWrapper<Activity>
	implements Activity, ModelWrapper<Activity> {

	public ActivityWrapper(Activity activity) {
		super(activity);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("activityId", getActivityId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("order", getOrder());
		attributes.put("videosIds", getVideosIds());
		attributes.put("imageId", getImageId());
		attributes.put("imagesIds", getImagesIds());
		attributes.put("filesIds", getFilesIds());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long activityId = (Long)attributes.get("activityId");

		if (activityId != null) {
			setActivityId(activityId);
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

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Integer order = (Integer)attributes.get("order");

		if (order != null) {
			setOrder(order);
		}

		String videosIds = (String)attributes.get("videosIds");

		if (videosIds != null) {
			setVideosIds(videosIds);
		}

		Long imageId = (Long)attributes.get("imageId");

		if (imageId != null) {
			setImageId(imageId);
		}

		String imagesIds = (String)attributes.get("imagesIds");

		if (imagesIds != null) {
			setImagesIds(imagesIds);
		}

		String filesIds = (String)attributes.get("filesIds");

		if (filesIds != null) {
			setFilesIds(filesIds);
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
	}

	@Override
	public Activity cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Retourne les cours de l'activité
	 */
	@Override
	public java.util.List<eu.strasbourg.service.activity.model.ActivityCourse>
		getActivityCourses() {

		return model.getActivityCourses();
	}

	/**
	 * Returns the activity ID of this activity.
	 *
	 * @return the activity ID of this activity
	 */
	@Override
	public long getActivityId() {
		return model.getActivityId();
	}

	/**
	 * Retourne l'AssetEntry rattaché à cette entité
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
	 * Renvoie la liste des AssetCategory rattachées à cette entité (via
	 * l'assetEntry)
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCategories() {

		return model.getCategories();
	}

	/**
	 * Returns the company ID of this activity.
	 *
	 * @return the company ID of this activity
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this activity.
	 *
	 * @return the create date of this activity
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
	 * Returns the description of this activity.
	 *
	 * @return the description of this activity
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the localized description of this activity in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description of this activity
	 */
	@Override
	public String getDescription(java.util.Locale locale) {
		return model.getDescription(locale);
	}

	/**
	 * Returns the localized description of this activity in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this activity. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getDescription(java.util.Locale locale, boolean useDefault) {
		return model.getDescription(locale, useDefault);
	}

	/**
	 * Returns the localized description of this activity in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description of this activity
	 */
	@Override
	public String getDescription(String languageId) {
		return model.getDescription(languageId);
	}

	/**
	 * Returns the localized description of this activity in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this activity
	 */
	@Override
	public String getDescription(String languageId, boolean useDefault) {
		return model.getDescription(languageId, useDefault);
	}

	@Override
	public String getDescriptionCurrentLanguageId() {
		return model.getDescriptionCurrentLanguageId();
	}

	@Override
	public String getDescriptionCurrentValue() {
		return model.getDescriptionCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized descriptions of this activity.
	 *
	 * @return the locales and localized descriptions of this activity
	 */
	@Override
	public Map<java.util.Locale, String> getDescriptionMap() {
		return model.getDescriptionMap();
	}

	/**
	 * Returns the files IDs of this activity.
	 *
	 * @return the files IDs of this activity
	 */
	@Override
	public String getFilesIds() {
		return model.getFilesIds();
	}

	/**
	 * Retourne la liste des URLs des documents
	 */
	@Override
	public java.util.List<String> getFilesURLs() {
		return model.getFilesURLs();
	}

	/**
	 * Returns the group ID of this activity.
	 *
	 * @return the group ID of this activity
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the image ID of this activity.
	 *
	 * @return the image ID of this activity
	 */
	@Override
	public long getImageId() {
		return model.getImageId();
	}

	/**
	 * Returns the images IDs of this activity.
	 *
	 * @return the images IDs of this activity
	 */
	@Override
	public String getImagesIds() {
		return model.getImagesIds();
	}

	/**
	 * Retourne la liste des URL publiques des images additionnelles
	 */
	@Override
	public java.util.List<String> getImagesURLs() {
		return model.getImagesURLs();
	}

	/**
	 * Retourne l'URL de l'image
	 */
	@Override
	public String getImageURL() {
		return model.getImageURL();
	}

	/**
	 * Retourne la version live de cette entité
	 *
	 * @return
	 */
	@Override
	public eu.strasbourg.service.activity.model.Activity getLiveVersion() {
		return model.getLiveVersion();
	}

	/**
	 * Returns the modified date of this activity.
	 *
	 * @return the modified date of this activity
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the order of this activity.
	 *
	 * @return the order of this activity
	 */
	@Override
	public int getOrder() {
		return model.getOrder();
	}

	/**
	 * Returns the primary key of this activity.
	 *
	 * @return the primary key of this activity
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Retourne les cours publiés du lieu
	 */
	@Override
	public java.util.List<eu.strasbourg.service.activity.model.ActivityCourse>
		getPublishedActivityCourses() {

		return model.getPublishedActivityCourses();
	}

	/**
	 * Returns the status of this activity.
	 *
	 * @return the status of this activity
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this activity.
	 *
	 * @return the status by user ID of this activity
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this activity.
	 *
	 * @return the status by user name of this activity
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this activity.
	 *
	 * @return the status by user uuid of this activity
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this activity.
	 *
	 * @return the status date of this activity
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the title of this activity.
	 *
	 * @return the title of this activity
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the localized title of this activity in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized title of this activity
	 */
	@Override
	public String getTitle(java.util.Locale locale) {
		return model.getTitle(locale);
	}

	/**
	 * Returns the localized title of this activity in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this activity. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getTitle(java.util.Locale locale, boolean useDefault) {
		return model.getTitle(locale, useDefault);
	}

	/**
	 * Returns the localized title of this activity in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized title of this activity
	 */
	@Override
	public String getTitle(String languageId) {
		return model.getTitle(languageId);
	}

	/**
	 * Returns the localized title of this activity in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this activity
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
	 * Returns a map of the locales and localized titles of this activity.
	 *
	 * @return the locales and localized titles of this activity
	 */
	@Override
	public Map<java.util.Locale, String> getTitleMap() {
		return model.getTitleMap();
	}

	/**
	 * Retourne les types de l'activité
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getTypes() {

		return model.getTypes();
	}

	/**
	 * Retourne le texte à afficher pour les types de l'activité
	 */
	@Override
	public String getTypesLabel(java.util.Locale locale) {
		return model.getTypesLabel(locale);
	}

	/**
	 * Returns the user ID of this activity.
	 *
	 * @return the user ID of this activity
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this activity.
	 *
	 * @return the user name of this activity
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this activity.
	 *
	 * @return the user uuid of this activity
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this activity.
	 *
	 * @return the uuid of this activity
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Retourne la liste des vidéos
	 */
	@Override
	public java.util.List<eu.strasbourg.service.video.model.Video> getVideos() {
		return model.getVideos();
	}

	/**
	 * Returns the videos IDs of this activity.
	 *
	 * @return the videos IDs of this activity
	 */
	@Override
	public String getVideosIds() {
		return model.getVideosIds();
	}

	/**
	 * Returns <code>true</code> if this activity is approved.
	 *
	 * @return <code>true</code> if this activity is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this activity is denied.
	 *
	 * @return <code>true</code> if this activity is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this activity is a draft.
	 *
	 * @return <code>true</code> if this activity is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this activity is expired.
	 *
	 * @return <code>true</code> if this activity is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this activity is inactive.
	 *
	 * @return <code>true</code> if this activity is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this activity is incomplete.
	 *
	 * @return <code>true</code> if this activity is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this activity is pending.
	 *
	 * @return <code>true</code> if this activity is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this activity is scheduled.
	 *
	 * @return <code>true</code> if this activity is scheduled; <code>false</code> otherwise
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
	 * Sets the activity ID of this activity.
	 *
	 * @param activityId the activity ID of this activity
	 */
	@Override
	public void setActivityId(long activityId) {
		model.setActivityId(activityId);
	}

	/**
	 * Sets the company ID of this activity.
	 *
	 * @param companyId the company ID of this activity
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this activity.
	 *
	 * @param createDate the create date of this activity
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this activity.
	 *
	 * @param description the description of this activity
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the localized description of this activity in the language.
	 *
	 * @param description the localized description of this activity
	 * @param locale the locale of the language
	 */
	@Override
	public void setDescription(String description, java.util.Locale locale) {
		model.setDescription(description, locale);
	}

	/**
	 * Sets the localized description of this activity in the language, and sets the default locale.
	 *
	 * @param description the localized description of this activity
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDescription(
		String description, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setDescription(description, locale, defaultLocale);
	}

	@Override
	public void setDescriptionCurrentLanguageId(String languageId) {
		model.setDescriptionCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized descriptions of this activity from the map of locales and localized descriptions.
	 *
	 * @param descriptionMap the locales and localized descriptions of this activity
	 */
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, String> descriptionMap) {

		model.setDescriptionMap(descriptionMap);
	}

	/**
	 * Sets the localized descriptions of this activity from the map of locales and localized descriptions, and sets the default locale.
	 *
	 * @param descriptionMap the locales and localized descriptions of this activity
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, String> descriptionMap,
		java.util.Locale defaultLocale) {

		model.setDescriptionMap(descriptionMap, defaultLocale);
	}

	/**
	 * Sets the files IDs of this activity.
	 *
	 * @param filesIds the files IDs of this activity
	 */
	@Override
	public void setFilesIds(String filesIds) {
		model.setFilesIds(filesIds);
	}

	/**
	 * Sets the group ID of this activity.
	 *
	 * @param groupId the group ID of this activity
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the image ID of this activity.
	 *
	 * @param imageId the image ID of this activity
	 */
	@Override
	public void setImageId(long imageId) {
		model.setImageId(imageId);
	}

	/**
	 * Sets the images IDs of this activity.
	 *
	 * @param imagesIds the images IDs of this activity
	 */
	@Override
	public void setImagesIds(String imagesIds) {
		model.setImagesIds(imagesIds);
	}

	/**
	 * Sets the modified date of this activity.
	 *
	 * @param modifiedDate the modified date of this activity
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the order of this activity.
	 *
	 * @param order the order of this activity
	 */
	@Override
	public void setOrder(int order) {
		model.setOrder(order);
	}

	/**
	 * Sets the primary key of this activity.
	 *
	 * @param primaryKey the primary key of this activity
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this activity.
	 *
	 * @param status the status of this activity
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this activity.
	 *
	 * @param statusByUserId the status by user ID of this activity
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this activity.
	 *
	 * @param statusByUserName the status by user name of this activity
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this activity.
	 *
	 * @param statusByUserUuid the status by user uuid of this activity
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this activity.
	 *
	 * @param statusDate the status date of this activity
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the title of this activity.
	 *
	 * @param title the title of this activity
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the localized title of this activity in the language.
	 *
	 * @param title the localized title of this activity
	 * @param locale the locale of the language
	 */
	@Override
	public void setTitle(String title, java.util.Locale locale) {
		model.setTitle(title, locale);
	}

	/**
	 * Sets the localized title of this activity in the language, and sets the default locale.
	 *
	 * @param title the localized title of this activity
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
	 * Sets the localized titles of this activity from the map of locales and localized titles.
	 *
	 * @param titleMap the locales and localized titles of this activity
	 */
	@Override
	public void setTitleMap(Map<java.util.Locale, String> titleMap) {
		model.setTitleMap(titleMap);
	}

	/**
	 * Sets the localized titles of this activity from the map of locales and localized titles, and sets the default locale.
	 *
	 * @param titleMap the locales and localized titles of this activity
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setTitleMap(
		Map<java.util.Locale, String> titleMap,
		java.util.Locale defaultLocale) {

		model.setTitleMap(titleMap, defaultLocale);
	}

	/**
	 * Sets the user ID of this activity.
	 *
	 * @param userId the user ID of this activity
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this activity.
	 *
	 * @param userName the user name of this activity
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this activity.
	 *
	 * @param userUuid the user uuid of this activity
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this activity.
	 *
	 * @param uuid the uuid of this activity
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the videos IDs of this activity.
	 *
	 * @param videosIds the videos IDs of this activity
	 */
	@Override
	public void setVideosIds(String videosIds) {
		model.setVideosIds(videosIds);
	}

	/**
	 * Retourne la version JSON de l'activité
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
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected ActivityWrapper wrap(Activity activity) {
		return new ActivityWrapper(activity);
	}

}