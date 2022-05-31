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
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import eu.strasbourg.service.gtfs.model.CacheAlertJSON;
import eu.strasbourg.service.gtfs.model.CacheAlertJSONModel;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the CacheAlertJSON service. Represents a row in the &quot;gtfs_CacheAlertJSON&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>CacheAlertJSONModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CacheAlertJSONImpl}.
 * </p>
 *
 * @author Cedric Henry
 * @see CacheAlertJSONImpl
 * @generated
 */
public class CacheAlertJSONModelImpl
	extends BaseModelImpl<CacheAlertJSON> implements CacheAlertJSONModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a cache alert json model instance should use the <code>CacheAlertJSON</code> interface instead.
	 */
	public static final String TABLE_NAME = "gtfs_CacheAlertJSON";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"cacheId", Types.BIGINT},
		{"jsonAlert", Types.CLOB}, {"creationDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("cacheId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("jsonAlert", Types.CLOB);
		TABLE_COLUMNS_MAP.put("creationDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table gtfs_CacheAlertJSON (uuid_ VARCHAR(75) null,cacheId LONG not null primary key,jsonAlert TEXT null,creationDate DATE null,modifiedDate DATE null)";

	public static final String TABLE_SQL_DROP =
		"drop table gtfs_CacheAlertJSON";

	public static final String ORDER_BY_JPQL =
		" ORDER BY cacheAlertJSON.cacheId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY gtfs_CacheAlertJSON.cacheId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.gtfs.service.util.PropsUtil.get(
			"value.object.entity.cache.enabled.eu.strasbourg.service.gtfs.model.CacheAlertJSON"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.gtfs.service.util.PropsUtil.get(
			"value.object.finder.cache.enabled.eu.strasbourg.service.gtfs.model.CacheAlertJSON"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.gtfs.service.util.PropsUtil.get(
			"value.object.column.bitmask.enabled.eu.strasbourg.service.gtfs.model.CacheAlertJSON"),
		true);

	public static final long CACHEID_COLUMN_BITMASK = 1L;

	public static final long UUID_COLUMN_BITMASK = 2L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		eu.strasbourg.service.gtfs.service.util.PropsUtil.get(
			"lock.expiration.time.eu.strasbourg.service.gtfs.model.CacheAlertJSON"));

	public CacheAlertJSONModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _cacheId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCacheId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _cacheId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CacheAlertJSON.class;
	}

	@Override
	public String getModelClassName() {
		return CacheAlertJSON.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CacheAlertJSON, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CacheAlertJSON, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CacheAlertJSON, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((CacheAlertJSON)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CacheAlertJSON, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CacheAlertJSON, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CacheAlertJSON)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CacheAlertJSON, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CacheAlertJSON, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, CacheAlertJSON>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			CacheAlertJSON.class.getClassLoader(), CacheAlertJSON.class,
			ModelWrapper.class);

		try {
			Constructor<CacheAlertJSON> constructor =
				(Constructor<CacheAlertJSON>)proxyClass.getConstructor(
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

	private static final Map<String, Function<CacheAlertJSON, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<CacheAlertJSON, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<CacheAlertJSON, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<CacheAlertJSON, Object>>();
		Map<String, BiConsumer<CacheAlertJSON, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<CacheAlertJSON, ?>>();

		attributeGetterFunctions.put(
			"uuid",
			new Function<CacheAlertJSON, Object>() {

				@Override
				public Object apply(CacheAlertJSON cacheAlertJSON) {
					return cacheAlertJSON.getUuid();
				}

			});
		attributeSetterBiConsumers.put(
			"uuid",
			new BiConsumer<CacheAlertJSON, Object>() {

				@Override
				public void accept(
					CacheAlertJSON cacheAlertJSON, Object uuidObject) {

					cacheAlertJSON.setUuid((String)uuidObject);
				}

			});
		attributeGetterFunctions.put(
			"cacheId",
			new Function<CacheAlertJSON, Object>() {

				@Override
				public Object apply(CacheAlertJSON cacheAlertJSON) {
					return cacheAlertJSON.getCacheId();
				}

			});
		attributeSetterBiConsumers.put(
			"cacheId",
			new BiConsumer<CacheAlertJSON, Object>() {

				@Override
				public void accept(
					CacheAlertJSON cacheAlertJSON, Object cacheIdObject) {

					cacheAlertJSON.setCacheId((Long)cacheIdObject);
				}

			});
		attributeGetterFunctions.put(
			"jsonAlert",
			new Function<CacheAlertJSON, Object>() {

				@Override
				public Object apply(CacheAlertJSON cacheAlertJSON) {
					return cacheAlertJSON.getJsonAlert();
				}

			});
		attributeSetterBiConsumers.put(
			"jsonAlert",
			new BiConsumer<CacheAlertJSON, Object>() {

				@Override
				public void accept(
					CacheAlertJSON cacheAlertJSON, Object jsonAlertObject) {

					cacheAlertJSON.setJsonAlert((String)jsonAlertObject);
				}

			});
		attributeGetterFunctions.put(
			"creationDate",
			new Function<CacheAlertJSON, Object>() {

				@Override
				public Object apply(CacheAlertJSON cacheAlertJSON) {
					return cacheAlertJSON.getCreationDate();
				}

			});
		attributeSetterBiConsumers.put(
			"creationDate",
			new BiConsumer<CacheAlertJSON, Object>() {

				@Override
				public void accept(
					CacheAlertJSON cacheAlertJSON, Object creationDateObject) {

					cacheAlertJSON.setCreationDate((Date)creationDateObject);
				}

			});
		attributeGetterFunctions.put(
			"modifiedDate",
			new Function<CacheAlertJSON, Object>() {

				@Override
				public Object apply(CacheAlertJSON cacheAlertJSON) {
					return cacheAlertJSON.getModifiedDate();
				}

			});
		attributeSetterBiConsumers.put(
			"modifiedDate",
			new BiConsumer<CacheAlertJSON, Object>() {

				@Override
				public void accept(
					CacheAlertJSON cacheAlertJSON, Object modifiedDateObject) {

					cacheAlertJSON.setModifiedDate((Date)modifiedDateObject);
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
	public long getCacheId() {
		return _cacheId;
	}

	@Override
	public void setCacheId(long cacheId) {
		_columnBitmask |= CACHEID_COLUMN_BITMASK;

		if (!_setOriginalCacheId) {
			_setOriginalCacheId = true;

			_originalCacheId = _cacheId;
		}

		_cacheId = cacheId;
	}

	public long getOriginalCacheId() {
		return _originalCacheId;
	}

	@Override
	public String getJsonAlert() {
		if (_jsonAlert == null) {
			return "";
		}
		else {
			return _jsonAlert;
		}
	}

	@Override
	public void setJsonAlert(String jsonAlert) {
		_jsonAlert = jsonAlert;
	}

	@Override
	public Date getCreationDate() {
		return _creationDate;
	}

	@Override
	public void setCreationDate(Date creationDate) {
		_creationDate = creationDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, CacheAlertJSON.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CacheAlertJSON toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CacheAlertJSON>
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
		CacheAlertJSONImpl cacheAlertJSONImpl = new CacheAlertJSONImpl();

		cacheAlertJSONImpl.setUuid(getUuid());
		cacheAlertJSONImpl.setCacheId(getCacheId());
		cacheAlertJSONImpl.setJsonAlert(getJsonAlert());
		cacheAlertJSONImpl.setCreationDate(getCreationDate());
		cacheAlertJSONImpl.setModifiedDate(getModifiedDate());

		cacheAlertJSONImpl.resetOriginalValues();

		return cacheAlertJSONImpl;
	}

	@Override
	public int compareTo(CacheAlertJSON cacheAlertJSON) {
		long primaryKey = cacheAlertJSON.getPrimaryKey();

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

		if (!(object instanceof CacheAlertJSON)) {
			return false;
		}

		CacheAlertJSON cacheAlertJSON = (CacheAlertJSON)object;

		long primaryKey = cacheAlertJSON.getPrimaryKey();

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
		CacheAlertJSONModelImpl cacheAlertJSONModelImpl = this;

		cacheAlertJSONModelImpl._originalUuid = cacheAlertJSONModelImpl._uuid;

		cacheAlertJSONModelImpl._originalCacheId =
			cacheAlertJSONModelImpl._cacheId;

		cacheAlertJSONModelImpl._setOriginalCacheId = false;

		cacheAlertJSONModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CacheAlertJSON> toCacheModel() {
		CacheAlertJSONCacheModel cacheAlertJSONCacheModel =
			new CacheAlertJSONCacheModel();

		cacheAlertJSONCacheModel.uuid = getUuid();

		String uuid = cacheAlertJSONCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			cacheAlertJSONCacheModel.uuid = null;
		}

		cacheAlertJSONCacheModel.cacheId = getCacheId();

		cacheAlertJSONCacheModel.jsonAlert = getJsonAlert();

		String jsonAlert = cacheAlertJSONCacheModel.jsonAlert;

		if ((jsonAlert != null) && (jsonAlert.length() == 0)) {
			cacheAlertJSONCacheModel.jsonAlert = null;
		}

		Date creationDate = getCreationDate();

		if (creationDate != null) {
			cacheAlertJSONCacheModel.creationDate = creationDate.getTime();
		}
		else {
			cacheAlertJSONCacheModel.creationDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			cacheAlertJSONCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			cacheAlertJSONCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		return cacheAlertJSONCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CacheAlertJSON, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CacheAlertJSON, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CacheAlertJSON, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((CacheAlertJSON)this));
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
		Map<String, Function<CacheAlertJSON, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CacheAlertJSON, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CacheAlertJSON, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((CacheAlertJSON)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, CacheAlertJSON>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private String _originalUuid;
	private long _cacheId;
	private long _originalCacheId;
	private boolean _setOriginalCacheId;
	private String _jsonAlert;
	private Date _creationDate;
	private Date _modifiedDate;
	private long _columnBitmask;
	private CacheAlertJSON _escapedModel;

}