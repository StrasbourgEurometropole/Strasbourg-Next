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

package eu.strasbourg.service.notification.model.impl;

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
import eu.strasbourg.service.notification.model.Notification;
import eu.strasbourg.service.notification.model.NotificationModel;

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
 * The base model implementation for the Notification service. Represents a row in the &quot;notification_Notification&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>NotificationModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link NotificationImpl}.
 * </p>
 *
 * @author BenjaminBini
 * @see NotificationImpl
 * @generated
 */
@JSON(strict = true)
public class NotificationModelImpl
	extends BaseModelImpl<Notification> implements NotificationModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a notification model instance should use the <code>Notification</code> interface instead.
	 */
	public static final String TABLE_NAME = "notification_Notification";

	public static final Object[][] TABLE_COLUMNS = {
		{"notificationId", Types.BIGINT}, {"title", Types.VARCHAR},
		{"description", Types.CLOB}, {"url", Types.VARCHAR},
		{"automatic", Types.BOOLEAN}, {"singleUser", Types.BOOLEAN},
		{"singleUserId", Types.VARCHAR}, {"publicationDate", Types.TIMESTAMP},
		{"expirationDate", Types.TIMESTAMP}, {"status", Types.INTEGER},
		{"typeId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("notificationId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("title", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.CLOB);
		TABLE_COLUMNS_MAP.put("url", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("automatic", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("singleUser", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("singleUserId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("publicationDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("expirationDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("typeId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table notification_Notification (notificationId LONG not null primary key,title STRING null,description TEXT null,url VARCHAR(400) null,automatic BOOLEAN,singleUser BOOLEAN,singleUserId VARCHAR(75) null,publicationDate DATE null,expirationDate DATE null,status INTEGER,typeId LONG)";

	public static final String TABLE_SQL_DROP =
		"drop table notification_Notification";

	public static final String ORDER_BY_JPQL =
		" ORDER BY notification.notificationId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY notification_Notification.notificationId ASC";

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
	public static final long EXPIRATIONDATE_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long PUBLICATIONDATE_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long STATUS_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long NOTIFICATIONID_COLUMN_BITMASK = 8L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		eu.strasbourg.service.notification.service.util.ServiceProps.get(
			"lock.expiration.time.eu.strasbourg.service.notification.model.Notification"));

	public NotificationModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _notificationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setNotificationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _notificationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Notification.class;
	}

	@Override
	public String getModelClassName() {
		return Notification.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Notification, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Notification, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Notification, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((Notification)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Notification, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Notification, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Notification)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Notification, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Notification, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<Notification, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Notification, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Notification, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Notification, Object>>();
		Map<String, BiConsumer<Notification, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Notification, ?>>();

		attributeGetterFunctions.put(
			"notificationId", Notification::getNotificationId);
		attributeSetterBiConsumers.put(
			"notificationId",
			(BiConsumer<Notification, Long>)Notification::setNotificationId);
		attributeGetterFunctions.put("title", Notification::getTitle);
		attributeSetterBiConsumers.put(
			"title", (BiConsumer<Notification, String>)Notification::setTitle);
		attributeGetterFunctions.put(
			"description", Notification::getDescription);
		attributeSetterBiConsumers.put(
			"description",
			(BiConsumer<Notification, String>)Notification::setDescription);
		attributeGetterFunctions.put("url", Notification::getUrl);
		attributeSetterBiConsumers.put(
			"url", (BiConsumer<Notification, String>)Notification::setUrl);
		attributeGetterFunctions.put("automatic", Notification::getAutomatic);
		attributeSetterBiConsumers.put(
			"automatic",
			(BiConsumer<Notification, Boolean>)Notification::setAutomatic);
		attributeGetterFunctions.put("singleUser", Notification::getSingleUser);
		attributeSetterBiConsumers.put(
			"singleUser",
			(BiConsumer<Notification, Boolean>)Notification::setSingleUser);
		attributeGetterFunctions.put(
			"singleUserId", Notification::getSingleUserId);
		attributeSetterBiConsumers.put(
			"singleUserId",
			(BiConsumer<Notification, String>)Notification::setSingleUserId);
		attributeGetterFunctions.put(
			"publicationDate", Notification::getPublicationDate);
		attributeSetterBiConsumers.put(
			"publicationDate",
			(BiConsumer<Notification, Date>)Notification::setPublicationDate);
		attributeGetterFunctions.put(
			"expirationDate", Notification::getExpirationDate);
		attributeSetterBiConsumers.put(
			"expirationDate",
			(BiConsumer<Notification, Date>)Notification::setExpirationDate);
		attributeGetterFunctions.put("status", Notification::getStatus);
		attributeSetterBiConsumers.put(
			"status",
			(BiConsumer<Notification, Integer>)Notification::setStatus);
		attributeGetterFunctions.put("typeId", Notification::getTypeId);
		attributeSetterBiConsumers.put(
			"typeId", (BiConsumer<Notification, Long>)Notification::setTypeId);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getNotificationId() {
		return _notificationId;
	}

	@Override
	public void setNotificationId(long notificationId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_notificationId = notificationId;
	}

	@JSON
	@Override
	public String getTitle() {
		if (_title == null) {
			return "";
		}
		else {
			return _title;
		}
	}

	@Override
	public String getTitle(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getTitle(languageId);
	}

	@Override
	public String getTitle(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getTitle(languageId, useDefault);
	}

	@Override
	public String getTitle(String languageId) {
		return LocalizationUtil.getLocalization(getTitle(), languageId);
	}

	@Override
	public String getTitle(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(
			getTitle(), languageId, useDefault);
	}

	@Override
	public String getTitleCurrentLanguageId() {
		return _titleCurrentLanguageId;
	}

	@JSON
	@Override
	public String getTitleCurrentValue() {
		Locale locale = getLocale(_titleCurrentLanguageId);

		return getTitle(locale);
	}

	@Override
	public Map<Locale, String> getTitleMap() {
		return LocalizationUtil.getLocalizationMap(getTitle());
	}

	@Override
	public void setTitle(String title) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_title = title;
	}

	@Override
	public void setTitle(String title, Locale locale) {
		setTitle(title, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setTitle(String title, Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(title)) {
			setTitle(
				LocalizationUtil.updateLocalization(
					getTitle(), "Title", title, languageId, defaultLanguageId));
		}
		else {
			setTitle(
				LocalizationUtil.removeLocalization(
					getTitle(), "Title", languageId));
		}
	}

	@Override
	public void setTitleCurrentLanguageId(String languageId) {
		_titleCurrentLanguageId = languageId;
	}

	@Override
	public void setTitleMap(Map<Locale, String> titleMap) {
		setTitleMap(titleMap, LocaleUtil.getDefault());
	}

	@Override
	public void setTitleMap(
		Map<Locale, String> titleMap, Locale defaultLocale) {

		if (titleMap == null) {
			return;
		}

		setTitle(
			LocalizationUtil.updateLocalization(
				titleMap, getTitle(), "Title",
				LocaleUtil.toLanguageId(defaultLocale)));
	}

	@JSON
	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public String getDescription(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getDescription(languageId);
	}

	@Override
	public String getDescription(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getDescription(languageId, useDefault);
	}

	@Override
	public String getDescription(String languageId) {
		return LocalizationUtil.getLocalization(getDescription(), languageId);
	}

	@Override
	public String getDescription(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(
			getDescription(), languageId, useDefault);
	}

	@Override
	public String getDescriptionCurrentLanguageId() {
		return _descriptionCurrentLanguageId;
	}

	@JSON
	@Override
	public String getDescriptionCurrentValue() {
		Locale locale = getLocale(_descriptionCurrentLanguageId);

		return getDescription(locale);
	}

	@Override
	public Map<Locale, String> getDescriptionMap() {
		return LocalizationUtil.getLocalizationMap(getDescription());
	}

	@Override
	public void setDescription(String description) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_description = description;
	}

	@Override
	public void setDescription(String description, Locale locale) {
		setDescription(description, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setDescription(
		String description, Locale locale, Locale defaultLocale) {

		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(description)) {
			setDescription(
				LocalizationUtil.updateLocalization(
					getDescription(), "Description", description, languageId,
					defaultLanguageId));
		}
		else {
			setDescription(
				LocalizationUtil.removeLocalization(
					getDescription(), "Description", languageId));
		}
	}

	@Override
	public void setDescriptionCurrentLanguageId(String languageId) {
		_descriptionCurrentLanguageId = languageId;
	}

	@Override
	public void setDescriptionMap(Map<Locale, String> descriptionMap) {
		setDescriptionMap(descriptionMap, LocaleUtil.getDefault());
	}

	@Override
	public void setDescriptionMap(
		Map<Locale, String> descriptionMap, Locale defaultLocale) {

		if (descriptionMap == null) {
			return;
		}

		setDescription(
			LocalizationUtil.updateLocalization(
				descriptionMap, getDescription(), "Description",
				LocaleUtil.toLanguageId(defaultLocale)));
	}

	@JSON
	@Override
	public String getUrl() {
		if (_url == null) {
			return "";
		}
		else {
			return _url;
		}
	}

	@Override
	public void setUrl(String url) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_url = url;
	}

	@JSON
	@Override
	public boolean getAutomatic() {
		return _automatic;
	}

	@JSON
	@Override
	public boolean isAutomatic() {
		return _automatic;
	}

	@Override
	public void setAutomatic(boolean automatic) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_automatic = automatic;
	}

	@JSON
	@Override
	public boolean getSingleUser() {
		return _singleUser;
	}

	@JSON
	@Override
	public boolean isSingleUser() {
		return _singleUser;
	}

	@Override
	public void setSingleUser(boolean singleUser) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_singleUser = singleUser;
	}

	@JSON
	@Override
	public String getSingleUserId() {
		if (_singleUserId == null) {
			return "";
		}
		else {
			return _singleUserId;
		}
	}

	@Override
	public void setSingleUserId(String singleUserId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_singleUserId = singleUserId;
	}

	@JSON
	@Override
	public Date getPublicationDate() {
		return _publicationDate;
	}

	@Override
	public void setPublicationDate(Date publicationDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_publicationDate = publicationDate;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public Date getOriginalPublicationDate() {
		return getColumnOriginalValue("publicationDate");
	}

	@JSON
	@Override
	public Date getExpirationDate() {
		return _expirationDate;
	}

	@Override
	public void setExpirationDate(Date expirationDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_expirationDate = expirationDate;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public Date getOriginalExpirationDate() {
		return getColumnOriginalValue("expirationDate");
	}

	@JSON
	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_status = status;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public int getOriginalStatus() {
		return GetterUtil.getInteger(
			this.<Integer>getColumnOriginalValue("status"));
	}

	@JSON
	@Override
	public long getTypeId() {
		return _typeId;
	}

	@Override
	public void setTypeId(long typeId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_typeId = typeId;
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
			0, Notification.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> titleMap = getTitleMap();

		for (Map.Entry<Locale, String> entry : titleMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		Map<Locale, String> descriptionMap = getDescriptionMap();

		for (Map.Entry<Locale, String> entry : descriptionMap.entrySet()) {
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
		String xml = getTitle();

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
			Notification.class.getName(), getPrimaryKey(), defaultLocale,
			availableLocales);

		prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	@SuppressWarnings("unused")
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException {

		Locale defaultLocale = LocaleUtil.getDefault();

		String modelDefaultLanguageId = getDefaultLanguageId();

		String title = getTitle(defaultLocale);

		if (Validator.isNull(title)) {
			setTitle(getTitle(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setTitle(getTitle(defaultLocale), defaultLocale, defaultLocale);
		}

		String description = getDescription(defaultLocale);

		if (Validator.isNull(description)) {
			setDescription(
				getDescription(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setDescription(
				getDescription(defaultLocale), defaultLocale, defaultLocale);
		}
	}

	@Override
	public Notification toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Notification>
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
		NotificationImpl notificationImpl = new NotificationImpl();

		notificationImpl.setNotificationId(getNotificationId());
		notificationImpl.setTitle(getTitle());
		notificationImpl.setDescription(getDescription());
		notificationImpl.setUrl(getUrl());
		notificationImpl.setAutomatic(isAutomatic());
		notificationImpl.setSingleUser(isSingleUser());
		notificationImpl.setSingleUserId(getSingleUserId());
		notificationImpl.setPublicationDate(getPublicationDate());
		notificationImpl.setExpirationDate(getExpirationDate());
		notificationImpl.setStatus(getStatus());
		notificationImpl.setTypeId(getTypeId());

		notificationImpl.resetOriginalValues();

		return notificationImpl;
	}

	@Override
	public Notification cloneWithOriginalValues() {
		NotificationImpl notificationImpl = new NotificationImpl();

		notificationImpl.setNotificationId(
			this.<Long>getColumnOriginalValue("notificationId"));
		notificationImpl.setTitle(this.<String>getColumnOriginalValue("title"));
		notificationImpl.setDescription(
			this.<String>getColumnOriginalValue("description"));
		notificationImpl.setUrl(this.<String>getColumnOriginalValue("url"));
		notificationImpl.setAutomatic(
			this.<Boolean>getColumnOriginalValue("automatic"));
		notificationImpl.setSingleUser(
			this.<Boolean>getColumnOriginalValue("singleUser"));
		notificationImpl.setSingleUserId(
			this.<String>getColumnOriginalValue("singleUserId"));
		notificationImpl.setPublicationDate(
			this.<Date>getColumnOriginalValue("publicationDate"));
		notificationImpl.setExpirationDate(
			this.<Date>getColumnOriginalValue("expirationDate"));
		notificationImpl.setStatus(
			this.<Integer>getColumnOriginalValue("status"));
		notificationImpl.setTypeId(this.<Long>getColumnOriginalValue("typeId"));

		return notificationImpl;
	}

	@Override
	public int compareTo(Notification notification) {
		long primaryKey = notification.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Notification)) {
			return false;
		}

		Notification notification = (Notification)object;

		long primaryKey = notification.getPrimaryKey();

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
	public CacheModel<Notification> toCacheModel() {
		NotificationCacheModel notificationCacheModel =
			new NotificationCacheModel();

		notificationCacheModel.notificationId = getNotificationId();

		notificationCacheModel.title = getTitle();

		String title = notificationCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			notificationCacheModel.title = null;
		}

		notificationCacheModel.description = getDescription();

		String description = notificationCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			notificationCacheModel.description = null;
		}

		notificationCacheModel.url = getUrl();

		String url = notificationCacheModel.url;

		if ((url != null) && (url.length() == 0)) {
			notificationCacheModel.url = null;
		}

		notificationCacheModel.automatic = isAutomatic();

		notificationCacheModel.singleUser = isSingleUser();

		notificationCacheModel.singleUserId = getSingleUserId();

		String singleUserId = notificationCacheModel.singleUserId;

		if ((singleUserId != null) && (singleUserId.length() == 0)) {
			notificationCacheModel.singleUserId = null;
		}

		Date publicationDate = getPublicationDate();

		if (publicationDate != null) {
			notificationCacheModel.publicationDate = publicationDate.getTime();
		}
		else {
			notificationCacheModel.publicationDate = Long.MIN_VALUE;
		}

		Date expirationDate = getExpirationDate();

		if (expirationDate != null) {
			notificationCacheModel.expirationDate = expirationDate.getTime();
		}
		else {
			notificationCacheModel.expirationDate = Long.MIN_VALUE;
		}

		notificationCacheModel.status = getStatus();

		notificationCacheModel.typeId = getTypeId();

		return notificationCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Notification, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Notification, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Notification, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((Notification)this);

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

		private static final Function<InvocationHandler, Notification>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					Notification.class, ModelWrapper.class);

	}

	private long _notificationId;
	private String _title;
	private String _titleCurrentLanguageId;
	private String _description;
	private String _descriptionCurrentLanguageId;
	private String _url;
	private boolean _automatic;
	private boolean _singleUser;
	private String _singleUserId;
	private Date _publicationDate;
	private Date _expirationDate;
	private int _status;
	private long _typeId;

	public <T> T getColumnValue(String columnName) {
		Function<Notification, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Notification)this);
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

		_columnOriginalValues.put("notificationId", _notificationId);
		_columnOriginalValues.put("title", _title);
		_columnOriginalValues.put("description", _description);
		_columnOriginalValues.put("url", _url);
		_columnOriginalValues.put("automatic", _automatic);
		_columnOriginalValues.put("singleUser", _singleUser);
		_columnOriginalValues.put("singleUserId", _singleUserId);
		_columnOriginalValues.put("publicationDate", _publicationDate);
		_columnOriginalValues.put("expirationDate", _expirationDate);
		_columnOriginalValues.put("status", _status);
		_columnOriginalValues.put("typeId", _typeId);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("notificationId", 1L);

		columnBitmasks.put("title", 2L);

		columnBitmasks.put("description", 4L);

		columnBitmasks.put("url", 8L);

		columnBitmasks.put("automatic", 16L);

		columnBitmasks.put("singleUser", 32L);

		columnBitmasks.put("singleUserId", 64L);

		columnBitmasks.put("publicationDate", 128L);

		columnBitmasks.put("expirationDate", 256L);

		columnBitmasks.put("status", 512L);

		columnBitmasks.put("typeId", 1024L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Notification _escapedModel;

}