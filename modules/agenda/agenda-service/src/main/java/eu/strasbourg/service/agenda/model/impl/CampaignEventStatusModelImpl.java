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
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import eu.strasbourg.service.agenda.model.CampaignEventStatus;
import eu.strasbourg.service.agenda.model.CampaignEventStatusModel;

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
 * The base model implementation for the CampaignEventStatus service. Represents a row in the &quot;agenda_CampaignEventStatus&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>CampaignEventStatusModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CampaignEventStatusImpl}.
 * </p>
 *
 * @author BenjaminBini
 * @see CampaignEventStatusImpl
 * @generated
 */
@JSON(strict = true)
public class CampaignEventStatusModelImpl
	extends BaseModelImpl<CampaignEventStatus>
	implements CampaignEventStatusModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a campaign event status model instance should use the <code>CampaignEventStatus</code> interface instead.
	 */
	public static final String TABLE_NAME = "agenda_CampaignEventStatus";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"statusId", Types.BIGINT},
		{"status", Types.INTEGER}, {"comment_", Types.CLOB},
		{"deletionDenied", Types.BOOLEAN}, {"date_", Types.TIMESTAMP},
		{"campaignEventId", Types.BIGINT}, {"previousStatusId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("statusId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("comment_", Types.CLOB);
		TABLE_COLUMNS_MAP.put("deletionDenied", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("date_", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("campaignEventId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("previousStatusId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table agenda_CampaignEventStatus (uuid_ VARCHAR(75) null,statusId LONG not null primary key,status INTEGER,comment_ TEXT null,deletionDenied BOOLEAN,date_ DATE null,campaignEventId LONG,previousStatusId LONG,userId LONG,userName VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP =
		"drop table agenda_CampaignEventStatus";

	public static final String ORDER_BY_JPQL =
		" ORDER BY campaignEventStatus.statusId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY agenda_CampaignEventStatus.statusId ASC";

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
	public static final long CAMPAIGNEVENTID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long STATUSID_COLUMN_BITMASK = 4L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		eu.strasbourg.service.agenda.service.util.PropsUtil.get(
			"lock.expiration.time.eu.strasbourg.service.agenda.model.CampaignEventStatus"));

	public CampaignEventStatusModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _statusId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setStatusId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _statusId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CampaignEventStatus.class;
	}

	@Override
	public String getModelClassName() {
		return CampaignEventStatus.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CampaignEventStatus, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CampaignEventStatus, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CampaignEventStatus, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((CampaignEventStatus)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CampaignEventStatus, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CampaignEventStatus, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CampaignEventStatus)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CampaignEventStatus, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CampaignEventStatus, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<CampaignEventStatus, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<CampaignEventStatus, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<CampaignEventStatus, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<CampaignEventStatus, Object>>();
		Map<String, BiConsumer<CampaignEventStatus, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<CampaignEventStatus, ?>>();

		attributeGetterFunctions.put("uuid", CampaignEventStatus::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<CampaignEventStatus, String>)
				CampaignEventStatus::setUuid);
		attributeGetterFunctions.put(
			"statusId", CampaignEventStatus::getStatusId);
		attributeSetterBiConsumers.put(
			"statusId",
			(BiConsumer<CampaignEventStatus, Long>)
				CampaignEventStatus::setStatusId);
		attributeGetterFunctions.put("status", CampaignEventStatus::getStatus);
		attributeSetterBiConsumers.put(
			"status",
			(BiConsumer<CampaignEventStatus, Integer>)
				CampaignEventStatus::setStatus);
		attributeGetterFunctions.put(
			"comment", CampaignEventStatus::getComment);
		attributeSetterBiConsumers.put(
			"comment",
			(BiConsumer<CampaignEventStatus, String>)
				CampaignEventStatus::setComment);
		attributeGetterFunctions.put(
			"deletionDenied", CampaignEventStatus::getDeletionDenied);
		attributeSetterBiConsumers.put(
			"deletionDenied",
			(BiConsumer<CampaignEventStatus, Boolean>)
				CampaignEventStatus::setDeletionDenied);
		attributeGetterFunctions.put("date", CampaignEventStatus::getDate);
		attributeSetterBiConsumers.put(
			"date",
			(BiConsumer<CampaignEventStatus, Date>)
				CampaignEventStatus::setDate);
		attributeGetterFunctions.put(
			"campaignEventId", CampaignEventStatus::getCampaignEventId);
		attributeSetterBiConsumers.put(
			"campaignEventId",
			(BiConsumer<CampaignEventStatus, Long>)
				CampaignEventStatus::setCampaignEventId);
		attributeGetterFunctions.put(
			"previousStatusId", CampaignEventStatus::getPreviousStatusId);
		attributeSetterBiConsumers.put(
			"previousStatusId",
			(BiConsumer<CampaignEventStatus, Long>)
				CampaignEventStatus::setPreviousStatusId);
		attributeGetterFunctions.put("userId", CampaignEventStatus::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<CampaignEventStatus, Long>)
				CampaignEventStatus::setUserId);
		attributeGetterFunctions.put(
			"userName", CampaignEventStatus::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<CampaignEventStatus, String>)
				CampaignEventStatus::setUserName);

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

	@JSON
	@Override
	public long getStatusId() {
		return _statusId;
	}

	@Override
	public void setStatusId(long statusId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_statusId = statusId;
	}

	@JSON
	@Override
	public Integer getStatus() {
		return _status;
	}

	@Override
	public void setStatus(Integer status) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_status = status;
	}

	@JSON
	@Override
	public String getComment() {
		if (_comment == null) {
			return "";
		}
		else {
			return _comment;
		}
	}

	@Override
	public void setComment(String comment) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_comment = comment;
	}

	@JSON
	@Override
	public Boolean getDeletionDenied() {
		return _deletionDenied;
	}

	@Override
	public void setDeletionDenied(Boolean deletionDenied) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_deletionDenied = deletionDenied;
	}

	@JSON
	@Override
	public Date getDate() {
		return _date;
	}

	@Override
	public void setDate(Date date) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_date = date;
	}

	@JSON
	@Override
	public long getCampaignEventId() {
		return _campaignEventId;
	}

	@Override
	public void setCampaignEventId(long campaignEventId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_campaignEventId = campaignEventId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCampaignEventId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("campaignEventId"));
	}

	@JSON
	@Override
	public long getPreviousStatusId() {
		return _previousStatusId;
	}

	@Override
	public void setPreviousStatusId(long previousStatusId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_previousStatusId = previousStatusId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
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
			0, CampaignEventStatus.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CampaignEventStatus toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CampaignEventStatus>
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
		CampaignEventStatusImpl campaignEventStatusImpl =
			new CampaignEventStatusImpl();

		campaignEventStatusImpl.setUuid(getUuid());
		campaignEventStatusImpl.setStatusId(getStatusId());
		campaignEventStatusImpl.setStatus(getStatus());
		campaignEventStatusImpl.setComment(getComment());
		campaignEventStatusImpl.setDeletionDenied(getDeletionDenied());
		campaignEventStatusImpl.setDate(getDate());
		campaignEventStatusImpl.setCampaignEventId(getCampaignEventId());
		campaignEventStatusImpl.setPreviousStatusId(getPreviousStatusId());
		campaignEventStatusImpl.setUserId(getUserId());
		campaignEventStatusImpl.setUserName(getUserName());

		campaignEventStatusImpl.resetOriginalValues();

		return campaignEventStatusImpl;
	}

	@Override
	public CampaignEventStatus cloneWithOriginalValues() {
		CampaignEventStatusImpl campaignEventStatusImpl =
			new CampaignEventStatusImpl();

		campaignEventStatusImpl.setUuid(
			this.<String>getColumnOriginalValue("uuid_"));
		campaignEventStatusImpl.setStatusId(
			this.<Long>getColumnOriginalValue("statusId"));
		campaignEventStatusImpl.setStatus(
			this.<Integer>getColumnOriginalValue("status"));
		campaignEventStatusImpl.setComment(
			this.<String>getColumnOriginalValue("comment_"));
		campaignEventStatusImpl.setDeletionDenied(
			this.<Boolean>getColumnOriginalValue("deletionDenied"));
		campaignEventStatusImpl.setDate(
			this.<Date>getColumnOriginalValue("date_"));
		campaignEventStatusImpl.setCampaignEventId(
			this.<Long>getColumnOriginalValue("campaignEventId"));
		campaignEventStatusImpl.setPreviousStatusId(
			this.<Long>getColumnOriginalValue("previousStatusId"));
		campaignEventStatusImpl.setUserId(
			this.<Long>getColumnOriginalValue("userId"));
		campaignEventStatusImpl.setUserName(
			this.<String>getColumnOriginalValue("userName"));

		return campaignEventStatusImpl;
	}

	@Override
	public int compareTo(CampaignEventStatus campaignEventStatus) {
		long primaryKey = campaignEventStatus.getPrimaryKey();

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

		if (!(object instanceof CampaignEventStatus)) {
			return false;
		}

		CampaignEventStatus campaignEventStatus = (CampaignEventStatus)object;

		long primaryKey = campaignEventStatus.getPrimaryKey();

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
	public CacheModel<CampaignEventStatus> toCacheModel() {
		CampaignEventStatusCacheModel campaignEventStatusCacheModel =
			new CampaignEventStatusCacheModel();

		campaignEventStatusCacheModel.uuid = getUuid();

		String uuid = campaignEventStatusCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			campaignEventStatusCacheModel.uuid = null;
		}

		campaignEventStatusCacheModel.statusId = getStatusId();

		Integer status = getStatus();

		if (status != null) {
			campaignEventStatusCacheModel.status = status;
		}

		campaignEventStatusCacheModel.comment = getComment();

		String comment = campaignEventStatusCacheModel.comment;

		if ((comment != null) && (comment.length() == 0)) {
			campaignEventStatusCacheModel.comment = null;
		}

		Boolean deletionDenied = getDeletionDenied();

		if (deletionDenied != null) {
			campaignEventStatusCacheModel.deletionDenied = deletionDenied;
		}

		Date date = getDate();

		if (date != null) {
			campaignEventStatusCacheModel.date = date.getTime();
		}
		else {
			campaignEventStatusCacheModel.date = Long.MIN_VALUE;
		}

		campaignEventStatusCacheModel.campaignEventId = getCampaignEventId();

		campaignEventStatusCacheModel.previousStatusId = getPreviousStatusId();

		campaignEventStatusCacheModel.userId = getUserId();

		campaignEventStatusCacheModel.userName = getUserName();

		String userName = campaignEventStatusCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			campaignEventStatusCacheModel.userName = null;
		}

		return campaignEventStatusCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CampaignEventStatus, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CampaignEventStatus, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CampaignEventStatus, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply(
				(CampaignEventStatus)this);

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

		private static final Function<InvocationHandler, CampaignEventStatus>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					CampaignEventStatus.class, ModelWrapper.class);

	}

	private String _uuid;
	private long _statusId;
	private Integer _status;
	private String _comment;
	private Boolean _deletionDenied;
	private Date _date;
	private long _campaignEventId;
	private long _previousStatusId;
	private long _userId;
	private String _userName;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<CampaignEventStatus, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((CampaignEventStatus)this);
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
		_columnOriginalValues.put("statusId", _statusId);
		_columnOriginalValues.put("status", _status);
		_columnOriginalValues.put("comment_", _comment);
		_columnOriginalValues.put("deletionDenied", _deletionDenied);
		_columnOriginalValues.put("date_", _date);
		_columnOriginalValues.put("campaignEventId", _campaignEventId);
		_columnOriginalValues.put("previousStatusId", _previousStatusId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");
		attributeNames.put("comment_", "comment");
		attributeNames.put("date_", "date");

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

		columnBitmasks.put("statusId", 2L);

		columnBitmasks.put("status", 4L);

		columnBitmasks.put("comment_", 8L);

		columnBitmasks.put("deletionDenied", 16L);

		columnBitmasks.put("date_", 32L);

		columnBitmasks.put("campaignEventId", 64L);

		columnBitmasks.put("previousStatusId", 128L);

		columnBitmasks.put("userId", 256L);

		columnBitmasks.put("userName", 512L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private CampaignEventStatus _escapedModel;

}