/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.edition.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Edition}.
 * </p>
 *
 * @author BenjaminBini
 * @see Edition
 * @generated
 */
public class EditionWrapper
	extends BaseModelWrapper<Edition>
	implements Edition, ModelWrapper<Edition> {

	public EditionWrapper(Edition edition) {
		super(edition);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("editionId", getEditionId());
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
		attributes.put("subtitle", getSubtitle());
		attributes.put("description", getDescription());
		attributes.put("URL", getURL());
		attributes.put("author", getAuthor());
		attributes.put("editor", getEditor());
		attributes.put("distribution", getDistribution());
		attributes.put("ISBN", getISBN());
		attributes.put("price", getPrice());
		attributes.put("availableForExchange", isAvailableForExchange());
		attributes.put("inStock", isInStock());
		attributes.put("diffusionDateYear", getDiffusionDateYear());
		attributes.put("diffusionDateMonth", getDiffusionDateMonth());
		attributes.put("pageNumber", getPageNumber());
		attributes.put("pictureNumber", getPictureNumber());
		attributes.put("publicationDate", getPublicationDate());
		attributes.put("imageId", getImageId());
		attributes.put("fileId", getFileId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long editionId = (Long)attributes.get("editionId");

		if (editionId != null) {
			setEditionId(editionId);
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

		String subtitle = (String)attributes.get("subtitle");

		if (subtitle != null) {
			setSubtitle(subtitle);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String URL = (String)attributes.get("URL");

		if (URL != null) {
			setURL(URL);
		}

		String author = (String)attributes.get("author");

		if (author != null) {
			setAuthor(author);
		}

		String editor = (String)attributes.get("editor");

		if (editor != null) {
			setEditor(editor);
		}

		String distribution = (String)attributes.get("distribution");

		if (distribution != null) {
			setDistribution(distribution);
		}

		String ISBN = (String)attributes.get("ISBN");

		if (ISBN != null) {
			setISBN(ISBN);
		}

		String price = (String)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}

		Boolean availableForExchange = (Boolean)attributes.get(
			"availableForExchange");

		if (availableForExchange != null) {
			setAvailableForExchange(availableForExchange);
		}

		Boolean inStock = (Boolean)attributes.get("inStock");

		if (inStock != null) {
			setInStock(inStock);
		}

		String diffusionDateYear = (String)attributes.get("diffusionDateYear");

		if (diffusionDateYear != null) {
			setDiffusionDateYear(diffusionDateYear);
		}

		String diffusionDateMonth = (String)attributes.get(
			"diffusionDateMonth");

		if (diffusionDateMonth != null) {
			setDiffusionDateMonth(diffusionDateMonth);
		}

		String pageNumber = (String)attributes.get("pageNumber");

		if (pageNumber != null) {
			setPageNumber(pageNumber);
		}

		String pictureNumber = (String)attributes.get("pictureNumber");

		if (pictureNumber != null) {
			setPictureNumber(pictureNumber);
		}

		Date publicationDate = (Date)attributes.get("publicationDate");

		if (publicationDate != null) {
			setPublicationDate(publicationDate);
		}

		Long imageId = (Long)attributes.get("imageId");

		if (imageId != null) {
			setImageId(imageId);
		}

		String fileId = (String)attributes.get("fileId");

		if (fileId != null) {
			setFileId(fileId);
		}
	}

	@Override
	public Edition cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Retourne l'AssetEntry rattaché cet item
	 */
	@Override
	public com.liferay.asset.kernel.model.AssetEntry getAssetEntry() {
		return model.getAssetEntry();
	}

	/**
	 * Returns the author of this edition.
	 *
	 * @return the author of this edition
	 */
	@Override
	public String getAuthor() {
		return model.getAuthor();
	}

	/**
	 * Returns the localized author of this edition in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized author of this edition
	 */
	@Override
	public String getAuthor(java.util.Locale locale) {
		return model.getAuthor(locale);
	}

	/**
	 * Returns the localized author of this edition in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized author of this edition. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getAuthor(java.util.Locale locale, boolean useDefault) {
		return model.getAuthor(locale, useDefault);
	}

	/**
	 * Returns the localized author of this edition in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized author of this edition
	 */
	@Override
	public String getAuthor(String languageId) {
		return model.getAuthor(languageId);
	}

	/**
	 * Returns the localized author of this edition in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized author of this edition
	 */
	@Override
	public String getAuthor(String languageId, boolean useDefault) {
		return model.getAuthor(languageId, useDefault);
	}

	@Override
	public String getAuthorCurrentLanguageId() {
		return model.getAuthorCurrentLanguageId();
	}

	@Override
	public String getAuthorCurrentValue() {
		return model.getAuthorCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized authors of this edition.
	 *
	 * @return the locales and localized authors of this edition
	 */
	@Override
	public Map<java.util.Locale, String> getAuthorMap() {
		return model.getAuthorMap();
	}

	/**
	 * Returns the available for exchange of this edition.
	 *
	 * @return the available for exchange of this edition
	 */
	@Override
	public boolean getAvailableForExchange() {
		return model.getAvailableForExchange();
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
	 * Returns the company ID of this edition.
	 *
	 * @return the company ID of this edition
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this edition.
	 *
	 * @return the create date of this edition
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
	 * Returns the description of this edition.
	 *
	 * @return the description of this edition
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the localized description of this edition in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description of this edition
	 */
	@Override
	public String getDescription(java.util.Locale locale) {
		return model.getDescription(locale);
	}

	/**
	 * Returns the localized description of this edition in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this edition. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getDescription(java.util.Locale locale, boolean useDefault) {
		return model.getDescription(locale, useDefault);
	}

	/**
	 * Returns the localized description of this edition in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description of this edition
	 */
	@Override
	public String getDescription(String languageId) {
		return model.getDescription(languageId);
	}

	/**
	 * Returns the localized description of this edition in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this edition
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
	 * Returns a map of the locales and localized descriptions of this edition.
	 *
	 * @return the locales and localized descriptions of this edition
	 */
	@Override
	public Map<java.util.Locale, String> getDescriptionMap() {
		return model.getDescriptionMap();
	}

	/**
	 * Returns the diffusion date month of this edition.
	 *
	 * @return the diffusion date month of this edition
	 */
	@Override
	public String getDiffusionDateMonth() {
		return model.getDiffusionDateMonth();
	}

	/**
	 * Returns the diffusion date year of this edition.
	 *
	 * @return the diffusion date year of this edition
	 */
	@Override
	public String getDiffusionDateYear() {
		return model.getDiffusionDateYear();
	}

	/**
	 * Returns the distribution of this edition.
	 *
	 * @return the distribution of this edition
	 */
	@Override
	public String getDistribution() {
		return model.getDistribution();
	}

	/**
	 * Renvoie la liste des galleries auxquelles cette édition appartient
	 */
	@Override
	public java.util.List<eu.strasbourg.service.edition.model.EditionGallery>
		getEditionGalleries() {

		return model.getEditionGalleries();
	}

	/**
	 * Renvoie la liste des IDs des galleries auxquelles cette édition
	 * appartient sous forme de String
	 */
	@Override
	public String getEditionGalleriesIds() {
		return model.getEditionGalleriesIds();
	}

	/**
	 * Returns the edition ID of this edition.
	 *
	 * @return the edition ID of this edition
	 */
	@Override
	public long getEditionId() {
		return model.getEditionId();
	}

	/**
	 * Returns the editor of this edition.
	 *
	 * @return the editor of this edition
	 */
	@Override
	public String getEditor() {
		return model.getEditor();
	}

	/**
	 * Returns the localized editor of this edition in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized editor of this edition
	 */
	@Override
	public String getEditor(java.util.Locale locale) {
		return model.getEditor(locale);
	}

	/**
	 * Returns the localized editor of this edition in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized editor of this edition. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getEditor(java.util.Locale locale, boolean useDefault) {
		return model.getEditor(locale, useDefault);
	}

	/**
	 * Returns the localized editor of this edition in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized editor of this edition
	 */
	@Override
	public String getEditor(String languageId) {
		return model.getEditor(languageId);
	}

	/**
	 * Returns the localized editor of this edition in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized editor of this edition
	 */
	@Override
	public String getEditor(String languageId, boolean useDefault) {
		return model.getEditor(languageId, useDefault);
	}

	@Override
	public String getEditorCurrentLanguageId() {
		return model.getEditorCurrentLanguageId();
	}

	@Override
	public String getEditorCurrentValue() {
		return model.getEditorCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized editors of this edition.
	 *
	 * @return the locales and localized editors of this edition
	 */
	@Override
	public Map<java.util.Locale, String> getEditorMap() {
		return model.getEditorMap();
	}

	/**
	 * Renvoie l'URL de téléchargement du fichier (que ce soit un FileEntry ou
	 * une URL externe)
	 */
	@Override
	public String getFileDownloadURL(java.util.Locale locale) {
		return model.getFileDownloadURL(locale);
	}

	/**
	 * Returns the file ID of this edition.
	 *
	 * @return the file ID of this edition
	 */
	@Override
	public String getFileId() {
		return model.getFileId();
	}

	/**
	 * Returns the localized file ID of this edition in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized file ID of this edition
	 */
	@Override
	public String getFileId(java.util.Locale locale) {
		return model.getFileId(locale);
	}

	/**
	 * Returns the localized file ID of this edition in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized file ID of this edition. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getFileId(java.util.Locale locale, boolean useDefault) {
		return model.getFileId(locale, useDefault);
	}

	/**
	 * Returns the localized file ID of this edition in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized file ID of this edition
	 */
	@Override
	public String getFileId(String languageId) {
		return model.getFileId(languageId);
	}

	/**
	 * Returns the localized file ID of this edition in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized file ID of this edition
	 */
	@Override
	public String getFileId(String languageId, boolean useDefault) {
		return model.getFileId(languageId, useDefault);
	}

	@Override
	public String getFileIdCurrentLanguageId() {
		return model.getFileIdCurrentLanguageId();
	}

	@Override
	public String getFileIdCurrentValue() {
		return model.getFileIdCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized file IDs of this edition.
	 *
	 * @return the locales and localized file IDs of this edition
	 */
	@Override
	public Map<java.util.Locale, String> getFileIdMap() {
		return model.getFileIdMap();
	}

	/**
	 * Renvoie la taille du fichier sous forme de String
	 */
	@Override
	public String getFileSize(java.util.Locale locale) {
		return model.getFileSize(locale);
	}

	/**
	 * Retourne le nom du fichier si un fichier uploadé est lié à l'édition, le titre de l'édition sinon
	 */
	@Override
	public String getFileTitle(java.util.Locale locale) {
		return model.getFileTitle(locale);
	}

	/**
	 * Renovie le type du fichier sous forme de String (si c'est une FileEntry -
	 * renvoie une chaîne vide si c'est une URL externe)
	 */
	@Override
	public String getFileType(java.util.Locale locale) {
		return model.getFileType(locale);
	}

	/**
	 * Returns the group ID of this edition.
	 *
	 * @return the group ID of this edition
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
	 * Returns the image ID of this edition.
	 *
	 * @return the image ID of this edition
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
	 * Returns the in stock of this edition.
	 *
	 * @return the in stock of this edition
	 */
	@Override
	public boolean getInStock() {
		return model.getInStock();
	}

	/**
	 * Returns the isbn of this edition.
	 *
	 * @return the isbn of this edition
	 */
	@Override
	public String getISBN() {
		return model.getISBN();
	}

	/**
	 * Returns the last publish date of this edition.
	 *
	 * @return the last publish date of this edition
	 */
	@Override
	public Date getLastPublishDate() {
		return model.getLastPublishDate();
	}

	/**
	 * Renvoie la version live de l'édition, si elle existe
	 */
	@Override
	public eu.strasbourg.service.edition.model.Edition getLiveVersion() {
		return model.getLiveVersion();
	}

	/**
	 * Returns the modified date of this edition.
	 *
	 * @return the modified date of this edition
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Retourne les musées de l'édition
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getMuseums() {

		return model.getMuseums();
	}

	/**
	 * Retourne le(s) label(s) du/des musées de l'édition
	 */
	@Override
	public String getMuseumsLabel(java.util.Locale locale) {
		return model.getMuseumsLabel(locale);
	}

	/**
	 * Returns the page number of this edition.
	 *
	 * @return the page number of this edition
	 */
	@Override
	public String getPageNumber() {
		return model.getPageNumber();
	}

	/**
	 * Returns the picture number of this edition.
	 *
	 * @return the picture number of this edition
	 */
	@Override
	public String getPictureNumber() {
		return model.getPictureNumber();
	}

	/**
	 * Returns the price of this edition.
	 *
	 * @return the price of this edition
	 */
	@Override
	public String getPrice() {
		return model.getPrice();
	}

	/**
	 * Returns the primary key of this edition.
	 *
	 * @return the primary key of this edition
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the publication date of this edition.
	 *
	 * @return the publication date of this edition
	 */
	@Override
	public Date getPublicationDate() {
		return model.getPublicationDate();
	}

	/**
	 * Renvoie la liste des galeries publiées
	 */
	@Override
	public java.util.List<eu.strasbourg.service.edition.model.EditionGallery>
		getPublishedEditionGalleries() {

		return model.getPublishedEditionGalleries();
	}

	/**
	 * Retourne les sources de l'édition
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getSources() {

		return model.getSources();
	}

	/**
	 * Returns the status of this edition.
	 *
	 * @return the status of this edition
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this edition.
	 *
	 * @return the status by user ID of this edition
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this edition.
	 *
	 * @return the status by user name of this edition
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this edition.
	 *
	 * @return the status by user uuid of this edition
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this edition.
	 *
	 * @return the status date of this edition
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the subtitle of this edition.
	 *
	 * @return the subtitle of this edition
	 */
	@Override
	public String getSubtitle() {
		return model.getSubtitle();
	}

	/**
	 * Returns the localized subtitle of this edition in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized subtitle of this edition
	 */
	@Override
	public String getSubtitle(java.util.Locale locale) {
		return model.getSubtitle(locale);
	}

	/**
	 * Returns the localized subtitle of this edition in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized subtitle of this edition. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getSubtitle(java.util.Locale locale, boolean useDefault) {
		return model.getSubtitle(locale, useDefault);
	}

	/**
	 * Returns the localized subtitle of this edition in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized subtitle of this edition
	 */
	@Override
	public String getSubtitle(String languageId) {
		return model.getSubtitle(languageId);
	}

	/**
	 * Returns the localized subtitle of this edition in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized subtitle of this edition
	 */
	@Override
	public String getSubtitle(String languageId, boolean useDefault) {
		return model.getSubtitle(languageId, useDefault);
	}

	@Override
	public String getSubtitleCurrentLanguageId() {
		return model.getSubtitleCurrentLanguageId();
	}

	@Override
	public String getSubtitleCurrentValue() {
		return model.getSubtitleCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized subtitles of this edition.
	 *
	 * @return the locales and localized subtitles of this edition
	 */
	@Override
	public Map<java.util.Locale, String> getSubtitleMap() {
		return model.getSubtitleMap();
	}

	/**
	 * Returns the title of this edition.
	 *
	 * @return the title of this edition
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the localized title of this edition in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized title of this edition
	 */
	@Override
	public String getTitle(java.util.Locale locale) {
		return model.getTitle(locale);
	}

	/**
	 * Returns the localized title of this edition in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this edition. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getTitle(java.util.Locale locale, boolean useDefault) {
		return model.getTitle(locale, useDefault);
	}

	/**
	 * Returns the localized title of this edition in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized title of this edition
	 */
	@Override
	public String getTitle(String languageId) {
		return model.getTitle(languageId);
	}

	/**
	 * Returns the localized title of this edition in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this edition
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
	 * Returns a map of the locales and localized titles of this edition.
	 *
	 * @return the locales and localized titles of this edition
	 */
	@Override
	public Map<java.util.Locale, String> getTitleMap() {
		return model.getTitleMap();
	}

	/**
	 * Retourne les types de l'édition
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getTypes() {

		return model.getTypes();
	}

	/**
	 * Retourne le texte à afficher pour les types de l'édition
	 */
	@Override
	public String getTypesLabels(java.util.Locale locale) {
		return model.getTypesLabels(locale);
	}

	/**
	 * Returns the url of this edition.
	 *
	 * @return the url of this edition
	 */
	@Override
	public String getURL() {
		return model.getURL();
	}

	/**
	 * Returns the localized url of this edition in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized url of this edition
	 */
	@Override
	public String getURL(java.util.Locale locale) {
		return model.getURL(locale);
	}

	/**
	 * Returns the localized url of this edition in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized url of this edition. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getURL(java.util.Locale locale, boolean useDefault) {
		return model.getURL(locale, useDefault);
	}

	/**
	 * Returns the localized url of this edition in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized url of this edition
	 */
	@Override
	public String getURL(String languageId) {
		return model.getURL(languageId);
	}

	/**
	 * Returns the localized url of this edition in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized url of this edition
	 */
	@Override
	public String getURL(String languageId, boolean useDefault) {
		return model.getURL(languageId, useDefault);
	}

	@Override
	public String getURLCurrentLanguageId() {
		return model.getURLCurrentLanguageId();
	}

	@Override
	public String getURLCurrentValue() {
		return model.getURLCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized urls of this edition.
	 *
	 * @return the locales and localized urls of this edition
	 */
	@Override
	public Map<java.util.Locale, String> getURLMap() {
		return model.getURLMap();
	}

	/**
	 * Returns the user ID of this edition.
	 *
	 * @return the user ID of this edition
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this edition.
	 *
	 * @return the user name of this edition
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this edition.
	 *
	 * @return the user uuid of this edition
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this edition.
	 *
	 * @return the uuid of this edition
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this edition is approved.
	 *
	 * @return <code>true</code> if this edition is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this edition is available for exchange.
	 *
	 * @return <code>true</code> if this edition is available for exchange; <code>false</code> otherwise
	 */
	@Override
	public boolean isAvailableForExchange() {
		return model.isAvailableForExchange();
	}

	/**
	 * Returns <code>true</code> if this edition is denied.
	 *
	 * @return <code>true</code> if this edition is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this edition is a draft.
	 *
	 * @return <code>true</code> if this edition is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this edition is expired.
	 *
	 * @return <code>true</code> if this edition is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this edition is inactive.
	 *
	 * @return <code>true</code> if this edition is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this edition is incomplete.
	 *
	 * @return <code>true</code> if this edition is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this edition is in stock.
	 *
	 * @return <code>true</code> if this edition is in stock; <code>false</code> otherwise
	 */
	@Override
	public boolean isInStock() {
		return model.isInStock();
	}

	/**
	 * Returns <code>true</code> if this edition is pending.
	 *
	 * @return <code>true</code> if this edition is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this edition is scheduled.
	 *
	 * @return <code>true</code> if this edition is scheduled; <code>false</code> otherwise
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
	 * Sets the author of this edition.
	 *
	 * @param author the author of this edition
	 */
	@Override
	public void setAuthor(String author) {
		model.setAuthor(author);
	}

	/**
	 * Sets the localized author of this edition in the language.
	 *
	 * @param author the localized author of this edition
	 * @param locale the locale of the language
	 */
	@Override
	public void setAuthor(String author, java.util.Locale locale) {
		model.setAuthor(author, locale);
	}

	/**
	 * Sets the localized author of this edition in the language, and sets the default locale.
	 *
	 * @param author the localized author of this edition
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setAuthor(
		String author, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setAuthor(author, locale, defaultLocale);
	}

	@Override
	public void setAuthorCurrentLanguageId(String languageId) {
		model.setAuthorCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized authors of this edition from the map of locales and localized authors.
	 *
	 * @param authorMap the locales and localized authors of this edition
	 */
	@Override
	public void setAuthorMap(Map<java.util.Locale, String> authorMap) {
		model.setAuthorMap(authorMap);
	}

	/**
	 * Sets the localized authors of this edition from the map of locales and localized authors, and sets the default locale.
	 *
	 * @param authorMap the locales and localized authors of this edition
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setAuthorMap(
		Map<java.util.Locale, String> authorMap,
		java.util.Locale defaultLocale) {

		model.setAuthorMap(authorMap, defaultLocale);
	}

	/**
	 * Sets whether this edition is available for exchange.
	 *
	 * @param availableForExchange the available for exchange of this edition
	 */
	@Override
	public void setAvailableForExchange(boolean availableForExchange) {
		model.setAvailableForExchange(availableForExchange);
	}

	/**
	 * Sets the company ID of this edition.
	 *
	 * @param companyId the company ID of this edition
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this edition.
	 *
	 * @param createDate the create date of this edition
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this edition.
	 *
	 * @param description the description of this edition
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the localized description of this edition in the language.
	 *
	 * @param description the localized description of this edition
	 * @param locale the locale of the language
	 */
	@Override
	public void setDescription(String description, java.util.Locale locale) {
		model.setDescription(description, locale);
	}

	/**
	 * Sets the localized description of this edition in the language, and sets the default locale.
	 *
	 * @param description the localized description of this edition
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
	 * Sets the localized descriptions of this edition from the map of locales and localized descriptions.
	 *
	 * @param descriptionMap the locales and localized descriptions of this edition
	 */
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, String> descriptionMap) {

		model.setDescriptionMap(descriptionMap);
	}

	/**
	 * Sets the localized descriptions of this edition from the map of locales and localized descriptions, and sets the default locale.
	 *
	 * @param descriptionMap the locales and localized descriptions of this edition
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, String> descriptionMap,
		java.util.Locale defaultLocale) {

		model.setDescriptionMap(descriptionMap, defaultLocale);
	}

	/**
	 * Sets the diffusion date month of this edition.
	 *
	 * @param diffusionDateMonth the diffusion date month of this edition
	 */
	@Override
	public void setDiffusionDateMonth(String diffusionDateMonth) {
		model.setDiffusionDateMonth(diffusionDateMonth);
	}

	/**
	 * Sets the diffusion date year of this edition.
	 *
	 * @param diffusionDateYear the diffusion date year of this edition
	 */
	@Override
	public void setDiffusionDateYear(String diffusionDateYear) {
		model.setDiffusionDateYear(diffusionDateYear);
	}

	/**
	 * Sets the distribution of this edition.
	 *
	 * @param distribution the distribution of this edition
	 */
	@Override
	public void setDistribution(String distribution) {
		model.setDistribution(distribution);
	}

	/**
	 * Sets the edition ID of this edition.
	 *
	 * @param editionId the edition ID of this edition
	 */
	@Override
	public void setEditionId(long editionId) {
		model.setEditionId(editionId);
	}

	/**
	 * Sets the editor of this edition.
	 *
	 * @param editor the editor of this edition
	 */
	@Override
	public void setEditor(String editor) {
		model.setEditor(editor);
	}

	/**
	 * Sets the localized editor of this edition in the language.
	 *
	 * @param editor the localized editor of this edition
	 * @param locale the locale of the language
	 */
	@Override
	public void setEditor(String editor, java.util.Locale locale) {
		model.setEditor(editor, locale);
	}

	/**
	 * Sets the localized editor of this edition in the language, and sets the default locale.
	 *
	 * @param editor the localized editor of this edition
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setEditor(
		String editor, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setEditor(editor, locale, defaultLocale);
	}

	@Override
	public void setEditorCurrentLanguageId(String languageId) {
		model.setEditorCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized editors of this edition from the map of locales and localized editors.
	 *
	 * @param editorMap the locales and localized editors of this edition
	 */
	@Override
	public void setEditorMap(Map<java.util.Locale, String> editorMap) {
		model.setEditorMap(editorMap);
	}

	/**
	 * Sets the localized editors of this edition from the map of locales and localized editors, and sets the default locale.
	 *
	 * @param editorMap the locales and localized editors of this edition
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setEditorMap(
		Map<java.util.Locale, String> editorMap,
		java.util.Locale defaultLocale) {

		model.setEditorMap(editorMap, defaultLocale);
	}

	/**
	 * Sets the file ID of this edition.
	 *
	 * @param fileId the file ID of this edition
	 */
	@Override
	public void setFileId(String fileId) {
		model.setFileId(fileId);
	}

	/**
	 * Sets the localized file ID of this edition in the language.
	 *
	 * @param fileId the localized file ID of this edition
	 * @param locale the locale of the language
	 */
	@Override
	public void setFileId(String fileId, java.util.Locale locale) {
		model.setFileId(fileId, locale);
	}

	/**
	 * Sets the localized file ID of this edition in the language, and sets the default locale.
	 *
	 * @param fileId the localized file ID of this edition
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setFileId(
		String fileId, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setFileId(fileId, locale, defaultLocale);
	}

	@Override
	public void setFileIdCurrentLanguageId(String languageId) {
		model.setFileIdCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized file IDs of this edition from the map of locales and localized file IDs.
	 *
	 * @param fileIdMap the locales and localized file IDs of this edition
	 */
	@Override
	public void setFileIdMap(Map<java.util.Locale, String> fileIdMap) {
		model.setFileIdMap(fileIdMap);
	}

	/**
	 * Sets the localized file IDs of this edition from the map of locales and localized file IDs, and sets the default locale.
	 *
	 * @param fileIdMap the locales and localized file IDs of this edition
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setFileIdMap(
		Map<java.util.Locale, String> fileIdMap,
		java.util.Locale defaultLocale) {

		model.setFileIdMap(fileIdMap, defaultLocale);
	}

	/**
	 * Sets the group ID of this edition.
	 *
	 * @param groupId the group ID of this edition
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the image ID of this edition.
	 *
	 * @param imageId the image ID of this edition
	 */
	@Override
	public void setImageId(Long imageId) {
		model.setImageId(imageId);
	}

	/**
	 * Sets whether this edition is in stock.
	 *
	 * @param inStock the in stock of this edition
	 */
	@Override
	public void setInStock(boolean inStock) {
		model.setInStock(inStock);
	}

	/**
	 * Sets the isbn of this edition.
	 *
	 * @param ISBN the isbn of this edition
	 */
	@Override
	public void setISBN(String ISBN) {
		model.setISBN(ISBN);
	}

	/**
	 * Sets the last publish date of this edition.
	 *
	 * @param lastPublishDate the last publish date of this edition
	 */
	@Override
	public void setLastPublishDate(Date lastPublishDate) {
		model.setLastPublishDate(lastPublishDate);
	}

	/**
	 * Sets the modified date of this edition.
	 *
	 * @param modifiedDate the modified date of this edition
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the page number of this edition.
	 *
	 * @param pageNumber the page number of this edition
	 */
	@Override
	public void setPageNumber(String pageNumber) {
		model.setPageNumber(pageNumber);
	}

	/**
	 * Sets the picture number of this edition.
	 *
	 * @param pictureNumber the picture number of this edition
	 */
	@Override
	public void setPictureNumber(String pictureNumber) {
		model.setPictureNumber(pictureNumber);
	}

	/**
	 * Sets the price of this edition.
	 *
	 * @param price the price of this edition
	 */
	@Override
	public void setPrice(String price) {
		model.setPrice(price);
	}

	/**
	 * Sets the primary key of this edition.
	 *
	 * @param primaryKey the primary key of this edition
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the publication date of this edition.
	 *
	 * @param publicationDate the publication date of this edition
	 */
	@Override
	public void setPublicationDate(Date publicationDate) {
		model.setPublicationDate(publicationDate);
	}

	/**
	 * Sets the status of this edition.
	 *
	 * @param status the status of this edition
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this edition.
	 *
	 * @param statusByUserId the status by user ID of this edition
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this edition.
	 *
	 * @param statusByUserName the status by user name of this edition
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this edition.
	 *
	 * @param statusByUserUuid the status by user uuid of this edition
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this edition.
	 *
	 * @param statusDate the status date of this edition
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the subtitle of this edition.
	 *
	 * @param subtitle the subtitle of this edition
	 */
	@Override
	public void setSubtitle(String subtitle) {
		model.setSubtitle(subtitle);
	}

	/**
	 * Sets the localized subtitle of this edition in the language.
	 *
	 * @param subtitle the localized subtitle of this edition
	 * @param locale the locale of the language
	 */
	@Override
	public void setSubtitle(String subtitle, java.util.Locale locale) {
		model.setSubtitle(subtitle, locale);
	}

	/**
	 * Sets the localized subtitle of this edition in the language, and sets the default locale.
	 *
	 * @param subtitle the localized subtitle of this edition
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setSubtitle(
		String subtitle, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setSubtitle(subtitle, locale, defaultLocale);
	}

	@Override
	public void setSubtitleCurrentLanguageId(String languageId) {
		model.setSubtitleCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized subtitles of this edition from the map of locales and localized subtitles.
	 *
	 * @param subtitleMap the locales and localized subtitles of this edition
	 */
	@Override
	public void setSubtitleMap(Map<java.util.Locale, String> subtitleMap) {
		model.setSubtitleMap(subtitleMap);
	}

	/**
	 * Sets the localized subtitles of this edition from the map of locales and localized subtitles, and sets the default locale.
	 *
	 * @param subtitleMap the locales and localized subtitles of this edition
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setSubtitleMap(
		Map<java.util.Locale, String> subtitleMap,
		java.util.Locale defaultLocale) {

		model.setSubtitleMap(subtitleMap, defaultLocale);
	}

	/**
	 * Sets the title of this edition.
	 *
	 * @param title the title of this edition
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the localized title of this edition in the language.
	 *
	 * @param title the localized title of this edition
	 * @param locale the locale of the language
	 */
	@Override
	public void setTitle(String title, java.util.Locale locale) {
		model.setTitle(title, locale);
	}

	/**
	 * Sets the localized title of this edition in the language, and sets the default locale.
	 *
	 * @param title the localized title of this edition
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
	 * Sets the localized titles of this edition from the map of locales and localized titles.
	 *
	 * @param titleMap the locales and localized titles of this edition
	 */
	@Override
	public void setTitleMap(Map<java.util.Locale, String> titleMap) {
		model.setTitleMap(titleMap);
	}

	/**
	 * Sets the localized titles of this edition from the map of locales and localized titles, and sets the default locale.
	 *
	 * @param titleMap the locales and localized titles of this edition
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setTitleMap(
		Map<java.util.Locale, String> titleMap,
		java.util.Locale defaultLocale) {

		model.setTitleMap(titleMap, defaultLocale);
	}

	/**
	 * Sets the url of this edition.
	 *
	 * @param URL the url of this edition
	 */
	@Override
	public void setURL(String URL) {
		model.setURL(URL);
	}

	/**
	 * Sets the localized url of this edition in the language.
	 *
	 * @param URL the localized url of this edition
	 * @param locale the locale of the language
	 */
	@Override
	public void setURL(String URL, java.util.Locale locale) {
		model.setURL(URL, locale);
	}

	/**
	 * Sets the localized url of this edition in the language, and sets the default locale.
	 *
	 * @param URL the localized url of this edition
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setURL(
		String URL, java.util.Locale locale, java.util.Locale defaultLocale) {

		model.setURL(URL, locale, defaultLocale);
	}

	@Override
	public void setURLCurrentLanguageId(String languageId) {
		model.setURLCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized urls of this edition from the map of locales and localized urls.
	 *
	 * @param URLMap the locales and localized urls of this edition
	 */
	@Override
	public void setURLMap(Map<java.util.Locale, String> URLMap) {
		model.setURLMap(URLMap);
	}

	/**
	 * Sets the localized urls of this edition from the map of locales and localized urls, and sets the default locale.
	 *
	 * @param URLMap the locales and localized urls of this edition
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setURLMap(
		Map<java.util.Locale, String> URLMap, java.util.Locale defaultLocale) {

		model.setURLMap(URLMap, defaultLocale);
	}

	/**
	 * Sets the user ID of this edition.
	 *
	 * @param userId the user ID of this edition
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this edition.
	 *
	 * @param userName the user name of this edition
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this edition.
	 *
	 * @param userUuid the user uuid of this edition
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this edition.
	 *
	 * @param uuid the uuid of this edition
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Retourne la version JSON de l'édition
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
	protected EditionWrapper wrap(Edition edition) {
		return new EditionWrapper(edition);
	}

}