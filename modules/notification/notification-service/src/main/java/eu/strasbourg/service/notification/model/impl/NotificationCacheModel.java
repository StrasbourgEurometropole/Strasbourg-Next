/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.notification.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.notification.model.Notification;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Notification in entity cache.
 *
 * @author BenjaminBini
 * @generated
 */
public class NotificationCacheModel
	implements CacheModel<Notification>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof NotificationCacheModel)) {
			return false;
		}

		NotificationCacheModel notificationCacheModel =
			(NotificationCacheModel)object;

		if (notificationId == notificationCacheModel.notificationId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, notificationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{notificationId=");
		sb.append(notificationId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", url=");
		sb.append(url);
		sb.append(", automatic=");
		sb.append(automatic);
		sb.append(", singleUser=");
		sb.append(singleUser);
		sb.append(", singleUserId=");
		sb.append(singleUserId);
		sb.append(", publicationDate=");
		sb.append(publicationDate);
		sb.append(", expirationDate=");
		sb.append(expirationDate);
		sb.append(", status=");
		sb.append(status);
		sb.append(", typeId=");
		sb.append(typeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Notification toEntityModel() {
		NotificationImpl notificationImpl = new NotificationImpl();

		notificationImpl.setNotificationId(notificationId);

		if (title == null) {
			notificationImpl.setTitle("");
		}
		else {
			notificationImpl.setTitle(title);
		}

		if (description == null) {
			notificationImpl.setDescription("");
		}
		else {
			notificationImpl.setDescription(description);
		}

		if (url == null) {
			notificationImpl.setUrl("");
		}
		else {
			notificationImpl.setUrl(url);
		}

		notificationImpl.setAutomatic(automatic);
		notificationImpl.setSingleUser(singleUser);

		if (singleUserId == null) {
			notificationImpl.setSingleUserId("");
		}
		else {
			notificationImpl.setSingleUserId(singleUserId);
		}

		if (publicationDate == Long.MIN_VALUE) {
			notificationImpl.setPublicationDate(null);
		}
		else {
			notificationImpl.setPublicationDate(new Date(publicationDate));
		}

		if (expirationDate == Long.MIN_VALUE) {
			notificationImpl.setExpirationDate(null);
		}
		else {
			notificationImpl.setExpirationDate(new Date(expirationDate));
		}

		notificationImpl.setStatus(status);
		notificationImpl.setTypeId(typeId);

		notificationImpl.resetOriginalValues();

		return notificationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		notificationId = objectInput.readLong();
		title = objectInput.readUTF();
		description = (String)objectInput.readObject();
		url = objectInput.readUTF();

		automatic = objectInput.readBoolean();

		singleUser = objectInput.readBoolean();
		singleUserId = objectInput.readUTF();
		publicationDate = objectInput.readLong();
		expirationDate = objectInput.readLong();

		status = objectInput.readInt();

		typeId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(notificationId);

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

		if (url == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(url);
		}

		objectOutput.writeBoolean(automatic);

		objectOutput.writeBoolean(singleUser);

		if (singleUserId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(singleUserId);
		}

		objectOutput.writeLong(publicationDate);
		objectOutput.writeLong(expirationDate);

		objectOutput.writeInt(status);

		objectOutput.writeLong(typeId);
	}

	public long notificationId;
	public String title;
	public String description;
	public String url;
	public boolean automatic;
	public boolean singleUser;
	public String singleUserId;
	public long publicationDate;
	public long expirationDate;
	public int status;
	public long typeId;

}