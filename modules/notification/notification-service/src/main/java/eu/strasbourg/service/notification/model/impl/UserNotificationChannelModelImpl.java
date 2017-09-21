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
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import eu.strasbourg.service.notification.model.UserNotificationChannel;
import eu.strasbourg.service.notification.model.UserNotificationChannelModel;
import eu.strasbourg.service.notification.service.persistence.UserNotificationChannelPK;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the UserNotificationChannel service. Represents a row in the &quot;notification_UserNotificationChannel&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link UserNotificationChannelModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link UserNotificationChannelImpl}.
 * </p>
 *
 * @author BenjaminBini
 * @see UserNotificationChannelImpl
 * @see UserNotificationChannel
 * @see UserNotificationChannelModel
 * @generated
 */
@ProviderType
public class UserNotificationChannelModelImpl extends BaseModelImpl<UserNotificationChannel>
	implements UserNotificationChannelModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a user notification channel model instance should use the {@link UserNotificationChannel} interface instead.
	 */
	public static final String TABLE_NAME = "notification_UserNotificationChannel";
	public static final Object[][] TABLE_COLUMNS = {
			{ "publikUserId", Types.VARCHAR },
			{ "channelId", Types.BIGINT }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("publikUserId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("channelId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE = "create table notification_UserNotificationChannel (publikUserId VARCHAR(75) not null,channelId LONG not null,primary key (publikUserId, channelId))";
	public static final String TABLE_SQL_DROP = "drop table notification_UserNotificationChannel";
	public static final String ORDER_BY_JPQL = " ORDER BY userNotificationChannel.id.publikUserId ASC, userNotificationChannel.id.channelId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY notification_UserNotificationChannel.publikUserId ASC, notification_UserNotificationChannel.channelId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(eu.strasbourg.service.notification.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.eu.strasbourg.service.notification.model.UserNotificationChannel"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(eu.strasbourg.service.notification.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.eu.strasbourg.service.notification.model.UserNotificationChannel"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(eu.strasbourg.service.notification.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.eu.strasbourg.service.notification.model.UserNotificationChannel"),
			true);
	public static final long CHANNELID_COLUMN_BITMASK = 1L;
	public static final long PUBLIKUSERID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(eu.strasbourg.service.notification.service.util.ServiceProps.get(
				"lock.expiration.time.eu.strasbourg.service.notification.model.UserNotificationChannel"));

	public UserNotificationChannelModelImpl() {
	}

	@Override
	public UserNotificationChannelPK getPrimaryKey() {
		return new UserNotificationChannelPK(_publikUserId, _channelId);
	}

	@Override
	public void setPrimaryKey(UserNotificationChannelPK primaryKey) {
		setPublikUserId(primaryKey.publikUserId);
		setChannelId(primaryKey.channelId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new UserNotificationChannelPK(_publikUserId, _channelId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((UserNotificationChannelPK)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return UserNotificationChannel.class;
	}

	@Override
	public String getModelClassName() {
		return UserNotificationChannel.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("publikUserId", getPublikUserId());
		attributes.put("channelId", getChannelId());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String publikUserId = (String)attributes.get("publikUserId");

		if (publikUserId != null) {
			setPublikUserId(publikUserId);
		}

		Long channelId = (Long)attributes.get("channelId");

		if (channelId != null) {
			setChannelId(channelId);
		}
	}

	@Override
	public String getPublikUserId() {
		if (_publikUserId == null) {
			return StringPool.BLANK;
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

	@Override
	public long getChannelId() {
		return _channelId;
	}

	@Override
	public void setChannelId(long channelId) {
		_columnBitmask |= CHANNELID_COLUMN_BITMASK;

		if (!_setOriginalChannelId) {
			_setOriginalChannelId = true;

			_originalChannelId = _channelId;
		}

		_channelId = channelId;
	}

	public long getOriginalChannelId() {
		return _originalChannelId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public UserNotificationChannel toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (UserNotificationChannel)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		UserNotificationChannelImpl userNotificationChannelImpl = new UserNotificationChannelImpl();

		userNotificationChannelImpl.setPublikUserId(getPublikUserId());
		userNotificationChannelImpl.setChannelId(getChannelId());

		userNotificationChannelImpl.resetOriginalValues();

		return userNotificationChannelImpl;
	}

	@Override
	public int compareTo(UserNotificationChannel userNotificationChannel) {
		UserNotificationChannelPK primaryKey = userNotificationChannel.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserNotificationChannel)) {
			return false;
		}

		UserNotificationChannel userNotificationChannel = (UserNotificationChannel)obj;

		UserNotificationChannelPK primaryKey = userNotificationChannel.getPrimaryKey();

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
		UserNotificationChannelModelImpl userNotificationChannelModelImpl = this;

		userNotificationChannelModelImpl._originalPublikUserId = userNotificationChannelModelImpl._publikUserId;

		userNotificationChannelModelImpl._originalChannelId = userNotificationChannelModelImpl._channelId;

		userNotificationChannelModelImpl._setOriginalChannelId = false;

		userNotificationChannelModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<UserNotificationChannel> toCacheModel() {
		UserNotificationChannelCacheModel userNotificationChannelCacheModel = new UserNotificationChannelCacheModel();

		userNotificationChannelCacheModel.userNotificationChannelPK = getPrimaryKey();

		userNotificationChannelCacheModel.publikUserId = getPublikUserId();

		String publikUserId = userNotificationChannelCacheModel.publikUserId;

		if ((publikUserId != null) && (publikUserId.length() == 0)) {
			userNotificationChannelCacheModel.publikUserId = null;
		}

		userNotificationChannelCacheModel.channelId = getChannelId();

		return userNotificationChannelCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{publikUserId=");
		sb.append(getPublikUserId());
		sb.append(", channelId=");
		sb.append(getChannelId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append(
			"eu.strasbourg.service.notification.model.UserNotificationChannel");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>publikUserId</column-name><column-value><![CDATA[");
		sb.append(getPublikUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>channelId</column-name><column-value><![CDATA[");
		sb.append(getChannelId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = UserNotificationChannel.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			UserNotificationChannel.class
		};
	private String _publikUserId;
	private String _originalPublikUserId;
	private long _channelId;
	private long _originalChannelId;
	private boolean _setOriginalChannelId;
	private long _columnBitmask;
	private UserNotificationChannel _escapedModel;
}