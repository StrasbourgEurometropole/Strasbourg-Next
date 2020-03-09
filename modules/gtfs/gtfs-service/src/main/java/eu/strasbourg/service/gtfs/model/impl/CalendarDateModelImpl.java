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

import eu.strasbourg.service.gtfs.model.CalendarDate;
import eu.strasbourg.service.gtfs.model.CalendarDateModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the CalendarDate service. Represents a row in the &quot;gtfs_CalendarDate&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link CalendarDateModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CalendarDateImpl}.
 * </p>
 *
 * @author Cedric Henry
 * @see CalendarDateImpl
 * @see CalendarDate
 * @see CalendarDateModel
 * @generated
 */
@ProviderType
public class CalendarDateModelImpl extends BaseModelImpl<CalendarDate>
	implements CalendarDateModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a calendar date model instance should use the {@link CalendarDate} interface instead.
	 */
	public static final String TABLE_NAME = "gtfs_CalendarDate";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "id_", Types.BIGINT },
			{ "service_id", Types.VARCHAR },
			{ "date_", Types.TIMESTAMP },
			{ "exception_type", Types.INTEGER }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("id_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("service_id", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("date_", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("exception_type", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE = "create table gtfs_CalendarDate (uuid_ VARCHAR(75) null,id_ LONG not null primary key,service_id VARCHAR(75) null,date_ DATE null,exception_type INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table gtfs_CalendarDate";
	public static final String ORDER_BY_JPQL = " ORDER BY calendarDate.service_id ASC";
	public static final String ORDER_BY_SQL = " ORDER BY gtfs_CalendarDate.service_id ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(eu.strasbourg.service.gtfs.service.util.PropsUtil.get(
				"value.object.entity.cache.enabled.eu.strasbourg.service.gtfs.model.CalendarDate"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(eu.strasbourg.service.gtfs.service.util.PropsUtil.get(
				"value.object.finder.cache.enabled.eu.strasbourg.service.gtfs.model.CalendarDate"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(eu.strasbourg.service.gtfs.service.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.eu.strasbourg.service.gtfs.model.CalendarDate"),
			true);
	public static final long DATE_COLUMN_BITMASK = 1L;
	public static final long SERVICE_ID_COLUMN_BITMASK = 2L;
	public static final long UUID_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(eu.strasbourg.service.gtfs.service.util.PropsUtil.get(
				"lock.expiration.time.eu.strasbourg.service.gtfs.model.CalendarDate"));

	public CalendarDateModelImpl() {
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
		return CalendarDate.class;
	}

	@Override
	public String getModelClassName() {
		return CalendarDate.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("service_id", getService_id());
		attributes.put("date", getDate());
		attributes.put("exception_type", getException_type());

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

		Date date = (Date)attributes.get("date");

		if (date != null) {
			setDate(date);
		}

		Integer exception_type = (Integer)attributes.get("exception_type");

		if (exception_type != null) {
			setException_type(exception_type);
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

		if (_originalService_id == null) {
			_originalService_id = _service_id;
		}

		_service_id = service_id;
	}

	public String getOriginalService_id() {
		return GetterUtil.getString(_originalService_id);
	}

	@Override
	public Date getDate() {
		return _date;
	}

	@Override
	public void setDate(Date date) {
		_columnBitmask |= DATE_COLUMN_BITMASK;

		if (_originalDate == null) {
			_originalDate = _date;
		}

		_date = date;
	}

	public Date getOriginalDate() {
		return _originalDate;
	}

	@Override
	public int getException_type() {
		return _exception_type;
	}

	@Override
	public void setException_type(int exception_type) {
		_exception_type = exception_type;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			CalendarDate.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CalendarDate toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (CalendarDate)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CalendarDateImpl calendarDateImpl = new CalendarDateImpl();

		calendarDateImpl.setUuid(getUuid());
		calendarDateImpl.setId(getId());
		calendarDateImpl.setService_id(getService_id());
		calendarDateImpl.setDate(getDate());
		calendarDateImpl.setException_type(getException_type());

		calendarDateImpl.resetOriginalValues();

		return calendarDateImpl;
	}

	@Override
	public int compareTo(CalendarDate calendarDate) {
		int value = 0;

		value = getService_id().compareTo(calendarDate.getService_id());

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

		if (!(obj instanceof CalendarDate)) {
			return false;
		}

		CalendarDate calendarDate = (CalendarDate)obj;

		long primaryKey = calendarDate.getPrimaryKey();

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
		CalendarDateModelImpl calendarDateModelImpl = this;

		calendarDateModelImpl._originalUuid = calendarDateModelImpl._uuid;

		calendarDateModelImpl._originalService_id = calendarDateModelImpl._service_id;

		calendarDateModelImpl._originalDate = calendarDateModelImpl._date;

		calendarDateModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CalendarDate> toCacheModel() {
		CalendarDateCacheModel calendarDateCacheModel = new CalendarDateCacheModel();

		calendarDateCacheModel.uuid = getUuid();

		String uuid = calendarDateCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			calendarDateCacheModel.uuid = null;
		}

		calendarDateCacheModel.id = getId();

		calendarDateCacheModel.service_id = getService_id();

		String service_id = calendarDateCacheModel.service_id;

		if ((service_id != null) && (service_id.length() == 0)) {
			calendarDateCacheModel.service_id = null;
		}

		Date date = getDate();

		if (date != null) {
			calendarDateCacheModel.date = date.getTime();
		}
		else {
			calendarDateCacheModel.date = Long.MIN_VALUE;
		}

		calendarDateCacheModel.exception_type = getException_type();

		return calendarDateCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", id=");
		sb.append(getId());
		sb.append(", service_id=");
		sb.append(getService_id());
		sb.append(", date=");
		sb.append(getDate());
		sb.append(", exception_type=");
		sb.append(getException_type());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("eu.strasbourg.service.gtfs.model.CalendarDate");
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
			"<column><column-name>date</column-name><column-value><![CDATA[");
		sb.append(getDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>exception_type</column-name><column-value><![CDATA[");
		sb.append(getException_type());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = CalendarDate.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			CalendarDate.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _id;
	private String _service_id;
	private String _originalService_id;
	private Date _date;
	private Date _originalDate;
	private int _exception_type;
	private long _columnBitmask;
	private CalendarDate _escapedModel;
}