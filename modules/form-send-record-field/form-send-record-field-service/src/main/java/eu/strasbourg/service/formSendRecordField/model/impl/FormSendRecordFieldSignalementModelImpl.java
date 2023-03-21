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

package eu.strasbourg.service.formSendRecordField.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import eu.strasbourg.service.formSendRecordField.model.FormSendRecordFieldSignalement;
import eu.strasbourg.service.formSendRecordField.model.FormSendRecordFieldSignalementModel;

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
 * The base model implementation for the FormSendRecordFieldSignalement service. Represents a row in the &quot;formSendRecordField_FormSendRecordFieldSignalement&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>FormSendRecordFieldSignalementModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FormSendRecordFieldSignalementImpl}.
 * </p>
 *
 * @author Angélique Zunino
 * @see FormSendRecordFieldSignalementImpl
 * @generated
 */
public class FormSendRecordFieldSignalementModelImpl
	extends BaseModelImpl<FormSendRecordFieldSignalement>
	implements FormSendRecordFieldSignalementModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a form send record field signalement model instance should use the <code>FormSendRecordFieldSignalement</code> interface instead.
	 */
	public static final String TABLE_NAME =
		"formSendRecordField_FormSendRecordFieldSignalement";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"signalementId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"status", Types.INTEGER}, {"statusByUserId", Types.BIGINT},
		{"statusByUserName", Types.VARCHAR}, {"statusDate", Types.TIMESTAMP},
		{"formSendRecordFieldId", Types.BIGINT}, {"publikId", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("signalementId", Types.BIGINT);
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
		TABLE_COLUMNS_MAP.put("formSendRecordFieldId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("publikId", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table formSendRecordField_FormSendRecordFieldSignalement (uuid_ VARCHAR(75) null,signalementId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,status INTEGER,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null,formSendRecordFieldId LONG,publikId VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP =
		"drop table formSendRecordField_FormSendRecordFieldSignalement";

	public static final String ORDER_BY_JPQL =
		" ORDER BY formSendRecordFieldSignalement.createDate ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY formSendRecordField_FormSendRecordFieldSignalement.createDate ASC";

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
	public static final long FORMSENDRECORDFIELDID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long PUBLIKID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long CREATEDATE_COLUMN_BITMASK = 32L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		eu.strasbourg.service.formSendRecordField.service.util.ServiceProps.get(
			"lock.expiration.time.eu.strasbourg.service.formSendRecordField.model.FormSendRecordFieldSignalement"));

	public FormSendRecordFieldSignalementModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _signalementId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSignalementId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _signalementId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return FormSendRecordFieldSignalement.class;
	}

	@Override
	public String getModelClassName() {
		return FormSendRecordFieldSignalement.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<FormSendRecordFieldSignalement, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<FormSendRecordFieldSignalement, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<FormSendRecordFieldSignalement, Object>
				attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply(
					(FormSendRecordFieldSignalement)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<FormSendRecordFieldSignalement, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<FormSendRecordFieldSignalement, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(FormSendRecordFieldSignalement)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<FormSendRecordFieldSignalement, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<FormSendRecordFieldSignalement, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map
		<String, Function<FormSendRecordFieldSignalement, Object>>
			_attributeGetterFunctions;
	private static final Map
		<String, BiConsumer<FormSendRecordFieldSignalement, Object>>
			_attributeSetterBiConsumers;

	static {
		Map<String, Function<FormSendRecordFieldSignalement, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String,
					 Function<FormSendRecordFieldSignalement, Object>>();
		Map<String, BiConsumer<FormSendRecordFieldSignalement, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<FormSendRecordFieldSignalement, ?>>();

		attributeGetterFunctions.put(
			"uuid", FormSendRecordFieldSignalement::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<FormSendRecordFieldSignalement, String>)
				FormSendRecordFieldSignalement::setUuid);
		attributeGetterFunctions.put(
			"signalementId", FormSendRecordFieldSignalement::getSignalementId);
		attributeSetterBiConsumers.put(
			"signalementId",
			(BiConsumer<FormSendRecordFieldSignalement, Long>)
				FormSendRecordFieldSignalement::setSignalementId);
		attributeGetterFunctions.put(
			"groupId", FormSendRecordFieldSignalement::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<FormSendRecordFieldSignalement, Long>)
				FormSendRecordFieldSignalement::setGroupId);
		attributeGetterFunctions.put(
			"companyId", FormSendRecordFieldSignalement::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<FormSendRecordFieldSignalement, Long>)
				FormSendRecordFieldSignalement::setCompanyId);
		attributeGetterFunctions.put(
			"userId", FormSendRecordFieldSignalement::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<FormSendRecordFieldSignalement, Long>)
				FormSendRecordFieldSignalement::setUserId);
		attributeGetterFunctions.put(
			"userName", FormSendRecordFieldSignalement::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<FormSendRecordFieldSignalement, String>)
				FormSendRecordFieldSignalement::setUserName);
		attributeGetterFunctions.put(
			"createDate", FormSendRecordFieldSignalement::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<FormSendRecordFieldSignalement, Date>)
				FormSendRecordFieldSignalement::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", FormSendRecordFieldSignalement::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<FormSendRecordFieldSignalement, Date>)
				FormSendRecordFieldSignalement::setModifiedDate);
		attributeGetterFunctions.put(
			"status", FormSendRecordFieldSignalement::getStatus);
		attributeSetterBiConsumers.put(
			"status",
			(BiConsumer<FormSendRecordFieldSignalement, Integer>)
				FormSendRecordFieldSignalement::setStatus);
		attributeGetterFunctions.put(
			"statusByUserId",
			FormSendRecordFieldSignalement::getStatusByUserId);
		attributeSetterBiConsumers.put(
			"statusByUserId",
			(BiConsumer<FormSendRecordFieldSignalement, Long>)
				FormSendRecordFieldSignalement::setStatusByUserId);
		attributeGetterFunctions.put(
			"statusByUserName",
			FormSendRecordFieldSignalement::getStatusByUserName);
		attributeSetterBiConsumers.put(
			"statusByUserName",
			(BiConsumer<FormSendRecordFieldSignalement, String>)
				FormSendRecordFieldSignalement::setStatusByUserName);
		attributeGetterFunctions.put(
			"statusDate", FormSendRecordFieldSignalement::getStatusDate);
		attributeSetterBiConsumers.put(
			"statusDate",
			(BiConsumer<FormSendRecordFieldSignalement, Date>)
				FormSendRecordFieldSignalement::setStatusDate);
		attributeGetterFunctions.put(
			"formSendRecordFieldId",
			FormSendRecordFieldSignalement::getFormSendRecordFieldId);
		attributeSetterBiConsumers.put(
			"formSendRecordFieldId",
			(BiConsumer<FormSendRecordFieldSignalement, Long>)
				FormSendRecordFieldSignalement::setFormSendRecordFieldId);
		attributeGetterFunctions.put(
			"publikId", FormSendRecordFieldSignalement::getPublikId);
		attributeSetterBiConsumers.put(
			"publikId",
			(BiConsumer<FormSendRecordFieldSignalement, String>)
				FormSendRecordFieldSignalement::setPublikId);

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
	public long getSignalementId() {
		return _signalementId;
	}

	@Override
	public void setSignalementId(long signalementId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_signalementId = signalementId;
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

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

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

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_status = status;
	}

	@Override
	public long getStatusByUserId() {
		return _statusByUserId;
	}

	@Override
	public void setStatusByUserId(long statusByUserId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_statusByUserId = statusByUserId;
	}

	@Override
	public String getStatusByUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getStatusByUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
	}

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
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_statusByUserName = statusByUserName;
	}

	@Override
	public Date getStatusDate() {
		return _statusDate;
	}

	@Override
	public void setStatusDate(Date statusDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_statusDate = statusDate;
	}

	@Override
	public long getFormSendRecordFieldId() {
		return _formSendRecordFieldId;
	}

	@Override
	public void setFormSendRecordFieldId(long formSendRecordFieldId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_formSendRecordFieldId = formSendRecordFieldId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalFormSendRecordFieldId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("formSendRecordFieldId"));
	}

	@Override
	public String getPublikId() {
		if (_publikId == null) {
			return "";
		}
		else {
			return _publikId;
		}
	}

	@Override
	public void setPublikId(String publikId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_publikId = publikId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalPublikId() {
		return getColumnOriginalValue("publikId");
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(
				FormSendRecordFieldSignalement.class.getName()));
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
			getCompanyId(), FormSendRecordFieldSignalement.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public FormSendRecordFieldSignalement toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, FormSendRecordFieldSignalement>
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
		FormSendRecordFieldSignalementImpl formSendRecordFieldSignalementImpl =
			new FormSendRecordFieldSignalementImpl();

		formSendRecordFieldSignalementImpl.setUuid(getUuid());
		formSendRecordFieldSignalementImpl.setSignalementId(getSignalementId());
		formSendRecordFieldSignalementImpl.setGroupId(getGroupId());
		formSendRecordFieldSignalementImpl.setCompanyId(getCompanyId());
		formSendRecordFieldSignalementImpl.setUserId(getUserId());
		formSendRecordFieldSignalementImpl.setUserName(getUserName());
		formSendRecordFieldSignalementImpl.setCreateDate(getCreateDate());
		formSendRecordFieldSignalementImpl.setModifiedDate(getModifiedDate());
		formSendRecordFieldSignalementImpl.setStatus(getStatus());
		formSendRecordFieldSignalementImpl.setStatusByUserId(
			getStatusByUserId());
		formSendRecordFieldSignalementImpl.setStatusByUserName(
			getStatusByUserName());
		formSendRecordFieldSignalementImpl.setStatusDate(getStatusDate());
		formSendRecordFieldSignalementImpl.setFormSendRecordFieldId(
			getFormSendRecordFieldId());
		formSendRecordFieldSignalementImpl.setPublikId(getPublikId());

		formSendRecordFieldSignalementImpl.resetOriginalValues();

		return formSendRecordFieldSignalementImpl;
	}

	@Override
	public FormSendRecordFieldSignalement cloneWithOriginalValues() {
		FormSendRecordFieldSignalementImpl formSendRecordFieldSignalementImpl =
			new FormSendRecordFieldSignalementImpl();

		formSendRecordFieldSignalementImpl.setUuid(
			this.<String>getColumnOriginalValue("uuid_"));
		formSendRecordFieldSignalementImpl.setSignalementId(
			this.<Long>getColumnOriginalValue("signalementId"));
		formSendRecordFieldSignalementImpl.setGroupId(
			this.<Long>getColumnOriginalValue("groupId"));
		formSendRecordFieldSignalementImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		formSendRecordFieldSignalementImpl.setUserId(
			this.<Long>getColumnOriginalValue("userId"));
		formSendRecordFieldSignalementImpl.setUserName(
			this.<String>getColumnOriginalValue("userName"));
		formSendRecordFieldSignalementImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		formSendRecordFieldSignalementImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		formSendRecordFieldSignalementImpl.setStatus(
			this.<Integer>getColumnOriginalValue("status"));
		formSendRecordFieldSignalementImpl.setStatusByUserId(
			this.<Long>getColumnOriginalValue("statusByUserId"));
		formSendRecordFieldSignalementImpl.setStatusByUserName(
			this.<String>getColumnOriginalValue("statusByUserName"));
		formSendRecordFieldSignalementImpl.setStatusDate(
			this.<Date>getColumnOriginalValue("statusDate"));
		formSendRecordFieldSignalementImpl.setFormSendRecordFieldId(
			this.<Long>getColumnOriginalValue("formSendRecordFieldId"));
		formSendRecordFieldSignalementImpl.setPublikId(
			this.<String>getColumnOriginalValue("publikId"));

		return formSendRecordFieldSignalementImpl;
	}

	@Override
	public int compareTo(
		FormSendRecordFieldSignalement formSendRecordFieldSignalement) {

		int value = 0;

		value = DateUtil.compareTo(
			getCreateDate(), formSendRecordFieldSignalement.getCreateDate());

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

		if (!(object instanceof FormSendRecordFieldSignalement)) {
			return false;
		}

		FormSendRecordFieldSignalement formSendRecordFieldSignalement =
			(FormSendRecordFieldSignalement)object;

		long primaryKey = formSendRecordFieldSignalement.getPrimaryKey();

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

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<FormSendRecordFieldSignalement> toCacheModel() {
		FormSendRecordFieldSignalementCacheModel
			formSendRecordFieldSignalementCacheModel =
				new FormSendRecordFieldSignalementCacheModel();

		formSendRecordFieldSignalementCacheModel.uuid = getUuid();

		String uuid = formSendRecordFieldSignalementCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			formSendRecordFieldSignalementCacheModel.uuid = null;
		}

		formSendRecordFieldSignalementCacheModel.signalementId =
			getSignalementId();

		formSendRecordFieldSignalementCacheModel.groupId = getGroupId();

		formSendRecordFieldSignalementCacheModel.companyId = getCompanyId();

		formSendRecordFieldSignalementCacheModel.userId = getUserId();

		formSendRecordFieldSignalementCacheModel.userName = getUserName();

		String userName = formSendRecordFieldSignalementCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			formSendRecordFieldSignalementCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			formSendRecordFieldSignalementCacheModel.createDate =
				createDate.getTime();
		}
		else {
			formSendRecordFieldSignalementCacheModel.createDate =
				Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			formSendRecordFieldSignalementCacheModel.modifiedDate =
				modifiedDate.getTime();
		}
		else {
			formSendRecordFieldSignalementCacheModel.modifiedDate =
				Long.MIN_VALUE;
		}

		formSendRecordFieldSignalementCacheModel.status = getStatus();

		formSendRecordFieldSignalementCacheModel.statusByUserId =
			getStatusByUserId();

		formSendRecordFieldSignalementCacheModel.statusByUserName =
			getStatusByUserName();

		String statusByUserName =
			formSendRecordFieldSignalementCacheModel.statusByUserName;

		if ((statusByUserName != null) && (statusByUserName.length() == 0)) {
			formSendRecordFieldSignalementCacheModel.statusByUserName = null;
		}

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			formSendRecordFieldSignalementCacheModel.statusDate =
				statusDate.getTime();
		}
		else {
			formSendRecordFieldSignalementCacheModel.statusDate =
				Long.MIN_VALUE;
		}

		formSendRecordFieldSignalementCacheModel.formSendRecordFieldId =
			getFormSendRecordFieldId();

		formSendRecordFieldSignalementCacheModel.publikId = getPublikId();

		String publikId = formSendRecordFieldSignalementCacheModel.publikId;

		if ((publikId != null) && (publikId.length() == 0)) {
			formSendRecordFieldSignalementCacheModel.publikId = null;
		}

		return formSendRecordFieldSignalementCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<FormSendRecordFieldSignalement, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<FormSendRecordFieldSignalement, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<FormSendRecordFieldSignalement, Object>
				attributeGetterFunction = entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply(
				(FormSendRecordFieldSignalement)this);

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

		private static final Function
			<InvocationHandler, FormSendRecordFieldSignalement>
				_escapedModelProxyProviderFunction =
					ProxyUtil.getProxyProviderFunction(
						FormSendRecordFieldSignalement.class,
						ModelWrapper.class);

	}

	private String _uuid;
	private long _signalementId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private long _formSendRecordFieldId;
	private String _publikId;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<FormSendRecordFieldSignalement, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((FormSendRecordFieldSignalement)this);
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
		_columnOriginalValues.put("signalementId", _signalementId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("status", _status);
		_columnOriginalValues.put("statusByUserId", _statusByUserId);
		_columnOriginalValues.put("statusByUserName", _statusByUserName);
		_columnOriginalValues.put("statusDate", _statusDate);
		_columnOriginalValues.put(
			"formSendRecordFieldId", _formSendRecordFieldId);
		_columnOriginalValues.put("publikId", _publikId);
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

		columnBitmasks.put("signalementId", 2L);

		columnBitmasks.put("groupId", 4L);

		columnBitmasks.put("companyId", 8L);

		columnBitmasks.put("userId", 16L);

		columnBitmasks.put("userName", 32L);

		columnBitmasks.put("createDate", 64L);

		columnBitmasks.put("modifiedDate", 128L);

		columnBitmasks.put("status", 256L);

		columnBitmasks.put("statusByUserId", 512L);

		columnBitmasks.put("statusByUserName", 1024L);

		columnBitmasks.put("statusDate", 2048L);

		columnBitmasks.put("formSendRecordFieldId", 4096L);

		columnBitmasks.put("publikId", 8192L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private FormSendRecordFieldSignalement _escapedModel;

}