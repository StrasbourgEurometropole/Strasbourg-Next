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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import eu.strasbourg.service.gtfs.model.Route;
import eu.strasbourg.service.gtfs.model.RouteModel;

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
 * The base model implementation for the Route service. Represents a row in the &quot;gtfs_Route&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>RouteModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link RouteImpl}.
 * </p>
 *
 * @author Cedric Henry
 * @see RouteImpl
 * @generated
 */
@ProviderType
public class RouteModelImpl extends BaseModelImpl<Route> implements RouteModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a route model instance should use the <code>Route</code> interface instead.
	 */
	public static final String TABLE_NAME = "gtfs_Route";

	public static final Object[][] TABLE_COLUMNS = {
		{"route_id", Types.VARCHAR}, {"route_short_name", Types.VARCHAR},
		{"route_long_name", Types.VARCHAR}, {"route_type", Types.INTEGER},
		{"route_color", Types.VARCHAR}, {"route_text_color", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("route_id", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("route_short_name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("route_long_name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("route_type", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("route_color", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("route_text_color", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table gtfs_Route (route_id VARCHAR(75) not null primary key,route_short_name VARCHAR(75) null,route_long_name VARCHAR(200) null,route_type INTEGER,route_color VARCHAR(75) null,route_text_color VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table gtfs_Route";

	public static final String ORDER_BY_JPQL = " ORDER BY route.route_id ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY gtfs_Route.route_id ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.gtfs.service.util.PropsUtil.get(
			"value.object.entity.cache.enabled.eu.strasbourg.service.gtfs.model.Route"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.gtfs.service.util.PropsUtil.get(
			"value.object.finder.cache.enabled.eu.strasbourg.service.gtfs.model.Route"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.gtfs.service.util.PropsUtil.get(
			"value.object.column.bitmask.enabled.eu.strasbourg.service.gtfs.model.Route"),
		true);

	public static final long ROUTE_ID_COLUMN_BITMASK = 1L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		eu.strasbourg.service.gtfs.service.util.PropsUtil.get(
			"lock.expiration.time.eu.strasbourg.service.gtfs.model.Route"));

	public RouteModelImpl() {
	}

	@Override
	public String getPrimaryKey() {
		return _route_id;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setRoute_id(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _route_id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return Route.class;
	}

	@Override
	public String getModelClassName() {
		return Route.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Route, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Route, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Route, Object> attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Route)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Route, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Route, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept((Route)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Route, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Route, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Route>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Route.class.getClassLoader(), Route.class, ModelWrapper.class);

		try {
			Constructor<Route> constructor =
				(Constructor<Route>)proxyClass.getConstructor(
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

	private static final Map<String, Function<Route, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Route, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Route, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Route, Object>>();
		Map<String, BiConsumer<Route, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Route, ?>>();

		attributeGetterFunctions.put(
			"route_id",
			new Function<Route, Object>() {

				@Override
				public Object apply(Route route) {
					return route.getRoute_id();
				}

			});
		attributeSetterBiConsumers.put(
			"route_id",
			new BiConsumer<Route, Object>() {

				@Override
				public void accept(Route route, Object route_id) {
					route.setRoute_id((String)route_id);
				}

			});
		attributeGetterFunctions.put(
			"route_short_name",
			new Function<Route, Object>() {

				@Override
				public Object apply(Route route) {
					return route.getRoute_short_name();
				}

			});
		attributeSetterBiConsumers.put(
			"route_short_name",
			new BiConsumer<Route, Object>() {

				@Override
				public void accept(Route route, Object route_short_name) {
					route.setRoute_short_name((String)route_short_name);
				}

			});
		attributeGetterFunctions.put(
			"route_long_name",
			new Function<Route, Object>() {

				@Override
				public Object apply(Route route) {
					return route.getRoute_long_name();
				}

			});
		attributeSetterBiConsumers.put(
			"route_long_name",
			new BiConsumer<Route, Object>() {

				@Override
				public void accept(Route route, Object route_long_name) {
					route.setRoute_long_name((String)route_long_name);
				}

			});
		attributeGetterFunctions.put(
			"route_type",
			new Function<Route, Object>() {

				@Override
				public Object apply(Route route) {
					return route.getRoute_type();
				}

			});
		attributeSetterBiConsumers.put(
			"route_type",
			new BiConsumer<Route, Object>() {

				@Override
				public void accept(Route route, Object route_type) {
					route.setRoute_type((Integer)route_type);
				}

			});
		attributeGetterFunctions.put(
			"route_color",
			new Function<Route, Object>() {

				@Override
				public Object apply(Route route) {
					return route.getRoute_color();
				}

			});
		attributeSetterBiConsumers.put(
			"route_color",
			new BiConsumer<Route, Object>() {

				@Override
				public void accept(Route route, Object route_color) {
					route.setRoute_color((String)route_color);
				}

			});
		attributeGetterFunctions.put(
			"route_text_color",
			new Function<Route, Object>() {

				@Override
				public Object apply(Route route) {
					return route.getRoute_text_color();
				}

			});
		attributeSetterBiConsumers.put(
			"route_text_color",
			new BiConsumer<Route, Object>() {

				@Override
				public void accept(Route route, Object route_text_color) {
					route.setRoute_text_color((String)route_text_color);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public String getRoute_id() {
		if (_route_id == null) {
			return "";
		}
		else {
			return _route_id;
		}
	}

	@Override
	public void setRoute_id(String route_id) {
		_columnBitmask = -1L;

		if (_originalRoute_id == null) {
			_originalRoute_id = _route_id;
		}

		_route_id = route_id;
	}

	public String getOriginalRoute_id() {
		return GetterUtil.getString(_originalRoute_id);
	}

	@Override
	public String getRoute_short_name() {
		if (_route_short_name == null) {
			return "";
		}
		else {
			return _route_short_name;
		}
	}

	@Override
	public void setRoute_short_name(String route_short_name) {
		_route_short_name = route_short_name;
	}

	@Override
	public String getRoute_long_name() {
		if (_route_long_name == null) {
			return "";
		}
		else {
			return _route_long_name;
		}
	}

	@Override
	public void setRoute_long_name(String route_long_name) {
		_route_long_name = route_long_name;
	}

	@Override
	public int getRoute_type() {
		return _route_type;
	}

	@Override
	public void setRoute_type(int route_type) {
		_route_type = route_type;
	}

	@Override
	public String getRoute_color() {
		if (_route_color == null) {
			return "";
		}
		else {
			return _route_color;
		}
	}

	@Override
	public void setRoute_color(String route_color) {
		_route_color = route_color;
	}

	@Override
	public String getRoute_text_color() {
		if (_route_text_color == null) {
			return "";
		}
		else {
			return _route_text_color;
		}
	}

	@Override
	public void setRoute_text_color(String route_text_color) {
		_route_text_color = route_text_color;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public Route toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = _escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		RouteImpl routeImpl = new RouteImpl();

		routeImpl.setRoute_id(getRoute_id());
		routeImpl.setRoute_short_name(getRoute_short_name());
		routeImpl.setRoute_long_name(getRoute_long_name());
		routeImpl.setRoute_type(getRoute_type());
		routeImpl.setRoute_color(getRoute_color());
		routeImpl.setRoute_text_color(getRoute_text_color());

		routeImpl.resetOriginalValues();

		return routeImpl;
	}

	@Override
	public int compareTo(Route route) {
		int value = 0;

		value = getRoute_id().compareTo(route.getRoute_id());

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

		if (!(obj instanceof Route)) {
			return false;
		}

		Route route = (Route)obj;

		String primaryKey = route.getPrimaryKey();

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
		RouteModelImpl routeModelImpl = this;

		routeModelImpl._originalRoute_id = routeModelImpl._route_id;

		routeModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Route> toCacheModel() {
		RouteCacheModel routeCacheModel = new RouteCacheModel();

		routeCacheModel.route_id = getRoute_id();

		String route_id = routeCacheModel.route_id;

		if ((route_id != null) && (route_id.length() == 0)) {
			routeCacheModel.route_id = null;
		}

		routeCacheModel.route_short_name = getRoute_short_name();

		String route_short_name = routeCacheModel.route_short_name;

		if ((route_short_name != null) && (route_short_name.length() == 0)) {
			routeCacheModel.route_short_name = null;
		}

		routeCacheModel.route_long_name = getRoute_long_name();

		String route_long_name = routeCacheModel.route_long_name;

		if ((route_long_name != null) && (route_long_name.length() == 0)) {
			routeCacheModel.route_long_name = null;
		}

		routeCacheModel.route_type = getRoute_type();

		routeCacheModel.route_color = getRoute_color();

		String route_color = routeCacheModel.route_color;

		if ((route_color != null) && (route_color.length() == 0)) {
			routeCacheModel.route_color = null;
		}

		routeCacheModel.route_text_color = getRoute_text_color();

		String route_text_color = routeCacheModel.route_text_color;

		if ((route_text_color != null) && (route_text_color.length() == 0)) {
			routeCacheModel.route_text_color = null;
		}

		return routeCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Route, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Route, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Route, Object> attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Route)this));
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
		Map<String, Function<Route, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Route, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Route, Object> attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Route)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final Function<InvocationHandler, Route>
		_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	private String _route_id;
	private String _originalRoute_id;
	private String _route_short_name;
	private String _route_long_name;
	private int _route_type;
	private String _route_color;
	private String _route_text_color;
	private long _columnBitmask;
	private Route _escapedModel;

}