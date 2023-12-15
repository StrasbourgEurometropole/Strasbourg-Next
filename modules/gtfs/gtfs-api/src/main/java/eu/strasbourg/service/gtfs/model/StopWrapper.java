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
 * This class is a wrapper for {@link Stop}.
 * </p>
 *
 * @author Cedric Henry
 * @see Stop
 * @generated
 */
public class StopWrapper
	extends BaseModelWrapper<Stop> implements ModelWrapper<Stop>, Stop {

	public StopWrapper(Stop stop) {
		super(stop);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("stop_id", getStop_id());
		attributes.put("stop_code", getStop_code());
		attributes.put("stop_lat", getStop_lat());
		attributes.put("stop_lon", getStop_lon());
		attributes.put("stop_name", getStop_name());
		attributes.put("stop_url", getStop_url());
		attributes.put("stop_desc", getStop_desc());

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

		String stop_id = (String)attributes.get("stop_id");

		if (stop_id != null) {
			setStop_id(stop_id);
		}

		String stop_code = (String)attributes.get("stop_code");

		if (stop_code != null) {
			setStop_code(stop_code);
		}

		String stop_lat = (String)attributes.get("stop_lat");

		if (stop_lat != null) {
			setStop_lat(stop_lat);
		}

		String stop_lon = (String)attributes.get("stop_lon");

		if (stop_lon != null) {
			setStop_lon(stop_lon);
		}

		String stop_name = (String)attributes.get("stop_name");

		if (stop_name != null) {
			setStop_name(stop_name);
		}

		String stop_url = (String)attributes.get("stop_url");

		if (stop_url != null) {
			setStop_url(stop_url);
		}

		String stop_desc = (String)attributes.get("stop_desc");

		if (stop_desc != null) {
			setStop_desc(stop_desc);
		}
	}

	@Override
	public Stop cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the ID of this stop.
	 *
	 * @return the ID of this stop
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the primary key of this stop.
	 *
	 * @return the primary key of this stop
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the stop_code of this stop.
	 *
	 * @return the stop_code of this stop
	 */
	@Override
	public String getStop_code() {
		return model.getStop_code();
	}

	/**
	 * Returns the stop_desc of this stop.
	 *
	 * @return the stop_desc of this stop
	 */
	@Override
	public String getStop_desc() {
		return model.getStop_desc();
	}

	/**
	 * Returns the stop_id of this stop.
	 *
	 * @return the stop_id of this stop
	 */
	@Override
	public String getStop_id() {
		return model.getStop_id();
	}

	/**
	 * Returns the stop_lat of this stop.
	 *
	 * @return the stop_lat of this stop
	 */
	@Override
	public String getStop_lat() {
		return model.getStop_lat();
	}

	/**
	 * Returns the stop_lon of this stop.
	 *
	 * @return the stop_lon of this stop
	 */
	@Override
	public String getStop_lon() {
		return model.getStop_lon();
	}

	/**
	 * Returns the stop_name of this stop.
	 *
	 * @return the stop_name of this stop
	 */
	@Override
	public String getStop_name() {
		return model.getStop_name();
	}

	/**
	 * Returns the stop_url of this stop.
	 *
	 * @return the stop_url of this stop
	 */
	@Override
	public String getStop_url() {
		return model.getStop_url();
	}

	/**
	 * Returns the uuid of this stop.
	 *
	 * @return the uuid of this stop
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
	 * Sets the ID of this stop.
	 *
	 * @param id the ID of this stop
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the primary key of this stop.
	 *
	 * @param primaryKey the primary key of this stop
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the stop_code of this stop.
	 *
	 * @param stop_code the stop_code of this stop
	 */
	@Override
	public void setStop_code(String stop_code) {
		model.setStop_code(stop_code);
	}

	/**
	 * Sets the stop_desc of this stop.
	 *
	 * @param stop_desc the stop_desc of this stop
	 */
	@Override
	public void setStop_desc(String stop_desc) {
		model.setStop_desc(stop_desc);
	}

	/**
	 * Sets the stop_id of this stop.
	 *
	 * @param stop_id the stop_id of this stop
	 */
	@Override
	public void setStop_id(String stop_id) {
		model.setStop_id(stop_id);
	}

	/**
	 * Sets the stop_lat of this stop.
	 *
	 * @param stop_lat the stop_lat of this stop
	 */
	@Override
	public void setStop_lat(String stop_lat) {
		model.setStop_lat(stop_lat);
	}

	/**
	 * Sets the stop_lon of this stop.
	 *
	 * @param stop_lon the stop_lon of this stop
	 */
	@Override
	public void setStop_lon(String stop_lon) {
		model.setStop_lon(stop_lon);
	}

	/**
	 * Sets the stop_name of this stop.
	 *
	 * @param stop_name the stop_name of this stop
	 */
	@Override
	public void setStop_name(String stop_name) {
		model.setStop_name(stop_name);
	}

	/**
	 * Sets the stop_url of this stop.
	 *
	 * @param stop_url the stop_url of this stop
	 */
	@Override
	public void setStop_url(String stop_url) {
		model.setStop_url(stop_url);
	}

	/**
	 * Sets the uuid of this stop.
	 *
	 * @param uuid the uuid of this stop
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
	protected StopWrapper wrap(Stop stop) {
		return new StopWrapper(stop);
	}

}