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

package eu.strasbourg.service.official.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import eu.strasbourg.service.official.model.Official;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Official in entity cache.
 *
 * @author AngeliqueZUNINO
 * @generated
 */
@ProviderType
public class OfficialCacheModel
	implements CacheModel<Official>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OfficialCacheModel)) {
			return false;
		}

		OfficialCacheModel officialCacheModel = (OfficialCacheModel)obj;

		if (officialId == officialCacheModel.officialId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, officialId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(47);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", officialId=");
		sb.append(officialId);
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
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", thematicDelegation=");
		sb.append(thematicDelegation);
		sb.append(", missions=");
		sb.append(missions);
		sb.append(", wasMinister=");
		sb.append(wasMinister);
		sb.append(", contact=");
		sb.append(contact);
		sb.append(", orderDeputyMayor=");
		sb.append(orderDeputyMayor);
		sb.append(", orderVicePresident=");
		sb.append(orderVicePresident);
		sb.append(", imageId=");
		sb.append(imageId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Official toEntityModel() {
		OfficialImpl officialImpl = new OfficialImpl();

		if (uuid == null) {
			officialImpl.setUuid("");
		}
		else {
			officialImpl.setUuid(uuid);
		}

		officialImpl.setOfficialId(officialId);
		officialImpl.setGroupId(groupId);
		officialImpl.setCompanyId(companyId);
		officialImpl.setUserId(userId);

		if (userName == null) {
			officialImpl.setUserName("");
		}
		else {
			officialImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			officialImpl.setCreateDate(null);
		}
		else {
			officialImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			officialImpl.setModifiedDate(null);
		}
		else {
			officialImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (lastPublishDate == Long.MIN_VALUE) {
			officialImpl.setLastPublishDate(null);
		}
		else {
			officialImpl.setLastPublishDate(new Date(lastPublishDate));
		}

		officialImpl.setStatus(status);
		officialImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			officialImpl.setStatusByUserName("");
		}
		else {
			officialImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			officialImpl.setStatusDate(null);
		}
		else {
			officialImpl.setStatusDate(new Date(statusDate));
		}

		officialImpl.setGender(gender);

		if (lastName == null) {
			officialImpl.setLastName("");
		}
		else {
			officialImpl.setLastName(lastName);
		}

		if (firstName == null) {
			officialImpl.setFirstName("");
		}
		else {
			officialImpl.setFirstName(firstName);
		}

		if (thematicDelegation == null) {
			officialImpl.setThematicDelegation("");
		}
		else {
			officialImpl.setThematicDelegation(thematicDelegation);
		}

		if (missions == null) {
			officialImpl.setMissions("");
		}
		else {
			officialImpl.setMissions(missions);
		}

		officialImpl.setWasMinister(wasMinister);

		if (contact == null) {
			officialImpl.setContact("");
		}
		else {
			officialImpl.setContact(contact);
		}

		officialImpl.setOrderDeputyMayor(orderDeputyMayor);
		officialImpl.setOrderVicePresident(orderVicePresident);
		officialImpl.setImageId(imageId);

		officialImpl.resetOriginalValues();

		return officialImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		officialId = objectInput.readLong();

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

		gender = objectInput.readInt();
		lastName = objectInput.readUTF();
		firstName = objectInput.readUTF();
		thematicDelegation = objectInput.readUTF();
		missions = objectInput.readUTF();

		wasMinister = objectInput.readBoolean();
		contact = objectInput.readUTF();

		orderDeputyMayor = objectInput.readInt();

		orderVicePresident = objectInput.readInt();

		imageId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(officialId);

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

		objectOutput.writeInt(gender);

		if (lastName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		if (firstName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (thematicDelegation == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(thematicDelegation);
		}

		if (missions == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(missions);
		}

		objectOutput.writeBoolean(wasMinister);

		if (contact == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(contact);
		}

		objectOutput.writeInt(orderDeputyMayor);

		objectOutput.writeInt(orderVicePresident);

		objectOutput.writeLong(imageId);
	}

	public String uuid;
	public long officialId;
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
	public int gender;
	public String lastName;
	public String firstName;
	public String thematicDelegation;
	public String missions;
	public boolean wasMinister;
	public String contact;
	public int orderDeputyMayor;
	public int orderVicePresident;
	public long imageId;

}