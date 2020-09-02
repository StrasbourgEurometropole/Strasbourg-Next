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

package eu.strasbourg.service.ejob.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
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
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import eu.strasbourg.service.ejob.model.Alert;
import eu.strasbourg.service.ejob.model.AlertModel;
import eu.strasbourg.service.ejob.model.AlertSoap;

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
 * The base model implementation for the Alert service. Represents a row in the &quot;ejob_Alert&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>AlertModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AlertImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AlertImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class AlertModelImpl extends BaseModelImpl<Alert> implements AlertModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a alert model instance should use the <code>Alert</code> interface instead.
	 */
	public static final String TABLE_NAME = "ejob_Alert";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"alertId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"status", Types.INTEGER}, {"statusByUserId", Types.BIGINT},
		{"statusByUserName", Types.VARCHAR}, {"statusDate", Types.TIMESTAMP},
		{"name", Types.VARCHAR}, {"keyWord", Types.VARCHAR},
		{"publikUserId", Types.VARCHAR}, {"language", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("alertId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("statusByUserId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("statusByUserName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("statusDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("keyWord", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("publikUserId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("language", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table ejob_Alert (uuid_ VARCHAR(75) null,alertId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,status INTEGER,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null,name VARCHAR(75) null,keyWord VARCHAR(75) null,publikUserId VARCHAR(75) null,language VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table ejob_Alert";

	public static final String ORDER_BY_JPQL = " ORDER BY alert.alertId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY ejob_Alert.alertId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.ejob.service.util.ServiceProps.get(
			"value.object.entity.cache.enabled.eu.strasbourg.service.ejob.model.Alert"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.ejob.service.util.ServiceProps.get(
			"value.object.finder.cache.enabled.eu.strasbourg.service.ejob.model.Alert"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.ejob.service.util.ServiceProps.get(
			"value.object.column.bitmask.enabled.eu.strasbourg.service.ejob.model.Alert"),
		true);

	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	public static final long GROUPID_COLUMN_BITMASK = 2L;

	public static final long PUBLIKUSERID_COLUMN_BITMASK = 4L;

	public static final long UUID_COLUMN_BITMASK = 8L;

	public static final long ALERTID_COLUMN_BITMASK = 16L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Alert toModel(AlertSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Alert model = new AlertImpl();

		model.setUuid(soapModel.getUuid());
		model.setAlertId(soapModel.getAlertId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setStatus(soapModel.getStatus());
		model.setStatusByUserId(soapModel.getStatusByUserId());
		model.setStatusByUserName(soapModel.getStatusByUserName());
		model.setStatusDate(soapModel.getStatusDate());
		model.setName(soapModel.getName());
		model.setKeyWord(soapModel.getKeyWord());
		model.setPublikUserId(soapModel.getPublikUserId());
		model.setLanguage(soapModel.getLanguage());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Alert> toModels(AlertSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Alert> models = new ArrayList<Alert>(soapModels.length);

		for (AlertSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		eu.strasbourg.service.ejob.service.util.ServiceProps.get(
			"lock.expiration.time.eu.strasbourg.service.ejob.model.Alert"));

	public AlertModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _alertId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAlertId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _alertId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Alert.class;
	}

	@Override
	public String getModelClassName() {
		return Alert.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Alert, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Alert, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Alert, Object> attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Alert)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Alert, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Alert, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept((Alert)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Alert, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Alert, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Alert>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Alert.class.getClassLoader(), Alert.class, ModelWrapper.class);

		try {
			Constructor<Alert> constructor =
				(Constructor<Alert>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException roe) {
					throw new InternalError(roe);
				}
			};
		}
		catch (NoSuchMethodException nsme) {
			throw new InternalError(nsme);
		}
	}

	private static final Map<String, Function<Alert, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Alert, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Alert, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Alert, Object>>();
		Map<String, BiConsumer<Alert, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Alert, ?>>();

		attributeGetterFunctions.put(
			"uuid",
			new Function<Alert, Object>() {

				@Override
				public Object apply(Alert alert) {
					return alert.getUuid();
				}

			});
		attributeSetterBiConsumers.put(
			"uuid",
			new BiConsumer<Alert, Object>() {

				@Override
				public void accept(Alert alert, Object uuid) {
					alert.setUuid((String)uuid);
				}

			});
		attributeGetterFunctions.put(
			"alertId",
			new Function<Alert, Object>() {

				@Override
				public Object apply(Alert alert) {
					return alert.getAlertId();
				}

			});
		attributeSetterBiConsumers.put(
			"alertId",
			new BiConsumer<Alert, Object>() {

				@Override
				public void accept(Alert alert, Object alertId) {
					alert.setAlertId((Long)alertId);
				}

			});
		attributeGetterFunctions.put(
			"groupId",
			new Function<Alert, Object>() {

				@Override
				public Object apply(Alert alert) {
					return alert.getGroupId();
				}

			});
		attributeSetterBiConsumers.put(
			"groupId",
			new BiConsumer<Alert, Object>() {

				@Override
				public void accept(Alert alert, Object groupId) {
					alert.setGroupId((Long)groupId);
				}

			});
		attributeGetterFunctions.put(
			"companyId",
			new Function<Alert, Object>() {

				@Override
				public Object apply(Alert alert) {
					return alert.getCompanyId();
				}

			});
		attributeSetterBiConsumers.put(
			"companyId",
			new BiConsumer<Alert, Object>() {

				@Override
				public void accept(Alert alert, Object companyId) {
					alert.setCompanyId((Long)companyId);
				}

			});
		attributeGetterFunctions.put(
			"userId",
			new Function<Alert, Object>() {

				@Override
				public Object apply(Alert alert) {
					return alert.getUserId();
				}

			});
		attributeSetterBiConsumers.put(
			"userId",
			new BiConsumer<Alert, Object>() {

				@Override
				public void accept(Alert alert, Object userId) {
					alert.setUserId((Long)userId);
				}

			});
		attributeGetterFunctions.put(
			"userName",
			new Function<Alert, Object>() {

				@Override
				public Object apply(Alert alert) {
					return alert.getUserName();
				}

			});
		attributeSetterBiConsumers.put(
			"userName",
			new BiConsumer<Alert, Object>() {

				@Override
				public void accept(Alert alert, Object userName) {
					alert.setUserName((String)userName);
				}

			});
		attributeGetterFunctions.put(
			"createDate",
			new Function<Alert, Object>() {

				@Override
				public Object apply(Alert alert) {
					return alert.getCreateDate();
				}

			});
		attributeSetterBiConsumers.put(
			"createDate",
			new BiConsumer<Alert, Object>() {

				@Override
				public void accept(Alert alert, Object createDate) {
					alert.setCreateDate((Date)createDate);
				}

			});
		attributeGetterFunctions.put(
			"modifiedDate",
			new Function<Alert, Object>() {

				@Override
				public Object apply(Alert alert) {
					return alert.getModifiedDate();
				}

			});
		attributeSetterBiConsumers.put(
			"modifiedDate",
			new BiConsumer<Alert, Object>() {

				@Override
				public void accept(Alert alert, Object modifiedDate) {
					alert.setModifiedDate((Date)modifiedDate);
				}

			});
		attributeGetterFunctions.put(
			"status",
			new Function<Alert, Object>() {

				@Override
				public Object apply(Alert alert) {
					return alert.getStatus();
				}

			});
		attributeSetterBiConsumers.put(
			"status",
			new BiConsumer<Alert, Object>() {

				@Override
				public void accept(Alert alert, Object status) {
					alert.setStatus((Integer)status);
				}

			});
		attributeGetterFunctions.put(
			"statusByUserId",
			new Function<Alert, Object>() {

				@Override
				public Object apply(Alert alert) {
					return alert.getStatusByUserId();
				}

			});
		attributeSetterBiConsumers.put(
			"statusByUserId",
			new BiConsumer<Alert, Object>() {

				@Override
				public void accept(Alert alert, Object statusByUserId) {
					alert.setStatusByUserId((Long)statusByUserId);
				}

			});
		attributeGetterFunctions.put(
			"statusByUserName",
			new Function<Alert, Object>() {

				@Override
				public Object apply(Alert alert) {
					return alert.getStatusByUserName();
				}

			});
		attributeSetterBiConsumers.put(
			"statusByUserName",
			new BiConsumer<Alert, Object>() {

				@Override
				public void accept(Alert alert, Object statusByUserName) {
					alert.setStatusByUserName((String)statusByUserName);
				}

			});
		attributeGetterFunctions.put(
			"statusDate",
			new Function<Alert, Object>() {

				@Override
				public Object apply(Alert alert) {
					return alert.getStatusDate();
				}

			});
		attributeSetterBiConsumers.put(
			"statusDate",
			new BiConsumer<Alert, Object>() {

				@Override
				public void accept(Alert alert, Object statusDate) {
					alert.setStatusDate((Date)statusDate);
				}

			});
		attributeGetterFunctions.put(
			"name",
			new Function<Alert, Object>() {

				@Override
				public Object apply(Alert alert) {
					return alert.getName();
				}

			});
		attributeSetterBiConsumers.put(
			"name",
			new BiConsumer<Alert, Object>() {

				@Override
				public void accept(Alert alert, Object name) {
					alert.setName((String)name);
				}

			});
		attributeGetterFunctions.put(
			"keyWord",
			new Function<Alert, Object>() {

				@Override
				public Object apply(Alert alert) {
					return alert.getKeyWord();
				}

			});
		attributeSetterBiConsumers.put(
			"keyWord",
			new BiConsumer<Alert, Object>() {

				@Override
				public void accept(Alert alert, Object keyWord) {
					alert.setKeyWord((String)keyWord);
				}

			});
		attributeGetterFunctions.put(
			"publikUserId",
			new Function<Alert, Object>() {

				@Override
				public Object apply(Alert alert) {
					return alert.getPublikUserId();
				}

			});
		attributeSetterBiConsumers.put(
			"publikUserId",
			new BiConsumer<Alert, Object>() {

				@Override
				public void accept(Alert alert, Object publikUserId) {
					alert.setPublikUserId((String)publikUserId);
				}

			});
		attributeGetterFunctions.put(
			"language",
			new Function<Alert, Object>() {

				@Override
				public Object apply(Alert alert) {
					return alert.getLanguage();
				}

			});
		attributeSetterBiConsumers.put(
			"language",
			new BiConsumer<Alert, Object>() {

				@Override
				public void accept(Alert alert, Object language) {
					alert.setLanguage((String)language);
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
	public long getAlertId() {
		return _alertId;
	}

	@Override
	public void setAlertId(long alertId) {
		_alertId = alertId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
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
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;
	}

	@JSON
	@Override
	public long getStatusByUserId() {
		return _statusByUserId;
	}

	@Override
	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	@Override
	public String getStatusByUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getStatusByUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
	}

	@JSON
	@Override
	public String getStatusByUserName() {
		if (_statusByUserName == null) {
			return "";
		}
		else {
			return _statusByUserName;
		}
	}

	@Override
	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	@JSON
	@Override
	public Date getStatusDate() {
		return _statusDate;
	}

	@Override
	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_name = name;
	}

	@JSON
	@Override
	public String getKeyWord() {
		if (_keyWord == null) {
			return "";
		}
		else {
			return _keyWord;
		}
	}

	@Override
	public void setKeyWord(String keyWord) {
		_keyWord = keyWord;
	}

	@JSON
	@Override
	public String getPublikUserId() {
		if (_publikUserId == null) {
			return "";
		}
		else {
			return _publikUserId;
		}
	}

	@Override
	public void setPublikUserId(String publikUserId) {
		_columnBitmask |= PUBLIKUSERID_COLUMN_BITMASK;

		if (_originalPublikUserId == null) {
			_originalPublikUserId = _publikUserId;
		}

		_publikUserId = publikUserId;
	}

	public String getOriginalPublikUserId() {
		return GetterUtil.getString(_originalPublikUserId);
	}

	@JSON
	@Override
	public String getLanguage() {
		if (_language == null) {
			return "";
		}
		else {
			return _language;
		}
	}

	@Override
	public void setLanguage(String language) {
		_language = language;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(Alert.class.getName()));
	}

	@Override
	public boolean isApproved() {
		if (getStatus() == WorkflowConstants.STATUS_APPROVED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDenied() {
		if (getStatus() == WorkflowConstants.STATUS_DENIED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDraft() {
		if (getStatus() == WorkflowConstants.STATUS_DRAFT) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isExpired() {
		if (getStatus() == WorkflowConstants.STATUS_EXPIRED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isInactive() {
		if (getStatus() == WorkflowConstants.STATUS_INACTIVE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isIncomplete() {
		if (getStatus() == WorkflowConstants.STATUS_INCOMPLETE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isPending() {
		if (getStatus() == WorkflowConstants.STATUS_PENDING) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isScheduled() {
		if (getStatus() == WorkflowConstants.STATUS_SCHEDULED) {
			return true;
		}
		else {
			return false;
		}
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), Alert.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Alert toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = _escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		AlertImpl alertImpl = new AlertImpl();

		alertImpl.setUuid(getUuid());
		alertImpl.setAlertId(getAlertId());
		alertImpl.setGroupId(getGroupId());
		alertImpl.setCompanyId(getCompanyId());
		alertImpl.setUserId(getUserId());
		alertImpl.setUserName(getUserName());
		alertImpl.setCreateDate(getCreateDate());
		alertImpl.setModifiedDate(getModifiedDate());
		alertImpl.setStatus(getStatus());
		alertImpl.setStatusByUserId(getStatusByUserId());
		alertImpl.setStatusByUserName(getStatusByUserName());
		alertImpl.setStatusDate(getStatusDate());
		alertImpl.setName(getName());
		alertImpl.setKeyWord(getKeyWord());
		alertImpl.setPublikUserId(getPublikUserId());
		alertImpl.setLanguage(getLanguage());

		alertImpl.resetOriginalValues();

		return alertImpl;
	}

	@Override
	public int compareTo(Alert alert) {
		long primaryKey = alert.getPrimaryKey();

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
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Alert)) {
			return false;
		}

		Alert alert = (Alert)obj;

		long primaryKey = alert.getPrimaryKey();

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
		AlertModelImpl alertModelImpl = this;

		alertModelImpl._originalUuid = alertModelImpl._uuid;

		alertModelImpl._originalGroupId = alertModelImpl._groupId;

		alertModelImpl._setOriginalGroupId = false;

		alertModelImpl._originalCompanyId = alertModelImpl._companyId;

		alertModelImpl._setOriginalCompanyId = false;

		alertModelImpl._setModifiedDate = false;

		alertModelImpl._originalPublikUserId = alertModelImpl._publikUserId;

		alertModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Alert> toCacheModel() {
		AlertCacheModel alertCacheModel = new AlertCacheModel();

		alertCacheModel.uuid = getUuid();

		String uuid = alertCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			alertCacheModel.uuid = null;
		}

		alertCacheModel.alertId = getAlertId();

		alertCacheModel.groupId = getGroupId();

		alertCacheModel.companyId = getCompanyId();

		alertCacheModel.userId = getUserId();

		alertCacheModel.userName = getUserName();

		String userName = alertCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			alertCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			alertCacheModel.createDate = createDate.getTime();
		}
		else {
			alertCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			alertCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			alertCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		alertCacheModel.status = getStatus();

		alertCacheModel.statusByUserId = getStatusByUserId();

		alertCacheModel.statusByUserName = getStatusByUserName();

		String statusByUserName = alertCacheModel.statusByUserName;

		if ((statusByUserName != null) && (statusByUserName.length() == 0)) {
			alertCacheModel.statusByUserName = null;
		}

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			alertCacheModel.statusDate = statusDate.getTime();
		}
		else {
			alertCacheModel.statusDate = Long.MIN_VALUE;
		}

		alertCacheModel.name = getName();

		String name = alertCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			alertCacheModel.name = null;
		}

		alertCacheModel.keyWord = getKeyWord();

		String keyWord = alertCacheModel.keyWord;

		if ((keyWord != null) && (keyWord.length() == 0)) {
			alertCacheModel.keyWord = null;
		}

		alertCacheModel.publikUserId = getPublikUserId();

		String publikUserId = alertCacheModel.publikUserId;

		if ((publikUserId != null) && (publikUserId.length() == 0)) {
			alertCacheModel.publikUserId = null;
		}

		alertCacheModel.language = getLanguage();

		String language = alertCacheModel.language;

		if ((language != null) && (language.length() == 0)) {
			alertCacheModel.language = null;
		}

		return alertCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Alert, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Alert, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Alert, Object> attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Alert)this));
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
		Map<String, Function<Alert, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Alert, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Alert, Object> attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Alert)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final Function<InvocationHandler, Alert>
		_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	private String _uuid;
	private String _originalUuid;
	private long _alertId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private String _name;
	private String _keyWord;
	private String _publikUserId;
	private String _originalPublikUserId;
	private String _language;
	private long _columnBitmask;
	private Alert _escapedModel;

}