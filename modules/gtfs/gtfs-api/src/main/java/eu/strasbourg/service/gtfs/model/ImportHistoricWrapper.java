/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ImportHistoric}.
 * </p>
 *
 * @author Cedric Henry
 * @see ImportHistoric
 * @generated
 */
public class ImportHistoricWrapper
	extends BaseModelWrapper<ImportHistoric>
	implements ImportHistoric, ModelWrapper<ImportHistoric> {

	public ImportHistoricWrapper(ImportHistoric importHistoric) {
		super(importHistoric);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("importHistoricId", getImportHistoricId());
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
		attributes.put("result", getResult());
		attributes.put("operations", getOperations());
		attributes.put("errorDescription", getErrorDescription());
		attributes.put("errorStackTrace", getErrorStackTrace());
		attributes.put("startDate", getStartDate());
		attributes.put("finishDate", getFinishDate());
		attributes.put("gtfsFileHash", getGtfsFileHash());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long importHistoricId = (Long)attributes.get("importHistoricId");

		if (importHistoricId != null) {
			setImportHistoricId(importHistoricId);
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

		Integer result = (Integer)attributes.get("result");

		if (result != null) {
			setResult(result);
		}

		String operations = (String)attributes.get("operations");

		if (operations != null) {
			setOperations(operations);
		}

		String errorDescription = (String)attributes.get("errorDescription");

		if (errorDescription != null) {
			setErrorDescription(errorDescription);
		}

		String errorStackTrace = (String)attributes.get("errorStackTrace");

		if (errorStackTrace != null) {
			setErrorStackTrace(errorStackTrace);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date finishDate = (Date)attributes.get("finishDate");

		if (finishDate != null) {
			setFinishDate(finishDate);
		}

		String gtfsFileHash = (String)attributes.get("gtfsFileHash");

		if (gtfsFileHash != null) {
			setGtfsFileHash(gtfsFileHash);
		}
	}

	/**
	 * Ajout d'une ligne dans le resultat de l'import
	 *
	 * @return
	 */
	@Override
	public void addNewOperation(String operation) {
		model.addNewOperation(operation);
	}

	@Override
	public ImportHistoric cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
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
	 * Renvoie la liste des AssetCategory rattachées à cet item (via
	 * l'assetEntry)
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCategories() {

		return model.getCategories();
	}

	/**
	 * Returns the company ID of this import historic.
	 *
	 * @return the company ID of this import historic
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this import historic.
	 *
	 * @return the create date of this import historic
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
	 * Returns the error description of this import historic.
	 *
	 * @return the error description of this import historic
	 */
	@Override
	public String getErrorDescription() {
		return model.getErrorDescription();
	}

	/**
	 * Returns the localized error description of this import historic in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized error description of this import historic
	 */
	@Override
	public String getErrorDescription(java.util.Locale locale) {
		return model.getErrorDescription(locale);
	}

	/**
	 * Returns the localized error description of this import historic in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized error description of this import historic. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getErrorDescription(
		java.util.Locale locale, boolean useDefault) {

		return model.getErrorDescription(locale, useDefault);
	}

	/**
	 * Returns the localized error description of this import historic in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized error description of this import historic
	 */
	@Override
	public String getErrorDescription(String languageId) {
		return model.getErrorDescription(languageId);
	}

	/**
	 * Returns the localized error description of this import historic in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized error description of this import historic
	 */
	@Override
	public String getErrorDescription(String languageId, boolean useDefault) {
		return model.getErrorDescription(languageId, useDefault);
	}

	@Override
	public String getErrorDescriptionCurrentLanguageId() {
		return model.getErrorDescriptionCurrentLanguageId();
	}

	@Override
	public String getErrorDescriptionCurrentValue() {
		return model.getErrorDescriptionCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized error descriptions of this import historic.
	 *
	 * @return the locales and localized error descriptions of this import historic
	 */
	@Override
	public Map<java.util.Locale, String> getErrorDescriptionMap() {
		return model.getErrorDescriptionMap();
	}

	/**
	 * Returns the error stack trace of this import historic.
	 *
	 * @return the error stack trace of this import historic
	 */
	@Override
	public String getErrorStackTrace() {
		return model.getErrorStackTrace();
	}

	/**
	 * Returns the localized error stack trace of this import historic in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized error stack trace of this import historic
	 */
	@Override
	public String getErrorStackTrace(java.util.Locale locale) {
		return model.getErrorStackTrace(locale);
	}

	/**
	 * Returns the localized error stack trace of this import historic in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized error stack trace of this import historic. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getErrorStackTrace(
		java.util.Locale locale, boolean useDefault) {

		return model.getErrorStackTrace(locale, useDefault);
	}

	/**
	 * Returns the localized error stack trace of this import historic in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized error stack trace of this import historic
	 */
	@Override
	public String getErrorStackTrace(String languageId) {
		return model.getErrorStackTrace(languageId);
	}

	/**
	 * Returns the localized error stack trace of this import historic in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized error stack trace of this import historic
	 */
	@Override
	public String getErrorStackTrace(String languageId, boolean useDefault) {
		return model.getErrorStackTrace(languageId, useDefault);
	}

	@Override
	public String getErrorStackTraceCurrentLanguageId() {
		return model.getErrorStackTraceCurrentLanguageId();
	}

	@Override
	public String getErrorStackTraceCurrentValue() {
		return model.getErrorStackTraceCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized error stack traces of this import historic.
	 *
	 * @return the locales and localized error stack traces of this import historic
	 */
	@Override
	public Map<java.util.Locale, String> getErrorStackTraceMap() {
		return model.getErrorStackTraceMap();
	}

	/**
	 * Returns the finish date of this import historic.
	 *
	 * @return the finish date of this import historic
	 */
	@Override
	public Date getFinishDate() {
		return model.getFinishDate();
	}

	/**
	 * Returns the group ID of this import historic.
	 *
	 * @return the group ID of this import historic
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the gtfs file hash of this import historic.
	 *
	 * @return the gtfs file hash of this import historic
	 */
	@Override
	public String getGtfsFileHash() {
		return model.getGtfsFileHash();
	}

	/**
	 * Returns the import historic ID of this import historic.
	 *
	 * @return the import historic ID of this import historic
	 */
	@Override
	public long getImportHistoricId() {
		return model.getImportHistoricId();
	}

	/**
	 * Returns the modified date of this import historic.
	 *
	 * @return the modified date of this import historic
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the operations of this import historic.
	 *
	 * @return the operations of this import historic
	 */
	@Override
	public String getOperations() {
		return model.getOperations();
	}

	/**
	 * Returns the localized operations of this import historic in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized operations of this import historic
	 */
	@Override
	public String getOperations(java.util.Locale locale) {
		return model.getOperations(locale);
	}

	/**
	 * Returns the localized operations of this import historic in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized operations of this import historic. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getOperations(java.util.Locale locale, boolean useDefault) {
		return model.getOperations(locale, useDefault);
	}

	/**
	 * Returns the localized operations of this import historic in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized operations of this import historic
	 */
	@Override
	public String getOperations(String languageId) {
		return model.getOperations(languageId);
	}

	/**
	 * Returns the localized operations of this import historic in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized operations of this import historic
	 */
	@Override
	public String getOperations(String languageId, boolean useDefault) {
		return model.getOperations(languageId, useDefault);
	}

	@Override
	public String getOperationsCurrentLanguageId() {
		return model.getOperationsCurrentLanguageId();
	}

	@Override
	public String getOperationsCurrentValue() {
		return model.getOperationsCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized operationses of this import historic.
	 *
	 * @return the locales and localized operationses of this import historic
	 */
	@Override
	public Map<java.util.Locale, String> getOperationsMap() {
		return model.getOperationsMap();
	}

	/**
	 * Returns the primary key of this import historic.
	 *
	 * @return the primary key of this import historic
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the result of this import historic.
	 *
	 * @return the result of this import historic
	 */
	@Override
	public int getResult() {
		return model.getResult();
	}

	/**
	 * Renvoie le label affichable du resultat de l'import
	 *
	 * @return
	 */
	@Override
	public String getResultLabel() {
		return model.getResultLabel();
	}

	/**
	 * Returns the start date of this import historic.
	 *
	 * @return the start date of this import historic
	 */
	@Override
	public Date getStartDate() {
		return model.getStartDate();
	}

	/**
	 * Returns the status of this import historic.
	 *
	 * @return the status of this import historic
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this import historic.
	 *
	 * @return the status by user ID of this import historic
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this import historic.
	 *
	 * @return the status by user name of this import historic
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this import historic.
	 *
	 * @return the status by user uuid of this import historic
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this import historic.
	 *
	 * @return the status date of this import historic
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the user ID of this import historic.
	 *
	 * @return the user ID of this import historic
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this import historic.
	 *
	 * @return the user name of this import historic
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this import historic.
	 *
	 * @return the user uuid of this import historic
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this import historic.
	 *
	 * @return the uuid of this import historic
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this import historic is approved.
	 *
	 * @return <code>true</code> if this import historic is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this import historic is denied.
	 *
	 * @return <code>true</code> if this import historic is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this import historic is a draft.
	 *
	 * @return <code>true</code> if this import historic is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this import historic is expired.
	 *
	 * @return <code>true</code> if this import historic is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this import historic is inactive.
	 *
	 * @return <code>true</code> if this import historic is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this import historic is incomplete.
	 *
	 * @return <code>true</code> if this import historic is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this import historic is pending.
	 *
	 * @return <code>true</code> if this import historic is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this import historic is scheduled.
	 *
	 * @return <code>true</code> if this import historic is scheduled; <code>false</code> otherwise
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
	 * Envoi du mail d'import
	 */
	@Override
	public void sendMail() {
		model.sendMail();
	}

	/**
	 * Sets the company ID of this import historic.
	 *
	 * @param companyId the company ID of this import historic
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this import historic.
	 *
	 * @param createDate the create date of this import historic
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the error description of this import historic.
	 *
	 * @param errorDescription the error description of this import historic
	 */
	@Override
	public void setErrorDescription(String errorDescription) {
		model.setErrorDescription(errorDescription);
	}

	/**
	 * Sets the localized error description of this import historic in the language.
	 *
	 * @param errorDescription the localized error description of this import historic
	 * @param locale the locale of the language
	 */
	@Override
	public void setErrorDescription(
		String errorDescription, java.util.Locale locale) {

		model.setErrorDescription(errorDescription, locale);
	}

	/**
	 * Sets the localized error description of this import historic in the language, and sets the default locale.
	 *
	 * @param errorDescription the localized error description of this import historic
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setErrorDescription(
		String errorDescription, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setErrorDescription(errorDescription, locale, defaultLocale);
	}

	@Override
	public void setErrorDescriptionCurrentLanguageId(String languageId) {
		model.setErrorDescriptionCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized error descriptions of this import historic from the map of locales and localized error descriptions.
	 *
	 * @param errorDescriptionMap the locales and localized error descriptions of this import historic
	 */
	@Override
	public void setErrorDescriptionMap(
		Map<java.util.Locale, String> errorDescriptionMap) {

		model.setErrorDescriptionMap(errorDescriptionMap);
	}

	/**
	 * Sets the localized error descriptions of this import historic from the map of locales and localized error descriptions, and sets the default locale.
	 *
	 * @param errorDescriptionMap the locales and localized error descriptions of this import historic
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setErrorDescriptionMap(
		Map<java.util.Locale, String> errorDescriptionMap,
		java.util.Locale defaultLocale) {

		model.setErrorDescriptionMap(errorDescriptionMap, defaultLocale);
	}

	/**
	 * Sets the error stack trace of this import historic.
	 *
	 * @param errorStackTrace the error stack trace of this import historic
	 */
	@Override
	public void setErrorStackTrace(String errorStackTrace) {
		model.setErrorStackTrace(errorStackTrace);
	}

	/**
	 * Sets the localized error stack trace of this import historic in the language.
	 *
	 * @param errorStackTrace the localized error stack trace of this import historic
	 * @param locale the locale of the language
	 */
	@Override
	public void setErrorStackTrace(
		String errorStackTrace, java.util.Locale locale) {

		model.setErrorStackTrace(errorStackTrace, locale);
	}

	/**
	 * Sets the localized error stack trace of this import historic in the language, and sets the default locale.
	 *
	 * @param errorStackTrace the localized error stack trace of this import historic
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setErrorStackTrace(
		String errorStackTrace, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setErrorStackTrace(errorStackTrace, locale, defaultLocale);
	}

	@Override
	public void setErrorStackTraceCurrentLanguageId(String languageId) {
		model.setErrorStackTraceCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized error stack traces of this import historic from the map of locales and localized error stack traces.
	 *
	 * @param errorStackTraceMap the locales and localized error stack traces of this import historic
	 */
	@Override
	public void setErrorStackTraceMap(
		Map<java.util.Locale, String> errorStackTraceMap) {

		model.setErrorStackTraceMap(errorStackTraceMap);
	}

	/**
	 * Sets the localized error stack traces of this import historic from the map of locales and localized error stack traces, and sets the default locale.
	 *
	 * @param errorStackTraceMap the locales and localized error stack traces of this import historic
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setErrorStackTraceMap(
		Map<java.util.Locale, String> errorStackTraceMap,
		java.util.Locale defaultLocale) {

		model.setErrorStackTraceMap(errorStackTraceMap, defaultLocale);
	}

	/**
	 * Sets the finish date of this import historic.
	 *
	 * @param finishDate the finish date of this import historic
	 */
	@Override
	public void setFinishDate(Date finishDate) {
		model.setFinishDate(finishDate);
	}

	/**
	 * Sets the group ID of this import historic.
	 *
	 * @param groupId the group ID of this import historic
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the gtfs file hash of this import historic.
	 *
	 * @param gtfsFileHash the gtfs file hash of this import historic
	 */
	@Override
	public void setGtfsFileHash(String gtfsFileHash) {
		model.setGtfsFileHash(gtfsFileHash);
	}

	/**
	 * Sets the import historic ID of this import historic.
	 *
	 * @param importHistoricId the import historic ID of this import historic
	 */
	@Override
	public void setImportHistoricId(long importHistoricId) {
		model.setImportHistoricId(importHistoricId);
	}

	/**
	 * Sets the modified date of this import historic.
	 *
	 * @param modifiedDate the modified date of this import historic
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the operations of this import historic.
	 *
	 * @param operations the operations of this import historic
	 */
	@Override
	public void setOperations(String operations) {
		model.setOperations(operations);
	}

	/**
	 * Sets the localized operations of this import historic in the language.
	 *
	 * @param operations the localized operations of this import historic
	 * @param locale the locale of the language
	 */
	@Override
	public void setOperations(String operations, java.util.Locale locale) {
		model.setOperations(operations, locale);
	}

	/**
	 * Sets the localized operations of this import historic in the language, and sets the default locale.
	 *
	 * @param operations the localized operations of this import historic
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setOperations(
		String operations, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setOperations(operations, locale, defaultLocale);
	}

	@Override
	public void setOperationsCurrentLanguageId(String languageId) {
		model.setOperationsCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized operationses of this import historic from the map of locales and localized operationses.
	 *
	 * @param operationsMap the locales and localized operationses of this import historic
	 */
	@Override
	public void setOperationsMap(Map<java.util.Locale, String> operationsMap) {
		model.setOperationsMap(operationsMap);
	}

	/**
	 * Sets the localized operationses of this import historic from the map of locales and localized operationses, and sets the default locale.
	 *
	 * @param operationsMap the locales and localized operationses of this import historic
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setOperationsMap(
		Map<java.util.Locale, String> operationsMap,
		java.util.Locale defaultLocale) {

		model.setOperationsMap(operationsMap, defaultLocale);
	}

	/**
	 * Sets the primary key of this import historic.
	 *
	 * @param primaryKey the primary key of this import historic
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the result of this import historic.
	 *
	 * @param result the result of this import historic
	 */
	@Override
	public void setResult(int result) {
		model.setResult(result);
	}

	/**
	 * Sets the start date of this import historic.
	 *
	 * @param startDate the start date of this import historic
	 */
	@Override
	public void setStartDate(Date startDate) {
		model.setStartDate(startDate);
	}

	/**
	 * Sets the status of this import historic.
	 *
	 * @param status the status of this import historic
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this import historic.
	 *
	 * @param statusByUserId the status by user ID of this import historic
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this import historic.
	 *
	 * @param statusByUserName the status by user name of this import historic
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this import historic.
	 *
	 * @param statusByUserUuid the status by user uuid of this import historic
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this import historic.
	 *
	 * @param statusDate the status date of this import historic
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the user ID of this import historic.
	 *
	 * @param userId the user ID of this import historic
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this import historic.
	 *
	 * @param userName the user name of this import historic
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this import historic.
	 *
	 * @param userUuid the user uuid of this import historic
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this import historic.
	 *
	 * @param uuid the uuid of this import historic
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
	protected ImportHistoricWrapper wrap(ImportHistoric importHistoric) {
		return new ImportHistoricWrapper(importHistoric);
	}

}