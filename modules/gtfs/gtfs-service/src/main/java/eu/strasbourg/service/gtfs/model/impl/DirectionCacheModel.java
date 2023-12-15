/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.gtfs.model.Direction;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Direction in entity cache.
 *
 * @author Cedric Henry
 * @generated
 */
public class DirectionCacheModel
	implements CacheModel<Direction>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DirectionCacheModel)) {
			return false;
		}

		DirectionCacheModel directionCacheModel = (DirectionCacheModel)object;

		if (directionId == directionCacheModel.directionId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, directionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", directionId=");
		sb.append(directionId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", tripId=");
		sb.append(tripId);
		sb.append(", stopId=");
		sb.append(stopId);
		sb.append(", routeId=");
		sb.append(routeId);
		sb.append(", destinationName=");
		sb.append(destinationName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Direction toEntityModel() {
		DirectionImpl directionImpl = new DirectionImpl();

		if (uuid == null) {
			directionImpl.setUuid("");
		}
		else {
			directionImpl.setUuid(uuid);
		}

		directionImpl.setDirectionId(directionId);
		directionImpl.setGroupId(groupId);
		directionImpl.setCompanyId(companyId);

		if (tripId == null) {
			directionImpl.setTripId("");
		}
		else {
			directionImpl.setTripId(tripId);
		}

		if (stopId == null) {
			directionImpl.setStopId("");
		}
		else {
			directionImpl.setStopId(stopId);
		}

		if (routeId == null) {
			directionImpl.setRouteId("");
		}
		else {
			directionImpl.setRouteId(routeId);
		}

		if (destinationName == null) {
			directionImpl.setDestinationName("");
		}
		else {
			directionImpl.setDestinationName(destinationName);
		}

		directionImpl.resetOriginalValues();

		return directionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		directionId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		tripId = objectInput.readUTF();
		stopId = objectInput.readUTF();
		routeId = objectInput.readUTF();
		destinationName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(directionId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		if (tripId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tripId);
		}

		if (stopId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(stopId);
		}

		if (routeId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(routeId);
		}

		if (destinationName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(destinationName);
		}
	}

	public String uuid;
	public long directionId;
	public long groupId;
	public long companyId;
	public String tripId;
	public String stopId;
	public String routeId;
	public String destinationName;

}