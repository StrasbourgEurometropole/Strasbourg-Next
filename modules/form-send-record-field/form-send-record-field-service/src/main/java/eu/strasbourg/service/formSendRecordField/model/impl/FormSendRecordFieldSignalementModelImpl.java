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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import eu.strasbourg.service.formSendRecordField.model.FormSendRecordFieldSignalement;
import eu.strasbourg.service.formSendRecordField.model.FormSendRecordFieldSignalementModel;

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

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.formSendRecordField.service.util.ServiceProps.get(
			"value.object.entity.cache.enabled.eu.strasbourg.service.formSendRecordField.model.FormSendRecordFieldSignalement"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.formSendRecordField.service.util.ServiceProps.get(
			"value.object.finder.cache.enabled.eu.strasbourg.service.formSendRecordField.model.FormSendRecordFieldSignalement"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.formSendRecordField.service.util.ServiceProps.get(
			"value.object.column.bitmask.enabled.eu.strasbourg.service.formSendRecordField.model.FormSendRecordFieldSignalement"),
		true);

	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	public static final long FORMSENDRECORDFIELDID_COLUMN_BITMASK = 2L;

	public static final long GROUPID_COLUMN_BITMASK = 4L;

	public static final long PUBLIKID_COLUMN_BITMASK = 8L;

	public static final long UUID_COLUMN_BITMASK = 16L;

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

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

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

	private static Function<InvocationHandler, FormSendRecordFieldSignalement>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			FormSendRecordFieldSignalement.class.getClassLoader(),
			FormSendRecordFieldSignalement.class, ModelWrapper.class);

		try {
			Constructor<FormSendRecordFieldSignalement> constructor =
				(Constructor<FormSendRecordFieldSignalement>)
					proxyClass.getConstructor(InvocationHandler.class);

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
			"uuid",
			new Function<FormSendRecordFieldSignalement, Object>() {

				@Override
				public Object apply(
					FormSendRecordFieldSignalement
						formSendRecordFieldSignalement) {

					return formSendRecordFieldSignalement.getUuid();
				}

			});
		attributeSetterBiConsumers.put(
			"uuid",
			new BiConsumer<FormSendRecordFieldSignalement, Object>() {

				@Override
				public void accept(
					FormSendRecordFieldSignalement
						formSendRecordFieldSignalement,
					Object uuidObject) {

					formSendRecordFieldSignalement.setUuid((String)uuidObject);
				}

			});
		attributeGetterFunctions.put(
			"signalementId",
			new Function<FormSendRecordFieldSignalement, Object>() {

				@Override
				public Object apply(
					FormSendRecordFieldSignalement
						formSendRecordFieldSignalement) {

					return formSendRecordFieldSignalement.getSignalementId();
				}

			});
		attributeSetterBiConsumers.put(
			"signalementId",
			new BiConsumer<FormSendRecordFieldSignalement, Object>() {

				@Override
				public void accept(
					FormSendRecordFieldSignalement
						formSendRecordFieldSignalement,
					Object signalementIdObject) {

					formSendRecordFieldSignalement.setSignalementId(
						(Long)signalementIdObject);
				}

			});
		attributeGetterFunctions.put(
			"groupId",
			new Function<FormSendRecordFieldSignalement, Object>() {

				@Override
				public Object apply(
					FormSendRecordFieldSignalement
						formSendRecordFieldSignalement) {

					return formSendRecordFieldSignalement.getGroupId();
				}

			});
		attributeSetterBiConsumers.put(
			"groupId",
			new BiConsumer<FormSendRecordFieldSignalement, Object>() {

				@Override
				public void accept(
					FormSendRecordFieldSignalement
						formSendRecordFieldSignalement,
					Object groupIdObject) {

					formSendRecordFieldSignalement.setGroupId(
						(Long)groupIdObject);
				}

			});
		attributeGetterFunctions.put(
			"companyId",
			new Function<FormSendRecordFieldSignalement, Object>() {

				@Override
				public Object apply(
					FormSendRecordFieldSignalement
						formSendRecordFieldSignalement) {

					return formSendRecordFieldSignalement.getCompanyId();
				}

			});
		attributeSetterBiConsumers.put(
			"companyId",
			new BiConsumer<FormSendRecordFieldSignalement, Object>() {

				@Override
				public void accept(
					FormSendRecordFieldSignalement
						formSendRecordFieldSignalement,
					Object companyIdObject) {

					formSendRecordFieldSignalement.setCompanyId(
						(Long)companyIdObject);
				}

			});
		attributeGetterFunctions.put(
			"userId",
			new Function<FormSendRecordFieldSignalement, Object>() {

				@Override
				public Object apply(
					FormSendRecordFieldSignalement
						formSendRecordFieldSignalement) {

					return formSendRecordFieldSignalement.getUserId();
				}

			});
		attributeSetterBiConsumers.put(
			"userId",
			new BiConsumer<FormSendRecordFieldSignalement, Object>() {

				@Override
				public void accept(
					FormSendRecordFieldSignalement
						formSendRecordFieldSignalement,
					Object userIdObject) {

					formSendRecordFieldSignalement.setUserId(
						(Long)userIdObject);
				}

			});
		attributeGetterFunctions.put(
			"userName",
			new Function<FormSendRecordFieldSignalement, Object>() {

				@Override
				public Object apply(
					FormSendRecordFieldSignalement
						formSendRecordFieldSignalement) {

					return formSendRecordFieldSignalement.getUserName();
				}

			});
		attributeSetterBiConsumers.put(
			"userName",
			new BiConsumer<FormSendRecordFieldSignalement, Object>() {

				@Override
				public void accept(
					FormSendRecordFieldSignalement
						formSendRecordFieldSignalement,
					Object userNameObject) {

					formSendRecordFieldSignalement.setUserName(
						(String)userNameObject);
				}

			});
		attributeGetterFunctions.put(
			"createDate",
			new Function<FormSendRecordFieldSignalement, Object>() {

				@Override
				public Object apply(
					FormSendRecordFieldSignalement
						formSendRecordFieldSignalement) {

					return formSendRecordFieldSignalement.getCreateDate();
				}

			});
		attributeSetterBiConsumers.put(
			"createDate",
			new BiConsumer<FormSendRecordFieldSignalement, Object>() {

				@Override
				public void accept(
					FormSendRecordFieldSignalement
						formSendRecordFieldSignalement,
					Object createDateObject) {

					formSendRecordFieldSignalement.setCreateDate(
						(Date)createDateObject);
				}

			});
		attributeGetterFunctions.put(
			"modifiedDate",
			new Function<FormSendRecordFieldSignalement, Object>() {

				@Override
				public Object apply(
					FormSendRecordFieldSignalement
						formSendRecordFieldSignalement) {

					return formSendRecordFieldSignalement.getModifiedDate();
				}

			});
		attributeSetterBiConsumers.put(
			"modifiedDate",
			new BiConsumer<FormSendRecordFieldSignalement, Object>() {

				@Override
				public void accept(
					FormSendRecordFieldSignalement
						formSendRecordFieldSignalement,
					Object modifiedDateObject) {

					formSendRecordFieldSignalement.setModifiedDate(
						(Date)modifiedDateObject);
				}

			});
		attributeGetterFunctions.put(
			"status",
			new Function<FormSendRecordFieldSignalement, Object>() {

				@Override
				public Object apply(
					FormSendRecordFieldSignalement
						formSendRecordFieldSignalement) {

					return formSendRecordFieldSignalement.getStatus();
				}

			});
		attributeSetterBiConsumers.put(
			"status",
			new BiConsumer<FormSendRecordFieldSignalement, Object>() {

				@Override
				public void accept(
					FormSendRecordFieldSignalement
						formSendRecordFieldSignalement,
					Object statusObject) {

					formSendRecordFieldSignalement.setStatus(
						(Integer)statusObject);
				}

			});
		attributeGetterFunctions.put(
			"statusByUserId",
			new Function<FormSendRecordFieldSignalement, Object>() {

				@Override
				public Object apply(
					FormSendRecordFieldSignalement
						formSendRecordFieldSignalement) {

					return formSendRecordFieldSignalement.getStatusByUserId();
				}

			});
		attributeSetterBiConsumers.put(
			"statusByUserId",
			new BiConsumer<FormSendRecordFieldSignalement, Object>() {

				@Override
				public void accept(
					FormSendRecordFieldSignalement
						formSendRecordFieldSignalement,
					Object statusByUserIdObject) {

					formSendRecordFieldSignalement.setStatusByUserId(
						(Long)statusByUserIdObject);
				}

			});
		attributeGetterFunctions.put(
			"statusByUserName",
			new Function<FormSendRecordFieldSignalement, Object>() {

				@Override
				public Object apply(
					FormSendRecordFieldSignalement
						formSendRecordFieldSignalement) {

					return formSendRecordFieldSignalement.getStatusByUserName();
				}

			});
		attributeSetterBiConsumers.put(
			"statusByUserName",
			new BiConsumer<FormSendRecordFieldSignalement, Object>() {

				@Override
				public void accept(
					FormSendRecordFieldSignalement
						formSendRecordFieldSignalement,
					Object statusByUserNameObject) {

					formSendRecordFieldSignalement.setStatusByUserName(
						(String)statusByUserNameObject);
				}

			});
		attributeGetterFunctions.put(
			"statusDate",
			new Function<FormSendRecordFieldSignalement, Object>() {

				@Override
				public Object apply(
					FormSendRecordFieldSignalement
						formSendRecordFieldSignalement) {

					return formSendRecordFieldSignalement.getStatusDate();
				}

			});
		attributeSetterBiConsumers.put(
			"statusDate",
			new BiConsumer<FormSendRecordFieldSignalement, Object>() {

				@Override
				public void accept(
					FormSendRecordFieldSignalement
						formSendRecordFieldSignalement,
					Object statusDateObject) {

					formSendRecordFieldSignalement.setStatusDate(
						(Date)statusDateObject);
				}

			});
		attributeGetterFunctions.put(
			"formSendRecordFieldId",
			new Function<FormSendRecordFieldSignalement, Object>() {

				@Override
				public Object apply(
					FormSendRecordFieldSignalement
						formSendRecordFieldSignalement) {

					return formSendRecordFieldSignalement.
						getFormSendRecordFieldId();
				}

			});
		attributeSetterBiConsumers.put(
			"formSendRecordFieldId",
			new BiConsumer<FormSendRecordFieldSignalement, Object>() {

				@Override
				public void accept(
					FormSendRecordFieldSignalement
						formSendRecordFieldSignalement,
					Object formSendRecordFieldIdObject) {

					formSendRecordFieldSignalement.setFormSendRecordFieldId(
						(Long)formSendRecordFieldIdObject);
				}

			});
		attributeGetterFunctions.put(
			"publikId",
			new Function<FormSendRecordFieldSignalement, Object>() {

				@Override
				public Object apply(
					FormSendRecordFieldSignalement
						formSendRecordFieldSignalement) {

					return formSendRecordFieldSignalement.getPublikId();
				}

			});
		attributeSetterBiConsumers.put(
			"publikId",
			new BiConsumer<FormSendRecordFieldSignalement, Object>() {

				@Override
				public void accept(
					FormSendRecordFieldSignalement
						formSendRecordFieldSignalement,
					Object publikIdObject) {

					formSendRecordFieldSignalement.setPublikId(
						(String)publikIdObject);
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
	public long getSignalementId() {
		return _signalementId;
	}

	@Override
	public void setSignalementId(long signalementId) {
		_signalementId = signalementId;
	}

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
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_columnBitmask = -1L;

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

		_modifiedDate = modifiedDate;
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;
	}

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
		_statusByUserName = statusByUserName;
	}

	@Override
	public Date getStatusDate() {
		return _statusDate;
	}

	@Override
	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	@Override
	public long getFormSendRecordFieldId() {
		return _formSendRecordFieldId;
	}

	@Override
	public void setFormSendRecordFieldId(long formSendRecordFieldId) {
		_columnBitmask |= FORMSENDRECORDFIELDID_COLUMN_BITMASK;

		if (!_setOriginalFormSendRecordFieldId) {
			_setOriginalFormSendRecordFieldId = true;

			_originalFormSendRecordFieldId = _formSendRecordFieldId;
		}

		_formSendRecordFieldId = formSendRecordFieldId;
	}

	public long getOriginalFormSendRecordFieldId() {
		return _originalFormSendRecordFieldId;
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
		_columnBitmask |= PUBLIKID_COLUMN_BITMASK;

		if (_originalPublikId == null) {
			_originalPublikId = _publikId;
		}

		_publikId = publikId;
	}

	public String getOriginalPublikId() {
		return GetterUtil.getString(_originalPublikId);
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
		FormSendRecordFieldSignalementModelImpl
			formSendRecordFieldSignalementModelImpl = this;

		formSendRecordFieldSignalementModelImpl._originalUuid =
			formSendRecordFieldSignalementModelImpl._uuid;

		formSendRecordFieldSignalementModelImpl._originalGroupId =
			formSendRecordFieldSignalementModelImpl._groupId;

		formSendRecordFieldSignalementModelImpl._setOriginalGroupId = false;

		formSendRecordFieldSignalementModelImpl._originalCompanyId =
			formSendRecordFieldSignalementModelImpl._companyId;

		formSendRecordFieldSignalementModelImpl._setOriginalCompanyId = false;

		formSendRecordFieldSignalementModelImpl._setModifiedDate = false;

		formSendRecordFieldSignalementModelImpl._originalFormSendRecordFieldId =
			formSendRecordFieldSignalementModelImpl._formSendRecordFieldId;

		formSendRecordFieldSignalementModelImpl.
			_setOriginalFormSendRecordFieldId = false;

		formSendRecordFieldSignalementModelImpl._originalPublikId =
			formSendRecordFieldSignalementModelImpl._publikId;

		formSendRecordFieldSignalementModelImpl._columnBitmask = 0;
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
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<FormSendRecordFieldSignalement, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<FormSendRecordFieldSignalement, Object>
				attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(
				attributeGetterFunction.apply(
					(FormSendRecordFieldSignalement)this));
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
		Map<String, Function<FormSendRecordFieldSignalement, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<FormSendRecordFieldSignalement, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<FormSendRecordFieldSignalement, Object>
				attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply(
					(FormSendRecordFieldSignalement)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function
			<InvocationHandler, FormSendRecordFieldSignalement>
				_escapedModelProxyProviderFunction =
					_getProxyProviderFunction();

	}

	private String _uuid;
	private String _originalUuid;
	private long _signalementId;
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
	private long _formSendRecordFieldId;
	private long _originalFormSendRecordFieldId;
	private boolean _setOriginalFormSendRecordFieldId;
	private String _publikId;
	private String _originalPublikId;
	private long _columnBitmask;
	private FormSendRecordFieldSignalement _escapedModel;

}