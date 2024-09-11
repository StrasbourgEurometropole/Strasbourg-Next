/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.place.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.place.model.PublicHoliday;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PublicHoliday in entity cache.
 *
 * @author Angelique Zunino Champougny
 * @generated
 */
public class PublicHolidayCacheModel
	implements CacheModel<PublicHoliday>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PublicHolidayCacheModel)) {
			return false;
		}

		PublicHolidayCacheModel publicHolidayCacheModel =
			(PublicHolidayCacheModel)object;

		if (publicHolidayId == publicHolidayCacheModel.publicHolidayId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, publicHolidayId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", publicHolidayId=");
		sb.append(publicHolidayId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", date=");
		sb.append(date);
		sb.append(", recurrent=");
		sb.append(recurrent);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PublicHoliday toEntityModel() {
		PublicHolidayImpl publicHolidayImpl = new PublicHolidayImpl();

		if (uuid == null) {
			publicHolidayImpl.setUuid("");
		}
		else {
			publicHolidayImpl.setUuid(uuid);
		}

		publicHolidayImpl.setPublicHolidayId(publicHolidayId);

		if (name == null) {
			publicHolidayImpl.setName("");
		}
		else {
			publicHolidayImpl.setName(name);
		}

		if (date == Long.MIN_VALUE) {
			publicHolidayImpl.setDate(null);
		}
		else {
			publicHolidayImpl.setDate(new Date(date));
		}

		publicHolidayImpl.setRecurrent(recurrent);

		publicHolidayImpl.resetOriginalValues();

		return publicHolidayImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		publicHolidayId = objectInput.readLong();
		name = objectInput.readUTF();
		date = objectInput.readLong();

		recurrent = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(publicHolidayId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(date);

		objectOutput.writeBoolean(recurrent);
	}

	public String uuid;
	public long publicHolidayId;
	public String name;
	public long date;
	public boolean recurrent;

}