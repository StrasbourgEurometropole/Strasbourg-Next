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

package eu.strasbourg.service.activity.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.activity.model.ActivityCourse;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ActivityCourse in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ActivityCourseCacheModel
	implements CacheModel<ActivityCourse>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ActivityCourseCacheModel)) {
			return false;
		}

		ActivityCourseCacheModel activityCourseCacheModel =
			(ActivityCourseCacheModel)object;

		if (activityCourseId == activityCourseCacheModel.activityCourseId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, activityCourseId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(45);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", activityCourseId=");
		sb.append(activityCourseId);
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
		sb.append(", arrangements=");
		sb.append(arrangements);
		sb.append(", price=");
		sb.append(price);
		sb.append(", activityId=");
		sb.append(activityId);
		sb.append(", organizerId=");
		sb.append(organizerId);
		sb.append(", imageId=");
		sb.append(imageId);
		sb.append(", imageIds=");
		sb.append(imageIds);
		sb.append(", videosIds=");
		sb.append(videosIds);
		sb.append(", documentsIds=");
		sb.append(documentsIds);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ActivityCourse toEntityModel() {
		ActivityCourseImpl activityCourseImpl = new ActivityCourseImpl();

		if (uuid == null) {
			activityCourseImpl.setUuid("");
		}
		else {
			activityCourseImpl.setUuid(uuid);
		}

		activityCourseImpl.setActivityCourseId(activityCourseId);
		activityCourseImpl.setGroupId(groupId);
		activityCourseImpl.setCompanyId(companyId);
		activityCourseImpl.setUserId(userId);

		if (userName == null) {
			activityCourseImpl.setUserName("");
		}
		else {
			activityCourseImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			activityCourseImpl.setCreateDate(null);
		}
		else {
			activityCourseImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			activityCourseImpl.setModifiedDate(null);
		}
		else {
			activityCourseImpl.setModifiedDate(new Date(modifiedDate));
		}

		activityCourseImpl.setStatus(status);
		activityCourseImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			activityCourseImpl.setStatusByUserName("");
		}
		else {
			activityCourseImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			activityCourseImpl.setStatusDate(null);
		}
		else {
			activityCourseImpl.setStatusDate(new Date(statusDate));
		}

		if (name == null) {
			activityCourseImpl.setName("");
		}
		else {
			activityCourseImpl.setName(name);
		}

		if (presentation == null) {
			activityCourseImpl.setPresentation("");
		}
		else {
			activityCourseImpl.setPresentation(presentation);
		}

		if (arrangements == null) {
			activityCourseImpl.setArrangements("");
		}
		else {
			activityCourseImpl.setArrangements(arrangements);
		}

		if (price == null) {
			activityCourseImpl.setPrice("");
		}
		else {
			activityCourseImpl.setPrice(price);
		}

		activityCourseImpl.setActivityId(activityId);
		activityCourseImpl.setOrganizerId(organizerId);
		activityCourseImpl.setImageId(imageId);

		if (imageIds == null) {
			activityCourseImpl.setImageIds("");
		}
		else {
			activityCourseImpl.setImageIds(imageIds);
		}

		if (videosIds == null) {
			activityCourseImpl.setVideosIds("");
		}
		else {
			activityCourseImpl.setVideosIds(videosIds);
		}

		if (documentsIds == null) {
			activityCourseImpl.setDocumentsIds("");
		}
		else {
			activityCourseImpl.setDocumentsIds(documentsIds);
		}

		activityCourseImpl.resetOriginalValues();

		return activityCourseImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		uuid = objectInput.readUTF();

		activityCourseId = objectInput.readLong();

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
		arrangements = (String)objectInput.readObject();
		price = (String)objectInput.readObject();

		activityId = objectInput.readLong();

		organizerId = objectInput.readLong();

		imageId = objectInput.readLong();
		imageIds = objectInput.readUTF();
		videosIds = objectInput.readUTF();
		documentsIds = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(activityCourseId);

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

		if (arrangements == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(arrangements);
		}

		if (price == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(price);
		}

		objectOutput.writeLong(activityId);

		objectOutput.writeLong(organizerId);

		objectOutput.writeLong(imageId);

		if (imageIds == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(imageIds);
		}

		if (videosIds == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(videosIds);
		}

		if (documentsIds == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(documentsIds);
		}
	}

	public String uuid;
	public long activityCourseId;
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
	public String arrangements;
	public String price;
	public long activityId;
	public long organizerId;
	public long imageId;
	public String imageIds;
	public String videosIds;
	public String documentsIds;

}