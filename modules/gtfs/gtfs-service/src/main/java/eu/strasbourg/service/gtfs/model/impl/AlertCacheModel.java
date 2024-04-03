/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.gtfs.model.Alert;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Alert in entity cache.
 *
 * @author Cedric Henry
 * @generated
 */
public class AlertCacheModel implements CacheModel<Alert>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AlertCacheModel)) {
			return false;
		}

		AlertCacheModel alertCacheModel = (AlertCacheModel)object;

		if (alertId == alertCacheModel.alertId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, alertId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", alertId=");
		sb.append(alertId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", arretId=");
		sb.append(arretId);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", ligneAndDirection=");
		sb.append(ligneAndDirection);
		sb.append(", perturbation=");
		sb.append(perturbation);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Alert toEntityModel() {
		AlertImpl alertImpl = new AlertImpl();

		if (uuid == null) {
			alertImpl.setUuid("");
		}
		else {
			alertImpl.setUuid(uuid);
		}

		alertImpl.setAlertId(alertId);
		alertImpl.setGroupId(groupId);
		alertImpl.setCompanyId(companyId);
		alertImpl.setArretId(arretId);

		if (startDate == Long.MIN_VALUE) {
			alertImpl.setStartDate(null);
		}
		else {
			alertImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			alertImpl.setEndDate(null);
		}
		else {
			alertImpl.setEndDate(new Date(endDate));
		}

		if (ligneAndDirection == null) {
			alertImpl.setLigneAndDirection("");
		}
		else {
			alertImpl.setLigneAndDirection(ligneAndDirection);
		}

		if (perturbation == null) {
			alertImpl.setPerturbation("");
		}
		else {
			alertImpl.setPerturbation(perturbation);
		}

		alertImpl.resetOriginalValues();

		return alertImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		uuid = objectInput.readUTF();

		alertId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		arretId = objectInput.readLong();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
		ligneAndDirection = objectInput.readUTF();
		perturbation = (String)objectInput.readObject();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(alertId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(arretId);
		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);

		if (ligneAndDirection == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ligneAndDirection);
		}

		if (perturbation == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(perturbation);
		}
	}

	public String uuid;
	public long alertId;
	public long groupId;
	public long companyId;
	public long arretId;
	public long startDate;
	public long endDate;
	public String ligneAndDirection;
	public String perturbation;

}