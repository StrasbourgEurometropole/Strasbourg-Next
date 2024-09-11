/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.interest.model.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import eu.strasbourg.service.interest.model.UserInterest;
import eu.strasbourg.service.interest.model.UserInterestModel;
import eu.strasbourg.service.interest.service.persistence.UserInterestPK;

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
 * The base model implementation for the UserInterest service. Represents a row in the &quot;interest_UserInterest&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>UserInterestModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link UserInterestImpl}.
 * </p>
 *
 * @author BenjaminBini
 * @see UserInterestImpl
 * @generated
 */
public class UserInterestModelImpl
	extends BaseModelImpl<UserInterest> implements UserInterestModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a user interest model instance should use the <code>UserInterest</code> interface instead.
	 */
	public static final String TABLE_NAME = "interest_UserInterest";

	public static final Object[][] TABLE_COLUMNS = {
		{"interestId", Types.BIGINT}, {"publikUserId", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("interestId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("publikUserId", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table interest_UserInterest (interestId LONG not null,publikUserId VARCHAR(75) not null,primary key (interestId, publikUserId))";

	public static final String TABLE_SQL_DROP =
		"drop table interest_UserInterest";

	public static final String ORDER_BY_JPQL =
		" ORDER BY userInterest.id.interestId ASC, userInterest.id.publikUserId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY interest_UserInterest.interestId ASC, interest_UserInterest.publikUserId ASC";

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
	public static final long INTERESTID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long PUBLIKUSERID_COLUMN_BITMASK = 2L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		eu.strasbourg.service.interest.service.util.ServiceProps.get(
			"lock.expiration.time.eu.strasbourg.service.interest.model.UserInterest"));

	public UserInterestModelImpl() {
	}

	@Override
	public UserInterestPK getPrimaryKey() {
		return new UserInterestPK(_interestId, _publikUserId);
	}

	@Override
	public void setPrimaryKey(UserInterestPK primaryKey) {
		setInterestId(primaryKey.interestId);
		setPublikUserId(primaryKey.publikUserId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new UserInterestPK(_interestId, _publikUserId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((UserInterestPK)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return UserInterest.class;
	}

	@Override
	public String getModelClassName() {
		return UserInterest.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<UserInterest, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<UserInterest, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<UserInterest, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((UserInterest)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<UserInterest, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<UserInterest, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(UserInterest)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<UserInterest, Object>>
		getAttributeGetterFunctions() {

		return AttributeGetterFunctionsHolder._attributeGetterFunctions;
	}

	public Map<String, BiConsumer<UserInterest, Object>>
		getAttributeSetterBiConsumers() {

		return AttributeSetterBiConsumersHolder._attributeSetterBiConsumers;
	}

	private static class AttributeGetterFunctionsHolder {

		private static final Map<String, Function<UserInterest, Object>>
			_attributeGetterFunctions;

		static {
			Map<String, Function<UserInterest, Object>>
				attributeGetterFunctions =
					new LinkedHashMap<String, Function<UserInterest, Object>>();

			attributeGetterFunctions.put(
				"interestId", UserInterest::getInterestId);
			attributeGetterFunctions.put(
				"publikUserId", UserInterest::getPublikUserId);

			_attributeGetterFunctions = Collections.unmodifiableMap(
				attributeGetterFunctions);
		}

	}

	private static class AttributeSetterBiConsumersHolder {

		private static final Map<String, BiConsumer<UserInterest, Object>>
			_attributeSetterBiConsumers;

		static {
			Map<String, BiConsumer<UserInterest, ?>>
				attributeSetterBiConsumers =
					new LinkedHashMap<String, BiConsumer<UserInterest, ?>>();

			attributeSetterBiConsumers.put(
				"interestId",
				(BiConsumer<UserInterest, Long>)UserInterest::setInterestId);
			attributeSetterBiConsumers.put(
				"publikUserId",
				(BiConsumer<UserInterest, String>)
					UserInterest::setPublikUserId);

			_attributeSetterBiConsumers = Collections.unmodifiableMap(
				(Map)attributeSetterBiConsumers);
		}

	}

	@Override
	public long getInterestId() {
		return _interestId;
	}

	@Override
	public void setInterestId(long interestId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_interestId = interestId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalInterestId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("interestId"));
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
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_publikUserId = publikUserId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalPublikUserId() {
		return getColumnOriginalValue("publikUserId");
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
	public UserInterest toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, UserInterest>
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
		UserInterestImpl userInterestImpl = new UserInterestImpl();

		userInterestImpl.setInterestId(getInterestId());
		userInterestImpl.setPublikUserId(getPublikUserId());

		userInterestImpl.resetOriginalValues();

		return userInterestImpl;
	}

	@Override
	public UserInterest cloneWithOriginalValues() {
		UserInterestImpl userInterestImpl = new UserInterestImpl();

		userInterestImpl.setInterestId(
			this.<Long>getColumnOriginalValue("interestId"));
		userInterestImpl.setPublikUserId(
			this.<String>getColumnOriginalValue("publikUserId"));

		return userInterestImpl;
	}

	@Override
	public int compareTo(UserInterest userInterest) {
		UserInterestPK primaryKey = userInterest.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof UserInterest)) {
			return false;
		}

		UserInterest userInterest = (UserInterest)object;

		UserInterestPK primaryKey = userInterest.getPrimaryKey();

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

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<UserInterest> toCacheModel() {
		UserInterestCacheModel userInterestCacheModel =
			new UserInterestCacheModel();

		userInterestCacheModel.userInterestPK = getPrimaryKey();

		userInterestCacheModel.interestId = getInterestId();

		userInterestCacheModel.publikUserId = getPublikUserId();

		String publikUserId = userInterestCacheModel.publikUserId;

		if ((publikUserId != null) && (publikUserId.length() == 0)) {
			userInterestCacheModel.publikUserId = null;
		}

		return userInterestCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<UserInterest, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<UserInterest, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<UserInterest, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((UserInterest)this);

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

		private static final Function<InvocationHandler, UserInterest>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					UserInterest.class, ModelWrapper.class);

	}

	private long _interestId;
	private String _publikUserId;

	public <T> T getColumnValue(String columnName) {
		Function<UserInterest, Object> function =
			AttributeGetterFunctionsHolder._attributeGetterFunctions.get(
				columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((UserInterest)this);
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

		_columnOriginalValues.put("interestId", _interestId);
		_columnOriginalValues.put("publikUserId", _publikUserId);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("interestId", 1L);

		columnBitmasks.put("publikUserId", 2L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private UserInterest _escapedModel;

}