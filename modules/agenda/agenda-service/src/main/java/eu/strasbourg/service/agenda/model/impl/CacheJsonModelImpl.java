/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import eu.strasbourg.service.agenda.model.CacheJson;
import eu.strasbourg.service.agenda.model.CacheJsonModel;

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
 * The base model implementation for the CacheJson service. Represents a row in the &quot;agenda_CacheJson&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>CacheJsonModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CacheJsonImpl}.
 * </p>
 *
 * @author BenjaminBini
 * @see CacheJsonImpl
 * @generated
 */
public class CacheJsonModelImpl
	extends BaseModelImpl<CacheJson> implements CacheJsonModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a cache json model instance should use the <code>CacheJson</code> interface instead.
	 */
	public static final String TABLE_NAME = "agenda_CacheJson";

	public static final Object[][] TABLE_COLUMNS = {
		{"eventId", Types.BIGINT}, {"jsonEvent", Types.CLOB},
		{"jsonEventLegacy", Types.CLOB}, {"createEvent", Types.TIMESTAMP},
		{"modifiedEvent", Types.TIMESTAMP}, {"isApproved", Types.BOOLEAN}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("eventId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("jsonEvent", Types.CLOB);
		TABLE_COLUMNS_MAP.put("jsonEventLegacy", Types.CLOB);
		TABLE_COLUMNS_MAP.put("createEvent", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedEvent", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("isApproved", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE =
		"create table agenda_CacheJson (eventId LONG not null primary key,jsonEvent TEXT null,jsonEventLegacy TEXT null,createEvent DATE null,modifiedEvent DATE null,isApproved BOOLEAN)";

	public static final String TABLE_SQL_DROP = "drop table agenda_CacheJson";

	public static final String ORDER_BY_JPQL =
		" ORDER BY cacheJson.eventId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY agenda_CacheJson.eventId ASC";

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
	public static final long EVENTID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long ISAPPROVED_COLUMN_BITMASK = 2L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		eu.strasbourg.service.agenda.service.util.PropsUtil.get(
			"lock.expiration.time.eu.strasbourg.service.agenda.model.CacheJson"));

	public CacheJsonModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _eventId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEventId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _eventId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CacheJson.class;
	}

	@Override
	public String getModelClassName() {
		return CacheJson.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CacheJson, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CacheJson, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CacheJson, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((CacheJson)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CacheJson, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CacheJson, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CacheJson)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CacheJson, Object>>
		getAttributeGetterFunctions() {

		return AttributeGetterFunctionsHolder._attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CacheJson, Object>>
		getAttributeSetterBiConsumers() {

		return AttributeSetterBiConsumersHolder._attributeSetterBiConsumers;
	}

	private static class AttributeGetterFunctionsHolder {

		private static final Map<String, Function<CacheJson, Object>>
			_attributeGetterFunctions;

		static {
			Map<String, Function<CacheJson, Object>> attributeGetterFunctions =
				new LinkedHashMap<String, Function<CacheJson, Object>>();

			attributeGetterFunctions.put("eventId", CacheJson::getEventId);
			attributeGetterFunctions.put("jsonEvent", CacheJson::getJsonEvent);
			attributeGetterFunctions.put(
				"jsonEventLegacy", CacheJson::getJsonEventLegacy);
			attributeGetterFunctions.put(
				"createEvent", CacheJson::getCreateEvent);
			attributeGetterFunctions.put(
				"modifiedEvent", CacheJson::getModifiedEvent);
			attributeGetterFunctions.put(
				"isApproved", CacheJson::getIsApproved);

			_attributeGetterFunctions = Collections.unmodifiableMap(
				attributeGetterFunctions);
		}

	}

	private static class AttributeSetterBiConsumersHolder {

		private static final Map<String, BiConsumer<CacheJson, Object>>
			_attributeSetterBiConsumers;

		static {
			Map<String, BiConsumer<CacheJson, ?>> attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<CacheJson, ?>>();

			attributeSetterBiConsumers.put(
				"eventId", (BiConsumer<CacheJson, Long>)CacheJson::setEventId);
			attributeSetterBiConsumers.put(
				"jsonEvent",
				(BiConsumer<CacheJson, String>)CacheJson::setJsonEvent);
			attributeSetterBiConsumers.put(
				"jsonEventLegacy",
				(BiConsumer<CacheJson, String>)CacheJson::setJsonEventLegacy);
			attributeSetterBiConsumers.put(
				"createEvent",
				(BiConsumer<CacheJson, Date>)CacheJson::setCreateEvent);
			attributeSetterBiConsumers.put(
				"modifiedEvent",
				(BiConsumer<CacheJson, Date>)CacheJson::setModifiedEvent);
			attributeSetterBiConsumers.put(
				"isApproved",
				(BiConsumer<CacheJson, Boolean>)CacheJson::setIsApproved);

			_attributeSetterBiConsumers = Collections.unmodifiableMap(
				(Map)attributeSetterBiConsumers);
		}

	}

	@Override
	public long getEventId() {
		return _eventId;
	}

	@Override
	public void setEventId(long eventId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_eventId = eventId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalEventId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("eventId"));
	}

	@Override
	public String getJsonEvent() {
		if (_jsonEvent == null) {
			return "";
		}
		else {
			return _jsonEvent;
		}
	}

	@Override
	public void setJsonEvent(String jsonEvent) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_jsonEvent = jsonEvent;
	}

	@Override
	public String getJsonEventLegacy() {
		if (_jsonEventLegacy == null) {
			return "";
		}
		else {
			return _jsonEventLegacy;
		}
	}

	@Override
	public void setJsonEventLegacy(String jsonEventLegacy) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_jsonEventLegacy = jsonEventLegacy;
	}

	@Override
	public Date getCreateEvent() {
		return _createEvent;
	}

	@Override
	public void setCreateEvent(Date createEvent) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createEvent = createEvent;
	}

	@Override
	public Date getModifiedEvent() {
		return _modifiedEvent;
	}

	@Override
	public void setModifiedEvent(Date modifiedEvent) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedEvent = modifiedEvent;
	}

	@Override
	public boolean getIsApproved() {
		return _isApproved;
	}

	@Override
	public boolean isIsApproved() {
		return _isApproved;
	}

	@Override
	public void setIsApproved(boolean isApproved) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_isApproved = isApproved;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public boolean getOriginalIsApproved() {
		return GetterUtil.getBoolean(
			this.<Boolean>getColumnOriginalValue("isApproved"));
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
			0, CacheJson.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CacheJson toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CacheJson>
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
		CacheJsonImpl cacheJsonImpl = new CacheJsonImpl();

		cacheJsonImpl.setEventId(getEventId());
		cacheJsonImpl.setJsonEvent(getJsonEvent());
		cacheJsonImpl.setJsonEventLegacy(getJsonEventLegacy());
		cacheJsonImpl.setCreateEvent(getCreateEvent());
		cacheJsonImpl.setModifiedEvent(getModifiedEvent());
		cacheJsonImpl.setIsApproved(isIsApproved());

		cacheJsonImpl.resetOriginalValues();

		return cacheJsonImpl;
	}

	@Override
	public CacheJson cloneWithOriginalValues() {
		CacheJsonImpl cacheJsonImpl = new CacheJsonImpl();

		cacheJsonImpl.setEventId(this.<Long>getColumnOriginalValue("eventId"));
		cacheJsonImpl.setJsonEvent(
			this.<String>getColumnOriginalValue("jsonEvent"));
		cacheJsonImpl.setJsonEventLegacy(
			this.<String>getColumnOriginalValue("jsonEventLegacy"));
		cacheJsonImpl.setCreateEvent(
			this.<Date>getColumnOriginalValue("createEvent"));
		cacheJsonImpl.setModifiedEvent(
			this.<Date>getColumnOriginalValue("modifiedEvent"));
		cacheJsonImpl.setIsApproved(
			this.<Boolean>getColumnOriginalValue("isApproved"));

		return cacheJsonImpl;
	}

	@Override
	public int compareTo(CacheJson cacheJson) {
		long primaryKey = cacheJson.getPrimaryKey();

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

		if (!(object instanceof CacheJson)) {
			return false;
		}

		CacheJson cacheJson = (CacheJson)object;

		long primaryKey = cacheJson.getPrimaryKey();

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
	public CacheModel<CacheJson> toCacheModel() {
		CacheJsonCacheModel cacheJsonCacheModel = new CacheJsonCacheModel();

		cacheJsonCacheModel.eventId = getEventId();

		cacheJsonCacheModel.jsonEvent = getJsonEvent();

		String jsonEvent = cacheJsonCacheModel.jsonEvent;

		if ((jsonEvent != null) && (jsonEvent.length() == 0)) {
			cacheJsonCacheModel.jsonEvent = null;
		}

		cacheJsonCacheModel.jsonEventLegacy = getJsonEventLegacy();

		String jsonEventLegacy = cacheJsonCacheModel.jsonEventLegacy;

		if ((jsonEventLegacy != null) && (jsonEventLegacy.length() == 0)) {
			cacheJsonCacheModel.jsonEventLegacy = null;
		}

		Date createEvent = getCreateEvent();

		if (createEvent != null) {
			cacheJsonCacheModel.createEvent = createEvent.getTime();
		}
		else {
			cacheJsonCacheModel.createEvent = Long.MIN_VALUE;
		}

		Date modifiedEvent = getModifiedEvent();

		if (modifiedEvent != null) {
			cacheJsonCacheModel.modifiedEvent = modifiedEvent.getTime();
		}
		else {
			cacheJsonCacheModel.modifiedEvent = Long.MIN_VALUE;
		}

		cacheJsonCacheModel.isApproved = isIsApproved();

		return cacheJsonCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CacheJson, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CacheJson, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CacheJson, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((CacheJson)this);

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

		private static final Function<InvocationHandler, CacheJson>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					CacheJson.class, ModelWrapper.class);

	}

	private long _eventId;
	private String _jsonEvent;
	private String _jsonEventLegacy;
	private Date _createEvent;
	private Date _modifiedEvent;
	private boolean _isApproved;

	public <T> T getColumnValue(String columnName) {
		Function<CacheJson, Object> function =
			AttributeGetterFunctionsHolder._attributeGetterFunctions.get(
				columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((CacheJson)this);
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

		_columnOriginalValues.put("eventId", _eventId);
		_columnOriginalValues.put("jsonEvent", _jsonEvent);
		_columnOriginalValues.put("jsonEventLegacy", _jsonEventLegacy);
		_columnOriginalValues.put("createEvent", _createEvent);
		_columnOriginalValues.put("modifiedEvent", _modifiedEvent);
		_columnOriginalValues.put("isApproved", _isApproved);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("eventId", 1L);

		columnBitmasks.put("jsonEvent", 2L);

		columnBitmasks.put("jsonEventLegacy", 4L);

		columnBitmasks.put("createEvent", 8L);

		columnBitmasks.put("modifiedEvent", 16L);

		columnBitmasks.put("isApproved", 32L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private CacheJson _escapedModel;

}