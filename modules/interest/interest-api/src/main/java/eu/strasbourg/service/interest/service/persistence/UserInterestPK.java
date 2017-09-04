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

package eu.strasbourg.service.interest.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author BenjaminBini
 * @generated
 */
@ProviderType
public class UserInterestPK implements Comparable<UserInterestPK>, Serializable {
	public long interestId;
	public long publikUserId;

	public UserInterestPK() {
	}

	public UserInterestPK(long interestId, long publikUserId) {
		this.interestId = interestId;
		this.publikUserId = publikUserId;
	}

	public long getInterestId() {
		return interestId;
	}

	public void setInterestId(long interestId) {
		this.interestId = interestId;
	}

	public long getPublikUserId() {
		return publikUserId;
	}

	public void setPublikUserId(long publikUserId) {
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

		if (publikUserId < pk.publikUserId) {
			value = -1;
		}
		else if (publikUserId > pk.publikUserId) {
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
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserInterestPK)) {
			return false;
		}

		UserInterestPK pk = (UserInterestPK)obj;

		if ((interestId == pk.interestId) && (publikUserId == pk.publikUserId)) {
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
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("interestId");
		sb.append(StringPool.EQUAL);
		sb.append(interestId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("publikUserId");
		sb.append(StringPool.EQUAL);
		sb.append(publikUserId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}