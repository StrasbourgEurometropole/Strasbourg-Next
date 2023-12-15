/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.place.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.place.model.Historic;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Historic in entity cache.
 *
 * @author Angelique Zunino Champougny
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

		if (sigId.equals(historicCacheModel.sigId)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, sigId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", sigId=");
		sb.append(sigId);
		sb.append(", name=");
		sb.append(name);
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

		if (sigId == null) {
			historicImpl.setSigId("");
		}
		else {
			historicImpl.setSigId(sigId);
		}

		if (name == null) {
			historicImpl.setName("");
		}
		else {
			historicImpl.setName(name);
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
		sigId = objectInput.readUTF();
		name = objectInput.readUTF();
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

		if (sigId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sigId);
		}

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(suppressionDate);
	}

	public String uuid;
	public String sigId;
	public String name;
	public long suppressionDate;

}