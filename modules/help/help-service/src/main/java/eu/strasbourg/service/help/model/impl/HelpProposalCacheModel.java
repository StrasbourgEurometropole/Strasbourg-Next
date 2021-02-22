/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package eu.strasbourg.service.help.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.help.model.HelpProposal;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing HelpProposal in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class HelpProposalCacheModel
	implements CacheModel<HelpProposal>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof HelpProposalCacheModel)) {
			return false;
		}

		HelpProposalCacheModel helpProposalCacheModel =
			(HelpProposalCacheModel)obj;

		if (helpProposalId == helpProposalCacheModel.helpProposalId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, helpProposalId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(47);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", helpProposalId=");
		sb.append(helpProposalId);
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
		sb.append(", inTheNameOf=");
		sb.append(inTheNameOf);
		sb.append(", address=");
		sb.append(address);
		sb.append(", city=");
		sb.append(city);
		sb.append(", postalCode=");
		sb.append(postalCode);
		sb.append(", modifiedByUserDate=");
		sb.append(modifiedByUserDate);
		sb.append(", spokenLanguages=");
		sb.append(spokenLanguages);
		sb.append(", imageId=");
		sb.append(imageId);
		sb.append(", publikId=");
		sb.append(publikId);
		sb.append(", publicationDate=");
		sb.append(publicationDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public HelpProposal toEntityModel() {
		HelpProposalImpl helpProposalImpl = new HelpProposalImpl();

		if (uuid == null) {
			helpProposalImpl.setUuid("");
		}
		else {
			helpProposalImpl.setUuid(uuid);
		}

		helpProposalImpl.setHelpProposalId(helpProposalId);
		helpProposalImpl.setGroupId(groupId);
		helpProposalImpl.setCompanyId(companyId);
		helpProposalImpl.setUserId(userId);

		if (userName == null) {
			helpProposalImpl.setUserName("");
		}
		else {
			helpProposalImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			helpProposalImpl.setCreateDate(null);
		}
		else {
			helpProposalImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			helpProposalImpl.setModifiedDate(null);
		}
		else {
			helpProposalImpl.setModifiedDate(new Date(modifiedDate));
		}

		helpProposalImpl.setStatus(status);
		helpProposalImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			helpProposalImpl.setStatusByUserName("");
		}
		else {
			helpProposalImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			helpProposalImpl.setStatusDate(null);
		}
		else {
			helpProposalImpl.setStatusDate(new Date(statusDate));
		}

		if (title == null) {
			helpProposalImpl.setTitle("");
		}
		else {
			helpProposalImpl.setTitle(title);
		}

		if (description == null) {
			helpProposalImpl.setDescription("");
		}
		else {
			helpProposalImpl.setDescription(description);
		}

		if (inTheNameOf == null) {
			helpProposalImpl.setInTheNameOf("");
		}
		else {
			helpProposalImpl.setInTheNameOf(inTheNameOf);
		}

		if (address == null) {
			helpProposalImpl.setAddress("");
		}
		else {
			helpProposalImpl.setAddress(address);
		}

		if (city == null) {
			helpProposalImpl.setCity("");
		}
		else {
			helpProposalImpl.setCity(city);
		}

		helpProposalImpl.setPostalCode(postalCode);

		if (modifiedByUserDate == Long.MIN_VALUE) {
			helpProposalImpl.setModifiedByUserDate(null);
		}
		else {
			helpProposalImpl.setModifiedByUserDate(
				new Date(modifiedByUserDate));
		}

		if (spokenLanguages == null) {
			helpProposalImpl.setSpokenLanguages("");
		}
		else {
			helpProposalImpl.setSpokenLanguages(spokenLanguages);
		}

		helpProposalImpl.setImageId(imageId);

		if (publikId == null) {
			helpProposalImpl.setPublikId("");
		}
		else {
			helpProposalImpl.setPublikId(publikId);
		}

		if (publicationDate == Long.MIN_VALUE) {
			helpProposalImpl.setPublicationDate(null);
		}
		else {
			helpProposalImpl.setPublicationDate(new Date(publicationDate));
		}

		helpProposalImpl.resetOriginalValues();

		return helpProposalImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		helpProposalId = objectInput.readLong();

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
		inTheNameOf = objectInput.readUTF();
		address = objectInput.readUTF();
		city = objectInput.readUTF();

		postalCode = objectInput.readLong();
		modifiedByUserDate = objectInput.readLong();
		spokenLanguages = objectInput.readUTF();

		imageId = objectInput.readLong();
		publikId = objectInput.readUTF();
		publicationDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(helpProposalId);

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

		if (inTheNameOf == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(inTheNameOf);
		}

		if (address == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address);
		}

		if (city == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(city);
		}

		objectOutput.writeLong(postalCode);
		objectOutput.writeLong(modifiedByUserDate);

		if (spokenLanguages == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(spokenLanguages);
		}

		objectOutput.writeLong(imageId);

		if (publikId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(publikId);
		}

		objectOutput.writeLong(publicationDate);
	}

	public String uuid;
	public long helpProposalId;
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
	public String inTheNameOf;
	public String address;
	public String city;
	public long postalCode;
	public long modifiedByUserDate;
	public String spokenLanguages;
	public long imageId;
	public String publikId;
	public long publicationDate;

}