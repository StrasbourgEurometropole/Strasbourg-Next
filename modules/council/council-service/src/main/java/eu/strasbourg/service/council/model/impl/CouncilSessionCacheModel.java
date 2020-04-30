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

package eu.strasbourg.service.council.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import eu.strasbourg.service.council.model.CouncilSession;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CouncilSession in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see CouncilSession
 * @generated
 */
@ProviderType
public class CouncilSessionCacheModel implements CacheModel<CouncilSession>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CouncilSessionCacheModel)) {
			return false;
		}

		CouncilSessionCacheModel councilSessionCacheModel = (CouncilSessionCacheModel)obj;

		if (councilSessionId == councilSessionCacheModel.councilSessionId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, councilSessionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", councilSessionId=");
		sb.append(councilSessionId);
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
		sb.append(", title=");
		sb.append(title);
		sb.append(", date=");
		sb.append(date);
		sb.append(", type=");
		sb.append(type);
		sb.append(", officialLeaderId=");
		sb.append(officialLeaderId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CouncilSession toEntityModel() {
		CouncilSessionImpl councilSessionImpl = new CouncilSessionImpl();

		if (uuid == null) {
			councilSessionImpl.setUuid(StringPool.BLANK);
		}
		else {
			councilSessionImpl.setUuid(uuid);
		}

		councilSessionImpl.setCouncilSessionId(councilSessionId);
		councilSessionImpl.setGroupId(groupId);
		councilSessionImpl.setCompanyId(companyId);
		councilSessionImpl.setUserId(userId);

		if (userName == null) {
			councilSessionImpl.setUserName(StringPool.BLANK);
		}
		else {
			councilSessionImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			councilSessionImpl.setCreateDate(null);
		}
		else {
			councilSessionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			councilSessionImpl.setModifiedDate(null);
		}
		else {
			councilSessionImpl.setModifiedDate(new Date(modifiedDate));
		}

		councilSessionImpl.setStatus(status);
		councilSessionImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			councilSessionImpl.setStatusByUserName(StringPool.BLANK);
		}
		else {
			councilSessionImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			councilSessionImpl.setStatusDate(null);
		}
		else {
			councilSessionImpl.setStatusDate(new Date(statusDate));
		}

		if (title == null) {
			councilSessionImpl.setTitle(StringPool.BLANK);
		}
		else {
			councilSessionImpl.setTitle(title);
		}

		if (date == Long.MIN_VALUE) {
			councilSessionImpl.setDate(null);
		}
		else {
			councilSessionImpl.setDate(new Date(date));
		}

		if (type == null) {
			councilSessionImpl.setType(StringPool.BLANK);
		}
		else {
			councilSessionImpl.setType(type);
		}

		councilSessionImpl.setOfficialLeaderId(officialLeaderId);

		councilSessionImpl.resetOriginalValues();

		return councilSessionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		councilSessionId = objectInput.readLong();

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
		title = objectInput.readUTF();
		date = objectInput.readLong();
		type = objectInput.readUTF();

		officialLeaderId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(councilSessionId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		objectOutput.writeLong(date);

		if (type == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(type);
		}

		objectOutput.writeLong(officialLeaderId);
	}

	public String uuid;
	public long councilSessionId;
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
	public String title;
	public long date;
	public String type;
	public long officialLeaderId;
}