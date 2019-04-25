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

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import eu.strasbourg.service.gtfs.model.Calendar;
import eu.strasbourg.service.gtfs.model.CalendarModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Calendar service. Represents a row in the &quot;gtfs_Calendar&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link CalendarModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CalendarImpl}.
 * </p>
 *
 * @author Cedric Henry
 * @see CalendarImpl
 * @see Calendar
 * @see CalendarModel
 * @generated
 */
@ProviderType
public class CalendarModelImpl extends BaseModelImpl<Calendar>
	implements CalendarModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a calendar model instance should use the {@link Calendar} interface instead.
	 */
	public static final String TABLE_NAME = "gtfs_Calendar";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "id_", Types.BIGINT },
			{ "service_id", Types.VARCHAR },
			{ "monday", Types.BOOLEAN },
			{ "tuesday", Types.BOOLEAN },
			{ "wednesday", Types.BOOLEAN },
			{ "thursday", Types.BOOLEAN },
			{ "friday", Types.BOOLEAN },
			{ "saturday", Types.BOOLEAN },
			{ "sunday", Types.BOOLEAN },
			{ "start_date", Types.TIMESTAMP },
			{ "end_date", Types.TIMESTAMP }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

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

	public static final String TABLE_SQL_CREATE = "create table gtfs_Calendar (uuid_ VARCHAR(75) null,id_ LONG not null primary key,service_id VARCHAR(75) null,monday BOOLEAN,tuesday BOOLEAN,wednesday BOOLEAN,thursday BOOLEAN,friday BOOLEAN,saturday BOOLEAN,sunday BOOLEAN,start_date DATE null,end_date DATE null)";
	public static final String TABLE_SQL_DROP = "drop table gtfs_Calendar";
	public static final String ORDER_BY_JPQL = " ORDER BY calendar.service_id ASC";
	public static final String ORDER_BY_SQL = " ORDER BY gtfs_Calendar.service_id ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(eu.strasbourg.service.gtfs.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.eu.strasbourg.service.gtfs.model.Calendar"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(eu.strasbourg.service.gtfs.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.eu.strasbourg.service.gtfs.model.Calendar"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(eu.strasbourg.service.gtfs.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.eu.strasbourg.service.gtfs.model.Calendar"),
			true);
	public static final long UUID_COLUMN_BITMASK = 1L;
	public static final long SERVICE_ID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(eu.strasbourg.service.gtfs.service.util.ServiceProps.get(
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

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("service_id", getService_id());
		attributes.put("monday", getMonday());
		attributes.put("tuesday", getTuesday());
		attributes.put("wednesday", getWednesday());
		attributes.put("thursday", getThursday());
		attributes.put("friday", getFriday());
		attributes.put("saturday", getSaturday());
		attributes.put("sunday", getSunday());
		attributes.put("start_date", getStart_date());
		attributes.put("end_date", getEnd_date());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String service_id = (String)attributes.get("service_id");

		if (service_id != null) {
			setService_id(service_id);
		}

		Boolean monday = (Boolean)attributes.get("monday");

		if (monday != null) {
			setMonday(monday);
		}

		Boolean tuesday = (Boolean)attributes.get("tuesday");

		if (tuesday != null) {
			setTuesday(tuesday);
		}

		Boolean wednesday = (Boolean)attributes.get("wednesday");

		if (wednesday != null) {
			setWednesday(wednesday);
		}

		Boolean thursday = (Boolean)attributes.get("thursday");

		if (thursday != null) {
			setThursday(thursday);
		}

		Boolean friday = (Boolean)attributes.get("friday");

		if (friday != null) {
			setFriday(friday);
		}

		Boolean saturday = (Boolean)attributes.get("saturday");

		if (saturday != null) {
			setSaturday(saturday);
		}

		Boolean sunday = (Boolean)attributes.get("sunday");

		if (sunday != null) {
			setSunday(sunday);
		}

		Date start_date = (Date)attributes.get("start_date");

		if (start_date != null) {
			setStart_date(start_date);
		}

		Date end_date = (Date)attributes.get("end_date");

		if (end_date != null) {
			setEnd_date(end_date);
		}
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
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
			return StringPool.BLANK;
		}
		else {
			return _service_id;
		}
	}

	@Override
	public void setService_id(String service_id) {
		_columnBitmask = -1L;

		_service_id = service_id;
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
		_start_date = start_date;
	}

	@Override
	public Date getEnd_date() {
		return _end_date;
	}

	@Override
	public void setEnd_date(Date end_date) {
		_end_date = end_date;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Calendar.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Calendar toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Calendar)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CalendarImpl calendarImpl = new CalendarImpl();

		calendarImpl.setUuid(getUuid());
		calendarImpl.setId(getId());
		calendarImpl.setService_id(getService_id());
		calendarImpl.setMonday(getMonday());
		calendarImpl.setTuesday(getTuesday());
		calendarImpl.setWednesday(getWednesday());
		calendarImpl.setThursday(getThursday());
		calendarImpl.setFriday(getFriday());
		calendarImpl.setSaturday(getSaturday());
		calendarImpl.setSunday(getSunday());
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
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Calendar)) {
			return false;
		}

		Calendar calendar = (Calendar)obj;

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

		calendarCacheModel.monday = getMonday();

		calendarCacheModel.tuesday = getTuesday();

		calendarCacheModel.wednesday = getWednesday();

		calendarCacheModel.thursday = getThursday();

		calendarCacheModel.friday = getFriday();

		calendarCacheModel.saturday = getSaturday();

		calendarCacheModel.sunday = getSunday();

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
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", id=");
		sb.append(getId());
		sb.append(", service_id=");
		sb.append(getService_id());
		sb.append(", monday=");
		sb.append(getMonday());
		sb.append(", tuesday=");
		sb.append(getTuesday());
		sb.append(", wednesday=");
		sb.append(getWednesday());
		sb.append(", thursday=");
		sb.append(getThursday());
		sb.append(", friday=");
		sb.append(getFriday());
		sb.append(", saturday=");
		sb.append(getSaturday());
		sb.append(", sunday=");
		sb.append(getSunday());
		sb.append(", start_date=");
		sb.append(getStart_date());
		sb.append(", end_date=");
		sb.append(getEnd_date());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("eu.strasbourg.service.gtfs.model.Calendar");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>service_id</column-name><column-value><![CDATA[");
		sb.append(getService_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>monday</column-name><column-value><![CDATA[");
		sb.append(getMonday());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tuesday</column-name><column-value><![CDATA[");
		sb.append(getTuesday());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>wednesday</column-name><column-value><![CDATA[");
		sb.append(getWednesday());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>thursday</column-name><column-value><![CDATA[");
		sb.append(getThursday());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>friday</column-name><column-value><![CDATA[");
		sb.append(getFriday());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>saturday</column-name><column-value><![CDATA[");
		sb.append(getSaturday());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sunday</column-name><column-value><![CDATA[");
		sb.append(getSunday());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>start_date</column-name><column-value><![CDATA[");
		sb.append(getStart_date());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>end_date</column-name><column-value><![CDATA[");
		sb.append(getEnd_date());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = Calendar.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			Calendar.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _id;
	private String _service_id;
	private boolean _monday;
	private boolean _tuesday;
	private boolean _wednesday;
	private boolean _thursday;
	private boolean _friday;
	private boolean _saturday;
	private boolean _sunday;
	private Date _start_date;
	private Date _end_date;
	private long _columnBitmask;
	private Calendar _escapedModel;
}