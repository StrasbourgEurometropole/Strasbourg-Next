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
 * This class is a wrapper for {@link Petition}.
 * </p>
 *
 * @author Cedric Henry
 * @see Petition
 * @generated
 */
public class PetitionWrapper implements ModelWrapper<Petition>, Petition {

	public PetitionWrapper(Petition petition) {
		_petition = petition;
	}

	@Override
	public Class<?> getModelClass() {
		return Petition.class;
	}

	@Override
	public String getModelClassName() {
		return Petition.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("petitionId", getPetitionId());
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
		attributes.put("summary", getSummary());
		attributes.put("description", getDescription());
		attributes.put("placeTextArea", getPlaceTextArea());
		attributes.put("filesDownload", getFilesDownload());
		attributes.put("publicationDate", getPublicationDate());
		attributes.put("expirationDate", getExpirationDate());
		attributes.put("extensionDate", getExtensionDate());
		attributes.put("quotaSignature", getQuotaSignature());
		attributes.put("inTheNameOf", getInTheNameOf());
		attributes.put("petitionnaireLastname", getPetitionnaireLastname());
		attributes.put("petitionnaireFirstname", getPetitionnaireFirstname());
		attributes.put("petitionnaireBirthday", getPetitionnaireBirthday());
		attributes.put("petitionnaireAdresse", getPetitionnaireAdresse());
		attributes.put("petitionnairePostalCode", getPetitionnairePostalCode());
		attributes.put("petitionnaireCity", getPetitionnaireCity());
		attributes.put("petitionnairePhone", getPetitionnairePhone());
		attributes.put("petitionnaireEmail", getPetitionnaireEmail());
		attributes.put("isSupported", isIsSupported());
		attributes.put("supportedBy", getSupportedBy());
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
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long petitionId = (Long)attributes.get("petitionId");

		if (petitionId != null) {
			setPetitionId(petitionId);
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

		String summary = (String)attributes.get("summary");

		if (summary != null) {
			setSummary(summary);
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

		Date publicationDate = (Date)attributes.get("publicationDate");

		if (publicationDate != null) {
			setPublicationDate(publicationDate);
		}

		Date expirationDate = (Date)attributes.get("expirationDate");

		if (expirationDate != null) {
			setExpirationDate(expirationDate);
		}

		Date extensionDate = (Date)attributes.get("extensionDate");

		if (extensionDate != null) {
			setExtensionDate(extensionDate);
		}

		Long quotaSignature = (Long)attributes.get("quotaSignature");

		if (quotaSignature != null) {
			setQuotaSignature(quotaSignature);
		}

		String inTheNameOf = (String)attributes.get("inTheNameOf");

		if (inTheNameOf != null) {
			setInTheNameOf(inTheNameOf);
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

		Boolean isSupported = (Boolean)attributes.get("isSupported");

		if (isSupported != null) {
			setIsSupported(isSupported);
		}

		String supportedBy = (String)attributes.get("supportedBy");

		if (supportedBy != null) {
			setSupportedBy(supportedBy);
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
	public Object clone() {
		return new PetitionWrapper((Petition)_petition.clone());
	}

	@Override
	public int compareTo(
		eu.strasbourg.service.project.model.Petition petition) {

		return _petition.compareTo(petition);
	}

	/**
	 * Retourne les commentaires de l'entité
	 */
	@Override
	public java.util.List<eu.strasbourg.service.comment.model.Comment>
		getApprovedComments() {

		return _petition.getApprovedComments();
	}

	/**
	 * Retourne l'AssetEntry rattaché cet item
	 */
	@Override
	public com.liferay.asset.kernel.model.AssetEntry getAssetEntry() {
		return _petition.getAssetEntry();
	}

	@Override
	public String getAssetEntryTitle() {
		return _petition.getAssetEntryTitle();
	}

	/**
	 * Retourne l'URL de l'image de l'utilisateur
	 */
	@Override
	public String getAuthorImageURL() {
		return _petition.getAuthorImageURL();
	}

	/**
	 * Retourne le nom du depositaire sous forme "Truc M." ou le "Au nom de ..."
	 */
	@Override
	public String getAuthorLabel() {
		return _petition.getAuthorLabel();
	}

	/**
	 * Retourne l'auteur en publik user
	 *
	 * @return
	 */
	@Override
	public eu.strasbourg.service.oidc.model.PublikUser getAuthorPublikUser() {
		return _petition.getAuthorPublikUser();
	}

	/**
	 * Renvoie la liste des AssetCategory rattachées à cet item (via l'assetEntry)
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCategories() {

		return _petition.getCategories();
	}

	/**
	 * Retourne les sous-sous-catégories 'Territoire' correspondant aux communes de la pétition
	 *
	 * @return : null si vide, sinon la liste des catégories
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCityCategories() {

		return _petition.getCityCategories();
	}

	/**
	 * Returns the company ID of this petition.
	 *
	 * @return the company ID of this petition
	 */
	@Override
	public long getCompanyId() {
		return _petition.getCompanyId();
	}

	/**
	 * méthode permettant de récuperer les faux signataires d'une pétitions.
	 *
	 * @return les faux signataires.
	 */
	@Override
	public int getCountFakeSignataire() {
		return _petition.getCountFakeSignataire();
	}

	/**
	 * Returns the create date of this petition.
	 *
	 * @return the create date of this petition
	 */
	@Override
	public Date getCreateDate() {
		return _petition.getCreateDate();
	}

	/**
	 * Returns the description of this petition.
	 *
	 * @return the description of this petition
	 */
	@Override
	public String getDescription() {
		return _petition.getDescription();
	}

	/**
	 * Retourne les sous-sous-catégories 'Territoire' correspondant aux quartiers de la petition
	 *
	 * @return : null si vide, sinon la liste des catégories
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getDistrictCategories() {

		return _petition.getDistrictCategories();
	}

	/**
	 * Retourne une chaine des 'Territoires' correspondant aux quartiers de la petition
	 *
	 * @return : Chaine des quartiers ou description "Aucun" ou "Tous"
	 */
	@Override
	public String getDistrictLabel(java.util.Locale locale) {
		return _petition.getDistrictLabel(locale);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _petition.getExpandoBridge();
	}

	/**
	 * Returns the expiration date of this petition.
	 *
	 * @return the expiration date of this petition
	 */
	@Override
	public Date getExpirationDate() {
		return _petition.getExpirationDate();
	}

	/**
	 * Returns the extension date of this petition.
	 *
	 * @return the extension date of this petition
	 */
	@Override
	public Date getExtensionDate() {
		return _petition.getExtensionDate();
	}

	/**
	 * Returns the external image copyright of this petition.
	 *
	 * @return the external image copyright of this petition
	 */
	@Override
	public String getExternalImageCopyright() {
		return _petition.getExternalImageCopyright();
	}

	/**
	 * Returns the external image url of this petition.
	 *
	 * @return the external image url of this petition
	 */
	@Override
	public String getExternalImageURL() {
		return _petition.getExternalImageURL();
	}

	/**
	 * Returns the files download of this petition.
	 *
	 * @return the files download of this petition
	 */
	@Override
	public String getFilesDownload() {
		return _petition.getFilesDownload();
	}

	/**
	 * Returns the files IDs of this petition.
	 *
	 * @return the files IDs of this petition
	 */
	@Override
	public String getFilesIds() {
		return _petition.getFilesIds();
	}

	/**
	 * Retourne la liste des URLs des documents
	 */
	@Override
	public java.util.List<String> getFilesURLs() {
		return _petition.getFilesURLs();
	}

	/**
	 * méthode de récupération du status
	 *
	 * @return le status.
	 */
	@Override
	public String getFrontStatusFR() {
		return _petition.getFrontStatusFR();
	}

	/**
	 * Returns the group ID of this petition.
	 *
	 * @return the group ID of this petition
	 */
	@Override
	public long getGroupId() {
		return _petition.getGroupId();
	}

	/**
	 * Retourne le copyright de l'image principale
	 */
	@Override
	public String getImageCopyright(java.util.Locale locale) {
		return _petition.getImageCopyright(locale);
	}

	/**
	 * Returns the image ID of this petition.
	 *
	 * @return the image ID of this petition
	 */
	@Override
	public long getImageId() {
		return _petition.getImageId();
	}

	/**
	 * Retourne l'URL de l'image à partir de l'id du DLFileEntry
	 */
	@Override
	public String getImageURL() {
		return _petition.getImageURL();
	}

	/**
	 * Returns the in the name of of this petition.
	 *
	 * @return the in the name of of this petition
	 */
	@Override
	public String getInTheNameOf() {
		return _petition.getInTheNameOf();
	}

	/**
	 * Returns the is supported of this petition.
	 *
	 * @return the is supported of this petition
	 */
	@Override
	public boolean getIsSupported() {
		return _petition.getIsSupported();
	}

	/**
	 * Returns the media choice of this petition.
	 *
	 * @return the media choice of this petition
	 */
	@Override
	public boolean getMediaChoice() {
		return _petition.getMediaChoice();
	}

	/**
	 * Returns the modified date of this petition.
	 *
	 * @return the modified date of this petition
	 */
	@Override
	public Date getModifiedDate() {
		return _petition.getModifiedDate();
	}

	/**
	 * Retourne le nombre de commentaires de l'entité
	 */
	@Override
	public int getNbApprovedComments() {
		return _petition.getNbApprovedComments();
	}

	/**
	 * Retourne le label de 5 digits du nombre de commentaires de l'entité
	 */
	@Override
	public String getNbApprovedCommentsLabel() {
		return _petition.getNbApprovedCommentsLabel();
	}

	/**
	 * Retourne le nombre de dislikes de l'entité
	 *
	 * @see eu.strasbourg.service.like.model.LikeType
	 */
	@Override
	public int getNbDislikes() {
		return _petition.getNbDislikes();
	}

	/**
	 * Retourne le nombre de likes de l'entité
	 *
	 * @see eu.strasbourg.service.like.model.LikeType
	 */
	@Override
	public int getNbLikes() {
		return _petition.getNbLikes();
	}

	/**
	 * Méthode permettant de retourner le nombre de signataire de la pétition
	 *
	 * @return le nombre.
	 */
	@Override
	public long getNombreSignature() {
		return _petition.getNombreSignature();
	}

	/**
	 * méthode permettant d'afficher le nombre de signature.
	 *
	 * @return le nombre avec des zeros devant.
	 */
	@Override
	public String getNombreSignatureBoard() {
		return _petition.getNombreSignatureBoard();
	}

	/**
	 * Returns the petition ID of this petition.
	 *
	 * @return the petition ID of this petition
	 */
	@Override
	public long getPetitionId() {
		return _petition.getPetitionId();
	}

	/**
	 * Returns the petitionnaire adresse of this petition.
	 *
	 * @return the petitionnaire adresse of this petition
	 */
	@Override
	public String getPetitionnaireAdresse() {
		return _petition.getPetitionnaireAdresse();
	}

	/**
	 * Returns the petitionnaire birthday of this petition.
	 *
	 * @return the petitionnaire birthday of this petition
	 */
	@Override
	public Date getPetitionnaireBirthday() {
		return _petition.getPetitionnaireBirthday();
	}

	/**
	 * Returns the petitionnaire city of this petition.
	 *
	 * @return the petitionnaire city of this petition
	 */
	@Override
	public String getPetitionnaireCity() {
		return _petition.getPetitionnaireCity();
	}

	/**
	 * Returns the petitionnaire email of this petition.
	 *
	 * @return the petitionnaire email of this petition
	 */
	@Override
	public String getPetitionnaireEmail() {
		return _petition.getPetitionnaireEmail();
	}

	/**
	 * Returns the petitionnaire firstname of this petition.
	 *
	 * @return the petitionnaire firstname of this petition
	 */
	@Override
	public String getPetitionnaireFirstname() {
		return _petition.getPetitionnaireFirstname();
	}

	/**
	 * Returns the petitionnaire lastname of this petition.
	 *
	 * @return the petitionnaire lastname of this petition
	 */
	@Override
	public String getPetitionnaireLastname() {
		return _petition.getPetitionnaireLastname();
	}

	/**
	 * Returns the petitionnaire phone of this petition.
	 *
	 * @return the petitionnaire phone of this petition
	 */
	@Override
	public String getPetitionnairePhone() {
		return _petition.getPetitionnairePhone();
	}

	/**
	 * Returns the petitionnaire postal code of this petition.
	 *
	 * @return the petitionnaire postal code of this petition
	 */
	@Override
	public long getPetitionnairePostalCode() {
		return _petition.getPetitionnairePostalCode();
	}

	/**
	 * méthode de récupération du status
	 *
	 * @return le status.
	 */
	@Override
	public String getPetitionStatus() {
		return _petition.getPetitionStatus();
	}

	/**
	 * Retourne le status de la petition
	 */
	@Override
	public com.liferay.asset.kernel.model.AssetCategory
		getPetitionStatusCategory() {

		return _petition.getPetitionStatusCategory();
	}

	/**
	 * méthode d'affichage des information du status pour excel.
	 *
	 * @return le status.
	 */
	@Override
	public String getPetitionStatusExcel() {
		return _petition.getPetitionStatusExcel();
	}

	/**
	 * Returns the place text area of this petition.
	 *
	 * @return the place text area of this petition
	 */
	@Override
	public String getPlaceTextArea() {
		return _petition.getPlaceTextArea();
	}

	/**
	 * Retourne la liste des lieux placit liés à la petition
	 */
	@Override
	public java.util.List<eu.strasbourg.service.project.model.PlacitPlace>
		getPlacitPlaces() {

		return _petition.getPlacitPlaces();
	}

	/**
	 * méthode permettant de récupérer le pourcentage de signatures obtenu.
	 *
	 * @return le pourcentage en long.
	 */
	@Override
	public double getPourcentageSignature() {
		return _petition.getPourcentageSignature();
	}

	/**
	 * Returns the primary key of this petition.
	 *
	 * @return the primary key of this petition
	 */
	@Override
	public long getPrimaryKey() {
		return _petition.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _petition.getPrimaryKeyObj();
	}

	/**
	 * méthode de récupération du status
	 *
	 * @return le status.
	 */
	@Override
	public String getProDureeFR() {
		return _petition.getProDureeFR();
	}

	/**
	 * Retourne le projet de la petition (
	 */
	@Override
	public com.liferay.asset.kernel.model.AssetCategory getProjectCategory() {
		return _petition.getProjectCategory();
	}

	@Override
	public String getProjectTitle(java.util.Locale locale) {
		return _petition.getProjectTitle(locale);
	}

	/**
	 * Returns the publication date of this petition.
	 *
	 * @return the publication date of this petition
	 */
	@Override
	public Date getPublicationDate() {
		return _petition.getPublicationDate();
	}

	@Override
	public String getPublicationDateFr() {
		return _petition.getPublicationDateFr();
	}

	/**
	 * Returns the publik ID of this petition.
	 *
	 * @return the publik ID of this petition
	 */
	@Override
	public String getPublikId() {
		return _petition.getPublikId();
	}

	/**
	 * Returns the quota signature of this petition.
	 *
	 * @return the quota signature of this petition
	 */
	@Override
	public long getQuotaSignature() {
		return _petition.getQuotaSignature();
	}

	/**
	 * méthode permettant de récuperer le nombre de signataire nécessaire pour finir la pétition.
	 *
	 * @return le nombre
	 */
	@Override
	public long getSignataireNeeded() {
		return _petition.getSignataireNeeded();
	}

	@Override
	public java.util.List<eu.strasbourg.service.project.model.Signataire>
		getSignataires() {

		return _petition.getSignataires();
	}

	/**
	 * Returns the status of this petition.
	 *
	 * @return the status of this petition
	 */
	@Override
	public int getStatus() {
		return _petition.getStatus();
	}

	/**
	 * Returns the status by user ID of this petition.
	 *
	 * @return the status by user ID of this petition
	 */
	@Override
	public long getStatusByUserId() {
		return _petition.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this petition.
	 *
	 * @return the status by user name of this petition
	 */
	@Override
	public String getStatusByUserName() {
		return _petition.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this petition.
	 *
	 * @return the status by user uuid of this petition
	 */
	@Override
	public String getStatusByUserUuid() {
		return _petition.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this petition.
	 *
	 * @return the status date of this petition
	 */
	@Override
	public Date getStatusDate() {
		return _petition.getStatusDate();
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
	public java.util.List<eu.strasbourg.service.project.model.Petition>
			getSuggestions(
				javax.servlet.http.HttpServletRequest request,
				int nbSuggestions)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.search.SearchException {

		return _petition.getSuggestions(request, nbSuggestions);
	}

	/**
	 * Returns the summary of this petition.
	 *
	 * @return the summary of this petition
	 */
	@Override
	public String getSummary() {
		return _petition.getSummary();
	}

	/**
	 * Returns the supported by of this petition.
	 *
	 * @return the supported by of this petition
	 */
	@Override
	public String getSupportedBy() {
		return _petition.getSupportedBy();
	}

	/**
	 * Retourne les catégories 'Territoire' correspondant aux pays de la petition
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getTerritoryCategories() {

		return _petition.getTerritoryCategories();
	}

	/**
	 * Retourne les thematiques de la petition (
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getThematicCategories() {

		return _petition.getThematicCategories();
	}

	@Override
	public String getThematicLabel(java.util.Locale locale) {
		return _petition.getThematicLabel(locale);
	}

	/**
	 * Returns the title of this petition.
	 *
	 * @return the title of this petition
	 */
	@Override
	public String getTitle() {
		return _petition.getTitle();
	}

	/**
	 * Calcul la différence de jours entre la date du jour et celle d'expiration
	 */
	@Override
	public int getTodayExpirationDifferenceDays() {
		return _petition.getTodayExpirationDifferenceDays();
	}

	/**
	 * Returns the user ID of this petition.
	 *
	 * @return the user ID of this petition
	 */
	@Override
	public long getUserId() {
		return _petition.getUserId();
	}

	/**
	 * Returns the user name of this petition.
	 *
	 * @return the user name of this petition
	 */
	@Override
	public String getUserName() {
		return _petition.getUserName();
	}

	/**
	 * Returns the user uuid of this petition.
	 *
	 * @return the user uuid of this petition
	 */
	@Override
	public String getUserUuid() {
		return _petition.getUserUuid();
	}

	/**
	 * Returns the uuid of this petition.
	 *
	 * @return the uuid of this petition
	 */
	@Override
	public String getUuid() {
		return _petition.getUuid();
	}

	/**
	 * Returns the video url of this petition.
	 *
	 * @return the video url of this petition
	 */
	@Override
	public String getVideoUrl() {
		return _petition.getVideoUrl();
	}

	@Override
	public int hashCode() {
		return _petition.hashCode();
	}

	/**
	 * Demande si l'utilisateur demandé a signe la petition
	 *
	 * @throws PortletException
	 */
	@Override
	public boolean hasUserSigned(String publikUserId)
		throws javax.portlet.PortletException {

		return _petition.hasUserSigned(publikUserId);
	}

	/**
	 * Returns <code>true</code> if this petition is approved.
	 *
	 * @return <code>true</code> if this petition is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return _petition.isApproved();
	}

	@Override
	public boolean isCachedModel() {
		return _petition.isCachedModel();
	}

	/**
	 * Returns <code>true</code> if this petition is denied.
	 *
	 * @return <code>true</code> if this petition is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return _petition.isDenied();
	}

	/**
	 * Returns <code>true</code> if this petition is a draft.
	 *
	 * @return <code>true</code> if this petition is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return _petition.isDraft();
	}

	@Override
	public boolean isEscapedModel() {
		return _petition.isEscapedModel();
	}

	/**
	 * Returns <code>true</code> if this petition is expired.
	 *
	 * @return <code>true</code> if this petition is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return _petition.isExpired();
	}

	/**
	 * Returns <code>true</code> if this petition is inactive.
	 *
	 * @return <code>true</code> if this petition is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return _petition.isInactive();
	}

	/**
	 * Returns <code>true</code> if this petition is incomplete.
	 *
	 * @return <code>true</code> if this petition is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return _petition.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this petition is is supported.
	 *
	 * @return <code>true</code> if this petition is is supported; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsSupported() {
		return _petition.isIsSupported();
	}

	/**
	 * Peut apporter une reaction (commenter, liker, participer) a l'entite
	 */
	@Override
	public boolean isJudgeable() {
		return _petition.isJudgeable();
	}

	/**
	 * Returns <code>true</code> if this petition is media choice.
	 *
	 * @return <code>true</code> if this petition is media choice; <code>false</code> otherwise
	 */
	@Override
	public boolean isMediaChoice() {
		return _petition.isMediaChoice();
	}

	@Override
	public boolean isNew() {
		return _petition.isNew();
	}

	/**
	 * Returns <code>true</code> if this petition is pending.
	 *
	 * @return <code>true</code> if this petition is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return _petition.isPending();
	}

	/**
	 * Returns <code>true</code> if this petition is scheduled.
	 *
	 * @return <code>true</code> if this petition is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return _petition.isScheduled();
	}

	@Override
	public void persist() {
		_petition.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_petition.setCachedModel(cachedModel);
	}

	/**
	 * Sets the company ID of this petition.
	 *
	 * @param companyId the company ID of this petition
	 */
	@Override
	public void setCompanyId(long companyId) {
		_petition.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this petition.
	 *
	 * @param createDate the create date of this petition
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_petition.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this petition.
	 *
	 * @param description the description of this petition
	 */
	@Override
	public void setDescription(String description) {
		_petition.setDescription(description);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_petition.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_petition.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_petition.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the expiration date of this petition.
	 *
	 * @param expirationDate the expiration date of this petition
	 */
	@Override
	public void setExpirationDate(Date expirationDate) {
		_petition.setExpirationDate(expirationDate);
	}

	/**
	 * Sets the extension date of this petition.
	 *
	 * @param extensionDate the extension date of this petition
	 */
	@Override
	public void setExtensionDate(Date extensionDate) {
		_petition.setExtensionDate(extensionDate);
	}

	/**
	 * Sets the external image copyright of this petition.
	 *
	 * @param externalImageCopyright the external image copyright of this petition
	 */
	@Override
	public void setExternalImageCopyright(String externalImageCopyright) {
		_petition.setExternalImageCopyright(externalImageCopyright);
	}

	/**
	 * Sets the external image url of this petition.
	 *
	 * @param externalImageURL the external image url of this petition
	 */
	@Override
	public void setExternalImageURL(String externalImageURL) {
		_petition.setExternalImageURL(externalImageURL);
	}

	/**
	 * Sets the files download of this petition.
	 *
	 * @param filesDownload the files download of this petition
	 */
	@Override
	public void setFilesDownload(String filesDownload) {
		_petition.setFilesDownload(filesDownload);
	}

	/**
	 * Sets the files IDs of this petition.
	 *
	 * @param filesIds the files IDs of this petition
	 */
	@Override
	public void setFilesIds(String filesIds) {
		_petition.setFilesIds(filesIds);
	}

	/**
	 * Sets the group ID of this petition.
	 *
	 * @param groupId the group ID of this petition
	 */
	@Override
	public void setGroupId(long groupId) {
		_petition.setGroupId(groupId);
	}

	/**
	 * Sets the image ID of this petition.
	 *
	 * @param imageId the image ID of this petition
	 */
	@Override
	public void setImageId(long imageId) {
		_petition.setImageId(imageId);
	}

	/**
	 * Sets the in the name of of this petition.
	 *
	 * @param inTheNameOf the in the name of of this petition
	 */
	@Override
	public void setInTheNameOf(String inTheNameOf) {
		_petition.setInTheNameOf(inTheNameOf);
	}

	/**
	 * Sets whether this petition is is supported.
	 *
	 * @param isSupported the is supported of this petition
	 */
	@Override
	public void setIsSupported(boolean isSupported) {
		_petition.setIsSupported(isSupported);
	}

	/**
	 * Sets whether this petition is media choice.
	 *
	 * @param mediaChoice the media choice of this petition
	 */
	@Override
	public void setMediaChoice(boolean mediaChoice) {
		_petition.setMediaChoice(mediaChoice);
	}

	/**
	 * Sets the modified date of this petition.
	 *
	 * @param modifiedDate the modified date of this petition
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_petition.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_petition.setNew(n);
	}

	/**
	 * Sets the petition ID of this petition.
	 *
	 * @param petitionId the petition ID of this petition
	 */
	@Override
	public void setPetitionId(long petitionId) {
		_petition.setPetitionId(petitionId);
	}

	/**
	 * Sets the petitionnaire adresse of this petition.
	 *
	 * @param petitionnaireAdresse the petitionnaire adresse of this petition
	 */
	@Override
	public void setPetitionnaireAdresse(String petitionnaireAdresse) {
		_petition.setPetitionnaireAdresse(petitionnaireAdresse);
	}

	/**
	 * Sets the petitionnaire birthday of this petition.
	 *
	 * @param petitionnaireBirthday the petitionnaire birthday of this petition
	 */
	@Override
	public void setPetitionnaireBirthday(Date petitionnaireBirthday) {
		_petition.setPetitionnaireBirthday(petitionnaireBirthday);
	}

	/**
	 * Sets the petitionnaire city of this petition.
	 *
	 * @param petitionnaireCity the petitionnaire city of this petition
	 */
	@Override
	public void setPetitionnaireCity(String petitionnaireCity) {
		_petition.setPetitionnaireCity(petitionnaireCity);
	}

	/**
	 * Sets the petitionnaire email of this petition.
	 *
	 * @param petitionnaireEmail the petitionnaire email of this petition
	 */
	@Override
	public void setPetitionnaireEmail(String petitionnaireEmail) {
		_petition.setPetitionnaireEmail(petitionnaireEmail);
	}

	/**
	 * Sets the petitionnaire firstname of this petition.
	 *
	 * @param petitionnaireFirstname the petitionnaire firstname of this petition
	 */
	@Override
	public void setPetitionnaireFirstname(String petitionnaireFirstname) {
		_petition.setPetitionnaireFirstname(petitionnaireFirstname);
	}

	/**
	 * Sets the petitionnaire lastname of this petition.
	 *
	 * @param petitionnaireLastname the petitionnaire lastname of this petition
	 */
	@Override
	public void setPetitionnaireLastname(String petitionnaireLastname) {
		_petition.setPetitionnaireLastname(petitionnaireLastname);
	}

	/**
	 * Sets the petitionnaire phone of this petition.
	 *
	 * @param petitionnairePhone the petitionnaire phone of this petition
	 */
	@Override
	public void setPetitionnairePhone(String petitionnairePhone) {
		_petition.setPetitionnairePhone(petitionnairePhone);
	}

	/**
	 * Sets the petitionnaire postal code of this petition.
	 *
	 * @param petitionnairePostalCode the petitionnaire postal code of this petition
	 */
	@Override
	public void setPetitionnairePostalCode(long petitionnairePostalCode) {
		_petition.setPetitionnairePostalCode(petitionnairePostalCode);
	}

	/**
	 * Sets the place text area of this petition.
	 *
	 * @param placeTextArea the place text area of this petition
	 */
	@Override
	public void setPlaceTextArea(String placeTextArea) {
		_petition.setPlaceTextArea(placeTextArea);
	}

	/**
	 * Sets the primary key of this petition.
	 *
	 * @param primaryKey the primary key of this petition
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_petition.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_petition.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the publication date of this petition.
	 *
	 * @param publicationDate the publication date of this petition
	 */
	@Override
	public void setPublicationDate(Date publicationDate) {
		_petition.setPublicationDate(publicationDate);
	}

	/**
	 * Sets the publik ID of this petition.
	 *
	 * @param publikId the publik ID of this petition
	 */
	@Override
	public void setPublikId(String publikId) {
		_petition.setPublikId(publikId);
	}

	/**
	 * Sets the quota signature of this petition.
	 *
	 * @param quotaSignature the quota signature of this petition
	 */
	@Override
	public void setQuotaSignature(long quotaSignature) {
		_petition.setQuotaSignature(quotaSignature);
	}

	/**
	 * Sets the status of this petition.
	 *
	 * @param status the status of this petition
	 */
	@Override
	public void setStatus(int status) {
		_petition.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this petition.
	 *
	 * @param statusByUserId the status by user ID of this petition
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_petition.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this petition.
	 *
	 * @param statusByUserName the status by user name of this petition
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		_petition.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this petition.
	 *
	 * @param statusByUserUuid the status by user uuid of this petition
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		_petition.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this petition.
	 *
	 * @param statusDate the status date of this petition
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		_petition.setStatusDate(statusDate);
	}

	/**
	 * Sets the summary of this petition.
	 *
	 * @param summary the summary of this petition
	 */
	@Override
	public void setSummary(String summary) {
		_petition.setSummary(summary);
	}

	/**
	 * Sets the supported by of this petition.
	 *
	 * @param supportedBy the supported by of this petition
	 */
	@Override
	public void setSupportedBy(String supportedBy) {
		_petition.setSupportedBy(supportedBy);
	}

	/**
	 * Sets the title of this petition.
	 *
	 * @param title the title of this petition
	 */
	@Override
	public void setTitle(String title) {
		_petition.setTitle(title);
	}

	/**
	 * Sets the user ID of this petition.
	 *
	 * @param userId the user ID of this petition
	 */
	@Override
	public void setUserId(long userId) {
		_petition.setUserId(userId);
	}

	/**
	 * Sets the user name of this petition.
	 *
	 * @param userName the user name of this petition
	 */
	@Override
	public void setUserName(String userName) {
		_petition.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this petition.
	 *
	 * @param userUuid the user uuid of this petition
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_petition.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this petition.
	 *
	 * @param uuid the uuid of this petition
	 */
	@Override
	public void setUuid(String uuid) {
		_petition.setUuid(uuid);
	}

	/**
	 * Sets the video url of this petition.
	 *
	 * @param videoUrl the video url of this petition
	 */
	@Override
	public void setVideoUrl(String videoUrl) {
		_petition.setVideoUrl(videoUrl);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<eu.strasbourg.service.project.model.Petition> toCacheModel() {

		return _petition.toCacheModel();
	}

	@Override
	public eu.strasbourg.service.project.model.Petition toEscapedModel() {
		return new PetitionWrapper(_petition.toEscapedModel());
	}

	/**
	 * Retourne la version JSON de l'entité
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONObject toJSON(
		String publikUserId) {

		return _petition.toJSON(publikUserId);
	}

	@Override
	public String toString() {
		return _petition.toString();
	}

	@Override
	public eu.strasbourg.service.project.model.Petition toUnescapedModel() {
		return new PetitionWrapper(_petition.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _petition.toXmlString();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PetitionWrapper)) {
			return false;
		}

		PetitionWrapper petitionWrapper = (PetitionWrapper)object;

		if (Objects.equals(_petition, petitionWrapper._petition)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _petition.getStagedModelType();
	}

	@Override
	public Petition getWrappedModel() {
		return _petition;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _petition.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _petition.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_petition.resetOriginalValues();
	}

	private final Petition _petition;

}