/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.gtfs.model.Calendar;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Calendar in entity cache.
 *
 * @author Cedric Henry
 * @generated
 */
public class CalendarCacheModel
	implements CacheModel<Calendar>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CalendarCacheModel)) {
			return false;
		}

		CalendarCacheModel calendarCacheModel = (CalendarCacheModel)object;

		if (id == calendarCacheModel.id) {
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
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", id=");
		sb.append(id);
		sb.append(", service_id=");
		sb.append(service_id);
		sb.append(", monday=");
		sb.append(monday);
		sb.append(", tuesday=");
		sb.append(tuesday);
		sb.append(", wednesday=");
		sb.append(wednesday);
		sb.append(", thursday=");
		sb.append(thursday);
		sb.append(", friday=");
		sb.append(friday);
		sb.append(", saturday=");
		sb.append(saturday);
		sb.append(", sunday=");
		sb.append(sunday);
		sb.append(", start_date=");
		sb.append(start_date);
		sb.append(", end_date=");
		sb.append(end_date);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Calendar toEntityModel() {
		CalendarImpl calendarImpl = new CalendarImpl();

		if (uuid == null) {
			calendarImpl.setUuid("");
		}
		else {
			calendarImpl.setUuid(uuid);
		}

		calendarImpl.setId(id);

		if (service_id == null) {
			calendarImpl.setService_id("");
		}
		else {
			calendarImpl.setService_id(service_id);
		}

		calendarImpl.setMonday(monday);
		calendarImpl.setTuesday(tuesday);
		calendarImpl.setWednesday(wednesday);
		calendarImpl.setThursday(thursday);
		calendarImpl.setFriday(friday);
		calendarImpl.setSaturday(saturday);
		calendarImpl.setSunday(sunday);

		if (start_date == Long.MIN_VALUE) {
			calendarImpl.setStart_date(null);
		}
		else {
			calendarImpl.setStart_date(new Date(start_date));
		}

		if (end_date == Long.MIN_VALUE) {
			calendarImpl.setEnd_date(null);
		}
		else {
			calendarImpl.setEnd_date(new Date(end_date));
		}

		calendarImpl.resetOriginalValues();

		return calendarImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		id = objectInput.readLong();
		service_id = objectInput.readUTF();

		monday = objectInput.readBoolean();

		tuesday = objectInput.readBoolean();

		wednesday = objectInput.readBoolean();

		thursday = objectInput.readBoolean();

		friday = objectInput.readBoolean();

		saturday = objectInput.readBoolean();

		sunday = objectInput.readBoolean();
		start_date = objectInput.readLong();
		end_date = objectInput.readLong();
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

		objectOutput.writeBoolean(monday);

		objectOutput.writeBoolean(tuesday);

		objectOutput.writeBoolean(wednesday);

		objectOutput.writeBoolean(thursday);

		objectOutput.writeBoolean(friday);

		objectOutput.writeBoolean(saturday);

		objectOutput.writeBoolean(sunday);
		objectOutput.writeLong(start_date);
		objectOutput.writeLong(end_date);
	}

	public String uuid;
	public long id;
	public String service_id;
	public boolean monday;
	public boolean tuesday;
	public boolean wednesday;
	public boolean thursday;
	public boolean friday;
	public boolean saturday;
	public boolean sunday;
	public long start_date;
	public long end_date;

}