/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.agenda.model.ImportReportLine;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ImportReportLine in entity cache.
 *
 * @author BenjaminBini
 * @generated
 */
public class ImportReportLineCacheModel
	implements CacheModel<ImportReportLine>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ImportReportLineCacheModel)) {
			return false;
		}

		ImportReportLineCacheModel importReportLineCacheModel =
			(ImportReportLineCacheModel)object;

		if (lineId == importReportLineCacheModel.lineId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, lineId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", lineId=");
		sb.append(lineId);
		sb.append(", type=");
		sb.append(type);
		sb.append(", status=");
		sb.append(status);
		sb.append(", log=");
		sb.append(log);
		sb.append(", entityName=");
		sb.append(entityName);
		sb.append(", entityExternalId=");
		sb.append(entityExternalId);
		sb.append(", entityId=");
		sb.append(entityId);
		sb.append(", reportId=");
		sb.append(reportId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ImportReportLine toEntityModel() {
		ImportReportLineImpl importReportLineImpl = new ImportReportLineImpl();

		if (uuid == null) {
			importReportLineImpl.setUuid("");
		}
		else {
			importReportLineImpl.setUuid(uuid);
		}

		importReportLineImpl.setLineId(lineId);

		if (type == null) {
			importReportLineImpl.setType("");
		}
		else {
			importReportLineImpl.setType(type);
		}

		importReportLineImpl.setStatus(status);

		if (log == null) {
			importReportLineImpl.setLog("");
		}
		else {
			importReportLineImpl.setLog(log);
		}

		if (entityName == null) {
			importReportLineImpl.setEntityName("");
		}
		else {
			importReportLineImpl.setEntityName(entityName);
		}

		if (entityExternalId == null) {
			importReportLineImpl.setEntityExternalId("");
		}
		else {
			importReportLineImpl.setEntityExternalId(entityExternalId);
		}

		importReportLineImpl.setEntityId(entityId);
		importReportLineImpl.setReportId(reportId);

		importReportLineImpl.resetOriginalValues();

		return importReportLineImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		uuid = objectInput.readUTF();

		lineId = objectInput.readLong();
		type = objectInput.readUTF();

		status = objectInput.readLong();
		log = (String)objectInput.readObject();
		entityName = objectInput.readUTF();
		entityExternalId = objectInput.readUTF();

		entityId = objectInput.readLong();

		reportId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(lineId);

		if (type == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(type);
		}

		objectOutput.writeLong(status);

		if (log == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(log);
		}

		if (entityName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(entityName);
		}

		if (entityExternalId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(entityExternalId);
		}

		objectOutput.writeLong(entityId);

		objectOutput.writeLong(reportId);
	}

	public String uuid;
	public long lineId;
	public String type;
	public long status;
	public String log;
	public String entityName;
	public String entityExternalId;
	public long entityId;
	public long reportId;

}