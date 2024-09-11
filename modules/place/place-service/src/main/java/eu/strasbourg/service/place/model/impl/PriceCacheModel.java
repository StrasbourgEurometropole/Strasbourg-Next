/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.place.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.place.model.Price;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Price in entity cache.
 *
 * @author Angelique Zunino Champougny
 * @generated
 */
public class PriceCacheModel implements CacheModel<Price>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PriceCacheModel)) {
			return false;
		}

		PriceCacheModel priceCacheModel = (PriceCacheModel)object;

		if (priceId == priceCacheModel.priceId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, priceId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", priceId=");
		sb.append(priceId);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", title=");
		sb.append(title);
		sb.append(", priceDescription=");
		sb.append(priceDescription);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Price toEntityModel() {
		PriceImpl priceImpl = new PriceImpl();

		if (uuid == null) {
			priceImpl.setUuid("");
		}
		else {
			priceImpl.setUuid(uuid);
		}

		priceImpl.setPriceId(priceId);
		priceImpl.setStatus(status);
		priceImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			priceImpl.setStatusByUserName("");
		}
		else {
			priceImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			priceImpl.setStatusDate(null);
		}
		else {
			priceImpl.setStatusDate(new Date(statusDate));
		}

		if (title == null) {
			priceImpl.setTitle("");
		}
		else {
			priceImpl.setTitle(title);
		}

		if (priceDescription == null) {
			priceImpl.setPriceDescription("");
		}
		else {
			priceImpl.setPriceDescription(priceDescription);
		}

		priceImpl.resetOriginalValues();

		return priceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		uuid = objectInput.readUTF();

		priceId = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
		title = objectInput.readUTF();
		priceDescription = (String)objectInput.readObject();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(priceId);

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (priceDescription == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(priceDescription);
		}
	}

	public String uuid;
	public long priceId;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public String title;
	public String priceDescription;

}