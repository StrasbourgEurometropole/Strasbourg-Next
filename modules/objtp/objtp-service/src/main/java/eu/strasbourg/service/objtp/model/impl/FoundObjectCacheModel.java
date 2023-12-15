/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.objtp.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.objtp.model.FoundObject;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FoundObject in entity cache.
 *
 * @author JeremyZwickert
 * @generated
 */
public class FoundObjectCacheModel
	implements CacheModel<FoundObject>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FoundObjectCacheModel)) {
			return false;
		}

		FoundObjectCacheModel foundObjectCacheModel =
			(FoundObjectCacheModel)object;

		if (number.equals(foundObjectCacheModel.number)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, number);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{number=");
		sb.append(number);
		sb.append(", date=");
		sb.append(date);
		sb.append(", imageUrl=");
		sb.append(imageUrl);
		sb.append(", categoryCode=");
		sb.append(categoryCode);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FoundObject toEntityModel() {
		FoundObjectImpl foundObjectImpl = new FoundObjectImpl();

		if (number == null) {
			foundObjectImpl.setNumber("");
		}
		else {
			foundObjectImpl.setNumber(number);
		}

		if (date == Long.MIN_VALUE) {
			foundObjectImpl.setDate(null);
		}
		else {
			foundObjectImpl.setDate(new Date(date));
		}

		if (imageUrl == null) {
			foundObjectImpl.setImageUrl("");
		}
		else {
			foundObjectImpl.setImageUrl(imageUrl);
		}

		if (categoryCode == null) {
			foundObjectImpl.setCategoryCode("");
		}
		else {
			foundObjectImpl.setCategoryCode(categoryCode);
		}

		foundObjectImpl.resetOriginalValues();

		return foundObjectImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		number = objectInput.readUTF();
		date = objectInput.readLong();
		imageUrl = objectInput.readUTF();
		categoryCode = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (number == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(number);
		}

		objectOutput.writeLong(date);

		if (imageUrl == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(imageUrl);
		}

		if (categoryCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(categoryCode);
		}
	}

	public String number;
	public long date;
	public String imageUrl;
	public String categoryCode;

}