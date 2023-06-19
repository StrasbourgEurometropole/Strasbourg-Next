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

package eu.strasbourg.service.gtfs.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import eu.strasbourg.service.gtfs.model.Alert;
import eu.strasbourg.service.gtfs.model.AlertModel;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Alert service. Represents a row in the &quot;gtfs_Alert&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>AlertModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AlertImpl}.
 * </p>
 *
 * @author Cedric Henry
 * @see AlertImpl
 * @generated
 */
public class AlertModelImpl extends BaseModelImpl<Alert> implements AlertModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a alert model instance should use the <code>Alert</code> interface instead.
	 */
	public static final String TABLE_NAME = "gtfs_Alert";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"alertId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"arretId", Types.BIGINT}, {"startDate", Types.TIMESTAMP},
		{"endDate", Types.TIMESTAMP}, {"ligneAndDirection", Types.VARCHAR},
		{"perturbation", Types.CLOB}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("alertId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("arretId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("startDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("endDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("ligneAndDirection", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("perturbation", Types.CLOB);
	}

	public static final String TABLE_SQL_CREATE =
		"create table gtfs_Alert (uuid_ VARCHAR(75) null,alertId LONG not null primary key,groupId LONG,companyId LONG,arretId LONG,startDate DATE null,endDate DATE null,ligneAndDirection STRING null,perturbation TEXT null)";

	public static final String TABLE_SQL_DROP = "drop table gtfs_Alert";

	public static final String ORDER_BY_JPQL = " ORDER BY alert.alertId DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY gtfs_Alert.alertId DESC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static final boolean ENTITY_CACHE_ENABLED = true;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static final boolean FINDER_CACHE_ENABLED = true;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static final boolean COLUMN_BITMASK_ENABLED = true;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long ARRETID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long ALERTID_COLUMN_BITMASK = 16L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		eu.strasbourg.service.gtfs.service.util.PropsUtil.get(
			"lock.expiration.time.eu.strasbourg.service.gtfs.model.Alert"));

	public AlertModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _alertId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAlertId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _alertId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Alert.class;
	}

	@Override
	public String getModelClassName() {
		return Alert.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Alert, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Alert, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Alert, Object> attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Alert)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Alert, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Alert, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept((Alert)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Alert, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Alert, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<Alert, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Alert, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Alert, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Alert, Object>>();
		Map<String, BiConsumer<Alert, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Alert, ?>>();

		attributeGetterFunctions.put("uuid", Alert::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<Alert, String>)Alert::setUuid);
		attributeGetterFunctions.put("alertId", Alert::getAlertId);
		attributeSetterBiConsumers.put(
			"alertId", (BiConsumer<Alert, Long>)Alert::setAlertId);
		attributeGetterFunctions.put("groupId", Alert::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<Alert, Long>)Alert::setGroupId);
		attributeGetterFunctions.put("companyId", Alert::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<Alert, Long>)Alert::setCompanyId);
		attributeGetterFunctions.put("arretId", Alert::getArretId);
		attributeSetterBiConsumers.put(
			"arretId", (BiConsumer<Alert, Long>)Alert::setArretId);
		attributeGetterFunctions.put("startDate", Alert::getStartDate);
		attributeSetterBiConsumers.put(
			"startDate", (BiConsumer<Alert, Date>)Alert::setStartDate);
		attributeGetterFunctions.put("endDate", Alert::getEndDate);
		attributeSetterBiConsumers.put(
			"endDate", (BiConsumer<Alert, Date>)Alert::setEndDate);
		attributeGetterFunctions.put(
			"ligneAndDirection", Alert::getLigneAndDirection);
		attributeSetterBiConsumers.put(
			"ligneAndDirection",
			(BiConsumer<Alert, String>)Alert::setLigneAndDirection);
		attributeGetterFunctions.put("perturbation", Alert::getPerturbation);
		attributeSetterBiConsumers.put(
			"perturbation", (BiConsumer<Alert, String>)Alert::setPerturbation);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@Override
	public long getAlertId() {
		return _alertId;
	}

	@Override
	public void setAlertId(long alertId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_alertId = alertId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalGroupId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("groupId"));
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("companyId"));
	}

	@Override
	public long getArretId() {
		return _arretId;
	}

	@Override
	public void setArretId(long arretId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_arretId = arretId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalArretId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("arretId"));
	}

	@Override
	public Date getStartDate() {
		return _startDate;
	}

	@Override
	public void setStartDate(Date startDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_startDate = startDate;
	}

	@Override
	public Date getEndDate() {
		return _endDate;
	}

	@Override
	public void setEndDate(Date endDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_endDate = endDate;
	}

	@Override
	public String getLigneAndDirection() {
		if (_ligneAndDirection == null) {
			return "";
		}
		else {
			return _ligneAndDirection;
		}
	}

	@Override
	public String getLigneAndDirection(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getLigneAndDirection(languageId);
	}

	@Override
	public String getLigneAndDirection(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getLigneAndDirection(languageId, useDefault);
	}

	@Override
	public String getLigneAndDirection(String languageId) {
		return LocalizationUtil.getLocalization(
			getLigneAndDirection(), languageId);
	}

	@Override
	public String getLigneAndDirection(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(
			getLigneAndDirection(), languageId, useDefault);
	}

	@Override
	public String getLigneAndDirectionCurrentLanguageId() {
		return _ligneAndDirectionCurrentLanguageId;
	}

	@JSON
	@Override
	public String getLigneAndDirectionCurrentValue() {
		Locale locale = getLocale(_ligneAndDirectionCurrentLanguageId);

		return getLigneAndDirection(locale);
	}

	@Override
	public Map<Locale, String> getLigneAndDirectionMap() {
		return LocalizationUtil.getLocalizationMap(getLigneAndDirection());
	}

	@Override
	public void setLigneAndDirection(String ligneAndDirection) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_ligneAndDirection = ligneAndDirection;
	}

	@Override
	public void setLigneAndDirection(String ligneAndDirection, Locale locale) {
		setLigneAndDirection(
			ligneAndDirection, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setLigneAndDirection(
		String ligneAndDirection, Locale locale, Locale defaultLocale) {

		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(ligneAndDirection)) {
			setLigneAndDirection(
				LocalizationUtil.updateLocalization(
					getLigneAndDirection(), "LigneAndDirection",
					ligneAndDirection, languageId, defaultLanguageId));
		}
		else {
			setLigneAndDirection(
				LocalizationUtil.removeLocalization(
					getLigneAndDirection(), "LigneAndDirection", languageId));
		}
	}

	@Override
	public void setLigneAndDirectionCurrentLanguageId(String languageId) {
		_ligneAndDirectionCurrentLanguageId = languageId;
	}

	@Override
	public void setLigneAndDirectionMap(
		Map<Locale, String> ligneAndDirectionMap) {

		setLigneAndDirectionMap(ligneAndDirectionMap, LocaleUtil.getDefault());
	}

	@Override
	public void setLigneAndDirectionMap(
		Map<Locale, String> ligneAndDirectionMap, Locale defaultLocale) {

		if (ligneAndDirectionMap == null) {
			return;
		}

		setLigneAndDirection(
			LocalizationUtil.updateLocalization(
				ligneAndDirectionMap, getLigneAndDirection(),
				"LigneAndDirection", LocaleUtil.toLanguageId(defaultLocale)));
	}

	@Override
	public String getPerturbation() {
		if (_perturbation == null) {
			return "";
		}
		else {
			return _perturbation;
		}
	}

	@Override
	public String getPerturbation(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getPerturbation(languageId);
	}

	@Override
	public String getPerturbation(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getPerturbation(languageId, useDefault);
	}

	@Override
	public String getPerturbation(String languageId) {
		return LocalizationUtil.getLocalization(getPerturbation(), languageId);
	}

	@Override
	public String getPerturbation(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(
			getPerturbation(), languageId, useDefault);
	}

	@Override
	public String getPerturbationCurrentLanguageId() {
		return _perturbationCurrentLanguageId;
	}

	@JSON
	@Override
	public String getPerturbationCurrentValue() {
		Locale locale = getLocale(_perturbationCurrentLanguageId);

		return getPerturbation(locale);
	}

	@Override
	public Map<Locale, String> getPerturbationMap() {
		return LocalizationUtil.getLocalizationMap(getPerturbation());
	}

	@Override
	public void setPerturbation(String perturbation) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_perturbation = perturbation;
	}

	@Override
	public void setPerturbation(String perturbation, Locale locale) {
		setPerturbation(perturbation, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setPerturbation(
		String perturbation, Locale locale, Locale defaultLocale) {

		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(perturbation)) {
			setPerturbation(
				LocalizationUtil.updateLocalization(
					getPerturbation(), "Perturbation", perturbation, languageId,
					defaultLanguageId));
		}
		else {
			setPerturbation(
				LocalizationUtil.removeLocalization(
					getPerturbation(), "Perturbation", languageId));
		}
	}

	@Override
	public void setPerturbationCurrentLanguageId(String languageId) {
		_perturbationCurrentLanguageId = languageId;
	}

	@Override
	public void setPerturbationMap(Map<Locale, String> perturbationMap) {
		setPerturbationMap(perturbationMap, LocaleUtil.getDefault());
	}

	@Override
	public void setPerturbationMap(
		Map<Locale, String> perturbationMap, Locale defaultLocale) {

		if (perturbationMap == null) {
			return;
		}

		setPerturbation(
			LocalizationUtil.updateLocalization(
				perturbationMap, getPerturbation(), "Perturbation",
				LocaleUtil.toLanguageId(defaultLocale)));
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), Alert.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> ligneAndDirectionMap = getLigneAndDirectionMap();

		for (Map.Entry<Locale, String> entry :
				ligneAndDirectionMap.entrySet()) {

			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		Map<Locale, String> perturbationMap = getPerturbationMap();

		for (Map.Entry<Locale, String> entry : perturbationMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		return availableLanguageIds.toArray(
			new String[availableLanguageIds.size()]);
	}

	@Override
	public String getDefaultLanguageId() {
		String xml = getLigneAndDirection();

		if (xml == null) {
			return "";
		}

		Locale defaultLocale = LocaleUtil.getDefault();

		return LocalizationUtil.getDefaultLanguageId(xml, defaultLocale);
	}

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException {
		Locale defaultLocale = LocaleUtil.fromLanguageId(
			getDefaultLanguageId());

		Locale[] availableLocales = LocaleUtil.fromLanguageIds(
			getAvailableLanguageIds());

		Locale defaultImportLocale = LocalizationUtil.getDefaultImportLocale(
			Alert.class.getName(), getPrimaryKey(), defaultLocale,
			availableLocales);

		prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	@SuppressWarnings("unused")
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException {

		Locale defaultLocale = LocaleUtil.getDefault();

		String modelDefaultLanguageId = getDefaultLanguageId();

		String ligneAndDirection = getLigneAndDirection(defaultLocale);

		if (Validator.isNull(ligneAndDirection)) {
			setLigneAndDirection(
				getLigneAndDirection(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setLigneAndDirection(
				getLigneAndDirection(defaultLocale), defaultLocale,
				defaultLocale);
		}

		String perturbation = getPerturbation(defaultLocale);

		if (Validator.isNull(perturbation)) {
			setPerturbation(
				getPerturbation(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setPerturbation(
				getPerturbation(defaultLocale), defaultLocale, defaultLocale);
		}
	}

	@Override
	public Alert toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Alert>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		AlertImpl alertImpl = new AlertImpl();

		alertImpl.setUuid(getUuid());
		alertImpl.setAlertId(getAlertId());
		alertImpl.setGroupId(getGroupId());
		alertImpl.setCompanyId(getCompanyId());
		alertImpl.setArretId(getArretId());
		alertImpl.setStartDate(getStartDate());
		alertImpl.setEndDate(getEndDate());
		alertImpl.setLigneAndDirection(getLigneAndDirection());
		alertImpl.setPerturbation(getPerturbation());

		alertImpl.resetOriginalValues();

		return alertImpl;
	}

	@Override
	public Alert cloneWithOriginalValues() {
		AlertImpl alertImpl = new AlertImpl();

		alertImpl.setUuid(this.<String>getColumnOriginalValue("uuid_"));
		alertImpl.setAlertId(this.<Long>getColumnOriginalValue("alertId"));
		alertImpl.setGroupId(this.<Long>getColumnOriginalValue("groupId"));
		alertImpl.setCompanyId(this.<Long>getColumnOriginalValue("companyId"));
		alertImpl.setArretId(this.<Long>getColumnOriginalValue("arretId"));
		alertImpl.setStartDate(this.<Date>getColumnOriginalValue("startDate"));
		alertImpl.setEndDate(this.<Date>getColumnOriginalValue("endDate"));
		alertImpl.setLigneAndDirection(
			this.<String>getColumnOriginalValue("ligneAndDirection"));
		alertImpl.setPerturbation(
			this.<String>getColumnOriginalValue("perturbation"));

		return alertImpl;
	}

	@Override
	public int compareTo(Alert alert) {
		int value = 0;

		if (getAlertId() < alert.getAlertId()) {
			value = -1;
		}
		else if (getAlertId() > alert.getAlertId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Alert)) {
			return false;
		}

		Alert alert = (Alert)object;

		long primaryKey = alert.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<Alert> toCacheModel() {
		AlertCacheModel alertCacheModel = new AlertCacheModel();

		alertCacheModel.uuid = getUuid();

		String uuid = alertCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			alertCacheModel.uuid = null;
		}

		alertCacheModel.alertId = getAlertId();

		alertCacheModel.groupId = getGroupId();

		alertCacheModel.companyId = getCompanyId();

		alertCacheModel.arretId = getArretId();

		Date startDate = getStartDate();

		if (startDate != null) {
			alertCacheModel.startDate = startDate.getTime();
		}
		else {
			alertCacheModel.startDate = Long.MIN_VALUE;
		}

		Date endDate = getEndDate();

		if (endDate != null) {
			alertCacheModel.endDate = endDate.getTime();
		}
		else {
			alertCacheModel.endDate = Long.MIN_VALUE;
		}

		alertCacheModel.ligneAndDirection = getLigneAndDirection();

		String ligneAndDirection = alertCacheModel.ligneAndDirection;

		if ((ligneAndDirection != null) && (ligneAndDirection.length() == 0)) {
			alertCacheModel.ligneAndDirection = null;
		}

		alertCacheModel.perturbation = getPerturbation();

		String perturbation = alertCacheModel.perturbation;

		if ((perturbation != null) && (perturbation.length() == 0)) {
			alertCacheModel.perturbation = null;
		}

		return alertCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Alert, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Alert, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Alert, Object> attributeGetterFunction = entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((Alert)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Alert>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					Alert.class, ModelWrapper.class);

	}

	private String _uuid;
	private long _alertId;
	private long _groupId;
	private long _companyId;
	private long _arretId;
	private Date _startDate;
	private Date _endDate;
	private String _ligneAndDirection;
	private String _ligneAndDirectionCurrentLanguageId;
	private String _perturbation;
	private String _perturbationCurrentLanguageId;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<Alert, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Alert)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put("alertId", _alertId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("arretId", _arretId);
		_columnOriginalValues.put("startDate", _startDate);
		_columnOriginalValues.put("endDate", _endDate);
		_columnOriginalValues.put("ligneAndDirection", _ligneAndDirection);
		_columnOriginalValues.put("perturbation", _perturbation);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("uuid_", 1L);

		columnBitmasks.put("alertId", 2L);

		columnBitmasks.put("groupId", 4L);

		columnBitmasks.put("companyId", 8L);

		columnBitmasks.put("arretId", 16L);

		columnBitmasks.put("startDate", 32L);

		columnBitmasks.put("endDate", 64L);

		columnBitmasks.put("ligneAndDirection", 128L);

		columnBitmasks.put("perturbation", 256L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Alert _escapedModel;

}