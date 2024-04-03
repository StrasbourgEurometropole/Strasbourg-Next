/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.video.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.video.model.Video;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Video in entity cache.
 *
 * @author BenjaminBini
 * @generated
 */
public class VideoCacheModel implements CacheModel<Video>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof VideoCacheModel)) {
			return false;
		}

		VideoCacheModel videoCacheModel = (VideoCacheModel)object;

		if (videoId == videoCacheModel.videoId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, videoId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", videoId=");
		sb.append(videoId);
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
		sb.append(", copyright=");
		sb.append(copyright);
		sb.append(", source=");
		sb.append(source);
		sb.append(", publicationDate=");
		sb.append(publicationDate);
		sb.append(", imageId=");
		sb.append(imageId);
		sb.append(", transcriptionFileId=");
		sb.append(transcriptionFileId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Video toEntityModel() {
		VideoImpl videoImpl = new VideoImpl();

		if (uuid == null) {
			videoImpl.setUuid("");
		}
		else {
			videoImpl.setUuid(uuid);
		}

		videoImpl.setVideoId(videoId);
		videoImpl.setGroupId(groupId);
		videoImpl.setCompanyId(companyId);
		videoImpl.setUserId(userId);

		if (userName == null) {
			videoImpl.setUserName("");
		}
		else {
			videoImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			videoImpl.setCreateDate(null);
		}
		else {
			videoImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			videoImpl.setModifiedDate(null);
		}
		else {
			videoImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (lastPublishDate == Long.MIN_VALUE) {
			videoImpl.setLastPublishDate(null);
		}
		else {
			videoImpl.setLastPublishDate(new Date(lastPublishDate));
		}

		videoImpl.setStatus(status);
		videoImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			videoImpl.setStatusByUserName("");
		}
		else {
			videoImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			videoImpl.setStatusDate(null);
		}
		else {
			videoImpl.setStatusDate(new Date(statusDate));
		}

		if (title == null) {
			videoImpl.setTitle("");
		}
		else {
			videoImpl.setTitle(title);
		}

		if (description == null) {
			videoImpl.setDescription("");
		}
		else {
			videoImpl.setDescription(description);
		}

		if (copyright == null) {
			videoImpl.setCopyright("");
		}
		else {
			videoImpl.setCopyright(copyright);
		}

		if (source == null) {
			videoImpl.setSource("");
		}
		else {
			videoImpl.setSource(source);
		}

		if (publicationDate == Long.MIN_VALUE) {
			videoImpl.setPublicationDate(null);
		}
		else {
			videoImpl.setPublicationDate(new Date(publicationDate));
		}

		videoImpl.setImageId(imageId);
		videoImpl.setTranscriptionFileId(transcriptionFileId);

		videoImpl.resetOriginalValues();

		return videoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		uuid = objectInput.readUTF();

		videoId = objectInput.readLong();

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
		copyright = objectInput.readUTF();
		source = objectInput.readUTF();
		publicationDate = objectInput.readLong();

		imageId = objectInput.readLong();

		transcriptionFileId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(videoId);

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

		if (copyright == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(copyright);
		}

		if (source == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(source);
		}

		objectOutput.writeLong(publicationDate);

		objectOutput.writeLong(imageId);

		objectOutput.writeLong(transcriptionFileId);
	}

	public String uuid;
	public long videoId;
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
	public String copyright;
	public String source;
	public long publicationDate;
	public long imageId;
	public long transcriptionFileId;

}