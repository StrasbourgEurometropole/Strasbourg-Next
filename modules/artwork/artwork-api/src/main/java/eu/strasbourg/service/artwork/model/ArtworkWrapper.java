/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.artwork.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Artwork}.
 * </p>
 *
 * @author BenjaminBini
 * @see Artwork
 * @generated
 */
public class ArtworkWrapper
	extends BaseModelWrapper<Artwork>
	implements Artwork, ModelWrapper<Artwork> {

	public ArtworkWrapper(Artwork artwork) {
		super(artwork);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("artworkId", getArtworkId());
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
		attributes.put("technicalInformation", getTechnicalInformation());
		attributes.put("noticeLink", getNoticeLink());
		attributes.put("artistName", getArtistName());
		attributes.put("creationYear", getCreationYear());
		attributes.put("origin", getOrigin());
		attributes.put("exhibitionName", getExhibitionName());
		attributes.put("exhibitionPlace", getExhibitionPlace());
		attributes.put("loanPeriod", getLoanPeriod());
		attributes.put("linkName", getLinkName());
		attributes.put("link", getLink());
		attributes.put("imageId", getImageId());
		attributes.put("imagesIds", getImagesIds());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long artworkId = (Long)attributes.get("artworkId");

		if (artworkId != null) {
			setArtworkId(artworkId);
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

		String technicalInformation = (String)attributes.get(
			"technicalInformation");

		if (technicalInformation != null) {
			setTechnicalInformation(technicalInformation);
		}

		String noticeLink = (String)attributes.get("noticeLink");

		if (noticeLink != null) {
			setNoticeLink(noticeLink);
		}

		String artistName = (String)attributes.get("artistName");

		if (artistName != null) {
			setArtistName(artistName);
		}

		String creationYear = (String)attributes.get("creationYear");

		if (creationYear != null) {
			setCreationYear(creationYear);
		}

		String origin = (String)attributes.get("origin");

		if (origin != null) {
			setOrigin(origin);
		}

		String exhibitionName = (String)attributes.get("exhibitionName");

		if (exhibitionName != null) {
			setExhibitionName(exhibitionName);
		}

		String exhibitionPlace = (String)attributes.get("exhibitionPlace");

		if (exhibitionPlace != null) {
			setExhibitionPlace(exhibitionPlace);
		}

		String loanPeriod = (String)attributes.get("loanPeriod");

		if (loanPeriod != null) {
			setLoanPeriod(loanPeriod);
		}

		String linkName = (String)attributes.get("linkName");

		if (linkName != null) {
			setLinkName(linkName);
		}

		String link = (String)attributes.get("link");

		if (link != null) {
			setLink(link);
		}

		Long imageId = (Long)attributes.get("imageId");

		if (imageId != null) {
			setImageId(imageId);
		}

		String imagesIds = (String)attributes.get("imagesIds");

		if (imagesIds != null) {
			setImagesIds(imagesIds);
		}
	}

	@Override
	public Artwork cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the artist name of this artwork.
	 *
	 * @return the artist name of this artwork
	 */
	@Override
	public String getArtistName() {
		return model.getArtistName();
	}

	/**
	 * Returns the localized artist name of this artwork in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized artist name of this artwork
	 */
	@Override
	public String getArtistName(java.util.Locale locale) {
		return model.getArtistName(locale);
	}

	/**
	 * Returns the localized artist name of this artwork in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized artist name of this artwork. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getArtistName(java.util.Locale locale, boolean useDefault) {
		return model.getArtistName(locale, useDefault);
	}

	/**
	 * Returns the localized artist name of this artwork in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized artist name of this artwork
	 */
	@Override
	public String getArtistName(String languageId) {
		return model.getArtistName(languageId);
	}

	/**
	 * Returns the localized artist name of this artwork in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized artist name of this artwork
	 */
	@Override
	public String getArtistName(String languageId, boolean useDefault) {
		return model.getArtistName(languageId, useDefault);
	}

	@Override
	public String getArtistNameCurrentLanguageId() {
		return model.getArtistNameCurrentLanguageId();
	}

	@Override
	public String getArtistNameCurrentValue() {
		return model.getArtistNameCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized artist names of this artwork.
	 *
	 * @return the locales and localized artist names of this artwork
	 */
	@Override
	public Map<java.util.Locale, String> getArtistNameMap() {
		return model.getArtistNameMap();
	}

	/**
	 * Retourne la liste des collections d'oeuvres
	 */
	@Override
	public java.util.List<eu.strasbourg.service.artwork.model.ArtworkCollection>
		getArtworkCollections() {

		return model.getArtworkCollections();
	}

	/**
	 * Retourne la liste des ids de collections d'oeuvres sous forme de String
	 */
	@Override
	public String getArtworkCollectionsIds() {
		return model.getArtworkCollectionsIds();
	}

	/**
	 * Returns the artwork ID of this artwork.
	 *
	 * @return the artwork ID of this artwork
	 */
	@Override
	public long getArtworkId() {
		return model.getArtworkId();
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
	 * Returns the company ID of this artwork.
	 *
	 * @return the company ID of this artwork
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this artwork.
	 *
	 * @return the create date of this artwork
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the creation year of this artwork.
	 *
	 * @return the creation year of this artwork
	 */
	@Override
	public String getCreationYear() {
		return model.getCreationYear();
	}

	/**
	 * Returns the localized creation year of this artwork in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized creation year of this artwork
	 */
	@Override
	public String getCreationYear(java.util.Locale locale) {
		return model.getCreationYear(locale);
	}

	/**
	 * Returns the localized creation year of this artwork in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized creation year of this artwork. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getCreationYear(java.util.Locale locale, boolean useDefault) {
		return model.getCreationYear(locale, useDefault);
	}

	/**
	 * Returns the localized creation year of this artwork in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized creation year of this artwork
	 */
	@Override
	public String getCreationYear(String languageId) {
		return model.getCreationYear(languageId);
	}

	/**
	 * Returns the localized creation year of this artwork in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized creation year of this artwork
	 */
	@Override
	public String getCreationYear(String languageId, boolean useDefault) {
		return model.getCreationYear(languageId, useDefault);
	}

	@Override
	public String getCreationYearCurrentLanguageId() {
		return model.getCreationYearCurrentLanguageId();
	}

	@Override
	public String getCreationYearCurrentValue() {
		return model.getCreationYearCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized creation years of this artwork.
	 *
	 * @return the locales and localized creation years of this artwork
	 */
	@Override
	public Map<java.util.Locale, String> getCreationYearMap() {
		return model.getCreationYearMap();
	}

	@Override
	public String getDefaultLanguageId() {
		return model.getDefaultLanguageId();
	}

	/**
	 * Returns the description of this artwork.
	 *
	 * @return the description of this artwork
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the localized description of this artwork in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description of this artwork
	 */
	@Override
	public String getDescription(java.util.Locale locale) {
		return model.getDescription(locale);
	}

	/**
	 * Returns the localized description of this artwork in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this artwork. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getDescription(java.util.Locale locale, boolean useDefault) {
		return model.getDescription(locale, useDefault);
	}

	/**
	 * Returns the localized description of this artwork in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description of this artwork
	 */
	@Override
	public String getDescription(String languageId) {
		return model.getDescription(languageId);
	}

	/**
	 * Returns the localized description of this artwork in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this artwork
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
	 * Returns a map of the locales and localized descriptions of this artwork.
	 *
	 * @return the locales and localized descriptions of this artwork
	 */
	@Override
	public Map<java.util.Locale, String> getDescriptionMap() {
		return model.getDescriptionMap();
	}

	/**
	 * Returns the exhibition name of this artwork.
	 *
	 * @return the exhibition name of this artwork
	 */
	@Override
	public String getExhibitionName() {
		return model.getExhibitionName();
	}

	/**
	 * Returns the localized exhibition name of this artwork in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized exhibition name of this artwork
	 */
	@Override
	public String getExhibitionName(java.util.Locale locale) {
		return model.getExhibitionName(locale);
	}

	/**
	 * Returns the localized exhibition name of this artwork in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized exhibition name of this artwork. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getExhibitionName(
		java.util.Locale locale, boolean useDefault) {

		return model.getExhibitionName(locale, useDefault);
	}

	/**
	 * Returns the localized exhibition name of this artwork in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized exhibition name of this artwork
	 */
	@Override
	public String getExhibitionName(String languageId) {
		return model.getExhibitionName(languageId);
	}

	/**
	 * Returns the localized exhibition name of this artwork in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized exhibition name of this artwork
	 */
	@Override
	public String getExhibitionName(String languageId, boolean useDefault) {
		return model.getExhibitionName(languageId, useDefault);
	}

	@Override
	public String getExhibitionNameCurrentLanguageId() {
		return model.getExhibitionNameCurrentLanguageId();
	}

	@Override
	public String getExhibitionNameCurrentValue() {
		return model.getExhibitionNameCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized exhibition names of this artwork.
	 *
	 * @return the locales and localized exhibition names of this artwork
	 */
	@Override
	public Map<java.util.Locale, String> getExhibitionNameMap() {
		return model.getExhibitionNameMap();
	}

	/**
	 * Returns the exhibition place of this artwork.
	 *
	 * @return the exhibition place of this artwork
	 */
	@Override
	public String getExhibitionPlace() {
		return model.getExhibitionPlace();
	}

	/**
	 * Returns the localized exhibition place of this artwork in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized exhibition place of this artwork
	 */
	@Override
	public String getExhibitionPlace(java.util.Locale locale) {
		return model.getExhibitionPlace(locale);
	}

	/**
	 * Returns the localized exhibition place of this artwork in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized exhibition place of this artwork. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getExhibitionPlace(
		java.util.Locale locale, boolean useDefault) {

		return model.getExhibitionPlace(locale, useDefault);
	}

	/**
	 * Returns the localized exhibition place of this artwork in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized exhibition place of this artwork
	 */
	@Override
	public String getExhibitionPlace(String languageId) {
		return model.getExhibitionPlace(languageId);
	}

	/**
	 * Returns the localized exhibition place of this artwork in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized exhibition place of this artwork
	 */
	@Override
	public String getExhibitionPlace(String languageId, boolean useDefault) {
		return model.getExhibitionPlace(languageId, useDefault);
	}

	@Override
	public String getExhibitionPlaceCurrentLanguageId() {
		return model.getExhibitionPlaceCurrentLanguageId();
	}

	@Override
	public String getExhibitionPlaceCurrentValue() {
		return model.getExhibitionPlaceCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized exhibition places of this artwork.
	 *
	 * @return the locales and localized exhibition places of this artwork
	 */
	@Override
	public Map<java.util.Locale, String> getExhibitionPlaceMap() {
		return model.getExhibitionPlaceMap();
	}

	/**
	 * Returns the group ID of this artwork.
	 *
	 * @return the group ID of this artwork
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
	 * Returns the image ID of this artwork.
	 *
	 * @return the image ID of this artwork
	 */
	@Override
	public Long getImageId() {
		return model.getImageId();
	}

	/**
	 * Retourne la légende de l'image principale
	 */
	@Override
	public String getImageLegend(java.util.Locale locale) {
		return model.getImageLegend(locale);
	}

	/**
	 * Retourne la légende de l'image principale suivie de son copyright
	 */
	@Override
	public String getImageLegendAndCopyright(java.util.Locale locale) {
		return model.getImageLegendAndCopyright(locale);
	}

	/**
	 * Returns the images IDs of this artwork.
	 *
	 * @return the images IDs of this artwork
	 */
	@Override
	public String getImagesIds() {
		return model.getImagesIds();
	}

	/**
	 * Retourne la liste des URL publiques des images additionnelles
	 */
	@Override
	public java.util.List<String> getImagesLegendsAndCopyrights(
		java.util.Locale locale) {

		return model.getImagesLegendsAndCopyrights(locale);
	}

	/**
	 * Retourne la liste des URL publiques des images additionnelles
	 */
	@Override
	public java.util.List<String> getImagesURLs() {
		return model.getImagesURLs();
	}

	/**
	 * Retourne l'URL de l'image à partir de l'id du DLFileEntry
	 */
	@Override
	public String getImageURL() {
		return model.getImageURL();
	}

	/**
	 * Returns the last publish date of this artwork.
	 *
	 * @return the last publish date of this artwork
	 */
	@Override
	public Date getLastPublishDate() {
		return model.getLastPublishDate();
	}

	/**
	 * Returns the link of this artwork.
	 *
	 * @return the link of this artwork
	 */
	@Override
	public String getLink() {
		return model.getLink();
	}

	/**
	 * Returns the localized link of this artwork in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized link of this artwork
	 */
	@Override
	public String getLink(java.util.Locale locale) {
		return model.getLink(locale);
	}

	/**
	 * Returns the localized link of this artwork in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized link of this artwork. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getLink(java.util.Locale locale, boolean useDefault) {
		return model.getLink(locale, useDefault);
	}

	/**
	 * Returns the localized link of this artwork in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized link of this artwork
	 */
	@Override
	public String getLink(String languageId) {
		return model.getLink(languageId);
	}

	/**
	 * Returns the localized link of this artwork in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized link of this artwork
	 */
	@Override
	public String getLink(String languageId, boolean useDefault) {
		return model.getLink(languageId, useDefault);
	}

	@Override
	public String getLinkCurrentLanguageId() {
		return model.getLinkCurrentLanguageId();
	}

	@Override
	public String getLinkCurrentValue() {
		return model.getLinkCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized links of this artwork.
	 *
	 * @return the locales and localized links of this artwork
	 */
	@Override
	public Map<java.util.Locale, String> getLinkMap() {
		return model.getLinkMap();
	}

	/**
	 * Returns the link name of this artwork.
	 *
	 * @return the link name of this artwork
	 */
	@Override
	public String getLinkName() {
		return model.getLinkName();
	}

	/**
	 * Returns the localized link name of this artwork in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized link name of this artwork
	 */
	@Override
	public String getLinkName(java.util.Locale locale) {
		return model.getLinkName(locale);
	}

	/**
	 * Returns the localized link name of this artwork in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized link name of this artwork. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getLinkName(java.util.Locale locale, boolean useDefault) {
		return model.getLinkName(locale, useDefault);
	}

	/**
	 * Returns the localized link name of this artwork in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized link name of this artwork
	 */
	@Override
	public String getLinkName(String languageId) {
		return model.getLinkName(languageId);
	}

	/**
	 * Returns the localized link name of this artwork in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized link name of this artwork
	 */
	@Override
	public String getLinkName(String languageId, boolean useDefault) {
		return model.getLinkName(languageId, useDefault);
	}

	@Override
	public String getLinkNameCurrentLanguageId() {
		return model.getLinkNameCurrentLanguageId();
	}

	@Override
	public String getLinkNameCurrentValue() {
		return model.getLinkNameCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized link names of this artwork.
	 *
	 * @return the locales and localized link names of this artwork
	 */
	@Override
	public Map<java.util.Locale, String> getLinkNameMap() {
		return model.getLinkNameMap();
	}

	/**
	 * Retourne la version live de l'oeuvre, si elle existe
	 */
	@Override
	public eu.strasbourg.service.artwork.model.Artwork getLiveVersion() {
		return model.getLiveVersion();
	}

	/**
	 * Returns the loan period of this artwork.
	 *
	 * @return the loan period of this artwork
	 */
	@Override
	public String getLoanPeriod() {
		return model.getLoanPeriod();
	}

	/**
	 * Returns the localized loan period of this artwork in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized loan period of this artwork
	 */
	@Override
	public String getLoanPeriod(java.util.Locale locale) {
		return model.getLoanPeriod(locale);
	}

	/**
	 * Returns the localized loan period of this artwork in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized loan period of this artwork. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getLoanPeriod(java.util.Locale locale, boolean useDefault) {
		return model.getLoanPeriod(locale, useDefault);
	}

	/**
	 * Returns the localized loan period of this artwork in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized loan period of this artwork
	 */
	@Override
	public String getLoanPeriod(String languageId) {
		return model.getLoanPeriod(languageId);
	}

	/**
	 * Returns the localized loan period of this artwork in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized loan period of this artwork
	 */
	@Override
	public String getLoanPeriod(String languageId, boolean useDefault) {
		return model.getLoanPeriod(languageId, useDefault);
	}

	@Override
	public String getLoanPeriodCurrentLanguageId() {
		return model.getLoanPeriodCurrentLanguageId();
	}

	@Override
	public String getLoanPeriodCurrentValue() {
		return model.getLoanPeriodCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized loan periods of this artwork.
	 *
	 * @return the locales and localized loan periods of this artwork
	 */
	@Override
	public Map<java.util.Locale, String> getLoanPeriodMap() {
		return model.getLoanPeriodMap();
	}

	/**
	 * Returns the modified date of this artwork.
	 *
	 * @return the modified date of this artwork
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the notice link of this artwork.
	 *
	 * @return the notice link of this artwork
	 */
	@Override
	public String getNoticeLink() {
		return model.getNoticeLink();
	}

	/**
	 * Returns the localized notice link of this artwork in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized notice link of this artwork
	 */
	@Override
	public String getNoticeLink(java.util.Locale locale) {
		return model.getNoticeLink(locale);
	}

	/**
	 * Returns the localized notice link of this artwork in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized notice link of this artwork. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getNoticeLink(java.util.Locale locale, boolean useDefault) {
		return model.getNoticeLink(locale, useDefault);
	}

	/**
	 * Returns the localized notice link of this artwork in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized notice link of this artwork
	 */
	@Override
	public String getNoticeLink(String languageId) {
		return model.getNoticeLink(languageId);
	}

	/**
	 * Returns the localized notice link of this artwork in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized notice link of this artwork
	 */
	@Override
	public String getNoticeLink(String languageId, boolean useDefault) {
		return model.getNoticeLink(languageId, useDefault);
	}

	@Override
	public String getNoticeLinkCurrentLanguageId() {
		return model.getNoticeLinkCurrentLanguageId();
	}

	@Override
	public String getNoticeLinkCurrentValue() {
		return model.getNoticeLinkCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized notice links of this artwork.
	 *
	 * @return the locales and localized notice links of this artwork
	 */
	@Override
	public Map<java.util.Locale, String> getNoticeLinkMap() {
		return model.getNoticeLinkMap();
	}

	/**
	 * Returns the origin of this artwork.
	 *
	 * @return the origin of this artwork
	 */
	@Override
	public String getOrigin() {
		return model.getOrigin();
	}

	/**
	 * Returns the localized origin of this artwork in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized origin of this artwork
	 */
	@Override
	public String getOrigin(java.util.Locale locale) {
		return model.getOrigin(locale);
	}

	/**
	 * Returns the localized origin of this artwork in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized origin of this artwork. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getOrigin(java.util.Locale locale, boolean useDefault) {
		return model.getOrigin(locale, useDefault);
	}

	/**
	 * Returns the localized origin of this artwork in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized origin of this artwork
	 */
	@Override
	public String getOrigin(String languageId) {
		return model.getOrigin(languageId);
	}

	/**
	 * Returns the localized origin of this artwork in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized origin of this artwork
	 */
	@Override
	public String getOrigin(String languageId, boolean useDefault) {
		return model.getOrigin(languageId, useDefault);
	}

	@Override
	public String getOriginCurrentLanguageId() {
		return model.getOriginCurrentLanguageId();
	}

	@Override
	public String getOriginCurrentValue() {
		return model.getOriginCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized origins of this artwork.
	 *
	 * @return the locales and localized origins of this artwork
	 */
	@Override
	public Map<java.util.Locale, String> getOriginMap() {
		return model.getOriginMap();
	}

	/**
	 * Returns the primary key of this artwork.
	 *
	 * @return the primary key of this artwork
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Retourne la liste des collections d'oeuvres publiées
	 */
	@Override
	public java.util.List<eu.strasbourg.service.artwork.model.ArtworkCollection>
		getPublishedArtworkCollections() {

		return model.getPublishedArtworkCollections();
	}

	/**
	 * Retourne la classe css correspondante à la source
	 */
	@Override
	public String getSourceCSSClass() {
		return model.getSourceCSSClass();
	}

	/**
	 * Retourne les sources de l'oeuvre
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getSources() {

		return model.getSources();
	}

	/**
	 * Returns the status of this artwork.
	 *
	 * @return the status of this artwork
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this artwork.
	 *
	 * @return the status by user ID of this artwork
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this artwork.
	 *
	 * @return the status by user name of this artwork
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this artwork.
	 *
	 * @return the status by user uuid of this artwork
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this artwork.
	 *
	 * @return the status date of this artwork
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the technical information of this artwork.
	 *
	 * @return the technical information of this artwork
	 */
	@Override
	public String getTechnicalInformation() {
		return model.getTechnicalInformation();
	}

	/**
	 * Returns the localized technical information of this artwork in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized technical information of this artwork
	 */
	@Override
	public String getTechnicalInformation(java.util.Locale locale) {
		return model.getTechnicalInformation(locale);
	}

	/**
	 * Returns the localized technical information of this artwork in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized technical information of this artwork. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getTechnicalInformation(
		java.util.Locale locale, boolean useDefault) {

		return model.getTechnicalInformation(locale, useDefault);
	}

	/**
	 * Returns the localized technical information of this artwork in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized technical information of this artwork
	 */
	@Override
	public String getTechnicalInformation(String languageId) {
		return model.getTechnicalInformation(languageId);
	}

	/**
	 * Returns the localized technical information of this artwork in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized technical information of this artwork
	 */
	@Override
	public String getTechnicalInformation(
		String languageId, boolean useDefault) {

		return model.getTechnicalInformation(languageId, useDefault);
	}

	@Override
	public String getTechnicalInformationCurrentLanguageId() {
		return model.getTechnicalInformationCurrentLanguageId();
	}

	@Override
	public String getTechnicalInformationCurrentValue() {
		return model.getTechnicalInformationCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized technical informations of this artwork.
	 *
	 * @return the locales and localized technical informations of this artwork
	 */
	@Override
	public Map<java.util.Locale, String> getTechnicalInformationMap() {
		return model.getTechnicalInformationMap();
	}

	/**
	 * Returns the title of this artwork.
	 *
	 * @return the title of this artwork
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the localized title of this artwork in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized title of this artwork
	 */
	@Override
	public String getTitle(java.util.Locale locale) {
		return model.getTitle(locale);
	}

	/**
	 * Returns the localized title of this artwork in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this artwork. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getTitle(java.util.Locale locale, boolean useDefault) {
		return model.getTitle(locale, useDefault);
	}

	/**
	 * Returns the localized title of this artwork in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized title of this artwork
	 */
	@Override
	public String getTitle(String languageId) {
		return model.getTitle(languageId);
	}

	/**
	 * Returns the localized title of this artwork in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this artwork
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
	 * Returns a map of the locales and localized titles of this artwork.
	 *
	 * @return the locales and localized titles of this artwork
	 */
	@Override
	public Map<java.util.Locale, String> getTitleMap() {
		return model.getTitleMap();
	}

	/**
	 * Returns the user ID of this artwork.
	 *
	 * @return the user ID of this artwork
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this artwork.
	 *
	 * @return the user name of this artwork
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this artwork.
	 *
	 * @return the user uuid of this artwork
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this artwork.
	 *
	 * @return the uuid of this artwork
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this artwork is approved.
	 *
	 * @return <code>true</code> if this artwork is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this artwork is denied.
	 *
	 * @return <code>true</code> if this artwork is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this artwork is a draft.
	 *
	 * @return <code>true</code> if this artwork is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this artwork is expired.
	 *
	 * @return <code>true</code> if this artwork is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this artwork is inactive.
	 *
	 * @return <code>true</code> if this artwork is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this artwork is incomplete.
	 *
	 * @return <code>true</code> if this artwork is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this artwork is pending.
	 *
	 * @return <code>true</code> if this artwork is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this artwork is scheduled.
	 *
	 * @return <code>true</code> if this artwork is scheduled; <code>false</code> otherwise
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
	 * Sets the artist name of this artwork.
	 *
	 * @param artistName the artist name of this artwork
	 */
	@Override
	public void setArtistName(String artistName) {
		model.setArtistName(artistName);
	}

	/**
	 * Sets the localized artist name of this artwork in the language.
	 *
	 * @param artistName the localized artist name of this artwork
	 * @param locale the locale of the language
	 */
	@Override
	public void setArtistName(String artistName, java.util.Locale locale) {
		model.setArtistName(artistName, locale);
	}

	/**
	 * Sets the localized artist name of this artwork in the language, and sets the default locale.
	 *
	 * @param artistName the localized artist name of this artwork
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setArtistName(
		String artistName, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setArtistName(artistName, locale, defaultLocale);
	}

	@Override
	public void setArtistNameCurrentLanguageId(String languageId) {
		model.setArtistNameCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized artist names of this artwork from the map of locales and localized artist names.
	 *
	 * @param artistNameMap the locales and localized artist names of this artwork
	 */
	@Override
	public void setArtistNameMap(Map<java.util.Locale, String> artistNameMap) {
		model.setArtistNameMap(artistNameMap);
	}

	/**
	 * Sets the localized artist names of this artwork from the map of locales and localized artist names, and sets the default locale.
	 *
	 * @param artistNameMap the locales and localized artist names of this artwork
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setArtistNameMap(
		Map<java.util.Locale, String> artistNameMap,
		java.util.Locale defaultLocale) {

		model.setArtistNameMap(artistNameMap, defaultLocale);
	}

	/**
	 * Sets the artwork ID of this artwork.
	 *
	 * @param artworkId the artwork ID of this artwork
	 */
	@Override
	public void setArtworkId(long artworkId) {
		model.setArtworkId(artworkId);
	}

	/**
	 * Sets the company ID of this artwork.
	 *
	 * @param companyId the company ID of this artwork
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this artwork.
	 *
	 * @param createDate the create date of this artwork
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the creation year of this artwork.
	 *
	 * @param creationYear the creation year of this artwork
	 */
	@Override
	public void setCreationYear(String creationYear) {
		model.setCreationYear(creationYear);
	}

	/**
	 * Sets the localized creation year of this artwork in the language.
	 *
	 * @param creationYear the localized creation year of this artwork
	 * @param locale the locale of the language
	 */
	@Override
	public void setCreationYear(String creationYear, java.util.Locale locale) {
		model.setCreationYear(creationYear, locale);
	}

	/**
	 * Sets the localized creation year of this artwork in the language, and sets the default locale.
	 *
	 * @param creationYear the localized creation year of this artwork
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setCreationYear(
		String creationYear, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setCreationYear(creationYear, locale, defaultLocale);
	}

	@Override
	public void setCreationYearCurrentLanguageId(String languageId) {
		model.setCreationYearCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized creation years of this artwork from the map of locales and localized creation years.
	 *
	 * @param creationYearMap the locales and localized creation years of this artwork
	 */
	@Override
	public void setCreationYearMap(
		Map<java.util.Locale, String> creationYearMap) {

		model.setCreationYearMap(creationYearMap);
	}

	/**
	 * Sets the localized creation years of this artwork from the map of locales and localized creation years, and sets the default locale.
	 *
	 * @param creationYearMap the locales and localized creation years of this artwork
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setCreationYearMap(
		Map<java.util.Locale, String> creationYearMap,
		java.util.Locale defaultLocale) {

		model.setCreationYearMap(creationYearMap, defaultLocale);
	}

	/**
	 * Sets the description of this artwork.
	 *
	 * @param description the description of this artwork
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the localized description of this artwork in the language.
	 *
	 * @param description the localized description of this artwork
	 * @param locale the locale of the language
	 */
	@Override
	public void setDescription(String description, java.util.Locale locale) {
		model.setDescription(description, locale);
	}

	/**
	 * Sets the localized description of this artwork in the language, and sets the default locale.
	 *
	 * @param description the localized description of this artwork
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
	 * Sets the localized descriptions of this artwork from the map of locales and localized descriptions.
	 *
	 * @param descriptionMap the locales and localized descriptions of this artwork
	 */
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, String> descriptionMap) {

		model.setDescriptionMap(descriptionMap);
	}

	/**
	 * Sets the localized descriptions of this artwork from the map of locales and localized descriptions, and sets the default locale.
	 *
	 * @param descriptionMap the locales and localized descriptions of this artwork
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, String> descriptionMap,
		java.util.Locale defaultLocale) {

		model.setDescriptionMap(descriptionMap, defaultLocale);
	}

	/**
	 * Sets the exhibition name of this artwork.
	 *
	 * @param exhibitionName the exhibition name of this artwork
	 */
	@Override
	public void setExhibitionName(String exhibitionName) {
		model.setExhibitionName(exhibitionName);
	}

	/**
	 * Sets the localized exhibition name of this artwork in the language.
	 *
	 * @param exhibitionName the localized exhibition name of this artwork
	 * @param locale the locale of the language
	 */
	@Override
	public void setExhibitionName(
		String exhibitionName, java.util.Locale locale) {

		model.setExhibitionName(exhibitionName, locale);
	}

	/**
	 * Sets the localized exhibition name of this artwork in the language, and sets the default locale.
	 *
	 * @param exhibitionName the localized exhibition name of this artwork
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setExhibitionName(
		String exhibitionName, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setExhibitionName(exhibitionName, locale, defaultLocale);
	}

	@Override
	public void setExhibitionNameCurrentLanguageId(String languageId) {
		model.setExhibitionNameCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized exhibition names of this artwork from the map of locales and localized exhibition names.
	 *
	 * @param exhibitionNameMap the locales and localized exhibition names of this artwork
	 */
	@Override
	public void setExhibitionNameMap(
		Map<java.util.Locale, String> exhibitionNameMap) {

		model.setExhibitionNameMap(exhibitionNameMap);
	}

	/**
	 * Sets the localized exhibition names of this artwork from the map of locales and localized exhibition names, and sets the default locale.
	 *
	 * @param exhibitionNameMap the locales and localized exhibition names of this artwork
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setExhibitionNameMap(
		Map<java.util.Locale, String> exhibitionNameMap,
		java.util.Locale defaultLocale) {

		model.setExhibitionNameMap(exhibitionNameMap, defaultLocale);
	}

	/**
	 * Sets the exhibition place of this artwork.
	 *
	 * @param exhibitionPlace the exhibition place of this artwork
	 */
	@Override
	public void setExhibitionPlace(String exhibitionPlace) {
		model.setExhibitionPlace(exhibitionPlace);
	}

	/**
	 * Sets the localized exhibition place of this artwork in the language.
	 *
	 * @param exhibitionPlace the localized exhibition place of this artwork
	 * @param locale the locale of the language
	 */
	@Override
	public void setExhibitionPlace(
		String exhibitionPlace, java.util.Locale locale) {

		model.setExhibitionPlace(exhibitionPlace, locale);
	}

	/**
	 * Sets the localized exhibition place of this artwork in the language, and sets the default locale.
	 *
	 * @param exhibitionPlace the localized exhibition place of this artwork
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setExhibitionPlace(
		String exhibitionPlace, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setExhibitionPlace(exhibitionPlace, locale, defaultLocale);
	}

	@Override
	public void setExhibitionPlaceCurrentLanguageId(String languageId) {
		model.setExhibitionPlaceCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized exhibition places of this artwork from the map of locales and localized exhibition places.
	 *
	 * @param exhibitionPlaceMap the locales and localized exhibition places of this artwork
	 */
	@Override
	public void setExhibitionPlaceMap(
		Map<java.util.Locale, String> exhibitionPlaceMap) {

		model.setExhibitionPlaceMap(exhibitionPlaceMap);
	}

	/**
	 * Sets the localized exhibition places of this artwork from the map of locales and localized exhibition places, and sets the default locale.
	 *
	 * @param exhibitionPlaceMap the locales and localized exhibition places of this artwork
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setExhibitionPlaceMap(
		Map<java.util.Locale, String> exhibitionPlaceMap,
		java.util.Locale defaultLocale) {

		model.setExhibitionPlaceMap(exhibitionPlaceMap, defaultLocale);
	}

	/**
	 * Sets the group ID of this artwork.
	 *
	 * @param groupId the group ID of this artwork
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the image ID of this artwork.
	 *
	 * @param imageId the image ID of this artwork
	 */
	@Override
	public void setImageId(Long imageId) {
		model.setImageId(imageId);
	}

	/**
	 * Sets the images IDs of this artwork.
	 *
	 * @param imagesIds the images IDs of this artwork
	 */
	@Override
	public void setImagesIds(String imagesIds) {
		model.setImagesIds(imagesIds);
	}

	/**
	 * Sets the last publish date of this artwork.
	 *
	 * @param lastPublishDate the last publish date of this artwork
	 */
	@Override
	public void setLastPublishDate(Date lastPublishDate) {
		model.setLastPublishDate(lastPublishDate);
	}

	/**
	 * Sets the link of this artwork.
	 *
	 * @param link the link of this artwork
	 */
	@Override
	public void setLink(String link) {
		model.setLink(link);
	}

	/**
	 * Sets the localized link of this artwork in the language.
	 *
	 * @param link the localized link of this artwork
	 * @param locale the locale of the language
	 */
	@Override
	public void setLink(String link, java.util.Locale locale) {
		model.setLink(link, locale);
	}

	/**
	 * Sets the localized link of this artwork in the language, and sets the default locale.
	 *
	 * @param link the localized link of this artwork
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setLink(
		String link, java.util.Locale locale, java.util.Locale defaultLocale) {

		model.setLink(link, locale, defaultLocale);
	}

	@Override
	public void setLinkCurrentLanguageId(String languageId) {
		model.setLinkCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized links of this artwork from the map of locales and localized links.
	 *
	 * @param linkMap the locales and localized links of this artwork
	 */
	@Override
	public void setLinkMap(Map<java.util.Locale, String> linkMap) {
		model.setLinkMap(linkMap);
	}

	/**
	 * Sets the localized links of this artwork from the map of locales and localized links, and sets the default locale.
	 *
	 * @param linkMap the locales and localized links of this artwork
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setLinkMap(
		Map<java.util.Locale, String> linkMap, java.util.Locale defaultLocale) {

		model.setLinkMap(linkMap, defaultLocale);
	}

	/**
	 * Sets the link name of this artwork.
	 *
	 * @param linkName the link name of this artwork
	 */
	@Override
	public void setLinkName(String linkName) {
		model.setLinkName(linkName);
	}

	/**
	 * Sets the localized link name of this artwork in the language.
	 *
	 * @param linkName the localized link name of this artwork
	 * @param locale the locale of the language
	 */
	@Override
	public void setLinkName(String linkName, java.util.Locale locale) {
		model.setLinkName(linkName, locale);
	}

	/**
	 * Sets the localized link name of this artwork in the language, and sets the default locale.
	 *
	 * @param linkName the localized link name of this artwork
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setLinkName(
		String linkName, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setLinkName(linkName, locale, defaultLocale);
	}

	@Override
	public void setLinkNameCurrentLanguageId(String languageId) {
		model.setLinkNameCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized link names of this artwork from the map of locales and localized link names.
	 *
	 * @param linkNameMap the locales and localized link names of this artwork
	 */
	@Override
	public void setLinkNameMap(Map<java.util.Locale, String> linkNameMap) {
		model.setLinkNameMap(linkNameMap);
	}

	/**
	 * Sets the localized link names of this artwork from the map of locales and localized link names, and sets the default locale.
	 *
	 * @param linkNameMap the locales and localized link names of this artwork
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setLinkNameMap(
		Map<java.util.Locale, String> linkNameMap,
		java.util.Locale defaultLocale) {

		model.setLinkNameMap(linkNameMap, defaultLocale);
	}

	/**
	 * Sets the loan period of this artwork.
	 *
	 * @param loanPeriod the loan period of this artwork
	 */
	@Override
	public void setLoanPeriod(String loanPeriod) {
		model.setLoanPeriod(loanPeriod);
	}

	/**
	 * Sets the localized loan period of this artwork in the language.
	 *
	 * @param loanPeriod the localized loan period of this artwork
	 * @param locale the locale of the language
	 */
	@Override
	public void setLoanPeriod(String loanPeriod, java.util.Locale locale) {
		model.setLoanPeriod(loanPeriod, locale);
	}

	/**
	 * Sets the localized loan period of this artwork in the language, and sets the default locale.
	 *
	 * @param loanPeriod the localized loan period of this artwork
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setLoanPeriod(
		String loanPeriod, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setLoanPeriod(loanPeriod, locale, defaultLocale);
	}

	@Override
	public void setLoanPeriodCurrentLanguageId(String languageId) {
		model.setLoanPeriodCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized loan periods of this artwork from the map of locales and localized loan periods.
	 *
	 * @param loanPeriodMap the locales and localized loan periods of this artwork
	 */
	@Override
	public void setLoanPeriodMap(Map<java.util.Locale, String> loanPeriodMap) {
		model.setLoanPeriodMap(loanPeriodMap);
	}

	/**
	 * Sets the localized loan periods of this artwork from the map of locales and localized loan periods, and sets the default locale.
	 *
	 * @param loanPeriodMap the locales and localized loan periods of this artwork
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setLoanPeriodMap(
		Map<java.util.Locale, String> loanPeriodMap,
		java.util.Locale defaultLocale) {

		model.setLoanPeriodMap(loanPeriodMap, defaultLocale);
	}

	/**
	 * Sets the modified date of this artwork.
	 *
	 * @param modifiedDate the modified date of this artwork
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the notice link of this artwork.
	 *
	 * @param noticeLink the notice link of this artwork
	 */
	@Override
	public void setNoticeLink(String noticeLink) {
		model.setNoticeLink(noticeLink);
	}

	/**
	 * Sets the localized notice link of this artwork in the language.
	 *
	 * @param noticeLink the localized notice link of this artwork
	 * @param locale the locale of the language
	 */
	@Override
	public void setNoticeLink(String noticeLink, java.util.Locale locale) {
		model.setNoticeLink(noticeLink, locale);
	}

	/**
	 * Sets the localized notice link of this artwork in the language, and sets the default locale.
	 *
	 * @param noticeLink the localized notice link of this artwork
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setNoticeLink(
		String noticeLink, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setNoticeLink(noticeLink, locale, defaultLocale);
	}

	@Override
	public void setNoticeLinkCurrentLanguageId(String languageId) {
		model.setNoticeLinkCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized notice links of this artwork from the map of locales and localized notice links.
	 *
	 * @param noticeLinkMap the locales and localized notice links of this artwork
	 */
	@Override
	public void setNoticeLinkMap(Map<java.util.Locale, String> noticeLinkMap) {
		model.setNoticeLinkMap(noticeLinkMap);
	}

	/**
	 * Sets the localized notice links of this artwork from the map of locales and localized notice links, and sets the default locale.
	 *
	 * @param noticeLinkMap the locales and localized notice links of this artwork
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setNoticeLinkMap(
		Map<java.util.Locale, String> noticeLinkMap,
		java.util.Locale defaultLocale) {

		model.setNoticeLinkMap(noticeLinkMap, defaultLocale);
	}

	/**
	 * Sets the origin of this artwork.
	 *
	 * @param origin the origin of this artwork
	 */
	@Override
	public void setOrigin(String origin) {
		model.setOrigin(origin);
	}

	/**
	 * Sets the localized origin of this artwork in the language.
	 *
	 * @param origin the localized origin of this artwork
	 * @param locale the locale of the language
	 */
	@Override
	public void setOrigin(String origin, java.util.Locale locale) {
		model.setOrigin(origin, locale);
	}

	/**
	 * Sets the localized origin of this artwork in the language, and sets the default locale.
	 *
	 * @param origin the localized origin of this artwork
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setOrigin(
		String origin, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setOrigin(origin, locale, defaultLocale);
	}

	@Override
	public void setOriginCurrentLanguageId(String languageId) {
		model.setOriginCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized origins of this artwork from the map of locales and localized origins.
	 *
	 * @param originMap the locales and localized origins of this artwork
	 */
	@Override
	public void setOriginMap(Map<java.util.Locale, String> originMap) {
		model.setOriginMap(originMap);
	}

	/**
	 * Sets the localized origins of this artwork from the map of locales and localized origins, and sets the default locale.
	 *
	 * @param originMap the locales and localized origins of this artwork
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setOriginMap(
		Map<java.util.Locale, String> originMap,
		java.util.Locale defaultLocale) {

		model.setOriginMap(originMap, defaultLocale);
	}

	/**
	 * Sets the primary key of this artwork.
	 *
	 * @param primaryKey the primary key of this artwork
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this artwork.
	 *
	 * @param status the status of this artwork
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this artwork.
	 *
	 * @param statusByUserId the status by user ID of this artwork
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this artwork.
	 *
	 * @param statusByUserName the status by user name of this artwork
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this artwork.
	 *
	 * @param statusByUserUuid the status by user uuid of this artwork
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this artwork.
	 *
	 * @param statusDate the status date of this artwork
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the technical information of this artwork.
	 *
	 * @param technicalInformation the technical information of this artwork
	 */
	@Override
	public void setTechnicalInformation(String technicalInformation) {
		model.setTechnicalInformation(technicalInformation);
	}

	/**
	 * Sets the localized technical information of this artwork in the language.
	 *
	 * @param technicalInformation the localized technical information of this artwork
	 * @param locale the locale of the language
	 */
	@Override
	public void setTechnicalInformation(
		String technicalInformation, java.util.Locale locale) {

		model.setTechnicalInformation(technicalInformation, locale);
	}

	/**
	 * Sets the localized technical information of this artwork in the language, and sets the default locale.
	 *
	 * @param technicalInformation the localized technical information of this artwork
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setTechnicalInformation(
		String technicalInformation, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setTechnicalInformation(
			technicalInformation, locale, defaultLocale);
	}

	@Override
	public void setTechnicalInformationCurrentLanguageId(String languageId) {
		model.setTechnicalInformationCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized technical informations of this artwork from the map of locales and localized technical informations.
	 *
	 * @param technicalInformationMap the locales and localized technical informations of this artwork
	 */
	@Override
	public void setTechnicalInformationMap(
		Map<java.util.Locale, String> technicalInformationMap) {

		model.setTechnicalInformationMap(technicalInformationMap);
	}

	/**
	 * Sets the localized technical informations of this artwork from the map of locales and localized technical informations, and sets the default locale.
	 *
	 * @param technicalInformationMap the locales and localized technical informations of this artwork
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setTechnicalInformationMap(
		Map<java.util.Locale, String> technicalInformationMap,
		java.util.Locale defaultLocale) {

		model.setTechnicalInformationMap(
			technicalInformationMap, defaultLocale);
	}

	/**
	 * Sets the title of this artwork.
	 *
	 * @param title the title of this artwork
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the localized title of this artwork in the language.
	 *
	 * @param title the localized title of this artwork
	 * @param locale the locale of the language
	 */
	@Override
	public void setTitle(String title, java.util.Locale locale) {
		model.setTitle(title, locale);
	}

	/**
	 * Sets the localized title of this artwork in the language, and sets the default locale.
	 *
	 * @param title the localized title of this artwork
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
	 * Sets the localized titles of this artwork from the map of locales and localized titles.
	 *
	 * @param titleMap the locales and localized titles of this artwork
	 */
	@Override
	public void setTitleMap(Map<java.util.Locale, String> titleMap) {
		model.setTitleMap(titleMap);
	}

	/**
	 * Sets the localized titles of this artwork from the map of locales and localized titles, and sets the default locale.
	 *
	 * @param titleMap the locales and localized titles of this artwork
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setTitleMap(
		Map<java.util.Locale, String> titleMap,
		java.util.Locale defaultLocale) {

		model.setTitleMap(titleMap, defaultLocale);
	}

	/**
	 * Sets the user ID of this artwork.
	 *
	 * @param userId the user ID of this artwork
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this artwork.
	 *
	 * @param userName the user name of this artwork
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this artwork.
	 *
	 * @param userUuid the user uuid of this artwork
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this artwork.
	 *
	 * @param uuid the uuid of this artwork
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
	protected ArtworkWrapper wrap(Artwork artwork) {
		return new ArtworkWrapper(artwork);
	}

}