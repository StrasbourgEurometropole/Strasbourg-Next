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

package eu.strasbourg.service.formSendRecordField.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link FormSendRecordField}.
 * </p>
 *
 * @author Angélique Zunino
 * @see FormSendRecordField
 * @generated
 */
public class FormSendRecordFieldWrapper
	extends BaseModelWrapper<FormSendRecordField>
	implements FormSendRecordField, ModelWrapper<FormSendRecordField> {

	public FormSendRecordFieldWrapper(FormSendRecordField formSendRecordField) {
		super(formSendRecordField);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("formSendRecordFieldId", getFormSendRecordFieldId());
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
		attributes.put("response", getResponse());
		attributes.put("assetEntryId", getAssetEntryId());
		attributes.put("contentId", getContentId());
		attributes.put("instanceId", getInstanceId());
		attributes.put("responseUserId", getResponseUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long formSendRecordFieldId = (Long)attributes.get(
			"formSendRecordFieldId");

		if (formSendRecordFieldId != null) {
			setFormSendRecordFieldId(formSendRecordFieldId);
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

		String response = (String)attributes.get("response");

		if (response != null) {
			setResponse(response);
		}

		Long assetEntryId = (Long)attributes.get("assetEntryId");

		if (assetEntryId != null) {
			setAssetEntryId(assetEntryId);
		}

		Long contentId = (Long)attributes.get("contentId");

		if (contentId != null) {
			setContentId(contentId);
		}

		String instanceId = (String)attributes.get("instanceId");

		if (instanceId != null) {
			setInstanceId(instanceId);
		}

		Long responseUserId = (Long)attributes.get("responseUserId");

		if (responseUserId != null) {
			setResponseUserId(responseUserId);
		}
	}

	@Override
	public FormSendRecordField cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * méthode qui renvoie la liste des signalements d'une réponse.
	 *
	 * @return la liste des signalements
	 */
	@Override
	public java.util.List
		<eu.strasbourg.service.formSendRecordField.model.
			FormSendRecordFieldSignalement> findSignalements() {

		return model.findSignalements();
	}

	/**
	 * Retourne l'AssetEntry rattaché cet item
	 */
	@Override
	public com.liferay.asset.kernel.model.AssetEntry getAssetEntry() {
		return model.getAssetEntry();
	}

	/**
	 * Returns the asset entry ID of this form send record field.
	 *
	 * @return the asset entry ID of this form send record field
	 */
	@Override
	public long getAssetEntryId() {
		return model.getAssetEntryId();
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the company ID of this form send record field.
	 *
	 * @return the company ID of this form send record field
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the content ID of this form send record field.
	 *
	 * @return the content ID of this form send record field
	 */
	@Override
	public long getContentId() {
		return model.getContentId();
	}

	/**
	 * méthode qui renvoie le nombre de signalement pour un commentaire.
	 *
	 * @return le nombre de signalement en int.
	 */
	@Override
	public int getCountSignalements() {
		return model.getCountSignalements();
	}

	/**
	 * Returns the create date of this form send record field.
	 *
	 * @return the create date of this form send record field
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
	 * Returns the form send record field ID of this form send record field.
	 *
	 * @return the form send record field ID of this form send record field
	 */
	@Override
	public long getFormSendRecordFieldId() {
		return model.getFormSendRecordFieldId();
	}

	/**
	 * Returns the group ID of this form send record field.
	 *
	 * @return the group ID of this form send record field
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the instance ID of this form send record field.
	 *
	 * @return the instance ID of this form send record field
	 */
	@Override
	public String getInstanceId() {
		return model.getInstanceId();
	}

	/**
	 * Retourne la liste des likes de l'entité
	 *
	 * @see eu.strasbourg.service.like.model.LikeType
	 * @see eu.strasbourg.service.like.model.LikeType
	 */
	@Override
	public java.util.List<eu.strasbourg.service.like.model.Like> getLikes() {
		return model.getLikes();
	}

	/**
	 * Returns the modified date of this form send record field.
	 *
	 * @return the modified date of this form send record field
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
	 * @see eu.strasbourg.service.like.model.LikeType
	 * @see eu.strasbourg.service.like.model.LikeType
	 */
	@Override
	public int getNbLikes() {
		return model.getNbLikes();
	}

	/**
	 * Returns the primary key of this form send record field.
	 *
	 * @return the primary key of this form send record field
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the response of this form send record field.
	 *
	 * @return the response of this form send record field
	 */
	@Override
	public String getResponse() {
		return model.getResponse();
	}

	/**
	 * Returns the localized response of this form send record field in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized response of this form send record field
	 */
	@Override
	public String getResponse(java.util.Locale locale) {
		return model.getResponse(locale);
	}

	/**
	 * Returns the localized response of this form send record field in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized response of this form send record field. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getResponse(java.util.Locale locale, boolean useDefault) {
		return model.getResponse(locale, useDefault);
	}

	/**
	 * Returns the localized response of this form send record field in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized response of this form send record field
	 */
	@Override
	public String getResponse(String languageId) {
		return model.getResponse(languageId);
	}

	/**
	 * Returns the localized response of this form send record field in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized response of this form send record field
	 */
	@Override
	public String getResponse(String languageId, boolean useDefault) {
		return model.getResponse(languageId, useDefault);
	}

	@Override
	public String getResponseCurrentLanguageId() {
		return model.getResponseCurrentLanguageId();
	}

	@Override
	public String getResponseCurrentValue() {
		return model.getResponseCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized responses of this form send record field.
	 *
	 * @return the locales and localized responses of this form send record field
	 */
	@Override
	public Map<java.util.Locale, String> getResponseMap() {
		return model.getResponseMap();
	}

	/**
	 * Returns the response user ID of this form send record field.
	 *
	 * @return the response user ID of this form send record field
	 */
	@Override
	public long getResponseUserId() {
		return model.getResponseUserId();
	}

	/**
	 * Returns the response user uuid of this form send record field.
	 *
	 * @return the response user uuid of this form send record field
	 */
	@Override
	public String getResponseUserUuid() {
		return model.getResponseUserUuid();
	}

	/**
	 * Returns the status of this form send record field.
	 *
	 * @return the status of this form send record field
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this form send record field.
	 *
	 * @return the status by user ID of this form send record field
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this form send record field.
	 *
	 * @return the status by user name of this form send record field
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this form send record field.
	 *
	 * @return the status by user uuid of this form send record field
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this form send record field.
	 *
	 * @return the status date of this form send record field
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the user ID of this form send record field.
	 *
	 * @return the user ID of this form send record field
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this form send record field.
	 *
	 * @return the user name of this form send record field
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this form send record field.
	 *
	 * @return the user uuid of this form send record field
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this form send record field.
	 *
	 * @return the uuid of this form send record field
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this form send record field is approved.
	 *
	 * @return <code>true</code> if this form send record field is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this form send record field is denied.
	 *
	 * @return <code>true</code> if this form send record field is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this form send record field is a draft.
	 *
	 * @return <code>true</code> if this form send record field is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this form send record field is expired.
	 *
	 * @return <code>true</code> if this form send record field is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this form send record field is inactive.
	 *
	 * @return <code>true</code> if this form send record field is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this form send record field is incomplete.
	 *
	 * @return <code>true</code> if this form send record field is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this form send record field is pending.
	 *
	 * @return <code>true</code> if this form send record field is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this form send record field is scheduled.
	 *
	 * @return <code>true</code> if this form send record field is scheduled; <code>false</code> otherwise
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
	 * Sets the asset entry ID of this form send record field.
	 *
	 * @param assetEntryId the asset entry ID of this form send record field
	 */
	@Override
	public void setAssetEntryId(long assetEntryId) {
		model.setAssetEntryId(assetEntryId);
	}

	/**
	 * Sets the company ID of this form send record field.
	 *
	 * @param companyId the company ID of this form send record field
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the content ID of this form send record field.
	 *
	 * @param contentId the content ID of this form send record field
	 */
	@Override
	public void setContentId(long contentId) {
		model.setContentId(contentId);
	}

	/**
	 * Sets the create date of this form send record field.
	 *
	 * @param createDate the create date of this form send record field
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the form send record field ID of this form send record field.
	 *
	 * @param formSendRecordFieldId the form send record field ID of this form send record field
	 */
	@Override
	public void setFormSendRecordFieldId(long formSendRecordFieldId) {
		model.setFormSendRecordFieldId(formSendRecordFieldId);
	}

	/**
	 * Sets the group ID of this form send record field.
	 *
	 * @param groupId the group ID of this form send record field
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the instance ID of this form send record field.
	 *
	 * @param instanceId the instance ID of this form send record field
	 */
	@Override
	public void setInstanceId(String instanceId) {
		model.setInstanceId(instanceId);
	}

	/**
	 * Sets the modified date of this form send record field.
	 *
	 * @param modifiedDate the modified date of this form send record field
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this form send record field.
	 *
	 * @param primaryKey the primary key of this form send record field
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the response of this form send record field.
	 *
	 * @param response the response of this form send record field
	 */
	@Override
	public void setResponse(String response) {
		model.setResponse(response);
	}

	/**
	 * Sets the localized response of this form send record field in the language.
	 *
	 * @param response the localized response of this form send record field
	 * @param locale the locale of the language
	 */
	@Override
	public void setResponse(String response, java.util.Locale locale) {
		model.setResponse(response, locale);
	}

	/**
	 * Sets the localized response of this form send record field in the language, and sets the default locale.
	 *
	 * @param response the localized response of this form send record field
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setResponse(
		String response, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setResponse(response, locale, defaultLocale);
	}

	@Override
	public void setResponseCurrentLanguageId(String languageId) {
		model.setResponseCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized responses of this form send record field from the map of locales and localized responses.
	 *
	 * @param responseMap the locales and localized responses of this form send record field
	 */
	@Override
	public void setResponseMap(Map<java.util.Locale, String> responseMap) {
		model.setResponseMap(responseMap);
	}

	/**
	 * Sets the localized responses of this form send record field from the map of locales and localized responses, and sets the default locale.
	 *
	 * @param responseMap the locales and localized responses of this form send record field
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setResponseMap(
		Map<java.util.Locale, String> responseMap,
		java.util.Locale defaultLocale) {

		model.setResponseMap(responseMap, defaultLocale);
	}

	/**
	 * Sets the response user ID of this form send record field.
	 *
	 * @param responseUserId the response user ID of this form send record field
	 */
	@Override
	public void setResponseUserId(long responseUserId) {
		model.setResponseUserId(responseUserId);
	}

	/**
	 * Sets the response user uuid of this form send record field.
	 *
	 * @param responseUserUuid the response user uuid of this form send record field
	 */
	@Override
	public void setResponseUserUuid(String responseUserUuid) {
		model.setResponseUserUuid(responseUserUuid);
	}

	/**
	 * Sets the status of this form send record field.
	 *
	 * @param status the status of this form send record field
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this form send record field.
	 *
	 * @param statusByUserId the status by user ID of this form send record field
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this form send record field.
	 *
	 * @param statusByUserName the status by user name of this form send record field
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this form send record field.
	 *
	 * @param statusByUserUuid the status by user uuid of this form send record field
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this form send record field.
	 *
	 * @param statusDate the status date of this form send record field
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the user ID of this form send record field.
	 *
	 * @param userId the user ID of this form send record field
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this form send record field.
	 *
	 * @param userName the user name of this form send record field
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this form send record field.
	 *
	 * @param userUuid the user uuid of this form send record field
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this form send record field.
	 *
	 * @param uuid the uuid of this form send record field
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
	protected FormSendRecordFieldWrapper wrap(
		FormSendRecordField formSendRecordField) {

		return new FormSendRecordFieldWrapper(formSendRecordField);
	}

}