/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.video.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Video}.
 * </p>
 *
 * @author BenjaminBini
 * @see Video
 * @generated
 */
public class VideoWrapper
	extends BaseModelWrapper<Video> implements ModelWrapper<Video>, Video {

	public VideoWrapper(Video video) {
		super(video);
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
	public Video cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Retourne l'AssetEntry correspondant à cet item
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
	 * Retourne la liste des AssetCategory correspondant à cet item (via
	 * l'AssetEntry)
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCategories() {

		return model.getCategories();
	}

	/**
	 * Retourne l'url de la catégorie de la vidéo
	 */
	@Override
	public String getCategoryURL(
			com.liferay.asset.kernel.model.AssetCategory category)
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.getCategoryURL(category);
	}

	/**
	 * Retourne les chaînes de la vidéo
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getChaines() {

		return model.getChaines();
	}

	/**
	 * Retourne le texte à afficher pour les chaînes de la vidéo
	 */
	@Override
	public String getChannelsLabel(java.util.Locale locale) {
		return model.getChannelsLabel(locale);
	}

	/**
	 * Returns the company ID of this video.
	 *
	 * @return the company ID of this video
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the copyright of this video.
	 *
	 * @return the copyright of this video
	 */
	@Override
	public String getCopyright() {
		return model.getCopyright();
	}

	/**
	 * Returns the localized copyright of this video in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized copyright of this video
	 */
	@Override
	public String getCopyright(java.util.Locale locale) {
		return model.getCopyright(locale);
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
		return model.getCopyright(locale, useDefault);
	}

	/**
	 * Returns the localized copyright of this video in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized copyright of this video
	 */
	@Override
	public String getCopyright(String languageId) {
		return model.getCopyright(languageId);
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
		return model.getCopyright(languageId, useDefault);
	}

	@Override
	public String getCopyrightCurrentLanguageId() {
		return model.getCopyrightCurrentLanguageId();
	}

	@Override
	public String getCopyrightCurrentValue() {
		return model.getCopyrightCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized copyrights of this video.
	 *
	 * @return the locales and localized copyrights of this video
	 */
	@Override
	public Map<java.util.Locale, String> getCopyrightMap() {
		return model.getCopyrightMap();
	}

	/**
	 * Returns the create date of this video.
	 *
	 * @return the create date of this video
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
	 * Returns the description of this video.
	 *
	 * @return the description of this video
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the localized description of this video in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description of this video
	 */
	@Override
	public String getDescription(java.util.Locale locale) {
		return model.getDescription(locale);
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
		return model.getDescription(locale, useDefault);
	}

	/**
	 * Returns the localized description of this video in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description of this video
	 */
	@Override
	public String getDescription(String languageId) {
		return model.getDescription(languageId);
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
	 * Returns a map of the locales and localized descriptions of this video.
	 *
	 * @return the locales and localized descriptions of this video
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
	 * Retourne les sous-sous-catégories 'Territoire' correspondant aux quartiers de la vidéo
	 *
	 * @return : la liste des catégories
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getDistrictCategories() {

		return model.getDistrictCategories();
	}

	/**
	 * Retourne le code embed de la vidéo si le champ "source" est un lien
	 * vers une vidéo Dailymotion, YouTube ou Vimeo, retourne le contenu du
	 * champ source sinon
	 */
	@Override
	public String getEmbedURL(String site, String videoUrl) {
		return model.getEmbedURL(site, videoUrl);
	}

	/**
	 * Returns the group ID of this video.
	 *
	 * @return the group ID of this video
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the image ID of this video.
	 *
	 * @return the image ID of this video
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
	 * Returns the last publish date of this video.
	 *
	 * @return the last publish date of this video
	 */
	@Override
	public Date getLastPublishDate() {
		return model.getLastPublishDate();
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
	 * Retourne la version live de la vidéo si elle existe, null sinon
	 */
	@Override
	public Video getLiveVersion() {
		return model.getLiveVersion();
	}

	/**
	 * Returns the modified date of this video.
	 *
	 * @return the modified date of this video
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
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
	 * Retourne le nombre de vues d'une vidéo
	 */
	@Override
	public String getNbViews(String site, String videoId) {
		return model.getNbViews(site, videoId);
	}

	/**
	 * Retourne le code html embed du player si le champ "source" est un lien
	 * vers une vidéo Dailymotion, YouTube ou Vimeo, retourne le contenu du
	 * champ source sinon
	 */
	@Override
	public String getPlayer(java.util.Locale locale) {
		return model.getPlayer(locale);
	}

	/**
	 * Retourne le code html nécessaire à l'affichage de la vidéo dans le header du site vidéo
	 * et de son utilisation par les différentes API
	 */
	@Override
	public String getPlayerHeaderVideo(java.util.Locale locale) {
		return model.getPlayerHeaderVideo(locale);
	}

	/**
	 * Returns the primary key of this video.
	 *
	 * @return the primary key of this video
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Retourne le projet de la video
	 */
	@Override
	public com.liferay.asset.kernel.model.AssetCategory getProjectCategory() {
		return model.getProjectCategory();
	}

	/**
	 * Retourne les fournisseurs de la vidéo
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getProviders() {

		return model.getProviders();
	}

	/**
	 * Retourne le texte à afficher pour les fournisseurs de la vidéo
	 */
	@Override
	public String getProvidersLabel(java.util.Locale locale) {
		return model.getProvidersLabel(locale);
	}

	/**
	 * Returns the publication date of this video.
	 *
	 * @return the publication date of this video
	 */
	@Override
	public Date getPublicationDate() {
		return model.getPublicationDate();
	}

	/**
	 * Renvoie la liste des galeries vidéos publiées de la
	 */
	@Override
	public java.util.List<VideoGallery> getPublishedVideoGalleries() {
		return model.getPublishedVideoGalleries();
	}

	/**
	 * Retourne le site cible de la vidéo
	 */
	@Override
	public String getSiteVideo(String videoUrl) {
		return model.getSiteVideo(videoUrl);
	}

	/**
	 * Returns the source of this video.
	 *
	 * @return the source of this video
	 */
	@Override
	public String getSource() {
		return model.getSource();
	}

	/**
	 * Returns the localized source of this video in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized source of this video
	 */
	@Override
	public String getSource(java.util.Locale locale) {
		return model.getSource(locale);
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
		return model.getSource(locale, useDefault);
	}

	/**
	 * Returns the localized source of this video in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized source of this video
	 */
	@Override
	public String getSource(String languageId) {
		return model.getSource(languageId);
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
		return model.getSource(languageId, useDefault);
	}

	@Override
	public String getSourceCurrentLanguageId() {
		return model.getSourceCurrentLanguageId();
	}

	@Override
	public String getSourceCurrentValue() {
		return model.getSourceCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized sources of this video.
	 *
	 * @return the locales and localized sources of this video
	 */
	@Override
	public Map<java.util.Locale, String> getSourceMap() {
		return model.getSourceMap();
	}

	/**
	 * Returns the status of this video.
	 *
	 * @return the status of this video
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this video.
	 *
	 * @return the status by user ID of this video
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this video.
	 *
	 * @return the status by user name of this video
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this video.
	 *
	 * @return the status by user uuid of this video
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this video.
	 *
	 * @return the status date of this video
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Retourne 3 suggestions max pour un thème appartenant à la vidéo en cours
	 *
	 * @throws PortalException
	 */
	@Override
	public java.util.List<Video> getSuggestions(java.util.Locale locale) {
		return model.getSuggestions(locale);
	}

	/**
	 * Retourne X suggestions max pour un thème appartenant à la vidéo en cours
	 *
	 * @throws PortalException
	 */
	@Override
	public java.util.List<Video> getSuggestions(
		java.util.Locale locale, int nbSuggestions) {

		return model.getSuggestions(locale, nbSuggestions);
	}

	/**
	 * Retourne les thematiques de la vidéo
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getThematicCategories() {

		return model.getThematicCategories();
	}

	/**
	 * Retourne les thèmes de la vidéo
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getThemes() {

		return model.getThemes();
	}

	/**
	 * Retourne les thèmes de la vidéo
	 */
	@Override
	public String getThemesLabel(java.util.Locale locale) {
		return model.getThemesLabel(locale);
	}

	/**
	 * Returns the title of this video.
	 *
	 * @return the title of this video
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the localized title of this video in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized title of this video
	 */
	@Override
	public String getTitle(java.util.Locale locale) {
		return model.getTitle(locale);
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
		return model.getTitle(locale, useDefault);
	}

	/**
	 * Returns the localized title of this video in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized title of this video
	 */
	@Override
	public String getTitle(String languageId) {
		return model.getTitle(languageId);
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
		return model.getTitle(languageId, useDefault);
	}

	@Override
	public String getTitleCurrentLanguageId() {
		return model.getTitleCurrentLanguageId();
	}

	@Override
	public String getTitleCurrentValue() {
		return model.getTitleCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized titles of this video.
	 *
	 * @return the locales and localized titles of this video
	 */
	@Override
	public Map<java.util.Locale, String> getTitleMap() {
		return model.getTitleMap();
	}

	/**
	 * Retourne l'URL de téléchargement du fichier de transcription
	 */
	@Override
	public String getTranscriptionDownloadURL() {
		return model.getTranscriptionDownloadURL();
	}

	/**
	 * Returns the transcription file ID of this video.
	 *
	 * @return the transcription file ID of this video
	 */
	@Override
	public Long getTranscriptionFileId() {
		return model.getTranscriptionFileId();
	}

	/**
	 * Returns the user ID of this video.
	 *
	 * @return the user ID of this video
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this video.
	 *
	 * @return the user name of this video
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this video.
	 *
	 * @return the user uuid of this video
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this video.
	 *
	 * @return the uuid of this video
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Retourne la liste des galeries de la vidéo
	 */
	@Override
	public java.util.List<VideoGallery> getVideoGalleries() {
		return model.getVideoGalleries();
	}

	/**
	 * Retourne la liste des ids des galeries de la vidéo
	 */
	@Override
	public String getVideoGalleriesIds() {
		return model.getVideoGalleriesIds();
	}

	/**
	 * Returns the video ID of this video.
	 *
	 * @return the video ID of this video
	 */
	@Override
	public long getVideoId() {
		return model.getVideoId();
	}

	/**
	 * Retourne l'id de la vidéo
	 */
	@Override
	public String getVideoId(String site, String videoUrl) {
		return model.getVideoId(site, videoUrl);
	}

	/**
	 * Returns <code>true</code> if this video is approved.
	 *
	 * @return <code>true</code> if this video is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this video is denied.
	 *
	 * @return <code>true</code> if this video is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this video is a draft.
	 *
	 * @return <code>true</code> if this video is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this video is expired.
	 *
	 * @return <code>true</code> if this video is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this video is inactive.
	 *
	 * @return <code>true</code> if this video is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this video is incomplete.
	 *
	 * @return <code>true</code> if this video is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this video is pending.
	 *
	 * @return <code>true</code> if this video is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this video is scheduled.
	 *
	 * @return <code>true</code> if this video is scheduled; <code>false</code> otherwise
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
	 * Sets the company ID of this video.
	 *
	 * @param companyId the company ID of this video
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the copyright of this video.
	 *
	 * @param copyright the copyright of this video
	 */
	@Override
	public void setCopyright(String copyright) {
		model.setCopyright(copyright);
	}

	/**
	 * Sets the localized copyright of this video in the language.
	 *
	 * @param copyright the localized copyright of this video
	 * @param locale the locale of the language
	 */
	@Override
	public void setCopyright(String copyright, java.util.Locale locale) {
		model.setCopyright(copyright, locale);
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

		model.setCopyright(copyright, locale, defaultLocale);
	}

	@Override
	public void setCopyrightCurrentLanguageId(String languageId) {
		model.setCopyrightCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized copyrights of this video from the map of locales and localized copyrights.
	 *
	 * @param copyrightMap the locales and localized copyrights of this video
	 */
	@Override
	public void setCopyrightMap(Map<java.util.Locale, String> copyrightMap) {
		model.setCopyrightMap(copyrightMap);
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

		model.setCopyrightMap(copyrightMap, defaultLocale);
	}

	/**
	 * Sets the create date of this video.
	 *
	 * @param createDate the create date of this video
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this video.
	 *
	 * @param description the description of this video
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the localized description of this video in the language.
	 *
	 * @param description the localized description of this video
	 * @param locale the locale of the language
	 */
	@Override
	public void setDescription(String description, java.util.Locale locale) {
		model.setDescription(description, locale);
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

		model.setDescription(description, locale, defaultLocale);
	}

	@Override
	public void setDescriptionCurrentLanguageId(String languageId) {
		model.setDescriptionCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized descriptions of this video from the map of locales and localized descriptions.
	 *
	 * @param descriptionMap the locales and localized descriptions of this video
	 */
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, String> descriptionMap) {

		model.setDescriptionMap(descriptionMap);
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

		model.setDescriptionMap(descriptionMap, defaultLocale);
	}

	/**
	 * Sets the group ID of this video.
	 *
	 * @param groupId the group ID of this video
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the image ID of this video.
	 *
	 * @param imageId the image ID of this video
	 */
	@Override
	public void setImageId(Long imageId) {
		model.setImageId(imageId);
	}

	/**
	 * Sets the last publish date of this video.
	 *
	 * @param lastPublishDate the last publish date of this video
	 */
	@Override
	public void setLastPublishDate(Date lastPublishDate) {
		model.setLastPublishDate(lastPublishDate);
	}

	/**
	 * Sets the modified date of this video.
	 *
	 * @param modifiedDate the modified date of this video
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this video.
	 *
	 * @param primaryKey the primary key of this video
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the publication date of this video.
	 *
	 * @param publicationDate the publication date of this video
	 */
	@Override
	public void setPublicationDate(Date publicationDate) {
		model.setPublicationDate(publicationDate);
	}

	/**
	 * Sets the source of this video.
	 *
	 * @param source the source of this video
	 */
	@Override
	public void setSource(String source) {
		model.setSource(source);
	}

	/**
	 * Sets the localized source of this video in the language.
	 *
	 * @param source the localized source of this video
	 * @param locale the locale of the language
	 */
	@Override
	public void setSource(String source, java.util.Locale locale) {
		model.setSource(source, locale);
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

		model.setSource(source, locale, defaultLocale);
	}

	@Override
	public void setSourceCurrentLanguageId(String languageId) {
		model.setSourceCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized sources of this video from the map of locales and localized sources.
	 *
	 * @param sourceMap the locales and localized sources of this video
	 */
	@Override
	public void setSourceMap(Map<java.util.Locale, String> sourceMap) {
		model.setSourceMap(sourceMap);
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

		model.setSourceMap(sourceMap, defaultLocale);
	}

	/**
	 * Sets the status of this video.
	 *
	 * @param status the status of this video
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this video.
	 *
	 * @param statusByUserId the status by user ID of this video
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this video.
	 *
	 * @param statusByUserName the status by user name of this video
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this video.
	 *
	 * @param statusByUserUuid the status by user uuid of this video
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this video.
	 *
	 * @param statusDate the status date of this video
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the title of this video.
	 *
	 * @param title the title of this video
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the localized title of this video in the language.
	 *
	 * @param title the localized title of this video
	 * @param locale the locale of the language
	 */
	@Override
	public void setTitle(String title, java.util.Locale locale) {
		model.setTitle(title, locale);
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

		model.setTitle(title, locale, defaultLocale);
	}

	@Override
	public void setTitleCurrentLanguageId(String languageId) {
		model.setTitleCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized titles of this video from the map of locales and localized titles.
	 *
	 * @param titleMap the locales and localized titles of this video
	 */
	@Override
	public void setTitleMap(Map<java.util.Locale, String> titleMap) {
		model.setTitleMap(titleMap);
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

		model.setTitleMap(titleMap, defaultLocale);
	}

	/**
	 * Sets the transcription file ID of this video.
	 *
	 * @param transcriptionFileId the transcription file ID of this video
	 */
	@Override
	public void setTranscriptionFileId(Long transcriptionFileId) {
		model.setTranscriptionFileId(transcriptionFileId);
	}

	/**
	 * Sets the user ID of this video.
	 *
	 * @param userId the user ID of this video
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this video.
	 *
	 * @param userName the user name of this video
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this video.
	 *
	 * @param userUuid the user uuid of this video
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this video.
	 *
	 * @param uuid the uuid of this video
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the video ID of this video.
	 *
	 * @param videoId the video ID of this video
	 */
	@Override
	public void setVideoId(long videoId) {
		model.setVideoId(videoId);
	}

	/**
	 * Retourne la vidéo au format JSON
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
	protected VideoWrapper wrap(Video video) {
		return new VideoWrapper(video);
	}

}