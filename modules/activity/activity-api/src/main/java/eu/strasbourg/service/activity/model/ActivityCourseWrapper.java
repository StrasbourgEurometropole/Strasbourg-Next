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
 * This class is a wrapper for {@link ActivityCourse}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ActivityCourse
 * @generated
 */
public class ActivityCourseWrapper
	extends BaseModelWrapper<ActivityCourse>
	implements ActivityCourse, ModelWrapper<ActivityCourse> {

	public ActivityCourseWrapper(ActivityCourse activityCourse) {
		super(activityCourse);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("activityCourseId", getActivityCourseId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("name", getName());
		attributes.put("presentation", getPresentation());
		attributes.put("arrangements", getArrangements());
		attributes.put("price", getPrice());
		attributes.put("activityId", getActivityId());
		attributes.put("organizerId", getOrganizerId());
		attributes.put("duration", getDuration());
		attributes.put("imageId", getImageId());
		attributes.put("imageIds", getImageIds());
		attributes.put("videosIds", getVideosIds());
		attributes.put("documentsIds", getDocumentsIds());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long activityCourseId = (Long)attributes.get("activityCourseId");

		if (activityCourseId != null) {
			setActivityCourseId(activityCourseId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String presentation = (String)attributes.get("presentation");

		if (presentation != null) {
			setPresentation(presentation);
		}

		String arrangements = (String)attributes.get("arrangements");

		if (arrangements != null) {
			setArrangements(arrangements);
		}

		String price = (String)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}

		Long activityId = (Long)attributes.get("activityId");

		if (activityId != null) {
			setActivityId(activityId);
		}

		Long organizerId = (Long)attributes.get("organizerId");

		if (organizerId != null) {
			setOrganizerId(organizerId);
		}

		Integer duration = (Integer)attributes.get("duration");

		if (duration != null) {
			setDuration(duration);
		}

		Long imageId = (Long)attributes.get("imageId");

		if (imageId != null) {
			setImageId(imageId);
		}

		String imageIds = (String)attributes.get("imageIds");

		if (imageIds != null) {
			setImageIds(imageIds);
		}

		String videosIds = (String)attributes.get("videosIds");

		if (videosIds != null) {
			setVideosIds(videosIds);
		}

		String documentsIds = (String)attributes.get("documentsIds");

		if (documentsIds != null) {
			setDocumentsIds(documentsIds);
		}
	}

	@Override
	public ActivityCourse cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Retourne l'activité du cours
	 */
	@Override
	public eu.strasbourg.service.activity.model.Activity getActivity() {
		return model.getActivity();
	}

	/**
	 * Returns the activity course ID of this activity course.
	 *
	 * @return the activity course ID of this activity course
	 */
	@Override
	public long getActivityCourseId() {
		return model.getActivityCourseId();
	}

	/**
	 * Retourne les horaires par lieu du cours
	 */
	@Override
	public java.util.List
		<eu.strasbourg.service.activity.model.ActivityCoursePlace>
			getActivityCoursePlaces() {

		return model.getActivityCoursePlaces();
	}

	/**
	 * Returns the activity ID of this activity course.
	 *
	 * @return the activity ID of this activity course
	 */
	@Override
	public long getActivityId() {
		return model.getActivityId();
	}

	/**
	 * Retourne l'organisateur du cours
	 */
	@Override
	public eu.strasbourg.service.activity.model.ActivityOrganizer
		getActivityOrganizer() {

		return model.getActivityOrganizer();
	}

	/**
	 * Returns the arrangements of this activity course.
	 *
	 * @return the arrangements of this activity course
	 */
	@Override
	public String getArrangements() {
		return model.getArrangements();
	}

	/**
	 * Returns the localized arrangements of this activity course in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized arrangements of this activity course
	 */
	@Override
	public String getArrangements(java.util.Locale locale) {
		return model.getArrangements(locale);
	}

	/**
	 * Returns the localized arrangements of this activity course in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized arrangements of this activity course. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getArrangements(java.util.Locale locale, boolean useDefault) {
		return model.getArrangements(locale, useDefault);
	}

	/**
	 * Returns the localized arrangements of this activity course in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized arrangements of this activity course
	 */
	@Override
	public String getArrangements(String languageId) {
		return model.getArrangements(languageId);
	}

	/**
	 * Returns the localized arrangements of this activity course in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized arrangements of this activity course
	 */
	@Override
	public String getArrangements(String languageId, boolean useDefault) {
		return model.getArrangements(languageId, useDefault);
	}

	@Override
	public String getArrangementsCurrentLanguageId() {
		return model.getArrangementsCurrentLanguageId();
	}

	@Override
	public String getArrangementsCurrentValue() {
		return model.getArrangementsCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized arrangementses of this activity course.
	 *
	 * @return the locales and localized arrangementses of this activity course
	 */
	@Override
	public Map<java.util.Locale, String> getArrangementsMap() {
		return model.getArrangementsMap();
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
	 * Returns the company ID of this activity course.
	 *
	 * @return the company ID of this activity course
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Retourne l'affichage de l'agenda d'un cours Transformation de :
	 * ActivityCourse -> ActivityCoursePlace -> ActivityCourseSchedule ^ ^ | |
	 * Place Period
	 *
	 * En : Period -> Place -> Schedule
	 */
	@Override
	public eu.strasbourg.service.activity.model.CourseAgenda getCourseAgenda(
		long groupId, java.util.Locale locale) {

		return model.getCourseAgenda(groupId, locale);
	}

	/**
	 * Returns the create date of this activity course.
	 *
	 * @return the create date of this activity course
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
	 * Retourne une map de titre et d'URL des documents de ce cours
	 */
	@Override
	public Map<String, String> getDocuments() {
		return model.getDocuments();
	}

	/**
	 * Returns the documents IDs of this activity course.
	 *
	 * @return the documents IDs of this activity course
	 */
	@Override
	public String getDocumentsIds() {
		return model.getDocumentsIds();
	}

	/**
	 * Retourne la liste des URL des documents de ce cours
	 */
	@Override
	public java.util.List<String> getDocumentURLs() {
		return model.getDocumentURLs();
	}

	/**
	 * Returns the duration of this activity course.
	 *
	 * @return the duration of this activity course
	 */
	@Override
	public int getDuration() {
		return model.getDuration();
	}

	/**
	 * Returns the group ID of this activity course.
	 *
	 * @return the group ID of this activity course
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Retourne le copyright publiques de l'image
	 */
	@Override
	public String getImageCopyright(Long imageId, java.util.Locale locale) {
		return model.getImageCopyright(imageId, locale);
	}

	/**
	 * Returns the image ID of this activity course.
	 *
	 * @return the image ID of this activity course
	 */
	@Override
	public long getImageId() {
		return model.getImageId();
	}

	/**
	 * Returns the image IDs of this activity course.
	 *
	 * @return the image IDs of this activity course
	 */
	@Override
	public String getImageIds() {
		return model.getImageIds();
	}

	/**
	 * Retourne la légende publiques de l'image
	 */
	@Override
	public String getImageLegend(Long imageId, java.util.Locale locale) {
		return model.getImageLegend(imageId, locale);
	}

	/**
	 * Retourne le titre publiques de l'image
	 */
	@Override
	public String getImageTitle(Long imageId, java.util.Locale locale) {
		return model.getImageTitle(imageId, locale);
	}

	/**
	 * Renvoie l'URL de l'image à partir de l'id du DLFileEntry
	 */
	@Override
	public String getImageURL() {
		return model.getImageURL();
	}

	/**
	 * Retourne l'URL publiques de l'image
	 */
	@Override
	public String getImageURL(Long imageId) {
		return model.getImageURL(imageId);
	}

	/**
	 * Retourne la version live de cette entité
	 */
	@Override
	public eu.strasbourg.service.activity.model.ActivityCourse
		getLiveVersion() {

		return model.getLiveVersion();
	}

	/**
	 * Returns the modified date of this activity course.
	 *
	 * @return the modified date of this activity course
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this activity course.
	 *
	 * @return the name of this activity course
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the localized name of this activity course in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized name of this activity course
	 */
	@Override
	public String getName(java.util.Locale locale) {
		return model.getName(locale);
	}

	/**
	 * Returns the localized name of this activity course in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this activity course. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getName(java.util.Locale locale, boolean useDefault) {
		return model.getName(locale, useDefault);
	}

	/**
	 * Returns the localized name of this activity course in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized name of this activity course
	 */
	@Override
	public String getName(String languageId) {
		return model.getName(languageId);
	}

	/**
	 * Returns the localized name of this activity course in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this activity course
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
	 * Returns a map of the locales and localized names of this activity course.
	 *
	 * @return the locales and localized names of this activity course
	 */
	@Override
	public Map<java.util.Locale, String> getNameMap() {
		return model.getNameMap();
	}

	/**
	 * Returns the organizer ID of this activity course.
	 *
	 * @return the organizer ID of this activity course
	 */
	@Override
	public long getOrganizerId() {
		return model.getOrganizerId();
	}

	/**
	 * Retourne le nom de l'organisateur du cours
	 */
	@Override
	public String getOrganizerName(java.util.Locale locale) {
		return model.getOrganizerName(locale);
	}

	/**
	 * Retourne les noms des lieux du cours
	 */
	@Override
	public java.util.List<String> getPlaceNames(java.util.Locale locale) {
		return model.getPlaceNames(locale);
	}

	/**
	 * Retourne les ids SIG des lieux duc ours
	 */
	@Override
	public java.util.List<String> getPlaceSIGIds(java.util.Locale locale) {
		return model.getPlaceSIGIds(locale);
	}

	/**
	 * Returns the presentation of this activity course.
	 *
	 * @return the presentation of this activity course
	 */
	@Override
	public String getPresentation() {
		return model.getPresentation();
	}

	/**
	 * Returns the localized presentation of this activity course in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized presentation of this activity course
	 */
	@Override
	public String getPresentation(java.util.Locale locale) {
		return model.getPresentation(locale);
	}

	/**
	 * Returns the localized presentation of this activity course in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized presentation of this activity course. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getPresentation(java.util.Locale locale, boolean useDefault) {
		return model.getPresentation(locale, useDefault);
	}

	/**
	 * Returns the localized presentation of this activity course in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized presentation of this activity course
	 */
	@Override
	public String getPresentation(String languageId) {
		return model.getPresentation(languageId);
	}

	/**
	 * Returns the localized presentation of this activity course in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized presentation of this activity course
	 */
	@Override
	public String getPresentation(String languageId, boolean useDefault) {
		return model.getPresentation(languageId, useDefault);
	}

	@Override
	public String getPresentationCurrentLanguageId() {
		return model.getPresentationCurrentLanguageId();
	}

	@Override
	public String getPresentationCurrentValue() {
		return model.getPresentationCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized presentations of this activity course.
	 *
	 * @return the locales and localized presentations of this activity course
	 */
	@Override
	public Map<java.util.Locale, String> getPresentationMap() {
		return model.getPresentationMap();
	}

	/**
	 * Returns the price of this activity course.
	 *
	 * @return the price of this activity course
	 */
	@Override
	public String getPrice() {
		return model.getPrice();
	}

	/**
	 * Returns the localized price of this activity course in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized price of this activity course
	 */
	@Override
	public String getPrice(java.util.Locale locale) {
		return model.getPrice(locale);
	}

	/**
	 * Returns the localized price of this activity course in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized price of this activity course. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getPrice(java.util.Locale locale, boolean useDefault) {
		return model.getPrice(locale, useDefault);
	}

	/**
	 * Returns the localized price of this activity course in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized price of this activity course
	 */
	@Override
	public String getPrice(String languageId) {
		return model.getPrice(languageId);
	}

	/**
	 * Returns the localized price of this activity course in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized price of this activity course
	 */
	@Override
	public String getPrice(String languageId, boolean useDefault) {
		return model.getPrice(languageId, useDefault);
	}

	@Override
	public String getPriceCurrentLanguageId() {
		return model.getPriceCurrentLanguageId();
	}

	@Override
	public String getPriceCurrentValue() {
		return model.getPriceCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized prices of this activity course.
	 *
	 * @return the locales and localized prices of this activity course
	 */
	@Override
	public Map<java.util.Locale, String> getPriceMap() {
		return model.getPriceMap();
	}

	/**
	 * Returns the primary key of this activity course.
	 *
	 * @return the primary key of this activity course
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Retourne les publics dui cours
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getPublics() {

		return model.getPublics();
	}

	/**
	 * Retourne le texte à afficher pour les publics du cours
	 */
	@Override
	public String getPublicsLabel(java.util.Locale locale) {
		return model.getPublicsLabel(locale);
	}

	/**
	 * Returns the status of this activity course.
	 *
	 * @return the status of this activity course
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this activity course.
	 *
	 * @return the status by user ID of this activity course
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this activity course.
	 *
	 * @return the status by user name of this activity course
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this activity course.
	 *
	 * @return the status by user uuid of this activity course
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this activity course.
	 *
	 * @return the status date of this activity course
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Retourne les types du cours
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getTypes() {

		return model.getTypes();
	}

	/**
	 * Retourne le texte à afficher pour les types du cours
	 */
	@Override
	public String getTypesLabels(java.util.Locale locale) {
		return model.getTypesLabels(locale);
	}

	/**
	 * Returns the user ID of this activity course.
	 *
	 * @return the user ID of this activity course
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this activity course.
	 *
	 * @return the user name of this activity course
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this activity course.
	 *
	 * @return the user uuid of this activity course
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this activity course.
	 *
	 * @return the uuid of this activity course
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Retourne la liste des vidéos de ce lieu
	 */
	@Override
	public java.util.List<eu.strasbourg.service.video.model.Video> getVideos() {
		return model.getVideos();
	}

	/**
	 * Returns the videos IDs of this activity course.
	 *
	 * @return the videos IDs of this activity course
	 */
	@Override
	public String getVideosIds() {
		return model.getVideosIds();
	}

	/**
	 * Returns <code>true</code> if this activity course is approved.
	 *
	 * @return <code>true</code> if this activity course is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this activity course is denied.
	 *
	 * @return <code>true</code> if this activity course is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this activity course is a draft.
	 *
	 * @return <code>true</code> if this activity course is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this activity course is expired.
	 *
	 * @return <code>true</code> if this activity course is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this activity course is inactive.
	 *
	 * @return <code>true</code> if this activity course is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this activity course is incomplete.
	 *
	 * @return <code>true</code> if this activity course is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this activity course is pending.
	 *
	 * @return <code>true</code> if this activity course is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this activity course is scheduled.
	 *
	 * @return <code>true</code> if this activity course is scheduled; <code>false</code> otherwise
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
	 * Sets the activity course ID of this activity course.
	 *
	 * @param activityCourseId the activity course ID of this activity course
	 */
	@Override
	public void setActivityCourseId(long activityCourseId) {
		model.setActivityCourseId(activityCourseId);
	}

	/**
	 * Sets the activity ID of this activity course.
	 *
	 * @param activityId the activity ID of this activity course
	 */
	@Override
	public void setActivityId(long activityId) {
		model.setActivityId(activityId);
	}

	/**
	 * Sets the arrangements of this activity course.
	 *
	 * @param arrangements the arrangements of this activity course
	 */
	@Override
	public void setArrangements(String arrangements) {
		model.setArrangements(arrangements);
	}

	/**
	 * Sets the localized arrangements of this activity course in the language.
	 *
	 * @param arrangements the localized arrangements of this activity course
	 * @param locale the locale of the language
	 */
	@Override
	public void setArrangements(String arrangements, java.util.Locale locale) {
		model.setArrangements(arrangements, locale);
	}

	/**
	 * Sets the localized arrangements of this activity course in the language, and sets the default locale.
	 *
	 * @param arrangements the localized arrangements of this activity course
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setArrangements(
		String arrangements, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setArrangements(arrangements, locale, defaultLocale);
	}

	@Override
	public void setArrangementsCurrentLanguageId(String languageId) {
		model.setArrangementsCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized arrangementses of this activity course from the map of locales and localized arrangementses.
	 *
	 * @param arrangementsMap the locales and localized arrangementses of this activity course
	 */
	@Override
	public void setArrangementsMap(
		Map<java.util.Locale, String> arrangementsMap) {

		model.setArrangementsMap(arrangementsMap);
	}

	/**
	 * Sets the localized arrangementses of this activity course from the map of locales and localized arrangementses, and sets the default locale.
	 *
	 * @param arrangementsMap the locales and localized arrangementses of this activity course
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setArrangementsMap(
		Map<java.util.Locale, String> arrangementsMap,
		java.util.Locale defaultLocale) {

		model.setArrangementsMap(arrangementsMap, defaultLocale);
	}

	/**
	 * Sets the company ID of this activity course.
	 *
	 * @param companyId the company ID of this activity course
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this activity course.
	 *
	 * @param createDate the create date of this activity course
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the documents IDs of this activity course.
	 *
	 * @param documentsIds the documents IDs of this activity course
	 */
	@Override
	public void setDocumentsIds(String documentsIds) {
		model.setDocumentsIds(documentsIds);
	}

	/**
	 * Sets the duration of this activity course.
	 *
	 * @param duration the duration of this activity course
	 */
	@Override
	public void setDuration(int duration) {
		model.setDuration(duration);
	}

	/**
	 * Sets the group ID of this activity course.
	 *
	 * @param groupId the group ID of this activity course
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the image ID of this activity course.
	 *
	 * @param imageId the image ID of this activity course
	 */
	@Override
	public void setImageId(long imageId) {
		model.setImageId(imageId);
	}

	/**
	 * Sets the image IDs of this activity course.
	 *
	 * @param imageIds the image IDs of this activity course
	 */
	@Override
	public void setImageIds(String imageIds) {
		model.setImageIds(imageIds);
	}

	/**
	 * Sets the modified date of this activity course.
	 *
	 * @param modifiedDate the modified date of this activity course
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this activity course.
	 *
	 * @param name the name of this activity course
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the localized name of this activity course in the language.
	 *
	 * @param name the localized name of this activity course
	 * @param locale the locale of the language
	 */
	@Override
	public void setName(String name, java.util.Locale locale) {
		model.setName(name, locale);
	}

	/**
	 * Sets the localized name of this activity course in the language, and sets the default locale.
	 *
	 * @param name the localized name of this activity course
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
	 * Sets the localized names of this activity course from the map of locales and localized names.
	 *
	 * @param nameMap the locales and localized names of this activity course
	 */
	@Override
	public void setNameMap(Map<java.util.Locale, String> nameMap) {
		model.setNameMap(nameMap);
	}

	/**
	 * Sets the localized names of this activity course from the map of locales and localized names, and sets the default locale.
	 *
	 * @param nameMap the locales and localized names of this activity course
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setNameMap(
		Map<java.util.Locale, String> nameMap, java.util.Locale defaultLocale) {

		model.setNameMap(nameMap, defaultLocale);
	}

	/**
	 * Sets the organizer ID of this activity course.
	 *
	 * @param organizerId the organizer ID of this activity course
	 */
	@Override
	public void setOrganizerId(long organizerId) {
		model.setOrganizerId(organizerId);
	}

	/**
	 * Sets the presentation of this activity course.
	 *
	 * @param presentation the presentation of this activity course
	 */
	@Override
	public void setPresentation(String presentation) {
		model.setPresentation(presentation);
	}

	/**
	 * Sets the localized presentation of this activity course in the language.
	 *
	 * @param presentation the localized presentation of this activity course
	 * @param locale the locale of the language
	 */
	@Override
	public void setPresentation(String presentation, java.util.Locale locale) {
		model.setPresentation(presentation, locale);
	}

	/**
	 * Sets the localized presentation of this activity course in the language, and sets the default locale.
	 *
	 * @param presentation the localized presentation of this activity course
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setPresentation(
		String presentation, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setPresentation(presentation, locale, defaultLocale);
	}

	@Override
	public void setPresentationCurrentLanguageId(String languageId) {
		model.setPresentationCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized presentations of this activity course from the map of locales and localized presentations.
	 *
	 * @param presentationMap the locales and localized presentations of this activity course
	 */
	@Override
	public void setPresentationMap(
		Map<java.util.Locale, String> presentationMap) {

		model.setPresentationMap(presentationMap);
	}

	/**
	 * Sets the localized presentations of this activity course from the map of locales and localized presentations, and sets the default locale.
	 *
	 * @param presentationMap the locales and localized presentations of this activity course
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setPresentationMap(
		Map<java.util.Locale, String> presentationMap,
		java.util.Locale defaultLocale) {

		model.setPresentationMap(presentationMap, defaultLocale);
	}

	/**
	 * Sets the price of this activity course.
	 *
	 * @param price the price of this activity course
	 */
	@Override
	public void setPrice(String price) {
		model.setPrice(price);
	}

	/**
	 * Sets the localized price of this activity course in the language.
	 *
	 * @param price the localized price of this activity course
	 * @param locale the locale of the language
	 */
	@Override
	public void setPrice(String price, java.util.Locale locale) {
		model.setPrice(price, locale);
	}

	/**
	 * Sets the localized price of this activity course in the language, and sets the default locale.
	 *
	 * @param price the localized price of this activity course
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setPrice(
		String price, java.util.Locale locale, java.util.Locale defaultLocale) {

		model.setPrice(price, locale, defaultLocale);
	}

	@Override
	public void setPriceCurrentLanguageId(String languageId) {
		model.setPriceCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized prices of this activity course from the map of locales and localized prices.
	 *
	 * @param priceMap the locales and localized prices of this activity course
	 */
	@Override
	public void setPriceMap(Map<java.util.Locale, String> priceMap) {
		model.setPriceMap(priceMap);
	}

	/**
	 * Sets the localized prices of this activity course from the map of locales and localized prices, and sets the default locale.
	 *
	 * @param priceMap the locales and localized prices of this activity course
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setPriceMap(
		Map<java.util.Locale, String> priceMap,
		java.util.Locale defaultLocale) {

		model.setPriceMap(priceMap, defaultLocale);
	}

	/**
	 * Sets the primary key of this activity course.
	 *
	 * @param primaryKey the primary key of this activity course
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this activity course.
	 *
	 * @param status the status of this activity course
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this activity course.
	 *
	 * @param statusByUserId the status by user ID of this activity course
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this activity course.
	 *
	 * @param statusByUserName the status by user name of this activity course
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this activity course.
	 *
	 * @param statusByUserUuid the status by user uuid of this activity course
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this activity course.
	 *
	 * @param statusDate the status date of this activity course
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the user ID of this activity course.
	 *
	 * @param userId the user ID of this activity course
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this activity course.
	 *
	 * @param userName the user name of this activity course
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this activity course.
	 *
	 * @param userUuid the user uuid of this activity course
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this activity course.
	 *
	 * @param uuid the uuid of this activity course
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the videos IDs of this activity course.
	 *
	 * @param videosIds the videos IDs of this activity course
	 */
	@Override
	public void setVideosIds(String videosIds) {
		model.setVideosIds(videosIds);
	}

	/**
	 * Retourne la version JSON de la course
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
	protected ActivityCourseWrapper wrap(ActivityCourse activityCourse) {
		return new ActivityCourseWrapper(activityCourse);
	}

}