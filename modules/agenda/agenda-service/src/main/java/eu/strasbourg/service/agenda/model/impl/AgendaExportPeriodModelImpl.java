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

package eu.strasbourg.service.agenda.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import eu.strasbourg.service.agenda.model.AgendaExportPeriod;
import eu.strasbourg.service.agenda.model.AgendaExportPeriodModel;
import eu.strasbourg.service.agenda.model.AgendaExportPeriodSoap;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the AgendaExportPeriod service. Represents a row in the &quot;agenda_AgendaExportPeriod&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>AgendaExportPeriodModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AgendaExportPeriodImpl}.
 * </p>
 *
 * @author BenjaminBini
 * @see AgendaExportPeriodImpl
 * @generated
 */
@JSON(strict = true)
public class AgendaExportPeriodModelImpl
	extends BaseModelImpl<AgendaExportPeriod>
	implements AgendaExportPeriodModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a agenda export period model instance should use the <code>AgendaExportPeriod</code> interface instead.
	 */
	public static final String TABLE_NAME = "agenda_AgendaExportPeriod";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"agendaExportPeriodId", Types.BIGINT},
		{"startDate", Types.TIMESTAMP}, {"endDate", Types.TIMESTAMP},
		{"agendaExportId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("agendaExportPeriodId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("startDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("endDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("agendaExportId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table agenda_AgendaExportPeriod (uuid_ VARCHAR(75) null,agendaExportPeriodId LONG not null primary key,startDate DATE null,endDate DATE null,agendaExportId LONG)";

	public static final String TABLE_SQL_DROP =
		"drop table agenda_AgendaExportPeriod";

	public static final String ORDER_BY_JPQL =
		" ORDER BY agendaExportPeriod.agendaExportPeriodId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY agenda_AgendaExportPeriod.agendaExportPeriodId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.agenda.service.util.PropsUtil.get(
			"value.object.entity.cache.enabled.eu.strasbourg.service.agenda.model.AgendaExportPeriod"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.agenda.service.util.PropsUtil.get(
			"value.object.finder.cache.enabled.eu.strasbourg.service.agenda.model.AgendaExportPeriod"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.agenda.service.util.PropsUtil.get(
			"value.object.column.bitmask.enabled.eu.strasbourg.service.agenda.model.AgendaExportPeriod"),
		true);

	public static final long AGENDAEXPORTID_COLUMN_BITMASK = 1L;

	public static final long UUID_COLUMN_BITMASK = 2L;

	public static final long AGENDAEXPORTPERIODID_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static AgendaExportPeriod toModel(AgendaExportPeriodSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		AgendaExportPeriod model = new AgendaExportPeriodImpl();

		model.setUuid(soapModel.getUuid());
		model.setAgendaExportPeriodId(soapModel.getAgendaExportPeriodId());
		model.setStartDate(soapModel.getStartDate());
		model.setEndDate(soapModel.getEndDate());
		model.setAgendaExportId(soapModel.getAgendaExportId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<AgendaExportPeriod> toModels(
		AgendaExportPeriodSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<AgendaExportPeriod> models = new ArrayList<AgendaExportPeriod>(
			soapModels.length);

		for (AgendaExportPeriodSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		eu.strasbourg.service.agenda.service.util.PropsUtil.get(
			"lock.expiration.time.eu.strasbourg.service.agenda.model.AgendaExportPeriod"));

	public AgendaExportPeriodModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _agendaExportPeriodId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAgendaExportPeriodId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _agendaExportPeriodId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return AgendaExportPeriod.class;
	}

	@Override
	public String getModelClassName() {
		return AgendaExportPeriod.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<AgendaExportPeriod, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<AgendaExportPeriod, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<AgendaExportPeriod, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((AgendaExportPeriod)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<AgendaExportPeriod, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<AgendaExportPeriod, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(AgendaExportPeriod)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<AgendaExportPeriod, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<AgendaExportPeriod, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, AgendaExportPeriod>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			AgendaExportPeriod.class.getClassLoader(), AgendaExportPeriod.class,
			ModelWrapper.class);

		try {
			Constructor<AgendaExportPeriod> constructor =
				(Constructor<AgendaExportPeriod>)proxyClass.getConstructor(
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

	private static final Map<String, Function<AgendaExportPeriod, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<AgendaExportPeriod, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<AgendaExportPeriod, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<AgendaExportPeriod, Object>>();
		Map<String, BiConsumer<AgendaExportPeriod, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<AgendaExportPeriod, ?>>();

		attributeGetterFunctions.put(
			"uuid",
			new Function<AgendaExportPeriod, Object>() {

				@Override
				public Object apply(AgendaExportPeriod agendaExportPeriod) {
					return agendaExportPeriod.getUuid();
				}

			});
		attributeSetterBiConsumers.put(
			"uuid",
			new BiConsumer<AgendaExportPeriod, Object>() {

				@Override
				public void accept(
					AgendaExportPeriod agendaExportPeriod, Object uuidObject) {

					agendaExportPeriod.setUuid((String)uuidObject);
				}

			});
		attributeGetterFunctions.put(
			"agendaExportPeriodId",
			new Function<AgendaExportPeriod, Object>() {

				@Override
				public Object apply(AgendaExportPeriod agendaExportPeriod) {
					return agendaExportPeriod.getAgendaExportPeriodId();
				}

			});
		attributeSetterBiConsumers.put(
			"agendaExportPeriodId",
			new BiConsumer<AgendaExportPeriod, Object>() {

				@Override
				public void accept(
					AgendaExportPeriod agendaExportPeriod,
					Object agendaExportPeriodIdObject) {

					agendaExportPeriod.setAgendaExportPeriodId(
						(Long)agendaExportPeriodIdObject);
				}

			});
		attributeGetterFunctions.put(
			"startDate",
			new Function<AgendaExportPeriod, Object>() {

				@Override
				public Object apply(AgendaExportPeriod agendaExportPeriod) {
					return agendaExportPeriod.getStartDate();
				}

			});
		attributeSetterBiConsumers.put(
			"startDate",
			new BiConsumer<AgendaExportPeriod, Object>() {

				@Override
				public void accept(
					AgendaExportPeriod agendaExportPeriod,
					Object startDateObject) {

					agendaExportPeriod.setStartDate((Date)startDateObject);
				}

			});
		attributeGetterFunctions.put(
			"endDate",
			new Function<AgendaExportPeriod, Object>() {

				@Override
				public Object apply(AgendaExportPeriod agendaExportPeriod) {
					return agendaExportPeriod.getEndDate();
				}

			});
		attributeSetterBiConsumers.put(
			"endDate",
			new BiConsumer<AgendaExportPeriod, Object>() {

				@Override
				public void accept(
					AgendaExportPeriod agendaExportPeriod,
					Object endDateObject) {

					agendaExportPeriod.setEndDate((Date)endDateObject);
				}

			});
		attributeGetterFunctions.put(
			"agendaExportId",
			new Function<AgendaExportPeriod, Object>() {

				@Override
				public Object apply(AgendaExportPeriod agendaExportPeriod) {
					return agendaExportPeriod.getAgendaExportId();
				}

			});
		attributeSetterBiConsumers.put(
			"agendaExportId",
			new BiConsumer<AgendaExportPeriod, Object>() {

				@Override
				public void accept(
					AgendaExportPeriod agendaExportPeriod,
					Object agendaExportIdObject) {

					agendaExportPeriod.setAgendaExportId(
						(Long)agendaExportIdObject);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
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

	@JSON
	@Override
	public long getAgendaExportPeriodId() {
		return _agendaExportPeriodId;
	}

	@Override
	public void setAgendaExportPeriodId(long agendaExportPeriodId) {
		_agendaExportPeriodId = agendaExportPeriodId;
	}

	@JSON
	@Override
	public Date getStartDate() {
		return _startDate;
	}

	@Override
	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	@JSON
	@Override
	public Date getEndDate() {
		return _endDate;
	}

	@Override
	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	@JSON
	@Override
	public long getAgendaExportId() {
		return _agendaExportId;
	}

	@Override
	public void setAgendaExportId(long agendaExportId) {
		_columnBitmask |= AGENDAEXPORTID_COLUMN_BITMASK;

		if (!_setOriginalAgendaExportId) {
			_setOriginalAgendaExportId = true;

			_originalAgendaExportId = _agendaExportId;
		}

		_agendaExportId = agendaExportId;
	}

	public long getOriginalAgendaExportId() {
		return _originalAgendaExportId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, AgendaExportPeriod.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public AgendaExportPeriod toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, AgendaExportPeriod>
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
		AgendaExportPeriodImpl agendaExportPeriodImpl =
			new AgendaExportPeriodImpl();

		agendaExportPeriodImpl.setUuid(getUuid());
		agendaExportPeriodImpl.setAgendaExportPeriodId(
			getAgendaExportPeriodId());
		agendaExportPeriodImpl.setStartDate(getStartDate());
		agendaExportPeriodImpl.setEndDate(getEndDate());
		agendaExportPeriodImpl.setAgendaExportId(getAgendaExportId());

		agendaExportPeriodImpl.resetOriginalValues();

		return agendaExportPeriodImpl;
	}

	@Override
	public int compareTo(AgendaExportPeriod agendaExportPeriod) {
		long primaryKey = agendaExportPeriod.getPrimaryKey();

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

		if (!(object instanceof AgendaExportPeriod)) {
			return false;
		}

		AgendaExportPeriod agendaExportPeriod = (AgendaExportPeriod)object;

		long primaryKey = agendaExportPeriod.getPrimaryKey();

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
		AgendaExportPeriodModelImpl agendaExportPeriodModelImpl = this;

		agendaExportPeriodModelImpl._originalUuid =
			agendaExportPeriodModelImpl._uuid;

		agendaExportPeriodModelImpl._originalAgendaExportId =
			agendaExportPeriodModelImpl._agendaExportId;

		agendaExportPeriodModelImpl._setOriginalAgendaExportId = false;

		agendaExportPeriodModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<AgendaExportPeriod> toCacheModel() {
		AgendaExportPeriodCacheModel agendaExportPeriodCacheModel =
			new AgendaExportPeriodCacheModel();

		agendaExportPeriodCacheModel.uuid = getUuid();

		String uuid = agendaExportPeriodCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			agendaExportPeriodCacheModel.uuid = null;
		}

		agendaExportPeriodCacheModel.agendaExportPeriodId =
			getAgendaExportPeriodId();

		Date startDate = getStartDate();

		if (startDate != null) {
			agendaExportPeriodCacheModel.startDate = startDate.getTime();
		}
		else {
			agendaExportPeriodCacheModel.startDate = Long.MIN_VALUE;
		}

		Date endDate = getEndDate();

		if (endDate != null) {
			agendaExportPeriodCacheModel.endDate = endDate.getTime();
		}
		else {
			agendaExportPeriodCacheModel.endDate = Long.MIN_VALUE;
		}

		agendaExportPeriodCacheModel.agendaExportId = getAgendaExportId();

		return agendaExportPeriodCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<AgendaExportPeriod, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<AgendaExportPeriod, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<AgendaExportPeriod, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((AgendaExportPeriod)this));
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
		Map<String, Function<AgendaExportPeriod, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<AgendaExportPeriod, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<AgendaExportPeriod, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((AgendaExportPeriod)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, AgendaExportPeriod>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private String _originalUuid;
	private long _agendaExportPeriodId;
	private Date _startDate;
	private Date _endDate;
	private long _agendaExportId;
	private long _originalAgendaExportId;
	private boolean _setOriginalAgendaExportId;
	private long _columnBitmask;
	private AgendaExportPeriod _escapedModel;

}