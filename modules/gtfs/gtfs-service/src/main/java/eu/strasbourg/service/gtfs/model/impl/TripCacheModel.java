/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.gtfs.model.Trip;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Trip in entity cache.
 *
 * @author Cedric Henry
 * @generated
 */
public class TripCacheModel implements CacheModel<Trip>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TripCacheModel)) {
			return false;
		}

		TripCacheModel tripCacheModel = (TripCacheModel)object;

		if (id == tripCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", id=");
		sb.append(id);
		sb.append(", route_id=");
		sb.append(route_id);
		sb.append(", service_id=");
		sb.append(service_id);
		sb.append(", trip_id=");
		sb.append(trip_id);
		sb.append(", trip_headsign=");
		sb.append(trip_headsign);
		sb.append(", direction_id=");
		sb.append(direction_id);
		sb.append(", block_id=");
		sb.append(block_id);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Trip toEntityModel() {
		TripImpl tripImpl = new TripImpl();

		if (uuid == null) {
			tripImpl.setUuid("");
		}
		else {
			tripImpl.setUuid(uuid);
		}

		tripImpl.setId(id);

		if (route_id == null) {
			tripImpl.setRoute_id("");
		}
		else {
			tripImpl.setRoute_id(route_id);
		}

		if (service_id == null) {
			tripImpl.setService_id("");
		}
		else {
			tripImpl.setService_id(service_id);
		}

		if (trip_id == null) {
			tripImpl.setTrip_id("");
		}
		else {
			tripImpl.setTrip_id(trip_id);
		}

		if (trip_headsign == null) {
			tripImpl.setTrip_headsign("");
		}
		else {
			tripImpl.setTrip_headsign(trip_headsign);
		}

		tripImpl.setDirection_id(direction_id);

		if (block_id == null) {
			tripImpl.setBlock_id("");
		}
		else {
			tripImpl.setBlock_id(block_id);
		}

		tripImpl.resetOriginalValues();

		return tripImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		id = objectInput.readLong();
		route_id = objectInput.readUTF();
		service_id = objectInput.readUTF();
		trip_id = objectInput.readUTF();
		trip_headsign = objectInput.readUTF();

		direction_id = objectInput.readBoolean();
		block_id = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(id);

		if (route_id == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(route_id);
		}

		if (service_id == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(service_id);
		}

		if (trip_id == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(trip_id);
		}

		if (trip_headsign == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(trip_headsign);
		}

		objectOutput.writeBoolean(direction_id);

		if (block_id == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(block_id);
		}
	}

	public String uuid;
	public long id;
	public String route_id;
	public String service_id;
	public String trip_id;
	public String trip_headsign;
	public boolean direction_id;
	public String block_id;

}