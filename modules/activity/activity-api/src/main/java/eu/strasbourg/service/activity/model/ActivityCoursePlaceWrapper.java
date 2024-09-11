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
 * This class is a wrapper for {@link ActivityCoursePlace}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ActivityCoursePlace
 * @generated
 */
public class ActivityCoursePlaceWrapper
	extends BaseModelWrapper<ActivityCoursePlace>
	implements ActivityCoursePlace, ModelWrapper<ActivityCoursePlace> {

	public ActivityCoursePlaceWrapper(ActivityCoursePlace activityCoursePlace) {
		super(activityCoursePlace);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("activityCoursePlaceId", getActivityCoursePlaceId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("activityCourseId", getActivityCourseId());
		attributes.put("placeSIGId", getPlaceSIGId());
		attributes.put("placeName", getPlaceName());
		attributes.put("placeStreetNumber", getPlaceStreetNumber());
		attributes.put("placeStreetName", getPlaceStreetName());
		attributes.put("placeZipCode", getPlaceZipCode());
		attributes.put("placeCityId", getPlaceCityId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long activityCoursePlaceId = (Long)attributes.get(
			"activityCoursePlaceId");

		if (activityCoursePlaceId != null) {
			setActivityCoursePlaceId(activityCoursePlaceId);
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

		Long activityCourseId = (Long)attributes.get("activityCourseId");

		if (activityCourseId != null) {
			setActivityCourseId(activityCourseId);
		}

		String placeSIGId = (String)attributes.get("placeSIGId");

		if (placeSIGId != null) {
			setPlaceSIGId(placeSIGId);
		}

		String placeName = (String)attributes.get("placeName");

		if (placeName != null) {
			setPlaceName(placeName);
		}

		String placeStreetNumber = (String)attributes.get("placeStreetNumber");

		if (placeStreetNumber != null) {
			setPlaceStreetNumber(placeStreetNumber);
		}

		String placeStreetName = (String)attributes.get("placeStreetName");

		if (placeStreetName != null) {
			setPlaceStreetName(placeStreetName);
		}

		String placeZipCode = (String)attributes.get("placeZipCode");

		if (placeZipCode != null) {
			setPlaceZipCode(placeZipCode);
		}

		Long placeCityId = (Long)attributes.get("placeCityId");

		if (placeCityId != null) {
			setPlaceCityId(placeCityId);
		}
	}

	@Override
	public ActivityCoursePlace cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Retourne le cours du lieu
	 */
	@Override
	public eu.strasbourg.service.activity.model.ActivityCourse
		getActivityCourse() {

		return model.getActivityCourse();
	}

	/**
	 * Returns the activity course ID of this activity course place.
	 *
	 * @return the activity course ID of this activity course place
	 */
	@Override
	public long getActivityCourseId() {
		return model.getActivityCourseId();
	}

	/**
	 * Returns the activity course place ID of this activity course place.
	 *
	 * @return the activity course place ID of this activity course place
	 */
	@Override
	public long getActivityCoursePlaceId() {
		return model.getActivityCoursePlaceId();
	}

	/**
	 * Retourne les horaires du cours dans le lieu
	 */
	@Override
	public java.util.List
		<eu.strasbourg.service.activity.model.ActivityCourseSchedule>
			getActivityCourseSchedules() {

		return model.getActivityCourseSchedules();
	}

	/**
	 * Retourne les horaires du cours dans le lieu pour un jour donné (lundi =
	 * 0, mardi = 1, etc.)
	 */
	@Override
	public java.util.List
		<eu.strasbourg.service.activity.model.ActivityCourseSchedule>
			getActivityCourseSchedulesForDay(int day) {

		return model.getActivityCourseSchedulesForDay(day);
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
	 * Retourne la liste des AssetCategory rattachées à cette entité (via
	 * l'assetEntry)
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCategories() {

		return model.getCategories();
	}

	/**
	 * Returns the company ID of this activity course place.
	 *
	 * @return the company ID of this activity course place
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this activity course place.
	 *
	 * @return the create date of this activity course place
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
	 * Returns the group ID of this activity course place.
	 *
	 * @return the group ID of this activity course place
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Retourne la version live de cette entité
	 */
	@Override
	public eu.strasbourg.service.activity.model.ActivityCoursePlace
		getLiveVersion() {

		return model.getLiveVersion();
	}

	/**
	 * Returns the modified date of this activity course place.
	 *
	 * @return the modified date of this activity course place
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Retourne le nom du lieu SIG ou "manuel"
	 */
	@Override
	public String getPlaceAlias(java.util.Locale locale) {
		return model.getPlaceAlias(locale);
	}

	/**
	 * Returns the place city ID of this activity course place.
	 *
	 * @return the place city ID of this activity course place
	 */
	@Override
	public long getPlaceCityId() {
		return model.getPlaceCityId();
	}

	/**
	 * Returns the place name of this activity course place.
	 *
	 * @return the place name of this activity course place
	 */
	@Override
	public String getPlaceName() {
		return model.getPlaceName();
	}

	/**
	 * Returns the localized place name of this activity course place in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized place name of this activity course place
	 */
	@Override
	public String getPlaceName(java.util.Locale locale) {
		return model.getPlaceName(locale);
	}

	/**
	 * Returns the localized place name of this activity course place in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized place name of this activity course place. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getPlaceName(java.util.Locale locale, boolean useDefault) {
		return model.getPlaceName(locale, useDefault);
	}

	/**
	 * Returns the localized place name of this activity course place in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized place name of this activity course place
	 */
	@Override
	public String getPlaceName(String languageId) {
		return model.getPlaceName(languageId);
	}

	/**
	 * Returns the localized place name of this activity course place in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized place name of this activity course place
	 */
	@Override
	public String getPlaceName(String languageId, boolean useDefault) {
		return model.getPlaceName(languageId, useDefault);
	}

	@Override
	public String getPlaceNameCurrentLanguageId() {
		return model.getPlaceNameCurrentLanguageId();
	}

	@Override
	public String getPlaceNameCurrentValue() {
		return model.getPlaceNameCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized place names of this activity course place.
	 *
	 * @return the locales and localized place names of this activity course place
	 */
	@Override
	public Map<java.util.Locale, String> getPlaceNameMap() {
		return model.getPlaceNameMap();
	}

	/**
	 * Returns the place sig ID of this activity course place.
	 *
	 * @return the place sig ID of this activity course place
	 */
	@Override
	public String getPlaceSIGId() {
		return model.getPlaceSIGId();
	}

	/**
	 * Returns the place street name of this activity course place.
	 *
	 * @return the place street name of this activity course place
	 */
	@Override
	public String getPlaceStreetName() {
		return model.getPlaceStreetName();
	}

	/**
	 * Returns the place street number of this activity course place.
	 *
	 * @return the place street number of this activity course place
	 */
	@Override
	public String getPlaceStreetNumber() {
		return model.getPlaceStreetNumber();
	}

	/**
	 * Returns the place zip code of this activity course place.
	 *
	 * @return the place zip code of this activity course place
	 */
	@Override
	public String getPlaceZipCode() {
		return model.getPlaceZipCode();
	}

	/**
	 * Returns the primary key of this activity course place.
	 *
	 * @return the primary key of this activity course place
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Retourne le nom du lieu SIG
	 */
	@Override
	public String getSIGPlaceAlias(java.util.Locale locale) {
		return model.getSIGPlaceAlias(locale);
	}

	/**
	 * Returns the user ID of this activity course place.
	 *
	 * @return the user ID of this activity course place
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this activity course place.
	 *
	 * @return the user name of this activity course place
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this activity course place.
	 *
	 * @return the user uuid of this activity course place
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this activity course place.
	 *
	 * @return the uuid of this activity course place
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Retourne true si le cours a des horaires pour ce lieux
	 */
	@Override
	public boolean hasSchedules() {
		return model.hasSchedules();
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
	 * Sets the activity course ID of this activity course place.
	 *
	 * @param activityCourseId the activity course ID of this activity course place
	 */
	@Override
	public void setActivityCourseId(long activityCourseId) {
		model.setActivityCourseId(activityCourseId);
	}

	/**
	 * Sets the activity course place ID of this activity course place.
	 *
	 * @param activityCoursePlaceId the activity course place ID of this activity course place
	 */
	@Override
	public void setActivityCoursePlaceId(long activityCoursePlaceId) {
		model.setActivityCoursePlaceId(activityCoursePlaceId);
	}

	/**
	 * Sets the company ID of this activity course place.
	 *
	 * @param companyId the company ID of this activity course place
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this activity course place.
	 *
	 * @param createDate the create date of this activity course place
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this activity course place.
	 *
	 * @param groupId the group ID of this activity course place
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this activity course place.
	 *
	 * @param modifiedDate the modified date of this activity course place
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the place city ID of this activity course place.
	 *
	 * @param placeCityId the place city ID of this activity course place
	 */
	@Override
	public void setPlaceCityId(long placeCityId) {
		model.setPlaceCityId(placeCityId);
	}

	/**
	 * Sets the place name of this activity course place.
	 *
	 * @param placeName the place name of this activity course place
	 */
	@Override
	public void setPlaceName(String placeName) {
		model.setPlaceName(placeName);
	}

	/**
	 * Sets the localized place name of this activity course place in the language.
	 *
	 * @param placeName the localized place name of this activity course place
	 * @param locale the locale of the language
	 */
	@Override
	public void setPlaceName(String placeName, java.util.Locale locale) {
		model.setPlaceName(placeName, locale);
	}

	/**
	 * Sets the localized place name of this activity course place in the language, and sets the default locale.
	 *
	 * @param placeName the localized place name of this activity course place
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setPlaceName(
		String placeName, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setPlaceName(placeName, locale, defaultLocale);
	}

	@Override
	public void setPlaceNameCurrentLanguageId(String languageId) {
		model.setPlaceNameCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized place names of this activity course place from the map of locales and localized place names.
	 *
	 * @param placeNameMap the locales and localized place names of this activity course place
	 */
	@Override
	public void setPlaceNameMap(Map<java.util.Locale, String> placeNameMap) {
		model.setPlaceNameMap(placeNameMap);
	}

	/**
	 * Sets the localized place names of this activity course place from the map of locales and localized place names, and sets the default locale.
	 *
	 * @param placeNameMap the locales and localized place names of this activity course place
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setPlaceNameMap(
		Map<java.util.Locale, String> placeNameMap,
		java.util.Locale defaultLocale) {

		model.setPlaceNameMap(placeNameMap, defaultLocale);
	}

	/**
	 * Sets the place sig ID of this activity course place.
	 *
	 * @param placeSIGId the place sig ID of this activity course place
	 */
	@Override
	public void setPlaceSIGId(String placeSIGId) {
		model.setPlaceSIGId(placeSIGId);
	}

	/**
	 * Sets the place street name of this activity course place.
	 *
	 * @param placeStreetName the place street name of this activity course place
	 */
	@Override
	public void setPlaceStreetName(String placeStreetName) {
		model.setPlaceStreetName(placeStreetName);
	}

	/**
	 * Sets the place street number of this activity course place.
	 *
	 * @param placeStreetNumber the place street number of this activity course place
	 */
	@Override
	public void setPlaceStreetNumber(String placeStreetNumber) {
		model.setPlaceStreetNumber(placeStreetNumber);
	}

	/**
	 * Sets the place zip code of this activity course place.
	 *
	 * @param placeZipCode the place zip code of this activity course place
	 */
	@Override
	public void setPlaceZipCode(String placeZipCode) {
		model.setPlaceZipCode(placeZipCode);
	}

	/**
	 * Sets the primary key of this activity course place.
	 *
	 * @param primaryKey the primary key of this activity course place
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this activity course place.
	 *
	 * @param userId the user ID of this activity course place
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this activity course place.
	 *
	 * @param userName the user name of this activity course place
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this activity course place.
	 *
	 * @param userUuid the user uuid of this activity course place
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this activity course place.
	 *
	 * @param uuid the uuid of this activity course place
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
	protected ActivityCoursePlaceWrapper wrap(
		ActivityCoursePlace activityCoursePlace) {

		return new ActivityCoursePlaceWrapper(activityCoursePlace);
	}

}