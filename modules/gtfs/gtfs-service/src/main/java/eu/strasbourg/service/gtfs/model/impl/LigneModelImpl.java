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

import eu.strasbourg.service.gtfs.model.Ligne;
import eu.strasbourg.service.gtfs.model.LigneModel;
import eu.strasbourg.service.gtfs.model.LigneSoap;

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
 * The base model implementation for the Ligne service. Represents a row in the &quot;gtfs_Ligne&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>LigneModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LigneImpl}.
 * </p>
 *
 * @author Cedric Henry
 * @see LigneImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class LigneModelImpl extends BaseModelImpl<Ligne> implements LigneModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a ligne model instance should use the <code>Ligne</code> interface instead.
	 */
	public static final String TABLE_NAME = "gtfs_Ligne";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"ligneId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"status", Types.INTEGER}, {"statusByUserId", Types.BIGINT},
		{"statusByUserName", Types.VARCHAR}, {"statusDate", Types.TIMESTAMP},
		{"routeId", Types.VARCHAR}, {"shortName", Types.VARCHAR},
		{"title", Types.VARCHAR}, {"type_", Types.INTEGER},
		{"backgroundColor", Types.VARCHAR}, {"textColor", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("ligneId", Types.BIGINT);
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
		TABLE_COLUMNS_MAP.put("routeId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("shortName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("title", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("type_", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("backgroundColor", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("textColor", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table gtfs_Ligne (uuid_ VARCHAR(75) null,ligneId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,status INTEGER,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null,routeId VARCHAR(75) null,shortName VARCHAR(75) null,title VARCHAR(75) null,type_ INTEGER,backgroundColor VARCHAR(75) null,textColor VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table gtfs_Ligne";

	public static final String ORDER_BY_JPQL = " ORDER BY ligne.ligneId DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY gtfs_Ligne.ligneId DESC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.gtfs.service.util.PropsUtil.get(
			"value.object.entity.cache.enabled.eu.strasbourg.service.gtfs.model.Ligne"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.gtfs.service.util.PropsUtil.get(
			"value.object.finder.cache.enabled.eu.strasbourg.service.gtfs.model.Ligne"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.gtfs.service.util.PropsUtil.get(
			"value.object.column.bitmask.enabled.eu.strasbourg.service.gtfs.model.Ligne"),
		true);

	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	public static final long GROUPID_COLUMN_BITMASK = 2L;

	public static final long ROUTEID_COLUMN_BITMASK = 4L;

	public static final long SHORTNAME_COLUMN_BITMASK = 8L;

	public static final long STATUS_COLUMN_BITMASK = 16L;

	public static final long UUID_COLUMN_BITMASK = 32L;

	public static final long LIGNEID_COLUMN_BITMASK = 64L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Ligne toModel(LigneSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Ligne model = new LigneImpl();

		model.setUuid(soapModel.getUuid());
		model.setLigneId(soapModel.getLigneId());
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
		model.setRouteId(soapModel.getRouteId());
		model.setShortName(soapModel.getShortName());
		model.setTitle(soapModel.getTitle());
		model.setType(soapModel.getType());
		model.setBackgroundColor(soapModel.getBackgroundColor());
		model.setTextColor(soapModel.getTextColor());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Ligne> toModels(LigneSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Ligne> models = new ArrayList<Ligne>(soapModels.length);

		for (LigneSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		eu.strasbourg.service.gtfs.service.util.PropsUtil.get(
			"lock.expiration.time.eu.strasbourg.service.gtfs.model.Ligne"));

	public LigneModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _ligneId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLigneId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ligneId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Ligne.class;
	}

	@Override
	public String getModelClassName() {
		return Ligne.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Ligne, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Ligne, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Ligne, Object> attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Ligne)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Ligne, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Ligne, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept((Ligne)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Ligne, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Ligne, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Ligne>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Ligne.class.getClassLoader(), Ligne.class, ModelWrapper.class);

		try {
			Constructor<Ligne> constructor =
				(Constructor<Ligne>)proxyClass.getConstructor(
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

	private static final Map<String, Function<Ligne, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Ligne, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Ligne, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Ligne, Object>>();
		Map<String, BiConsumer<Ligne, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Ligne, ?>>();

		attributeGetterFunctions.put(
			"uuid",
			new Function<Ligne, Object>() {

				@Override
				public Object apply(Ligne ligne) {
					return ligne.getUuid();
				}

			});
		attributeSetterBiConsumers.put(
			"uuid",
			new BiConsumer<Ligne, Object>() {

				@Override
				public void accept(Ligne ligne, Object uuid) {
					ligne.setUuid((String)uuid);
				}

			});
		attributeGetterFunctions.put(
			"ligneId",
			new Function<Ligne, Object>() {

				@Override
				public Object apply(Ligne ligne) {
					return ligne.getLigneId();
				}

			});
		attributeSetterBiConsumers.put(
			"ligneId",
			new BiConsumer<Ligne, Object>() {

				@Override
				public void accept(Ligne ligne, Object ligneId) {
					ligne.setLigneId((Long)ligneId);
				}

			});
		attributeGetterFunctions.put(
			"groupId",
			new Function<Ligne, Object>() {

				@Override
				public Object apply(Ligne ligne) {
					return ligne.getGroupId();
				}

			});
		attributeSetterBiConsumers.put(
			"groupId",
			new BiConsumer<Ligne, Object>() {

				@Override
				public void accept(Ligne ligne, Object groupId) {
					ligne.setGroupId((Long)groupId);
				}

			});
		attributeGetterFunctions.put(
			"companyId",
			new Function<Ligne, Object>() {

				@Override
				public Object apply(Ligne ligne) {
					return ligne.getCompanyId();
				}

			});
		attributeSetterBiConsumers.put(
			"companyId",
			new BiConsumer<Ligne, Object>() {

				@Override
				public void accept(Ligne ligne, Object companyId) {
					ligne.setCompanyId((Long)companyId);
				}

			});
		attributeGetterFunctions.put(
			"userId",
			new Function<Ligne, Object>() {

				@Override
				public Object apply(Ligne ligne) {
					return ligne.getUserId();
				}

			});
		attributeSetterBiConsumers.put(
			"userId",
			new BiConsumer<Ligne, Object>() {

				@Override
				public void accept(Ligne ligne, Object userId) {
					ligne.setUserId((Long)userId);
				}

			});
		attributeGetterFunctions.put(
			"userName",
			new Function<Ligne, Object>() {

				@Override
				public Object apply(Ligne ligne) {
					return ligne.getUserName();
				}

			});
		attributeSetterBiConsumers.put(
			"userName",
			new BiConsumer<Ligne, Object>() {

				@Override
				public void accept(Ligne ligne, Object userName) {
					ligne.setUserName((String)userName);
				}

			});
		attributeGetterFunctions.put(
			"createDate",
			new Function<Ligne, Object>() {

				@Override
				public Object apply(Ligne ligne) {
					return ligne.getCreateDate();
				}

			});
		attributeSetterBiConsumers.put(
			"createDate",
			new BiConsumer<Ligne, Object>() {

				@Override
				public void accept(Ligne ligne, Object createDate) {
					ligne.setCreateDate((Date)createDate);
				}

			});
		attributeGetterFunctions.put(
			"modifiedDate",
			new Function<Ligne, Object>() {

				@Override
				public Object apply(Ligne ligne) {
					return ligne.getModifiedDate();
				}

			});
		attributeSetterBiConsumers.put(
			"modifiedDate",
			new BiConsumer<Ligne, Object>() {

				@Override
				public void accept(Ligne ligne, Object modifiedDate) {
					ligne.setModifiedDate((Date)modifiedDate);
				}

			});
		attributeGetterFunctions.put(
			"status",
			new Function<Ligne, Object>() {

				@Override
				public Object apply(Ligne ligne) {
					return ligne.getStatus();
				}

			});
		attributeSetterBiConsumers.put(
			"status",
			new BiConsumer<Ligne, Object>() {

				@Override
				public void accept(Ligne ligne, Object status) {
					ligne.setStatus((Integer)status);
				}

			});
		attributeGetterFunctions.put(
			"statusByUserId",
			new Function<Ligne, Object>() {

				@Override
				public Object apply(Ligne ligne) {
					return ligne.getStatusByUserId();
				}

			});
		attributeSetterBiConsumers.put(
			"statusByUserId",
			new BiConsumer<Ligne, Object>() {

				@Override
				public void accept(Ligne ligne, Object statusByUserId) {
					ligne.setStatusByUserId((Long)statusByUserId);
				}

			});
		attributeGetterFunctions.put(
			"statusByUserName",
			new Function<Ligne, Object>() {

				@Override
				public Object apply(Ligne ligne) {
					return ligne.getStatusByUserName();
				}

			});
		attributeSetterBiConsumers.put(
			"statusByUserName",
			new BiConsumer<Ligne, Object>() {

				@Override
				public void accept(Ligne ligne, Object statusByUserName) {
					ligne.setStatusByUserName((String)statusByUserName);
				}

			});
		attributeGetterFunctions.put(
			"statusDate",
			new Function<Ligne, Object>() {

				@Override
				public Object apply(Ligne ligne) {
					return ligne.getStatusDate();
				}

			});
		attributeSetterBiConsumers.put(
			"statusDate",
			new BiConsumer<Ligne, Object>() {

				@Override
				public void accept(Ligne ligne, Object statusDate) {
					ligne.setStatusDate((Date)statusDate);
				}

			});
		attributeGetterFunctions.put(
			"routeId",
			new Function<Ligne, Object>() {

				@Override
				public Object apply(Ligne ligne) {
					return ligne.getRouteId();
				}

			});
		attributeSetterBiConsumers.put(
			"routeId",
			new BiConsumer<Ligne, Object>() {

				@Override
				public void accept(Ligne ligne, Object routeId) {
					ligne.setRouteId((String)routeId);
				}

			});
		attributeGetterFunctions.put(
			"shortName",
			new Function<Ligne, Object>() {

				@Override
				public Object apply(Ligne ligne) {
					return ligne.getShortName();
				}

			});
		attributeSetterBiConsumers.put(
			"shortName",
			new BiConsumer<Ligne, Object>() {

				@Override
				public void accept(Ligne ligne, Object shortName) {
					ligne.setShortName((String)shortName);
				}

			});
		attributeGetterFunctions.put(
			"title",
			new Function<Ligne, Object>() {

				@Override
				public Object apply(Ligne ligne) {
					return ligne.getTitle();
				}

			});
		attributeSetterBiConsumers.put(
			"title",
			new BiConsumer<Ligne, Object>() {

				@Override
				public void accept(Ligne ligne, Object title) {
					ligne.setTitle((String)title);
				}

			});
		attributeGetterFunctions.put(
			"type",
			new Function<Ligne, Object>() {

				@Override
				public Object apply(Ligne ligne) {
					return ligne.getType();
				}

			});
		attributeSetterBiConsumers.put(
			"type",
			new BiConsumer<Ligne, Object>() {

				@Override
				public void accept(Ligne ligne, Object type) {
					ligne.setType((Integer)type);
				}

			});
		attributeGetterFunctions.put(
			"backgroundColor",
			new Function<Ligne, Object>() {

				@Override
				public Object apply(Ligne ligne) {
					return ligne.getBackgroundColor();
				}

			});
		attributeSetterBiConsumers.put(
			"backgroundColor",
			new BiConsumer<Ligne, Object>() {

				@Override
				public void accept(Ligne ligne, Object backgroundColor) {
					ligne.setBackgroundColor((String)backgroundColor);
				}

			});
		attributeGetterFunctions.put(
			"textColor",
			new Function<Ligne, Object>() {

				@Override
				public Object apply(Ligne ligne) {
					return ligne.getTextColor();
				}

			});
		attributeSetterBiConsumers.put(
			"textColor",
			new BiConsumer<Ligne, Object>() {

				@Override
				public void accept(Ligne ligne, Object textColor) {
					ligne.setTextColor((String)textColor);
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
	public long getLigneId() {
		return _ligneId;
	}

	@Override
	public void setLigneId(long ligneId) {
		_columnBitmask = -1L;

		_ligneId = ligneId;
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
		_columnBitmask |= STATUS_COLUMN_BITMASK;

		if (!_setOriginalStatus) {
			_setOriginalStatus = true;

			_originalStatus = _status;
		}

		_status = status;
	}

	public int getOriginalStatus() {
		return _originalStatus;
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
	public String getRouteId() {
		if (_routeId == null) {
			return "";
		}
		else {
			return _routeId;
		}
	}

	@Override
	public void setRouteId(String routeId) {
		_columnBitmask |= ROUTEID_COLUMN_BITMASK;

		if (_originalRouteId == null) {
			_originalRouteId = _routeId;
		}

		_routeId = routeId;
	}

	public String getOriginalRouteId() {
		return GetterUtil.getString(_originalRouteId);
	}

	@JSON
	@Override
	public String getShortName() {
		if (_shortName == null) {
			return "";
		}
		else {
			return _shortName;
		}
	}

	@Override
	public void setShortName(String shortName) {
		_columnBitmask |= SHORTNAME_COLUMN_BITMASK;

		if (_originalShortName == null) {
			_originalShortName = _shortName;
		}

		_shortName = shortName;
	}

	public String getOriginalShortName() {
		return GetterUtil.getString(_originalShortName);
	}

	@JSON
	@Override
	public String getTitle() {
		if (_title == null) {
			return "";
		}
		else {
			return _title;
		}
	}

	@Override
	public void setTitle(String title) {
		_title = title;
	}

	@JSON
	@Override
	public int getType() {
		return _type;
	}

	@Override
	public void setType(int type) {
		_type = type;
	}

	@JSON
	@Override
	public String getBackgroundColor() {
		if (_backgroundColor == null) {
			return "";
		}
		else {
			return _backgroundColor;
		}
	}

	@Override
	public void setBackgroundColor(String backgroundColor) {
		_backgroundColor = backgroundColor;
	}

	@JSON
	@Override
	public String getTextColor() {
		if (_textColor == null) {
			return "";
		}
		else {
			return _textColor;
		}
	}

	@Override
	public void setTextColor(String textColor) {
		_textColor = textColor;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(Ligne.class.getName()));
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
			getCompanyId(), Ligne.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Ligne toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = _escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		LigneImpl ligneImpl = new LigneImpl();

		ligneImpl.setUuid(getUuid());
		ligneImpl.setLigneId(getLigneId());
		ligneImpl.setGroupId(getGroupId());
		ligneImpl.setCompanyId(getCompanyId());
		ligneImpl.setUserId(getUserId());
		ligneImpl.setUserName(getUserName());
		ligneImpl.setCreateDate(getCreateDate());
		ligneImpl.setModifiedDate(getModifiedDate());
		ligneImpl.setStatus(getStatus());
		ligneImpl.setStatusByUserId(getStatusByUserId());
		ligneImpl.setStatusByUserName(getStatusByUserName());
		ligneImpl.setStatusDate(getStatusDate());
		ligneImpl.setRouteId(getRouteId());
		ligneImpl.setShortName(getShortName());
		ligneImpl.setTitle(getTitle());
		ligneImpl.setType(getType());
		ligneImpl.setBackgroundColor(getBackgroundColor());
		ligneImpl.setTextColor(getTextColor());

		ligneImpl.resetOriginalValues();

		return ligneImpl;
	}

	@Override
	public int compareTo(Ligne ligne) {
		int value = 0;

		if (getLigneId() < ligne.getLigneId()) {
			value = -1;
		}
		else if (getLigneId() > ligne.getLigneId()) {
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

		if (!(obj instanceof Ligne)) {
			return false;
		}

		Ligne ligne = (Ligne)obj;

		long primaryKey = ligne.getPrimaryKey();

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
		LigneModelImpl ligneModelImpl = this;

		ligneModelImpl._originalUuid = ligneModelImpl._uuid;

		ligneModelImpl._originalGroupId = ligneModelImpl._groupId;

		ligneModelImpl._setOriginalGroupId = false;

		ligneModelImpl._originalCompanyId = ligneModelImpl._companyId;

		ligneModelImpl._setOriginalCompanyId = false;

		ligneModelImpl._setModifiedDate = false;

		ligneModelImpl._originalStatus = ligneModelImpl._status;

		ligneModelImpl._setOriginalStatus = false;

		ligneModelImpl._originalRouteId = ligneModelImpl._routeId;

		ligneModelImpl._originalShortName = ligneModelImpl._shortName;

		ligneModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Ligne> toCacheModel() {
		LigneCacheModel ligneCacheModel = new LigneCacheModel();

		ligneCacheModel.uuid = getUuid();

		String uuid = ligneCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			ligneCacheModel.uuid = null;
		}

		ligneCacheModel.ligneId = getLigneId();

		ligneCacheModel.groupId = getGroupId();

		ligneCacheModel.companyId = getCompanyId();

		ligneCacheModel.userId = getUserId();

		ligneCacheModel.userName = getUserName();

		String userName = ligneCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			ligneCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			ligneCacheModel.createDate = createDate.getTime();
		}
		else {
			ligneCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			ligneCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			ligneCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		ligneCacheModel.status = getStatus();

		ligneCacheModel.statusByUserId = getStatusByUserId();

		ligneCacheModel.statusByUserName = getStatusByUserName();

		String statusByUserName = ligneCacheModel.statusByUserName;

		if ((statusByUserName != null) && (statusByUserName.length() == 0)) {
			ligneCacheModel.statusByUserName = null;
		}

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			ligneCacheModel.statusDate = statusDate.getTime();
		}
		else {
			ligneCacheModel.statusDate = Long.MIN_VALUE;
		}

		ligneCacheModel.routeId = getRouteId();

		String routeId = ligneCacheModel.routeId;

		if ((routeId != null) && (routeId.length() == 0)) {
			ligneCacheModel.routeId = null;
		}

		ligneCacheModel.shortName = getShortName();

		String shortName = ligneCacheModel.shortName;

		if ((shortName != null) && (shortName.length() == 0)) {
			ligneCacheModel.shortName = null;
		}

		ligneCacheModel.title = getTitle();

		String title = ligneCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			ligneCacheModel.title = null;
		}

		ligneCacheModel.type = getType();

		ligneCacheModel.backgroundColor = getBackgroundColor();

		String backgroundColor = ligneCacheModel.backgroundColor;

		if ((backgroundColor != null) && (backgroundColor.length() == 0)) {
			ligneCacheModel.backgroundColor = null;
		}

		ligneCacheModel.textColor = getTextColor();

		String textColor = ligneCacheModel.textColor;

		if ((textColor != null) && (textColor.length() == 0)) {
			ligneCacheModel.textColor = null;
		}

		return ligneCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Ligne, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Ligne, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Ligne, Object> attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Ligne)this));
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
		Map<String, Function<Ligne, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Ligne, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Ligne, Object> attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Ligne)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final Function<InvocationHandler, Ligne>
		_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	private String _uuid;
	private String _originalUuid;
	private long _ligneId;
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
	private int _originalStatus;
	private boolean _setOriginalStatus;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private String _routeId;
	private String _originalRouteId;
	private String _shortName;
	private String _originalShortName;
	private String _title;
	private int _type;
	private String _backgroundColor;
	private String _textColor;
	private long _columnBitmask;
	private Ligne _escapedModel;

}