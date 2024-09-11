/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
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

import eu.strasbourg.service.gtfs.model.Calendar;
import eu.strasbourg.service.gtfs.model.CalendarModel;

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
	public static final long END_DATE_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long SERVICE_ID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long START_DATE_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
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

		return AttributeGetterFunctionsHolder._attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Calendar, Object>>
		getAttributeSetterBiConsumers() {

		return AttributeSetterBiConsumersHolder._attributeSetterBiConsumers;
	}

	private static class AttributeGetterFunctionsHolder {

		private static final Map<String, Function<Calendar, Object>>
			_attributeGetterFunctions;

		static {
			Map<String, Function<Calendar, Object>> attributeGetterFunctions =
				new LinkedHashMap<String, Function<Calendar, Object>>();

			attributeGetterFunctions.put("uuid", Calendar::getUuid);
			attributeGetterFunctions.put("id", Calendar::getId);
			attributeGetterFunctions.put("service_id", Calendar::getService_id);
			attributeGetterFunctions.put("monday", Calendar::getMonday);
			attributeGetterFunctions.put("tuesday", Calendar::getTuesday);
			attributeGetterFunctions.put("wednesday", Calendar::getWednesday);
			attributeGetterFunctions.put("thursday", Calendar::getThursday);
			attributeGetterFunctions.put("friday", Calendar::getFriday);
			attributeGetterFunctions.put("saturday", Calendar::getSaturday);
			attributeGetterFunctions.put("sunday", Calendar::getSunday);
			attributeGetterFunctions.put("start_date", Calendar::getStart_date);
			attributeGetterFunctions.put("end_date", Calendar::getEnd_date);

			_attributeGetterFunctions = Collections.unmodifiableMap(
				attributeGetterFunctions);
		}

	}

	private static class AttributeSetterBiConsumersHolder {

		private static final Map<String, BiConsumer<Calendar, Object>>
			_attributeSetterBiConsumers;

		static {
			Map<String, BiConsumer<Calendar, ?>> attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<Calendar, ?>>();

			attributeSetterBiConsumers.put(
				"uuid", (BiConsumer<Calendar, String>)Calendar::setUuid);
			attributeSetterBiConsumers.put(
				"id", (BiConsumer<Calendar, Long>)Calendar::setId);
			attributeSetterBiConsumers.put(
				"service_id",
				(BiConsumer<Calendar, String>)Calendar::setService_id);
			attributeSetterBiConsumers.put(
				"monday", (BiConsumer<Calendar, Boolean>)Calendar::setMonday);
			attributeSetterBiConsumers.put(
				"tuesday", (BiConsumer<Calendar, Boolean>)Calendar::setTuesday);
			attributeSetterBiConsumers.put(
				"wednesday",
				(BiConsumer<Calendar, Boolean>)Calendar::setWednesday);
			attributeSetterBiConsumers.put(
				"thursday",
				(BiConsumer<Calendar, Boolean>)Calendar::setThursday);
			attributeSetterBiConsumers.put(
				"friday", (BiConsumer<Calendar, Boolean>)Calendar::setFriday);
			attributeSetterBiConsumers.put(
				"saturday",
				(BiConsumer<Calendar, Boolean>)Calendar::setSaturday);
			attributeSetterBiConsumers.put(
				"sunday", (BiConsumer<Calendar, Boolean>)Calendar::setSunday);
			attributeSetterBiConsumers.put(
				"start_date",
				(BiConsumer<Calendar, Date>)Calendar::setStart_date);
			attributeSetterBiConsumers.put(
				"end_date", (BiConsumer<Calendar, Date>)Calendar::setEnd_date);

			_attributeSetterBiConsumers = Collections.unmodifiableMap(
				(Map)attributeSetterBiConsumers);
		}

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
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

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
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_service_id = service_id;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalService_id() {
		return getColumnOriginalValue("service_id");
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
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

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
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

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
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

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
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

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
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

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
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

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
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_sunday = sunday;
	}

	@Override
	public Date getStart_date() {
		return _start_date;
	}

	@Override
	public void setStart_date(Date start_date) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_start_date = start_date;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public Date getOriginalStart_date() {
		return getColumnOriginalValue("start_date");
	}

	@Override
	public Date getEnd_date() {
		return _end_date;
	}

	@Override
	public void setEnd_date(Date end_date) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_end_date = end_date;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public Date getOriginalEnd_date() {
		return getColumnOriginalValue("end_date");
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
	public Calendar cloneWithOriginalValues() {
		CalendarImpl calendarImpl = new CalendarImpl();

		calendarImpl.setUuid(this.<String>getColumnOriginalValue("uuid_"));
		calendarImpl.setId(this.<Long>getColumnOriginalValue("id_"));
		calendarImpl.setService_id(
			this.<String>getColumnOriginalValue("service_id"));
		calendarImpl.setMonday(this.<Boolean>getColumnOriginalValue("monday"));
		calendarImpl.setTuesday(
			this.<Boolean>getColumnOriginalValue("tuesday"));
		calendarImpl.setWednesday(
			this.<Boolean>getColumnOriginalValue("wednesday"));
		calendarImpl.setThursday(
			this.<Boolean>getColumnOriginalValue("thursday"));
		calendarImpl.setFriday(this.<Boolean>getColumnOriginalValue("friday"));
		calendarImpl.setSaturday(
			this.<Boolean>getColumnOriginalValue("saturday"));
		calendarImpl.setSunday(this.<Boolean>getColumnOriginalValue("sunday"));
		calendarImpl.setStart_date(
			this.<Date>getColumnOriginalValue("start_date"));
		calendarImpl.setEnd_date(this.<Date>getColumnOriginalValue("end_date"));

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
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Calendar, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Calendar, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((Calendar)this);

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

		private static final Function<InvocationHandler, Calendar>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					Calendar.class, ModelWrapper.class);

	}

	private String _uuid;
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

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<Calendar, Object> function =
			AttributeGetterFunctionsHolder._attributeGetterFunctions.get(
				columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Calendar)this);
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
		_columnOriginalValues.put("id_", _id);
		_columnOriginalValues.put("service_id", _service_id);
		_columnOriginalValues.put("monday", _monday);
		_columnOriginalValues.put("tuesday", _tuesday);
		_columnOriginalValues.put("wednesday", _wednesday);
		_columnOriginalValues.put("thursday", _thursday);
		_columnOriginalValues.put("friday", _friday);
		_columnOriginalValues.put("saturday", _saturday);
		_columnOriginalValues.put("sunday", _sunday);
		_columnOriginalValues.put("start_date", _start_date);
		_columnOriginalValues.put("end_date", _end_date);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");
		attributeNames.put("id_", "id");

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

		columnBitmasks.put("id_", 2L);

		columnBitmasks.put("service_id", 4L);

		columnBitmasks.put("monday", 8L);

		columnBitmasks.put("tuesday", 16L);

		columnBitmasks.put("wednesday", 32L);

		columnBitmasks.put("thursday", 64L);

		columnBitmasks.put("friday", 128L);

		columnBitmasks.put("saturday", 256L);

		columnBitmasks.put("sunday", 512L);

		columnBitmasks.put("start_date", 1024L);

		columnBitmasks.put("end_date", 2048L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Calendar _escapedModel;

}