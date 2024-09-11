/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.help.model;

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
 * The base model interface for the HelpRequest service. Represents a row in the &quot;help_HelpRequest&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>eu.strasbourg.service.help.model.impl.HelpRequestModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>eu.strasbourg.service.help.model.impl.HelpRequestImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see HelpRequest
 * @generated
 */
@ProviderType
public interface HelpRequestModel
	extends BaseModel<HelpRequest>, GroupedModel, LocalizedModel, ShardedModel,
			StagedAuditedModel, WorkflowedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a help request model instance should use the {@link HelpRequest} interface instead.
	 */

	/**
	 * Returns the primary key of this help request.
	 *
	 * @return the primary key of this help request
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this help request.
	 *
	 * @param primaryKey the primary key of this help request
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this help request.
	 *
	 * @return the uuid of this help request
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this help request.
	 *
	 * @param uuid the uuid of this help request
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the help request ID of this help request.
	 *
	 * @return the help request ID of this help request
	 */
	public long getHelpRequestId();

	/**
	 * Sets the help request ID of this help request.
	 *
	 * @param helpRequestId the help request ID of this help request
	 */
	public void setHelpRequestId(long helpRequestId);

	/**
	 * Returns the group ID of this help request.
	 *
	 * @return the group ID of this help request
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this help request.
	 *
	 * @param groupId the group ID of this help request
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this help request.
	 *
	 * @return the company ID of this help request
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this help request.
	 *
	 * @param companyId the company ID of this help request
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this help request.
	 *
	 * @return the user ID of this help request
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this help request.
	 *
	 * @param userId the user ID of this help request
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this help request.
	 *
	 * @return the user uuid of this help request
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this help request.
	 *
	 * @param userUuid the user uuid of this help request
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this help request.
	 *
	 * @return the user name of this help request
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this help request.
	 *
	 * @param userName the user name of this help request
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this help request.
	 *
	 * @return the create date of this help request
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this help request.
	 *
	 * @param createDate the create date of this help request
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this help request.
	 *
	 * @return the modified date of this help request
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this help request.
	 *
	 * @param modifiedDate the modified date of this help request
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the status of this help request.
	 *
	 * @return the status of this help request
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this help request.
	 *
	 * @param status the status of this help request
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this help request.
	 *
	 * @return the status by user ID of this help request
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this help request.
	 *
	 * @param statusByUserId the status by user ID of this help request
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this help request.
	 *
	 * @return the status by user uuid of this help request
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this help request.
	 *
	 * @param statusByUserUuid the status by user uuid of this help request
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this help request.
	 *
	 * @return the status by user name of this help request
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this help request.
	 *
	 * @param statusByUserName the status by user name of this help request
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this help request.
	 *
	 * @return the status date of this help request
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this help request.
	 *
	 * @param statusDate the status date of this help request
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns the publik ID of this help request.
	 *
	 * @return the publik ID of this help request
	 */
	@AutoEscape
	public String getPublikId();

	/**
	 * Sets the publik ID of this help request.
	 *
	 * @param publikId the publik ID of this help request
	 */
	public void setPublikId(String publikId);

	/**
	 * Returns the help proposal ID of this help request.
	 *
	 * @return the help proposal ID of this help request
	 */
	public long getHelpProposalId();

	/**
	 * Sets the help proposal ID of this help request.
	 *
	 * @param helpProposalId the help proposal ID of this help request
	 */
	public void setHelpProposalId(long helpProposalId);

	/**
	 * Returns the phone number of this help request.
	 *
	 * @return the phone number of this help request
	 */
	@AutoEscape
	public String getPhoneNumber();

	/**
	 * Sets the phone number of this help request.
	 *
	 * @param phoneNumber the phone number of this help request
	 */
	public void setPhoneNumber(String phoneNumber);

	/**
	 * Returns the message of this help request.
	 *
	 * @return the message of this help request
	 */
	public String getMessage();

	/**
	 * Returns the localized message of this help request in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized message of this help request
	 */
	@AutoEscape
	public String getMessage(Locale locale);

	/**
	 * Returns the localized message of this help request in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized message of this help request. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getMessage(Locale locale, boolean useDefault);

	/**
	 * Returns the localized message of this help request in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized message of this help request
	 */
	@AutoEscape
	public String getMessage(String languageId);

	/**
	 * Returns the localized message of this help request in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized message of this help request
	 */
	@AutoEscape
	public String getMessage(String languageId, boolean useDefault);

	@AutoEscape
	public String getMessageCurrentLanguageId();

	@AutoEscape
	public String getMessageCurrentValue();

	/**
	 * Returns a map of the locales and localized messages of this help request.
	 *
	 * @return the locales and localized messages of this help request
	 */
	public Map<Locale, String> getMessageMap();

	/**
	 * Sets the message of this help request.
	 *
	 * @param message the message of this help request
	 */
	public void setMessage(String message);

	/**
	 * Sets the localized message of this help request in the language.
	 *
	 * @param message the localized message of this help request
	 * @param locale the locale of the language
	 */
	public void setMessage(String message, Locale locale);

	/**
	 * Sets the localized message of this help request in the language, and sets the default locale.
	 *
	 * @param message the localized message of this help request
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setMessage(String message, Locale locale, Locale defaultLocale);

	public void setMessageCurrentLanguageId(String languageId);

	/**
	 * Sets the localized messages of this help request from the map of locales and localized messages.
	 *
	 * @param messageMap the locales and localized messages of this help request
	 */
	public void setMessageMap(Map<Locale, String> messageMap);

	/**
	 * Sets the localized messages of this help request from the map of locales and localized messages, and sets the default locale.
	 *
	 * @param messageMap the locales and localized messages of this help request
	 * @param defaultLocale the default locale
	 */
	public void setMessageMap(
		Map<Locale, String> messageMap, Locale defaultLocale);

	/**
	 * Returns the student card image ID of this help request.
	 *
	 * @return the student card image ID of this help request
	 */
	public long getStudentCardImageId();

	/**
	 * Sets the student card image ID of this help request.
	 *
	 * @param studentCardImageId the student card image ID of this help request
	 */
	public void setStudentCardImageId(long studentCardImageId);

	/**
	 * Returns the agreement signed1 of this help request.
	 *
	 * @return the agreement signed1 of this help request
	 */
	public boolean getAgreementSigned1();

	/**
	 * Returns <code>true</code> if this help request is agreement signed1.
	 *
	 * @return <code>true</code> if this help request is agreement signed1; <code>false</code> otherwise
	 */
	public boolean isAgreementSigned1();

	/**
	 * Sets whether this help request is agreement signed1.
	 *
	 * @param agreementSigned1 the agreement signed1 of this help request
	 */
	public void setAgreementSigned1(boolean agreementSigned1);

	/**
	 * Returns the agreement signed2 of this help request.
	 *
	 * @return the agreement signed2 of this help request
	 */
	public boolean getAgreementSigned2();

	/**
	 * Returns <code>true</code> if this help request is agreement signed2.
	 *
	 * @return <code>true</code> if this help request is agreement signed2; <code>false</code> otherwise
	 */
	public boolean isAgreementSigned2();

	/**
	 * Sets whether this help request is agreement signed2.
	 *
	 * @param agreementSigned2 the agreement signed2 of this help request
	 */
	public void setAgreementSigned2(boolean agreementSigned2);

	/**
	 * Returns the agreement signed3 of this help request.
	 *
	 * @return the agreement signed3 of this help request
	 */
	public boolean getAgreementSigned3();

	/**
	 * Returns <code>true</code> if this help request is agreement signed3.
	 *
	 * @return <code>true</code> if this help request is agreement signed3; <code>false</code> otherwise
	 */
	public boolean isAgreementSigned3();

	/**
	 * Sets whether this help request is agreement signed3.
	 *
	 * @param agreementSigned3 the agreement signed3 of this help request
	 */
	public void setAgreementSigned3(boolean agreementSigned3);

	/**
	 * Returns the comment of this help request.
	 *
	 * @return the comment of this help request
	 */
	public String getComment();

	/**
	 * Returns the localized comment of this help request in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized comment of this help request
	 */
	@AutoEscape
	public String getComment(Locale locale);

	/**
	 * Returns the localized comment of this help request in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized comment of this help request. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getComment(Locale locale, boolean useDefault);

	/**
	 * Returns the localized comment of this help request in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized comment of this help request
	 */
	@AutoEscape
	public String getComment(String languageId);

	/**
	 * Returns the localized comment of this help request in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized comment of this help request
	 */
	@AutoEscape
	public String getComment(String languageId, boolean useDefault);

	@AutoEscape
	public String getCommentCurrentLanguageId();

	@AutoEscape
	public String getCommentCurrentValue();

	/**
	 * Returns a map of the locales and localized comments of this help request.
	 *
	 * @return the locales and localized comments of this help request
	 */
	public Map<Locale, String> getCommentMap();

	/**
	 * Sets the comment of this help request.
	 *
	 * @param comment the comment of this help request
	 */
	public void setComment(String comment);

	/**
	 * Sets the localized comment of this help request in the language.
	 *
	 * @param comment the localized comment of this help request
	 * @param locale the locale of the language
	 */
	public void setComment(String comment, Locale locale);

	/**
	 * Sets the localized comment of this help request in the language, and sets the default locale.
	 *
	 * @param comment the localized comment of this help request
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setComment(String comment, Locale locale, Locale defaultLocale);

	public void setCommentCurrentLanguageId(String languageId);

	/**
	 * Sets the localized comments of this help request from the map of locales and localized comments.
	 *
	 * @param commentMap the locales and localized comments of this help request
	 */
	public void setCommentMap(Map<Locale, String> commentMap);

	/**
	 * Sets the localized comments of this help request from the map of locales and localized comments, and sets the default locale.
	 *
	 * @param commentMap the locales and localized comments of this help request
	 * @param defaultLocale the default locale
	 */
	public void setCommentMap(
		Map<Locale, String> commentMap, Locale defaultLocale);

	/**
	 * Returns <code>true</code> if this help request is approved.
	 *
	 * @return <code>true</code> if this help request is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this help request is denied.
	 *
	 * @return <code>true</code> if this help request is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this help request is a draft.
	 *
	 * @return <code>true</code> if this help request is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this help request is expired.
	 *
	 * @return <code>true</code> if this help request is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this help request is inactive.
	 *
	 * @return <code>true</code> if this help request is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this help request is incomplete.
	 *
	 * @return <code>true</code> if this help request is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this help request is pending.
	 *
	 * @return <code>true</code> if this help request is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this help request is scheduled.
	 *
	 * @return <code>true</code> if this help request is scheduled; <code>false</code> otherwise
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
	public HelpRequest cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}