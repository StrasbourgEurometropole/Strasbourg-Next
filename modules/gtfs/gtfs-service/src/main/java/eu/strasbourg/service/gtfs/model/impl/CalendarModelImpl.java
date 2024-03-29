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

import eu.strasbourg.service.gtfs.model.Calendar;
import eu.strasbourg.service.gtfs.model.CalendarModel;

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
 * The base model implementation for the Calendar service. Represents a row in the &quot;gtfs_Calendar&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>CalendarModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CalendarImpl}.
 * </p>
 *
 * @author Cedric Henry
 * @see CalendarImpl
 * @generated
 */
public class CalendarModelImpl
	extends BaseModelImpl<Calendar> implements CalendarModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a calendar model instance should use the <code>Calendar</code> interface instead.
	 */
	public static final String TABLE_NAME = "gtfs_Calendar";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"id_", Types.BIGINT},
		{"service_id", Types.VARCHAR}, {"monday", Types.BOOLEAN},
		{"tuesday", Types.BOOLEAN}, {"wednesday", Types.BOOLEAN},
		{"thursday", Types.BOOLEAN}, {"friday", Types.BOOLEAN},
		{"saturday", Types.BOOLEAN}, {"sunday", Types.BOOLEAN},
		{"start_date", Types.TIMESTAMP}, {"end_date", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("id_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("service_id", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("monday", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("tuesday", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("wednesday", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("thursday", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("friday", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("saturday", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("sunday", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("start_date", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("end_date", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table gtfs_Calendar (uuid_ VARCHAR(75) null,id_ LONG not null primary key,service_id VARCHAR(75) null,monday BOOLEAN,tuesday BOOLEAN,wednesday BOOLEAN,thursday BOOLEAN,friday BOOLEAN,saturday BOOLEAN,sunday BOOLEAN,start_date DATE null,end_date DATE null)";

	public static final String TABLE_SQL_DROP = "drop table gtfs_Calendar";

	public static final String ORDER_BY_JPQL =
		" ORDER BY calendar.service_id ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY gtfs_Calendar.service_id ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.gtfs.service.util.PropsUtil.get(
			"value.object.entity.cache.enabled.eu.strasbourg.service.gtfs.model.Calendar"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.gtfs.service.util.PropsUtil.get(
			"value.object.finder.cache.enabled.eu.strasbourg.service.gtfs.model.Calendar"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.gtfs.service.util.PropsUtil.get(
			"value.object.column.bitmask.enabled.eu.strasbourg.service.gtfs.model.Calendar"),
		true);

	public static final long END_DATE_COLUMN_BITMASK = 1L;

	public static final long SERVICE_ID_COLUMN_BITMASK = 2L;

	public static final long START_DATE_COLUMN_BITMASK = 4L;

	public static final long UUID_COLUMN_BITMASK = 8L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		eu.strasbourg.service.gtfs.service.util.PropsUtil.get(
			"lock.expiration.time.eu.strasbourg.service.gtfs.model.Calendar"));

	public CalendarModelImpl() {
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
		return Calendar.class;
	}

	@Override
	public String getModelClassName() {
		return Calendar.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Calendar, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Calendar, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Calendar, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Calendar)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Calendar, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Calendar, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Calendar)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Calendar, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Calendar, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Calendar>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Calendar.class.getClassLoader(), Calendar.class,
			ModelWrapper.class);

		try {
			Constructor<Calendar> constructor =
				(Constructor<Calendar>)proxyClass.getConstructor(
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

	private static final Map<String, Function<Calendar, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Calendar, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Calendar, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Calendar, Object>>();
		Map<String, BiConsumer<Calendar, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Calendar, ?>>();

		attributeGetterFunctions.put(
			"uuid",
			new Function<Calendar, Object>() {

				@Override
				public Object apply(Calendar calendar) {
					return calendar.getUuid();
				}

			});
		attributeSetterBiConsumers.put(
			"uuid",
			new BiConsumer<Calendar, Object>() {

				@Override
				public void accept(Calendar calendar, Object uuidObject) {
					calendar.setUuid((String)uuidObject);
				}

			});
		attributeGetterFunctions.put(
			"id",
			new Function<Calendar, Object>() {

				@Override
				public Object apply(Calendar calendar) {
					return calendar.getId();
				}

			});
		attributeSetterBiConsumers.put(
			"id",
			new BiConsumer<Calendar, Object>() {

				@Override
				public void accept(Calendar calendar, Object idObject) {
					calendar.setId((Long)idObject);
				}

			});
		attributeGetterFunctions.put(
			"service_id",
			new Function<Calendar, Object>() {

				@Override
				public Object apply(Calendar calendar) {
					return calendar.getService_id();
				}

			});
		attributeSetterBiConsumers.put(
			"service_id",
			new BiConsumer<Calendar, Object>() {

				@Override
				public void accept(Calendar calendar, Object service_idObject) {
					calendar.setService_id((String)service_idObject);
				}

			});
		attributeGetterFunctions.put(
			"monday",
			new Function<Calendar, Object>() {

				@Override
				public Object apply(Calendar calendar) {
					return calendar.getMonday();
				}

			});
		attributeSetterBiConsumers.put(
			"monday",
			new BiConsumer<Calendar, Object>() {

				@Override
				public void accept(Calendar calendar, Object mondayObject) {
					calendar.setMonday((Boolean)mondayObject);
				}

			});
		attributeGetterFunctions.put(
			"tuesday",
			new Function<Calendar, Object>() {

				@Override
				public Object apply(Calendar calendar) {
					return calendar.getTuesday();
				}

			});
		attributeSetterBiConsumers.put(
			"tuesday",
			new BiConsumer<Calendar, Object>() {

				@Override
				public void accept(Calendar calendar, Object tuesdayObject) {
					calendar.setTuesday((Boolean)tuesdayObject);
				}

			});
		attributeGetterFunctions.put(
			"wednesday",
			new Function<Calendar, Object>() {

				@Override
				public Object apply(Calendar calendar) {
					return calendar.getWednesday();
				}

			});
		attributeSetterBiConsumers.put(
			"wednesday",
			new BiConsumer<Calendar, Object>() {

				@Override
				public void accept(Calendar calendar, Object wednesdayObject) {
					calendar.setWednesday((Boolean)wednesdayObject);
				}

			});
		attributeGetterFunctions.put(
			"thursday",
			new Function<Calendar, Object>() {

				@Override
				public Object apply(Calendar calendar) {
					return calendar.getThursday();
				}

			});
		attributeSetterBiConsumers.put(
			"thursday",
			new BiConsumer<Calendar, Object>() {

				@Override
				public void accept(Calendar calendar, Object thursdayObject) {
					calendar.setThursday((Boolean)thursdayObject);
				}

			});
		attributeGetterFunctions.put(
			"friday",
			new Function<Calendar, Object>() {

				@Override
				public Object apply(Calendar calendar) {
					return calendar.getFriday();
				}

			});
		attributeSetterBiConsumers.put(
			"friday",
			new BiConsumer<Calendar, Object>() {

				@Override
				public void accept(Calendar calendar, Object fridayObject) {
					calendar.setFriday((Boolean)fridayObject);
				}

			});
		attributeGetterFunctions.put(
			"saturday",
			new Function<Calendar, Object>() {

				@Override
				public Object apply(Calendar calendar) {
					return calendar.getSaturday();
				}

			});
		attributeSetterBiConsumers.put(
			"saturday",
			new BiConsumer<Calendar, Object>() {

				@Override
				public void accept(Calendar calendar, Object saturdayObject) {
					calendar.setSaturday((Boolean)saturdayObject);
				}

			});
		attributeGetterFunctions.put(
			"sunday",
			new Function<Calendar, Object>() {

				@Override
				public Object apply(Calendar calendar) {
					return calendar.getSunday();
				}

			});
		attributeSetterBiConsumers.put(
			"sunday",
			new BiConsumer<Calendar, Object>() {

				@Override
				public void accept(Calendar calendar, Object sundayObject) {
					calendar.setSunday((Boolean)sundayObject);
				}

			});
		attributeGetterFunctions.put(
			"start_date",
			new Function<Calendar, Object>() {

				@Override
				public Object apply(Calendar calendar) {
					return calendar.getStart_date();
				}

			});
		attributeSetterBiConsumers.put(
			"start_date",
			new BiConsumer<Calendar, Object>() {

				@Override
				public void accept(Calendar calendar, Object start_dateObject) {
					calendar.setStart_date((Date)start_dateObject);
				}

			});
		attributeGetterFunctions.put(
			"end_date",
			new Function<Calendar, Object>() {

				@Override
				public Object apply(Calendar calendar) {
					return calendar.getEnd_date();
				}

			});
		attributeSetterBiConsumers.put(
			"end_date",
			new BiConsumer<Calendar, Object>() {

				@Override
				public void accept(Calendar calendar, Object end_dateObject) {
					calendar.setEnd_date((Date)end_dateObject);
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
	public String getService_id() {
		if (_service_id == null) {
			return "";
		}
		else {
			return _service_id;
		}
	}

	@Override
	public void setService_id(String service_id) {
		_columnBitmask = -1L;

		if (_originalService_id == null) {
			_originalService_id = _service_id;
		}

		_service_id = service_id;
	}

	public String getOriginalService_id() {
		return GetterUtil.getString(_originalService_id);
	}

	@Override
	public boolean getMonday() {
		return _monday;
	}

	@Override
	public boolean isMonday() {
		return _monday;
	}

	@Override
	public void setMonday(boolean monday) {
		_monday = monday;
	}

	@Override
	public boolean getTuesday() {
		return _tuesday;
	}

	@Override
	public boolean isTuesday() {
		return _tuesday;
	}

	@Override
	public void setTuesday(boolean tuesday) {
		_tuesday = tuesday;
	}

	@Override
	public boolean getWednesday() {
		return _wednesday;
	}

	@Override
	public boolean isWednesday() {
		return _wednesday;
	}

	@Override
	public void setWednesday(boolean wednesday) {
		_wednesday = wednesday;
	}

	@Override
	public boolean getThursday() {
		return _thursday;
	}

	@Override
	public boolean isThursday() {
		return _thursday;
	}

	@Override
	public void setThursday(boolean thursday) {
		_thursday = thursday;
	}

	@Override
	public boolean getFriday() {
		return _friday;
	}

	@Override
	public boolean isFriday() {
		return _friday;
	}

	@Override
	public void setFriday(boolean friday) {
		_friday = friday;
	}

	@Override
	public boolean getSaturday() {
		return _saturday;
	}

	@Override
	public boolean isSaturday() {
		return _saturday;
	}

	@Override
	public void setSaturday(boolean saturday) {
		_saturday = saturday;
	}

	@Override
	public boolean getSunday() {
		return _sunday;
	}

	@Override
	public boolean isSunday() {
		return _sunday;
	}

	@Override
	public void setSunday(boolean sunday) {
		_sunday = sunday;
	}

	@Override
	public Date getStart_date() {
		return _start_date;
	}

	@Override
	public void setStart_date(Date start_date) {
		_columnBitmask |= START_DATE_COLUMN_BITMASK;

		if (_originalStart_date == null) {
			_originalStart_date = _start_date;
		}

		_start_date = start_date;
	}

	public Date getOriginalStart_date() {
		return _originalStart_date;
	}

	@Override
	public Date getEnd_date() {
		return _end_date;
	}

	@Override
	public void setEnd_date(Date end_date) {
		_columnBitmask |= END_DATE_COLUMN_BITMASK;

		if (_originalEnd_date == null) {
			_originalEnd_date = _end_date;
		}

		_end_date = end_date;
	}

	public Date getOriginalEnd_date() {
		return _originalEnd_date;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, Calendar.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Calendar toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Calendar>
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
		CalendarImpl calendarImpl = new CalendarImpl();

		calendarImpl.setUuid(getUuid());
		calendarImpl.setId(getId());
		calendarImpl.setService_id(getService_id());
		calendarImpl.setMonday(isMonday());
		calendarImpl.setTuesday(isTuesday());
		calendarImpl.setWednesday(isWednesday());
		calendarImpl.setThursday(isThursday());
		calendarImpl.setFriday(isFriday());
		calendarImpl.setSaturday(isSaturday());
		calendarImpl.setSunday(isSunday());
		calendarImpl.setStart_date(getStart_date());
		calendarImpl.setEnd_date(getEnd_date());

		calendarImpl.resetOriginalValues();

		return calendarImpl;
	}

	@Override
	public int compareTo(Calendar calendar) {
		int value = 0;

		value = getService_id().compareTo(calendar.getService_id());

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

		if (!(object instanceof Calendar)) {
			return false;
		}

		Calendar calendar = (Calendar)object;

		long primaryKey = calendar.getPrimaryKey();

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
		CalendarModelImpl calendarModelImpl = this;

		calendarModelImpl._originalUuid = calendarModelImpl._uuid;

		calendarModelImpl._originalService_id = calendarModelImpl._service_id;

		calendarModelImpl._originalStart_date = calendarModelImpl._start_date;

		calendarModelImpl._originalEnd_date = calendarModelImpl._end_date;

		calendarModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Calendar> toCacheModel() {
		CalendarCacheModel calendarCacheModel = new CalendarCacheModel();

		calendarCacheModel.uuid = getUuid();

		String uuid = calendarCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			calendarCacheModel.uuid = null;
		}

		calendarCacheModel.id = getId();

		calendarCacheModel.service_id = getService_id();

		String service_id = calendarCacheModel.service_id;

		if ((service_id != null) && (service_id.length() == 0)) {
			calendarCacheModel.service_id = null;
		}

		calendarCacheModel.monday = isMonday();

		calendarCacheModel.tuesday = isTuesday();

		calendarCacheModel.wednesday = isWednesday();

		calendarCacheModel.thursday = isThursday();

		calendarCacheModel.friday = isFriday();

		calendarCacheModel.saturday = isSaturday();

		calendarCacheModel.sunday = isSunday();

		Date start_date = getStart_date();

		if (start_date != null) {
			calendarCacheModel.start_date = start_date.getTime();
		}
		else {
			calendarCacheModel.start_date = Long.MIN_VALUE;
		}

		Date end_date = getEnd_date();

		if (end_date != null) {
			calendarCacheModel.end_date = end_date.getTime();
		}
		else {
			calendarCacheModel.end_date = Long.MIN_VALUE;
		}

		return calendarCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Calendar, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Calendar, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Calendar, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Calendar)this));
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
		Map<String, Function<Calendar, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Calendar, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Calendar, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Calendar)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Calendar>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private String _originalUuid;
	private long _id;
	private String _service_id;
	private String _originalService_id;
	private boolean _monday;
	private boolean _tuesday;
	private boolean _wednesday;
	private boolean _thursday;
	private boolean _friday;
	private boolean _saturday;
	private boolean _sunday;
	private Date _start_date;
	private Date _originalStart_date;
	private Date _end_date;
	private Date _originalEnd_date;
	private long _columnBitmask;
	private Calendar _escapedModel;

}