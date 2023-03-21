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

package eu.strasbourg.service.activity.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;
import com.liferay.portal.kernel.model.WorkflowedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Practice service. Represents a row in the &quot;activity_Practice&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>eu.strasbourg.service.activity.model.impl.PracticeModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>eu.strasbourg.service.activity.model.impl.PracticeImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Practice
 * @generated
 */
@ProviderType
public interface PracticeModel
	extends BaseModel<Practice>, GroupedModel, ShardedModel, StagedAuditedModel,
			WorkflowedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a practice model instance should use the {@link Practice} interface instead.
	 */

	/**
	 * Returns the primary key of this practice.
	 *
	 * @return the primary key of this practice
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this practice.
	 *
	 * @param primaryKey the primary key of this practice
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this practice.
	 *
	 * @return the uuid of this practice
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this practice.
	 *
	 * @param uuid the uuid of this practice
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the practice ID of this practice.
	 *
	 * @return the practice ID of this practice
	 */
	public long getPracticeId();

	/**
	 * Sets the practice ID of this practice.
	 *
	 * @param practiceId the practice ID of this practice
	 */
	public void setPracticeId(long practiceId);

	/**
	 * Returns the group ID of this practice.
	 *
	 * @return the group ID of this practice
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this practice.
	 *
	 * @param groupId the group ID of this practice
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this practice.
	 *
	 * @return the company ID of this practice
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this practice.
	 *
	 * @param companyId the company ID of this practice
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this practice.
	 *
	 * @return the user ID of this practice
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this practice.
	 *
	 * @param userId the user ID of this practice
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this practice.
	 *
	 * @return the user uuid of this practice
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this practice.
	 *
	 * @param userUuid the user uuid of this practice
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this practice.
	 *
	 * @return the user name of this practice
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this practice.
	 *
	 * @param userName the user name of this practice
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this practice.
	 *
	 * @return the create date of this practice
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this practice.
	 *
	 * @param createDate the create date of this practice
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this practice.
	 *
	 * @return the modified date of this practice
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this practice.
	 *
	 * @param modifiedDate the modified date of this practice
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the status of this practice.
	 *
	 * @return the status of this practice
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this practice.
	 *
	 * @param status the status of this practice
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this practice.
	 *
	 * @return the status by user ID of this practice
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this practice.
	 *
	 * @param statusByUserId the status by user ID of this practice
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this practice.
	 *
	 * @return the status by user uuid of this practice
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this practice.
	 *
	 * @param statusByUserUuid the status by user uuid of this practice
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this practice.
	 *
	 * @return the status by user name of this practice
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this practice.
	 *
	 * @param statusByUserName the status by user name of this practice
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this practice.
	 *
	 * @return the status date of this practice
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this practice.
	 *
	 * @param statusDate the status date of this practice
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns the association ID of this practice.
	 *
	 * @return the association ID of this practice
	 */
	public long getAssociationId();

	/**
	 * Sets the association ID of this practice.
	 *
	 * @param associationId the association ID of this practice
	 */
	public void setAssociationId(long associationId);

	/**
	 * Returns <code>true</code> if this practice is approved.
	 *
	 * @return <code>true</code> if this practice is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this practice is denied.
	 *
	 * @return <code>true</code> if this practice is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this practice is a draft.
	 *
	 * @return <code>true</code> if this practice is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this practice is expired.
	 *
	 * @return <code>true</code> if this practice is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this practice is inactive.
	 *
	 * @return <code>true</code> if this practice is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this practice is incomplete.
	 *
	 * @return <code>true</code> if this practice is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this practice is pending.
	 *
	 * @return <code>true</code> if this practice is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this practice is scheduled.
	 *
	 * @return <code>true</code> if this practice is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled();

	@Override
	public Practice cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}