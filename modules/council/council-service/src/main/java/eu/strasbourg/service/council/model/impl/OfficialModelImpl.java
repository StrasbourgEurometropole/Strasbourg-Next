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

package eu.strasbourg.service.council.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import eu.strasbourg.service.council.model.Official;
import eu.strasbourg.service.council.model.OfficialModel;
import eu.strasbourg.service.council.model.OfficialSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Official service. Represents a row in the &quot;council_Official&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link OfficialModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link OfficialImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OfficialImpl
 * @see Official
 * @see OfficialModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class OfficialModelImpl extends BaseModelImpl<Official>
	implements OfficialModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a official model instance should use the {@link Official} interface instead.
	 */
	public static final String TABLE_NAME = "council_Official";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "officialId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "status", Types.INTEGER },
			{ "statusByUserId", Types.BIGINT },
			{ "statusByUserName", Types.VARCHAR },
			{ "statusDate", Types.TIMESTAMP },
			{ "email", Types.VARCHAR },
			{ "firstname", Types.VARCHAR },
			{ "lastname", Types.VARCHAR },
			{ "isMunicipal", Types.BOOLEAN },
			{ "isEurometropolitan", Types.BOOLEAN },
			{ "isActive", Types.BOOLEAN }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("officialId", Types.BIGINT);
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
		TABLE_COLUMNS_MAP.put("email", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("firstname", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("lastname", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("isMunicipal", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("isEurometropolitan", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("isActive", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE = "create table council_Official (uuid_ VARCHAR(75) null,officialId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,status INTEGER,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null,email VARCHAR(75) null,firstname VARCHAR(75) null,lastname VARCHAR(75) null,isMunicipal BOOLEAN,isEurometropolitan BOOLEAN,isActive BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table council_Official";
	public static final String ORDER_BY_JPQL = " ORDER BY official.lastname ASC";
	public static final String ORDER_BY_SQL = " ORDER BY council_Official.lastname ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(eu.strasbourg.service.council.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.eu.strasbourg.service.council.model.Official"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(eu.strasbourg.service.council.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.eu.strasbourg.service.council.model.Official"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(eu.strasbourg.service.council.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.eu.strasbourg.service.council.model.Official"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long EMAIL_COLUMN_BITMASK = 2L;
	public static final long GROUPID_COLUMN_BITMASK = 4L;
	public static final long ISACTIVE_COLUMN_BITMASK = 8L;
	public static final long ISEUROMETROPOLITAN_COLUMN_BITMASK = 16L;
	public static final long ISMUNICIPAL_COLUMN_BITMASK = 32L;
	public static final long UUID_COLUMN_BITMASK = 64L;
	public static final long LASTNAME_COLUMN_BITMASK = 128L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Official toModel(OfficialSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Official model = new OfficialImpl();

		model.setUuid(soapModel.getUuid());
		model.setOfficialId(soapModel.getOfficialId());
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
		model.setEmail(soapModel.getEmail());
		model.setFirstname(soapModel.getFirstname());
		model.setLastname(soapModel.getLastname());
		model.setIsMunicipal(soapModel.getIsMunicipal());
		model.setIsEurometropolitan(soapModel.getIsEurometropolitan());
		model.setIsActive(soapModel.getIsActive());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Official> toModels(OfficialSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Official> models = new ArrayList<Official>(soapModels.length);

		for (OfficialSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(eu.strasbourg.service.council.service.util.ServiceProps.get(
				"lock.expiration.time.eu.strasbourg.service.council.model.Official"));

	public OfficialModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _officialId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setOfficialId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _officialId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Official.class;
	}

	@Override
	public String getModelClassName() {
		return Official.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("officialId", getOfficialId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("email", getEmail());
		attributes.put("firstname", getFirstname());
		attributes.put("lastname", getLastname());
		attributes.put("isMunicipal", getIsMunicipal());
		attributes.put("isEurometropolitan", getIsEurometropolitan());
		attributes.put("isActive", getIsActive());

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

		Long officialId = (Long)attributes.get("officialId");

		if (officialId != null) {
			setOfficialId(officialId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String firstname = (String)attributes.get("firstname");

		if (firstname != null) {
			setFirstname(firstname);
		}

		String lastname = (String)attributes.get("lastname");

		if (lastname != null) {
			setLastname(lastname);
		}

		Boolean isMunicipal = (Boolean)attributes.get("isMunicipal");

		if (isMunicipal != null) {
			setIsMunicipal(isMunicipal);
		}

		Boolean isEurometropolitan = (Boolean)attributes.get(
				"isEurometropolitan");

		if (isEurometropolitan != null) {
			setIsEurometropolitan(isEurometropolitan);
		}

		Boolean isActive = (Boolean)attributes.get("isActive");

		if (isActive != null) {
			setIsActive(isActive);
		}
	}

	@JSON
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

	@JSON
	@Override
	public long getOfficialId() {
		return _officialId;
	}

	@Override
	public void setOfficialId(long officialId) {
		_officialId = officialId;
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
			return StringPool.BLANK;
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
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
			return StringPool.BLANK;
		}
	}

	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
	}

	@JSON
	@Override
	public String getStatusByUserName() {
		if (_statusByUserName == null) {
			return StringPool.BLANK;
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
	public String getEmail() {
		if (_email == null) {
			return StringPool.BLANK;
		}
		else {
			return _email;
		}
	}

	@Override
	public void setEmail(String email) {
		_columnBitmask |= EMAIL_COLUMN_BITMASK;

		if (_originalEmail == null) {
			_originalEmail = _email;
		}

		_email = email;
	}

	public String getOriginalEmail() {
		return GetterUtil.getString(_originalEmail);
	}

	@JSON
	@Override
	public String getFirstname() {
		if (_firstname == null) {
			return StringPool.BLANK;
		}
		else {
			return _firstname;
		}
	}

	@Override
	public void setFirstname(String firstname) {
		_firstname = firstname;
	}

	@JSON
	@Override
	public String getLastname() {
		if (_lastname == null) {
			return StringPool.BLANK;
		}
		else {
			return _lastname;
		}
	}

	@Override
	public void setLastname(String lastname) {
		_columnBitmask = -1L;

		_lastname = lastname;
	}

	@JSON
	@Override
	public boolean getIsMunicipal() {
		return _isMunicipal;
	}

	@JSON
	@Override
	public boolean isIsMunicipal() {
		return _isMunicipal;
	}

	@Override
	public void setIsMunicipal(boolean isMunicipal) {
		_columnBitmask |= ISMUNICIPAL_COLUMN_BITMASK;

		if (!_setOriginalIsMunicipal) {
			_setOriginalIsMunicipal = true;

			_originalIsMunicipal = _isMunicipal;
		}

		_isMunicipal = isMunicipal;
	}

	public boolean getOriginalIsMunicipal() {
		return _originalIsMunicipal;
	}

	@JSON
	@Override
	public boolean getIsEurometropolitan() {
		return _isEurometropolitan;
	}

	@JSON
	@Override
	public boolean isIsEurometropolitan() {
		return _isEurometropolitan;
	}

	@Override
	public void setIsEurometropolitan(boolean isEurometropolitan) {
		_columnBitmask |= ISEUROMETROPOLITAN_COLUMN_BITMASK;

		if (!_setOriginalIsEurometropolitan) {
			_setOriginalIsEurometropolitan = true;

			_originalIsEurometropolitan = _isEurometropolitan;
		}

		_isEurometropolitan = isEurometropolitan;
	}

	public boolean getOriginalIsEurometropolitan() {
		return _originalIsEurometropolitan;
	}

	@JSON
	@Override
	public boolean getIsActive() {
		return _isActive;
	}

	@JSON
	@Override
	public boolean isIsActive() {
		return _isActive;
	}

	@Override
	public void setIsActive(boolean isActive) {
		_columnBitmask |= ISACTIVE_COLUMN_BITMASK;

		if (!_setOriginalIsActive) {
			_setOriginalIsActive = true;

			_originalIsActive = _isActive;
		}

		_isActive = isActive;
	}

	public boolean getOriginalIsActive() {
		return _originalIsActive;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				Official.class.getName()));
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
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Official.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Official toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Official)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		OfficialImpl officialImpl = new OfficialImpl();

		officialImpl.setUuid(getUuid());
		officialImpl.setOfficialId(getOfficialId());
		officialImpl.setGroupId(getGroupId());
		officialImpl.setCompanyId(getCompanyId());
		officialImpl.setUserId(getUserId());
		officialImpl.setUserName(getUserName());
		officialImpl.setCreateDate(getCreateDate());
		officialImpl.setModifiedDate(getModifiedDate());
		officialImpl.setStatus(getStatus());
		officialImpl.setStatusByUserId(getStatusByUserId());
		officialImpl.setStatusByUserName(getStatusByUserName());
		officialImpl.setStatusDate(getStatusDate());
		officialImpl.setEmail(getEmail());
		officialImpl.setFirstname(getFirstname());
		officialImpl.setLastname(getLastname());
		officialImpl.setIsMunicipal(getIsMunicipal());
		officialImpl.setIsEurometropolitan(getIsEurometropolitan());
		officialImpl.setIsActive(getIsActive());

		officialImpl.resetOriginalValues();

		return officialImpl;
	}

	@Override
	public int compareTo(Official official) {
		int value = 0;

		value = getLastname().compareTo(official.getLastname());

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

		if (!(obj instanceof Official)) {
			return false;
		}

		Official official = (Official)obj;

		long primaryKey = official.getPrimaryKey();

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
		OfficialModelImpl officialModelImpl = this;

		officialModelImpl._originalUuid = officialModelImpl._uuid;

		officialModelImpl._originalGroupId = officialModelImpl._groupId;

		officialModelImpl._setOriginalGroupId = false;

		officialModelImpl._originalCompanyId = officialModelImpl._companyId;

		officialModelImpl._setOriginalCompanyId = false;

		officialModelImpl._setModifiedDate = false;

		officialModelImpl._originalEmail = officialModelImpl._email;

		officialModelImpl._originalIsMunicipal = officialModelImpl._isMunicipal;

		officialModelImpl._setOriginalIsMunicipal = false;

		officialModelImpl._originalIsEurometropolitan = officialModelImpl._isEurometropolitan;

		officialModelImpl._setOriginalIsEurometropolitan = false;

		officialModelImpl._originalIsActive = officialModelImpl._isActive;

		officialModelImpl._setOriginalIsActive = false;

		officialModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Official> toCacheModel() {
		OfficialCacheModel officialCacheModel = new OfficialCacheModel();

		officialCacheModel.uuid = getUuid();

		String uuid = officialCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			officialCacheModel.uuid = null;
		}

		officialCacheModel.officialId = getOfficialId();

		officialCacheModel.groupId = getGroupId();

		officialCacheModel.companyId = getCompanyId();

		officialCacheModel.userId = getUserId();

		officialCacheModel.userName = getUserName();

		String userName = officialCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			officialCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			officialCacheModel.createDate = createDate.getTime();
		}
		else {
			officialCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			officialCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			officialCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		officialCacheModel.status = getStatus();

		officialCacheModel.statusByUserId = getStatusByUserId();

		officialCacheModel.statusByUserName = getStatusByUserName();

		String statusByUserName = officialCacheModel.statusByUserName;

		if ((statusByUserName != null) && (statusByUserName.length() == 0)) {
			officialCacheModel.statusByUserName = null;
		}

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			officialCacheModel.statusDate = statusDate.getTime();
		}
		else {
			officialCacheModel.statusDate = Long.MIN_VALUE;
		}

		officialCacheModel.email = getEmail();

		String email = officialCacheModel.email;

		if ((email != null) && (email.length() == 0)) {
			officialCacheModel.email = null;
		}

		officialCacheModel.firstname = getFirstname();

		String firstname = officialCacheModel.firstname;

		if ((firstname != null) && (firstname.length() == 0)) {
			officialCacheModel.firstname = null;
		}

		officialCacheModel.lastname = getLastname();

		String lastname = officialCacheModel.lastname;

		if ((lastname != null) && (lastname.length() == 0)) {
			officialCacheModel.lastname = null;
		}

		officialCacheModel.isMunicipal = getIsMunicipal();

		officialCacheModel.isEurometropolitan = getIsEurometropolitan();

		officialCacheModel.isActive = getIsActive();

		return officialCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", officialId=");
		sb.append(getOfficialId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", statusByUserId=");
		sb.append(getStatusByUserId());
		sb.append(", statusByUserName=");
		sb.append(getStatusByUserName());
		sb.append(", statusDate=");
		sb.append(getStatusDate());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", firstname=");
		sb.append(getFirstname());
		sb.append(", lastname=");
		sb.append(getLastname());
		sb.append(", isMunicipal=");
		sb.append(getIsMunicipal());
		sb.append(", isEurometropolitan=");
		sb.append(getIsEurometropolitan());
		sb.append(", isActive=");
		sb.append(getIsActive());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(58);

		sb.append("<model><model-name>");
		sb.append("eu.strasbourg.service.council.model.Official");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>officialId</column-name><column-value><![CDATA[");
		sb.append(getOfficialId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserId</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserName</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusDate</column-name><column-value><![CDATA[");
		sb.append(getStatusDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firstname</column-name><column-value><![CDATA[");
		sb.append(getFirstname());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastname</column-name><column-value><![CDATA[");
		sb.append(getLastname());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isMunicipal</column-name><column-value><![CDATA[");
		sb.append(getIsMunicipal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isEurometropolitan</column-name><column-value><![CDATA[");
		sb.append(getIsEurometropolitan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isActive</column-name><column-value><![CDATA[");
		sb.append(getIsActive());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = Official.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			Official.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _officialId;
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
	private String _email;
	private String _originalEmail;
	private String _firstname;
	private String _lastname;
	private boolean _isMunicipal;
	private boolean _originalIsMunicipal;
	private boolean _setOriginalIsMunicipal;
	private boolean _isEurometropolitan;
	private boolean _originalIsEurometropolitan;
	private boolean _setOriginalIsEurometropolitan;
	private boolean _isActive;
	private boolean _originalIsActive;
	private boolean _setOriginalIsActive;
	private long _columnBitmask;
	private Official _escapedModel;
}