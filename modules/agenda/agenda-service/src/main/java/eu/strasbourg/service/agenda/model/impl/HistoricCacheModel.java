/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.agenda.model.Historic;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Historic in entity cache.
 *
 * @author BenjaminBini
 * @generated
 */
public class HistoricCacheModel
	implements CacheModel<Historic>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof HistoricCacheModel)) {
			return false;
		}

		HistoricCacheModel historicCacheModel = (HistoricCacheModel)object;

		if (eventId == historicCacheModel.eventId) {
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
		StringBundler sb = new StringBundler(9);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", eventId=");
		sb.append(eventId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", suppressionDate=");
		sb.append(suppressionDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Historic toEntityModel() {
		HistoricImpl historicImpl = new HistoricImpl();

		if (uuid == null) {
			historicImpl.setUuid("");
		}
		else {
			historicImpl.setUuid(uuid);
		}

		historicImpl.setEventId(eventId);

		if (title == null) {
			historicImpl.setTitle("");
		}
		else {
			historicImpl.setTitle(title);
		}

		if (suppressionDate == Long.MIN_VALUE) {
			historicImpl.setSuppressionDate(null);
		}
		else {
			historicImpl.setSuppressionDate(new Date(suppressionDate));
		}

		historicImpl.resetOriginalValues();

		return historicImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		eventId = objectInput.readLong();
		title = objectInput.readUTF();
		suppressionDate = objectInput.readLong();
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

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		objectOutput.writeLong(suppressionDate);
	}

	public String uuid;
	public long eventId;
	public String title;
	public long suppressionDate;

}