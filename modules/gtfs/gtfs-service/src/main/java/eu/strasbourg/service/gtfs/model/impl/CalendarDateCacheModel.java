/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.gtfs.model.CalendarDate;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CalendarDate in entity cache.
 *
 * @author Cedric Henry
 * @generated
 */
public class CalendarDateCacheModel
	implements CacheModel<CalendarDate>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CalendarDateCacheModel)) {
			return false;
		}

		CalendarDateCacheModel calendarDateCacheModel =
			(CalendarDateCacheModel)object;

		if (id == calendarDateCacheModel.id) {
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
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", id=");
		sb.append(id);
		sb.append(", service_id=");
		sb.append(service_id);
		sb.append(", date=");
		sb.append(date);
		sb.append(", exception_type=");
		sb.append(exception_type);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CalendarDate toEntityModel() {
		CalendarDateImpl calendarDateImpl = new CalendarDateImpl();

		if (uuid == null) {
			calendarDateImpl.setUuid("");
		}
		else {
			calendarDateImpl.setUuid(uuid);
		}

		calendarDateImpl.setId(id);

		if (service_id == null) {
			calendarDateImpl.setService_id("");
		}
		else {
			calendarDateImpl.setService_id(service_id);
		}

		if (date == Long.MIN_VALUE) {
			calendarDateImpl.setDate(null);
		}
		else {
			calendarDateImpl.setDate(new Date(date));
		}

		calendarDateImpl.setException_type(exception_type);

		calendarDateImpl.resetOriginalValues();

		return calendarDateImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		id = objectInput.readLong();
		service_id = objectInput.readUTF();
		date = objectInput.readLong();

		exception_type = objectInput.readInt();
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

		if (service_id == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(service_id);
		}

		objectOutput.writeLong(date);

		objectOutput.writeInt(exception_type);
	}

	public String uuid;
	public long id;
	public String service_id;
	public long date;
	public int exception_type;

}