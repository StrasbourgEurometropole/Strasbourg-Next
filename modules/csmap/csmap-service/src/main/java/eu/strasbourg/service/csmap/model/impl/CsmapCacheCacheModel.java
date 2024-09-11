/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.csmap.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.csmap.model.CsmapCache;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CsmapCache in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CsmapCacheCacheModel
	implements CacheModel<CsmapCache>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CsmapCacheCacheModel)) {
			return false;
		}

		CsmapCacheCacheModel csmapCacheCacheModel =
			(CsmapCacheCacheModel)object;

		if (cacheId == csmapCacheCacheModel.cacheId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, cacheId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{cacheId=");
		sb.append(cacheId);
		sb.append(", codeCache=");
		sb.append(codeCache);
		sb.append(", description=");
		sb.append(description);
		sb.append(", cacheJson=");
		sb.append(cacheJson);
		sb.append(", isLastProcessSuccess=");
		sb.append(isLastProcessSuccess);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", processedDate=");
		sb.append(processedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CsmapCache toEntityModel() {
		CsmapCacheImpl csmapCacheImpl = new CsmapCacheImpl();

		csmapCacheImpl.setCacheId(cacheId);
		csmapCacheImpl.setCodeCache(codeCache);

		if (description == null) {
			csmapCacheImpl.setDescription("");
		}
		else {
			csmapCacheImpl.setDescription(description);
		}

		if (cacheJson == null) {
			csmapCacheImpl.setCacheJson("");
		}
		else {
			csmapCacheImpl.setCacheJson(cacheJson);
		}

		csmapCacheImpl.setIsLastProcessSuccess(isLastProcessSuccess);

		if (modifiedDate == Long.MIN_VALUE) {
			csmapCacheImpl.setModifiedDate(null);
		}
		else {
			csmapCacheImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (processedDate == Long.MIN_VALUE) {
			csmapCacheImpl.setProcessedDate(null);
		}
		else {
			csmapCacheImpl.setProcessedDate(new Date(processedDate));
		}

		csmapCacheImpl.resetOriginalValues();

		return csmapCacheImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		cacheId = objectInput.readLong();

		codeCache = objectInput.readLong();
		description = objectInput.readUTF();
		cacheJson = objectInput.readUTF();

		isLastProcessSuccess = objectInput.readBoolean();
		modifiedDate = objectInput.readLong();
		processedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(cacheId);

		objectOutput.writeLong(codeCache);

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (cacheJson == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cacheJson);
		}

		objectOutput.writeBoolean(isLastProcessSuccess);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(processedDate);
	}

	public long cacheId;
	public long codeCache;
	public String description;
	public String cacheJson;
	public boolean isLastProcessSuccess;
	public long modifiedDate;
	public long processedDate;

}