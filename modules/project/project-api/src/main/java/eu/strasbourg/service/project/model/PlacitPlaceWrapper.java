/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PlacitPlace}.
 * </p>
 *
 * @author Cedric Henry
 * @see PlacitPlace
 * @generated
 */
public class PlacitPlaceWrapper
	extends BaseModelWrapper<PlacitPlace>
	implements ModelWrapper<PlacitPlace>, PlacitPlace {

	public PlacitPlaceWrapper(PlacitPlace placitPlace) {
		super(placitPlace);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("placitPlaceId", getPlacitPlaceId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("placeName", getPlaceName());
		attributes.put("placeStreetNumber", getPlaceStreetNumber());
		attributes.put("placeStreetName", getPlaceStreetName());
		attributes.put("placeZipCode", getPlaceZipCode());
		attributes.put("placeCityId", getPlaceCityId());
		attributes.put("imageId", getImageId());
		attributes.put("projectId", getProjectId());
		attributes.put("participationId", getParticipationId());
		attributes.put("petitionId", getPetitionId());
		attributes.put("saisineObservatoireId", getSaisineObservatoireId());
		attributes.put("budgetParticipatifId", getBudgetParticipatifId());
		attributes.put("initiativeId", getInitiativeId());
		attributes.put("placeSIGId", getPlaceSIGId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long placitPlaceId = (Long)attributes.get("placitPlaceId");

		if (placitPlaceId != null) {
			setPlacitPlaceId(placitPlaceId);
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

		Long imageId = (Long)attributes.get("imageId");

		if (imageId != null) {
			setImageId(imageId);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}

		Long participationId = (Long)attributes.get("participationId");

		if (participationId != null) {
			setParticipationId(participationId);
		}

		Long petitionId = (Long)attributes.get("petitionId");

		if (petitionId != null) {
			setPetitionId(petitionId);
		}

		Long saisineObservatoireId = (Long)attributes.get(
			"saisineObservatoireId");

		if (saisineObservatoireId != null) {
			setSaisineObservatoireId(saisineObservatoireId);
		}

		Long budgetParticipatifId = (Long)attributes.get(
			"budgetParticipatifId");

		if (budgetParticipatifId != null) {
			setBudgetParticipatifId(budgetParticipatifId);
		}

		Long initiativeId = (Long)attributes.get("initiativeId");

		if (initiativeId != null) {
			setInitiativeId(initiativeId);
		}

		String placeSIGId = (String)attributes.get("placeSIGId");

		if (placeSIGId != null) {
			setPlaceSIGId(placeSIGId);
		}
	}

	@Override
	public PlacitPlace cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Retourne l'adresse (num + rue) du lieu SIG ou "manuel"
	 */
	@Override
	public String getAddress() {
		return model.getAddress();
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
	 * Returns the budget participatif ID of this placit place.
	 *
	 * @return the budget participatif ID of this placit place
	 */
	@Override
	public long getBudgetParticipatifId() {
		return model.getBudgetParticipatifId();
	}

	/**
	 * Retourne la liste des AssetCategory rattachées à cette entité (via
	 * l'assetEntry)
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCategories() {

		return model.getCategories();
	}

	/**
	 * Retourne la ville du lieu SIG ou "manuel"
	 */
	@Override
	public String getCity(java.util.Locale locale) {
		return model.getCity(locale);
	}

	/**
	 * Returns the company ID of this placit place.
	 *
	 * @return the company ID of this placit place
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Retourne l'adresse complete du lieu SIG ou "manuel"
	 */
	@Override
	public String getCompleteAddress(java.util.Locale locale) {
		return model.getCompleteAddress(locale);
	}

	/**
	 * Returns the create date of this placit place.
	 *
	 * @return the create date of this placit place
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
	 * Returns the group ID of this placit place.
	 *
	 * @return the group ID of this placit place
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the image ID of this placit place.
	 *
	 * @return the image ID of this placit place
	 */
	@Override
	public long getImageId() {
		return model.getImageId();
	}

	/**
	 * Retourne l'ID de l'image du lieu SIG ou "manuel"
	 */
	@Override
	public String getImageURL() {
		return model.getImageURL();
	}

	/**
	 * Returns the initiative ID of this placit place.
	 *
	 * @return the initiative ID of this placit place
	 */
	@Override
	public long getInitiativeId() {
		return model.getInitiativeId();
	}

	/**
	 * Retourne les coordonnees mercator en axe X et Y
	 * Notes : permet de ne pas multiplier les appels
	 *
	 * @return tableau [mercatorX, mercatorY] sinon tableau vide
	 */
	@Override
	public java.util.List<String> getMercators() {
		return model.getMercators();
	}

	/**
	 * Retourne les coordonnees mercator en axe X (longitude)
	 */
	@Override
	public String getMercatorX() {
		return model.getMercatorX();
	}

	/**
	 * Retourne les coordonnees mercator en axe Y (latitude)
	 */
	@Override
	public String getMercatorY() {
		return model.getMercatorY();
	}

	/**
	 * Returns the modified date of this placit place.
	 *
	 * @return the modified date of this placit place
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Retourne la participation du lieu Placit
	 */
	@Override
	public Participation getParticipation() {
		return model.getParticipation();
	}

	/**
	 * Returns the participation ID of this placit place.
	 *
	 * @return the participation ID of this placit place
	 */
	@Override
	public long getParticipationId() {
		return model.getParticipationId();
	}

	/**
	 * Returns the petition ID of this placit place.
	 *
	 * @return the petition ID of this placit place
	 */
	@Override
	public long getPetitionId() {
		return model.getPetitionId();
	}

	/**
	 * Retourne le nom du lieu SIG ou "manuel"
	 */
	@Override
	public String getPlaceAlias(java.util.Locale locale) {
		return model.getPlaceAlias(locale);
	}

	/**
	 * Returns the place city ID of this placit place.
	 *
	 * @return the place city ID of this placit place
	 */
	@Override
	public long getPlaceCityId() {
		return model.getPlaceCityId();
	}

	/**
	 * Returns the place name of this placit place.
	 *
	 * @return the place name of this placit place
	 */
	@Override
	public String getPlaceName() {
		return model.getPlaceName();
	}

	/**
	 * Returns the localized place name of this placit place in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized place name of this placit place
	 */
	@Override
	public String getPlaceName(java.util.Locale locale) {
		return model.getPlaceName(locale);
	}

	/**
	 * Returns the localized place name of this placit place in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized place name of this placit place. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getPlaceName(java.util.Locale locale, boolean useDefault) {
		return model.getPlaceName(locale, useDefault);
	}

	/**
	 * Returns the localized place name of this placit place in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized place name of this placit place
	 */
	@Override
	public String getPlaceName(String languageId) {
		return model.getPlaceName(languageId);
	}

	/**
	 * Returns the localized place name of this placit place in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized place name of this placit place
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
	 * Returns a map of the locales and localized place names of this placit place.
	 *
	 * @return the locales and localized place names of this placit place
	 */
	@Override
	public Map<java.util.Locale, String> getPlaceNameMap() {
		return model.getPlaceNameMap();
	}

	/**
	 * Returns the place sig ID of this placit place.
	 *
	 * @return the place sig ID of this placit place
	 */
	@Override
	public String getPlaceSIGId() {
		return model.getPlaceSIGId();
	}

	/**
	 * Returns the place street name of this placit place.
	 *
	 * @return the place street name of this placit place
	 */
	@Override
	public String getPlaceStreetName() {
		return model.getPlaceStreetName();
	}

	/**
	 * Returns the place street number of this placit place.
	 *
	 * @return the place street number of this placit place
	 */
	@Override
	public String getPlaceStreetNumber() {
		return model.getPlaceStreetNumber();
	}

	/**
	 * Returns the place zip code of this placit place.
	 *
	 * @return the place zip code of this placit place
	 */
	@Override
	public String getPlaceZipCode() {
		return model.getPlaceZipCode();
	}

	/**
	 * Returns the placit place ID of this placit place.
	 *
	 * @return the placit place ID of this placit place
	 */
	@Override
	public long getPlacitPlaceId() {
		return model.getPlacitPlaceId();
	}

	/**
	 * Returns the primary key of this placit place.
	 *
	 * @return the primary key of this placit place
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Retourne le projet du lieu Placit
	 */
	@Override
	public Project getProject() {
		return model.getProject();
	}

	/**
	 * Returns the project ID of this placit place.
	 *
	 * @return the project ID of this placit place
	 */
	@Override
	public long getProjectId() {
		return model.getProjectId();
	}

	/**
	 * Returns the saisine observatoire ID of this placit place.
	 *
	 * @return the saisine observatoire ID of this placit place
	 */
	@Override
	public long getSaisineObservatoireId() {
		return model.getSaisineObservatoireId();
	}

	/**
	 * Retourne le nom du lieu SIG
	 */
	@Override
	public String getSIGPlaceAlias(java.util.Locale locale) {
		return model.getSIGPlaceAlias(locale);
	}

	/**
	 * Returns the user ID of this placit place.
	 *
	 * @return the user ID of this placit place
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this placit place.
	 *
	 * @return the user name of this placit place
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this placit place.
	 *
	 * @return the user uuid of this placit place
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this placit place.
	 *
	 * @return the uuid of this placit place
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Retourne le code postal du lieu SIG ou "manuel"
	 */
	@Override
	public String getZipCode() {
		return model.getZipCode();
	}

	/**
	 * Renvoie si le lieu placit est SIG ou manuel
	 *
	 * @return True : lieu SIG ; False : lieu manuel
	 */
	@Override
	public boolean isSIG() {
		return model.isSIG();
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
	 * Sets the budget participatif ID of this placit place.
	 *
	 * @param budgetParticipatifId the budget participatif ID of this placit place
	 */
	@Override
	public void setBudgetParticipatifId(long budgetParticipatifId) {
		model.setBudgetParticipatifId(budgetParticipatifId);
	}

	/**
	 * Sets the company ID of this placit place.
	 *
	 * @param companyId the company ID of this placit place
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this placit place.
	 *
	 * @param createDate the create date of this placit place
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this placit place.
	 *
	 * @param groupId the group ID of this placit place
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the image ID of this placit place.
	 *
	 * @param imageId the image ID of this placit place
	 */
	@Override
	public void setImageId(long imageId) {
		model.setImageId(imageId);
	}

	/**
	 * Sets the initiative ID of this placit place.
	 *
	 * @param initiativeId the initiative ID of this placit place
	 */
	@Override
	public void setInitiativeId(long initiativeId) {
		model.setInitiativeId(initiativeId);
	}

	/**
	 * Sets the modified date of this placit place.
	 *
	 * @param modifiedDate the modified date of this placit place
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the participation ID of this placit place.
	 *
	 * @param participationId the participation ID of this placit place
	 */
	@Override
	public void setParticipationId(long participationId) {
		model.setParticipationId(participationId);
	}

	/**
	 * Sets the petition ID of this placit place.
	 *
	 * @param petitionId the petition ID of this placit place
	 */
	@Override
	public void setPetitionId(long petitionId) {
		model.setPetitionId(petitionId);
	}

	/**
	 * Sets the place city ID of this placit place.
	 *
	 * @param placeCityId the place city ID of this placit place
	 */
	@Override
	public void setPlaceCityId(long placeCityId) {
		model.setPlaceCityId(placeCityId);
	}

	/**
	 * Sets the place name of this placit place.
	 *
	 * @param placeName the place name of this placit place
	 */
	@Override
	public void setPlaceName(String placeName) {
		model.setPlaceName(placeName);
	}

	/**
	 * Sets the localized place name of this placit place in the language.
	 *
	 * @param placeName the localized place name of this placit place
	 * @param locale the locale of the language
	 */
	@Override
	public void setPlaceName(String placeName, java.util.Locale locale) {
		model.setPlaceName(placeName, locale);
	}

	/**
	 * Sets the localized place name of this placit place in the language, and sets the default locale.
	 *
	 * @param placeName the localized place name of this placit place
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
	 * Sets the localized place names of this placit place from the map of locales and localized place names.
	 *
	 * @param placeNameMap the locales and localized place names of this placit place
	 */
	@Override
	public void setPlaceNameMap(Map<java.util.Locale, String> placeNameMap) {
		model.setPlaceNameMap(placeNameMap);
	}

	/**
	 * Sets the localized place names of this placit place from the map of locales and localized place names, and sets the default locale.
	 *
	 * @param placeNameMap the locales and localized place names of this placit place
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setPlaceNameMap(
		Map<java.util.Locale, String> placeNameMap,
		java.util.Locale defaultLocale) {

		model.setPlaceNameMap(placeNameMap, defaultLocale);
	}

	/**
	 * Sets the place sig ID of this placit place.
	 *
	 * @param placeSIGId the place sig ID of this placit place
	 */
	@Override
	public void setPlaceSIGId(String placeSIGId) {
		model.setPlaceSIGId(placeSIGId);
	}

	/**
	 * Sets the place street name of this placit place.
	 *
	 * @param placeStreetName the place street name of this placit place
	 */
	@Override
	public void setPlaceStreetName(String placeStreetName) {
		model.setPlaceStreetName(placeStreetName);
	}

	/**
	 * Sets the place street number of this placit place.
	 *
	 * @param placeStreetNumber the place street number of this placit place
	 */
	@Override
	public void setPlaceStreetNumber(String placeStreetNumber) {
		model.setPlaceStreetNumber(placeStreetNumber);
	}

	/**
	 * Sets the place zip code of this placit place.
	 *
	 * @param placeZipCode the place zip code of this placit place
	 */
	@Override
	public void setPlaceZipCode(String placeZipCode) {
		model.setPlaceZipCode(placeZipCode);
	}

	/**
	 * Sets the placit place ID of this placit place.
	 *
	 * @param placitPlaceId the placit place ID of this placit place
	 */
	@Override
	public void setPlacitPlaceId(long placitPlaceId) {
		model.setPlacitPlaceId(placitPlaceId);
	}

	/**
	 * Sets the primary key of this placit place.
	 *
	 * @param primaryKey the primary key of this placit place
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the project ID of this placit place.
	 *
	 * @param projectId the project ID of this placit place
	 */
	@Override
	public void setProjectId(long projectId) {
		model.setProjectId(projectId);
	}

	/**
	 * Sets the saisine observatoire ID of this placit place.
	 *
	 * @param saisineObservatoireId the saisine observatoire ID of this placit place
	 */
	@Override
	public void setSaisineObservatoireId(long saisineObservatoireId) {
		model.setSaisineObservatoireId(saisineObservatoireId);
	}

	/**
	 * Sets the user ID of this placit place.
	 *
	 * @param userId the user ID of this placit place
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this placit place.
	 *
	 * @param userName the user name of this placit place
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this placit place.
	 *
	 * @param userUuid the user uuid of this placit place
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this placit place.
	 *
	 * @param uuid the uuid of this placit place
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Retourne la version JSON de l'entité
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
	protected PlacitPlaceWrapper wrap(PlacitPlace placitPlace) {
		return new PlacitPlaceWrapper(placitPlace);
	}

}