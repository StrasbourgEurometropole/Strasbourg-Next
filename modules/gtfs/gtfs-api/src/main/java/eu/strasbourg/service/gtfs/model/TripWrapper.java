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
 * This class is a wrapper for {@link Trip}.
 * </p>
 *
 * @author Cedric Henry
 * @see Trip
 * @generated
 */
public class TripWrapper
	extends BaseModelWrapper<Trip> implements ModelWrapper<Trip>, Trip {

	public TripWrapper(Trip trip) {
		super(trip);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("route_id", getRoute_id());
		attributes.put("service_id", getService_id());
		attributes.put("trip_id", getTrip_id());
		attributes.put("trip_headsign", getTrip_headsign());
		attributes.put("direction_id", isDirection_id());
		attributes.put("block_id", getBlock_id());

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

		String service_id = (String)attributes.get("service_id");

		if (service_id != null) {
			setService_id(service_id);
		}

		String trip_id = (String)attributes.get("trip_id");

		if (trip_id != null) {
			setTrip_id(trip_id);
		}

		String trip_headsign = (String)attributes.get("trip_headsign");

		if (trip_headsign != null) {
			setTrip_headsign(trip_headsign);
		}

		Boolean direction_id = (Boolean)attributes.get("direction_id");

		if (direction_id != null) {
			setDirection_id(direction_id);
		}

		String block_id = (String)attributes.get("block_id");

		if (block_id != null) {
			setBlock_id(block_id);
		}
	}

	@Override
	public Trip cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the block_id of this trip.
	 *
	 * @return the block_id of this trip
	 */
	@Override
	public String getBlock_id() {
		return model.getBlock_id();
	}

	/**
	 * Returns the direction_id of this trip.
	 *
	 * @return the direction_id of this trip
	 */
	@Override
	public boolean getDirection_id() {
		return model.getDirection_id();
	}

	/**
	 * Returns the ID of this trip.
	 *
	 * @return the ID of this trip
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the primary key of this trip.
	 *
	 * @return the primary key of this trip
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the route_id of this trip.
	 *
	 * @return the route_id of this trip
	 */
	@Override
	public String getRoute_id() {
		return model.getRoute_id();
	}

	/**
	 * Returns the service_id of this trip.
	 *
	 * @return the service_id of this trip
	 */
	@Override
	public String getService_id() {
		return model.getService_id();
	}

	/**
	 * Returns the trip_headsign of this trip.
	 *
	 * @return the trip_headsign of this trip
	 */
	@Override
	public String getTrip_headsign() {
		return model.getTrip_headsign();
	}

	/**
	 * Returns the trip_id of this trip.
	 *
	 * @return the trip_id of this trip
	 */
	@Override
	public String getTrip_id() {
		return model.getTrip_id();
	}

	/**
	 * Returns the uuid of this trip.
	 *
	 * @return the uuid of this trip
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this trip is direction_id.
	 *
	 * @return <code>true</code> if this trip is direction_id; <code>false</code> otherwise
	 */
	@Override
	public boolean isDirection_id() {
		return model.isDirection_id();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the block_id of this trip.
	 *
	 * @param block_id the block_id of this trip
	 */
	@Override
	public void setBlock_id(String block_id) {
		model.setBlock_id(block_id);
	}

	/**
	 * Sets whether this trip is direction_id.
	 *
	 * @param direction_id the direction_id of this trip
	 */
	@Override
	public void setDirection_id(boolean direction_id) {
		model.setDirection_id(direction_id);
	}

	/**
	 * Sets the ID of this trip.
	 *
	 * @param id the ID of this trip
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the primary key of this trip.
	 *
	 * @param primaryKey the primary key of this trip
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the route_id of this trip.
	 *
	 * @param route_id the route_id of this trip
	 */
	@Override
	public void setRoute_id(String route_id) {
		model.setRoute_id(route_id);
	}

	/**
	 * Sets the service_id of this trip.
	 *
	 * @param service_id the service_id of this trip
	 */
	@Override
	public void setService_id(String service_id) {
		model.setService_id(service_id);
	}

	/**
	 * Sets the trip_headsign of this trip.
	 *
	 * @param trip_headsign the trip_headsign of this trip
	 */
	@Override
	public void setTrip_headsign(String trip_headsign) {
		model.setTrip_headsign(trip_headsign);
	}

	/**
	 * Sets the trip_id of this trip.
	 *
	 * @param trip_id the trip_id of this trip
	 */
	@Override
	public void setTrip_id(String trip_id) {
		model.setTrip_id(trip_id);
	}

	/**
	 * Sets the uuid of this trip.
	 *
	 * @param uuid the uuid of this trip
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
	protected TripWrapper wrap(Trip trip) {
		return new TripWrapper(trip);
	}

}