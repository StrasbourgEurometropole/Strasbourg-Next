/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.project.model.BudgetPhase;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BudgetPhase in entity cache.
 *
 * @author Cedric Henry
 * @generated
 */
public class BudgetPhaseCacheModel
	implements CacheModel<BudgetPhase>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof BudgetPhaseCacheModel)) {
			return false;
		}

		BudgetPhaseCacheModel budgetPhaseCacheModel =
			(BudgetPhaseCacheModel)object;

		if (budgetPhaseId == budgetPhaseCacheModel.budgetPhaseId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, budgetPhaseId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(45);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", budgetPhaseId=");
		sb.append(budgetPhaseId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
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
		sb.append(", description=");
		sb.append(description);
		sb.append(", numberOfVote=");
		sb.append(numberOfVote);
		sb.append(", isActive=");
		sb.append(isActive);
		sb.append(", beginDate=");
		sb.append(beginDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", depositUrl=");
		sb.append(depositUrl);
		sb.append(", beginVoteDate=");
		sb.append(beginVoteDate);
		sb.append(", endVoteDate=");
		sb.append(endVoteDate);
		sb.append(", voteUrl=");
		sb.append(voteUrl);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BudgetPhase toEntityModel() {
		BudgetPhaseImpl budgetPhaseImpl = new BudgetPhaseImpl();

		if (uuid == null) {
			budgetPhaseImpl.setUuid("");
		}
		else {
			budgetPhaseImpl.setUuid(uuid);
		}

		budgetPhaseImpl.setBudgetPhaseId(budgetPhaseId);
		budgetPhaseImpl.setGroupId(groupId);
		budgetPhaseImpl.setCompanyId(companyId);
		budgetPhaseImpl.setUserId(userId);

		if (userName == null) {
			budgetPhaseImpl.setUserName("");
		}
		else {
			budgetPhaseImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			budgetPhaseImpl.setCreateDate(null);
		}
		else {
			budgetPhaseImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			budgetPhaseImpl.setModifiedDate(null);
		}
		else {
			budgetPhaseImpl.setModifiedDate(new Date(modifiedDate));
		}

		budgetPhaseImpl.setStatus(status);
		budgetPhaseImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			budgetPhaseImpl.setStatusByUserName("");
		}
		else {
			budgetPhaseImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			budgetPhaseImpl.setStatusDate(null);
		}
		else {
			budgetPhaseImpl.setStatusDate(new Date(statusDate));
		}

		if (title == null) {
			budgetPhaseImpl.setTitle("");
		}
		else {
			budgetPhaseImpl.setTitle(title);
		}

		if (description == null) {
			budgetPhaseImpl.setDescription("");
		}
		else {
			budgetPhaseImpl.setDescription(description);
		}

		budgetPhaseImpl.setNumberOfVote(numberOfVote);
		budgetPhaseImpl.setIsActive(isActive);

		if (beginDate == Long.MIN_VALUE) {
			budgetPhaseImpl.setBeginDate(null);
		}
		else {
			budgetPhaseImpl.setBeginDate(new Date(beginDate));
		}

		if (endDate == Long.MIN_VALUE) {
			budgetPhaseImpl.setEndDate(null);
		}
		else {
			budgetPhaseImpl.setEndDate(new Date(endDate));
		}

		if (depositUrl == null) {
			budgetPhaseImpl.setDepositUrl("");
		}
		else {
			budgetPhaseImpl.setDepositUrl(depositUrl);
		}

		if (beginVoteDate == Long.MIN_VALUE) {
			budgetPhaseImpl.setBeginVoteDate(null);
		}
		else {
			budgetPhaseImpl.setBeginVoteDate(new Date(beginVoteDate));
		}

		if (endVoteDate == Long.MIN_VALUE) {
			budgetPhaseImpl.setEndVoteDate(null);
		}
		else {
			budgetPhaseImpl.setEndVoteDate(new Date(endVoteDate));
		}

		if (voteUrl == null) {
			budgetPhaseImpl.setVoteUrl("");
		}
		else {
			budgetPhaseImpl.setVoteUrl(voteUrl);
		}

		budgetPhaseImpl.resetOriginalValues();

		return budgetPhaseImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		budgetPhaseId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
		title = objectInput.readUTF();
		description = objectInput.readUTF();

		numberOfVote = objectInput.readLong();

		isActive = objectInput.readBoolean();
		beginDate = objectInput.readLong();
		endDate = objectInput.readLong();
		depositUrl = objectInput.readUTF();
		beginVoteDate = objectInput.readLong();
		endVoteDate = objectInput.readLong();
		voteUrl = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(budgetPhaseId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

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

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(numberOfVote);

		objectOutput.writeBoolean(isActive);
		objectOutput.writeLong(beginDate);
		objectOutput.writeLong(endDate);

		if (depositUrl == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(depositUrl);
		}

		objectOutput.writeLong(beginVoteDate);
		objectOutput.writeLong(endVoteDate);

		if (voteUrl == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(voteUrl);
		}
	}

	public String uuid;
	public long budgetPhaseId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public String title;
	public String description;
	public long numberOfVote;
	public boolean isActive;
	public long beginDate;
	public long endDate;
	public String depositUrl;
	public long beginVoteDate;
	public long endVoteDate;
	public String voteUrl;

}