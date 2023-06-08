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

package eu.strasbourg.service.notification.service.persistence;

import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

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