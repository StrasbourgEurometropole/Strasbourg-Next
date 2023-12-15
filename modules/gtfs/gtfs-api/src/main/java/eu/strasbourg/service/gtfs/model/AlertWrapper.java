/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Alert}.
 * </p>
 *
 * @author Cedric Henry
 * @see Alert
 * @generated
 */
public class AlertWrapper
	extends BaseModelWrapper<Alert> implements Alert, ModelWrapper<Alert> {

	public AlertWrapper(Alert alert) {
		super(alert);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("alertId", getAlertId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("arretId", getArretId());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("ligneAndDirection", getLigneAndDirection());
		attributes.put("perturbation", getPerturbation());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long alertId = (Long)attributes.get("alertId");

		if (alertId != null) {
			setAlertId(alertId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long arretId = (Long)attributes.get("arretId");

		if (arretId != null) {
			setArretId(arretId);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		String ligneAndDirection = (String)attributes.get("ligneAndDirection");

		if (ligneAndDirection != null) {
			setLigneAndDirection(ligneAndDirection);
		}

		String perturbation = (String)attributes.get("perturbation");

		if (perturbation != null) {
			setPerturbation(perturbation);
		}
	}

	@Override
	public Alert cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the alert ID of this alert.
	 *
	 * @return the alert ID of this alert
	 */
	@Override
	public long getAlertId() {
		return model.getAlertId();
	}

	/**
	 * Returns the arret ID of this alert.
	 *
	 * @return the arret ID of this alert
	 */
	@Override
	public long getArretId() {
		return model.getArretId();
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the company ID of this alert.
	 *
	 * @return the company ID of this alert
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	@Override
	public String getDefaultLanguageId() {
		return model.getDefaultLanguageId();
	}

	/**
	 * Returns the end date of this alert.
	 *
	 * @return the end date of this alert
	 */
	@Override
	public Date getEndDate() {
		return model.getEndDate();
	}

	/**
	 * Returns the group ID of this alert.
	 *
	 * @return the group ID of this alert
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ligne and direction of this alert.
	 *
	 * @return the ligne and direction of this alert
	 */
	@Override
	public String getLigneAndDirection() {
		return model.getLigneAndDirection();
	}

	/**
	 * Returns the localized ligne and direction of this alert in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized ligne and direction of this alert
	 */
	@Override
	public String getLigneAndDirection(java.util.Locale locale) {
		return model.getLigneAndDirection(locale);
	}

	/**
	 * Returns the localized ligne and direction of this alert in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized ligne and direction of this alert. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getLigneAndDirection(
		java.util.Locale locale, boolean useDefault) {

		return model.getLigneAndDirection(locale, useDefault);
	}

	/**
	 * Returns the localized ligne and direction of this alert in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized ligne and direction of this alert
	 */
	@Override
	public String getLigneAndDirection(String languageId) {
		return model.getLigneAndDirection(languageId);
	}

	/**
	 * Returns the localized ligne and direction of this alert in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized ligne and direction of this alert
	 */
	@Override
	public String getLigneAndDirection(String languageId, boolean useDefault) {
		return model.getLigneAndDirection(languageId, useDefault);
	}

	@Override
	public String getLigneAndDirectionCurrentLanguageId() {
		return model.getLigneAndDirectionCurrentLanguageId();
	}

	@Override
	public String getLigneAndDirectionCurrentValue() {
		return model.getLigneAndDirectionCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized ligne and directions of this alert.
	 *
	 * @return the locales and localized ligne and directions of this alert
	 */
	@Override
	public Map<java.util.Locale, String> getLigneAndDirectionMap() {
		return model.getLigneAndDirectionMap();
	}

	/**
	 * Returns the perturbation of this alert.
	 *
	 * @return the perturbation of this alert
	 */
	@Override
	public String getPerturbation() {
		return model.getPerturbation();
	}

	/**
	 * Returns the localized perturbation of this alert in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized perturbation of this alert
	 */
	@Override
	public String getPerturbation(java.util.Locale locale) {
		return model.getPerturbation(locale);
	}

	/**
	 * Returns the localized perturbation of this alert in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized perturbation of this alert. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getPerturbation(java.util.Locale locale, boolean useDefault) {
		return model.getPerturbation(locale, useDefault);
	}

	/**
	 * Returns the localized perturbation of this alert in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized perturbation of this alert
	 */
	@Override
	public String getPerturbation(String languageId) {
		return model.getPerturbation(languageId);
	}

	/**
	 * Returns the localized perturbation of this alert in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized perturbation of this alert
	 */
	@Override
	public String getPerturbation(String languageId, boolean useDefault) {
		return model.getPerturbation(languageId, useDefault);
	}

	@Override
	public String getPerturbationCurrentLanguageId() {
		return model.getPerturbationCurrentLanguageId();
	}

	@Override
	public String getPerturbationCurrentValue() {
		return model.getPerturbationCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized perturbations of this alert.
	 *
	 * @return the locales and localized perturbations of this alert
	 */
	@Override
	public Map<java.util.Locale, String> getPerturbationMap() {
		return model.getPerturbationMap();
	}

	/**
	 * Returns the primary key of this alert.
	 *
	 * @return the primary key of this alert
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the start date of this alert.
	 *
	 * @return the start date of this alert
	 */
	@Override
	public Date getStartDate() {
		return model.getStartDate();
	}

	/**
	 * Returns the uuid of this alert.
	 *
	 * @return the uuid of this alert
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
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
	 * Sets the alert ID of this alert.
	 *
	 * @param alertId the alert ID of this alert
	 */
	@Override
	public void setAlertId(long alertId) {
		model.setAlertId(alertId);
	}

	/**
	 * Sets the arret ID of this alert.
	 *
	 * @param arretId the arret ID of this alert
	 */
	@Override
	public void setArretId(long arretId) {
		model.setArretId(arretId);
	}

	/**
	 * Sets the company ID of this alert.
	 *
	 * @param companyId the company ID of this alert
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the end date of this alert.
	 *
	 * @param endDate the end date of this alert
	 */
	@Override
	public void setEndDate(Date endDate) {
		model.setEndDate(endDate);
	}

	/**
	 * Sets the group ID of this alert.
	 *
	 * @param groupId the group ID of this alert
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ligne and direction of this alert.
	 *
	 * @param ligneAndDirection the ligne and direction of this alert
	 */
	@Override
	public void setLigneAndDirection(String ligneAndDirection) {
		model.setLigneAndDirection(ligneAndDirection);
	}

	/**
	 * Sets the localized ligne and direction of this alert in the language.
	 *
	 * @param ligneAndDirection the localized ligne and direction of this alert
	 * @param locale the locale of the language
	 */
	@Override
	public void setLigneAndDirection(
		String ligneAndDirection, java.util.Locale locale) {

		model.setLigneAndDirection(ligneAndDirection, locale);
	}

	/**
	 * Sets the localized ligne and direction of this alert in the language, and sets the default locale.
	 *
	 * @param ligneAndDirection the localized ligne and direction of this alert
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setLigneAndDirection(
		String ligneAndDirection, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setLigneAndDirection(ligneAndDirection, locale, defaultLocale);
	}

	@Override
	public void setLigneAndDirectionCurrentLanguageId(String languageId) {
		model.setLigneAndDirectionCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized ligne and directions of this alert from the map of locales and localized ligne and directions.
	 *
	 * @param ligneAndDirectionMap the locales and localized ligne and directions of this alert
	 */
	@Override
	public void setLigneAndDirectionMap(
		Map<java.util.Locale, String> ligneAndDirectionMap) {

		model.setLigneAndDirectionMap(ligneAndDirectionMap);
	}

	/**
	 * Sets the localized ligne and directions of this alert from the map of locales and localized ligne and directions, and sets the default locale.
	 *
	 * @param ligneAndDirectionMap the locales and localized ligne and directions of this alert
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setLigneAndDirectionMap(
		Map<java.util.Locale, String> ligneAndDirectionMap,
		java.util.Locale defaultLocale) {

		model.setLigneAndDirectionMap(ligneAndDirectionMap, defaultLocale);
	}

	/**
	 * Sets the perturbation of this alert.
	 *
	 * @param perturbation the perturbation of this alert
	 */
	@Override
	public void setPerturbation(String perturbation) {
		model.setPerturbation(perturbation);
	}

	/**
	 * Sets the localized perturbation of this alert in the language.
	 *
	 * @param perturbation the localized perturbation of this alert
	 * @param locale the locale of the language
	 */
	@Override
	public void setPerturbation(String perturbation, java.util.Locale locale) {
		model.setPerturbation(perturbation, locale);
	}

	/**
	 * Sets the localized perturbation of this alert in the language, and sets the default locale.
	 *
	 * @param perturbation the localized perturbation of this alert
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setPerturbation(
		String perturbation, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setPerturbation(perturbation, locale, defaultLocale);
	}

	@Override
	public void setPerturbationCurrentLanguageId(String languageId) {
		model.setPerturbationCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized perturbations of this alert from the map of locales and localized perturbations.
	 *
	 * @param perturbationMap the locales and localized perturbations of this alert
	 */
	@Override
	public void setPerturbationMap(
		Map<java.util.Locale, String> perturbationMap) {

		model.setPerturbationMap(perturbationMap);
	}

	/**
	 * Sets the localized perturbations of this alert from the map of locales and localized perturbations, and sets the default locale.
	 *
	 * @param perturbationMap the locales and localized perturbations of this alert
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setPerturbationMap(
		Map<java.util.Locale, String> perturbationMap,
		java.util.Locale defaultLocale) {

		model.setPerturbationMap(perturbationMap, defaultLocale);
	}

	/**
	 * Sets the primary key of this alert.
	 *
	 * @param primaryKey the primary key of this alert
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the start date of this alert.
	 *
	 * @param startDate the start date of this alert
	 */
	@Override
	public void setStartDate(Date startDate) {
		model.setStartDate(startDate);
	}

	/**
	 * Sets the uuid of this alert.
	 *
	 * @param uuid the uuid of this alert
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
	protected AlertWrapper wrap(Alert alert) {
		return new AlertWrapper(alert);
	}

}