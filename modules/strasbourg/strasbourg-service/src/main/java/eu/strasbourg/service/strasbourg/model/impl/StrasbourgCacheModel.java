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