/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.notif.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

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