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