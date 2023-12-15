/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.notification.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.notification.model.UserNotificationType;
import eu.strasbourg.service.notification.service.persistence.UserNotificationTypePK;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing UserNotificationType in entity cache.
 *
 * @author BenjaminBini
 * @generated
 */
public class UserNotificationTypeCacheModel
	implements CacheModel<UserNotificationType>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof UserNotificationTypeCacheModel)) {
			return false;
		}

		UserNotificationTypeCacheModel userNotificationTypeCacheModel =
			(UserNotificationTypeCacheModel)object;

		if (userNotificationTypePK.equals(
				userNotificationTypeCacheModel.userNotificationTypePK)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, userNotificationTypePK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{publikUserId=");
		sb.append(publikUserId);
		sb.append(", typeId=");
		sb.append(typeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserNotificationType toEntityModel() {
		UserNotificationTypeImpl userNotificationTypeImpl =
			new UserNotificationTypeImpl();

		if (publikUserId == null) {
			userNotificationTypeImpl.setPublikUserId("");
		}
		else {
			userNotificationTypeImpl.setPublikUserId(publikUserId);
		}

		userNotificationTypeImpl.setTypeId(typeId);

		userNotificationTypeImpl.resetOriginalValues();

		return userNotificationTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		publikUserId = objectInput.readUTF();

		typeId = objectInput.readLong();

		userNotificationTypePK = new UserNotificationTypePK(
			publikUserId, typeId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (publikUserId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(publikUserId);
		}

		objectOutput.writeLong(typeId);
	}

	public String publikUserId;
	public long typeId;
	public transient UserNotificationTypePK userNotificationTypePK;

}