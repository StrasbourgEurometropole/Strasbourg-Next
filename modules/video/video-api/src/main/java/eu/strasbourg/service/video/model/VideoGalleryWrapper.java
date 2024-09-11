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
 * This class is a wrapper for {@link VideoGallery}.
 * </p>
 *
 * @author BenjaminBini
 * @see VideoGallery
 * @generated
 */
public class VideoGalleryWrapper
	extends BaseModelWrapper<VideoGallery>
	implements ModelWrapper<VideoGallery>, VideoGallery {

	public VideoGalleryWrapper(VideoGallery videoGallery) {
		super(videoGallery);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("galleryId", getGalleryId());
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
		attributes.put("publicationDate", getPublicationDate());
		attributes.put("imageId", getImageId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long galleryId = (Long)attributes.get("galleryId");

		if (galleryId != null) {
			setGalleryId(galleryId);
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

		Date publicationDate = (Date)attributes.get("publicationDate");

		if (publicationDate != null) {
			setPublicationDate(publicationDate);
		}

		Long imageId = (Long)attributes.get("imageId");

		if (imageId != null) {
			setImageId(imageId);
		}
	}

	@Override
	public VideoGallery cloneWithOriginalValues() {
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
	 * Retourne la liste des AssetCategory correspondant à cet item (via l'AssetEntry)
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCategories() {

		return model.getCategories();
	}

	/**
	 * Returns the company ID of this video gallery.
	 *
	 * @return the company ID of this video gallery
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this video gallery.
	 *
	 * @return the create date of this video gallery
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
	 * Returns the description of this video gallery.
	 *
	 * @return the description of this video gallery
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the localized description of this video gallery in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description of this video gallery
	 */
	@Override
	public String getDescription(java.util.Locale locale) {
		return model.getDescription(locale);
	}

	/**
	 * Returns the localized description of this video gallery in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this video gallery. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getDescription(java.util.Locale locale, boolean useDefault) {
		return model.getDescription(locale, useDefault);
	}

	/**
	 * Returns the localized description of this video gallery in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description of this video gallery
	 */
	@Override
	public String getDescription(String languageId) {
		return model.getDescription(languageId);
	}

	/**
	 * Returns the localized description of this video gallery in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this video gallery
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
	 * Returns a map of the locales and localized descriptions of this video gallery.
	 *
	 * @return the locales and localized descriptions of this video gallery
	 */
	@Override
	public Map<java.util.Locale, String> getDescriptionMap() {
		return model.getDescriptionMap();
	}

	/**
	 * Returns the gallery ID of this video gallery.
	 *
	 * @return the gallery ID of this video gallery
	 */
	@Override
	public long getGalleryId() {
		return model.getGalleryId();
	}

	/**
	 * Returns the group ID of this video gallery.
	 *
	 * @return the group ID of this video gallery
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
	 * Returns the image ID of this video gallery.
	 *
	 * @return the image ID of this video gallery
	 */
	@Override
	public Long getImageId() {
		return model.getImageId();
	}

	/**
	 * Renvoie l'URL de l'image à partir de l'id du DLFileEntry
	 *
	 * @throws PortalException
	 * @throws NumberFormatException
	 */
	@Override
	public String getImageURL() {
		return model.getImageURL();
	}

	/**
	 * Returns the last publish date of this video gallery.
	 *
	 * @return the last publish date of this video gallery
	 */
	@Override
	public Date getLastPublishDate() {
		return model.getLastPublishDate();
	}

	/**
	 * Renvoie la version live de la galerie, si elle existe
	 */
	@Override
	public eu.strasbourg.service.video.model.VideoGallery getLiveVersion() {
		return model.getLiveVersion();
	}

	/**
	 * Returns the modified date of this video gallery.
	 *
	 * @return the modified date of this video gallery
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this video gallery.
	 *
	 * @return the primary key of this video gallery
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the publication date of this video gallery.
	 *
	 * @return the publication date of this video gallery
	 */
	@Override
	public Date getPublicationDate() {
		return model.getPublicationDate();
	}

	/**
	 * Renvoie la liste des éditions publiées de la galerie
	 */
	@Override
	public java.util.List<eu.strasbourg.service.video.model.Video>
		getPublishedVideos() {

		return model.getPublishedVideos();
	}

	/**
	 * Returns the status of this video gallery.
	 *
	 * @return the status of this video gallery
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this video gallery.
	 *
	 * @return the status by user ID of this video gallery
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this video gallery.
	 *
	 * @return the status by user name of this video gallery
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this video gallery.
	 *
	 * @return the status by user uuid of this video gallery
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this video gallery.
	 *
	 * @return the status date of this video gallery
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the title of this video gallery.
	 *
	 * @return the title of this video gallery
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the localized title of this video gallery in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized title of this video gallery
	 */
	@Override
	public String getTitle(java.util.Locale locale) {
		return model.getTitle(locale);
	}

	/**
	 * Returns the localized title of this video gallery in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this video gallery. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getTitle(java.util.Locale locale, boolean useDefault) {
		return model.getTitle(locale, useDefault);
	}

	/**
	 * Returns the localized title of this video gallery in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized title of this video gallery
	 */
	@Override
	public String getTitle(String languageId) {
		return model.getTitle(languageId);
	}

	/**
	 * Returns the localized title of this video gallery in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this video gallery
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
	 * Returns a map of the locales and localized titles of this video gallery.
	 *
	 * @return the locales and localized titles of this video gallery
	 */
	@Override
	public Map<java.util.Locale, String> getTitleMap() {
		return model.getTitleMap();
	}

	/**
	 * Returns the user ID of this video gallery.
	 *
	 * @return the user ID of this video gallery
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this video gallery.
	 *
	 * @return the user name of this video gallery
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this video gallery.
	 *
	 * @return the user uuid of this video gallery
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this video gallery.
	 *
	 * @return the uuid of this video gallery
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Retourne la liste des vidéos de la galerie
	 */
	@Override
	public java.util.List<eu.strasbourg.service.video.model.Video> getVideos() {
		return model.getVideos();
	}

	/**
	 * Retourne la liste des ids des vidéos de la galerie
	 */
	@Override
	public String getVideosIds() {
		return model.getVideosIds();
	}

	/**
	 * Returns <code>true</code> if this video gallery is approved.
	 *
	 * @return <code>true</code> if this video gallery is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this video gallery is denied.
	 *
	 * @return <code>true</code> if this video gallery is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this video gallery is a draft.
	 *
	 * @return <code>true</code> if this video gallery is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this video gallery is expired.
	 *
	 * @return <code>true</code> if this video gallery is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this video gallery is inactive.
	 *
	 * @return <code>true</code> if this video gallery is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this video gallery is incomplete.
	 *
	 * @return <code>true</code> if this video gallery is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this video gallery is pending.
	 *
	 * @return <code>true</code> if this video gallery is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this video gallery is scheduled.
	 *
	 * @return <code>true</code> if this video gallery is scheduled; <code>false</code> otherwise
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
	 * Sets the company ID of this video gallery.
	 *
	 * @param companyId the company ID of this video gallery
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this video gallery.
	 *
	 * @param createDate the create date of this video gallery
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this video gallery.
	 *
	 * @param description the description of this video gallery
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the localized description of this video gallery in the language.
	 *
	 * @param description the localized description of this video gallery
	 * @param locale the locale of the language
	 */
	@Override
	public void setDescription(String description, java.util.Locale locale) {
		model.setDescription(description, locale);
	}

	/**
	 * Sets the localized description of this video gallery in the language, and sets the default locale.
	 *
	 * @param description the localized description of this video gallery
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
	 * Sets the localized descriptions of this video gallery from the map of locales and localized descriptions.
	 *
	 * @param descriptionMap the locales and localized descriptions of this video gallery
	 */
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, String> descriptionMap) {

		model.setDescriptionMap(descriptionMap);
	}

	/**
	 * Sets the localized descriptions of this video gallery from the map of locales and localized descriptions, and sets the default locale.
	 *
	 * @param descriptionMap the locales and localized descriptions of this video gallery
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, String> descriptionMap,
		java.util.Locale defaultLocale) {

		model.setDescriptionMap(descriptionMap, defaultLocale);
	}

	/**
	 * Sets the gallery ID of this video gallery.
	 *
	 * @param galleryId the gallery ID of this video gallery
	 */
	@Override
	public void setGalleryId(long galleryId) {
		model.setGalleryId(galleryId);
	}

	/**
	 * Sets the group ID of this video gallery.
	 *
	 * @param groupId the group ID of this video gallery
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the image ID of this video gallery.
	 *
	 * @param imageId the image ID of this video gallery
	 */
	@Override
	public void setImageId(Long imageId) {
		model.setImageId(imageId);
	}

	/**
	 * Sets the last publish date of this video gallery.
	 *
	 * @param lastPublishDate the last publish date of this video gallery
	 */
	@Override
	public void setLastPublishDate(Date lastPublishDate) {
		model.setLastPublishDate(lastPublishDate);
	}

	/**
	 * Sets the modified date of this video gallery.
	 *
	 * @param modifiedDate the modified date of this video gallery
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this video gallery.
	 *
	 * @param primaryKey the primary key of this video gallery
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the publication date of this video gallery.
	 *
	 * @param publicationDate the publication date of this video gallery
	 */
	@Override
	public void setPublicationDate(Date publicationDate) {
		model.setPublicationDate(publicationDate);
	}

	/**
	 * Sets the status of this video gallery.
	 *
	 * @param status the status of this video gallery
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this video gallery.
	 *
	 * @param statusByUserId the status by user ID of this video gallery
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this video gallery.
	 *
	 * @param statusByUserName the status by user name of this video gallery
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this video gallery.
	 *
	 * @param statusByUserUuid the status by user uuid of this video gallery
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this video gallery.
	 *
	 * @param statusDate the status date of this video gallery
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the title of this video gallery.
	 *
	 * @param title the title of this video gallery
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the localized title of this video gallery in the language.
	 *
	 * @param title the localized title of this video gallery
	 * @param locale the locale of the language
	 */
	@Override
	public void setTitle(String title, java.util.Locale locale) {
		model.setTitle(title, locale);
	}

	/**
	 * Sets the localized title of this video gallery in the language, and sets the default locale.
	 *
	 * @param title the localized title of this video gallery
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
	 * Sets the localized titles of this video gallery from the map of locales and localized titles.
	 *
	 * @param titleMap the locales and localized titles of this video gallery
	 */
	@Override
	public void setTitleMap(Map<java.util.Locale, String> titleMap) {
		model.setTitleMap(titleMap);
	}

	/**
	 * Sets the localized titles of this video gallery from the map of locales and localized titles, and sets the default locale.
	 *
	 * @param titleMap the locales and localized titles of this video gallery
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setTitleMap(
		Map<java.util.Locale, String> titleMap,
		java.util.Locale defaultLocale) {

		model.setTitleMap(titleMap, defaultLocale);
	}

	/**
	 * Sets the user ID of this video gallery.
	 *
	 * @param userId the user ID of this video gallery
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this video gallery.
	 *
	 * @param userName the user name of this video gallery
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this video gallery.
	 *
	 * @param userUuid the user uuid of this video gallery
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this video gallery.
	 *
	 * @param uuid the uuid of this video gallery
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
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
	protected VideoGalleryWrapper wrap(VideoGallery videoGallery) {
		return new VideoGalleryWrapper(videoGallery);
	}

}