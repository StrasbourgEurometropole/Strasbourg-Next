/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.favorite.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import eu.strasbourg.service.favorite.model.Favorite;
import eu.strasbourg.service.favorite.model.FavoriteModel;

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
 * The base model implementation for the Favorite service. Represents a row in the &quot;favorite_Favorite&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>FavoriteModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FavoriteImpl}.
 * </p>
 *
 * @author BenjaminBini
 * @see FavoriteImpl
 * @generated
 */
@JSON(strict = true)
public class FavoriteModelImpl
	extends BaseModelImpl<Favorite> implements FavoriteModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a favorite model instance should use the <code>Favorite</code> interface instead.
	 */
	public static final String TABLE_NAME = "favorite_Favorite";

	public static final Object[][] TABLE_COLUMNS = {
		{"favoriteId", Types.BIGINT}, {"publikUserId", Types.VARCHAR},
		{"title", Types.VARCHAR}, {"url", Types.VARCHAR},
		{"typeId", Types.BIGINT}, {"entityId", Types.BIGINT},
		{"entityGroupId", Types.BIGINT}, {"onDashboardDate", Types.TIMESTAMP},
		{"order_", Types.INTEGER}, {"content", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("favoriteId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("publikUserId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("title", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("url", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("typeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("entityId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("entityGroupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("onDashboardDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("order_", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("content", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table favorite_Favorite (favoriteId LONG not null primary key,publikUserId VARCHAR(75) null,title VARCHAR(255) null,url VARCHAR(255) null,typeId LONG,entityId LONG,entityGroupId LONG,onDashboardDate DATE null,order_ INTEGER,content VARCHAR(75) null,createDate DATE null,modifiedDate DATE null)";

	public static final String TABLE_SQL_DROP = "drop table favorite_Favorite";

	public static final String ORDER_BY_JPQL =
		" ORDER BY favorite.favoriteId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY favorite_Favorite.favoriteId ASC";

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
	public static final long CONTENT_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long ENTITYGROUPID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long ENTITYID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long PUBLIKUSERID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long TITLE_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long TYPEID_COLUMN_BITMASK = 32L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long FAVORITEID_COLUMN_BITMASK = 64L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		eu.strasbourg.service.favorite.service.util.ServiceProps.get(
			"lock.expiration.time.eu.strasbourg.service.favorite.model.Favorite"));

	public FavoriteModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _favoriteId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFavoriteId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _favoriteId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Favorite.class;
	}

	@Override
	public String getModelClassName() {
		return Favorite.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Favorite, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Favorite, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Favorite, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Favorite)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Favorite, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Favorite, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Favorite)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Favorite, Object>>
		getAttributeGetterFunctions() {

		return AttributeGetterFunctionsHolder._attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Favorite, Object>>
		getAttributeSetterBiConsumers() {

		return AttributeSetterBiConsumersHolder._attributeSetterBiConsumers;
	}

	private static class AttributeGetterFunctionsHolder {

		private static final Map<String, Function<Favorite, Object>>
			_attributeGetterFunctions;

		static {
			Map<String, Function<Favorite, Object>> attributeGetterFunctions =
				new LinkedHashMap<String, Function<Favorite, Object>>();

			attributeGetterFunctions.put("favoriteId", Favorite::getFavoriteId);
			attributeGetterFunctions.put(
				"publikUserId", Favorite::getPublikUserId);
			attributeGetterFunctions.put("title", Favorite::getTitle);
			attributeGetterFunctions.put("url", Favorite::getUrl);
			attributeGetterFunctions.put("typeId", Favorite::getTypeId);
			attributeGetterFunctions.put("entityId", Favorite::getEntityId);
			attributeGetterFunctions.put(
				"entityGroupId", Favorite::getEntityGroupId);
			attributeGetterFunctions.put(
				"onDashboardDate", Favorite::getOnDashboardDate);
			attributeGetterFunctions.put("order", Favorite::getOrder);
			attributeGetterFunctions.put("content", Favorite::getContent);
			attributeGetterFunctions.put("createDate", Favorite::getCreateDate);
			attributeGetterFunctions.put(
				"modifiedDate", Favorite::getModifiedDate);

			_attributeGetterFunctions = Collections.unmodifiableMap(
				attributeGetterFunctions);
		}

	}

	private static class AttributeSetterBiConsumersHolder {

		private static final Map<String, BiConsumer<Favorite, Object>>
			_attributeSetterBiConsumers;

		static {
			Map<String, BiConsumer<Favorite, ?>> attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<Favorite, ?>>();

			attributeSetterBiConsumers.put(
				"favoriteId",
				(BiConsumer<Favorite, Long>)Favorite::setFavoriteId);
			attributeSetterBiConsumers.put(
				"publikUserId",
				(BiConsumer<Favorite, String>)Favorite::setPublikUserId);
			attributeSetterBiConsumers.put(
				"title", (BiConsumer<Favorite, String>)Favorite::setTitle);
			attributeSetterBiConsumers.put(
				"url", (BiConsumer<Favorite, String>)Favorite::setUrl);
			attributeSetterBiConsumers.put(
				"typeId", (BiConsumer<Favorite, Long>)Favorite::setTypeId);
			attributeSetterBiConsumers.put(
				"entityId", (BiConsumer<Favorite, Long>)Favorite::setEntityId);
			attributeSetterBiConsumers.put(
				"entityGroupId",
				(BiConsumer<Favorite, Long>)Favorite::setEntityGroupId);
			attributeSetterBiConsumers.put(
				"onDashboardDate",
				(BiConsumer<Favorite, Date>)Favorite::setOnDashboardDate);
			attributeSetterBiConsumers.put(
				"order", (BiConsumer<Favorite, Integer>)Favorite::setOrder);
			attributeSetterBiConsumers.put(
				"content", (BiConsumer<Favorite, String>)Favorite::setContent);
			attributeSetterBiConsumers.put(
				"createDate",
				(BiConsumer<Favorite, Date>)Favorite::setCreateDate);
			attributeSetterBiConsumers.put(
				"modifiedDate",
				(BiConsumer<Favorite, Date>)Favorite::setModifiedDate);

			_attributeSetterBiConsumers = Collections.unmodifiableMap(
				(Map)attributeSetterBiConsumers);
		}

	}

	@JSON
	@Override
	public long getFavoriteId() {
		return _favoriteId;
	}

	@Override
	public void setFavoriteId(long favoriteId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_favoriteId = favoriteId;
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
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_title = title;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalTitle() {
		return getColumnOriginalValue("title");
	}

	@JSON
	@Override
	public String getUrl() {
		if (_url == null) {
			return "";
		}
		else {
			return _url;
		}
	}

	@Override
	public void setUrl(String url) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_url = url;
	}

	@JSON
	@Override
	public long getTypeId() {
		return _typeId;
	}

	@Override
	public void setTypeId(long typeId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_typeId = typeId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalTypeId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("typeId"));
	}

	@JSON
	@Override
	public long getEntityId() {
		return _entityId;
	}

	@Override
	public void setEntityId(long entityId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_entityId = entityId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalEntityId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("entityId"));
	}

	@JSON
	@Override
	public long getEntityGroupId() {
		return _entityGroupId;
	}

	@Override
	public void setEntityGroupId(long entityGroupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_entityGroupId = entityGroupId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalEntityGroupId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("entityGroupId"));
	}

	@JSON
	@Override
	public Date getOnDashboardDate() {
		return _onDashboardDate;
	}

	@Override
	public void setOnDashboardDate(Date onDashboardDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_onDashboardDate = onDashboardDate;
	}

	@JSON
	@Override
	public int getOrder() {
		return _order;
	}

	@Override
	public void setOrder(int order) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_order = order;
	}

	@JSON
	@Override
	public String getContent() {
		if (_content == null) {
			return "";
		}
		else {
			return _content;
		}
	}

	@Override
	public void setContent(String content) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_content = content;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalContent() {
		return getColumnOriginalValue("content");
	}

	@JSON
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

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
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
			0, Favorite.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Favorite toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Favorite>
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
		FavoriteImpl favoriteImpl = new FavoriteImpl();

		favoriteImpl.setFavoriteId(getFavoriteId());
		favoriteImpl.setPublikUserId(getPublikUserId());
		favoriteImpl.setTitle(getTitle());
		favoriteImpl.setUrl(getUrl());
		favoriteImpl.setTypeId(getTypeId());
		favoriteImpl.setEntityId(getEntityId());
		favoriteImpl.setEntityGroupId(getEntityGroupId());
		favoriteImpl.setOnDashboardDate(getOnDashboardDate());
		favoriteImpl.setOrder(getOrder());
		favoriteImpl.setContent(getContent());
		favoriteImpl.setCreateDate(getCreateDate());
		favoriteImpl.setModifiedDate(getModifiedDate());

		favoriteImpl.resetOriginalValues();

		return favoriteImpl;
	}

	@Override
	public Favorite cloneWithOriginalValues() {
		FavoriteImpl favoriteImpl = new FavoriteImpl();

		favoriteImpl.setFavoriteId(
			this.<Long>getColumnOriginalValue("favoriteId"));
		favoriteImpl.setPublikUserId(
			this.<String>getColumnOriginalValue("publikUserId"));
		favoriteImpl.setTitle(this.<String>getColumnOriginalValue("title"));
		favoriteImpl.setUrl(this.<String>getColumnOriginalValue("url"));
		favoriteImpl.setTypeId(this.<Long>getColumnOriginalValue("typeId"));
		favoriteImpl.setEntityId(this.<Long>getColumnOriginalValue("entityId"));
		favoriteImpl.setEntityGroupId(
			this.<Long>getColumnOriginalValue("entityGroupId"));
		favoriteImpl.setOnDashboardDate(
			this.<Date>getColumnOriginalValue("onDashboardDate"));
		favoriteImpl.setOrder(this.<Integer>getColumnOriginalValue("order_"));
		favoriteImpl.setContent(this.<String>getColumnOriginalValue("content"));
		favoriteImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		favoriteImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));

		return favoriteImpl;
	}

	@Override
	public int compareTo(Favorite favorite) {
		long primaryKey = favorite.getPrimaryKey();

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
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Favorite)) {
			return false;
		}

		Favorite favorite = (Favorite)object;

		long primaryKey = favorite.getPrimaryKey();

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
	public CacheModel<Favorite> toCacheModel() {
		FavoriteCacheModel favoriteCacheModel = new FavoriteCacheModel();

		favoriteCacheModel.favoriteId = getFavoriteId();

		favoriteCacheModel.publikUserId = getPublikUserId();

		String publikUserId = favoriteCacheModel.publikUserId;

		if ((publikUserId != null) && (publikUserId.length() == 0)) {
			favoriteCacheModel.publikUserId = null;
		}

		favoriteCacheModel.title = getTitle();

		String title = favoriteCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			favoriteCacheModel.title = null;
		}

		favoriteCacheModel.url = getUrl();

		String url = favoriteCacheModel.url;

		if ((url != null) && (url.length() == 0)) {
			favoriteCacheModel.url = null;
		}

		favoriteCacheModel.typeId = getTypeId();

		favoriteCacheModel.entityId = getEntityId();

		favoriteCacheModel.entityGroupId = getEntityGroupId();

		Date onDashboardDate = getOnDashboardDate();

		if (onDashboardDate != null) {
			favoriteCacheModel.onDashboardDate = onDashboardDate.getTime();
		}
		else {
			favoriteCacheModel.onDashboardDate = Long.MIN_VALUE;
		}

		favoriteCacheModel.order = getOrder();

		favoriteCacheModel.content = getContent();

		String content = favoriteCacheModel.content;

		if ((content != null) && (content.length() == 0)) {
			favoriteCacheModel.content = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			favoriteCacheModel.createDate = createDate.getTime();
		}
		else {
			favoriteCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			favoriteCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			favoriteCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		return favoriteCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Favorite, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Favorite, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Favorite, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((Favorite)this);

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

		private static final Function<InvocationHandler, Favorite>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					Favorite.class, ModelWrapper.class);

	}

	private long _favoriteId;
	private String _publikUserId;
	private String _title;
	private String _url;
	private long _typeId;
	private long _entityId;
	private long _entityGroupId;
	private Date _onDashboardDate;
	private int _order;
	private String _content;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<Favorite, Object> function =
			AttributeGetterFunctionsHolder._attributeGetterFunctions.get(
				columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Favorite)this);
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

		_columnOriginalValues.put("favoriteId", _favoriteId);
		_columnOriginalValues.put("publikUserId", _publikUserId);
		_columnOriginalValues.put("title", _title);
		_columnOriginalValues.put("url", _url);
		_columnOriginalValues.put("typeId", _typeId);
		_columnOriginalValues.put("entityId", _entityId);
		_columnOriginalValues.put("entityGroupId", _entityGroupId);
		_columnOriginalValues.put("onDashboardDate", _onDashboardDate);
		_columnOriginalValues.put("order_", _order);
		_columnOriginalValues.put("content", _content);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("order_", "order");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("favoriteId", 1L);

		columnBitmasks.put("publikUserId", 2L);

		columnBitmasks.put("title", 4L);

		columnBitmasks.put("url", 8L);

		columnBitmasks.put("typeId", 16L);

		columnBitmasks.put("entityId", 32L);

		columnBitmasks.put("entityGroupId", 64L);

		columnBitmasks.put("onDashboardDate", 128L);

		columnBitmasks.put("order_", 256L);

		columnBitmasks.put("content", 512L);

		columnBitmasks.put("createDate", 1024L);

		columnBitmasks.put("modifiedDate", 2048L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Favorite _escapedModel;

}