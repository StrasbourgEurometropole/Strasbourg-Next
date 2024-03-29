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
 * This class is a wrapper for {@link Initiative}.
 * </p>
 *
 * @author Cedric Henry
 * @see Initiative
 * @generated
 */
public class InitiativeWrapper implements Initiative, ModelWrapper<Initiative> {

	public InitiativeWrapper(Initiative initiative) {
		_initiative = initiative;
	}

	@Override
	public Class<?> getModelClass() {
		return Initiative.class;
	}

	@Override
	public String getModelClassName() {
		return Initiative.class.getName();
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
	public Object clone() {
		return new InitiativeWrapper((Initiative)_initiative.clone());
	}

	@Override
	public int compareTo(
		eu.strasbourg.service.project.model.Initiative initiative) {

		return _initiative.compareTo(initiative);
	}

	/**
	 * Retourne les commentaires de l'entité
	 */
	@Override
	public java.util.List<eu.strasbourg.service.comment.model.Comment>
		getApprovedComments() {

		return _initiative.getApprovedComments();
	}

	/**
	 * Retourne l'AssetEntry rattaché cet item
	 */
	@Override
	public com.liferay.asset.kernel.model.AssetEntry getAssetEntry() {
		return _initiative.getAssetEntry();
	}

	/**
	 * Returns the asset entry ID of this initiative.
	 *
	 * @return the asset entry ID of this initiative
	 */
	@Override
	public long getAssetEntryId() {
		return _initiative.getAssetEntryId();
	}

	/**
	 * Retourne l'utilisateur Publik depositaire
	 *
	 * @return
	 */
	@Override
	public eu.strasbourg.service.oidc.model.PublikUser getAuthor() {
		return _initiative.getAuthor();
	}

	/**
	 * Retourne l'adresse mail du depositaire s'il existe
	 */
	@Override
	public String getAuthorEmail() {
		return _initiative.getAuthorEmail();
	}

	/**
	 * Retourne l'URL de l'image de l'utilisateur
	 */
	@Override
	public String getAuthorImageURL() {
		return _initiative.getAuthorImageURL();
	}

	/**
	 * Retourne le nom de du depositaire sous forme "Truc M." ou le "Au nom de ..."
	 */
	@Override
	public String getAuthorLabel() {
		return _initiative.getAuthorLabel();
	}

	/**
	 * Retourne le nom prenom du depositaire s'il existe
	 */
	@Override
	public String getAuthorNameLabel() {
		return _initiative.getAuthorNameLabel();
	}

	/**
	 * Renvoie la liste des AssetCategory rattachées à cet item (via
	 * l'assetEntry)
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCategories() {

		return _initiative.getCategories();
	}

	/**
	 * Retourne les sous-catégories 'Territoire' correspondant aux villes de la initiative
	 *
	 * @return : null si vide, sinon la liste des catégories
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCityCategories() {

		return _initiative.getCityCategories();
	}

	/**
	 * Returns the company ID of this initiative.
	 *
	 * @return the company ID of this initiative
	 */
	@Override
	public long getCompanyId() {
		return _initiative.getCompanyId();
	}

	/**
	 * Returns the create date of this initiative.
	 *
	 * @return the create date of this initiative
	 */
	@Override
	public Date getCreateDate() {
		return _initiative.getCreateDate();
	}

	/**
	 * Returns the description of this initiative.
	 *
	 * @return the description of this initiative
	 */
	@Override
	public String getDescription() {
		return _initiative.getDescription();
	}

	/**
	 * Retourne la liste des dislikes de l'entité
	 *
	 * @see eu.strasbourg.service.like.model.LikeType
	 */
	@Override
	public java.util.List<eu.strasbourg.service.like.model.Like> getDislikes() {
		return _initiative.getDislikes();
	}

	/**
	 * Retourne les sous-sous-catégories 'Territoire' correspondant aux quartiers de la initiative
	 *
	 * @return : null si vide, sinon la liste des catégories
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getDistrictCategories() {

		return _initiative.getDistrictCategories();
	}

	/**
	 * Retourne une chaine des 'Territoires' correspondant aux quartiers de la initiative
	 *
	 * @return : Chaine des quartiers ou description "Aucun" ou "Tous"
	 */
	@Override
	public String getDistrictLabel(java.util.Locale locale) {
		return _initiative.getDistrictLabel(locale);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _initiative.getExpandoBridge();
	}

	/**
	 * Returns the external image copyright of this initiative.
	 *
	 * @return the external image copyright of this initiative
	 */
	@Override
	public String getExternalImageCopyright() {
		return _initiative.getExternalImageCopyright();
	}

	/**
	 * Returns the external image url of this initiative.
	 *
	 * @return the external image url of this initiative
	 */
	@Override
	public String getExternalImageURL() {
		return _initiative.getExternalImageURL();
	}

	/**
	 * Returns the files IDs of this initiative.
	 *
	 * @return the files IDs of this initiative
	 */
	@Override
	public String getFilesIds() {
		return _initiative.getFilesIds();
	}

	/**
	 * Retourne la liste des URLs des documents
	 */
	@Override
	public java.util.List<String> getFilesURLs() {
		return _initiative.getFilesURLs();
	}

	/**
	 * Returns the group ID of this initiative.
	 *
	 * @return the group ID of this initiative
	 */
	@Override
	public long getGroupId() {
		return _initiative.getGroupId();
	}

	/**
	 * Retourne les aides qu'on affiche de l'initiative
	 */
	@Override
	public java.util.List<eu.strasbourg.service.project.model.InitiativeHelp>
		getHelps() {

		return _initiative.getHelps();
	}

	/**
	 * Retourne le copyright de l'image principale
	 */
	@Override
	public String getImageCopyright(java.util.Locale locale) {
		return _initiative.getImageCopyright(locale);
	}

	/**
	 * Returns the image ID of this initiative.
	 *
	 * @return the image ID of this initiative
	 */
	@Override
	public long getImageId() {
		return _initiative.getImageId();
	}

	/**
	 * Retourne l'URL de l'image à partir de l'id du DLFileEntry
	 */
	@Override
	public String getImageURL() {
		return _initiative.getImageURL();
	}

	/**
	 * Returns the initiative ID of this initiative.
	 *
	 * @return the initiative ID of this initiative
	 */
	@Override
	public long getInitiativeId() {
		return _initiative.getInitiativeId();
	}

	/**
	 * Returns the in the name of of this initiative.
	 *
	 * @return the in the name of of this initiative
	 */
	@Override
	public String getInTheNameOf() {
		return _initiative.getInTheNameOf();
	}

	/**
	 * Retourne la liste des likes de l'entité
	 *
	 * @see eu.strasbourg.service.like.model.LikeType
	 */
	@Override
	public java.util.List<eu.strasbourg.service.like.model.Like> getLikes() {
		return _initiative.getLikes();
	}

	/**
	 * Retourne la liste des like/dislike de l'entité
	 *
	 * @see eu.strasbourg.service.like.model.LikeType
	 */
	@Override
	public java.util.List<eu.strasbourg.service.like.model.Like>
		getLikesDislikes() {

		return _initiative.getLikesDislikes();
	}

	/**
	 * Returns the media choice of this initiative.
	 *
	 * @return the media choice of this initiative
	 */
	@Override
	public boolean getMediaChoice() {
		return _initiative.getMediaChoice();
	}

	/**
	 * Returns the modified date of this initiative.
	 *
	 * @return the modified date of this initiative
	 */
	@Override
	public Date getModifiedDate() {
		return _initiative.getModifiedDate();
	}

	/**
	 * Retourne le nombre de commentaires de l'entité
	 */
	@Override
	public int getNbApprovedComments() {
		return _initiative.getNbApprovedComments();
	}

	/**
	 * Retourne le nombre de dislikes de l'entité
	 *
	 * @see eu.strasbourg.service.like.model.LikeType
	 */
	@Override
	public int getNbDislikes() {
		return _initiative.getNbDislikes();
	}

	/**
	 * Retourne le nombre d'aides de l'initiative
	 */
	@Override
	public int getNbHelps() {
		return _initiative.getNbHelps();
	}

	/**
	 * Retourne le nombre de likes de l'entité
	 *
	 * @see eu.strasbourg.service.like.model.LikeType
	 */
	@Override
	public int getNbLikes() {
		return _initiative.getNbLikes();
	}

	/**
	 * Retourne le nombre de likes/dislikes de l'entité
	 *
	 * @see eu.strasbourg.service.like.model.LikeType
	 */
	@Override
	public int getNbLikesDislikes() {
		return _initiative.getNbLikesDislikes();
	}

	/**
	 * Retourne les noms des lieux placit de l'initiative
	 */
	@Override
	public java.util.List<String> getPlaceNames(java.util.Locale locale) {
		return _initiative.getPlaceNames(locale);
	}

	/**
	 * Retourne les ids SIG des lieux placit de l'initiative
	 */
	@Override
	public java.util.List<String> getPlaceSIGIds(java.util.Locale locale) {
		return _initiative.getPlaceSIGIds(locale);
	}

	/**
	 * Returns the place text area of this initiative.
	 *
	 * @return the place text area of this initiative
	 */
	@Override
	public String getPlaceTextArea() {
		return _initiative.getPlaceTextArea();
	}

	/**
	 * Retourne la liste des lieux placit liés à l'initiative
	 */
	@Override
	public java.util.List<eu.strasbourg.service.project.model.PlacitPlace>
		getPlacitPlaces() {

		return _initiative.getPlacitPlaces();
	}

	/**
	 * Returns the primary key of this initiative.
	 *
	 * @return the primary key of this initiative
	 */
	@Override
	public long getPrimaryKey() {
		return _initiative.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _initiative.getPrimaryKeyObj();
	}

	/**
	 * Retourne la categorie projet
	 */
	@Override
	public com.liferay.asset.kernel.model.AssetCategory getProjectCategory() {
		return _initiative.getProjectCategory();
	}

	/**
	 * Retourne la titre du projet
	 */
	@Override
	public String getProjectName() {
		return _initiative.getProjectName();
	}

	/**
	 * Returns the publication date of this initiative.
	 *
	 * @return the publication date of this initiative
	 */
	@Override
	public Date getPublicationDate() {
		return _initiative.getPublicationDate();
	}

	@Override
	public String getPublicationDateFr() {
		return _initiative.getPublicationDateFr();
	}

	/**
	 * Returns the publik ID of this initiative.
	 *
	 * @return the publik ID of this initiative
	 */
	@Override
	public String getPublikId() {
		return _initiative.getPublikId();
	}

	/**
	 * Returns the status of this initiative.
	 *
	 * @return the status of this initiative
	 */
	@Override
	public int getStatus() {
		return _initiative.getStatus();
	}

	/**
	 * Returns the status by user ID of this initiative.
	 *
	 * @return the status by user ID of this initiative
	 */
	@Override
	public long getStatusByUserId() {
		return _initiative.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this initiative.
	 *
	 * @return the status by user name of this initiative
	 */
	@Override
	public String getStatusByUserName() {
		return _initiative.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this initiative.
	 *
	 * @return the status by user uuid of this initiative
	 */
	@Override
	public String getStatusByUserUuid() {
		return _initiative.getStatusByUserUuid();
	}

	/**
	 * Retourne le statut de l'initiative (
	 */
	@Override
	public com.liferay.asset.kernel.model.AssetCategory getStatusCategory() {
		return _initiative.getStatusCategory();
	}

	/**
	 * Retourne la couleur hexa du statut de l'initiative contenu dans la
	 * propriete 'code_color' de la categorie associee
	 */
	@Override
	public String getStatusCategoryColor() {
		return _initiative.getStatusCategoryColor();
	}

	/**
	 * Returns the status date of this initiative.
	 *
	 * @return the status date of this initiative
	 */
	@Override
	public Date getStatusDate() {
		return _initiative.getStatusDate();
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

		return _initiative.getSuggestions(request, nbSuggestions);
	}

	/**
	 * Retourne les catégories 'Territoire' correspondant aux pays de la initiative
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getTerritoryCategories() {

		return _initiative.getTerritoryCategories();
	}

	/**
	 * Retourne les thematiques de la initiative (
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getThematicCategories() {

		return _initiative.getThematicCategories();
	}

	/**
	 * Retourne une chaine des 'Thematics' sépararée d'un '-'
	 */
	@Override
	public String getThematicsLabel(java.util.Locale locale) {
		return _initiative.getThematicsLabel(locale);
	}

	/**
	 * Returns the title of this initiative.
	 *
	 * @return the title of this initiative
	 */
	@Override
	public String getTitle() {
		return _initiative.getTitle();
	}

	/**
	 * Returns the user ID of this initiative.
	 *
	 * @return the user ID of this initiative
	 */
	@Override
	public long getUserId() {
		return _initiative.getUserId();
	}

	/**
	 * Returns the user name of this initiative.
	 *
	 * @return the user name of this initiative
	 */
	@Override
	public String getUserName() {
		return _initiative.getUserName();
	}

	/**
	 * Returns the user uuid of this initiative.
	 *
	 * @return the user uuid of this initiative
	 */
	@Override
	public String getUserUuid() {
		return _initiative.getUserUuid();
	}

	/**
	 * Returns the uuid of this initiative.
	 *
	 * @return the uuid of this initiative
	 */
	@Override
	public String getUuid() {
		return _initiative.getUuid();
	}

	/**
	 * Returns the video url of this initiative.
	 *
	 * @return the video url of this initiative
	 */
	@Override
	public String getVideoUrl() {
		return _initiative.getVideoUrl();
	}

	@Override
	public int hashCode() {
		return _initiative.hashCode();
	}

	/**
	 * Returns <code>true</code> if this initiative is approved.
	 *
	 * @return <code>true</code> if this initiative is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return _initiative.isApproved();
	}

	@Override
	public boolean isCachedModel() {
		return _initiative.isCachedModel();
	}

	/**
	 * Returns <code>true</code> if this initiative is denied.
	 *
	 * @return <code>true</code> if this initiative is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return _initiative.isDenied();
	}

	/**
	 * Returns <code>true</code> if this initiative is a draft.
	 *
	 * @return <code>true</code> if this initiative is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return _initiative.isDraft();
	}

	@Override
	public boolean isEscapedModel() {
		return _initiative.isEscapedModel();
	}

	/**
	 * Returns <code>true</code> if this initiative is expired.
	 *
	 * @return <code>true</code> if this initiative is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return _initiative.isExpired();
	}

	/**
	 * Returns <code>true</code> if this initiative is inactive.
	 *
	 * @return <code>true</code> if this initiative is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return _initiative.isInactive();
	}

	/**
	 * Returns <code>true</code> if this initiative is incomplete.
	 *
	 * @return <code>true</code> if this initiative is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return _initiative.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this initiative is media choice.
	 *
	 * @return <code>true</code> if this initiative is media choice; <code>false</code> otherwise
	 */
	@Override
	public boolean isMediaChoice() {
		return _initiative.isMediaChoice();
	}

	@Override
	public boolean isNew() {
		return _initiative.isNew();
	}

	/**
	 * Returns <code>true</code> if this initiative is pending.
	 *
	 * @return <code>true</code> if this initiative is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return _initiative.isPending();
	}

	/**
	 * Returns <code>true</code> if this initiative is scheduled.
	 *
	 * @return <code>true</code> if this initiative is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return _initiative.isScheduled();
	}

	/**
	 * L'utilisateur donne a t-il deja propose son aide a l'initiative
	 *
	 * @param publikUserId L'identifiant Publik de l'utilisateur
	 * @return La verite
	 */
	@Override
	public boolean isUserAlreadyHelp(String publikUserId) {
		return _initiative.isUserAlreadyHelp(publikUserId);
	}

	@Override
	public void persist() {
		_initiative.persist();
	}

	/**
	 * Sets the asset entry ID of this initiative.
	 *
	 * @param assetEntryId the asset entry ID of this initiative
	 */
	@Override
	public void setAssetEntryId(long assetEntryId) {
		_initiative.setAssetEntryId(assetEntryId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_initiative.setCachedModel(cachedModel);
	}

	/**
	 * Sets the company ID of this initiative.
	 *
	 * @param companyId the company ID of this initiative
	 */
	@Override
	public void setCompanyId(long companyId) {
		_initiative.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this initiative.
	 *
	 * @param createDate the create date of this initiative
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_initiative.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this initiative.
	 *
	 * @param description the description of this initiative
	 */
	@Override
	public void setDescription(String description) {
		_initiative.setDescription(description);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_initiative.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_initiative.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_initiative.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the external image copyright of this initiative.
	 *
	 * @param externalImageCopyright the external image copyright of this initiative
	 */
	@Override
	public void setExternalImageCopyright(String externalImageCopyright) {
		_initiative.setExternalImageCopyright(externalImageCopyright);
	}

	/**
	 * Sets the external image url of this initiative.
	 *
	 * @param externalImageURL the external image url of this initiative
	 */
	@Override
	public void setExternalImageURL(String externalImageURL) {
		_initiative.setExternalImageURL(externalImageURL);
	}

	/**
	 * Sets the files IDs of this initiative.
	 *
	 * @param filesIds the files IDs of this initiative
	 */
	@Override
	public void setFilesIds(String filesIds) {
		_initiative.setFilesIds(filesIds);
	}

	/**
	 * Sets the group ID of this initiative.
	 *
	 * @param groupId the group ID of this initiative
	 */
	@Override
	public void setGroupId(long groupId) {
		_initiative.setGroupId(groupId);
	}

	/**
	 * Sets the image ID of this initiative.
	 *
	 * @param imageId the image ID of this initiative
	 */
	@Override
	public void setImageId(long imageId) {
		_initiative.setImageId(imageId);
	}

	/**
	 * Sets the initiative ID of this initiative.
	 *
	 * @param initiativeId the initiative ID of this initiative
	 */
	@Override
	public void setInitiativeId(long initiativeId) {
		_initiative.setInitiativeId(initiativeId);
	}

	/**
	 * Sets the in the name of of this initiative.
	 *
	 * @param inTheNameOf the in the name of of this initiative
	 */
	@Override
	public void setInTheNameOf(String inTheNameOf) {
		_initiative.setInTheNameOf(inTheNameOf);
	}

	/**
	 * Sets whether this initiative is media choice.
	 *
	 * @param mediaChoice the media choice of this initiative
	 */
	@Override
	public void setMediaChoice(boolean mediaChoice) {
		_initiative.setMediaChoice(mediaChoice);
	}

	/**
	 * Sets the modified date of this initiative.
	 *
	 * @param modifiedDate the modified date of this initiative
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_initiative.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_initiative.setNew(n);
	}

	/**
	 * Sets the place text area of this initiative.
	 *
	 * @param placeTextArea the place text area of this initiative
	 */
	@Override
	public void setPlaceTextArea(String placeTextArea) {
		_initiative.setPlaceTextArea(placeTextArea);
	}

	/**
	 * Sets the primary key of this initiative.
	 *
	 * @param primaryKey the primary key of this initiative
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_initiative.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_initiative.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the publication date of this initiative.
	 *
	 * @param publicationDate the publication date of this initiative
	 */
	@Override
	public void setPublicationDate(Date publicationDate) {
		_initiative.setPublicationDate(publicationDate);
	}

	/**
	 * Sets the publik ID of this initiative.
	 *
	 * @param publikId the publik ID of this initiative
	 */
	@Override
	public void setPublikId(String publikId) {
		_initiative.setPublikId(publikId);
	}

	/**
	 * Sets the status of this initiative.
	 *
	 * @param status the status of this initiative
	 */
	@Override
	public void setStatus(int status) {
		_initiative.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this initiative.
	 *
	 * @param statusByUserId the status by user ID of this initiative
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_initiative.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this initiative.
	 *
	 * @param statusByUserName the status by user name of this initiative
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		_initiative.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this initiative.
	 *
	 * @param statusByUserUuid the status by user uuid of this initiative
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		_initiative.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this initiative.
	 *
	 * @param statusDate the status date of this initiative
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		_initiative.setStatusDate(statusDate);
	}

	/**
	 * Sets the title of this initiative.
	 *
	 * @param title the title of this initiative
	 */
	@Override
	public void setTitle(String title) {
		_initiative.setTitle(title);
	}

	/**
	 * Sets the user ID of this initiative.
	 *
	 * @param userId the user ID of this initiative
	 */
	@Override
	public void setUserId(long userId) {
		_initiative.setUserId(userId);
	}

	/**
	 * Sets the user name of this initiative.
	 *
	 * @param userName the user name of this initiative
	 */
	@Override
	public void setUserName(String userName) {
		_initiative.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this initiative.
	 *
	 * @param userUuid the user uuid of this initiative
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_initiative.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this initiative.
	 *
	 * @param uuid the uuid of this initiative
	 */
	@Override
	public void setUuid(String uuid) {
		_initiative.setUuid(uuid);
	}

	/**
	 * Sets the video url of this initiative.
	 *
	 * @param videoUrl the video url of this initiative
	 */
	@Override
	public void setVideoUrl(String videoUrl) {
		_initiative.setVideoUrl(videoUrl);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<eu.strasbourg.service.project.model.Initiative> toCacheModel() {

		return _initiative.toCacheModel();
	}

	@Override
	public eu.strasbourg.service.project.model.Initiative toEscapedModel() {
		return new InitiativeWrapper(_initiative.toEscapedModel());
	}

	/**
	 * Retourne la version JSON de l'entité
	 *
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONObject toJSON()
		throws com.liferay.portal.kernel.exception.PortalException {

		return _initiative.toJSON();
	}

	@Override
	public String toString() {
		return _initiative.toString();
	}

	@Override
	public eu.strasbourg.service.project.model.Initiative toUnescapedModel() {
		return new InitiativeWrapper(_initiative.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _initiative.toXmlString();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof InitiativeWrapper)) {
			return false;
		}

		InitiativeWrapper initiativeWrapper = (InitiativeWrapper)object;

		if (Objects.equals(_initiative, initiativeWrapper._initiative)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _initiative.getStagedModelType();
	}

	@Override
	public Initiative getWrappedModel() {
		return _initiative;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _initiative.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _initiative.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_initiative.resetOriginalValues();
	}

	private final Initiative _initiative;

}