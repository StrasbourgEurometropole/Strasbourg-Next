/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.notification.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.notification.model.UserNotificationChannel;
import eu.strasbourg.service.notification.service.persistence.UserNotificationChannelPK;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing UserNotificationChannel in entity cache.
 *
 * @author BenjaminBini
 * @generated
 */
public class UserNotificationChannelCacheModel
	implements CacheModel<UserNotificationChannel>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof UserNotificationChannelCacheModel)) {
			return false;
		}

		UserNotificationChannelCacheModel userNotificationChannelCacheModel =
			(UserNotificationChannelCacheModel)object;

		if (userNotificationChannelPK.equals(
				userNotificationChannelCacheModel.userNotificationChannelPK)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, userNotificationChannelPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{publikUserId=");
		sb.append(publikUserId);
		sb.append(", channelId=");
		sb.append(channelId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserNotificationChannel toEntityModel() {
		UserNotificationChannelImpl userNotificationChannelImpl =
			new UserNotificationChannelImpl();

		if (publikUserId == null) {
			userNotificationChannelImpl.setPublikUserId("");
		}
		else {
			userNotificationChannelImpl.setPublikUserId(publikUserId);
		}

		userNotificationChannelImpl.setChannelId(channelId);

		userNotificationChannelImpl.resetOriginalValues();

		return userNotificationChannelImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		publikUserId = objectInput.readUTF();

		channelId = objectInput.readLong();

		userNotificationChannelPK = new UserNotificationChannelPK(
			publikUserId, channelId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (publikUserId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(publikUserId);
		}

		objectOutput.writeLong(channelId);
	}

	public String publikUserId;
	public long channelId;
	public transient UserNotificationChannelPK userNotificationChannelPK;

}