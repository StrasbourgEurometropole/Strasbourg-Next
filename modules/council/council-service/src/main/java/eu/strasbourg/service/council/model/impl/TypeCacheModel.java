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

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import eu.strasbourg.service.council.model.Type;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Date;

/**
 * The cache model class for representing Type in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TypeCacheModel implements CacheModel<Type>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TypeCacheModel)) {
			return false;
		}

		TypeCacheModel typeCacheModel = (TypeCacheModel)object;

		if (typeId == typeCacheModel.typeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, typeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", typeId=");
		sb.append(typeId);
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
		sb.append(", titleLong=");
		sb.append(titleLong);
		sb.append(", roleId=");
		sb.append(roleId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Type toEntityModel() {
		TypeImpl typeImpl = new TypeImpl();

		if (uuid == null) {
			typeImpl.setUuid("");
		}
		else {
			typeImpl.setUuid(uuid);
		}

		typeImpl.setTypeId(typeId);
		typeImpl.setGroupId(groupId);
		typeImpl.setCompanyId(companyId);
		typeImpl.setUserId(userId);

		if (userName == null) {
			typeImpl.setUserName("");
		}
		else {
			typeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			typeImpl.setCreateDate(null);
		}
		else {
			typeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			typeImpl.setModifiedDate(null);
		}
		else {
			typeImpl.setModifiedDate(new Date(modifiedDate));
		}

		typeImpl.setStatus(status);
		typeImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			typeImpl.setStatusByUserName("");
		}
		else {
			typeImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			typeImpl.setStatusDate(null);
		}
		else {
			typeImpl.setStatusDate(new Date(statusDate));
		}

		if (title == null) {
			typeImpl.setTitle("");
		}
		else {
			typeImpl.setTitle(title);
		}

		if (titleLong == null) {
			typeImpl.setTitleLong("");
		}
		else {
			typeImpl.setTitleLong(titleLong);
		}

		typeImpl.setRoleId(roleId);

		typeImpl.resetOriginalValues();

		return typeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		typeId = objectInput.readLong();

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
		titleLong = objectInput.readUTF();

		roleId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(typeId);

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

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (titleLong == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(titleLong);
		}

		objectOutput.writeLong(roleId);
	}

	public String uuid;
	public long typeId;
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
	public String titleLong;
	public long roleId;

}