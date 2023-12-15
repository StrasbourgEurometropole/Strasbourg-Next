/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.place.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.place.model.Period;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Period in entity cache.
 *
 * @author Angelique Zunino Champougny
 * @generated
 */
public class PeriodCacheModel implements CacheModel<Period>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PeriodCacheModel)) {
			return false;
		}

		PeriodCacheModel periodCacheModel = (PeriodCacheModel)object;

		if (periodId == periodCacheModel.periodId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, periodId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", periodId=");
		sb.append(periodId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", defaultPeriod=");
		sb.append(defaultPeriod);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", alwaysOpen=");
		sb.append(alwaysOpen);
		sb.append(", RTGreenThreshold=");
		sb.append(RTGreenThreshold);
		sb.append(", RTOrangeThreshold=");
		sb.append(RTOrangeThreshold);
		sb.append(", RTRedThreshold=");
		sb.append(RTRedThreshold);
		sb.append(", RTMaxThreshold=");
		sb.append(RTMaxThreshold);
		sb.append(", placeId=");
		sb.append(placeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Period toEntityModel() {
		PeriodImpl periodImpl = new PeriodImpl();

		if (uuid == null) {
			periodImpl.setUuid("");
		}
		else {
			periodImpl.setUuid(uuid);
		}

		periodImpl.setPeriodId(periodId);

		if (name == null) {
			periodImpl.setName("");
		}
		else {
			periodImpl.setName(name);
		}

		periodImpl.setDefaultPeriod(defaultPeriod);

		if (startDate == Long.MIN_VALUE) {
			periodImpl.setStartDate(null);
		}
		else {
			periodImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			periodImpl.setEndDate(null);
		}
		else {
			periodImpl.setEndDate(new Date(endDate));
		}

		periodImpl.setAlwaysOpen(alwaysOpen);
		periodImpl.setRTGreenThreshold(RTGreenThreshold);
		periodImpl.setRTOrangeThreshold(RTOrangeThreshold);
		periodImpl.setRTRedThreshold(RTRedThreshold);
		periodImpl.setRTMaxThreshold(RTMaxThreshold);
		periodImpl.setPlaceId(placeId);

		periodImpl.resetOriginalValues();

		return periodImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		periodId = objectInput.readLong();
		name = objectInput.readUTF();

		defaultPeriod = objectInput.readBoolean();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();

		alwaysOpen = objectInput.readBoolean();

		RTGreenThreshold = objectInput.readLong();

		RTOrangeThreshold = objectInput.readLong();

		RTRedThreshold = objectInput.readLong();

		RTMaxThreshold = objectInput.readLong();

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

		objectOutput.writeLong(periodId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeBoolean(defaultPeriod);
		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);

		objectOutput.writeBoolean(alwaysOpen);

		objectOutput.writeLong(RTGreenThreshold);

		objectOutput.writeLong(RTOrangeThreshold);

		objectOutput.writeLong(RTRedThreshold);

		objectOutput.writeLong(RTMaxThreshold);

		objectOutput.writeLong(placeId);
	}

	public String uuid;
	public long periodId;
	public String name;
	public boolean defaultPeriod;
	public long startDate;
	public long endDate;
	public boolean alwaysOpen;
	public long RTGreenThreshold;
	public long RTOrangeThreshold;
	public long RTRedThreshold;
	public long RTMaxThreshold;
	public long placeId;

}