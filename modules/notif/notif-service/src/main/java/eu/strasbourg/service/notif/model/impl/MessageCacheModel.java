/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.notif.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.notif.model.Message;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Message in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MessageCacheModel implements CacheModel<Message>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof MessageCacheModel)) {
			return false;
		}

		MessageCacheModel messageCacheModel = (MessageCacheModel)object;

		if (messageId == messageCacheModel.messageId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, messageId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{messageId=");
		sb.append(messageId);
		sb.append(", serviceId=");
		sb.append(serviceId);
		sb.append(", content=");
		sb.append(content);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Message toEntityModel() {
		MessageImpl messageImpl = new MessageImpl();

		messageImpl.setMessageId(messageId);
		messageImpl.setServiceId(serviceId);

		if (content == null) {
			messageImpl.setContent("");
		}
		else {
			messageImpl.setContent(content);
		}

		messageImpl.resetOriginalValues();

		return messageImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		messageId = objectInput.readLong();

		serviceId = objectInput.readLong();
		content = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(messageId);

		objectOutput.writeLong(serviceId);

		if (content == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(content);
		}
	}

	public long messageId;
	public long serviceId;
	public String content;

}