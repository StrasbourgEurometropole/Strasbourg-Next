/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ProjectFollowed}.
 * </p>
 *
 * @author Cedric Henry
 * @see ProjectFollowed
 * @generated
 */
public class ProjectFollowedWrapper
	extends BaseModelWrapper<ProjectFollowed>
	implements ModelWrapper<ProjectFollowed>, ProjectFollowed {

	public ProjectFollowedWrapper(ProjectFollowed projectFollowed) {
		super(projectFollowed);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("projectFollowedId", getProjectFollowedId());
		attributes.put("createDate", getCreateDate());
		attributes.put("publikUserId", getPublikUserId());
		attributes.put("projectId", getProjectId());
		attributes.put("groupId", getGroupId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long projectFollowedId = (Long)attributes.get("projectFollowedId");

		if (projectFollowedId != null) {
			setProjectFollowedId(projectFollowedId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		String publikUserId = (String)attributes.get("publikUserId");

		if (publikUserId != null) {
			setPublikUserId(publikUserId);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}
	}

	@Override
	public ProjectFollowed cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the create date of this project followed.
	 *
	 * @return the create date of this project followed
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this project followed.
	 *
	 * @return the group ID of this project followed
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the primary key of this project followed.
	 *
	 * @return the primary key of this project followed
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the project followed ID of this project followed.
	 *
	 * @return the project followed ID of this project followed
	 */
	@Override
	public long getProjectFollowedId() {
		return model.getProjectFollowedId();
	}

	/**
	 * Returns the project ID of this project followed.
	 *
	 * @return the project ID of this project followed
	 */
	@Override
	public long getProjectId() {
		return model.getProjectId();
	}

	/**
	 * Returns the publik user ID of this project followed.
	 *
	 * @return the publik user ID of this project followed
	 */
	@Override
	public String getPublikUserId() {
		return model.getPublikUserId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the create date of this project followed.
	 *
	 * @param createDate the create date of this project followed
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this project followed.
	 *
	 * @param groupId the group ID of this project followed
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the primary key of this project followed.
	 *
	 * @param primaryKey the primary key of this project followed
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the project followed ID of this project followed.
	 *
	 * @param projectFollowedId the project followed ID of this project followed
	 */
	@Override
	public void setProjectFollowedId(long projectFollowedId) {
		model.setProjectFollowedId(projectFollowedId);
	}

	/**
	 * Sets the project ID of this project followed.
	 *
	 * @param projectId the project ID of this project followed
	 */
	@Override
	public void setProjectId(long projectId) {
		model.setProjectId(projectId);
	}

	/**
	 * Sets the publik user ID of this project followed.
	 *
	 * @param publikUserId the publik user ID of this project followed
	 */
	@Override
	public void setPublikUserId(String publikUserId) {
		model.setPublikUserId(publikUserId);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected ProjectFollowedWrapper wrap(ProjectFollowed projectFollowed) {
		return new ProjectFollowedWrapper(projectFollowed);
	}

}