/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.agenda.model.CsmapCacheJson;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CsmapCacheJson in entity cache.
 *
 * @author BenjaminBini
 * @generated
 */
public class CsmapCacheJsonCacheModel
	implements CacheModel<CsmapCacheJson>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CsmapCacheJsonCacheModel)) {
			return false;
		}

		CsmapCacheJsonCacheModel csmapCacheJsonCacheModel =
			(CsmapCacheJsonCacheModel)object;

		if (eventId == csmapCacheJsonCacheModel.eventId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, eventId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", eventId=");
		sb.append(eventId);
		sb.append(", jsonEvent=");
		sb.append(jsonEvent);
		sb.append(", createEvent=");
		sb.append(createEvent);
		sb.append(", modifiedEvent=");
		sb.append(modifiedEvent);
		sb.append(", isActive=");
		sb.append(isActive);
		sb.append(", regeneratedDate=");
		sb.append(regeneratedDate);
		sb.append(", hasSchedules=");
		sb.append(hasSchedules);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CsmapCacheJson toEntityModel() {
		CsmapCacheJsonImpl csmapCacheJsonImpl = new CsmapCacheJsonImpl();

		if (uuid == null) {
			csmapCacheJsonImpl.setUuid("");
		}
		else {
			csmapCacheJsonImpl.setUuid(uuid);
		}

		csmapCacheJsonImpl.setEventId(eventId);

		if (jsonEvent == null) {
			csmapCacheJsonImpl.setJsonEvent("");
		}
		else {
			csmapCacheJsonImpl.setJsonEvent(jsonEvent);
		}

		if (createEvent == Long.MIN_VALUE) {
			csmapCacheJsonImpl.setCreateEvent(null);
		}
		else {
			csmapCacheJsonImpl.setCreateEvent(new Date(createEvent));
		}

		if (modifiedEvent == Long.MIN_VALUE) {
			csmapCacheJsonImpl.setModifiedEvent(null);
		}
		else {
			csmapCacheJsonImpl.setModifiedEvent(new Date(modifiedEvent));
		}

		csmapCacheJsonImpl.setIsActive(isActive);

		if (regeneratedDate == Long.MIN_VALUE) {
			csmapCacheJsonImpl.setRegeneratedDate(null);
		}
		else {
			csmapCacheJsonImpl.setRegeneratedDate(new Date(regeneratedDate));
		}

		csmapCacheJsonImpl.setHasSchedules(hasSchedules);

		csmapCacheJsonImpl.resetOriginalValues();

		return csmapCacheJsonImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		uuid = objectInput.readUTF();

		eventId = objectInput.readLong();
		jsonEvent = (String)objectInput.readObject();
		createEvent = objectInput.readLong();
		modifiedEvent = objectInput.readLong();

		isActive = objectInput.readBoolean();
		regeneratedDate = objectInput.readLong();

		hasSchedules = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(eventId);

		if (jsonEvent == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(jsonEvent);
		}

		objectOutput.writeLong(createEvent);
		objectOutput.writeLong(modifiedEvent);

		objectOutput.writeBoolean(isActive);
		objectOutput.writeLong(regeneratedDate);

		objectOutput.writeBoolean(hasSchedules);
	}

	public String uuid;
	public long eventId;
	public String jsonEvent;
	public long createEvent;
	public long modifiedEvent;
	public boolean isActive;
	public long regeneratedDate;
	public boolean hasSchedules;

}