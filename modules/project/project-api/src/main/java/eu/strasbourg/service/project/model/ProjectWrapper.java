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

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Project}.
 * </p>
 *
 * @author Cedric Henry
 * @see Project
 * @generated
 */
public class ProjectWrapper
	extends BaseModelWrapper<Project>
	implements ModelWrapper<Project>, Project {

	public ProjectWrapper(Project project) {
		super(project);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("projectId", getProjectId());
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
		attributes.put("externalImageURL", getExternalImageURL());
		attributes.put("externalImageCopyright", getExternalImageCopyright());
		attributes.put("opacityImage", getOpacityImage());
		attributes.put("description", getDescription());
		attributes.put("detailURL", getDetailURL());
		attributes.put("budget", getBudget());
		attributes.put("label", getLabel());
		attributes.put("duration", getDuration());
		attributes.put("partners", getPartners());
		attributes.put("contactName", getContactName());
		attributes.put("contactLine1", getContactLine1());
		attributes.put("contactLine2", getContactLine2());
		attributes.put("contactPhoneNumber", getContactPhoneNumber());
		attributes.put("imageId", getImageId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
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

		String externalImageURL = (String)attributes.get("externalImageURL");

		if (externalImageURL != null) {
			setExternalImageURL(externalImageURL);
		}

		String externalImageCopyright = (String)attributes.get(
			"externalImageCopyright");

		if (externalImageCopyright != null) {
			setExternalImageCopyright(externalImageCopyright);
		}

		Double opacityImage = (Double)attributes.get("opacityImage");

		if (opacityImage != null) {
			setOpacityImage(opacityImage);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String detailURL = (String)attributes.get("detailURL");

		if (detailURL != null) {
			setDetailURL(detailURL);
		}

		String budget = (String)attributes.get("budget");

		if (budget != null) {
			setBudget(budget);
		}

		String label = (String)attributes.get("label");

		if (label != null) {
			setLabel(label);
		}

		String duration = (String)attributes.get("duration");

		if (duration != null) {
			setDuration(duration);
		}

		String partners = (String)attributes.get("partners");

		if (partners != null) {
			setPartners(partners);
		}

		String contactName = (String)attributes.get("contactName");

		if (contactName != null) {
			setContactName(contactName);
		}

		String contactLine1 = (String)attributes.get("contactLine1");

		if (contactLine1 != null) {
			setContactLine1(contactLine1);
		}

		String contactLine2 = (String)attributes.get("contactLine2");

		if (contactLine2 != null) {
			setContactLine2(contactLine2);
		}

		String contactPhoneNumber = (String)attributes.get(
			"contactPhoneNumber");

		if (contactPhoneNumber != null) {
			setContactPhoneNumber(contactPhoneNumber);
		}

		Long imageId = (Long)attributes.get("imageId");

		if (imageId != null) {
			setImageId(imageId);
		}
	}

	@Override
	public Project cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Retourne les statuts du projet
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getAllStatus() {

		return model.getAllStatus();
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

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the budget of this project.
	 *
	 * @return the budget of this project
	 */
	@Override
	public String getBudget() {
		return model.getBudget();
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
	 * Retourne les sous-catégories 'Territoire' correspondant aux villes du projet
	 *
	 * @return : la liste des catégories
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCityCategories() {

		return model.getCityCategories();
	}

	/**
	 * Returns the company ID of this project.
	 *
	 * @return the company ID of this project
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the contact line1 of this project.
	 *
	 * @return the contact line1 of this project
	 */
	@Override
	public String getContactLine1() {
		return model.getContactLine1();
	}

	/**
	 * Returns the contact line2 of this project.
	 *
	 * @return the contact line2 of this project
	 */
	@Override
	public String getContactLine2() {
		return model.getContactLine2();
	}

	/**
	 * Returns the contact name of this project.
	 *
	 * @return the contact name of this project
	 */
	@Override
	public String getContactName() {
		return model.getContactName();
	}

	/**
	 * Returns the contact phone number of this project.
	 *
	 * @return the contact phone number of this project
	 */
	@Override
	public String getContactPhoneNumber() {
		return model.getContactPhoneNumber();
	}

	/**
	 * Returns the create date of this project.
	 *
	 * @return the create date of this project
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
	 * Returns the description of this project.
	 *
	 * @return the description of this project
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the localized description of this project in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description of this project
	 */
	@Override
	public String getDescription(java.util.Locale locale) {
		return model.getDescription(locale);
	}

	/**
	 * Returns the localized description of this project in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this project. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getDescription(java.util.Locale locale, boolean useDefault) {
		return model.getDescription(locale, useDefault);
	}

	/**
	 * Returns the localized description of this project in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description of this project
	 */
	@Override
	public String getDescription(String languageId) {
		return model.getDescription(languageId);
	}

	/**
	 * Returns the localized description of this project in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this project
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
	 * Returns a map of the locales and localized descriptions of this project.
	 *
	 * @return the locales and localized descriptions of this project
	 */
	@Override
	public Map<java.util.Locale, String> getDescriptionMap() {
		return model.getDescriptionMap();
	}

	/**
	 * Returns the detail url of this project.
	 *
	 * @return the detail url of this project
	 */
	@Override
	public String getDetailURL() {
		return model.getDetailURL();
	}

	/**
	 * Retourne les sous-sous-catégories 'Territoire' correspondant aux quartiers du projet
	 *
	 * @return : la liste des catégories
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getDistrictCategories() {

		return model.getDistrictCategories();
	}

	/**
	 * Retourne une chaine des 'Territoires' correspondant aux quartiers du projet
	 *
	 * @return : Chaine des quartiers ou description "Aucun" ou "Tous"
	 */
	@Override
	public String getDistrictLabel(java.util.Locale locale) {
		return model.getDistrictLabel(locale);
	}

	/**
	 * Returns the duration of this project.
	 *
	 * @return the duration of this project
	 */
	@Override
	public String getDuration() {
		return model.getDuration();
	}

	/**
	 * Retourne la liste des évènements du projet
	 */
	@Override
	public java.util.List<eu.strasbourg.service.agenda.model.Event>
		getEvents() {

		return model.getEvents();
	}

	/**
	 * Returns the external image copyright of this project.
	 *
	 * @return the external image copyright of this project
	 */
	@Override
	public String getExternalImageCopyright() {
		return model.getExternalImageCopyright();
	}

	/**
	 * Returns the external image url of this project.
	 *
	 * @return the external image url of this project
	 */
	@Override
	public String getExternalImageURL() {
		return model.getExternalImageURL();
	}

	/**
	 * Returns the group ID of this project.
	 *
	 * @return the group ID of this project
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
	 * Returns the image ID of this project.
	 *
	 * @return the image ID of this project
	 */
	@Override
	public long getImageId() {
		return model.getImageId();
	}

	/**
	 * Retourne l'URL de l'image à partir de l'id du DLFileEntry
	 */
	@Override
	public String getImageURL() {
		return model.getImageURL();
	}

	/**
	 * Returns the label of this project.
	 *
	 * @return the label of this project
	 */
	@Override
	public String getLabel() {
		return model.getLabel();
	}

	/**
	 * Returns the modified date of this project.
	 *
	 * @return the modified date of this project
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Retourne le nombre de commentaires de l'entité
	 */
	@Override
	public int getNbApprovedComments() {
		return model.getNbApprovedComments();
	}

	/**
	 * Retourne le nombre de follower au projet
	 */
	@Override
	public int getNbFollower() {
		return model.getNbFollower();
	}

	/**
	 * Retourne le label de 5 digits du nombre de follower au projet
	 */
	@Override
	public String getNbFollowerLabel() {
		return model.getNbFollowerLabel();
	}

	/**
	 * Returns the opacity image of this project.
	 *
	 * @return the opacity image of this project
	 */
	@Override
	public double getOpacityImage() {
		return model.getOpacityImage();
	}

	/**
	 * Retourne la liste des participations du projet
	 */
	@Override
	public java.util.List<eu.strasbourg.service.project.model.Participation>
		getParticipations() {

		return model.getParticipations();
	}

	/**
	 * Returns the partners of this project.
	 *
	 * @return the partners of this project
	 */
	@Override
	public String getPartners() {
		return model.getPartners();
	}

	/**
	 * Returns the localized partners of this project in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized partners of this project
	 */
	@Override
	public String getPartners(java.util.Locale locale) {
		return model.getPartners(locale);
	}

	/**
	 * Returns the localized partners of this project in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized partners of this project. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getPartners(java.util.Locale locale, boolean useDefault) {
		return model.getPartners(locale, useDefault);
	}

	/**
	 * Returns the localized partners of this project in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized partners of this project
	 */
	@Override
	public String getPartners(String languageId) {
		return model.getPartners(languageId);
	}

	/**
	 * Returns the localized partners of this project in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized partners of this project
	 */
	@Override
	public String getPartners(String languageId, boolean useDefault) {
		return model.getPartners(languageId, useDefault);
	}

	@Override
	public String getPartnersCurrentLanguageId() {
		return model.getPartnersCurrentLanguageId();
	}

	@Override
	public String getPartnersCurrentValue() {
		return model.getPartnersCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized partnerses of this project.
	 *
	 * @return the locales and localized partnerses of this project
	 */
	@Override
	public Map<java.util.Locale, String> getPartnersMap() {
		return model.getPartnersMap();
	}

	@Override
	public java.util.List<eu.strasbourg.service.project.model.Petition>
		getPetitions() {

		return model.getPetitions();
	}

	/**
	 * Retourne les noms des lieux placit au projet
	 */
	@Override
	public java.util.List<String> getPlaceNames(java.util.Locale locale) {
		return model.getPlaceNames(locale);
	}

	/**
	 * Retourne les ids SIG des lieux placit au projet
	 */
	@Override
	public java.util.List<String> getPlaceSIGIds(java.util.Locale locale) {
		return model.getPlaceSIGIds(locale);
	}

	/**
	 * Retourne la liste des lieux placit liés au projet
	 */
	@Override
	public java.util.List<eu.strasbourg.service.project.model.PlacitPlace>
		getPlacitPlaces() {

		return model.getPlacitPlaces();
	}

	/**
	 * Returns the primary key of this project.
	 *
	 * @return the primary key of this project
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Retourne l'asset category du projet (normalement du même non que le projet)
	 */
	@Override
	public com.liferay.asset.kernel.model.AssetCategory getProjectCategory() {
		return model.getProjectCategory();
	}

	/**
	 * Retourne la liste des follower au projet
	 */
	@Override
	public java.util.List<eu.strasbourg.service.project.model.ProjectFollowed>
		getProjectFollower() {

		return model.getProjectFollower();
	}

	/**
	 * Returns the project ID of this project.
	 *
	 * @return the project ID of this project
	 */
	@Override
	public long getProjectId() {
		return model.getProjectId();
	}

	@Override
	public String getProjectStatus(java.util.Locale locale) {
		return model.getProjectStatus(locale);
	}

	/**
	 * Retourne la liste des entrées timelines du projet
	 */
	@Override
	public java.util.List<eu.strasbourg.service.project.model.ProjectTimeline>
		getProjectTimelines() {

		return model.getProjectTimelines();
	}

	/**
	 * Returns the status of this project.
	 *
	 * @return the status of this project
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this project.
	 *
	 * @return the status by user ID of this project
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this project.
	 *
	 * @return the status by user name of this project
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this project.
	 *
	 * @return the status by user uuid of this project
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this project.
	 *
	 * @return the status date of this project
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Retourne les catégories 'Territoire' correspondant aux pays du projet
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getTerritoryCategories() {

		return model.getTerritoryCategories();
	}

	/**
	 * Retourne les thematiques du projet
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getThematicCategories() {

		return model.getThematicCategories();
	}

	/**
	 * Retourne une chaine des 'Thematics' sépararée d'un '-'
	 */
	@Override
	public String getThematicsLabel(java.util.Locale locale) {
		return model.getThematicsLabel(locale);
	}

	/**
	 * Returns the title of this project.
	 *
	 * @return the title of this project
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the user ID of this project.
	 *
	 * @return the user ID of this project
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this project.
	 *
	 * @return the user name of this project
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this project.
	 *
	 * @return the user uuid of this project
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this project.
	 *
	 * @return the uuid of this project
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this project is approved.
	 *
	 * @return <code>true</code> if this project is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this project is denied.
	 *
	 * @return <code>true</code> if this project is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this project is a draft.
	 *
	 * @return <code>true</code> if this project is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this project is expired.
	 *
	 * @return <code>true</code> if this project is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this project is inactive.
	 *
	 * @return <code>true</code> if this project is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this project is incomplete.
	 *
	 * @return <code>true</code> if this project is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this project is pending.
	 *
	 * @return <code>true</code> if this project is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this project is scheduled.
	 *
	 * @return <code>true</code> if this project is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
	}

	/**
	 * Demande si l'utilisateur demandé suit le projet
	 */
	@Override
	public boolean isUserFollows(String publikUserId) {
		return model.isUserFollows(publikUserId);
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
	 * Sets the budget of this project.
	 *
	 * @param budget the budget of this project
	 */
	@Override
	public void setBudget(String budget) {
		model.setBudget(budget);
	}

	/**
	 * Sets the company ID of this project.
	 *
	 * @param companyId the company ID of this project
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the contact line1 of this project.
	 *
	 * @param contactLine1 the contact line1 of this project
	 */
	@Override
	public void setContactLine1(String contactLine1) {
		model.setContactLine1(contactLine1);
	}

	/**
	 * Sets the contact line2 of this project.
	 *
	 * @param contactLine2 the contact line2 of this project
	 */
	@Override
	public void setContactLine2(String contactLine2) {
		model.setContactLine2(contactLine2);
	}

	/**
	 * Sets the contact name of this project.
	 *
	 * @param contactName the contact name of this project
	 */
	@Override
	public void setContactName(String contactName) {
		model.setContactName(contactName);
	}

	/**
	 * Sets the contact phone number of this project.
	 *
	 * @param contactPhoneNumber the contact phone number of this project
	 */
	@Override
	public void setContactPhoneNumber(String contactPhoneNumber) {
		model.setContactPhoneNumber(contactPhoneNumber);
	}

	/**
	 * Sets the create date of this project.
	 *
	 * @param createDate the create date of this project
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this project.
	 *
	 * @param description the description of this project
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the localized description of this project in the language.
	 *
	 * @param description the localized description of this project
	 * @param locale the locale of the language
	 */
	@Override
	public void setDescription(String description, java.util.Locale locale) {
		model.setDescription(description, locale);
	}

	/**
	 * Sets the localized description of this project in the language, and sets the default locale.
	 *
	 * @param description the localized description of this project
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
	 * Sets the localized descriptions of this project from the map of locales and localized descriptions.
	 *
	 * @param descriptionMap the locales and localized descriptions of this project
	 */
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, String> descriptionMap) {

		model.setDescriptionMap(descriptionMap);
	}

	/**
	 * Sets the localized descriptions of this project from the map of locales and localized descriptions, and sets the default locale.
	 *
	 * @param descriptionMap the locales and localized descriptions of this project
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, String> descriptionMap,
		java.util.Locale defaultLocale) {

		model.setDescriptionMap(descriptionMap, defaultLocale);
	}

	/**
	 * Sets the detail url of this project.
	 *
	 * @param detailURL the detail url of this project
	 */
	@Override
	public void setDetailURL(String detailURL) {
		model.setDetailURL(detailURL);
	}

	/**
	 * Sets the duration of this project.
	 *
	 * @param duration the duration of this project
	 */
	@Override
	public void setDuration(String duration) {
		model.setDuration(duration);
	}

	/**
	 * Sets the external image copyright of this project.
	 *
	 * @param externalImageCopyright the external image copyright of this project
	 */
	@Override
	public void setExternalImageCopyright(String externalImageCopyright) {
		model.setExternalImageCopyright(externalImageCopyright);
	}

	/**
	 * Sets the external image url of this project.
	 *
	 * @param externalImageURL the external image url of this project
	 */
	@Override
	public void setExternalImageURL(String externalImageURL) {
		model.setExternalImageURL(externalImageURL);
	}

	/**
	 * Sets the group ID of this project.
	 *
	 * @param groupId the group ID of this project
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the image ID of this project.
	 *
	 * @param imageId the image ID of this project
	 */
	@Override
	public void setImageId(long imageId) {
		model.setImageId(imageId);
	}

	/**
	 * Sets the label of this project.
	 *
	 * @param label the label of this project
	 */
	@Override
	public void setLabel(String label) {
		model.setLabel(label);
	}

	/**
	 * Sets the modified date of this project.
	 *
	 * @param modifiedDate the modified date of this project
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the opacity image of this project.
	 *
	 * @param opacityImage the opacity image of this project
	 */
	@Override
	public void setOpacityImage(double opacityImage) {
		model.setOpacityImage(opacityImage);
	}

	/**
	 * Sets the partners of this project.
	 *
	 * @param partners the partners of this project
	 */
	@Override
	public void setPartners(String partners) {
		model.setPartners(partners);
	}

	/**
	 * Sets the localized partners of this project in the language.
	 *
	 * @param partners the localized partners of this project
	 * @param locale the locale of the language
	 */
	@Override
	public void setPartners(String partners, java.util.Locale locale) {
		model.setPartners(partners, locale);
	}

	/**
	 * Sets the localized partners of this project in the language, and sets the default locale.
	 *
	 * @param partners the localized partners of this project
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setPartners(
		String partners, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setPartners(partners, locale, defaultLocale);
	}

	@Override
	public void setPartnersCurrentLanguageId(String languageId) {
		model.setPartnersCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized partnerses of this project from the map of locales and localized partnerses.
	 *
	 * @param partnersMap the locales and localized partnerses of this project
	 */
	@Override
	public void setPartnersMap(Map<java.util.Locale, String> partnersMap) {
		model.setPartnersMap(partnersMap);
	}

	/**
	 * Sets the localized partnerses of this project from the map of locales and localized partnerses, and sets the default locale.
	 *
	 * @param partnersMap the locales and localized partnerses of this project
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setPartnersMap(
		Map<java.util.Locale, String> partnersMap,
		java.util.Locale defaultLocale) {

		model.setPartnersMap(partnersMap, defaultLocale);
	}

	/**
	 * Sets the primary key of this project.
	 *
	 * @param primaryKey the primary key of this project
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the project ID of this project.
	 *
	 * @param projectId the project ID of this project
	 */
	@Override
	public void setProjectId(long projectId) {
		model.setProjectId(projectId);
	}

	/**
	 * Sets the status of this project.
	 *
	 * @param status the status of this project
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this project.
	 *
	 * @param statusByUserId the status by user ID of this project
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this project.
	 *
	 * @param statusByUserName the status by user name of this project
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this project.
	 *
	 * @param statusByUserUuid the status by user uuid of this project
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this project.
	 *
	 * @param statusDate the status date of this project
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the title of this project.
	 *
	 * @param title the title of this project
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the user ID of this project.
	 *
	 * @param userId the user ID of this project
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this project.
	 *
	 * @param userName the user name of this project
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this project.
	 *
	 * @param userUuid the user uuid of this project
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this project.
	 *
	 * @param uuid the uuid of this project
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
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
	protected ProjectWrapper wrap(Project project) {
		return new ProjectWrapper(project);
	}

}