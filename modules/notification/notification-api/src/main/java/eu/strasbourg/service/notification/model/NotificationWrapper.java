/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.notification.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Notification}.
 * </p>
 *
 * @author BenjaminBini
 * @see Notification
 * @generated
 */
public class NotificationWrapper
	extends BaseModelWrapper<Notification>
	implements ModelWrapper<Notification>, Notification {

	public NotificationWrapper(Notification notification) {
		super(notification);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("notificationId", getNotificationId());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("url", getUrl());
		attributes.put("automatic", isAutomatic());
		attributes.put("singleUser", isSingleUser());
		attributes.put("singleUserId", getSingleUserId());
		attributes.put("publicationDate", getPublicationDate());
		attributes.put("expirationDate", getExpirationDate());
		attributes.put("status", getStatus());
		attributes.put("typeId", getTypeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long notificationId = (Long)attributes.get("notificationId");

		if (notificationId != null) {
			setNotificationId(notificationId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}

		Boolean automatic = (Boolean)attributes.get("automatic");

		if (automatic != null) {
			setAutomatic(automatic);
		}

		Boolean singleUser = (Boolean)attributes.get("singleUser");

		if (singleUser != null) {
			setSingleUser(singleUser);
		}

		String singleUserId = (String)attributes.get("singleUserId");

		if (singleUserId != null) {
			setSingleUserId(singleUserId);
		}

		Date publicationDate = (Date)attributes.get("publicationDate");

		if (publicationDate != null) {
			setPublicationDate(publicationDate);
		}

		Date expirationDate = (Date)attributes.get("expirationDate");

		if (expirationDate != null) {
			setExpirationDate(expirationDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long typeId = (Long)attributes.get("typeId");

		if (typeId != null) {
			setTypeId(typeId);
		}
	}

	@Override
	public Notification cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the automatic of this notification.
	 *
	 * @return the automatic of this notification
	 */
	@Override
	public boolean getAutomatic() {
		return model.getAutomatic();
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	@Override
	public String getDefaultLanguageId() {
		return model.getDefaultLanguageId();
	}

	/**
	 * Returns the description of this notification.
	 *
	 * @return the description of this notification
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the localized description of this notification in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description of this notification
	 */
	@Override
	public String getDescription(java.util.Locale locale) {
		return model.getDescription(locale);
	}

	/**
	 * Returns the localized description of this notification in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this notification. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getDescription(java.util.Locale locale, boolean useDefault) {
		return model.getDescription(locale, useDefault);
	}

	/**
	 * Returns the localized description of this notification in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description of this notification
	 */
	@Override
	public String getDescription(String languageId) {
		return model.getDescription(languageId);
	}

	/**
	 * Returns the localized description of this notification in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this notification
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
	 * Returns a map of the locales and localized descriptions of this notification.
	 *
	 * @return the locales and localized descriptions of this notification
	 */
	@Override
	public Map<java.util.Locale, String> getDescriptionMap() {
		return model.getDescriptionMap();
	}

	/**
	 * Returns the expiration date of this notification.
	 *
	 * @return the expiration date of this notification
	 */
	@Override
	public Date getExpirationDate() {
		return model.getExpirationDate();
	}

	/**
	 * Returns the notification ID of this notification.
	 *
	 * @return the notification ID of this notification
	 */
	@Override
	public long getNotificationId() {
		return model.getNotificationId();
	}

	/**
	 * Returns the primary key of this notification.
	 *
	 * @return the primary key of this notification
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the publication date of this notification.
	 *
	 * @return the publication date of this notification
	 */
	@Override
	public Date getPublicationDate() {
		return model.getPublicationDate();
	}

	/**
	 * Returns the single user of this notification.
	 *
	 * @return the single user of this notification
	 */
	@Override
	public boolean getSingleUser() {
		return model.getSingleUser();
	}

	/**
	 * Returns the single user ID of this notification.
	 *
	 * @return the single user ID of this notification
	 */
	@Override
	public String getSingleUserId() {
		return model.getSingleUserId();
	}

	/**
	 * Returns the status of this notification.
	 *
	 * @return the status of this notification
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the title of this notification.
	 *
	 * @return the title of this notification
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the localized title of this notification in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized title of this notification
	 */
	@Override
	public String getTitle(java.util.Locale locale) {
		return model.getTitle(locale);
	}

	/**
	 * Returns the localized title of this notification in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this notification. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getTitle(java.util.Locale locale, boolean useDefault) {
		return model.getTitle(locale, useDefault);
	}

	/**
	 * Returns the localized title of this notification in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized title of this notification
	 */
	@Override
	public String getTitle(String languageId) {
		return model.getTitle(languageId);
	}

	/**
	 * Returns the localized title of this notification in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this notification
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
	 * Returns a map of the locales and localized titles of this notification.
	 *
	 * @return the locales and localized titles of this notification
	 */
	@Override
	public Map<java.util.Locale, String> getTitleMap() {
		return model.getTitleMap();
	}

	/**
	 * Retourne le type de la notification
	 */
	@Override
	public com.liferay.asset.kernel.model.AssetCategory getType() {
		return model.getType();
	}

	/**
	 * Returns the type ID of this notification.
	 *
	 * @return the type ID of this notification
	 */
	@Override
	public long getTypeId() {
		return model.getTypeId();
	}

	/**
	 * Returns the url of this notification.
	 *
	 * @return the url of this notification
	 */
	@Override
	public String getUrl() {
		return model.getUrl();
	}

	/**
	 * Retourne la liste des utilisateurs concernés par la notification
	 */
	@Override
	public java.util.List<eu.strasbourg.service.oidc.model.PublikUser>
		getUsersToNotify() {

		return model.getUsersToNotify();
	}

	/**
	 * Returns <code>true</code> if this notification is automatic.
	 *
	 * @return <code>true</code> if this notification is automatic; <code>false</code> otherwise
	 */
	@Override
	public boolean isAutomatic() {
		return model.isAutomatic();
	}

	/**
	 * Returns <code>true</code> if this notification is single user.
	 *
	 * @return <code>true</code> if this notification is single user; <code>false</code> otherwise
	 */
	@Override
	public boolean isSingleUser() {
		return model.isSingleUser();
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
	 * Sets whether this notification is automatic.
	 *
	 * @param automatic the automatic of this notification
	 */
	@Override
	public void setAutomatic(boolean automatic) {
		model.setAutomatic(automatic);
	}

	/**
	 * Sets the description of this notification.
	 *
	 * @param description the description of this notification
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the localized description of this notification in the language.
	 *
	 * @param description the localized description of this notification
	 * @param locale the locale of the language
	 */
	@Override
	public void setDescription(String description, java.util.Locale locale) {
		model.setDescription(description, locale);
	}

	/**
	 * Sets the localized description of this notification in the language, and sets the default locale.
	 *
	 * @param description the localized description of this notification
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
	 * Sets the localized descriptions of this notification from the map of locales and localized descriptions.
	 *
	 * @param descriptionMap the locales and localized descriptions of this notification
	 */
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, String> descriptionMap) {

		model.setDescriptionMap(descriptionMap);
	}

	/**
	 * Sets the localized descriptions of this notification from the map of locales and localized descriptions, and sets the default locale.
	 *
	 * @param descriptionMap the locales and localized descriptions of this notification
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, String> descriptionMap,
		java.util.Locale defaultLocale) {

		model.setDescriptionMap(descriptionMap, defaultLocale);
	}

	/**
	 * Sets the expiration date of this notification.
	 *
	 * @param expirationDate the expiration date of this notification
	 */
	@Override
	public void setExpirationDate(Date expirationDate) {
		model.setExpirationDate(expirationDate);
	}

	/**
	 * Sets the notification ID of this notification.
	 *
	 * @param notificationId the notification ID of this notification
	 */
	@Override
	public void setNotificationId(long notificationId) {
		model.setNotificationId(notificationId);
	}

	/**
	 * Sets the primary key of this notification.
	 *
	 * @param primaryKey the primary key of this notification
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the publication date of this notification.
	 *
	 * @param publicationDate the publication date of this notification
	 */
	@Override
	public void setPublicationDate(Date publicationDate) {
		model.setPublicationDate(publicationDate);
	}

	/**
	 * Sets whether this notification is single user.
	 *
	 * @param singleUser the single user of this notification
	 */
	@Override
	public void setSingleUser(boolean singleUser) {
		model.setSingleUser(singleUser);
	}

	/**
	 * Sets the single user ID of this notification.
	 *
	 * @param singleUserId the single user ID of this notification
	 */
	@Override
	public void setSingleUserId(String singleUserId) {
		model.setSingleUserId(singleUserId);
	}

	/**
	 * Sets the status of this notification.
	 *
	 * @param status the status of this notification
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the title of this notification.
	 *
	 * @param title the title of this notification
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the localized title of this notification in the language.
	 *
	 * @param title the localized title of this notification
	 * @param locale the locale of the language
	 */
	@Override
	public void setTitle(String title, java.util.Locale locale) {
		model.setTitle(title, locale);
	}

	/**
	 * Sets the localized title of this notification in the language, and sets the default locale.
	 *
	 * @param title the localized title of this notification
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
	 * Sets the localized titles of this notification from the map of locales and localized titles.
	 *
	 * @param titleMap the locales and localized titles of this notification
	 */
	@Override
	public void setTitleMap(Map<java.util.Locale, String> titleMap) {
		model.setTitleMap(titleMap);
	}

	/**
	 * Sets the localized titles of this notification from the map of locales and localized titles, and sets the default locale.
	 *
	 * @param titleMap the locales and localized titles of this notification
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setTitleMap(
		Map<java.util.Locale, String> titleMap,
		java.util.Locale defaultLocale) {

		model.setTitleMap(titleMap, defaultLocale);
	}

	/**
	 * Sets the type ID of this notification.
	 *
	 * @param typeId the type ID of this notification
	 */
	@Override
	public void setTypeId(long typeId) {
		model.setTypeId(typeId);
	}

	/**
	 * Sets the url of this notification.
	 *
	 * @param url the url of this notification
	 */
	@Override
	public void setUrl(String url) {
		model.setUrl(url);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected NotificationWrapper wrap(Notification notification) {
		return new NotificationWrapper(notification);
	}

}