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

package eu.strasbourg.service.project.model.impl;

import aQute.bnd.annotation.ProviderType;

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

import eu.strasbourg.service.project.model.InitiativeHelp;
import eu.strasbourg.service.project.model.InitiativeHelpModel;
import eu.strasbourg.service.project.model.InitiativeHelpSoap;

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
 * The base model implementation for the InitiativeHelp service. Represents a row in the &quot;project_InitiativeHelp&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>InitiativeHelpModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link InitiativeHelpImpl}.
 * </p>
 *
 * @author Cedric Henry
 * @see InitiativeHelpImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class InitiativeHelpModelImpl
	extends BaseModelImpl<InitiativeHelp> implements InitiativeHelpModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a initiative help model instance should use the <code>InitiativeHelp</code> interface instead.
	 */
	public static final String TABLE_NAME = "project_InitiativeHelp";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"initiativeHelpId", Types.BIGINT},
		{"createDate", Types.TIMESTAMP}, {"publikUserId", Types.VARCHAR},
		{"initiativeId", Types.BIGINT}, {"helpTypes", Types.VARCHAR},
		{"groupId", Types.BIGINT}, {"message", Types.VARCHAR},
		{"helpDisplay", Types.BOOLEAN}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("initiativeHelpId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("publikUserId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("initiativeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("helpTypes", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("message", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("helpDisplay", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE =
		"create table project_InitiativeHelp (uuid_ VARCHAR(75) null,initiativeHelpId LONG not null primary key,createDate DATE null,publikUserId VARCHAR(75) null,initiativeId LONG,helpTypes VARCHAR(75) null,groupId LONG,message VARCHAR(400) null,helpDisplay BOOLEAN)";

	public static final String TABLE_SQL_DROP =
		"drop table project_InitiativeHelp";

	public static final String ORDER_BY_JPQL =
		" ORDER BY initiativeHelp.initiativeHelpId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY project_InitiativeHelp.initiativeHelpId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.project.service.util.PropsUtil.get(
			"value.object.entity.cache.enabled.eu.strasbourg.service.project.model.InitiativeHelp"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.project.service.util.PropsUtil.get(
			"value.object.finder.cache.enabled.eu.strasbourg.service.project.model.InitiativeHelp"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.project.service.util.PropsUtil.get(
			"value.object.column.bitmask.enabled.eu.strasbourg.service.project.model.InitiativeHelp"),
		true);

	public static final long GROUPID_COLUMN_BITMASK = 1L;

	public static final long INITIATIVEID_COLUMN_BITMASK = 2L;

	public static final long PUBLIKUSERID_COLUMN_BITMASK = 4L;

	public static final long UUID_COLUMN_BITMASK = 8L;

	public static final long INITIATIVEHELPID_COLUMN_BITMASK = 16L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static InitiativeHelp toModel(InitiativeHelpSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		InitiativeHelp model = new InitiativeHelpImpl();

		model.setUuid(soapModel.getUuid());
		model.setInitiativeHelpId(soapModel.getInitiativeHelpId());
		model.setCreateDate(soapModel.getCreateDate());
		model.setPublikUserId(soapModel.getPublikUserId());
		model.setInitiativeId(soapModel.getInitiativeId());
		model.setHelpTypes(soapModel.getHelpTypes());
		model.setGroupId(soapModel.getGroupId());
		model.setMessage(soapModel.getMessage());
		model.setHelpDisplay(soapModel.isHelpDisplay());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<InitiativeHelp> toModels(
		InitiativeHelpSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<InitiativeHelp> models = new ArrayList<InitiativeHelp>(
			soapModels.length);

		for (InitiativeHelpSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		eu.strasbourg.service.project.service.util.PropsUtil.get(
			"lock.expiration.time.eu.strasbourg.service.project.model.InitiativeHelp"));

	public InitiativeHelpModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _initiativeHelpId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setInitiativeHelpId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _initiativeHelpId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return InitiativeHelp.class;
	}

	@Override
	public String getModelClassName() {
		return InitiativeHelp.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<InitiativeHelp, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<InitiativeHelp, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<InitiativeHelp, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((InitiativeHelp)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<InitiativeHelp, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<InitiativeHelp, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(InitiativeHelp)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<InitiativeHelp, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<InitiativeHelp, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, InitiativeHelp>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			InitiativeHelp.class.getClassLoader(), InitiativeHelp.class,
			ModelWrapper.class);

		try {
			Constructor<InitiativeHelp> constructor =
				(Constructor<InitiativeHelp>)proxyClass.getConstructor(
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

	private static final Map<String, Function<InitiativeHelp, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<InitiativeHelp, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<InitiativeHelp, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<InitiativeHelp, Object>>();
		Map<String, BiConsumer<InitiativeHelp, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<InitiativeHelp, ?>>();

		attributeGetterFunctions.put(
			"uuid",
			new Function<InitiativeHelp, Object>() {

				@Override
				public Object apply(InitiativeHelp initiativeHelp) {
					return initiativeHelp.getUuid();
				}

			});
		attributeSetterBiConsumers.put(
			"uuid",
			new BiConsumer<InitiativeHelp, Object>() {

				@Override
				public void accept(InitiativeHelp initiativeHelp, Object uuid) {
					initiativeHelp.setUuid((String)uuid);
				}

			});
		attributeGetterFunctions.put(
			"initiativeHelpId",
			new Function<InitiativeHelp, Object>() {

				@Override
				public Object apply(InitiativeHelp initiativeHelp) {
					return initiativeHelp.getInitiativeHelpId();
				}

			});
		attributeSetterBiConsumers.put(
			"initiativeHelpId",
			new BiConsumer<InitiativeHelp, Object>() {

				@Override
				public void accept(
					InitiativeHelp initiativeHelp, Object initiativeHelpId) {

					initiativeHelp.setInitiativeHelpId((Long)initiativeHelpId);
				}

			});
		attributeGetterFunctions.put(
			"createDate",
			new Function<InitiativeHelp, Object>() {

				@Override
				public Object apply(InitiativeHelp initiativeHelp) {
					return initiativeHelp.getCreateDate();
				}

			});
		attributeSetterBiConsumers.put(
			"createDate",
			new BiConsumer<InitiativeHelp, Object>() {

				@Override
				public void accept(
					InitiativeHelp initiativeHelp, Object createDate) {

					initiativeHelp.setCreateDate((Date)createDate);
				}

			});
		attributeGetterFunctions.put(
			"publikUserId",
			new Function<InitiativeHelp, Object>() {

				@Override
				public Object apply(InitiativeHelp initiativeHelp) {
					return initiativeHelp.getPublikUserId();
				}

			});
		attributeSetterBiConsumers.put(
			"publikUserId",
			new BiConsumer<InitiativeHelp, Object>() {

				@Override
				public void accept(
					InitiativeHelp initiativeHelp, Object publikUserId) {

					initiativeHelp.setPublikUserId((String)publikUserId);
				}

			});
		attributeGetterFunctions.put(
			"initiativeId",
			new Function<InitiativeHelp, Object>() {

				@Override
				public Object apply(InitiativeHelp initiativeHelp) {
					return initiativeHelp.getInitiativeId();
				}

			});
		attributeSetterBiConsumers.put(
			"initiativeId",
			new BiConsumer<InitiativeHelp, Object>() {

				@Override
				public void accept(
					InitiativeHelp initiativeHelp, Object initiativeId) {

					initiativeHelp.setInitiativeId((Long)initiativeId);
				}

			});
		attributeGetterFunctions.put(
			"helpTypes",
			new Function<InitiativeHelp, Object>() {

				@Override
				public Object apply(InitiativeHelp initiativeHelp) {
					return initiativeHelp.getHelpTypes();
				}

			});
		attributeSetterBiConsumers.put(
			"helpTypes",
			new BiConsumer<InitiativeHelp, Object>() {

				@Override
				public void accept(
					InitiativeHelp initiativeHelp, Object helpTypes) {

					initiativeHelp.setHelpTypes((String)helpTypes);
				}

			});
		attributeGetterFunctions.put(
			"groupId",
			new Function<InitiativeHelp, Object>() {

				@Override
				public Object apply(InitiativeHelp initiativeHelp) {
					return initiativeHelp.getGroupId();
				}

			});
		attributeSetterBiConsumers.put(
			"groupId",
			new BiConsumer<InitiativeHelp, Object>() {

				@Override
				public void accept(
					InitiativeHelp initiativeHelp, Object groupId) {

					initiativeHelp.setGroupId((Long)groupId);
				}

			});
		attributeGetterFunctions.put(
			"message",
			new Function<InitiativeHelp, Object>() {

				@Override
				public Object apply(InitiativeHelp initiativeHelp) {
					return initiativeHelp.getMessage();
				}

			});
		attributeSetterBiConsumers.put(
			"message",
			new BiConsumer<InitiativeHelp, Object>() {

				@Override
				public void accept(
					InitiativeHelp initiativeHelp, Object message) {

					initiativeHelp.setMessage((String)message);
				}

			});
		attributeGetterFunctions.put(
			"helpDisplay",
			new Function<InitiativeHelp, Object>() {

				@Override
				public Object apply(InitiativeHelp initiativeHelp) {
					return initiativeHelp.getHelpDisplay();
				}

			});
		attributeSetterBiConsumers.put(
			"helpDisplay",
			new BiConsumer<InitiativeHelp, Object>() {

				@Override
				public void accept(
					InitiativeHelp initiativeHelp, Object helpDisplay) {

					initiativeHelp.setHelpDisplay((Boolean)helpDisplay);
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
	public long getInitiativeHelpId() {
		return _initiativeHelpId;
	}

	@Override
	public void setInitiativeHelpId(long initiativeHelpId) {
		_initiativeHelpId = initiativeHelpId;
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
	public long getInitiativeId() {
		return _initiativeId;
	}

	@Override
	public void setInitiativeId(long initiativeId) {
		_columnBitmask |= INITIATIVEID_COLUMN_BITMASK;

		if (!_setOriginalInitiativeId) {
			_setOriginalInitiativeId = true;

			_originalInitiativeId = _initiativeId;
		}

		_initiativeId = initiativeId;
	}

	public long getOriginalInitiativeId() {
		return _originalInitiativeId;
	}

	@JSON
	@Override
	public String getHelpTypes() {
		if (_helpTypes == null) {
			return "";
		}
		else {
			return _helpTypes;
		}
	}

	@Override
	public void setHelpTypes(String helpTypes) {
		_helpTypes = helpTypes;
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
	public String getMessage() {
		if (_message == null) {
			return "";
		}
		else {
			return _message;
		}
	}

	@Override
	public void setMessage(String message) {
		_message = message;
	}

	@JSON
	@Override
	public boolean getHelpDisplay() {
		return _helpDisplay;
	}

	@JSON
	@Override
	public boolean isHelpDisplay() {
		return _helpDisplay;
	}

	@Override
	public void setHelpDisplay(boolean helpDisplay) {
		_helpDisplay = helpDisplay;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, InitiativeHelp.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public InitiativeHelp toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = _escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		InitiativeHelpImpl initiativeHelpImpl = new InitiativeHelpImpl();

		initiativeHelpImpl.setUuid(getUuid());
		initiativeHelpImpl.setInitiativeHelpId(getInitiativeHelpId());
		initiativeHelpImpl.setCreateDate(getCreateDate());
		initiativeHelpImpl.setPublikUserId(getPublikUserId());
		initiativeHelpImpl.setInitiativeId(getInitiativeId());
		initiativeHelpImpl.setHelpTypes(getHelpTypes());
		initiativeHelpImpl.setGroupId(getGroupId());
		initiativeHelpImpl.setMessage(getMessage());
		initiativeHelpImpl.setHelpDisplay(isHelpDisplay());

		initiativeHelpImpl.resetOriginalValues();

		return initiativeHelpImpl;
	}

	@Override
	public int compareTo(InitiativeHelp initiativeHelp) {
		long primaryKey = initiativeHelp.getPrimaryKey();

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

		if (!(obj instanceof InitiativeHelp)) {
			return false;
		}

		InitiativeHelp initiativeHelp = (InitiativeHelp)obj;

		long primaryKey = initiativeHelp.getPrimaryKey();

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
		InitiativeHelpModelImpl initiativeHelpModelImpl = this;

		initiativeHelpModelImpl._originalUuid = initiativeHelpModelImpl._uuid;

		initiativeHelpModelImpl._originalPublikUserId =
			initiativeHelpModelImpl._publikUserId;

		initiativeHelpModelImpl._originalInitiativeId =
			initiativeHelpModelImpl._initiativeId;

		initiativeHelpModelImpl._setOriginalInitiativeId = false;

		initiativeHelpModelImpl._originalGroupId =
			initiativeHelpModelImpl._groupId;

		initiativeHelpModelImpl._setOriginalGroupId = false;

		initiativeHelpModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<InitiativeHelp> toCacheModel() {
		InitiativeHelpCacheModel initiativeHelpCacheModel =
			new InitiativeHelpCacheModel();

		initiativeHelpCacheModel.uuid = getUuid();

		String uuid = initiativeHelpCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			initiativeHelpCacheModel.uuid = null;
		}

		initiativeHelpCacheModel.initiativeHelpId = getInitiativeHelpId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			initiativeHelpCacheModel.createDate = createDate.getTime();
		}
		else {
			initiativeHelpCacheModel.createDate = Long.MIN_VALUE;
		}

		initiativeHelpCacheModel.publikUserId = getPublikUserId();

		String publikUserId = initiativeHelpCacheModel.publikUserId;

		if ((publikUserId != null) && (publikUserId.length() == 0)) {
			initiativeHelpCacheModel.publikUserId = null;
		}

		initiativeHelpCacheModel.initiativeId = getInitiativeId();

		initiativeHelpCacheModel.helpTypes = getHelpTypes();

		String helpTypes = initiativeHelpCacheModel.helpTypes;

		if ((helpTypes != null) && (helpTypes.length() == 0)) {
			initiativeHelpCacheModel.helpTypes = null;
		}

		initiativeHelpCacheModel.groupId = getGroupId();

		initiativeHelpCacheModel.message = getMessage();

		String message = initiativeHelpCacheModel.message;

		if ((message != null) && (message.length() == 0)) {
			initiativeHelpCacheModel.message = null;
		}

		initiativeHelpCacheModel.helpDisplay = isHelpDisplay();

		return initiativeHelpCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<InitiativeHelp, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<InitiativeHelp, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<InitiativeHelp, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((InitiativeHelp)this));
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
		Map<String, Function<InitiativeHelp, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<InitiativeHelp, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<InitiativeHelp, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((InitiativeHelp)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final Function<InvocationHandler, InitiativeHelp>
		_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	private String _uuid;
	private String _originalUuid;
	private long _initiativeHelpId;
	private Date _createDate;
	private String _publikUserId;
	private String _originalPublikUserId;
	private long _initiativeId;
	private long _originalInitiativeId;
	private boolean _setOriginalInitiativeId;
	private String _helpTypes;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private String _message;
	private boolean _helpDisplay;
	private long _columnBitmask;
	private InitiativeHelp _escapedModel;

}