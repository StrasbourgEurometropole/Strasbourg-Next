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
 * This class is a wrapper for {@link Association}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Association
 * @generated
 */
public class AssociationWrapper
	extends BaseModelWrapper<Association>
	implements Association, ModelWrapper<Association> {

	public AssociationWrapper(Association association) {
		super(association);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("associationId", getAssociationId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("presentation", getPresentation());
		attributes.put("phone", getPhone());
		attributes.put("siteURL", getSiteURL());
		attributes.put("mail", getMail());
		attributes.put("facebookURL", getFacebookURL());
		attributes.put("othersInformations", getOthersInformations());
		attributes.put("order", getOrder());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long associationId = (Long)attributes.get("associationId");

		if (associationId != null) {
			setAssociationId(associationId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String presentation = (String)attributes.get("presentation");

		if (presentation != null) {
			setPresentation(presentation);
		}

		String phone = (String)attributes.get("phone");

		if (phone != null) {
			setPhone(phone);
		}

		String siteURL = (String)attributes.get("siteURL");

		if (siteURL != null) {
			setSiteURL(siteURL);
		}

		String mail = (String)attributes.get("mail");

		if (mail != null) {
			setMail(mail);
		}

		String facebookURL = (String)attributes.get("facebookURL");

		if (facebookURL != null) {
			setFacebookURL(facebookURL);
		}

		String othersInformations = (String)attributes.get(
			"othersInformations");

		if (othersInformations != null) {
			setOthersInformations(othersInformations);
		}

		Integer order = (Integer)attributes.get("order");

		if (order != null) {
			setOrder(order);
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
	}

	@Override
	public Association cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Retourne l'AssetEntry rattaché à cette entité
	 */
	@Override
	public com.liferay.asset.kernel.model.AssetEntry getAssetEntry() {
		return model.getAssetEntry();
	}

	/**
	 * Returns the association ID of this association.
	 *
	 * @return the association ID of this association
	 */
	@Override
	public long getAssociationId() {
		return model.getAssociationId();
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
	 * Returns the company ID of this association.
	 *
	 * @return the company ID of this association
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this association.
	 *
	 * @return the create date of this association
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
	 * Returns the facebook url of this association.
	 *
	 * @return the facebook url of this association
	 */
	@Override
	public String getFacebookURL() {
		return model.getFacebookURL();
	}

	/**
	 * Returns the localized facebook url of this association in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized facebook url of this association
	 */
	@Override
	public String getFacebookURL(java.util.Locale locale) {
		return model.getFacebookURL(locale);
	}

	/**
	 * Returns the localized facebook url of this association in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized facebook url of this association. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getFacebookURL(java.util.Locale locale, boolean useDefault) {
		return model.getFacebookURL(locale, useDefault);
	}

	/**
	 * Returns the localized facebook url of this association in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized facebook url of this association
	 */
	@Override
	public String getFacebookURL(String languageId) {
		return model.getFacebookURL(languageId);
	}

	/**
	 * Returns the localized facebook url of this association in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized facebook url of this association
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
	 * Returns a map of the locales and localized facebook urls of this association.
	 *
	 * @return the locales and localized facebook urls of this association
	 */
	@Override
	public Map<java.util.Locale, String> getFacebookURLMap() {
		return model.getFacebookURLMap();
	}

	/**
	 * Returns the group ID of this association.
	 *
	 * @return the group ID of this association
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Retourne la version live de cette entité
	 */
	@Override
	public eu.strasbourg.service.activity.model.Association getLiveVersion() {
		return model.getLiveVersion();
	}

	/**
	 * Returns the mail of this association.
	 *
	 * @return the mail of this association
	 */
	@Override
	public String getMail() {
		return model.getMail();
	}

	/**
	 * Returns the modified date of this association.
	 *
	 * @return the modified date of this association
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this association.
	 *
	 * @return the name of this association
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the localized name of this association in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized name of this association
	 */
	@Override
	public String getName(java.util.Locale locale) {
		return model.getName(locale);
	}

	/**
	 * Returns the localized name of this association in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this association. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getName(java.util.Locale locale, boolean useDefault) {
		return model.getName(locale, useDefault);
	}

	/**
	 * Returns the localized name of this association in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized name of this association
	 */
	@Override
	public String getName(String languageId) {
		return model.getName(languageId);
	}

	/**
	 * Returns the localized name of this association in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this association
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
	 * Returns a map of the locales and localized names of this association.
	 *
	 * @return the locales and localized names of this association
	 */
	@Override
	public Map<java.util.Locale, String> getNameMap() {
		return model.getNameMap();
	}

	/**
	 * Returns the order of this association.
	 *
	 * @return the order of this association
	 */
	@Override
	public int getOrder() {
		return model.getOrder();
	}

	/**
	 * Returns the others informations of this association.
	 *
	 * @return the others informations of this association
	 */
	@Override
	public String getOthersInformations() {
		return model.getOthersInformations();
	}

	/**
	 * Returns the localized others informations of this association in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized others informations of this association
	 */
	@Override
	public String getOthersInformations(java.util.Locale locale) {
		return model.getOthersInformations(locale);
	}

	/**
	 * Returns the localized others informations of this association in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized others informations of this association. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getOthersInformations(
		java.util.Locale locale, boolean useDefault) {

		return model.getOthersInformations(locale, useDefault);
	}

	/**
	 * Returns the localized others informations of this association in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized others informations of this association
	 */
	@Override
	public String getOthersInformations(String languageId) {
		return model.getOthersInformations(languageId);
	}

	/**
	 * Returns the localized others informations of this association in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized others informations of this association
	 */
	@Override
	public String getOthersInformations(String languageId, boolean useDefault) {
		return model.getOthersInformations(languageId, useDefault);
	}

	@Override
	public String getOthersInformationsCurrentLanguageId() {
		return model.getOthersInformationsCurrentLanguageId();
	}

	@Override
	public String getOthersInformationsCurrentValue() {
		return model.getOthersInformationsCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized others informationses of this association.
	 *
	 * @return the locales and localized others informationses of this association
	 */
	@Override
	public Map<java.util.Locale, String> getOthersInformationsMap() {
		return model.getOthersInformationsMap();
	}

	/**
	 * Returns the phone of this association.
	 *
	 * @return the phone of this association
	 */
	@Override
	public String getPhone() {
		return model.getPhone();
	}

	/**
	 * Retourne les activités de l'association
	 */
	@Override
	public java.util.List<eu.strasbourg.service.activity.model.Practice>
		getPractices() {

		return model.getPractices();
	}

	/**
	 * Retourne les catégories des activités triées par domaine de l'association
	 */
	@Override
	public java.util.List
		<eu.strasbourg.service.activity.model.PracticeCategories>
			getPracticesCategories() {

		return model.getPracticesCategories();
	}

	/**
	 * Returns the presentation of this association.
	 *
	 * @return the presentation of this association
	 */
	@Override
	public String getPresentation() {
		return model.getPresentation();
	}

	/**
	 * Returns the localized presentation of this association in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized presentation of this association
	 */
	@Override
	public String getPresentation(java.util.Locale locale) {
		return model.getPresentation(locale);
	}

	/**
	 * Returns the localized presentation of this association in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized presentation of this association. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getPresentation(java.util.Locale locale, boolean useDefault) {
		return model.getPresentation(locale, useDefault);
	}

	/**
	 * Returns the localized presentation of this association in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized presentation of this association
	 */
	@Override
	public String getPresentation(String languageId) {
		return model.getPresentation(languageId);
	}

	/**
	 * Returns the localized presentation of this association in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized presentation of this association
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
	 * Returns a map of the locales and localized presentations of this association.
	 *
	 * @return the locales and localized presentations of this association
	 */
	@Override
	public Map<java.util.Locale, String> getPresentationMap() {
		return model.getPresentationMap();
	}

	/**
	 * Returns the primary key of this association.
	 *
	 * @return the primary key of this association
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the site url of this association.
	 *
	 * @return the site url of this association
	 */
	@Override
	public String getSiteURL() {
		return model.getSiteURL();
	}

	/**
	 * Returns the localized site url of this association in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized site url of this association
	 */
	@Override
	public String getSiteURL(java.util.Locale locale) {
		return model.getSiteURL(locale);
	}

	/**
	 * Returns the localized site url of this association in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized site url of this association. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getSiteURL(java.util.Locale locale, boolean useDefault) {
		return model.getSiteURL(locale, useDefault);
	}

	/**
	 * Returns the localized site url of this association in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized site url of this association
	 */
	@Override
	public String getSiteURL(String languageId) {
		return model.getSiteURL(languageId);
	}

	/**
	 * Returns the localized site url of this association in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized site url of this association
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
	 * Returns a map of the locales and localized site urls of this association.
	 *
	 * @return the locales and localized site urls of this association
	 */
	@Override
	public Map<java.util.Locale, String> getSiteURLMap() {
		return model.getSiteURLMap();
	}

	/**
	 * Returns the status of this association.
	 *
	 * @return the status of this association
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this association.
	 *
	 * @return the status by user ID of this association
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this association.
	 *
	 * @return the status by user name of this association
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this association.
	 *
	 * @return the status by user uuid of this association
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this association.
	 *
	 * @return the status date of this association
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Retourne les territoires de l'association
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getTerritories() {

		return model.getTerritories();
	}

	/**
	 * Returns the user ID of this association.
	 *
	 * @return the user ID of this association
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this association.
	 *
	 * @return the user name of this association
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this association.
	 *
	 * @return the user uuid of this association
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this association.
	 *
	 * @return the uuid of this association
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this association is approved.
	 *
	 * @return <code>true</code> if this association is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this association is denied.
	 *
	 * @return <code>true</code> if this association is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this association is a draft.
	 *
	 * @return <code>true</code> if this association is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this association is expired.
	 *
	 * @return <code>true</code> if this association is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this association is inactive.
	 *
	 * @return <code>true</code> if this association is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this association is incomplete.
	 *
	 * @return <code>true</code> if this association is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this association is pending.
	 *
	 * @return <code>true</code> if this association is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this association is scheduled.
	 *
	 * @return <code>true</code> if this association is scheduled; <code>false</code> otherwise
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
	 * Sets the association ID of this association.
	 *
	 * @param associationId the association ID of this association
	 */
	@Override
	public void setAssociationId(long associationId) {
		model.setAssociationId(associationId);
	}

	/**
	 * Sets the company ID of this association.
	 *
	 * @param companyId the company ID of this association
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this association.
	 *
	 * @param createDate the create date of this association
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the facebook url of this association.
	 *
	 * @param facebookURL the facebook url of this association
	 */
	@Override
	public void setFacebookURL(String facebookURL) {
		model.setFacebookURL(facebookURL);
	}

	/**
	 * Sets the localized facebook url of this association in the language.
	 *
	 * @param facebookURL the localized facebook url of this association
	 * @param locale the locale of the language
	 */
	@Override
	public void setFacebookURL(String facebookURL, java.util.Locale locale) {
		model.setFacebookURL(facebookURL, locale);
	}

	/**
	 * Sets the localized facebook url of this association in the language, and sets the default locale.
	 *
	 * @param facebookURL the localized facebook url of this association
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
	 * Sets the localized facebook urls of this association from the map of locales and localized facebook urls.
	 *
	 * @param facebookURLMap the locales and localized facebook urls of this association
	 */
	@Override
	public void setFacebookURLMap(
		Map<java.util.Locale, String> facebookURLMap) {

		model.setFacebookURLMap(facebookURLMap);
	}

	/**
	 * Sets the localized facebook urls of this association from the map of locales and localized facebook urls, and sets the default locale.
	 *
	 * @param facebookURLMap the locales and localized facebook urls of this association
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setFacebookURLMap(
		Map<java.util.Locale, String> facebookURLMap,
		java.util.Locale defaultLocale) {

		model.setFacebookURLMap(facebookURLMap, defaultLocale);
	}

	/**
	 * Sets the group ID of this association.
	 *
	 * @param groupId the group ID of this association
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the mail of this association.
	 *
	 * @param mail the mail of this association
	 */
	@Override
	public void setMail(String mail) {
		model.setMail(mail);
	}

	/**
	 * Sets the modified date of this association.
	 *
	 * @param modifiedDate the modified date of this association
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this association.
	 *
	 * @param name the name of this association
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the localized name of this association in the language.
	 *
	 * @param name the localized name of this association
	 * @param locale the locale of the language
	 */
	@Override
	public void setName(String name, java.util.Locale locale) {
		model.setName(name, locale);
	}

	/**
	 * Sets the localized name of this association in the language, and sets the default locale.
	 *
	 * @param name the localized name of this association
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
	 * Sets the localized names of this association from the map of locales and localized names.
	 *
	 * @param nameMap the locales and localized names of this association
	 */
	@Override
	public void setNameMap(Map<java.util.Locale, String> nameMap) {
		model.setNameMap(nameMap);
	}

	/**
	 * Sets the localized names of this association from the map of locales and localized names, and sets the default locale.
	 *
	 * @param nameMap the locales and localized names of this association
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setNameMap(
		Map<java.util.Locale, String> nameMap, java.util.Locale defaultLocale) {

		model.setNameMap(nameMap, defaultLocale);
	}

	/**
	 * Sets the order of this association.
	 *
	 * @param order the order of this association
	 */
	@Override
	public void setOrder(int order) {
		model.setOrder(order);
	}

	/**
	 * Sets the others informations of this association.
	 *
	 * @param othersInformations the others informations of this association
	 */
	@Override
	public void setOthersInformations(String othersInformations) {
		model.setOthersInformations(othersInformations);
	}

	/**
	 * Sets the localized others informations of this association in the language.
	 *
	 * @param othersInformations the localized others informations of this association
	 * @param locale the locale of the language
	 */
	@Override
	public void setOthersInformations(
		String othersInformations, java.util.Locale locale) {

		model.setOthersInformations(othersInformations, locale);
	}

	/**
	 * Sets the localized others informations of this association in the language, and sets the default locale.
	 *
	 * @param othersInformations the localized others informations of this association
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setOthersInformations(
		String othersInformations, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setOthersInformations(othersInformations, locale, defaultLocale);
	}

	@Override
	public void setOthersInformationsCurrentLanguageId(String languageId) {
		model.setOthersInformationsCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized others informationses of this association from the map of locales and localized others informationses.
	 *
	 * @param othersInformationsMap the locales and localized others informationses of this association
	 */
	@Override
	public void setOthersInformationsMap(
		Map<java.util.Locale, String> othersInformationsMap) {

		model.setOthersInformationsMap(othersInformationsMap);
	}

	/**
	 * Sets the localized others informationses of this association from the map of locales and localized others informationses, and sets the default locale.
	 *
	 * @param othersInformationsMap the locales and localized others informationses of this association
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setOthersInformationsMap(
		Map<java.util.Locale, String> othersInformationsMap,
		java.util.Locale defaultLocale) {

		model.setOthersInformationsMap(othersInformationsMap, defaultLocale);
	}

	/**
	 * Sets the phone of this association.
	 *
	 * @param phone the phone of this association
	 */
	@Override
	public void setPhone(String phone) {
		model.setPhone(phone);
	}

	/**
	 * Sets the presentation of this association.
	 *
	 * @param presentation the presentation of this association
	 */
	@Override
	public void setPresentation(String presentation) {
		model.setPresentation(presentation);
	}

	/**
	 * Sets the localized presentation of this association in the language.
	 *
	 * @param presentation the localized presentation of this association
	 * @param locale the locale of the language
	 */
	@Override
	public void setPresentation(String presentation, java.util.Locale locale) {
		model.setPresentation(presentation, locale);
	}

	/**
	 * Sets the localized presentation of this association in the language, and sets the default locale.
	 *
	 * @param presentation the localized presentation of this association
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
	 * Sets the localized presentations of this association from the map of locales and localized presentations.
	 *
	 * @param presentationMap the locales and localized presentations of this association
	 */
	@Override
	public void setPresentationMap(
		Map<java.util.Locale, String> presentationMap) {

		model.setPresentationMap(presentationMap);
	}

	/**
	 * Sets the localized presentations of this association from the map of locales and localized presentations, and sets the default locale.
	 *
	 * @param presentationMap the locales and localized presentations of this association
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setPresentationMap(
		Map<java.util.Locale, String> presentationMap,
		java.util.Locale defaultLocale) {

		model.setPresentationMap(presentationMap, defaultLocale);
	}

	/**
	 * Sets the primary key of this association.
	 *
	 * @param primaryKey the primary key of this association
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the site url of this association.
	 *
	 * @param siteURL the site url of this association
	 */
	@Override
	public void setSiteURL(String siteURL) {
		model.setSiteURL(siteURL);
	}

	/**
	 * Sets the localized site url of this association in the language.
	 *
	 * @param siteURL the localized site url of this association
	 * @param locale the locale of the language
	 */
	@Override
	public void setSiteURL(String siteURL, java.util.Locale locale) {
		model.setSiteURL(siteURL, locale);
	}

	/**
	 * Sets the localized site url of this association in the language, and sets the default locale.
	 *
	 * @param siteURL the localized site url of this association
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
	 * Sets the localized site urls of this association from the map of locales and localized site urls.
	 *
	 * @param siteURLMap the locales and localized site urls of this association
	 */
	@Override
	public void setSiteURLMap(Map<java.util.Locale, String> siteURLMap) {
		model.setSiteURLMap(siteURLMap);
	}

	/**
	 * Sets the localized site urls of this association from the map of locales and localized site urls, and sets the default locale.
	 *
	 * @param siteURLMap the locales and localized site urls of this association
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setSiteURLMap(
		Map<java.util.Locale, String> siteURLMap,
		java.util.Locale defaultLocale) {

		model.setSiteURLMap(siteURLMap, defaultLocale);
	}

	/**
	 * Sets the status of this association.
	 *
	 * @param status the status of this association
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this association.
	 *
	 * @param statusByUserId the status by user ID of this association
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this association.
	 *
	 * @param statusByUserName the status by user name of this association
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this association.
	 *
	 * @param statusByUserUuid the status by user uuid of this association
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this association.
	 *
	 * @param statusDate the status date of this association
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the user ID of this association.
	 *
	 * @param userId the user ID of this association
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this association.
	 *
	 * @param userName the user name of this association
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this association.
	 *
	 * @param userUuid the user uuid of this association
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this association.
	 *
	 * @param uuid the uuid of this association
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
	protected AssociationWrapper wrap(Association association) {
		return new AssociationWrapper(association);
	}

}