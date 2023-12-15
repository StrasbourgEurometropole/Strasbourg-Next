/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.csmap.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.csmap.model.PlaceCategories;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing PlaceCategories in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PlaceCategoriesCacheModel
	implements CacheModel<PlaceCategories>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PlaceCategoriesCacheModel)) {
			return false;
		}

		PlaceCategoriesCacheModel placeCategoriesCacheModel =
			(PlaceCategoriesCacheModel)object;

		if (placeCategoriesId == placeCategoriesCacheModel.placeCategoriesId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, placeCategoriesId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", placeCategoriesId=");
		sb.append(placeCategoriesId);
		sb.append(", categoriesIds=");
		sb.append(categoriesIds);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PlaceCategories toEntityModel() {
		PlaceCategoriesImpl placeCategoriesImpl = new PlaceCategoriesImpl();

		if (uuid == null) {
			placeCategoriesImpl.setUuid("");
		}
		else {
			placeCategoriesImpl.setUuid(uuid);
		}

		placeCategoriesImpl.setPlaceCategoriesId(placeCategoriesId);

		if (categoriesIds == null) {
			placeCategoriesImpl.setCategoriesIds("");
		}
		else {
			placeCategoriesImpl.setCategoriesIds(categoriesIds);
		}

		placeCategoriesImpl.resetOriginalValues();

		return placeCategoriesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		placeCategoriesId = objectInput.readLong();
		categoriesIds = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(placeCategoriesId);

		if (categoriesIds == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(categoriesIds);
		}
	}

	public String uuid;
	public long placeCategoriesId;
	public String categoriesIds;

}