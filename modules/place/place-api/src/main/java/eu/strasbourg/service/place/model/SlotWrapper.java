/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.place.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Slot}.
 * </p>
 *
 * @author Angelique Zunino Champougny
 * @see Slot
 * @generated
 */
public class SlotWrapper
	extends BaseModelWrapper<Slot> implements ModelWrapper<Slot>, Slot {

	public SlotWrapper(Slot slot) {
		super(slot);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("slotId", getSlotId());
		attributes.put("dayOfWeek", getDayOfWeek());
		attributes.put("startHour", getStartHour());
		attributes.put("endHour", getEndHour());
		attributes.put("comment", getComment());
		attributes.put("periodId", getPeriodId());
		attributes.put("subPlaceId", getSubPlaceId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long slotId = (Long)attributes.get("slotId");

		if (slotId != null) {
			setSlotId(slotId);
		}

		Long dayOfWeek = (Long)attributes.get("dayOfWeek");

		if (dayOfWeek != null) {
			setDayOfWeek(dayOfWeek);
		}

		String startHour = (String)attributes.get("startHour");

		if (startHour != null) {
			setStartHour(startHour);
		}

		String endHour = (String)attributes.get("endHour");

		if (endHour != null) {
			setEndHour(endHour);
		}

		String comment = (String)attributes.get("comment");

		if (comment != null) {
			setComment(comment);
		}

		Long periodId = (Long)attributes.get("periodId");

		if (periodId != null) {
			setPeriodId(periodId);
		}

		Long subPlaceId = (Long)attributes.get("subPlaceId");

		if (subPlaceId != null) {
			setSubPlaceId(subPlaceId);
		}
	}

	@Override
	public Slot cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the comment of this slot.
	 *
	 * @return the comment of this slot
	 */
	@Override
	public String getComment() {
		return model.getComment();
	}

	/**
	 * Returns the localized comment of this slot in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized comment of this slot
	 */
	@Override
	public String getComment(java.util.Locale locale) {
		return model.getComment(locale);
	}

	/**
	 * Returns the localized comment of this slot in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized comment of this slot. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getComment(java.util.Locale locale, boolean useDefault) {
		return model.getComment(locale, useDefault);
	}

	/**
	 * Returns the localized comment of this slot in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized comment of this slot
	 */
	@Override
	public String getComment(String languageId) {
		return model.getComment(languageId);
	}

	/**
	 * Returns the localized comment of this slot in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized comment of this slot
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
	 * Returns a map of the locales and localized comments of this slot.
	 *
	 * @return the locales and localized comments of this slot
	 */
	@Override
	public Map<java.util.Locale, String> getCommentMap() {
		return model.getCommentMap();
	}

	/**
	 * Returns the day of week of this slot.
	 *
	 * @return the day of week of this slot
	 */
	@Override
	public long getDayOfWeek() {
		return model.getDayOfWeek();
	}

	@Override
	public String getDefaultLanguageId() {
		return model.getDefaultLanguageId();
	}

	/**
	 * Returns the end hour of this slot.
	 *
	 * @return the end hour of this slot
	 */
	@Override
	public String getEndHour() {
		return model.getEndHour();
	}

	/**
	 * Returns the period ID of this slot.
	 *
	 * @return the period ID of this slot
	 */
	@Override
	public long getPeriodId() {
		return model.getPeriodId();
	}

	/**
	 * Returns the primary key of this slot.
	 *
	 * @return the primary key of this slot
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the slot ID of this slot.
	 *
	 * @return the slot ID of this slot
	 */
	@Override
	public long getSlotId() {
		return model.getSlotId();
	}

	/**
	 * Returns the start hour of this slot.
	 *
	 * @return the start hour of this slot
	 */
	@Override
	public String getStartHour() {
		return model.getStartHour();
	}

	/**
	 * Returns the sub place ID of this slot.
	 *
	 * @return the sub place ID of this slot
	 */
	@Override
	public long getSubPlaceId() {
		return model.getSubPlaceId();
	}

	/**
	 * Returns the uuid of this slot.
	 *
	 * @return the uuid of this slot
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
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
	 * Sets the comment of this slot.
	 *
	 * @param comment the comment of this slot
	 */
	@Override
	public void setComment(String comment) {
		model.setComment(comment);
	}

	/**
	 * Sets the localized comment of this slot in the language.
	 *
	 * @param comment the localized comment of this slot
	 * @param locale the locale of the language
	 */
	@Override
	public void setComment(String comment, java.util.Locale locale) {
		model.setComment(comment, locale);
	}

	/**
	 * Sets the localized comment of this slot in the language, and sets the default locale.
	 *
	 * @param comment the localized comment of this slot
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
	 * Sets the localized comments of this slot from the map of locales and localized comments.
	 *
	 * @param commentMap the locales and localized comments of this slot
	 */
	@Override
	public void setCommentMap(Map<java.util.Locale, String> commentMap) {
		model.setCommentMap(commentMap);
	}

	/**
	 * Sets the localized comments of this slot from the map of locales and localized comments, and sets the default locale.
	 *
	 * @param commentMap the locales and localized comments of this slot
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setCommentMap(
		Map<java.util.Locale, String> commentMap,
		java.util.Locale defaultLocale) {

		model.setCommentMap(commentMap, defaultLocale);
	}

	/**
	 * Sets the day of week of this slot.
	 *
	 * @param dayOfWeek the day of week of this slot
	 */
	@Override
	public void setDayOfWeek(long dayOfWeek) {
		model.setDayOfWeek(dayOfWeek);
	}

	/**
	 * Sets the end hour of this slot.
	 *
	 * @param endHour the end hour of this slot
	 */
	@Override
	public void setEndHour(String endHour) {
		model.setEndHour(endHour);
	}

	/**
	 * Sets the period ID of this slot.
	 *
	 * @param periodId the period ID of this slot
	 */
	@Override
	public void setPeriodId(long periodId) {
		model.setPeriodId(periodId);
	}

	/**
	 * Sets the primary key of this slot.
	 *
	 * @param primaryKey the primary key of this slot
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the slot ID of this slot.
	 *
	 * @param slotId the slot ID of this slot
	 */
	@Override
	public void setSlotId(long slotId) {
		model.setSlotId(slotId);
	}

	/**
	 * Sets the start hour of this slot.
	 *
	 * @param startHour the start hour of this slot
	 */
	@Override
	public void setStartHour(String startHour) {
		model.setStartHour(startHour);
	}

	/**
	 * Sets the sub place ID of this slot.
	 *
	 * @param subPlaceId the sub place ID of this slot
	 */
	@Override
	public void setSubPlaceId(long subPlaceId) {
		model.setSubPlaceId(subPlaceId);
	}

	/**
	 * Sets the uuid of this slot.
	 *
	 * @param uuid the uuid of this slot
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Retourne la version JSON des horaires
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
	protected SlotWrapper wrap(Slot slot) {
		return new SlotWrapper(slot);
	}

}