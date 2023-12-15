/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.place.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.place.model.CsmapCacheJson;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CsmapCacheJson in entity cache.
 *
 * @author Angelique Zunino Champougny
 * @generated
 */
public class CsmapCacheJsonCacheModel
	implements CacheModel<CsmapCacheJson>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CsmapCacheJsonCacheModel)) {
			return false;
		}

		CsmapCacheJsonCacheModel csmapCacheJsonCacheModel =
			(CsmapCacheJsonCacheModel)object;

		if (sigId.equals(csmapCacheJsonCacheModel.sigId)) {
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
		StringBundler sb = new StringBundler(15);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", sigId=");
		sb.append(sigId);
		sb.append(", jsonLieu=");
		sb.append(jsonLieu);
		sb.append(", jsonHoraire=");
		sb.append(jsonHoraire);
		sb.append(", createPlace=");
		sb.append(createPlace);
		sb.append(", modifiedPlace=");
		sb.append(modifiedPlace);
		sb.append(", isActive=");
		sb.append(isActive);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CsmapCacheJson toEntityModel() {
		CsmapCacheJsonImpl csmapCacheJsonImpl = new CsmapCacheJsonImpl();

		if (uuid == null) {
			csmapCacheJsonImpl.setUuid("");
		}
		else {
			csmapCacheJsonImpl.setUuid(uuid);
		}

		if (sigId == null) {
			csmapCacheJsonImpl.setSigId("");
		}
		else {
			csmapCacheJsonImpl.setSigId(sigId);
		}

		if (jsonLieu == null) {
			csmapCacheJsonImpl.setJsonLieu("");
		}
		else {
			csmapCacheJsonImpl.setJsonLieu(jsonLieu);
		}

		if (jsonHoraire == null) {
			csmapCacheJsonImpl.setJsonHoraire("");
		}
		else {
			csmapCacheJsonImpl.setJsonHoraire(jsonHoraire);
		}

		if (createPlace == Long.MIN_VALUE) {
			csmapCacheJsonImpl.setCreatePlace(null);
		}
		else {
			csmapCacheJsonImpl.setCreatePlace(new Date(createPlace));
		}

		if (modifiedPlace == Long.MIN_VALUE) {
			csmapCacheJsonImpl.setModifiedPlace(null);
		}
		else {
			csmapCacheJsonImpl.setModifiedPlace(new Date(modifiedPlace));
		}

		csmapCacheJsonImpl.setIsActive(isActive);

		csmapCacheJsonImpl.resetOriginalValues();

		return csmapCacheJsonImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		uuid = objectInput.readUTF();
		sigId = objectInput.readUTF();
		jsonLieu = (String)objectInput.readObject();
		jsonHoraire = (String)objectInput.readObject();
		createPlace = objectInput.readLong();
		modifiedPlace = objectInput.readLong();

		isActive = objectInput.readBoolean();
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

		if (jsonLieu == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(jsonLieu);
		}

		if (jsonHoraire == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(jsonHoraire);
		}

		objectOutput.writeLong(createPlace);
		objectOutput.writeLong(modifiedPlace);

		objectOutput.writeBoolean(isActive);
	}

	public String uuid;
	public String sigId;
	public String jsonLieu;
	public String jsonHoraire;
	public long createPlace;
	public long modifiedPlace;
	public boolean isActive;

}