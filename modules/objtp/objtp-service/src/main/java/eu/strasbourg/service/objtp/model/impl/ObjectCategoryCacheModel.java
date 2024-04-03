/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.objtp.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.objtp.model.ObjectCategory;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ObjectCategory in entity cache.
 *
 * @author JeremyZwickert
 * @generated
 */
public class ObjectCategoryCacheModel
	implements CacheModel<ObjectCategory>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ObjectCategoryCacheModel)) {
			return false;
		}

		ObjectCategoryCacheModel objectCategoryCacheModel =
			(ObjectCategoryCacheModel)object;

		if (code.equals(objectCategoryCacheModel.code)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, code);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{code=");
		sb.append(code);
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ObjectCategory toEntityModel() {
		ObjectCategoryImpl objectCategoryImpl = new ObjectCategoryImpl();

		if (code == null) {
			objectCategoryImpl.setCode("");
		}
		else {
			objectCategoryImpl.setCode(code);
		}

		if (name == null) {
			objectCategoryImpl.setName("");
		}
		else {
			objectCategoryImpl.setName(name);
		}

		objectCategoryImpl.resetOriginalValues();

		return objectCategoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		code = objectInput.readUTF();
		name = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (code == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(code);
		}

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}
	}

	public String code;
	public String name;

}