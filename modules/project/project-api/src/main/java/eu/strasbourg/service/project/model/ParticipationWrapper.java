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
 * This class is a wrapper for {@link Participation}.
 * </p>
 *
 * @author Cedric Henry
 * @see Participation
 * @generated
 */
public class ParticipationWrapper
	extends BaseModelWrapper<Participation>
	implements ModelWrapper<Participation>, Participation {

	public ParticipationWrapper(Participation participation) {
		super(participation);
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
	public Participation cloneWithOriginalValues() {
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
	public String getAuthorFullName()
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.getAuthorFullName();
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
	 * Retourne les sous-catégories 'Territoire' correspondant aux villes de la
	 * participation
	 *
	 * @return : null si vide, sinon la liste des catégories
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCityCategories() {

		return model.getCityCategories();
	}

	/**
	 * Returns the company ID of this participation.
	 *
	 * @return the company ID of this participation
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the consultation places body of this participation.
	 *
	 * @return the consultation places body of this participation
	 */
	@Override
	public String getConsultationPlacesBody() {
		return model.getConsultationPlacesBody();
	}

	/**
	 * Returns the localized consultation places body of this participation in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized consultation places body of this participation
	 */
	@Override
	public String getConsultationPlacesBody(java.util.Locale locale) {
		return model.getConsultationPlacesBody(locale);
	}

	/**
	 * Returns the localized consultation places body of this participation in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized consultation places body of this participation. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getConsultationPlacesBody(
		java.util.Locale locale, boolean useDefault) {

		return model.getConsultationPlacesBody(locale, useDefault);
	}

	/**
	 * Returns the localized consultation places body of this participation in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized consultation places body of this participation
	 */
	@Override
	public String getConsultationPlacesBody(String languageId) {
		return model.getConsultationPlacesBody(languageId);
	}

	/**
	 * Returns the localized consultation places body of this participation in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized consultation places body of this participation
	 */
	@Override
	public String getConsultationPlacesBody(
		String languageId, boolean useDefault) {

		return model.getConsultationPlacesBody(languageId, useDefault);
	}

	@Override
	public String getConsultationPlacesBodyCurrentLanguageId() {
		return model.getConsultationPlacesBodyCurrentLanguageId();
	}

	@Override
	public String getConsultationPlacesBodyCurrentValue() {
		return model.getConsultationPlacesBodyCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized consultation places bodies of this participation.
	 *
	 * @return the locales and localized consultation places bodies of this participation
	 */
	@Override
	public Map<java.util.Locale, String> getConsultationPlacesBodyMap() {
		return model.getConsultationPlacesBodyMap();
	}

	/**
	 * Returns the contact line1 of this participation.
	 *
	 * @return the contact line1 of this participation
	 */
	@Override
	public String getContactLine1() {
		return model.getContactLine1();
	}

	/**
	 * Returns the contact line2 of this participation.
	 *
	 * @return the contact line2 of this participation
	 */
	@Override
	public String getContactLine2() {
		return model.getContactLine2();
	}

	/**
	 * Returns the contact name of this participation.
	 *
	 * @return the contact name of this participation
	 */
	@Override
	public String getContactName() {
		return model.getContactName();
	}

	/**
	 * Returns the contact phone number of this participation.
	 *
	 * @return the contact phone number of this participation
	 */
	@Override
	public String getContactPhoneNumber() {
		return model.getContactPhoneNumber();
	}

	/**
	 * Returns the create date of this participation.
	 *
	 * @return the create date of this participation
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
	 * Returns the description body of this participation.
	 *
	 * @return the description body of this participation
	 */
	@Override
	public String getDescriptionBody() {
		return model.getDescriptionBody();
	}

	/**
	 * Returns the localized description body of this participation in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description body of this participation
	 */
	@Override
	public String getDescriptionBody(java.util.Locale locale) {
		return model.getDescriptionBody(locale);
	}

	/**
	 * Returns the localized description body of this participation in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description body of this participation. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getDescriptionBody(
		java.util.Locale locale, boolean useDefault) {

		return model.getDescriptionBody(locale, useDefault);
	}

	/**
	 * Returns the localized description body of this participation in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description body of this participation
	 */
	@Override
	public String getDescriptionBody(String languageId) {
		return model.getDescriptionBody(languageId);
	}

	/**
	 * Returns the localized description body of this participation in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description body of this participation
	 */
	@Override
	public String getDescriptionBody(String languageId, boolean useDefault) {
		return model.getDescriptionBody(languageId, useDefault);
	}

	@Override
	public String getDescriptionBodyCurrentLanguageId() {
		return model.getDescriptionBodyCurrentLanguageId();
	}

	@Override
	public String getDescriptionBodyCurrentValue() {
		return model.getDescriptionBodyCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized description bodies of this participation.
	 *
	 * @return the locales and localized description bodies of this participation
	 */
	@Override
	public Map<java.util.Locale, String> getDescriptionBodyMap() {
		return model.getDescriptionBodyMap();
	}

	/**
	 * Returns the description chapeau of this participation.
	 *
	 * @return the description chapeau of this participation
	 */
	@Override
	public String getDescriptionChapeau() {
		return model.getDescriptionChapeau();
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
	 * Retourne les sous-sous-catégories 'Territoire' correspondant aux quartiers de
	 * la participation
	 *
	 * @return : null si vide, sinon la liste des catégories
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getDistrictCategories() {

		return model.getDistrictCategories();
	}

	/**
	 * Retourne une chaine des 'Territoires' correspondant aux quartiers de la
	 * participation
	 *
	 * @return : Chaine des quartiers ou description "Aucun" ou "Tous"
	 */
	@Override
	public String getDistrictLabel(java.util.Locale locale) {
		return model.getDistrictLabel(locale);
	}

	/**
	 * Retourne la liste des événements liés à la participation
	 */
	@Override
	public java.util.List<eu.strasbourg.service.agenda.model.Event>
		getEvents() {

		return model.getEvents();
	}

	/**
	 * Returns the events IDs of this participation.
	 *
	 * @return the events IDs of this participation
	 */
	@Override
	public String getEventsIds() {
		return model.getEventsIds();
	}

	/**
	 * Returns the expiration date of this participation.
	 *
	 * @return the expiration date of this participation
	 */
	@Override
	public Date getExpirationDate() {
		return model.getExpirationDate();
	}

	/**
	 * Returns the external image copyright of this participation.
	 *
	 * @return the external image copyright of this participation
	 */
	@Override
	public String getExternalImageCopyright() {
		return model.getExternalImageCopyright();
	}

	/**
	 * Returns the external image url of this participation.
	 *
	 * @return the external image url of this participation
	 */
	@Override
	public String getExternalImageURL() {
		return model.getExternalImageURL();
	}

	/**
	 * Returns the files IDs of this participation.
	 *
	 * @return the files IDs of this participation
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
	 * Returns the group ID of this participation.
	 *
	 * @return the group ID of this participation
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	@Override
	public String getImageAuthorURL(
			com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.getImageAuthorURL(themeDisplay);
	}

	/**
	 * Retourne le copyright de l'image principale
	 */
	@Override
	public String getImageCopyright(java.util.Locale locale) {
		return model.getImageCopyright(locale);
	}

	/**
	 * Returns the image ID of this participation.
	 *
	 * @return the image ID of this participation
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
	 * Returns the media choice of this participation.
	 *
	 * @return the media choice of this participation
	 */
	@Override
	public boolean getMediaChoice() {
		return model.getMediaChoice();
	}

	/**
	 * Returns the modified date of this participation.
	 *
	 * @return the modified date of this participation
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
	 * Retourne le nombre de likes/dislikes de l'entité
	 *
	 * @see eu.strasbourg.service.like.model.LikeType
	 */
	@Override
	public int getNbLikesDislikes() {
		return model.getNbLikesDislikes();
	}

	/**
	 * Returns the participation ID of this participation.
	 *
	 * @return the participation ID of this participation
	 */
	@Override
	public long getParticipationId() {
		return model.getParticipationId();
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
		return model.getParticipationStatus();
	}

	/**
	 * Retourne le status de la participation
	 */
	@Override
	public com.liferay.asset.kernel.model.AssetCategory
		getParticipationStatusCategory() {

		return model.getParticipationStatusCategory();
	}

	/**
	 * Retourne les noms des lieux placit de la participation
	 */
	@Override
	public java.util.List<String> getPlaceNames(java.util.Locale locale) {
		return model.getPlaceNames(locale);
	}

	/**
	 * Retourne les ids SIG des lieux placit de la participation
	 */
	@Override
	public java.util.List<String> getPlaceSIGIds(java.util.Locale locale) {
		return model.getPlaceSIGIds(locale);
	}

	/**
	 * Retourne la liste des lieux placit liés à la participation
	 */
	@Override
	public java.util.List<PlacitPlace> getPlacitPlaces() {
		return model.getPlacitPlaces();
	}

	/**
	 * Returns the primary key of this participation.
	 *
	 * @return the primary key of this participation
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Retourne le projet de la participation (
	 */
	@Override
	public com.liferay.asset.kernel.model.AssetCategory getProjectCategory() {
		return model.getProjectCategory();
	}

	/**
	 * Returns the publication date of this participation.
	 *
	 * @return the publication date of this participation
	 */
	@Override
	public Date getPublicationDate() {
		return model.getPublicationDate();
	}

	/**
	 * Returns the status of this participation.
	 *
	 * @return the status of this participation
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this participation.
	 *
	 * @return the status by user ID of this participation
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this participation.
	 *
	 * @return the status by user name of this participation
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this participation.
	 *
	 * @return the status by user uuid of this participation
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this participation.
	 *
	 * @return the status date of this participation
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Retourne le label d'affichage détaillant le statut
	 */
	@Override
	public String getStatusDetailLabel() {
		return model.getStatusDetailLabel();
	}

	/**
	 * Retourne les catégories 'Territoire' correspondant aux pays de la
	 * participation
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getTerritoryCategories() {

		return model.getTerritoryCategories();
	}

	/**
	 * Retourne les thematiques de la participation (
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
	 * Returns the title of this participation.
	 *
	 * @return the title of this participation
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
	 * Calcul la différence de jours entre la date du jour et celle de publication
	 */
	@Override
	public int getTodayPublicationDifferenceDays() {
		return model.getTodayPublicationDifferenceDays();
	}

	/**
	 * Retourne le type de la participation (
	 */
	@Override
	public com.liferay.asset.kernel.model.AssetCategory getTypeCategory() {
		return model.getTypeCategory();
	}

	/**
	 * Retourne la couleur hexa du type de la participation contenu dans la
	 * propriete 'code_color' de la categorie associee
	 */
	@Override
	public String getTypeCategoryColor() {
		return model.getTypeCategoryColor();
	}

	/**
	 * Returns the user ID of this participation.
	 *
	 * @return the user ID of this participation
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this participation.
	 *
	 * @return the user name of this participation
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this participation.
	 *
	 * @return the user uuid of this participation
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this participation.
	 *
	 * @return the uuid of this participation
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the video url of this participation.
	 *
	 * @return the video url of this participation
	 */
	@Override
	public String getVideoUrl() {
		return model.getVideoUrl();
	}

	/**
	 * Returns <code>true</code> if this participation is approved.
	 *
	 * @return <code>true</code> if this participation is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this participation is denied.
	 *
	 * @return <code>true</code> if this participation is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this participation is a draft.
	 *
	 * @return <code>true</code> if this participation is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this participation is expired.
	 *
	 * @return <code>true</code> if this participation is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this participation is inactive.
	 *
	 * @return <code>true</code> if this participation is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this participation is incomplete.
	 *
	 * @return <code>true</code> if this participation is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Peut apporter une reaction (commenter, liker, participer) a l'entite
	 */
	@Override
	public boolean isJudgeable() {
		return model.isJudgeable();
	}

	/**
	 * Returns <code>true</code> if this participation is media choice.
	 *
	 * @return <code>true</code> if this participation is media choice; <code>false</code> otherwise
	 */
	@Override
	public boolean isMediaChoice() {
		return model.isMediaChoice();
	}

	/**
	 * Returns <code>true</code> if this participation is pending.
	 *
	 * @return <code>true</code> if this participation is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this participation is scheduled.
	 *
	 * @return <code>true</code> if this participation is scheduled; <code>false</code> otherwise
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
	 * Sets the company ID of this participation.
	 *
	 * @param companyId the company ID of this participation
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the consultation places body of this participation.
	 *
	 * @param consultationPlacesBody the consultation places body of this participation
	 */
	@Override
	public void setConsultationPlacesBody(String consultationPlacesBody) {
		model.setConsultationPlacesBody(consultationPlacesBody);
	}

	/**
	 * Sets the localized consultation places body of this participation in the language.
	 *
	 * @param consultationPlacesBody the localized consultation places body of this participation
	 * @param locale the locale of the language
	 */
	@Override
	public void setConsultationPlacesBody(
		String consultationPlacesBody, java.util.Locale locale) {

		model.setConsultationPlacesBody(consultationPlacesBody, locale);
	}

	/**
	 * Sets the localized consultation places body of this participation in the language, and sets the default locale.
	 *
	 * @param consultationPlacesBody the localized consultation places body of this participation
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setConsultationPlacesBody(
		String consultationPlacesBody, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setConsultationPlacesBody(
			consultationPlacesBody, locale, defaultLocale);
	}

	@Override
	public void setConsultationPlacesBodyCurrentLanguageId(String languageId) {
		model.setConsultationPlacesBodyCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized consultation places bodies of this participation from the map of locales and localized consultation places bodies.
	 *
	 * @param consultationPlacesBodyMap the locales and localized consultation places bodies of this participation
	 */
	@Override
	public void setConsultationPlacesBodyMap(
		Map<java.util.Locale, String> consultationPlacesBodyMap) {

		model.setConsultationPlacesBodyMap(consultationPlacesBodyMap);
	}

	/**
	 * Sets the localized consultation places bodies of this participation from the map of locales and localized consultation places bodies, and sets the default locale.
	 *
	 * @param consultationPlacesBodyMap the locales and localized consultation places bodies of this participation
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setConsultationPlacesBodyMap(
		Map<java.util.Locale, String> consultationPlacesBodyMap,
		java.util.Locale defaultLocale) {

		model.setConsultationPlacesBodyMap(
			consultationPlacesBodyMap, defaultLocale);
	}

	/**
	 * Sets the contact line1 of this participation.
	 *
	 * @param contactLine1 the contact line1 of this participation
	 */
	@Override
	public void setContactLine1(String contactLine1) {
		model.setContactLine1(contactLine1);
	}

	/**
	 * Sets the contact line2 of this participation.
	 *
	 * @param contactLine2 the contact line2 of this participation
	 */
	@Override
	public void setContactLine2(String contactLine2) {
		model.setContactLine2(contactLine2);
	}

	/**
	 * Sets the contact name of this participation.
	 *
	 * @param contactName the contact name of this participation
	 */
	@Override
	public void setContactName(String contactName) {
		model.setContactName(contactName);
	}

	/**
	 * Sets the contact phone number of this participation.
	 *
	 * @param contactPhoneNumber the contact phone number of this participation
	 */
	@Override
	public void setContactPhoneNumber(String contactPhoneNumber) {
		model.setContactPhoneNumber(contactPhoneNumber);
	}

	/**
	 * Sets the create date of this participation.
	 *
	 * @param createDate the create date of this participation
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description body of this participation.
	 *
	 * @param descriptionBody the description body of this participation
	 */
	@Override
	public void setDescriptionBody(String descriptionBody) {
		model.setDescriptionBody(descriptionBody);
	}

	/**
	 * Sets the localized description body of this participation in the language.
	 *
	 * @param descriptionBody the localized description body of this participation
	 * @param locale the locale of the language
	 */
	@Override
	public void setDescriptionBody(
		String descriptionBody, java.util.Locale locale) {

		model.setDescriptionBody(descriptionBody, locale);
	}

	/**
	 * Sets the localized description body of this participation in the language, and sets the default locale.
	 *
	 * @param descriptionBody the localized description body of this participation
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDescriptionBody(
		String descriptionBody, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setDescriptionBody(descriptionBody, locale, defaultLocale);
	}

	@Override
	public void setDescriptionBodyCurrentLanguageId(String languageId) {
		model.setDescriptionBodyCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized description bodies of this participation from the map of locales and localized description bodies.
	 *
	 * @param descriptionBodyMap the locales and localized description bodies of this participation
	 */
	@Override
	public void setDescriptionBodyMap(
		Map<java.util.Locale, String> descriptionBodyMap) {

		model.setDescriptionBodyMap(descriptionBodyMap);
	}

	/**
	 * Sets the localized description bodies of this participation from the map of locales and localized description bodies, and sets the default locale.
	 *
	 * @param descriptionBodyMap the locales and localized description bodies of this participation
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDescriptionBodyMap(
		Map<java.util.Locale, String> descriptionBodyMap,
		java.util.Locale defaultLocale) {

		model.setDescriptionBodyMap(descriptionBodyMap, defaultLocale);
	}

	/**
	 * Sets the description chapeau of this participation.
	 *
	 * @param descriptionChapeau the description chapeau of this participation
	 */
	@Override
	public void setDescriptionChapeau(String descriptionChapeau) {
		model.setDescriptionChapeau(descriptionChapeau);
	}

	/**
	 * Sets the events IDs of this participation.
	 *
	 * @param eventsIds the events IDs of this participation
	 */
	@Override
	public void setEventsIds(String eventsIds) {
		model.setEventsIds(eventsIds);
	}

	/**
	 * Sets the expiration date of this participation.
	 *
	 * @param expirationDate the expiration date of this participation
	 */
	@Override
	public void setExpirationDate(Date expirationDate) {
		model.setExpirationDate(expirationDate);
	}

	/**
	 * Sets the external image copyright of this participation.
	 *
	 * @param externalImageCopyright the external image copyright of this participation
	 */
	@Override
	public void setExternalImageCopyright(String externalImageCopyright) {
		model.setExternalImageCopyright(externalImageCopyright);
	}

	/**
	 * Sets the external image url of this participation.
	 *
	 * @param externalImageURL the external image url of this participation
	 */
	@Override
	public void setExternalImageURL(String externalImageURL) {
		model.setExternalImageURL(externalImageURL);
	}

	/**
	 * Sets the files IDs of this participation.
	 *
	 * @param filesIds the files IDs of this participation
	 */
	@Override
	public void setFilesIds(String filesIds) {
		model.setFilesIds(filesIds);
	}

	/**
	 * Sets the group ID of this participation.
	 *
	 * @param groupId the group ID of this participation
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the image ID of this participation.
	 *
	 * @param imageId the image ID of this participation
	 */
	@Override
	public void setImageId(long imageId) {
		model.setImageId(imageId);
	}

	/**
	 * Sets whether this participation is media choice.
	 *
	 * @param mediaChoice the media choice of this participation
	 */
	@Override
	public void setMediaChoice(boolean mediaChoice) {
		model.setMediaChoice(mediaChoice);
	}

	/**
	 * Sets the modified date of this participation.
	 *
	 * @param modifiedDate the modified date of this participation
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the participation ID of this participation.
	 *
	 * @param participationId the participation ID of this participation
	 */
	@Override
	public void setParticipationId(long participationId) {
		model.setParticipationId(participationId);
	}

	/**
	 * Sets the primary key of this participation.
	 *
	 * @param primaryKey the primary key of this participation
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the publication date of this participation.
	 *
	 * @param publicationDate the publication date of this participation
	 */
	@Override
	public void setPublicationDate(Date publicationDate) {
		model.setPublicationDate(publicationDate);
	}

	/**
	 * Sets the status of this participation.
	 *
	 * @param status the status of this participation
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this participation.
	 *
	 * @param statusByUserId the status by user ID of this participation
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this participation.
	 *
	 * @param statusByUserName the status by user name of this participation
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this participation.
	 *
	 * @param statusByUserUuid the status by user uuid of this participation
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this participation.
	 *
	 * @param statusDate the status date of this participation
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the title of this participation.
	 *
	 * @param title the title of this participation
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the user ID of this participation.
	 *
	 * @param userId the user ID of this participation
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this participation.
	 *
	 * @param userName the user name of this participation
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this participation.
	 *
	 * @param userUuid the user uuid of this participation
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this participation.
	 *
	 * @param uuid the uuid of this participation
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the video url of this participation.
	 *
	 * @param videoUrl the video url of this participation
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
	public com.liferay.portal.kernel.json.JSONObject toJSON(
			com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.toJSON(themeDisplay);
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
	protected ParticipationWrapper wrap(Participation participation) {
		return new ParticipationWrapper(participation);
	}

}