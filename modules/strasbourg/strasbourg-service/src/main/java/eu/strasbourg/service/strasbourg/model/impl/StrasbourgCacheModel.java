/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.strasbourg.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.strasbourg.model.Strasbourg;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Strasbourg in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class StrasbourgCacheModel
	implements CacheModel<Strasbourg>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof StrasbourgCacheModel)) {
			return false;
		}

		StrasbourgCacheModel strasbourgCacheModel =
			(StrasbourgCacheModel)object;

		if (id == strasbourgCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", id=");
		sb.append(id);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Strasbourg toEntityModel() {
		StrasbourgImpl strasbourgImpl = new StrasbourgImpl();

		if (uuid == null) {
			strasbourgImpl.setUuid("");
		}
		else {
			strasbourgImpl.setUuid(uuid);
		}

		strasbourgImpl.setId(id);

		strasbourgImpl.resetOriginalValues();

		return strasbourgImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		id = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(id);
	}

	public String uuid;
	public long id;

}