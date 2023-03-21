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

package eu.strasbourg.service.gtfs.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import eu.strasbourg.service.gtfs.model.ImportHistoric;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Date;

/**
 * The cache model class for representing ImportHistoric in entity cache.
 *
 * @author Cedric Henry
 * @generated
 */
public class ImportHistoricCacheModel
	implements CacheModel<ImportHistoric>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ImportHistoricCacheModel)) {
			return false;
		}

		ImportHistoricCacheModel importHistoricCacheModel =
			(ImportHistoricCacheModel)object;

		if (importHistoricId == importHistoricCacheModel.importHistoricId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, importHistoricId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", importHistoricId=");
		sb.append(importHistoricId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", result=");
		sb.append(result);
		sb.append(", operations=");
		sb.append(operations);
		sb.append(", errorDescription=");
		sb.append(errorDescription);
		sb.append(", errorStackTrace=");
		sb.append(errorStackTrace);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", finishDate=");
		sb.append(finishDate);
		sb.append(", gtfsFileHash=");
		sb.append(gtfsFileHash);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ImportHistoric toEntityModel() {
		ImportHistoricImpl importHistoricImpl = new ImportHistoricImpl();

		if (uuid == null) {
			importHistoricImpl.setUuid("");
		}
		else {
			importHistoricImpl.setUuid(uuid);
		}

		importHistoricImpl.setImportHistoricId(importHistoricId);
		importHistoricImpl.setGroupId(groupId);
		importHistoricImpl.setCompanyId(companyId);
		importHistoricImpl.setUserId(userId);

		if (userName == null) {
			importHistoricImpl.setUserName("");
		}
		else {
			importHistoricImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			importHistoricImpl.setCreateDate(null);
		}
		else {
			importHistoricImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			importHistoricImpl.setModifiedDate(null);
		}
		else {
			importHistoricImpl.setModifiedDate(new Date(modifiedDate));
		}

		importHistoricImpl.setStatus(status);
		importHistoricImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			importHistoricImpl.setStatusByUserName("");
		}
		else {
			importHistoricImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			importHistoricImpl.setStatusDate(null);
		}
		else {
			importHistoricImpl.setStatusDate(new Date(statusDate));
		}

		importHistoricImpl.setResult(result);

		if (operations == null) {
			importHistoricImpl.setOperations("");
		}
		else {
			importHistoricImpl.setOperations(operations);
		}

		if (errorDescription == null) {
			importHistoricImpl.setErrorDescription("");
		}
		else {
			importHistoricImpl.setErrorDescription(errorDescription);
		}

		if (errorStackTrace == null) {
			importHistoricImpl.setErrorStackTrace("");
		}
		else {
			importHistoricImpl.setErrorStackTrace(errorStackTrace);
		}

		if (startDate == Long.MIN_VALUE) {
			importHistoricImpl.setStartDate(null);
		}
		else {
			importHistoricImpl.setStartDate(new Date(startDate));
		}

		if (finishDate == Long.MIN_VALUE) {
			importHistoricImpl.setFinishDate(null);
		}
		else {
			importHistoricImpl.setFinishDate(new Date(finishDate));
		}

		if (gtfsFileHash == null) {
			importHistoricImpl.setGtfsFileHash("");
		}
		else {
			importHistoricImpl.setGtfsFileHash(gtfsFileHash);
		}

		importHistoricImpl.resetOriginalValues();

		return importHistoricImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		uuid = objectInput.readUTF();

		importHistoricId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();

		result = objectInput.readInt();
		operations = (String)objectInput.readObject();
		errorDescription = (String)objectInput.readObject();
		errorStackTrace = (String)objectInput.readObject();
		startDate = objectInput.readLong();
		finishDate = objectInput.readLong();
		gtfsFileHash = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(importHistoricId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);

		objectOutput.writeInt(result);

		if (operations == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(operations);
		}

		if (errorDescription == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(errorDescription);
		}

		if (errorStackTrace == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(errorStackTrace);
		}

		objectOutput.writeLong(startDate);
		objectOutput.writeLong(finishDate);

		if (gtfsFileHash == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(gtfsFileHash);
		}
	}

	public String uuid;
	public long importHistoricId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public int result;
	public String operations;
	public String errorDescription;
	public String errorStackTrace;
	public long startDate;
	public long finishDate;
	public String gtfsFileHash;

}