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

package eu.strasbourg.service.csmap.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;
import eu.strasbourg.service.csmap.model.RefreshToken;
import eu.strasbourg.service.csmap.model.RefreshTokenModel;

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
 * The base model implementation for the RefreshToken service. Represents a row in the &quot;csmap_RefreshToken&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>RefreshTokenModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link RefreshTokenImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RefreshTokenImpl
 * @generated
 */
public class RefreshTokenModelImpl
	extends BaseModelImpl<RefreshToken> implements RefreshTokenModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a refresh token model instance should use the <code>RefreshToken</code> interface instead.
	 */
	public static final String TABLE_NAME = "csmap_RefreshToken";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"refreshTokenId", Types.BIGINT},
		{"createDate", Types.TIMESTAMP}, {"value", Types.VARCHAR},
		{"publikId", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("refreshTokenId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("value", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("publikId", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table csmap_RefreshToken (uuid_ VARCHAR(75) null,refreshTokenId LONG not null primary key,createDate DATE null,value VARCHAR(300) null,publikId VARCHAR(200) null)";

	public static final String TABLE_SQL_DROP = "drop table csmap_RefreshToken";

	public static final String ORDER_BY_JPQL =
		" ORDER BY refreshToken.createDate ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY csmap_RefreshToken.createDate ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long VALUE_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long CREATEDATE_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public RefreshTokenModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _refreshTokenId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setRefreshTokenId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _refreshTokenId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return RefreshToken.class;
	}

	@Override
	public String getModelClassName() {
		return RefreshToken.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<RefreshToken, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<RefreshToken, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<RefreshToken, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((RefreshToken)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<RefreshToken, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<RefreshToken, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(RefreshToken)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<RefreshToken, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<RefreshToken, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<RefreshToken, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<RefreshToken, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<RefreshToken, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<RefreshToken, Object>>();
		Map<String, BiConsumer<RefreshToken, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<RefreshToken, ?>>();

		attributeGetterFunctions.put("uuid", RefreshToken::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<RefreshToken, String>)RefreshToken::setUuid);
		attributeGetterFunctions.put(
			"refreshTokenId", RefreshToken::getRefreshTokenId);
		attributeSetterBiConsumers.put(
			"refreshTokenId",
			(BiConsumer<RefreshToken, Long>)RefreshToken::setRefreshTokenId);
		attributeGetterFunctions.put("createDate", RefreshToken::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<RefreshToken, Date>)RefreshToken::setCreateDate);
		attributeGetterFunctions.put("value", RefreshToken::getValue);
		attributeSetterBiConsumers.put(
			"value", (BiConsumer<RefreshToken, String>)RefreshToken::setValue);
		attributeGetterFunctions.put("publikId", RefreshToken::getPublikId);
		attributeSetterBiConsumers.put(
			"publikId",
			(BiConsumer<RefreshToken, String>)RefreshToken::setPublikId);

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
	public long getRefreshTokenId() {
		return _refreshTokenId;
	}

	@Override
	public void setRefreshTokenId(long refreshTokenId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_refreshTokenId = refreshTokenId;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@Override
	public String getValue() {
		if (_value == null) {
			return "";
		}
		else {
			return _value;
		}
	}

	@Override
	public void setValue(String value) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_value = value;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalValue() {
		return getColumnOriginalValue("value");
	}

	@Override
	public String getPublikId() {
		if (_publikId == null) {
			return "";
		}
		else {
			return _publikId;
		}
	}

	@Override
	public void setPublikId(String publikId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_publikId = publikId;
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
			0, RefreshToken.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public RefreshToken toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, RefreshToken>
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
		RefreshTokenImpl refreshTokenImpl = new RefreshTokenImpl();

		refreshTokenImpl.setUuid(getUuid());
		refreshTokenImpl.setRefreshTokenId(getRefreshTokenId());
		refreshTokenImpl.setCreateDate(getCreateDate());
		refreshTokenImpl.setValue(getValue());
		refreshTokenImpl.setPublikId(getPublikId());

		refreshTokenImpl.resetOriginalValues();

		return refreshTokenImpl;
	}

	@Override
	public RefreshToken cloneWithOriginalValues() {
		RefreshTokenImpl refreshTokenImpl = new RefreshTokenImpl();

		refreshTokenImpl.setUuid(this.<String>getColumnOriginalValue("uuid_"));
		refreshTokenImpl.setRefreshTokenId(
			this.<Long>getColumnOriginalValue("refreshTokenId"));
		refreshTokenImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		refreshTokenImpl.setValue(this.<String>getColumnOriginalValue("value"));
		refreshTokenImpl.setPublikId(
			this.<String>getColumnOriginalValue("publikId"));

		return refreshTokenImpl;
	}

	@Override
	public int compareTo(RefreshToken refreshToken) {
		int value = 0;

		value = DateUtil.compareTo(
			getCreateDate(), refreshToken.getCreateDate());

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

		if (!(object instanceof RefreshToken)) {
			return false;
		}

		RefreshToken refreshToken = (RefreshToken)object;

		long primaryKey = refreshToken.getPrimaryKey();

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
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<RefreshToken> toCacheModel() {
		RefreshTokenCacheModel refreshTokenCacheModel =
			new RefreshTokenCacheModel();

		refreshTokenCacheModel.uuid = getUuid();

		String uuid = refreshTokenCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			refreshTokenCacheModel.uuid = null;
		}

		refreshTokenCacheModel.refreshTokenId = getRefreshTokenId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			refreshTokenCacheModel.createDate = createDate.getTime();
		}
		else {
			refreshTokenCacheModel.createDate = Long.MIN_VALUE;
		}

		refreshTokenCacheModel.value = getValue();

		String value = refreshTokenCacheModel.value;

		if ((value != null) && (value.length() == 0)) {
			refreshTokenCacheModel.value = null;
		}

		refreshTokenCacheModel.publikId = getPublikId();

		String publikId = refreshTokenCacheModel.publikId;

		if ((publikId != null) && (publikId.length() == 0)) {
			refreshTokenCacheModel.publikId = null;
		}

		return refreshTokenCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<RefreshToken, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<RefreshToken, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<RefreshToken, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((RefreshToken)this);

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

		private static final Function<InvocationHandler, RefreshToken>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					RefreshToken.class, ModelWrapper.class);

	}

	private String _uuid;
	private long _refreshTokenId;
	private Date _createDate;
	private String _value;
	private String _publikId;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<RefreshToken, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((RefreshToken)this);
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
		_columnOriginalValues.put("refreshTokenId", _refreshTokenId);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("value", _value);
		_columnOriginalValues.put("publikId", _publikId);
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

		columnBitmasks.put("refreshTokenId", 2L);

		columnBitmasks.put("createDate", 4L);

		columnBitmasks.put("value", 8L);

		columnBitmasks.put("publikId", 16L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private RefreshToken _escapedModel;

}