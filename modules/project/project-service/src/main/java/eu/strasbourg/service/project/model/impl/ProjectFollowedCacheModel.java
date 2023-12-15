/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.project.model.ProjectFollowed;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProjectFollowed in entity cache.
 *
 * @author Cedric Henry
 * @generated
 */
public class ProjectFollowedCacheModel
	implements CacheModel<ProjectFollowed>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProjectFollowedCacheModel)) {
			return false;
		}

		ProjectFollowedCacheModel projectFollowedCacheModel =
			(ProjectFollowedCacheModel)object;

		if (projectFollowedId == projectFollowedCacheModel.projectFollowedId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, projectFollowedId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{projectFollowedId=");
		sb.append(projectFollowedId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", publikUserId=");
		sb.append(publikUserId);
		sb.append(", projectId=");
		sb.append(projectId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProjectFollowed toEntityModel() {
		ProjectFollowedImpl projectFollowedImpl = new ProjectFollowedImpl();

		projectFollowedImpl.setProjectFollowedId(projectFollowedId);

		if (createDate == Long.MIN_VALUE) {
			projectFollowedImpl.setCreateDate(null);
		}
		else {
			projectFollowedImpl.setCreateDate(new Date(createDate));
		}

		if (publikUserId == null) {
			projectFollowedImpl.setPublikUserId("");
		}
		else {
			projectFollowedImpl.setPublikUserId(publikUserId);
		}

		projectFollowedImpl.setProjectId(projectId);
		projectFollowedImpl.setGroupId(groupId);

		projectFollowedImpl.resetOriginalValues();

		return projectFollowedImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		projectFollowedId = objectInput.readLong();
		createDate = objectInput.readLong();
		publikUserId = objectInput.readUTF();

		projectId = objectInput.readLong();

		groupId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(projectFollowedId);
		objectOutput.writeLong(createDate);

		if (publikUserId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(publikUserId);
		}

		objectOutput.writeLong(projectId);

		objectOutput.writeLong(groupId);
	}

	public long projectFollowedId;
	public long createDate;
	public String publikUserId;
	public long projectId;
	public long groupId;

}