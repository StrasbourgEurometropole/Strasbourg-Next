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
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;
import eu.strasbourg.service.gtfs.model.Direction;
import eu.strasbourg.service.gtfs.model.DirectionModel;

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
 * The base model implementation for the Direction service. Represents a row in the &quot;gtfs_Direction&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>DirectionModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DirectionImpl}.
 * </p>
 *
 * @author Cedric Henry
 * @see DirectionImpl
 * @generated
 */
public class DirectionModelImpl
	extends BaseModelImpl<Direction> implements DirectionModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a direction model instance should use the <code>Direction</code> interface instead.
	 */
	public static final String TABLE_NAME = "gtfs_Direction";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"directionId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"tripId", Types.VARCHAR}, {"stopId", Types.VARCHAR},
		{"routeId", Types.VARCHAR}, {"destinationName", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("directionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("tripId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("stopId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("routeId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("destinationName", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table gtfs_Direction (uuid_ VARCHAR(75) null,directionId LONG not null primary key,groupId LONG,companyId LONG,tripId VARCHAR(75) null,stopId VARCHAR(75) null,routeId VARCHAR(75) null,destinationName VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table gtfs_Direction";

	public static final String ORDER_BY_JPQL =
		" ORDER BY direction.directionId DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY gtfs_Direction.directionId DESC";

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
	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long ROUTEID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long STOPID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long TRIPID_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 32L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long DIRECTIONID_COLUMN_BITMASK = 64L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		eu.strasbourg.service.gtfs.service.util.PropsUtil.get(
			"lock.expiration.time.eu.strasbourg.service.gtfs.model.Direction"));

	public DirectionModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _directionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDirectionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _directionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Direction.class;
	}

	@Override
	public String getModelClassName() {
		return Direction.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Direction, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Direction, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Direction, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Direction)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Direction, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Direction, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Direction)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Direction, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Direction, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<Direction, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Direction, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Direction, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Direction, Object>>();
		Map<String, BiConsumer<Direction, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Direction, ?>>();

		attributeGetterFunctions.put("uuid", Direction::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<Direction, String>)Direction::setUuid);
		attributeGetterFunctions.put("directionId", Direction::getDirectionId);
		attributeSetterBiConsumers.put(
			"directionId",
			(BiConsumer<Direction, Long>)Direction::setDirectionId);
		attributeGetterFunctions.put("groupId", Direction::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<Direction, Long>)Direction::setGroupId);
		attributeGetterFunctions.put("companyId", Direction::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<Direction, Long>)Direction::setCompanyId);
		attributeGetterFunctions.put("tripId", Direction::getTripId);
		attributeSetterBiConsumers.put(
			"tripId", (BiConsumer<Direction, String>)Direction::setTripId);
		attributeGetterFunctions.put("stopId", Direction::getStopId);
		attributeSetterBiConsumers.put(
			"stopId", (BiConsumer<Direction, String>)Direction::setStopId);
		attributeGetterFunctions.put("routeId", Direction::getRouteId);
		attributeSetterBiConsumers.put(
			"routeId", (BiConsumer<Direction, String>)Direction::setRouteId);
		attributeGetterFunctions.put(
			"destinationName", Direction::getDestinationName);
		attributeSetterBiConsumers.put(
			"destinationName",
			(BiConsumer<Direction, String>)Direction::setDestinationName);

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
	public long getDirectionId() {
		return _directionId;
	}

	@Override
	public void setDirectionId(long directionId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_directionId = directionId;
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
	public String getTripId() {
		if (_tripId == null) {
			return "";
		}
		else {
			return _tripId;
		}
	}

	@Override
	public void setTripId(String tripId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_tripId = tripId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalTripId() {
		return getColumnOriginalValue("tripId");
	}

	@Override
	public String getStopId() {
		if (_stopId == null) {
			return "";
		}
		else {
			return _stopId;
		}
	}

	@Override
	public void setStopId(String stopId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_stopId = stopId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalStopId() {
		return getColumnOriginalValue("stopId");
	}

	@Override
	public String getRouteId() {
		if (_routeId == null) {
			return "";
		}
		else {
			return _routeId;
		}
	}

	@Override
	public void setRouteId(String routeId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_routeId = routeId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalRouteId() {
		return getColumnOriginalValue("routeId");
	}

	@Override
	public String getDestinationName() {
		if (_destinationName == null) {
			return "";
		}
		else {
			return _destinationName;
		}
	}

	@Override
	public void setDestinationName(String destinationName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_destinationName = destinationName;
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
			getCompanyId(), Direction.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Direction toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Direction>
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
		DirectionImpl directionImpl = new DirectionImpl();

		directionImpl.setUuid(getUuid());
		directionImpl.setDirectionId(getDirectionId());
		directionImpl.setGroupId(getGroupId());
		directionImpl.setCompanyId(getCompanyId());
		directionImpl.setTripId(getTripId());
		directionImpl.setStopId(getStopId());
		directionImpl.setRouteId(getRouteId());
		directionImpl.setDestinationName(getDestinationName());

		directionImpl.resetOriginalValues();

		return directionImpl;
	}

	@Override
	public Direction cloneWithOriginalValues() {
		DirectionImpl directionImpl = new DirectionImpl();

		directionImpl.setUuid(this.<String>getColumnOriginalValue("uuid_"));
		directionImpl.setDirectionId(
			this.<Long>getColumnOriginalValue("directionId"));
		directionImpl.setGroupId(this.<Long>getColumnOriginalValue("groupId"));
		directionImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		directionImpl.setTripId(this.<String>getColumnOriginalValue("tripId"));
		directionImpl.setStopId(this.<String>getColumnOriginalValue("stopId"));
		directionImpl.setRouteId(
			this.<String>getColumnOriginalValue("routeId"));
		directionImpl.setDestinationName(
			this.<String>getColumnOriginalValue("destinationName"));

		return directionImpl;
	}

	@Override
	public int compareTo(Direction direction) {
		int value = 0;

		if (getDirectionId() < direction.getDirectionId()) {
			value = -1;
		}
		else if (getDirectionId() > direction.getDirectionId()) {
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

		if (!(object instanceof Direction)) {
			return false;
		}

		Direction direction = (Direction)object;

		long primaryKey = direction.getPrimaryKey();

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
	public CacheModel<Direction> toCacheModel() {
		DirectionCacheModel directionCacheModel = new DirectionCacheModel();

		directionCacheModel.uuid = getUuid();

		String uuid = directionCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			directionCacheModel.uuid = null;
		}

		directionCacheModel.directionId = getDirectionId();

		directionCacheModel.groupId = getGroupId();

		directionCacheModel.companyId = getCompanyId();

		directionCacheModel.tripId = getTripId();

		String tripId = directionCacheModel.tripId;

		if ((tripId != null) && (tripId.length() == 0)) {
			directionCacheModel.tripId = null;
		}

		directionCacheModel.stopId = getStopId();

		String stopId = directionCacheModel.stopId;

		if ((stopId != null) && (stopId.length() == 0)) {
			directionCacheModel.stopId = null;
		}

		directionCacheModel.routeId = getRouteId();

		String routeId = directionCacheModel.routeId;

		if ((routeId != null) && (routeId.length() == 0)) {
			directionCacheModel.routeId = null;
		}

		directionCacheModel.destinationName = getDestinationName();

		String destinationName = directionCacheModel.destinationName;

		if ((destinationName != null) && (destinationName.length() == 0)) {
			directionCacheModel.destinationName = null;
		}

		return directionCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Direction, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Direction, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Direction, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((Direction)this);

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

		private static final Function<InvocationHandler, Direction>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					Direction.class, ModelWrapper.class);

	}

	private String _uuid;
	private long _directionId;
	private long _groupId;
	private long _companyId;
	private String _tripId;
	private String _stopId;
	private String _routeId;
	private String _destinationName;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<Direction, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Direction)this);
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
		_columnOriginalValues.put("directionId", _directionId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("tripId", _tripId);
		_columnOriginalValues.put("stopId", _stopId);
		_columnOriginalValues.put("routeId", _routeId);
		_columnOriginalValues.put("destinationName", _destinationName);
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

		columnBitmasks.put("directionId", 2L);

		columnBitmasks.put("groupId", 4L);

		columnBitmasks.put("companyId", 8L);

		columnBitmasks.put("tripId", 16L);

		columnBitmasks.put("stopId", 32L);

		columnBitmasks.put("routeId", 64L);

		columnBitmasks.put("destinationName", 128L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Direction _escapedModel;

}