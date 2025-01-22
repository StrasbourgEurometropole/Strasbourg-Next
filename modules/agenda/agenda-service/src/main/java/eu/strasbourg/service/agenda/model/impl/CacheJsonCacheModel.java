/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.agenda.model.CacheJson;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CacheJson in entity cache.
 *
 * @author BenjaminBini
 * @generated
 */
public class CacheJsonCacheModel
	implements CacheModel<CacheJson>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CacheJsonCacheModel)) {
			return false;
		}

		CacheJsonCacheModel cacheJsonCacheModel = (CacheJsonCacheModel)object;

		if (eventId == cacheJsonCacheModel.eventId) {
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
		StringBundler sb = new StringBundler(13);

		sb.append("{eventId=");
		sb.append(eventId);
		sb.append(", jsonEvent=");
		sb.append(jsonEvent);
		sb.append(", jsonEventLegacy=");
		sb.append(jsonEventLegacy);
		sb.append(", createEvent=");
		sb.append(createEvent);
		sb.append(", modifiedEvent=");
		sb.append(modifiedEvent);
		sb.append(", isApproved=");
		sb.append(isApproved);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CacheJson toEntityModel() {
		CacheJsonImpl cacheJsonImpl = new CacheJsonImpl();

		cacheJsonImpl.setEventId(eventId);

		if (jsonEvent == null) {
			cacheJsonImpl.setJsonEvent("");
		}
		else {
			cacheJsonImpl.setJsonEvent(jsonEvent);
		}

		if (jsonEventLegacy == null) {
			cacheJsonImpl.setJsonEventLegacy("");
		}
		else {
			cacheJsonImpl.setJsonEventLegacy(jsonEventLegacy);
		}

		if (createEvent == Long.MIN_VALUE) {
			cacheJsonImpl.setCreateEvent(null);
		}
		else {
			cacheJsonImpl.setCreateEvent(new Date(createEvent));
		}

		if (modifiedEvent == Long.MIN_VALUE) {
			cacheJsonImpl.setModifiedEvent(null);
		}
		else {
			cacheJsonImpl.setModifiedEvent(new Date(modifiedEvent));
		}

		cacheJsonImpl.setIsApproved(isApproved);

		cacheJsonImpl.resetOriginalValues();

		return cacheJsonImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		eventId = objectInput.readLong();
		jsonEvent = (String)objectInput.readObject();
		jsonEventLegacy = (String)objectInput.readObject();
		createEvent = objectInput.readLong();
		modifiedEvent = objectInput.readLong();

		isApproved = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(eventId);

		if (jsonEvent == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(jsonEvent);
		}

		if (jsonEventLegacy == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(jsonEventLegacy);
		}

		objectOutput.writeLong(createEvent);
		objectOutput.writeLong(modifiedEvent);

		objectOutput.writeBoolean(isApproved);
	}

	public long eventId;
	public String jsonEvent;
	public String jsonEventLegacy;
	public long createEvent;
	public long modifiedEvent;
	public boolean isApproved;

}