/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.place.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ScheduleException}.
 * </p>
 *
 * @author Angelique Zunino Champougny
 * @see ScheduleException
 * @generated
 */
public class ScheduleExceptionWrapper
	extends BaseModelWrapper<ScheduleException>
	implements ModelWrapper<ScheduleException>, ScheduleException {

	public ScheduleExceptionWrapper(ScheduleException scheduleException) {
		super(scheduleException);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("exceptionId", getExceptionId());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("openingTimes", getOpeningTimes());
		attributes.put("firstComment", getFirstComment());
		attributes.put("secondComment", getSecondComment());
		attributes.put("thirdComment", getThirdComment());
		attributes.put("fourthComment", getFourthComment());
		attributes.put("fifthComment", getFifthComment());
		attributes.put("comment", getComment());
		attributes.put("closed", isClosed());
		attributes.put("placeId", getPlaceId());
		attributes.put("subPlaceId", getSubPlaceId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long exceptionId = (Long)attributes.get("exceptionId");

		if (exceptionId != null) {
			setExceptionId(exceptionId);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		String openingTimes = (String)attributes.get("openingTimes");

		if (openingTimes != null) {
			setOpeningTimes(openingTimes);
		}

		String firstComment = (String)attributes.get("firstComment");

		if (firstComment != null) {
			setFirstComment(firstComment);
		}

		String secondComment = (String)attributes.get("secondComment");

		if (secondComment != null) {
			setSecondComment(secondComment);
		}

		String thirdComment = (String)attributes.get("thirdComment");

		if (thirdComment != null) {
			setThirdComment(thirdComment);
		}

		String fourthComment = (String)attributes.get("fourthComment");

		if (fourthComment != null) {
			setFourthComment(fourthComment);
		}

		String fifthComment = (String)attributes.get("fifthComment");

		if (fifthComment != null) {
			setFifthComment(fifthComment);
		}

		String comment = (String)attributes.get("comment");

		if (comment != null) {
			setComment(comment);
		}

		Boolean closed = (Boolean)attributes.get("closed");

		if (closed != null) {
			setClosed(closed);
		}

		Long placeId = (Long)attributes.get("placeId");

		if (placeId != null) {
			setPlaceId(placeId);
		}

		Long subPlaceId = (Long)attributes.get("subPlaceId");

		if (subPlaceId != null) {
			setSubPlaceId(subPlaceId);
		}
	}

	@Override
	public ScheduleException cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the closed of this schedule exception.
	 *
	 * @return the closed of this schedule exception
	 */
	@Override
	public boolean getClosed() {
		return model.getClosed();
	}

	/**
	 * Returns the comment of this schedule exception.
	 *
	 * @return the comment of this schedule exception
	 */
	@Override
	public String getComment() {
		return model.getComment();
	}

	/**
	 * Returns the localized comment of this schedule exception in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized comment of this schedule exception
	 */
	@Override
	public String getComment(java.util.Locale locale) {
		return model.getComment(locale);
	}

	/**
	 * Returns the localized comment of this schedule exception in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized comment of this schedule exception. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getComment(java.util.Locale locale, boolean useDefault) {
		return model.getComment(locale, useDefault);
	}

	/**
	 * Returns the localized comment of this schedule exception in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized comment of this schedule exception
	 */
	@Override
	public String getComment(String languageId) {
		return model.getComment(languageId);
	}

	/**
	 * Returns the localized comment of this schedule exception in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized comment of this schedule exception
	 */
	@Override
	public String getComment(String languageId, boolean useDefault) {
		return model.getComment(languageId, useDefault);
	}

	@Override
	public String getCommentCurrentLanguageId() {
		return model.getCommentCurrentLanguageId();
	}

	@Override
	public String getCommentCurrentValue() {
		return model.getCommentCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized comments of this schedule exception.
	 *
	 * @return the locales and localized comments of this schedule exception
	 */
	@Override
	public Map<java.util.Locale, String> getCommentMap() {
		return model.getCommentMap();
	}

	/**
	 * Retourne liste des commentaires
	 */
	@Override
	public String[] getComments() {
		return model.getComments();
	}

	@Override
	public String getDefaultLanguageId() {
		return model.getDefaultLanguageId();
	}

	/**
	 * Returns the end date of this schedule exception.
	 *
	 * @return the end date of this schedule exception
	 */
	@Override
	public Date getEndDate() {
		return model.getEndDate();
	}

	/**
	 * Retourne la Nème heure de début
	 */
	@Override
	public java.time.LocalTime getEndHour(int index) {
		return model.getEndHour(index);
	}

	/**
	 * Returns the exception ID of this schedule exception.
	 *
	 * @return the exception ID of this schedule exception
	 */
	@Override
	public long getExceptionId() {
		return model.getExceptionId();
	}

	/**
	 * Returns the fifth comment of this schedule exception.
	 *
	 * @return the fifth comment of this schedule exception
	 */
	@Override
	public String getFifthComment() {
		return model.getFifthComment();
	}

	/**
	 * Returns the localized fifth comment of this schedule exception in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized fifth comment of this schedule exception
	 */
	@Override
	public String getFifthComment(java.util.Locale locale) {
		return model.getFifthComment(locale);
	}

	/**
	 * Returns the localized fifth comment of this schedule exception in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized fifth comment of this schedule exception. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getFifthComment(java.util.Locale locale, boolean useDefault) {
		return model.getFifthComment(locale, useDefault);
	}

	/**
	 * Returns the localized fifth comment of this schedule exception in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized fifth comment of this schedule exception
	 */
	@Override
	public String getFifthComment(String languageId) {
		return model.getFifthComment(languageId);
	}

	/**
	 * Returns the localized fifth comment of this schedule exception in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized fifth comment of this schedule exception
	 */
	@Override
	public String getFifthComment(String languageId, boolean useDefault) {
		return model.getFifthComment(languageId, useDefault);
	}

	@Override
	public String getFifthCommentCurrentLanguageId() {
		return model.getFifthCommentCurrentLanguageId();
	}

	@Override
	public String getFifthCommentCurrentValue() {
		return model.getFifthCommentCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized fifth comments of this schedule exception.
	 *
	 * @return the locales and localized fifth comments of this schedule exception
	 */
	@Override
	public Map<java.util.Locale, String> getFifthCommentMap() {
		return model.getFifthCommentMap();
	}

	/**
	 * Returns the first comment of this schedule exception.
	 *
	 * @return the first comment of this schedule exception
	 */
	@Override
	public String getFirstComment() {
		return model.getFirstComment();
	}

	/**
	 * Returns the localized first comment of this schedule exception in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized first comment of this schedule exception
	 */
	@Override
	public String getFirstComment(java.util.Locale locale) {
		return model.getFirstComment(locale);
	}

	/**
	 * Returns the localized first comment of this schedule exception in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized first comment of this schedule exception. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getFirstComment(java.util.Locale locale, boolean useDefault) {
		return model.getFirstComment(locale, useDefault);
	}

	/**
	 * Returns the localized first comment of this schedule exception in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized first comment of this schedule exception
	 */
	@Override
	public String getFirstComment(String languageId) {
		return model.getFirstComment(languageId);
	}

	/**
	 * Returns the localized first comment of this schedule exception in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized first comment of this schedule exception
	 */
	@Override
	public String getFirstComment(String languageId, boolean useDefault) {
		return model.getFirstComment(languageId, useDefault);
	}

	@Override
	public String getFirstCommentCurrentLanguageId() {
		return model.getFirstCommentCurrentLanguageId();
	}

	@Override
	public String getFirstCommentCurrentValue() {
		return model.getFirstCommentCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized first comments of this schedule exception.
	 *
	 * @return the locales and localized first comments of this schedule exception
	 */
	@Override
	public Map<java.util.Locale, String> getFirstCommentMap() {
		return model.getFirstCommentMap();
	}

	/**
	 * Returns the fourth comment of this schedule exception.
	 *
	 * @return the fourth comment of this schedule exception
	 */
	@Override
	public String getFourthComment() {
		return model.getFourthComment();
	}

	/**
	 * Returns the localized fourth comment of this schedule exception in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized fourth comment of this schedule exception
	 */
	@Override
	public String getFourthComment(java.util.Locale locale) {
		return model.getFourthComment(locale);
	}

	/**
	 * Returns the localized fourth comment of this schedule exception in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized fourth comment of this schedule exception. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getFourthComment(
		java.util.Locale locale, boolean useDefault) {

		return model.getFourthComment(locale, useDefault);
	}

	/**
	 * Returns the localized fourth comment of this schedule exception in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized fourth comment of this schedule exception
	 */
	@Override
	public String getFourthComment(String languageId) {
		return model.getFourthComment(languageId);
	}

	/**
	 * Returns the localized fourth comment of this schedule exception in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized fourth comment of this schedule exception
	 */
	@Override
	public String getFourthComment(String languageId, boolean useDefault) {
		return model.getFourthComment(languageId, useDefault);
	}

	@Override
	public String getFourthCommentCurrentLanguageId() {
		return model.getFourthCommentCurrentLanguageId();
	}

	@Override
	public String getFourthCommentCurrentValue() {
		return model.getFourthCommentCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized fourth comments of this schedule exception.
	 *
	 * @return the locales and localized fourth comments of this schedule exception
	 */
	@Override
	public Map<java.util.Locale, String> getFourthCommentMap() {
		return model.getFourthCommentMap();
	}

	/**
	 * Retourne la liste des horaires d'ouvertures d'une exception
	 */
	@Override
	public java.util.List
		<eu.strasbourg.utils.models.Pair
			<java.time.LocalTime, java.time.LocalTime>> getOpeningLocalTimes() {

		return model.getOpeningLocalTimes();
	}

	/**
	 * Returns the opening times of this schedule exception.
	 *
	 * @return the opening times of this schedule exception
	 */
	@Override
	public String getOpeningTimes() {
		return model.getOpeningTimes();
	}

	/**
	 * Returns the place ID of this schedule exception.
	 *
	 * @return the place ID of this schedule exception
	 */
	@Override
	public long getPlaceId() {
		return model.getPlaceId();
	}

	/**
	 * Returns the primary key of this schedule exception.
	 *
	 * @return the primary key of this schedule exception
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the second comment of this schedule exception.
	 *
	 * @return the second comment of this schedule exception
	 */
	@Override
	public String getSecondComment() {
		return model.getSecondComment();
	}

	/**
	 * Returns the localized second comment of this schedule exception in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized second comment of this schedule exception
	 */
	@Override
	public String getSecondComment(java.util.Locale locale) {
		return model.getSecondComment(locale);
	}

	/**
	 * Returns the localized second comment of this schedule exception in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized second comment of this schedule exception. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getSecondComment(
		java.util.Locale locale, boolean useDefault) {

		return model.getSecondComment(locale, useDefault);
	}

	/**
	 * Returns the localized second comment of this schedule exception in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized second comment of this schedule exception
	 */
	@Override
	public String getSecondComment(String languageId) {
		return model.getSecondComment(languageId);
	}

	/**
	 * Returns the localized second comment of this schedule exception in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized second comment of this schedule exception
	 */
	@Override
	public String getSecondComment(String languageId, boolean useDefault) {
		return model.getSecondComment(languageId, useDefault);
	}

	@Override
	public String getSecondCommentCurrentLanguageId() {
		return model.getSecondCommentCurrentLanguageId();
	}

	@Override
	public String getSecondCommentCurrentValue() {
		return model.getSecondCommentCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized second comments of this schedule exception.
	 *
	 * @return the locales and localized second comments of this schedule exception
	 */
	@Override
	public Map<java.util.Locale, String> getSecondCommentMap() {
		return model.getSecondCommentMap();
	}

	/**
	 * Returns the start date of this schedule exception.
	 *
	 * @return the start date of this schedule exception
	 */
	@Override
	public Date getStartDate() {
		return model.getStartDate();
	}

	/**
	 * Retourne la Nème heure de début
	 */
	@Override
	public java.time.LocalTime getStartHour(int index) {
		return model.getStartHour(index);
	}

	/**
	 * Returns the sub place ID of this schedule exception.
	 *
	 * @return the sub place ID of this schedule exception
	 */
	@Override
	public long getSubPlaceId() {
		return model.getSubPlaceId();
	}

	/**
	 * Returns the third comment of this schedule exception.
	 *
	 * @return the third comment of this schedule exception
	 */
	@Override
	public String getThirdComment() {
		return model.getThirdComment();
	}

	/**
	 * Returns the localized third comment of this schedule exception in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized third comment of this schedule exception
	 */
	@Override
	public String getThirdComment(java.util.Locale locale) {
		return model.getThirdComment(locale);
	}

	/**
	 * Returns the localized third comment of this schedule exception in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized third comment of this schedule exception. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getThirdComment(java.util.Locale locale, boolean useDefault) {
		return model.getThirdComment(locale, useDefault);
	}

	/**
	 * Returns the localized third comment of this schedule exception in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized third comment of this schedule exception
	 */
	@Override
	public String getThirdComment(String languageId) {
		return model.getThirdComment(languageId);
	}

	/**
	 * Returns the localized third comment of this schedule exception in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized third comment of this schedule exception
	 */
	@Override
	public String getThirdComment(String languageId, boolean useDefault) {
		return model.getThirdComment(languageId, useDefault);
	}

	@Override
	public String getThirdCommentCurrentLanguageId() {
		return model.getThirdCommentCurrentLanguageId();
	}

	@Override
	public String getThirdCommentCurrentValue() {
		return model.getThirdCommentCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized third comments of this schedule exception.
	 *
	 * @return the locales and localized third comments of this schedule exception
	 */
	@Override
	public Map<java.util.Locale, String> getThirdCommentMap() {
		return model.getThirdCommentMap();
	}

	/**
	 * Returns the uuid of this schedule exception.
	 *
	 * @return the uuid of this schedule exception
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this schedule exception is closed.
	 *
	 * @return <code>true</code> if this schedule exception is closed; <code>false</code> otherwise
	 */
	@Override
	public boolean isClosed() {
		return model.isClosed();
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
	 * Sets whether this schedule exception is closed.
	 *
	 * @param closed the closed of this schedule exception
	 */
	@Override
	public void setClosed(boolean closed) {
		model.setClosed(closed);
	}

	/**
	 * Sets the comment of this schedule exception.
	 *
	 * @param comment the comment of this schedule exception
	 */
	@Override
	public void setComment(String comment) {
		model.setComment(comment);
	}

	/**
	 * Sets the localized comment of this schedule exception in the language.
	 *
	 * @param comment the localized comment of this schedule exception
	 * @param locale the locale of the language
	 */
	@Override
	public void setComment(String comment, java.util.Locale locale) {
		model.setComment(comment, locale);
	}

	/**
	 * Sets the localized comment of this schedule exception in the language, and sets the default locale.
	 *
	 * @param comment the localized comment of this schedule exception
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setComment(
		String comment, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setComment(comment, locale, defaultLocale);
	}

	@Override
	public void setCommentCurrentLanguageId(String languageId) {
		model.setCommentCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized comments of this schedule exception from the map of locales and localized comments.
	 *
	 * @param commentMap the locales and localized comments of this schedule exception
	 */
	@Override
	public void setCommentMap(Map<java.util.Locale, String> commentMap) {
		model.setCommentMap(commentMap);
	}

	/**
	 * Sets the localized comments of this schedule exception from the map of locales and localized comments, and sets the default locale.
	 *
	 * @param commentMap the locales and localized comments of this schedule exception
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setCommentMap(
		Map<java.util.Locale, String> commentMap,
		java.util.Locale defaultLocale) {

		model.setCommentMap(commentMap, defaultLocale);
	}

	/**
	 * Sets the end date of this schedule exception.
	 *
	 * @param endDate the end date of this schedule exception
	 */
	@Override
	public void setEndDate(Date endDate) {
		model.setEndDate(endDate);
	}

	/**
	 * Sets the exception ID of this schedule exception.
	 *
	 * @param exceptionId the exception ID of this schedule exception
	 */
	@Override
	public void setExceptionId(long exceptionId) {
		model.setExceptionId(exceptionId);
	}

	/**
	 * Sets the fifth comment of this schedule exception.
	 *
	 * @param fifthComment the fifth comment of this schedule exception
	 */
	@Override
	public void setFifthComment(String fifthComment) {
		model.setFifthComment(fifthComment);
	}

	/**
	 * Sets the localized fifth comment of this schedule exception in the language.
	 *
	 * @param fifthComment the localized fifth comment of this schedule exception
	 * @param locale the locale of the language
	 */
	@Override
	public void setFifthComment(String fifthComment, java.util.Locale locale) {
		model.setFifthComment(fifthComment, locale);
	}

	/**
	 * Sets the localized fifth comment of this schedule exception in the language, and sets the default locale.
	 *
	 * @param fifthComment the localized fifth comment of this schedule exception
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setFifthComment(
		String fifthComment, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setFifthComment(fifthComment, locale, defaultLocale);
	}

	@Override
	public void setFifthCommentCurrentLanguageId(String languageId) {
		model.setFifthCommentCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized fifth comments of this schedule exception from the map of locales and localized fifth comments.
	 *
	 * @param fifthCommentMap the locales and localized fifth comments of this schedule exception
	 */
	@Override
	public void setFifthCommentMap(
		Map<java.util.Locale, String> fifthCommentMap) {

		model.setFifthCommentMap(fifthCommentMap);
	}

	/**
	 * Sets the localized fifth comments of this schedule exception from the map of locales and localized fifth comments, and sets the default locale.
	 *
	 * @param fifthCommentMap the locales and localized fifth comments of this schedule exception
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setFifthCommentMap(
		Map<java.util.Locale, String> fifthCommentMap,
		java.util.Locale defaultLocale) {

		model.setFifthCommentMap(fifthCommentMap, defaultLocale);
	}

	/**
	 * Sets the first comment of this schedule exception.
	 *
	 * @param firstComment the first comment of this schedule exception
	 */
	@Override
	public void setFirstComment(String firstComment) {
		model.setFirstComment(firstComment);
	}

	/**
	 * Sets the localized first comment of this schedule exception in the language.
	 *
	 * @param firstComment the localized first comment of this schedule exception
	 * @param locale the locale of the language
	 */
	@Override
	public void setFirstComment(String firstComment, java.util.Locale locale) {
		model.setFirstComment(firstComment, locale);
	}

	/**
	 * Sets the localized first comment of this schedule exception in the language, and sets the default locale.
	 *
	 * @param firstComment the localized first comment of this schedule exception
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setFirstComment(
		String firstComment, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setFirstComment(firstComment, locale, defaultLocale);
	}

	@Override
	public void setFirstCommentCurrentLanguageId(String languageId) {
		model.setFirstCommentCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized first comments of this schedule exception from the map of locales and localized first comments.
	 *
	 * @param firstCommentMap the locales and localized first comments of this schedule exception
	 */
	@Override
	public void setFirstCommentMap(
		Map<java.util.Locale, String> firstCommentMap) {

		model.setFirstCommentMap(firstCommentMap);
	}

	/**
	 * Sets the localized first comments of this schedule exception from the map of locales and localized first comments, and sets the default locale.
	 *
	 * @param firstCommentMap the locales and localized first comments of this schedule exception
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setFirstCommentMap(
		Map<java.util.Locale, String> firstCommentMap,
		java.util.Locale defaultLocale) {

		model.setFirstCommentMap(firstCommentMap, defaultLocale);
	}

	/**
	 * Sets the fourth comment of this schedule exception.
	 *
	 * @param fourthComment the fourth comment of this schedule exception
	 */
	@Override
	public void setFourthComment(String fourthComment) {
		model.setFourthComment(fourthComment);
	}

	/**
	 * Sets the localized fourth comment of this schedule exception in the language.
	 *
	 * @param fourthComment the localized fourth comment of this schedule exception
	 * @param locale the locale of the language
	 */
	@Override
	public void setFourthComment(
		String fourthComment, java.util.Locale locale) {

		model.setFourthComment(fourthComment, locale);
	}

	/**
	 * Sets the localized fourth comment of this schedule exception in the language, and sets the default locale.
	 *
	 * @param fourthComment the localized fourth comment of this schedule exception
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setFourthComment(
		String fourthComment, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setFourthComment(fourthComment, locale, defaultLocale);
	}

	@Override
	public void setFourthCommentCurrentLanguageId(String languageId) {
		model.setFourthCommentCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized fourth comments of this schedule exception from the map of locales and localized fourth comments.
	 *
	 * @param fourthCommentMap the locales and localized fourth comments of this schedule exception
	 */
	@Override
	public void setFourthCommentMap(
		Map<java.util.Locale, String> fourthCommentMap) {

		model.setFourthCommentMap(fourthCommentMap);
	}

	/**
	 * Sets the localized fourth comments of this schedule exception from the map of locales and localized fourth comments, and sets the default locale.
	 *
	 * @param fourthCommentMap the locales and localized fourth comments of this schedule exception
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setFourthCommentMap(
		Map<java.util.Locale, String> fourthCommentMap,
		java.util.Locale defaultLocale) {

		model.setFourthCommentMap(fourthCommentMap, defaultLocale);
	}

	/**
	 * Sets the opening times of this schedule exception.
	 *
	 * @param openingTimes the opening times of this schedule exception
	 */
	@Override
	public void setOpeningTimes(String openingTimes) {
		model.setOpeningTimes(openingTimes);
	}

	/**
	 * Sets the place ID of this schedule exception.
	 *
	 * @param placeId the place ID of this schedule exception
	 */
	@Override
	public void setPlaceId(long placeId) {
		model.setPlaceId(placeId);
	}

	/**
	 * Sets the primary key of this schedule exception.
	 *
	 * @param primaryKey the primary key of this schedule exception
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the second comment of this schedule exception.
	 *
	 * @param secondComment the second comment of this schedule exception
	 */
	@Override
	public void setSecondComment(String secondComment) {
		model.setSecondComment(secondComment);
	}

	/**
	 * Sets the localized second comment of this schedule exception in the language.
	 *
	 * @param secondComment the localized second comment of this schedule exception
	 * @param locale the locale of the language
	 */
	@Override
	public void setSecondComment(
		String secondComment, java.util.Locale locale) {

		model.setSecondComment(secondComment, locale);
	}

	/**
	 * Sets the localized second comment of this schedule exception in the language, and sets the default locale.
	 *
	 * @param secondComment the localized second comment of this schedule exception
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setSecondComment(
		String secondComment, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setSecondComment(secondComment, locale, defaultLocale);
	}

	@Override
	public void setSecondCommentCurrentLanguageId(String languageId) {
		model.setSecondCommentCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized second comments of this schedule exception from the map of locales and localized second comments.
	 *
	 * @param secondCommentMap the locales and localized second comments of this schedule exception
	 */
	@Override
	public void setSecondCommentMap(
		Map<java.util.Locale, String> secondCommentMap) {

		model.setSecondCommentMap(secondCommentMap);
	}

	/**
	 * Sets the localized second comments of this schedule exception from the map of locales and localized second comments, and sets the default locale.
	 *
	 * @param secondCommentMap the locales and localized second comments of this schedule exception
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setSecondCommentMap(
		Map<java.util.Locale, String> secondCommentMap,
		java.util.Locale defaultLocale) {

		model.setSecondCommentMap(secondCommentMap, defaultLocale);
	}

	/**
	 * Sets the start date of this schedule exception.
	 *
	 * @param startDate the start date of this schedule exception
	 */
	@Override
	public void setStartDate(Date startDate) {
		model.setStartDate(startDate);
	}

	/**
	 * Sets the sub place ID of this schedule exception.
	 *
	 * @param subPlaceId the sub place ID of this schedule exception
	 */
	@Override
	public void setSubPlaceId(long subPlaceId) {
		model.setSubPlaceId(subPlaceId);
	}

	/**
	 * Sets the third comment of this schedule exception.
	 *
	 * @param thirdComment the third comment of this schedule exception
	 */
	@Override
	public void setThirdComment(String thirdComment) {
		model.setThirdComment(thirdComment);
	}

	/**
	 * Sets the localized third comment of this schedule exception in the language.
	 *
	 * @param thirdComment the localized third comment of this schedule exception
	 * @param locale the locale of the language
	 */
	@Override
	public void setThirdComment(String thirdComment, java.util.Locale locale) {
		model.setThirdComment(thirdComment, locale);
	}

	/**
	 * Sets the localized third comment of this schedule exception in the language, and sets the default locale.
	 *
	 * @param thirdComment the localized third comment of this schedule exception
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setThirdComment(
		String thirdComment, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setThirdComment(thirdComment, locale, defaultLocale);
	}

	@Override
	public void setThirdCommentCurrentLanguageId(String languageId) {
		model.setThirdCommentCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized third comments of this schedule exception from the map of locales and localized third comments.
	 *
	 * @param thirdCommentMap the locales and localized third comments of this schedule exception
	 */
	@Override
	public void setThirdCommentMap(
		Map<java.util.Locale, String> thirdCommentMap) {

		model.setThirdCommentMap(thirdCommentMap);
	}

	/**
	 * Sets the localized third comments of this schedule exception from the map of locales and localized third comments, and sets the default locale.
	 *
	 * @param thirdCommentMap the locales and localized third comments of this schedule exception
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setThirdCommentMap(
		Map<java.util.Locale, String> thirdCommentMap,
		java.util.Locale defaultLocale) {

		model.setThirdCommentMap(thirdCommentMap, defaultLocale);
	}

	/**
	 * Sets the uuid of this schedule exception.
	 *
	 * @param uuid the uuid of this schedule exception
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Retourne la version CSMap JSON des exceptions
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONObject toCSMapJSON() {
		return model.toCSMapJSON();
	}

	/**
	 * Retourne la version JSON des exceptions
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
	protected ScheduleExceptionWrapper wrap(
		ScheduleException scheduleException) {

		return new ScheduleExceptionWrapper(scheduleException);
	}

}