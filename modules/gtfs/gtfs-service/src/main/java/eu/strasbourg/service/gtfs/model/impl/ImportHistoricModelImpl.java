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
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
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

import eu.strasbourg.service.gtfs.model.ImportHistoric;
import eu.strasbourg.service.gtfs.model.ImportHistoricModel;

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
 * The base model implementation for the ImportHistoric service. Represents a row in the &quot;gtfs_ImportHistoric&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>ImportHistoricModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ImportHistoricImpl}.
 * </p>
 *
 * @author Cedric Henry
 * @see ImportHistoricImpl
 * @generated
 */
@ProviderType
public class ImportHistoricModelImpl
	extends BaseModelImpl<ImportHistoric> implements ImportHistoricModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a import historic model instance should use the <code>ImportHistoric</code> interface instead.
	 */
	public static final String TABLE_NAME = "gtfs_ImportHistoric";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"importHistoricId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"status", Types.INTEGER}, {"statusByUserId", Types.BIGINT},
		{"statusByUserName", Types.VARCHAR}, {"statusDate", Types.TIMESTAMP},
		{"result", Types.INTEGER}, {"operations", Types.CLOB},
		{"errorDescription", Types.CLOB}, {"errorStackTrace", Types.CLOB},
		{"startDate", Types.TIMESTAMP}, {"finishDate", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("importHistoricId", Types.BIGINT);
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
		TABLE_COLUMNS_MAP.put("result", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("operations", Types.CLOB);
		TABLE_COLUMNS_MAP.put("errorDescription", Types.CLOB);
		TABLE_COLUMNS_MAP.put("errorStackTrace", Types.CLOB);
		TABLE_COLUMNS_MAP.put("startDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("finishDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table gtfs_ImportHistoric (uuid_ VARCHAR(75) null,importHistoricId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,status INTEGER,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null,result INTEGER,operations TEXT null,errorDescription TEXT null,errorStackTrace TEXT null,startDate DATE null,finishDate DATE null)";

	public static final String TABLE_SQL_DROP =
		"drop table gtfs_ImportHistoric";

	public static final String ORDER_BY_JPQL =
		" ORDER BY importHistoric.importHistoricId DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY gtfs_ImportHistoric.importHistoricId DESC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.gtfs.service.util.PropsUtil.get(
			"value.object.entity.cache.enabled.eu.strasbourg.service.gtfs.model.ImportHistoric"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.gtfs.service.util.PropsUtil.get(
			"value.object.finder.cache.enabled.eu.strasbourg.service.gtfs.model.ImportHistoric"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.gtfs.service.util.PropsUtil.get(
			"value.object.column.bitmask.enabled.eu.strasbourg.service.gtfs.model.ImportHistoric"),
		true);

	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	public static final long GROUPID_COLUMN_BITMASK = 2L;

	public static final long UUID_COLUMN_BITMASK = 4L;

	public static final long IMPORTHISTORICID_COLUMN_BITMASK = 8L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		eu.strasbourg.service.gtfs.service.util.PropsUtil.get(
			"lock.expiration.time.eu.strasbourg.service.gtfs.model.ImportHistoric"));

	public ImportHistoricModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _importHistoricId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setImportHistoricId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _importHistoricId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ImportHistoric.class;
	}

	@Override
	public String getModelClassName() {
		return ImportHistoric.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<ImportHistoric, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<ImportHistoric, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ImportHistoric, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((ImportHistoric)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<ImportHistoric, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<ImportHistoric, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(ImportHistoric)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<ImportHistoric, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<ImportHistoric, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, ImportHistoric>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			ImportHistoric.class.getClassLoader(), ImportHistoric.class,
			ModelWrapper.class);

		try {
			Constructor<ImportHistoric> constructor =
				(Constructor<ImportHistoric>)proxyClass.getConstructor(
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

	private static final Map<String, Function<ImportHistoric, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<ImportHistoric, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<ImportHistoric, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<ImportHistoric, Object>>();
		Map<String, BiConsumer<ImportHistoric, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<ImportHistoric, ?>>();

		attributeGetterFunctions.put(
			"uuid",
			new Function<ImportHistoric, Object>() {

				@Override
				public Object apply(ImportHistoric importHistoric) {
					return importHistoric.getUuid();
				}

			});
		attributeSetterBiConsumers.put(
			"uuid",
			new BiConsumer<ImportHistoric, Object>() {

				@Override
				public void accept(ImportHistoric importHistoric, Object uuid) {
					importHistoric.setUuid((String)uuid);
				}

			});
		attributeGetterFunctions.put(
			"importHistoricId",
			new Function<ImportHistoric, Object>() {

				@Override
				public Object apply(ImportHistoric importHistoric) {
					return importHistoric.getImportHistoricId();
				}

			});
		attributeSetterBiConsumers.put(
			"importHistoricId",
			new BiConsumer<ImportHistoric, Object>() {

				@Override
				public void accept(
					ImportHistoric importHistoric, Object importHistoricId) {

					importHistoric.setImportHistoricId((Long)importHistoricId);
				}

			});
		attributeGetterFunctions.put(
			"groupId",
			new Function<ImportHistoric, Object>() {

				@Override
				public Object apply(ImportHistoric importHistoric) {
					return importHistoric.getGroupId();
				}

			});
		attributeSetterBiConsumers.put(
			"groupId",
			new BiConsumer<ImportHistoric, Object>() {

				@Override
				public void accept(
					ImportHistoric importHistoric, Object groupId) {

					importHistoric.setGroupId((Long)groupId);
				}

			});
		attributeGetterFunctions.put(
			"companyId",
			new Function<ImportHistoric, Object>() {

				@Override
				public Object apply(ImportHistoric importHistoric) {
					return importHistoric.getCompanyId();
				}

			});
		attributeSetterBiConsumers.put(
			"companyId",
			new BiConsumer<ImportHistoric, Object>() {

				@Override
				public void accept(
					ImportHistoric importHistoric, Object companyId) {

					importHistoric.setCompanyId((Long)companyId);
				}

			});
		attributeGetterFunctions.put(
			"userId",
			new Function<ImportHistoric, Object>() {

				@Override
				public Object apply(ImportHistoric importHistoric) {
					return importHistoric.getUserId();
				}

			});
		attributeSetterBiConsumers.put(
			"userId",
			new BiConsumer<ImportHistoric, Object>() {

				@Override
				public void accept(
					ImportHistoric importHistoric, Object userId) {

					importHistoric.setUserId((Long)userId);
				}

			});
		attributeGetterFunctions.put(
			"userName",
			new Function<ImportHistoric, Object>() {

				@Override
				public Object apply(ImportHistoric importHistoric) {
					return importHistoric.getUserName();
				}

			});
		attributeSetterBiConsumers.put(
			"userName",
			new BiConsumer<ImportHistoric, Object>() {

				@Override
				public void accept(
					ImportHistoric importHistoric, Object userName) {

					importHistoric.setUserName((String)userName);
				}

			});
		attributeGetterFunctions.put(
			"createDate",
			new Function<ImportHistoric, Object>() {

				@Override
				public Object apply(ImportHistoric importHistoric) {
					return importHistoric.getCreateDate();
				}

			});
		attributeSetterBiConsumers.put(
			"createDate",
			new BiConsumer<ImportHistoric, Object>() {

				@Override
				public void accept(
					ImportHistoric importHistoric, Object createDate) {

					importHistoric.setCreateDate((Date)createDate);
				}

			});
		attributeGetterFunctions.put(
			"modifiedDate",
			new Function<ImportHistoric, Object>() {

				@Override
				public Object apply(ImportHistoric importHistoric) {
					return importHistoric.getModifiedDate();
				}

			});
		attributeSetterBiConsumers.put(
			"modifiedDate",
			new BiConsumer<ImportHistoric, Object>() {

				@Override
				public void accept(
					ImportHistoric importHistoric, Object modifiedDate) {

					importHistoric.setModifiedDate((Date)modifiedDate);
				}

			});
		attributeGetterFunctions.put(
			"status",
			new Function<ImportHistoric, Object>() {

				@Override
				public Object apply(ImportHistoric importHistoric) {
					return importHistoric.getStatus();
				}

			});
		attributeSetterBiConsumers.put(
			"status",
			new BiConsumer<ImportHistoric, Object>() {

				@Override
				public void accept(
					ImportHistoric importHistoric, Object status) {

					importHistoric.setStatus((Integer)status);
				}

			});
		attributeGetterFunctions.put(
			"statusByUserId",
			new Function<ImportHistoric, Object>() {

				@Override
				public Object apply(ImportHistoric importHistoric) {
					return importHistoric.getStatusByUserId();
				}

			});
		attributeSetterBiConsumers.put(
			"statusByUserId",
			new BiConsumer<ImportHistoric, Object>() {

				@Override
				public void accept(
					ImportHistoric importHistoric, Object statusByUserId) {

					importHistoric.setStatusByUserId((Long)statusByUserId);
				}

			});
		attributeGetterFunctions.put(
			"statusByUserName",
			new Function<ImportHistoric, Object>() {

				@Override
				public Object apply(ImportHistoric importHistoric) {
					return importHistoric.getStatusByUserName();
				}

			});
		attributeSetterBiConsumers.put(
			"statusByUserName",
			new BiConsumer<ImportHistoric, Object>() {

				@Override
				public void accept(
					ImportHistoric importHistoric, Object statusByUserName) {

					importHistoric.setStatusByUserName(
						(String)statusByUserName);
				}

			});
		attributeGetterFunctions.put(
			"statusDate",
			new Function<ImportHistoric, Object>() {

				@Override
				public Object apply(ImportHistoric importHistoric) {
					return importHistoric.getStatusDate();
				}

			});
		attributeSetterBiConsumers.put(
			"statusDate",
			new BiConsumer<ImportHistoric, Object>() {

				@Override
				public void accept(
					ImportHistoric importHistoric, Object statusDate) {

					importHistoric.setStatusDate((Date)statusDate);
				}

			});
		attributeGetterFunctions.put(
			"result",
			new Function<ImportHistoric, Object>() {

				@Override
				public Object apply(ImportHistoric importHistoric) {
					return importHistoric.getResult();
				}

			});
		attributeSetterBiConsumers.put(
			"result",
			new BiConsumer<ImportHistoric, Object>() {

				@Override
				public void accept(
					ImportHistoric importHistoric, Object result) {

					importHistoric.setResult((Integer)result);
				}

			});
		attributeGetterFunctions.put(
			"operations",
			new Function<ImportHistoric, Object>() {

				@Override
				public Object apply(ImportHistoric importHistoric) {
					return importHistoric.getOperations();
				}

			});
		attributeSetterBiConsumers.put(
			"operations",
			new BiConsumer<ImportHistoric, Object>() {

				@Override
				public void accept(
					ImportHistoric importHistoric, Object operations) {

					importHistoric.setOperations((String)operations);
				}

			});
		attributeGetterFunctions.put(
			"errorDescription",
			new Function<ImportHistoric, Object>() {

				@Override
				public Object apply(ImportHistoric importHistoric) {
					return importHistoric.getErrorDescription();
				}

			});
		attributeSetterBiConsumers.put(
			"errorDescription",
			new BiConsumer<ImportHistoric, Object>() {

				@Override
				public void accept(
					ImportHistoric importHistoric, Object errorDescription) {

					importHistoric.setErrorDescription(
						(String)errorDescription);
				}

			});
		attributeGetterFunctions.put(
			"errorStackTrace",
			new Function<ImportHistoric, Object>() {

				@Override
				public Object apply(ImportHistoric importHistoric) {
					return importHistoric.getErrorStackTrace();
				}

			});
		attributeSetterBiConsumers.put(
			"errorStackTrace",
			new BiConsumer<ImportHistoric, Object>() {

				@Override
				public void accept(
					ImportHistoric importHistoric, Object errorStackTrace) {

					importHistoric.setErrorStackTrace((String)errorStackTrace);
				}

			});
		attributeGetterFunctions.put(
			"startDate",
			new Function<ImportHistoric, Object>() {

				@Override
				public Object apply(ImportHistoric importHistoric) {
					return importHistoric.getStartDate();
				}

			});
		attributeSetterBiConsumers.put(
			"startDate",
			new BiConsumer<ImportHistoric, Object>() {

				@Override
				public void accept(
					ImportHistoric importHistoric, Object startDate) {

					importHistoric.setStartDate((Date)startDate);
				}

			});
		attributeGetterFunctions.put(
			"finishDate",
			new Function<ImportHistoric, Object>() {

				@Override
				public Object apply(ImportHistoric importHistoric) {
					return importHistoric.getFinishDate();
				}

			});
		attributeSetterBiConsumers.put(
			"finishDate",
			new BiConsumer<ImportHistoric, Object>() {

				@Override
				public void accept(
					ImportHistoric importHistoric, Object finishDate) {

					importHistoric.setFinishDate((Date)finishDate);
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
	public long getImportHistoricId() {
		return _importHistoricId;
	}

	@Override
	public void setImportHistoricId(long importHistoricId) {
		_columnBitmask = -1L;

		_importHistoricId = importHistoricId;
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
		catch (PortalException pe) {
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
		catch (PortalException pe) {
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
	public int getResult() {
		return _result;
	}

	@Override
	public void setResult(int result) {
		_result = result;
	}

	@Override
	public String getOperations() {
		if (_operations == null) {
			return "";
		}
		else {
			return _operations;
		}
	}

	@Override
	public void setOperations(String operations) {
		_operations = operations;
	}

	@Override
	public String getErrorDescription() {
		if (_errorDescription == null) {
			return "";
		}
		else {
			return _errorDescription;
		}
	}

	@Override
	public void setErrorDescription(String errorDescription) {
		_errorDescription = errorDescription;
	}

	@Override
	public String getErrorStackTrace() {
		if (_errorStackTrace == null) {
			return "";
		}
		else {
			return _errorStackTrace;
		}
	}

	@Override
	public void setErrorStackTrace(String errorStackTrace) {
		_errorStackTrace = errorStackTrace;
	}

	@Override
	public Date getStartDate() {
		return _startDate;
	}

	@Override
	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	@Override
	public Date getFinishDate() {
		return _finishDate;
	}

	@Override
	public void setFinishDate(Date finishDate) {
		_finishDate = finishDate;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(ImportHistoric.class.getName()));
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
			getCompanyId(), ImportHistoric.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ImportHistoric toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = _escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ImportHistoricImpl importHistoricImpl = new ImportHistoricImpl();

		importHistoricImpl.setUuid(getUuid());
		importHistoricImpl.setImportHistoricId(getImportHistoricId());
		importHistoricImpl.setGroupId(getGroupId());
		importHistoricImpl.setCompanyId(getCompanyId());
		importHistoricImpl.setUserId(getUserId());
		importHistoricImpl.setUserName(getUserName());
		importHistoricImpl.setCreateDate(getCreateDate());
		importHistoricImpl.setModifiedDate(getModifiedDate());
		importHistoricImpl.setStatus(getStatus());
		importHistoricImpl.setStatusByUserId(getStatusByUserId());
		importHistoricImpl.setStatusByUserName(getStatusByUserName());
		importHistoricImpl.setStatusDate(getStatusDate());
		importHistoricImpl.setResult(getResult());
		importHistoricImpl.setOperations(getOperations());
		importHistoricImpl.setErrorDescription(getErrorDescription());
		importHistoricImpl.setErrorStackTrace(getErrorStackTrace());
		importHistoricImpl.setStartDate(getStartDate());
		importHistoricImpl.setFinishDate(getFinishDate());

		importHistoricImpl.resetOriginalValues();

		return importHistoricImpl;
	}

	@Override
	public int compareTo(ImportHistoric importHistoric) {
		int value = 0;

		if (getImportHistoricId() < importHistoric.getImportHistoricId()) {
			value = -1;
		}
		else if (getImportHistoricId() > importHistoric.getImportHistoricId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

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

		if (!(obj instanceof ImportHistoric)) {
			return false;
		}

		ImportHistoric importHistoric = (ImportHistoric)obj;

		long primaryKey = importHistoric.getPrimaryKey();

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
		ImportHistoricModelImpl importHistoricModelImpl = this;

		importHistoricModelImpl._originalUuid = importHistoricModelImpl._uuid;

		importHistoricModelImpl._originalGroupId =
			importHistoricModelImpl._groupId;

		importHistoricModelImpl._setOriginalGroupId = false;

		importHistoricModelImpl._originalCompanyId =
			importHistoricModelImpl._companyId;

		importHistoricModelImpl._setOriginalCompanyId = false;

		importHistoricModelImpl._setModifiedDate = false;

		importHistoricModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ImportHistoric> toCacheModel() {
		ImportHistoricCacheModel importHistoricCacheModel =
			new ImportHistoricCacheModel();

		importHistoricCacheModel.uuid = getUuid();

		String uuid = importHistoricCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			importHistoricCacheModel.uuid = null;
		}

		importHistoricCacheModel.importHistoricId = getImportHistoricId();

		importHistoricCacheModel.groupId = getGroupId();

		importHistoricCacheModel.companyId = getCompanyId();

		importHistoricCacheModel.userId = getUserId();

		importHistoricCacheModel.userName = getUserName();

		String userName = importHistoricCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			importHistoricCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			importHistoricCacheModel.createDate = createDate.getTime();
		}
		else {
			importHistoricCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			importHistoricCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			importHistoricCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		importHistoricCacheModel.status = getStatus();

		importHistoricCacheModel.statusByUserId = getStatusByUserId();

		importHistoricCacheModel.statusByUserName = getStatusByUserName();

		String statusByUserName = importHistoricCacheModel.statusByUserName;

		if ((statusByUserName != null) && (statusByUserName.length() == 0)) {
			importHistoricCacheModel.statusByUserName = null;
		}

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			importHistoricCacheModel.statusDate = statusDate.getTime();
		}
		else {
			importHistoricCacheModel.statusDate = Long.MIN_VALUE;
		}

		importHistoricCacheModel.result = getResult();

		importHistoricCacheModel.operations = getOperations();

		String operations = importHistoricCacheModel.operations;

		if ((operations != null) && (operations.length() == 0)) {
			importHistoricCacheModel.operations = null;
		}

		importHistoricCacheModel.errorDescription = getErrorDescription();

		String errorDescription = importHistoricCacheModel.errorDescription;

		if ((errorDescription != null) && (errorDescription.length() == 0)) {
			importHistoricCacheModel.errorDescription = null;
		}

		importHistoricCacheModel.errorStackTrace = getErrorStackTrace();

		String errorStackTrace = importHistoricCacheModel.errorStackTrace;

		if ((errorStackTrace != null) && (errorStackTrace.length() == 0)) {
			importHistoricCacheModel.errorStackTrace = null;
		}

		Date startDate = getStartDate();

		if (startDate != null) {
			importHistoricCacheModel.startDate = startDate.getTime();
		}
		else {
			importHistoricCacheModel.startDate = Long.MIN_VALUE;
		}

		Date finishDate = getFinishDate();

		if (finishDate != null) {
			importHistoricCacheModel.finishDate = finishDate.getTime();
		}
		else {
			importHistoricCacheModel.finishDate = Long.MIN_VALUE;
		}

		return importHistoricCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<ImportHistoric, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<ImportHistoric, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ImportHistoric, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((ImportHistoric)this));
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
		Map<String, Function<ImportHistoric, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<ImportHistoric, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ImportHistoric, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((ImportHistoric)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final Function<InvocationHandler, ImportHistoric>
		_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	private String _uuid;
	private String _originalUuid;
	private long _importHistoricId;
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
	private int _result;
	private String _operations;
	private String _errorDescription;
	private String _errorStackTrace;
	private Date _startDate;
	private Date _finishDate;
	private long _columnBitmask;
	private ImportHistoric _escapedModel;

}