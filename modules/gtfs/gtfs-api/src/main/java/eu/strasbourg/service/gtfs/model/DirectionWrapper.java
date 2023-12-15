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
 * This class is a wrapper for {@link Direction}.
 * </p>
 *
 * @author Cedric Henry
 * @see Direction
 * @generated
 */
public class DirectionWrapper
	extends BaseModelWrapper<Direction>
	implements Direction, ModelWrapper<Direction> {

	public DirectionWrapper(Direction direction) {
		super(direction);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("directionId", getDirectionId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("tripId", getTripId());
		attributes.put("stopId", getStopId());
		attributes.put("routeId", getRouteId());
		attributes.put("destinationName", getDestinationName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long directionId = (Long)attributes.get("directionId");

		if (directionId != null) {
			setDirectionId(directionId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String tripId = (String)attributes.get("tripId");

		if (tripId != null) {
			setTripId(tripId);
		}

		String stopId = (String)attributes.get("stopId");

		if (stopId != null) {
			setStopId(stopId);
		}

		String routeId = (String)attributes.get("routeId");

		if (routeId != null) {
			setRouteId(routeId);
		}

		String destinationName = (String)attributes.get("destinationName");

		if (destinationName != null) {
			setDestinationName(destinationName);
		}
	}

	@Override
	public Direction cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this direction.
	 *
	 * @return the company ID of this direction
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the destination name of this direction.
	 *
	 * @return the destination name of this direction
	 */
	@Override
	public String getDestinationName() {
		return model.getDestinationName();
	}

	/**
	 * Returns the direction ID of this direction.
	 *
	 * @return the direction ID of this direction
	 */
	@Override
	public long getDirectionId() {
		return model.getDirectionId();
	}

	/**
	 * Returns the group ID of this direction.
	 *
	 * @return the group ID of this direction
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Renvoie la Ligne de cette direction
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Ligne getLigne() {
		return model.getLigne();
	}

	/**
	 * Returns the primary key of this direction.
	 *
	 * @return the primary key of this direction
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the route ID of this direction.
	 *
	 * @return the route ID of this direction
	 */
	@Override
	public String getRouteId() {
		return model.getRouteId();
	}

	/**
	 * Returns the stop ID of this direction.
	 *
	 * @return the stop ID of this direction
	 */
	@Override
	public String getStopId() {
		return model.getStopId();
	}

	/**
	 * Returns the trip ID of this direction.
	 *
	 * @return the trip ID of this direction
	 */
	@Override
	public String getTripId() {
		return model.getTripId();
	}

	/**
	 * Returns the uuid of this direction.
	 *
	 * @return the uuid of this direction
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
	 * Sets the company ID of this direction.
	 *
	 * @param companyId the company ID of this direction
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the destination name of this direction.
	 *
	 * @param destinationName the destination name of this direction
	 */
	@Override
	public void setDestinationName(String destinationName) {
		model.setDestinationName(destinationName);
	}

	/**
	 * Sets the direction ID of this direction.
	 *
	 * @param directionId the direction ID of this direction
	 */
	@Override
	public void setDirectionId(long directionId) {
		model.setDirectionId(directionId);
	}

	/**
	 * Sets the group ID of this direction.
	 *
	 * @param groupId the group ID of this direction
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the primary key of this direction.
	 *
	 * @param primaryKey the primary key of this direction
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the route ID of this direction.
	 *
	 * @param routeId the route ID of this direction
	 */
	@Override
	public void setRouteId(String routeId) {
		model.setRouteId(routeId);
	}

	/**
	 * Sets the stop ID of this direction.
	 *
	 * @param stopId the stop ID of this direction
	 */
	@Override
	public void setStopId(String stopId) {
		model.setStopId(stopId);
	}

	/**
	 * Sets the trip ID of this direction.
	 *
	 * @param tripId the trip ID of this direction
	 */
	@Override
	public void setTripId(String tripId) {
		model.setTripId(tripId);
	}

	/**
	 * Sets the uuid of this direction.
	 *
	 * @param uuid the uuid of this direction
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
	protected DirectionWrapper wrap(Direction direction) {
		return new DirectionWrapper(direction);
	}

}