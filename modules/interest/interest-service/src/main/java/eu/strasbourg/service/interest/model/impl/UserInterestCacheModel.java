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

package eu.strasbourg.service.interest.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import eu.strasbourg.service.interest.model.UserInterest;
import eu.strasbourg.service.interest.service.persistence.UserInterestPK;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing UserInterest in entity cache.
 *
 * @author BenjaminBini
 * @generated
 */
public class UserInterestCacheModel
	implements CacheModel<UserInterest>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof UserInterestCacheModel)) {
			return false;
		}

		UserInterestCacheModel userInterestCacheModel =
			(UserInterestCacheModel)object;

		if (userInterestPK.equals(userInterestCacheModel.userInterestPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, userInterestPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{interestId=");
		sb.append(interestId);
		sb.append(", publikUserId=");
		sb.append(publikUserId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserInterest toEntityModel() {
		UserInterestImpl userInterestImpl = new UserInterestImpl();

		userInterestImpl.setInterestId(interestId);

		if (publikUserId == null) {
			userInterestImpl.setPublikUserId("");
		}
		else {
			userInterestImpl.setPublikUserId(publikUserId);
		}

		userInterestImpl.resetOriginalValues();

		return userInterestImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		interestId = objectInput.readLong();
		publikUserId = objectInput.readUTF();

		userInterestPK = new UserInterestPK(interestId, publikUserId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(interestId);

		if (publikUserId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(publikUserId);
		}
	}

	public long interestId;
	public String publikUserId;
	public transient UserInterestPK userInterestPK;

}