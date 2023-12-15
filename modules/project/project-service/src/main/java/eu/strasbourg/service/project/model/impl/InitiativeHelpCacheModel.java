/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.project.model.InitiativeHelp;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing InitiativeHelp in entity cache.
 *
 * @author Cedric Henry
 * @generated
 */
public class InitiativeHelpCacheModel
	implements CacheModel<InitiativeHelp>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof InitiativeHelpCacheModel)) {
			return false;
		}

		InitiativeHelpCacheModel initiativeHelpCacheModel =
			(InitiativeHelpCacheModel)object;

		if (initiativeHelpId == initiativeHelpCacheModel.initiativeHelpId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, initiativeHelpId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", initiativeHelpId=");
		sb.append(initiativeHelpId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", publikUserId=");
		sb.append(publikUserId);
		sb.append(", initiativeId=");
		sb.append(initiativeId);
		sb.append(", helpTypes=");
		sb.append(helpTypes);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", message=");
		sb.append(message);
		sb.append(", helpDisplay=");
		sb.append(helpDisplay);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public InitiativeHelp toEntityModel() {
		InitiativeHelpImpl initiativeHelpImpl = new InitiativeHelpImpl();

		if (uuid == null) {
			initiativeHelpImpl.setUuid("");
		}
		else {
			initiativeHelpImpl.setUuid(uuid);
		}

		initiativeHelpImpl.setInitiativeHelpId(initiativeHelpId);

		if (createDate == Long.MIN_VALUE) {
			initiativeHelpImpl.setCreateDate(null);
		}
		else {
			initiativeHelpImpl.setCreateDate(new Date(createDate));
		}

		if (publikUserId == null) {
			initiativeHelpImpl.setPublikUserId("");
		}
		else {
			initiativeHelpImpl.setPublikUserId(publikUserId);
		}

		initiativeHelpImpl.setInitiativeId(initiativeId);

		if (helpTypes == null) {
			initiativeHelpImpl.setHelpTypes("");
		}
		else {
			initiativeHelpImpl.setHelpTypes(helpTypes);
		}

		initiativeHelpImpl.setGroupId(groupId);

		if (message == null) {
			initiativeHelpImpl.setMessage("");
		}
		else {
			initiativeHelpImpl.setMessage(message);
		}

		initiativeHelpImpl.setHelpDisplay(helpDisplay);

		initiativeHelpImpl.resetOriginalValues();

		return initiativeHelpImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		initiativeHelpId = objectInput.readLong();
		createDate = objectInput.readLong();
		publikUserId = objectInput.readUTF();

		initiativeId = objectInput.readLong();
		helpTypes = objectInput.readUTF();

		groupId = objectInput.readLong();
		message = objectInput.readUTF();

		helpDisplay = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(initiativeHelpId);
		objectOutput.writeLong(createDate);

		if (publikUserId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(publikUserId);
		}

		objectOutput.writeLong(initiativeId);

		if (helpTypes == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(helpTypes);
		}

		objectOutput.writeLong(groupId);

		if (message == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(message);
		}

		objectOutput.writeBoolean(helpDisplay);
	}

	public String uuid;
	public long initiativeHelpId;
	public long createDate;
	public String publikUserId;
	public long initiativeId;
	public String helpTypes;
	public long groupId;
	public String message;
	public boolean helpDisplay;

}