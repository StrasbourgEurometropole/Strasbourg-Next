/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.activity.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.activity.model.Association;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Association in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AssociationCacheModel
	implements CacheModel<Association>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AssociationCacheModel)) {
			return false;
		}

		AssociationCacheModel associationCacheModel =
			(AssociationCacheModel)object;

		if (associationId == associationCacheModel.associationId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, associationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", associationId=");
		sb.append(associationId);
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
		sb.append(", name=");
		sb.append(name);
		sb.append(", presentation=");
		sb.append(presentation);
		sb.append(", phone=");
		sb.append(phone);
		sb.append(", siteURL=");
		sb.append(siteURL);
		sb.append(", mail=");
		sb.append(mail);
		sb.append(", facebookURL=");
		sb.append(facebookURL);
		sb.append(", othersInformations=");
		sb.append(othersInformations);
		sb.append(", order=");
		sb.append(order);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Association toEntityModel() {
		AssociationImpl associationImpl = new AssociationImpl();

		if (uuid == null) {
			associationImpl.setUuid("");
		}
		else {
			associationImpl.setUuid(uuid);
		}

		associationImpl.setAssociationId(associationId);
		associationImpl.setGroupId(groupId);
		associationImpl.setCompanyId(companyId);
		associationImpl.setUserId(userId);

		if (userName == null) {
			associationImpl.setUserName("");
		}
		else {
			associationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			associationImpl.setCreateDate(null);
		}
		else {
			associationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			associationImpl.setModifiedDate(null);
		}
		else {
			associationImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			associationImpl.setName("");
		}
		else {
			associationImpl.setName(name);
		}

		if (presentation == null) {
			associationImpl.setPresentation("");
		}
		else {
			associationImpl.setPresentation(presentation);
		}

		if (phone == null) {
			associationImpl.setPhone("");
		}
		else {
			associationImpl.setPhone(phone);
		}

		if (siteURL == null) {
			associationImpl.setSiteURL("");
		}
		else {
			associationImpl.setSiteURL(siteURL);
		}

		if (mail == null) {
			associationImpl.setMail("");
		}
		else {
			associationImpl.setMail(mail);
		}

		if (facebookURL == null) {
			associationImpl.setFacebookURL("");
		}
		else {
			associationImpl.setFacebookURL(facebookURL);
		}

		if (othersInformations == null) {
			associationImpl.setOthersInformations("");
		}
		else {
			associationImpl.setOthersInformations(othersInformations);
		}

		associationImpl.setOrder(order);
		associationImpl.setStatus(status);
		associationImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			associationImpl.setStatusByUserName("");
		}
		else {
			associationImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			associationImpl.setStatusDate(null);
		}
		else {
			associationImpl.setStatusDate(new Date(statusDate));
		}

		associationImpl.resetOriginalValues();

		return associationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		uuid = objectInput.readUTF();

		associationId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		presentation = (String)objectInput.readObject();
		phone = objectInput.readUTF();
		siteURL = objectInput.readUTF();
		mail = objectInput.readUTF();
		facebookURL = objectInput.readUTF();
		othersInformations = (String)objectInput.readObject();

		order = objectInput.readInt();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(associationId);

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

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (presentation == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(presentation);
		}

		if (phone == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(phone);
		}

		if (siteURL == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(siteURL);
		}

		if (mail == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mail);
		}

		if (facebookURL == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(facebookURL);
		}

		if (othersInformations == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(othersInformations);
		}

		objectOutput.writeInt(order);

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);
	}

	public String uuid;
	public long associationId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String presentation;
	public String phone;
	public String siteURL;
	public String mail;
	public String facebookURL;
	public String othersInformations;
	public int order;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;

}