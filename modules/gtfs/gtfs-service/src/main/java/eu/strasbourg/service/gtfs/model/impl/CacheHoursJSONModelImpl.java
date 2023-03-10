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

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;
import eu.strasbourg.service.gtfs.model.CacheHoursJSON;
import eu.strasbourg.service.gtfs.model.CacheHoursJSONModel;
import eu.strasbourg.service.gtfs.service.persistence.CacheHoursJSONPK;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.sql.Blob;
import java.sql.Types;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the CacheHoursJSON service. Represents a row in the &quot;gtfs_CacheHoursJSON&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>CacheHoursJSONModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CacheHoursJSONImpl}.
 * </p>
 *
 * @author Cedric Henry
 * @see CacheHoursJSONImpl
 * @generated
 */
public class CacheHoursJSONModelImpl
	extends BaseModelImpl<CacheHoursJSON> implements CacheHoursJSONModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a cache hours json model instance should use the <code>CacheHoursJSON</code> interface instead.
	 */
	public static final String TABLE_NAME = "gtfs_CacheHoursJSON";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"stopCode", Types.VARCHAR},
		{"type_", Types.INTEGER}, {"jsonHour", Types.CLOB},
		{"creationDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("stopCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("type_", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("jsonHour", Types.CLOB);
		TABLE_COLUMNS_MAP.put("creationDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table gtfs_CacheHoursJSON (uuid_ VARCHAR(75) null,stopCode VARCHAR(75) not null,type_ INTEGER not null,jsonHour TEXT null,creationDate DATE null,modifiedDate DATE null,primary key (stopCode, type_))";

	public static final String TABLE_SQL_DROP =
		"drop table gtfs_CacheHoursJSON";

	public static final String ORDER_BY_JPQL =
		" ORDER BY cacheHoursJSON.id.stopCode ASC, cacheHoursJSON.id.type ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY gtfs_CacheHoursJSON.stopCode ASC, gtfs_CacheHoursJSON.type_ ASC";

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
	public static final long STOPCODE_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long TYPE_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 4L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		eu.strasbourg.service.gtfs.service.util.PropsUtil.get(
			"lock.expiration.time.eu.strasbourg.service.gtfs.model.CacheHoursJSON"));

	public CacheHoursJSONModelImpl() {
	}

	@Override
	public CacheHoursJSONPK getPrimaryKey() {
		return new CacheHoursJSONPK(_stopCode, _type);
	}

	@Override
	public void setPrimaryKey(CacheHoursJSONPK primaryKey) {
		setStopCode(primaryKey.stopCode);
		setType(primaryKey.type);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new CacheHoursJSONPK(_stopCode, _type);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((CacheHoursJSONPK)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return CacheHoursJSON.class;
	}

	@Override
	public String getModelClassName() {
		return CacheHoursJSON.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CacheHoursJSON, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CacheHoursJSON, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CacheHoursJSON, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((CacheHoursJSON)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CacheHoursJSON, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CacheHoursJSON, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CacheHoursJSON)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CacheHoursJSON, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CacheHoursJSON, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<CacheHoursJSON, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<CacheHoursJSON, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<CacheHoursJSON, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<CacheHoursJSON, Object>>();
		Map<String, BiConsumer<CacheHoursJSON, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<CacheHoursJSON, ?>>();

		attributeGetterFunctions.put("uuid", CacheHoursJSON::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<CacheHoursJSON, String>)CacheHoursJSON::setUuid);
		attributeGetterFunctions.put("stopCode", CacheHoursJSON::getStopCode);
		attributeSetterBiConsumers.put(
			"stopCode",
			(BiConsumer<CacheHoursJSON, String>)CacheHoursJSON::setStopCode);
		attributeGetterFunctions.put("type", CacheHoursJSON::getType);
		attributeSetterBiConsumers.put(
			"type",
			(BiConsumer<CacheHoursJSON, Integer>)CacheHoursJSON::setType);
		attributeGetterFunctions.put("jsonHour", CacheHoursJSON::getJsonHour);
		attributeSetterBiConsumers.put(
			"jsonHour",
			(BiConsumer<CacheHoursJSON, String>)CacheHoursJSON::setJsonHour);
		attributeGetterFunctions.put(
			"creationDate", CacheHoursJSON::getCreationDate);
		attributeSetterBiConsumers.put(
			"creationDate",
			(BiConsumer<CacheHoursJSON, Date>)CacheHoursJSON::setCreationDate);
		attributeGetterFunctions.put(
			"modifiedDate", CacheHoursJSON::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<CacheHoursJSON, Date>)CacheHoursJSON::setModifiedDate);

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
	public String getStopCode() {
		if (_stopCode == null) {
			return "";
		}
		else {
			return _stopCode;
		}
	}

	@Override
	public void setStopCode(String stopCode) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_stopCode = stopCode;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalStopCode() {
		return getColumnOriginalValue("stopCode");
	}

	@Override
	public int getType() {
		return _type;
	}

	@Override
	public void setType(int type) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_type = type;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public int getOriginalType() {
		return GetterUtil.getInteger(
			this.<Integer>getColumnOriginalValue("type_"));
	}

	@Override
	public String getJsonHour() {
		if (_jsonHour == null) {
			return "";
		}
		else {
			return _jsonHour;
		}
	}

	@Override
	public void setJsonHour(String jsonHour) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_jsonHour = jsonHour;
	}

	@Override
	public Date getCreationDate() {
		return _creationDate;
	}

	@Override
	public void setCreationDate(Date creationDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_creationDate = creationDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
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
	public CacheHoursJSON toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CacheHoursJSON>
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
		CacheHoursJSONImpl cacheHoursJSONImpl = new CacheHoursJSONImpl();

		cacheHoursJSONImpl.setUuid(getUuid());
		cacheHoursJSONImpl.setStopCode(getStopCode());
		cacheHoursJSONImpl.setType(getType());
		cacheHoursJSONImpl.setJsonHour(getJsonHour());
		cacheHoursJSONImpl.setCreationDate(getCreationDate());
		cacheHoursJSONImpl.setModifiedDate(getModifiedDate());

		cacheHoursJSONImpl.resetOriginalValues();

		return cacheHoursJSONImpl;
	}

	@Override
	public CacheHoursJSON cloneWithOriginalValues() {
		CacheHoursJSONImpl cacheHoursJSONImpl = new CacheHoursJSONImpl();

		cacheHoursJSONImpl.setUuid(
			this.<String>getColumnOriginalValue("uuid_"));
		cacheHoursJSONImpl.setStopCode(
			this.<String>getColumnOriginalValue("stopCode"));
		cacheHoursJSONImpl.setType(
			this.<Integer>getColumnOriginalValue("type_"));
		cacheHoursJSONImpl.setJsonHour(
			this.<String>getColumnOriginalValue("jsonHour"));
		cacheHoursJSONImpl.setCreationDate(
			this.<Date>getColumnOriginalValue("creationDate"));
		cacheHoursJSONImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));

		return cacheHoursJSONImpl;
	}

	@Override
	public int compareTo(CacheHoursJSON cacheHoursJSON) {
		CacheHoursJSONPK primaryKey = cacheHoursJSON.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CacheHoursJSON)) {
			return false;
		}

		CacheHoursJSON cacheHoursJSON = (CacheHoursJSON)object;

		CacheHoursJSONPK primaryKey = cacheHoursJSON.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
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

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<CacheHoursJSON> toCacheModel() {
		CacheHoursJSONCacheModel cacheHoursJSONCacheModel =
			new CacheHoursJSONCacheModel();

		cacheHoursJSONCacheModel.cacheHoursJSONPK = getPrimaryKey();

		cacheHoursJSONCacheModel.uuid = getUuid();

		String uuid = cacheHoursJSONCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			cacheHoursJSONCacheModel.uuid = null;
		}

		cacheHoursJSONCacheModel.stopCode = getStopCode();

		String stopCode = cacheHoursJSONCacheModel.stopCode;

		if ((stopCode != null) && (stopCode.length() == 0)) {
			cacheHoursJSONCacheModel.stopCode = null;
		}

		cacheHoursJSONCacheModel.type = getType();

		cacheHoursJSONCacheModel.jsonHour = getJsonHour();

		String jsonHour = cacheHoursJSONCacheModel.jsonHour;

		if ((jsonHour != null) && (jsonHour.length() == 0)) {
			cacheHoursJSONCacheModel.jsonHour = null;
		}

		Date creationDate = getCreationDate();

		if (creationDate != null) {
			cacheHoursJSONCacheModel.creationDate = creationDate.getTime();
		}
		else {
			cacheHoursJSONCacheModel.creationDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			cacheHoursJSONCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			cacheHoursJSONCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		return cacheHoursJSONCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CacheHoursJSON, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CacheHoursJSON, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CacheHoursJSON, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((CacheHoursJSON)this);

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

		private static final Function<InvocationHandler, CacheHoursJSON>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					CacheHoursJSON.class, ModelWrapper.class);

	}

	private String _uuid;
	private String _stopCode;
	private int _type;
	private String _jsonHour;
	private Date _creationDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<CacheHoursJSON, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((CacheHoursJSON)this);
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
		_columnOriginalValues.put("stopCode", _stopCode);
		_columnOriginalValues.put("type_", _type);
		_columnOriginalValues.put("jsonHour", _jsonHour);
		_columnOriginalValues.put("creationDate", _creationDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");
		attributeNames.put("type_", "type");

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

		columnBitmasks.put("stopCode", 2L);

		columnBitmasks.put("type_", 4L);

		columnBitmasks.put("jsonHour", 8L);

		columnBitmasks.put("creationDate", 16L);

		columnBitmasks.put("modifiedDate", 32L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private CacheHoursJSON _escapedModel;

}