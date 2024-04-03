/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.agenda.model.AgendaExportPeriod;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AgendaExportPeriod in entity cache.
 *
 * @author BenjaminBini
 * @generated
 */
public class AgendaExportPeriodCacheModel
	implements CacheModel<AgendaExportPeriod>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AgendaExportPeriodCacheModel)) {
			return false;
		}

		AgendaExportPeriodCacheModel agendaExportPeriodCacheModel =
			(AgendaExportPeriodCacheModel)object;

		if (agendaExportPeriodId ==
				agendaExportPeriodCacheModel.agendaExportPeriodId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, agendaExportPeriodId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", agendaExportPeriodId=");
		sb.append(agendaExportPeriodId);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", agendaExportId=");
		sb.append(agendaExportId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AgendaExportPeriod toEntityModel() {
		AgendaExportPeriodImpl agendaExportPeriodImpl =
			new AgendaExportPeriodImpl();

		if (uuid == null) {
			agendaExportPeriodImpl.setUuid("");
		}
		else {
			agendaExportPeriodImpl.setUuid(uuid);
		}

		agendaExportPeriodImpl.setAgendaExportPeriodId(agendaExportPeriodId);

		if (startDate == Long.MIN_VALUE) {
			agendaExportPeriodImpl.setStartDate(null);
		}
		else {
			agendaExportPeriodImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			agendaExportPeriodImpl.setEndDate(null);
		}
		else {
			agendaExportPeriodImpl.setEndDate(new Date(endDate));
		}

		agendaExportPeriodImpl.setAgendaExportId(agendaExportId);

		agendaExportPeriodImpl.resetOriginalValues();

		return agendaExportPeriodImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		agendaExportPeriodId = objectInput.readLong();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();

		agendaExportId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(agendaExportPeriodId);
		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);

		objectOutput.writeLong(agendaExportId);
	}

	public String uuid;
	public long agendaExportPeriodId;
	public long startDate;
	public long endDate;
	public long agendaExportId;

}