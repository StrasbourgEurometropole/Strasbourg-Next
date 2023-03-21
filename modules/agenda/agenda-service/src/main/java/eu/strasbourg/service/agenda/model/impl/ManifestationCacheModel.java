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

package eu.strasbourg.service.agenda.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.agenda.model.Manifestation;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Manifestation in entity cache.
 *
 * @author BenjaminBini
 * @generated
 */
public class ManifestationCacheModel
	implements CacheModel<Manifestation>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ManifestationCacheModel)) {
			return false;
		}

		ManifestationCacheModel manifestationCacheModel =
			(ManifestationCacheModel)object;

		if (manifestationId == manifestationCacheModel.manifestationId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, manifestationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(51);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", manifestationId=");
		sb.append(manifestationId);
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
		sb.append(", imageId=");
		sb.append(imageId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", externalImageURL=");
		sb.append(externalImageURL);
		sb.append(", externalImageCopyright=");
		sb.append(externalImageCopyright);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", source=");
		sb.append(source);
		sb.append(", idSource=");
		sb.append(idSource);
		sb.append(", publicationDate=");
		sb.append(publicationDate);
		sb.append(", createDateSource=");
		sb.append(createDateSource);
		sb.append(", modifiedDateSource=");
		sb.append(modifiedDateSource);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Manifestation toEntityModel() {
		ManifestationImpl manifestationImpl = new ManifestationImpl();

		if (uuid == null) {
			manifestationImpl.setUuid("");
		}
		else {
			manifestationImpl.setUuid(uuid);
		}

		manifestationImpl.setManifestationId(manifestationId);
		manifestationImpl.setGroupId(groupId);
		manifestationImpl.setCompanyId(companyId);
		manifestationImpl.setUserId(userId);

		if (userName == null) {
			manifestationImpl.setUserName("");
		}
		else {
			manifestationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			manifestationImpl.setCreateDate(null);
		}
		else {
			manifestationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			manifestationImpl.setModifiedDate(null);
		}
		else {
			manifestationImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (lastPublishDate == Long.MIN_VALUE) {
			manifestationImpl.setLastPublishDate(null);
		}
		else {
			manifestationImpl.setLastPublishDate(new Date(lastPublishDate));
		}

		manifestationImpl.setStatus(status);
		manifestationImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			manifestationImpl.setStatusByUserName("");
		}
		else {
			manifestationImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			manifestationImpl.setStatusDate(null);
		}
		else {
			manifestationImpl.setStatusDate(new Date(statusDate));
		}

		manifestationImpl.setImageId(imageId);

		if (title == null) {
			manifestationImpl.setTitle("");
		}
		else {
			manifestationImpl.setTitle(title);
		}

		if (description == null) {
			manifestationImpl.setDescription("");
		}
		else {
			manifestationImpl.setDescription(description);
		}

		if (externalImageURL == null) {
			manifestationImpl.setExternalImageURL("");
		}
		else {
			manifestationImpl.setExternalImageURL(externalImageURL);
		}

		if (externalImageCopyright == null) {
			manifestationImpl.setExternalImageCopyright("");
		}
		else {
			manifestationImpl.setExternalImageCopyright(externalImageCopyright);
		}

		if (startDate == Long.MIN_VALUE) {
			manifestationImpl.setStartDate(null);
		}
		else {
			manifestationImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			manifestationImpl.setEndDate(null);
		}
		else {
			manifestationImpl.setEndDate(new Date(endDate));
		}

		if (source == null) {
			manifestationImpl.setSource("");
		}
		else {
			manifestationImpl.setSource(source);
		}

		if (idSource == null) {
			manifestationImpl.setIdSource("");
		}
		else {
			manifestationImpl.setIdSource(idSource);
		}

		if (publicationDate == Long.MIN_VALUE) {
			manifestationImpl.setPublicationDate(null);
		}
		else {
			manifestationImpl.setPublicationDate(new Date(publicationDate));
		}

		if (createDateSource == Long.MIN_VALUE) {
			manifestationImpl.setCreateDateSource(null);
		}
		else {
			manifestationImpl.setCreateDateSource(new Date(createDateSource));
		}

		if (modifiedDateSource == Long.MIN_VALUE) {
			manifestationImpl.setModifiedDateSource(null);
		}
		else {
			manifestationImpl.setModifiedDateSource(
				new Date(modifiedDateSource));
		}

		manifestationImpl.resetOriginalValues();

		return manifestationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		uuid = objectInput.readUTF();

		manifestationId = objectInput.readLong();

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

		imageId = objectInput.readLong();
		title = objectInput.readUTF();
		description = (String)objectInput.readObject();
		externalImageURL = objectInput.readUTF();
		externalImageCopyright = objectInput.readUTF();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
		source = objectInput.readUTF();
		idSource = objectInput.readUTF();
		publicationDate = objectInput.readLong();
		createDateSource = objectInput.readLong();
		modifiedDateSource = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(manifestationId);

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

		objectOutput.writeLong(imageId);

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

		if (externalImageURL == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(externalImageURL);
		}

		if (externalImageCopyright == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(externalImageCopyright);
		}

		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);

		if (source == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(source);
		}

		if (idSource == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(idSource);
		}

		objectOutput.writeLong(publicationDate);
		objectOutput.writeLong(createDateSource);
		objectOutput.writeLong(modifiedDateSource);
	}

	public String uuid;
	public long manifestationId;
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
	public long imageId;
	public String title;
	public String description;
	public String externalImageURL;
	public String externalImageCopyright;
	public long startDate;
	public long endDate;
	public String source;
	public String idSource;
	public long publicationDate;
	public long createDateSource;
	public long modifiedDateSource;

}