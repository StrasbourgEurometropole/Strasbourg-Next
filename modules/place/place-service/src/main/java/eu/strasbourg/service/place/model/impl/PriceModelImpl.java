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

package eu.strasbourg.service.place.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import eu.strasbourg.service.place.model.Price;
import eu.strasbourg.service.place.model.PriceModel;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Price service. Represents a row in the &quot;place_Price&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>PriceModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PriceImpl}.
 * </p>
 *
 * @author Angelique Zunino Champougny
 * @see PriceImpl
 * @generated
 */
public class PriceModelImpl extends BaseModelImpl<Price> implements PriceModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a price model instance should use the <code>Price</code> interface instead.
	 */
	public static final String TABLE_NAME = "place_Price";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"priceId", Types.BIGINT},
		{"status", Types.INTEGER}, {"statusByUserId", Types.BIGINT},
		{"statusByUserName", Types.VARCHAR}, {"statusDate", Types.TIMESTAMP},
		{"title", Types.VARCHAR}, {"priceDescription", Types.CLOB}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("priceId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("statusByUserId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("statusByUserName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("statusDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("title", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("priceDescription", Types.CLOB);
	}

	public static final String TABLE_SQL_CREATE =
		"create table place_Price (uuid_ VARCHAR(75) null,priceId LONG not null primary key,status INTEGER,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null,title STRING null,priceDescription TEXT null)";

	public static final String TABLE_SQL_DROP = "drop table place_Price";

	public static final String ORDER_BY_JPQL = " ORDER BY price.priceId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY place_Price.priceId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.place.service.util.PropsUtil.get(
			"value.object.entity.cache.enabled.eu.strasbourg.service.place.model.Price"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.place.service.util.PropsUtil.get(
			"value.object.finder.cache.enabled.eu.strasbourg.service.place.model.Price"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.place.service.util.PropsUtil.get(
			"value.object.column.bitmask.enabled.eu.strasbourg.service.place.model.Price"),
		true);

	public static final long UUID_COLUMN_BITMASK = 1L;

	public static final long PRICEID_COLUMN_BITMASK = 2L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		eu.strasbourg.service.place.service.util.PropsUtil.get(
			"lock.expiration.time.eu.strasbourg.service.place.model.Price"));

	public PriceModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _priceId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPriceId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _priceId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Price.class;
	}

	@Override
	public String getModelClassName() {
		return Price.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Price, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Price, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Price, Object> attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Price)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Price, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Price, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept((Price)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Price, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Price, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Price>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Price.class.getClassLoader(), Price.class, ModelWrapper.class);

		try {
			Constructor<Price> constructor =
				(Constructor<Price>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<Price, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Price, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Price, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Price, Object>>();
		Map<String, BiConsumer<Price, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Price, ?>>();

		attributeGetterFunctions.put(
			"uuid",
			new Function<Price, Object>() {

				@Override
				public Object apply(Price price) {
					return price.getUuid();
				}

			});
		attributeSetterBiConsumers.put(
			"uuid",
			new BiConsumer<Price, Object>() {

				@Override
				public void accept(Price price, Object uuidObject) {
					price.setUuid((String)uuidObject);
				}

			});
		attributeGetterFunctions.put(
			"priceId",
			new Function<Price, Object>() {

				@Override
				public Object apply(Price price) {
					return price.getPriceId();
				}

			});
		attributeSetterBiConsumers.put(
			"priceId",
			new BiConsumer<Price, Object>() {

				@Override
				public void accept(Price price, Object priceIdObject) {
					price.setPriceId((Long)priceIdObject);
				}

			});
		attributeGetterFunctions.put(
			"status",
			new Function<Price, Object>() {

				@Override
				public Object apply(Price price) {
					return price.getStatus();
				}

			});
		attributeSetterBiConsumers.put(
			"status",
			new BiConsumer<Price, Object>() {

				@Override
				public void accept(Price price, Object statusObject) {
					price.setStatus((Integer)statusObject);
				}

			});
		attributeGetterFunctions.put(
			"statusByUserId",
			new Function<Price, Object>() {

				@Override
				public Object apply(Price price) {
					return price.getStatusByUserId();
				}

			});
		attributeSetterBiConsumers.put(
			"statusByUserId",
			new BiConsumer<Price, Object>() {

				@Override
				public void accept(Price price, Object statusByUserIdObject) {
					price.setStatusByUserId((Long)statusByUserIdObject);
				}

			});
		attributeGetterFunctions.put(
			"statusByUserName",
			new Function<Price, Object>() {

				@Override
				public Object apply(Price price) {
					return price.getStatusByUserName();
				}

			});
		attributeSetterBiConsumers.put(
			"statusByUserName",
			new BiConsumer<Price, Object>() {

				@Override
				public void accept(Price price, Object statusByUserNameObject) {
					price.setStatusByUserName((String)statusByUserNameObject);
				}

			});
		attributeGetterFunctions.put(
			"statusDate",
			new Function<Price, Object>() {

				@Override
				public Object apply(Price price) {
					return price.getStatusDate();
				}

			});
		attributeSetterBiConsumers.put(
			"statusDate",
			new BiConsumer<Price, Object>() {

				@Override
				public void accept(Price price, Object statusDateObject) {
					price.setStatusDate((Date)statusDateObject);
				}

			});
		attributeGetterFunctions.put(
			"title",
			new Function<Price, Object>() {

				@Override
				public Object apply(Price price) {
					return price.getTitle();
				}

			});
		attributeSetterBiConsumers.put(
			"title",
			new BiConsumer<Price, Object>() {

				@Override
				public void accept(Price price, Object titleObject) {
					price.setTitle((String)titleObject);
				}

			});
		attributeGetterFunctions.put(
			"priceDescription",
			new Function<Price, Object>() {

				@Override
				public Object apply(Price price) {
					return price.getPriceDescription();
				}

			});
		attributeSetterBiConsumers.put(
			"priceDescription",
			new BiConsumer<Price, Object>() {

				@Override
				public void accept(Price price, Object priceDescriptionObject) {
					price.setPriceDescription((String)priceDescriptionObject);
				}

			});

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
		_columnBitmask |= UUID_COLUMN_BITMASK;

		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@Override
	public long getPriceId() {
		return _priceId;
	}

	@Override
	public void setPriceId(long priceId) {
		_priceId = priceId;
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;
	}

	@Override
	public long getStatusByUserId() {
		return _statusByUserId;
	}

	@Override
	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	@Override
	public String getStatusByUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getStatusByUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
	}

	@Override
	public String getStatusByUserName() {
		if (_statusByUserName == null) {
			return "";
		}
		else {
			return _statusByUserName;
		}
	}

	@Override
	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	@Override
	public Date getStatusDate() {
		return _statusDate;
	}

	@Override
	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

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

	@Override
	public String getPriceDescription() {
		if (_priceDescription == null) {
			return "";
		}
		else {
			return _priceDescription;
		}
	}

	@Override
	public String getPriceDescription(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getPriceDescription(languageId);
	}

	@Override
	public String getPriceDescription(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getPriceDescription(languageId, useDefault);
	}

	@Override
	public String getPriceDescription(String languageId) {
		return LocalizationUtil.getLocalization(
			getPriceDescription(), languageId);
	}

	@Override
	public String getPriceDescription(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(
			getPriceDescription(), languageId, useDefault);
	}

	@Override
	public String getPriceDescriptionCurrentLanguageId() {
		return _priceDescriptionCurrentLanguageId;
	}

	@JSON
	@Override
	public String getPriceDescriptionCurrentValue() {
		Locale locale = getLocale(_priceDescriptionCurrentLanguageId);

		return getPriceDescription(locale);
	}

	@Override
	public Map<Locale, String> getPriceDescriptionMap() {
		return LocalizationUtil.getLocalizationMap(getPriceDescription());
	}

	@Override
	public void setPriceDescription(String priceDescription) {
		_priceDescription = priceDescription;
	}

	@Override
	public void setPriceDescription(String priceDescription, Locale locale) {
		setPriceDescription(priceDescription, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setPriceDescription(
		String priceDescription, Locale locale, Locale defaultLocale) {

		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(priceDescription)) {
			setPriceDescription(
				LocalizationUtil.updateLocalization(
					getPriceDescription(), "PriceDescription", priceDescription,
					languageId, defaultLanguageId));
		}
		else {
			setPriceDescription(
				LocalizationUtil.removeLocalization(
					getPriceDescription(), "PriceDescription", languageId));
		}
	}

	@Override
	public void setPriceDescriptionCurrentLanguageId(String languageId) {
		_priceDescriptionCurrentLanguageId = languageId;
	}

	@Override
	public void setPriceDescriptionMap(
		Map<Locale, String> priceDescriptionMap) {

		setPriceDescriptionMap(priceDescriptionMap, LocaleUtil.getDefault());
	}

	@Override
	public void setPriceDescriptionMap(
		Map<Locale, String> priceDescriptionMap, Locale defaultLocale) {

		if (priceDescriptionMap == null) {
			return;
		}

		setPriceDescription(
			LocalizationUtil.updateLocalization(
				priceDescriptionMap, getPriceDescription(), "PriceDescription",
				LocaleUtil.toLanguageId(defaultLocale)));
	}

	@Override
	public boolean isApproved() {
		if (getStatus() == WorkflowConstants.STATUS_APPROVED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDenied() {
		if (getStatus() == WorkflowConstants.STATUS_DENIED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDraft() {
		if (getStatus() == WorkflowConstants.STATUS_DRAFT) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isExpired() {
		if (getStatus() == WorkflowConstants.STATUS_EXPIRED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isInactive() {
		if (getStatus() == WorkflowConstants.STATUS_INACTIVE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isIncomplete() {
		if (getStatus() == WorkflowConstants.STATUS_INCOMPLETE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isPending() {
		if (getStatus() == WorkflowConstants.STATUS_PENDING) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isScheduled() {
		if (getStatus() == WorkflowConstants.STATUS_SCHEDULED) {
			return true;
		}
		else {
			return false;
		}
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, Price.class.getName(), getPrimaryKey());
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

		Map<Locale, String> priceDescriptionMap = getPriceDescriptionMap();

		for (Map.Entry<Locale, String> entry : priceDescriptionMap.entrySet()) {
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
			Price.class.getName(), getPrimaryKey(), defaultLocale,
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

		String priceDescription = getPriceDescription(defaultLocale);

		if (Validator.isNull(priceDescription)) {
			setPriceDescription(
				getPriceDescription(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setPriceDescription(
				getPriceDescription(defaultLocale), defaultLocale,
				defaultLocale);
		}
	}

	@Override
	public Price toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Price>
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
		PriceImpl priceImpl = new PriceImpl();

		priceImpl.setUuid(getUuid());
		priceImpl.setPriceId(getPriceId());
		priceImpl.setStatus(getStatus());
		priceImpl.setStatusByUserId(getStatusByUserId());
		priceImpl.setStatusByUserName(getStatusByUserName());
		priceImpl.setStatusDate(getStatusDate());
		priceImpl.setTitle(getTitle());
		priceImpl.setPriceDescription(getPriceDescription());

		priceImpl.resetOriginalValues();

		return priceImpl;
	}

	@Override
	public int compareTo(Price price) {
		long primaryKey = price.getPrimaryKey();

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

		if (!(object instanceof Price)) {
			return false;
		}

		Price price = (Price)object;

		long primaryKey = price.getPrimaryKey();

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

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		PriceModelImpl priceModelImpl = this;

		priceModelImpl._originalUuid = priceModelImpl._uuid;

		priceModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Price> toCacheModel() {
		PriceCacheModel priceCacheModel = new PriceCacheModel();

		priceCacheModel.uuid = getUuid();

		String uuid = priceCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			priceCacheModel.uuid = null;
		}

		priceCacheModel.priceId = getPriceId();

		priceCacheModel.status = getStatus();

		priceCacheModel.statusByUserId = getStatusByUserId();

		priceCacheModel.statusByUserName = getStatusByUserName();

		String statusByUserName = priceCacheModel.statusByUserName;

		if ((statusByUserName != null) && (statusByUserName.length() == 0)) {
			priceCacheModel.statusByUserName = null;
		}

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			priceCacheModel.statusDate = statusDate.getTime();
		}
		else {
			priceCacheModel.statusDate = Long.MIN_VALUE;
		}

		priceCacheModel.title = getTitle();

		String title = priceCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			priceCacheModel.title = null;
		}

		priceCacheModel.priceDescription = getPriceDescription();

		String priceDescription = priceCacheModel.priceDescription;

		if ((priceDescription != null) && (priceDescription.length() == 0)) {
			priceCacheModel.priceDescription = null;
		}

		return priceCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Price, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Price, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Price, Object> attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Price)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<Price, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Price, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Price, Object> attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Price)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Price>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private String _originalUuid;
	private long _priceId;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private String _title;
	private String _titleCurrentLanguageId;
	private String _priceDescription;
	private String _priceDescriptionCurrentLanguageId;
	private long _columnBitmask;
	private Price _escapedModel;

}