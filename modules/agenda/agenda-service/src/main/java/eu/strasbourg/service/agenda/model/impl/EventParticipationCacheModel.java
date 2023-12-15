/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.agenda.model.EventParticipation;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EventParticipation in entity cache.
 *
 * @author BenjaminBini
 * @generated
 */
public class EventParticipationCacheModel
	implements CacheModel<EventParticipation>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EventParticipationCacheModel)) {
			return false;
		}

		EventParticipationCacheModel eventParticipationCacheModel =
			(EventParticipationCacheModel)object;

		if (eventParticipationId ==
				eventParticipationCacheModel.eventParticipationId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, eventParticipationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{eventParticipationId=");
		sb.append(eventParticipationId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", publikUserId=");
		sb.append(publikUserId);
		sb.append(", eventId=");
		sb.append(eventId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EventParticipation toEntityModel() {
		EventParticipationImpl eventParticipationImpl =
			new EventParticipationImpl();

		eventParticipationImpl.setEventParticipationId(eventParticipationId);

		if (createDate == Long.MIN_VALUE) {
			eventParticipationImpl.setCreateDate(null);
		}
		else {
			eventParticipationImpl.setCreateDate(new Date(createDate));
		}

		if (publikUserId == null) {
			eventParticipationImpl.setPublikUserId("");
		}
		else {
			eventParticipationImpl.setPublikUserId(publikUserId);
		}

		eventParticipationImpl.setEventId(eventId);
		eventParticipationImpl.setGroupId(groupId);

		eventParticipationImpl.resetOriginalValues();

		return eventParticipationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		eventParticipationId = objectInput.readLong();
		createDate = objectInput.readLong();
		publikUserId = objectInput.readUTF();

		eventId = objectInput.readLong();

		groupId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(eventParticipationId);
		objectOutput.writeLong(createDate);

		if (publikUserId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(publikUserId);
		}

		objectOutput.writeLong(eventId);

		objectOutput.writeLong(groupId);
	}

	public long eventParticipationId;
	public long createDate;
	public String publikUserId;
	public long eventId;
	public long groupId;

}