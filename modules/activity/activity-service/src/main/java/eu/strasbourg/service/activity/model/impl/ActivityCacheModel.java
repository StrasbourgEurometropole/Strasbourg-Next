/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.activity.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.activity.model.Activity;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Activity in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ActivityCacheModel
	implements CacheModel<Activity>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ActivityCacheModel)) {
			return false;
		}

		ActivityCacheModel activityCacheModel = (ActivityCacheModel)object;

		if (activityId == activityCacheModel.activityId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, activityId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", activityId=");
		sb.append(activityId);
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
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", order=");
		sb.append(order);
		sb.append(", videosIds=");
		sb.append(videosIds);
		sb.append(", imageId=");
		sb.append(imageId);
		sb.append(", imagesIds=");
		sb.append(imagesIds);
		sb.append(", filesIds=");
		sb.append(filesIds);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Activity toEntityModel() {
		ActivityImpl activityImpl = new ActivityImpl();

		if (uuid == null) {
			activityImpl.setUuid("");
		}
		else {
			activityImpl.setUuid(uuid);
		}

		activityImpl.setActivityId(activityId);
		activityImpl.setGroupId(groupId);
		activityImpl.setCompanyId(companyId);
		activityImpl.setUserId(userId);

		if (userName == null) {
			activityImpl.setUserName("");
		}
		else {
			activityImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			activityImpl.setCreateDate(null);
		}
		else {
			activityImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			activityImpl.setModifiedDate(null);
		}
		else {
			activityImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (title == null) {
			activityImpl.setTitle("");
		}
		else {
			activityImpl.setTitle(title);
		}

		if (description == null) {
			activityImpl.setDescription("");
		}
		else {
			activityImpl.setDescription(description);
		}

		activityImpl.setOrder(order);

		if (videosIds == null) {
			activityImpl.setVideosIds("");
		}
		else {
			activityImpl.setVideosIds(videosIds);
		}

		activityImpl.setImageId(imageId);

		if (imagesIds == null) {
			activityImpl.setImagesIds("");
		}
		else {
			activityImpl.setImagesIds(imagesIds);
		}

		if (filesIds == null) {
			activityImpl.setFilesIds("");
		}
		else {
			activityImpl.setFilesIds(filesIds);
		}

		activityImpl.setStatus(status);
		activityImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			activityImpl.setStatusByUserName("");
		}
		else {
			activityImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			activityImpl.setStatusDate(null);
		}
		else {
			activityImpl.setStatusDate(new Date(statusDate));
		}

		activityImpl.resetOriginalValues();

		return activityImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		uuid = objectInput.readUTF();

		activityId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		title = objectInput.readUTF();
		description = (String)objectInput.readObject();

		order = objectInput.readInt();
		videosIds = objectInput.readUTF();

		imageId = objectInput.readLong();
		imagesIds = objectInput.readUTF();
		filesIds = objectInput.readUTF();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(activityId);

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

		objectOutput.writeInt(order);

		if (videosIds == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(videosIds);
		}

		objectOutput.writeLong(imageId);

		if (imagesIds == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(imagesIds);
		}

		if (filesIds == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(filesIds);
		}

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);
	}

	public String uuid;
	public long activityId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String title;
	public String description;
	public int order;
	public String videosIds;
	public long imageId;
	public String imagesIds;
	public String filesIds;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;

}