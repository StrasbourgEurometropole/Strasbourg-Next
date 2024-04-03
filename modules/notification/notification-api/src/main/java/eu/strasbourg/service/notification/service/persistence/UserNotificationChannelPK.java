/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.notification.service.persistence;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;

import java.io.Serializable;

/**
 * @author BenjaminBini
 * @generated
 */
public class UserNotificationChannelPK
	implements Comparable<UserNotificationChannelPK>, Serializable {

	public String publikUserId;
	public long channelId;

	public UserNotificationChannelPK() {
	}

	public UserNotificationChannelPK(String publikUserId, long channelId) {
		this.publikUserId = publikUserId;
		this.channelId = channelId;
	}

	public String getPublikUserId() {
		return publikUserId;
	}

	public void setPublikUserId(String publikUserId) {
		this.publikUserId = publikUserId;
	}

	public long getChannelId() {
		return channelId;
	}

	public void setChannelId(long channelId) {
		this.channelId = channelId;
	}

	@Override
	public int compareTo(UserNotificationChannelPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		value = publikUserId.compareTo(pk.publikUserId);

		if (value != 0) {
			return value;
		}

		if (channelId < pk.channelId) {
			value = -1;
		}
		else if (channelId > pk.channelId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof UserNotificationChannelPK)) {
			return false;
		}

		UserNotificationChannelPK pk = (UserNotificationChannelPK)object;

		if (publikUserId.equals(pk.publikUserId) &&
			(channelId == pk.channelId)) {

			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, publikUserId);
		hashCode = HashUtil.hash(hashCode, channelId);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("publikUserId=");

		sb.append(publikUserId);
		sb.append(", channelId=");

		sb.append(channelId);

		sb.append("}");

		return sb.toString();
	}

}