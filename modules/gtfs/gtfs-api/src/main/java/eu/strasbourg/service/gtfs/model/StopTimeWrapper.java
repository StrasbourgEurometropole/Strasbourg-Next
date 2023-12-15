/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link StopTime}.
 * </p>
 *
 * @author Cedric Henry
 * @see StopTime
 * @generated
 */
public class StopTimeWrapper
	extends BaseModelWrapper<StopTime>
	implements ModelWrapper<StopTime>, StopTime {

	public StopTimeWrapper(StopTime stopTime) {
		super(stopTime);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("trip_id", getTrip_id());
		attributes.put("arrival_time", getArrival_time());
		attributes.put("departure_time", getDeparture_time());
		attributes.put("stop_id", getStop_id());
		attributes.put("stop_sequence", getStop_sequence());
		attributes.put("pickup_type", getPickup_type());
		attributes.put("drop_off_type", getDrop_off_type());

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

		String trip_id = (String)attributes.get("trip_id");

		if (trip_id != null) {
			setTrip_id(trip_id);
		}

		Date arrival_time = (Date)attributes.get("arrival_time");

		if (arrival_time != null) {
			setArrival_time(arrival_time);
		}

		Date departure_time = (Date)attributes.get("departure_time");

		if (departure_time != null) {
			setDeparture_time(departure_time);
		}

		String stop_id = (String)attributes.get("stop_id");

		if (stop_id != null) {
			setStop_id(stop_id);
		}

		Integer stop_sequence = (Integer)attributes.get("stop_sequence");

		if (stop_sequence != null) {
			setStop_sequence(stop_sequence);
		}

		String pickup_type = (String)attributes.get("pickup_type");

		if (pickup_type != null) {
			setPickup_type(pickup_type);
		}

		String drop_off_type = (String)attributes.get("drop_off_type");

		if (drop_off_type != null) {
			setDrop_off_type(drop_off_type);
		}
	}

	@Override
	public StopTime cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the arrival_time of this stop time.
	 *
	 * @return the arrival_time of this stop time
	 */
	@Override
	public Date getArrival_time() {
		return model.getArrival_time();
	}

	/**
	 * Returns the departure_time of this stop time.
	 *
	 * @return the departure_time of this stop time
	 */
	@Override
	public Date getDeparture_time() {
		return model.getDeparture_time();
	}

	/**
	 * Returns the drop_off_type of this stop time.
	 *
	 * @return the drop_off_type of this stop time
	 */
	@Override
	public String getDrop_off_type() {
		return model.getDrop_off_type();
	}

	/**
	 * Returns the ID of this stop time.
	 *
	 * @return the ID of this stop time
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the pickup_type of this stop time.
	 *
	 * @return the pickup_type of this stop time
	 */
	@Override
	public String getPickup_type() {
		return model.getPickup_type();
	}

	/**
	 * Returns the primary key of this stop time.
	 *
	 * @return the primary key of this stop time
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the stop_id of this stop time.
	 *
	 * @return the stop_id of this stop time
	 */
	@Override
	public String getStop_id() {
		return model.getStop_id();
	}

	/**
	 * Returns the stop_sequence of this stop time.
	 *
	 * @return the stop_sequence of this stop time
	 */
	@Override
	public int getStop_sequence() {
		return model.getStop_sequence();
	}

	/**
	 * Returns the trip_id of this stop time.
	 *
	 * @return the trip_id of this stop time
	 */
	@Override
	public String getTrip_id() {
		return model.getTrip_id();
	}

	/**
	 * Returns the uuid of this stop time.
	 *
	 * @return the uuid of this stop time
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
	 * Sets the arrival_time of this stop time.
	 *
	 * @param arrival_time the arrival_time of this stop time
	 */
	@Override
	public void setArrival_time(Date arrival_time) {
		model.setArrival_time(arrival_time);
	}

	/**
	 * Sets the departure_time of this stop time.
	 *
	 * @param departure_time the departure_time of this stop time
	 */
	@Override
	public void setDeparture_time(Date departure_time) {
		model.setDeparture_time(departure_time);
	}

	/**
	 * Sets the drop_off_type of this stop time.
	 *
	 * @param drop_off_type the drop_off_type of this stop time
	 */
	@Override
	public void setDrop_off_type(String drop_off_type) {
		model.setDrop_off_type(drop_off_type);
	}

	/**
	 * Sets the ID of this stop time.
	 *
	 * @param id the ID of this stop time
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the pickup_type of this stop time.
	 *
	 * @param pickup_type the pickup_type of this stop time
	 */
	@Override
	public void setPickup_type(String pickup_type) {
		model.setPickup_type(pickup_type);
	}

	/**
	 * Sets the primary key of this stop time.
	 *
	 * @param primaryKey the primary key of this stop time
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the stop_id of this stop time.
	 *
	 * @param stop_id the stop_id of this stop time
	 */
	@Override
	public void setStop_id(String stop_id) {
		model.setStop_id(stop_id);
	}

	/**
	 * Sets the stop_sequence of this stop time.
	 *
	 * @param stop_sequence the stop_sequence of this stop time
	 */
	@Override
	public void setStop_sequence(int stop_sequence) {
		model.setStop_sequence(stop_sequence);
	}

	/**
	 * Sets the trip_id of this stop time.
	 *
	 * @param trip_id the trip_id of this stop time
	 */
	@Override
	public void setTrip_id(String trip_id) {
		model.setTrip_id(trip_id);
	}

	/**
	 * Sets the uuid of this stop time.
	 *
	 * @param uuid the uuid of this stop time
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
	protected StopTimeWrapper wrap(StopTime stopTime) {
		return new StopTimeWrapper(stopTime);
	}

}