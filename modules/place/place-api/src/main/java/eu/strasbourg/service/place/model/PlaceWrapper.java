/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.place.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Place}.
 * </p>
 *
 * @author Angelique Zunino Champougny
 * @see Place
 * @generated
 */
public class PlaceWrapper
	extends BaseModelWrapper<Place> implements ModelWrapper<Place>, Place {

	public PlaceWrapper(Place place) {
		super(place);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("placeId", getPlaceId());
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
		attributes.put("SIGid", getSIGid());
		attributes.put("name", getName());
		attributes.put("addressComplement", getAddressComplement());
		attributes.put("addressStreet", getAddressStreet());
		attributes.put("addressDistribution", getAddressDistribution());
		attributes.put("addressZipCode", getAddressZipCode());
		attributes.put("addressCountry", getAddressCountry());
		attributes.put("mercatorX", getMercatorX());
		attributes.put("mercatorY", getMercatorY());
		attributes.put("RGF93X", getRGF93X());
		attributes.put("RGF93Y", getRGF93Y());
		attributes.put("locationId", getLocationId());
		attributes.put("alias", getAlias());
		attributes.put("presentation", getPresentation());
		attributes.put("serviceAndActivities", getServiceAndActivities());
		attributes.put("characteristics", getCharacteristics());
		attributes.put("subjectToPublicHoliday", isSubjectToPublicHoliday());
		attributes.put("exceptionalSchedule", getExceptionalSchedule());
		attributes.put("displayEvents", isDisplayEvents());
		attributes.put("additionalInformation", getAdditionalInformation());
		attributes.put("contenuTooltipCarto", getContenuTooltipCarto());
		attributes.put("hasURLSchedule", isHasURLSchedule());
		attributes.put("scheduleLinkName", getScheduleLinkName());
		attributes.put("scheduleLinkURL", getScheduleLinkURL());
		attributes.put("phone", getPhone());
		attributes.put("mail", getMail());
		attributes.put("siteURL", getSiteURL());
		attributes.put("siteLabel", getSiteLabel());
		attributes.put("bookingURL", getBookingURL());
		attributes.put("facebookURL", getFacebookURL());
		attributes.put("facebookLabel", getFacebookLabel());
		attributes.put("instagramURL", getInstagramURL());
		attributes.put("instagramLabel", getInstagramLabel());
		attributes.put("accesMap", getAccesMap());
		attributes.put("access", getAccess());
		attributes.put("accessForDisabled", getAccessForDisabled());
		attributes.put("accessForBlind", getAccessForBlind());
		attributes.put("accessForDeaf", getAccessForDeaf());
		attributes.put("accessForWheelchair", getAccessForWheelchair());
		attributes.put("accessForElder", getAccessForElder());
		attributes.put("accessForDeficient", getAccessForDeficient());
		attributes.put("RTEnabled", getRTEnabled());
		attributes.put("RTType", getRTType());
		attributes.put("RTExternalId", getRTExternalId());
		attributes.put("RTAvailable", getRTAvailable());
		attributes.put("RTOccupation", getRTOccupation());
		attributes.put("RTCapacity", getRTCapacity());
		attributes.put("RTStatus", getRTStatus());
		attributes.put("RTLastUpdate", getRTLastUpdate());
		attributes.put("imageId", getImageId());
		attributes.put("imageWidth", getImageWidth());
		attributes.put("imageHeight", getImageHeight());
		attributes.put("imageIds", getImageIds());
		attributes.put("videosIds", getVideosIds());
		attributes.put("priceId", getPriceId());
		attributes.put("documentsIds", getDocumentsIds());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long placeId = (Long)attributes.get("placeId");

		if (placeId != null) {
			setPlaceId(placeId);
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

		String SIGid = (String)attributes.get("SIGid");

		if (SIGid != null) {
			setSIGid(SIGid);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String addressComplement = (String)attributes.get("addressComplement");

		if (addressComplement != null) {
			setAddressComplement(addressComplement);
		}

		String addressStreet = (String)attributes.get("addressStreet");

		if (addressStreet != null) {
			setAddressStreet(addressStreet);
		}

		String addressDistribution = (String)attributes.get(
			"addressDistribution");

		if (addressDistribution != null) {
			setAddressDistribution(addressDistribution);
		}

		String addressZipCode = (String)attributes.get("addressZipCode");

		if (addressZipCode != null) {
			setAddressZipCode(addressZipCode);
		}

		String addressCountry = (String)attributes.get("addressCountry");

		if (addressCountry != null) {
			setAddressCountry(addressCountry);
		}

		String mercatorX = (String)attributes.get("mercatorX");

		if (mercatorX != null) {
			setMercatorX(mercatorX);
		}

		String mercatorY = (String)attributes.get("mercatorY");

		if (mercatorY != null) {
			setMercatorY(mercatorY);
		}

		String RGF93X = (String)attributes.get("RGF93X");

		if (RGF93X != null) {
			setRGF93X(RGF93X);
		}

		String RGF93Y = (String)attributes.get("RGF93Y");

		if (RGF93Y != null) {
			setRGF93Y(RGF93Y);
		}

		String locationId = (String)attributes.get("locationId");

		if (locationId != null) {
			setLocationId(locationId);
		}

		String alias = (String)attributes.get("alias");

		if (alias != null) {
			setAlias(alias);
		}

		String presentation = (String)attributes.get("presentation");

		if (presentation != null) {
			setPresentation(presentation);
		}

		String serviceAndActivities = (String)attributes.get(
			"serviceAndActivities");

		if (serviceAndActivities != null) {
			setServiceAndActivities(serviceAndActivities);
		}

		String characteristics = (String)attributes.get("characteristics");

		if (characteristics != null) {
			setCharacteristics(characteristics);
		}

		Boolean subjectToPublicHoliday = (Boolean)attributes.get(
			"subjectToPublicHoliday");

		if (subjectToPublicHoliday != null) {
			setSubjectToPublicHoliday(subjectToPublicHoliday);
		}

		String exceptionalSchedule = (String)attributes.get(
			"exceptionalSchedule");

		if (exceptionalSchedule != null) {
			setExceptionalSchedule(exceptionalSchedule);
		}

		Boolean displayEvents = (Boolean)attributes.get("displayEvents");

		if (displayEvents != null) {
			setDisplayEvents(displayEvents);
		}

		String additionalInformation = (String)attributes.get(
			"additionalInformation");

		if (additionalInformation != null) {
			setAdditionalInformation(additionalInformation);
		}

		String contenuTooltipCarto = (String)attributes.get(
			"contenuTooltipCarto");

		if (contenuTooltipCarto != null) {
			setContenuTooltipCarto(contenuTooltipCarto);
		}

		Boolean hasURLSchedule = (Boolean)attributes.get("hasURLSchedule");

		if (hasURLSchedule != null) {
			setHasURLSchedule(hasURLSchedule);
		}

		String scheduleLinkName = (String)attributes.get("scheduleLinkName");

		if (scheduleLinkName != null) {
			setScheduleLinkName(scheduleLinkName);
		}

		String scheduleLinkURL = (String)attributes.get("scheduleLinkURL");

		if (scheduleLinkURL != null) {
			setScheduleLinkURL(scheduleLinkURL);
		}

		String phone = (String)attributes.get("phone");

		if (phone != null) {
			setPhone(phone);
		}

		String mail = (String)attributes.get("mail");

		if (mail != null) {
			setMail(mail);
		}

		String siteURL = (String)attributes.get("siteURL");

		if (siteURL != null) {
			setSiteURL(siteURL);
		}

		String siteLabel = (String)attributes.get("siteLabel");

		if (siteLabel != null) {
			setSiteLabel(siteLabel);
		}

		String bookingURL = (String)attributes.get("bookingURL");

		if (bookingURL != null) {
			setBookingURL(bookingURL);
		}

		String facebookURL = (String)attributes.get("facebookURL");

		if (facebookURL != null) {
			setFacebookURL(facebookURL);
		}

		String facebookLabel = (String)attributes.get("facebookLabel");

		if (facebookLabel != null) {
			setFacebookLabel(facebookLabel);
		}

		String instagramURL = (String)attributes.get("instagramURL");

		if (instagramURL != null) {
			setInstagramURL(instagramURL);
		}

		String instagramLabel = (String)attributes.get("instagramLabel");

		if (instagramLabel != null) {
			setInstagramLabel(instagramLabel);
		}

		String accesMap = (String)attributes.get("accesMap");

		if (accesMap != null) {
			setAccesMap(accesMap);
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

		Boolean RTEnabled = (Boolean)attributes.get("RTEnabled");

		if (RTEnabled != null) {
			setRTEnabled(RTEnabled);
		}

		String RTType = (String)attributes.get("RTType");

		if (RTType != null) {
			setRTType(RTType);
		}

		String RTExternalId = (String)attributes.get("RTExternalId");

		if (RTExternalId != null) {
			setRTExternalId(RTExternalId);
		}

		Long RTAvailable = (Long)attributes.get("RTAvailable");

		if (RTAvailable != null) {
			setRTAvailable(RTAvailable);
		}

		Long RTOccupation = (Long)attributes.get("RTOccupation");

		if (RTOccupation != null) {
			setRTOccupation(RTOccupation);
		}

		Long RTCapacity = (Long)attributes.get("RTCapacity");

		if (RTCapacity != null) {
			setRTCapacity(RTCapacity);
		}

		String RTStatus = (String)attributes.get("RTStatus");

		if (RTStatus != null) {
			setRTStatus(RTStatus);
		}

		Date RTLastUpdate = (Date)attributes.get("RTLastUpdate");

		if (RTLastUpdate != null) {
			setRTLastUpdate(RTLastUpdate);
		}

		Long imageId = (Long)attributes.get("imageId");

		if (imageId != null) {
			setImageId(imageId);
		}

		Integer imageWidth = (Integer)attributes.get("imageWidth");

		if (imageWidth != null) {
			setImageWidth(imageWidth);
		}

		Integer imageHeight = (Integer)attributes.get("imageHeight");

		if (imageHeight != null) {
			setImageHeight(imageHeight);
		}

		String imageIds = (String)attributes.get("imageIds");

		if (imageIds != null) {
			setImageIds(imageIds);
		}

		String videosIds = (String)attributes.get("videosIds");

		if (videosIds != null) {
			setVideosIds(videosIds);
		}

		Long priceId = (Long)attributes.get("priceId");

		if (priceId != null) {
			setPriceId(priceId);
		}

		String documentsIds = (String)attributes.get("documentsIds");

		if (documentsIds != null) {
			setDocumentsIds(documentsIds);
		}
	}

	@Override
	public Place cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the acces map of this place.
	 *
	 * @return the acces map of this place
	 */
	@Override
	public String getAccesMap() {
		return model.getAccesMap();
	}

	/**
	 * Returns the localized acces map of this place in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized acces map of this place
	 */
	@Override
	public String getAccesMap(java.util.Locale locale) {
		return model.getAccesMap(locale);
	}

	/**
	 * Returns the localized acces map of this place in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized acces map of this place. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getAccesMap(java.util.Locale locale, boolean useDefault) {
		return model.getAccesMap(locale, useDefault);
	}

	/**
	 * Returns the localized acces map of this place in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized acces map of this place
	 */
	@Override
	public String getAccesMap(String languageId) {
		return model.getAccesMap(languageId);
	}

	/**
	 * Returns the localized acces map of this place in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized acces map of this place
	 */
	@Override
	public String getAccesMap(String languageId, boolean useDefault) {
		return model.getAccesMap(languageId, useDefault);
	}

	@Override
	public String getAccesMapCurrentLanguageId() {
		return model.getAccesMapCurrentLanguageId();
	}

	@Override
	public String getAccesMapCurrentValue() {
		return model.getAccesMapCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized acces maps of this place.
	 *
	 * @return the locales and localized acces maps of this place
	 */
	@Override
	public Map<java.util.Locale, String> getAccesMapMap() {
		return model.getAccesMapMap();
	}

	/**
	 * Returns the access of this place.
	 *
	 * @return the access of this place
	 */
	@Override
	public String getAccess() {
		return model.getAccess();
	}

	/**
	 * Returns the localized access of this place in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized access of this place
	 */
	@Override
	public String getAccess(java.util.Locale locale) {
		return model.getAccess(locale);
	}

	/**
	 * Returns the localized access of this place in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized access of this place. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getAccess(java.util.Locale locale, boolean useDefault) {
		return model.getAccess(locale, useDefault);
	}

	/**
	 * Returns the localized access of this place in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized access of this place
	 */
	@Override
	public String getAccess(String languageId) {
		return model.getAccess(languageId);
	}

	/**
	 * Returns the localized access of this place in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized access of this place
	 */
	@Override
	public String getAccess(String languageId, boolean useDefault) {
		return model.getAccess(languageId, useDefault);
	}

	@Override
	public String getAccessCurrentLanguageId() {
		return model.getAccessCurrentLanguageId();
	}

	@Override
	public String getAccessCurrentValue() {
		return model.getAccessCurrentValue();
	}

	/**
	 * Returns the access for blind of this place.
	 *
	 * @return the access for blind of this place
	 */
	@Override
	public Boolean getAccessForBlind() {
		return model.getAccessForBlind();
	}

	/**
	 * Returns the access for deaf of this place.
	 *
	 * @return the access for deaf of this place
	 */
	@Override
	public Boolean getAccessForDeaf() {
		return model.getAccessForDeaf();
	}

	/**
	 * Returns the access for deficient of this place.
	 *
	 * @return the access for deficient of this place
	 */
	@Override
	public Boolean getAccessForDeficient() {
		return model.getAccessForDeficient();
	}

	/**
	 * Returns the access for disabled of this place.
	 *
	 * @return the access for disabled of this place
	 */
	@Override
	public String getAccessForDisabled() {
		return model.getAccessForDisabled();
	}

	/**
	 * Returns the localized access for disabled of this place in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized access for disabled of this place
	 */
	@Override
	public String getAccessForDisabled(java.util.Locale locale) {
		return model.getAccessForDisabled(locale);
	}

	/**
	 * Returns the localized access for disabled of this place in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized access for disabled of this place. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getAccessForDisabled(
		java.util.Locale locale, boolean useDefault) {

		return model.getAccessForDisabled(locale, useDefault);
	}

	/**
	 * Returns the localized access for disabled of this place in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized access for disabled of this place
	 */
	@Override
	public String getAccessForDisabled(String languageId) {
		return model.getAccessForDisabled(languageId);
	}

	/**
	 * Returns the localized access for disabled of this place in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized access for disabled of this place
	 */
	@Override
	public String getAccessForDisabled(String languageId, boolean useDefault) {
		return model.getAccessForDisabled(languageId, useDefault);
	}

	@Override
	public String getAccessForDisabledCurrentLanguageId() {
		return model.getAccessForDisabledCurrentLanguageId();
	}

	@Override
	public String getAccessForDisabledCurrentValue() {
		return model.getAccessForDisabledCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized access for disableds of this place.
	 *
	 * @return the locales and localized access for disableds of this place
	 */
	@Override
	public Map<java.util.Locale, String> getAccessForDisabledMap() {
		return model.getAccessForDisabledMap();
	}

	/**
	 * Returns the access for elder of this place.
	 *
	 * @return the access for elder of this place
	 */
	@Override
	public Boolean getAccessForElder() {
		return model.getAccessForElder();
	}

	/**
	 * Returns the access for wheelchair of this place.
	 *
	 * @return the access for wheelchair of this place
	 */
	@Override
	public Boolean getAccessForWheelchair() {
		return model.getAccessForWheelchair();
	}

	/**
	 * Returns a map of the locales and localized accesses of this place.
	 *
	 * @return the locales and localized accesses of this place
	 */
	@Override
	public Map<java.util.Locale, String> getAccessMap() {
		return model.getAccessMap();
	}

	/**
	 * Returns the additional information of this place.
	 *
	 * @return the additional information of this place
	 */
	@Override
	public String getAdditionalInformation() {
		return model.getAdditionalInformation();
	}

	/**
	 * Returns the localized additional information of this place in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized additional information of this place
	 */
	@Override
	public String getAdditionalInformation(java.util.Locale locale) {
		return model.getAdditionalInformation(locale);
	}

	/**
	 * Returns the localized additional information of this place in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized additional information of this place. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getAdditionalInformation(
		java.util.Locale locale, boolean useDefault) {

		return model.getAdditionalInformation(locale, useDefault);
	}

	/**
	 * Returns the localized additional information of this place in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized additional information of this place
	 */
	@Override
	public String getAdditionalInformation(String languageId) {
		return model.getAdditionalInformation(languageId);
	}

	/**
	 * Returns the localized additional information of this place in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized additional information of this place
	 */
	@Override
	public String getAdditionalInformation(
		String languageId, boolean useDefault) {

		return model.getAdditionalInformation(languageId, useDefault);
	}

	@Override
	public String getAdditionalInformationCurrentLanguageId() {
		return model.getAdditionalInformationCurrentLanguageId();
	}

	@Override
	public String getAdditionalInformationCurrentValue() {
		return model.getAdditionalInformationCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized additional informations of this place.
	 *
	 * @return the locales and localized additional informations of this place
	 */
	@Override
	public Map<java.util.Locale, String> getAdditionalInformationMap() {
		return model.getAdditionalInformationMap();
	}

	/**
	 * Returns the address complement of this place.
	 *
	 * @return the address complement of this place
	 */
	@Override
	public String getAddressComplement() {
		return model.getAddressComplement();
	}

	/**
	 * Returns the address country of this place.
	 *
	 * @return the address country of this place
	 */
	@Override
	public String getAddressCountry() {
		return model.getAddressCountry();
	}

	/**
	 * Returns the address distribution of this place.
	 *
	 * @return the address distribution of this place
	 */
	@Override
	public String getAddressDistribution() {
		return model.getAddressDistribution();
	}

	/**
	 * Returns the address street of this place.
	 *
	 * @return the address street of this place
	 */
	@Override
	public String getAddressStreet() {
		return model.getAddressStreet();
	}

	/**
	 * Returns the address zip code of this place.
	 *
	 * @return the address zip code of this place
	 */
	@Override
	public String getAddressZipCode() {
		return model.getAddressZipCode();
	}

	/**
	 * Returns the alias of this place.
	 *
	 * @return the alias of this place
	 */
	@Override
	public String getAlias() {
		return model.getAlias();
	}

	/**
	 * Returns the localized alias of this place in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized alias of this place
	 */
	@Override
	public String getAlias(java.util.Locale locale) {
		return model.getAlias(locale);
	}

	/**
	 * Returns the localized alias of this place in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized alias of this place. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getAlias(java.util.Locale locale, boolean useDefault) {
		return model.getAlias(locale, useDefault);
	}

	/**
	 * Returns the localized alias of this place in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized alias of this place
	 */
	@Override
	public String getAlias(String languageId) {
		return model.getAlias(languageId);
	}

	/**
	 * Returns the localized alias of this place in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized alias of this place
	 */
	@Override
	public String getAlias(String languageId, boolean useDefault) {
		return model.getAlias(languageId, useDefault);
	}

	@Override
	public String getAliasCurrentLanguageId() {
		return model.getAliasCurrentLanguageId();
	}

	@Override
	public String getAliasCurrentValue() {
		return model.getAliasCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized aliases of this place.
	 *
	 * @return the locales and localized aliases of this place
	 */
	@Override
	public Map<java.util.Locale, String> getAliasMap() {
		return model.getAliasMap();
	}

	/**
	 * Retourne l'AssetEntry rattaché cet item
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
	 * Returns the booking url of this place.
	 *
	 * @return the booking url of this place
	 */
	@Override
	public String getBookingURL() {
		return model.getBookingURL();
	}

	/**
	 * Returns the localized booking url of this place in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized booking url of this place
	 */
	@Override
	public String getBookingURL(java.util.Locale locale) {
		return model.getBookingURL(locale);
	}

	/**
	 * Returns the localized booking url of this place in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized booking url of this place. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getBookingURL(java.util.Locale locale, boolean useDefault) {
		return model.getBookingURL(locale, useDefault);
	}

	/**
	 * Returns the localized booking url of this place in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized booking url of this place
	 */
	@Override
	public String getBookingURL(String languageId) {
		return model.getBookingURL(languageId);
	}

	/**
	 * Returns the localized booking url of this place in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized booking url of this place
	 */
	@Override
	public String getBookingURL(String languageId, boolean useDefault) {
		return model.getBookingURL(languageId, useDefault);
	}

	@Override
	public String getBookingURLCurrentLanguageId() {
		return model.getBookingURLCurrentLanguageId();
	}

	@Override
	public String getBookingURLCurrentValue() {
		return model.getBookingURLCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized booking urls of this place.
	 *
	 * @return the locales and localized booking urls of this place
	 */
	@Override
	public Map<java.util.Locale, String> getBookingURLMap() {
		return model.getBookingURLMap();
	}

	/**
	 * Renvoie la liste des AssetCategory rattachées à cet item (via
	 * l'assetEntry)
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCategories() {

		return model.getCategories();
	}

	/**
	 * Returns the characteristics of this place.
	 *
	 * @return the characteristics of this place
	 */
	@Override
	public String getCharacteristics() {
		return model.getCharacteristics();
	}

	/**
	 * Returns the localized characteristics of this place in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized characteristics of this place
	 */
	@Override
	public String getCharacteristics(java.util.Locale locale) {
		return model.getCharacteristics(locale);
	}

	/**
	 * Returns the localized characteristics of this place in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized characteristics of this place. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getCharacteristics(
		java.util.Locale locale, boolean useDefault) {

		return model.getCharacteristics(locale, useDefault);
	}

	/**
	 * Returns the localized characteristics of this place in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized characteristics of this place
	 */
	@Override
	public String getCharacteristics(String languageId) {
		return model.getCharacteristics(languageId);
	}

	/**
	 * Returns the localized characteristics of this place in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized characteristics of this place
	 */
	@Override
	public String getCharacteristics(String languageId, boolean useDefault) {
		return model.getCharacteristics(languageId, useDefault);
	}

	@Override
	public String getCharacteristicsCurrentLanguageId() {
		return model.getCharacteristicsCurrentLanguageId();
	}

	@Override
	public String getCharacteristicsCurrentValue() {
		return model.getCharacteristicsCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized characteristicses of this place.
	 *
	 * @return the locales and localized characteristicses of this place
	 */
	@Override
	public Map<java.util.Locale, String> getCharacteristicsMap() {
		return model.getCharacteristicsMap();
	}

	/**
	 * Retourne la ville
	 */
	@Override
	public String getCity(java.util.Locale locale) {
		return model.getCity(locale);
	}

	/**
	 * Retourne la catégorie Territoire correspondant à la ville du lieu
	 */
	@Override
	public com.liferay.asset.kernel.model.AssetCategory getCityCategory() {
		return model.getCityCategory();
	}

	/**
	 * Returns the company ID of this place.
	 *
	 * @return the company ID of this place
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the contenu tooltip carto of this place.
	 *
	 * @return the contenu tooltip carto of this place
	 */
	@Override
	public String getContenuTooltipCarto() {
		return model.getContenuTooltipCarto();
	}

	/**
	 * Returns the localized contenu tooltip carto of this place in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized contenu tooltip carto of this place
	 */
	@Override
	public String getContenuTooltipCarto(java.util.Locale locale) {
		return model.getContenuTooltipCarto(locale);
	}

	/**
	 * Returns the localized contenu tooltip carto of this place in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized contenu tooltip carto of this place. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getContenuTooltipCarto(
		java.util.Locale locale, boolean useDefault) {

		return model.getContenuTooltipCarto(locale, useDefault);
	}

	/**
	 * Returns the localized contenu tooltip carto of this place in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized contenu tooltip carto of this place
	 */
	@Override
	public String getContenuTooltipCarto(String languageId) {
		return model.getContenuTooltipCarto(languageId);
	}

	/**
	 * Returns the localized contenu tooltip carto of this place in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized contenu tooltip carto of this place
	 */
	@Override
	public String getContenuTooltipCarto(
		String languageId, boolean useDefault) {

		return model.getContenuTooltipCarto(languageId, useDefault);
	}

	@Override
	public String getContenuTooltipCartoCurrentLanguageId() {
		return model.getContenuTooltipCartoCurrentLanguageId();
	}

	@Override
	public String getContenuTooltipCartoCurrentValue() {
		return model.getContenuTooltipCartoCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized contenu tooltip cartos of this place.
	 *
	 * @return the locales and localized contenu tooltip cartos of this place
	 */
	@Override
	public Map<java.util.Locale, String> getContenuTooltipCartoMap() {
		return model.getContenuTooltipCartoMap();
	}

	/**
	 * Returns the create date of this place.
	 *
	 * @return the create date of this place
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Renvoie le JSON de l'entite au format CSMap
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONObject getCSMapExceptionJSON() {
		return model.getCSMapExceptionJSON();
	}

	/**
	 * Renvoie le JSON de l'entite au format CSMap
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONObject getCSMapJSON() {
		return model.getCSMapJSON();
	}

	@Override
	public String getDefaultLanguageId() {
		return model.getDefaultLanguageId();
	}

	/**
	 * Retourne la période par défaut
	 */
	@Override
	public eu.strasbourg.service.place.model.Period getDefaultPeriod() {
		return model.getDefaultPeriod();
	}

	/**
	 * Returns the display events of this place.
	 *
	 * @return the display events of this place
	 */
	@Override
	public boolean getDisplayEvents() {
		return model.getDisplayEvents();
	}

	/**
	 * Retourne le quartier
	 */
	@Override
	public String getDistrict(java.util.Locale locale) {
		return model.getDistrict(locale);
	}

	/**
	 * Retourne la catégorie Territoire correspondant au quartier du lieu
	 */
	@Override
	public com.liferay.asset.kernel.model.AssetCategory getDistrictCategory() {
		return model.getDistrictCategory();
	}

	/**
	 * Retourne une map de titre et d'URL des documents de ce lieu
	 */
	@Override
	public Map<String, String> getDocuments() {
		return model.getDocuments();
	}

	/**
	 * Returns the documents IDs of this place.
	 *
	 * @return the documents IDs of this place
	 */
	@Override
	public String getDocumentsIds() {
		return model.getDocumentsIds();
	}

	/**
	 * Retourne la liste des URL des documents de ce lieu
	 */
	@Override
	public java.util.List<String> getDocumentURLs() {
		return model.getDocumentURLs();
	}

	/**
	 * Returns the exceptional schedule of this place.
	 *
	 * @return the exceptional schedule of this place
	 */
	@Override
	public String getExceptionalSchedule() {
		return model.getExceptionalSchedule();
	}

	/**
	 * Returns the localized exceptional schedule of this place in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized exceptional schedule of this place
	 */
	@Override
	public String getExceptionalSchedule(java.util.Locale locale) {
		return model.getExceptionalSchedule(locale);
	}

	/**
	 * Returns the localized exceptional schedule of this place in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized exceptional schedule of this place. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getExceptionalSchedule(
		java.util.Locale locale, boolean useDefault) {

		return model.getExceptionalSchedule(locale, useDefault);
	}

	/**
	 * Returns the localized exceptional schedule of this place in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized exceptional schedule of this place
	 */
	@Override
	public String getExceptionalSchedule(String languageId) {
		return model.getExceptionalSchedule(languageId);
	}

	/**
	 * Returns the localized exceptional schedule of this place in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized exceptional schedule of this place
	 */
	@Override
	public String getExceptionalSchedule(
		String languageId, boolean useDefault) {

		return model.getExceptionalSchedule(languageId, useDefault);
	}

	@Override
	public String getExceptionalScheduleCurrentLanguageId() {
		return model.getExceptionalScheduleCurrentLanguageId();
	}

	@Override
	public String getExceptionalScheduleCurrentValue() {
		return model.getExceptionalScheduleCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized exceptional schedules of this place.
	 *
	 * @return the locales and localized exceptional schedules of this place
	 */
	@Override
	public Map<java.util.Locale, String> getExceptionalScheduleMap() {
		return model.getExceptionalScheduleMap();
	}

	/**
	 * Returns the facebook label of this place.
	 *
	 * @return the facebook label of this place
	 */
	@Override
	public String getFacebookLabel() {
		return model.getFacebookLabel();
	}

	/**
	 * Returns the localized facebook label of this place in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized facebook label of this place
	 */
	@Override
	public String getFacebookLabel(java.util.Locale locale) {
		return model.getFacebookLabel(locale);
	}

	/**
	 * Returns the localized facebook label of this place in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized facebook label of this place. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getFacebookLabel(
		java.util.Locale locale, boolean useDefault) {

		return model.getFacebookLabel(locale, useDefault);
	}

	/**
	 * Returns the localized facebook label of this place in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized facebook label of this place
	 */
	@Override
	public String getFacebookLabel(String languageId) {
		return model.getFacebookLabel(languageId);
	}

	/**
	 * Returns the localized facebook label of this place in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized facebook label of this place
	 */
	@Override
	public String getFacebookLabel(String languageId, boolean useDefault) {
		return model.getFacebookLabel(languageId, useDefault);
	}

	@Override
	public String getFacebookLabelCurrentLanguageId() {
		return model.getFacebookLabelCurrentLanguageId();
	}

	@Override
	public String getFacebookLabelCurrentValue() {
		return model.getFacebookLabelCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized facebook labels of this place.
	 *
	 * @return the locales and localized facebook labels of this place
	 */
	@Override
	public Map<java.util.Locale, String> getFacebookLabelMap() {
		return model.getFacebookLabelMap();
	}

	/**
	 * Returns the facebook url of this place.
	 *
	 * @return the facebook url of this place
	 */
	@Override
	public String getFacebookURL() {
		return model.getFacebookURL();
	}

	/**
	 * Returns the localized facebook url of this place in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized facebook url of this place
	 */
	@Override
	public String getFacebookURL(java.util.Locale locale) {
		return model.getFacebookURL(locale);
	}

	/**
	 * Returns the localized facebook url of this place in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized facebook url of this place. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getFacebookURL(java.util.Locale locale, boolean useDefault) {
		return model.getFacebookURL(locale, useDefault);
	}

	/**
	 * Returns the localized facebook url of this place in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized facebook url of this place
	 */
	@Override
	public String getFacebookURL(String languageId) {
		return model.getFacebookURL(languageId);
	}

	/**
	 * Returns the localized facebook url of this place in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized facebook url of this place
	 */
	@Override
	public String getFacebookURL(String languageId, boolean useDefault) {
		return model.getFacebookURL(languageId, useDefault);
	}

	@Override
	public String getFacebookURLCurrentLanguageId() {
		return model.getFacebookURLCurrentLanguageId();
	}

	@Override
	public String getFacebookURLCurrentValue() {
		return model.getFacebookURLCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized facebook urls of this place.
	 *
	 * @return the locales and localized facebook urls of this place
	 */
	@Override
	public Map<java.util.Locale, String> getFacebookURLMap() {
		return model.getFacebookURLMap();
	}

	/**
	 * Retourne une map contennant les horaires de chaque jour des 7 jours
	 * suivants "startDate" (inclus)
	 */
	@Override
	public Map
		<String,
		 java.util.List<eu.strasbourg.service.place.model.PlaceSchedule>>
			getFollowingWeekSchedules(Date startDate, java.util.Locale locale) {

		return model.getFollowingWeekSchedules(startDate, locale);
	}

	/**
	 * Renvoie le JSON de l'entite au format GeoJSON pour la map
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONObject getGeoJSON(
		long groupId, java.util.Locale locale, long territoryVocabularyId,
		long placeTypeVocabularyId) {

		return model.getGeoJSON(
			groupId, locale, territoryVocabularyId, placeTypeVocabularyId);
	}

	/**
	 * Returns the group ID of this place.
	 *
	 * @return the group ID of this place
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the has url schedule of this place.
	 *
	 * @return the has url schedule of this place
	 */
	@Override
	public boolean getHasURLSchedule() {
		return model.getHasURLSchedule();
	}

	/**
	 * Retourne une map contennant le jour et une liste de PlaceSchedule de la
	 * semaine en cours
	 */
	@Override
	public Map
		<String,
		 java.util.List<eu.strasbourg.service.place.model.PlaceSchedule>>
			getHoraire(Date dateJour, java.util.Locale locale) {

		return model.getHoraire(dateJour, locale);
	}

	/**
	 * Retourne le copyright de l'image principale
	 */
	@Override
	public String getImageCopyright(java.util.Locale locale) {
		return model.getImageCopyright(locale);
	}

	/**
	 * Retourne le copyright publiques de l'image
	 */
	@Override
	public String getImageCopyright(Long imageId, java.util.Locale locale) {
		return model.getImageCopyright(imageId, locale);
	}

	/**
	 * Returns the image height of this place.
	 *
	 * @return the image height of this place
	 */
	@Override
	public Integer getImageHeight() {
		return model.getImageHeight();
	}

	/**
	 * Returns the image ID of this place.
	 *
	 * @return the image ID of this place
	 */
	@Override
	public long getImageId() {
		return model.getImageId();
	}

	/**
	 * Returns the image IDs of this place.
	 *
	 * @return the image IDs of this place
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
	 * Retourne la liste des URL publiques des images additionnelles
	 */
	@Override
	public java.util.List<String> getImagesURLs() {
		return model.getImagesURLs();
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
	 * Retourne la liste des URL publiques des images additionnelles avec la version et le timastamp
	 */
	@Override
	public java.util.List<String> getImageURLsWithTimeStamp() {
		return model.getImageURLsWithTimeStamp();
	}

	/**
	 * Returns the image width of this place.
	 *
	 * @return the image width of this place
	 */
	@Override
	public Integer getImageWidth() {
		return model.getImageWidth();
	}

	/**
	 * Returns the instagram label of this place.
	 *
	 * @return the instagram label of this place
	 */
	@Override
	public String getInstagramLabel() {
		return model.getInstagramLabel();
	}

	/**
	 * Returns the localized instagram label of this place in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized instagram label of this place
	 */
	@Override
	public String getInstagramLabel(java.util.Locale locale) {
		return model.getInstagramLabel(locale);
	}

	/**
	 * Returns the localized instagram label of this place in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized instagram label of this place. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getInstagramLabel(
		java.util.Locale locale, boolean useDefault) {

		return model.getInstagramLabel(locale, useDefault);
	}

	/**
	 * Returns the localized instagram label of this place in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized instagram label of this place
	 */
	@Override
	public String getInstagramLabel(String languageId) {
		return model.getInstagramLabel(languageId);
	}

	/**
	 * Returns the localized instagram label of this place in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized instagram label of this place
	 */
	@Override
	public String getInstagramLabel(String languageId, boolean useDefault) {
		return model.getInstagramLabel(languageId, useDefault);
	}

	@Override
	public String getInstagramLabelCurrentLanguageId() {
		return model.getInstagramLabelCurrentLanguageId();
	}

	@Override
	public String getInstagramLabelCurrentValue() {
		return model.getInstagramLabelCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized instagram labels of this place.
	 *
	 * @return the locales and localized instagram labels of this place
	 */
	@Override
	public Map<java.util.Locale, String> getInstagramLabelMap() {
		return model.getInstagramLabelMap();
	}

	/**
	 * Returns the instagram url of this place.
	 *
	 * @return the instagram url of this place
	 */
	@Override
	public String getInstagramURL() {
		return model.getInstagramURL();
	}

	/**
	 * Returns the localized instagram url of this place in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized instagram url of this place
	 */
	@Override
	public String getInstagramURL(java.util.Locale locale) {
		return model.getInstagramURL(locale);
	}

	/**
	 * Returns the localized instagram url of this place in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized instagram url of this place. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getInstagramURL(java.util.Locale locale, boolean useDefault) {
		return model.getInstagramURL(locale, useDefault);
	}

	/**
	 * Returns the localized instagram url of this place in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized instagram url of this place
	 */
	@Override
	public String getInstagramURL(String languageId) {
		return model.getInstagramURL(languageId);
	}

	/**
	 * Returns the localized instagram url of this place in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized instagram url of this place
	 */
	@Override
	public String getInstagramURL(String languageId, boolean useDefault) {
		return model.getInstagramURL(languageId, useDefault);
	}

	@Override
	public String getInstagramURLCurrentLanguageId() {
		return model.getInstagramURLCurrentLanguageId();
	}

	@Override
	public String getInstagramURLCurrentValue() {
		return model.getInstagramURLCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized instagram urls of this place.
	 *
	 * @return the locales and localized instagram urls of this place
	 */
	@Override
	public Map<java.util.Locale, String> getInstagramURLMap() {
		return model.getInstagramURLMap();
	}

	/**
	 * Returns the last publish date of this place.
	 *
	 * @return the last publish date of this place
	 */
	@Override
	public Date getLastPublishDate() {
		return model.getLastPublishDate();
	}

	/**
	 * Returns the location ID of this place.
	 *
	 * @return the location ID of this place
	 */
	@Override
	public String getLocationId() {
		return model.getLocationId();
	}

	/**
	 * Returns the mail of this place.
	 *
	 * @return the mail of this place
	 */
	@Override
	public String getMail() {
		return model.getMail();
	}

	/**
	 * Returns the mercator x of this place.
	 *
	 * @return the mercator x of this place
	 */
	@Override
	public String getMercatorX() {
		return model.getMercatorX();
	}

	/**
	 * Returns the mercator y of this place.
	 *
	 * @return the mercator y of this place
	 */
	@Override
	public String getMercatorY() {
		return model.getMercatorY();
	}

	/**
	 * Returns the modified date of this place.
	 *
	 * @return the modified date of this place
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this place.
	 *
	 * @return the name of this place
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Retourne le PlaceSchedule de la prochaine ouverture (pour X jour)
	 */
	@Override
	public eu.strasbourg.service.place.model.PlaceSchedule
		getNextScheduleOpening(
			java.util.GregorianCalendar today, int nbDays,
			java.util.Locale locale) {

		return model.getNextScheduleOpening(today, nbDays, locale);
	}

	/**
	 * Retourne le PlaceSchedule de la prochaine ouverture (sous quinzaine)
	 */
	@Override
	public eu.strasbourg.service.place.model.PlaceSchedule
		getNextScheduleOpening(
			java.util.GregorianCalendar today, java.util.Locale locale) {

		return model.getNextScheduleOpening(today, locale);
	}

	/**
	 * Retourne les périodes qui ne sont pas par défaut (uniquement les périodes en cours ou futures)
	 */
	@Override
	public java.util.List<eu.strasbourg.service.place.model.Period>
		getNonDefaultPeriods() {

		return model.getNonDefaultPeriods();
	}

	/**
	 * Renvoie le titre du lieu pour friendlyUrl
	 */
	@Override
	public String getNormalizedAlias() {
		return model.getNormalizedAlias();
	}

	/**
	 * Renvoie le titre du lieu pour friendlyUrl
	 */
	@Override
	public String getNormalizedAlias(java.util.Locale locale) {
		return model.getNormalizedAlias(locale);
	}

	/**
	 * Retourne les Periods du lieux
	 */
	@Override
	public java.util.List<eu.strasbourg.service.place.model.Period>
		getPeriods() {

		return model.getPeriods();
	}

	/**
	 * Returns the phone of this place.
	 *
	 * @return the phone of this place
	 */
	@Override
	public String getPhone() {
		return model.getPhone();
	}

	/**
	 * Returns the place ID of this place.
	 *
	 * @return the place ID of this place
	 */
	@Override
	public long getPlaceId() {
		return model.getPlaceId();
	}

	/**
	 * Retourne les horaires d'ouverture du jour passé en paramètre jusqu'à
	 * "date" + "daysCount"
	 */
	@Override
	public Map
		<String,
		 java.util.List<eu.strasbourg.service.place.model.PlaceSchedule>>
			getPlaceSchedule(
				Date date, int daysCount, java.util.Locale locale) {

		return model.getPlaceSchedule(date, daysCount, locale);
	}

	/**
	 * Retourne les horaires d'ouverture du jour
	 */
	@Override
	public java.util.List<eu.strasbourg.service.place.model.PlaceSchedule>
		getPlaceSchedule(
			java.util.GregorianCalendar jourSemaine, java.util.Locale locale) {

		return model.getPlaceSchedule(jourSemaine, locale);
	}

	/**
	 * Retourne les horaires des exceptions d'ouverture à partir du lundi de la
	 * semaine en cours
	 *
	 * @param surPeriode (false = horaires d'une journée uniquement , true = horaires
	 sur 2 mois à partir du jour + le début de la semaine)
	 */
	@Override
	public java.util.List<eu.strasbourg.service.place.model.PlaceSchedule>
		getPlaceScheduleException(
			java.util.GregorianCalendar dateChoisie, Boolean surPeriode,
			java.util.Locale locale) {

		return model.getPlaceScheduleException(dateChoisie, surPeriode, locale);
	}

	/**
	 * Retourne les PlaceSchedule des exceptions d'ouverture à partir du lundi
	 * de la semaine en cours, jusqu'à dans 2 mois (pour freemarker)
	 */
	@Override
	public java.util.List<eu.strasbourg.service.place.model.PlaceSchedule>
		getPlaceScheduleExceptionFreeMarker(
			Date dateDeb, Boolean surPeriode, java.util.Locale locale) {

		return model.getPlaceScheduleExceptionFreeMarker(
			dateDeb, surPeriode, locale);
	}

	/**
	 * Returns the presentation of this place.
	 *
	 * @return the presentation of this place
	 */
	@Override
	public String getPresentation() {
		return model.getPresentation();
	}

	/**
	 * Returns the localized presentation of this place in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized presentation of this place
	 */
	@Override
	public String getPresentation(java.util.Locale locale) {
		return model.getPresentation(locale);
	}

	/**
	 * Returns the localized presentation of this place in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized presentation of this place. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getPresentation(java.util.Locale locale, boolean useDefault) {
		return model.getPresentation(locale, useDefault);
	}

	/**
	 * Returns the localized presentation of this place in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized presentation of this place
	 */
	@Override
	public String getPresentation(String languageId) {
		return model.getPresentation(languageId);
	}

	/**
	 * Returns the localized presentation of this place in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized presentation of this place
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
	 * Returns a map of the locales and localized presentations of this place.
	 *
	 * @return the locales and localized presentations of this place
	 */
	@Override
	public Map<java.util.Locale, String> getPresentationMap() {
		return model.getPresentationMap();
	}

	/**
	 * Retourne le prix rattaché au lieu
	 */
	@Override
	public eu.strasbourg.service.place.model.Price getPrice() {
		return model.getPrice();
	}

	/**
	 * Returns the price ID of this place.
	 *
	 * @return the price ID of this place
	 */
	@Override
	public long getPriceId() {
		return model.getPriceId();
	}

	/**
	 * Returns the primary key of this place.
	 *
	 * @return the primary key of this place
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Retourne les PublicHolidays
	 */
	@Override
	public java.util.List<eu.strasbourg.service.place.model.PublicHoliday>
		getPublicHolidays() {

		return model.getPublicHolidays();
	}

	/**
	 * Retourne les sous lieux publiés du lieu
	 */
	@Override
	public java.util.List<eu.strasbourg.service.place.model.SubPlace>
		getPublishedSubPlaces() {

		return model.getPublishedSubPlaces();
	}

	/**
	 * Retourne une map d'URL et de titre des images additionnelles et des
	 * vidéos
	 *
	 * @throws PortalException
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetEntry>
			getRandomContents()
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.getRandomContents();
	}

	/**
	 * Retourne le temps réel (en gérant automatiquement le fait que ce soit une
	 * piscine,une mairie ou un parking)
	 *
	 * @throws Exception
	 */
	@Override
	public eu.strasbourg.utils.OccupationState getRealTime() {
		return model.getRealTime();
	}

	/**
	 * Retourne le temps réel (couleur de fond,valeur)
	 *
	 * @param type (1 = piscine, 2 = parking, 3 = mairie, 4 = patinoire, 5 =Vélop)
	 * @throws Exception
	 */
	@Override
	public eu.strasbourg.utils.OccupationState getRealTime(String type) {
		return model.getRealTime(type);
	}

	/**
	 * Retourne les horaires habituels d'ouverture du jour
	 */
	@Override
	public eu.strasbourg.service.place.model.PlaceSchedule
		getRegularPlaceSchedule(
			java.util.GregorianCalendar jourSemaine, java.util.Locale locale) {

		return model.getRegularPlaceSchedule(jourSemaine, locale);
	}

	/**
	 * Returns the rgf93x of this place.
	 *
	 * @return the rgf93x of this place
	 */
	@Override
	public String getRGF93X() {
		return model.getRGF93X();
	}

	/**
	 * Returns the rgf93y of this place.
	 *
	 * @return the rgf93y of this place
	 */
	@Override
	public String getRGF93Y() {
		return model.getRGF93Y();
	}

	/**
	 * Returns the rt available of this place.
	 *
	 * @return the rt available of this place
	 */
	@Override
	public long getRTAvailable() {
		return model.getRTAvailable();
	}

	/**
	 * Returns the rt capacity of this place.
	 *
	 * @return the rt capacity of this place
	 */
	@Override
	public long getRTCapacity() {
		return model.getRTCapacity();
	}

	/**
	 * Returns the rt enabled of this place.
	 *
	 * @return the rt enabled of this place
	 */
	@Override
	public Boolean getRTEnabled() {
		return model.getRTEnabled();
	}

	/**
	 * Returns the rt external ID of this place.
	 *
	 * @return the rt external ID of this place
	 */
	@Override
	public String getRTExternalId() {
		return model.getRTExternalId();
	}

	/**
	 * Returns the rt last update of this place.
	 *
	 * @return the rt last update of this place
	 */
	@Override
	public Date getRTLastUpdate() {
		return model.getRTLastUpdate();
	}

	/**
	 * Returns the rt occupation of this place.
	 *
	 * @return the rt occupation of this place
	 */
	@Override
	public long getRTOccupation() {
		return model.getRTOccupation();
	}

	/**
	 * Returns the rt status of this place.
	 *
	 * @return the rt status of this place
	 */
	@Override
	public String getRTStatus() {
		return model.getRTStatus();
	}

	/**
	 * Returns the rt type of this place.
	 *
	 * @return the rt type of this place
	 */
	@Override
	public String getRTType() {
		return model.getRTType();
	}

	/**
	 * Renvoie le JSON des horaires sur 7 jours au format CSMap
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONObject getScheduleCSMapJSON() {
		return model.getScheduleCSMapJSON();
	}

	/**
	 * Retourne les ScheduleExceptions du lieu
	 */
	@Override
	public java.util.List<eu.strasbourg.service.place.model.ScheduleException>
		getScheduleExceptions() {

		return model.getScheduleExceptions();
	}

	/**
	 * Renvoie la liste des IDs des ScheduleExceptions auxquelles ce lieu
	 * appartient sous forme de String
	 */
	@Override
	public String getScheduleExceptionsIds() {
		return model.getScheduleExceptionsIds();
	}

	/**
	 * Returns the schedule link name of this place.
	 *
	 * @return the schedule link name of this place
	 */
	@Override
	public String getScheduleLinkName() {
		return model.getScheduleLinkName();
	}

	/**
	 * Returns the localized schedule link name of this place in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized schedule link name of this place
	 */
	@Override
	public String getScheduleLinkName(java.util.Locale locale) {
		return model.getScheduleLinkName(locale);
	}

	/**
	 * Returns the localized schedule link name of this place in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized schedule link name of this place. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getScheduleLinkName(
		java.util.Locale locale, boolean useDefault) {

		return model.getScheduleLinkName(locale, useDefault);
	}

	/**
	 * Returns the localized schedule link name of this place in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized schedule link name of this place
	 */
	@Override
	public String getScheduleLinkName(String languageId) {
		return model.getScheduleLinkName(languageId);
	}

	/**
	 * Returns the localized schedule link name of this place in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized schedule link name of this place
	 */
	@Override
	public String getScheduleLinkName(String languageId, boolean useDefault) {
		return model.getScheduleLinkName(languageId, useDefault);
	}

	@Override
	public String getScheduleLinkNameCurrentLanguageId() {
		return model.getScheduleLinkNameCurrentLanguageId();
	}

	@Override
	public String getScheduleLinkNameCurrentValue() {
		return model.getScheduleLinkNameCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized schedule link names of this place.
	 *
	 * @return the locales and localized schedule link names of this place
	 */
	@Override
	public Map<java.util.Locale, String> getScheduleLinkNameMap() {
		return model.getScheduleLinkNameMap();
	}

	/**
	 * Returns the schedule link url of this place.
	 *
	 * @return the schedule link url of this place
	 */
	@Override
	public String getScheduleLinkURL() {
		return model.getScheduleLinkURL();
	}

	/**
	 * Returns the localized schedule link url of this place in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized schedule link url of this place
	 */
	@Override
	public String getScheduleLinkURL(java.util.Locale locale) {
		return model.getScheduleLinkURL(locale);
	}

	/**
	 * Returns the localized schedule link url of this place in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized schedule link url of this place. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getScheduleLinkURL(
		java.util.Locale locale, boolean useDefault) {

		return model.getScheduleLinkURL(locale, useDefault);
	}

	/**
	 * Returns the localized schedule link url of this place in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized schedule link url of this place
	 */
	@Override
	public String getScheduleLinkURL(String languageId) {
		return model.getScheduleLinkURL(languageId);
	}

	/**
	 * Returns the localized schedule link url of this place in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized schedule link url of this place
	 */
	@Override
	public String getScheduleLinkURL(String languageId, boolean useDefault) {
		return model.getScheduleLinkURL(languageId, useDefault);
	}

	@Override
	public String getScheduleLinkURLCurrentLanguageId() {
		return model.getScheduleLinkURLCurrentLanguageId();
	}

	@Override
	public String getScheduleLinkURLCurrentValue() {
		return model.getScheduleLinkURLCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized schedule link urls of this place.
	 *
	 * @return the locales and localized schedule link urls of this place
	 */
	@Override
	public Map<java.util.Locale, String> getScheduleLinkURLMap() {
		return model.getScheduleLinkURLMap();
	}

	/**
	 * Returns the service and activities of this place.
	 *
	 * @return the service and activities of this place
	 */
	@Override
	public String getServiceAndActivities() {
		return model.getServiceAndActivities();
	}

	/**
	 * Returns the localized service and activities of this place in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized service and activities of this place
	 */
	@Override
	public String getServiceAndActivities(java.util.Locale locale) {
		return model.getServiceAndActivities(locale);
	}

	/**
	 * Returns the localized service and activities of this place in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized service and activities of this place. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getServiceAndActivities(
		java.util.Locale locale, boolean useDefault) {

		return model.getServiceAndActivities(locale, useDefault);
	}

	/**
	 * Returns the localized service and activities of this place in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized service and activities of this place
	 */
	@Override
	public String getServiceAndActivities(String languageId) {
		return model.getServiceAndActivities(languageId);
	}

	/**
	 * Returns the localized service and activities of this place in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized service and activities of this place
	 */
	@Override
	public String getServiceAndActivities(
		String languageId, boolean useDefault) {

		return model.getServiceAndActivities(languageId, useDefault);
	}

	@Override
	public String getServiceAndActivitiesCurrentLanguageId() {
		return model.getServiceAndActivitiesCurrentLanguageId();
	}

	@Override
	public String getServiceAndActivitiesCurrentValue() {
		return model.getServiceAndActivitiesCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized service and activitieses of this place.
	 *
	 * @return the locales and localized service and activitieses of this place
	 */
	@Override
	public Map<java.util.Locale, String> getServiceAndActivitiesMap() {
		return model.getServiceAndActivitiesMap();
	}

	/**
	 * Returns the si gid of this place.
	 *
	 * @return the si gid of this place
	 */
	@Override
	public String getSIGid() {
		return model.getSIGid();
	}

	/**
	 * Returns the site label of this place.
	 *
	 * @return the site label of this place
	 */
	@Override
	public String getSiteLabel() {
		return model.getSiteLabel();
	}

	/**
	 * Returns the localized site label of this place in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized site label of this place
	 */
	@Override
	public String getSiteLabel(java.util.Locale locale) {
		return model.getSiteLabel(locale);
	}

	/**
	 * Returns the localized site label of this place in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized site label of this place. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getSiteLabel(java.util.Locale locale, boolean useDefault) {
		return model.getSiteLabel(locale, useDefault);
	}

	/**
	 * Returns the localized site label of this place in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized site label of this place
	 */
	@Override
	public String getSiteLabel(String languageId) {
		return model.getSiteLabel(languageId);
	}

	/**
	 * Returns the localized site label of this place in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized site label of this place
	 */
	@Override
	public String getSiteLabel(String languageId, boolean useDefault) {
		return model.getSiteLabel(languageId, useDefault);
	}

	@Override
	public String getSiteLabelCurrentLanguageId() {
		return model.getSiteLabelCurrentLanguageId();
	}

	@Override
	public String getSiteLabelCurrentValue() {
		return model.getSiteLabelCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized site labels of this place.
	 *
	 * @return the locales and localized site labels of this place
	 */
	@Override
	public Map<java.util.Locale, String> getSiteLabelMap() {
		return model.getSiteLabelMap();
	}

	/**
	 * Returns the site url of this place.
	 *
	 * @return the site url of this place
	 */
	@Override
	public String getSiteURL() {
		return model.getSiteURL();
	}

	/**
	 * Returns the localized site url of this place in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized site url of this place
	 */
	@Override
	public String getSiteURL(java.util.Locale locale) {
		return model.getSiteURL(locale);
	}

	/**
	 * Returns the localized site url of this place in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized site url of this place. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getSiteURL(java.util.Locale locale, boolean useDefault) {
		return model.getSiteURL(locale, useDefault);
	}

	/**
	 * Returns the localized site url of this place in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized site url of this place
	 */
	@Override
	public String getSiteURL(String languageId) {
		return model.getSiteURL(languageId);
	}

	/**
	 * Returns the localized site url of this place in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized site url of this place
	 */
	@Override
	public String getSiteURL(String languageId, boolean useDefault) {
		return model.getSiteURL(languageId, useDefault);
	}

	@Override
	public String getSiteURLCurrentLanguageId() {
		return model.getSiteURLCurrentLanguageId();
	}

	@Override
	public String getSiteURLCurrentValue() {
		return model.getSiteURLCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized site urls of this place.
	 *
	 * @return the locales and localized site urls of this place
	 */
	@Override
	public Map<java.util.Locale, String> getSiteURLMap() {
		return model.getSiteURLMap();
	}

	/**
	 * Returns the status of this place.
	 *
	 * @return the status of this place
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this place.
	 *
	 * @return the status by user ID of this place
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this place.
	 *
	 * @return the status by user name of this place
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this place.
	 *
	 * @return the status by user uuid of this place
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this place.
	 *
	 * @return the status date of this place
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the subject to public holiday of this place.
	 *
	 * @return the subject to public holiday of this place
	 */
	@Override
	public boolean getSubjectToPublicHoliday() {
		return model.getSubjectToPublicHoliday();
	}

	/**
	 * Retourne les sous lieux du lieux
	 */
	@Override
	public java.util.List<eu.strasbourg.service.place.model.SubPlace>
		getSubPlaces() {

		return model.getSubPlaces();
	}

	/**
	 * Retourne les territoire du lieu
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getTerritories() {

		return model.getTerritories();
	}

	/**
	 * Retourne le label des types de l'événement
	 */
	@Override
	public String getTypeLabel(java.util.Locale locale) {
		return model.getTypeLabel(locale);
	}

	/**
	 * Retourne les types du lieu
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getTypes() {

		return model.getTypes();
	}

	/**
	 * Returns the user ID of this place.
	 *
	 * @return the user ID of this place
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this place.
	 *
	 * @return the user name of this place
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this place.
	 *
	 * @return the user uuid of this place
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this place.
	 *
	 * @return the uuid of this place
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
	 * Returns the videos IDs of this place.
	 *
	 * @return the videos IDs of this place
	 */
	@Override
	public String getVideosIds() {
		return model.getVideosIds();
	}

	/**
	 * Retourne true si l'événement est accessible pour au moins un type de
	 * handicap
	 *
	 * @Override public List<Event> getEvents() {
	 List<Event> events = EventLocalServiceUtil.findByPlaceSIGId(this.getSIGid());
	 return events;
	 }
	 * @Override public List<Event> getPublishedEvents() {
	 List<Event> events = EventLocalServiceUtil.findByPlaceSIGId(this.getSIGid());
	 return events.stream().filter(e -> e.isApproved()).collect(Collectors.toList());
	 }
	 * @Override public List<Event> getCurrentAndFuturePublishedEvents() {
	 final Calendar cal = Calendar.getInstance();
	 cal.add(Calendar.DATE, -1);
	 Date yesterday = cal.getTime();
	 List<Event> events = EventLocalServiceUtil.findByPlaceSIGId(this.getSIGid());
	 return events.stream().filter(e -> e.isApproved() && e.getStartDateFirstCurrentAndFuturePeriod().compareTo(yesterday) > 0).collect(Collectors.toList());
	 }
	 */
	@Override
	public boolean hasAnyAccessForDisabled() {
		return model.hasAnyAccessForDisabled();
	}

	/**
	 * Retourne true si le type du lieu doit avoir un calendrier d'horaires
	 */
	@Override
	public Boolean hasScheduleTable() {
		return model.hasScheduleTable();
	}

	/**
	 * Returns <code>true</code> if this place is approved.
	 *
	 * @return <code>true</code> if this place is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Vérifie si le lieu est fermé un jour donné
	 */
	@Override
	public Boolean isClosed(java.util.GregorianCalendar jourSemaine) {
		return model.isClosed(jourSemaine);
	}

	/**
	 * Returns <code>true</code> if this place is denied.
	 *
	 * @return <code>true</code> if this place is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this place is display events.
	 *
	 * @return <code>true</code> if this place is display events; <code>false</code> otherwise
	 */
	@Override
	public boolean isDisplayEvents() {
		return model.isDisplayEvents();
	}

	/**
	 * Returns <code>true</code> if this place is a draft.
	 *
	 * @return <code>true</code> if this place is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Vérifie si le lieu à accès au temps réel
	 *
	 * @throws PortalException
	 */
	@Override
	public Boolean isEnabled()
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.isEnabled();
	}

	/**
	 * Returns <code>true</code> if this place is expired.
	 *
	 * @return <code>true</code> if this place is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this place is has url schedule.
	 *
	 * @return <code>true</code> if this place is has url schedule; <code>false</code> otherwise
	 */
	@Override
	public boolean isHasURLSchedule() {
		return model.isHasURLSchedule();
	}

	/**
	 * Retourne true si le lieu est une patinoire
	 *
	 * @return
	 */
	@Override
	public boolean isIceRink() {
		return model.isIceRink();
	}

	/**
	 * Returns <code>true</code> if this place is inactive.
	 *
	 * @return <code>true</code> if this place is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this place is incomplete.
	 *
	 * @return <code>true</code> if this place is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Retourne true si le lieu est une mairie
	 *
	 * @return
	 */
	@Override
	public boolean isMairie() {
		return model.isMairie();
	}

	/**
	 * Retourne true si le lieu est ouvert à l'instant passé en paramètre
	 */
	@Override
	public Boolean isOpen(java.time.LocalDateTime localDateTime) {
		return model.isOpen(localDateTime);
	}

	/**
	 * Retourne true si le lieu est ouvert à l'instant présent
	 */
	@Override
	public Boolean isOpenNow() {
		return model.isOpenNow();
	}

	/**
	 * Retourne true si le lieu est un parking
	 *
	 * @return
	 */
	@Override
	public boolean isParking() {
		return model.isParking();
	}

	/**
	 * Returns <code>true</code> if this place is pending.
	 *
	 * @return <code>true</code> if this place is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this place is scheduled.
	 *
	 * @return <code>true</code> if this place is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
	}

	/**
	 * Retourne true si le type du lieu est recherchable (utilisé pour affiche tous les lieux de meme type)
	 */
	@Override
	public Boolean isSearchable() {
		return model.isSearchable();
	}

	/**
	 * Returns <code>true</code> if this place is subject to public holiday.
	 *
	 * @return <code>true</code> if this place is subject to public holiday; <code>false</code> otherwise
	 */
	@Override
	public boolean isSubjectToPublicHoliday() {
		return model.isSubjectToPublicHoliday();
	}

	/**
	 * Retourne true si le lieu est une piscine
	 *
	 * @return
	 */
	@Override
	public boolean isSwimmingPool() {
		return model.isSwimmingPool();
	}

	/**
	 * Retourne true si le lieu est une station vélhop
	 *
	 * @return
	 */
	@Override
	public boolean isVelhopStation() {
		return model.isVelhopStation();
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
	 * Sets the acces map of this place.
	 *
	 * @param accesMap the acces map of this place
	 */
	@Override
	public void setAccesMap(String accesMap) {
		model.setAccesMap(accesMap);
	}

	/**
	 * Sets the localized acces map of this place in the language.
	 *
	 * @param accesMap the localized acces map of this place
	 * @param locale the locale of the language
	 */
	@Override
	public void setAccesMap(String accesMap, java.util.Locale locale) {
		model.setAccesMap(accesMap, locale);
	}

	/**
	 * Sets the localized acces map of this place in the language, and sets the default locale.
	 *
	 * @param accesMap the localized acces map of this place
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setAccesMap(
		String accesMap, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setAccesMap(accesMap, locale, defaultLocale);
	}

	@Override
	public void setAccesMapCurrentLanguageId(String languageId) {
		model.setAccesMapCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized acces maps of this place from the map of locales and localized acces maps.
	 *
	 * @param accesMapMap the locales and localized acces maps of this place
	 */
	@Override
	public void setAccesMapMap(Map<java.util.Locale, String> accesMapMap) {
		model.setAccesMapMap(accesMapMap);
	}

	/**
	 * Sets the localized acces maps of this place from the map of locales and localized acces maps, and sets the default locale.
	 *
	 * @param accesMapMap the locales and localized acces maps of this place
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setAccesMapMap(
		Map<java.util.Locale, String> accesMapMap,
		java.util.Locale defaultLocale) {

		model.setAccesMapMap(accesMapMap, defaultLocale);
	}

	/**
	 * Sets the access of this place.
	 *
	 * @param access the access of this place
	 */
	@Override
	public void setAccess(String access) {
		model.setAccess(access);
	}

	/**
	 * Sets the localized access of this place in the language.
	 *
	 * @param access the localized access of this place
	 * @param locale the locale of the language
	 */
	@Override
	public void setAccess(String access, java.util.Locale locale) {
		model.setAccess(access, locale);
	}

	/**
	 * Sets the localized access of this place in the language, and sets the default locale.
	 *
	 * @param access the localized access of this place
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setAccess(
		String access, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setAccess(access, locale, defaultLocale);
	}

	@Override
	public void setAccessCurrentLanguageId(String languageId) {
		model.setAccessCurrentLanguageId(languageId);
	}

	/**
	 * Sets the access for blind of this place.
	 *
	 * @param accessForBlind the access for blind of this place
	 */
	@Override
	public void setAccessForBlind(Boolean accessForBlind) {
		model.setAccessForBlind(accessForBlind);
	}

	/**
	 * Sets the access for deaf of this place.
	 *
	 * @param accessForDeaf the access for deaf of this place
	 */
	@Override
	public void setAccessForDeaf(Boolean accessForDeaf) {
		model.setAccessForDeaf(accessForDeaf);
	}

	/**
	 * Sets the access for deficient of this place.
	 *
	 * @param accessForDeficient the access for deficient of this place
	 */
	@Override
	public void setAccessForDeficient(Boolean accessForDeficient) {
		model.setAccessForDeficient(accessForDeficient);
	}

	/**
	 * Sets the access for disabled of this place.
	 *
	 * @param accessForDisabled the access for disabled of this place
	 */
	@Override
	public void setAccessForDisabled(String accessForDisabled) {
		model.setAccessForDisabled(accessForDisabled);
	}

	/**
	 * Sets the localized access for disabled of this place in the language.
	 *
	 * @param accessForDisabled the localized access for disabled of this place
	 * @param locale the locale of the language
	 */
	@Override
	public void setAccessForDisabled(
		String accessForDisabled, java.util.Locale locale) {

		model.setAccessForDisabled(accessForDisabled, locale);
	}

	/**
	 * Sets the localized access for disabled of this place in the language, and sets the default locale.
	 *
	 * @param accessForDisabled the localized access for disabled of this place
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setAccessForDisabled(
		String accessForDisabled, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setAccessForDisabled(accessForDisabled, locale, defaultLocale);
	}

	@Override
	public void setAccessForDisabledCurrentLanguageId(String languageId) {
		model.setAccessForDisabledCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized access for disableds of this place from the map of locales and localized access for disableds.
	 *
	 * @param accessForDisabledMap the locales and localized access for disableds of this place
	 */
	@Override
	public void setAccessForDisabledMap(
		Map<java.util.Locale, String> accessForDisabledMap) {

		model.setAccessForDisabledMap(accessForDisabledMap);
	}

	/**
	 * Sets the localized access for disableds of this place from the map of locales and localized access for disableds, and sets the default locale.
	 *
	 * @param accessForDisabledMap the locales and localized access for disableds of this place
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setAccessForDisabledMap(
		Map<java.util.Locale, String> accessForDisabledMap,
		java.util.Locale defaultLocale) {

		model.setAccessForDisabledMap(accessForDisabledMap, defaultLocale);
	}

	/**
	 * Sets the access for elder of this place.
	 *
	 * @param accessForElder the access for elder of this place
	 */
	@Override
	public void setAccessForElder(Boolean accessForElder) {
		model.setAccessForElder(accessForElder);
	}

	/**
	 * Sets the access for wheelchair of this place.
	 *
	 * @param accessForWheelchair the access for wheelchair of this place
	 */
	@Override
	public void setAccessForWheelchair(Boolean accessForWheelchair) {
		model.setAccessForWheelchair(accessForWheelchair);
	}

	/**
	 * Sets the localized accesses of this place from the map of locales and localized accesses.
	 *
	 * @param accessMap the locales and localized accesses of this place
	 */
	@Override
	public void setAccessMap(Map<java.util.Locale, String> accessMap) {
		model.setAccessMap(accessMap);
	}

	/**
	 * Sets the localized accesses of this place from the map of locales and localized accesses, and sets the default locale.
	 *
	 * @param accessMap the locales and localized accesses of this place
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setAccessMap(
		Map<java.util.Locale, String> accessMap,
		java.util.Locale defaultLocale) {

		model.setAccessMap(accessMap, defaultLocale);
	}

	/**
	 * Sets the additional information of this place.
	 *
	 * @param additionalInformation the additional information of this place
	 */
	@Override
	public void setAdditionalInformation(String additionalInformation) {
		model.setAdditionalInformation(additionalInformation);
	}

	/**
	 * Sets the localized additional information of this place in the language.
	 *
	 * @param additionalInformation the localized additional information of this place
	 * @param locale the locale of the language
	 */
	@Override
	public void setAdditionalInformation(
		String additionalInformation, java.util.Locale locale) {

		model.setAdditionalInformation(additionalInformation, locale);
	}

	/**
	 * Sets the localized additional information of this place in the language, and sets the default locale.
	 *
	 * @param additionalInformation the localized additional information of this place
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setAdditionalInformation(
		String additionalInformation, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setAdditionalInformation(
			additionalInformation, locale, defaultLocale);
	}

	@Override
	public void setAdditionalInformationCurrentLanguageId(String languageId) {
		model.setAdditionalInformationCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized additional informations of this place from the map of locales and localized additional informations.
	 *
	 * @param additionalInformationMap the locales and localized additional informations of this place
	 */
	@Override
	public void setAdditionalInformationMap(
		Map<java.util.Locale, String> additionalInformationMap) {

		model.setAdditionalInformationMap(additionalInformationMap);
	}

	/**
	 * Sets the localized additional informations of this place from the map of locales and localized additional informations, and sets the default locale.
	 *
	 * @param additionalInformationMap the locales and localized additional informations of this place
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setAdditionalInformationMap(
		Map<java.util.Locale, String> additionalInformationMap,
		java.util.Locale defaultLocale) {

		model.setAdditionalInformationMap(
			additionalInformationMap, defaultLocale);
	}

	/**
	 * Sets the address complement of this place.
	 *
	 * @param addressComplement the address complement of this place
	 */
	@Override
	public void setAddressComplement(String addressComplement) {
		model.setAddressComplement(addressComplement);
	}

	/**
	 * Sets the address country of this place.
	 *
	 * @param addressCountry the address country of this place
	 */
	@Override
	public void setAddressCountry(String addressCountry) {
		model.setAddressCountry(addressCountry);
	}

	/**
	 * Sets the address distribution of this place.
	 *
	 * @param addressDistribution the address distribution of this place
	 */
	@Override
	public void setAddressDistribution(String addressDistribution) {
		model.setAddressDistribution(addressDistribution);
	}

	/**
	 * Sets the address street of this place.
	 *
	 * @param addressStreet the address street of this place
	 */
	@Override
	public void setAddressStreet(String addressStreet) {
		model.setAddressStreet(addressStreet);
	}

	/**
	 * Sets the address zip code of this place.
	 *
	 * @param addressZipCode the address zip code of this place
	 */
	@Override
	public void setAddressZipCode(String addressZipCode) {
		model.setAddressZipCode(addressZipCode);
	}

	/**
	 * Sets the alias of this place.
	 *
	 * @param alias the alias of this place
	 */
	@Override
	public void setAlias(String alias) {
		model.setAlias(alias);
	}

	/**
	 * Sets the localized alias of this place in the language.
	 *
	 * @param alias the localized alias of this place
	 * @param locale the locale of the language
	 */
	@Override
	public void setAlias(String alias, java.util.Locale locale) {
		model.setAlias(alias, locale);
	}

	/**
	 * Sets the localized alias of this place in the language, and sets the default locale.
	 *
	 * @param alias the localized alias of this place
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setAlias(
		String alias, java.util.Locale locale, java.util.Locale defaultLocale) {

		model.setAlias(alias, locale, defaultLocale);
	}

	@Override
	public void setAliasCurrentLanguageId(String languageId) {
		model.setAliasCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized aliases of this place from the map of locales and localized aliases.
	 *
	 * @param aliasMap the locales and localized aliases of this place
	 */
	@Override
	public void setAliasMap(Map<java.util.Locale, String> aliasMap) {
		model.setAliasMap(aliasMap);
	}

	/**
	 * Sets the localized aliases of this place from the map of locales and localized aliases, and sets the default locale.
	 *
	 * @param aliasMap the locales and localized aliases of this place
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setAliasMap(
		Map<java.util.Locale, String> aliasMap,
		java.util.Locale defaultLocale) {

		model.setAliasMap(aliasMap, defaultLocale);
	}

	/**
	 * Sets the booking url of this place.
	 *
	 * @param bookingURL the booking url of this place
	 */
	@Override
	public void setBookingURL(String bookingURL) {
		model.setBookingURL(bookingURL);
	}

	/**
	 * Sets the localized booking url of this place in the language.
	 *
	 * @param bookingURL the localized booking url of this place
	 * @param locale the locale of the language
	 */
	@Override
	public void setBookingURL(String bookingURL, java.util.Locale locale) {
		model.setBookingURL(bookingURL, locale);
	}

	/**
	 * Sets the localized booking url of this place in the language, and sets the default locale.
	 *
	 * @param bookingURL the localized booking url of this place
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setBookingURL(
		String bookingURL, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setBookingURL(bookingURL, locale, defaultLocale);
	}

	@Override
	public void setBookingURLCurrentLanguageId(String languageId) {
		model.setBookingURLCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized booking urls of this place from the map of locales and localized booking urls.
	 *
	 * @param bookingURLMap the locales and localized booking urls of this place
	 */
	@Override
	public void setBookingURLMap(Map<java.util.Locale, String> bookingURLMap) {
		model.setBookingURLMap(bookingURLMap);
	}

	/**
	 * Sets the localized booking urls of this place from the map of locales and localized booking urls, and sets the default locale.
	 *
	 * @param bookingURLMap the locales and localized booking urls of this place
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setBookingURLMap(
		Map<java.util.Locale, String> bookingURLMap,
		java.util.Locale defaultLocale) {

		model.setBookingURLMap(bookingURLMap, defaultLocale);
	}

	/**
	 * Sets the characteristics of this place.
	 *
	 * @param characteristics the characteristics of this place
	 */
	@Override
	public void setCharacteristics(String characteristics) {
		model.setCharacteristics(characteristics);
	}

	/**
	 * Sets the localized characteristics of this place in the language.
	 *
	 * @param characteristics the localized characteristics of this place
	 * @param locale the locale of the language
	 */
	@Override
	public void setCharacteristics(
		String characteristics, java.util.Locale locale) {

		model.setCharacteristics(characteristics, locale);
	}

	/**
	 * Sets the localized characteristics of this place in the language, and sets the default locale.
	 *
	 * @param characteristics the localized characteristics of this place
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setCharacteristics(
		String characteristics, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setCharacteristics(characteristics, locale, defaultLocale);
	}

	@Override
	public void setCharacteristicsCurrentLanguageId(String languageId) {
		model.setCharacteristicsCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized characteristicses of this place from the map of locales and localized characteristicses.
	 *
	 * @param characteristicsMap the locales and localized characteristicses of this place
	 */
	@Override
	public void setCharacteristicsMap(
		Map<java.util.Locale, String> characteristicsMap) {

		model.setCharacteristicsMap(characteristicsMap);
	}

	/**
	 * Sets the localized characteristicses of this place from the map of locales and localized characteristicses, and sets the default locale.
	 *
	 * @param characteristicsMap the locales and localized characteristicses of this place
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setCharacteristicsMap(
		Map<java.util.Locale, String> characteristicsMap,
		java.util.Locale defaultLocale) {

		model.setCharacteristicsMap(characteristicsMap, defaultLocale);
	}

	/**
	 * Sets the company ID of this place.
	 *
	 * @param companyId the company ID of this place
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the contenu tooltip carto of this place.
	 *
	 * @param contenuTooltipCarto the contenu tooltip carto of this place
	 */
	@Override
	public void setContenuTooltipCarto(String contenuTooltipCarto) {
		model.setContenuTooltipCarto(contenuTooltipCarto);
	}

	/**
	 * Sets the localized contenu tooltip carto of this place in the language.
	 *
	 * @param contenuTooltipCarto the localized contenu tooltip carto of this place
	 * @param locale the locale of the language
	 */
	@Override
	public void setContenuTooltipCarto(
		String contenuTooltipCarto, java.util.Locale locale) {

		model.setContenuTooltipCarto(contenuTooltipCarto, locale);
	}

	/**
	 * Sets the localized contenu tooltip carto of this place in the language, and sets the default locale.
	 *
	 * @param contenuTooltipCarto the localized contenu tooltip carto of this place
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setContenuTooltipCarto(
		String contenuTooltipCarto, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setContenuTooltipCarto(
			contenuTooltipCarto, locale, defaultLocale);
	}

	@Override
	public void setContenuTooltipCartoCurrentLanguageId(String languageId) {
		model.setContenuTooltipCartoCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized contenu tooltip cartos of this place from the map of locales and localized contenu tooltip cartos.
	 *
	 * @param contenuTooltipCartoMap the locales and localized contenu tooltip cartos of this place
	 */
	@Override
	public void setContenuTooltipCartoMap(
		Map<java.util.Locale, String> contenuTooltipCartoMap) {

		model.setContenuTooltipCartoMap(contenuTooltipCartoMap);
	}

	/**
	 * Sets the localized contenu tooltip cartos of this place from the map of locales and localized contenu tooltip cartos, and sets the default locale.
	 *
	 * @param contenuTooltipCartoMap the locales and localized contenu tooltip cartos of this place
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setContenuTooltipCartoMap(
		Map<java.util.Locale, String> contenuTooltipCartoMap,
		java.util.Locale defaultLocale) {

		model.setContenuTooltipCartoMap(contenuTooltipCartoMap, defaultLocale);
	}

	/**
	 * Sets the create date of this place.
	 *
	 * @param createDate the create date of this place
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets whether this place is display events.
	 *
	 * @param displayEvents the display events of this place
	 */
	@Override
	public void setDisplayEvents(boolean displayEvents) {
		model.setDisplayEvents(displayEvents);
	}

	/**
	 * Sets the documents IDs of this place.
	 *
	 * @param documentsIds the documents IDs of this place
	 */
	@Override
	public void setDocumentsIds(String documentsIds) {
		model.setDocumentsIds(documentsIds);
	}

	/**
	 * Sets the exceptional schedule of this place.
	 *
	 * @param exceptionalSchedule the exceptional schedule of this place
	 */
	@Override
	public void setExceptionalSchedule(String exceptionalSchedule) {
		model.setExceptionalSchedule(exceptionalSchedule);
	}

	/**
	 * Sets the localized exceptional schedule of this place in the language.
	 *
	 * @param exceptionalSchedule the localized exceptional schedule of this place
	 * @param locale the locale of the language
	 */
	@Override
	public void setExceptionalSchedule(
		String exceptionalSchedule, java.util.Locale locale) {

		model.setExceptionalSchedule(exceptionalSchedule, locale);
	}

	/**
	 * Sets the localized exceptional schedule of this place in the language, and sets the default locale.
	 *
	 * @param exceptionalSchedule the localized exceptional schedule of this place
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setExceptionalSchedule(
		String exceptionalSchedule, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setExceptionalSchedule(
			exceptionalSchedule, locale, defaultLocale);
	}

	@Override
	public void setExceptionalScheduleCurrentLanguageId(String languageId) {
		model.setExceptionalScheduleCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized exceptional schedules of this place from the map of locales and localized exceptional schedules.
	 *
	 * @param exceptionalScheduleMap the locales and localized exceptional schedules of this place
	 */
	@Override
	public void setExceptionalScheduleMap(
		Map<java.util.Locale, String> exceptionalScheduleMap) {

		model.setExceptionalScheduleMap(exceptionalScheduleMap);
	}

	/**
	 * Sets the localized exceptional schedules of this place from the map of locales and localized exceptional schedules, and sets the default locale.
	 *
	 * @param exceptionalScheduleMap the locales and localized exceptional schedules of this place
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setExceptionalScheduleMap(
		Map<java.util.Locale, String> exceptionalScheduleMap,
		java.util.Locale defaultLocale) {

		model.setExceptionalScheduleMap(exceptionalScheduleMap, defaultLocale);
	}

	/**
	 * Sets the facebook label of this place.
	 *
	 * @param facebookLabel the facebook label of this place
	 */
	@Override
	public void setFacebookLabel(String facebookLabel) {
		model.setFacebookLabel(facebookLabel);
	}

	/**
	 * Sets the localized facebook label of this place in the language.
	 *
	 * @param facebookLabel the localized facebook label of this place
	 * @param locale the locale of the language
	 */
	@Override
	public void setFacebookLabel(
		String facebookLabel, java.util.Locale locale) {

		model.setFacebookLabel(facebookLabel, locale);
	}

	/**
	 * Sets the localized facebook label of this place in the language, and sets the default locale.
	 *
	 * @param facebookLabel the localized facebook label of this place
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setFacebookLabel(
		String facebookLabel, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setFacebookLabel(facebookLabel, locale, defaultLocale);
	}

	@Override
	public void setFacebookLabelCurrentLanguageId(String languageId) {
		model.setFacebookLabelCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized facebook labels of this place from the map of locales and localized facebook labels.
	 *
	 * @param facebookLabelMap the locales and localized facebook labels of this place
	 */
	@Override
	public void setFacebookLabelMap(
		Map<java.util.Locale, String> facebookLabelMap) {

		model.setFacebookLabelMap(facebookLabelMap);
	}

	/**
	 * Sets the localized facebook labels of this place from the map of locales and localized facebook labels, and sets the default locale.
	 *
	 * @param facebookLabelMap the locales and localized facebook labels of this place
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setFacebookLabelMap(
		Map<java.util.Locale, String> facebookLabelMap,
		java.util.Locale defaultLocale) {

		model.setFacebookLabelMap(facebookLabelMap, defaultLocale);
	}

	/**
	 * Sets the facebook url of this place.
	 *
	 * @param facebookURL the facebook url of this place
	 */
	@Override
	public void setFacebookURL(String facebookURL) {
		model.setFacebookURL(facebookURL);
	}

	/**
	 * Sets the localized facebook url of this place in the language.
	 *
	 * @param facebookURL the localized facebook url of this place
	 * @param locale the locale of the language
	 */
	@Override
	public void setFacebookURL(String facebookURL, java.util.Locale locale) {
		model.setFacebookURL(facebookURL, locale);
	}

	/**
	 * Sets the localized facebook url of this place in the language, and sets the default locale.
	 *
	 * @param facebookURL the localized facebook url of this place
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setFacebookURL(
		String facebookURL, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setFacebookURL(facebookURL, locale, defaultLocale);
	}

	@Override
	public void setFacebookURLCurrentLanguageId(String languageId) {
		model.setFacebookURLCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized facebook urls of this place from the map of locales and localized facebook urls.
	 *
	 * @param facebookURLMap the locales and localized facebook urls of this place
	 */
	@Override
	public void setFacebookURLMap(
		Map<java.util.Locale, String> facebookURLMap) {

		model.setFacebookURLMap(facebookURLMap);
	}

	/**
	 * Sets the localized facebook urls of this place from the map of locales and localized facebook urls, and sets the default locale.
	 *
	 * @param facebookURLMap the locales and localized facebook urls of this place
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setFacebookURLMap(
		Map<java.util.Locale, String> facebookURLMap,
		java.util.Locale defaultLocale) {

		model.setFacebookURLMap(facebookURLMap, defaultLocale);
	}

	/**
	 * Sets the group ID of this place.
	 *
	 * @param groupId the group ID of this place
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets whether this place is has url schedule.
	 *
	 * @param hasURLSchedule the has url schedule of this place
	 */
	@Override
	public void setHasURLSchedule(boolean hasURLSchedule) {
		model.setHasURLSchedule(hasURLSchedule);
	}

	/**
	 * Sets the image height of this place.
	 *
	 * @param imageHeight the image height of this place
	 */
	@Override
	public void setImageHeight(Integer imageHeight) {
		model.setImageHeight(imageHeight);
	}

	/**
	 * Sets the image ID of this place.
	 *
	 * @param imageId the image ID of this place
	 */
	@Override
	public void setImageId(long imageId) {
		model.setImageId(imageId);
	}

	/**
	 * Sets the image IDs of this place.
	 *
	 * @param imageIds the image IDs of this place
	 */
	@Override
	public void setImageIds(String imageIds) {
		model.setImageIds(imageIds);
	}

	/**
	 * Sets the image width of this place.
	 *
	 * @param imageWidth the image width of this place
	 */
	@Override
	public void setImageWidth(Integer imageWidth) {
		model.setImageWidth(imageWidth);
	}

	/**
	 * Sets the instagram label of this place.
	 *
	 * @param instagramLabel the instagram label of this place
	 */
	@Override
	public void setInstagramLabel(String instagramLabel) {
		model.setInstagramLabel(instagramLabel);
	}

	/**
	 * Sets the localized instagram label of this place in the language.
	 *
	 * @param instagramLabel the localized instagram label of this place
	 * @param locale the locale of the language
	 */
	@Override
	public void setInstagramLabel(
		String instagramLabel, java.util.Locale locale) {

		model.setInstagramLabel(instagramLabel, locale);
	}

	/**
	 * Sets the localized instagram label of this place in the language, and sets the default locale.
	 *
	 * @param instagramLabel the localized instagram label of this place
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setInstagramLabel(
		String instagramLabel, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setInstagramLabel(instagramLabel, locale, defaultLocale);
	}

	@Override
	public void setInstagramLabelCurrentLanguageId(String languageId) {
		model.setInstagramLabelCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized instagram labels of this place from the map of locales and localized instagram labels.
	 *
	 * @param instagramLabelMap the locales and localized instagram labels of this place
	 */
	@Override
	public void setInstagramLabelMap(
		Map<java.util.Locale, String> instagramLabelMap) {

		model.setInstagramLabelMap(instagramLabelMap);
	}

	/**
	 * Sets the localized instagram labels of this place from the map of locales and localized instagram labels, and sets the default locale.
	 *
	 * @param instagramLabelMap the locales and localized instagram labels of this place
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setInstagramLabelMap(
		Map<java.util.Locale, String> instagramLabelMap,
		java.util.Locale defaultLocale) {

		model.setInstagramLabelMap(instagramLabelMap, defaultLocale);
	}

	/**
	 * Sets the instagram url of this place.
	 *
	 * @param instagramURL the instagram url of this place
	 */
	@Override
	public void setInstagramURL(String instagramURL) {
		model.setInstagramURL(instagramURL);
	}

	/**
	 * Sets the localized instagram url of this place in the language.
	 *
	 * @param instagramURL the localized instagram url of this place
	 * @param locale the locale of the language
	 */
	@Override
	public void setInstagramURL(String instagramURL, java.util.Locale locale) {
		model.setInstagramURL(instagramURL, locale);
	}

	/**
	 * Sets the localized instagram url of this place in the language, and sets the default locale.
	 *
	 * @param instagramURL the localized instagram url of this place
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setInstagramURL(
		String instagramURL, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setInstagramURL(instagramURL, locale, defaultLocale);
	}

	@Override
	public void setInstagramURLCurrentLanguageId(String languageId) {
		model.setInstagramURLCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized instagram urls of this place from the map of locales and localized instagram urls.
	 *
	 * @param instagramURLMap the locales and localized instagram urls of this place
	 */
	@Override
	public void setInstagramURLMap(
		Map<java.util.Locale, String> instagramURLMap) {

		model.setInstagramURLMap(instagramURLMap);
	}

	/**
	 * Sets the localized instagram urls of this place from the map of locales and localized instagram urls, and sets the default locale.
	 *
	 * @param instagramURLMap the locales and localized instagram urls of this place
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setInstagramURLMap(
		Map<java.util.Locale, String> instagramURLMap,
		java.util.Locale defaultLocale) {

		model.setInstagramURLMap(instagramURLMap, defaultLocale);
	}

	/**
	 * Sets the last publish date of this place.
	 *
	 * @param lastPublishDate the last publish date of this place
	 */
	@Override
	public void setLastPublishDate(Date lastPublishDate) {
		model.setLastPublishDate(lastPublishDate);
	}

	/**
	 * Sets the location ID of this place.
	 *
	 * @param locationId the location ID of this place
	 */
	@Override
	public void setLocationId(String locationId) {
		model.setLocationId(locationId);
	}

	/**
	 * Sets the mail of this place.
	 *
	 * @param mail the mail of this place
	 */
	@Override
	public void setMail(String mail) {
		model.setMail(mail);
	}

	/**
	 * Sets the mercator x of this place.
	 *
	 * @param mercatorX the mercator x of this place
	 */
	@Override
	public void setMercatorX(String mercatorX) {
		model.setMercatorX(mercatorX);
	}

	/**
	 * Sets the mercator y of this place.
	 *
	 * @param mercatorY the mercator y of this place
	 */
	@Override
	public void setMercatorY(String mercatorY) {
		model.setMercatorY(mercatorY);
	}

	/**
	 * Sets the modified date of this place.
	 *
	 * @param modifiedDate the modified date of this place
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this place.
	 *
	 * @param name the name of this place
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the phone of this place.
	 *
	 * @param phone the phone of this place
	 */
	@Override
	public void setPhone(String phone) {
		model.setPhone(phone);
	}

	/**
	 * Sets the place ID of this place.
	 *
	 * @param placeId the place ID of this place
	 */
	@Override
	public void setPlaceId(long placeId) {
		model.setPlaceId(placeId);
	}

	/**
	 * Sets the presentation of this place.
	 *
	 * @param presentation the presentation of this place
	 */
	@Override
	public void setPresentation(String presentation) {
		model.setPresentation(presentation);
	}

	/**
	 * Sets the localized presentation of this place in the language.
	 *
	 * @param presentation the localized presentation of this place
	 * @param locale the locale of the language
	 */
	@Override
	public void setPresentation(String presentation, java.util.Locale locale) {
		model.setPresentation(presentation, locale);
	}

	/**
	 * Sets the localized presentation of this place in the language, and sets the default locale.
	 *
	 * @param presentation the localized presentation of this place
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
	 * Sets the localized presentations of this place from the map of locales and localized presentations.
	 *
	 * @param presentationMap the locales and localized presentations of this place
	 */
	@Override
	public void setPresentationMap(
		Map<java.util.Locale, String> presentationMap) {

		model.setPresentationMap(presentationMap);
	}

	/**
	 * Sets the localized presentations of this place from the map of locales and localized presentations, and sets the default locale.
	 *
	 * @param presentationMap the locales and localized presentations of this place
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setPresentationMap(
		Map<java.util.Locale, String> presentationMap,
		java.util.Locale defaultLocale) {

		model.setPresentationMap(presentationMap, defaultLocale);
	}

	/**
	 * Sets the price ID of this place.
	 *
	 * @param priceId the price ID of this place
	 */
	@Override
	public void setPriceId(long priceId) {
		model.setPriceId(priceId);
	}

	/**
	 * Sets the primary key of this place.
	 *
	 * @param primaryKey the primary key of this place
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the rgf93x of this place.
	 *
	 * @param RGF93X the rgf93x of this place
	 */
	@Override
	public void setRGF93X(String RGF93X) {
		model.setRGF93X(RGF93X);
	}

	/**
	 * Sets the rgf93y of this place.
	 *
	 * @param RGF93Y the rgf93y of this place
	 */
	@Override
	public void setRGF93Y(String RGF93Y) {
		model.setRGF93Y(RGF93Y);
	}

	/**
	 * Sets the rt available of this place.
	 *
	 * @param RTAvailable the rt available of this place
	 */
	@Override
	public void setRTAvailable(long RTAvailable) {
		model.setRTAvailable(RTAvailable);
	}

	/**
	 * Sets the rt capacity of this place.
	 *
	 * @param RTCapacity the rt capacity of this place
	 */
	@Override
	public void setRTCapacity(long RTCapacity) {
		model.setRTCapacity(RTCapacity);
	}

	/**
	 * Sets the rt enabled of this place.
	 *
	 * @param RTEnabled the rt enabled of this place
	 */
	@Override
	public void setRTEnabled(Boolean RTEnabled) {
		model.setRTEnabled(RTEnabled);
	}

	/**
	 * Sets the rt external ID of this place.
	 *
	 * @param RTExternalId the rt external ID of this place
	 */
	@Override
	public void setRTExternalId(String RTExternalId) {
		model.setRTExternalId(RTExternalId);
	}

	/**
	 * Sets the rt last update of this place.
	 *
	 * @param RTLastUpdate the rt last update of this place
	 */
	@Override
	public void setRTLastUpdate(Date RTLastUpdate) {
		model.setRTLastUpdate(RTLastUpdate);
	}

	/**
	 * Sets the rt occupation of this place.
	 *
	 * @param RTOccupation the rt occupation of this place
	 */
	@Override
	public void setRTOccupation(long RTOccupation) {
		model.setRTOccupation(RTOccupation);
	}

	/**
	 * Sets the rt status of this place.
	 *
	 * @param RTStatus the rt status of this place
	 */
	@Override
	public void setRTStatus(String RTStatus) {
		model.setRTStatus(RTStatus);
	}

	/**
	 * Sets the rt type of this place.
	 *
	 * @param RTType the rt type of this place
	 */
	@Override
	public void setRTType(String RTType) {
		model.setRTType(RTType);
	}

	/**
	 * Sets the schedule link name of this place.
	 *
	 * @param scheduleLinkName the schedule link name of this place
	 */
	@Override
	public void setScheduleLinkName(String scheduleLinkName) {
		model.setScheduleLinkName(scheduleLinkName);
	}

	/**
	 * Sets the localized schedule link name of this place in the language.
	 *
	 * @param scheduleLinkName the localized schedule link name of this place
	 * @param locale the locale of the language
	 */
	@Override
	public void setScheduleLinkName(
		String scheduleLinkName, java.util.Locale locale) {

		model.setScheduleLinkName(scheduleLinkName, locale);
	}

	/**
	 * Sets the localized schedule link name of this place in the language, and sets the default locale.
	 *
	 * @param scheduleLinkName the localized schedule link name of this place
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setScheduleLinkName(
		String scheduleLinkName, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setScheduleLinkName(scheduleLinkName, locale, defaultLocale);
	}

	@Override
	public void setScheduleLinkNameCurrentLanguageId(String languageId) {
		model.setScheduleLinkNameCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized schedule link names of this place from the map of locales and localized schedule link names.
	 *
	 * @param scheduleLinkNameMap the locales and localized schedule link names of this place
	 */
	@Override
	public void setScheduleLinkNameMap(
		Map<java.util.Locale, String> scheduleLinkNameMap) {

		model.setScheduleLinkNameMap(scheduleLinkNameMap);
	}

	/**
	 * Sets the localized schedule link names of this place from the map of locales and localized schedule link names, and sets the default locale.
	 *
	 * @param scheduleLinkNameMap the locales and localized schedule link names of this place
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setScheduleLinkNameMap(
		Map<java.util.Locale, String> scheduleLinkNameMap,
		java.util.Locale defaultLocale) {

		model.setScheduleLinkNameMap(scheduleLinkNameMap, defaultLocale);
	}

	/**
	 * Sets the schedule link url of this place.
	 *
	 * @param scheduleLinkURL the schedule link url of this place
	 */
	@Override
	public void setScheduleLinkURL(String scheduleLinkURL) {
		model.setScheduleLinkURL(scheduleLinkURL);
	}

	/**
	 * Sets the localized schedule link url of this place in the language.
	 *
	 * @param scheduleLinkURL the localized schedule link url of this place
	 * @param locale the locale of the language
	 */
	@Override
	public void setScheduleLinkURL(
		String scheduleLinkURL, java.util.Locale locale) {

		model.setScheduleLinkURL(scheduleLinkURL, locale);
	}

	/**
	 * Sets the localized schedule link url of this place in the language, and sets the default locale.
	 *
	 * @param scheduleLinkURL the localized schedule link url of this place
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setScheduleLinkURL(
		String scheduleLinkURL, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setScheduleLinkURL(scheduleLinkURL, locale, defaultLocale);
	}

	@Override
	public void setScheduleLinkURLCurrentLanguageId(String languageId) {
		model.setScheduleLinkURLCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized schedule link urls of this place from the map of locales and localized schedule link urls.
	 *
	 * @param scheduleLinkURLMap the locales and localized schedule link urls of this place
	 */
	@Override
	public void setScheduleLinkURLMap(
		Map<java.util.Locale, String> scheduleLinkURLMap) {

		model.setScheduleLinkURLMap(scheduleLinkURLMap);
	}

	/**
	 * Sets the localized schedule link urls of this place from the map of locales and localized schedule link urls, and sets the default locale.
	 *
	 * @param scheduleLinkURLMap the locales and localized schedule link urls of this place
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setScheduleLinkURLMap(
		Map<java.util.Locale, String> scheduleLinkURLMap,
		java.util.Locale defaultLocale) {

		model.setScheduleLinkURLMap(scheduleLinkURLMap, defaultLocale);
	}

	/**
	 * Sets the service and activities of this place.
	 *
	 * @param serviceAndActivities the service and activities of this place
	 */
	@Override
	public void setServiceAndActivities(String serviceAndActivities) {
		model.setServiceAndActivities(serviceAndActivities);
	}

	/**
	 * Sets the localized service and activities of this place in the language.
	 *
	 * @param serviceAndActivities the localized service and activities of this place
	 * @param locale the locale of the language
	 */
	@Override
	public void setServiceAndActivities(
		String serviceAndActivities, java.util.Locale locale) {

		model.setServiceAndActivities(serviceAndActivities, locale);
	}

	/**
	 * Sets the localized service and activities of this place in the language, and sets the default locale.
	 *
	 * @param serviceAndActivities the localized service and activities of this place
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setServiceAndActivities(
		String serviceAndActivities, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setServiceAndActivities(
			serviceAndActivities, locale, defaultLocale);
	}

	@Override
	public void setServiceAndActivitiesCurrentLanguageId(String languageId) {
		model.setServiceAndActivitiesCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized service and activitieses of this place from the map of locales and localized service and activitieses.
	 *
	 * @param serviceAndActivitiesMap the locales and localized service and activitieses of this place
	 */
	@Override
	public void setServiceAndActivitiesMap(
		Map<java.util.Locale, String> serviceAndActivitiesMap) {

		model.setServiceAndActivitiesMap(serviceAndActivitiesMap);
	}

	/**
	 * Sets the localized service and activitieses of this place from the map of locales and localized service and activitieses, and sets the default locale.
	 *
	 * @param serviceAndActivitiesMap the locales and localized service and activitieses of this place
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setServiceAndActivitiesMap(
		Map<java.util.Locale, String> serviceAndActivitiesMap,
		java.util.Locale defaultLocale) {

		model.setServiceAndActivitiesMap(
			serviceAndActivitiesMap, defaultLocale);
	}

	/**
	 * Sets the si gid of this place.
	 *
	 * @param SIGid the si gid of this place
	 */
	@Override
	public void setSIGid(String SIGid) {
		model.setSIGid(SIGid);
	}

	/**
	 * Sets the site label of this place.
	 *
	 * @param siteLabel the site label of this place
	 */
	@Override
	public void setSiteLabel(String siteLabel) {
		model.setSiteLabel(siteLabel);
	}

	/**
	 * Sets the localized site label of this place in the language.
	 *
	 * @param siteLabel the localized site label of this place
	 * @param locale the locale of the language
	 */
	@Override
	public void setSiteLabel(String siteLabel, java.util.Locale locale) {
		model.setSiteLabel(siteLabel, locale);
	}

	/**
	 * Sets the localized site label of this place in the language, and sets the default locale.
	 *
	 * @param siteLabel the localized site label of this place
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setSiteLabel(
		String siteLabel, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setSiteLabel(siteLabel, locale, defaultLocale);
	}

	@Override
	public void setSiteLabelCurrentLanguageId(String languageId) {
		model.setSiteLabelCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized site labels of this place from the map of locales and localized site labels.
	 *
	 * @param siteLabelMap the locales and localized site labels of this place
	 */
	@Override
	public void setSiteLabelMap(Map<java.util.Locale, String> siteLabelMap) {
		model.setSiteLabelMap(siteLabelMap);
	}

	/**
	 * Sets the localized site labels of this place from the map of locales and localized site labels, and sets the default locale.
	 *
	 * @param siteLabelMap the locales and localized site labels of this place
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setSiteLabelMap(
		Map<java.util.Locale, String> siteLabelMap,
		java.util.Locale defaultLocale) {

		model.setSiteLabelMap(siteLabelMap, defaultLocale);
	}

	/**
	 * Sets the site url of this place.
	 *
	 * @param siteURL the site url of this place
	 */
	@Override
	public void setSiteURL(String siteURL) {
		model.setSiteURL(siteURL);
	}

	/**
	 * Sets the localized site url of this place in the language.
	 *
	 * @param siteURL the localized site url of this place
	 * @param locale the locale of the language
	 */
	@Override
	public void setSiteURL(String siteURL, java.util.Locale locale) {
		model.setSiteURL(siteURL, locale);
	}

	/**
	 * Sets the localized site url of this place in the language, and sets the default locale.
	 *
	 * @param siteURL the localized site url of this place
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setSiteURL(
		String siteURL, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setSiteURL(siteURL, locale, defaultLocale);
	}

	@Override
	public void setSiteURLCurrentLanguageId(String languageId) {
		model.setSiteURLCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized site urls of this place from the map of locales and localized site urls.
	 *
	 * @param siteURLMap the locales and localized site urls of this place
	 */
	@Override
	public void setSiteURLMap(Map<java.util.Locale, String> siteURLMap) {
		model.setSiteURLMap(siteURLMap);
	}

	/**
	 * Sets the localized site urls of this place from the map of locales and localized site urls, and sets the default locale.
	 *
	 * @param siteURLMap the locales and localized site urls of this place
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setSiteURLMap(
		Map<java.util.Locale, String> siteURLMap,
		java.util.Locale defaultLocale) {

		model.setSiteURLMap(siteURLMap, defaultLocale);
	}

	/**
	 * Sets the status of this place.
	 *
	 * @param status the status of this place
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this place.
	 *
	 * @param statusByUserId the status by user ID of this place
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this place.
	 *
	 * @param statusByUserName the status by user name of this place
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this place.
	 *
	 * @param statusByUserUuid the status by user uuid of this place
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this place.
	 *
	 * @param statusDate the status date of this place
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets whether this place is subject to public holiday.
	 *
	 * @param subjectToPublicHoliday the subject to public holiday of this place
	 */
	@Override
	public void setSubjectToPublicHoliday(boolean subjectToPublicHoliday) {
		model.setSubjectToPublicHoliday(subjectToPublicHoliday);
	}

	/**
	 * Sets the user ID of this place.
	 *
	 * @param userId the user ID of this place
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this place.
	 *
	 * @param userName the user name of this place
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this place.
	 *
	 * @param userUuid the user uuid of this place
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this place.
	 *
	 * @param uuid the uuid of this place
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the videos IDs of this place.
	 *
	 * @param videosIds the videos IDs of this place
	 */
	@Override
	public void setVideosIds(String videosIds) {
		model.setVideosIds(videosIds);
	}

	/**
	 * Retourne la version GeoJSON du lieu
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONObject toGeoJSON() {
		return model.toGeoJSON();
	}

	/**
	 * Retourne la version JSON du lieu
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
	protected PlaceWrapper wrap(Place place) {
		return new PlaceWrapper(place);
	}

}