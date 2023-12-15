/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.gtfs.model.CacheAlertJSON;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CacheAlertJSON in entity cache.
 *
 * @author Cedric Henry
 * @generated
 */
public class CacheAlertJSONCacheModel
	implements CacheModel<CacheAlertJSON>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CacheAlertJSONCacheModel)) {
			return false;
		}

		CacheAlertJSONCacheModel cacheAlertJSONCacheModel =
			(CacheAlertJSONCacheModel)object;

		if (cacheId == cacheAlertJSONCacheModel.cacheId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, cacheId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", cacheId=");
		sb.append(cacheId);
		sb.append(", jsonAlert=");
		sb.append(jsonAlert);
		sb.append(", creationDate=");
		sb.append(creationDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CacheAlertJSON toEntityModel() {
		CacheAlertJSONImpl cacheAlertJSONImpl = new CacheAlertJSONImpl();

		if (uuid == null) {
			cacheAlertJSONImpl.setUuid("");
		}
		else {
			cacheAlertJSONImpl.setUuid(uuid);
		}

		cacheAlertJSONImpl.setCacheId(cacheId);

		if (jsonAlert == null) {
			cacheAlertJSONImpl.setJsonAlert("");
		}
		else {
			cacheAlertJSONImpl.setJsonAlert(jsonAlert);
		}

		if (creationDate == Long.MIN_VALUE) {
			cacheAlertJSONImpl.setCreationDate(null);
		}
		else {
			cacheAlertJSONImpl.setCreationDate(new Date(creationDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			cacheAlertJSONImpl.setModifiedDate(null);
		}
		else {
			cacheAlertJSONImpl.setModifiedDate(new Date(modifiedDate));
		}

		cacheAlertJSONImpl.resetOriginalValues();

		return cacheAlertJSONImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		uuid = objectInput.readUTF();

		cacheId = objectInput.readLong();
		jsonAlert = (String)objectInput.readObject();
		creationDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(cacheId);

		if (jsonAlert == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(jsonAlert);
		}

		objectOutput.writeLong(creationDate);
		objectOutput.writeLong(modifiedDate);
	}

	public String uuid;
	public long cacheId;
	public String jsonAlert;
	public long creationDate;
	public long modifiedDate;

}