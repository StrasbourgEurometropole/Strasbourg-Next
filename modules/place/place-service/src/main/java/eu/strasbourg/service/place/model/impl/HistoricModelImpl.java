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

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import eu.strasbourg.service.place.model.Historic;
import eu.strasbourg.service.place.model.HistoricModel;

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
 * The base model implementation for the Historic service. Represents a row in the &quot;place_Historic&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>HistoricModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link HistoricImpl}.
 * </p>
 *
 * @author Angelique Zunino Champougny
 * @see HistoricImpl
 * @generated
 */
public class HistoricModelImpl
	extends BaseModelImpl<Historic> implements HistoricModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a historic model instance should use the <code>Historic</code> interface instead.
	 */
	public static final String TABLE_NAME = "place_Historic";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"sigId", Types.VARCHAR},
		{"name", Types.VARCHAR}, {"suppressionDate", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("sigId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("suppressionDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table place_Historic (uuid_ VARCHAR(75) null,sigId VARCHAR(75) not null primary key,name VARCHAR(75) null,suppressionDate DATE null)";

	public static final String TABLE_SQL_DROP = "drop table place_Historic";

	public static final String ORDER_BY_JPQL = " ORDER BY historic.sigId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY place_Historic.sigId ASC";

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
	public static final long SUPPRESSIONDATE_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long SIGID_COLUMN_BITMASK = 4L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		eu.strasbourg.service.place.service.util.PropsUtil.get(
			"lock.expiration.time.eu.strasbourg.service.place.model.Historic"));

	public HistoricModelImpl() {
	}

	@Override
	public String getPrimaryKey() {
		return _sigId;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setSigId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _sigId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return Historic.class;
	}

	@Override
	public String getModelClassName() {
		return Historic.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Historic, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Historic, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Historic, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Historic)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Historic, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Historic, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Historic)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Historic, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Historic, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<Historic, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Historic, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Historic, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Historic, Object>>();
		Map<String, BiConsumer<Historic, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Historic, ?>>();

		attributeGetterFunctions.put("uuid", Historic::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<Historic, String>)Historic::setUuid);
		attributeGetterFunctions.put("sigId", Historic::getSigId);
		attributeSetterBiConsumers.put(
			"sigId", (BiConsumer<Historic, String>)Historic::setSigId);
		attributeGetterFunctions.put("name", Historic::getName);
		attributeSetterBiConsumers.put(
			"name", (BiConsumer<Historic, String>)Historic::setName);
		attributeGetterFunctions.put(
			"suppressionDate", Historic::getSuppressionDate);
		attributeSetterBiConsumers.put(
			"suppressionDate",
			(BiConsumer<Historic, Date>)Historic::setSuppressionDate);

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
	public String getSigId() {
		if (_sigId == null) {
			return "";
		}
		else {
			return _sigId;
		}
	}

	@Override
	public void setSigId(String sigId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_sigId = sigId;
	}

	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_name = name;
	}

	@Override
	public Date getSuppressionDate() {
		return _suppressionDate;
	}

	@Override
	public void setSuppressionDate(Date suppressionDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_suppressionDate = suppressionDate;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public Date getOriginalSuppressionDate() {
		return getColumnOriginalValue("suppressionDate");
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
	public Historic toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Historic>
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
		HistoricImpl historicImpl = new HistoricImpl();

		historicImpl.setUuid(getUuid());
		historicImpl.setSigId(getSigId());
		historicImpl.setName(getName());
		historicImpl.setSuppressionDate(getSuppressionDate());

		historicImpl.resetOriginalValues();

		return historicImpl;
	}

	@Override
	public Historic cloneWithOriginalValues() {
		HistoricImpl historicImpl = new HistoricImpl();

		historicImpl.setUuid(this.<String>getColumnOriginalValue("uuid_"));
		historicImpl.setSigId(this.<String>getColumnOriginalValue("sigId"));
		historicImpl.setName(this.<String>getColumnOriginalValue("name"));
		historicImpl.setSuppressionDate(
			this.<Date>getColumnOriginalValue("suppressionDate"));

		return historicImpl;
	}

	@Override
	public int compareTo(Historic historic) {
		String primaryKey = historic.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Historic)) {
			return false;
		}

		Historic historic = (Historic)object;

		String primaryKey = historic.getPrimaryKey();

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

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<Historic> toCacheModel() {
		HistoricCacheModel historicCacheModel = new HistoricCacheModel();

		historicCacheModel.uuid = getUuid();

		String uuid = historicCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			historicCacheModel.uuid = null;
		}

		historicCacheModel.sigId = getSigId();

		String sigId = historicCacheModel.sigId;

		if ((sigId != null) && (sigId.length() == 0)) {
			historicCacheModel.sigId = null;
		}

		historicCacheModel.name = getName();

		String name = historicCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			historicCacheModel.name = null;
		}

		Date suppressionDate = getSuppressionDate();

		if (suppressionDate != null) {
			historicCacheModel.suppressionDate = suppressionDate.getTime();
		}
		else {
			historicCacheModel.suppressionDate = Long.MIN_VALUE;
		}

		return historicCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Historic, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Historic, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Historic, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((Historic)this);

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

		private static final Function<InvocationHandler, Historic>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					Historic.class, ModelWrapper.class);

	}

	private String _uuid;
	private String _sigId;
	private String _name;
	private Date _suppressionDate;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<Historic, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Historic)this);
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
		_columnOriginalValues.put("sigId", _sigId);
		_columnOriginalValues.put("name", _name);
		_columnOriginalValues.put("suppressionDate", _suppressionDate);
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

		columnBitmasks.put("sigId", 2L);

		columnBitmasks.put("name", 4L);

		columnBitmasks.put("suppressionDate", 8L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Historic _escapedModel;

}