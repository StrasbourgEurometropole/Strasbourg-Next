/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.council.service.persistence;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class VotePK implements Comparable<VotePK>, Serializable {

	public long officialId;
	public long deliberationId;

	public VotePK() {
	}

	public VotePK(long officialId, long deliberationId) {
		this.officialId = officialId;
		this.deliberationId = deliberationId;
	}

	public long getOfficialId() {
		return officialId;
	}

	public void setOfficialId(long officialId) {
		this.officialId = officialId;
	}

	public long getDeliberationId() {
		return deliberationId;
	}

	public void setDeliberationId(long deliberationId) {
		this.deliberationId = deliberationId;
	}

	@Override
	public int compareTo(VotePK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (officialId < pk.officialId) {
			value = -1;
		}
		else if (officialId > pk.officialId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (deliberationId < pk.deliberationId) {
			value = -1;
		}
		else if (deliberationId > pk.deliberationId) {
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

		if (!(object instanceof VotePK)) {
			return false;
		}

		VotePK pk = (VotePK)object;

		if ((officialId == pk.officialId) &&
			(deliberationId == pk.deliberationId)) {

			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, officialId);
		hashCode = HashUtil.hash(hashCode, deliberationId);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("officialId=");

		sb.append(officialId);
		sb.append(", deliberationId=");

		sb.append(deliberationId);

		sb.append("}");

		return sb.toString();
	}

}