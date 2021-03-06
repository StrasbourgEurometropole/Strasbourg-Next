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

package eu.strasbourg.service.project.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the ProjectFollowed service. Represents a row in the &quot;project_ProjectFollowed&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>eu.strasbourg.service.project.model.impl.ProjectFollowedModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>eu.strasbourg.service.project.model.impl.ProjectFollowedImpl</code>.
 * </p>
 *
 * @author Cedric Henry
 * @see ProjectFollowed
 * @generated
 */
@ProviderType
public interface ProjectFollowedModel extends BaseModel<ProjectFollowed> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a project followed model instance should use the {@link ProjectFollowed} interface instead.
	 */

	/**
	 * Returns the primary key of this project followed.
	 *
	 * @return the primary key of this project followed
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this project followed.
	 *
	 * @param primaryKey the primary key of this project followed
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the project followed ID of this project followed.
	 *
	 * @return the project followed ID of this project followed
	 */
	public long getProjectFollowedId();

	/**
	 * Sets the project followed ID of this project followed.
	 *
	 * @param projectFollowedId the project followed ID of this project followed
	 */
	public void setProjectFollowedId(long projectFollowedId);

	/**
	 * Returns the create date of this project followed.
	 *
	 * @return the create date of this project followed
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this project followed.
	 *
	 * @param createDate the create date of this project followed
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the publik user ID of this project followed.
	 *
	 * @return the publik user ID of this project followed
	 */
	@AutoEscape
	public String getPublikUserId();

	/**
	 * Sets the publik user ID of this project followed.
	 *
	 * @param publikUserId the publik user ID of this project followed
	 */
	public void setPublikUserId(String publikUserId);

	/**
	 * Returns the project ID of this project followed.
	 *
	 * @return the project ID of this project followed
	 */
	public long getProjectId();

	/**
	 * Sets the project ID of this project followed.
	 *
	 * @param projectId the project ID of this project followed
	 */
	public void setProjectId(long projectId);

	/**
	 * Returns the group ID of this project followed.
	 *
	 * @return the group ID of this project followed
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this project followed.
	 *
	 * @param groupId the group ID of this project followed
	 */
	public void setGroupId(long groupId);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(
		eu.strasbourg.service.project.model.ProjectFollowed projectFollowed);

	@Override
	public int hashCode();

	@Override
	public CacheModel<eu.strasbourg.service.project.model.ProjectFollowed>
		toCacheModel();

	@Override
	public eu.strasbourg.service.project.model.ProjectFollowed toEscapedModel();

	@Override
	public eu.strasbourg.service.project.model.ProjectFollowed
		toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();

}