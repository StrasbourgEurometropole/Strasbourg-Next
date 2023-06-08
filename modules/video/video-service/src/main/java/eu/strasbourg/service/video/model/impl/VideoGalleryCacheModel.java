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

package eu.strasbourg.service.video.model.impl;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import eu.strasbourg.service.video.model.VideoGallery;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing VideoGallery in entity cache.
 *
 * @author BenjaminBini
 * @generated
 */
public class VideoGalleryCacheModel
	implements CacheModel<VideoGallery>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof VideoGalleryCacheModel)) {
			return false;
		}

		VideoGalleryCacheModel videoGalleryCacheModel =
			(VideoGalleryCacheModel)object;

		if (galleryId == videoGalleryCacheModel.galleryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, galleryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", galleryId=");
		sb.append(galleryId);
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
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", publicationDate=");
		sb.append(publicationDate);
		sb.append(", imageId=");
		sb.append(imageId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public VideoGallery toEntityModel() {
		VideoGalleryImpl videoGalleryImpl = new VideoGalleryImpl();

		if (uuid == null) {
			videoGalleryImpl.setUuid("");
		}
		else {
			videoGalleryImpl.setUuid(uuid);
		}

		videoGalleryImpl.setGalleryId(galleryId);
		videoGalleryImpl.setGroupId(groupId);
		videoGalleryImpl.setCompanyId(companyId);
		videoGalleryImpl.setUserId(userId);

		if (userName == null) {
			videoGalleryImpl.setUserName("");
		}
		else {
			videoGalleryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			videoGalleryImpl.setCreateDate(null);
		}
		else {
			videoGalleryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			videoGalleryImpl.setModifiedDate(null);
		}
		else {
			videoGalleryImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (lastPublishDate == Long.MIN_VALUE) {
			videoGalleryImpl.setLastPublishDate(null);
		}
		else {
			videoGalleryImpl.setLastPublishDate(new Date(lastPublishDate));
		}

		videoGalleryImpl.setStatus(status);
		videoGalleryImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			videoGalleryImpl.setStatusByUserName("");
		}
		else {
			videoGalleryImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			videoGalleryImpl.setStatusDate(null);
		}
		else {
			videoGalleryImpl.setStatusDate(new Date(statusDate));
		}

		if (title == null) {
			videoGalleryImpl.setTitle("");
		}
		else {
			videoGalleryImpl.setTitle(title);
		}

		if (description == null) {
			videoGalleryImpl.setDescription("");
		}
		else {
			videoGalleryImpl.setDescription(description);
		}

		if (publicationDate == Long.MIN_VALUE) {
			videoGalleryImpl.setPublicationDate(null);
		}
		else {
			videoGalleryImpl.setPublicationDate(new Date(publicationDate));
		}

		videoGalleryImpl.setImageId(imageId);

		videoGalleryImpl.resetOriginalValues();

		return videoGalleryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		uuid = objectInput.readUTF();

		galleryId = objectInput.readLong();

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
		title = objectInput.readUTF();
		description = (String)objectInput.readObject();
		publicationDate = objectInput.readLong();

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

		objectOutput.writeLong(galleryId);

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

		objectOutput.writeLong(publicationDate);

		objectOutput.writeLong(imageId);
	}

	public String uuid;
	public long galleryId;
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
	public String title;
	public String description;
	public long publicationDate;
	public long imageId;

}