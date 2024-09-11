/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.csmap.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.csmap.model.BaseNonce;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BaseNonce in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BaseNonceCacheModel
	implements CacheModel<BaseNonce>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof BaseNonceCacheModel)) {
			return false;
		}

		BaseNonceCacheModel baseNonceCacheModel = (BaseNonceCacheModel)object;

		if (baseNonceId == baseNonceCacheModel.baseNonceId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, baseNonceId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{baseNonceId=");
		sb.append(baseNonceId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", value=");
		sb.append(value);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BaseNonce toEntityModel() {
		BaseNonceImpl baseNonceImpl = new BaseNonceImpl();

		baseNonceImpl.setBaseNonceId(baseNonceId);

		if (createDate == Long.MIN_VALUE) {
			baseNonceImpl.setCreateDate(null);
		}
		else {
			baseNonceImpl.setCreateDate(new Date(createDate));
		}

		if (value == null) {
			baseNonceImpl.setValue("");
		}
		else {
			baseNonceImpl.setValue(value);
		}

		baseNonceImpl.resetOriginalValues();

		return baseNonceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		baseNonceId = objectInput.readLong();
		createDate = objectInput.readLong();
		value = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(baseNonceId);
		objectOutput.writeLong(createDate);

		if (value == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(value);
		}
	}

	public long baseNonceId;
	public long createDate;
	public String value;

}