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
 * This class is a wrapper for {@link ActivityCourseSchedule}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ActivityCourseSchedule
 * @generated
 */
public class ActivityCourseScheduleWrapper
	extends BaseModelWrapper<ActivityCourseSchedule>
	implements ActivityCourseSchedule, ModelWrapper<ActivityCourseSchedule> {

	public ActivityCourseScheduleWrapper(
		ActivityCourseSchedule activityCourseSchedule) {

		super(activityCourseSchedule);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put(
			"activityCourseScheduleId", getActivityCourseScheduleId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("activityCoursePlaceId", getActivityCoursePlaceId());
		attributes.put("startTime", getStartTime());
		attributes.put("endTime", getEndTime());
		attributes.put("monday", isMonday());
		attributes.put("tuesday", isTuesday());
		attributes.put("wednesday", isWednesday());
		attributes.put("thursday", isThursday());
		attributes.put("friday", isFriday());
		attributes.put("saturday", isSaturday());
		attributes.put("sunday", isSunday());
		attributes.put("comments", getComments());
		attributes.put("periodsIds", getPeriodsIds());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long activityCourseScheduleId = (Long)attributes.get(
			"activityCourseScheduleId");

		if (activityCourseScheduleId != null) {
			setActivityCourseScheduleId(activityCourseScheduleId);
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

		Long activityCoursePlaceId = (Long)attributes.get(
			"activityCoursePlaceId");

		if (activityCoursePlaceId != null) {
			setActivityCoursePlaceId(activityCoursePlaceId);
		}

		String startTime = (String)attributes.get("startTime");

		if (startTime != null) {
			setStartTime(startTime);
		}

		String endTime = (String)attributes.get("endTime");

		if (endTime != null) {
			setEndTime(endTime);
		}

		Boolean monday = (Boolean)attributes.get("monday");

		if (monday != null) {
			setMonday(monday);
		}

		Boolean tuesday = (Boolean)attributes.get("tuesday");

		if (tuesday != null) {
			setTuesday(tuesday);
		}

		Boolean wednesday = (Boolean)attributes.get("wednesday");

		if (wednesday != null) {
			setWednesday(wednesday);
		}

		Boolean thursday = (Boolean)attributes.get("thursday");

		if (thursday != null) {
			setThursday(thursday);
		}

		Boolean friday = (Boolean)attributes.get("friday");

		if (friday != null) {
			setFriday(friday);
		}

		Boolean saturday = (Boolean)attributes.get("saturday");

		if (saturday != null) {
			setSaturday(saturday);
		}

		Boolean sunday = (Boolean)attributes.get("sunday");

		if (sunday != null) {
			setSunday(sunday);
		}

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
		}

		String periodsIds = (String)attributes.get("periodsIds");

		if (periodsIds != null) {
			setPeriodsIds(periodsIds);
		}
	}

	@Override
	public ActivityCourseSchedule cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Retourne le lieu de l'horaire
	 */
	@Override
	public eu.strasbourg.service.activity.model.ActivityCoursePlace
		getActivityCoursePlace() {

		return model.getActivityCoursePlace();
	}

	/**
	 * Returns the activity course place ID of this activity course schedule.
	 *
	 * @return the activity course place ID of this activity course schedule
	 */
	@Override
	public long getActivityCoursePlaceId() {
		return model.getActivityCoursePlaceId();
	}

	/**
	 * Returns the activity course schedule ID of this activity course schedule.
	 *
	 * @return the activity course schedule ID of this activity course schedule
	 */
	@Override
	public long getActivityCourseScheduleId() {
		return model.getActivityCourseScheduleId();
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
	 * Returns the comments of this activity course schedule.
	 *
	 * @return the comments of this activity course schedule
	 */
	@Override
	public String getComments() {
		return model.getComments();
	}

	/**
	 * Returns the localized comments of this activity course schedule in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized comments of this activity course schedule
	 */
	@Override
	public String getComments(java.util.Locale locale) {
		return model.getComments(locale);
	}

	/**
	 * Returns the localized comments of this activity course schedule in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized comments of this activity course schedule. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getComments(java.util.Locale locale, boolean useDefault) {
		return model.getComments(locale, useDefault);
	}

	/**
	 * Returns the localized comments of this activity course schedule in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized comments of this activity course schedule
	 */
	@Override
	public String getComments(String languageId) {
		return model.getComments(languageId);
	}

	/**
	 * Returns the localized comments of this activity course schedule in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized comments of this activity course schedule
	 */
	@Override
	public String getComments(String languageId, boolean useDefault) {
		return model.getComments(languageId, useDefault);
	}

	@Override
	public String getCommentsCurrentLanguageId() {
		return model.getCommentsCurrentLanguageId();
	}

	@Override
	public String getCommentsCurrentValue() {
		return model.getCommentsCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized commentses of this activity course schedule.
	 *
	 * @return the locales and localized commentses of this activity course schedule
	 */
	@Override
	public Map<java.util.Locale, String> getCommentsMap() {
		return model.getCommentsMap();
	}

	/**
	 * Returns the company ID of this activity course schedule.
	 *
	 * @return the company ID of this activity course schedule
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this activity course schedule.
	 *
	 * @return the create date of this activity course schedule
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
	 * Returns the end time of this activity course schedule.
	 *
	 * @return the end time of this activity course schedule
	 */
	@Override
	public String getEndTime() {
		return model.getEndTime();
	}

	/**
	 * Returns the friday of this activity course schedule.
	 *
	 * @return the friday of this activity course schedule
	 */
	@Override
	public boolean getFriday() {
		return model.getFriday();
	}

	/**
	 * Returns the group ID of this activity course schedule.
	 *
	 * @return the group ID of this activity course schedule
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Retourne la version live de cette entité
	 */
	@Override
	public eu.strasbourg.service.activity.model.ActivityCourseSchedule
		getLiveVersion() {

		return model.getLiveVersion();
	}

	/**
	 * Returns the modified date of this activity course schedule.
	 *
	 * @return the modified date of this activity course schedule
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the monday of this activity course schedule.
	 *
	 * @return the monday of this activity course schedule
	 */
	@Override
	public boolean getMonday() {
		return model.getMonday();
	}

	/**
	 * Retourne les périodes du schedule
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getPeriods() {

		return model.getPeriods();
	}

	/**
	 * Returns the periods IDs of this activity course schedule.
	 *
	 * @return the periods IDs of this activity course schedule
	 */
	@Override
	public String getPeriodsIds() {
		return model.getPeriodsIds();
	}

	/**
	 * Returns the primary key of this activity course schedule.
	 *
	 * @return the primary key of this activity course schedule
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the saturday of this activity course schedule.
	 *
	 * @return the saturday of this activity course schedule
	 */
	@Override
	public boolean getSaturday() {
		return model.getSaturday();
	}

	/**
	 * Returns the start time of this activity course schedule.
	 *
	 * @return the start time of this activity course schedule
	 */
	@Override
	public String getStartTime() {
		return model.getStartTime();
	}

	/**
	 * Returns the sunday of this activity course schedule.
	 *
	 * @return the sunday of this activity course schedule
	 */
	@Override
	public boolean getSunday() {
		return model.getSunday();
	}

	/**
	 * Returns the thursday of this activity course schedule.
	 *
	 * @return the thursday of this activity course schedule
	 */
	@Override
	public boolean getThursday() {
		return model.getThursday();
	}

	/**
	 * Returns the tuesday of this activity course schedule.
	 *
	 * @return the tuesday of this activity course schedule
	 */
	@Override
	public boolean getTuesday() {
		return model.getTuesday();
	}

	/**
	 * Returns the user ID of this activity course schedule.
	 *
	 * @return the user ID of this activity course schedule
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this activity course schedule.
	 *
	 * @return the user name of this activity course schedule
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this activity course schedule.
	 *
	 * @return the user uuid of this activity course schedule
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this activity course schedule.
	 *
	 * @return the uuid of this activity course schedule
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the wednesday of this activity course schedule.
	 *
	 * @return the wednesday of this activity course schedule
	 */
	@Override
	public boolean getWednesday() {
		return model.getWednesday();
	}

	/**
	 * Renvoie un tableau de 7 booléens valant true si l'horaire concerne le
	 * jour, false sinon
	 */
	@Override
	public boolean[] getWeekDays() {
		return model.getWeekDays();
	}

	/**
	 * Renvoie true si l'horaire concerne le jour passé en paramètre (jour entre
	 * 0 et 6)
	 */
	@Override
	public boolean hasScheduleOnDay(int day) {
		return model.hasScheduleOnDay(day);
	}

	/**
	 * Returns <code>true</code> if this activity course schedule is friday.
	 *
	 * @return <code>true</code> if this activity course schedule is friday; <code>false</code> otherwise
	 */
	@Override
	public boolean isFriday() {
		return model.isFriday();
	}

	/**
	 * Returns <code>true</code> if this activity course schedule is monday.
	 *
	 * @return <code>true</code> if this activity course schedule is monday; <code>false</code> otherwise
	 */
	@Override
	public boolean isMonday() {
		return model.isMonday();
	}

	/**
	 * Returns <code>true</code> if this activity course schedule is saturday.
	 *
	 * @return <code>true</code> if this activity course schedule is saturday; <code>false</code> otherwise
	 */
	@Override
	public boolean isSaturday() {
		return model.isSaturday();
	}

	/**
	 * Returns <code>true</code> if this activity course schedule is sunday.
	 *
	 * @return <code>true</code> if this activity course schedule is sunday; <code>false</code> otherwise
	 */
	@Override
	public boolean isSunday() {
		return model.isSunday();
	}

	/**
	 * Returns <code>true</code> if this activity course schedule is thursday.
	 *
	 * @return <code>true</code> if this activity course schedule is thursday; <code>false</code> otherwise
	 */
	@Override
	public boolean isThursday() {
		return model.isThursday();
	}

	/**
	 * Returns <code>true</code> if this activity course schedule is tuesday.
	 *
	 * @return <code>true</code> if this activity course schedule is tuesday; <code>false</code> otherwise
	 */
	@Override
	public boolean isTuesday() {
		return model.isTuesday();
	}

	/**
	 * Returns <code>true</code> if this activity course schedule is wednesday.
	 *
	 * @return <code>true</code> if this activity course schedule is wednesday; <code>false</code> otherwise
	 */
	@Override
	public boolean isWednesday() {
		return model.isWednesday();
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
	 * Sets the activity course place ID of this activity course schedule.
	 *
	 * @param activityCoursePlaceId the activity course place ID of this activity course schedule
	 */
	@Override
	public void setActivityCoursePlaceId(long activityCoursePlaceId) {
		model.setActivityCoursePlaceId(activityCoursePlaceId);
	}

	/**
	 * Sets the activity course schedule ID of this activity course schedule.
	 *
	 * @param activityCourseScheduleId the activity course schedule ID of this activity course schedule
	 */
	@Override
	public void setActivityCourseScheduleId(long activityCourseScheduleId) {
		model.setActivityCourseScheduleId(activityCourseScheduleId);
	}

	/**
	 * Sets the comments of this activity course schedule.
	 *
	 * @param comments the comments of this activity course schedule
	 */
	@Override
	public void setComments(String comments) {
		model.setComments(comments);
	}

	/**
	 * Sets the localized comments of this activity course schedule in the language.
	 *
	 * @param comments the localized comments of this activity course schedule
	 * @param locale the locale of the language
	 */
	@Override
	public void setComments(String comments, java.util.Locale locale) {
		model.setComments(comments, locale);
	}

	/**
	 * Sets the localized comments of this activity course schedule in the language, and sets the default locale.
	 *
	 * @param comments the localized comments of this activity course schedule
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setComments(
		String comments, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setComments(comments, locale, defaultLocale);
	}

	@Override
	public void setCommentsCurrentLanguageId(String languageId) {
		model.setCommentsCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized commentses of this activity course schedule from the map of locales and localized commentses.
	 *
	 * @param commentsMap the locales and localized commentses of this activity course schedule
	 */
	@Override
	public void setCommentsMap(Map<java.util.Locale, String> commentsMap) {
		model.setCommentsMap(commentsMap);
	}

	/**
	 * Sets the localized commentses of this activity course schedule from the map of locales and localized commentses, and sets the default locale.
	 *
	 * @param commentsMap the locales and localized commentses of this activity course schedule
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setCommentsMap(
		Map<java.util.Locale, String> commentsMap,
		java.util.Locale defaultLocale) {

		model.setCommentsMap(commentsMap, defaultLocale);
	}

	/**
	 * Sets the company ID of this activity course schedule.
	 *
	 * @param companyId the company ID of this activity course schedule
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this activity course schedule.
	 *
	 * @param createDate the create date of this activity course schedule
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the end time of this activity course schedule.
	 *
	 * @param endTime the end time of this activity course schedule
	 */
	@Override
	public void setEndTime(String endTime) {
		model.setEndTime(endTime);
	}

	/**
	 * Sets whether this activity course schedule is friday.
	 *
	 * @param friday the friday of this activity course schedule
	 */
	@Override
	public void setFriday(boolean friday) {
		model.setFriday(friday);
	}

	/**
	 * Sets the group ID of this activity course schedule.
	 *
	 * @param groupId the group ID of this activity course schedule
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this activity course schedule.
	 *
	 * @param modifiedDate the modified date of this activity course schedule
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets whether this activity course schedule is monday.
	 *
	 * @param monday the monday of this activity course schedule
	 */
	@Override
	public void setMonday(boolean monday) {
		model.setMonday(monday);
	}

	/**
	 * Sets the periods IDs of this activity course schedule.
	 *
	 * @param periodsIds the periods IDs of this activity course schedule
	 */
	@Override
	public void setPeriodsIds(String periodsIds) {
		model.setPeriodsIds(periodsIds);
	}

	/**
	 * Sets the primary key of this activity course schedule.
	 *
	 * @param primaryKey the primary key of this activity course schedule
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets whether this activity course schedule is saturday.
	 *
	 * @param saturday the saturday of this activity course schedule
	 */
	@Override
	public void setSaturday(boolean saturday) {
		model.setSaturday(saturday);
	}

	/**
	 * Sets the start time of this activity course schedule.
	 *
	 * @param startTime the start time of this activity course schedule
	 */
	@Override
	public void setStartTime(String startTime) {
		model.setStartTime(startTime);
	}

	/**
	 * Sets whether this activity course schedule is sunday.
	 *
	 * @param sunday the sunday of this activity course schedule
	 */
	@Override
	public void setSunday(boolean sunday) {
		model.setSunday(sunday);
	}

	/**
	 * Sets whether this activity course schedule is thursday.
	 *
	 * @param thursday the thursday of this activity course schedule
	 */
	@Override
	public void setThursday(boolean thursday) {
		model.setThursday(thursday);
	}

	/**
	 * Sets whether this activity course schedule is tuesday.
	 *
	 * @param tuesday the tuesday of this activity course schedule
	 */
	@Override
	public void setTuesday(boolean tuesday) {
		model.setTuesday(tuesday);
	}

	/**
	 * Sets the user ID of this activity course schedule.
	 *
	 * @param userId the user ID of this activity course schedule
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this activity course schedule.
	 *
	 * @param userName the user name of this activity course schedule
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this activity course schedule.
	 *
	 * @param userUuid the user uuid of this activity course schedule
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this activity course schedule.
	 *
	 * @param uuid the uuid of this activity course schedule
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets whether this activity course schedule is wednesday.
	 *
	 * @param wednesday the wednesday of this activity course schedule
	 */
	@Override
	public void setWednesday(boolean wednesday) {
		model.setWednesday(wednesday);
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
	protected ActivityCourseScheduleWrapper wrap(
		ActivityCourseSchedule activityCourseSchedule) {

		return new ActivityCourseScheduleWrapper(activityCourseSchedule);
	}

}