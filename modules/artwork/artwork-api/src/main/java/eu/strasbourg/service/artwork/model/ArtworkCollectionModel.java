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

package eu.strasbourg.service.artwork.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.LocalizedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedGroupedModel;
import com.liferay.portal.kernel.model.WorkflowedModel;
import org.osgi.annotation.versioning.ProviderType;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * The base model interface for the ArtworkCollection service. Represents a row in the &quot;artwork_ArtworkCollection&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>eu.strasbourg.service.artwork.model.impl.ArtworkCollectionModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>eu.strasbourg.service.artwork.model.impl.ArtworkCollectionImpl</code>.
 * </p>
 *
 * @author BenjaminBini
 * @see ArtworkCollection
 * @generated
 */
@ProviderType
public interface ArtworkCollectionModel
	extends BaseModel<ArtworkCollection>, LocalizedModel, ShardedModel,
			StagedGroupedModel, WorkflowedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a artwork collection model instance should use the {@link ArtworkCollection} interface instead.
	 */

	/**
	 * Returns the primary key of this artwork collection.
	 *
	 * @return the primary key of this artwork collection
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this artwork collection.
	 *
	 * @param primaryKey the primary key of this artwork collection
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this artwork collection.
	 *
	 * @return the uuid of this artwork collection
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this artwork collection.
	 *
	 * @param uuid the uuid of this artwork collection
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the collection ID of this artwork collection.
	 *
	 * @return the collection ID of this artwork collection
	 */
	public long getCollectionId();

	/**
	 * Sets the collection ID of this artwork collection.
	 *
	 * @param collectionId the collection ID of this artwork collection
	 */
	public void setCollectionId(long collectionId);

	/**
	 * Returns the group ID of this artwork collection.
	 *
	 * @return the group ID of this artwork collection
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this artwork collection.
	 *
	 * @param groupId the group ID of this artwork collection
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this artwork collection.
	 *
	 * @return the company ID of this artwork collection
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this artwork collection.
	 *
	 * @param companyId the company ID of this artwork collection
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this artwork collection.
	 *
	 * @return the user ID of this artwork collection
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this artwork collection.
	 *
	 * @param userId the user ID of this artwork collection
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this artwork collection.
	 *
	 * @return the user uuid of this artwork collection
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this artwork collection.
	 *
	 * @param userUuid the user uuid of this artwork collection
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this artwork collection.
	 *
	 * @return the user name of this artwork collection
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this artwork collection.
	 *
	 * @param userName the user name of this artwork collection
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this artwork collection.
	 *
	 * @return the create date of this artwork collection
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this artwork collection.
	 *
	 * @param createDate the create date of this artwork collection
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this artwork collection.
	 *
	 * @return the modified date of this artwork collection
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this artwork collection.
	 *
	 * @param modifiedDate the modified date of this artwork collection
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the last publish date of this artwork collection.
	 *
	 * @return the last publish date of this artwork collection
	 */
	@Override
	public Date getLastPublishDate();

	/**
	 * Sets the last publish date of this artwork collection.
	 *
	 * @param lastPublishDate the last publish date of this artwork collection
	 */
	@Override
	public void setLastPublishDate(Date lastPublishDate);

	/**
	 * Returns the status of this artwork collection.
	 *
	 * @return the status of this artwork collection
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this artwork collection.
	 *
	 * @param status the status of this artwork collection
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this artwork collection.
	 *
	 * @return the status by user ID of this artwork collection
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this artwork collection.
	 *
	 * @param statusByUserId the status by user ID of this artwork collection
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this artwork collection.
	 *
	 * @return the status by user uuid of this artwork collection
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this artwork collection.
	 *
	 * @param statusByUserUuid the status by user uuid of this artwork collection
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this artwork collection.
	 *
	 * @return the status by user name of this artwork collection
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this artwork collection.
	 *
	 * @param statusByUserName the status by user name of this artwork collection
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this artwork collection.
	 *
	 * @return the status date of this artwork collection
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this artwork collection.
	 *
	 * @param statusDate the status date of this artwork collection
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns the title of this artwork collection.
	 *
	 * @return the title of this artwork collection
	 */
	public String getTitle();

	/**
	 * Returns the localized title of this artwork collection in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized title of this artwork collection
	 */
	@AutoEscape
	public String getTitle(Locale locale);

	/**
	 * Returns the localized title of this artwork collection in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this artwork collection. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getTitle(Locale locale, boolean useDefault);

	/**
	 * Returns the localized title of this artwork collection in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized title of this artwork collection
	 */
	@AutoEscape
	public String getTitle(String languageId);

	/**
	 * Returns the localized title of this artwork collection in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this artwork collection
	 */
	@AutoEscape
	public String getTitle(String languageId, boolean useDefault);

	@AutoEscape
	public String getTitleCurrentLanguageId();

	@AutoEscape
	public String getTitleCurrentValue();

	/**
	 * Returns a map of the locales and localized titles of this artwork collection.
	 *
	 * @return the locales and localized titles of this artwork collection
	 */
	public Map<Locale, String> getTitleMap();

	/**
	 * Sets the title of this artwork collection.
	 *
	 * @param title the title of this artwork collection
	 */
	public void setTitle(String title);

	/**
	 * Sets the localized title of this artwork collection in the language.
	 *
	 * @param title the localized title of this artwork collection
	 * @param locale the locale of the language
	 */
	public void setTitle(String title, Locale locale);

	/**
	 * Sets the localized title of this artwork collection in the language, and sets the default locale.
	 *
	 * @param title the localized title of this artwork collection
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setTitle(String title, Locale locale, Locale defaultLocale);

	public void setTitleCurrentLanguageId(String languageId);

	/**
	 * Sets the localized titles of this artwork collection from the map of locales and localized titles.
	 *
	 * @param titleMap the locales and localized titles of this artwork collection
	 */
	public void setTitleMap(Map<Locale, String> titleMap);

	/**
	 * Sets the localized titles of this artwork collection from the map of locales and localized titles, and sets the default locale.
	 *
	 * @param titleMap the locales and localized titles of this artwork collection
	 * @param defaultLocale the default locale
	 */
	public void setTitleMap(Map<Locale, String> titleMap, Locale defaultLocale);

	/**
	 * Returns the description of this artwork collection.
	 *
	 * @return the description of this artwork collection
	 */
	public String getDescription();

	/**
	 * Returns the localized description of this artwork collection in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description of this artwork collection
	 */
	@AutoEscape
	public String getDescription(Locale locale);

	/**
	 * Returns the localized description of this artwork collection in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this artwork collection. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getDescription(Locale locale, boolean useDefault);

	/**
	 * Returns the localized description of this artwork collection in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description of this artwork collection
	 */
	@AutoEscape
	public String getDescription(String languageId);

	/**
	 * Returns the localized description of this artwork collection in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this artwork collection
	 */
	@AutoEscape
	public String getDescription(String languageId, boolean useDefault);

	@AutoEscape
	public String getDescriptionCurrentLanguageId();

	@AutoEscape
	public String getDescriptionCurrentValue();

	/**
	 * Returns a map of the locales and localized descriptions of this artwork collection.
	 *
	 * @return the locales and localized descriptions of this artwork collection
	 */
	public Map<Locale, String> getDescriptionMap();

	/**
	 * Sets the description of this artwork collection.
	 *
	 * @param description the description of this artwork collection
	 */
	public void setDescription(String description);

	/**
	 * Sets the localized description of this artwork collection in the language.
	 *
	 * @param description the localized description of this artwork collection
	 * @param locale the locale of the language
	 */
	public void setDescription(String description, Locale locale);

	/**
	 * Sets the localized description of this artwork collection in the language, and sets the default locale.
	 *
	 * @param description the localized description of this artwork collection
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setDescription(
		String description, Locale locale, Locale defaultLocale);

	public void setDescriptionCurrentLanguageId(String languageId);

	/**
	 * Sets the localized descriptions of this artwork collection from the map of locales and localized descriptions.
	 *
	 * @param descriptionMap the locales and localized descriptions of this artwork collection
	 */
	public void setDescriptionMap(Map<Locale, String> descriptionMap);

	/**
	 * Sets the localized descriptions of this artwork collection from the map of locales and localized descriptions, and sets the default locale.
	 *
	 * @param descriptionMap the locales and localized descriptions of this artwork collection
	 * @param defaultLocale the default locale
	 */
	public void setDescriptionMap(
		Map<Locale, String> descriptionMap, Locale defaultLocale);

	/**
	 * Returns the contributors of this artwork collection.
	 *
	 * @return the contributors of this artwork collection
	 */
	public String getContributors();

	/**
	 * Returns the localized contributors of this artwork collection in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized contributors of this artwork collection
	 */
	@AutoEscape
	public String getContributors(Locale locale);

	/**
	 * Returns the localized contributors of this artwork collection in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized contributors of this artwork collection. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getContributors(Locale locale, boolean useDefault);

	/**
	 * Returns the localized contributors of this artwork collection in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized contributors of this artwork collection
	 */
	@AutoEscape
	public String getContributors(String languageId);

	/**
	 * Returns the localized contributors of this artwork collection in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized contributors of this artwork collection
	 */
	@AutoEscape
	public String getContributors(String languageId, boolean useDefault);

	@AutoEscape
	public String getContributorsCurrentLanguageId();

	@AutoEscape
	public String getContributorsCurrentValue();

	/**
	 * Returns a map of the locales and localized contributorses of this artwork collection.
	 *
	 * @return the locales and localized contributorses of this artwork collection
	 */
	public Map<Locale, String> getContributorsMap();

	/**
	 * Sets the contributors of this artwork collection.
	 *
	 * @param contributors the contributors of this artwork collection
	 */
	public void setContributors(String contributors);

	/**
	 * Sets the localized contributors of this artwork collection in the language.
	 *
	 * @param contributors the localized contributors of this artwork collection
	 * @param locale the locale of the language
	 */
	public void setContributors(String contributors, Locale locale);

	/**
	 * Sets the localized contributors of this artwork collection in the language, and sets the default locale.
	 *
	 * @param contributors the localized contributors of this artwork collection
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setContributors(
		String contributors, Locale locale, Locale defaultLocale);

	public void setContributorsCurrentLanguageId(String languageId);

	/**
	 * Sets the localized contributorses of this artwork collection from the map of locales and localized contributorses.
	 *
	 * @param contributorsMap the locales and localized contributorses of this artwork collection
	 */
	public void setContributorsMap(Map<Locale, String> contributorsMap);

	/**
	 * Sets the localized contributorses of this artwork collection from the map of locales and localized contributorses, and sets the default locale.
	 *
	 * @param contributorsMap the locales and localized contributorses of this artwork collection
	 * @param defaultLocale the default locale
	 */
	public void setContributorsMap(
		Map<Locale, String> contributorsMap, Locale defaultLocale);

	/**
	 * Returns the image ID of this artwork collection.
	 *
	 * @return the image ID of this artwork collection
	 */
	public Long getImageId();

	/**
	 * Sets the image ID of this artwork collection.
	 *
	 * @param imageId the image ID of this artwork collection
	 */
	public void setImageId(Long imageId);

	/**
	 * Returns <code>true</code> if this artwork collection is approved.
	 *
	 * @return <code>true</code> if this artwork collection is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this artwork collection is denied.
	 *
	 * @return <code>true</code> if this artwork collection is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this artwork collection is a draft.
	 *
	 * @return <code>true</code> if this artwork collection is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this artwork collection is expired.
	 *
	 * @return <code>true</code> if this artwork collection is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this artwork collection is inactive.
	 *
	 * @return <code>true</code> if this artwork collection is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this artwork collection is incomplete.
	 *
	 * @return <code>true</code> if this artwork collection is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this artwork collection is pending.
	 *
	 * @return <code>true</code> if this artwork collection is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this artwork collection is scheduled.
	 *
	 * @return <code>true</code> if this artwork collection is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled();

	@Override
	public String[] getAvailableLanguageIds();

	@Override
	public String getDefaultLanguageId();

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException;

	@Override
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException;

	@Override
	public ArtworkCollection cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}