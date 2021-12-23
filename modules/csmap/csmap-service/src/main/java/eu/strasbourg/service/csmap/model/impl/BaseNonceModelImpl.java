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
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import eu.strasbourg.service.csmap.model.BaseNonce;
import eu.strasbourg.service.csmap.model.BaseNonceModel;

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

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model implementation for the BaseNonce service. Represents a row in the &quot;csmap_BaseNonce&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>BaseNonceModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link BaseNonceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BaseNonceImpl
 * @generated
 */
@ProviderType
public class BaseNonceModelImpl
	extends BaseModelImpl<BaseNonce> implements BaseNonceModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a base nonce model instance should use the <code>BaseNonce</code> interface instead.
	 */
	public static final String TABLE_NAME = "csmap_BaseNonce";

	public static final Object[][] TABLE_COLUMNS = {
		{"baseNonceId", Types.BIGINT}, {"createDate", Types.TIMESTAMP},
		{"value", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("baseNonceId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("value", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table csmap_BaseNonce (baseNonceId LONG not null primary key,createDate DATE null,value VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table csmap_BaseNonce";

	public static final String ORDER_BY_JPQL =
		" ORDER BY baseNonce.createDate ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY csmap_BaseNonce.createDate ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long VALUE_COLUMN_BITMASK = 1L;

	public static final long CREATEDATE_COLUMN_BITMASK = 2L;

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	public BaseNonceModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _baseNonceId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBaseNonceId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _baseNonceId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return BaseNonce.class;
	}

	@Override
	public String getModelClassName() {
		return BaseNonce.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<BaseNonce, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<BaseNonce, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<BaseNonce, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((BaseNonce)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<BaseNonce, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<BaseNonce, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(BaseNonce)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<BaseNonce, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<BaseNonce, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, BaseNonce>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			BaseNonce.class.getClassLoader(), BaseNonce.class,
			ModelWrapper.class);

		try {
			Constructor<BaseNonce> constructor =
				(Constructor<BaseNonce>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException roe) {
					throw new InternalError(roe);
				}
			};
		}
		catch (NoSuchMethodException nsme) {
			throw new InternalError(nsme);
		}
	}

	private static final Map<String, Function<BaseNonce, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<BaseNonce, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<BaseNonce, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<BaseNonce, Object>>();
		Map<String, BiConsumer<BaseNonce, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<BaseNonce, ?>>();

		attributeGetterFunctions.put("baseNonceId", BaseNonce::getBaseNonceId);
		attributeSetterBiConsumers.put(
			"baseNonceId",
			(BiConsumer<BaseNonce, Long>)BaseNonce::setBaseNonceId);
		attributeGetterFunctions.put("createDate", BaseNonce::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<BaseNonce, Date>)BaseNonce::setCreateDate);
		attributeGetterFunctions.put("value", BaseNonce::getValue);
		attributeSetterBiConsumers.put(
			"value", (BiConsumer<BaseNonce, String>)BaseNonce::setValue);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getBaseNonceId() {
		return _baseNonceId;
	}

	@Override
	public void setBaseNonceId(long baseNonceId) {
		_baseNonceId = baseNonceId;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_columnBitmask = -1L;

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
		_columnBitmask |= VALUE_COLUMN_BITMASK;

		if (_originalValue == null) {
			_originalValue = _value;
		}

		_value = value;
	}

	public String getOriginalValue() {
		return GetterUtil.getString(_originalValue);
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, BaseNonce.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public BaseNonce toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = _escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		BaseNonceImpl baseNonceImpl = new BaseNonceImpl();

		baseNonceImpl.setBaseNonceId(getBaseNonceId());
		baseNonceImpl.setCreateDate(getCreateDate());
		baseNonceImpl.setValue(getValue());

		baseNonceImpl.resetOriginalValues();

		return baseNonceImpl;
	}

	@Override
	public int compareTo(BaseNonce baseNonce) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), baseNonce.getCreateDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BaseNonce)) {
			return false;
		}

		BaseNonce baseNonce = (BaseNonce)obj;

		long primaryKey = baseNonce.getPrimaryKey();

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
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public void resetOriginalValues() {
		BaseNonceModelImpl baseNonceModelImpl = this;

		baseNonceModelImpl._originalValue = baseNonceModelImpl._value;

		baseNonceModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<BaseNonce> toCacheModel() {
		BaseNonceCacheModel baseNonceCacheModel = new BaseNonceCacheModel();

		baseNonceCacheModel.baseNonceId = getBaseNonceId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			baseNonceCacheModel.createDate = createDate.getTime();
		}
		else {
			baseNonceCacheModel.createDate = Long.MIN_VALUE;
		}

		baseNonceCacheModel.value = getValue();

		String value = baseNonceCacheModel.value;

		if ((value != null) && (value.length() == 0)) {
			baseNonceCacheModel.value = null;
		}

		return baseNonceCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<BaseNonce, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<BaseNonce, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<BaseNonce, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((BaseNonce)this));
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
		Map<String, Function<BaseNonce, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<BaseNonce, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<BaseNonce, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((BaseNonce)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final Function<InvocationHandler, BaseNonce>
		_escapedModelProxyProviderFunction = _getProxyProviderFunction();
	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _baseNonceId;
	private Date _createDate;
	private String _value;
	private String _originalValue;
	private long _columnBitmask;
	private BaseNonce _escapedModel;

}