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
 * This class is a wrapper for {@link Initiative}.
 * </p>
 *
 * @author Cedric Henry
 * @see Initiative
 * @generated
 */
public class InitiativeWrapper
	extends BaseModelWrapper<Initiative>
	implements Initiative, ModelWrapper<Initiative> {

	public InitiativeWrapper(Initiative initiative) {
		super(initiative);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("initiativeId", getInitiativeId());
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
		attributes.put("inTheNameOf", getInTheNameOf());
		attributes.put("videoUrl", getVideoUrl());
		attributes.put("externalImageURL", getExternalImageURL());
		attributes.put("externalImageCopyright", getExternalImageCopyright());
		attributes.put("mediaChoice", isMediaChoice());
		attributes.put("assetEntryId", getAssetEntryId());
		attributes.put("publikId", getPublikId());
		attributes.put("imageId", getImageId());
		attributes.put("filesIds", getFilesIds());
		attributes.put("publicationDate", getPublicationDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long initiativeId = (Long)attributes.get("initiativeId");

		if (initiativeId != null) {
			setInitiativeId(initiativeId);
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

		String inTheNameOf = (String)attributes.get("inTheNameOf");

		if (inTheNameOf != null) {
			setInTheNameOf(inTheNameOf);
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

		Long assetEntryId = (Long)attributes.get("assetEntryId");

		if (assetEntryId != null) {
			setAssetEntryId(assetEntryId);
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

		Date publicationDate = (Date)attributes.get("publicationDate");

		if (publicationDate != null) {
			setPublicationDate(publicationDate);
		}
	}

	@Override
	public Initiative cloneWithOriginalValues() {
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
	 * Returns the asset entry ID of this initiative.
	 *
	 * @return the asset entry ID of this initiative
	 */
	@Override
	public long getAssetEntryId() {
		return model.getAssetEntryId();
	}

	/**
	 * Retourne l'utilisateur Publik depositaire
	 *
	 * @return
	 */
	@Override
	public eu.strasbourg.service.oidc.model.PublikUser getAuthor() {
		return model.getAuthor();
	}

	/**
	 * Retourne l'adresse mail du depositaire s'il existe
	 */
	@Override
	public String getAuthorEmail() {
		return model.getAuthorEmail();
	}

	/**
	 * Retourne l'URL de l'image de l'utilisateur
	 */
	@Override
	public String getAuthorImageURL() {
		return model.getAuthorImageURL();
	}

	/**
	 * Retourne le nom de du depositaire sous forme "Truc M." ou le "Au nom de ..."
	 */
	@Override
	public String getAuthorLabel() {
		return model.getAuthorLabel();
	}

	/**
	 * Retourne le nom prenom du depositaire s'il existe
	 */
	@Override
	public String getAuthorNameLabel() {
		return model.getAuthorNameLabel();
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
	 * Retourne les sous-catégories 'Territoire' correspondant aux villes de la initiative
	 *
	 * @return : null si vide, sinon la liste des catégories
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCityCategories() {

		return model.getCityCategories();
	}

	/**
	 * Returns the company ID of this initiative.
	 *
	 * @return the company ID of this initiative
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this initiative.
	 *
	 * @return the create date of this initiative
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
	 * Returns the description of this initiative.
	 *
	 * @return the description of this initiative
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the localized description of this initiative in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description of this initiative
	 */
	@Override
	public String getDescription(java.util.Locale locale) {
		return model.getDescription(locale);
	}

	/**
	 * Returns the localized description of this initiative in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this initiative. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getDescription(java.util.Locale locale, boolean useDefault) {
		return model.getDescription(locale, useDefault);
	}

	/**
	 * Returns the localized description of this initiative in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description of this initiative
	 */
	@Override
	public String getDescription(String languageId) {
		return model.getDescription(languageId);
	}

	/**
	 * Returns the localized description of this initiative in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this initiative
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
	 * Returns a map of the locales and localized descriptions of this initiative.
	 *
	 * @return the locales and localized descriptions of this initiative
	 */
	@Override
	public Map<java.util.Locale, String> getDescriptionMap() {
		return model.getDescriptionMap();
	}

	/**
	 * Retourne la liste des dislikes de l'entité
	 *
	 * @see eu.strasbourg.service.like.model.LikeType
	 */
	@Override
	public java.util.List<eu.strasbourg.service.like.model.Like> getDislikes() {
		return model.getDislikes();
	}

	/**
	 * Retourne les sous-sous-catégories 'Territoire' correspondant aux quartiers de la initiative
	 *
	 * @return : null si vide, sinon la liste des catégories
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getDistrictCategories() {

		return model.getDistrictCategories();
	}

	/**
	 * Retourne une chaine des 'Territoires' correspondant aux quartiers de la initiative
	 *
	 * @return : Chaine des quartiers ou description "Aucun" ou "Tous"
	 */
	@Override
	public String getDistrictLabel(java.util.Locale locale) {
		return model.getDistrictLabel(locale);
	}

	/**
	 * Returns the external image copyright of this initiative.
	 *
	 * @return the external image copyright of this initiative
	 */
	@Override
	public String getExternalImageCopyright() {
		return model.getExternalImageCopyright();
	}

	/**
	 * Returns the external image url of this initiative.
	 *
	 * @return the external image url of this initiative
	 */
	@Override
	public String getExternalImageURL() {
		return model.getExternalImageURL();
	}

	/**
	 * Returns the files IDs of this initiative.
	 *
	 * @return the files IDs of this initiative
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
	 * Returns the group ID of this initiative.
	 *
	 * @return the group ID of this initiative
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Retourne les aides qu'on affiche de l'initiative
	 */
	@Override
	public java.util.List<eu.strasbourg.service.project.model.InitiativeHelp>
		getHelps() {

		return model.getHelps();
	}

	/**
	 * Retourne le copyright de l'image principale
	 */
	@Override
	public String getImageCopyright(java.util.Locale locale) {
		return model.getImageCopyright(locale);
	}

	/**
	 * Returns the image ID of this initiative.
	 *
	 * @return the image ID of this initiative
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
	 * Returns the initiative ID of this initiative.
	 *
	 * @return the initiative ID of this initiative
	 */
	@Override
	public long getInitiativeId() {
		return model.getInitiativeId();
	}

	/**
	 * Returns the in the name of of this initiative.
	 *
	 * @return the in the name of of this initiative
	 */
	@Override
	public String getInTheNameOf() {
		return model.getInTheNameOf();
	}

	/**
	 * Retourne la liste des likes de l'entité
	 *
	 * @see eu.strasbourg.service.like.model.LikeType
	 */
	@Override
	public java.util.List<eu.strasbourg.service.like.model.Like> getLikes() {
		return model.getLikes();
	}

	/**
	 * Retourne la liste des like/dislike de l'entité
	 *
	 * @see eu.strasbourg.service.like.model.LikeType
	 */
	@Override
	public java.util.List<eu.strasbourg.service.like.model.Like>
		getLikesDislikes() {

		return model.getLikesDislikes();
	}

	/**
	 * Returns the media choice of this initiative.
	 *
	 * @return the media choice of this initiative
	 */
	@Override
	public boolean getMediaChoice() {
		return model.getMediaChoice();
	}

	/**
	 * Returns the modified date of this initiative.
	 *
	 * @return the modified date of this initiative
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
	 * Retourne le nombre de dislikes de l'entité
	 *
	 * @see eu.strasbourg.service.like.model.LikeType
	 */
	@Override
	public int getNbDislikes() {
		return model.getNbDislikes();
	}

	/**
	 * Retourne le nombre d'aides de l'initiative
	 */
	@Override
	public int getNbHelps() {
		return model.getNbHelps();
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
	 * Retourne le nombre de likes/dislikes de l'entité
	 *
	 * @see eu.strasbourg.service.like.model.LikeType
	 */
	@Override
	public int getNbLikesDislikes() {
		return model.getNbLikesDislikes();
	}

	/**
	 * Retourne les noms des lieux placit de l'initiative
	 */
	@Override
	public java.util.List<String> getPlaceNames(java.util.Locale locale) {
		return model.getPlaceNames(locale);
	}

	/**
	 * Retourne les ids SIG des lieux placit de l'initiative
	 */
	@Override
	public java.util.List<String> getPlaceSIGIds(java.util.Locale locale) {
		return model.getPlaceSIGIds(locale);
	}

	/**
	 * Returns the place text area of this initiative.
	 *
	 * @return the place text area of this initiative
	 */
	@Override
	public String getPlaceTextArea() {
		return model.getPlaceTextArea();
	}

	/**
	 * Retourne la liste des lieux placit liés à l'initiative
	 */
	@Override
	public java.util.List<eu.strasbourg.service.project.model.PlacitPlace>
		getPlacitPlaces() {

		return model.getPlacitPlaces();
	}

	/**
	 * Returns the primary key of this initiative.
	 *
	 * @return the primary key of this initiative
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Retourne la categorie projet
	 */
	@Override
	public com.liferay.asset.kernel.model.AssetCategory getProjectCategory() {
		return model.getProjectCategory();
	}

	/**
	 * Retourne la titre du projet
	 */
	@Override
	public String getProjectName() {
		return model.getProjectName();
	}

	/**
	 * Returns the publication date of this initiative.
	 *
	 * @return the publication date of this initiative
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
	 * Returns the publik ID of this initiative.
	 *
	 * @return the publik ID of this initiative
	 */
	@Override
	public String getPublikId() {
		return model.getPublikId();
	}

	/**
	 * Returns the status of this initiative.
	 *
	 * @return the status of this initiative
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this initiative.
	 *
	 * @return the status by user ID of this initiative
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this initiative.
	 *
	 * @return the status by user name of this initiative
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this initiative.
	 *
	 * @return the status by user uuid of this initiative
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Retourne le statut de l'initiative (
	 */
	@Override
	public com.liferay.asset.kernel.model.AssetCategory getStatusCategory() {
		return model.getStatusCategory();
	}

	/**
	 * Retourne la couleur hexa du statut de l'initiative contenu dans la
	 * propriete 'code_color' de la categorie associee
	 */
	@Override
	public String getStatusCategoryColor() {
		return model.getStatusCategoryColor();
	}

	/**
	 * Returns the status date of this initiative.
	 *
	 * @return the status date of this initiative
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Retourne X suggestions max pour une initiative
	 *
	 * @param request la requete
	 * @param nbSuggestions le nombre de suggestions.
	 * @return la liste d'initiatives.
	 */
	@Override
	public java.util.List<eu.strasbourg.service.project.model.Initiative>
			getSuggestions(
				javax.servlet.http.HttpServletRequest request,
				int nbSuggestions)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.search.SearchException {

		return model.getSuggestions(request, nbSuggestions);
	}

	/**
	 * Retourne les catégories 'Territoire' correspondant aux pays de la initiative
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getTerritoryCategories() {

		return model.getTerritoryCategories();
	}

	/**
	 * Retourne les thematiques de la initiative (
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getThematicCategories() {

		return model.getThematicCategories();
	}

	/**
	 * Retourne une chaine des 'Thematics' sépararée d'un '-'
	 */
	@Override
	public String getThematicsLabel(java.util.Locale locale) {
		return model.getThematicsLabel(locale);
	}

	/**
	 * Returns the title of this initiative.
	 *
	 * @return the title of this initiative
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the user ID of this initiative.
	 *
	 * @return the user ID of this initiative
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this initiative.
	 *
	 * @return the user name of this initiative
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this initiative.
	 *
	 * @return the user uuid of this initiative
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this initiative.
	 *
	 * @return the uuid of this initiative
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the video url of this initiative.
	 *
	 * @return the video url of this initiative
	 */
	@Override
	public String getVideoUrl() {
		return model.getVideoUrl();
	}

	/**
	 * Returns <code>true</code> if this initiative is approved.
	 *
	 * @return <code>true</code> if this initiative is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this initiative is denied.
	 *
	 * @return <code>true</code> if this initiative is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this initiative is a draft.
	 *
	 * @return <code>true</code> if this initiative is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this initiative is expired.
	 *
	 * @return <code>true</code> if this initiative is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this initiative is inactive.
	 *
	 * @return <code>true</code> if this initiative is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this initiative is incomplete.
	 *
	 * @return <code>true</code> if this initiative is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this initiative is media choice.
	 *
	 * @return <code>true</code> if this initiative is media choice; <code>false</code> otherwise
	 */
	@Override
	public boolean isMediaChoice() {
		return model.isMediaChoice();
	}

	/**
	 * Returns <code>true</code> if this initiative is pending.
	 *
	 * @return <code>true</code> if this initiative is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this initiative is scheduled.
	 *
	 * @return <code>true</code> if this initiative is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
	}

	/**
	 * L'utilisateur donne a t-il deja propose son aide a l'initiative
	 *
	 * @param publikUserId L'identifiant Publik de l'utilisateur
	 * @return La verite
	 */
	@Override
	public boolean isUserAlreadyHelp(String publikUserId) {
		return model.isUserAlreadyHelp(publikUserId);
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
	 * Sets the asset entry ID of this initiative.
	 *
	 * @param assetEntryId the asset entry ID of this initiative
	 */
	@Override
	public void setAssetEntryId(long assetEntryId) {
		model.setAssetEntryId(assetEntryId);
	}

	/**
	 * Sets the company ID of this initiative.
	 *
	 * @param companyId the company ID of this initiative
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this initiative.
	 *
	 * @param createDate the create date of this initiative
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this initiative.
	 *
	 * @param description the description of this initiative
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the localized description of this initiative in the language.
	 *
	 * @param description the localized description of this initiative
	 * @param locale the locale of the language
	 */
	@Override
	public void setDescription(String description, java.util.Locale locale) {
		model.setDescription(description, locale);
	}

	/**
	 * Sets the localized description of this initiative in the language, and sets the default locale.
	 *
	 * @param description the localized description of this initiative
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
	 * Sets the localized descriptions of this initiative from the map of locales and localized descriptions.
	 *
	 * @param descriptionMap the locales and localized descriptions of this initiative
	 */
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, String> descriptionMap) {

		model.setDescriptionMap(descriptionMap);
	}

	/**
	 * Sets the localized descriptions of this initiative from the map of locales and localized descriptions, and sets the default locale.
	 *
	 * @param descriptionMap the locales and localized descriptions of this initiative
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, String> descriptionMap,
		java.util.Locale defaultLocale) {

		model.setDescriptionMap(descriptionMap, defaultLocale);
	}

	/**
	 * Sets the external image copyright of this initiative.
	 *
	 * @param externalImageCopyright the external image copyright of this initiative
	 */
	@Override
	public void setExternalImageCopyright(String externalImageCopyright) {
		model.setExternalImageCopyright(externalImageCopyright);
	}

	/**
	 * Sets the external image url of this initiative.
	 *
	 * @param externalImageURL the external image url of this initiative
	 */
	@Override
	public void setExternalImageURL(String externalImageURL) {
		model.setExternalImageURL(externalImageURL);
	}

	/**
	 * Sets the files IDs of this initiative.
	 *
	 * @param filesIds the files IDs of this initiative
	 */
	@Override
	public void setFilesIds(String filesIds) {
		model.setFilesIds(filesIds);
	}

	/**
	 * Sets the group ID of this initiative.
	 *
	 * @param groupId the group ID of this initiative
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the image ID of this initiative.
	 *
	 * @param imageId the image ID of this initiative
	 */
	@Override
	public void setImageId(long imageId) {
		model.setImageId(imageId);
	}

	/**
	 * Sets the initiative ID of this initiative.
	 *
	 * @param initiativeId the initiative ID of this initiative
	 */
	@Override
	public void setInitiativeId(long initiativeId) {
		model.setInitiativeId(initiativeId);
	}

	/**
	 * Sets the in the name of of this initiative.
	 *
	 * @param inTheNameOf the in the name of of this initiative
	 */
	@Override
	public void setInTheNameOf(String inTheNameOf) {
		model.setInTheNameOf(inTheNameOf);
	}

	/**
	 * Sets whether this initiative is media choice.
	 *
	 * @param mediaChoice the media choice of this initiative
	 */
	@Override
	public void setMediaChoice(boolean mediaChoice) {
		model.setMediaChoice(mediaChoice);
	}

	/**
	 * Sets the modified date of this initiative.
	 *
	 * @param modifiedDate the modified date of this initiative
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the place text area of this initiative.
	 *
	 * @param placeTextArea the place text area of this initiative
	 */
	@Override
	public void setPlaceTextArea(String placeTextArea) {
		model.setPlaceTextArea(placeTextArea);
	}

	/**
	 * Sets the primary key of this initiative.
	 *
	 * @param primaryKey the primary key of this initiative
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the publication date of this initiative.
	 *
	 * @param publicationDate the publication date of this initiative
	 */
	@Override
	public void setPublicationDate(Date publicationDate) {
		model.setPublicationDate(publicationDate);
	}

	/**
	 * Sets the publik ID of this initiative.
	 *
	 * @param publikId the publik ID of this initiative
	 */
	@Override
	public void setPublikId(String publikId) {
		model.setPublikId(publikId);
	}

	/**
	 * Sets the status of this initiative.
	 *
	 * @param status the status of this initiative
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this initiative.
	 *
	 * @param statusByUserId the status by user ID of this initiative
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this initiative.
	 *
	 * @param statusByUserName the status by user name of this initiative
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this initiative.
	 *
	 * @param statusByUserUuid the status by user uuid of this initiative
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this initiative.
	 *
	 * @param statusDate the status date of this initiative
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the title of this initiative.
	 *
	 * @param title the title of this initiative
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the user ID of this initiative.
	 *
	 * @param userId the user ID of this initiative
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this initiative.
	 *
	 * @param userName the user name of this initiative
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this initiative.
	 *
	 * @param userUuid the user uuid of this initiative
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this initiative.
	 *
	 * @param uuid the uuid of this initiative
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the video url of this initiative.
	 *
	 * @param videoUrl the video url of this initiative
	 */
	@Override
	public void setVideoUrl(String videoUrl) {
		model.setVideoUrl(videoUrl);
	}

	/**
	 * Retourne la version JSON de l'entité
	 *
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONObject toJSON()
		throws com.liferay.portal.kernel.exception.PortalException {

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
	protected InitiativeWrapper wrap(Initiative initiative) {
		return new InitiativeWrapper(initiative);
	}

}