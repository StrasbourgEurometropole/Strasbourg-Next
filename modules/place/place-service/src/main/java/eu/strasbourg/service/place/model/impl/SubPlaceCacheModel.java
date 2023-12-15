/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.place.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.place.model.SubPlace;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SubPlace in entity cache.
 *
 * @author Angelique Zunino Champougny
 * @generated
 */
public class SubPlaceCacheModel
	implements CacheModel<SubPlace>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SubPlaceCacheModel)) {
			return false;
		}

		SubPlaceCacheModel subPlaceCacheModel = (SubPlaceCacheModel)object;

		if (subPlaceId == subPlaceCacheModel.subPlaceId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, subPlaceId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", subPlaceId=");
		sb.append(subPlaceId);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", placeId=");
		sb.append(placeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SubPlace toEntityModel() {
		SubPlaceImpl subPlaceImpl = new SubPlaceImpl();

		if (uuid == null) {
			subPlaceImpl.setUuid("");
		}
		else {
			subPlaceImpl.setUuid(uuid);
		}

		subPlaceImpl.setSubPlaceId(subPlaceId);
		subPlaceImpl.setStatus(status);
		subPlaceImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			subPlaceImpl.setStatusByUserName("");
		}
		else {
			subPlaceImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			subPlaceImpl.setStatusDate(null);
		}
		else {
			subPlaceImpl.setStatusDate(new Date(statusDate));
		}

		if (name == null) {
			subPlaceImpl.setName("");
		}
		else {
			subPlaceImpl.setName(name);
		}

		if (description == null) {
			subPlaceImpl.setDescription("");
		}
		else {
			subPlaceImpl.setDescription(description);
		}

		subPlaceImpl.setPlaceId(placeId);

		subPlaceImpl.resetOriginalValues();

		return subPlaceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		uuid = objectInput.readUTF();

		subPlaceId = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
		name = objectInput.readUTF();
		description = (String)objectInput.readObject();

		placeId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(subPlaceId);

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (description == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(description);
		}

		objectOutput.writeLong(placeId);
	}

	public String uuid;
	public long subPlaceId;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public String name;
	public String description;
	public long placeId;

}