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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.LocalizedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the PlacitPlace service. Represents a row in the &quot;project_PlacitPlace&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>eu.strasbourg.service.project.model.impl.PlacitPlaceModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>eu.strasbourg.service.project.model.impl.PlacitPlaceImpl</code>.
 * </p>
 *
 * @author Cedric Henry
 * @see PlacitPlace
 * @generated
 */
@ProviderType
public interface PlacitPlaceModel
	extends BaseModel<PlacitPlace>, GroupedModel, LocalizedModel, ShardedModel,
			StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a placit place model instance should use the {@link PlacitPlace} interface instead.
	 */

	/**
	 * Returns the primary key of this placit place.
	 *
	 * @return the primary key of this placit place
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this placit place.
	 *
	 * @param primaryKey the primary key of this placit place
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this placit place.
	 *
	 * @return the uuid of this placit place
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this placit place.
	 *
	 * @param uuid the uuid of this placit place
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the placit place ID of this placit place.
	 *
	 * @return the placit place ID of this placit place
	 */
	public long getPlacitPlaceId();

	/**
	 * Sets the placit place ID of this placit place.
	 *
	 * @param placitPlaceId the placit place ID of this placit place
	 */
	public void setPlacitPlaceId(long placitPlaceId);

	/**
	 * Returns the group ID of this placit place.
	 *
	 * @return the group ID of this placit place
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this placit place.
	 *
	 * @param groupId the group ID of this placit place
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this placit place.
	 *
	 * @return the company ID of this placit place
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this placit place.
	 *
	 * @param companyId the company ID of this placit place
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this placit place.
	 *
	 * @return the user ID of this placit place
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this placit place.
	 *
	 * @param userId the user ID of this placit place
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this placit place.
	 *
	 * @return the user uuid of this placit place
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this placit place.
	 *
	 * @param userUuid the user uuid of this placit place
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this placit place.
	 *
	 * @return the user name of this placit place
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this placit place.
	 *
	 * @param userName the user name of this placit place
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this placit place.
	 *
	 * @return the create date of this placit place
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this placit place.
	 *
	 * @param createDate the create date of this placit place
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this placit place.
	 *
	 * @return the modified date of this placit place
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this placit place.
	 *
	 * @param modifiedDate the modified date of this placit place
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the place name of this placit place.
	 *
	 * @return the place name of this placit place
	 */
	public String getPlaceName();

	/**
	 * Returns the localized place name of this placit place in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized place name of this placit place
	 */
	@AutoEscape
	public String getPlaceName(Locale locale);

	/**
	 * Returns the localized place name of this placit place in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized place name of this placit place. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getPlaceName(Locale locale, boolean useDefault);

	/**
	 * Returns the localized place name of this placit place in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized place name of this placit place
	 */
	@AutoEscape
	public String getPlaceName(String languageId);

	/**
	 * Returns the localized place name of this placit place in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized place name of this placit place
	 */
	@AutoEscape
	public String getPlaceName(String languageId, boolean useDefault);

	@AutoEscape
	public String getPlaceNameCurrentLanguageId();

	@AutoEscape
	public String getPlaceNameCurrentValue();

	/**
	 * Returns a map of the locales and localized place names of this placit place.
	 *
	 * @return the locales and localized place names of this placit place
	 */
	public Map<Locale, String> getPlaceNameMap();

	/**
	 * Sets the place name of this placit place.
	 *
	 * @param placeName the place name of this placit place
	 */
	public void setPlaceName(String placeName);

	/**
	 * Sets the localized place name of this placit place in the language.
	 *
	 * @param placeName the localized place name of this placit place
	 * @param locale the locale of the language
	 */
	public void setPlaceName(String placeName, Locale locale);

	/**
	 * Sets the localized place name of this placit place in the language, and sets the default locale.
	 *
	 * @param placeName the localized place name of this placit place
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setPlaceName(
		String placeName, Locale locale, Locale defaultLocale);

	public void setPlaceNameCurrentLanguageId(String languageId);

	/**
	 * Sets the localized place names of this placit place from the map of locales and localized place names.
	 *
	 * @param placeNameMap the locales and localized place names of this placit place
	 */
	public void setPlaceNameMap(Map<Locale, String> placeNameMap);

	/**
	 * Sets the localized place names of this placit place from the map of locales and localized place names, and sets the default locale.
	 *
	 * @param placeNameMap the locales and localized place names of this placit place
	 * @param defaultLocale the default locale
	 */
	public void setPlaceNameMap(
		Map<Locale, String> placeNameMap, Locale defaultLocale);

	/**
	 * Returns the place street number of this placit place.
	 *
	 * @return the place street number of this placit place
	 */
	@AutoEscape
	public String getPlaceStreetNumber();

	/**
	 * Sets the place street number of this placit place.
	 *
	 * @param placeStreetNumber the place street number of this placit place
	 */
	public void setPlaceStreetNumber(String placeStreetNumber);

	/**
	 * Returns the place street name of this placit place.
	 *
	 * @return the place street name of this placit place
	 */
	@AutoEscape
	public String getPlaceStreetName();

	/**
	 * Sets the place street name of this placit place.
	 *
	 * @param placeStreetName the place street name of this placit place
	 */
	public void setPlaceStreetName(String placeStreetName);

	/**
	 * Returns the place zip code of this placit place.
	 *
	 * @return the place zip code of this placit place
	 */
	@AutoEscape
	public String getPlaceZipCode();

	/**
	 * Sets the place zip code of this placit place.
	 *
	 * @param placeZipCode the place zip code of this placit place
	 */
	public void setPlaceZipCode(String placeZipCode);

	/**
	 * Returns the place city ID of this placit place.
	 *
	 * @return the place city ID of this placit place
	 */
	public long getPlaceCityId();

	/**
	 * Sets the place city ID of this placit place.
	 *
	 * @param placeCityId the place city ID of this placit place
	 */
	public void setPlaceCityId(long placeCityId);

	/**
	 * Returns the image ID of this placit place.
	 *
	 * @return the image ID of this placit place
	 */
	public long getImageId();

	/**
	 * Sets the image ID of this placit place.
	 *
	 * @param imageId the image ID of this placit place
	 */
	public void setImageId(long imageId);

	/**
	 * Returns the project ID of this placit place.
	 *
	 * @return the project ID of this placit place
	 */
	public long getProjectId();

	/**
	 * Sets the project ID of this placit place.
	 *
	 * @param projectId the project ID of this placit place
	 */
	public void setProjectId(long projectId);

	/**
	 * Returns the participation ID of this placit place.
	 *
	 * @return the participation ID of this placit place
	 */
	public long getParticipationId();

	/**
	 * Sets the participation ID of this placit place.
	 *
	 * @param participationId the participation ID of this placit place
	 */
	public void setParticipationId(long participationId);

	/**
	 * Returns the petition ID of this placit place.
	 *
	 * @return the petition ID of this placit place
	 */
	public long getPetitionId();

	/**
	 * Sets the petition ID of this placit place.
	 *
	 * @param petitionId the petition ID of this placit place
	 */
	public void setPetitionId(long petitionId);

	/**
	 * Returns the budget participatif ID of this placit place.
	 *
	 * @return the budget participatif ID of this placit place
	 */
	public long getBudgetParticipatifId();

	/**
	 * Sets the budget participatif ID of this placit place.
	 *
	 * @param budgetParticipatifId the budget participatif ID of this placit place
	 */
	public void setBudgetParticipatifId(long budgetParticipatifId);

	/**
	 * Returns the initiative ID of this placit place.
	 *
	 * @return the initiative ID of this placit place
	 */
	public long getInitiativeId();

	/**
	 * Sets the initiative ID of this placit place.
	 *
	 * @param initiativeId the initiative ID of this placit place
	 */
	public void setInitiativeId(long initiativeId);

	/**
	 * Returns the place sig ID of this placit place.
	 *
	 * @return the place sig ID of this placit place
	 */
	@AutoEscape
	public String getPlaceSIGId();

	/**
	 * Sets the place sig ID of this placit place.
	 *
	 * @param placeSIGId the place sig ID of this placit place
	 */
	public void setPlaceSIGId(String placeSIGId);

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
	public PlacitPlace cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}