/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.council.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.council.model.Vote;
import eu.strasbourg.service.council.service.persistence.VotePK;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Vote in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class VoteCacheModel implements CacheModel<Vote>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof VoteCacheModel)) {
			return false;
		}

		VoteCacheModel voteCacheModel = (VoteCacheModel)object;

		if (votePK.equals(voteCacheModel.votePK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, votePK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", officialId=");
		sb.append(officialId);
		sb.append(", deliberationId=");
		sb.append(deliberationId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", result=");
		sb.append(result);
		sb.append(", officialProcurationId=");
		sb.append(officialProcurationId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Vote toEntityModel() {
		VoteImpl voteImpl = new VoteImpl();

		if (uuid == null) {
			voteImpl.setUuid("");
		}
		else {
			voteImpl.setUuid(uuid);
		}

		voteImpl.setOfficialId(officialId);
		voteImpl.setDeliberationId(deliberationId);
		voteImpl.setGroupId(groupId);
		voteImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			voteImpl.setCreateDate(null);
		}
		else {
			voteImpl.setCreateDate(new Date(createDate));
		}

		if (result == null) {
			voteImpl.setResult("");
		}
		else {
			voteImpl.setResult(result);
		}

		voteImpl.setOfficialProcurationId(officialProcurationId);

		voteImpl.resetOriginalValues();

		return voteImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		officialId = objectInput.readLong();

		deliberationId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		result = objectInput.readUTF();

		officialProcurationId = objectInput.readLong();

		votePK = new VotePK(officialId, deliberationId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(officialId);

		objectOutput.writeLong(deliberationId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);

		if (result == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(result);
		}

		objectOutput.writeLong(officialProcurationId);
	}

	public String uuid;
	public long officialId;
	public long deliberationId;
	public long groupId;
	public long companyId;
	public long createDate;
	public String result;
	public long officialProcurationId;
	public transient VotePK votePK;

}