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

package eu.strasbourg.service.gtfs.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Serializable;

/**
 * @author Cedric Henry
 * @generated
 */
@ProviderType
public class StopTimePK implements Comparable<StopTimePK>, Serializable {

	public String trip_id;
	public String stop_id;

	public StopTimePK() {
	}

	public StopTimePK(String trip_id, String stop_id) {
		this.trip_id = trip_id;
		this.stop_id = stop_id;
	}

	public String getTrip_id() {
		return trip_id;
	}

	public void setTrip_id(String trip_id) {
		this.trip_id = trip_id;
	}

	public String getStop_id() {
		return stop_id;
	}

	public void setStop_id(String stop_id) {
		this.stop_id = stop_id;
	}

	@Override
	public int compareTo(StopTimePK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		value = trip_id.compareTo(pk.trip_id);

		if (value != 0) {
			return value;
		}

		value = stop_id.compareTo(pk.stop_id);

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

		if (!(obj instanceof StopTimePK)) {
			return false;
		}

		StopTimePK pk = (StopTimePK)obj;

		if (trip_id.equals(pk.trip_id) && stop_id.equals(pk.stop_id)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, trip_id);
		hashCode = HashUtil.hash(hashCode, stop_id);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("trip_id=");

		sb.append(trip_id);
		sb.append(", stop_id=");

		sb.append(stop_id);

		sb.append("}");

		return sb.toString();
	}

}