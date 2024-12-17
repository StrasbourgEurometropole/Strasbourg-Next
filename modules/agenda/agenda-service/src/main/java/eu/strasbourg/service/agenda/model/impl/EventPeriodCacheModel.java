/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.agenda.model.EventPeriod;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EventPeriod in entity cache.
 *
 * @author BenjaminBini
 * @generated
 */
public class EventPeriodCacheModel
	implements CacheModel<EventPeriod>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EventPeriodCacheModel)) {
			return false;
		}

		EventPeriodCacheModel eventPeriodCacheModel =
			(EventPeriodCacheModel)object;

		if (eventPeriodId == eventPeriodCacheModel.eventPeriodId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, eventPeriodId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", eventPeriodId=");
		sb.append(eventPeriodId);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", startTime=");
		sb.append(startTime);
		sb.append(", endTime=");
		sb.append(endTime);
		sb.append(", isRecurrent=");
		sb.append(isRecurrent);
		sb.append(", timeDetail=");
		sb.append(timeDetail);
		sb.append(", eventId=");
		sb.append(eventId);
		sb.append(", campaignEventId=");
		sb.append(campaignEventId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EventPeriod toEntityModel() {
		EventPeriodImpl eventPeriodImpl = new EventPeriodImpl();

		if (uuid == null) {
			eventPeriodImpl.setUuid("");
		}
		else {
			eventPeriodImpl.setUuid(uuid);
		}

		eventPeriodImpl.setEventPeriodId(eventPeriodId);

		if (startDate == Long.MIN_VALUE) {
			eventPeriodImpl.setStartDate(null);
		}
		else {
			eventPeriodImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			eventPeriodImpl.setEndDate(null);
		}
		else {
			eventPeriodImpl.setEndDate(new Date(endDate));
		}

		if (startTime == null) {
			eventPeriodImpl.setStartTime("");
		}
		else {
			eventPeriodImpl.setStartTime(startTime);
		}

		if (endTime == null) {
			eventPeriodImpl.setEndTime("");
		}
		else {
			eventPeriodImpl.setEndTime(endTime);
		}

		eventPeriodImpl.setIsRecurrent(isRecurrent);

		if (timeDetail == null) {
			eventPeriodImpl.setTimeDetail("");
		}
		else {
			eventPeriodImpl.setTimeDetail(timeDetail);
		}

		eventPeriodImpl.setEventId(eventId);
		eventPeriodImpl.setCampaignEventId(campaignEventId);

		eventPeriodImpl.resetOriginalValues();

		return eventPeriodImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		eventPeriodId = objectInput.readLong();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
		startTime = objectInput.readUTF();
		endTime = objectInput.readUTF();

		isRecurrent = objectInput.readBoolean();
		timeDetail = objectInput.readUTF();

		eventId = objectInput.readLong();

		campaignEventId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(eventPeriodId);
		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);

		if (startTime == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(startTime);
		}

		if (endTime == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(endTime);
		}

		objectOutput.writeBoolean(isRecurrent);

		if (timeDetail == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(timeDetail);
		}

		objectOutput.writeLong(eventId);

		objectOutput.writeLong(campaignEventId);
	}

	public String uuid;
	public long eventPeriodId;
	public long startDate;
	public long endDate;
	public String startTime;
	public String endTime;
	public boolean isRecurrent;
	public String timeDetail;
	public long eventId;
	public long campaignEventId;

}