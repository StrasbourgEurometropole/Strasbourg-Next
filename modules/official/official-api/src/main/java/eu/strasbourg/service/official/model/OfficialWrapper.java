/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.official.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Official}.
 * </p>
 *
 * @author AngeliqueZUNINO
 * @see Official
 * @generated
 */
public class OfficialWrapper
	extends BaseModelWrapper<Official>
	implements ModelWrapper<Official>, Official {

	public OfficialWrapper(Official official) {
		super(official);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("officialId", getOfficialId());
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
		attributes.put("gender", getGender());
		attributes.put("lastName", getLastName());
		attributes.put("firstName", getFirstName());
		attributes.put("thematicDelegation", getThematicDelegation());
		attributes.put("missions", getMissions());
		attributes.put("wasMinister", isWasMinister());
		attributes.put("contact", getContact());
		attributes.put("orderDeputyMayor", getOrderDeputyMayor());
		attributes.put("orderVicePresident", getOrderVicePresident());
		attributes.put("listeContact", getListeContact());
		attributes.put("resumeFonction", getResumeFonction());
		attributes.put("imageId", getImageId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long officialId = (Long)attributes.get("officialId");

		if (officialId != null) {
			setOfficialId(officialId);
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

		Integer gender = (Integer)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String thematicDelegation = (String)attributes.get(
			"thematicDelegation");

		if (thematicDelegation != null) {
			setThematicDelegation(thematicDelegation);
		}

		String missions = (String)attributes.get("missions");

		if (missions != null) {
			setMissions(missions);
		}

		Boolean wasMinister = (Boolean)attributes.get("wasMinister");

		if (wasMinister != null) {
			setWasMinister(wasMinister);
		}

		String contact = (String)attributes.get("contact");

		if (contact != null) {
			setContact(contact);
		}

		Integer orderDeputyMayor = (Integer)attributes.get("orderDeputyMayor");

		if (orderDeputyMayor != null) {
			setOrderDeputyMayor(orderDeputyMayor);
		}

		Integer orderVicePresident = (Integer)attributes.get(
			"orderVicePresident");

		if (orderVicePresident != null) {
			setOrderVicePresident(orderVicePresident);
		}

		String listeContact = (String)attributes.get("listeContact");

		if (listeContact != null) {
			setListeContact(listeContact);
		}

		String resumeFonction = (String)attributes.get("resumeFonction");

		if (resumeFonction != null) {
			setResumeFonction(resumeFonction);
		}

		Long imageId = (Long)attributes.get("imageId");

		if (imageId != null) {
			setImageId(imageId);
		}
	}

	@Override
	public Official cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
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
	 * Renvoie la liste des AssetCategory rattachées à cet item (via
	 * l'assetEntry)
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCategories() {

		return model.getCategories();
	}

	/**
	 * Vérifie si c'est un élu eurométropolitain
	 *
	 * @throws PortalException
	 */
	@Override
	public boolean getCommunalMembership()
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.getCommunalMembership();
	}

	/**
	 * Returns the company ID of this official.
	 *
	 * @return the company ID of this official
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the contact of this official.
	 *
	 * @return the contact of this official
	 */
	@Override
	public String getContact() {
		return model.getContact();
	}

	/**
	 * Returns the localized contact of this official in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized contact of this official
	 */
	@Override
	public String getContact(java.util.Locale locale) {
		return model.getContact(locale);
	}

	/**
	 * Returns the localized contact of this official in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized contact of this official. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getContact(java.util.Locale locale, boolean useDefault) {
		return model.getContact(locale, useDefault);
	}

	/**
	 * Returns the localized contact of this official in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized contact of this official
	 */
	@Override
	public String getContact(String languageId) {
		return model.getContact(languageId);
	}

	/**
	 * Returns the localized contact of this official in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized contact of this official
	 */
	@Override
	public String getContact(String languageId, boolean useDefault) {
		return model.getContact(languageId, useDefault);
	}

	@Override
	public String getContactCurrentLanguageId() {
		return model.getContactCurrentLanguageId();
	}

	@Override
	public String getContactCurrentValue() {
		return model.getContactCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized contacts of this official.
	 *
	 * @return the locales and localized contacts of this official
	 */
	@Override
	public Map<java.util.Locale, String> getContactMap() {
		return model.getContactMap();
	}

	/**
	 * Returns the create date of this official.
	 *
	 * @return the create date of this official
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
	 * Retourne la liste des quartiers correspondants à l'élu
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getDistricts() {

		return model.getDistricts();
	}

	/**
	 * Returns the first name of this official.
	 *
	 * @return the first name of this official
	 */
	@Override
	public String getFirstName() {
		return model.getFirstName();
	}

	/**
	 * Retourne l' id catégorie Fonction ville correspondant à l'élu
	 */
	@Override
	public com.liferay.asset.kernel.model.AssetCategory getFonctionCity() {
		return model.getFonctionCity();
	}

	/**
	 * Retourne la catégorie Fonction eurometropole correspondant à l'élu
	 */
	@Override
	public com.liferay.asset.kernel.model.AssetCategory
		getFonctionEurometropole() {

		return model.getFonctionEurometropole();
	}

	/**
	 * Retourne la catégorie Fonction commune correspondant à l'élu
	 */
	@Override
	public com.liferay.asset.kernel.model.AssetCategory getFonctionTown() {
		return model.getFonctionTown();
	}

	/**
	 * Returns the gender of this official.
	 *
	 * @return the gender of this official
	 */
	@Override
	public int getGender() {
		return model.getGender();
	}

	/**
	 * Returns the group ID of this official.
	 *
	 * @return the group ID of this official
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the image ID of this official.
	 *
	 * @return the image ID of this official
	 */
	@Override
	public Long getImageId() {
		return model.getImageId();
	}

	/**
	 * Renvoie l'URL de l'image à partir de l'id du DLFileEntry
	 */
	@Override
	public String getImageURL() {
		return model.getImageURL();
	}

	/**
	 * Returns the last name of this official.
	 *
	 * @return the last name of this official
	 */
	@Override
	public String getLastName() {
		return model.getLastName();
	}

	/**
	 * Returns the last publish date of this official.
	 *
	 * @return the last publish date of this official
	 */
	@Override
	public Date getLastPublishDate() {
		return model.getLastPublishDate();
	}

	/**
	 * Returns the liste contact of this official.
	 *
	 * @return the liste contact of this official
	 */
	@Override
	public String getListeContact() {
		return model.getListeContact();
	}

	/**
	 * Returns the liste contact of this official.
	 *
	 * @return the liste contact of this official
	 */
	@Override
	public String getListeContact() {
		return _official.getListeContact();
	}

	/**
	 * Renvoie la version live de l'élu, si il existe
	 */
	@Override
	public eu.strasbourg.service.official.model.Official getLiveVersion() {
		return model.getLiveVersion();
	}

	/**
	 * Returns the missions of this official.
	 *
	 * @return the missions of this official
	 */
	@Override
	public String getMissions() {
		return model.getMissions();
	}

	/**
	 * Returns the localized missions of this official in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized missions of this official
	 */
	@Override
	public String getMissions(java.util.Locale locale) {
		return model.getMissions(locale);
	}

	/**
	 * Returns the localized missions of this official in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized missions of this official. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getMissions(java.util.Locale locale, boolean useDefault) {
		return model.getMissions(locale, useDefault);
	}

	/**
	 * Returns the localized missions of this official in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized missions of this official
	 */
	@Override
	public String getMissions(String languageId) {
		return model.getMissions(languageId);
	}

	/**
	 * Returns the localized missions of this official in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized missions of this official
	 */
	@Override
	public String getMissions(String languageId, boolean useDefault) {
		return model.getMissions(languageId, useDefault);
	}

	@Override
	public String getMissionsCurrentLanguageId() {
		return model.getMissionsCurrentLanguageId();
	}

	@Override
	public String getMissionsCurrentValue() {
		return model.getMissionsCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized missionses of this official.
	 *
	 * @return the locales and localized missionses of this official
	 */
	@Override
	public Map<java.util.Locale, String> getMissionsMap() {
		return model.getMissionsMap();
	}

	/**
	 * Returns the modified date of this official.
	 *
	 * @return the modified date of this official
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Retourne le nom féminin/masculin de la catégorie
	 *
	 * @throws PortalException
	 */
	@Override
	public String getName(
			com.liferay.asset.kernel.model.AssetCategory category,
			java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.getName(category, locale);
	}

	/**
	 * Returns the official ID of this official.
	 *
	 * @return the official ID of this official
	 */
	@Override
	public long getOfficialId() {
		return model.getOfficialId();
	}

	/**
	 * Returns the order deputy mayor of this official.
	 *
	 * @return the order deputy mayor of this official
	 */
	@Override
	public int getOrderDeputyMayor() {
		return model.getOrderDeputyMayor();
	}

	/**
	 * Returns the order vice president of this official.
	 *
	 * @return the order vice president of this official
	 */
	@Override
	public int getOrderVicePresident() {
		return model.getOrderVicePresident();
	}

	/**
	 * Retourne la catégorie Autres mandats correspondant à l'élu
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getOthersMandates() {

		return model.getOthersMandates();
	}

	/**
	 * Retourne la catégorie Groupe Politique ville correspondant à l'élu
	 */
	@Override
	public com.liferay.asset.kernel.model.AssetCategory
		getPoliticalGroupCity() {

		return model.getPoliticalGroupCity();
	}

	/**
	 * Retourne la catégorie Groupe Politique eurométropole correspondant à
	 * l'élu
	 */
	@Override
	public com.liferay.asset.kernel.model.AssetCategory
		getPoliticalGroupEurometropole() {

		return model.getPoliticalGroupEurometropole();
	}

	/**
	 * Returns the primary key of this official.
	 *
	 * @return the primary key of this official
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the resume fonction of this official.
	 *
	 * @return the resume fonction of this official
	 */
	@Override
	public String getResumeFonction() {
		return model.getResumeFonction();
	}

	/**
	 * Returns the localized resume fonction of this official in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized resume fonction of this official
	 */
	@Override
	public String getResumeFonction(java.util.Locale locale) {
		return model.getResumeFonction(locale);
	}

	/**
	 * Returns the localized resume fonction of this official in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized resume fonction of this official. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getResumeFonction(
		java.util.Locale locale, boolean useDefault) {

		return model.getResumeFonction(locale, useDefault);
	}

	/**
	 * Returns the localized resume fonction of this official in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized resume fonction of this official
	 */
	@Override
	public String getResumeFonction(String languageId) {
		return model.getResumeFonction(languageId);
	}

	/**
	 * Returns the localized resume fonction of this official in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized resume fonction of this official
	 */
	@Override
	public String getResumeFonction(String languageId, boolean useDefault) {
		return model.getResumeFonction(languageId, useDefault);
	}

	@Override
	public String getResumeFonctionCurrentLanguageId() {
		return model.getResumeFonctionCurrentLanguageId();
	}

	@Override
	public String getResumeFonctionCurrentValue() {
		return model.getResumeFonctionCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized resume fonctions of this official.
	 *
	 * @return the locales and localized resume fonctions of this official
	 */
	@Override
	public Map<java.util.Locale, String> getResumeFonctionMap() {
		return model.getResumeFonctionMap();
	}

	/**
	 * Returns the resume fonction of this official.
	 *
	 * @return the resume fonction of this official
	 */
	@Override
	public String getResumeFonction() {
		return _official.getResumeFonction();
	}

	/**
	 * Returns the localized resume fonction of this official in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized resume fonction of this official
	 */
	@Override
	public String getResumeFonction(java.util.Locale locale) {
		return _official.getResumeFonction(locale);
	}

	/**
	 * Returns the localized resume fonction of this official in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized resume fonction of this official. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getResumeFonction(
		java.util.Locale locale, boolean useDefault) {

		return _official.getResumeFonction(locale, useDefault);
	}

	/**
	 * Returns the localized resume fonction of this official in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized resume fonction of this official
	 */
	@Override
	public String getResumeFonction(String languageId) {
		return _official.getResumeFonction(languageId);
	}

	/**
	 * Returns the localized resume fonction of this official in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized resume fonction of this official
	 */
	@Override
	public String getResumeFonction(String languageId, boolean useDefault) {
		return _official.getResumeFonction(languageId, useDefault);
	}

	@Override
	public String getResumeFonctionCurrentLanguageId() {
		return _official.getResumeFonctionCurrentLanguageId();
	}

	@Override
	public String getResumeFonctionCurrentValue() {
		return _official.getResumeFonctionCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized resume fonctions of this official.
	 *
	 * @return the locales and localized resume fonctions of this official
	 */
	@Override
	public Map<java.util.Locale, String> getResumeFonctionMap() {
		return _official.getResumeFonctionMap();
	}

	/**
	 * Returns the status of this official.
	 *
	 * @return the status of this official
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this official.
	 *
	 * @return the status by user ID of this official
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this official.
	 *
	 * @return the status by user name of this official
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this official.
	 *
	 * @return the status by user uuid of this official
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this official.
	 *
	 * @return the status date of this official
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Retourne les territoires du lieu
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getTerritories() {

		return model.getTerritories();
	}

	/**
	 * Returns the thematic delegation of this official.
	 *
	 * @return the thematic delegation of this official
	 */
	@Override
	public String getThematicDelegation() {
		return model.getThematicDelegation();
	}

	/**
	 * Returns the localized thematic delegation of this official in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized thematic delegation of this official
	 */
	@Override
	public String getThematicDelegation(java.util.Locale locale) {
		return model.getThematicDelegation(locale);
	}

	/**
	 * Returns the localized thematic delegation of this official in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized thematic delegation of this official. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getThematicDelegation(
		java.util.Locale locale, boolean useDefault) {

		return model.getThematicDelegation(locale, useDefault);
	}

	/**
	 * Returns the localized thematic delegation of this official in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized thematic delegation of this official
	 */
	@Override
	public String getThematicDelegation(String languageId) {
		return model.getThematicDelegation(languageId);
	}

	/**
	 * Returns the localized thematic delegation of this official in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized thematic delegation of this official
	 */
	@Override
	public String getThematicDelegation(String languageId, boolean useDefault) {
		return model.getThematicDelegation(languageId, useDefault);
	}

	@Override
	public String getThematicDelegationCurrentLanguageId() {
		return model.getThematicDelegationCurrentLanguageId();
	}

	@Override
	public String getThematicDelegationCurrentValue() {
		return model.getThematicDelegationCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized thematic delegations of this official.
	 *
	 * @return the locales and localized thematic delegations of this official
	 */
	@Override
	public Map<java.util.Locale, String> getThematicDelegationMap() {
		return model.getThematicDelegationMap();
	}

	/**
	 * Retourne la commune correspondants à l'élu
	 */
	@Override
	public com.liferay.asset.kernel.model.AssetCategory getTown() {
		return model.getTown();
	}

	/**
	 * Returns the user ID of this official.
	 *
	 * @return the user ID of this official
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this official.
	 *
	 * @return the user name of this official
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this official.
	 *
	 * @return the user uuid of this official
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this official.
	 *
	 * @return the uuid of this official
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the was minister of this official.
	 *
	 * @return the was minister of this official
	 */
	@Override
	public boolean getWasMinister() {
		return model.getWasMinister();
	}

	/**
	 * Returns <code>true</code> if this official is approved.
	 *
	 * @return <code>true</code> if this official is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Vérifie si c'est un élu municipal
	 *
	 * @throws PortalException
	 */
	@Override
	public boolean isAssistant()
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.isAssistant();
	}

	/**
	 * Vérifie si la catégorie fait parti des catégories correspondants à l'élu
	 */
	@Override
	public boolean isCategoryOfficial(long categoryId) {
		return model.isCategoryOfficial(categoryId);
	}

	/**
	 * Returns <code>true</code> if this official is denied.
	 *
	 * @return <code>true</code> if this official is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this official is a draft.
	 *
	 * @return <code>true</code> if this official is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Vérifie si c'est un élu eurométropolitain
	 *
	 * @throws PortalException
	 */
	@Override
	public boolean isEluEurometropole()
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.isEluEurometropole();
	}

	/**
	 * Vérifie si c'est un élu municipal
	 *
	 * @throws PortalException
	 */
	@Override
	public boolean isEluMunicipal()
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.isEluMunicipal();
	}

	/**
	 * Returns <code>true</code> if this official is expired.
	 *
	 * @return <code>true</code> if this official is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this official is inactive.
	 *
	 * @return <code>true</code> if this official is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this official is incomplete.
	 *
	 * @return <code>true</code> if this official is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this official is pending.
	 *
	 * @return <code>true</code> if this official is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this official is scheduled.
	 *
	 * @return <code>true</code> if this official is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
	}

	/**
	 * Returns <code>true</code> if this official is was minister.
	 *
	 * @return <code>true</code> if this official is was minister; <code>false</code> otherwise
	 */
	@Override
	public boolean isWasMinister() {
		return model.isWasMinister();
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
	 * Sets the company ID of this official.
	 *
	 * @param companyId the company ID of this official
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the contact of this official.
	 *
	 * @param contact the contact of this official
	 */
	@Override
	public void setContact(String contact) {
		model.setContact(contact);
	}

	/**
	 * Sets the localized contact of this official in the language.
	 *
	 * @param contact the localized contact of this official
	 * @param locale the locale of the language
	 */
	@Override
	public void setContact(String contact, java.util.Locale locale) {
		model.setContact(contact, locale);
	}

	/**
	 * Sets the localized contact of this official in the language, and sets the default locale.
	 *
	 * @param contact the localized contact of this official
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setContact(
		String contact, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setContact(contact, locale, defaultLocale);
	}

	@Override
	public void setContactCurrentLanguageId(String languageId) {
		model.setContactCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized contacts of this official from the map of locales and localized contacts.
	 *
	 * @param contactMap the locales and localized contacts of this official
	 */
	@Override
	public void setContactMap(Map<java.util.Locale, String> contactMap) {
		model.setContactMap(contactMap);
	}

	/**
	 * Sets the localized contacts of this official from the map of locales and localized contacts, and sets the default locale.
	 *
	 * @param contactMap the locales and localized contacts of this official
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setContactMap(
		Map<java.util.Locale, String> contactMap,
		java.util.Locale defaultLocale) {

		model.setContactMap(contactMap, defaultLocale);
	}

	/**
	 * Sets the create date of this official.
	 *
	 * @param createDate the create date of this official
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the first name of this official.
	 *
	 * @param firstName the first name of this official
	 */
	@Override
	public void setFirstName(String firstName) {
		model.setFirstName(firstName);
	}

	/**
	 * Sets the gender of this official.
	 *
	 * @param gender the gender of this official
	 */
	@Override
	public void setGender(int gender) {
		model.setGender(gender);
	}

	/**
	 * Sets the group ID of this official.
	 *
	 * @param groupId the group ID of this official
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the image ID of this official.
	 *
	 * @param imageId the image ID of this official
	 */
	@Override
	public void setImageId(Long imageId) {
		model.setImageId(imageId);
	}

	/**
	 * Sets the last name of this official.
	 *
	 * @param lastName the last name of this official
	 */
	@Override
	public void setLastName(String lastName) {
		model.setLastName(lastName);
	}

	/**
	 * Sets the last publish date of this official.
	 *
	 * @param lastPublishDate the last publish date of this official
	 */
	@Override
	public void setLastPublishDate(Date lastPublishDate) {
		model.setLastPublishDate(lastPublishDate);
	}

	/**
	 * Sets the liste contact of this official.
	 *
	 * @param listeContact the liste contact of this official
	 */
	@Override
	public void setListeContact(String listeContact) {
		model.setListeContact(listeContact);
	}

	/**
	 * Sets the liste contact of this official.
	 *
	 * @param listeContact the liste contact of this official
	 */
	@Override
	public void setListeContact(String listeContact) {
		_official.setListeContact(listeContact);
	}

	/**
	 * Sets the missions of this official.
	 *
	 * @param missions the missions of this official
	 */
	@Override
	public void setMissions(String missions) {
		model.setMissions(missions);
	}

	/**
	 * Sets the localized missions of this official in the language.
	 *
	 * @param missions the localized missions of this official
	 * @param locale the locale of the language
	 */
	@Override
	public void setMissions(String missions, java.util.Locale locale) {
		model.setMissions(missions, locale);
	}

	/**
	 * Sets the localized missions of this official in the language, and sets the default locale.
	 *
	 * @param missions the localized missions of this official
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setMissions(
		String missions, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setMissions(missions, locale, defaultLocale);
	}

	@Override
	public void setMissionsCurrentLanguageId(String languageId) {
		model.setMissionsCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized missionses of this official from the map of locales and localized missionses.
	 *
	 * @param missionsMap the locales and localized missionses of this official
	 */
	@Override
	public void setMissionsMap(Map<java.util.Locale, String> missionsMap) {
		model.setMissionsMap(missionsMap);
	}

	/**
	 * Sets the localized missionses of this official from the map of locales and localized missionses, and sets the default locale.
	 *
	 * @param missionsMap the locales and localized missionses of this official
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setMissionsMap(
		Map<java.util.Locale, String> missionsMap,
		java.util.Locale defaultLocale) {

		model.setMissionsMap(missionsMap, defaultLocale);
	}

	/**
	 * Sets the modified date of this official.
	 *
	 * @param modifiedDate the modified date of this official
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the official ID of this official.
	 *
	 * @param officialId the official ID of this official
	 */
	@Override
	public void setOfficialId(long officialId) {
		model.setOfficialId(officialId);
	}

	/**
	 * Sets the order deputy mayor of this official.
	 *
	 * @param orderDeputyMayor the order deputy mayor of this official
	 */
	@Override
	public void setOrderDeputyMayor(int orderDeputyMayor) {
		model.setOrderDeputyMayor(orderDeputyMayor);
	}

	/**
	 * Sets the order vice president of this official.
	 *
	 * @param orderVicePresident the order vice president of this official
	 */
	@Override
	public void setOrderVicePresident(int orderVicePresident) {
		model.setOrderVicePresident(orderVicePresident);
	}

	/**
	 * Sets the primary key of this official.
	 *
	 * @param primaryKey the primary key of this official
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the resume fonction of this official.
	 *
	 * @param resumeFonction the resume fonction of this official
	 */
	@Override
	public void setResumeFonction(String resumeFonction) {
		model.setResumeFonction(resumeFonction);
	}

	/**
	 * Sets the localized resume fonction of this official in the language.
	 *
	 * @param resumeFonction the localized resume fonction of this official
	 * @param locale the locale of the language
	 */
	@Override
	public void setResumeFonction(
		String resumeFonction, java.util.Locale locale) {

		model.setResumeFonction(resumeFonction, locale);
	}

	/**
	 * Sets the localized resume fonction of this official in the language, and sets the default locale.
	 *
	 * @param resumeFonction the localized resume fonction of this official
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setResumeFonction(
		String resumeFonction, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setResumeFonction(resumeFonction, locale, defaultLocale);
	}

	@Override
	public void setResumeFonctionCurrentLanguageId(String languageId) {
		model.setResumeFonctionCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized resume fonctions of this official from the map of locales and localized resume fonctions.
	 *
	 * @param resumeFonctionMap the locales and localized resume fonctions of this official
	 */
	@Override
	public void setResumeFonctionMap(
		Map<java.util.Locale, String> resumeFonctionMap) {

		model.setResumeFonctionMap(resumeFonctionMap);
	}

	/**
	 * Sets the localized resume fonctions of this official from the map of locales and localized resume fonctions, and sets the default locale.
	 *
	 * @param resumeFonctionMap the locales and localized resume fonctions of this official
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setResumeFonctionMap(
		Map<java.util.Locale, String> resumeFonctionMap,
		java.util.Locale defaultLocale) {

		model.setResumeFonctionMap(resumeFonctionMap, defaultLocale);
	}

	/**
	 * Sets the resume fonction of this official.
	 *
	 * @param resumeFonction the resume fonction of this official
	 */
	@Override
	public void setResumeFonction(String resumeFonction) {
		_official.setResumeFonction(resumeFonction);
	}

	/**
	 * Sets the localized resume fonction of this official in the language.
	 *
	 * @param resumeFonction the localized resume fonction of this official
	 * @param locale the locale of the language
	 */
	@Override
	public void setResumeFonction(
		String resumeFonction, java.util.Locale locale) {

		_official.setResumeFonction(resumeFonction, locale);
	}

	/**
	 * Sets the localized resume fonction of this official in the language, and sets the default locale.
	 *
	 * @param resumeFonction the localized resume fonction of this official
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setResumeFonction(
		String resumeFonction, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		_official.setResumeFonction(resumeFonction, locale, defaultLocale);
	}

	@Override
	public void setResumeFonctionCurrentLanguageId(String languageId) {
		_official.setResumeFonctionCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized resume fonctions of this official from the map of locales and localized resume fonctions.
	 *
	 * @param resumeFonctionMap the locales and localized resume fonctions of this official
	 */
	@Override
	public void setResumeFonctionMap(
		Map<java.util.Locale, String> resumeFonctionMap) {

		_official.setResumeFonctionMap(resumeFonctionMap);
	}

	/**
	 * Sets the localized resume fonctions of this official from the map of locales and localized resume fonctions, and sets the default locale.
	 *
	 * @param resumeFonctionMap the locales and localized resume fonctions of this official
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setResumeFonctionMap(
		Map<java.util.Locale, String> resumeFonctionMap,
		java.util.Locale defaultLocale) {

		_official.setResumeFonctionMap(resumeFonctionMap, defaultLocale);
	}

	/**
	 * Sets the status of this official.
	 *
	 * @param status the status of this official
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this official.
	 *
	 * @param statusByUserId the status by user ID of this official
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this official.
	 *
	 * @param statusByUserName the status by user name of this official
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this official.
	 *
	 * @param statusByUserUuid the status by user uuid of this official
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this official.
	 *
	 * @param statusDate the status date of this official
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the thematic delegation of this official.
	 *
	 * @param thematicDelegation the thematic delegation of this official
	 */
	@Override
	public void setThematicDelegation(String thematicDelegation) {
		model.setThematicDelegation(thematicDelegation);
	}

	/**
	 * Sets the localized thematic delegation of this official in the language.
	 *
	 * @param thematicDelegation the localized thematic delegation of this official
	 * @param locale the locale of the language
	 */
	@Override
	public void setThematicDelegation(
		String thematicDelegation, java.util.Locale locale) {

		model.setThematicDelegation(thematicDelegation, locale);
	}

	/**
	 * Sets the localized thematic delegation of this official in the language, and sets the default locale.
	 *
	 * @param thematicDelegation the localized thematic delegation of this official
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setThematicDelegation(
		String thematicDelegation, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setThematicDelegation(thematicDelegation, locale, defaultLocale);
	}

	@Override
	public void setThematicDelegationCurrentLanguageId(String languageId) {
		model.setThematicDelegationCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized thematic delegations of this official from the map of locales and localized thematic delegations.
	 *
	 * @param thematicDelegationMap the locales and localized thematic delegations of this official
	 */
	@Override
	public void setThematicDelegationMap(
		Map<java.util.Locale, String> thematicDelegationMap) {

		model.setThematicDelegationMap(thematicDelegationMap);
	}

	/**
	 * Sets the localized thematic delegations of this official from the map of locales and localized thematic delegations, and sets the default locale.
	 *
	 * @param thematicDelegationMap the locales and localized thematic delegations of this official
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setThematicDelegationMap(
		Map<java.util.Locale, String> thematicDelegationMap,
		java.util.Locale defaultLocale) {

		model.setThematicDelegationMap(thematicDelegationMap, defaultLocale);
	}

	/**
	 * Sets the user ID of this official.
	 *
	 * @param userId the user ID of this official
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this official.
	 *
	 * @param userName the user name of this official
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this official.
	 *
	 * @param userUuid the user uuid of this official
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this official.
	 *
	 * @param uuid the uuid of this official
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets whether this official is was minister.
	 *
	 * @param wasMinister the was minister of this official
	 */
	@Override
	public void setWasMinister(boolean wasMinister) {
		model.setWasMinister(wasMinister);
	}

	/**
	 * Retourne la version JSON de l'élu
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
	protected OfficialWrapper wrap(Official official) {
		return new OfficialWrapper(official);
	}

}