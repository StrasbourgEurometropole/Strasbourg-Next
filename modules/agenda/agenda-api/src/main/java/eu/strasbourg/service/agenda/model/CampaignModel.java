/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.LocalizedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedGroupedModel;
import com.liferay.portal.kernel.model.WorkflowedModel;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Campaign service. Represents a row in the &quot;agenda_Campaign&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>eu.strasbourg.service.agenda.model.impl.CampaignModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>eu.strasbourg.service.agenda.model.impl.CampaignImpl</code>.
 * </p>
 *
 * @author BenjaminBini
 * @see Campaign
 * @generated
 */
@ProviderType
public interface CampaignModel
	extends BaseModel<Campaign>, LocalizedModel, ShardedModel,
			StagedGroupedModel, WorkflowedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a campaign model instance should use the {@link Campaign} interface instead.
	 */

	/**
	 * Returns the primary key of this campaign.
	 *
	 * @return the primary key of this campaign
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this campaign.
	 *
	 * @param primaryKey the primary key of this campaign
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this campaign.
	 *
	 * @return the uuid of this campaign
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this campaign.
	 *
	 * @param uuid the uuid of this campaign
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the campaign ID of this campaign.
	 *
	 * @return the campaign ID of this campaign
	 */
	public long getCampaignId();

	/**
	 * Sets the campaign ID of this campaign.
	 *
	 * @param campaignId the campaign ID of this campaign
	 */
	public void setCampaignId(long campaignId);

	/**
	 * Returns the group ID of this campaign.
	 *
	 * @return the group ID of this campaign
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this campaign.
	 *
	 * @param groupId the group ID of this campaign
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this campaign.
	 *
	 * @return the company ID of this campaign
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this campaign.
	 *
	 * @param companyId the company ID of this campaign
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this campaign.
	 *
	 * @return the user ID of this campaign
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this campaign.
	 *
	 * @param userId the user ID of this campaign
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this campaign.
	 *
	 * @return the user uuid of this campaign
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this campaign.
	 *
	 * @param userUuid the user uuid of this campaign
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this campaign.
	 *
	 * @return the user name of this campaign
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this campaign.
	 *
	 * @param userName the user name of this campaign
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this campaign.
	 *
	 * @return the create date of this campaign
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this campaign.
	 *
	 * @param createDate the create date of this campaign
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this campaign.
	 *
	 * @return the modified date of this campaign
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this campaign.
	 *
	 * @param modifiedDate the modified date of this campaign
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the last publish date of this campaign.
	 *
	 * @return the last publish date of this campaign
	 */
	@Override
	public Date getLastPublishDate();

	/**
	 * Sets the last publish date of this campaign.
	 *
	 * @param lastPublishDate the last publish date of this campaign
	 */
	@Override
	public void setLastPublishDate(Date lastPublishDate);

	/**
	 * Returns the status of this campaign.
	 *
	 * @return the status of this campaign
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this campaign.
	 *
	 * @param status the status of this campaign
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this campaign.
	 *
	 * @return the status by user ID of this campaign
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this campaign.
	 *
	 * @param statusByUserId the status by user ID of this campaign
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this campaign.
	 *
	 * @return the status by user uuid of this campaign
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this campaign.
	 *
	 * @param statusByUserUuid the status by user uuid of this campaign
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this campaign.
	 *
	 * @return the status by user name of this campaign
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this campaign.
	 *
	 * @param statusByUserName the status by user name of this campaign
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this campaign.
	 *
	 * @return the status date of this campaign
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this campaign.
	 *
	 * @param statusDate the status date of this campaign
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns the title of this campaign.
	 *
	 * @return the title of this campaign
	 */
	public String getTitle();

	/**
	 * Returns the localized title of this campaign in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized title of this campaign
	 */
	@AutoEscape
	public String getTitle(Locale locale);

	/**
	 * Returns the localized title of this campaign in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this campaign. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getTitle(Locale locale, boolean useDefault);

	/**
	 * Returns the localized title of this campaign in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized title of this campaign
	 */
	@AutoEscape
	public String getTitle(String languageId);

	/**
	 * Returns the localized title of this campaign in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this campaign
	 */
	@AutoEscape
	public String getTitle(String languageId, boolean useDefault);

	@AutoEscape
	public String getTitleCurrentLanguageId();

	@AutoEscape
	public String getTitleCurrentValue();

	/**
	 * Returns a map of the locales and localized titles of this campaign.
	 *
	 * @return the locales and localized titles of this campaign
	 */
	public Map<Locale, String> getTitleMap();

	/**
	 * Sets the title of this campaign.
	 *
	 * @param title the title of this campaign
	 */
	public void setTitle(String title);

	/**
	 * Sets the localized title of this campaign in the language.
	 *
	 * @param title the localized title of this campaign
	 * @param locale the locale of the language
	 */
	public void setTitle(String title, Locale locale);

	/**
	 * Sets the localized title of this campaign in the language, and sets the default locale.
	 *
	 * @param title the localized title of this campaign
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setTitle(String title, Locale locale, Locale defaultLocale);

	public void setTitleCurrentLanguageId(String languageId);

	/**
	 * Sets the localized titles of this campaign from the map of locales and localized titles.
	 *
	 * @param titleMap the locales and localized titles of this campaign
	 */
	public void setTitleMap(Map<Locale, String> titleMap);

	/**
	 * Sets the localized titles of this campaign from the map of locales and localized titles, and sets the default locale.
	 *
	 * @param titleMap the locales and localized titles of this campaign
	 * @param defaultLocale the default locale
	 */
	public void setTitleMap(Map<Locale, String> titleMap, Locale defaultLocale);

	/**
	 * Returns the default image ID of this campaign.
	 *
	 * @return the default image ID of this campaign
	 */
	public long getDefaultImageId();

	/**
	 * Sets the default image ID of this campaign.
	 *
	 * @param defaultImageId the default image ID of this campaign
	 */
	public void setDefaultImageId(long defaultImageId);

	/**
	 * Returns the default image copyright of this campaign.
	 *
	 * @return the default image copyright of this campaign
	 */
	public String getDefaultImageCopyright();

	/**
	 * Returns the localized default image copyright of this campaign in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized default image copyright of this campaign
	 */
	@AutoEscape
	public String getDefaultImageCopyright(Locale locale);

	/**
	 * Returns the localized default image copyright of this campaign in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized default image copyright of this campaign. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getDefaultImageCopyright(Locale locale, boolean useDefault);

	/**
	 * Returns the localized default image copyright of this campaign in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized default image copyright of this campaign
	 */
	@AutoEscape
	public String getDefaultImageCopyright(String languageId);

	/**
	 * Returns the localized default image copyright of this campaign in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized default image copyright of this campaign
	 */
	@AutoEscape
	public String getDefaultImageCopyright(
		String languageId, boolean useDefault);

	@AutoEscape
	public String getDefaultImageCopyrightCurrentLanguageId();

	@AutoEscape
	public String getDefaultImageCopyrightCurrentValue();

	/**
	 * Returns a map of the locales and localized default image copyrights of this campaign.
	 *
	 * @return the locales and localized default image copyrights of this campaign
	 */
	public Map<Locale, String> getDefaultImageCopyrightMap();

	/**
	 * Sets the default image copyright of this campaign.
	 *
	 * @param defaultImageCopyright the default image copyright of this campaign
	 */
	public void setDefaultImageCopyright(String defaultImageCopyright);

	/**
	 * Sets the localized default image copyright of this campaign in the language.
	 *
	 * @param defaultImageCopyright the localized default image copyright of this campaign
	 * @param locale the locale of the language
	 */
	public void setDefaultImageCopyright(
		String defaultImageCopyright, Locale locale);

	/**
	 * Sets the localized default image copyright of this campaign in the language, and sets the default locale.
	 *
	 * @param defaultImageCopyright the localized default image copyright of this campaign
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setDefaultImageCopyright(
		String defaultImageCopyright, Locale locale, Locale defaultLocale);

	public void setDefaultImageCopyrightCurrentLanguageId(String languageId);

	/**
	 * Sets the localized default image copyrights of this campaign from the map of locales and localized default image copyrights.
	 *
	 * @param defaultImageCopyrightMap the locales and localized default image copyrights of this campaign
	 */
	public void setDefaultImageCopyrightMap(
		Map<Locale, String> defaultImageCopyrightMap);

	/**
	 * Sets the localized default image copyrights of this campaign from the map of locales and localized default image copyrights, and sets the default locale.
	 *
	 * @param defaultImageCopyrightMap the locales and localized default image copyrights of this campaign
	 * @param defaultLocale the default locale
	 */
	public void setDefaultImageCopyrightMap(
		Map<Locale, String> defaultImageCopyrightMap, Locale defaultLocale);

	/**
	 * Returns the managers IDs of this campaign.
	 *
	 * @return the managers IDs of this campaign
	 */
	@AutoEscape
	public String getManagersIds();

	/**
	 * Sets the managers IDs of this campaign.
	 *
	 * @param managersIds the managers IDs of this campaign
	 */
	public void setManagersIds(String managersIds);

	/**
	 * Returns the export enabled of this campaign.
	 *
	 * @return the export enabled of this campaign
	 */
	public Boolean getExportEnabled();

	/**
	 * Sets the export enabled of this campaign.
	 *
	 * @param exportEnabled the export enabled of this campaign
	 */
	public void setExportEnabled(Boolean exportEnabled);

	/**
	 * Returns the start date of this campaign.
	 *
	 * @return the start date of this campaign
	 */
	public Date getStartDate();

	/**
	 * Sets the start date of this campaign.
	 *
	 * @param startDate the start date of this campaign
	 */
	public void setStartDate(Date startDate);

	/**
	 * Returns the end date of this campaign.
	 *
	 * @return the end date of this campaign
	 */
	public Date getEndDate();

	/**
	 * Sets the end date of this campaign.
	 *
	 * @param endDate the end date of this campaign
	 */
	public void setEndDate(Date endDate);

	/**
	 * Returns the provider of this campaign.
	 *
	 * @return the provider of this campaign
	 */
	@AutoEscape
	public String getProvider();

	/**
	 * Sets the provider of this campaign.
	 *
	 * @param provider the provider of this campaign
	 */
	public void setProvider(String provider);

	/**
	 * Returns <code>true</code> if this campaign is approved.
	 *
	 * @return <code>true</code> if this campaign is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this campaign is denied.
	 *
	 * @return <code>true</code> if this campaign is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this campaign is a draft.
	 *
	 * @return <code>true</code> if this campaign is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this campaign is expired.
	 *
	 * @return <code>true</code> if this campaign is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this campaign is inactive.
	 *
	 * @return <code>true</code> if this campaign is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this campaign is incomplete.
	 *
	 * @return <code>true</code> if this campaign is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this campaign is pending.
	 *
	 * @return <code>true</code> if this campaign is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this campaign is scheduled.
	 *
	 * @return <code>true</code> if this campaign is scheduled; <code>false</code> otherwise
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
	public Campaign cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}