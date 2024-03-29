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

package eu.strasbourg.service.notif.model.impl;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import eu.strasbourg.service.notif.model.NatureNotif;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing NatureNotif in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class NatureNotifCacheModel
	implements CacheModel<NatureNotif>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof NatureNotifCacheModel)) {
			return false;
		}

		NatureNotifCacheModel natureNotifCacheModel =
			(NatureNotifCacheModel)object;

		if (natureId == natureNotifCacheModel.natureId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, natureId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{natureId=");
		sb.append(natureId);
		sb.append(", serviceId=");
		sb.append(serviceId);
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public NatureNotif toEntityModel() {
		NatureNotifImpl natureNotifImpl = new NatureNotifImpl();

		natureNotifImpl.setNatureId(natureId);
		natureNotifImpl.setServiceId(serviceId);

		if (name == null) {
			natureNotifImpl.setName("");
		}
		else {
			natureNotifImpl.setName(name);
		}

		natureNotifImpl.resetOriginalValues();

		return natureNotifImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		natureId = objectInput.readLong();

		serviceId = objectInput.readLong();
		name = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(natureId);

		objectOutput.writeLong(serviceId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}
	}

	public long natureId;
	public long serviceId;
	public String name;

}