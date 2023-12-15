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
 * This class is a wrapper for {@link Petition}.
 * </p>
 *
 * @author Cedric Henry
 * @see Petition
 * @generated
 */
public class PetitionWrapper
	extends BaseModelWrapper<Petition>
	implements ModelWrapper<Petition>, Petition {

	public PetitionWrapper(Petition petition) {
		super(petition);
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
	public Petition cloneWithOriginalValues() {
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

	@Override
	public String getAssetEntryTitle() {
		return model.getAssetEntryTitle();
	}

	/**
	 * Retourne l'URL de l'image de l'utilisateur
	 */
	@Override
	public String getAuthorImageURL() {
		return model.getAuthorImageURL();
	}

	/**
	 * Retourne le nom du depositaire sous forme "Truc M." ou le "Au nom de ..."
	 */
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
	 * Returns the company ID of this petition.
	 *
	 * @return the company ID of this petition
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * méthode permettant de récuperer les faux signataires d'une pétitions.
	 *
	 * @return les faux signataires.
	 */
	@Override
	public int getCountFakeSignataire() {
		return model.getCountFakeSignataire();
	}

	/**
	 * Returns the create date of this petition.
	 *
	 * @return the create date of this petition
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
	 * Returns the description of this petition.
	 *
	 * @return the description of this petition
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the localized description of this petition in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description of this petition
	 */
	@Override
	public String getDescription(java.util.Locale locale) {
		return model.getDescription(locale);
	}

	/**
	 * Returns the localized description of this petition in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this petition. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getDescription(java.util.Locale locale, boolean useDefault) {
		return model.getDescription(locale, useDefault);
	}

	/**
	 * Returns the localized description of this petition in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description of this petition
	 */
	@Override
	public String getDescription(String languageId) {
		return model.getDescription(languageId);
	}

	/**
	 * Returns the localized description of this petition in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this petition
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
	 * Returns a map of the locales and localized descriptions of this petition.
	 *
	 * @return the locales and localized descriptions of this petition
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
	 * Returns the expiration date of this petition.
	 *
	 * @return the expiration date of this petition
	 */
	@Override
	public Date getExpirationDate() {
		return model.getExpirationDate();
	}

	/**
	 * Returns the extension date of this petition.
	 *
	 * @return the extension date of this petition
	 */
	@Override
	public Date getExtensionDate() {
		return model.getExtensionDate();
	}

	/**
	 * Returns the external image copyright of this petition.
	 *
	 * @return the external image copyright of this petition
	 */
	@Override
	public String getExternalImageCopyright() {
		return model.getExternalImageCopyright();
	}

	/**
	 * Returns the external image url of this petition.
	 *
	 * @return the external image url of this petition
	 */
	@Override
	public String getExternalImageURL() {
		return model.getExternalImageURL();
	}

	/**
	 * Returns the files download of this petition.
	 *
	 * @return the files download of this petition
	 */
	@Override
	public String getFilesDownload() {
		return model.getFilesDownload();
	}

	/**
	 * Returns the files IDs of this petition.
	 *
	 * @return the files IDs of this petition
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
	 * méthode de récupération du status
	 *
	 * @return le status.
	 */
	@Override
	public String getFrontStatusFR() {
		return model.getFrontStatusFR();
	}

	/**
	 * Returns the group ID of this petition.
	 *
	 * @return the group ID of this petition
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
	 * Returns the image ID of this petition.
	 *
	 * @return the image ID of this petition
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
	 * Returns the in the name of of this petition.
	 *
	 * @return the in the name of of this petition
	 */
	@Override
	public String getInTheNameOf() {
		return model.getInTheNameOf();
	}

	/**
	 * Returns the is supported of this petition.
	 *
	 * @return the is supported of this petition
	 */
	@Override
	public boolean getIsSupported() {
		return model.getIsSupported();
	}

	/**
	 * Returns the media choice of this petition.
	 *
	 * @return the media choice of this petition
	 */
	@Override
	public boolean getMediaChoice() {
		return model.getMediaChoice();
	}

	/**
	 * Returns the modified date of this petition.
	 *
	 * @return the modified date of this petition
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
	 * Retourne le nombre de dislikes de l'entité
	 *
	 * @see eu.strasbourg.service.like.model.LikeType
	 */
	@Override
	public int getNbDislikes() {
		return model.getNbDislikes();
	}

	/**
	 * Retourne le nombre de likes de l'entité
	 *
	 * @see eu.strasbourg.service.like.model.LikeType
	 */
	@Override
	public int getNbLikes() {
		return model.getNbLikes();
	}

	/**
	 * Méthode permettant de retourner le nombre de signataire de la pétition
	 *
	 * @return le nombre.
	 */
	@Override
	public long getNombreSignature() {
		return model.getNombreSignature();
	}

	/**
	 * méthode permettant d'afficher le nombre de signature.
	 *
	 * @return le nombre avec des zeros devant.
	 */
	@Override
	public String getNombreSignatureBoard() {
		return model.getNombreSignatureBoard();
	}

	/**
	 * Returns the petition ID of this petition.
	 *
	 * @return the petition ID of this petition
	 */
	@Override
	public long getPetitionId() {
		return model.getPetitionId();
	}

	/**
	 * Returns the petitionnaire adresse of this petition.
	 *
	 * @return the petitionnaire adresse of this petition
	 */
	@Override
	public String getPetitionnaireAdresse() {
		return model.getPetitionnaireAdresse();
	}

	/**
	 * Returns the petitionnaire birthday of this petition.
	 *
	 * @return the petitionnaire birthday of this petition
	 */
	@Override
	public Date getPetitionnaireBirthday() {
		return model.getPetitionnaireBirthday();
	}

	/**
	 * Returns the petitionnaire city of this petition.
	 *
	 * @return the petitionnaire city of this petition
	 */
	@Override
	public String getPetitionnaireCity() {
		return model.getPetitionnaireCity();
	}

	/**
	 * Returns the petitionnaire email of this petition.
	 *
	 * @return the petitionnaire email of this petition
	 */
	@Override
	public String getPetitionnaireEmail() {
		return model.getPetitionnaireEmail();
	}

	/**
	 * Returns the petitionnaire firstname of this petition.
	 *
	 * @return the petitionnaire firstname of this petition
	 */
	@Override
	public String getPetitionnaireFirstname() {
		return model.getPetitionnaireFirstname();
	}

	/**
	 * Returns the petitionnaire lastname of this petition.
	 *
	 * @return the petitionnaire lastname of this petition
	 */
	@Override
	public String getPetitionnaireLastname() {
		return model.getPetitionnaireLastname();
	}

	/**
	 * Returns the petitionnaire phone of this petition.
	 *
	 * @return the petitionnaire phone of this petition
	 */
	@Override
	public String getPetitionnairePhone() {
		return model.getPetitionnairePhone();
	}

	/**
	 * Returns the petitionnaire postal code of this petition.
	 *
	 * @return the petitionnaire postal code of this petition
	 */
	@Override
	public long getPetitionnairePostalCode() {
		return model.getPetitionnairePostalCode();
	}

	/**
	 * méthode de récupération du status
	 *
	 * @return le status.
	 */
	@Override
	public String getPetitionStatus() {
		return model.getPetitionStatus();
	}

	/**
	 * Retourne le status de la petition
	 */
	@Override
	public com.liferay.asset.kernel.model.AssetCategory
		getPetitionStatusCategory() {

		return model.getPetitionStatusCategory();
	}

	/**
	 * méthode d'affichage des information du status pour excel.
	 *
	 * @return le status.
	 */
	@Override
	public String getPetitionStatusExcel() {
		return model.getPetitionStatusExcel();
	}

	/**
	 * Returns the place text area of this petition.
	 *
	 * @return the place text area of this petition
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
	 * méthode permettant de récupérer le pourcentage de signatures obtenu.
	 *
	 * @return le pourcentage en long.
	 */
	@Override
	public double getPourcentageSignature() {
		return model.getPourcentageSignature();
	}

	/**
	 * Returns the primary key of this petition.
	 *
	 * @return the primary key of this petition
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * méthode de récupération du status
	 *
	 * @return le status.
	 */
	@Override
	public String getProDureeFR() {
		return model.getProDureeFR();
	}

	/**
	 * Retourne le projet de la petition (
	 */
	@Override
	public com.liferay.asset.kernel.model.AssetCategory getProjectCategory() {
		return model.getProjectCategory();
	}

	@Override
	public String getProjectTitle(java.util.Locale locale) {
		return model.getProjectTitle(locale);
	}

	/**
	 * Returns the publication date of this petition.
	 *
	 * @return the publication date of this petition
	 */
	@Override
	public Date getPublicationDate() {
		return model.getPublicationDate();
	}

	@Override
	public String getPublicationDateFr() {
		return model.getPublicationDateFr();
	}

	/**
	 * Returns the publik ID of this petition.
	 *
	 * @return the publik ID of this petition
	 */
	@Override
	public String getPublikId() {
		return model.getPublikId();
	}

	/**
	 * Returns the quota signature of this petition.
	 *
	 * @return the quota signature of this petition
	 */
	@Override
	public long getQuotaSignature() {
		return model.getQuotaSignature();
	}

	/**
	 * méthode permettant de récuperer le nombre de signataire nécessaire pour finir la pétition.
	 *
	 * @return le nombre
	 */
	@Override
	public long getSignataireNeeded() {
		return model.getSignataireNeeded();
	}

	@Override
	public java.util.List<eu.strasbourg.service.project.model.Signataire>
		getSignataires() {

		return model.getSignataires();
	}

	/**
	 * Returns the status of this petition.
	 *
	 * @return the status of this petition
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this petition.
	 *
	 * @return the status by user ID of this petition
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this petition.
	 *
	 * @return the status by user name of this petition
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this petition.
	 *
	 * @return the status by user uuid of this petition
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this petition.
	 *
	 * @return the status date of this petition
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
	public java.util.List<eu.strasbourg.service.project.model.Petition>
			getSuggestions(
				javax.servlet.http.HttpServletRequest request,
				int nbSuggestions)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.search.SearchException {

		return model.getSuggestions(request, nbSuggestions);
	}

	/**
	 * Returns the summary of this petition.
	 *
	 * @return the summary of this petition
	 */
	@Override
	public String getSummary() {
		return model.getSummary();
	}

	/**
	 * Returns the supported by of this petition.
	 *
	 * @return the supported by of this petition
	 */
	@Override
	public String getSupportedBy() {
		return model.getSupportedBy();
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
	 * Retourne les thematiques de la petition (
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
	 * Returns the title of this petition.
	 *
	 * @return the title of this petition
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Calcul la différence de jours entre la date du jour et celle d'expiration
	 */
	@Override
	public int getTodayExpirationDifferenceDays() {
		return model.getTodayExpirationDifferenceDays();
	}

	/**
	 * Returns the user ID of this petition.
	 *
	 * @return the user ID of this petition
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this petition.
	 *
	 * @return the user name of this petition
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this petition.
	 *
	 * @return the user uuid of this petition
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this petition.
	 *
	 * @return the uuid of this petition
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the video url of this petition.
	 *
	 * @return the video url of this petition
	 */
	@Override
	public String getVideoUrl() {
		return model.getVideoUrl();
	}

	/**
	 * Demande si l'utilisateur demandé a signe la petition
	 *
	 * @throws PortletException
	 */
	@Override
	public boolean hasUserSigned(String publikUserId)
		throws javax.portlet.PortletException {

		return model.hasUserSigned(publikUserId);
	}

	/**
	 * Returns <code>true</code> if this petition is approved.
	 *
	 * @return <code>true</code> if this petition is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this petition is denied.
	 *
	 * @return <code>true</code> if this petition is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this petition is a draft.
	 *
	 * @return <code>true</code> if this petition is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this petition is expired.
	 *
	 * @return <code>true</code> if this petition is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this petition is inactive.
	 *
	 * @return <code>true</code> if this petition is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this petition is incomplete.
	 *
	 * @return <code>true</code> if this petition is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this petition is is supported.
	 *
	 * @return <code>true</code> if this petition is is supported; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsSupported() {
		return model.isIsSupported();
	}

	/**
	 * Peut apporter une reaction (commenter, liker, participer) a l'entite
	 */
	@Override
	public boolean isJudgeable() {
		return model.isJudgeable();
	}

	/**
	 * Returns <code>true</code> if this petition is media choice.
	 *
	 * @return <code>true</code> if this petition is media choice; <code>false</code> otherwise
	 */
	@Override
	public boolean isMediaChoice() {
		return model.isMediaChoice();
	}

	/**
	 * Returns <code>true</code> if this petition is pending.
	 *
	 * @return <code>true</code> if this petition is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this petition is scheduled.
	 *
	 * @return <code>true</code> if this petition is scheduled; <code>false</code> otherwise
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
	 * Sets the company ID of this petition.
	 *
	 * @param companyId the company ID of this petition
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this petition.
	 *
	 * @param createDate the create date of this petition
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this petition.
	 *
	 * @param description the description of this petition
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the localized description of this petition in the language.
	 *
	 * @param description the localized description of this petition
	 * @param locale the locale of the language
	 */
	@Override
	public void setDescription(String description, java.util.Locale locale) {
		model.setDescription(description, locale);
	}

	/**
	 * Sets the localized description of this petition in the language, and sets the default locale.
	 *
	 * @param description the localized description of this petition
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
	 * Sets the localized descriptions of this petition from the map of locales and localized descriptions.
	 *
	 * @param descriptionMap the locales and localized descriptions of this petition
	 */
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, String> descriptionMap) {

		model.setDescriptionMap(descriptionMap);
	}

	/**
	 * Sets the localized descriptions of this petition from the map of locales and localized descriptions, and sets the default locale.
	 *
	 * @param descriptionMap the locales and localized descriptions of this petition
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, String> descriptionMap,
		java.util.Locale defaultLocale) {

		model.setDescriptionMap(descriptionMap, defaultLocale);
	}

	/**
	 * Sets the expiration date of this petition.
	 *
	 * @param expirationDate the expiration date of this petition
	 */
	@Override
	public void setExpirationDate(Date expirationDate) {
		model.setExpirationDate(expirationDate);
	}

	/**
	 * Sets the extension date of this petition.
	 *
	 * @param extensionDate the extension date of this petition
	 */
	@Override
	public void setExtensionDate(Date extensionDate) {
		model.setExtensionDate(extensionDate);
	}

	/**
	 * Sets the external image copyright of this petition.
	 *
	 * @param externalImageCopyright the external image copyright of this petition
	 */
	@Override
	public void setExternalImageCopyright(String externalImageCopyright) {
		model.setExternalImageCopyright(externalImageCopyright);
	}

	/**
	 * Sets the external image url of this petition.
	 *
	 * @param externalImageURL the external image url of this petition
	 */
	@Override
	public void setExternalImageURL(String externalImageURL) {
		model.setExternalImageURL(externalImageURL);
	}

	/**
	 * Sets the files download of this petition.
	 *
	 * @param filesDownload the files download of this petition
	 */
	@Override
	public void setFilesDownload(String filesDownload) {
		model.setFilesDownload(filesDownload);
	}

	/**
	 * Sets the files IDs of this petition.
	 *
	 * @param filesIds the files IDs of this petition
	 */
	@Override
	public void setFilesIds(String filesIds) {
		model.setFilesIds(filesIds);
	}

	/**
	 * Sets the group ID of this petition.
	 *
	 * @param groupId the group ID of this petition
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the image ID of this petition.
	 *
	 * @param imageId the image ID of this petition
	 */
	@Override
	public void setImageId(long imageId) {
		model.setImageId(imageId);
	}

	/**
	 * Sets the in the name of of this petition.
	 *
	 * @param inTheNameOf the in the name of of this petition
	 */
	@Override
	public void setInTheNameOf(String inTheNameOf) {
		model.setInTheNameOf(inTheNameOf);
	}

	/**
	 * Sets whether this petition is is supported.
	 *
	 * @param isSupported the is supported of this petition
	 */
	@Override
	public void setIsSupported(boolean isSupported) {
		model.setIsSupported(isSupported);
	}

	/**
	 * Sets whether this petition is media choice.
	 *
	 * @param mediaChoice the media choice of this petition
	 */
	@Override
	public void setMediaChoice(boolean mediaChoice) {
		model.setMediaChoice(mediaChoice);
	}

	/**
	 * Sets the modified date of this petition.
	 *
	 * @param modifiedDate the modified date of this petition
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the petition ID of this petition.
	 *
	 * @param petitionId the petition ID of this petition
	 */
	@Override
	public void setPetitionId(long petitionId) {
		model.setPetitionId(petitionId);
	}

	/**
	 * Sets the petitionnaire adresse of this petition.
	 *
	 * @param petitionnaireAdresse the petitionnaire adresse of this petition
	 */
	@Override
	public void setPetitionnaireAdresse(String petitionnaireAdresse) {
		model.setPetitionnaireAdresse(petitionnaireAdresse);
	}

	/**
	 * Sets the petitionnaire birthday of this petition.
	 *
	 * @param petitionnaireBirthday the petitionnaire birthday of this petition
	 */
	@Override
	public void setPetitionnaireBirthday(Date petitionnaireBirthday) {
		model.setPetitionnaireBirthday(petitionnaireBirthday);
	}

	/**
	 * Sets the petitionnaire city of this petition.
	 *
	 * @param petitionnaireCity the petitionnaire city of this petition
	 */
	@Override
	public void setPetitionnaireCity(String petitionnaireCity) {
		model.setPetitionnaireCity(petitionnaireCity);
	}

	/**
	 * Sets the petitionnaire email of this petition.
	 *
	 * @param petitionnaireEmail the petitionnaire email of this petition
	 */
	@Override
	public void setPetitionnaireEmail(String petitionnaireEmail) {
		model.setPetitionnaireEmail(petitionnaireEmail);
	}

	/**
	 * Sets the petitionnaire firstname of this petition.
	 *
	 * @param petitionnaireFirstname the petitionnaire firstname of this petition
	 */
	@Override
	public void setPetitionnaireFirstname(String petitionnaireFirstname) {
		model.setPetitionnaireFirstname(petitionnaireFirstname);
	}

	/**
	 * Sets the petitionnaire lastname of this petition.
	 *
	 * @param petitionnaireLastname the petitionnaire lastname of this petition
	 */
	@Override
	public void setPetitionnaireLastname(String petitionnaireLastname) {
		model.setPetitionnaireLastname(petitionnaireLastname);
	}

	/**
	 * Sets the petitionnaire phone of this petition.
	 *
	 * @param petitionnairePhone the petitionnaire phone of this petition
	 */
	@Override
	public void setPetitionnairePhone(String petitionnairePhone) {
		model.setPetitionnairePhone(petitionnairePhone);
	}

	/**
	 * Sets the petitionnaire postal code of this petition.
	 *
	 * @param petitionnairePostalCode the petitionnaire postal code of this petition
	 */
	@Override
	public void setPetitionnairePostalCode(long petitionnairePostalCode) {
		model.setPetitionnairePostalCode(petitionnairePostalCode);
	}

	/**
	 * Sets the place text area of this petition.
	 *
	 * @param placeTextArea the place text area of this petition
	 */
	@Override
	public void setPlaceTextArea(String placeTextArea) {
		model.setPlaceTextArea(placeTextArea);
	}

	/**
	 * Sets the primary key of this petition.
	 *
	 * @param primaryKey the primary key of this petition
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the publication date of this petition.
	 *
	 * @param publicationDate the publication date of this petition
	 */
	@Override
	public void setPublicationDate(Date publicationDate) {
		model.setPublicationDate(publicationDate);
	}

	/**
	 * Sets the publik ID of this petition.
	 *
	 * @param publikId the publik ID of this petition
	 */
	@Override
	public void setPublikId(String publikId) {
		model.setPublikId(publikId);
	}

	/**
	 * Sets the quota signature of this petition.
	 *
	 * @param quotaSignature the quota signature of this petition
	 */
	@Override
	public void setQuotaSignature(long quotaSignature) {
		model.setQuotaSignature(quotaSignature);
	}

	/**
	 * Sets the status of this petition.
	 *
	 * @param status the status of this petition
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this petition.
	 *
	 * @param statusByUserId the status by user ID of this petition
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this petition.
	 *
	 * @param statusByUserName the status by user name of this petition
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this petition.
	 *
	 * @param statusByUserUuid the status by user uuid of this petition
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this petition.
	 *
	 * @param statusDate the status date of this petition
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the summary of this petition.
	 *
	 * @param summary the summary of this petition
	 */
	@Override
	public void setSummary(String summary) {
		model.setSummary(summary);
	}

	/**
	 * Sets the supported by of this petition.
	 *
	 * @param supportedBy the supported by of this petition
	 */
	@Override
	public void setSupportedBy(String supportedBy) {
		model.setSupportedBy(supportedBy);
	}

	/**
	 * Sets the title of this petition.
	 *
	 * @param title the title of this petition
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the user ID of this petition.
	 *
	 * @param userId the user ID of this petition
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this petition.
	 *
	 * @param userName the user name of this petition
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this petition.
	 *
	 * @param userUuid the user uuid of this petition
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this petition.
	 *
	 * @param uuid the uuid of this petition
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the video url of this petition.
	 *
	 * @param videoUrl the video url of this petition
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
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected PetitionWrapper wrap(Petition petition) {
		return new PetitionWrapper(petition);
	}

}