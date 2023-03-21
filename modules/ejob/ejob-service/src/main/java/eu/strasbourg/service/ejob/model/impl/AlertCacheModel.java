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

package eu.strasbourg.service.ejob.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import eu.strasbourg.service.ejob.model.Alert;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Date;

/**
 * The cache model class for representing Alert in entity cache.
 *
 * @author Brian Wing Shun Chan
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
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", alertId=");
		sb.append(alertId);
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
		sb.append(", name=");
		sb.append(name);
		sb.append(", keyWord=");
		sb.append(keyWord);
		sb.append(", publikUserId=");
		sb.append(publikUserId);
		sb.append(", language=");
		sb.append(language);
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
		alertImpl.setUserId(userId);

		if (userName == null) {
			alertImpl.setUserName("");
		}
		else {
			alertImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			alertImpl.setCreateDate(null);
		}
		else {
			alertImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			alertImpl.setModifiedDate(null);
		}
		else {
			alertImpl.setModifiedDate(new Date(modifiedDate));
		}

		alertImpl.setStatus(status);
		alertImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			alertImpl.setStatusByUserName("");
		}
		else {
			alertImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			alertImpl.setStatusDate(null);
		}
		else {
			alertImpl.setStatusDate(new Date(statusDate));
		}

		if (name == null) {
			alertImpl.setName("");
		}
		else {
			alertImpl.setName(name);
		}

		if (keyWord == null) {
			alertImpl.setKeyWord("");
		}
		else {
			alertImpl.setKeyWord(keyWord);
		}

		if (publikUserId == null) {
			alertImpl.setPublikUserId("");
		}
		else {
			alertImpl.setPublikUserId(publikUserId);
		}

		if (language == null) {
			alertImpl.setLanguage("");
		}
		else {
			alertImpl.setLanguage(language);
		}

		alertImpl.resetOriginalValues();

		return alertImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		alertId = objectInput.readLong();

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
		name = objectInput.readUTF();
		keyWord = objectInput.readUTF();
		publikUserId = objectInput.readUTF();
		language = objectInput.readUTF();
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

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (keyWord == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(keyWord);
		}

		if (publikUserId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(publikUserId);
		}

		if (language == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(language);
		}
	}

	public String uuid;
	public long alertId;
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
	public String name;
	public String keyWord;
	public String publikUserId;
	public String language;

}