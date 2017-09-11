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

package eu.strasbourg.service.notification.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import eu.strasbourg.service.notification.model.UserNotificationType;
import eu.strasbourg.service.notification.model.UserNotificationTypeModel;
import eu.strasbourg.service.notification.service.persistence.UserNotificationTypePK;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the UserNotificationType service. Represents a row in the &quot;notification_UserNotificationType&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link UserNotificationTypeModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link UserNotificationTypeImpl}.
 * </p>
 *
 * @author BenjaminBini
 * @see UserNotificationTypeImpl
 * @see UserNotificationType
 * @see UserNotificationTypeModel
 * @generated
 */
@ProviderType
public class UserNotificationTypeModelImpl extends BaseModelImpl<UserNotificationType>
	implements UserNotificationTypeModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a user notification type model instance should use the {@link UserNotificationType} interface instead.
	 */
	public static final String TABLE_NAME = "notification_UserNotificationType";
	public static final Object[][] TABLE_COLUMNS = {
			{ "publikUserId", Types.BIGINT },
			{ "typeId", Types.BIGINT }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("publikUserId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("typeId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE = "create table notification_UserNotificationType (publikUserId LONG not null,typeId LONG not null,primary key (publikUserId, typeId))";
	public static final String TABLE_SQL_DROP = "drop table notification_UserNotificationType";
	public static final String ORDER_BY_JPQL = " ORDER BY userNotificationType.id.publikUserId ASC, userNotificationType.id.typeId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY notification_UserNotificationType.publikUserId ASC, notification_UserNotificationType.typeId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(eu.strasbourg.service.notification.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.eu.strasbourg.service.notification.model.UserNotificationType"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(eu.strasbourg.service.notification.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.eu.strasbourg.service.notification.model.UserNotificationType"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(eu.strasbourg.service.notification.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.eu.strasbourg.service.notification.model.UserNotificationType"),
			true);
	public static final long PUBLIKUSERID_COLUMN_BITMASK = 1L;
	public static final long TYPEID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(eu.strasbourg.service.notification.service.util.ServiceProps.get(
				"lock.expiration.time.eu.strasbourg.service.notification.model.UserNotificationType"));

	public UserNotificationTypeModelImpl() {
	}

	@Override
	public UserNotificationTypePK getPrimaryKey() {
		return new UserNotificationTypePK(_publikUserId, _typeId);
	}

	@Override
	public void setPrimaryKey(UserNotificationTypePK primaryKey) {
		setPublikUserId(primaryKey.publikUserId);
		setTypeId(primaryKey.typeId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new UserNotificationTypePK(_publikUserId, _typeId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((UserNotificationTypePK)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return UserNotificationType.class;
	}

	@Override
	public String getModelClassName() {
		return UserNotificationType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("publikUserId", getPublikUserId());
		attributes.put("typeId", getTypeId());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long publikUserId = (Long)attributes.get("publikUserId");

		if (publikUserId != null) {
			setPublikUserId(publikUserId);
		}

		Long typeId = (Long)attributes.get("typeId");

		if (typeId != null) {
			setTypeId(typeId);
		}
	}

	@Override
	public long getPublikUserId() {
		return _publikUserId;
	}

	@Override
	public void setPublikUserId(long publikUserId) {
		_columnBitmask |= PUBLIKUSERID_COLUMN_BITMASK;

		if (!_setOriginalPublikUserId) {
			_setOriginalPublikUserId = true;

			_originalPublikUserId = _publikUserId;
		}

		_publikUserId = publikUserId;
	}

	@Override
	public String getPublikUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getPublikUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setPublikUserUuid(String publikUserUuid) {
	}

	public long getOriginalPublikUserId() {
		return _originalPublikUserId;
	}

	@Override
	public long getTypeId() {
		return _typeId;
	}

	@Override
	public void setTypeId(long typeId) {
		_columnBitmask |= TYPEID_COLUMN_BITMASK;

		if (!_setOriginalTypeId) {
			_setOriginalTypeId = true;

			_originalTypeId = _typeId;
		}

		_typeId = typeId;
	}

	public long getOriginalTypeId() {
		return _originalTypeId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public UserNotificationType toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (UserNotificationType)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		UserNotificationTypeImpl userNotificationTypeImpl = new UserNotificationTypeImpl();

		userNotificationTypeImpl.setPublikUserId(getPublikUserId());
		userNotificationTypeImpl.setTypeId(getTypeId());

		userNotificationTypeImpl.resetOriginalValues();

		return userNotificationTypeImpl;
	}

	@Override
	public int compareTo(UserNotificationType userNotificationType) {
		UserNotificationTypePK primaryKey = userNotificationType.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserNotificationType)) {
			return false;
		}

		UserNotificationType userNotificationType = (UserNotificationType)obj;

		UserNotificationTypePK primaryKey = userNotificationType.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
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
		UserNotificationTypeModelImpl userNotificationTypeModelImpl = this;

		userNotificationTypeModelImpl._originalPublikUserId = userNotificationTypeModelImpl._publikUserId;

		userNotificationTypeModelImpl._setOriginalPublikUserId = false;

		userNotificationTypeModelImpl._originalTypeId = userNotificationTypeModelImpl._typeId;

		userNotificationTypeModelImpl._setOriginalTypeId = false;

		userNotificationTypeModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<UserNotificationType> toCacheModel() {
		UserNotificationTypeCacheModel userNotificationTypeCacheModel = new UserNotificationTypeCacheModel();

		userNotificationTypeCacheModel.userNotificationTypePK = getPrimaryKey();

		userNotificationTypeCacheModel.publikUserId = getPublikUserId();

		userNotificationTypeCacheModel.typeId = getTypeId();

		return userNotificationTypeCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{publikUserId=");
		sb.append(getPublikUserId());
		sb.append(", typeId=");
		sb.append(getTypeId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append(
			"eu.strasbourg.service.notification.model.UserNotificationType");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>publikUserId</column-name><column-value><![CDATA[");
		sb.append(getPublikUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>typeId</column-name><column-value><![CDATA[");
		sb.append(getTypeId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = UserNotificationType.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			UserNotificationType.class
		};
	private long _publikUserId;
	private long _originalPublikUserId;
	private boolean _setOriginalPublikUserId;
	private long _typeId;
	private long _originalTypeId;
	private boolean _setOriginalTypeId;
	private long _columnBitmask;
	private UserNotificationType _escapedModel;
}