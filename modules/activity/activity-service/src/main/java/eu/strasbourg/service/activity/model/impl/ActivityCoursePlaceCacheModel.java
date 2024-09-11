/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.activity.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.activity.model.ActivityCoursePlace;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ActivityCoursePlace in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ActivityCoursePlaceCacheModel
	implements CacheModel<ActivityCoursePlace>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ActivityCoursePlaceCacheModel)) {
			return false;
		}

		ActivityCoursePlaceCacheModel activityCoursePlaceCacheModel =
			(ActivityCoursePlaceCacheModel)object;

		if (activityCoursePlaceId ==
				activityCoursePlaceCacheModel.activityCoursePlaceId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, activityCoursePlaceId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", activityCoursePlaceId=");
		sb.append(activityCoursePlaceId);
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
		sb.append(", activityCourseId=");
		sb.append(activityCourseId);
		sb.append(", placeSIGId=");
		sb.append(placeSIGId);
		sb.append(", placeName=");
		sb.append(placeName);
		sb.append(", placeStreetNumber=");
		sb.append(placeStreetNumber);
		sb.append(", placeStreetName=");
		sb.append(placeStreetName);
		sb.append(", placeZipCode=");
		sb.append(placeZipCode);
		sb.append(", placeCityId=");
		sb.append(placeCityId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ActivityCoursePlace toEntityModel() {
		ActivityCoursePlaceImpl activityCoursePlaceImpl =
			new ActivityCoursePlaceImpl();

		if (uuid == null) {
			activityCoursePlaceImpl.setUuid("");
		}
		else {
			activityCoursePlaceImpl.setUuid(uuid);
		}

		activityCoursePlaceImpl.setActivityCoursePlaceId(activityCoursePlaceId);
		activityCoursePlaceImpl.setGroupId(groupId);
		activityCoursePlaceImpl.setCompanyId(companyId);
		activityCoursePlaceImpl.setUserId(userId);

		if (userName == null) {
			activityCoursePlaceImpl.setUserName("");
		}
		else {
			activityCoursePlaceImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			activityCoursePlaceImpl.setCreateDate(null);
		}
		else {
			activityCoursePlaceImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			activityCoursePlaceImpl.setModifiedDate(null);
		}
		else {
			activityCoursePlaceImpl.setModifiedDate(new Date(modifiedDate));
		}

		activityCoursePlaceImpl.setActivityCourseId(activityCourseId);

		if (placeSIGId == null) {
			activityCoursePlaceImpl.setPlaceSIGId("");
		}
		else {
			activityCoursePlaceImpl.setPlaceSIGId(placeSIGId);
		}

		if (placeName == null) {
			activityCoursePlaceImpl.setPlaceName("");
		}
		else {
			activityCoursePlaceImpl.setPlaceName(placeName);
		}

		if (placeStreetNumber == null) {
			activityCoursePlaceImpl.setPlaceStreetNumber("");
		}
		else {
			activityCoursePlaceImpl.setPlaceStreetNumber(placeStreetNumber);
		}

		if (placeStreetName == null) {
			activityCoursePlaceImpl.setPlaceStreetName("");
		}
		else {
			activityCoursePlaceImpl.setPlaceStreetName(placeStreetName);
		}

		if (placeZipCode == null) {
			activityCoursePlaceImpl.setPlaceZipCode("");
		}
		else {
			activityCoursePlaceImpl.setPlaceZipCode(placeZipCode);
		}

		activityCoursePlaceImpl.setPlaceCityId(placeCityId);

		activityCoursePlaceImpl.resetOriginalValues();

		return activityCoursePlaceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		activityCoursePlaceId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		activityCourseId = objectInput.readLong();
		placeSIGId = objectInput.readUTF();
		placeName = objectInput.readUTF();
		placeStreetNumber = objectInput.readUTF();
		placeStreetName = objectInput.readUTF();
		placeZipCode = objectInput.readUTF();

		placeCityId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(activityCoursePlaceId);

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

		objectOutput.writeLong(activityCourseId);

		if (placeSIGId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(placeSIGId);
		}

		if (placeName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(placeName);
		}

		if (placeStreetNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(placeStreetNumber);
		}

		if (placeStreetName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(placeStreetName);
		}

		if (placeZipCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(placeZipCode);
		}

		objectOutput.writeLong(placeCityId);
	}

	public String uuid;
	public long activityCoursePlaceId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long activityCourseId;
	public String placeSIGId;
	public String placeName;
	public String placeStreetNumber;
	public String placeStreetName;
	public String placeZipCode;
	public long placeCityId;

}