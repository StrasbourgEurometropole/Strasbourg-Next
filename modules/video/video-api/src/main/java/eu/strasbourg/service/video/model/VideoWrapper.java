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

package eu.strasbourg.service.video.model;

import aQute.bnd.annotation.ProviderType;

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
 * This class is a wrapper for {@link Video}.
 * </p>
 *
 * @author BenjaminBini
 * @see Video
 * @generated
 */
@ProviderType
public class VideoWrapper implements Video, ModelWrapper<Video> {

	public VideoWrapper(Video video) {
		_video = video;
	}

	@Override
	public Class<?> getModelClass() {
		return Video.class;
	}

	@Override
	public String getModelClassName() {
		return Video.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("videoId", getVideoId());
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
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("copyright", getCopyright());
		attributes.put("source", getSource());
		attributes.put("publicationDate", getPublicationDate());
		attributes.put("imageId", getImageId());
		attributes.put("transcriptionFileId", getTranscriptionFileId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long videoId = (Long)attributes.get("videoId");

		if (videoId != null) {
			setVideoId(videoId);
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

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String copyright = (String)attributes.get("copyright");

		if (copyright != null) {
			setCopyright(copyright);
		}

		String source = (String)attributes.get("source");

		if (source != null) {
			setSource(source);
		}

		Date publicationDate = (Date)attributes.get("publicationDate");

		if (publicationDate != null) {
			setPublicationDate(publicationDate);
		}

		Long imageId = (Long)attributes.get("imageId");

		if (imageId != null) {
			setImageId(imageId);
		}

		Long transcriptionFileId = (Long)attributes.get("transcriptionFileId");

		if (transcriptionFileId != null) {
			setTranscriptionFileId(transcriptionFileId);
		}
	}

	@Override
	public Object clone() {
		return new VideoWrapper((Video)_video.clone());
	}

	@Override
	public int compareTo(eu.strasbourg.service.video.model.Video video) {
		return _video.compareTo(video);
	}

	/**
	 * Retourne l'AssetEntry correspondant à cet item
	 */
	@Override
	public com.liferay.asset.kernel.model.AssetEntry getAssetEntry() {
		return _video.getAssetEntry();
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return _video.getAvailableLanguageIds();
	}

	/**
	 * Retourne la liste des AssetCategory correspondant à cet item (via
	 * l'AssetEntry)
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCategories() {

		return _video.getCategories();
	}

	/**
	 * Retourne l'url de la catégorie de la vidéo
	 */
	@Override
	public String getCategoryURL(
			com.liferay.asset.kernel.model.AssetCategory category)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _video.getCategoryURL(category);
	}

	/**
	 * Retourne les chaînes de la vidéo
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getChaines() {

		return _video.getChaines();
	}

	/**
	 * Retourne le texte à afficher pour les chaînes de la vidéo
	 */
	@Override
	public String getChannelsLabel(java.util.Locale locale) {
		return _video.getChannelsLabel(locale);
	}

	/**
	 * Returns the company ID of this video.
	 *
	 * @return the company ID of this video
	 */
	@Override
	public long getCompanyId() {
		return _video.getCompanyId();
	}

	/**
	 * Returns the copyright of this video.
	 *
	 * @return the copyright of this video
	 */
	@Override
	public String getCopyright() {
		return _video.getCopyright();
	}

	/**
	 * Returns the localized copyright of this video in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized copyright of this video
	 */
	@Override
	public String getCopyright(java.util.Locale locale) {
		return _video.getCopyright(locale);
	}

	/**
	 * Returns the localized copyright of this video in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized copyright of this video. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getCopyright(java.util.Locale locale, boolean useDefault) {
		return _video.getCopyright(locale, useDefault);
	}

	/**
	 * Returns the localized copyright of this video in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized copyright of this video
	 */
	@Override
	public String getCopyright(String languageId) {
		return _video.getCopyright(languageId);
	}

	/**
	 * Returns the localized copyright of this video in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized copyright of this video
	 */
	@Override
	public String getCopyright(String languageId, boolean useDefault) {
		return _video.getCopyright(languageId, useDefault);
	}

	@Override
	public String getCopyrightCurrentLanguageId() {
		return _video.getCopyrightCurrentLanguageId();
	}

	@Override
	public String getCopyrightCurrentValue() {
		return _video.getCopyrightCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized copyrights of this video.
	 *
	 * @return the locales and localized copyrights of this video
	 */
	@Override
	public Map<java.util.Locale, String> getCopyrightMap() {
		return _video.getCopyrightMap();
	}

	/**
	 * Returns the create date of this video.
	 *
	 * @return the create date of this video
	 */
	@Override
	public Date getCreateDate() {
		return _video.getCreateDate();
	}

	@Override
	public String getDefaultLanguageId() {
		return _video.getDefaultLanguageId();
	}

	/**
	 * Returns the description of this video.
	 *
	 * @return the description of this video
	 */
	@Override
	public String getDescription() {
		return _video.getDescription();
	}

	/**
	 * Returns the localized description of this video in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description of this video
	 */
	@Override
	public String getDescription(java.util.Locale locale) {
		return _video.getDescription(locale);
	}

	/**
	 * Returns the localized description of this video in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this video. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getDescription(java.util.Locale locale, boolean useDefault) {
		return _video.getDescription(locale, useDefault);
	}

	/**
	 * Returns the localized description of this video in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description of this video
	 */
	@Override
	public String getDescription(String languageId) {
		return _video.getDescription(languageId);
	}

	/**
	 * Returns the localized description of this video in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this video
	 */
	@Override
	public String getDescription(String languageId, boolean useDefault) {
		return _video.getDescription(languageId, useDefault);
	}

	@Override
	public String getDescriptionCurrentLanguageId() {
		return _video.getDescriptionCurrentLanguageId();
	}

	@Override
	public String getDescriptionCurrentValue() {
		return _video.getDescriptionCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized descriptions of this video.
	 *
	 * @return the locales and localized descriptions of this video
	 */
	@Override
	public Map<java.util.Locale, String> getDescriptionMap() {
		return _video.getDescriptionMap();
	}

	/**
	 * Retourne la liste des dislikes de l'entité
	 *
	 * @see eu.strasbourg.service.like.model.LikeType
	 */
	@Override
	public java.util.List<eu.strasbourg.service.like.model.Like> getDislikes() {
		return _video.getDislikes();
	}

	/**
	 * Retourne les sous-sous-catégories 'Territoire' correspondant aux quartiers de la vidéo
	 *
	 * @return : la liste des catégories
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getDistrictCategories() {

		return _video.getDistrictCategories();
	}

	/**
	 * Retourne le code embed de la vidéo si le champ "source" est un lien
	 * vers une vidéo Dailymotion, YouTube ou Vimeo, retourne le contenu du
	 * champ source sinon
	 */
	@Override
	public String getEmbedURL(String site, String videoUrl) {
		return _video.getEmbedURL(site, videoUrl);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _video.getExpandoBridge();
	}

	/**
	 * Returns the group ID of this video.
	 *
	 * @return the group ID of this video
	 */
	@Override
	public long getGroupId() {
		return _video.getGroupId();
	}

	/**
	 * Returns the image ID of this video.
	 *
	 * @return the image ID of this video
	 */
	@Override
	public Long getImageId() {
		return _video.getImageId();
	}

	/**
	 * Renvoie l'URL de l'image à partir de l'id du DLFileEntry
	 */
	@Override
	public String getImageURL() {
		return _video.getImageURL();
	}

	/**
	 * Returns the last publish date of this video.
	 *
	 * @return the last publish date of this video
	 */
	@Override
	public Date getLastPublishDate() {
		return _video.getLastPublishDate();
	}

	/**
	 * Retourne la liste des likes de l'entité
	 *
	 * @see eu.strasbourg.service.like.model.LikeType
	 */
	@Override
	public java.util.List<eu.strasbourg.service.like.model.Like> getLikes() {
		return _video.getLikes();
	}

	/**
	 * Retourne la liste des like/dislike de l'entité
	 *
	 * @see eu.strasbourg.service.like.model.LikeType
	 */
	@Override
	public java.util.List<eu.strasbourg.service.like.model.Like>
		getLikesDislikes() {

		return _video.getLikesDislikes();
	}

	/**
	 * Retourne la version live de la vidéo si elle existe, null sinon
	 */
	@Override
	public eu.strasbourg.service.video.model.Video getLiveVersion() {
		return _video.getLiveVersion();
	}

	/**
	 * Returns the modified date of this video.
	 *
	 * @return the modified date of this video
	 */
	@Override
	public Date getModifiedDate() {
		return _video.getModifiedDate();
	}

	/**
	 * Retourne le nombre de dislikes de l'entité
	 *
	 * @see eu.strasbourg.service.like.model.LikeType
	 */
	@Override
	public int getNbDislikes() {
		return _video.getNbDislikes();
	}

	/**
	 * Retourne le nombre de likes de l'entité
	 *
	 * @see eu.strasbourg.service.like.model.LikeType
	 */
	@Override
	public int getNbLikes() {
		return _video.getNbLikes();
	}

	/**
	 * Retourne le nombre de likes/dislikes de l'entité
	 *
	 * @see eu.strasbourg.service.like.model.LikeType
	 */
	@Override
	public int getNbLikesDislikes() {
		return _video.getNbLikesDislikes();
	}

	/**
	 * Retourne le nombre de vues d'une vidéo
	 */
	@Override
	public String getNbViews(String site, String videoId) {
		return _video.getNbViews(site, videoId);
	}

	/**
	 * Retourne le code html embed du player si le champ "source" est un lien
	 * vers une vidéo Dailymotion, YouTube ou Vimeo, retourne le contenu du
	 * champ source sinon
	 */
	@Override
	public String getPlayer(java.util.Locale locale) {
		return _video.getPlayer(locale);
	}

	/**
	 * Retourne le code html nécessaire à l'affichage de la vidéo dans le header du site vidéo
	 * et de son utilisation par les différentes API
	 */
	@Override
	public String getPlayerHeaderVideo(java.util.Locale locale) {
		return _video.getPlayerHeaderVideo(locale);
	}

	/**
	 * Returns the primary key of this video.
	 *
	 * @return the primary key of this video
	 */
	@Override
	public long getPrimaryKey() {
		return _video.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _video.getPrimaryKeyObj();
	}

	/**
	 * Retourne le projet de la video
	 */
	@Override
	public com.liferay.asset.kernel.model.AssetCategory getProjectCategory() {
		return _video.getProjectCategory();
	}

	/**
	 * Retourne les fournisseurs de la vidéo
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getProviders() {

		return _video.getProviders();
	}

	/**
	 * Retourne le texte à afficher pour les fournisseurs de la vidéo
	 */
	@Override
	public String getProvidersLabel(java.util.Locale locale) {
		return _video.getProvidersLabel(locale);
	}

	/**
	 * Returns the publication date of this video.
	 *
	 * @return the publication date of this video
	 */
	@Override
	public Date getPublicationDate() {
		return _video.getPublicationDate();
	}

	/**
	 * Renvoie la liste des galeries vidéos publiées de la
	 */
	@Override
	public java.util.List<eu.strasbourg.service.video.model.VideoGallery>
		getPublishedVideoGalleries() {

		return _video.getPublishedVideoGalleries();
	}

	/**
	 * Retourne le site cible de la vidéo
	 */
	@Override
	public String getSiteVideo(String videoUrl) {
		return _video.getSiteVideo(videoUrl);
	}

	/**
	 * Returns the source of this video.
	 *
	 * @return the source of this video
	 */
	@Override
	public String getSource() {
		return _video.getSource();
	}

	/**
	 * Returns the localized source of this video in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized source of this video
	 */
	@Override
	public String getSource(java.util.Locale locale) {
		return _video.getSource(locale);
	}

	/**
	 * Returns the localized source of this video in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized source of this video. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getSource(java.util.Locale locale, boolean useDefault) {
		return _video.getSource(locale, useDefault);
	}

	/**
	 * Returns the localized source of this video in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized source of this video
	 */
	@Override
	public String getSource(String languageId) {
		return _video.getSource(languageId);
	}

	/**
	 * Returns the localized source of this video in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized source of this video
	 */
	@Override
	public String getSource(String languageId, boolean useDefault) {
		return _video.getSource(languageId, useDefault);
	}

	@Override
	public String getSourceCurrentLanguageId() {
		return _video.getSourceCurrentLanguageId();
	}

	@Override
	public String getSourceCurrentValue() {
		return _video.getSourceCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized sources of this video.
	 *
	 * @return the locales and localized sources of this video
	 */
	@Override
	public Map<java.util.Locale, String> getSourceMap() {
		return _video.getSourceMap();
	}

	/**
	 * Returns the status of this video.
	 *
	 * @return the status of this video
	 */
	@Override
	public int getStatus() {
		return _video.getStatus();
	}

	/**
	 * Returns the status by user ID of this video.
	 *
	 * @return the status by user ID of this video
	 */
	@Override
	public long getStatusByUserId() {
		return _video.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this video.
	 *
	 * @return the status by user name of this video
	 */
	@Override
	public String getStatusByUserName() {
		return _video.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this video.
	 *
	 * @return the status by user uuid of this video
	 */
	@Override
	public String getStatusByUserUuid() {
		return _video.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this video.
	 *
	 * @return the status date of this video
	 */
	@Override
	public Date getStatusDate() {
		return _video.getStatusDate();
	}

	/**
	 * Retourne 3 suggestions max pour un thème appartenant à la vidéo en cours
	 *
	 * @throws PortalException
	 */
	@Override
	public java.util.List<eu.strasbourg.service.video.model.Video>
		getSuggestions(java.util.Locale locale) {

		return _video.getSuggestions(locale);
	}

	/**
	 * Retourne X suggestions max pour un thème appartenant à la vidéo en cours
	 *
	 * @throws PortalException
	 */
	@Override
	public java.util.List<eu.strasbourg.service.video.model.Video>
		getSuggestions(java.util.Locale locale, int nbSuggestions) {

		return _video.getSuggestions(locale, nbSuggestions);
	}

	/**
	 * Retourne les thematiques de la vidéo
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getThematicCategories() {

		return _video.getThematicCategories();
	}

	/**
	 * Retourne les thèmes de la vidéo
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getThemes() {

		return _video.getThemes();
	}

	/**
	 * Retourne les thèmes de la vidéo
	 */
	@Override
	public String getThemesLabel(java.util.Locale locale) {
		return _video.getThemesLabel(locale);
	}

	/**
	 * Returns the title of this video.
	 *
	 * @return the title of this video
	 */
	@Override
	public String getTitle() {
		return _video.getTitle();
	}

	/**
	 * Returns the localized title of this video in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized title of this video
	 */
	@Override
	public String getTitle(java.util.Locale locale) {
		return _video.getTitle(locale);
	}

	/**
	 * Returns the localized title of this video in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this video. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getTitle(java.util.Locale locale, boolean useDefault) {
		return _video.getTitle(locale, useDefault);
	}

	/**
	 * Returns the localized title of this video in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized title of this video
	 */
	@Override
	public String getTitle(String languageId) {
		return _video.getTitle(languageId);
	}

	/**
	 * Returns the localized title of this video in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this video
	 */
	@Override
	public String getTitle(String languageId, boolean useDefault) {
		return _video.getTitle(languageId, useDefault);
	}

	@Override
	public String getTitleCurrentLanguageId() {
		return _video.getTitleCurrentLanguageId();
	}

	@Override
	public String getTitleCurrentValue() {
		return _video.getTitleCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized titles of this video.
	 *
	 * @return the locales and localized titles of this video
	 */
	@Override
	public Map<java.util.Locale, String> getTitleMap() {
		return _video.getTitleMap();
	}

	/**
	 * Retourne l'URL de téléchargement du fichier de transcription
	 */
	@Override
	public String getTranscriptionDownloadURL() {
		return _video.getTranscriptionDownloadURL();
	}

	/**
	 * Returns the transcription file ID of this video.
	 *
	 * @return the transcription file ID of this video
	 */
	@Override
	public Long getTranscriptionFileId() {
		return _video.getTranscriptionFileId();
	}

	/**
	 * Returns the user ID of this video.
	 *
	 * @return the user ID of this video
	 */
	@Override
	public long getUserId() {
		return _video.getUserId();
	}

	/**
	 * Returns the user name of this video.
	 *
	 * @return the user name of this video
	 */
	@Override
	public String getUserName() {
		return _video.getUserName();
	}

	/**
	 * Returns the user uuid of this video.
	 *
	 * @return the user uuid of this video
	 */
	@Override
	public String getUserUuid() {
		return _video.getUserUuid();
	}

	/**
	 * Returns the uuid of this video.
	 *
	 * @return the uuid of this video
	 */
	@Override
	public String getUuid() {
		return _video.getUuid();
	}

	/**
	 * Retourne la liste des galeries de la vidéo
	 */
	@Override
	public java.util.List<eu.strasbourg.service.video.model.VideoGallery>
		getVideoGalleries() {

		return _video.getVideoGalleries();
	}

	/**
	 * Retourne la liste des ids des galeries de la vidéo
	 */
	@Override
	public String getVideoGalleriesIds() {
		return _video.getVideoGalleriesIds();
	}

	/**
	 * Returns the video ID of this video.
	 *
	 * @return the video ID of this video
	 */
	@Override
	public long getVideoId() {
		return _video.getVideoId();
	}

	/**
	 * Retourne l'id de la vidéo
	 */
	@Override
	public String getVideoId(String site, String videoUrl) {
		return _video.getVideoId(site, videoUrl);
	}

	@Override
	public int hashCode() {
		return _video.hashCode();
	}

	/**
	 * Returns <code>true</code> if this video is approved.
	 *
	 * @return <code>true</code> if this video is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return _video.isApproved();
	}

	@Override
	public boolean isCachedModel() {
		return _video.isCachedModel();
	}

	/**
	 * Returns <code>true</code> if this video is denied.
	 *
	 * @return <code>true</code> if this video is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return _video.isDenied();
	}

	/**
	 * Returns <code>true</code> if this video is a draft.
	 *
	 * @return <code>true</code> if this video is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return _video.isDraft();
	}

	@Override
	public boolean isEscapedModel() {
		return _video.isEscapedModel();
	}

	/**
	 * Returns <code>true</code> if this video is expired.
	 *
	 * @return <code>true</code> if this video is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return _video.isExpired();
	}

	/**
	 * Returns <code>true</code> if this video is inactive.
	 *
	 * @return <code>true</code> if this video is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return _video.isInactive();
	}

	/**
	 * Returns <code>true</code> if this video is incomplete.
	 *
	 * @return <code>true</code> if this video is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return _video.isIncomplete();
	}

	@Override
	public boolean isNew() {
		return _video.isNew();
	}

	/**
	 * Returns <code>true</code> if this video is pending.
	 *
	 * @return <code>true</code> if this video is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return _video.isPending();
	}

	/**
	 * Returns <code>true</code> if this video is scheduled.
	 *
	 * @return <code>true</code> if this video is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return _video.isScheduled();
	}

	@Override
	public void persist() {
		_video.persist();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.kernel.exception.LocaleException {

		_video.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
			java.util.Locale defaultImportLocale)
		throws com.liferay.portal.kernel.exception.LocaleException {

		_video.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_video.setCachedModel(cachedModel);
	}

	/**
	 * Sets the company ID of this video.
	 *
	 * @param companyId the company ID of this video
	 */
	@Override
	public void setCompanyId(long companyId) {
		_video.setCompanyId(companyId);
	}

	/**
	 * Sets the copyright of this video.
	 *
	 * @param copyright the copyright of this video
	 */
	@Override
	public void setCopyright(String copyright) {
		_video.setCopyright(copyright);
	}

	/**
	 * Sets the localized copyright of this video in the language.
	 *
	 * @param copyright the localized copyright of this video
	 * @param locale the locale of the language
	 */
	@Override
	public void setCopyright(String copyright, java.util.Locale locale) {
		_video.setCopyright(copyright, locale);
	}

	/**
	 * Sets the localized copyright of this video in the language, and sets the default locale.
	 *
	 * @param copyright the localized copyright of this video
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setCopyright(
		String copyright, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		_video.setCopyright(copyright, locale, defaultLocale);
	}

	@Override
	public void setCopyrightCurrentLanguageId(String languageId) {
		_video.setCopyrightCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized copyrights of this video from the map of locales and localized copyrights.
	 *
	 * @param copyrightMap the locales and localized copyrights of this video
	 */
	@Override
	public void setCopyrightMap(Map<java.util.Locale, String> copyrightMap) {
		_video.setCopyrightMap(copyrightMap);
	}

	/**
	 * Sets the localized copyrights of this video from the map of locales and localized copyrights, and sets the default locale.
	 *
	 * @param copyrightMap the locales and localized copyrights of this video
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setCopyrightMap(
		Map<java.util.Locale, String> copyrightMap,
		java.util.Locale defaultLocale) {

		_video.setCopyrightMap(copyrightMap, defaultLocale);
	}

	/**
	 * Sets the create date of this video.
	 *
	 * @param createDate the create date of this video
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_video.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this video.
	 *
	 * @param description the description of this video
	 */
	@Override
	public void setDescription(String description) {
		_video.setDescription(description);
	}

	/**
	 * Sets the localized description of this video in the language.
	 *
	 * @param description the localized description of this video
	 * @param locale the locale of the language
	 */
	@Override
	public void setDescription(String description, java.util.Locale locale) {
		_video.setDescription(description, locale);
	}

	/**
	 * Sets the localized description of this video in the language, and sets the default locale.
	 *
	 * @param description the localized description of this video
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDescription(
		String description, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		_video.setDescription(description, locale, defaultLocale);
	}

	@Override
	public void setDescriptionCurrentLanguageId(String languageId) {
		_video.setDescriptionCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized descriptions of this video from the map of locales and localized descriptions.
	 *
	 * @param descriptionMap the locales and localized descriptions of this video
	 */
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, String> descriptionMap) {

		_video.setDescriptionMap(descriptionMap);
	}

	/**
	 * Sets the localized descriptions of this video from the map of locales and localized descriptions, and sets the default locale.
	 *
	 * @param descriptionMap the locales and localized descriptions of this video
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, String> descriptionMap,
		java.util.Locale defaultLocale) {

		_video.setDescriptionMap(descriptionMap, defaultLocale);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_video.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_video.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_video.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the group ID of this video.
	 *
	 * @param groupId the group ID of this video
	 */
	@Override
	public void setGroupId(long groupId) {
		_video.setGroupId(groupId);
	}

	/**
	 * Sets the image ID of this video.
	 *
	 * @param imageId the image ID of this video
	 */
	@Override
	public void setImageId(Long imageId) {
		_video.setImageId(imageId);
	}

	/**
	 * Sets the last publish date of this video.
	 *
	 * @param lastPublishDate the last publish date of this video
	 */
	@Override
	public void setLastPublishDate(Date lastPublishDate) {
		_video.setLastPublishDate(lastPublishDate);
	}

	/**
	 * Sets the modified date of this video.
	 *
	 * @param modifiedDate the modified date of this video
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_video.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_video.setNew(n);
	}

	/**
	 * Sets the primary key of this video.
	 *
	 * @param primaryKey the primary key of this video
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_video.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_video.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the publication date of this video.
	 *
	 * @param publicationDate the publication date of this video
	 */
	@Override
	public void setPublicationDate(Date publicationDate) {
		_video.setPublicationDate(publicationDate);
	}

	/**
	 * Sets the source of this video.
	 *
	 * @param source the source of this video
	 */
	@Override
	public void setSource(String source) {
		_video.setSource(source);
	}

	/**
	 * Sets the localized source of this video in the language.
	 *
	 * @param source the localized source of this video
	 * @param locale the locale of the language
	 */
	@Override
	public void setSource(String source, java.util.Locale locale) {
		_video.setSource(source, locale);
	}

	/**
	 * Sets the localized source of this video in the language, and sets the default locale.
	 *
	 * @param source the localized source of this video
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setSource(
		String source, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		_video.setSource(source, locale, defaultLocale);
	}

	@Override
	public void setSourceCurrentLanguageId(String languageId) {
		_video.setSourceCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized sources of this video from the map of locales and localized sources.
	 *
	 * @param sourceMap the locales and localized sources of this video
	 */
	@Override
	public void setSourceMap(Map<java.util.Locale, String> sourceMap) {
		_video.setSourceMap(sourceMap);
	}

	/**
	 * Sets the localized sources of this video from the map of locales and localized sources, and sets the default locale.
	 *
	 * @param sourceMap the locales and localized sources of this video
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setSourceMap(
		Map<java.util.Locale, String> sourceMap,
		java.util.Locale defaultLocale) {

		_video.setSourceMap(sourceMap, defaultLocale);
	}

	/**
	 * Sets the status of this video.
	 *
	 * @param status the status of this video
	 */
	@Override
	public void setStatus(int status) {
		_video.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this video.
	 *
	 * @param statusByUserId the status by user ID of this video
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_video.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this video.
	 *
	 * @param statusByUserName the status by user name of this video
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		_video.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this video.
	 *
	 * @param statusByUserUuid the status by user uuid of this video
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		_video.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this video.
	 *
	 * @param statusDate the status date of this video
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		_video.setStatusDate(statusDate);
	}

	/**
	 * Sets the title of this video.
	 *
	 * @param title the title of this video
	 */
	@Override
	public void setTitle(String title) {
		_video.setTitle(title);
	}

	/**
	 * Sets the localized title of this video in the language.
	 *
	 * @param title the localized title of this video
	 * @param locale the locale of the language
	 */
	@Override
	public void setTitle(String title, java.util.Locale locale) {
		_video.setTitle(title, locale);
	}

	/**
	 * Sets the localized title of this video in the language, and sets the default locale.
	 *
	 * @param title the localized title of this video
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setTitle(
		String title, java.util.Locale locale, java.util.Locale defaultLocale) {

		_video.setTitle(title, locale, defaultLocale);
	}

	@Override
	public void setTitleCurrentLanguageId(String languageId) {
		_video.setTitleCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized titles of this video from the map of locales and localized titles.
	 *
	 * @param titleMap the locales and localized titles of this video
	 */
	@Override
	public void setTitleMap(Map<java.util.Locale, String> titleMap) {
		_video.setTitleMap(titleMap);
	}

	/**
	 * Sets the localized titles of this video from the map of locales and localized titles, and sets the default locale.
	 *
	 * @param titleMap the locales and localized titles of this video
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setTitleMap(
		Map<java.util.Locale, String> titleMap,
		java.util.Locale defaultLocale) {

		_video.setTitleMap(titleMap, defaultLocale);
	}

	/**
	 * Sets the transcription file ID of this video.
	 *
	 * @param transcriptionFileId the transcription file ID of this video
	 */
	@Override
	public void setTranscriptionFileId(Long transcriptionFileId) {
		_video.setTranscriptionFileId(transcriptionFileId);
	}

	/**
	 * Sets the user ID of this video.
	 *
	 * @param userId the user ID of this video
	 */
	@Override
	public void setUserId(long userId) {
		_video.setUserId(userId);
	}

	/**
	 * Sets the user name of this video.
	 *
	 * @param userName the user name of this video
	 */
	@Override
	public void setUserName(String userName) {
		_video.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this video.
	 *
	 * @param userUuid the user uuid of this video
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_video.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this video.
	 *
	 * @param uuid the uuid of this video
	 */
	@Override
	public void setUuid(String uuid) {
		_video.setUuid(uuid);
	}

	/**
	 * Sets the video ID of this video.
	 *
	 * @param videoId the video ID of this video
	 */
	@Override
	public void setVideoId(long videoId) {
		_video.setVideoId(videoId);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<eu.strasbourg.service.video.model.Video> toCacheModel() {

		return _video.toCacheModel();
	}

	@Override
	public eu.strasbourg.service.video.model.Video toEscapedModel() {
		return new VideoWrapper(_video.toEscapedModel());
	}

	/**
	 * Retourne la vidéo au format JSON
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONObject toJSON() {
		return _video.toJSON();
	}

	@Override
	public String toString() {
		return _video.toString();
	}

	@Override
	public eu.strasbourg.service.video.model.Video toUnescapedModel() {
		return new VideoWrapper(_video.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _video.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VideoWrapper)) {
			return false;
		}

		VideoWrapper videoWrapper = (VideoWrapper)obj;

		if (Objects.equals(_video, videoWrapper._video)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _video.getStagedModelType();
	}

	@Override
	public Video getWrappedModel() {
		return _video;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _video.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _video.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_video.resetOriginalValues();
	}

	private final Video _video;

}