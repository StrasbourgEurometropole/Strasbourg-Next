/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.LocalizedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;
import com.liferay.portal.kernel.model.WorkflowedModel;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the BudgetParticipatif service. Represents a row in the &quot;project_BudgetParticipatif&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>eu.strasbourg.service.project.model.impl.BudgetParticipatifModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>eu.strasbourg.service.project.model.impl.BudgetParticipatifImpl</code>.
 * </p>
 *
 * @author Cedric Henry
 * @see BudgetParticipatif
 * @generated
 */
@ProviderType
public interface BudgetParticipatifModel
	extends BaseModel<BudgetParticipatif>, GroupedModel, LocalizedModel,
			ShardedModel, StagedAuditedModel, WorkflowedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a budget participatif model instance should use the {@link BudgetParticipatif} interface instead.
	 */

	/**
	 * Returns the primary key of this budget participatif.
	 *
	 * @return the primary key of this budget participatif
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this budget participatif.
	 *
	 * @param primaryKey the primary key of this budget participatif
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this budget participatif.
	 *
	 * @return the uuid of this budget participatif
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this budget participatif.
	 *
	 * @param uuid the uuid of this budget participatif
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the budget participatif ID of this budget participatif.
	 *
	 * @return the budget participatif ID of this budget participatif
	 */
	public long getBudgetParticipatifId();

	/**
	 * Sets the budget participatif ID of this budget participatif.
	 *
	 * @param budgetParticipatifId the budget participatif ID of this budget participatif
	 */
	public void setBudgetParticipatifId(long budgetParticipatifId);

	/**
	 * Returns the group ID of this budget participatif.
	 *
	 * @return the group ID of this budget participatif
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this budget participatif.
	 *
	 * @param groupId the group ID of this budget participatif
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this budget participatif.
	 *
	 * @return the company ID of this budget participatif
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this budget participatif.
	 *
	 * @param companyId the company ID of this budget participatif
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this budget participatif.
	 *
	 * @return the user ID of this budget participatif
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this budget participatif.
	 *
	 * @param userId the user ID of this budget participatif
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this budget participatif.
	 *
	 * @return the user uuid of this budget participatif
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this budget participatif.
	 *
	 * @param userUuid the user uuid of this budget participatif
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this budget participatif.
	 *
	 * @return the user name of this budget participatif
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this budget participatif.
	 *
	 * @param userName the user name of this budget participatif
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this budget participatif.
	 *
	 * @return the create date of this budget participatif
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this budget participatif.
	 *
	 * @param createDate the create date of this budget participatif
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this budget participatif.
	 *
	 * @return the modified date of this budget participatif
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this budget participatif.
	 *
	 * @param modifiedDate the modified date of this budget participatif
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the status of this budget participatif.
	 *
	 * @return the status of this budget participatif
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this budget participatif.
	 *
	 * @param status the status of this budget participatif
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this budget participatif.
	 *
	 * @return the status by user ID of this budget participatif
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this budget participatif.
	 *
	 * @param statusByUserId the status by user ID of this budget participatif
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this budget participatif.
	 *
	 * @return the status by user uuid of this budget participatif
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this budget participatif.
	 *
	 * @param statusByUserUuid the status by user uuid of this budget participatif
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this budget participatif.
	 *
	 * @return the status by user name of this budget participatif
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this budget participatif.
	 *
	 * @param statusByUserName the status by user name of this budget participatif
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this budget participatif.
	 *
	 * @return the status date of this budget participatif
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this budget participatif.
	 *
	 * @param statusDate the status date of this budget participatif
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns the title of this budget participatif.
	 *
	 * @return the title of this budget participatif
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this budget participatif.
	 *
	 * @param title the title of this budget participatif
	 */
	public void setTitle(String title);

	/**
	 * Returns the description of this budget participatif.
	 *
	 * @return the description of this budget participatif
	 */
	public String getDescription();

	/**
	 * Returns the localized description of this budget participatif in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description of this budget participatif
	 */
	@AutoEscape
	public String getDescription(Locale locale);

	/**
	 * Returns the localized description of this budget participatif in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this budget participatif. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getDescription(Locale locale, boolean useDefault);

	/**
	 * Returns the localized description of this budget participatif in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description of this budget participatif
	 */
	@AutoEscape
	public String getDescription(String languageId);

	/**
	 * Returns the localized description of this budget participatif in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this budget participatif
	 */
	@AutoEscape
	public String getDescription(String languageId, boolean useDefault);

	@AutoEscape
	public String getDescriptionCurrentLanguageId();

	@AutoEscape
	public String getDescriptionCurrentValue();

	/**
	 * Returns a map of the locales and localized descriptions of this budget participatif.
	 *
	 * @return the locales and localized descriptions of this budget participatif
	 */
	public Map<Locale, String> getDescriptionMap();

	/**
	 * Sets the description of this budget participatif.
	 *
	 * @param description the description of this budget participatif
	 */
	public void setDescription(String description);

	/**
	 * Sets the localized description of this budget participatif in the language.
	 *
	 * @param description the localized description of this budget participatif
	 * @param locale the locale of the language
	 */
	public void setDescription(String description, Locale locale);

	/**
	 * Sets the localized description of this budget participatif in the language, and sets the default locale.
	 *
	 * @param description the localized description of this budget participatif
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setDescription(
		String description, Locale locale, Locale defaultLocale);

	public void setDescriptionCurrentLanguageId(String languageId);

	/**
	 * Sets the localized descriptions of this budget participatif from the map of locales and localized descriptions.
	 *
	 * @param descriptionMap the locales and localized descriptions of this budget participatif
	 */
	public void setDescriptionMap(Map<Locale, String> descriptionMap);

	/**
	 * Sets the localized descriptions of this budget participatif from the map of locales and localized descriptions, and sets the default locale.
	 *
	 * @param descriptionMap the locales and localized descriptions of this budget participatif
	 * @param defaultLocale the default locale
	 */
	public void setDescriptionMap(
		Map<Locale, String> descriptionMap, Locale defaultLocale);

	/**
	 * Returns the summary of this budget participatif.
	 *
	 * @return the summary of this budget participatif
	 */
	@AutoEscape
	public String getSummary();

	/**
	 * Sets the summary of this budget participatif.
	 *
	 * @param summary the summary of this budget participatif
	 */
	public void setSummary(String summary);

	/**
	 * Returns the budget of this budget participatif.
	 *
	 * @return the budget of this budget participatif
	 */
	@AutoEscape
	public String getBudget();

	/**
	 * Sets the budget of this budget participatif.
	 *
	 * @param budget the budget of this budget participatif
	 */
	public void setBudget(String budget);

	/**
	 * Returns the motif of this budget participatif.
	 *
	 * @return the motif of this budget participatif
	 */
	public String getMotif();

	/**
	 * Returns the localized motif of this budget participatif in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized motif of this budget participatif
	 */
	@AutoEscape
	public String getMotif(Locale locale);

	/**
	 * Returns the localized motif of this budget participatif in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized motif of this budget participatif. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getMotif(Locale locale, boolean useDefault);

	/**
	 * Returns the localized motif of this budget participatif in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized motif of this budget participatif
	 */
	@AutoEscape
	public String getMotif(String languageId);

	/**
	 * Returns the localized motif of this budget participatif in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized motif of this budget participatif
	 */
	@AutoEscape
	public String getMotif(String languageId, boolean useDefault);

	@AutoEscape
	public String getMotifCurrentLanguageId();

	@AutoEscape
	public String getMotifCurrentValue();

	/**
	 * Returns a map of the locales and localized motifs of this budget participatif.
	 *
	 * @return the locales and localized motifs of this budget participatif
	 */
	public Map<Locale, String> getMotifMap();

	/**
	 * Sets the motif of this budget participatif.
	 *
	 * @param motif the motif of this budget participatif
	 */
	public void setMotif(String motif);

	/**
	 * Sets the localized motif of this budget participatif in the language.
	 *
	 * @param motif the localized motif of this budget participatif
	 * @param locale the locale of the language
	 */
	public void setMotif(String motif, Locale locale);

	/**
	 * Sets the localized motif of this budget participatif in the language, and sets the default locale.
	 *
	 * @param motif the localized motif of this budget participatif
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setMotif(String motif, Locale locale, Locale defaultLocale);

	public void setMotifCurrentLanguageId(String languageId);

	/**
	 * Sets the localized motifs of this budget participatif from the map of locales and localized motifs.
	 *
	 * @param motifMap the locales and localized motifs of this budget participatif
	 */
	public void setMotifMap(Map<Locale, String> motifMap);

	/**
	 * Sets the localized motifs of this budget participatif from the map of locales and localized motifs, and sets the default locale.
	 *
	 * @param motifMap the locales and localized motifs of this budget participatif
	 * @param defaultLocale the default locale
	 */
	public void setMotifMap(Map<Locale, String> motifMap, Locale defaultLocale);

	/**
	 * Returns the place text area of this budget participatif.
	 *
	 * @return the place text area of this budget participatif
	 */
	@AutoEscape
	public String getPlaceTextArea();

	/**
	 * Sets the place text area of this budget participatif.
	 *
	 * @param placeTextArea the place text area of this budget participatif
	 */
	public void setPlaceTextArea(String placeTextArea);

	/**
	 * Returns the in the name of of this budget participatif.
	 *
	 * @return the in the name of of this budget participatif
	 */
	@AutoEscape
	public String getInTheNameOf();

	/**
	 * Sets the in the name of of this budget participatif.
	 *
	 * @param inTheNameOf the in the name of of this budget participatif
	 */
	public void setInTheNameOf(String inTheNameOf);

	/**
	 * Returns the commitment of this budget participatif.
	 *
	 * @return the commitment of this budget participatif
	 */
	@AutoEscape
	public String getCommitment();

	/**
	 * Sets the commitment of this budget participatif.
	 *
	 * @param commitment the commitment of this budget participatif
	 */
	public void setCommitment(String commitment);

	/**
	 * Returns the citoyen lastname of this budget participatif.
	 *
	 * @return the citoyen lastname of this budget participatif
	 */
	@AutoEscape
	public String getCitoyenLastname();

	/**
	 * Sets the citoyen lastname of this budget participatif.
	 *
	 * @param citoyenLastname the citoyen lastname of this budget participatif
	 */
	public void setCitoyenLastname(String citoyenLastname);

	/**
	 * Returns the citoyen firstname of this budget participatif.
	 *
	 * @return the citoyen firstname of this budget participatif
	 */
	@AutoEscape
	public String getCitoyenFirstname();

	/**
	 * Sets the citoyen firstname of this budget participatif.
	 *
	 * @param citoyenFirstname the citoyen firstname of this budget participatif
	 */
	public void setCitoyenFirstname(String citoyenFirstname);

	/**
	 * Returns the citoyen adresse of this budget participatif.
	 *
	 * @return the citoyen adresse of this budget participatif
	 */
	@AutoEscape
	public String getCitoyenAdresse();

	/**
	 * Sets the citoyen adresse of this budget participatif.
	 *
	 * @param citoyenAdresse the citoyen adresse of this budget participatif
	 */
	public void setCitoyenAdresse(String citoyenAdresse);

	/**
	 * Returns the citoyen postal code of this budget participatif.
	 *
	 * @return the citoyen postal code of this budget participatif
	 */
	public long getCitoyenPostalCode();

	/**
	 * Sets the citoyen postal code of this budget participatif.
	 *
	 * @param citoyenPostalCode the citoyen postal code of this budget participatif
	 */
	public void setCitoyenPostalCode(long citoyenPostalCode);

	/**
	 * Returns the citoyen city of this budget participatif.
	 *
	 * @return the citoyen city of this budget participatif
	 */
	@AutoEscape
	public String getCitoyenCity();

	/**
	 * Sets the citoyen city of this budget participatif.
	 *
	 * @param citoyenCity the citoyen city of this budget participatif
	 */
	public void setCitoyenCity(String citoyenCity);

	/**
	 * Returns the citoyen phone of this budget participatif.
	 *
	 * @return the citoyen phone of this budget participatif
	 */
	@AutoEscape
	public String getCitoyenPhone();

	/**
	 * Sets the citoyen phone of this budget participatif.
	 *
	 * @param citoyenPhone the citoyen phone of this budget participatif
	 */
	public void setCitoyenPhone(String citoyenPhone);

	/**
	 * Returns the citoyen mobile of this budget participatif.
	 *
	 * @return the citoyen mobile of this budget participatif
	 */
	@AutoEscape
	public String getCitoyenMobile();

	/**
	 * Sets the citoyen mobile of this budget participatif.
	 *
	 * @param citoyenMobile the citoyen mobile of this budget participatif
	 */
	public void setCitoyenMobile(String citoyenMobile);

	/**
	 * Returns the citoyen email of this budget participatif.
	 *
	 * @return the citoyen email of this budget participatif
	 */
	@AutoEscape
	public String getCitoyenEmail();

	/**
	 * Sets the citoyen email of this budget participatif.
	 *
	 * @param citoyenEmail the citoyen email of this budget participatif
	 */
	public void setCitoyenEmail(String citoyenEmail);

	/**
	 * Returns the citoyen birthday of this budget participatif.
	 *
	 * @return the citoyen birthday of this budget participatif
	 */
	public Date getCitoyenBirthday();

	/**
	 * Sets the citoyen birthday of this budget participatif.
	 *
	 * @param citoyenBirthday the citoyen birthday of this budget participatif
	 */
	public void setCitoyenBirthday(Date citoyenBirthday);

	/**
	 * Returns the has copyright of this budget participatif.
	 *
	 * @return the has copyright of this budget participatif
	 */
	public boolean getHasCopyright();

	/**
	 * Returns <code>true</code> if this budget participatif is has copyright.
	 *
	 * @return <code>true</code> if this budget participatif is has copyright; <code>false</code> otherwise
	 */
	public boolean isHasCopyright();

	/**
	 * Sets whether this budget participatif is has copyright.
	 *
	 * @param hasCopyright the has copyright of this budget participatif
	 */
	public void setHasCopyright(boolean hasCopyright);

	/**
	 * Returns the video url of this budget participatif.
	 *
	 * @return the video url of this budget participatif
	 */
	@AutoEscape
	public String getVideoUrl();

	/**
	 * Sets the video url of this budget participatif.
	 *
	 * @param videoUrl the video url of this budget participatif
	 */
	public void setVideoUrl(String videoUrl);

	/**
	 * Returns the image timeline of this budget participatif.
	 *
	 * @return the image timeline of this budget participatif
	 */
	public long getImageTimeline();

	/**
	 * Sets the image timeline of this budget participatif.
	 *
	 * @param imageTimeline the image timeline of this budget participatif
	 */
	public void setImageTimeline(long imageTimeline);

	/**
	 * Returns the opacity image of this budget participatif.
	 *
	 * @return the opacity image of this budget participatif
	 */
	public double getOpacityImage();

	/**
	 * Sets the opacity image of this budget participatif.
	 *
	 * @param opacityImage the opacity image of this budget participatif
	 */
	public void setOpacityImage(double opacityImage);

	/**
	 * Returns the is crush of this budget participatif.
	 *
	 * @return the is crush of this budget participatif
	 */
	public boolean getIsCrush();

	/**
	 * Returns <code>true</code> if this budget participatif is is crush.
	 *
	 * @return <code>true</code> if this budget participatif is is crush; <code>false</code> otherwise
	 */
	public boolean isIsCrush();

	/**
	 * Sets whether this budget participatif is is crush.
	 *
	 * @param isCrush the is crush of this budget participatif
	 */
	public void setIsCrush(boolean isCrush);

	/**
	 * Returns the crush comment of this budget participatif.
	 *
	 * @return the crush comment of this budget participatif
	 */
	public String getCrushComment();

	/**
	 * Returns the localized crush comment of this budget participatif in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized crush comment of this budget participatif
	 */
	@AutoEscape
	public String getCrushComment(Locale locale);

	/**
	 * Returns the localized crush comment of this budget participatif in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized crush comment of this budget participatif. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getCrushComment(Locale locale, boolean useDefault);

	/**
	 * Returns the localized crush comment of this budget participatif in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized crush comment of this budget participatif
	 */
	@AutoEscape
	public String getCrushComment(String languageId);

	/**
	 * Returns the localized crush comment of this budget participatif in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized crush comment of this budget participatif
	 */
	@AutoEscape
	public String getCrushComment(String languageId, boolean useDefault);

	@AutoEscape
	public String getCrushCommentCurrentLanguageId();

	@AutoEscape
	public String getCrushCommentCurrentValue();

	/**
	 * Returns a map of the locales and localized crush comments of this budget participatif.
	 *
	 * @return the locales and localized crush comments of this budget participatif
	 */
	public Map<Locale, String> getCrushCommentMap();

	/**
	 * Sets the crush comment of this budget participatif.
	 *
	 * @param crushComment the crush comment of this budget participatif
	 */
	public void setCrushComment(String crushComment);

	/**
	 * Sets the localized crush comment of this budget participatif in the language.
	 *
	 * @param crushComment the localized crush comment of this budget participatif
	 * @param locale the locale of the language
	 */
	public void setCrushComment(String crushComment, Locale locale);

	/**
	 * Sets the localized crush comment of this budget participatif in the language, and sets the default locale.
	 *
	 * @param crushComment the localized crush comment of this budget participatif
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setCrushComment(
		String crushComment, Locale locale, Locale defaultLocale);

	public void setCrushCommentCurrentLanguageId(String languageId);

	/**
	 * Sets the localized crush comments of this budget participatif from the map of locales and localized crush comments.
	 *
	 * @param crushCommentMap the locales and localized crush comments of this budget participatif
	 */
	public void setCrushCommentMap(Map<Locale, String> crushCommentMap);

	/**
	 * Sets the localized crush comments of this budget participatif from the map of locales and localized crush comments, and sets the default locale.
	 *
	 * @param crushCommentMap the locales and localized crush comments of this budget participatif
	 * @param defaultLocale the default locale
	 */
	public void setCrushCommentMap(
		Map<Locale, String> crushCommentMap, Locale defaultLocale);

	/**
	 * Returns the publik ID of this budget participatif.
	 *
	 * @return the publik ID of this budget participatif
	 */
	@AutoEscape
	public String getPublikId();

	/**
	 * Sets the publik ID of this budget participatif.
	 *
	 * @param publikId the publik ID of this budget participatif
	 */
	public void setPublikId(String publikId);

	/**
	 * Returns the image ID of this budget participatif.
	 *
	 * @return the image ID of this budget participatif
	 */
	public long getImageId();

	/**
	 * Sets the image ID of this budget participatif.
	 *
	 * @param imageId the image ID of this budget participatif
	 */
	public void setImageId(long imageId);

	/**
	 * Returns the files IDs of this budget participatif.
	 *
	 * @return the files IDs of this budget participatif
	 */
	@AutoEscape
	public String getFilesIds();

	/**
	 * Sets the files IDs of this budget participatif.
	 *
	 * @param filesIds the files IDs of this budget participatif
	 */
	public void setFilesIds(String filesIds);

	/**
	 * Returns the budget phase ID of this budget participatif.
	 *
	 * @return the budget phase ID of this budget participatif
	 */
	public long getBudgetPhaseId();

	/**
	 * Sets the budget phase ID of this budget participatif.
	 *
	 * @param budgetPhaseId the budget phase ID of this budget participatif
	 */
	public void setBudgetPhaseId(long budgetPhaseId);

	/**
	 * Returns the parent ID of this budget participatif.
	 *
	 * @return the parent ID of this budget participatif
	 */
	public long getParentId();

	/**
	 * Sets the parent ID of this budget participatif.
	 *
	 * @param parentId the parent ID of this budget participatif
	 */
	public void setParentId(long parentId);

	/**
	 * Returns <code>true</code> if this budget participatif is approved.
	 *
	 * @return <code>true</code> if this budget participatif is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this budget participatif is denied.
	 *
	 * @return <code>true</code> if this budget participatif is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this budget participatif is a draft.
	 *
	 * @return <code>true</code> if this budget participatif is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this budget participatif is expired.
	 *
	 * @return <code>true</code> if this budget participatif is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this budget participatif is inactive.
	 *
	 * @return <code>true</code> if this budget participatif is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this budget participatif is incomplete.
	 *
	 * @return <code>true</code> if this budget participatif is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this budget participatif is pending.
	 *
	 * @return <code>true</code> if this budget participatif is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this budget participatif is scheduled.
	 *
	 * @return <code>true</code> if this budget participatif is scheduled; <code>false</code> otherwise
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
	public BudgetParticipatif cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}