/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CampaignEvent}.
 * </p>
 *
 * @author BenjaminBini
 * @see CampaignEvent
 * @generated
 */
public class CampaignEventWrapper
	extends BaseModelWrapper<CampaignEvent>
	implements CampaignEvent, ModelWrapper<CampaignEvent> {

	public CampaignEventWrapper(CampaignEvent campaignEvent) {
		super(campaignEvent);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("campaignEventId", getCampaignEventId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("lastPublishDate", getLastPublishDate());
		attributes.put("status", getStatus());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("phone", getPhone());
		attributes.put("email", getEmail());
		attributes.put("serviceId", getServiceId());
		attributes.put("service", getService());
		attributes.put("onSiteFirstName", getOnSiteFirstName());
		attributes.put("onSiteLastName", getOnSiteLastName());
		attributes.put("onSitePhone", getOnSitePhone());
		attributes.put("title", getTitle());
		attributes.put("subtitle", getSubtitle());
		attributes.put("description", getDescription());
		attributes.put("imageId", getImageId());
		attributes.put("webImageId", getWebImageId());
		attributes.put("imageOwner", getImageOwner());
		attributes.put("manifestationsIds", getManifestationsIds());
		attributes.put("placeSIGId", getPlaceSIGId());
		attributes.put("placeName", getPlaceName());
		attributes.put("placeStreetNumber", getPlaceStreetNumber());
		attributes.put("placeStreetName", getPlaceStreetName());
		attributes.put("placeZipCode", getPlaceZipCode());
		attributes.put("placeCityId", getPlaceCityId());
		attributes.put("placeCountry", getPlaceCountry());
		attributes.put("promoter", getPromoter());
		attributes.put("publicPhone", getPublicPhone());
		attributes.put("publicEmail", getPublicEmail());
		attributes.put("websiteURL", getWebsiteURL());
		attributes.put("websiteName", getWebsiteName());
		attributes.put("free", getFree());
		attributes.put("price", getPrice());
		attributes.put("campaignId", getCampaignId());
		attributes.put("themesIds", getThemesIds());
		attributes.put("typesIds", getTypesIds());
		attributes.put("publicsIds", getPublicsIds());
		attributes.put("tagsNames", getTagsNames());
		attributes.put("bookingDescription", getBookingDescription());
		attributes.put("bookingURL", getBookingURL());
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

		Long campaignEventId = (Long)attributes.get("campaignEventId");

		if (campaignEventId != null) {
			setCampaignEventId(campaignEventId);
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

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String phone = (String)attributes.get("phone");

		if (phone != null) {
			setPhone(phone);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		Long serviceId = (Long)attributes.get("serviceId");

		if (serviceId != null) {
			setServiceId(serviceId);
		}

		String service = (String)attributes.get("service");

		if (service != null) {
			setService(service);
		}

		String onSiteFirstName = (String)attributes.get("onSiteFirstName");

		if (onSiteFirstName != null) {
			setOnSiteFirstName(onSiteFirstName);
		}

		String onSiteLastName = (String)attributes.get("onSiteLastName");

		if (onSiteLastName != null) {
			setOnSiteLastName(onSiteLastName);
		}

		String onSitePhone = (String)attributes.get("onSitePhone");

		if (onSitePhone != null) {
			setOnSitePhone(onSitePhone);
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

		Long imageId = (Long)attributes.get("imageId");

		if (imageId != null) {
			setImageId(imageId);
		}

		Long webImageId = (Long)attributes.get("webImageId");

		if (webImageId != null) {
			setWebImageId(webImageId);
		}

		String imageOwner = (String)attributes.get("imageOwner");

		if (imageOwner != null) {
			setImageOwner(imageOwner);
		}

		String manifestationsIds = (String)attributes.get("manifestationsIds");

		if (manifestationsIds != null) {
			setManifestationsIds(manifestationsIds);
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

		String placeCountry = (String)attributes.get("placeCountry");

		if (placeCountry != null) {
			setPlaceCountry(placeCountry);
		}

		String promoter = (String)attributes.get("promoter");

		if (promoter != null) {
			setPromoter(promoter);
		}

		String publicPhone = (String)attributes.get("publicPhone");

		if (publicPhone != null) {
			setPublicPhone(publicPhone);
		}

		String publicEmail = (String)attributes.get("publicEmail");

		if (publicEmail != null) {
			setPublicEmail(publicEmail);
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

		Long campaignId = (Long)attributes.get("campaignId");

		if (campaignId != null) {
			setCampaignId(campaignId);
		}

		String themesIds = (String)attributes.get("themesIds");

		if (themesIds != null) {
			setThemesIds(themesIds);
		}

		String typesIds = (String)attributes.get("typesIds");

		if (typesIds != null) {
			setTypesIds(typesIds);
		}

		String publicsIds = (String)attributes.get("publicsIds");

		if (publicsIds != null) {
			setPublicsIds(publicsIds);
		}

		String tagsNames = (String)attributes.get("tagsNames");

		if (tagsNames != null) {
			setTagsNames(tagsNames);
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
	public CampaignEvent cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the booking description of this campaign event.
	 *
	 * @return the booking description of this campaign event
	 */
	@Override
	public String getBookingDescription() {
		return model.getBookingDescription();
	}

	/**
	 * Returns the localized booking description of this campaign event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized booking description of this campaign event
	 */
	@Override
	public String getBookingDescription(java.util.Locale locale) {
		return model.getBookingDescription(locale);
	}

	/**
	 * Returns the localized booking description of this campaign event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized booking description of this campaign event. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getBookingDescription(
		java.util.Locale locale, boolean useDefault) {

		return model.getBookingDescription(locale, useDefault);
	}

	/**
	 * Returns the localized booking description of this campaign event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized booking description of this campaign event
	 */
	@Override
	public String getBookingDescription(String languageId) {
		return model.getBookingDescription(languageId);
	}

	/**
	 * Returns the localized booking description of this campaign event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized booking description of this campaign event
	 */
	@Override
	public String getBookingDescription(String languageId, boolean useDefault) {
		return model.getBookingDescription(languageId, useDefault);
	}

	@Override
	public String getBookingDescriptionCurrentLanguageId() {
		return model.getBookingDescriptionCurrentLanguageId();
	}

	@Override
	public String getBookingDescriptionCurrentValue() {
		return model.getBookingDescriptionCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized booking descriptions of this campaign event.
	 *
	 * @return the locales and localized booking descriptions of this campaign event
	 */
	@Override
	public Map<java.util.Locale, String> getBookingDescriptionMap() {
		return model.getBookingDescriptionMap();
	}

	/**
	 * Returns the booking url of this campaign event.
	 *
	 * @return the booking url of this campaign event
	 */
	@Override
	public String getBookingURL() {
		return model.getBookingURL();
	}

	@Override
	public eu.strasbourg.service.agenda.model.Campaign getCampaign() {
		return model.getCampaign();
	}

	/**
	 * Returns the campaign event ID of this campaign event.
	 *
	 * @return the campaign event ID of this campaign event
	 */
	@Override
	public long getCampaignEventId() {
		return model.getCampaignEventId();
	}

	/**
	 * Returns the campaign ID of this campaign event.
	 *
	 * @return the campaign ID of this campaign event
	 */
	@Override
	public Long getCampaignId() {
		return model.getCampaignId();
	}

	/**
	 * Retourne le territoire (la ville) de l'événement (si lieu manuel)
	 */
	@Override
	public String getCity() {
		return model.getCity();
	}

	/**
	 * Returns the company ID of this campaign event.
	 *
	 * @return the company ID of this campaign event
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this campaign event.
	 *
	 * @return the create date of this campaign event
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
	 * Returns the description of this campaign event.
	 *
	 * @return the description of this campaign event
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the localized description of this campaign event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description of this campaign event
	 */
	@Override
	public String getDescription(java.util.Locale locale) {
		return model.getDescription(locale);
	}

	/**
	 * Returns the localized description of this campaign event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this campaign event. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getDescription(java.util.Locale locale, boolean useDefault) {
		return model.getDescription(locale, useDefault);
	}

	/**
	 * Returns the localized description of this campaign event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description of this campaign event
	 */
	@Override
	public String getDescription(String languageId) {
		return model.getDescription(languageId);
	}

	/**
	 * Returns the localized description of this campaign event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this campaign event
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
	 * Returns a map of the locales and localized descriptions of this campaign event.
	 *
	 * @return the locales and localized descriptions of this campaign event
	 */
	@Override
	public Map<java.util.Locale, String> getDescriptionMap() {
		return model.getDescriptionMap();
	}

	/**
	 * Returns the email of this campaign event.
	 *
	 * @return the email of this campaign event
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the first name of this campaign event.
	 *
	 * @return the first name of this campaign event
	 */
	@Override
	public String getFirstName() {
		return model.getFirstName();
	}

	/**
	 * Returns the free of this campaign event.
	 *
	 * @return the free of this campaign event
	 */
	@Override
	public Integer getFree() {
		return model.getFree();
	}

	/**
	 * Returns the group ID of this campaign event.
	 *
	 * @return the group ID of this campaign event
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the image ID of this campaign event.
	 *
	 * @return the image ID of this campaign event
	 */
	@Override
	public Long getImageId() {
		return model.getImageId();
	}

	/**
	 * Returns the image owner of this campaign event.
	 *
	 * @return the image owner of this campaign event
	 */
	@Override
	public String getImageOwner() {
		return model.getImageOwner();
	}

	/**
	 * Retourne l'URL de l'image à partir de l'id du DLFileEntry
	 */
	@Override
	public String getImageURL() {
		return model.getImageURL();
	}

	/**
	 * Returns the last name of this campaign event.
	 *
	 * @return the last name of this campaign event
	 */
	@Override
	public String getLastName() {
		return model.getLastName();
	}

	/**
	 * Returns the last publish date of this campaign event.
	 *
	 * @return the last publish date of this campaign event
	 */
	@Override
	public Date getLastPublishDate() {
		return model.getLastPublishDate();
	}

	/**
	 * Renvoie le dernier statut en date de l'événement
	 */
	@Override
	public eu.strasbourg.service.agenda.model.CampaignEventStatus
		getLastStatus() {

		return model.getLastStatus();
	}

	/**
	 * Retourne le label des manifestations de l'événement
	 */
	@Override
	public String getManifestationLabel(java.util.Locale locale) {
		return model.getManifestationLabel(locale);
	}

	/**
	 * Returns the manifestations IDs of this campaign event.
	 *
	 * @return the manifestations IDs of this campaign event
	 */
	@Override
	public String getManifestationsIds() {
		return model.getManifestationsIds();
	}

	/**
	 * Returns the max gauge of this campaign event.
	 *
	 * @return the max gauge of this campaign event
	 */
	@Override
	public long getMaxGauge() {
		return model.getMaxGauge();
	}

	/**
	 * Returns the modified date of this campaign event.
	 *
	 * @return the modified date of this campaign event
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the on site first name of this campaign event.
	 *
	 * @return the on site first name of this campaign event
	 */
	@Override
	public String getOnSiteFirstName() {
		return model.getOnSiteFirstName();
	}

	/**
	 * Returns the on site last name of this campaign event.
	 *
	 * @return the on site last name of this campaign event
	 */
	@Override
	public String getOnSiteLastName() {
		return model.getOnSiteLastName();
	}

	/**
	 * Returns the on site phone of this campaign event.
	 *
	 * @return the on site phone of this campaign event
	 */
	@Override
	public String getOnSitePhone() {
		return model.getOnSitePhone();
	}

	/**
	 * Retourne les périodes
	 */
	@Override
	public java.util.List<eu.strasbourg.service.agenda.model.EventPeriod>
		getPeriods() {

		return model.getPeriods();
	}

	/**
	 * Returns the phone of this campaign event.
	 *
	 * @return the phone of this campaign event
	 */
	@Override
	public String getPhone() {
		return model.getPhone();
	}

	/**
	 * Retourne le nom lieu rattaché à l'événement
	 */
	@Override
	public String getPlaceAlias(java.util.Locale locale) {
		return model.getPlaceAlias(locale);
	}

	/**
	 * Returns the place city ID of this campaign event.
	 *
	 * @return the place city ID of this campaign event
	 */
	@Override
	public Long getPlaceCityId() {
		return model.getPlaceCityId();
	}

	/**
	 * Returns the place country of this campaign event.
	 *
	 * @return the place country of this campaign event
	 */
	@Override
	public String getPlaceCountry() {
		return model.getPlaceCountry();
	}

	/**
	 * Returns the place name of this campaign event.
	 *
	 * @return the place name of this campaign event
	 */
	@Override
	public String getPlaceName() {
		return model.getPlaceName();
	}

	/**
	 * Returns the localized place name of this campaign event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized place name of this campaign event
	 */
	@Override
	public String getPlaceName(java.util.Locale locale) {
		return model.getPlaceName(locale);
	}

	/**
	 * Returns the localized place name of this campaign event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized place name of this campaign event. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getPlaceName(java.util.Locale locale, boolean useDefault) {
		return model.getPlaceName(locale, useDefault);
	}

	/**
	 * Returns the localized place name of this campaign event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized place name of this campaign event
	 */
	@Override
	public String getPlaceName(String languageId) {
		return model.getPlaceName(languageId);
	}

	/**
	 * Returns the localized place name of this campaign event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized place name of this campaign event
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
	 * Returns a map of the locales and localized place names of this campaign event.
	 *
	 * @return the locales and localized place names of this campaign event
	 */
	@Override
	public Map<java.util.Locale, String> getPlaceNameMap() {
		return model.getPlaceNameMap();
	}

	/**
	 * Returns the place sig ID of this campaign event.
	 *
	 * @return the place sig ID of this campaign event
	 */
	@Override
	public String getPlaceSIGId() {
		return model.getPlaceSIGId();
	}

	/**
	 * Returns the place street name of this campaign event.
	 *
	 * @return the place street name of this campaign event
	 */
	@Override
	public String getPlaceStreetName() {
		return model.getPlaceStreetName();
	}

	/**
	 * Returns the place street number of this campaign event.
	 *
	 * @return the place street number of this campaign event
	 */
	@Override
	public String getPlaceStreetNumber() {
		return model.getPlaceStreetNumber();
	}

	/**
	 * Returns the place zip code of this campaign event.
	 *
	 * @return the place zip code of this campaign event
	 */
	@Override
	public String getPlaceZipCode() {
		return model.getPlaceZipCode();
	}

	/**
	 * Returns the price of this campaign event.
	 *
	 * @return the price of this campaign event
	 */
	@Override
	public String getPrice() {
		return model.getPrice();
	}

	/**
	 * Returns the localized price of this campaign event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized price of this campaign event
	 */
	@Override
	public String getPrice(java.util.Locale locale) {
		return model.getPrice(locale);
	}

	/**
	 * Returns the localized price of this campaign event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized price of this campaign event. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getPrice(java.util.Locale locale, boolean useDefault) {
		return model.getPrice(locale, useDefault);
	}

	/**
	 * Returns the localized price of this campaign event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized price of this campaign event
	 */
	@Override
	public String getPrice(String languageId) {
		return model.getPrice(languageId);
	}

	/**
	 * Returns the localized price of this campaign event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized price of this campaign event
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
	 * Returns a map of the locales and localized prices of this campaign event.
	 *
	 * @return the locales and localized prices of this campaign event
	 */
	@Override
	public Map<java.util.Locale, String> getPriceMap() {
		return model.getPriceMap();
	}

	/**
	 * Returns the primary key of this campaign event.
	 *
	 * @return the primary key of this campaign event
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the promoter of this campaign event.
	 *
	 * @return the promoter of this campaign event
	 */
	@Override
	public String getPromoter() {
		return model.getPromoter();
	}

	/**
	 * Returns the public email of this campaign event.
	 *
	 * @return the public email of this campaign event
	 */
	@Override
	public String getPublicEmail() {
		return model.getPublicEmail();
	}

	/**
	 * Retourne le label des publics de l'événement
	 */
	@Override
	public String getPublicLabel(java.util.Locale locale) {
		return model.getPublicLabel(locale);
	}

	/**
	 * Returns the public phone of this campaign event.
	 *
	 * @return the public phone of this campaign event
	 */
	@Override
	public String getPublicPhone() {
		return model.getPublicPhone();
	}

	/**
	 * Retourne les publics
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getPublics() {

		return model.getPublics();
	}

	/**
	 * Returns the publics IDs of this campaign event.
	 *
	 * @return the publics IDs of this campaign event
	 */
	@Override
	public String getPublicsIds() {
		return model.getPublicsIds();
	}

	/**
	 * Returns the registration of this campaign event.
	 *
	 * @return the registration of this campaign event
	 */
	@Override
	public boolean getRegistration() {
		return model.getRegistration();
	}

	/**
	 * Returns the registration end date of this campaign event.
	 *
	 * @return the registration end date of this campaign event
	 */
	@Override
	public Date getRegistrationEndDate() {
		return model.getRegistrationEndDate();
	}

	/**
	 * Returns the registration start date of this campaign event.
	 *
	 * @return the registration start date of this campaign event
	 */
	@Override
	public Date getRegistrationStartDate() {
		return model.getRegistrationStartDate();
	}

	/**
	 * Returns the service of this campaign event.
	 *
	 * @return the service of this campaign event
	 */
	@Override
	public String getService() {
		return model.getService();
	}

	/**
	 * Returns the service ID of this campaign event.
	 *
	 * @return the service ID of this campaign event
	 */
	@Override
	public Long getServiceId() {
		return model.getServiceId();
	}

	/**
	 * Retourne le nom du service
	 */
	@Override
	public String getServiceName(java.util.Locale locale) {
		return model.getServiceName(locale);
	}

	/**
	 * Returns the status of this campaign event.
	 *
	 * @return the status of this campaign event
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Retourne la liste de CampaignEventStatus, correspondant à l'historique
	 * des statuts de l'événement classé par ordre chronologique
	 */
	@Override
	public java.util.List
		<eu.strasbourg.service.agenda.model.CampaignEventStatus>
			getStatusHistory() {

		return model.getStatusHistory();
	}

	/**
	 * Returns the subtitle of this campaign event.
	 *
	 * @return the subtitle of this campaign event
	 */
	@Override
	public String getSubtitle() {
		return model.getSubtitle();
	}

	/**
	 * Returns the localized subtitle of this campaign event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized subtitle of this campaign event
	 */
	@Override
	public String getSubtitle(java.util.Locale locale) {
		return model.getSubtitle(locale);
	}

	/**
	 * Returns the localized subtitle of this campaign event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized subtitle of this campaign event. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getSubtitle(java.util.Locale locale, boolean useDefault) {
		return model.getSubtitle(locale, useDefault);
	}

	/**
	 * Returns the localized subtitle of this campaign event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized subtitle of this campaign event
	 */
	@Override
	public String getSubtitle(String languageId) {
		return model.getSubtitle(languageId);
	}

	/**
	 * Returns the localized subtitle of this campaign event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized subtitle of this campaign event
	 */
	@Override
	public String getSubtitle(String languageId, boolean useDefault) {
		return model.getSubtitle(languageId, useDefault);
	}

	@Override
	public String getSubtitleCurrentLanguageId() {
		return model.getSubtitleCurrentLanguageId();
	}

	@Override
	public String getSubtitleCurrentValue() {
		return model.getSubtitleCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized subtitles of this campaign event.
	 *
	 * @return the locales and localized subtitles of this campaign event
	 */
	@Override
	public Map<java.util.Locale, String> getSubtitleMap() {
		return model.getSubtitleMap();
	}

	/**
	 * Returns the tags names of this campaign event.
	 *
	 * @return the tags names of this campaign event
	 */
	@Override
	public String getTagsNames() {
		return model.getTagsNames();
	}

	/**
	 * Retourne le label des thèles de l'événement
	 */
	@Override
	public String getThemeLabel(java.util.Locale locale) {
		return model.getThemeLabel(locale);
	}

	/**
	 * Retourne les thèmes
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getThemes() {

		return model.getThemes();
	}

	/**
	 * Returns the themes IDs of this campaign event.
	 *
	 * @return the themes IDs of this campaign event
	 */
	@Override
	public String getThemesIds() {
		return model.getThemesIds();
	}

	/**
	 * Returns the title of this campaign event.
	 *
	 * @return the title of this campaign event
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the localized title of this campaign event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized title of this campaign event
	 */
	@Override
	public String getTitle(java.util.Locale locale) {
		return model.getTitle(locale);
	}

	/**
	 * Returns the localized title of this campaign event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this campaign event. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getTitle(java.util.Locale locale, boolean useDefault) {
		return model.getTitle(locale, useDefault);
	}

	/**
	 * Returns the localized title of this campaign event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized title of this campaign event
	 */
	@Override
	public String getTitle(String languageId) {
		return model.getTitle(languageId);
	}

	/**
	 * Returns the localized title of this campaign event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this campaign event
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
	 * Returns a map of the locales and localized titles of this campaign event.
	 *
	 * @return the locales and localized titles of this campaign event
	 */
	@Override
	public Map<java.util.Locale, String> getTitleMap() {
		return model.getTitleMap();
	}

	/**
	 * Retourne le label des types de l'événement
	 */
	@Override
	public String getTypeLabel(java.util.Locale locale) {
		return model.getTypeLabel(locale);
	}

	/**
	 * Retourne les types
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getTypes() {

		return model.getTypes();
	}

	/**
	 * Returns the types IDs of this campaign event.
	 *
	 * @return the types IDs of this campaign event
	 */
	@Override
	public String getTypesIds() {
		return model.getTypesIds();
	}

	/**
	 * Returns the user ID of this campaign event.
	 *
	 * @return the user ID of this campaign event
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this campaign event.
	 *
	 * @return the user name of this campaign event
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this campaign event.
	 *
	 * @return the user uuid of this campaign event
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this campaign event.
	 *
	 * @return the uuid of this campaign event
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the web image ID of this campaign event.
	 *
	 * @return the web image ID of this campaign event
	 */
	@Override
	public Long getWebImageId() {
		return model.getWebImageId();
	}

	/**
	 * Retourne l'URL de l'image à partir de l'id du DLFileEntry
	 */
	@Override
	public String getWebImageURL() {
		return model.getWebImageURL();
	}

	/**
	 * Returns the website name of this campaign event.
	 *
	 * @return the website name of this campaign event
	 */
	@Override
	public String getWebsiteName() {
		return model.getWebsiteName();
	}

	/**
	 * Returns the localized website name of this campaign event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized website name of this campaign event
	 */
	@Override
	public String getWebsiteName(java.util.Locale locale) {
		return model.getWebsiteName(locale);
	}

	/**
	 * Returns the localized website name of this campaign event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized website name of this campaign event. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getWebsiteName(java.util.Locale locale, boolean useDefault) {
		return model.getWebsiteName(locale, useDefault);
	}

	/**
	 * Returns the localized website name of this campaign event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized website name of this campaign event
	 */
	@Override
	public String getWebsiteName(String languageId) {
		return model.getWebsiteName(languageId);
	}

	/**
	 * Returns the localized website name of this campaign event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized website name of this campaign event
	 */
	@Override
	public String getWebsiteName(String languageId, boolean useDefault) {
		return model.getWebsiteName(languageId, useDefault);
	}

	@Override
	public String getWebsiteNameCurrentLanguageId() {
		return model.getWebsiteNameCurrentLanguageId();
	}

	@Override
	public String getWebsiteNameCurrentValue() {
		return model.getWebsiteNameCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized website names of this campaign event.
	 *
	 * @return the locales and localized website names of this campaign event
	 */
	@Override
	public Map<java.util.Locale, String> getWebsiteNameMap() {
		return model.getWebsiteNameMap();
	}

	/**
	 * Returns the website url of this campaign event.
	 *
	 * @return the website url of this campaign event
	 */
	@Override
	public String getWebsiteURL() {
		return model.getWebsiteURL();
	}

	/**
	 * Returns the localized website url of this campaign event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized website url of this campaign event
	 */
	@Override
	public String getWebsiteURL(java.util.Locale locale) {
		return model.getWebsiteURL(locale);
	}

	/**
	 * Returns the localized website url of this campaign event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized website url of this campaign event. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getWebsiteURL(java.util.Locale locale, boolean useDefault) {
		return model.getWebsiteURL(locale, useDefault);
	}

	/**
	 * Returns the localized website url of this campaign event in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized website url of this campaign event
	 */
	@Override
	public String getWebsiteURL(String languageId) {
		return model.getWebsiteURL(languageId);
	}

	/**
	 * Returns the localized website url of this campaign event in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized website url of this campaign event
	 */
	@Override
	public String getWebsiteURL(String languageId, boolean useDefault) {
		return model.getWebsiteURL(languageId, useDefault);
	}

	@Override
	public String getWebsiteURLCurrentLanguageId() {
		return model.getWebsiteURLCurrentLanguageId();
	}

	@Override
	public String getWebsiteURLCurrentValue() {
		return model.getWebsiteURLCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized website urls of this campaign event.
	 *
	 * @return the locales and localized website urls of this campaign event
	 */
	@Override
	public Map<java.util.Locale, String> getWebsiteURLMap() {
		return model.getWebsiteURLMap();
	}

	/**
	 * Returns <code>true</code> if this campaign event is registration.
	 *
	 * @return <code>true</code> if this campaign event is registration; <code>false</code> otherwise
	 */
	@Override
	public boolean isRegistration() {
		return model.isRegistration();
	}

	/**
	 * Retourne true si l'utilisateur est manager de la campagne à laquelle
	 * appartient l'événement
	 */
	@Override
	public boolean isUserManagerOfTheEvent(long userId) {
		return model.isUserManagerOfTheEvent(userId);
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

	@Override
	public void sendDeleteMail()
		throws com.liferay.portal.kernel.exception.PortalException {

		model.sendDeleteMail();
	}

	@Override
	public void sendDeletionDeniedMail()
		throws com.liferay.portal.kernel.exception.PortalException {

		model.sendDeletionDeniedMail();
	}

	@Override
	public void sendStatusMail()
		throws com.liferay.portal.kernel.exception.PortalException {

		model.sendStatusMail();
	}

	/**
	 * Sets the booking description of this campaign event.
	 *
	 * @param bookingDescription the booking description of this campaign event
	 */
	@Override
	public void setBookingDescription(String bookingDescription) {
		model.setBookingDescription(bookingDescription);
	}

	/**
	 * Sets the localized booking description of this campaign event in the language.
	 *
	 * @param bookingDescription the localized booking description of this campaign event
	 * @param locale the locale of the language
	 */
	@Override
	public void setBookingDescription(
		String bookingDescription, java.util.Locale locale) {

		model.setBookingDescription(bookingDescription, locale);
	}

	/**
	 * Sets the localized booking description of this campaign event in the language, and sets the default locale.
	 *
	 * @param bookingDescription the localized booking description of this campaign event
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setBookingDescription(
		String bookingDescription, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setBookingDescription(bookingDescription, locale, defaultLocale);
	}

	@Override
	public void setBookingDescriptionCurrentLanguageId(String languageId) {
		model.setBookingDescriptionCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized booking descriptions of this campaign event from the map of locales and localized booking descriptions.
	 *
	 * @param bookingDescriptionMap the locales and localized booking descriptions of this campaign event
	 */
	@Override
	public void setBookingDescriptionMap(
		Map<java.util.Locale, String> bookingDescriptionMap) {

		model.setBookingDescriptionMap(bookingDescriptionMap);
	}

	/**
	 * Sets the localized booking descriptions of this campaign event from the map of locales and localized booking descriptions, and sets the default locale.
	 *
	 * @param bookingDescriptionMap the locales and localized booking descriptions of this campaign event
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setBookingDescriptionMap(
		Map<java.util.Locale, String> bookingDescriptionMap,
		java.util.Locale defaultLocale) {

		model.setBookingDescriptionMap(bookingDescriptionMap, defaultLocale);
	}

	/**
	 * Sets the booking url of this campaign event.
	 *
	 * @param bookingURL the booking url of this campaign event
	 */
	@Override
	public void setBookingURL(String bookingURL) {
		model.setBookingURL(bookingURL);
	}

	/**
	 * Sets the campaign event ID of this campaign event.
	 *
	 * @param campaignEventId the campaign event ID of this campaign event
	 */
	@Override
	public void setCampaignEventId(long campaignEventId) {
		model.setCampaignEventId(campaignEventId);
	}

	/**
	 * Sets the campaign ID of this campaign event.
	 *
	 * @param campaignId the campaign ID of this campaign event
	 */
	@Override
	public void setCampaignId(Long campaignId) {
		model.setCampaignId(campaignId);
	}

	/**
	 * Sets the company ID of this campaign event.
	 *
	 * @param companyId the company ID of this campaign event
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this campaign event.
	 *
	 * @param createDate the create date of this campaign event
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this campaign event.
	 *
	 * @param description the description of this campaign event
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the localized description of this campaign event in the language.
	 *
	 * @param description the localized description of this campaign event
	 * @param locale the locale of the language
	 */
	@Override
	public void setDescription(String description, java.util.Locale locale) {
		model.setDescription(description, locale);
	}

	/**
	 * Sets the localized description of this campaign event in the language, and sets the default locale.
	 *
	 * @param description the localized description of this campaign event
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
	 * Sets the localized descriptions of this campaign event from the map of locales and localized descriptions.
	 *
	 * @param descriptionMap the locales and localized descriptions of this campaign event
	 */
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, String> descriptionMap) {

		model.setDescriptionMap(descriptionMap);
	}

	/**
	 * Sets the localized descriptions of this campaign event from the map of locales and localized descriptions, and sets the default locale.
	 *
	 * @param descriptionMap the locales and localized descriptions of this campaign event
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, String> descriptionMap,
		java.util.Locale defaultLocale) {

		model.setDescriptionMap(descriptionMap, defaultLocale);
	}

	/**
	 * Sets the email of this campaign event.
	 *
	 * @param email the email of this campaign event
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the first name of this campaign event.
	 *
	 * @param firstName the first name of this campaign event
	 */
	@Override
	public void setFirstName(String firstName) {
		model.setFirstName(firstName);
	}

	/**
	 * Sets the free of this campaign event.
	 *
	 * @param free the free of this campaign event
	 */
	@Override
	public void setFree(Integer free) {
		model.setFree(free);
	}

	/**
	 * Sets the group ID of this campaign event.
	 *
	 * @param groupId the group ID of this campaign event
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the image ID of this campaign event.
	 *
	 * @param imageId the image ID of this campaign event
	 */
	@Override
	public void setImageId(Long imageId) {
		model.setImageId(imageId);
	}

	/**
	 * Sets the image owner of this campaign event.
	 *
	 * @param imageOwner the image owner of this campaign event
	 */
	@Override
	public void setImageOwner(String imageOwner) {
		model.setImageOwner(imageOwner);
	}

	/**
	 * Sets the last name of this campaign event.
	 *
	 * @param lastName the last name of this campaign event
	 */
	@Override
	public void setLastName(String lastName) {
		model.setLastName(lastName);
	}

	/**
	 * Sets the last publish date of this campaign event.
	 *
	 * @param lastPublishDate the last publish date of this campaign event
	 */
	@Override
	public void setLastPublishDate(Date lastPublishDate) {
		model.setLastPublishDate(lastPublishDate);
	}

	/**
	 * Sets the manifestations IDs of this campaign event.
	 *
	 * @param manifestationsIds the manifestations IDs of this campaign event
	 */
	@Override
	public void setManifestationsIds(String manifestationsIds) {
		model.setManifestationsIds(manifestationsIds);
	}

	/**
	 * Sets the max gauge of this campaign event.
	 *
	 * @param maxGauge the max gauge of this campaign event
	 */
	@Override
	public void setMaxGauge(long maxGauge) {
		model.setMaxGauge(maxGauge);
	}

	/**
	 * Sets the modified date of this campaign event.
	 *
	 * @param modifiedDate the modified date of this campaign event
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the on site first name of this campaign event.
	 *
	 * @param onSiteFirstName the on site first name of this campaign event
	 */
	@Override
	public void setOnSiteFirstName(String onSiteFirstName) {
		model.setOnSiteFirstName(onSiteFirstName);
	}

	/**
	 * Sets the on site last name of this campaign event.
	 *
	 * @param onSiteLastName the on site last name of this campaign event
	 */
	@Override
	public void setOnSiteLastName(String onSiteLastName) {
		model.setOnSiteLastName(onSiteLastName);
	}

	/**
	 * Sets the on site phone of this campaign event.
	 *
	 * @param onSitePhone the on site phone of this campaign event
	 */
	@Override
	public void setOnSitePhone(String onSitePhone) {
		model.setOnSitePhone(onSitePhone);
	}

	/**
	 * Sets the phone of this campaign event.
	 *
	 * @param phone the phone of this campaign event
	 */
	@Override
	public void setPhone(String phone) {
		model.setPhone(phone);
	}

	/**
	 * Sets the place city ID of this campaign event.
	 *
	 * @param placeCityId the place city ID of this campaign event
	 */
	@Override
	public void setPlaceCityId(Long placeCityId) {
		model.setPlaceCityId(placeCityId);
	}

	/**
	 * Sets the place country of this campaign event.
	 *
	 * @param placeCountry the place country of this campaign event
	 */
	@Override
	public void setPlaceCountry(String placeCountry) {
		model.setPlaceCountry(placeCountry);
	}

	/**
	 * Sets the place name of this campaign event.
	 *
	 * @param placeName the place name of this campaign event
	 */
	@Override
	public void setPlaceName(String placeName) {
		model.setPlaceName(placeName);
	}

	/**
	 * Sets the localized place name of this campaign event in the language.
	 *
	 * @param placeName the localized place name of this campaign event
	 * @param locale the locale of the language
	 */
	@Override
	public void setPlaceName(String placeName, java.util.Locale locale) {
		model.setPlaceName(placeName, locale);
	}

	/**
	 * Sets the localized place name of this campaign event in the language, and sets the default locale.
	 *
	 * @param placeName the localized place name of this campaign event
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
	 * Sets the localized place names of this campaign event from the map of locales and localized place names.
	 *
	 * @param placeNameMap the locales and localized place names of this campaign event
	 */
	@Override
	public void setPlaceNameMap(Map<java.util.Locale, String> placeNameMap) {
		model.setPlaceNameMap(placeNameMap);
	}

	/**
	 * Sets the localized place names of this campaign event from the map of locales and localized place names, and sets the default locale.
	 *
	 * @param placeNameMap the locales and localized place names of this campaign event
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setPlaceNameMap(
		Map<java.util.Locale, String> placeNameMap,
		java.util.Locale defaultLocale) {

		model.setPlaceNameMap(placeNameMap, defaultLocale);
	}

	/**
	 * Sets the place sig ID of this campaign event.
	 *
	 * @param placeSIGId the place sig ID of this campaign event
	 */
	@Override
	public void setPlaceSIGId(String placeSIGId) {
		model.setPlaceSIGId(placeSIGId);
	}

	/**
	 * Sets the place street name of this campaign event.
	 *
	 * @param placeStreetName the place street name of this campaign event
	 */
	@Override
	public void setPlaceStreetName(String placeStreetName) {
		model.setPlaceStreetName(placeStreetName);
	}

	/**
	 * Sets the place street number of this campaign event.
	 *
	 * @param placeStreetNumber the place street number of this campaign event
	 */
	@Override
	public void setPlaceStreetNumber(String placeStreetNumber) {
		model.setPlaceStreetNumber(placeStreetNumber);
	}

	/**
	 * Sets the place zip code of this campaign event.
	 *
	 * @param placeZipCode the place zip code of this campaign event
	 */
	@Override
	public void setPlaceZipCode(String placeZipCode) {
		model.setPlaceZipCode(placeZipCode);
	}

	/**
	 * Sets the price of this campaign event.
	 *
	 * @param price the price of this campaign event
	 */
	@Override
	public void setPrice(String price) {
		model.setPrice(price);
	}

	/**
	 * Sets the localized price of this campaign event in the language.
	 *
	 * @param price the localized price of this campaign event
	 * @param locale the locale of the language
	 */
	@Override
	public void setPrice(String price, java.util.Locale locale) {
		model.setPrice(price, locale);
	}

	/**
	 * Sets the localized price of this campaign event in the language, and sets the default locale.
	 *
	 * @param price the localized price of this campaign event
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
	 * Sets the localized prices of this campaign event from the map of locales and localized prices.
	 *
	 * @param priceMap the locales and localized prices of this campaign event
	 */
	@Override
	public void setPriceMap(Map<java.util.Locale, String> priceMap) {
		model.setPriceMap(priceMap);
	}

	/**
	 * Sets the localized prices of this campaign event from the map of locales and localized prices, and sets the default locale.
	 *
	 * @param priceMap the locales and localized prices of this campaign event
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setPriceMap(
		Map<java.util.Locale, String> priceMap,
		java.util.Locale defaultLocale) {

		model.setPriceMap(priceMap, defaultLocale);
	}

	/**
	 * Sets the primary key of this campaign event.
	 *
	 * @param primaryKey the primary key of this campaign event
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the promoter of this campaign event.
	 *
	 * @param promoter the promoter of this campaign event
	 */
	@Override
	public void setPromoter(String promoter) {
		model.setPromoter(promoter);
	}

	/**
	 * Sets the public email of this campaign event.
	 *
	 * @param publicEmail the public email of this campaign event
	 */
	@Override
	public void setPublicEmail(String publicEmail) {
		model.setPublicEmail(publicEmail);
	}

	/**
	 * Sets the public phone of this campaign event.
	 *
	 * @param publicPhone the public phone of this campaign event
	 */
	@Override
	public void setPublicPhone(String publicPhone) {
		model.setPublicPhone(publicPhone);
	}

	/**
	 * Sets the publics IDs of this campaign event.
	 *
	 * @param publicsIds the publics IDs of this campaign event
	 */
	@Override
	public void setPublicsIds(String publicsIds) {
		model.setPublicsIds(publicsIds);
	}

	/**
	 * Sets whether this campaign event is registration.
	 *
	 * @param registration the registration of this campaign event
	 */
	@Override
	public void setRegistration(boolean registration) {
		model.setRegistration(registration);
	}

	/**
	 * Sets the registration end date of this campaign event.
	 *
	 * @param registrationEndDate the registration end date of this campaign event
	 */
	@Override
	public void setRegistrationEndDate(Date registrationEndDate) {
		model.setRegistrationEndDate(registrationEndDate);
	}

	/**
	 * Sets the registration start date of this campaign event.
	 *
	 * @param registrationStartDate the registration start date of this campaign event
	 */
	@Override
	public void setRegistrationStartDate(Date registrationStartDate) {
		model.setRegistrationStartDate(registrationStartDate);
	}

	/**
	 * Sets the service of this campaign event.
	 *
	 * @param service the service of this campaign event
	 */
	@Override
	public void setService(String service) {
		model.setService(service);
	}

	/**
	 * Sets the service ID of this campaign event.
	 *
	 * @param serviceId the service ID of this campaign event
	 */
	@Override
	public void setServiceId(Long serviceId) {
		model.setServiceId(serviceId);
	}

	/**
	 * Sets the status of this campaign event.
	 *
	 * @param status the status of this campaign event
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the subtitle of this campaign event.
	 *
	 * @param subtitle the subtitle of this campaign event
	 */
	@Override
	public void setSubtitle(String subtitle) {
		model.setSubtitle(subtitle);
	}

	/**
	 * Sets the localized subtitle of this campaign event in the language.
	 *
	 * @param subtitle the localized subtitle of this campaign event
	 * @param locale the locale of the language
	 */
	@Override
	public void setSubtitle(String subtitle, java.util.Locale locale) {
		model.setSubtitle(subtitle, locale);
	}

	/**
	 * Sets the localized subtitle of this campaign event in the language, and sets the default locale.
	 *
	 * @param subtitle the localized subtitle of this campaign event
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setSubtitle(
		String subtitle, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setSubtitle(subtitle, locale, defaultLocale);
	}

	@Override
	public void setSubtitleCurrentLanguageId(String languageId) {
		model.setSubtitleCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized subtitles of this campaign event from the map of locales and localized subtitles.
	 *
	 * @param subtitleMap the locales and localized subtitles of this campaign event
	 */
	@Override
	public void setSubtitleMap(Map<java.util.Locale, String> subtitleMap) {
		model.setSubtitleMap(subtitleMap);
	}

	/**
	 * Sets the localized subtitles of this campaign event from the map of locales and localized subtitles, and sets the default locale.
	 *
	 * @param subtitleMap the locales and localized subtitles of this campaign event
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setSubtitleMap(
		Map<java.util.Locale, String> subtitleMap,
		java.util.Locale defaultLocale) {

		model.setSubtitleMap(subtitleMap, defaultLocale);
	}

	/**
	 * Sets the tags names of this campaign event.
	 *
	 * @param tagsNames the tags names of this campaign event
	 */
	@Override
	public void setTagsNames(String tagsNames) {
		model.setTagsNames(tagsNames);
	}

	/**
	 * Sets the themes IDs of this campaign event.
	 *
	 * @param themesIds the themes IDs of this campaign event
	 */
	@Override
	public void setThemesIds(String themesIds) {
		model.setThemesIds(themesIds);
	}

	/**
	 * Sets the title of this campaign event.
	 *
	 * @param title the title of this campaign event
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the localized title of this campaign event in the language.
	 *
	 * @param title the localized title of this campaign event
	 * @param locale the locale of the language
	 */
	@Override
	public void setTitle(String title, java.util.Locale locale) {
		model.setTitle(title, locale);
	}

	/**
	 * Sets the localized title of this campaign event in the language, and sets the default locale.
	 *
	 * @param title the localized title of this campaign event
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
	 * Sets the localized titles of this campaign event from the map of locales and localized titles.
	 *
	 * @param titleMap the locales and localized titles of this campaign event
	 */
	@Override
	public void setTitleMap(Map<java.util.Locale, String> titleMap) {
		model.setTitleMap(titleMap);
	}

	/**
	 * Sets the localized titles of this campaign event from the map of locales and localized titles, and sets the default locale.
	 *
	 * @param titleMap the locales and localized titles of this campaign event
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setTitleMap(
		Map<java.util.Locale, String> titleMap,
		java.util.Locale defaultLocale) {

		model.setTitleMap(titleMap, defaultLocale);
	}

	/**
	 * Sets the types IDs of this campaign event.
	 *
	 * @param typesIds the types IDs of this campaign event
	 */
	@Override
	public void setTypesIds(String typesIds) {
		model.setTypesIds(typesIds);
	}

	/**
	 * Sets the user ID of this campaign event.
	 *
	 * @param userId the user ID of this campaign event
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this campaign event.
	 *
	 * @param userName the user name of this campaign event
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this campaign event.
	 *
	 * @param userUuid the user uuid of this campaign event
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this campaign event.
	 *
	 * @param uuid the uuid of this campaign event
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the web image ID of this campaign event.
	 *
	 * @param webImageId the web image ID of this campaign event
	 */
	@Override
	public void setWebImageId(Long webImageId) {
		model.setWebImageId(webImageId);
	}

	/**
	 * Sets the website name of this campaign event.
	 *
	 * @param websiteName the website name of this campaign event
	 */
	@Override
	public void setWebsiteName(String websiteName) {
		model.setWebsiteName(websiteName);
	}

	/**
	 * Sets the localized website name of this campaign event in the language.
	 *
	 * @param websiteName the localized website name of this campaign event
	 * @param locale the locale of the language
	 */
	@Override
	public void setWebsiteName(String websiteName, java.util.Locale locale) {
		model.setWebsiteName(websiteName, locale);
	}

	/**
	 * Sets the localized website name of this campaign event in the language, and sets the default locale.
	 *
	 * @param websiteName the localized website name of this campaign event
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setWebsiteName(
		String websiteName, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setWebsiteName(websiteName, locale, defaultLocale);
	}

	@Override
	public void setWebsiteNameCurrentLanguageId(String languageId) {
		model.setWebsiteNameCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized website names of this campaign event from the map of locales and localized website names.
	 *
	 * @param websiteNameMap the locales and localized website names of this campaign event
	 */
	@Override
	public void setWebsiteNameMap(
		Map<java.util.Locale, String> websiteNameMap) {

		model.setWebsiteNameMap(websiteNameMap);
	}

	/**
	 * Sets the localized website names of this campaign event from the map of locales and localized website names, and sets the default locale.
	 *
	 * @param websiteNameMap the locales and localized website names of this campaign event
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setWebsiteNameMap(
		Map<java.util.Locale, String> websiteNameMap,
		java.util.Locale defaultLocale) {

		model.setWebsiteNameMap(websiteNameMap, defaultLocale);
	}

	/**
	 * Sets the website url of this campaign event.
	 *
	 * @param websiteURL the website url of this campaign event
	 */
	@Override
	public void setWebsiteURL(String websiteURL) {
		model.setWebsiteURL(websiteURL);
	}

	/**
	 * Sets the localized website url of this campaign event in the language.
	 *
	 * @param websiteURL the localized website url of this campaign event
	 * @param locale the locale of the language
	 */
	@Override
	public void setWebsiteURL(String websiteURL, java.util.Locale locale) {
		model.setWebsiteURL(websiteURL, locale);
	}

	/**
	 * Sets the localized website url of this campaign event in the language, and sets the default locale.
	 *
	 * @param websiteURL the localized website url of this campaign event
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setWebsiteURL(
		String websiteURL, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setWebsiteURL(websiteURL, locale, defaultLocale);
	}

	@Override
	public void setWebsiteURLCurrentLanguageId(String languageId) {
		model.setWebsiteURLCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized website urls of this campaign event from the map of locales and localized website urls.
	 *
	 * @param websiteURLMap the locales and localized website urls of this campaign event
	 */
	@Override
	public void setWebsiteURLMap(Map<java.util.Locale, String> websiteURLMap) {
		model.setWebsiteURLMap(websiteURLMap);
	}

	/**
	 * Sets the localized website urls of this campaign event from the map of locales and localized website urls, and sets the default locale.
	 *
	 * @param websiteURLMap the locales and localized website urls of this campaign event
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setWebsiteURLMap(
		Map<java.util.Locale, String> websiteURLMap,
		java.util.Locale defaultLocale) {

		model.setWebsiteURLMap(websiteURLMap, defaultLocale);
	}

	/**
	 * Retourne la version JSON de l'object
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
	public eu.strasbourg.service.agenda.model.CampaignEventStatus updateStatus(
			int newStatus, String comment,
			com.liferay.portal.kernel.model.User user)
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.updateStatus(newStatus, comment, user);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected CampaignEventWrapper wrap(CampaignEvent campaignEvent) {
		return new CampaignEventWrapper(campaignEvent);
	}

}