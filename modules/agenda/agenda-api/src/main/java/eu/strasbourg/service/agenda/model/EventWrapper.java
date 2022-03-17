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

package eu.strasbourg.service.agenda.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Event}.
 * </p>
 *
 * @author BenjaminBini
 * @see Event
 * @generated
 */
@ProviderType
public class EventWrapper implements Event, ModelWrapper<Event> {

	public EventWrapper(Event event) {
		_event = event;
	}

	@Override
	public Class<?> getModelClass() {
		return Event.class;
	}

	@Override
	public String getModelClassName() {
		return Event.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("eventId", getEventId());
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
		attributes.put("subtitle", getSubtitle());
		attributes.put("description", getDescription());
		attributes.put("externalImageURL", getExternalImageURL());
		attributes.put("externalImageCopyright", getExternalImageCopyright());
		attributes.put("imageWidth", getImageWidth());
		attributes.put("imageHeight", getImageHeight());
		attributes.put("placeSIGId", getPlaceSIGId());
		attributes.put("placeName", getPlaceName());
		attributes.put("placeStreetNumber", getPlaceStreetNumber());
		attributes.put("placeStreetName", getPlaceStreetName());
		attributes.put("placeZipCode", getPlaceZipCode());
		attributes.put("placeCity", getPlaceCity());
		attributes.put("placeCountry", getPlaceCountry());
		attributes.put("mercatorX", getMercatorX());
		attributes.put("mercatorY", getMercatorY());
		attributes.put("access", getAccess());
		attributes.put("accessForDisabled", getAccessForDisabled());
		attributes.put("accessForBlind", getAccessForBlind());
		attributes.put("accessForDeaf", getAccessForDeaf());
		attributes.put("accessForWheelchair", getAccessForWheelchair());
		attributes.put("accessForElder", getAccessForElder());
		attributes.put("accessForDeficient", getAccessForDeficient());
		attributes.put("promoter", getPromoter());
		attributes.put("phone", getPhone());
		attributes.put("email", getEmail());
		attributes.put("websiteURL", getWebsiteURL());
		attributes.put("websiteName", getWebsiteName());
		attributes.put("free", getFree());
		attributes.put("price", getPrice());
		attributes.put("bookingDescription", getBookingDescription());
		attributes.put("bookingURL", getBookingURL());
		attributes.put("subscriptionURL", getSubscriptionURL());
		attributes.put("source", getSource());
		attributes.put("idSource", getIdSource());
		attributes.put("publicationDate", getPublicationDate());
		attributes.put("distribution", getDistribution());
		attributes.put("composer", getComposer());
		attributes.put("concertId", getConcertId());
		attributes.put("program", getProgram());
		attributes.put("firstStartDate", getFirstStartDate());
		attributes.put("lastEndDate", getLastEndDate());
		attributes.put("createDateSource", getCreateDateSource());
		attributes.put("modifiedDateSource", getModifiedDateSource());
		attributes.put("imageId", getImageId());
		attributes.put("registration", isRegistration());
		attributes.put("registrationStartDate", getRegistrationStartDate());
		attributes.put("registrationEndDate", getRegistrationEndDate());
		attributes.put("maxGauge", getMaxGauge());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long eventId = (Long)attributes.get("eventId");

		if (eventId != null) {
			setEventId(eventId);
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

		String subtitle = (String)attributes.get("subtitle");

		if (subtitle != null) {
			setSubtitle(subtitle);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String externalImageURL = (String)attributes.get("externalImageURL");

		if (externalImageURL != null) {
			setExternalImageURL(externalImageURL);
		}

		String externalImageCopyright = (String)attributes.get(
			"externalImageCopyright");

		if (externalImageCopyright != null) {
			setExternalImageCopyright(externalImageCopyright);
		}

		Integer imageWidth = (Integer)attributes.get("imageWidth");

		if (imageWidth != null) {
			setImageWidth(imageWidth);
		}

		Integer imageHeight = (Integer)attributes.get("imageHeight");

		if (imageHeight != null) {
			setImageHeight(imageHeight);
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

		String placeCity = (String)attributes.get("placeCity");

		if (placeCity != null) {
			setPlaceCity(placeCity);
		}

		String placeCountry = (String)attributes.get("placeCountry");

		if (placeCountry != null) {
			setPlaceCountry(placeCountry);
		}

		String mercatorX = (String)attributes.get("mercatorX");

		if (mercatorX != null) {
			setMercatorX(mercatorX);
		}

		String mercatorY = (String)attributes.get("mercatorY");

		if (mercatorY != null) {
			setMercatorY(mercatorY);
		}

		String access = (String)attributes.get("access");

		if (access != null) {
			setAccess(access);
		}

		String accessForDisabled = (String)attributes.get("accessForDisabled");

		if (accessForDisabled != null) {
			setAccessForDisabled(accessForDisabled);
		}

		Boolean accessForBlind = (Boolean)attributes.get("accessForBlind");

		if (accessForBlind != null) {
			setAccessForBlind(accessForBlind);
		}

		Boolean accessForDeaf = (Boolean)attributes.get("accessForDeaf");

		if (accessForDeaf != null) {
			setAccessForDeaf(accessForDeaf);
		}

		Boolean accessForWheelchair = (Boolean)attributes.get(
			"accessForWheelchair");

		if (accessForWheelchair != null) {
			setAccessForWheelchair(accessForWheelchair);
		}

		Boolean accessForElder = (Boolean)attributes.get("accessForElder");

		if (accessForElder != null) {
			setAccessForElder(accessForElder);
		}

		Boolean accessForDeficient = (Boolean)attributes.get(
			"accessForDeficient");

		if (accessForDeficient != null) {
			setAccessForDeficient(accessForDeficient);
		}

		String promoter = (String)attributes.get("promoter");

		if (promoter != null) {
			setPromoter(promoter);
		}

		String phone = (String)attributes.get("phone");

		if (phone != null) {
			setPhone(phone);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String websiteURL = (String)attributes.get("websiteURL");

		if (websiteURL != null) {
			setWebsiteURL(websiteURL);
		}

		String websiteName = (String)attributes.get("websiteName");

		if (websiteName != null) {
			setWebsiteName(websiteName);
		}

		Integer free = (Integer)attributes.get("free");

		if (free != null) {
			setFree(free);
		}

		String price = (String)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}

		String bookingDescription = (String)attributes.get(
			"bookingDescription");

		if (bookingDescription != null) {
			setBookingDescription(bookingDescription);
		}

		String bookingURL = (String)attributes.get("bookingURL");

		if (bookingURL != null) {
			setBookingURL(bookingURL);
		}

		String subscriptionURL = (String)attributes.get("subscriptionURL");

		if (subscriptionURL != null) {
			setSubscriptionURL(subscriptionURL);
		}

		String source = (String)attributes.get("source");

		if (source != null) {
			setSource(source);
		}

		String idSource = (String)attributes.get("idSource");

		if (idSource != null) {
			setIdSource(idSource);
		}

		Date publicationDate = (Date)attributes.get("publicationDate");

		if (publicationDate != null) {
			setPublicationDate(publicationDate);
		}

		String distribution = (String)attributes.get("distribution");

		if (distribution != null) {
			setDistribution(distribution);
		}

		String composer = (String)attributes.get("composer");

		if (composer != null) {
			setComposer(composer);
		}

		String concertId = (String)attributes.get("concertId");

		if (concertId != null) {
			setConcertId(concertId);
		}

		String program = (String)attributes.get("program");

		if (program != null) {
			setProgram(program);
		}

		Date firstStartDate = (Date)attributes.get("firstStartDate");

		if (firstStartDate != null) {
			setFirstStartDate(firstStartDate);
		}

		Date lastEndDate = (Date)attributes.get("lastEndDate");

		if (lastEndDate != null) {
			setLastEndDate(lastEndDate);
		}

		Date createDateSource = (Date)attributes.get("createDateSource");

		if (createDateSource != null) {
			setCreateDateSource(createDateSource);
		}

		Date modifiedDateSource = (Date)attributes.get("modifiedDateSource");

		if (modifiedDateSource != null) {
			setModifiedDateSource(modifiedDateSource);
		}

		Long imageId = (Long)attributes.get("imageId");

		if (imageId != null) {
			setImageId(imageId);
		}

		Boolean registration = (Boolean)attributes.get("registration");

		if (registration != null) {
			setRegistration(registration);
		}

		Date registrationStartDate = (Date)attributes.get(
			"registrationStartDate");

		if (registrationStartDate != null) {
			setRegistrationStartDate(registrationStartDate);
		}

		Date registrationEndDate = (Date)attributes.get("registrationEndDate");

		if (registrationEndDate != null) {
			setRegistrationEndDate(registrationEndDate);
		}

		Long maxGauge = (Long)attributes.get("maxGauge");

		if (maxGauge != null) {
			setMaxGauge(maxGauge);
		}
	}

	@Override
	public Object clone() {
		return new EventWrapper((Event)_event.clone());
	}

	@Override
	public int compareTo(eu.strasbourg.service.agenda.model.Event event) {
		return _event.compareTo(event);
	}

	/**
	 * Returns the access of this event.
	 *
	 * @return the access of this event
	 */
	@Override
	public String getAccess() {
		return _event.getAccess();
	}

	/**
	 * Returns the localized access of this event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized access of this event
	 */
	@Override
	public String getAccess(java.util.Locale locale) {
		return _event.getAccess(locale);
	}

	/**
	 * Returns the localized access of this event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized access of this event. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getAccess(java.util.Locale locale, boolean useDefault) {
		return _event.getAccess(locale, useDefault);
	}

	/**
	 * Returns the localized access of this event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized access of this event
	 */
	@Override
	public String getAccess(String languageId) {
		return _event.getAccess(languageId);
	}

	/**
	 * Returns the localized access of this event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized access of this event
	 */
	@Override
	public String getAccess(String languageId, boolean useDefault) {
		return _event.getAccess(languageId, useDefault);
	}

	@Override
	public String getAccessCurrentLanguageId() {
		return _event.getAccessCurrentLanguageId();
	}

	@Override
	public String getAccessCurrentValue() {
		return _event.getAccessCurrentValue();
	}

	/**
	 * Returns the access for blind of this event.
	 *
	 * @return the access for blind of this event
	 */
	@Override
	public Boolean getAccessForBlind() {
		return _event.getAccessForBlind();
	}

	/**
	 * Returns the access for deaf of this event.
	 *
	 * @return the access for deaf of this event
	 */
	@Override
	public Boolean getAccessForDeaf() {
		return _event.getAccessForDeaf();
	}

	/**
	 * Returns the access for deficient of this event.
	 *
	 * @return the access for deficient of this event
	 */
	@Override
	public Boolean getAccessForDeficient() {
		return _event.getAccessForDeficient();
	}

	/**
	 * Returns the access for disabled of this event.
	 *
	 * @return the access for disabled of this event
	 */
	@Override
	public String getAccessForDisabled() {
		return _event.getAccessForDisabled();
	}

	/**
	 * Returns the localized access for disabled of this event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized access for disabled of this event
	 */
	@Override
	public String getAccessForDisabled(java.util.Locale locale) {
		return _event.getAccessForDisabled(locale);
	}

	/**
	 * Returns the localized access for disabled of this event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized access for disabled of this event. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getAccessForDisabled(
		java.util.Locale locale, boolean useDefault) {

		return _event.getAccessForDisabled(locale, useDefault);
	}

	/**
	 * Returns the localized access for disabled of this event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized access for disabled of this event
	 */
	@Override
	public String getAccessForDisabled(String languageId) {
		return _event.getAccessForDisabled(languageId);
	}

	/**
	 * Returns the localized access for disabled of this event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized access for disabled of this event
	 */
	@Override
	public String getAccessForDisabled(String languageId, boolean useDefault) {
		return _event.getAccessForDisabled(languageId, useDefault);
	}

	@Override
	public String getAccessForDisabledCurrentLanguageId() {
		return _event.getAccessForDisabledCurrentLanguageId();
	}

	@Override
	public String getAccessForDisabledCurrentValue() {
		return _event.getAccessForDisabledCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized access for disableds of this event.
	 *
	 * @return the locales and localized access for disableds of this event
	 */
	@Override
	public Map<java.util.Locale, String> getAccessForDisabledMap() {
		return _event.getAccessForDisabledMap();
	}

	/**
	 * Returns the access for elder of this event.
	 *
	 * @return the access for elder of this event
	 */
	@Override
	public Boolean getAccessForElder() {
		return _event.getAccessForElder();
	}

	/**
	 * Returns the access for wheelchair of this event.
	 *
	 * @return the access for wheelchair of this event
	 */
	@Override
	public Boolean getAccessForWheelchair() {
		return _event.getAccessForWheelchair();
	}

	/**
	 * Returns a map of the locales and localized accesses of this event.
	 *
	 * @return the locales and localized accesses of this event
	 */
	@Override
	public Map<java.util.Locale, String> getAccessMap() {
		return _event.getAccessMap();
	}

	/**
	 * Retourne les commentaires de l'entité
	 */
	@Override
	public java.util.List<eu.strasbourg.service.comment.model.Comment>
		getApprovedComments() {

		return _event.getApprovedComments();
	}

	/**
	 * Retourne l'AssetEntry rattaché cet item
	 */
	@Override
	public com.liferay.asset.kernel.model.AssetEntry getAssetEntry() {
		return _event.getAssetEntry();
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return _event.getAvailableLanguageIds();
	}

	/**
	 * Returns the booking description of this event.
	 *
	 * @return the booking description of this event
	 */
	@Override
	public String getBookingDescription() {
		return _event.getBookingDescription();
	}

	/**
	 * Returns the localized booking description of this event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized booking description of this event
	 */
	@Override
	public String getBookingDescription(java.util.Locale locale) {
		return _event.getBookingDescription(locale);
	}

	/**
	 * Returns the localized booking description of this event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized booking description of this event. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getBookingDescription(
		java.util.Locale locale, boolean useDefault) {

		return _event.getBookingDescription(locale, useDefault);
	}

	/**
	 * Returns the localized booking description of this event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized booking description of this event
	 */
	@Override
	public String getBookingDescription(String languageId) {
		return _event.getBookingDescription(languageId);
	}

	/**
	 * Returns the localized booking description of this event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized booking description of this event
	 */
	@Override
	public String getBookingDescription(String languageId, boolean useDefault) {
		return _event.getBookingDescription(languageId, useDefault);
	}

	@Override
	public String getBookingDescriptionCurrentLanguageId() {
		return _event.getBookingDescriptionCurrentLanguageId();
	}

	@Override
	public String getBookingDescriptionCurrentValue() {
		return _event.getBookingDescriptionCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized booking descriptions of this event.
	 *
	 * @return the locales and localized booking descriptions of this event
	 */
	@Override
	public Map<java.util.Locale, String> getBookingDescriptionMap() {
		return _event.getBookingDescriptionMap();
	}

	/**
	 * Returns the booking url of this event.
	 *
	 * @return the booking url of this event
	 */
	@Override
	public String getBookingURL() {
		return _event.getBookingURL();
	}

	/**
	 * Renvoie la liste des AssetCategory rattachées à cet item (via l'assetEntry)
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCategories() {

		return _event.getCategories();
	}

	/**
	 * Retourne le nom de la ville, provenant du lieu interne s'il existe, du lieu
	 * lié sinon
	 */
	@Override
	public String getCity(java.util.Locale locale) {
		return _event.getCity(locale);
	}

	/**
	 * Returns the company ID of this event.
	 *
	 * @return the company ID of this event
	 */
	@Override
	public long getCompanyId() {
		return _event.getCompanyId();
	}

	/**
	 * Retourne l'adresse complete du lieu SIG ou "manuel"
	 */
	@Override
	public String getCompleteAddress(java.util.Locale locale) {
		return _event.getCompleteAddress(locale);
	}

	/**
	 * Returns the composer of this event.
	 *
	 * @return the composer of this event
	 */
	@Override
	public String getComposer() {
		return _event.getComposer();
	}

	/**
	 * Returns the concert ID of this event.
	 *
	 * @return the concert ID of this event
	 */
	@Override
	public String getConcertId() {
		return _event.getConcertId();
	}

	/**
	 * Returns the create date of this event.
	 *
	 * @return the create date of this event
	 */
	@Override
	public Date getCreateDate() {
		return _event.getCreateDate();
	}

	/**
	 * Returns the create date source of this event.
	 *
	 * @return the create date source of this event
	 */
	@Override
	public Date getCreateDateSource() {
		return _event.getCreateDateSource();
	}

	/**
	 * Renvoie le JSON de l'entite au format CSMap
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONObject getCSMapJSON() {
		return _event.getCSMapJSON();
	}

	/**
	 * Retourne la liste des périodes courantes et futures auxuqlles l'événement à
	 * lieu
	 */
	@Override
	public java.util.List<eu.strasbourg.service.agenda.model.EventPeriod>
		getCurrentAndFuturePeriods() {

		return _event.getCurrentAndFuturePeriods();
	}

	/**
	 * Retourne la période courrante, ou la prochaine
	 */
	@Override
	public eu.strasbourg.service.agenda.model.EventPeriod
		getCurrentOrFuturePeriod() {

		return _event.getCurrentOrFuturePeriod();
	}

	@Override
	public String getCurrentOrFuturePeriodStringDate() {
		return _event.getCurrentOrFuturePeriodStringDate();
	}

	@Override
	public String getDefaultLanguageId() {
		return _event.getDefaultLanguageId();
	}

	/**
	 * Returns the description of this event.
	 *
	 * @return the description of this event
	 */
	@Override
	public String getDescription() {
		return _event.getDescription();
	}

	/**
	 * Returns the localized description of this event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description of this event
	 */
	@Override
	public String getDescription(java.util.Locale locale) {
		return _event.getDescription(locale);
	}

	/**
	 * Returns the localized description of this event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this event. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getDescription(java.util.Locale locale, boolean useDefault) {
		return _event.getDescription(locale, useDefault);
	}

	/**
	 * Returns the localized description of this event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description of this event
	 */
	@Override
	public String getDescription(String languageId) {
		return _event.getDescription(languageId);
	}

	/**
	 * Returns the localized description of this event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this event
	 */
	@Override
	public String getDescription(String languageId, boolean useDefault) {
		return _event.getDescription(languageId, useDefault);
	}

	@Override
	public String getDescriptionCurrentLanguageId() {
		return _event.getDescriptionCurrentLanguageId();
	}

	@Override
	public String getDescriptionCurrentValue() {
		return _event.getDescriptionCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized descriptions of this event.
	 *
	 * @return the locales and localized descriptions of this event
	 */
	@Override
	public Map<java.util.Locale, String> getDescriptionMap() {
		return _event.getDescriptionMap();
	}

	/**
	 * Returns the distribution of this event.
	 *
	 * @return the distribution of this event
	 */
	@Override
	public String getDistribution() {
		return _event.getDistribution();
	}

	/**
	 * Returns the localized distribution of this event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized distribution of this event
	 */
	@Override
	public String getDistribution(java.util.Locale locale) {
		return _event.getDistribution(locale);
	}

	/**
	 * Returns the localized distribution of this event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized distribution of this event. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getDistribution(java.util.Locale locale, boolean useDefault) {
		return _event.getDistribution(locale, useDefault);
	}

	/**
	 * Returns the localized distribution of this event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized distribution of this event
	 */
	@Override
	public String getDistribution(String languageId) {
		return _event.getDistribution(languageId);
	}

	/**
	 * Returns the localized distribution of this event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized distribution of this event
	 */
	@Override
	public String getDistribution(String languageId, boolean useDefault) {
		return _event.getDistribution(languageId, useDefault);
	}

	@Override
	public String getDistributionCurrentLanguageId() {
		return _event.getDistributionCurrentLanguageId();
	}

	@Override
	public String getDistributionCurrentValue() {
		return _event.getDistributionCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized distributions of this event.
	 *
	 * @return the locales and localized distributions of this event
	 */
	@Override
	public Map<java.util.Locale, String> getDistributionMap() {
		return _event.getDistributionMap();
	}

	/**
	 * Returns the email of this event.
	 *
	 * @return the email of this event
	 */
	@Override
	public String getEmail() {
		return _event.getEmail();
	}

	/**
	 * Returns the event ID of this event.
	 *
	 * @return the event ID of this event
	 */
	@Override
	public long getEventId() {
		return _event.getEventId();
	}

	/**
	 * Retourne la liste des participations de l'evenement
	 */
	@Override
	public java.util.List<eu.strasbourg.service.agenda.model.EventParticipation>
		getEventParticipations() {

		return _event.getEventParticipations();
	}

	/**
	 * Retourne la liste des périodes auxquelles l'événement à lieu (classées par
	 * date de début croissante)
	 */
	@Override
	public java.util.List<eu.strasbourg.service.agenda.model.EventPeriod>
		getEventPeriods() {

		return _event.getEventPeriods();
	}

	/**
	 * Retourne la période principale de l'événement (de la première date de début à
	 * la dernière date de fin) sous forme de String dans la locale passée en
	 * paramètre
	 */
	@Override
	public String getEventScheduleDisplay(java.util.Locale locale) {
		return _event.getEventScheduleDisplay(locale);
	}

	/**
	 * Retourne la période principale de l'événement (de la première date de début à
	 * la dernière date de fin) sous forme de String dans la locale passée en
	 * paramètre
	 */
	@Override
	public String getEventScheduleDisplay(
		java.util.Locale locale, boolean dispYear, boolean dispShortMonth) {

		return _event.getEventScheduleDisplay(locale, dispYear, dispShortMonth);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _event.getExpandoBridge();
	}

	/**
	 * Returns the external image copyright of this event.
	 *
	 * @return the external image copyright of this event
	 */
	@Override
	public String getExternalImageCopyright() {
		return _event.getExternalImageCopyright();
	}

	/**
	 * Returns the external image url of this event.
	 *
	 * @return the external image url of this event
	 */
	@Override
	public String getExternalImageURL() {
		return _event.getExternalImageURL();
	}

	/**
	 * Returns the first start date of this event.
	 *
	 * @return the first start date of this event
	 */
	@Override
	public Date getFirstStartDate() {
		return _event.getFirstStartDate();
	}

	/**
	 * Returns the free of this event.
	 *
	 * @return the free of this event
	 */
	@Override
	public Integer getFree() {
		return _event.getFree();
	}

	/**
	 * Renvoie le JSON de l'entite au format GeoJSON pour la map
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONObject getGeoJSON(
		long groupId, java.util.Locale locale) {

		return _event.getGeoJSON(groupId, locale);
	}

	/**
	 * Returns the group ID of this event.
	 *
	 * @return the group ID of this event
	 */
	@Override
	public long getGroupId() {
		return _event.getGroupId();
	}

	/**
	 * Returns the id source of this event.
	 *
	 * @return the id source of this event
	 */
	@Override
	public String getIdSource() {
		return _event.getIdSource();
	}

	/**
	 * Retourne le copyright de l'image principale
	 */
	@Override
	public String getImageCopyright(java.util.Locale locale) {
		return _event.getImageCopyright(locale);
	}

	/**
	 * Returns the image height of this event.
	 *
	 * @return the image height of this event
	 */
	@Override
	public Integer getImageHeight() {
		return _event.getImageHeight();
	}

	/**
	 * Returns the image ID of this event.
	 *
	 * @return the image ID of this event
	 */
	@Override
	public Long getImageId() {
		return _event.getImageId();
	}

	/**
	 * Retourne l'URL de l'image à partir de l'id du DLFileEntry
	 */
	@Override
	public String getImageURL() {
		return _event.getImageURL();
	}

	/**
	 * Returns the image width of this event.
	 *
	 * @return the image width of this event
	 */
	@Override
	public Integer getImageWidth() {
		return _event.getImageWidth();
	}

	/**
	 * Retourne le label des typologies de l'événement (Catégorie du site de l'OPS)
	 */
	@Override
	public String getLabelTypologies(java.util.Locale locale) {
		return _event.getLabelTypologies(locale);
	}

	/**
	 * Returns the last end date of this event.
	 *
	 * @return the last end date of this event
	 */
	@Override
	public Date getLastEndDate() {
		return _event.getLastEndDate();
	}

	/**
	 * Returns the last publish date of this event.
	 *
	 * @return the last publish date of this event
	 */
	@Override
	public Date getLastPublishDate() {
		return _event.getLastPublishDate();
	}

	/**
	 * Retourne la version live de l'édition, si elle existe
	 */
	@Override
	public eu.strasbourg.service.agenda.model.Event getLiveVersion() {
		return _event.getLiveVersion();
	}

	/**
	 * Retourne la liste des manifestations auxquelles cette édition appartient
	 */
	@Override
	public java.util.List<eu.strasbourg.service.agenda.model.Manifestation>
		getManifestations() {

		return _event.getManifestations();
	}

	/**
	 * Retourne la liste des IDs des manifestations auxquelles cette édition
	 * appartient sous forme de String
	 */
	@Override
	public String getManifestationsIds() {
		return _event.getManifestationsIds();
	}

	/**
	 * Returns the max gauge of this event.
	 *
	 * @return the max gauge of this event
	 */
	@Override
	public long getMaxGauge() {
		return _event.getMaxGauge();
	}

	/**
	 * Retourne les coordonnees mercator en axe X et Y Notes : permet de ne pas
	 * multiplier les appels
	 *
	 * @return tableau [mercatorX, mercatorY] sinon tableau vide
	 */
	@Override
	public java.util.List<String> getMercators() {
		return _event.getMercators();
	}

	/**
	 * Returns the mercator x of this event.
	 *
	 * @return the mercator x of this event
	 */
	@Override
	public String getMercatorX() {
		return _event.getMercatorX();
	}

	/**
	 * Returns the mercator y of this event.
	 *
	 * @return the mercator y of this event
	 */
	@Override
	public String getMercatorY() {
		return _event.getMercatorY();
	}

	/**
	 * Returns the modified date of this event.
	 *
	 * @return the modified date of this event
	 */
	@Override
	public Date getModifiedDate() {
		return _event.getModifiedDate();
	}

	/**
	 * Returns the modified date source of this event.
	 *
	 * @return the modified date source of this event
	 */
	@Override
	public Date getModifiedDateSource() {
		return _event.getModifiedDateSource();
	}

	/**
	 * Retourne le nombre de commentaires de l'entité
	 */
	@Override
	public int getNbApprovedComments() {
		return _event.getNbApprovedComments();
	}

	/**
	 * Retourne le nombre de participation a l'evenement
	 */
	@Override
	public int getNbEventParticipations() {
		return _event.getNbEventParticipations();
	}

	/**
	 * Retourne le label de 5 digits du nombre de participation a l'evenement
	 */
	@Override
	public String getNbEventParticipationsLabel() {
		return _event.getNbEventParticipationsLabel();
	}

	@Override
	public java.time.LocalDate getNextOpenDate() {
		return _event.getNextOpenDate();
	}

	/**
	 * Renvoie le titre de l'event pour friendlyUrl
	 */
	@Override
	public String getNormalizedTitle() {
		return _event.getNormalizedTitle();
	}

	/**
	 * Renvoie le titre de l'event pour friendlyUrl
	 */
	@Override
	public String getNormalizedTitle(java.util.Locale locale) {
		return _event.getNormalizedTitle(locale);
	}

	/**
	 * Returns the phone of this event.
	 *
	 * @return the phone of this event
	 */
	@Override
	public String getPhone() {
		return _event.getPhone();
	}

	/**
	 * Retourne l'adresse sans la ville
	 */
	@Override
	public String getPlaceAddress(java.util.Locale locale) {
		return _event.getPlaceAddress(locale);
	}

	/**
	 * Retourne l'adresse complète du lieu, provenant du lieu interne s'il existe,
	 * du lieu lié sinon
	 */
	@Override
	public String getPlaceAddressHTML(java.util.Locale locale) {
		return _event.getPlaceAddressHTML(locale);
	}

	/**
	 * Retourne le nom du lieu, provenant du lieu interne s'il existe, du lieu lié
	 * sinon
	 */
	@Override
	public String getPlaceAlias(java.util.Locale locale) {
		return _event.getPlaceAlias(locale);
	}

	/**
	 * Returns the place city of this event.
	 *
	 * @return the place city of this event
	 */
	@Override
	public String getPlaceCity() {
		return _event.getPlaceCity();
	}

	/**
	 * Retourne la ville
	 */
	@Override
	public String getPlaceCity(java.util.Locale locale) {
		return _event.getPlaceCity(locale);
	}

	/**
	 * Returns the place country of this event.
	 *
	 * @return the place country of this event
	 */
	@Override
	public String getPlaceCountry() {
		return _event.getPlaceCountry();
	}

	/**
	 * Retourne l'id du lieu de l'événement s'il existe, 0 sinon
	 */
	@Override
	public long getPlaceId() {
		return _event.getPlaceId();
	}

	/**
	 * Returns the place name of this event.
	 *
	 * @return the place name of this event
	 */
	@Override
	public String getPlaceName() {
		return _event.getPlaceName();
	}

	/**
	 * Returns the localized place name of this event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized place name of this event
	 */
	@Override
	public String getPlaceName(java.util.Locale locale) {
		return _event.getPlaceName(locale);
	}

	/**
	 * Returns the localized place name of this event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized place name of this event. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getPlaceName(java.util.Locale locale, boolean useDefault) {
		return _event.getPlaceName(locale, useDefault);
	}

	/**
	 * Returns the localized place name of this event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized place name of this event
	 */
	@Override
	public String getPlaceName(String languageId) {
		return _event.getPlaceName(languageId);
	}

	/**
	 * Returns the localized place name of this event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized place name of this event
	 */
	@Override
	public String getPlaceName(String languageId, boolean useDefault) {
		return _event.getPlaceName(languageId, useDefault);
	}

	@Override
	public String getPlaceNameCurrentLanguageId() {
		return _event.getPlaceNameCurrentLanguageId();
	}

	@Override
	public String getPlaceNameCurrentValue() {
		return _event.getPlaceNameCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized place names of this event.
	 *
	 * @return the locales and localized place names of this event
	 */
	@Override
	public Map<java.util.Locale, String> getPlaceNameMap() {
		return _event.getPlaceNameMap();
	}

	/**
	 * Returns the place sig ID of this event.
	 *
	 * @return the place sig ID of this event
	 */
	@Override
	public String getPlaceSIGId() {
		return _event.getPlaceSIGId();
	}

	/**
	 * Returns the place street name of this event.
	 *
	 * @return the place street name of this event
	 */
	@Override
	public String getPlaceStreetName() {
		return _event.getPlaceStreetName();
	}

	/**
	 * Returns the place street number of this event.
	 *
	 * @return the place street number of this event
	 */
	@Override
	public String getPlaceStreetNumber() {
		return _event.getPlaceStreetNumber();
	}

	/**
	 * Returns the place zip code of this event.
	 *
	 * @return the place zip code of this event
	 */
	@Override
	public String getPlaceZipCode() {
		return _event.getPlaceZipCode();
	}

	/**
	 * Returns the price of this event.
	 *
	 * @return the price of this event
	 */
	@Override
	public String getPrice() {
		return _event.getPrice();
	}

	/**
	 * Returns the localized price of this event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized price of this event
	 */
	@Override
	public String getPrice(java.util.Locale locale) {
		return _event.getPrice(locale);
	}

	/**
	 * Returns the localized price of this event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized price of this event. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getPrice(java.util.Locale locale, boolean useDefault) {
		return _event.getPrice(locale, useDefault);
	}

	/**
	 * Returns the localized price of this event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized price of this event
	 */
	@Override
	public String getPrice(String languageId) {
		return _event.getPrice(languageId);
	}

	/**
	 * Returns the localized price of this event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized price of this event
	 */
	@Override
	public String getPrice(String languageId, boolean useDefault) {
		return _event.getPrice(languageId, useDefault);
	}

	@Override
	public String getPriceCurrentLanguageId() {
		return _event.getPriceCurrentLanguageId();
	}

	@Override
	public String getPriceCurrentValue() {
		return _event.getPriceCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized prices of this event.
	 *
	 * @return the locales and localized prices of this event
	 */
	@Override
	public Map<java.util.Locale, String> getPriceMap() {
		return _event.getPriceMap();
	}

	/**
	 * Returns the primary key of this event.
	 *
	 * @return the primary key of this event
	 */
	@Override
	public long getPrimaryKey() {
		return _event.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _event.getPrimaryKeyObj();
	}

	/**
	 * Returns the program of this event.
	 *
	 * @return the program of this event
	 */
	@Override
	public String getProgram() {
		return _event.getProgram();
	}

	/**
	 * Returns the localized program of this event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized program of this event
	 */
	@Override
	public String getProgram(java.util.Locale locale) {
		return _event.getProgram(locale);
	}

	/**
	 * Returns the localized program of this event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized program of this event. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getProgram(java.util.Locale locale, boolean useDefault) {
		return _event.getProgram(locale, useDefault);
	}

	/**
	 * Returns the localized program of this event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized program of this event
	 */
	@Override
	public String getProgram(String languageId) {
		return _event.getProgram(languageId);
	}

	/**
	 * Returns the localized program of this event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized program of this event
	 */
	@Override
	public String getProgram(String languageId, boolean useDefault) {
		return _event.getProgram(languageId, useDefault);
	}

	@Override
	public String getProgramCurrentLanguageId() {
		return _event.getProgramCurrentLanguageId();
	}

	@Override
	public String getProgramCurrentValue() {
		return _event.getProgramCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized programs of this event.
	 *
	 * @return the locales and localized programs of this event
	 */
	@Override
	public Map<java.util.Locale, String> getProgramMap() {
		return _event.getProgramMap();
	}

	/**
	 * Returns the promoter of this event.
	 *
	 * @return the promoter of this event
	 */
	@Override
	public String getPromoter() {
		return _event.getPromoter();
	}

	/**
	 * Returns the publication date of this event.
	 *
	 * @return the publication date of this event
	 */
	@Override
	public Date getPublicationDate() {
		return _event.getPublicationDate();
	}

	/**
	 * Retourne le label des publics de l'événement
	 */
	@Override
	public String getPublicLabel(java.util.Locale locale) {
		return _event.getPublicLabel(locale);
	}

	/**
	 * Retourne les publics de l'événement
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getPublics() {

		return _event.getPublics();
	}

	/**
	 * Retourne la liste des galeries publiées
	 */
	@Override
	public java.util.List<eu.strasbourg.service.agenda.model.Manifestation>
		getPublishedManifestations() {

		return _event.getPublishedManifestations();
	}

	/**
	 * Returns the registration of this event.
	 *
	 * @return the registration of this event
	 */
	@Override
	public boolean getRegistration() {
		return _event.getRegistration();
	}

	/**
	 * Returns the registration end date of this event.
	 *
	 * @return the registration end date of this event
	 */
	@Override
	public Date getRegistrationEndDate() {
		return _event.getRegistrationEndDate();
	}

	/**
	 * Returns the registration start date of this event.
	 *
	 * @return the registration start date of this event
	 */
	@Override
	public Date getRegistrationStartDate() {
		return _event.getRegistrationStartDate();
	}

	/**
	 * Retourne les territoires de l'événement
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getServices() {

		return _event.getServices();
	}

	/**
	 * Renvoi les sessions de l'evenement obtenues par le webService Rodrigue
	 *
	 * @return
	 */
	@Override
	public java.util.List
		<eu.strasbourg.service.agenda.custom.beans.RodrigueEventSession>
			getSessionsFromRodrigue() {

		return _event.getSessionsFromRodrigue();
	}

	/**
	 * Renvoi les sessions de l'evenement obtenues par le webService Rodriguesous format JSON
	 *
	 * @return
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONArray
		getSessionsFromRodrigueInJSON() {

		return _event.getSessionsFromRodrigueInJSON();
	}

	/**
	 * Returns the source of this event.
	 *
	 * @return the source of this event
	 */
	@Override
	public String getSource() {
		return _event.getSource();
	}

	/**
	 * Retourne la date de début de la future ou courante période de l'événement
	 */
	@Override
	public Date getStartDateFirstCurrentAndFuturePeriod() {
		return _event.getStartDateFirstCurrentAndFuturePeriod();
	}

	/**
	 * Returns the status of this event.
	 *
	 * @return the status of this event
	 */
	@Override
	public int getStatus() {
		return _event.getStatus();
	}

	/**
	 * Returns the status by user ID of this event.
	 *
	 * @return the status by user ID of this event
	 */
	@Override
	public long getStatusByUserId() {
		return _event.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this event.
	 *
	 * @return the status by user name of this event
	 */
	@Override
	public String getStatusByUserName() {
		return _event.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this event.
	 *
	 * @return the status by user uuid of this event
	 */
	@Override
	public String getStatusByUserUuid() {
		return _event.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this event.
	 *
	 * @return the status date of this event
	 */
	@Override
	public Date getStatusDate() {
		return _event.getStatusDate();
	}

	/**
	 * Returns the subscription url of this event.
	 *
	 * @return the subscription url of this event
	 */
	@Override
	public String getSubscriptionURL() {
		return _event.getSubscriptionURL();
	}

	/**
	 * Returns the subtitle of this event.
	 *
	 * @return the subtitle of this event
	 */
	@Override
	public String getSubtitle() {
		return _event.getSubtitle();
	}

	/**
	 * Returns the localized subtitle of this event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized subtitle of this event
	 */
	@Override
	public String getSubtitle(java.util.Locale locale) {
		return _event.getSubtitle(locale);
	}

	/**
	 * Returns the localized subtitle of this event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized subtitle of this event. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getSubtitle(java.util.Locale locale, boolean useDefault) {
		return _event.getSubtitle(locale, useDefault);
	}

	/**
	 * Returns the localized subtitle of this event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized subtitle of this event
	 */
	@Override
	public String getSubtitle(String languageId) {
		return _event.getSubtitle(languageId);
	}

	/**
	 * Returns the localized subtitle of this event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized subtitle of this event
	 */
	@Override
	public String getSubtitle(String languageId, boolean useDefault) {
		return _event.getSubtitle(languageId, useDefault);
	}

	@Override
	public String getSubtitleCurrentLanguageId() {
		return _event.getSubtitleCurrentLanguageId();
	}

	@Override
	public String getSubtitleCurrentValue() {
		return _event.getSubtitleCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized subtitles of this event.
	 *
	 * @return the locales and localized subtitles of this event
	 */
	@Override
	public Map<java.util.Locale, String> getSubtitleMap() {
		return _event.getSubtitleMap();
	}

	/**
	 * Retourne X suggestions max pour un événement
	 *
	 * @param request  la requete
	 * @param nbSuggestions le nombre de suggestions.
	 * @param tag le tag a appliquer
	 * @param category la categorie a appliquer
	 * @return la liste d'événements.
	 */
	@Override
	public java.util.List<eu.strasbourg.service.agenda.model.Event>
			getSuggestions(
				javax.servlet.http.HttpServletRequest request,
				int nbSuggestions, String tag, String category)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.search.SearchException {

		return _event.getSuggestions(request, nbSuggestions, tag, category);
	}

	/**
	 * Retourne les territoires de l'événement
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getTerritories() {

		return _event.getTerritories();
	}

	/**
	 * Retourne le label des territoires de l'événement
	 */
	@Override
	public String getTerritoryLabel(java.util.Locale locale) {
		return _event.getTerritoryLabel(locale);
	}

	/**
	 * Retourne le label des thèmes de l'événement
	 */
	@Override
	public String getThemeLabel(java.util.Locale locale) {
		return _event.getThemeLabel(locale);
	}

	/**
	 * Retourne les themes de l'événement
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getThemes() {

		return _event.getThemes();
	}

	/**
	 * Returns the title of this event.
	 *
	 * @return the title of this event
	 */
	@Override
	public String getTitle() {
		return _event.getTitle();
	}

	/**
	 * Returns the localized title of this event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized title of this event
	 */
	@Override
	public String getTitle(java.util.Locale locale) {
		return _event.getTitle(locale);
	}

	/**
	 * Returns the localized title of this event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this event. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getTitle(java.util.Locale locale, boolean useDefault) {
		return _event.getTitle(locale, useDefault);
	}

	/**
	 * Returns the localized title of this event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized title of this event
	 */
	@Override
	public String getTitle(String languageId) {
		return _event.getTitle(languageId);
	}

	/**
	 * Returns the localized title of this event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this event
	 */
	@Override
	public String getTitle(String languageId, boolean useDefault) {
		return _event.getTitle(languageId, useDefault);
	}

	@Override
	public String getTitleCurrentLanguageId() {
		return _event.getTitleCurrentLanguageId();
	}

	@Override
	public String getTitleCurrentValue() {
		return _event.getTitleCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized titles of this event.
	 *
	 * @return the locales and localized titles of this event
	 */
	@Override
	public Map<java.util.Locale, String> getTitleMap() {
		return _event.getTitleMap();
	}

	/**
	 * Retourne le label des types de l'événement
	 */
	@Override
	public String getTypeLabel(java.util.Locale locale) {
		return _event.getTypeLabel(locale);
	}

	/**
	 * Retourne les types de l'événement
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getTypes() {

		return _event.getTypes();
	}

	/**
	 * Retourne les typologie de l'événement (Catégorie du site de l'OPS)
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getTypologies() {

		return _event.getTypologies();
	}

	/**
	 * Returns the user ID of this event.
	 *
	 * @return the user ID of this event
	 */
	@Override
	public long getUserId() {
		return _event.getUserId();
	}

	/**
	 * Returns the user name of this event.
	 *
	 * @return the user name of this event
	 */
	@Override
	public String getUserName() {
		return _event.getUserName();
	}

	/**
	 * Returns the user uuid of this event.
	 *
	 * @return the user uuid of this event
	 */
	@Override
	public String getUserUuid() {
		return _event.getUserUuid();
	}

	/**
	 * Returns the uuid of this event.
	 *
	 * @return the uuid of this event
	 */
	@Override
	public String getUuid() {
		return _event.getUuid();
	}

	/**
	 * Returns the website name of this event.
	 *
	 * @return the website name of this event
	 */
	@Override
	public String getWebsiteName() {
		return _event.getWebsiteName();
	}

	/**
	 * Returns the localized website name of this event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized website name of this event
	 */
	@Override
	public String getWebsiteName(java.util.Locale locale) {
		return _event.getWebsiteName(locale);
	}

	/**
	 * Returns the localized website name of this event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized website name of this event. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getWebsiteName(java.util.Locale locale, boolean useDefault) {
		return _event.getWebsiteName(locale, useDefault);
	}

	/**
	 * Returns the localized website name of this event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized website name of this event
	 */
	@Override
	public String getWebsiteName(String languageId) {
		return _event.getWebsiteName(languageId);
	}

	/**
	 * Returns the localized website name of this event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized website name of this event
	 */
	@Override
	public String getWebsiteName(String languageId, boolean useDefault) {
		return _event.getWebsiteName(languageId, useDefault);
	}

	@Override
	public String getWebsiteNameCurrentLanguageId() {
		return _event.getWebsiteNameCurrentLanguageId();
	}

	@Override
	public String getWebsiteNameCurrentValue() {
		return _event.getWebsiteNameCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized website names of this event.
	 *
	 * @return the locales and localized website names of this event
	 */
	@Override
	public Map<java.util.Locale, String> getWebsiteNameMap() {
		return _event.getWebsiteNameMap();
	}

	/**
	 * Returns the website url of this event.
	 *
	 * @return the website url of this event
	 */
	@Override
	public String getWebsiteURL() {
		return _event.getWebsiteURL();
	}

	/**
	 * Returns the localized website url of this event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized website url of this event
	 */
	@Override
	public String getWebsiteURL(java.util.Locale locale) {
		return _event.getWebsiteURL(locale);
	}

	/**
	 * Returns the localized website url of this event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized website url of this event. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getWebsiteURL(java.util.Locale locale, boolean useDefault) {
		return _event.getWebsiteURL(locale, useDefault);
	}

	/**
	 * Returns the localized website url of this event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized website url of this event
	 */
	@Override
	public String getWebsiteURL(String languageId) {
		return _event.getWebsiteURL(languageId);
	}

	/**
	 * Returns the localized website url of this event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized website url of this event
	 */
	@Override
	public String getWebsiteURL(String languageId, boolean useDefault) {
		return _event.getWebsiteURL(languageId, useDefault);
	}

	@Override
	public String getWebsiteURLCurrentLanguageId() {
		return _event.getWebsiteURLCurrentLanguageId();
	}

	@Override
	public String getWebsiteURLCurrentValue() {
		return _event.getWebsiteURLCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized website urls of this event.
	 *
	 * @return the locales and localized website urls of this event
	 */
	@Override
	public Map<java.util.Locale, String> getWebsiteURLMap() {
		return _event.getWebsiteURLMap();
	}

	/**
	 * Retourne true si l'événement est accessible pour au moins un type de handicap
	 */
	@Override
	public boolean hasAnyAccessForDisabled() {
		return _event.hasAnyAccessForDisabled();
	}

	@Override
	public int hashCode() {
		return _event.hashCode();
	}

	/**
	 * Returns <code>true</code> if this event is approved.
	 *
	 * @return <code>true</code> if this event is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return _event.isApproved();
	}

	@Override
	public boolean isCachedModel() {
		return _event.isCachedModel();
	}

	/**
	 * Returns <code>true</code> if this event is denied.
	 *
	 * @return <code>true</code> if this event is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return _event.isDenied();
	}

	/**
	 * Returns <code>true</code> if this event is a draft.
	 *
	 * @return <code>true</code> if this event is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return _event.isDraft();
	}

	@Override
	public boolean isEscapedModel() {
		return _event.isEscapedModel();
	}

	/**
	 * Returns <code>true</code> if this event is expired.
	 *
	 * @return <code>true</code> if this event is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return _event.isExpired();
	}

	/**
	 * L'evenement est-il terminee ?
	 */
	@Override
	public boolean isFinished() {
		return _event.isFinished();
	}

	/**
	 * Returns <code>true</code> if this event is inactive.
	 *
	 * @return <code>true</code> if this event is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return _event.isInactive();
	}

	/**
	 * Returns <code>true</code> if this event is incomplete.
	 *
	 * @return <code>true</code> if this event is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return _event.isIncomplete();
	}

	@Override
	public boolean isNew() {
		return _event.isNew();
	}

	/**
	 * Returns <code>true</code> if this event is pending.
	 *
	 * @return <code>true</code> if this event is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return _event.isPending();
	}

	/**
	 * Returns <code>true</code> if this event is registration.
	 *
	 * @return <code>true</code> if this event is registration; <code>false</code> otherwise
	 */
	@Override
	public boolean isRegistration() {
		return _event.isRegistration();
	}

	/**
	 * Returns <code>true</code> if this event is scheduled.
	 *
	 * @return <code>true</code> if this event is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return _event.isScheduled();
	}

	/**
	 * Demande si l'utilisateur demandé participe à l'événement
	 */
	@Override
	public boolean isUserParticipates(String publikUserId) {
		return _event.isUserParticipates(publikUserId);
	}

	@Override
	public void persist() {
		_event.persist();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.kernel.exception.LocaleException {

		_event.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
			java.util.Locale defaultImportLocale)
		throws com.liferay.portal.kernel.exception.LocaleException {

		_event.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	/**
	 * Sets the access of this event.
	 *
	 * @param access the access of this event
	 */
	@Override
	public void setAccess(String access) {
		_event.setAccess(access);
	}

	/**
	 * Sets the localized access of this event in the language.
	 *
	 * @param access the localized access of this event
	 * @param locale the locale of the language
	 */
	@Override
	public void setAccess(String access, java.util.Locale locale) {
		_event.setAccess(access, locale);
	}

	/**
	 * Sets the localized access of this event in the language, and sets the default locale.
	 *
	 * @param access the localized access of this event
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setAccess(
		String access, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		_event.setAccess(access, locale, defaultLocale);
	}

	@Override
	public void setAccessCurrentLanguageId(String languageId) {
		_event.setAccessCurrentLanguageId(languageId);
	}

	/**
	 * Sets the access for blind of this event.
	 *
	 * @param accessForBlind the access for blind of this event
	 */
	@Override
	public void setAccessForBlind(Boolean accessForBlind) {
		_event.setAccessForBlind(accessForBlind);
	}

	/**
	 * Sets the access for deaf of this event.
	 *
	 * @param accessForDeaf the access for deaf of this event
	 */
	@Override
	public void setAccessForDeaf(Boolean accessForDeaf) {
		_event.setAccessForDeaf(accessForDeaf);
	}

	/**
	 * Sets the access for deficient of this event.
	 *
	 * @param accessForDeficient the access for deficient of this event
	 */
	@Override
	public void setAccessForDeficient(Boolean accessForDeficient) {
		_event.setAccessForDeficient(accessForDeficient);
	}

	/**
	 * Sets the access for disabled of this event.
	 *
	 * @param accessForDisabled the access for disabled of this event
	 */
	@Override
	public void setAccessForDisabled(String accessForDisabled) {
		_event.setAccessForDisabled(accessForDisabled);
	}

	/**
	 * Sets the localized access for disabled of this event in the language.
	 *
	 * @param accessForDisabled the localized access for disabled of this event
	 * @param locale the locale of the language
	 */
	@Override
	public void setAccessForDisabled(
		String accessForDisabled, java.util.Locale locale) {

		_event.setAccessForDisabled(accessForDisabled, locale);
	}

	/**
	 * Sets the localized access for disabled of this event in the language, and sets the default locale.
	 *
	 * @param accessForDisabled the localized access for disabled of this event
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setAccessForDisabled(
		String accessForDisabled, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		_event.setAccessForDisabled(accessForDisabled, locale, defaultLocale);
	}

	@Override
	public void setAccessForDisabledCurrentLanguageId(String languageId) {
		_event.setAccessForDisabledCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized access for disableds of this event from the map of locales and localized access for disableds.
	 *
	 * @param accessForDisabledMap the locales and localized access for disableds of this event
	 */
	@Override
	public void setAccessForDisabledMap(
		Map<java.util.Locale, String> accessForDisabledMap) {

		_event.setAccessForDisabledMap(accessForDisabledMap);
	}

	/**
	 * Sets the localized access for disableds of this event from the map of locales and localized access for disableds, and sets the default locale.
	 *
	 * @param accessForDisabledMap the locales and localized access for disableds of this event
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setAccessForDisabledMap(
		Map<java.util.Locale, String> accessForDisabledMap,
		java.util.Locale defaultLocale) {

		_event.setAccessForDisabledMap(accessForDisabledMap, defaultLocale);
	}

	/**
	 * Sets the access for elder of this event.
	 *
	 * @param accessForElder the access for elder of this event
	 */
	@Override
	public void setAccessForElder(Boolean accessForElder) {
		_event.setAccessForElder(accessForElder);
	}

	/**
	 * Sets the access for wheelchair of this event.
	 *
	 * @param accessForWheelchair the access for wheelchair of this event
	 */
	@Override
	public void setAccessForWheelchair(Boolean accessForWheelchair) {
		_event.setAccessForWheelchair(accessForWheelchair);
	}

	/**
	 * Sets the localized accesses of this event from the map of locales and localized accesses.
	 *
	 * @param accessMap the locales and localized accesses of this event
	 */
	@Override
	public void setAccessMap(Map<java.util.Locale, String> accessMap) {
		_event.setAccessMap(accessMap);
	}

	/**
	 * Sets the localized accesses of this event from the map of locales and localized accesses, and sets the default locale.
	 *
	 * @param accessMap the locales and localized accesses of this event
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setAccessMap(
		Map<java.util.Locale, String> accessMap,
		java.util.Locale defaultLocale) {

		_event.setAccessMap(accessMap, defaultLocale);
	}

	/**
	 * Sets the booking description of this event.
	 *
	 * @param bookingDescription the booking description of this event
	 */
	@Override
	public void setBookingDescription(String bookingDescription) {
		_event.setBookingDescription(bookingDescription);
	}

	/**
	 * Sets the localized booking description of this event in the language.
	 *
	 * @param bookingDescription the localized booking description of this event
	 * @param locale the locale of the language
	 */
	@Override
	public void setBookingDescription(
		String bookingDescription, java.util.Locale locale) {

		_event.setBookingDescription(bookingDescription, locale);
	}

	/**
	 * Sets the localized booking description of this event in the language, and sets the default locale.
	 *
	 * @param bookingDescription the localized booking description of this event
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setBookingDescription(
		String bookingDescription, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		_event.setBookingDescription(bookingDescription, locale, defaultLocale);
	}

	@Override
	public void setBookingDescriptionCurrentLanguageId(String languageId) {
		_event.setBookingDescriptionCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized booking descriptions of this event from the map of locales and localized booking descriptions.
	 *
	 * @param bookingDescriptionMap the locales and localized booking descriptions of this event
	 */
	@Override
	public void setBookingDescriptionMap(
		Map<java.util.Locale, String> bookingDescriptionMap) {

		_event.setBookingDescriptionMap(bookingDescriptionMap);
	}

	/**
	 * Sets the localized booking descriptions of this event from the map of locales and localized booking descriptions, and sets the default locale.
	 *
	 * @param bookingDescriptionMap the locales and localized booking descriptions of this event
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setBookingDescriptionMap(
		Map<java.util.Locale, String> bookingDescriptionMap,
		java.util.Locale defaultLocale) {

		_event.setBookingDescriptionMap(bookingDescriptionMap, defaultLocale);
	}

	/**
	 * Sets the booking url of this event.
	 *
	 * @param bookingURL the booking url of this event
	 */
	@Override
	public void setBookingURL(String bookingURL) {
		_event.setBookingURL(bookingURL);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_event.setCachedModel(cachedModel);
	}

	/**
	 * Sets the company ID of this event.
	 *
	 * @param companyId the company ID of this event
	 */
	@Override
	public void setCompanyId(long companyId) {
		_event.setCompanyId(companyId);
	}

	/**
	 * Sets the composer of this event.
	 *
	 * @param composer the composer of this event
	 */
	@Override
	public void setComposer(String composer) {
		_event.setComposer(composer);
	}

	/**
	 * Sets the concert ID of this event.
	 *
	 * @param concertId the concert ID of this event
	 */
	@Override
	public void setConcertId(String concertId) {
		_event.setConcertId(concertId);
	}

	/**
	 * Sets the create date of this event.
	 *
	 * @param createDate the create date of this event
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_event.setCreateDate(createDate);
	}

	/**
	 * Sets the create date source of this event.
	 *
	 * @param createDateSource the create date source of this event
	 */
	@Override
	public void setCreateDateSource(Date createDateSource) {
		_event.setCreateDateSource(createDateSource);
	}

	/**
	 * Sets the description of this event.
	 *
	 * @param description the description of this event
	 */
	@Override
	public void setDescription(String description) {
		_event.setDescription(description);
	}

	/**
	 * Sets the localized description of this event in the language.
	 *
	 * @param description the localized description of this event
	 * @param locale the locale of the language
	 */
	@Override
	public void setDescription(String description, java.util.Locale locale) {
		_event.setDescription(description, locale);
	}

	/**
	 * Sets the localized description of this event in the language, and sets the default locale.
	 *
	 * @param description the localized description of this event
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDescription(
		String description, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		_event.setDescription(description, locale, defaultLocale);
	}

	@Override
	public void setDescriptionCurrentLanguageId(String languageId) {
		_event.setDescriptionCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized descriptions of this event from the map of locales and localized descriptions.
	 *
	 * @param descriptionMap the locales and localized descriptions of this event
	 */
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, String> descriptionMap) {

		_event.setDescriptionMap(descriptionMap);
	}

	/**
	 * Sets the localized descriptions of this event from the map of locales and localized descriptions, and sets the default locale.
	 *
	 * @param descriptionMap the locales and localized descriptions of this event
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, String> descriptionMap,
		java.util.Locale defaultLocale) {

		_event.setDescriptionMap(descriptionMap, defaultLocale);
	}

	/**
	 * Sets the distribution of this event.
	 *
	 * @param distribution the distribution of this event
	 */
	@Override
	public void setDistribution(String distribution) {
		_event.setDistribution(distribution);
	}

	/**
	 * Sets the localized distribution of this event in the language.
	 *
	 * @param distribution the localized distribution of this event
	 * @param locale the locale of the language
	 */
	@Override
	public void setDistribution(String distribution, java.util.Locale locale) {
		_event.setDistribution(distribution, locale);
	}

	/**
	 * Sets the localized distribution of this event in the language, and sets the default locale.
	 *
	 * @param distribution the localized distribution of this event
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDistribution(
		String distribution, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		_event.setDistribution(distribution, locale, defaultLocale);
	}

	@Override
	public void setDistributionCurrentLanguageId(String languageId) {
		_event.setDistributionCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized distributions of this event from the map of locales and localized distributions.
	 *
	 * @param distributionMap the locales and localized distributions of this event
	 */
	@Override
	public void setDistributionMap(
		Map<java.util.Locale, String> distributionMap) {

		_event.setDistributionMap(distributionMap);
	}

	/**
	 * Sets the localized distributions of this event from the map of locales and localized distributions, and sets the default locale.
	 *
	 * @param distributionMap the locales and localized distributions of this event
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDistributionMap(
		Map<java.util.Locale, String> distributionMap,
		java.util.Locale defaultLocale) {

		_event.setDistributionMap(distributionMap, defaultLocale);
	}

	/**
	 * Sets the email of this event.
	 *
	 * @param email the email of this event
	 */
	@Override
	public void setEmail(String email) {
		_event.setEmail(email);
	}

	/**
	 * Sets the event ID of this event.
	 *
	 * @param eventId the event ID of this event
	 */
	@Override
	public void setEventId(long eventId) {
		_event.setEventId(eventId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_event.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_event.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_event.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the external image copyright of this event.
	 *
	 * @param externalImageCopyright the external image copyright of this event
	 */
	@Override
	public void setExternalImageCopyright(String externalImageCopyright) {
		_event.setExternalImageCopyright(externalImageCopyright);
	}

	/**
	 * Sets the external image url of this event.
	 *
	 * @param externalImageURL the external image url of this event
	 */
	@Override
	public void setExternalImageURL(String externalImageURL) {
		_event.setExternalImageURL(externalImageURL);
	}

	/**
	 * Sets the first start date of this event.
	 *
	 * @param firstStartDate the first start date of this event
	 */
	@Override
	public void setFirstStartDate(Date firstStartDate) {
		_event.setFirstStartDate(firstStartDate);
	}

	/**
	 * Sets the free of this event.
	 *
	 * @param free the free of this event
	 */
	@Override
	public void setFree(Integer free) {
		_event.setFree(free);
	}

	/**
	 * Sets the group ID of this event.
	 *
	 * @param groupId the group ID of this event
	 */
	@Override
	public void setGroupId(long groupId) {
		_event.setGroupId(groupId);
	}

	/**
	 * Sets the id source of this event.
	 *
	 * @param idSource the id source of this event
	 */
	@Override
	public void setIdSource(String idSource) {
		_event.setIdSource(idSource);
	}

	/**
	 * Sets the image height of this event.
	 *
	 * @param imageHeight the image height of this event
	 */
	@Override
	public void setImageHeight(Integer imageHeight) {
		_event.setImageHeight(imageHeight);
	}

	/**
	 * Sets the image ID of this event.
	 *
	 * @param imageId the image ID of this event
	 */
	@Override
	public void setImageId(Long imageId) {
		_event.setImageId(imageId);
	}

	/**
	 * Sets the image width of this event.
	 *
	 * @param imageWidth the image width of this event
	 */
	@Override
	public void setImageWidth(Integer imageWidth) {
		_event.setImageWidth(imageWidth);
	}

	/**
	 * Sets the last end date of this event.
	 *
	 * @param lastEndDate the last end date of this event
	 */
	@Override
	public void setLastEndDate(Date lastEndDate) {
		_event.setLastEndDate(lastEndDate);
	}

	/**
	 * Sets the last publish date of this event.
	 *
	 * @param lastPublishDate the last publish date of this event
	 */
	@Override
	public void setLastPublishDate(Date lastPublishDate) {
		_event.setLastPublishDate(lastPublishDate);
	}

	/**
	 * Sets the max gauge of this event.
	 *
	 * @param maxGauge the max gauge of this event
	 */
	@Override
	public void setMaxGauge(long maxGauge) {
		_event.setMaxGauge(maxGauge);
	}

	/**
	 * Sets the mercator x of this event.
	 *
	 * @param mercatorX the mercator x of this event
	 */
	@Override
	public void setMercatorX(String mercatorX) {
		_event.setMercatorX(mercatorX);
	}

	/**
	 * Sets the mercator y of this event.
	 *
	 * @param mercatorY the mercator y of this event
	 */
	@Override
	public void setMercatorY(String mercatorY) {
		_event.setMercatorY(mercatorY);
	}

	/**
	 * Sets the modified date of this event.
	 *
	 * @param modifiedDate the modified date of this event
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_event.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the modified date source of this event.
	 *
	 * @param modifiedDateSource the modified date source of this event
	 */
	@Override
	public void setModifiedDateSource(Date modifiedDateSource) {
		_event.setModifiedDateSource(modifiedDateSource);
	}

	@Override
	public void setNew(boolean n) {
		_event.setNew(n);
	}

	/**
	 * Sets the phone of this event.
	 *
	 * @param phone the phone of this event
	 */
	@Override
	public void setPhone(String phone) {
		_event.setPhone(phone);
	}

	/**
	 * Sets the place city of this event.
	 *
	 * @param placeCity the place city of this event
	 */
	@Override
	public void setPlaceCity(String placeCity) {
		_event.setPlaceCity(placeCity);
	}

	/**
	 * Sets the place country of this event.
	 *
	 * @param placeCountry the place country of this event
	 */
	@Override
	public void setPlaceCountry(String placeCountry) {
		_event.setPlaceCountry(placeCountry);
	}

	/**
	 * Sets the place name of this event.
	 *
	 * @param placeName the place name of this event
	 */
	@Override
	public void setPlaceName(String placeName) {
		_event.setPlaceName(placeName);
	}

	/**
	 * Sets the localized place name of this event in the language.
	 *
	 * @param placeName the localized place name of this event
	 * @param locale the locale of the language
	 */
	@Override
	public void setPlaceName(String placeName, java.util.Locale locale) {
		_event.setPlaceName(placeName, locale);
	}

	/**
	 * Sets the localized place name of this event in the language, and sets the default locale.
	 *
	 * @param placeName the localized place name of this event
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setPlaceName(
		String placeName, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		_event.setPlaceName(placeName, locale, defaultLocale);
	}

	@Override
	public void setPlaceNameCurrentLanguageId(String languageId) {
		_event.setPlaceNameCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized place names of this event from the map of locales and localized place names.
	 *
	 * @param placeNameMap the locales and localized place names of this event
	 */
	@Override
	public void setPlaceNameMap(Map<java.util.Locale, String> placeNameMap) {
		_event.setPlaceNameMap(placeNameMap);
	}

	/**
	 * Sets the localized place names of this event from the map of locales and localized place names, and sets the default locale.
	 *
	 * @param placeNameMap the locales and localized place names of this event
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setPlaceNameMap(
		Map<java.util.Locale, String> placeNameMap,
		java.util.Locale defaultLocale) {

		_event.setPlaceNameMap(placeNameMap, defaultLocale);
	}

	/**
	 * Sets the place sig ID of this event.
	 *
	 * @param placeSIGId the place sig ID of this event
	 */
	@Override
	public void setPlaceSIGId(String placeSIGId) {
		_event.setPlaceSIGId(placeSIGId);
	}

	/**
	 * Sets the place street name of this event.
	 *
	 * @param placeStreetName the place street name of this event
	 */
	@Override
	public void setPlaceStreetName(String placeStreetName) {
		_event.setPlaceStreetName(placeStreetName);
	}

	/**
	 * Sets the place street number of this event.
	 *
	 * @param placeStreetNumber the place street number of this event
	 */
	@Override
	public void setPlaceStreetNumber(String placeStreetNumber) {
		_event.setPlaceStreetNumber(placeStreetNumber);
	}

	/**
	 * Sets the place zip code of this event.
	 *
	 * @param placeZipCode the place zip code of this event
	 */
	@Override
	public void setPlaceZipCode(String placeZipCode) {
		_event.setPlaceZipCode(placeZipCode);
	}

	/**
	 * Sets the price of this event.
	 *
	 * @param price the price of this event
	 */
	@Override
	public void setPrice(String price) {
		_event.setPrice(price);
	}

	/**
	 * Sets the localized price of this event in the language.
	 *
	 * @param price the localized price of this event
	 * @param locale the locale of the language
	 */
	@Override
	public void setPrice(String price, java.util.Locale locale) {
		_event.setPrice(price, locale);
	}

	/**
	 * Sets the localized price of this event in the language, and sets the default locale.
	 *
	 * @param price the localized price of this event
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setPrice(
		String price, java.util.Locale locale, java.util.Locale defaultLocale) {

		_event.setPrice(price, locale, defaultLocale);
	}

	@Override
	public void setPriceCurrentLanguageId(String languageId) {
		_event.setPriceCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized prices of this event from the map of locales and localized prices.
	 *
	 * @param priceMap the locales and localized prices of this event
	 */
	@Override
	public void setPriceMap(Map<java.util.Locale, String> priceMap) {
		_event.setPriceMap(priceMap);
	}

	/**
	 * Sets the localized prices of this event from the map of locales and localized prices, and sets the default locale.
	 *
	 * @param priceMap the locales and localized prices of this event
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setPriceMap(
		Map<java.util.Locale, String> priceMap,
		java.util.Locale defaultLocale) {

		_event.setPriceMap(priceMap, defaultLocale);
	}

	/**
	 * Sets the primary key of this event.
	 *
	 * @param primaryKey the primary key of this event
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_event.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_event.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the program of this event.
	 *
	 * @param program the program of this event
	 */
	@Override
	public void setProgram(String program) {
		_event.setProgram(program);
	}

	/**
	 * Sets the localized program of this event in the language.
	 *
	 * @param program the localized program of this event
	 * @param locale the locale of the language
	 */
	@Override
	public void setProgram(String program, java.util.Locale locale) {
		_event.setProgram(program, locale);
	}

	/**
	 * Sets the localized program of this event in the language, and sets the default locale.
	 *
	 * @param program the localized program of this event
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setProgram(
		String program, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		_event.setProgram(program, locale, defaultLocale);
	}

	@Override
	public void setProgramCurrentLanguageId(String languageId) {
		_event.setProgramCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized programs of this event from the map of locales and localized programs.
	 *
	 * @param programMap the locales and localized programs of this event
	 */
	@Override
	public void setProgramMap(Map<java.util.Locale, String> programMap) {
		_event.setProgramMap(programMap);
	}

	/**
	 * Sets the localized programs of this event from the map of locales and localized programs, and sets the default locale.
	 *
	 * @param programMap the locales and localized programs of this event
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setProgramMap(
		Map<java.util.Locale, String> programMap,
		java.util.Locale defaultLocale) {

		_event.setProgramMap(programMap, defaultLocale);
	}

	/**
	 * Sets the promoter of this event.
	 *
	 * @param promoter the promoter of this event
	 */
	@Override
	public void setPromoter(String promoter) {
		_event.setPromoter(promoter);
	}

	/**
	 * Sets the publication date of this event.
	 *
	 * @param publicationDate the publication date of this event
	 */
	@Override
	public void setPublicationDate(Date publicationDate) {
		_event.setPublicationDate(publicationDate);
	}

	/**
	 * Sets whether this event is registration.
	 *
	 * @param registration the registration of this event
	 */
	@Override
	public void setRegistration(boolean registration) {
		_event.setRegistration(registration);
	}

	/**
	 * Sets the registration end date of this event.
	 *
	 * @param registrationEndDate the registration end date of this event
	 */
	@Override
	public void setRegistrationEndDate(Date registrationEndDate) {
		_event.setRegistrationEndDate(registrationEndDate);
	}

	/**
	 * Sets the registration start date of this event.
	 *
	 * @param registrationStartDate the registration start date of this event
	 */
	@Override
	public void setRegistrationStartDate(Date registrationStartDate) {
		_event.setRegistrationStartDate(registrationStartDate);
	}

	/**
	 * Sets the source of this event.
	 *
	 * @param source the source of this event
	 */
	@Override
	public void setSource(String source) {
		_event.setSource(source);
	}

	/**
	 * Sets the status of this event.
	 *
	 * @param status the status of this event
	 */
	@Override
	public void setStatus(int status) {
		_event.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this event.
	 *
	 * @param statusByUserId the status by user ID of this event
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_event.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this event.
	 *
	 * @param statusByUserName the status by user name of this event
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		_event.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this event.
	 *
	 * @param statusByUserUuid the status by user uuid of this event
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		_event.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this event.
	 *
	 * @param statusDate the status date of this event
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		_event.setStatusDate(statusDate);
	}

	/**
	 * Sets the subscription url of this event.
	 *
	 * @param subscriptionURL the subscription url of this event
	 */
	@Override
	public void setSubscriptionURL(String subscriptionURL) {
		_event.setSubscriptionURL(subscriptionURL);
	}

	/**
	 * Sets the subtitle of this event.
	 *
	 * @param subtitle the subtitle of this event
	 */
	@Override
	public void setSubtitle(String subtitle) {
		_event.setSubtitle(subtitle);
	}

	/**
	 * Sets the localized subtitle of this event in the language.
	 *
	 * @param subtitle the localized subtitle of this event
	 * @param locale the locale of the language
	 */
	@Override
	public void setSubtitle(String subtitle, java.util.Locale locale) {
		_event.setSubtitle(subtitle, locale);
	}

	/**
	 * Sets the localized subtitle of this event in the language, and sets the default locale.
	 *
	 * @param subtitle the localized subtitle of this event
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setSubtitle(
		String subtitle, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		_event.setSubtitle(subtitle, locale, defaultLocale);
	}

	@Override
	public void setSubtitleCurrentLanguageId(String languageId) {
		_event.setSubtitleCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized subtitles of this event from the map of locales and localized subtitles.
	 *
	 * @param subtitleMap the locales and localized subtitles of this event
	 */
	@Override
	public void setSubtitleMap(Map<java.util.Locale, String> subtitleMap) {
		_event.setSubtitleMap(subtitleMap);
	}

	/**
	 * Sets the localized subtitles of this event from the map of locales and localized subtitles, and sets the default locale.
	 *
	 * @param subtitleMap the locales and localized subtitles of this event
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setSubtitleMap(
		Map<java.util.Locale, String> subtitleMap,
		java.util.Locale defaultLocale) {

		_event.setSubtitleMap(subtitleMap, defaultLocale);
	}

	/**
	 * Sets the title of this event.
	 *
	 * @param title the title of this event
	 */
	@Override
	public void setTitle(String title) {
		_event.setTitle(title);
	}

	/**
	 * Sets the localized title of this event in the language.
	 *
	 * @param title the localized title of this event
	 * @param locale the locale of the language
	 */
	@Override
	public void setTitle(String title, java.util.Locale locale) {
		_event.setTitle(title, locale);
	}

	/**
	 * Sets the localized title of this event in the language, and sets the default locale.
	 *
	 * @param title the localized title of this event
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setTitle(
		String title, java.util.Locale locale, java.util.Locale defaultLocale) {

		_event.setTitle(title, locale, defaultLocale);
	}

	@Override
	public void setTitleCurrentLanguageId(String languageId) {
		_event.setTitleCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized titles of this event from the map of locales and localized titles.
	 *
	 * @param titleMap the locales and localized titles of this event
	 */
	@Override
	public void setTitleMap(Map<java.util.Locale, String> titleMap) {
		_event.setTitleMap(titleMap);
	}

	/**
	 * Sets the localized titles of this event from the map of locales and localized titles, and sets the default locale.
	 *
	 * @param titleMap the locales and localized titles of this event
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setTitleMap(
		Map<java.util.Locale, String> titleMap,
		java.util.Locale defaultLocale) {

		_event.setTitleMap(titleMap, defaultLocale);
	}

	/**
	 * Sets the user ID of this event.
	 *
	 * @param userId the user ID of this event
	 */
	@Override
	public void setUserId(long userId) {
		_event.setUserId(userId);
	}

	/**
	 * Sets the user name of this event.
	 *
	 * @param userName the user name of this event
	 */
	@Override
	public void setUserName(String userName) {
		_event.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this event.
	 *
	 * @param userUuid the user uuid of this event
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_event.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this event.
	 *
	 * @param uuid the uuid of this event
	 */
	@Override
	public void setUuid(String uuid) {
		_event.setUuid(uuid);
	}

	/**
	 * Sets the website name of this event.
	 *
	 * @param websiteName the website name of this event
	 */
	@Override
	public void setWebsiteName(String websiteName) {
		_event.setWebsiteName(websiteName);
	}

	/**
	 * Sets the localized website name of this event in the language.
	 *
	 * @param websiteName the localized website name of this event
	 * @param locale the locale of the language
	 */
	@Override
	public void setWebsiteName(String websiteName, java.util.Locale locale) {
		_event.setWebsiteName(websiteName, locale);
	}

	/**
	 * Sets the localized website name of this event in the language, and sets the default locale.
	 *
	 * @param websiteName the localized website name of this event
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setWebsiteName(
		String websiteName, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		_event.setWebsiteName(websiteName, locale, defaultLocale);
	}

	@Override
	public void setWebsiteNameCurrentLanguageId(String languageId) {
		_event.setWebsiteNameCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized website names of this event from the map of locales and localized website names.
	 *
	 * @param websiteNameMap the locales and localized website names of this event
	 */
	@Override
	public void setWebsiteNameMap(
		Map<java.util.Locale, String> websiteNameMap) {

		_event.setWebsiteNameMap(websiteNameMap);
	}

	/**
	 * Sets the localized website names of this event from the map of locales and localized website names, and sets the default locale.
	 *
	 * @param websiteNameMap the locales and localized website names of this event
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setWebsiteNameMap(
		Map<java.util.Locale, String> websiteNameMap,
		java.util.Locale defaultLocale) {

		_event.setWebsiteNameMap(websiteNameMap, defaultLocale);
	}

	/**
	 * Sets the website url of this event.
	 *
	 * @param websiteURL the website url of this event
	 */
	@Override
	public void setWebsiteURL(String websiteURL) {
		_event.setWebsiteURL(websiteURL);
	}

	/**
	 * Sets the localized website url of this event in the language.
	 *
	 * @param websiteURL the localized website url of this event
	 * @param locale the locale of the language
	 */
	@Override
	public void setWebsiteURL(String websiteURL, java.util.Locale locale) {
		_event.setWebsiteURL(websiteURL, locale);
	}

	/**
	 * Sets the localized website url of this event in the language, and sets the default locale.
	 *
	 * @param websiteURL the localized website url of this event
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setWebsiteURL(
		String websiteURL, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		_event.setWebsiteURL(websiteURL, locale, defaultLocale);
	}

	@Override
	public void setWebsiteURLCurrentLanguageId(String languageId) {
		_event.setWebsiteURLCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized website urls of this event from the map of locales and localized website urls.
	 *
	 * @param websiteURLMap the locales and localized website urls of this event
	 */
	@Override
	public void setWebsiteURLMap(Map<java.util.Locale, String> websiteURLMap) {
		_event.setWebsiteURLMap(websiteURLMap);
	}

	/**
	 * Sets the localized website urls of this event from the map of locales and localized website urls, and sets the default locale.
	 *
	 * @param websiteURLMap the locales and localized website urls of this event
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setWebsiteURLMap(
		Map<java.util.Locale, String> websiteURLMap,
		java.util.Locale defaultLocale) {

		_event.setWebsiteURLMap(websiteURLMap, defaultLocale);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<eu.strasbourg.service.agenda.model.Event> toCacheModel() {

		return _event.toCacheModel();
	}

	@Override
	public eu.strasbourg.service.agenda.model.Event toEscapedModel() {
		return new EventWrapper(_event.toEscapedModel());
	}

	/**
	 * Retourne la version JSON de l'événenement
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONObject toJSON() {
		return _event.toJSON();
	}

	/**
	 * Retourne la version JSON de l'événenement avec la participation ou non d'un
	 * utilisateur potentiel en incluant l'escape des caractères / balises pouvant
	 * casser l'utilisation des données et le split de l'HTML en général
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONObject toJSON(
		String publikUserID) {

		return _event.toJSON(publikUserID);
	}

	@Override
	public String toString() {
		return _event.toString();
	}

	@Override
	public eu.strasbourg.service.agenda.model.Event toUnescapedModel() {
		return new EventWrapper(_event.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _event.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EventWrapper)) {
			return false;
		}

		EventWrapper eventWrapper = (EventWrapper)obj;

		if (Objects.equals(_event, eventWrapper._event)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _event.getStagedModelType();
	}

	@Override
	public Event getWrappedModel() {
		return _event;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _event.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _event.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_event.resetOriginalValues();
	}

	private final Event _event;

}