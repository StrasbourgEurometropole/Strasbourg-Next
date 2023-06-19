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

import eu.strasbourg.service.gtfs.model.Arret;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Arret in entity cache.
 *
 * @author Cedric Henry
 * @generated
 */
public class ArretCacheModel implements CacheModel<Arret>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ArretCacheModel)) {
			return false;
		}

		ArretCacheModel arretCacheModel = (ArretCacheModel)object;

		if (arretId == arretCacheModel.arretId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, arretId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", arretId=");
		sb.append(arretId);
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
		sb.append(", stopId=");
		sb.append(stopId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", code=");
		sb.append(code);
		sb.append(", latitude=");
		sb.append(latitude);
		sb.append(", longitude=");
		sb.append(longitude);
		sb.append(", type=");
		sb.append(type);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Arret toEntityModel() {
		ArretImpl arretImpl = new ArretImpl();

		if (uuid == null) {
			arretImpl.setUuid("");
		}
		else {
			arretImpl.setUuid(uuid);
		}

		arretImpl.setArretId(arretId);
		arretImpl.setGroupId(groupId);
		arretImpl.setCompanyId(companyId);
		arretImpl.setUserId(userId);

		if (userName == null) {
			arretImpl.setUserName("");
		}
		else {
			arretImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			arretImpl.setCreateDate(null);
		}
		else {
			arretImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			arretImpl.setModifiedDate(null);
		}
		else {
			arretImpl.setModifiedDate(new Date(modifiedDate));
		}

		arretImpl.setStatus(status);
		arretImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			arretImpl.setStatusByUserName("");
		}
		else {
			arretImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			arretImpl.setStatusDate(null);
		}
		else {
			arretImpl.setStatusDate(new Date(statusDate));
		}

		if (stopId == null) {
			arretImpl.setStopId("");
		}
		else {
			arretImpl.setStopId(stopId);
		}

		if (title == null) {
			arretImpl.setTitle("");
		}
		else {
			arretImpl.setTitle(title);
		}

		if (code == null) {
			arretImpl.setCode("");
		}
		else {
			arretImpl.setCode(code);
		}

		if (latitude == null) {
			arretImpl.setLatitude("");
		}
		else {
			arretImpl.setLatitude(latitude);
		}

		if (longitude == null) {
			arretImpl.setLongitude("");
		}
		else {
			arretImpl.setLongitude(longitude);
		}

		arretImpl.setType(type);

		arretImpl.resetOriginalValues();

		return arretImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		arretId = objectInput.readLong();

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
		stopId = objectInput.readUTF();
		title = objectInput.readUTF();
		code = objectInput.readUTF();
		latitude = objectInput.readUTF();
		longitude = objectInput.readUTF();

		type = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(arretId);

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

		if (stopId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(stopId);
		}

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (code == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(code);
		}

		if (latitude == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(latitude);
		}

		if (longitude == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(longitude);
		}

		objectOutput.writeInt(type);
	}

	public String uuid;
	public long arretId;
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
	public String stopId;
	public String title;
	public String code;
	public String latitude;
	public String longitude;
	public int type;

}