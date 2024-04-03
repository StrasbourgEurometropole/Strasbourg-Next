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
public class OfficialTypeCouncilPK
	implements Comparable<OfficialTypeCouncilPK>, Serializable {

	public long officialId;
	public long typeId;

	public OfficialTypeCouncilPK() {
	}

	public OfficialTypeCouncilPK(long officialId, long typeId) {
		this.officialId = officialId;
		this.typeId = typeId;
	}

	public long getOfficialId() {
		return officialId;
	}

	public void setOfficialId(long officialId) {
		this.officialId = officialId;
	}

	public long getTypeId() {
		return typeId;
	}

	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}

	@Override
	public int compareTo(OfficialTypeCouncilPK pk) {
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

		if (typeId < pk.typeId) {
			value = -1;
		}
		else if (typeId > pk.typeId) {
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

		if (!(object instanceof OfficialTypeCouncilPK)) {
			return false;
		}

		OfficialTypeCouncilPK pk = (OfficialTypeCouncilPK)object;

		if ((officialId == pk.officialId) && (typeId == pk.typeId)) {
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
		hashCode = HashUtil.hash(hashCode, typeId);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("officialId=");

		sb.append(officialId);
		sb.append(", typeId=");

		sb.append(typeId);

		sb.append("}");

		return sb.toString();
	}

}