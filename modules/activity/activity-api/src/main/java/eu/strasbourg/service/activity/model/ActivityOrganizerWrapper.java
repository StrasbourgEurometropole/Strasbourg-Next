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
 * This class is a wrapper for {@link ActivityOrganizer}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ActivityOrganizer
 * @generated
 */
public class ActivityOrganizerWrapper
	extends BaseModelWrapper<ActivityOrganizer>
	implements ActivityOrganizer, ModelWrapper<ActivityOrganizer> {

	public ActivityOrganizerWrapper(ActivityOrganizer activityOrganizer) {
		super(activityOrganizer);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("activityOrganizerId", getActivityOrganizerId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("name", getName());
		attributes.put("presentation", getPresentation());
		attributes.put("address", getAddress());
		attributes.put("phone", getPhone());
		attributes.put("mail", getMail());
		attributes.put("siteURL", getSiteURL());
		attributes.put("imageId", getImageId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long activityOrganizerId = (Long)attributes.get("activityOrganizerId");

		if (activityOrganizerId != null) {
			setActivityOrganizerId(activityOrganizerId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String presentation = (String)attributes.get("presentation");

		if (presentation != null) {
			setPresentation(presentation);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
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

		Long imageId = (Long)attributes.get("imageId");

		if (imageId != null) {
			setImageId(imageId);
		}
	}

	@Override
	public ActivityOrganizer cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the activity organizer ID of this activity organizer.
	 *
	 * @return the activity organizer ID of this activity organizer
	 */
	@Override
	public long getActivityOrganizerId() {
		return model.getActivityOrganizerId();
	}

	/**
	 * Returns the address of this activity organizer.
	 *
	 * @return the address of this activity organizer
	 */
	@Override
	public String getAddress() {
		return model.getAddress();
	}

	/**
	 * Returns the localized address of this activity organizer in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized address of this activity organizer
	 */
	@Override
	public String getAddress(java.util.Locale locale) {
		return model.getAddress(locale);
	}

	/**
	 * Returns the localized address of this activity organizer in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized address of this activity organizer. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getAddress(java.util.Locale locale, boolean useDefault) {
		return model.getAddress(locale, useDefault);
	}

	/**
	 * Returns the localized address of this activity organizer in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized address of this activity organizer
	 */
	@Override
	public String getAddress(String languageId) {
		return model.getAddress(languageId);
	}

	/**
	 * Returns the localized address of this activity organizer in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized address of this activity organizer
	 */
	@Override
	public String getAddress(String languageId, boolean useDefault) {
		return model.getAddress(languageId, useDefault);
	}

	@Override
	public String getAddressCurrentLanguageId() {
		return model.getAddressCurrentLanguageId();
	}

	@Override
	public String getAddressCurrentValue() {
		return model.getAddressCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized addresses of this activity organizer.
	 *
	 * @return the locales and localized addresses of this activity organizer
	 */
	@Override
	public Map<java.util.Locale, String> getAddressMap() {
		return model.getAddressMap();
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
	 * Returns the company ID of this activity organizer.
	 *
	 * @return the company ID of this activity organizer
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this activity organizer.
	 *
	 * @return the create date of this activity organizer
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
	 * Returns the group ID of this activity organizer.
	 *
	 * @return the group ID of this activity organizer
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the image ID of this activity organizer.
	 *
	 * @return the image ID of this activity organizer
	 */
	@Override
	public long getImageId() {
		return model.getImageId();
	}

	/**
	 * Retourne l'URL de l'image
	 */
	@Override
	public String getImageURL() {
		return model.getImageURL();
	}

	/**
	 * Retourne la version live de cette entité
	 */
	@Override
	public ActivityOrganizer getLiveVersion() {
		return model.getLiveVersion();
	}

	/**
	 * Returns the mail of this activity organizer.
	 *
	 * @return the mail of this activity organizer
	 */
	@Override
	public String getMail() {
		return model.getMail();
	}

	/**
	 * Returns the modified date of this activity organizer.
	 *
	 * @return the modified date of this activity organizer
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this activity organizer.
	 *
	 * @return the name of this activity organizer
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the localized name of this activity organizer in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized name of this activity organizer
	 */
	@Override
	public String getName(java.util.Locale locale) {
		return model.getName(locale);
	}

	/**
	 * Returns the localized name of this activity organizer in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this activity organizer. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getName(java.util.Locale locale, boolean useDefault) {
		return model.getName(locale, useDefault);
	}

	/**
	 * Returns the localized name of this activity organizer in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized name of this activity organizer
	 */
	@Override
	public String getName(String languageId) {
		return model.getName(languageId);
	}

	/**
	 * Returns the localized name of this activity organizer in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this activity organizer
	 */
	@Override
	public String getName(String languageId, boolean useDefault) {
		return model.getName(languageId, useDefault);
	}

	@Override
	public String getNameCurrentLanguageId() {
		return model.getNameCurrentLanguageId();
	}

	@Override
	public String getNameCurrentValue() {
		return model.getNameCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized names of this activity organizer.
	 *
	 * @return the locales and localized names of this activity organizer
	 */
	@Override
	public Map<java.util.Locale, String> getNameMap() {
		return model.getNameMap();
	}

	/**
	 * Returns the phone of this activity organizer.
	 *
	 * @return the phone of this activity organizer
	 */
	@Override
	public String getPhone() {
		return model.getPhone();
	}

	/**
	 * Returns the presentation of this activity organizer.
	 *
	 * @return the presentation of this activity organizer
	 */
	@Override
	public String getPresentation() {
		return model.getPresentation();
	}

	/**
	 * Returns the localized presentation of this activity organizer in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized presentation of this activity organizer
	 */
	@Override
	public String getPresentation(java.util.Locale locale) {
		return model.getPresentation(locale);
	}

	/**
	 * Returns the localized presentation of this activity organizer in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized presentation of this activity organizer. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getPresentation(java.util.Locale locale, boolean useDefault) {
		return model.getPresentation(locale, useDefault);
	}

	/**
	 * Returns the localized presentation of this activity organizer in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized presentation of this activity organizer
	 */
	@Override
	public String getPresentation(String languageId) {
		return model.getPresentation(languageId);
	}

	/**
	 * Returns the localized presentation of this activity organizer in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized presentation of this activity organizer
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
	 * Returns a map of the locales and localized presentations of this activity organizer.
	 *
	 * @return the locales and localized presentations of this activity organizer
	 */
	@Override
	public Map<java.util.Locale, String> getPresentationMap() {
		return model.getPresentationMap();
	}

	/**
	 * Returns the primary key of this activity organizer.
	 *
	 * @return the primary key of this activity organizer
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the site url of this activity organizer.
	 *
	 * @return the site url of this activity organizer
	 */
	@Override
	public String getSiteURL() {
		return model.getSiteURL();
	}

	/**
	 * Returns the localized site url of this activity organizer in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized site url of this activity organizer
	 */
	@Override
	public String getSiteURL(java.util.Locale locale) {
		return model.getSiteURL(locale);
	}

	/**
	 * Returns the localized site url of this activity organizer in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized site url of this activity organizer. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getSiteURL(java.util.Locale locale, boolean useDefault) {
		return model.getSiteURL(locale, useDefault);
	}

	/**
	 * Returns the localized site url of this activity organizer in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized site url of this activity organizer
	 */
	@Override
	public String getSiteURL(String languageId) {
		return model.getSiteURL(languageId);
	}

	/**
	 * Returns the localized site url of this activity organizer in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized site url of this activity organizer
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
	 * Returns a map of the locales and localized site urls of this activity organizer.
	 *
	 * @return the locales and localized site urls of this activity organizer
	 */
	@Override
	public Map<java.util.Locale, String> getSiteURLMap() {
		return model.getSiteURLMap();
	}

	/**
	 * Returns the status of this activity organizer.
	 *
	 * @return the status of this activity organizer
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this activity organizer.
	 *
	 * @return the status by user ID of this activity organizer
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this activity organizer.
	 *
	 * @return the status by user name of this activity organizer
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this activity organizer.
	 *
	 * @return the status by user uuid of this activity organizer
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this activity organizer.
	 *
	 * @return the status date of this activity organizer
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the user ID of this activity organizer.
	 *
	 * @return the user ID of this activity organizer
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this activity organizer.
	 *
	 * @return the user name of this activity organizer
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this activity organizer.
	 *
	 * @return the user uuid of this activity organizer
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this activity organizer.
	 *
	 * @return the uuid of this activity organizer
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this activity organizer is approved.
	 *
	 * @return <code>true</code> if this activity organizer is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this activity organizer is denied.
	 *
	 * @return <code>true</code> if this activity organizer is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this activity organizer is a draft.
	 *
	 * @return <code>true</code> if this activity organizer is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this activity organizer is expired.
	 *
	 * @return <code>true</code> if this activity organizer is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this activity organizer is inactive.
	 *
	 * @return <code>true</code> if this activity organizer is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this activity organizer is incomplete.
	 *
	 * @return <code>true</code> if this activity organizer is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this activity organizer is pending.
	 *
	 * @return <code>true</code> if this activity organizer is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this activity organizer is scheduled.
	 *
	 * @return <code>true</code> if this activity organizer is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
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
	 * Sets the activity organizer ID of this activity organizer.
	 *
	 * @param activityOrganizerId the activity organizer ID of this activity organizer
	 */
	@Override
	public void setActivityOrganizerId(long activityOrganizerId) {
		model.setActivityOrganizerId(activityOrganizerId);
	}

	/**
	 * Sets the address of this activity organizer.
	 *
	 * @param address the address of this activity organizer
	 */
	@Override
	public void setAddress(String address) {
		model.setAddress(address);
	}

	/**
	 * Sets the localized address of this activity organizer in the language.
	 *
	 * @param address the localized address of this activity organizer
	 * @param locale the locale of the language
	 */
	@Override
	public void setAddress(String address, java.util.Locale locale) {
		model.setAddress(address, locale);
	}

	/**
	 * Sets the localized address of this activity organizer in the language, and sets the default locale.
	 *
	 * @param address the localized address of this activity organizer
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setAddress(
		String address, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setAddress(address, locale, defaultLocale);
	}

	@Override
	public void setAddressCurrentLanguageId(String languageId) {
		model.setAddressCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized addresses of this activity organizer from the map of locales and localized addresses.
	 *
	 * @param addressMap the locales and localized addresses of this activity organizer
	 */
	@Override
	public void setAddressMap(Map<java.util.Locale, String> addressMap) {
		model.setAddressMap(addressMap);
	}

	/**
	 * Sets the localized addresses of this activity organizer from the map of locales and localized addresses, and sets the default locale.
	 *
	 * @param addressMap the locales and localized addresses of this activity organizer
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setAddressMap(
		Map<java.util.Locale, String> addressMap,
		java.util.Locale defaultLocale) {

		model.setAddressMap(addressMap, defaultLocale);
	}

	/**
	 * Sets the company ID of this activity organizer.
	 *
	 * @param companyId the company ID of this activity organizer
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this activity organizer.
	 *
	 * @param createDate the create date of this activity organizer
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this activity organizer.
	 *
	 * @param groupId the group ID of this activity organizer
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the image ID of this activity organizer.
	 *
	 * @param imageId the image ID of this activity organizer
	 */
	@Override
	public void setImageId(long imageId) {
		model.setImageId(imageId);
	}

	/**
	 * Sets the mail of this activity organizer.
	 *
	 * @param mail the mail of this activity organizer
	 */
	@Override
	public void setMail(String mail) {
		model.setMail(mail);
	}

	/**
	 * Sets the modified date of this activity organizer.
	 *
	 * @param modifiedDate the modified date of this activity organizer
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this activity organizer.
	 *
	 * @param name the name of this activity organizer
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the localized name of this activity organizer in the language.
	 *
	 * @param name the localized name of this activity organizer
	 * @param locale the locale of the language
	 */
	@Override
	public void setName(String name, java.util.Locale locale) {
		model.setName(name, locale);
	}

	/**
	 * Sets the localized name of this activity organizer in the language, and sets the default locale.
	 *
	 * @param name the localized name of this activity organizer
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setName(
		String name, java.util.Locale locale, java.util.Locale defaultLocale) {

		model.setName(name, locale, defaultLocale);
	}

	@Override
	public void setNameCurrentLanguageId(String languageId) {
		model.setNameCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized names of this activity organizer from the map of locales and localized names.
	 *
	 * @param nameMap the locales and localized names of this activity organizer
	 */
	@Override
	public void setNameMap(Map<java.util.Locale, String> nameMap) {
		model.setNameMap(nameMap);
	}

	/**
	 * Sets the localized names of this activity organizer from the map of locales and localized names, and sets the default locale.
	 *
	 * @param nameMap the locales and localized names of this activity organizer
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setNameMap(
		Map<java.util.Locale, String> nameMap, java.util.Locale defaultLocale) {

		model.setNameMap(nameMap, defaultLocale);
	}

	/**
	 * Sets the phone of this activity organizer.
	 *
	 * @param phone the phone of this activity organizer
	 */
	@Override
	public void setPhone(String phone) {
		model.setPhone(phone);
	}

	/**
	 * Sets the presentation of this activity organizer.
	 *
	 * @param presentation the presentation of this activity organizer
	 */
	@Override
	public void setPresentation(String presentation) {
		model.setPresentation(presentation);
	}

	/**
	 * Sets the localized presentation of this activity organizer in the language.
	 *
	 * @param presentation the localized presentation of this activity organizer
	 * @param locale the locale of the language
	 */
	@Override
	public void setPresentation(String presentation, java.util.Locale locale) {
		model.setPresentation(presentation, locale);
	}

	/**
	 * Sets the localized presentation of this activity organizer in the language, and sets the default locale.
	 *
	 * @param presentation the localized presentation of this activity organizer
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
	 * Sets the localized presentations of this activity organizer from the map of locales and localized presentations.
	 *
	 * @param presentationMap the locales and localized presentations of this activity organizer
	 */
	@Override
	public void setPresentationMap(
		Map<java.util.Locale, String> presentationMap) {

		model.setPresentationMap(presentationMap);
	}

	/**
	 * Sets the localized presentations of this activity organizer from the map of locales and localized presentations, and sets the default locale.
	 *
	 * @param presentationMap the locales and localized presentations of this activity organizer
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setPresentationMap(
		Map<java.util.Locale, String> presentationMap,
		java.util.Locale defaultLocale) {

		model.setPresentationMap(presentationMap, defaultLocale);
	}

	/**
	 * Sets the primary key of this activity organizer.
	 *
	 * @param primaryKey the primary key of this activity organizer
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the site url of this activity organizer.
	 *
	 * @param siteURL the site url of this activity organizer
	 */
	@Override
	public void setSiteURL(String siteURL) {
		model.setSiteURL(siteURL);
	}

	/**
	 * Sets the localized site url of this activity organizer in the language.
	 *
	 * @param siteURL the localized site url of this activity organizer
	 * @param locale the locale of the language
	 */
	@Override
	public void setSiteURL(String siteURL, java.util.Locale locale) {
		model.setSiteURL(siteURL, locale);
	}

	/**
	 * Sets the localized site url of this activity organizer in the language, and sets the default locale.
	 *
	 * @param siteURL the localized site url of this activity organizer
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
	 * Sets the localized site urls of this activity organizer from the map of locales and localized site urls.
	 *
	 * @param siteURLMap the locales and localized site urls of this activity organizer
	 */
	@Override
	public void setSiteURLMap(Map<java.util.Locale, String> siteURLMap) {
		model.setSiteURLMap(siteURLMap);
	}

	/**
	 * Sets the localized site urls of this activity organizer from the map of locales and localized site urls, and sets the default locale.
	 *
	 * @param siteURLMap the locales and localized site urls of this activity organizer
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setSiteURLMap(
		Map<java.util.Locale, String> siteURLMap,
		java.util.Locale defaultLocale) {

		model.setSiteURLMap(siteURLMap, defaultLocale);
	}

	/**
	 * Sets the status of this activity organizer.
	 *
	 * @param status the status of this activity organizer
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this activity organizer.
	 *
	 * @param statusByUserId the status by user ID of this activity organizer
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this activity organizer.
	 *
	 * @param statusByUserName the status by user name of this activity organizer
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this activity organizer.
	 *
	 * @param statusByUserUuid the status by user uuid of this activity organizer
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this activity organizer.
	 *
	 * @param statusDate the status date of this activity organizer
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the user ID of this activity organizer.
	 *
	 * @param userId the user ID of this activity organizer
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this activity organizer.
	 *
	 * @param userName the user name of this activity organizer
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this activity organizer.
	 *
	 * @param userUuid the user uuid of this activity organizer
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this activity organizer.
	 *
	 * @param uuid the uuid of this activity organizer
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
	protected ActivityOrganizerWrapper wrap(
		ActivityOrganizer activityOrganizer) {

		return new ActivityOrganizerWrapper(activityOrganizer);
	}

}