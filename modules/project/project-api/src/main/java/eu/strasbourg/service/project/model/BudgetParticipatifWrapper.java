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
 * This class is a wrapper for {@link BudgetParticipatif}.
 * </p>
 *
 * @author Cedric Henry
 * @see BudgetParticipatif
 * @generated
 */
public class BudgetParticipatifWrapper
	extends BaseModelWrapper<BudgetParticipatif>
	implements BudgetParticipatif, ModelWrapper<BudgetParticipatif> {

	public BudgetParticipatifWrapper(BudgetParticipatif budgetParticipatif) {
		super(budgetParticipatif);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("budgetParticipatifId", getBudgetParticipatifId());
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
		attributes.put("description", getDescription());
		attributes.put("summary", getSummary());
		attributes.put("budget", getBudget());
		attributes.put("motif", getMotif());
		attributes.put("placeTextArea", getPlaceTextArea());
		attributes.put("inTheNameOf", getInTheNameOf());
		attributes.put("citoyenLastname", getCitoyenLastname());
		attributes.put("citoyenFirstname", getCitoyenFirstname());
		attributes.put("citoyenAdresse", getCitoyenAdresse());
		attributes.put("citoyenPostalCode", getCitoyenPostalCode());
		attributes.put("citoyenCity", getCitoyenCity());
		attributes.put("citoyenPhone", getCitoyenPhone());
		attributes.put("citoyenMobile", getCitoyenMobile());
		attributes.put("citoyenEmail", getCitoyenEmail());
		attributes.put("citoyenBirthday", getCitoyenBirthday());
		attributes.put("hasCopyright", isHasCopyright());
		attributes.put("videoUrl", getVideoUrl());
		attributes.put("imageTimeline", getImageTimeline());
		attributes.put("opacityImage", getOpacityImage());
		attributes.put("isCrush", isIsCrush());
		attributes.put("crushComment", getCrushComment());
		attributes.put("publikId", getPublikId());
		attributes.put("imageId", getImageId());
		attributes.put("filesIds", getFilesIds());
		attributes.put("budgetPhaseId", getBudgetPhaseId());
		attributes.put("parentId", getParentId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long budgetParticipatifId = (Long)attributes.get(
			"budgetParticipatifId");

		if (budgetParticipatifId != null) {
			setBudgetParticipatifId(budgetParticipatifId);
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

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String summary = (String)attributes.get("summary");

		if (summary != null) {
			setSummary(summary);
		}

		String budget = (String)attributes.get("budget");

		if (budget != null) {
			setBudget(budget);
		}

		String motif = (String)attributes.get("motif");

		if (motif != null) {
			setMotif(motif);
		}

		String placeTextArea = (String)attributes.get("placeTextArea");

		if (placeTextArea != null) {
			setPlaceTextArea(placeTextArea);
		}

		String inTheNameOf = (String)attributes.get("inTheNameOf");

		if (inTheNameOf != null) {
			setInTheNameOf(inTheNameOf);
		}

		String citoyenLastname = (String)attributes.get("citoyenLastname");

		if (citoyenLastname != null) {
			setCitoyenLastname(citoyenLastname);
		}

		String citoyenFirstname = (String)attributes.get("citoyenFirstname");

		if (citoyenFirstname != null) {
			setCitoyenFirstname(citoyenFirstname);
		}

		String citoyenAdresse = (String)attributes.get("citoyenAdresse");

		if (citoyenAdresse != null) {
			setCitoyenAdresse(citoyenAdresse);
		}

		Long citoyenPostalCode = (Long)attributes.get("citoyenPostalCode");

		if (citoyenPostalCode != null) {
			setCitoyenPostalCode(citoyenPostalCode);
		}

		String citoyenCity = (String)attributes.get("citoyenCity");

		if (citoyenCity != null) {
			setCitoyenCity(citoyenCity);
		}

		String citoyenPhone = (String)attributes.get("citoyenPhone");

		if (citoyenPhone != null) {
			setCitoyenPhone(citoyenPhone);
		}

		String citoyenMobile = (String)attributes.get("citoyenMobile");

		if (citoyenMobile != null) {
			setCitoyenMobile(citoyenMobile);
		}

		String citoyenEmail = (String)attributes.get("citoyenEmail");

		if (citoyenEmail != null) {
			setCitoyenEmail(citoyenEmail);
		}

		Date citoyenBirthday = (Date)attributes.get("citoyenBirthday");

		if (citoyenBirthday != null) {
			setCitoyenBirthday(citoyenBirthday);
		}

		Boolean hasCopyright = (Boolean)attributes.get("hasCopyright");

		if (hasCopyright != null) {
			setHasCopyright(hasCopyright);
		}

		String videoUrl = (String)attributes.get("videoUrl");

		if (videoUrl != null) {
			setVideoUrl(videoUrl);
		}

		Long imageTimeline = (Long)attributes.get("imageTimeline");

		if (imageTimeline != null) {
			setImageTimeline(imageTimeline);
		}

		Double opacityImage = (Double)attributes.get("opacityImage");

		if (opacityImage != null) {
			setOpacityImage(opacityImage);
		}

		Boolean isCrush = (Boolean)attributes.get("isCrush");

		if (isCrush != null) {
			setIsCrush(isCrush);
		}

		String crushComment = (String)attributes.get("crushComment");

		if (crushComment != null) {
			setCrushComment(crushComment);
		}

		String publikId = (String)attributes.get("publikId");

		if (publikId != null) {
			setPublikId(publikId);
		}

		Long imageId = (Long)attributes.get("imageId");

		if (imageId != null) {
			setImageId(imageId);
		}

		String filesIds = (String)attributes.get("filesIds");

		if (filesIds != null) {
			setFilesIds(filesIds);
		}

		Long budgetPhaseId = (Long)attributes.get("budgetPhaseId");

		if (budgetPhaseId != null) {
			setBudgetPhaseId(budgetPhaseId);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}
	}

	@Override
	public BudgetParticipatif cloneWithOriginalValues() {
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

	/**
	 * Retourne le nom de l'autheur sous forme "Truc M."
	 */
	@Override
	public String getAuthor() {
		return model.getAuthor();
	}

	/**
	 * Retourne l'URL de l'image de l'utilisateur
	 */
	@Override
	public String getAuthorImageURL() {
		return model.getAuthorImageURL();
	}

	/**
	 * Retourne l'auteur en publik user
	 *
	 * @return
	 */
	@Override
	public eu.strasbourg.service.oidc.model.PublikUser getAuthorPublikUser() {
		return model.getAuthorPublikUser();
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	@Override
	public String getBPbuttonMessageState(
		javax.servlet.http.HttpServletRequest request) {

		return model.getBPbuttonMessageState(request);
	}

	@Override
	public String getBPMessageState(
		javax.servlet.http.HttpServletRequest request) {

		return model.getBPMessageState(request);
	}

	@Override
	public int getBPState() {
		return model.getBPState();
	}

	/**
	 * Returns the budget of this budget participatif.
	 *
	 * @return the budget of this budget participatif
	 */
	@Override
	public String getBudget() {
		return model.getBudget();
	}

	/**
	 * Returns the budget participatif ID of this budget participatif.
	 *
	 * @return the budget participatif ID of this budget participatif
	 */
	@Override
	public long getBudgetParticipatifId() {
		return model.getBudgetParticipatifId();
	}

	/**
	 * Retourne le statut (Enumeration) du budget participatif
	 */
	@Override
	public eu.strasbourg.service.project.constants.ParticiperCategories
		getBudgetParticipatifStatus() {

		return model.getBudgetParticipatifStatus();
	}

	/**
	 * Retourne la catégorie 'Statut BP' du budget participatif
	 */
	@Override
	public com.liferay.asset.kernel.model.AssetCategory
		getBudgetParticipatifStatusCategory() {

		return model.getBudgetParticipatifStatusCategory();
	}

	@Override
	public String getBudgetParticipatifStatusCategoryColor() {
		return model.getBudgetParticipatifStatusCategoryColor();
	}

	@Override
	public String getBudgetParticipatifStatusTitle(java.util.Locale locale) {
		return model.getBudgetParticipatifStatusTitle(locale);
	}

	/**
	 * Retourne la liste des entrées timelines du projet
	 */
	@Override
	public java.util.List<eu.strasbourg.service.project.model.ProjectTimeline>
		getBudgetParticipatifTimelines() {

		return model.getBudgetParticipatifTimelines();
	}

	/**
	 * Returns the budget phase ID of this budget participatif.
	 *
	 * @return the budget phase ID of this budget participatif
	 */
	@Override
	public long getBudgetPhaseId() {
		return model.getBudgetPhaseId();
	}

	/**
	 * retourne les catégories
	 *
	 * @return
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCategories() {

		return model.getCategories();
	}

	/**
	 * Retourne X suggestions max pour un BP
	 *
	 * @return la liste de bp.
	 */
	@Override
	public java.util.List
		<eu.strasbourg.service.project.model.BudgetParticipatif> getChilds() {

		return model.getChilds();
	}

	/**
	 * Returns the citoyen adresse of this budget participatif.
	 *
	 * @return the citoyen adresse of this budget participatif
	 */
	@Override
	public String getCitoyenAdresse() {
		return model.getCitoyenAdresse();
	}

	/**
	 * Returns the citoyen birthday of this budget participatif.
	 *
	 * @return the citoyen birthday of this budget participatif
	 */
	@Override
	public Date getCitoyenBirthday() {
		return model.getCitoyenBirthday();
	}

	/**
	 * Returns the citoyen city of this budget participatif.
	 *
	 * @return the citoyen city of this budget participatif
	 */
	@Override
	public String getCitoyenCity() {
		return model.getCitoyenCity();
	}

	/**
	 * Returns the citoyen email of this budget participatif.
	 *
	 * @return the citoyen email of this budget participatif
	 */
	@Override
	public String getCitoyenEmail() {
		return model.getCitoyenEmail();
	}

	/**
	 * Returns the citoyen firstname of this budget participatif.
	 *
	 * @return the citoyen firstname of this budget participatif
	 */
	@Override
	public String getCitoyenFirstname() {
		return model.getCitoyenFirstname();
	}

	/**
	 * Returns the citoyen lastname of this budget participatif.
	 *
	 * @return the citoyen lastname of this budget participatif
	 */
	@Override
	public String getCitoyenLastname() {
		return model.getCitoyenLastname();
	}

	/**
	 * Returns the citoyen mobile of this budget participatif.
	 *
	 * @return the citoyen mobile of this budget participatif
	 */
	@Override
	public String getCitoyenMobile() {
		return model.getCitoyenMobile();
	}

	/**
	 * Returns the citoyen phone of this budget participatif.
	 *
	 * @return the citoyen phone of this budget participatif
	 */
	@Override
	public String getCitoyenPhone() {
		return model.getCitoyenPhone();
	}

	/**
	 * Returns the citoyen postal code of this budget participatif.
	 *
	 * @return the citoyen postal code of this budget participatif
	 */
	@Override
	public long getCitoyenPostalCode() {
		return model.getCitoyenPostalCode();
	}

	/**
	 * Retourne les sous-sous-catégories 'Territoire' correspondant aux communes du bp
	 *
	 * @return : null si vide, sinon la liste des catégories
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCityCategories() {

		return model.getCityCategories();
	}

	/**
	 * Returns the company ID of this budget participatif.
	 *
	 * @return the company ID of this budget participatif
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this budget participatif.
	 *
	 * @return the create date of this budget participatif
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the crush comment of this budget participatif.
	 *
	 * @return the crush comment of this budget participatif
	 */
	@Override
	public String getCrushComment() {
		return model.getCrushComment();
	}

	/**
	 * Returns the localized crush comment of this budget participatif in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized crush comment of this budget participatif
	 */
	@Override
	public String getCrushComment(java.util.Locale locale) {
		return model.getCrushComment(locale);
	}

	/**
	 * Returns the localized crush comment of this budget participatif in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized crush comment of this budget participatif. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getCrushComment(java.util.Locale locale, boolean useDefault) {
		return model.getCrushComment(locale, useDefault);
	}

	/**
	 * Returns the localized crush comment of this budget participatif in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized crush comment of this budget participatif
	 */
	@Override
	public String getCrushComment(String languageId) {
		return model.getCrushComment(languageId);
	}

	/**
	 * Returns the localized crush comment of this budget participatif in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized crush comment of this budget participatif
	 */
	@Override
	public String getCrushComment(String languageId, boolean useDefault) {
		return model.getCrushComment(languageId, useDefault);
	}

	@Override
	public String getCrushCommentCurrentLanguageId() {
		return model.getCrushCommentCurrentLanguageId();
	}

	@Override
	public String getCrushCommentCurrentValue() {
		return model.getCrushCommentCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized crush comments of this budget participatif.
	 *
	 * @return the locales and localized crush comments of this budget participatif
	 */
	@Override
	public Map<java.util.Locale, String> getCrushCommentMap() {
		return model.getCrushCommentMap();
	}

	@Override
	public String getDefaultLanguageId() {
		return model.getDefaultLanguageId();
	}

	/**
	 * Returns the description of this budget participatif.
	 *
	 * @return the description of this budget participatif
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the localized description of this budget participatif in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description of this budget participatif
	 */
	@Override
	public String getDescription(java.util.Locale locale) {
		return model.getDescription(locale);
	}

	/**
	 * Returns the localized description of this budget participatif in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this budget participatif. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getDescription(java.util.Locale locale, boolean useDefault) {
		return model.getDescription(locale, useDefault);
	}

	/**
	 * Returns the localized description of this budget participatif in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description of this budget participatif
	 */
	@Override
	public String getDescription(String languageId) {
		return model.getDescription(languageId);
	}

	/**
	 * Returns the localized description of this budget participatif in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this budget participatif
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
	 * Returns a map of the locales and localized descriptions of this budget participatif.
	 *
	 * @return the locales and localized descriptions of this budget participatif
	 */
	@Override
	public Map<java.util.Locale, String> getDescriptionMap() {
		return model.getDescriptionMap();
	}

	/**
	 * Retourne les sous-sous-catégories 'Territoire' correspondant aux quartiers du bp
	 *
	 * @return : null si vide, sinon la liste des catégories
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getDistrictCategories() {

		return model.getDistrictCategories();
	}

	/**
	 * Retourne une chaine des 'Territoires' correspondant aux quartiers du bp
	 *
	 * @return : Chaine des quartiers ou description "Aucun" ou "Tous"
	 */
	@Override
	public String getDistrictLabel(java.util.Locale locale) {
		return model.getDistrictLabel(locale);
	}

	/**
	 * Returns the files IDs of this budget participatif.
	 *
	 * @return the files IDs of this budget participatif
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
	 * Returns the group ID of this budget participatif.
	 *
	 * @return the group ID of this budget participatif
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the has copyright of this budget participatif.
	 *
	 * @return the has copyright of this budget participatif
	 */
	@Override
	public boolean getHasCopyright() {
		return model.getHasCopyright();
	}

	/**
	 * Returns the image ID of this budget participatif.
	 *
	 * @return the image ID of this budget participatif
	 */
	@Override
	public long getImageId() {
		return model.getImageId();
	}

	/**
	 * Returns the image timeline of this budget participatif.
	 *
	 * @return the image timeline of this budget participatif
	 */
	@Override
	public long getImageTimeline() {
		return model.getImageTimeline();
	}

	/**
	 * Retourne l'URL de l'image de la timeline à partir de l'id du DLFileEntry
	 */
	@Override
	public String getImageTimelineURL() {
		return model.getImageTimelineURL();
	}

	/**
	 * Retourne l'URL de l'image à partir de l'id du DLFileEntry
	 */
	@Override
	public String getImageURL() {
		return model.getImageURL();
	}

	/**
	 * Returns the in the name of of this budget participatif.
	 *
	 * @return the in the name of of this budget participatif
	 */
	@Override
	public String getInTheNameOf() {
		return model.getInTheNameOf();
	}

	/**
	 * Returns the is crush of this budget participatif.
	 *
	 * @return the is crush of this budget participatif
	 */
	@Override
	public boolean getIsCrush() {
		return model.getIsCrush();
	}

	/**
	 * Returns the modified date of this budget participatif.
	 *
	 * @return the modified date of this budget participatif
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the motif of this budget participatif.
	 *
	 * @return the motif of this budget participatif
	 */
	@Override
	public String getMotif() {
		return model.getMotif();
	}

	/**
	 * Returns the localized motif of this budget participatif in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized motif of this budget participatif
	 */
	@Override
	public String getMotif(java.util.Locale locale) {
		return model.getMotif(locale);
	}

	/**
	 * Returns the localized motif of this budget participatif in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized motif of this budget participatif. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getMotif(java.util.Locale locale, boolean useDefault) {
		return model.getMotif(locale, useDefault);
	}

	/**
	 * Returns the localized motif of this budget participatif in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized motif of this budget participatif
	 */
	@Override
	public String getMotif(String languageId) {
		return model.getMotif(languageId);
	}

	/**
	 * Returns the localized motif of this budget participatif in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized motif of this budget participatif
	 */
	@Override
	public String getMotif(String languageId, boolean useDefault) {
		return model.getMotif(languageId, useDefault);
	}

	@Override
	public String getMotifCurrentLanguageId() {
		return model.getMotifCurrentLanguageId();
	}

	@Override
	public String getMotifCurrentValue() {
		return model.getMotifCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized motifs of this budget participatif.
	 *
	 * @return the locales and localized motifs of this budget participatif
	 */
	@Override
	public Map<java.util.Locale, String> getMotifMap() {
		return model.getMotifMap();
	}

	/**
	 * Retourne le nombre de commentaires de l'entité
	 */
	@Override
	public int getNbApprovedComments() {
		return model.getNbApprovedComments();
	}

	/**
	 * Retourne le nombre de soutiens d'un utilisateur pour ce projet
	 */
	@Override
	public int getNbSupportOfUser(String publikUserId) {
		return model.getNbSupportOfUser(publikUserId);
	}

	/**
	 * Retourne le nombre de soutiens d'un utilisateur pour la phase en cours, qu'importe le projet
	 */
	@Override
	public int getNbSupportOfUserInActivePhase(String publikUserId) {
		return model.getNbSupportOfUserInActivePhase(publikUserId);
	}

	/**
	 * Retourne le nombre de soutien
	 */
	@Override
	public long getNbSupports() {
		return model.getNbSupports();
	}

	/**
	 * Retourne le nombre de soutien sous le format 6 digits pour l'affichage
	 *
	 * @return le nombre sous le format '000124'
	 */
	@Override
	public String getNbSupportsBoard() {
		return model.getNbSupportsBoard();
	}

	/**
	 * Returns the opacity image of this budget participatif.
	 *
	 * @return the opacity image of this budget participatif
	 */
	@Override
	public double getOpacityImage() {
		return model.getOpacityImage();
	}

	/**
	 * Retourne Le budget participatif parent dans le cas d'un bp fusionne
	 *
	 * @return Le BP parent
	 */
	@Override
	public eu.strasbourg.service.project.model.BudgetParticipatif getParent() {
		return model.getParent();
	}

	/**
	 * Returns the parent ID of this budget participatif.
	 *
	 * @return the parent ID of this budget participatif
	 */
	@Override
	public long getParentId() {
		return model.getParentId();
	}

	@Override
	public eu.strasbourg.service.project.model.BudgetPhase getPhase() {
		return model.getPhase();
	}

	/**
	 * Retourne la catégorie 'Phase du budget participatif' du budget participatif
	 */
	@Override
	public com.liferay.asset.kernel.model.AssetCategory getPhaseCategory() {
		return model.getPhaseCategory();
	}

	@Override
	public String getPhaseTitleLabel() {
		return model.getPhaseTitleLabel();
	}

	/**
	 * Returns the place text area of this budget participatif.
	 *
	 * @return the place text area of this budget participatif
	 */
	@Override
	public String getPlaceTextArea() {
		return model.getPlaceTextArea();
	}

	/**
	 * Retourne la liste des lieux placit liés
	 */
	@Override
	public java.util.List<eu.strasbourg.service.project.model.PlacitPlace>
		getPlacitPlaces() {

		return model.getPlacitPlaces();
	}

	/**
	 * Returns the primary key of this budget participatif.
	 *
	 * @return the primary key of this budget participatif
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public int getPriorityOrder() {
		return model.getPriorityOrder();
	}

	/**
	 * Retourne la categorie projet du BP
	 */
	@Override
	public com.liferay.asset.kernel.model.AssetCategory getProjectCategory() {
		return model.getProjectCategory();
	}

	/**
	 * Retourne la titre du projet du BP
	 */
	@Override
	public String getProjectName() {
		return model.getProjectName();
	}

	@Override
	public String getPublicationDateFr() {
		return model.getPublicationDateFr();
	}

	/**
	 * Returns the publik ID of this budget participatif.
	 *
	 * @return the publik ID of this budget participatif
	 */
	@Override
	public String getPublikId() {
		return model.getPublikId();
	}

	/**
	 * Returns the status of this budget participatif.
	 *
	 * @return the status of this budget participatif
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this budget participatif.
	 *
	 * @return the status by user ID of this budget participatif
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this budget participatif.
	 *
	 * @return the status by user name of this budget participatif
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this budget participatif.
	 *
	 * @return the status by user uuid of this budget participatif
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this budget participatif.
	 *
	 * @return the status date of this budget participatif
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Retourne X suggestions max pour un BP
	 *
	 * @param request la requete
	 * @param nbSuggestions le nombre de suggestions.
	 * @return la liste de bp.
	 */
	@Override
	public java.util.List
		<eu.strasbourg.service.project.model.BudgetParticipatif> getSuggestions(
				javax.servlet.http.HttpServletRequest request,
				int nbSuggestions)
			throws com.liferay.portal.kernel.exception.PortalException,
				   com.liferay.portal.kernel.search.SearchException {

		return model.getSuggestions(request, nbSuggestions);
	}

	/**
	 * Returns the summary of this budget participatif.
	 *
	 * @return the summary of this budget participatif
	 */
	@Override
	public String getSummary() {
		return model.getSummary();
	}

	/**
	 * Retourne les soutiens du budget participatif
	 *
	 * @return Liste des soutiens
	 */
	@Override
	public java.util.List<eu.strasbourg.service.project.model.BudgetSupport>
		getSupports() {

		return model.getSupports();
	}

	/**
	 * Retourne les catégories 'Territoire' correspondant aux pays du budget
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getTerritoryCategories() {

		return model.getTerritoryCategories();
	}

	/**
	 * Retourne les thematiques du budget participatif (
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getThematicCategories() {

		return model.getThematicCategories();
	}

	/**
	 * Retourne la catégorie 'Thematic' du budget participatif. Si plusieurs, retourne la première de la liste
	 */
	@Override
	public com.liferay.asset.kernel.model.AssetCategory getThematicCategory() {
		return model.getThematicCategory();
	}

	/**
	 * Retourne une chaine des 'Thematics' sépararée d'un '-'
	 */
	@Override
	public String getThematicsLabel(java.util.Locale locale) {
		return model.getThematicsLabel(locale);
	}

	/**
	 * Returns the title of this budget participatif.
	 *
	 * @return the title of this budget participatif
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the user ID of this budget participatif.
	 *
	 * @return the user ID of this budget participatif
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this budget participatif.
	 *
	 * @return the user name of this budget participatif
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this budget participatif.
	 *
	 * @return the user uuid of this budget participatif
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this budget participatif.
	 *
	 * @return the uuid of this budget participatif
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the video url of this budget participatif.
	 *
	 * @return the video url of this budget participatif
	 */
	@Override
	public String getVideoUrl() {
		return model.getVideoUrl();
	}

	/**
	 * Le budget a-t-il ete evalue par l'administration ?
	 *
	 * @note : doit alors posseder l'un des statuts adequat
	 */
	@Override
	public boolean hasBeenEvaluated() {
		return model.hasBeenEvaluated();
	}

	/**
	 * A deja fait l'oeuvre d'un vote et/ou d'une decision administrative
	 */
	@Override
	public boolean hasBeenVoted() {
		return model.hasBeenVoted();
	}

	/**
	 * Returns <code>true</code> if this budget participatif is approved.
	 *
	 * @return <code>true</code> if this budget participatif is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this budget participatif is denied.
	 *
	 * @return <code>true</code> if this budget participatif is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this budget participatif is a draft.
	 *
	 * @return <code>true</code> if this budget participatif is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Peut être modifié
	 */
	@Override
	public boolean isEditable() {
		return model.isEditable();
	}

	/**
	 * Returns <code>true</code> if this budget participatif is expired.
	 *
	 * @return <code>true</code> if this budget participatif is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this budget participatif is has copyright.
	 *
	 * @return <code>true</code> if this budget participatif is has copyright; <code>false</code> otherwise
	 */
	@Override
	public boolean isHasCopyright() {
		return model.isHasCopyright();
	}

	/**
	 * Returns <code>true</code> if this budget participatif is inactive.
	 *
	 * @return <code>true</code> if this budget participatif is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this budget participatif is incomplete.
	 *
	 * @return <code>true</code> if this budget participatif is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this budget participatif is is crush.
	 *
	 * @return <code>true</code> if this budget participatif is is crush; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsCrush() {
		return model.isIsCrush();
	}

	/**
	 * Non faisable si le statut est : Non Recevable, Non faisable, Non retenu, Annulé, Suspendu, fusionné
	 */
	@Override
	public boolean isNotDoable() {
		return model.isNotDoable();
	}

	/**
	 * Returns <code>true</code> if this budget participatif is pending.
	 *
	 * @return <code>true</code> if this budget participatif is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this budget participatif is scheduled.
	 *
	 * @return <code>true</code> if this budget participatif is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
	}

	/**
	 * Est en periode et capacite de vote
	 */
	@Override
	public boolean isVotable() {
		return model.isVotable();
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
	 * Remplace le statut bp actuel par celui fournis en paramètre de la méthode
	 *
	 * @param budgetParticipatif
	 * @param status
	 */
	@Override
	public void setBPStatus(
		eu.strasbourg.service.project.model.BudgetParticipatif
			budgetParticipatif,
		eu.strasbourg.service.project.constants.ParticiperCategories status,
		long groupID) {

		model.setBPStatus(budgetParticipatif, status, groupID);
	}

	/**
	 * Sets the budget of this budget participatif.
	 *
	 * @param budget the budget of this budget participatif
	 */
	@Override
	public void setBudget(String budget) {
		model.setBudget(budget);
	}

	/**
	 * Sets the budget participatif ID of this budget participatif.
	 *
	 * @param budgetParticipatifId the budget participatif ID of this budget participatif
	 */
	@Override
	public void setBudgetParticipatifId(long budgetParticipatifId) {
		model.setBudgetParticipatifId(budgetParticipatifId);
	}

	/**
	 * Sets the budget phase ID of this budget participatif.
	 *
	 * @param budgetPhaseId the budget phase ID of this budget participatif
	 */
	@Override
	public void setBudgetPhaseId(long budgetPhaseId) {
		model.setBudgetPhaseId(budgetPhaseId);
	}

	/**
	 * Sets the citoyen adresse of this budget participatif.
	 *
	 * @param citoyenAdresse the citoyen adresse of this budget participatif
	 */
	@Override
	public void setCitoyenAdresse(String citoyenAdresse) {
		model.setCitoyenAdresse(citoyenAdresse);
	}

	/**
	 * Sets the citoyen birthday of this budget participatif.
	 *
	 * @param citoyenBirthday the citoyen birthday of this budget participatif
	 */
	@Override
	public void setCitoyenBirthday(Date citoyenBirthday) {
		model.setCitoyenBirthday(citoyenBirthday);
	}

	/**
	 * Sets the citoyen city of this budget participatif.
	 *
	 * @param citoyenCity the citoyen city of this budget participatif
	 */
	@Override
	public void setCitoyenCity(String citoyenCity) {
		model.setCitoyenCity(citoyenCity);
	}

	/**
	 * Sets the citoyen email of this budget participatif.
	 *
	 * @param citoyenEmail the citoyen email of this budget participatif
	 */
	@Override
	public void setCitoyenEmail(String citoyenEmail) {
		model.setCitoyenEmail(citoyenEmail);
	}

	/**
	 * Sets the citoyen firstname of this budget participatif.
	 *
	 * @param citoyenFirstname the citoyen firstname of this budget participatif
	 */
	@Override
	public void setCitoyenFirstname(String citoyenFirstname) {
		model.setCitoyenFirstname(citoyenFirstname);
	}

	/**
	 * Sets the citoyen lastname of this budget participatif.
	 *
	 * @param citoyenLastname the citoyen lastname of this budget participatif
	 */
	@Override
	public void setCitoyenLastname(String citoyenLastname) {
		model.setCitoyenLastname(citoyenLastname);
	}

	/**
	 * Sets the citoyen mobile of this budget participatif.
	 *
	 * @param citoyenMobile the citoyen mobile of this budget participatif
	 */
	@Override
	public void setCitoyenMobile(String citoyenMobile) {
		model.setCitoyenMobile(citoyenMobile);
	}

	/**
	 * Sets the citoyen phone of this budget participatif.
	 *
	 * @param citoyenPhone the citoyen phone of this budget participatif
	 */
	@Override
	public void setCitoyenPhone(String citoyenPhone) {
		model.setCitoyenPhone(citoyenPhone);
	}

	/**
	 * Sets the citoyen postal code of this budget participatif.
	 *
	 * @param citoyenPostalCode the citoyen postal code of this budget participatif
	 */
	@Override
	public void setCitoyenPostalCode(long citoyenPostalCode) {
		model.setCitoyenPostalCode(citoyenPostalCode);
	}

	/**
	 * Sets the company ID of this budget participatif.
	 *
	 * @param companyId the company ID of this budget participatif
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this budget participatif.
	 *
	 * @param createDate the create date of this budget participatif
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the crush comment of this budget participatif.
	 *
	 * @param crushComment the crush comment of this budget participatif
	 */
	@Override
	public void setCrushComment(String crushComment) {
		model.setCrushComment(crushComment);
	}

	/**
	 * Sets the localized crush comment of this budget participatif in the language.
	 *
	 * @param crushComment the localized crush comment of this budget participatif
	 * @param locale the locale of the language
	 */
	@Override
	public void setCrushComment(String crushComment, java.util.Locale locale) {
		model.setCrushComment(crushComment, locale);
	}

	/**
	 * Sets the localized crush comment of this budget participatif in the language, and sets the default locale.
	 *
	 * @param crushComment the localized crush comment of this budget participatif
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setCrushComment(
		String crushComment, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setCrushComment(crushComment, locale, defaultLocale);
	}

	@Override
	public void setCrushCommentCurrentLanguageId(String languageId) {
		model.setCrushCommentCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized crush comments of this budget participatif from the map of locales and localized crush comments.
	 *
	 * @param crushCommentMap the locales and localized crush comments of this budget participatif
	 */
	@Override
	public void setCrushCommentMap(
		Map<java.util.Locale, String> crushCommentMap) {

		model.setCrushCommentMap(crushCommentMap);
	}

	/**
	 * Sets the localized crush comments of this budget participatif from the map of locales and localized crush comments, and sets the default locale.
	 *
	 * @param crushCommentMap the locales and localized crush comments of this budget participatif
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setCrushCommentMap(
		Map<java.util.Locale, String> crushCommentMap,
		java.util.Locale defaultLocale) {

		model.setCrushCommentMap(crushCommentMap, defaultLocale);
	}

	/**
	 * Sets the description of this budget participatif.
	 *
	 * @param description the description of this budget participatif
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the localized description of this budget participatif in the language.
	 *
	 * @param description the localized description of this budget participatif
	 * @param locale the locale of the language
	 */
	@Override
	public void setDescription(String description, java.util.Locale locale) {
		model.setDescription(description, locale);
	}

	/**
	 * Sets the localized description of this budget participatif in the language, and sets the default locale.
	 *
	 * @param description the localized description of this budget participatif
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
	 * Sets the localized descriptions of this budget participatif from the map of locales and localized descriptions.
	 *
	 * @param descriptionMap the locales and localized descriptions of this budget participatif
	 */
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, String> descriptionMap) {

		model.setDescriptionMap(descriptionMap);
	}

	/**
	 * Sets the localized descriptions of this budget participatif from the map of locales and localized descriptions, and sets the default locale.
	 *
	 * @param descriptionMap the locales and localized descriptions of this budget participatif
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, String> descriptionMap,
		java.util.Locale defaultLocale) {

		model.setDescriptionMap(descriptionMap, defaultLocale);
	}

	/**
	 * Sets the files IDs of this budget participatif.
	 *
	 * @param filesIds the files IDs of this budget participatif
	 */
	@Override
	public void setFilesIds(String filesIds) {
		model.setFilesIds(filesIds);
	}

	/**
	 * Sets the group ID of this budget participatif.
	 *
	 * @param groupId the group ID of this budget participatif
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets whether this budget participatif is has copyright.
	 *
	 * @param hasCopyright the has copyright of this budget participatif
	 */
	@Override
	public void setHasCopyright(boolean hasCopyright) {
		model.setHasCopyright(hasCopyright);
	}

	/**
	 * Sets the image ID of this budget participatif.
	 *
	 * @param imageId the image ID of this budget participatif
	 */
	@Override
	public void setImageId(long imageId) {
		model.setImageId(imageId);
	}

	/**
	 * Sets the image timeline of this budget participatif.
	 *
	 * @param imageTimeline the image timeline of this budget participatif
	 */
	@Override
	public void setImageTimeline(long imageTimeline) {
		model.setImageTimeline(imageTimeline);
	}

	/**
	 * Sets the in the name of of this budget participatif.
	 *
	 * @param inTheNameOf the in the name of of this budget participatif
	 */
	@Override
	public void setInTheNameOf(String inTheNameOf) {
		model.setInTheNameOf(inTheNameOf);
	}

	/**
	 * Sets whether this budget participatif is is crush.
	 *
	 * @param isCrush the is crush of this budget participatif
	 */
	@Override
	public void setIsCrush(boolean isCrush) {
		model.setIsCrush(isCrush);
	}

	/**
	 * Sets the modified date of this budget participatif.
	 *
	 * @param modifiedDate the modified date of this budget participatif
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the motif of this budget participatif.
	 *
	 * @param motif the motif of this budget participatif
	 */
	@Override
	public void setMotif(String motif) {
		model.setMotif(motif);
	}

	/**
	 * Sets the localized motif of this budget participatif in the language.
	 *
	 * @param motif the localized motif of this budget participatif
	 * @param locale the locale of the language
	 */
	@Override
	public void setMotif(String motif, java.util.Locale locale) {
		model.setMotif(motif, locale);
	}

	/**
	 * Sets the localized motif of this budget participatif in the language, and sets the default locale.
	 *
	 * @param motif the localized motif of this budget participatif
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setMotif(
		String motif, java.util.Locale locale, java.util.Locale defaultLocale) {

		model.setMotif(motif, locale, defaultLocale);
	}

	@Override
	public void setMotifCurrentLanguageId(String languageId) {
		model.setMotifCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized motifs of this budget participatif from the map of locales and localized motifs.
	 *
	 * @param motifMap the locales and localized motifs of this budget participatif
	 */
	@Override
	public void setMotifMap(Map<java.util.Locale, String> motifMap) {
		model.setMotifMap(motifMap);
	}

	/**
	 * Sets the localized motifs of this budget participatif from the map of locales and localized motifs, and sets the default locale.
	 *
	 * @param motifMap the locales and localized motifs of this budget participatif
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setMotifMap(
		Map<java.util.Locale, String> motifMap,
		java.util.Locale defaultLocale) {

		model.setMotifMap(motifMap, defaultLocale);
	}

	/**
	 * Sets the opacity image of this budget participatif.
	 *
	 * @param opacityImage the opacity image of this budget participatif
	 */
	@Override
	public void setOpacityImage(double opacityImage) {
		model.setOpacityImage(opacityImage);
	}

	/**
	 * Sets the parent ID of this budget participatif.
	 *
	 * @param parentId the parent ID of this budget participatif
	 */
	@Override
	public void setParentId(long parentId) {
		model.setParentId(parentId);
	}

	/**
	 * Sets the place text area of this budget participatif.
	 *
	 * @param placeTextArea the place text area of this budget participatif
	 */
	@Override
	public void setPlaceTextArea(String placeTextArea) {
		model.setPlaceTextArea(placeTextArea);
	}

	/**
	 * Sets the primary key of this budget participatif.
	 *
	 * @param primaryKey the primary key of this budget participatif
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the publik ID of this budget participatif.
	 *
	 * @param publikId the publik ID of this budget participatif
	 */
	@Override
	public void setPublikId(String publikId) {
		model.setPublikId(publikId);
	}

	/**
	 * Sets the status of this budget participatif.
	 *
	 * @param status the status of this budget participatif
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this budget participatif.
	 *
	 * @param statusByUserId the status by user ID of this budget participatif
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this budget participatif.
	 *
	 * @param statusByUserName the status by user name of this budget participatif
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this budget participatif.
	 *
	 * @param statusByUserUuid the status by user uuid of this budget participatif
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this budget participatif.
	 *
	 * @param statusDate the status date of this budget participatif
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the summary of this budget participatif.
	 *
	 * @param summary the summary of this budget participatif
	 */
	@Override
	public void setSummary(String summary) {
		model.setSummary(summary);
	}

	/**
	 * Sets the title of this budget participatif.
	 *
	 * @param title the title of this budget participatif
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the user ID of this budget participatif.
	 *
	 * @param userId the user ID of this budget participatif
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this budget participatif.
	 *
	 * @param userName the user name of this budget participatif
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this budget participatif.
	 *
	 * @param userUuid the user uuid of this budget participatif
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this budget participatif.
	 *
	 * @param uuid the uuid of this budget participatif
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the video url of this budget participatif.
	 *
	 * @param videoUrl the video url of this budget participatif
	 */
	@Override
	public void setVideoUrl(String videoUrl) {
		model.setVideoUrl(videoUrl);
	}

	/**
	 * Retourne la version JSON de l'entité
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONObject toJSON(
		String publikUserId) {

		return model.toJSON(publikUserId);
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
	protected BudgetParticipatifWrapper wrap(
		BudgetParticipatif budgetParticipatif) {

		return new BudgetParticipatifWrapper(budgetParticipatif);
	}

}