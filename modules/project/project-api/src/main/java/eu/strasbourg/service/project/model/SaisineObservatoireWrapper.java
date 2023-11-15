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

package eu.strasbourg.service.project.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SaisineObservatoire}.
 * </p>
 *
 * @author Cedric Henry
 * @see SaisineObservatoire
 * @generated
 */
public class SaisineObservatoireWrapper
	extends BaseModelWrapper<SaisineObservatoire>
	implements ModelWrapper<SaisineObservatoire>, SaisineObservatoire {

	public SaisineObservatoireWrapper(SaisineObservatoire saisineObservatoire) {
		super(saisineObservatoire);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("saisineObservatoireId", getSaisineObservatoireId());
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
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("placeTextArea", getPlaceTextArea());
		attributes.put("filesDownload", getFilesDownload());
		attributes.put("cityResponse", getCityResponse());
		attributes.put("projectTarget", getProjectTarget());
		attributes.put("otherMechanism", getOtherMechanism());
		attributes.put("collectiveName", getCollectiveName());
		attributes.put("petitionnaireLastname", getPetitionnaireLastname());
		attributes.put("petitionnaireFirstname", getPetitionnaireFirstname());
		attributes.put("petitionnaireBirthday", getPetitionnaireBirthday());
		attributes.put("petitionnaireAdresse", getPetitionnaireAdresse());
		attributes.put("petitionnairePostalCode", getPetitionnairePostalCode());
		attributes.put("petitionnaireCity", getPetitionnaireCity());
		attributes.put("petitionnairePhone", getPetitionnairePhone());
		attributes.put("petitionnaireEmail", getPetitionnaireEmail());
		attributes.put("videoUrl", getVideoUrl());
		attributes.put("externalImageURL", getExternalImageURL());
		attributes.put("externalImageCopyright", getExternalImageCopyright());
		attributes.put("mediaChoice", isMediaChoice());
		attributes.put("publikId", getPublikId());
		attributes.put("imageId", getImageId());
		attributes.put("filesIds", getFilesIds());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long saisineObservatoireId = (Long)attributes.get(
			"saisineObservatoireId");

		if (saisineObservatoireId != null) {
			setSaisineObservatoireId(saisineObservatoireId);
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

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String placeTextArea = (String)attributes.get("placeTextArea");

		if (placeTextArea != null) {
			setPlaceTextArea(placeTextArea);
		}

		String filesDownload = (String)attributes.get("filesDownload");

		if (filesDownload != null) {
			setFilesDownload(filesDownload);
		}

		String cityResponse = (String)attributes.get("cityResponse");

		if (cityResponse != null) {
			setCityResponse(cityResponse);
		}

		String projectTarget = (String)attributes.get("projectTarget");

		if (projectTarget != null) {
			setProjectTarget(projectTarget);
		}

		String otherMechanism = (String)attributes.get("otherMechanism");

		if (otherMechanism != null) {
			setOtherMechanism(otherMechanism);
		}

		String collectiveName = (String)attributes.get("collectiveName");

		if (collectiveName != null) {
			setCollectiveName(collectiveName);
		}

		String petitionnaireLastname = (String)attributes.get(
			"petitionnaireLastname");

		if (petitionnaireLastname != null) {
			setPetitionnaireLastname(petitionnaireLastname);
		}

		String petitionnaireFirstname = (String)attributes.get(
			"petitionnaireFirstname");

		if (petitionnaireFirstname != null) {
			setPetitionnaireFirstname(petitionnaireFirstname);
		}

		Date petitionnaireBirthday = (Date)attributes.get(
			"petitionnaireBirthday");

		if (petitionnaireBirthday != null) {
			setPetitionnaireBirthday(petitionnaireBirthday);
		}

		String petitionnaireAdresse = (String)attributes.get(
			"petitionnaireAdresse");

		if (petitionnaireAdresse != null) {
			setPetitionnaireAdresse(petitionnaireAdresse);
		}

		Long petitionnairePostalCode = (Long)attributes.get(
			"petitionnairePostalCode");

		if (petitionnairePostalCode != null) {
			setPetitionnairePostalCode(petitionnairePostalCode);
		}

		String petitionnaireCity = (String)attributes.get("petitionnaireCity");

		if (petitionnaireCity != null) {
			setPetitionnaireCity(petitionnaireCity);
		}

		String petitionnairePhone = (String)attributes.get(
			"petitionnairePhone");

		if (petitionnairePhone != null) {
			setPetitionnairePhone(petitionnairePhone);
		}

		String petitionnaireEmail = (String)attributes.get(
			"petitionnaireEmail");

		if (petitionnaireEmail != null) {
			setPetitionnaireEmail(petitionnaireEmail);
		}

		String videoUrl = (String)attributes.get("videoUrl");

		if (videoUrl != null) {
			setVideoUrl(videoUrl);
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

		Boolean mediaChoice = (Boolean)attributes.get("mediaChoice");

		if (mediaChoice != null) {
			setMediaChoice(mediaChoice);
		}

		String publikId = (String)attributes.get("publikId");

		if (publikId != null) {
			setPublikId(publikId);
		}

		Long imageId = (Long)attributes.get("imageId");

		if (imageId != null) {
			setImageId(imageId);
		}

		String filesIds = (String)attributes.get("filesIds");

		if (filesIds != null) {
			setFilesIds(filesIds);
		}
	}

	@Override
	public SaisineObservatoire cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Retourne les commentaires de l'entité
	 */
	@Override
	public java.util.List<eu.strasbourg.service.comment.model.Comment>
		getApprovedComments() {

		return model.getApprovedComments();
	}

	/**
	 * Retourne l'AssetEntry rattaché cet item
	 */
	@Override
	public com.liferay.asset.kernel.model.AssetEntry getAssetEntry() {
		return model.getAssetEntry();
	}

	/**
	 * Retourne l'URL de l'image de l'utilisateur
	 */
	@Override
	public String getAuthorImageURL() {
		return model.getAuthorImageURL();
	}

	@Override
	public String getAuthorLabel() {
		return model.getAuthorLabel();
	}

	/**
	 * Retourne l'auteur en publik user
	 *
	 * @return
	 */
	@Override
	public eu.strasbourg.service.oidc.model.PublikUser getAuthorPublikUser() {
		return model.getAuthorPublikUser();
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Renvoie la liste des AssetCategory rattachées à cet item (via l'assetEntry)
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCategories() {

		return model.getCategories();
	}

	/**
	 * Retourne les sous-sous-catégories 'Territoire' correspondant aux communes de la pétition
	 *
	 * @return : null si vide, sinon la liste des catégories
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCityCategories() {

		return model.getCityCategories();
	}

	/**
	 * Returns the city response of this saisine observatoire.
	 *
	 * @return the city response of this saisine observatoire
	 */
	@Override
	public String getCityResponse() {
		return model.getCityResponse();
	}

	/**
	 * Returns the localized city response of this saisine observatoire in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized city response of this saisine observatoire
	 */
	@Override
	public String getCityResponse(java.util.Locale locale) {
		return model.getCityResponse(locale);
	}

	/**
	 * Returns the localized city response of this saisine observatoire in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized city response of this saisine observatoire. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getCityResponse(java.util.Locale locale, boolean useDefault) {
		return model.getCityResponse(locale, useDefault);
	}

	/**
	 * Returns the localized city response of this saisine observatoire in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized city response of this saisine observatoire
	 */
	@Override
	public String getCityResponse(String languageId) {
		return model.getCityResponse(languageId);
	}

	/**
	 * Returns the localized city response of this saisine observatoire in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized city response of this saisine observatoire
	 */
	@Override
	public String getCityResponse(String languageId, boolean useDefault) {
		return model.getCityResponse(languageId, useDefault);
	}

	@Override
	public String getCityResponseCurrentLanguageId() {
		return model.getCityResponseCurrentLanguageId();
	}

	@Override
	public String getCityResponseCurrentValue() {
		return model.getCityResponseCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized city responses of this saisine observatoire.
	 *
	 * @return the locales and localized city responses of this saisine observatoire
	 */
	@Override
	public Map<java.util.Locale, String> getCityResponseMap() {
		return model.getCityResponseMap();
	}

	/**
	 * Returns the collective name of this saisine observatoire.
	 *
	 * @return the collective name of this saisine observatoire
	 */
	@Override
	public String getCollectiveName() {
		return model.getCollectiveName();
	}

	/**
	 * Returns the company ID of this saisine observatoire.
	 *
	 * @return the company ID of this saisine observatoire
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this saisine observatoire.
	 *
	 * @return the create date of this saisine observatoire
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
	 * Returns the description of this saisine observatoire.
	 *
	 * @return the description of this saisine observatoire
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the localized description of this saisine observatoire in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description of this saisine observatoire
	 */
	@Override
	public String getDescription(java.util.Locale locale) {
		return model.getDescription(locale);
	}

	/**
	 * Returns the localized description of this saisine observatoire in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this saisine observatoire. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getDescription(java.util.Locale locale, boolean useDefault) {
		return model.getDescription(locale, useDefault);
	}

	/**
	 * Returns the localized description of this saisine observatoire in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description of this saisine observatoire
	 */
	@Override
	public String getDescription(String languageId) {
		return model.getDescription(languageId);
	}

	/**
	 * Returns the localized description of this saisine observatoire in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this saisine observatoire
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
	 * Returns a map of the locales and localized descriptions of this saisine observatoire.
	 *
	 * @return the locales and localized descriptions of this saisine observatoire
	 */
	@Override
	public Map<java.util.Locale, String> getDescriptionMap() {
		return model.getDescriptionMap();
	}

	/**
	 * Retourne les sous-sous-catégories 'Territoire' correspondant aux quartiers de la petition
	 *
	 * @return : null si vide, sinon la liste des catégories
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getDistrictCategories() {

		return model.getDistrictCategories();
	}

	/**
	 * Retourne une chaine des 'Territoires' correspondant aux quartiers de la petition
	 *
	 * @return : Chaine des quartiers ou description "Aucun" ou "Tous"
	 */
	@Override
	public String getDistrictLabel(java.util.Locale locale) {
		return model.getDistrictLabel(locale);
	}

	/**
	 * Returns the external image copyright of this saisine observatoire.
	 *
	 * @return the external image copyright of this saisine observatoire
	 */
	@Override
	public String getExternalImageCopyright() {
		return model.getExternalImageCopyright();
	}

	/**
	 * Returns the external image url of this saisine observatoire.
	 *
	 * @return the external image url of this saisine observatoire
	 */
	@Override
	public String getExternalImageURL() {
		return model.getExternalImageURL();
	}

	/**
	 * Returns the files download of this saisine observatoire.
	 *
	 * @return the files download of this saisine observatoire
	 */
	@Override
	public String getFilesDownload() {
		return model.getFilesDownload();
	}

	/**
	 * Returns the files IDs of this saisine observatoire.
	 *
	 * @return the files IDs of this saisine observatoire
	 */
	@Override
	public String getFilesIds() {
		return model.getFilesIds();
	}

	/**
	 * Retourne la liste des URLs des documents
	 */
	@Override
	public java.util.List<String> getFilesURLs() {
		return model.getFilesURLs();
	}

	/**
	 * Returns the group ID of this saisine observatoire.
	 *
	 * @return the group ID of this saisine observatoire
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Retourne le copyright de l'image principale
	 */
	@Override
	public String getImageCopyright(java.util.Locale locale) {
		return model.getImageCopyright(locale);
	}

	/**
	 * Returns the image ID of this saisine observatoire.
	 *
	 * @return the image ID of this saisine observatoire
	 */
	@Override
	public long getImageId() {
		return model.getImageId();
	}

	/**
	 * Retourne l'URL de l'image à partir de l'id du DLFileEntry
	 */
	@Override
	public String getImageURL() {
		return model.getImageURL();
	}

	/**
	 * Returns the media choice of this saisine observatoire.
	 *
	 * @return the media choice of this saisine observatoire
	 */
	@Override
	public boolean getMediaChoice() {
		return model.getMediaChoice();
	}

	/**
	 * Returns the modified date of this saisine observatoire.
	 *
	 * @return the modified date of this saisine observatoire
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Retourne le nombre de commentaires de l'entité
	 */
	@Override
	public int getNbApprovedComments() {
		return model.getNbApprovedComments();
	}

	/**
	 * Retourne le label de 5 digits du nombre de commentaires de l'entité
	 */
	@Override
	public String getNbApprovedCommentsLabel() {
		return model.getNbApprovedCommentsLabel();
	}

	/**
	 * Returns the other mechanism of this saisine observatoire.
	 *
	 * @return the other mechanism of this saisine observatoire
	 */
	@Override
	public String getOtherMechanism() {
		return model.getOtherMechanism();
	}

	/**
	 * Returns the petitionnaire adresse of this saisine observatoire.
	 *
	 * @return the petitionnaire adresse of this saisine observatoire
	 */
	@Override
	public String getPetitionnaireAdresse() {
		return model.getPetitionnaireAdresse();
	}

	/**
	 * Returns the petitionnaire birthday of this saisine observatoire.
	 *
	 * @return the petitionnaire birthday of this saisine observatoire
	 */
	@Override
	public Date getPetitionnaireBirthday() {
		return model.getPetitionnaireBirthday();
	}

	/**
	 * Returns the petitionnaire city of this saisine observatoire.
	 *
	 * @return the petitionnaire city of this saisine observatoire
	 */
	@Override
	public String getPetitionnaireCity() {
		return model.getPetitionnaireCity();
	}

	/**
	 * Returns the petitionnaire email of this saisine observatoire.
	 *
	 * @return the petitionnaire email of this saisine observatoire
	 */
	@Override
	public String getPetitionnaireEmail() {
		return model.getPetitionnaireEmail();
	}

	/**
	 * Returns the petitionnaire firstname of this saisine observatoire.
	 *
	 * @return the petitionnaire firstname of this saisine observatoire
	 */
	@Override
	public String getPetitionnaireFirstname() {
		return model.getPetitionnaireFirstname();
	}

	/**
	 * Returns the petitionnaire lastname of this saisine observatoire.
	 *
	 * @return the petitionnaire lastname of this saisine observatoire
	 */
	@Override
	public String getPetitionnaireLastname() {
		return model.getPetitionnaireLastname();
	}

	/**
	 * Returns the petitionnaire phone of this saisine observatoire.
	 *
	 * @return the petitionnaire phone of this saisine observatoire
	 */
	@Override
	public String getPetitionnairePhone() {
		return model.getPetitionnairePhone();
	}

	/**
	 * Returns the petitionnaire postal code of this saisine observatoire.
	 *
	 * @return the petitionnaire postal code of this saisine observatoire
	 */
	@Override
	public long getPetitionnairePostalCode() {
		return model.getPetitionnairePostalCode();
	}

	/**
	 * Returns the place text area of this saisine observatoire.
	 *
	 * @return the place text area of this saisine observatoire
	 */
	@Override
	public String getPlaceTextArea() {
		return model.getPlaceTextArea();
	}

	/**
	 * Retourne la liste des lieux placit liés à la petition
	 */
	@Override
	public java.util.List<eu.strasbourg.service.project.model.PlacitPlace>
		getPlacitPlaces() {

		return model.getPlacitPlaces();
	}

	/**
	 * Returns the primary key of this saisine observatoire.
	 *
	 * @return the primary key of this saisine observatoire
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Retourne le projet de la saisine (
	 */
	@Override
	public com.liferay.asset.kernel.model.AssetCategory getProjectCategory() {
		return model.getProjectCategory();
	}

	/**
	 * Returns the project target of this saisine observatoire.
	 *
	 * @return the project target of this saisine observatoire
	 */
	@Override
	public String getProjectTarget() {
		return model.getProjectTarget();
	}

	@Override
	public String getProjectTitle(java.util.Locale locale) {
		return model.getProjectTitle(locale);
	}

	/**
	 * Returns the publik ID of this saisine observatoire.
	 *
	 * @return the publik ID of this saisine observatoire
	 */
	@Override
	public String getPublikId() {
		return model.getPublikId();
	}

	/**
	 * Returns the saisine observatoire ID of this saisine observatoire.
	 *
	 * @return the saisine observatoire ID of this saisine observatoire
	 */
	@Override
	public long getSaisineObservatoireId() {
		return model.getSaisineObservatoireId();
	}

	/**
	 * méthode de récupération du status
	 *
	 * @return le status.
	 */
	@Override
	public String getSaisineObservatoireStatus() {
		return model.getSaisineObservatoireStatus();
	}

	/**
	 * Returns the status of this saisine observatoire.
	 *
	 * @return the status of this saisine observatoire
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this saisine observatoire.
	 *
	 * @return the status by user ID of this saisine observatoire
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this saisine observatoire.
	 *
	 * @return the status by user name of this saisine observatoire
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this saisine observatoire.
	 *
	 * @return the status by user uuid of this saisine observatoire
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	@Override
	public com.liferay.asset.kernel.model.AssetCategory getStatusCategorie() {
		return model.getStatusCategorie();
	}

	/**
	 * Returns the status date of this saisine observatoire.
	 *
	 * @return the status date of this saisine observatoire
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Retourne X suggestions max pour une pétition
	 *
	 * @param request
	 la requete
	 * @param nbSuggestions
	 le nombre de suggestions.
	 * @return la liste de pétition.
	 */
	@Override
	public java.util.List
		<eu.strasbourg.service.project.model.SaisineObservatoire>
			getSuggestions(
				javax.servlet.http.HttpServletRequest request,
				int nbSuggestions) {

		return model.getSuggestions(request, nbSuggestions);
	}

	/**
	 * Retourne les catégories 'Territoire' correspondant aux pays de la petition
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getTerritoryCategories() {

		return model.getTerritoryCategories();
	}

	/**
	 * Retourne les thematiques de la saisine (
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getThematicCategories() {

		return model.getThematicCategories();
	}

	@Override
	public String getThematicLabel(java.util.Locale locale) {
		return model.getThematicLabel(locale);
	}

	/**
	 * Returns the title of this saisine observatoire.
	 *
	 * @return the title of this saisine observatoire
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the user ID of this saisine observatoire.
	 *
	 * @return the user ID of this saisine observatoire
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this saisine observatoire.
	 *
	 * @return the user name of this saisine observatoire
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this saisine observatoire.
	 *
	 * @return the user uuid of this saisine observatoire
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the video url of this saisine observatoire.
	 *
	 * @return the video url of this saisine observatoire
	 */
	@Override
	public String getVideoUrl() {
		return model.getVideoUrl();
	}

	/**
	 * Returns <code>true</code> if this saisine observatoire is approved.
	 *
	 * @return <code>true</code> if this saisine observatoire is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this saisine observatoire is denied.
	 *
	 * @return <code>true</code> if this saisine observatoire is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this saisine observatoire is a draft.
	 *
	 * @return <code>true</code> if this saisine observatoire is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this saisine observatoire is expired.
	 *
	 * @return <code>true</code> if this saisine observatoire is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this saisine observatoire is inactive.
	 *
	 * @return <code>true</code> if this saisine observatoire is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this saisine observatoire is incomplete.
	 *
	 * @return <code>true</code> if this saisine observatoire is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this saisine observatoire is media choice.
	 *
	 * @return <code>true</code> if this saisine observatoire is media choice; <code>false</code> otherwise
	 */
	@Override
	public boolean isMediaChoice() {
		return model.isMediaChoice();
	}

	/**
	 * Returns <code>true</code> if this saisine observatoire is pending.
	 *
	 * @return <code>true</code> if this saisine observatoire is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this saisine observatoire is scheduled.
	 *
	 * @return <code>true</code> if this saisine observatoire is scheduled; <code>false</code> otherwise
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
	 * Sets the city response of this saisine observatoire.
	 *
	 * @param cityResponse the city response of this saisine observatoire
	 */
	@Override
	public void setCityResponse(String cityResponse) {
		model.setCityResponse(cityResponse);
	}

	/**
	 * Sets the localized city response of this saisine observatoire in the language.
	 *
	 * @param cityResponse the localized city response of this saisine observatoire
	 * @param locale the locale of the language
	 */
	@Override
	public void setCityResponse(String cityResponse, java.util.Locale locale) {
		model.setCityResponse(cityResponse, locale);
	}

	/**
	 * Sets the localized city response of this saisine observatoire in the language, and sets the default locale.
	 *
	 * @param cityResponse the localized city response of this saisine observatoire
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setCityResponse(
		String cityResponse, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setCityResponse(cityResponse, locale, defaultLocale);
	}

	@Override
	public void setCityResponseCurrentLanguageId(String languageId) {
		model.setCityResponseCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized city responses of this saisine observatoire from the map of locales and localized city responses.
	 *
	 * @param cityResponseMap the locales and localized city responses of this saisine observatoire
	 */
	@Override
	public void setCityResponseMap(
		Map<java.util.Locale, String> cityResponseMap) {

		model.setCityResponseMap(cityResponseMap);
	}

	/**
	 * Sets the localized city responses of this saisine observatoire from the map of locales and localized city responses, and sets the default locale.
	 *
	 * @param cityResponseMap the locales and localized city responses of this saisine observatoire
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setCityResponseMap(
		Map<java.util.Locale, String> cityResponseMap,
		java.util.Locale defaultLocale) {

		model.setCityResponseMap(cityResponseMap, defaultLocale);
	}

	/**
	 * Sets the collective name of this saisine observatoire.
	 *
	 * @param collectiveName the collective name of this saisine observatoire
	 */
	@Override
	public void setCollectiveName(String collectiveName) {
		model.setCollectiveName(collectiveName);
	}

	/**
	 * Sets the company ID of this saisine observatoire.
	 *
	 * @param companyId the company ID of this saisine observatoire
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this saisine observatoire.
	 *
	 * @param createDate the create date of this saisine observatoire
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this saisine observatoire.
	 *
	 * @param description the description of this saisine observatoire
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the localized description of this saisine observatoire in the language.
	 *
	 * @param description the localized description of this saisine observatoire
	 * @param locale the locale of the language
	 */
	@Override
	public void setDescription(String description, java.util.Locale locale) {
		model.setDescription(description, locale);
	}

	/**
	 * Sets the localized description of this saisine observatoire in the language, and sets the default locale.
	 *
	 * @param description the localized description of this saisine observatoire
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
	 * Sets the localized descriptions of this saisine observatoire from the map of locales and localized descriptions.
	 *
	 * @param descriptionMap the locales and localized descriptions of this saisine observatoire
	 */
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, String> descriptionMap) {

		model.setDescriptionMap(descriptionMap);
	}

	/**
	 * Sets the localized descriptions of this saisine observatoire from the map of locales and localized descriptions, and sets the default locale.
	 *
	 * @param descriptionMap the locales and localized descriptions of this saisine observatoire
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, String> descriptionMap,
		java.util.Locale defaultLocale) {

		model.setDescriptionMap(descriptionMap, defaultLocale);
	}

	/**
	 * Sets the external image copyright of this saisine observatoire.
	 *
	 * @param externalImageCopyright the external image copyright of this saisine observatoire
	 */
	@Override
	public void setExternalImageCopyright(String externalImageCopyright) {
		model.setExternalImageCopyright(externalImageCopyright);
	}

	/**
	 * Sets the external image url of this saisine observatoire.
	 *
	 * @param externalImageURL the external image url of this saisine observatoire
	 */
	@Override
	public void setExternalImageURL(String externalImageURL) {
		model.setExternalImageURL(externalImageURL);
	}

	/**
	 * Sets the files download of this saisine observatoire.
	 *
	 * @param filesDownload the files download of this saisine observatoire
	 */
	@Override
	public void setFilesDownload(String filesDownload) {
		model.setFilesDownload(filesDownload);
	}

	/**
	 * Sets the files IDs of this saisine observatoire.
	 *
	 * @param filesIds the files IDs of this saisine observatoire
	 */
	@Override
	public void setFilesIds(String filesIds) {
		model.setFilesIds(filesIds);
	}

	/**
	 * Sets the group ID of this saisine observatoire.
	 *
	 * @param groupId the group ID of this saisine observatoire
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the image ID of this saisine observatoire.
	 *
	 * @param imageId the image ID of this saisine observatoire
	 */
	@Override
	public void setImageId(long imageId) {
		model.setImageId(imageId);
	}

	/**
	 * Sets whether this saisine observatoire is media choice.
	 *
	 * @param mediaChoice the media choice of this saisine observatoire
	 */
	@Override
	public void setMediaChoice(boolean mediaChoice) {
		model.setMediaChoice(mediaChoice);
	}

	/**
	 * Sets the modified date of this saisine observatoire.
	 *
	 * @param modifiedDate the modified date of this saisine observatoire
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the other mechanism of this saisine observatoire.
	 *
	 * @param otherMechanism the other mechanism of this saisine observatoire
	 */
	@Override
	public void setOtherMechanism(String otherMechanism) {
		model.setOtherMechanism(otherMechanism);
	}

	/**
	 * Sets the petitionnaire adresse of this saisine observatoire.
	 *
	 * @param petitionnaireAdresse the petitionnaire adresse of this saisine observatoire
	 */
	@Override
	public void setPetitionnaireAdresse(String petitionnaireAdresse) {
		model.setPetitionnaireAdresse(petitionnaireAdresse);
	}

	/**
	 * Sets the petitionnaire birthday of this saisine observatoire.
	 *
	 * @param petitionnaireBirthday the petitionnaire birthday of this saisine observatoire
	 */
	@Override
	public void setPetitionnaireBirthday(Date petitionnaireBirthday) {
		model.setPetitionnaireBirthday(petitionnaireBirthday);
	}

	/**
	 * Sets the petitionnaire city of this saisine observatoire.
	 *
	 * @param petitionnaireCity the petitionnaire city of this saisine observatoire
	 */
	@Override
	public void setPetitionnaireCity(String petitionnaireCity) {
		model.setPetitionnaireCity(petitionnaireCity);
	}

	/**
	 * Sets the petitionnaire email of this saisine observatoire.
	 *
	 * @param petitionnaireEmail the petitionnaire email of this saisine observatoire
	 */
	@Override
	public void setPetitionnaireEmail(String petitionnaireEmail) {
		model.setPetitionnaireEmail(petitionnaireEmail);
	}

	/**
	 * Sets the petitionnaire firstname of this saisine observatoire.
	 *
	 * @param petitionnaireFirstname the petitionnaire firstname of this saisine observatoire
	 */
	@Override
	public void setPetitionnaireFirstname(String petitionnaireFirstname) {
		model.setPetitionnaireFirstname(petitionnaireFirstname);
	}

	/**
	 * Sets the petitionnaire lastname of this saisine observatoire.
	 *
	 * @param petitionnaireLastname the petitionnaire lastname of this saisine observatoire
	 */
	@Override
	public void setPetitionnaireLastname(String petitionnaireLastname) {
		model.setPetitionnaireLastname(petitionnaireLastname);
	}

	/**
	 * Sets the petitionnaire phone of this saisine observatoire.
	 *
	 * @param petitionnairePhone the petitionnaire phone of this saisine observatoire
	 */
	@Override
	public void setPetitionnairePhone(String petitionnairePhone) {
		model.setPetitionnairePhone(petitionnairePhone);
	}

	/**
	 * Sets the petitionnaire postal code of this saisine observatoire.
	 *
	 * @param petitionnairePostalCode the petitionnaire postal code of this saisine observatoire
	 */
	@Override
	public void setPetitionnairePostalCode(long petitionnairePostalCode) {
		model.setPetitionnairePostalCode(petitionnairePostalCode);
	}

	/**
	 * Sets the place text area of this saisine observatoire.
	 *
	 * @param placeTextArea the place text area of this saisine observatoire
	 */
	@Override
	public void setPlaceTextArea(String placeTextArea) {
		model.setPlaceTextArea(placeTextArea);
	}

	/**
	 * Sets the primary key of this saisine observatoire.
	 *
	 * @param primaryKey the primary key of this saisine observatoire
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the project target of this saisine observatoire.
	 *
	 * @param projectTarget the project target of this saisine observatoire
	 */
	@Override
	public void setProjectTarget(String projectTarget) {
		model.setProjectTarget(projectTarget);
	}

	/**
	 * Sets the publik ID of this saisine observatoire.
	 *
	 * @param publikId the publik ID of this saisine observatoire
	 */
	@Override
	public void setPublikId(String publikId) {
		model.setPublikId(publikId);
	}

	/**
	 * Sets the saisine observatoire ID of this saisine observatoire.
	 *
	 * @param saisineObservatoireId the saisine observatoire ID of this saisine observatoire
	 */
	@Override
	public void setSaisineObservatoireId(long saisineObservatoireId) {
		model.setSaisineObservatoireId(saisineObservatoireId);
	}

	/**
	 * Sets the status of this saisine observatoire.
	 *
	 * @param status the status of this saisine observatoire
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this saisine observatoire.
	 *
	 * @param statusByUserId the status by user ID of this saisine observatoire
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this saisine observatoire.
	 *
	 * @param statusByUserName the status by user name of this saisine observatoire
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this saisine observatoire.
	 *
	 * @param statusByUserUuid the status by user uuid of this saisine observatoire
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this saisine observatoire.
	 *
	 * @param statusDate the status date of this saisine observatoire
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the title of this saisine observatoire.
	 *
	 * @param title the title of this saisine observatoire
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the user ID of this saisine observatoire.
	 *
	 * @param userId the user ID of this saisine observatoire
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this saisine observatoire.
	 *
	 * @param userName the user name of this saisine observatoire
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this saisine observatoire.
	 *
	 * @param userUuid the user uuid of this saisine observatoire
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the video url of this saisine observatoire.
	 *
	 * @param videoUrl the video url of this saisine observatoire
	 */
	@Override
	public void setVideoUrl(String videoUrl) {
		model.setVideoUrl(videoUrl);
	}

	/**
	 * Retourne la version JSON de l'entité
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONObject toJSON(
		String publikUserId) {

		return model.toJSON(publikUserId);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected SaisineObservatoireWrapper wrap(
		SaisineObservatoire saisineObservatoire) {

		return new SaisineObservatoireWrapper(saisineObservatoire);
	}

}