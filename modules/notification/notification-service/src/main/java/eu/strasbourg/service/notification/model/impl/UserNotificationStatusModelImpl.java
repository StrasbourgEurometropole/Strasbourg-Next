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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import eu.strasbourg.service.notification.model.UserNotificationStatus;
import eu.strasbourg.service.notification.model.UserNotificationStatusModel;
import eu.strasbourg.service.notification.service.persistence.UserNotificationStatusPK;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the UserNotificationStatus service. Represents a row in the &quot;notification_UserNotificationStatus&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>UserNotificationStatusModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link UserNotificationStatusImpl}.
 * </p>
 *
 * @author BenjaminBini
 * @see UserNotificationStatusImpl
 * @generated
 */
public class UserNotificationStatusModelImpl
	extends BaseModelImpl<UserNotificationStatus>
	implements UserNotificationStatusModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a user notification status model instance should use the <code>UserNotificationStatus</code> interface instead.
	 */
	public static final String TABLE_NAME =
		"notification_UserNotificationStatus";

	public static final Object[][] TABLE_COLUMNS = {
		{"notificationId", Types.BIGINT}, {"publikUserId", Types.VARCHAR},
		{"read_", Types.BOOLEAN}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("notificationId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("publikUserId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("read_", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE =
		"create table notification_UserNotificationStatus (notificationId LONG not null,publikUserId VARCHAR(75) not null,read_ BOOLEAN,primary key (notificationId, publikUserId))";

	public static final String TABLE_SQL_DROP =
		"drop table notification_UserNotificationStatus";

	public static final String ORDER_BY_JPQL =
		" ORDER BY userNotificationStatus.id.notificationId ASC, userNotificationStatus.id.publikUserId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY notification_UserNotificationStatus.notificationId ASC, notification_UserNotificationStatus.publikUserId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.notification.service.util.ServiceProps.get(
			"value.object.entity.cache.enabled.eu.strasbourg.service.notification.model.UserNotificationStatus"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.notification.service.util.ServiceProps.get(
			"value.object.finder.cache.enabled.eu.strasbourg.service.notification.model.UserNotificationStatus"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.notification.service.util.ServiceProps.get(
			"value.object.column.bitmask.enabled.eu.strasbourg.service.notification.model.UserNotificationStatus"),
		true);

	public static final long NOTIFICATIONID_COLUMN_BITMASK = 1L;

	public static final long PUBLIKUSERID_COLUMN_BITMASK = 2L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		eu.strasbourg.service.notification.service.util.ServiceProps.get(
			"lock.expiration.time.eu.strasbourg.service.notification.model.UserNotificationStatus"));

	public UserNotificationStatusModelImpl() {
	}

	@Override
	public UserNotificationStatusPK getPrimaryKey() {
		return new UserNotificationStatusPK(_notificationId, _publikUserId);
	}

	@Override
	public void setPrimaryKey(UserNotificationStatusPK primaryKey) {
		setNotificationId(primaryKey.notificationId);
		setPublikUserId(primaryKey.publikUserId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new UserNotificationStatusPK(_notificationId, _publikUserId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((UserNotificationStatusPK)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return UserNotificationStatus.class;
	}

	@Override
	public String getModelClassName() {
		return UserNotificationStatus.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<UserNotificationStatus, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<UserNotificationStatus, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<UserNotificationStatus, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((UserNotificationStatus)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<UserNotificationStatus, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<UserNotificationStatus, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(UserNotificationStatus)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<UserNotificationStatus, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<UserNotificationStatus, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, UserNotificationStatus>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			UserNotificationStatus.class.getClassLoader(),
			UserNotificationStatus.class, ModelWrapper.class);

		try {
			Constructor<UserNotificationStatus> constructor =
				(Constructor<UserNotificationStatus>)proxyClass.getConstructor(
					InvocationHandler.class);

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

	private static final Map<String, Function<UserNotificationStatus, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<UserNotificationStatus, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<UserNotificationStatus, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<UserNotificationStatus, Object>>();
		Map<String, BiConsumer<UserNotificationStatus, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<UserNotificationStatus, ?>>();

		attributeGetterFunctions.put(
			"notificationId",
			new Function<UserNotificationStatus, Object>() {

				@Override
				public Object apply(
					UserNotificationStatus userNotificationStatus) {

					return userNotificationStatus.getNotificationId();
				}

			});
		attributeSetterBiConsumers.put(
			"notificationId",
			new BiConsumer<UserNotificationStatus, Object>() {

				@Override
				public void accept(
					UserNotificationStatus userNotificationStatus,
					Object notificationIdObject) {

					userNotificationStatus.setNotificationId(
						(Long)notificationIdObject);
				}

			});
		attributeGetterFunctions.put(
			"publikUserId",
			new Function<UserNotificationStatus, Object>() {

				@Override
				public Object apply(
					UserNotificationStatus userNotificationStatus) {

					return userNotificationStatus.getPublikUserId();
				}

			});
		attributeSetterBiConsumers.put(
			"publikUserId",
			new BiConsumer<UserNotificationStatus, Object>() {

				@Override
				public void accept(
					UserNotificationStatus userNotificationStatus,
					Object publikUserIdObject) {

					userNotificationStatus.setPublikUserId(
						(String)publikUserIdObject);
				}

			});
		attributeGetterFunctions.put(
			"read",
			new Function<UserNotificationStatus, Object>() {

				@Override
				public Object apply(
					UserNotificationStatus userNotificationStatus) {

					return userNotificationStatus.getRead();
				}

			});
		attributeSetterBiConsumers.put(
			"read",
			new BiConsumer<UserNotificationStatus, Object>() {

				@Override
				public void accept(
					UserNotificationStatus userNotificationStatus,
					Object readObject) {

					userNotificationStatus.setRead((Boolean)readObject);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getNotificationId() {
		return _notificationId;
	}

	@Override
	public void setNotificationId(long notificationId) {
		_columnBitmask |= NOTIFICATIONID_COLUMN_BITMASK;

		if (!_setOriginalNotificationId) {
			_setOriginalNotificationId = true;

			_originalNotificationId = _notificationId;
		}

		_notificationId = notificationId;
	}

	public long getOriginalNotificationId() {
		return _originalNotificationId;
	}

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

	@Override
	public boolean getRead() {
		return _read;
	}

	@Override
	public boolean isRead() {
		return _read;
	}

	@Override
	public void setRead(boolean read) {
		_read = read;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public UserNotificationStatus toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, UserNotificationStatus>
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
		UserNotificationStatusImpl userNotificationStatusImpl =
			new UserNotificationStatusImpl();

		userNotificationStatusImpl.setNotificationId(getNotificationId());
		userNotificationStatusImpl.setPublikUserId(getPublikUserId());
		userNotificationStatusImpl.setRead(isRead());

		userNotificationStatusImpl.resetOriginalValues();

		return userNotificationStatusImpl;
	}

	@Override
	public int compareTo(UserNotificationStatus userNotificationStatus) {
		UserNotificationStatusPK primaryKey =
			userNotificationStatus.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof UserNotificationStatus)) {
			return false;
		}

		UserNotificationStatus userNotificationStatus =
			(UserNotificationStatus)object;

		UserNotificationStatusPK primaryKey =
			userNotificationStatus.getPrimaryKey();

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
		UserNotificationStatusModelImpl userNotificationStatusModelImpl = this;

		userNotificationStatusModelImpl._originalNotificationId =
			userNotificationStatusModelImpl._notificationId;

		userNotificationStatusModelImpl._setOriginalNotificationId = false;

		userNotificationStatusModelImpl._originalPublikUserId =
			userNotificationStatusModelImpl._publikUserId;

		userNotificationStatusModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<UserNotificationStatus> toCacheModel() {
		UserNotificationStatusCacheModel userNotificationStatusCacheModel =
			new UserNotificationStatusCacheModel();

		userNotificationStatusCacheModel.userNotificationStatusPK =
			getPrimaryKey();

		userNotificationStatusCacheModel.notificationId = getNotificationId();

		userNotificationStatusCacheModel.publikUserId = getPublikUserId();

		String publikUserId = userNotificationStatusCacheModel.publikUserId;

		if ((publikUserId != null) && (publikUserId.length() == 0)) {
			userNotificationStatusCacheModel.publikUserId = null;
		}

		userNotificationStatusCacheModel.read = isRead();

		return userNotificationStatusCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<UserNotificationStatus, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<UserNotificationStatus, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<UserNotificationStatus, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(
				attributeGetterFunction.apply((UserNotificationStatus)this));
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
		Map<String, Function<UserNotificationStatus, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<UserNotificationStatus, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<UserNotificationStatus, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply((UserNotificationStatus)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, UserNotificationStatus>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _notificationId;
	private long _originalNotificationId;
	private boolean _setOriginalNotificationId;
	private String _publikUserId;
	private String _originalPublikUserId;
	private boolean _read;
	private long _columnBitmask;
	private UserNotificationStatus _escapedModel;

}