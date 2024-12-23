/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.agenda.model.Campaign;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Campaign in entity cache.
 *
 * @author BenjaminBini
 * @generated
 */
public class CampaignCacheModel
	implements CacheModel<Campaign>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CampaignCacheModel)) {
			return false;
		}

		CampaignCacheModel campaignCacheModel = (CampaignCacheModel)object;

		if (campaignId == campaignCacheModel.campaignId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, campaignId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(43);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", campaignId=");
		sb.append(campaignId);
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
		sb.append(", lastPublishDate=");
		sb.append(lastPublishDate);
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
		sb.append(", defaultImageId=");
		sb.append(defaultImageId);
		sb.append(", defaultImageCopyright=");
		sb.append(defaultImageCopyright);
		sb.append(", managersIds=");
		sb.append(managersIds);
		sb.append(", exportEnabled=");
		sb.append(exportEnabled);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", provider=");
		sb.append(provider);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Campaign toEntityModel() {
		CampaignImpl campaignImpl = new CampaignImpl();

		if (uuid == null) {
			campaignImpl.setUuid("");
		}
		else {
			campaignImpl.setUuid(uuid);
		}

		campaignImpl.setCampaignId(campaignId);
		campaignImpl.setGroupId(groupId);
		campaignImpl.setCompanyId(companyId);
		campaignImpl.setUserId(userId);

		if (userName == null) {
			campaignImpl.setUserName("");
		}
		else {
			campaignImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			campaignImpl.setCreateDate(null);
		}
		else {
			campaignImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			campaignImpl.setModifiedDate(null);
		}
		else {
			campaignImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (lastPublishDate == Long.MIN_VALUE) {
			campaignImpl.setLastPublishDate(null);
		}
		else {
			campaignImpl.setLastPublishDate(new Date(lastPublishDate));
		}

		campaignImpl.setStatus(status);
		campaignImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			campaignImpl.setStatusByUserName("");
		}
		else {
			campaignImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			campaignImpl.setStatusDate(null);
		}
		else {
			campaignImpl.setStatusDate(new Date(statusDate));
		}

		if (title == null) {
			campaignImpl.setTitle("");
		}
		else {
			campaignImpl.setTitle(title);
		}

		campaignImpl.setDefaultImageId(defaultImageId);

		if (defaultImageCopyright == null) {
			campaignImpl.setDefaultImageCopyright("");
		}
		else {
			campaignImpl.setDefaultImageCopyright(defaultImageCopyright);
		}

		if (managersIds == null) {
			campaignImpl.setManagersIds("");
		}
		else {
			campaignImpl.setManagersIds(managersIds);
		}

		campaignImpl.setExportEnabled(exportEnabled);

		if (startDate == Long.MIN_VALUE) {
			campaignImpl.setStartDate(null);
		}
		else {
			campaignImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			campaignImpl.setEndDate(null);
		}
		else {
			campaignImpl.setEndDate(new Date(endDate));
		}

		if (provider == null) {
			campaignImpl.setProvider("");
		}
		else {
			campaignImpl.setProvider(provider);
		}

		campaignImpl.resetOriginalValues();

		return campaignImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		campaignId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		lastPublishDate = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
		title = objectInput.readUTF();

		defaultImageId = objectInput.readLong();
		defaultImageCopyright = objectInput.readUTF();
		managersIds = objectInput.readUTF();

		exportEnabled = objectInput.readBoolean();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
		provider = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(campaignId);

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
		objectOutput.writeLong(lastPublishDate);

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

		objectOutput.writeLong(defaultImageId);

		if (defaultImageCopyright == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(defaultImageCopyright);
		}

		if (managersIds == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(managersIds);
		}

		objectOutput.writeBoolean(exportEnabled);
		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);

		if (provider == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(provider);
		}
	}

	public String uuid;
	public long campaignId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long lastPublishDate;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public String title;
	public long defaultImageId;
	public String defaultImageCopyright;
	public String managersIds;
	public boolean exportEnabled;
	public long startDate;
	public long endDate;
	public String provider;

}