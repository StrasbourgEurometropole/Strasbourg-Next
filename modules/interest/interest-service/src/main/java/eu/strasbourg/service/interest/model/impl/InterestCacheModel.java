/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.interest.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.interest.model.Interest;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Interest in entity cache.
 *
 * @author BenjaminBini
 * @generated
 */
public class InterestCacheModel
	implements CacheModel<Interest>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof InterestCacheModel)) {
			return false;
		}

		InterestCacheModel interestCacheModel = (InterestCacheModel)object;

		if (interestId == interestCacheModel.interestId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, interestId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", interestId=");
		sb.append(interestId);
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
		sb.append(", lastPublishDate=");
		sb.append(lastPublishDate);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", typeId=");
		sb.append(typeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Interest toEntityModel() {
		InterestImpl interestImpl = new InterestImpl();

		if (uuid == null) {
			interestImpl.setUuid("");
		}
		else {
			interestImpl.setUuid(uuid);
		}

		interestImpl.setInterestId(interestId);
		interestImpl.setGroupId(groupId);
		interestImpl.setCompanyId(companyId);
		interestImpl.setUserId(userId);

		if (userName == null) {
			interestImpl.setUserName("");
		}
		else {
			interestImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			interestImpl.setCreateDate(null);
		}
		else {
			interestImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			interestImpl.setModifiedDate(null);
		}
		else {
			interestImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (lastPublishDate == Long.MIN_VALUE) {
			interestImpl.setLastPublishDate(null);
		}
		else {
			interestImpl.setLastPublishDate(new Date(lastPublishDate));
		}

		interestImpl.setStatus(status);
		interestImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			interestImpl.setStatusByUserName("");
		}
		else {
			interestImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			interestImpl.setStatusDate(null);
		}
		else {
			interestImpl.setStatusDate(new Date(statusDate));
		}

		if (title == null) {
			interestImpl.setTitle("");
		}
		else {
			interestImpl.setTitle(title);
		}

		if (description == null) {
			interestImpl.setDescription("");
		}
		else {
			interestImpl.setDescription(description);
		}

		interestImpl.setTypeId(typeId);

		interestImpl.resetOriginalValues();

		return interestImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		uuid = objectInput.readUTF();

		interestId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		lastPublishDate = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
		title = objectInput.readUTF();
		description = (String)objectInput.readObject();

		typeId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(interestId);

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
		objectOutput.writeLong(lastPublishDate);

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (description == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(description);
		}

		objectOutput.writeLong(typeId);
	}

	public String uuid;
	public long interestId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long lastPublishDate;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public String title;
	public String description;
	public long typeId;

}