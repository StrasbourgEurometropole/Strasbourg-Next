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

import eu.strasbourg.service.gtfs.model.CacheHoursJSON;
import eu.strasbourg.service.gtfs.service.persistence.CacheHoursJSONPK;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CacheHoursJSON in entity cache.
 *
 * @author Cedric Henry
 * @generated
 */
public class CacheHoursJSONCacheModel
	implements CacheModel<CacheHoursJSON>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CacheHoursJSONCacheModel)) {
			return false;
		}

		CacheHoursJSONCacheModel cacheHoursJSONCacheModel =
			(CacheHoursJSONCacheModel)object;

		if (cacheHoursJSONPK.equals(
				cacheHoursJSONCacheModel.cacheHoursJSONPK)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, cacheHoursJSONPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", stopCode=");
		sb.append(stopCode);
		sb.append(", type=");
		sb.append(type);
		sb.append(", jsonHour=");
		sb.append(jsonHour);
		sb.append(", creationDate=");
		sb.append(creationDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CacheHoursJSON toEntityModel() {
		CacheHoursJSONImpl cacheHoursJSONImpl = new CacheHoursJSONImpl();

		if (uuid == null) {
			cacheHoursJSONImpl.setUuid("");
		}
		else {
			cacheHoursJSONImpl.setUuid(uuid);
		}

		if (stopCode == null) {
			cacheHoursJSONImpl.setStopCode("");
		}
		else {
			cacheHoursJSONImpl.setStopCode(stopCode);
		}

		cacheHoursJSONImpl.setType(type);

		if (jsonHour == null) {
			cacheHoursJSONImpl.setJsonHour("");
		}
		else {
			cacheHoursJSONImpl.setJsonHour(jsonHour);
		}

		if (creationDate == Long.MIN_VALUE) {
			cacheHoursJSONImpl.setCreationDate(null);
		}
		else {
			cacheHoursJSONImpl.setCreationDate(new Date(creationDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			cacheHoursJSONImpl.setModifiedDate(null);
		}
		else {
			cacheHoursJSONImpl.setModifiedDate(new Date(modifiedDate));
		}

		cacheHoursJSONImpl.resetOriginalValues();

		return cacheHoursJSONImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		uuid = objectInput.readUTF();
		stopCode = objectInput.readUTF();

		type = objectInput.readInt();
		jsonHour = (String)objectInput.readObject();
		creationDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		cacheHoursJSONPK = new CacheHoursJSONPK(stopCode, type);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		if (stopCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(stopCode);
		}

		objectOutput.writeInt(type);

		if (jsonHour == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(jsonHour);
		}

		objectOutput.writeLong(creationDate);
		objectOutput.writeLong(modifiedDate);
	}

	public String uuid;
	public String stopCode;
	public int type;
	public String jsonHour;
	public long creationDate;
	public long modifiedDate;
	public transient CacheHoursJSONPK cacheHoursJSONPK;

}