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

package eu.strasbourg.service.project.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.project.model.PlacitPlace;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PlacitPlace in entity cache.
 *
 * @author Cedric Henry
 * @generated
 */
public class PlacitPlaceCacheModel
	implements CacheModel<PlacitPlace>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PlacitPlaceCacheModel)) {
			return false;
		}

		PlacitPlaceCacheModel placitPlaceCacheModel =
			(PlacitPlaceCacheModel)object;

		if (placitPlaceId == placitPlaceCacheModel.placitPlaceId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, placitPlaceId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", placitPlaceId=");
		sb.append(placitPlaceId);
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
		sb.append(", imageId=");
		sb.append(imageId);
		sb.append(", projectId=");
		sb.append(projectId);
		sb.append(", participationId=");
		sb.append(participationId);
		sb.append(", petitionId=");
		sb.append(petitionId);
		sb.append(", budgetParticipatifId=");
		sb.append(budgetParticipatifId);
		sb.append(", initiativeId=");
		sb.append(initiativeId);
		sb.append(", placeSIGId=");
		sb.append(placeSIGId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PlacitPlace toEntityModel() {
		PlacitPlaceImpl placitPlaceImpl = new PlacitPlaceImpl();

		if (uuid == null) {
			placitPlaceImpl.setUuid("");
		}
		else {
			placitPlaceImpl.setUuid(uuid);
		}

		placitPlaceImpl.setPlacitPlaceId(placitPlaceId);
		placitPlaceImpl.setGroupId(groupId);
		placitPlaceImpl.setCompanyId(companyId);
		placitPlaceImpl.setUserId(userId);

		if (userName == null) {
			placitPlaceImpl.setUserName("");
		}
		else {
			placitPlaceImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			placitPlaceImpl.setCreateDate(null);
		}
		else {
			placitPlaceImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			placitPlaceImpl.setModifiedDate(null);
		}
		else {
			placitPlaceImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (placeName == null) {
			placitPlaceImpl.setPlaceName("");
		}
		else {
			placitPlaceImpl.setPlaceName(placeName);
		}

		if (placeStreetNumber == null) {
			placitPlaceImpl.setPlaceStreetNumber("");
		}
		else {
			placitPlaceImpl.setPlaceStreetNumber(placeStreetNumber);
		}

		if (placeStreetName == null) {
			placitPlaceImpl.setPlaceStreetName("");
		}
		else {
			placitPlaceImpl.setPlaceStreetName(placeStreetName);
		}

		if (placeZipCode == null) {
			placitPlaceImpl.setPlaceZipCode("");
		}
		else {
			placitPlaceImpl.setPlaceZipCode(placeZipCode);
		}

		placitPlaceImpl.setPlaceCityId(placeCityId);
		placitPlaceImpl.setImageId(imageId);
		placitPlaceImpl.setProjectId(projectId);
		placitPlaceImpl.setParticipationId(participationId);
		placitPlaceImpl.setPetitionId(petitionId);
		placitPlaceImpl.setBudgetParticipatifId(budgetParticipatifId);
		placitPlaceImpl.setInitiativeId(initiativeId);

		if (placeSIGId == null) {
			placitPlaceImpl.setPlaceSIGId("");
		}
		else {
			placitPlaceImpl.setPlaceSIGId(placeSIGId);
		}

		placitPlaceImpl.resetOriginalValues();

		return placitPlaceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		placitPlaceId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		placeName = objectInput.readUTF();
		placeStreetNumber = objectInput.readUTF();
		placeStreetName = objectInput.readUTF();
		placeZipCode = objectInput.readUTF();

		placeCityId = objectInput.readLong();

		imageId = objectInput.readLong();

		projectId = objectInput.readLong();

		participationId = objectInput.readLong();

		petitionId = objectInput.readLong();

		budgetParticipatifId = objectInput.readLong();

		initiativeId = objectInput.readLong();
		placeSIGId = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(placitPlaceId);

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

		objectOutput.writeLong(imageId);

		objectOutput.writeLong(projectId);

		objectOutput.writeLong(participationId);

		objectOutput.writeLong(petitionId);

		objectOutput.writeLong(budgetParticipatifId);

		objectOutput.writeLong(initiativeId);

		if (placeSIGId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(placeSIGId);
		}
	}

	public String uuid;
	public long placitPlaceId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String placeName;
	public String placeStreetNumber;
	public String placeStreetName;
	public String placeZipCode;
	public long placeCityId;
	public long imageId;
	public long projectId;
	public long participationId;
	public long petitionId;
	public long budgetParticipatifId;
	public long initiativeId;
	public String placeSIGId;

}