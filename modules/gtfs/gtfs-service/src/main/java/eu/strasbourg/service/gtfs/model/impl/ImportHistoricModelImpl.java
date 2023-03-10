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
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import eu.strasbourg.service.gtfs.model.ImportHistoric;
import eu.strasbourg.service.gtfs.model.ImportHistoricModel;

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
 * The base model implementation for the ImportHistoric service. Represents a row in the &quot;gtfs_ImportHistoric&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>ImportHistoricModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ImportHistoricImpl}.
 * </p>
 *
 * @author Cedric Henry
 * @see ImportHistoricImpl
 * @generated
 */
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
		{"startDate", Types.TIMESTAMP}, {"finishDate", Types.TIMESTAMP},
		{"gtfsFileHash", Types.VARCHAR}
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
		TABLE_COLUMNS_MAP.put("gtfsFileHash", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table gtfs_ImportHistoric (uuid_ VARCHAR(75) null,importHistoricId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,status INTEGER,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null,result INTEGER,operations TEXT null,errorDescription TEXT null,errorStackTrace TEXT null,startDate DATE null,finishDate DATE null,gtfsFileHash VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP =
		"drop table gtfs_ImportHistoric";

	public static final String ORDER_BY_JPQL =
		" ORDER BY importHistoric.importHistoricId DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY gtfs_ImportHistoric.importHistoricId DESC";

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
	public static final long GROUPID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
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

	private static final Map<String, Function<ImportHistoric, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<ImportHistoric, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<ImportHistoric, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<ImportHistoric, Object>>();
		Map<String, BiConsumer<ImportHistoric, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<ImportHistoric, ?>>();

		attributeGetterFunctions.put("uuid", ImportHistoric::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<ImportHistoric, String>)ImportHistoric::setUuid);
		attributeGetterFunctions.put(
			"importHistoricId", ImportHistoric::getImportHistoricId);
		attributeSetterBiConsumers.put(
			"importHistoricId",
			(BiConsumer<ImportHistoric, Long>)
				ImportHistoric::setImportHistoricId);
		attributeGetterFunctions.put("groupId", ImportHistoric::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<ImportHistoric, Long>)ImportHistoric::setGroupId);
		attributeGetterFunctions.put("companyId", ImportHistoric::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<ImportHistoric, Long>)ImportHistoric::setCompanyId);
		attributeGetterFunctions.put("userId", ImportHistoric::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<ImportHistoric, Long>)ImportHistoric::setUserId);
		attributeGetterFunctions.put("userName", ImportHistoric::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<ImportHistoric, String>)ImportHistoric::setUserName);
		attributeGetterFunctions.put(
			"createDate", ImportHistoric::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<ImportHistoric, Date>)ImportHistoric::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", ImportHistoric::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<ImportHistoric, Date>)ImportHistoric::setModifiedDate);
		attributeGetterFunctions.put("status", ImportHistoric::getStatus);
		attributeSetterBiConsumers.put(
			"status",
			(BiConsumer<ImportHistoric, Integer>)ImportHistoric::setStatus);
		attributeGetterFunctions.put(
			"statusByUserId", ImportHistoric::getStatusByUserId);
		attributeSetterBiConsumers.put(
			"statusByUserId",
			(BiConsumer<ImportHistoric, Long>)
				ImportHistoric::setStatusByUserId);
		attributeGetterFunctions.put(
			"statusByUserName", ImportHistoric::getStatusByUserName);
		attributeSetterBiConsumers.put(
			"statusByUserName",
			(BiConsumer<ImportHistoric, String>)
				ImportHistoric::setStatusByUserName);
		attributeGetterFunctions.put(
			"statusDate", ImportHistoric::getStatusDate);
		attributeSetterBiConsumers.put(
			"statusDate",
			(BiConsumer<ImportHistoric, Date>)ImportHistoric::setStatusDate);
		attributeGetterFunctions.put("result", ImportHistoric::getResult);
		attributeSetterBiConsumers.put(
			"result",
			(BiConsumer<ImportHistoric, Integer>)ImportHistoric::setResult);
		attributeGetterFunctions.put(
			"operations", ImportHistoric::getOperations);
		attributeSetterBiConsumers.put(
			"operations",
			(BiConsumer<ImportHistoric, String>)ImportHistoric::setOperations);
		attributeGetterFunctions.put(
			"errorDescription", ImportHistoric::getErrorDescription);
		attributeSetterBiConsumers.put(
			"errorDescription",
			(BiConsumer<ImportHistoric, String>)
				ImportHistoric::setErrorDescription);
		attributeGetterFunctions.put(
			"errorStackTrace", ImportHistoric::getErrorStackTrace);
		attributeSetterBiConsumers.put(
			"errorStackTrace",
			(BiConsumer<ImportHistoric, String>)
				ImportHistoric::setErrorStackTrace);
		attributeGetterFunctions.put("startDate", ImportHistoric::getStartDate);
		attributeSetterBiConsumers.put(
			"startDate",
			(BiConsumer<ImportHistoric, Date>)ImportHistoric::setStartDate);
		attributeGetterFunctions.put(
			"finishDate", ImportHistoric::getFinishDate);
		attributeSetterBiConsumers.put(
			"finishDate",
			(BiConsumer<ImportHistoric, Date>)ImportHistoric::setFinishDate);
		attributeGetterFunctions.put(
			"gtfsFileHash", ImportHistoric::getGtfsFileHash);
		attributeSetterBiConsumers.put(
			"gtfsFileHash",
			(BiConsumer<ImportHistoric, String>)
				ImportHistoric::setGtfsFileHash);

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
	public long getImportHistoricId() {
		return _importHistoricId;
	}

	@Override
	public void setImportHistoricId(long importHistoricId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_importHistoricId = importHistoricId;
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
	public int getResult() {
		return _result;
	}

	@Override
	public void setResult(int result) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

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
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

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
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

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
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_errorStackTrace = errorStackTrace;
	}

	@Override
	public Date getStartDate() {
		return _startDate;
	}

	@Override
	public void setStartDate(Date startDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_startDate = startDate;
	}

	@Override
	public Date getFinishDate() {
		return _finishDate;
	}

	@Override
	public void setFinishDate(Date finishDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_finishDate = finishDate;
	}

	@Override
	public String getGtfsFileHash() {
		if (_gtfsFileHash == null) {
			return "";
		}
		else {
			return _gtfsFileHash;
		}
	}

	@Override
	public void setGtfsFileHash(String gtfsFileHash) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_gtfsFileHash = gtfsFileHash;
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
			Function<InvocationHandler, ImportHistoric>
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
		importHistoricImpl.setGtfsFileHash(getGtfsFileHash());

		importHistoricImpl.resetOriginalValues();

		return importHistoricImpl;
	}

	@Override
	public ImportHistoric cloneWithOriginalValues() {
		ImportHistoricImpl importHistoricImpl = new ImportHistoricImpl();

		importHistoricImpl.setUuid(
			this.<String>getColumnOriginalValue("uuid_"));
		importHistoricImpl.setImportHistoricId(
			this.<Long>getColumnOriginalValue("importHistoricId"));
		importHistoricImpl.setGroupId(
			this.<Long>getColumnOriginalValue("groupId"));
		importHistoricImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		importHistoricImpl.setUserId(
			this.<Long>getColumnOriginalValue("userId"));
		importHistoricImpl.setUserName(
			this.<String>getColumnOriginalValue("userName"));
		importHistoricImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		importHistoricImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		importHistoricImpl.setStatus(
			this.<Integer>getColumnOriginalValue("status"));
		importHistoricImpl.setStatusByUserId(
			this.<Long>getColumnOriginalValue("statusByUserId"));
		importHistoricImpl.setStatusByUserName(
			this.<String>getColumnOriginalValue("statusByUserName"));
		importHistoricImpl.setStatusDate(
			this.<Date>getColumnOriginalValue("statusDate"));
		importHistoricImpl.setResult(
			this.<Integer>getColumnOriginalValue("result"));
		importHistoricImpl.setOperations(
			this.<String>getColumnOriginalValue("operations"));
		importHistoricImpl.setErrorDescription(
			this.<String>getColumnOriginalValue("errorDescription"));
		importHistoricImpl.setErrorStackTrace(
			this.<String>getColumnOriginalValue("errorStackTrace"));
		importHistoricImpl.setStartDate(
			this.<Date>getColumnOriginalValue("startDate"));
		importHistoricImpl.setFinishDate(
			this.<Date>getColumnOriginalValue("finishDate"));
		importHistoricImpl.setGtfsFileHash(
			this.<String>getColumnOriginalValue("gtfsFileHash"));

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
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ImportHistoric)) {
			return false;
		}

		ImportHistoric importHistoric = (ImportHistoric)object;

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

		importHistoricCacheModel.gtfsFileHash = getGtfsFileHash();

		String gtfsFileHash = importHistoricCacheModel.gtfsFileHash;

		if ((gtfsFileHash != null) && (gtfsFileHash.length() == 0)) {
			importHistoricCacheModel.gtfsFileHash = null;
		}

		return importHistoricCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<ImportHistoric, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<ImportHistoric, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ImportHistoric, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((ImportHistoric)this);

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

		private static final Function<InvocationHandler, ImportHistoric>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					ImportHistoric.class, ModelWrapper.class);

	}

	private String _uuid;
	private long _importHistoricId;
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
	private int _result;
	private String _operations;
	private String _errorDescription;
	private String _errorStackTrace;
	private Date _startDate;
	private Date _finishDate;
	private String _gtfsFileHash;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<ImportHistoric, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((ImportHistoric)this);
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
		_columnOriginalValues.put("importHistoricId", _importHistoricId);
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
		_columnOriginalValues.put("result", _result);
		_columnOriginalValues.put("operations", _operations);
		_columnOriginalValues.put("errorDescription", _errorDescription);
		_columnOriginalValues.put("errorStackTrace", _errorStackTrace);
		_columnOriginalValues.put("startDate", _startDate);
		_columnOriginalValues.put("finishDate", _finishDate);
		_columnOriginalValues.put("gtfsFileHash", _gtfsFileHash);
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

		columnBitmasks.put("importHistoricId", 2L);

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

		columnBitmasks.put("result", 4096L);

		columnBitmasks.put("operations", 8192L);

		columnBitmasks.put("errorDescription", 16384L);

		columnBitmasks.put("errorStackTrace", 32768L);

		columnBitmasks.put("startDate", 65536L);

		columnBitmasks.put("finishDate", 131072L);

		columnBitmasks.put("gtfsFileHash", 262144L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private ImportHistoric _escapedModel;

}