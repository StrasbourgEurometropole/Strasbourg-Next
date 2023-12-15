/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.notif.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Message}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Message
 * @generated
 */
public class MessageWrapper
	extends BaseModelWrapper<Message>
	implements Message, ModelWrapper<Message> {

	public MessageWrapper(Message message) {
		super(message);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("messageId", getMessageId());
		attributes.put("serviceId", getServiceId());
		attributes.put("content", getContent());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long messageId = (Long)attributes.get("messageId");

		if (messageId != null) {
			setMessageId(messageId);
		}

		Long serviceId = (Long)attributes.get("serviceId");

		if (serviceId != null) {
			setServiceId(serviceId);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}
	}

	@Override
	public Message cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the content of this message.
	 *
	 * @return the content of this message
	 */
	@Override
	public String getContent() {
		return model.getContent();
	}

	/**
	 * Returns the localized content of this message in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized content of this message
	 */
	@Override
	public String getContent(java.util.Locale locale) {
		return model.getContent(locale);
	}

	/**
	 * Returns the localized content of this message in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized content of this message. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getContent(java.util.Locale locale, boolean useDefault) {
		return model.getContent(locale, useDefault);
	}

	/**
	 * Returns the localized content of this message in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized content of this message
	 */
	@Override
	public String getContent(String languageId) {
		return model.getContent(languageId);
	}

	/**
	 * Returns the localized content of this message in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized content of this message
	 */
	@Override
	public String getContent(String languageId, boolean useDefault) {
		return model.getContent(languageId, useDefault);
	}

	@Override
	public String getContentCurrentLanguageId() {
		return model.getContentCurrentLanguageId();
	}

	@Override
	public String getContentCurrentValue() {
		return model.getContentCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized contents of this message.
	 *
	 * @return the locales and localized contents of this message
	 */
	@Override
	public Map<java.util.Locale, String> getContentMap() {
		return model.getContentMap();
	}

	@Override
	public String getDefaultLanguageId() {
		return model.getDefaultLanguageId();
	}

	/**
	 * Returns the message ID of this message.
	 *
	 * @return the message ID of this message
	 */
	@Override
	public long getMessageId() {
		return model.getMessageId();
	}

	/**
	 * Returns the primary key of this message.
	 *
	 * @return the primary key of this message
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the service ID of this message.
	 *
	 * @return the service ID of this message
	 */
	@Override
	public long getServiceId() {
		return model.getServiceId();
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
	 * Sets the content of this message.
	 *
	 * @param content the content of this message
	 */
	@Override
	public void setContent(String content) {
		model.setContent(content);
	}

	/**
	 * Sets the localized content of this message in the language.
	 *
	 * @param content the localized content of this message
	 * @param locale the locale of the language
	 */
	@Override
	public void setContent(String content, java.util.Locale locale) {
		model.setContent(content, locale);
	}

	/**
	 * Sets the localized content of this message in the language, and sets the default locale.
	 *
	 * @param content the localized content of this message
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setContent(
		String content, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setContent(content, locale, defaultLocale);
	}

	@Override
	public void setContentCurrentLanguageId(String languageId) {
		model.setContentCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized contents of this message from the map of locales and localized contents.
	 *
	 * @param contentMap the locales and localized contents of this message
	 */
	@Override
	public void setContentMap(Map<java.util.Locale, String> contentMap) {
		model.setContentMap(contentMap);
	}

	/**
	 * Sets the localized contents of this message from the map of locales and localized contents, and sets the default locale.
	 *
	 * @param contentMap the locales and localized contents of this message
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setContentMap(
		Map<java.util.Locale, String> contentMap,
		java.util.Locale defaultLocale) {

		model.setContentMap(contentMap, defaultLocale);
	}

	/**
	 * Sets the message ID of this message.
	 *
	 * @param messageId the message ID of this message
	 */
	@Override
	public void setMessageId(long messageId) {
		model.setMessageId(messageId);
	}

	/**
	 * Sets the primary key of this message.
	 *
	 * @param primaryKey the primary key of this message
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the service ID of this message.
	 *
	 * @param serviceId the service ID of this message
	 */
	@Override
	public void setServiceId(long serviceId) {
		model.setServiceId(serviceId);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected MessageWrapper wrap(Message message) {
		return new MessageWrapper(message);
	}

}