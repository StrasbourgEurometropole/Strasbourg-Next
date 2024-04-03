/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.gtfs.model.Agency;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Agency in entity cache.
 *
 * @author Cedric Henry
 * @generated
 */
public class AgencyCacheModel implements CacheModel<Agency>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AgencyCacheModel)) {
			return false;
		}

		AgencyCacheModel agencyCacheModel = (AgencyCacheModel)object;

		if (id == agencyCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", id=");
		sb.append(id);
		sb.append(", agency_name=");
		sb.append(agency_name);
		sb.append(", agency_url=");
		sb.append(agency_url);
		sb.append(", agency_timezone=");
		sb.append(agency_timezone);
		sb.append(", agency_phone=");
		sb.append(agency_phone);
		sb.append(", agency_fare_url=");
		sb.append(agency_fare_url);
		sb.append(", agency_lang=");
		sb.append(agency_lang);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Agency toEntityModel() {
		AgencyImpl agencyImpl = new AgencyImpl();

		if (uuid == null) {
			agencyImpl.setUuid("");
		}
		else {
			agencyImpl.setUuid(uuid);
		}

		agencyImpl.setId(id);

		if (agency_name == null) {
			agencyImpl.setAgency_name("");
		}
		else {
			agencyImpl.setAgency_name(agency_name);
		}

		if (agency_url == null) {
			agencyImpl.setAgency_url("");
		}
		else {
			agencyImpl.setAgency_url(agency_url);
		}

		if (agency_timezone == null) {
			agencyImpl.setAgency_timezone("");
		}
		else {
			agencyImpl.setAgency_timezone(agency_timezone);
		}

		if (agency_phone == null) {
			agencyImpl.setAgency_phone("");
		}
		else {
			agencyImpl.setAgency_phone(agency_phone);
		}

		if (agency_fare_url == null) {
			agencyImpl.setAgency_fare_url("");
		}
		else {
			agencyImpl.setAgency_fare_url(agency_fare_url);
		}

		if (agency_lang == null) {
			agencyImpl.setAgency_lang("");
		}
		else {
			agencyImpl.setAgency_lang(agency_lang);
		}

		agencyImpl.resetOriginalValues();

		return agencyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		id = objectInput.readLong();
		agency_name = objectInput.readUTF();
		agency_url = objectInput.readUTF();
		agency_timezone = objectInput.readUTF();
		agency_phone = objectInput.readUTF();
		agency_fare_url = objectInput.readUTF();
		agency_lang = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(id);

		if (agency_name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(agency_name);
		}

		if (agency_url == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(agency_url);
		}

		if (agency_timezone == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(agency_timezone);
		}

		if (agency_phone == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(agency_phone);
		}

		if (agency_fare_url == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(agency_fare_url);
		}

		if (agency_lang == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(agency_lang);
		}
	}

	public String uuid;
	public long id;
	public String agency_name;
	public String agency_url;
	public String agency_timezone;
	public String agency_phone;
	public String agency_fare_url;
	public String agency_lang;

}