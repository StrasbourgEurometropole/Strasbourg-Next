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

package eu.strasbourg.service.place.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.place.model.Slot;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Slot in entity cache.
 *
 * @author Angelique Zunino Champougny
 * @generated
 */
public class SlotCacheModel implements CacheModel<Slot>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SlotCacheModel)) {
			return false;
		}

		SlotCacheModel slotCacheModel = (SlotCacheModel)object;

		if (slotId == slotCacheModel.slotId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, slotId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", slotId=");
		sb.append(slotId);
		sb.append(", dayOfWeek=");
		sb.append(dayOfWeek);
		sb.append(", startHour=");
		sb.append(startHour);
		sb.append(", endHour=");
		sb.append(endHour);
		sb.append(", comment=");
		sb.append(comment);
		sb.append(", periodId=");
		sb.append(periodId);
		sb.append(", subPlaceId=");
		sb.append(subPlaceId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Slot toEntityModel() {
		SlotImpl slotImpl = new SlotImpl();

		if (uuid == null) {
			slotImpl.setUuid("");
		}
		else {
			slotImpl.setUuid(uuid);
		}

		slotImpl.setSlotId(slotId);
		slotImpl.setDayOfWeek(dayOfWeek);

		if (startHour == null) {
			slotImpl.setStartHour("");
		}
		else {
			slotImpl.setStartHour(startHour);
		}

		if (endHour == null) {
			slotImpl.setEndHour("");
		}
		else {
			slotImpl.setEndHour(endHour);
		}

		if (comment == null) {
			slotImpl.setComment("");
		}
		else {
			slotImpl.setComment(comment);
		}

		slotImpl.setPeriodId(periodId);
		slotImpl.setSubPlaceId(subPlaceId);

		slotImpl.resetOriginalValues();

		return slotImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		slotId = objectInput.readLong();

		dayOfWeek = objectInput.readLong();
		startHour = objectInput.readUTF();
		endHour = objectInput.readUTF();
		comment = objectInput.readUTF();

		periodId = objectInput.readLong();

		subPlaceId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(slotId);

		objectOutput.writeLong(dayOfWeek);

		if (startHour == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(startHour);
		}

		if (endHour == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(endHour);
		}

		if (comment == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(comment);
		}

		objectOutput.writeLong(periodId);

		objectOutput.writeLong(subPlaceId);
	}

	public String uuid;
	public long slotId;
	public long dayOfWeek;
	public String startHour;
	public String endHour;
	public String comment;
	public long periodId;
	public long subPlaceId;

}