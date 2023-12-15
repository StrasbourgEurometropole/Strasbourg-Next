/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.gtfs.model.Ligne;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Ligne in entity cache.
 *
 * @author Cedric Henry
 * @generated
 */
public class LigneCacheModel implements CacheModel<Ligne>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof LigneCacheModel)) {
			return false;
		}

		LigneCacheModel ligneCacheModel = (LigneCacheModel)object;

		if (ligneId == ligneCacheModel.ligneId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ligneId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", ligneId=");
		sb.append(ligneId);
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
		sb.append(", routeId=");
		sb.append(routeId);
		sb.append(", shortName=");
		sb.append(shortName);
		sb.append(", title=");
		sb.append(title);
		sb.append(", type=");
		sb.append(type);
		sb.append(", backgroundColor=");
		sb.append(backgroundColor);
		sb.append(", textColor=");
		sb.append(textColor);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Ligne toEntityModel() {
		LigneImpl ligneImpl = new LigneImpl();

		if (uuid == null) {
			ligneImpl.setUuid("");
		}
		else {
			ligneImpl.setUuid(uuid);
		}

		ligneImpl.setLigneId(ligneId);
		ligneImpl.setGroupId(groupId);
		ligneImpl.setCompanyId(companyId);
		ligneImpl.setUserId(userId);

		if (userName == null) {
			ligneImpl.setUserName("");
		}
		else {
			ligneImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			ligneImpl.setCreateDate(null);
		}
		else {
			ligneImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			ligneImpl.setModifiedDate(null);
		}
		else {
			ligneImpl.setModifiedDate(new Date(modifiedDate));
		}

		ligneImpl.setStatus(status);
		ligneImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			ligneImpl.setStatusByUserName("");
		}
		else {
			ligneImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			ligneImpl.setStatusDate(null);
		}
		else {
			ligneImpl.setStatusDate(new Date(statusDate));
		}

		if (routeId == null) {
			ligneImpl.setRouteId("");
		}
		else {
			ligneImpl.setRouteId(routeId);
		}

		if (shortName == null) {
			ligneImpl.setShortName("");
		}
		else {
			ligneImpl.setShortName(shortName);
		}

		if (title == null) {
			ligneImpl.setTitle("");
		}
		else {
			ligneImpl.setTitle(title);
		}

		ligneImpl.setType(type);

		if (backgroundColor == null) {
			ligneImpl.setBackgroundColor("");
		}
		else {
			ligneImpl.setBackgroundColor(backgroundColor);
		}

		if (textColor == null) {
			ligneImpl.setTextColor("");
		}
		else {
			ligneImpl.setTextColor(textColor);
		}

		ligneImpl.resetOriginalValues();

		return ligneImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		ligneId = objectInput.readLong();

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
		routeId = objectInput.readUTF();
		shortName = objectInput.readUTF();
		title = objectInput.readUTF();

		type = objectInput.readInt();
		backgroundColor = objectInput.readUTF();
		textColor = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(ligneId);

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

		if (routeId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(routeId);
		}

		if (shortName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(shortName);
		}

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		objectOutput.writeInt(type);

		if (backgroundColor == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(backgroundColor);
		}

		if (textColor == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(textColor);
		}
	}

	public String uuid;
	public long ligneId;
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
	public String routeId;
	public String shortName;
	public String title;
	public int type;
	public String backgroundColor;
	public String textColor;

}