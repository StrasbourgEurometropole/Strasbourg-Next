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

import eu.strasbourg.service.gtfs.model.StopTime;
import eu.strasbourg.service.gtfs.model.StopTimeModel;

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
 * The base model implementation for the StopTime service. Represents a row in the &quot;gtfs_StopTime&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>StopTimeModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link StopTimeImpl}.
 * </p>
 *
 * @author Cedric Henry
 * @see StopTimeImpl
 * @generated
 */
public class StopTimeModelImpl
	extends BaseModelImpl<StopTime> implements StopTimeModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a stop time model instance should use the <code>StopTime</code> interface instead.
	 */
	public static final String TABLE_NAME = "gtfs_StopTime";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"id_", Types.BIGINT},
		{"trip_id", Types.VARCHAR}, {"arrival_time", Types.TIMESTAMP},
		{"departure_time", Types.TIMESTAMP}, {"stop_id", Types.VARCHAR},
		{"stop_sequence", Types.INTEGER}, {"pickup_type", Types.VARCHAR},
		{"drop_off_type", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("id_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("trip_id", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("arrival_time", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("departure_time", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("stop_id", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("stop_sequence", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("pickup_type", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("drop_off_type", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table gtfs_StopTime (uuid_ VARCHAR(75) null,id_ LONG not null primary key,trip_id VARCHAR(75) null,arrival_time DATE null,departure_time DATE null,stop_id VARCHAR(75) null,stop_sequence INTEGER,pickup_type VARCHAR(75) null,drop_off_type VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table gtfs_StopTime";

	public static final String ORDER_BY_JPQL = " ORDER BY stopTime.trip_id ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY gtfs_StopTime.trip_id ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.gtfs.service.util.PropsUtil.get(
			"value.object.entity.cache.enabled.eu.strasbourg.service.gtfs.model.StopTime"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.gtfs.service.util.PropsUtil.get(
			"value.object.finder.cache.enabled.eu.strasbourg.service.gtfs.model.StopTime"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.gtfs.service.util.PropsUtil.get(
			"value.object.column.bitmask.enabled.eu.strasbourg.service.gtfs.model.StopTime"),
		true);

	public static final long STOP_ID_COLUMN_BITMASK = 1L;

	public static final long TRIP_ID_COLUMN_BITMASK = 2L;

	public static final long UUID_COLUMN_BITMASK = 4L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		eu.strasbourg.service.gtfs.service.util.PropsUtil.get(
			"lock.expiration.time.eu.strasbourg.service.gtfs.model.StopTime"));

	public StopTimeModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return StopTime.class;
	}

	@Override
	public String getModelClassName() {
		return StopTime.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<StopTime, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<StopTime, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<StopTime, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((StopTime)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<StopTime, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<StopTime, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(StopTime)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<StopTime, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<StopTime, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, StopTime>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			StopTime.class.getClassLoader(), StopTime.class,
			ModelWrapper.class);

		try {
			Constructor<StopTime> constructor =
				(Constructor<StopTime>)proxyClass.getConstructor(
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

	private static final Map<String, Function<StopTime, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<StopTime, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<StopTime, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<StopTime, Object>>();
		Map<String, BiConsumer<StopTime, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<StopTime, ?>>();

		attributeGetterFunctions.put(
			"uuid",
			new Function<StopTime, Object>() {

				@Override
				public Object apply(StopTime stopTime) {
					return stopTime.getUuid();
				}

			});
		attributeSetterBiConsumers.put(
			"uuid",
			new BiConsumer<StopTime, Object>() {

				@Override
				public void accept(StopTime stopTime, Object uuidObject) {
					stopTime.setUuid((String)uuidObject);
				}

			});
		attributeGetterFunctions.put(
			"id",
			new Function<StopTime, Object>() {

				@Override
				public Object apply(StopTime stopTime) {
					return stopTime.getId();
				}

			});
		attributeSetterBiConsumers.put(
			"id",
			new BiConsumer<StopTime, Object>() {

				@Override
				public void accept(StopTime stopTime, Object idObject) {
					stopTime.setId((Long)idObject);
				}

			});
		attributeGetterFunctions.put(
			"trip_id",
			new Function<StopTime, Object>() {

				@Override
				public Object apply(StopTime stopTime) {
					return stopTime.getTrip_id();
				}

			});
		attributeSetterBiConsumers.put(
			"trip_id",
			new BiConsumer<StopTime, Object>() {

				@Override
				public void accept(StopTime stopTime, Object trip_idObject) {
					stopTime.setTrip_id((String)trip_idObject);
				}

			});
		attributeGetterFunctions.put(
			"arrival_time",
			new Function<StopTime, Object>() {

				@Override
				public Object apply(StopTime stopTime) {
					return stopTime.getArrival_time();
				}

			});
		attributeSetterBiConsumers.put(
			"arrival_time",
			new BiConsumer<StopTime, Object>() {

				@Override
				public void accept(
					StopTime stopTime, Object arrival_timeObject) {

					stopTime.setArrival_time((Date)arrival_timeObject);
				}

			});
		attributeGetterFunctions.put(
			"departure_time",
			new Function<StopTime, Object>() {

				@Override
				public Object apply(StopTime stopTime) {
					return stopTime.getDeparture_time();
				}

			});
		attributeSetterBiConsumers.put(
			"departure_time",
			new BiConsumer<StopTime, Object>() {

				@Override
				public void accept(
					StopTime stopTime, Object departure_timeObject) {

					stopTime.setDeparture_time((Date)departure_timeObject);
				}

			});
		attributeGetterFunctions.put(
			"stop_id",
			new Function<StopTime, Object>() {

				@Override
				public Object apply(StopTime stopTime) {
					return stopTime.getStop_id();
				}

			});
		attributeSetterBiConsumers.put(
			"stop_id",
			new BiConsumer<StopTime, Object>() {

				@Override
				public void accept(StopTime stopTime, Object stop_idObject) {
					stopTime.setStop_id((String)stop_idObject);
				}

			});
		attributeGetterFunctions.put(
			"stop_sequence",
			new Function<StopTime, Object>() {

				@Override
				public Object apply(StopTime stopTime) {
					return stopTime.getStop_sequence();
				}

			});
		attributeSetterBiConsumers.put(
			"stop_sequence",
			new BiConsumer<StopTime, Object>() {

				@Override
				public void accept(
					StopTime stopTime, Object stop_sequenceObject) {

					stopTime.setStop_sequence((Integer)stop_sequenceObject);
				}

			});
		attributeGetterFunctions.put(
			"pickup_type",
			new Function<StopTime, Object>() {

				@Override
				public Object apply(StopTime stopTime) {
					return stopTime.getPickup_type();
				}

			});
		attributeSetterBiConsumers.put(
			"pickup_type",
			new BiConsumer<StopTime, Object>() {

				@Override
				public void accept(
					StopTime stopTime, Object pickup_typeObject) {

					stopTime.setPickup_type((String)pickup_typeObject);
				}

			});
		attributeGetterFunctions.put(
			"drop_off_type",
			new Function<StopTime, Object>() {

				@Override
				public Object apply(StopTime stopTime) {
					return stopTime.getDrop_off_type();
				}

			});
		attributeSetterBiConsumers.put(
			"drop_off_type",
			new BiConsumer<StopTime, Object>() {

				@Override
				public void accept(
					StopTime stopTime, Object drop_off_typeObject) {

					stopTime.setDrop_off_type((String)drop_off_typeObject);
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
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;
	}

	@Override
	public String getTrip_id() {
		if (_trip_id == null) {
			return "";
		}
		else {
			return _trip_id;
		}
	}

	@Override
	public void setTrip_id(String trip_id) {
		_columnBitmask = -1L;

		if (_originalTrip_id == null) {
			_originalTrip_id = _trip_id;
		}

		_trip_id = trip_id;
	}

	public String getOriginalTrip_id() {
		return GetterUtil.getString(_originalTrip_id);
	}

	@Override
	public Date getArrival_time() {
		return _arrival_time;
	}

	@Override
	public void setArrival_time(Date arrival_time) {
		_arrival_time = arrival_time;
	}

	@Override
	public Date getDeparture_time() {
		return _departure_time;
	}

	@Override
	public void setDeparture_time(Date departure_time) {
		_departure_time = departure_time;
	}

	@Override
	public String getStop_id() {
		if (_stop_id == null) {
			return "";
		}
		else {
			return _stop_id;
		}
	}

	@Override
	public void setStop_id(String stop_id) {
		_columnBitmask |= STOP_ID_COLUMN_BITMASK;

		if (_originalStop_id == null) {
			_originalStop_id = _stop_id;
		}

		_stop_id = stop_id;
	}

	public String getOriginalStop_id() {
		return GetterUtil.getString(_originalStop_id);
	}

	@Override
	public int getStop_sequence() {
		return _stop_sequence;
	}

	@Override
	public void setStop_sequence(int stop_sequence) {
		_stop_sequence = stop_sequence;
	}

	@Override
	public String getPickup_type() {
		if (_pickup_type == null) {
			return "";
		}
		else {
			return _pickup_type;
		}
	}

	@Override
	public void setPickup_type(String pickup_type) {
		_pickup_type = pickup_type;
	}

	@Override
	public String getDrop_off_type() {
		if (_drop_off_type == null) {
			return "";
		}
		else {
			return _drop_off_type;
		}
	}

	@Override
	public void setDrop_off_type(String drop_off_type) {
		_drop_off_type = drop_off_type;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, StopTime.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public StopTime toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, StopTime>
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
		StopTimeImpl stopTimeImpl = new StopTimeImpl();

		stopTimeImpl.setUuid(getUuid());
		stopTimeImpl.setId(getId());
		stopTimeImpl.setTrip_id(getTrip_id());
		stopTimeImpl.setArrival_time(getArrival_time());
		stopTimeImpl.setDeparture_time(getDeparture_time());
		stopTimeImpl.setStop_id(getStop_id());
		stopTimeImpl.setStop_sequence(getStop_sequence());
		stopTimeImpl.setPickup_type(getPickup_type());
		stopTimeImpl.setDrop_off_type(getDrop_off_type());

		stopTimeImpl.resetOriginalValues();

		return stopTimeImpl;
	}

	@Override
	public int compareTo(StopTime stopTime) {
		int value = 0;

		value = getTrip_id().compareTo(stopTime.getTrip_id());

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

		if (!(object instanceof StopTime)) {
			return false;
		}

		StopTime stopTime = (StopTime)object;

		long primaryKey = stopTime.getPrimaryKey();

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
		StopTimeModelImpl stopTimeModelImpl = this;

		stopTimeModelImpl._originalUuid = stopTimeModelImpl._uuid;

		stopTimeModelImpl._originalTrip_id = stopTimeModelImpl._trip_id;

		stopTimeModelImpl._originalStop_id = stopTimeModelImpl._stop_id;

		stopTimeModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<StopTime> toCacheModel() {
		StopTimeCacheModel stopTimeCacheModel = new StopTimeCacheModel();

		stopTimeCacheModel.uuid = getUuid();

		String uuid = stopTimeCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			stopTimeCacheModel.uuid = null;
		}

		stopTimeCacheModel.id = getId();

		stopTimeCacheModel.trip_id = getTrip_id();

		String trip_id = stopTimeCacheModel.trip_id;

		if ((trip_id != null) && (trip_id.length() == 0)) {
			stopTimeCacheModel.trip_id = null;
		}

		Date arrival_time = getArrival_time();

		if (arrival_time != null) {
			stopTimeCacheModel.arrival_time = arrival_time.getTime();
		}
		else {
			stopTimeCacheModel.arrival_time = Long.MIN_VALUE;
		}

		Date departure_time = getDeparture_time();

		if (departure_time != null) {
			stopTimeCacheModel.departure_time = departure_time.getTime();
		}
		else {
			stopTimeCacheModel.departure_time = Long.MIN_VALUE;
		}

		stopTimeCacheModel.stop_id = getStop_id();

		String stop_id = stopTimeCacheModel.stop_id;

		if ((stop_id != null) && (stop_id.length() == 0)) {
			stopTimeCacheModel.stop_id = null;
		}

		stopTimeCacheModel.stop_sequence = getStop_sequence();

		stopTimeCacheModel.pickup_type = getPickup_type();

		String pickup_type = stopTimeCacheModel.pickup_type;

		if ((pickup_type != null) && (pickup_type.length() == 0)) {
			stopTimeCacheModel.pickup_type = null;
		}

		stopTimeCacheModel.drop_off_type = getDrop_off_type();

		String drop_off_type = stopTimeCacheModel.drop_off_type;

		if ((drop_off_type != null) && (drop_off_type.length() == 0)) {
			stopTimeCacheModel.drop_off_type = null;
		}

		return stopTimeCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<StopTime, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<StopTime, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<StopTime, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((StopTime)this));
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
		Map<String, Function<StopTime, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<StopTime, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<StopTime, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((StopTime)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, StopTime>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private String _originalUuid;
	private long _id;
	private String _trip_id;
	private String _originalTrip_id;
	private Date _arrival_time;
	private Date _departure_time;
	private String _stop_id;
	private String _originalStop_id;
	private int _stop_sequence;
	private String _pickup_type;
	private String _drop_off_type;
	private long _columnBitmask;
	private StopTime _escapedModel;

}