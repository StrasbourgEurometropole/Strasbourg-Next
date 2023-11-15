/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package eu.strasbourg.service.oidc.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PublikUser}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PublikUser
 * @generated
 */
public class PublikUserWrapper
	extends BaseModelWrapper<PublikUser>
	implements ModelWrapper<PublikUser>, PublikUser {

	public PublikUserWrapper(PublikUser publikUser) {
		super(publikUser);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("publikUserLiferayId", getPublikUserLiferayId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("publikId", getPublikId());
		attributes.put("accessToken", getAccessToken());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("email", getEmail());
		attributes.put("mapConfig", getMapConfig());
		attributes.put("displayConfig", getDisplayConfig());
		attributes.put("pactSignature", getPactSignature());
		attributes.put("banishDate", getBanishDate());
		attributes.put("banishDescription", getBanishDescription());
		attributes.put("imageURL", getImageURL());
		attributes.put("pactDisplay", isPactDisplay());
		attributes.put("csmapJSON", getCsmapJSON());
		attributes.put("modifiedDateJSON", getModifiedDateJSON());
		attributes.put("topicsFCM", getTopicsFCM());
		attributes.put("lastUpdateTimeTopics", getLastUpdateTimeTopics());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long publikUserLiferayId = (Long)attributes.get("publikUserLiferayId");

		if (publikUserLiferayId != null) {
			setPublikUserLiferayId(publikUserLiferayId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		String publikId = (String)attributes.get("publikId");

		if (publikId != null) {
			setPublikId(publikId);
		}

		String accessToken = (String)attributes.get("accessToken");

		if (accessToken != null) {
			setAccessToken(accessToken);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String mapConfig = (String)attributes.get("mapConfig");

		if (mapConfig != null) {
			setMapConfig(mapConfig);
		}

		String displayConfig = (String)attributes.get("displayConfig");

		if (displayConfig != null) {
			setDisplayConfig(displayConfig);
		}

		Date pactSignature = (Date)attributes.get("pactSignature");

		if (pactSignature != null) {
			setPactSignature(pactSignature);
		}

		Date banishDate = (Date)attributes.get("banishDate");

		if (banishDate != null) {
			setBanishDate(banishDate);
		}

		String banishDescription = (String)attributes.get("banishDescription");

		if (banishDescription != null) {
			setBanishDescription(banishDescription);
		}

		String imageURL = (String)attributes.get("imageURL");

		if (imageURL != null) {
			setImageURL(imageURL);
		}

		Boolean pactDisplay = (Boolean)attributes.get("pactDisplay");

		if (pactDisplay != null) {
			setPactDisplay(pactDisplay);
		}

		String csmapJSON = (String)attributes.get("csmapJSON");

		if (csmapJSON != null) {
			setCsmapJSON(csmapJSON);
		}

		Date modifiedDateJSON = (Date)attributes.get("modifiedDateJSON");

		if (modifiedDateJSON != null) {
			setModifiedDateJSON(modifiedDateJSON);
		}

		String topicsFCM = (String)attributes.get("topicsFCM");

		if (topicsFCM != null) {
			setTopicsFCM(topicsFCM);
		}

		Long lastUpdateTimeTopics = (Long)attributes.get(
			"lastUpdateTimeTopics");

		if (lastUpdateTimeTopics != null) {
			setLastUpdateTimeTopics(lastUpdateTimeTopics);
		}
	}

	@Override
	public PublikUser cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the access token of this publik user.
	 *
	 * @return the access token of this publik user
	 */
	@Override
	public String getAccessToken() {
		return model.getAccessToken();
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the banish date of this publik user.
	 *
	 * @return the banish date of this publik user
	 */
	@Override
	public Date getBanishDate() {
		return model.getBanishDate();
	}

	/**
	 * Returns the banish description of this publik user.
	 *
	 * @return the banish description of this publik user
	 */
	@Override
	public String getBanishDescription() {
		return model.getBanishDescription();
	}

	/**
	 * Returns the localized banish description of this publik user in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized banish description of this publik user
	 */
	@Override
	public String getBanishDescription(java.util.Locale locale) {
		return model.getBanishDescription(locale);
	}

	/**
	 * Returns the localized banish description of this publik user in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized banish description of this publik user. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getBanishDescription(
		java.util.Locale locale, boolean useDefault) {

		return model.getBanishDescription(locale, useDefault);
	}

	/**
	 * Returns the localized banish description of this publik user in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized banish description of this publik user
	 */
	@Override
	public String getBanishDescription(String languageId) {
		return model.getBanishDescription(languageId);
	}

	/**
	 * Returns the localized banish description of this publik user in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized banish description of this publik user
	 */
	@Override
	public String getBanishDescription(String languageId, boolean useDefault) {
		return model.getBanishDescription(languageId, useDefault);
	}

	@Override
	public String getBanishDescriptionCurrentLanguageId() {
		return model.getBanishDescriptionCurrentLanguageId();
	}

	@Override
	public String getBanishDescriptionCurrentValue() {
		return model.getBanishDescriptionCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized banish descriptions of this publik user.
	 *
	 * @return the locales and localized banish descriptions of this publik user
	 */
	@Override
	public Map<java.util.Locale, String> getBanishDescriptionMap() {
		return model.getBanishDescriptionMap();
	}

	/**
	 * Returns the create date of this publik user.
	 *
	 * @return the create date of this publik user
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the csmap json of this publik user.
	 *
	 * @return the csmap json of this publik user
	 */
	@Override
	public String getCsmapJSON() {
		return model.getCsmapJSON();
	}

	@Override
	public String getDefaultLanguageId() {
		return model.getDefaultLanguageId();
	}

	/**
	 * Returns the display config of this publik user.
	 *
	 * @return the display config of this publik user
	 */
	@Override
	public String getDisplayConfig() {
		return model.getDisplayConfig();
	}

	/**
	 * Returns the email of this publik user.
	 *
	 * @return the email of this publik user
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the first name of this publik user.
	 *
	 * @return the first name of this publik user
	 */
	@Override
	public String getFirstName() {
		return model.getFirstName();
	}

	/**
	 * Returns the image url of this publik user.
	 *
	 * @return the image url of this publik user
	 */
	@Override
	public String getImageURL() {
		return model.getImageURL();
	}

	/**
	 * Retourne l'image de profil ou le substitut
	 */
	@Override
	public String getImageURLOrSurrogate() {
		return model.getImageURLOrSurrogate();
	}

	/**
	 * Returns the last name of this publik user.
	 *
	 * @return the last name of this publik user
	 */
	@Override
	public String getLastName() {
		return model.getLastName();
	}

	/**
	 * Returns the last update time topics of this publik user.
	 *
	 * @return the last update time topics of this publik user
	 */
	@Override
	public long getLastUpdateTimeTopics() {
		return model.getLastUpdateTimeTopics();
	}

	/**
	 * Returns the map config of this publik user.
	 *
	 * @return the map config of this publik user
	 */
	@Override
	public String getMapConfig() {
		return model.getMapConfig();
	}

	/**
	 * Returns the modified date of this publik user.
	 *
	 * @return the modified date of this publik user
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the modified date json of this publik user.
	 *
	 * @return the modified date json of this publik user
	 */
	@Override
	public Date getModifiedDateJSON() {
		return model.getModifiedDateJSON();
	}

	/**
	 * Returns the pact display of this publik user.
	 *
	 * @return the pact display of this publik user
	 */
	@Override
	public boolean getPactDisplay() {
		return model.getPactDisplay();
	}

	/**
	 * Returns the pact signature of this publik user.
	 *
	 * @return the pact signature of this publik user
	 */
	@Override
	public Date getPactSignature() {
		return model.getPactSignature();
	}

	/**
	 * Returns the primary key of this publik user.
	 *
	 * @return the primary key of this publik user
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the publik ID of this publik user.
	 *
	 * @return the publik ID of this publik user
	 */
	@Override
	public String getPublikId() {
		return model.getPublikId();
	}

	/**
	 * Returns the publik user liferay ID of this publik user.
	 *
	 * @return the publik user liferay ID of this publik user
	 */
	@Override
	public long getPublikUserLiferayId() {
		return model.getPublikUserLiferayId();
	}

	/**
	 * Returns the topics fcm of this publik user.
	 *
	 * @return the topics fcm of this publik user
	 */
	@Override
	public String getTopicsFCM() {
		return model.getTopicsFCM();
	}

	/**
	 * Returns the user ID of this publik user.
	 *
	 * @return the user ID of this publik user
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this publik user.
	 *
	 * @return the user name of this publik user
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this publik user.
	 *
	 * @return the user uuid of this publik user
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this publik user.
	 *
	 * @return the uuid of this publik user
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * L'utilisateur est-il en perdiode de bannissement ?
	 */
	@Override
	public boolean isBanned() {
		return model.isBanned();
	}

	/**
	 * Returns <code>true</code> if this publik user is pact display.
	 *
	 * @return <code>true</code> if this publik user is pact display; <code>false</code> otherwise
	 */
	@Override
	public boolean isPactDisplay() {
		return model.isPactDisplay();
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
	 * Sets the access token of this publik user.
	 *
	 * @param accessToken the access token of this publik user
	 */
	@Override
	public void setAccessToken(String accessToken) {
		model.setAccessToken(accessToken);
	}

	/**
	 * Sets the banish date of this publik user.
	 *
	 * @param banishDate the banish date of this publik user
	 */
	@Override
	public void setBanishDate(Date banishDate) {
		model.setBanishDate(banishDate);
	}

	/**
	 * Sets the banish description of this publik user.
	 *
	 * @param banishDescription the banish description of this publik user
	 */
	@Override
	public void setBanishDescription(String banishDescription) {
		model.setBanishDescription(banishDescription);
	}

	/**
	 * Sets the localized banish description of this publik user in the language.
	 *
	 * @param banishDescription the localized banish description of this publik user
	 * @param locale the locale of the language
	 */
	@Override
	public void setBanishDescription(
		String banishDescription, java.util.Locale locale) {

		model.setBanishDescription(banishDescription, locale);
	}

	/**
	 * Sets the localized banish description of this publik user in the language, and sets the default locale.
	 *
	 * @param banishDescription the localized banish description of this publik user
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setBanishDescription(
		String banishDescription, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setBanishDescription(banishDescription, locale, defaultLocale);
	}

	@Override
	public void setBanishDescriptionCurrentLanguageId(String languageId) {
		model.setBanishDescriptionCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized banish descriptions of this publik user from the map of locales and localized banish descriptions.
	 *
	 * @param banishDescriptionMap the locales and localized banish descriptions of this publik user
	 */
	@Override
	public void setBanishDescriptionMap(
		Map<java.util.Locale, String> banishDescriptionMap) {

		model.setBanishDescriptionMap(banishDescriptionMap);
	}

	/**
	 * Sets the localized banish descriptions of this publik user from the map of locales and localized banish descriptions, and sets the default locale.
	 *
	 * @param banishDescriptionMap the locales and localized banish descriptions of this publik user
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setBanishDescriptionMap(
		Map<java.util.Locale, String> banishDescriptionMap,
		java.util.Locale defaultLocale) {

		model.setBanishDescriptionMap(banishDescriptionMap, defaultLocale);
	}

	/**
	 * Sets the create date of this publik user.
	 *
	 * @param createDate the create date of this publik user
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the csmap json of this publik user.
	 *
	 * @param csmapJSON the csmap json of this publik user
	 */
	@Override
	public void setCsmapJSON(String csmapJSON) {
		model.setCsmapJSON(csmapJSON);
	}

	/**
	 * Sets the display config of this publik user.
	 *
	 * @param displayConfig the display config of this publik user
	 */
	@Override
	public void setDisplayConfig(String displayConfig) {
		model.setDisplayConfig(displayConfig);
	}

	/**
	 * Sets the email of this publik user.
	 *
	 * @param email the email of this publik user
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the first name of this publik user.
	 *
	 * @param firstName the first name of this publik user
	 */
	@Override
	public void setFirstName(String firstName) {
		model.setFirstName(firstName);
	}

	/**
	 * Sets the image url of this publik user.
	 *
	 * @param imageURL the image url of this publik user
	 */
	@Override
	public void setImageURL(String imageURL) {
		model.setImageURL(imageURL);
	}

	/**
	 * Sets the last name of this publik user.
	 *
	 * @param lastName the last name of this publik user
	 */
	@Override
	public void setLastName(String lastName) {
		model.setLastName(lastName);
	}

	/**
	 * Sets the last update time topics of this publik user.
	 *
	 * @param lastUpdateTimeTopics the last update time topics of this publik user
	 */
	@Override
	public void setLastUpdateTimeTopics(long lastUpdateTimeTopics) {
		model.setLastUpdateTimeTopics(lastUpdateTimeTopics);
	}

	/**
	 * Sets the map config of this publik user.
	 *
	 * @param mapConfig the map config of this publik user
	 */
	@Override
	public void setMapConfig(String mapConfig) {
		model.setMapConfig(mapConfig);
	}

	/**
	 * Sets the modified date of this publik user.
	 *
	 * @param modifiedDate the modified date of this publik user
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the modified date json of this publik user.
	 *
	 * @param modifiedDateJSON the modified date json of this publik user
	 */
	@Override
	public void setModifiedDateJSON(Date modifiedDateJSON) {
		model.setModifiedDateJSON(modifiedDateJSON);
	}

	/**
	 * Sets whether this publik user is pact display.
	 *
	 * @param pactDisplay the pact display of this publik user
	 */
	@Override
	public void setPactDisplay(boolean pactDisplay) {
		model.setPactDisplay(pactDisplay);
	}

	/**
	 * Sets the pact signature of this publik user.
	 *
	 * @param pactSignature the pact signature of this publik user
	 */
	@Override
	public void setPactSignature(Date pactSignature) {
		model.setPactSignature(pactSignature);
	}

	/**
	 * Sets the primary key of this publik user.
	 *
	 * @param primaryKey the primary key of this publik user
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the publik ID of this publik user.
	 *
	 * @param publikId the publik ID of this publik user
	 */
	@Override
	public void setPublikId(String publikId) {
		model.setPublikId(publikId);
	}

	/**
	 * Sets the publik user liferay ID of this publik user.
	 *
	 * @param publikUserLiferayId the publik user liferay ID of this publik user
	 */
	@Override
	public void setPublikUserLiferayId(long publikUserLiferayId) {
		model.setPublikUserLiferayId(publikUserLiferayId);
	}

	/**
	 * Sets the topics fcm of this publik user.
	 *
	 * @param topicsFCM the topics fcm of this publik user
	 */
	@Override
	public void setTopicsFCM(String topicsFCM) {
		model.setTopicsFCM(topicsFCM);
	}

	/**
	 * Sets the user ID of this publik user.
	 *
	 * @param userId the user ID of this publik user
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this publik user.
	 *
	 * @param userName the user name of this publik user
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this publik user.
	 *
	 * @param userUuid the user uuid of this publik user
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this publik user.
	 *
	 * @param uuid the uuid of this publik user
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
	protected PublikUserWrapper wrap(PublikUser publikUser) {
		return new PublikUserWrapper(publikUser);
	}

}