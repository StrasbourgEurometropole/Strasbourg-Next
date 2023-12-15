/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.service.persistence;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;

import java.io.Serializable;

/**
 * @author Cedric Henry
 * @generated
 */
public class CacheHoursJSONPK
	implements Comparable<CacheHoursJSONPK>, Serializable {

	public String stopCode;
	public int type;

	public CacheHoursJSONPK() {
	}

	public CacheHoursJSONPK(String stopCode, int type) {
		this.stopCode = stopCode;
		this.type = type;
	}

	public String getStopCode() {
		return stopCode;
	}

	public void setStopCode(String stopCode) {
		this.stopCode = stopCode;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public int compareTo(CacheHoursJSONPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		value = stopCode.compareTo(pk.stopCode);

		if (value != 0) {
			return value;
		}

		if (type < pk.type) {
			value = -1;
		}
		else if (type > pk.type) {
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

		if (!(object instanceof CacheHoursJSONPK)) {
			return false;
		}

		CacheHoursJSONPK pk = (CacheHoursJSONPK)object;

		if (stopCode.equals(pk.stopCode) && (type == pk.type)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, stopCode);
		hashCode = HashUtil.hash(hashCode, type);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("stopCode=");

		sb.append(stopCode);
		sb.append(", type=");

		sb.append(type);

		sb.append("}");

		return sb.toString();
	}

}