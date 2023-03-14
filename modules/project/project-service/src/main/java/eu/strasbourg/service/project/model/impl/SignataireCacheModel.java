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

package eu.strasbourg.service.project.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import eu.strasbourg.service.project.model.Signataire;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Date;

/**
 * The cache model class for representing Signataire in entity cache.
 *
 * @author Cedric Henry
 * @generated
 */
public class SignataireCacheModel
	implements CacheModel<Signataire>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SignataireCacheModel)) {
			return false;
		}

		SignataireCacheModel signataireCacheModel =
			(SignataireCacheModel)object;

		if (signataireId == signataireCacheModel.signataireId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, signataireId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(49);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", signataireId=");
		sb.append(signataireId);
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
		sb.append(", signataireName=");
		sb.append(signataireName);
		sb.append(", signataireFirstname=");
		sb.append(signataireFirstname);
		sb.append(", birthday=");
		sb.append(birthday);
		sb.append(", address=");
		sb.append(address);
		sb.append(", mail=");
		sb.append(mail);
		sb.append(", postalCode=");
		sb.append(postalCode);
		sb.append(", mobilePhone=");
		sb.append(mobilePhone);
		sb.append(", phone=");
		sb.append(phone);
		sb.append(", city=");
		sb.append(city);
		sb.append(", signatureDate=");
		sb.append(signatureDate);
		sb.append(", publikUserId=");
		sb.append(publikUserId);
		sb.append(", petitionId=");
		sb.append(petitionId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Signataire toEntityModel() {
		SignataireImpl signataireImpl = new SignataireImpl();

		if (uuid == null) {
			signataireImpl.setUuid("");
		}
		else {
			signataireImpl.setUuid(uuid);
		}

		signataireImpl.setSignataireId(signataireId);
		signataireImpl.setGroupId(groupId);
		signataireImpl.setCompanyId(companyId);
		signataireImpl.setUserId(userId);

		if (userName == null) {
			signataireImpl.setUserName("");
		}
		else {
			signataireImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			signataireImpl.setCreateDate(null);
		}
		else {
			signataireImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			signataireImpl.setModifiedDate(null);
		}
		else {
			signataireImpl.setModifiedDate(new Date(modifiedDate));
		}

		signataireImpl.setStatus(status);
		signataireImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			signataireImpl.setStatusByUserName("");
		}
		else {
			signataireImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			signataireImpl.setStatusDate(null);
		}
		else {
			signataireImpl.setStatusDate(new Date(statusDate));
		}

		if (signataireName == null) {
			signataireImpl.setSignataireName("");
		}
		else {
			signataireImpl.setSignataireName(signataireName);
		}

		if (signataireFirstname == null) {
			signataireImpl.setSignataireFirstname("");
		}
		else {
			signataireImpl.setSignataireFirstname(signataireFirstname);
		}

		if (birthday == Long.MIN_VALUE) {
			signataireImpl.setBirthday(null);
		}
		else {
			signataireImpl.setBirthday(new Date(birthday));
		}

		if (address == null) {
			signataireImpl.setAddress("");
		}
		else {
			signataireImpl.setAddress(address);
		}

		if (mail == null) {
			signataireImpl.setMail("");
		}
		else {
			signataireImpl.setMail(mail);
		}

		signataireImpl.setPostalCode(postalCode);

		if (mobilePhone == null) {
			signataireImpl.setMobilePhone("");
		}
		else {
			signataireImpl.setMobilePhone(mobilePhone);
		}

		if (phone == null) {
			signataireImpl.setPhone("");
		}
		else {
			signataireImpl.setPhone(phone);
		}

		if (city == null) {
			signataireImpl.setCity("");
		}
		else {
			signataireImpl.setCity(city);
		}

		if (signatureDate == Long.MIN_VALUE) {
			signataireImpl.setSignatureDate(null);
		}
		else {
			signataireImpl.setSignatureDate(new Date(signatureDate));
		}

		if (publikUserId == null) {
			signataireImpl.setPublikUserId("");
		}
		else {
			signataireImpl.setPublikUserId(publikUserId);
		}

		signataireImpl.setPetitionId(petitionId);

		signataireImpl.resetOriginalValues();

		return signataireImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		signataireId = objectInput.readLong();

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
		signataireName = objectInput.readUTF();
		signataireFirstname = objectInput.readUTF();
		birthday = objectInput.readLong();
		address = objectInput.readUTF();
		mail = objectInput.readUTF();

		postalCode = objectInput.readLong();
		mobilePhone = objectInput.readUTF();
		phone = objectInput.readUTF();
		city = objectInput.readUTF();
		signatureDate = objectInput.readLong();
		publikUserId = objectInput.readUTF();

		petitionId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(signataireId);

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

		if (signataireName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(signataireName);
		}

		if (signataireFirstname == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(signataireFirstname);
		}

		objectOutput.writeLong(birthday);

		if (address == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address);
		}

		if (mail == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mail);
		}

		objectOutput.writeLong(postalCode);

		if (mobilePhone == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mobilePhone);
		}

		if (phone == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(phone);
		}

		if (city == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(city);
		}

		objectOutput.writeLong(signatureDate);

		if (publikUserId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(publikUserId);
		}

		objectOutput.writeLong(petitionId);
	}

	public String uuid;
	public long signataireId;
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
	public String signataireName;
	public String signataireFirstname;
	public long birthday;
	public String address;
	public String mail;
	public long postalCode;
	public String mobilePhone;
	public String phone;
	public String city;
	public long signatureDate;
	public String publikUserId;
	public long petitionId;

}