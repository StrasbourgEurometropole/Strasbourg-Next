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
 * This class is a wrapper for {@link Participation}.
 * </p>
 *
 * @author Cedric Henry
 * @see Participation
 * @generated
 */
public class ParticipationWrapper
	implements ModelWrapper<Participation>, Participation {

	public ParticipationWrapper(Participation participation) {
		_participation = participation;
	}

	@Override
	public Class<?> getModelClass() {
		return Participation.class;
	}

	@Override
	public String getModelClassName() {
		return Participation.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("participationId", getParticipationId());
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
		attributes.put("contactName", getContactName());
		attributes.put("contactLine1", getContactLine1());
		attributes.put("contactLine2", getContactLine2());
		attributes.put("contactPhoneNumber", getContactPhoneNumber());
		attributes.put("videoUrl", getVideoUrl());
		attributes.put("externalImageURL", getExternalImageURL());
		attributes.put("externalImageCopyright", getExternalImageCopyright());
		attributes.put("mediaChoice", isMediaChoice());
		attributes.put("descriptionChapeau", getDescriptionChapeau());
		attributes.put("descriptionBody", getDescriptionBody());
		attributes.put("consultationPlacesBody", getConsultationPlacesBody());
		attributes.put("imageId", getImageId());
		attributes.put("filesIds", getFilesIds());
		attributes.put("eventsIds", getEventsIds());
		attributes.put("publicationDate", getPublicationDate());
		attributes.put("expirationDate", getExpirationDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long participationId = (Long)attributes.get("participationId");

		if (participationId != null) {
			setParticipationId(participationId);
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

		String contactName = (String)attributes.get("contactName");

		if (contactName != null) {
			setContactName(contactName);
		}

		String contactLine1 = (String)attributes.get("contactLine1");

		if (contactLine1 != null) {
			setContactLine1(contactLine1);
		}

		String contactLine2 = (String)attributes.get("contactLine2");

		if (contactLine2 != null) {
			setContactLine2(contactLine2);
		}

		String contactPhoneNumber = (String)attributes.get(
			"contactPhoneNumber");

		if (contactPhoneNumber != null) {
			setContactPhoneNumber(contactPhoneNumber);
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

		String descriptionChapeau = (String)attributes.get(
			"descriptionChapeau");

		if (descriptionChapeau != null) {
			setDescriptionChapeau(descriptionChapeau);
		}

		String descriptionBody = (String)attributes.get("descriptionBody");

		if (descriptionBody != null) {
			setDescriptionBody(descriptionBody);
		}

		String consultationPlacesBody = (String)attributes.get(
			"consultationPlacesBody");

		if (consultationPlacesBody != null) {
			setConsultationPlacesBody(consultationPlacesBody);
		}

		Long imageId = (Long)attributes.get("imageId");

		if (imageId != null) {
			setImageId(imageId);
		}

		String filesIds = (String)attributes.get("filesIds");

		if (filesIds != null) {
			setFilesIds(filesIds);
		}

		String eventsIds = (String)attributes.get("eventsIds");

		if (eventsIds != null) {
			setEventsIds(eventsIds);
		}

		Date publicationDate = (Date)attributes.get("publicationDate");

		if (publicationDate != null) {
			setPublicationDate(publicationDate);
		}

		Date expirationDate = (Date)attributes.get("expirationDate");

		if (expirationDate != null) {
			setExpirationDate(expirationDate);
		}
	}

	@Override
	public Object clone() {
		return new ParticipationWrapper((Participation)_participation.clone());
	}

	@Override
	public int compareTo(
		eu.strasbourg.service.project.model.Participation participation) {

		return _participation.compareTo(participation);
	}

	/**
	 * Retourne les commentaires de l'entité
	 */
	@Override
	public java.util.List<eu.strasbourg.service.comment.model.Comment>
		getApprovedComments() {

		return _participation.getApprovedComments();
	}

	/**
	 * Retourne l'AssetEntry rattaché cet item
	 */
	@Override
	public com.liferay.asset.kernel.model.AssetEntry getAssetEntry() {
		return _participation.getAssetEntry();
	}

	@Override
	public String getAuthorFullName()
		throws com.liferay.portal.kernel.exception.PortalException {

		return _participation.getAuthorFullName();
	}

	/**
	 * Renvoie la liste des AssetCategory rattachées à cet item (via l'assetEntry)
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCategories() {

		return _participation.getCategories();
	}

	/**
	 * Retourne les sous-catégories 'Territoire' correspondant aux villes de la
	 * participation
	 *
	 * @return : null si vide, sinon la liste des catégories
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCityCategories() {

		return _participation.getCityCategories();
	}

	/**
	 * Returns the company ID of this participation.
	 *
	 * @return the company ID of this participation
	 */
	@Override
	public long getCompanyId() {
		return _participation.getCompanyId();
	}

	/**
	 * Returns the consultation places body of this participation.
	 *
	 * @return the consultation places body of this participation
	 */
	@Override
	public String getConsultationPlacesBody() {
		return _participation.getConsultationPlacesBody();
	}

	/**
	 * Returns the contact line1 of this participation.
	 *
	 * @return the contact line1 of this participation
	 */
	@Override
	public String getContactLine1() {
		return _participation.getContactLine1();
	}

	/**
	 * Returns the contact line2 of this participation.
	 *
	 * @return the contact line2 of this participation
	 */
	@Override
	public String getContactLine2() {
		return _participation.getContactLine2();
	}

	/**
	 * Returns the contact name of this participation.
	 *
	 * @return the contact name of this participation
	 */
	@Override
	public String getContactName() {
		return _participation.getContactName();
	}

	/**
	 * Returns the contact phone number of this participation.
	 *
	 * @return the contact phone number of this participation
	 */
	@Override
	public String getContactPhoneNumber() {
		return _participation.getContactPhoneNumber();
	}

	/**
	 * Returns the create date of this participation.
	 *
	 * @return the create date of this participation
	 */
	@Override
	public Date getCreateDate() {
		return _participation.getCreateDate();
	}

	/**
	 * Returns the description body of this participation.
	 *
	 * @return the description body of this participation
	 */
	@Override
	public String getDescriptionBody() {
		return _participation.getDescriptionBody();
	}

	/**
	 * Returns the description chapeau of this participation.
	 *
	 * @return the description chapeau of this participation
	 */
	@Override
	public String getDescriptionChapeau() {
		return _participation.getDescriptionChapeau();
	}

	/**
	 * Retourne la liste des dislikes de l'entité
	 *
	 * @see eu.strasbourg.service.like.model.LikeType
	 */
	@Override
	public java.util.List<eu.strasbourg.service.like.model.Like> getDislikes() {
		return _participation.getDislikes();
	}

	/**
	 * Retourne les sous-sous-catégories 'Territoire' correspondant aux quartiers de
	 * la participation
	 *
	 * @return : null si vide, sinon la liste des catégories
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getDistrictCategories() {

		return _participation.getDistrictCategories();
	}

	/**
	 * Retourne une chaine des 'Territoires' correspondant aux quartiers de la
	 * participation
	 *
	 * @return : Chaine des quartiers ou description "Aucun" ou "Tous"
	 */
	@Override
	public String getDistrictLabel(java.util.Locale locale) {
		return _participation.getDistrictLabel(locale);
	}

	/**
	 * Retourne la liste des événements liés à la participation
	 */
	@Override
	public java.util.List<eu.strasbourg.service.agenda.model.Event>
		getEvents() {

		return _participation.getEvents();
	}

	/**
	 * Returns the events IDs of this participation.
	 *
	 * @return the events IDs of this participation
	 */
	@Override
	public String getEventsIds() {
		return _participation.getEventsIds();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _participation.getExpandoBridge();
	}

	/**
	 * Returns the expiration date of this participation.
	 *
	 * @return the expiration date of this participation
	 */
	@Override
	public Date getExpirationDate() {
		return _participation.getExpirationDate();
	}

	/**
	 * Returns the external image copyright of this participation.
	 *
	 * @return the external image copyright of this participation
	 */
	@Override
	public String getExternalImageCopyright() {
		return _participation.getExternalImageCopyright();
	}

	/**
	 * Returns the external image url of this participation.
	 *
	 * @return the external image url of this participation
	 */
	@Override
	public String getExternalImageURL() {
		return _participation.getExternalImageURL();
	}

	/**
	 * Returns the files IDs of this participation.
	 *
	 * @return the files IDs of this participation
	 */
	@Override
	public String getFilesIds() {
		return _participation.getFilesIds();
	}

	/**
	 * Retourne la liste des URLs des documents
	 */
	@Override
	public java.util.List<String> getFilesURLs() {
		return _participation.getFilesURLs();
	}

	/**
	 * Returns the group ID of this participation.
	 *
	 * @return the group ID of this participation
	 */
	@Override
	public long getGroupId() {
		return _participation.getGroupId();
	}

	@Override
	public String getImageAuthorURL(
			com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _participation.getImageAuthorURL(themeDisplay);
	}

	/**
	 * Retourne le copyright de l'image principale
	 */
	@Override
	public String getImageCopyright(java.util.Locale locale) {
		return _participation.getImageCopyright(locale);
	}

	/**
	 * Returns the image ID of this participation.
	 *
	 * @return the image ID of this participation
	 */
	@Override
	public long getImageId() {
		return _participation.getImageId();
	}

	/**
	 * Retourne l'URL de l'image à partir de l'id du DLFileEntry
	 */
	@Override
	public String getImageURL() {
		return _participation.getImageURL();
	}

	/**
	 * Retourne la liste des likes de l'entité
	 *
	 * @see eu.strasbourg.service.like.model.LikeType
	 */
	@Override
	public java.util.List<eu.strasbourg.service.like.model.Like> getLikes() {
		return _participation.getLikes();
	}

	/**
	 * Retourne la liste des like/dislike de l'entité
	 *
	 * @see eu.strasbourg.service.like.model.LikeType
	 */
	@Override
	public java.util.List<eu.strasbourg.service.like.model.Like>
		getLikesDislikes() {

		return _participation.getLikesDislikes();
	}

	/**
	 * Returns the media choice of this participation.
	 *
	 * @return the media choice of this participation
	 */
	@Override
	public boolean getMediaChoice() {
		return _participation.getMediaChoice();
	}

	/**
	 * Returns the modified date of this participation.
	 *
	 * @return the modified date of this participation
	 */
	@Override
	public Date getModifiedDate() {
		return _participation.getModifiedDate();
	}

	/**
	 * Retourne le nombre de commentaires de l'entité
	 */
	@Override
	public int getNbApprovedComments() {
		return _participation.getNbApprovedComments();
	}

	/**
	 * Retourne le label de 5 digits du nombre de commentaires de l'entité
	 */
	@Override
	public String getNbApprovedCommentsLabel() {
		return _participation.getNbApprovedCommentsLabel();
	}

	/**
	 * Retourne le nombre de dislikes de l'entité
	 *
	 * @see eu.strasbourg.service.like.model.LikeType
	 */
	@Override
	public int getNbDislikes() {
		return _participation.getNbDislikes();
	}

	/**
	 * Retourne le nombre de likes de l'entité
	 *
	 * @see eu.strasbourg.service.like.model.LikeType
	 */
	@Override
	public int getNbLikes() {
		return _participation.getNbLikes();
	}

	/**
	 * Retourne le nombre de likes/dislikes de l'entité
	 *
	 * @see eu.strasbourg.service.like.model.LikeType
	 */
	@Override
	public int getNbLikesDislikes() {
		return _participation.getNbLikesDislikes();
	}

	/**
	 * Returns the participation ID of this participation.
	 *
	 * @return the participation ID of this participation
	 */
	@Override
	public long getParticipationId() {
		return _participation.getParticipationId();
	}

	/**
	 * Retourne le status de la participation selon la temporalité actuelle
	 *
	 * @return le status suivant l'ordre : [soon_arrived] : date du jour antérieur à
	 la date de publication [new] : 7 jour après la publication
	 [in_progress] : toute la durée de la période de participation
	 [soon_finished] : 7 jours avant l'expiration [finished] : date du
	 jour postérieur à la date d'expiration
	 */
	@Override
	public String getParticipationStatus() {
		return _participation.getParticipationStatus();
	}

	/**
	 * Retourne le status de la participation
	 */
	@Override
	public com.liferay.asset.kernel.model.AssetCategory
		getParticipationStatusCategory() {

		return _participation.getParticipationStatusCategory();
	}

	/**
	 * Retourne les noms des lieux placit de la participation
	 */
	@Override
	public java.util.List<String> getPlaceNames(java.util.Locale locale) {
		return _participation.getPlaceNames(locale);
	}

	/**
	 * Retourne les ids SIG des lieux placit de la participation
	 */
	@Override
	public java.util.List<String> getPlaceSIGIds(java.util.Locale locale) {
		return _participation.getPlaceSIGIds(locale);
	}

	/**
	 * Retourne la liste des lieux placit liés à la participation
	 */
	@Override
	public java.util.List<eu.strasbourg.service.project.model.PlacitPlace>
		getPlacitPlaces() {

		return _participation.getPlacitPlaces();
	}

	/**
	 * Returns the primary key of this participation.
	 *
	 * @return the primary key of this participation
	 */
	@Override
	public long getPrimaryKey() {
		return _participation.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _participation.getPrimaryKeyObj();
	}

	/**
	 * Retourne le projet de la participation (
	 */
	@Override
	public com.liferay.asset.kernel.model.AssetCategory getProjectCategory() {
		return _participation.getProjectCategory();
	}

	/**
	 * Returns the publication date of this participation.
	 *
	 * @return the publication date of this participation
	 */
	@Override
	public Date getPublicationDate() {
		return _participation.getPublicationDate();
	}

	/**
	 * Returns the status of this participation.
	 *
	 * @return the status of this participation
	 */
	@Override
	public int getStatus() {
		return _participation.getStatus();
	}

	/**
	 * Returns the status by user ID of this participation.
	 *
	 * @return the status by user ID of this participation
	 */
	@Override
	public long getStatusByUserId() {
		return _participation.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this participation.
	 *
	 * @return the status by user name of this participation
	 */
	@Override
	public String getStatusByUserName() {
		return _participation.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this participation.
	 *
	 * @return the status by user uuid of this participation
	 */
	@Override
	public String getStatusByUserUuid() {
		return _participation.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this participation.
	 *
	 * @return the status date of this participation
	 */
	@Override
	public Date getStatusDate() {
		return _participation.getStatusDate();
	}

	/**
	 * Retourne le label d'affichage détaillant le statut
	 */
	@Override
	public String getStatusDetailLabel() {
		return _participation.getStatusDetailLabel();
	}

	/**
	 * Retourne les catégories 'Territoire' correspondant aux pays de la
	 * participation
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getTerritoryCategories() {

		return _participation.getTerritoryCategories();
	}

	/**
	 * Retourne les thematiques de la participation (
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getThematicCategories() {

		return _participation.getThematicCategories();
	}

	/**
	 * Retourne une chaine des 'Thematics' sépararée d'un '-'
	 */
	@Override
	public String getThematicsLabel(java.util.Locale locale) {
		return _participation.getThematicsLabel(locale);
	}

	/**
	 * Returns the title of this participation.
	 *
	 * @return the title of this participation
	 */
	@Override
	public String getTitle() {
		return _participation.getTitle();
	}

	/**
	 * Calcul la différence de jours entre la date du jour et celle d'expiration
	 */
	@Override
	public int getTodayExpirationDifferenceDays() {
		return _participation.getTodayExpirationDifferenceDays();
	}

	/**
	 * Calcul la différence de jours entre la date du jour et celle de publication
	 */
	@Override
	public int getTodayPublicationDifferenceDays() {
		return _participation.getTodayPublicationDifferenceDays();
	}

	/**
	 * Retourne le type de la participation (
	 */
	@Override
	public com.liferay.asset.kernel.model.AssetCategory getTypeCategory() {
		return _participation.getTypeCategory();
	}

	/**
	 * Retourne la couleur hexa du type de la participation contenu dans la
	 * propriete 'code_color' de la categorie associee
	 */
	@Override
	public String getTypeCategoryColor() {
		return _participation.getTypeCategoryColor();
	}

	/**
	 * Returns the user ID of this participation.
	 *
	 * @return the user ID of this participation
	 */
	@Override
	public long getUserId() {
		return _participation.getUserId();
	}

	/**
	 * Returns the user name of this participation.
	 *
	 * @return the user name of this participation
	 */
	@Override
	public String getUserName() {
		return _participation.getUserName();
	}

	/**
	 * Returns the user uuid of this participation.
	 *
	 * @return the user uuid of this participation
	 */
	@Override
	public String getUserUuid() {
		return _participation.getUserUuid();
	}

	/**
	 * Returns the uuid of this participation.
	 *
	 * @return the uuid of this participation
	 */
	@Override
	public String getUuid() {
		return _participation.getUuid();
	}

	/**
	 * Returns the video url of this participation.
	 *
	 * @return the video url of this participation
	 */
	@Override
	public String getVideoUrl() {
		return _participation.getVideoUrl();
	}

	@Override
	public int hashCode() {
		return _participation.hashCode();
	}

	/**
	 * Returns <code>true</code> if this participation is approved.
	 *
	 * @return <code>true</code> if this participation is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return _participation.isApproved();
	}

	@Override
	public boolean isCachedModel() {
		return _participation.isCachedModel();
	}

	/**
	 * Returns <code>true</code> if this participation is denied.
	 *
	 * @return <code>true</code> if this participation is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return _participation.isDenied();
	}

	/**
	 * Returns <code>true</code> if this participation is a draft.
	 *
	 * @return <code>true</code> if this participation is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return _participation.isDraft();
	}

	@Override
	public boolean isEscapedModel() {
		return _participation.isEscapedModel();
	}

	/**
	 * Returns <code>true</code> if this participation is expired.
	 *
	 * @return <code>true</code> if this participation is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return _participation.isExpired();
	}

	/**
	 * Returns <code>true</code> if this participation is inactive.
	 *
	 * @return <code>true</code> if this participation is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return _participation.isInactive();
	}

	/**
	 * Returns <code>true</code> if this participation is incomplete.
	 *
	 * @return <code>true</code> if this participation is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return _participation.isIncomplete();
	}

	/**
	 * Peut apporter une reaction (commenter, liker, participer) a l'entite
	 */
	@Override
	public boolean isJudgeable() {
		return _participation.isJudgeable();
	}

	/**
	 * Returns <code>true</code> if this participation is media choice.
	 *
	 * @return <code>true</code> if this participation is media choice; <code>false</code> otherwise
	 */
	@Override
	public boolean isMediaChoice() {
		return _participation.isMediaChoice();
	}

	@Override
	public boolean isNew() {
		return _participation.isNew();
	}

	/**
	 * Returns <code>true</code> if this participation is pending.
	 *
	 * @return <code>true</code> if this participation is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return _participation.isPending();
	}

	/**
	 * Returns <code>true</code> if this participation is scheduled.
	 *
	 * @return <code>true</code> if this participation is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return _participation.isScheduled();
	}

	@Override
	public void persist() {
		_participation.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_participation.setCachedModel(cachedModel);
	}

	/**
	 * Sets the company ID of this participation.
	 *
	 * @param companyId the company ID of this participation
	 */
	@Override
	public void setCompanyId(long companyId) {
		_participation.setCompanyId(companyId);
	}

	/**
	 * Sets the consultation places body of this participation.
	 *
	 * @param consultationPlacesBody the consultation places body of this participation
	 */
	@Override
	public void setConsultationPlacesBody(String consultationPlacesBody) {
		_participation.setConsultationPlacesBody(consultationPlacesBody);
	}

	/**
	 * Sets the contact line1 of this participation.
	 *
	 * @param contactLine1 the contact line1 of this participation
	 */
	@Override
	public void setContactLine1(String contactLine1) {
		_participation.setContactLine1(contactLine1);
	}

	/**
	 * Sets the contact line2 of this participation.
	 *
	 * @param contactLine2 the contact line2 of this participation
	 */
	@Override
	public void setContactLine2(String contactLine2) {
		_participation.setContactLine2(contactLine2);
	}

	/**
	 * Sets the contact name of this participation.
	 *
	 * @param contactName the contact name of this participation
	 */
	@Override
	public void setContactName(String contactName) {
		_participation.setContactName(contactName);
	}

	/**
	 * Sets the contact phone number of this participation.
	 *
	 * @param contactPhoneNumber the contact phone number of this participation
	 */
	@Override
	public void setContactPhoneNumber(String contactPhoneNumber) {
		_participation.setContactPhoneNumber(contactPhoneNumber);
	}

	/**
	 * Sets the create date of this participation.
	 *
	 * @param createDate the create date of this participation
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_participation.setCreateDate(createDate);
	}

	/**
	 * Sets the description body of this participation.
	 *
	 * @param descriptionBody the description body of this participation
	 */
	@Override
	public void setDescriptionBody(String descriptionBody) {
		_participation.setDescriptionBody(descriptionBody);
	}

	/**
	 * Sets the description chapeau of this participation.
	 *
	 * @param descriptionChapeau the description chapeau of this participation
	 */
	@Override
	public void setDescriptionChapeau(String descriptionChapeau) {
		_participation.setDescriptionChapeau(descriptionChapeau);
	}

	/**
	 * Sets the events IDs of this participation.
	 *
	 * @param eventsIds the events IDs of this participation
	 */
	@Override
	public void setEventsIds(String eventsIds) {
		_participation.setEventsIds(eventsIds);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_participation.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_participation.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_participation.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the expiration date of this participation.
	 *
	 * @param expirationDate the expiration date of this participation
	 */
	@Override
	public void setExpirationDate(Date expirationDate) {
		_participation.setExpirationDate(expirationDate);
	}

	/**
	 * Sets the external image copyright of this participation.
	 *
	 * @param externalImageCopyright the external image copyright of this participation
	 */
	@Override
	public void setExternalImageCopyright(String externalImageCopyright) {
		_participation.setExternalImageCopyright(externalImageCopyright);
	}

	/**
	 * Sets the external image url of this participation.
	 *
	 * @param externalImageURL the external image url of this participation
	 */
	@Override
	public void setExternalImageURL(String externalImageURL) {
		_participation.setExternalImageURL(externalImageURL);
	}

	/**
	 * Sets the files IDs of this participation.
	 *
	 * @param filesIds the files IDs of this participation
	 */
	@Override
	public void setFilesIds(String filesIds) {
		_participation.setFilesIds(filesIds);
	}

	/**
	 * Sets the group ID of this participation.
	 *
	 * @param groupId the group ID of this participation
	 */
	@Override
	public void setGroupId(long groupId) {
		_participation.setGroupId(groupId);
	}

	/**
	 * Sets the image ID of this participation.
	 *
	 * @param imageId the image ID of this participation
	 */
	@Override
	public void setImageId(long imageId) {
		_participation.setImageId(imageId);
	}

	/**
	 * Sets whether this participation is media choice.
	 *
	 * @param mediaChoice the media choice of this participation
	 */
	@Override
	public void setMediaChoice(boolean mediaChoice) {
		_participation.setMediaChoice(mediaChoice);
	}

	/**
	 * Sets the modified date of this participation.
	 *
	 * @param modifiedDate the modified date of this participation
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_participation.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_participation.setNew(n);
	}

	/**
	 * Sets the participation ID of this participation.
	 *
	 * @param participationId the participation ID of this participation
	 */
	@Override
	public void setParticipationId(long participationId) {
		_participation.setParticipationId(participationId);
	}

	/**
	 * Sets the primary key of this participation.
	 *
	 * @param primaryKey the primary key of this participation
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_participation.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_participation.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the publication date of this participation.
	 *
	 * @param publicationDate the publication date of this participation
	 */
	@Override
	public void setPublicationDate(Date publicationDate) {
		_participation.setPublicationDate(publicationDate);
	}

	/**
	 * Sets the status of this participation.
	 *
	 * @param status the status of this participation
	 */
	@Override
	public void setStatus(int status) {
		_participation.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this participation.
	 *
	 * @param statusByUserId the status by user ID of this participation
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_participation.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this participation.
	 *
	 * @param statusByUserName the status by user name of this participation
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		_participation.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this participation.
	 *
	 * @param statusByUserUuid the status by user uuid of this participation
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		_participation.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this participation.
	 *
	 * @param statusDate the status date of this participation
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		_participation.setStatusDate(statusDate);
	}

	/**
	 * Sets the title of this participation.
	 *
	 * @param title the title of this participation
	 */
	@Override
	public void setTitle(String title) {
		_participation.setTitle(title);
	}

	/**
	 * Sets the user ID of this participation.
	 *
	 * @param userId the user ID of this participation
	 */
	@Override
	public void setUserId(long userId) {
		_participation.setUserId(userId);
	}

	/**
	 * Sets the user name of this participation.
	 *
	 * @param userName the user name of this participation
	 */
	@Override
	public void setUserName(String userName) {
		_participation.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this participation.
	 *
	 * @param userUuid the user uuid of this participation
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_participation.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this participation.
	 *
	 * @param uuid the uuid of this participation
	 */
	@Override
	public void setUuid(String uuid) {
		_participation.setUuid(uuid);
	}

	/**
	 * Sets the video url of this participation.
	 *
	 * @param videoUrl the video url of this participation
	 */
	@Override
	public void setVideoUrl(String videoUrl) {
		_participation.setVideoUrl(videoUrl);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<eu.strasbourg.service.project.model.Participation> toCacheModel() {

		return _participation.toCacheModel();
	}

	@Override
	public eu.strasbourg.service.project.model.Participation toEscapedModel() {
		return new ParticipationWrapper(_participation.toEscapedModel());
	}

	/**
	 * Retourne la version JSON de l'entité
	 *
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONObject toJSON(
			com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _participation.toJSON(themeDisplay);
	}

	@Override
	public String toString() {
		return _participation.toString();
	}

	@Override
	public eu.strasbourg.service.project.model.Participation
		toUnescapedModel() {

		return new ParticipationWrapper(_participation.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _participation.toXmlString();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ParticipationWrapper)) {
			return false;
		}

		ParticipationWrapper participationWrapper =
			(ParticipationWrapper)object;

		if (Objects.equals(
				_participation, participationWrapper._participation)) {

			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _participation.getStagedModelType();
	}

	@Override
	public Participation getWrappedModel() {
		return _participation;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _participation.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _participation.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_participation.resetOriginalValues();
	}

	private final Participation _participation;

}