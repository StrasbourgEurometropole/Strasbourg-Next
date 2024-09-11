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
public class UserNotificationStatusPK
	implements Comparable<UserNotificationStatusPK>, Serializable {

	public long notificationId;
	public String publikUserId;

	public UserNotificationStatusPK() {
	}

	public UserNotificationStatusPK(long notificationId, String publikUserId) {
		this.notificationId = notificationId;
		this.publikUserId = publikUserId;
	}

	public long getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(long notificationId) {
		this.notificationId = notificationId;
	}

	public String getPublikUserId() {
		return publikUserId;
	}

	public void setPublikUserId(String publikUserId) {
		this.publikUserId = publikUserId;
	}

	@Override
	public int compareTo(UserNotificationStatusPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (notificationId < pk.notificationId) {
			value = -1;
		}
		else if (notificationId > pk.notificationId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = publikUserId.compareTo(pk.publikUserId);

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

		if (!(object instanceof UserNotificationStatusPK)) {
			return false;
		}

		UserNotificationStatusPK pk = (UserNotificationStatusPK)object;

		if ((notificationId == pk.notificationId) &&
			publikUserId.equals(pk.publikUserId)) {

			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, notificationId);
		hashCode = HashUtil.hash(hashCode, publikUserId);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("notificationId=");

		sb.append(notificationId);
		sb.append(", publikUserId=");

		sb.append(publikUserId);

		sb.append("}");

		return sb.toString();
	}

}