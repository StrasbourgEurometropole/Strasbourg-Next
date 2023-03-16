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
import eu.strasbourg.service.gtfs.model.Agency;
import eu.strasbourg.service.gtfs.model.AgencyModel;

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
 * The base model implementation for the Agency service. Represents a row in the &quot;gtfs_Agency&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>AgencyModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AgencyImpl}.
 * </p>
 *
 * @author Cedric Henry
 * @see AgencyImpl
 * @generated
 */
public class AgencyModelImpl
	extends BaseModelImpl<Agency> implements AgencyModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a agency model instance should use the <code>Agency</code> interface instead.
	 */
	public static final String TABLE_NAME = "gtfs_Agency";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"id_", Types.BIGINT},
		{"agency_name", Types.VARCHAR}, {"agency_url", Types.VARCHAR},
		{"agency_timezone", Types.VARCHAR}, {"agency_phone", Types.VARCHAR},
		{"agency_fare_url", Types.VARCHAR}, {"agency_lang", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("id_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("agency_name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("agency_url", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("agency_timezone", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("agency_phone", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("agency_fare_url", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("agency_lang", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table gtfs_Agency (uuid_ VARCHAR(75) null,id_ LONG not null primary key,agency_name VARCHAR(75) null,agency_url VARCHAR(400) null,agency_timezone VARCHAR(75) null,agency_phone VARCHAR(75) null,agency_fare_url VARCHAR(400) null,agency_lang VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table gtfs_Agency";

	public static final String ORDER_BY_JPQL =
		" ORDER BY agency.agency_name ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY gtfs_Agency.agency_name ASC";

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
	public static final long UUID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long AGENCY_NAME_COLUMN_BITMASK = 2L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		eu.strasbourg.service.gtfs.service.util.PropsUtil.get(
			"lock.expiration.time.eu.strasbourg.service.gtfs.model.Agency"));

	public AgencyModelImpl() {
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
		return Agency.class;
	}

	@Override
	public String getModelClassName() {
		return Agency.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Agency, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Agency, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Agency, Object> attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Agency)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Agency, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Agency, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Agency)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Agency, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Agency, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<Agency, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Agency, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Agency, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Agency, Object>>();
		Map<String, BiConsumer<Agency, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Agency, ?>>();

		attributeGetterFunctions.put("uuid", Agency::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<Agency, String>)Agency::setUuid);
		attributeGetterFunctions.put("id", Agency::getId);
		attributeSetterBiConsumers.put(
			"id", (BiConsumer<Agency, Long>)Agency::setId);
		attributeGetterFunctions.put("agency_name", Agency::getAgency_name);
		attributeSetterBiConsumers.put(
			"agency_name", (BiConsumer<Agency, String>)Agency::setAgency_name);
		attributeGetterFunctions.put("agency_url", Agency::getAgency_url);
		attributeSetterBiConsumers.put(
			"agency_url", (BiConsumer<Agency, String>)Agency::setAgency_url);
		attributeGetterFunctions.put(
			"agency_timezone", Agency::getAgency_timezone);
		attributeSetterBiConsumers.put(
			"agency_timezone",
			(BiConsumer<Agency, String>)Agency::setAgency_timezone);
		attributeGetterFunctions.put("agency_phone", Agency::getAgency_phone);
		attributeSetterBiConsumers.put(
			"agency_phone",
			(BiConsumer<Agency, String>)Agency::setAgency_phone);
		attributeGetterFunctions.put(
			"agency_fare_url", Agency::getAgency_fare_url);
		attributeSetterBiConsumers.put(
			"agency_fare_url",
			(BiConsumer<Agency, String>)Agency::setAgency_fare_url);
		attributeGetterFunctions.put("agency_lang", Agency::getAgency_lang);
		attributeSetterBiConsumers.put(
			"agency_lang", (BiConsumer<Agency, String>)Agency::setAgency_lang);

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
	public String getAgency_name() {
		if (_agency_name == null) {
			return "";
		}
		else {
			return _agency_name;
		}
	}

	@Override
	public void setAgency_name(String agency_name) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_agency_name = agency_name;
	}

	@Override
	public String getAgency_url() {
		if (_agency_url == null) {
			return "";
		}
		else {
			return _agency_url;
		}
	}

	@Override
	public void setAgency_url(String agency_url) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_agency_url = agency_url;
	}

	@Override
	public String getAgency_timezone() {
		if (_agency_timezone == null) {
			return "";
		}
		else {
			return _agency_timezone;
		}
	}

	@Override
	public void setAgency_timezone(String agency_timezone) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_agency_timezone = agency_timezone;
	}

	@Override
	public String getAgency_phone() {
		if (_agency_phone == null) {
			return "";
		}
		else {
			return _agency_phone;
		}
	}

	@Override
	public void setAgency_phone(String agency_phone) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_agency_phone = agency_phone;
	}

	@Override
	public String getAgency_fare_url() {
		if (_agency_fare_url == null) {
			return "";
		}
		else {
			return _agency_fare_url;
		}
	}

	@Override
	public void setAgency_fare_url(String agency_fare_url) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_agency_fare_url = agency_fare_url;
	}

	@Override
	public String getAgency_lang() {
		if (_agency_lang == null) {
			return "";
		}
		else {
			return _agency_lang;
		}
	}

	@Override
	public void setAgency_lang(String agency_lang) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_agency_lang = agency_lang;
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
			0, Agency.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Agency toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Agency>
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
		AgencyImpl agencyImpl = new AgencyImpl();

		agencyImpl.setUuid(getUuid());
		agencyImpl.setId(getId());
		agencyImpl.setAgency_name(getAgency_name());
		agencyImpl.setAgency_url(getAgency_url());
		agencyImpl.setAgency_timezone(getAgency_timezone());
		agencyImpl.setAgency_phone(getAgency_phone());
		agencyImpl.setAgency_fare_url(getAgency_fare_url());
		agencyImpl.setAgency_lang(getAgency_lang());

		agencyImpl.resetOriginalValues();

		return agencyImpl;
	}

	@Override
	public Agency cloneWithOriginalValues() {
		AgencyImpl agencyImpl = new AgencyImpl();

		agencyImpl.setUuid(this.<String>getColumnOriginalValue("uuid_"));
		agencyImpl.setId(this.<Long>getColumnOriginalValue("id_"));
		agencyImpl.setAgency_name(
			this.<String>getColumnOriginalValue("agency_name"));
		agencyImpl.setAgency_url(
			this.<String>getColumnOriginalValue("agency_url"));
		agencyImpl.setAgency_timezone(
			this.<String>getColumnOriginalValue("agency_timezone"));
		agencyImpl.setAgency_phone(
			this.<String>getColumnOriginalValue("agency_phone"));
		agencyImpl.setAgency_fare_url(
			this.<String>getColumnOriginalValue("agency_fare_url"));
		agencyImpl.setAgency_lang(
			this.<String>getColumnOriginalValue("agency_lang"));

		return agencyImpl;
	}

	@Override
	public int compareTo(Agency agency) {
		int value = 0;

		value = getAgency_name().compareTo(agency.getAgency_name());

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

		if (!(object instanceof Agency)) {
			return false;
		}

		Agency agency = (Agency)object;

		long primaryKey = agency.getPrimaryKey();

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
	public CacheModel<Agency> toCacheModel() {
		AgencyCacheModel agencyCacheModel = new AgencyCacheModel();

		agencyCacheModel.uuid = getUuid();

		String uuid = agencyCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			agencyCacheModel.uuid = null;
		}

		agencyCacheModel.id = getId();

		agencyCacheModel.agency_name = getAgency_name();

		String agency_name = agencyCacheModel.agency_name;

		if ((agency_name != null) && (agency_name.length() == 0)) {
			agencyCacheModel.agency_name = null;
		}

		agencyCacheModel.agency_url = getAgency_url();

		String agency_url = agencyCacheModel.agency_url;

		if ((agency_url != null) && (agency_url.length() == 0)) {
			agencyCacheModel.agency_url = null;
		}

		agencyCacheModel.agency_timezone = getAgency_timezone();

		String agency_timezone = agencyCacheModel.agency_timezone;

		if ((agency_timezone != null) && (agency_timezone.length() == 0)) {
			agencyCacheModel.agency_timezone = null;
		}

		agencyCacheModel.agency_phone = getAgency_phone();

		String agency_phone = agencyCacheModel.agency_phone;

		if ((agency_phone != null) && (agency_phone.length() == 0)) {
			agencyCacheModel.agency_phone = null;
		}

		agencyCacheModel.agency_fare_url = getAgency_fare_url();

		String agency_fare_url = agencyCacheModel.agency_fare_url;

		if ((agency_fare_url != null) && (agency_fare_url.length() == 0)) {
			agencyCacheModel.agency_fare_url = null;
		}

		agencyCacheModel.agency_lang = getAgency_lang();

		String agency_lang = agencyCacheModel.agency_lang;

		if ((agency_lang != null) && (agency_lang.length() == 0)) {
			agencyCacheModel.agency_lang = null;
		}

		return agencyCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Agency, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Agency, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Agency, Object> attributeGetterFunction = entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((Agency)this);

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

		private static final Function<InvocationHandler, Agency>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					Agency.class, ModelWrapper.class);

	}

	private String _uuid;
	private long _id;
	private String _agency_name;
	private String _agency_url;
	private String _agency_timezone;
	private String _agency_phone;
	private String _agency_fare_url;
	private String _agency_lang;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<Agency, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Agency)this);
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
		_columnOriginalValues.put("agency_name", _agency_name);
		_columnOriginalValues.put("agency_url", _agency_url);
		_columnOriginalValues.put("agency_timezone", _agency_timezone);
		_columnOriginalValues.put("agency_phone", _agency_phone);
		_columnOriginalValues.put("agency_fare_url", _agency_fare_url);
		_columnOriginalValues.put("agency_lang", _agency_lang);
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

		columnBitmasks.put("agency_name", 4L);

		columnBitmasks.put("agency_url", 8L);

		columnBitmasks.put("agency_timezone", 16L);

		columnBitmasks.put("agency_phone", 32L);

		columnBitmasks.put("agency_fare_url", 64L);

		columnBitmasks.put("agency_lang", 128L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Agency _escapedModel;

}