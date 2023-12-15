/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.activity.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.activity.model.ActivityOrganizer;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ActivityOrganizer in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ActivityOrganizerCacheModel
	implements CacheModel<ActivityOrganizer>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ActivityOrganizerCacheModel)) {
			return false;
		}

		ActivityOrganizerCacheModel activityOrganizerCacheModel =
			(ActivityOrganizerCacheModel)object;

		if (activityOrganizerId ==
				activityOrganizerCacheModel.activityOrganizerId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, activityOrganizerId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", activityOrganizerId=");
		sb.append(activityOrganizerId);
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
		sb.append(", presentation=");
		sb.append(presentation);
		sb.append(", address=");
		sb.append(address);
		sb.append(", phone=");
		sb.append(phone);
		sb.append(", mail=");
		sb.append(mail);
		sb.append(", siteURL=");
		sb.append(siteURL);
		sb.append(", imageId=");
		sb.append(imageId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ActivityOrganizer toEntityModel() {
		ActivityOrganizerImpl activityOrganizerImpl =
			new ActivityOrganizerImpl();

		if (uuid == null) {
			activityOrganizerImpl.setUuid("");
		}
		else {
			activityOrganizerImpl.setUuid(uuid);
		}

		activityOrganizerImpl.setActivityOrganizerId(activityOrganizerId);
		activityOrganizerImpl.setGroupId(groupId);
		activityOrganizerImpl.setCompanyId(companyId);
		activityOrganizerImpl.setUserId(userId);

		if (userName == null) {
			activityOrganizerImpl.setUserName("");
		}
		else {
			activityOrganizerImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			activityOrganizerImpl.setCreateDate(null);
		}
		else {
			activityOrganizerImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			activityOrganizerImpl.setModifiedDate(null);
		}
		else {
			activityOrganizerImpl.setModifiedDate(new Date(modifiedDate));
		}

		activityOrganizerImpl.setStatus(status);
		activityOrganizerImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			activityOrganizerImpl.setStatusByUserName("");
		}
		else {
			activityOrganizerImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			activityOrganizerImpl.setStatusDate(null);
		}
		else {
			activityOrganizerImpl.setStatusDate(new Date(statusDate));
		}

		if (name == null) {
			activityOrganizerImpl.setName("");
		}
		else {
			activityOrganizerImpl.setName(name);
		}

		if (presentation == null) {
			activityOrganizerImpl.setPresentation("");
		}
		else {
			activityOrganizerImpl.setPresentation(presentation);
		}

		if (address == null) {
			activityOrganizerImpl.setAddress("");
		}
		else {
			activityOrganizerImpl.setAddress(address);
		}

		if (phone == null) {
			activityOrganizerImpl.setPhone("");
		}
		else {
			activityOrganizerImpl.setPhone(phone);
		}

		if (mail == null) {
			activityOrganizerImpl.setMail("");
		}
		else {
			activityOrganizerImpl.setMail(mail);
		}

		if (siteURL == null) {
			activityOrganizerImpl.setSiteURL("");
		}
		else {
			activityOrganizerImpl.setSiteURL(siteURL);
		}

		activityOrganizerImpl.setImageId(imageId);

		activityOrganizerImpl.resetOriginalValues();

		return activityOrganizerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		uuid = objectInput.readUTF();

		activityOrganizerId = objectInput.readLong();

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
		presentation = (String)objectInput.readObject();
		address = (String)objectInput.readObject();
		phone = objectInput.readUTF();
		mail = objectInput.readUTF();
		siteURL = objectInput.readUTF();

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

		objectOutput.writeLong(activityOrganizerId);

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

		if (presentation == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(presentation);
		}

		if (address == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(address);
		}

		if (phone == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(phone);
		}

		if (mail == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mail);
		}

		if (siteURL == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(siteURL);
		}

		objectOutput.writeLong(imageId);
	}

	public String uuid;
	public long activityOrganizerId;
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
	public String presentation;
	public String address;
	public String phone;
	public String mail;
	public String siteURL;
	public long imageId;

}