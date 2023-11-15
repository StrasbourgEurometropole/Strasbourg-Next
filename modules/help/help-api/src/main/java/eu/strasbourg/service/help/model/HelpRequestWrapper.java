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

package eu.strasbourg.service.help.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link HelpRequest}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see HelpRequest
 * @generated
 */
public class HelpRequestWrapper
	extends BaseModelWrapper<HelpRequest>
	implements HelpRequest, ModelWrapper<HelpRequest> {

	public HelpRequestWrapper(HelpRequest helpRequest) {
		super(helpRequest);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("helpRequestId", getHelpRequestId());
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
		attributes.put("publikId", getPublikId());
		attributes.put("helpProposalId", getHelpProposalId());
		attributes.put("phoneNumber", getPhoneNumber());
		attributes.put("message", getMessage());
		attributes.put("studentCardImageId", getStudentCardImageId());
		attributes.put("agreementSigned1", isAgreementSigned1());
		attributes.put("agreementSigned2", isAgreementSigned2());
		attributes.put("agreementSigned3", isAgreementSigned3());
		attributes.put("comment", getComment());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long helpRequestId = (Long)attributes.get("helpRequestId");

		if (helpRequestId != null) {
			setHelpRequestId(helpRequestId);
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

		String publikId = (String)attributes.get("publikId");

		if (publikId != null) {
			setPublikId(publikId);
		}

		Long helpProposalId = (Long)attributes.get("helpProposalId");

		if (helpProposalId != null) {
			setHelpProposalId(helpProposalId);
		}

		String phoneNumber = (String)attributes.get("phoneNumber");

		if (phoneNumber != null) {
			setPhoneNumber(phoneNumber);
		}

		String message = (String)attributes.get("message");

		if (message != null) {
			setMessage(message);
		}

		Long studentCardImageId = (Long)attributes.get("studentCardImageId");

		if (studentCardImageId != null) {
			setStudentCardImageId(studentCardImageId);
		}

		Boolean agreementSigned1 = (Boolean)attributes.get("agreementSigned1");

		if (agreementSigned1 != null) {
			setAgreementSigned1(agreementSigned1);
		}

		Boolean agreementSigned2 = (Boolean)attributes.get("agreementSigned2");

		if (agreementSigned2 != null) {
			setAgreementSigned2(agreementSigned2);
		}

		Boolean agreementSigned3 = (Boolean)attributes.get("agreementSigned3");

		if (agreementSigned3 != null) {
			setAgreementSigned3(agreementSigned3);
		}

		String comment = (String)attributes.get("comment");

		if (comment != null) {
			setComment(comment);
		}
	}

	@Override
	public HelpRequest cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the agreement signed1 of this help request.
	 *
	 * @return the agreement signed1 of this help request
	 */
	@Override
	public boolean getAgreementSigned1() {
		return model.getAgreementSigned1();
	}

	/**
	 * Returns the agreement signed2 of this help request.
	 *
	 * @return the agreement signed2 of this help request
	 */
	@Override
	public boolean getAgreementSigned2() {
		return model.getAgreementSigned2();
	}

	/**
	 * Returns the agreement signed3 of this help request.
	 *
	 * @return the agreement signed3 of this help request
	 */
	@Override
	public boolean getAgreementSigned3() {
		return model.getAgreementSigned3();
	}

	/**
	 * Retourne l'AssetEntry rattaché a cette proposition d'aide
	 */
	@Override
	public com.liferay.asset.kernel.model.AssetEntry getAssetEntry() {
		return model.getAssetEntry();
	}

	/**
	 * Retourne l'utilisateur Publik depositaire
	 *
	 * @return
	 */
	@Override
	public eu.strasbourg.service.oidc.model.PublikUser getAuthor() {
		return model.getAuthor();
	}

	/**
	 * Retourne l'email du demandeur d'aide
	 */
	@Override
	public String getAuthorEmail() {
		return model.getAuthorEmail();
	}

	/**
	 * Retourne l'URL de l'image de l'utilisateur
	 */
	@Override
	public String getAuthorImageURL() {
		return model.getAuthorImageURL();
	}

	/**
	 * Retourne le nom de du depositaire sous forme "Truc M." ou le "Au nom de ..."
	 */
	@Override
	public String getAuthorLabel() {
		return model.getAuthorLabel();
	}

	/**
	 * Retourne le nom prenom du depositaire s'il existe
	 */
	@Override
	public String getAuthorNameLabel() {
		return model.getAuthorNameLabel();
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Renvoie la liste des AssetCategory rattachées à cette proposition d'aide (via
	 * l'assetEntry)
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCategories() {

		return model.getCategories();
	}

	/**
	 * Returns the comment of this help request.
	 *
	 * @return the comment of this help request
	 */
	@Override
	public String getComment() {
		return model.getComment();
	}

	/**
	 * Returns the localized comment of this help request in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized comment of this help request
	 */
	@Override
	public String getComment(java.util.Locale locale) {
		return model.getComment(locale);
	}

	/**
	 * Returns the localized comment of this help request in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized comment of this help request. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getComment(java.util.Locale locale, boolean useDefault) {
		return model.getComment(locale, useDefault);
	}

	/**
	 * Returns the localized comment of this help request in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized comment of this help request
	 */
	@Override
	public String getComment(String languageId) {
		return model.getComment(languageId);
	}

	/**
	 * Returns the localized comment of this help request in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized comment of this help request
	 */
	@Override
	public String getComment(String languageId, boolean useDefault) {
		return model.getComment(languageId, useDefault);
	}

	@Override
	public String getCommentCurrentLanguageId() {
		return model.getCommentCurrentLanguageId();
	}

	@Override
	public String getCommentCurrentValue() {
		return model.getCommentCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized comments of this help request.
	 *
	 * @return the locales and localized comments of this help request
	 */
	@Override
	public Map<java.util.Locale, String> getCommentMap() {
		return model.getCommentMap();
	}

	/**
	 * Returns the company ID of this help request.
	 *
	 * @return the company ID of this help request
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this help request.
	 *
	 * @return the create date of this help request
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
	 * Retourne le message d'accompagnement sans les balises et autres fioritures
	 *
	 * @return
	 */
	@Override
	public String getFormatedMessage() {
		return model.getFormatedMessage();
	}

	/**
	 * Returns the group ID of this help request.
	 *
	 * @return the group ID of this help request
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Retourne la proposition d'aide de la demande
	 *
	 * @return
	 * @throws PortalException
	 */
	@Override
	public eu.strasbourg.service.help.model.HelpProposal getHelpProposal() {
		return model.getHelpProposal();
	}

	/**
	 * Returns the help proposal ID of this help request.
	 *
	 * @return the help proposal ID of this help request
	 */
	@Override
	public long getHelpProposalId() {
		return model.getHelpProposalId();
	}

	/**
	 * Returns the help request ID of this help request.
	 *
	 * @return the help request ID of this help request
	 */
	@Override
	public long getHelpRequestId() {
		return model.getHelpRequestId();
	}

	/**
	 * Returns the message of this help request.
	 *
	 * @return the message of this help request
	 */
	@Override
	public String getMessage() {
		return model.getMessage();
	}

	/**
	 * Returns the localized message of this help request in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized message of this help request
	 */
	@Override
	public String getMessage(java.util.Locale locale) {
		return model.getMessage(locale);
	}

	/**
	 * Returns the localized message of this help request in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized message of this help request. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getMessage(java.util.Locale locale, boolean useDefault) {
		return model.getMessage(locale, useDefault);
	}

	/**
	 * Returns the localized message of this help request in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized message of this help request
	 */
	@Override
	public String getMessage(String languageId) {
		return model.getMessage(languageId);
	}

	/**
	 * Returns the localized message of this help request in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized message of this help request
	 */
	@Override
	public String getMessage(String languageId, boolean useDefault) {
		return model.getMessage(languageId, useDefault);
	}

	@Override
	public String getMessageCurrentLanguageId() {
		return model.getMessageCurrentLanguageId();
	}

	@Override
	public String getMessageCurrentValue() {
		return model.getMessageCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized messages of this help request.
	 *
	 * @return the locales and localized messages of this help request
	 */
	@Override
	public Map<java.util.Locale, String> getMessageMap() {
		return model.getMessageMap();
	}

	/**
	 * Retourne la catégorie statut moderation demande d'aide
	 */
	@Override
	public com.liferay.asset.kernel.model.AssetCategory
		getModerationStatusCategory() {

		return model.getModerationStatusCategory();
	}

	/**
	 * Retourne la class du statut de modération de la demande d'aide (
	 */
	@Override
	public String getModerationStatusClass() {
		return model.getModerationStatusClass();
	}

	/**
	 * Retourne le statut de modération de la demande d'aide
	 */
	@Override
	public String getModerationStatusTitle(java.util.Locale locale) {
		return model.getModerationStatusTitle(locale);
	}

	/**
	 * Returns the modified date of this help request.
	 *
	 * @return the modified date of this help request
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the phone number of this help request.
	 *
	 * @return the phone number of this help request
	 */
	@Override
	public String getPhoneNumber() {
		return model.getPhoneNumber();
	}

	/**
	 * Returns the primary key of this help request.
	 *
	 * @return the primary key of this help request
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the publik ID of this help request.
	 *
	 * @return the publik ID of this help request
	 */
	@Override
	public String getPublikId() {
		return model.getPublikId();
	}

	/**
	 * Returns the status of this help request.
	 *
	 * @return the status of this help request
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this help request.
	 *
	 * @return the status by user ID of this help request
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this help request.
	 *
	 * @return the status by user name of this help request
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this help request.
	 *
	 * @return the status by user uuid of this help request
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this help request.
	 *
	 * @return the status date of this help request
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the student card image ID of this help request.
	 *
	 * @return the student card image ID of this help request
	 */
	@Override
	public long getStudentCardImageId() {
		return model.getStudentCardImageId();
	}

	/**
	 * Returns the user ID of this help request.
	 *
	 * @return the user ID of this help request
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this help request.
	 *
	 * @return the user name of this help request
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this help request.
	 *
	 * @return the user uuid of this help request
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this help request.
	 *
	 * @return the uuid of this help request
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this help request is agreement signed1.
	 *
	 * @return <code>true</code> if this help request is agreement signed1; <code>false</code> otherwise
	 */
	@Override
	public boolean isAgreementSigned1() {
		return model.isAgreementSigned1();
	}

	/**
	 * Returns <code>true</code> if this help request is agreement signed2.
	 *
	 * @return <code>true</code> if this help request is agreement signed2; <code>false</code> otherwise
	 */
	@Override
	public boolean isAgreementSigned2() {
		return model.isAgreementSigned2();
	}

	/**
	 * Returns <code>true</code> if this help request is agreement signed3.
	 *
	 * @return <code>true</code> if this help request is agreement signed3; <code>false</code> otherwise
	 */
	@Override
	public boolean isAgreementSigned3() {
		return model.isAgreementSigned3();
	}

	/**
	 * Returns <code>true</code> if this help request is approved.
	 *
	 * @return <code>true</code> if this help request is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this help request is denied.
	 *
	 * @return <code>true</code> if this help request is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this help request is a draft.
	 *
	 * @return <code>true</code> if this help request is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this help request is expired.
	 *
	 * @return <code>true</code> if this help request is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this help request is inactive.
	 *
	 * @return <code>true</code> if this help request is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this help request is incomplete.
	 *
	 * @return <code>true</code> if this help request is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this help request is pending.
	 *
	 * @return <code>true</code> if this help request is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this help request is scheduled.
	 *
	 * @return <code>true</code> if this help request is scheduled; <code>false</code> otherwise
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
	 * Sets whether this help request is agreement signed1.
	 *
	 * @param agreementSigned1 the agreement signed1 of this help request
	 */
	@Override
	public void setAgreementSigned1(boolean agreementSigned1) {
		model.setAgreementSigned1(agreementSigned1);
	}

	/**
	 * Sets whether this help request is agreement signed2.
	 *
	 * @param agreementSigned2 the agreement signed2 of this help request
	 */
	@Override
	public void setAgreementSigned2(boolean agreementSigned2) {
		model.setAgreementSigned2(agreementSigned2);
	}

	/**
	 * Sets whether this help request is agreement signed3.
	 *
	 * @param agreementSigned3 the agreement signed3 of this help request
	 */
	@Override
	public void setAgreementSigned3(boolean agreementSigned3) {
		model.setAgreementSigned3(agreementSigned3);
	}

	/**
	 * Sets the comment of this help request.
	 *
	 * @param comment the comment of this help request
	 */
	@Override
	public void setComment(String comment) {
		model.setComment(comment);
	}

	/**
	 * Sets the localized comment of this help request in the language.
	 *
	 * @param comment the localized comment of this help request
	 * @param locale the locale of the language
	 */
	@Override
	public void setComment(String comment, java.util.Locale locale) {
		model.setComment(comment, locale);
	}

	/**
	 * Sets the localized comment of this help request in the language, and sets the default locale.
	 *
	 * @param comment the localized comment of this help request
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setComment(
		String comment, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setComment(comment, locale, defaultLocale);
	}

	@Override
	public void setCommentCurrentLanguageId(String languageId) {
		model.setCommentCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized comments of this help request from the map of locales and localized comments.
	 *
	 * @param commentMap the locales and localized comments of this help request
	 */
	@Override
	public void setCommentMap(Map<java.util.Locale, String> commentMap) {
		model.setCommentMap(commentMap);
	}

	/**
	 * Sets the localized comments of this help request from the map of locales and localized comments, and sets the default locale.
	 *
	 * @param commentMap the locales and localized comments of this help request
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setCommentMap(
		Map<java.util.Locale, String> commentMap,
		java.util.Locale defaultLocale) {

		model.setCommentMap(commentMap, defaultLocale);
	}

	/**
	 * Sets the company ID of this help request.
	 *
	 * @param companyId the company ID of this help request
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this help request.
	 *
	 * @param createDate the create date of this help request
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this help request.
	 *
	 * @param groupId the group ID of this help request
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the help proposal ID of this help request.
	 *
	 * @param helpProposalId the help proposal ID of this help request
	 */
	@Override
	public void setHelpProposalId(long helpProposalId) {
		model.setHelpProposalId(helpProposalId);
	}

	/**
	 * Sets the help request ID of this help request.
	 *
	 * @param helpRequestId the help request ID of this help request
	 */
	@Override
	public void setHelpRequestId(long helpRequestId) {
		model.setHelpRequestId(helpRequestId);
	}

	/**
	 * Sets the message of this help request.
	 *
	 * @param message the message of this help request
	 */
	@Override
	public void setMessage(String message) {
		model.setMessage(message);
	}

	/**
	 * Sets the localized message of this help request in the language.
	 *
	 * @param message the localized message of this help request
	 * @param locale the locale of the language
	 */
	@Override
	public void setMessage(String message, java.util.Locale locale) {
		model.setMessage(message, locale);
	}

	/**
	 * Sets the localized message of this help request in the language, and sets the default locale.
	 *
	 * @param message the localized message of this help request
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setMessage(
		String message, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setMessage(message, locale, defaultLocale);
	}

	@Override
	public void setMessageCurrentLanguageId(String languageId) {
		model.setMessageCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized messages of this help request from the map of locales and localized messages.
	 *
	 * @param messageMap the locales and localized messages of this help request
	 */
	@Override
	public void setMessageMap(Map<java.util.Locale, String> messageMap) {
		model.setMessageMap(messageMap);
	}

	/**
	 * Sets the localized messages of this help request from the map of locales and localized messages, and sets the default locale.
	 *
	 * @param messageMap the locales and localized messages of this help request
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setMessageMap(
		Map<java.util.Locale, String> messageMap,
		java.util.Locale defaultLocale) {

		model.setMessageMap(messageMap, defaultLocale);
	}

	/**
	 * Sets the modified date of this help request.
	 *
	 * @param modifiedDate the modified date of this help request
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the phone number of this help request.
	 *
	 * @param phoneNumber the phone number of this help request
	 */
	@Override
	public void setPhoneNumber(String phoneNumber) {
		model.setPhoneNumber(phoneNumber);
	}

	/**
	 * Sets the primary key of this help request.
	 *
	 * @param primaryKey the primary key of this help request
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the publik ID of this help request.
	 *
	 * @param publikId the publik ID of this help request
	 */
	@Override
	public void setPublikId(String publikId) {
		model.setPublikId(publikId);
	}

	/**
	 * Sets the status of this help request.
	 *
	 * @param status the status of this help request
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this help request.
	 *
	 * @param statusByUserId the status by user ID of this help request
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this help request.
	 *
	 * @param statusByUserName the status by user name of this help request
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this help request.
	 *
	 * @param statusByUserUuid the status by user uuid of this help request
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this help request.
	 *
	 * @param statusDate the status date of this help request
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the student card image ID of this help request.
	 *
	 * @param studentCardImageId the student card image ID of this help request
	 */
	@Override
	public void setStudentCardImageId(long studentCardImageId) {
		model.setStudentCardImageId(studentCardImageId);
	}

	/**
	 * Sets the user ID of this help request.
	 *
	 * @param userId the user ID of this help request
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this help request.
	 *
	 * @param userName the user name of this help request
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this help request.
	 *
	 * @param userUuid the user uuid of this help request
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this help request.
	 *
	 * @param uuid the uuid of this help request
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
	protected HelpRequestWrapper wrap(HelpRequest helpRequest) {
		return new HelpRequestWrapper(helpRequest);
	}

}