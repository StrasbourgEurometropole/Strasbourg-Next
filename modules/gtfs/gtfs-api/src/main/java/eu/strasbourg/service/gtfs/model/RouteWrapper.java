/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Route}.
 * </p>
 *
 * @author Cedric Henry
 * @see Route
 * @generated
 */
public class RouteWrapper
	extends BaseModelWrapper<Route> implements ModelWrapper<Route>, Route {

	public RouteWrapper(Route route) {
		super(route);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("route_id", getRoute_id());
		attributes.put("route_short_name", getRoute_short_name());
		attributes.put("route_long_name", getRoute_long_name());
		attributes.put("route_desc", getRoute_desc());
		attributes.put("route_type", getRoute_type());
		attributes.put("route_color", getRoute_color());
		attributes.put("route_text_color", getRoute_text_color());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String route_id = (String)attributes.get("route_id");

		if (route_id != null) {
			setRoute_id(route_id);
		}

		String route_short_name = (String)attributes.get("route_short_name");

		if (route_short_name != null) {
			setRoute_short_name(route_short_name);
		}

		String route_long_name = (String)attributes.get("route_long_name");

		if (route_long_name != null) {
			setRoute_long_name(route_long_name);
		}

		String route_desc = (String)attributes.get("route_desc");

		if (route_desc != null) {
			setRoute_desc(route_desc);
		}

		Integer route_type = (Integer)attributes.get("route_type");

		if (route_type != null) {
			setRoute_type(route_type);
		}

		String route_color = (String)attributes.get("route_color");

		if (route_color != null) {
			setRoute_color(route_color);
		}

		String route_text_color = (String)attributes.get("route_text_color");

		if (route_text_color != null) {
			setRoute_text_color(route_text_color);
		}
	}

	@Override
	public Route cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the ID of this route.
	 *
	 * @return the ID of this route
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the primary key of this route.
	 *
	 * @return the primary key of this route
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the route_color of this route.
	 *
	 * @return the route_color of this route
	 */
	@Override
	public String getRoute_color() {
		return model.getRoute_color();
	}

	/**
	 * Returns the route_desc of this route.
	 *
	 * @return the route_desc of this route
	 */
	@Override
	public String getRoute_desc() {
		return model.getRoute_desc();
	}

	/**
	 * Returns the route_id of this route.
	 *
	 * @return the route_id of this route
	 */
	@Override
	public String getRoute_id() {
		return model.getRoute_id();
	}

	/**
	 * Returns the route_long_name of this route.
	 *
	 * @return the route_long_name of this route
	 */
	@Override
	public String getRoute_long_name() {
		return model.getRoute_long_name();
	}

	/**
	 * Returns the route_short_name of this route.
	 *
	 * @return the route_short_name of this route
	 */
	@Override
	public String getRoute_short_name() {
		return model.getRoute_short_name();
	}

	/**
	 * Returns the route_text_color of this route.
	 *
	 * @return the route_text_color of this route
	 */
	@Override
	public String getRoute_text_color() {
		return model.getRoute_text_color();
	}

	/**
	 * Returns the route_type of this route.
	 *
	 * @return the route_type of this route
	 */
	@Override
	public int getRoute_type() {
		return model.getRoute_type();
	}

	/**
	 * Returns the uuid of this route.
	 *
	 * @return the uuid of this route
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the ID of this route.
	 *
	 * @param id the ID of this route
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the primary key of this route.
	 *
	 * @param primaryKey the primary key of this route
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the route_color of this route.
	 *
	 * @param route_color the route_color of this route
	 */
	@Override
	public void setRoute_color(String route_color) {
		model.setRoute_color(route_color);
	}

	/**
	 * Sets the route_desc of this route.
	 *
	 * @param route_desc the route_desc of this route
	 */
	@Override
	public void setRoute_desc(String route_desc) {
		model.setRoute_desc(route_desc);
	}

	/**
	 * Sets the route_id of this route.
	 *
	 * @param route_id the route_id of this route
	 */
	@Override
	public void setRoute_id(String route_id) {
		model.setRoute_id(route_id);
	}

	/**
	 * Sets the route_long_name of this route.
	 *
	 * @param route_long_name the route_long_name of this route
	 */
	@Override
	public void setRoute_long_name(String route_long_name) {
		model.setRoute_long_name(route_long_name);
	}

	/**
	 * Sets the route_short_name of this route.
	 *
	 * @param route_short_name the route_short_name of this route
	 */
	@Override
	public void setRoute_short_name(String route_short_name) {
		model.setRoute_short_name(route_short_name);
	}

	/**
	 * Sets the route_text_color of this route.
	 *
	 * @param route_text_color the route_text_color of this route
	 */
	@Override
	public void setRoute_text_color(String route_text_color) {
		model.setRoute_text_color(route_text_color);
	}

	/**
	 * Sets the route_type of this route.
	 *
	 * @param route_type the route_type of this route
	 */
	@Override
	public void setRoute_type(int route_type) {
		model.setRoute_type(route_type);
	}

	/**
	 * Sets the uuid of this route.
	 *
	 * @param uuid the uuid of this route
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected RouteWrapper wrap(Route route) {
		return new RouteWrapper(route);
	}

}