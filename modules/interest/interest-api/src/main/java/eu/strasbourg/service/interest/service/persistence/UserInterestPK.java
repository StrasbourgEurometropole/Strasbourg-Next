/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.interest.service.persistence;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;

import java.io.Serializable;

/**
 * @author BenjaminBini
 * @generated
 */
public class UserInterestPK
	implements Comparable<UserInterestPK>, Serializable {

	public long interestId;
	public String publikUserId;

	public UserInterestPK() {
	}

	public UserInterestPK(long interestId, String publikUserId) {
		this.interestId = interestId;
		this.publikUserId = publikUserId;
	}

	public long getInterestId() {
		return interestId;
	}

	public void setInterestId(long interestId) {
		this.interestId = interestId;
	}

	public String getPublikUserId() {
		return publikUserId;
	}

	public void setPublikUserId(String publikUserId) {
		this.publikUserId = publikUserId;
	}

	@Override
	public int compareTo(UserInterestPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (interestId < pk.interestId) {
			value = -1;
		}
		else if (interestId > pk.interestId) {
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

		if (!(object instanceof UserInterestPK)) {
			return false;
		}

		UserInterestPK pk = (UserInterestPK)object;

		if ((interestId == pk.interestId) &&
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

		hashCode = HashUtil.hash(hashCode, interestId);
		hashCode = HashUtil.hash(hashCode, publikUserId);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("interestId=");

		sb.append(interestId);
		sb.append(", publikUserId=");

		sb.append(publikUserId);

		sb.append("}");

		return sb.toString();
	}

}