/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.edition.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.edition.model.EditionGallery;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EditionGallery in entity cache.
 *
 * @author BenjaminBini
 * @generated
 */
public class EditionGalleryCacheModel
	implements CacheModel<EditionGallery>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EditionGalleryCacheModel)) {
			return false;
		}

		EditionGalleryCacheModel editionGalleryCacheModel =
			(EditionGalleryCacheModel)object;

		if (galleryId == editionGalleryCacheModel.galleryId) {
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
		sb.append(", imageId=");
		sb.append(imageId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", publicationDate=");
		sb.append(publicationDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EditionGallery toEntityModel() {
		EditionGalleryImpl editionGalleryImpl = new EditionGalleryImpl();

		if (uuid == null) {
			editionGalleryImpl.setUuid("");
		}
		else {
			editionGalleryImpl.setUuid(uuid);
		}

		editionGalleryImpl.setGalleryId(galleryId);
		editionGalleryImpl.setGroupId(groupId);
		editionGalleryImpl.setCompanyId(companyId);
		editionGalleryImpl.setUserId(userId);

		if (userName == null) {
			editionGalleryImpl.setUserName("");
		}
		else {
			editionGalleryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			editionGalleryImpl.setCreateDate(null);
		}
		else {
			editionGalleryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			editionGalleryImpl.setModifiedDate(null);
		}
		else {
			editionGalleryImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (lastPublishDate == Long.MIN_VALUE) {
			editionGalleryImpl.setLastPublishDate(null);
		}
		else {
			editionGalleryImpl.setLastPublishDate(new Date(lastPublishDate));
		}

		editionGalleryImpl.setStatus(status);
		editionGalleryImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			editionGalleryImpl.setStatusByUserName("");
		}
		else {
			editionGalleryImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			editionGalleryImpl.setStatusDate(null);
		}
		else {
			editionGalleryImpl.setStatusDate(new Date(statusDate));
		}

		editionGalleryImpl.setImageId(imageId);

		if (title == null) {
			editionGalleryImpl.setTitle("");
		}
		else {
			editionGalleryImpl.setTitle(title);
		}

		if (description == null) {
			editionGalleryImpl.setDescription("");
		}
		else {
			editionGalleryImpl.setDescription(description);
		}

		if (publicationDate == Long.MIN_VALUE) {
			editionGalleryImpl.setPublicationDate(null);
		}
		else {
			editionGalleryImpl.setPublicationDate(new Date(publicationDate));
		}

		editionGalleryImpl.resetOriginalValues();

		return editionGalleryImpl;
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

		imageId = objectInput.readLong();
		title = objectInput.readUTF();
		description = (String)objectInput.readObject();
		publicationDate = objectInput.readLong();
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

		objectOutput.writeLong(publicationDate);
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
	public long imageId;
	public String title;
	public String description;
	public long publicationDate;

}