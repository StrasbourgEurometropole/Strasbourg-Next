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

package eu.strasbourg.service.help.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;
import com.liferay.portal.kernel.model.WorkflowedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the HelpRequest service. Represents a row in the &quot;help_HelpRequest&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>eu.strasbourg.service.help.model.impl.HelpRequestModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>eu.strasbourg.service.help.model.impl.HelpRequestImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see HelpRequest
 * @generated
 */
@ProviderType
public interface HelpRequestModel
	extends BaseModel<HelpRequest>, GroupedModel, ShardedModel,
			StagedAuditedModel, WorkflowedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a help request model instance should use the {@link HelpRequest} interface instead.
	 */

	/**
	 * Returns the primary key of this help request.
	 *
	 * @return the primary key of this help request
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this help request.
	 *
	 * @param primaryKey the primary key of this help request
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this help request.
	 *
	 * @return the uuid of this help request
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this help request.
	 *
	 * @param uuid the uuid of this help request
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the help request ID of this help request.
	 *
	 * @return the help request ID of this help request
	 */
	public long getHelpRequestId();

	/**
	 * Sets the help request ID of this help request.
	 *
	 * @param helpRequestId the help request ID of this help request
	 */
	public void setHelpRequestId(long helpRequestId);

	/**
	 * Returns the group ID of this help request.
	 *
	 * @return the group ID of this help request
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this help request.
	 *
	 * @param groupId the group ID of this help request
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this help request.
	 *
	 * @return the company ID of this help request
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this help request.
	 *
	 * @param companyId the company ID of this help request
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this help request.
	 *
	 * @return the user ID of this help request
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this help request.
	 *
	 * @param userId the user ID of this help request
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this help request.
	 *
	 * @return the user uuid of this help request
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this help request.
	 *
	 * @param userUuid the user uuid of this help request
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this help request.
	 *
	 * @return the user name of this help request
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this help request.
	 *
	 * @param userName the user name of this help request
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this help request.
	 *
	 * @return the create date of this help request
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this help request.
	 *
	 * @param createDate the create date of this help request
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this help request.
	 *
	 * @return the modified date of this help request
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this help request.
	 *
	 * @param modifiedDate the modified date of this help request
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the status of this help request.
	 *
	 * @return the status of this help request
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this help request.
	 *
	 * @param status the status of this help request
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this help request.
	 *
	 * @return the status by user ID of this help request
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this help request.
	 *
	 * @param statusByUserId the status by user ID of this help request
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this help request.
	 *
	 * @return the status by user uuid of this help request
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this help request.
	 *
	 * @param statusByUserUuid the status by user uuid of this help request
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this help request.
	 *
	 * @return the status by user name of this help request
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this help request.
	 *
	 * @param statusByUserName the status by user name of this help request
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this help request.
	 *
	 * @return the status date of this help request
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this help request.
	 *
	 * @param statusDate the status date of this help request
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns the publik ID of this help request.
	 *
	 * @return the publik ID of this help request
	 */
	@AutoEscape
	public String getPublikId();

	/**
	 * Sets the publik ID of this help request.
	 *
	 * @param publikId the publik ID of this help request
	 */
	public void setPublikId(String publikId);

	/**
	 * Returns the help proposal ID of this help request.
	 *
	 * @return the help proposal ID of this help request
	 */
	public long getHelpProposalId();

	/**
	 * Sets the help proposal ID of this help request.
	 *
	 * @param helpProposalId the help proposal ID of this help request
	 */
	public void setHelpProposalId(long helpProposalId);

	/**
	 * Returns the phone number of this help request.
	 *
	 * @return the phone number of this help request
	 */
	@AutoEscape
	public String getPhoneNumber();

	/**
	 * Sets the phone number of this help request.
	 *
	 * @param phoneNumber the phone number of this help request
	 */
	public void setPhoneNumber(String phoneNumber);

	/**
	 * Returns the message of this help request.
	 *
	 * @return the message of this help request
	 */
	@AutoEscape
	public String getMessage();

	/**
	 * Sets the message of this help request.
	 *
	 * @param message the message of this help request
	 */
	public void setMessage(String message);

	/**
	 * Returns the student card image ID of this help request.
	 *
	 * @return the student card image ID of this help request
	 */
	public long getStudentCardImageId();

	/**
	 * Sets the student card image ID of this help request.
	 *
	 * @param studentCardImageId the student card image ID of this help request
	 */
	public void setStudentCardImageId(long studentCardImageId);

	/**
	 * Returns <code>true</code> if this help request is approved.
	 *
	 * @return <code>true</code> if this help request is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this help request is denied.
	 *
	 * @return <code>true</code> if this help request is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this help request is a draft.
	 *
	 * @return <code>true</code> if this help request is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this help request is expired.
	 *
	 * @return <code>true</code> if this help request is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this help request is inactive.
	 *
	 * @return <code>true</code> if this help request is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this help request is incomplete.
	 *
	 * @return <code>true</code> if this help request is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this help request is pending.
	 *
	 * @return <code>true</code> if this help request is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this help request is scheduled.
	 *
	 * @return <code>true</code> if this help request is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled();

}