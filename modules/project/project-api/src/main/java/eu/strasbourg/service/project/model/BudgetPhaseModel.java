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
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;
import com.liferay.portal.kernel.model.WorkflowedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;
import java.util.Date;

/**
 * The base model interface for the BudgetPhase service. Represents a row in the &quot;project_BudgetPhase&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link eu.strasbourg.service.project.model.impl.BudgetPhaseModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link eu.strasbourg.service.project.model.impl.BudgetPhaseImpl}.
 * </p>
 *
 * @author Cedric Henry
 * @see BudgetPhase
 * @see eu.strasbourg.service.project.model.impl.BudgetPhaseImpl
 * @see eu.strasbourg.service.project.model.impl.BudgetPhaseModelImpl
 * @generated
 */
@ProviderType
public interface BudgetPhaseModel extends BaseModel<BudgetPhase>, GroupedModel,
	ShardedModel, StagedAuditedModel, WorkflowedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a budget phase model instance should use the {@link BudgetPhase} interface instead.
	 */

	/**
	 * Returns the primary key of this budget phase.
	 *
	 * @return the primary key of this budget phase
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this budget phase.
	 *
	 * @param primaryKey the primary key of this budget phase
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this budget phase.
	 *
	 * @return the uuid of this budget phase
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this budget phase.
	 *
	 * @param uuid the uuid of this budget phase
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the budget phase ID of this budget phase.
	 *
	 * @return the budget phase ID of this budget phase
	 */
	public long getBudgetPhaseId();

	/**
	 * Sets the budget phase ID of this budget phase.
	 *
	 * @param budgetPhaseId the budget phase ID of this budget phase
	 */
	public void setBudgetPhaseId(long budgetPhaseId);

	/**
	 * Returns the group ID of this budget phase.
	 *
	 * @return the group ID of this budget phase
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this budget phase.
	 *
	 * @param groupId the group ID of this budget phase
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this budget phase.
	 *
	 * @return the company ID of this budget phase
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this budget phase.
	 *
	 * @param companyId the company ID of this budget phase
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this budget phase.
	 *
	 * @return the user ID of this budget phase
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this budget phase.
	 *
	 * @param userId the user ID of this budget phase
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this budget phase.
	 *
	 * @return the user uuid of this budget phase
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this budget phase.
	 *
	 * @param userUuid the user uuid of this budget phase
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this budget phase.
	 *
	 * @return the user name of this budget phase
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this budget phase.
	 *
	 * @param userName the user name of this budget phase
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this budget phase.
	 *
	 * @return the create date of this budget phase
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this budget phase.
	 *
	 * @param createDate the create date of this budget phase
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this budget phase.
	 *
	 * @return the modified date of this budget phase
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this budget phase.
	 *
	 * @param modifiedDate the modified date of this budget phase
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the status of this budget phase.
	 *
	 * @return the status of this budget phase
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this budget phase.
	 *
	 * @param status the status of this budget phase
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this budget phase.
	 *
	 * @return the status by user ID of this budget phase
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this budget phase.
	 *
	 * @param statusByUserId the status by user ID of this budget phase
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this budget phase.
	 *
	 * @return the status by user uuid of this budget phase
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this budget phase.
	 *
	 * @param statusByUserUuid the status by user uuid of this budget phase
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this budget phase.
	 *
	 * @return the status by user name of this budget phase
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this budget phase.
	 *
	 * @param statusByUserName the status by user name of this budget phase
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this budget phase.
	 *
	 * @return the status date of this budget phase
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this budget phase.
	 *
	 * @param statusDate the status date of this budget phase
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns the name of this budget phase.
	 *
	 * @return the name of this budget phase
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this budget phase.
	 *
	 * @param name the name of this budget phase
	 */
	public void setName(String name);

	/**
	 * Returns the description of this budget phase.
	 *
	 * @return the description of this budget phase
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this budget phase.
	 *
	 * @param description the description of this budget phase
	 */
	public void setDescription(String description);

	/**
	 * Returns the number of vote of this budget phase.
	 *
	 * @return the number of vote of this budget phase
	 */
	public long getNumberOfVote();

	/**
	 * Sets the number of vote of this budget phase.
	 *
	 * @param numberOfVote the number of vote of this budget phase
	 */
	public void setNumberOfVote(long numberOfVote);

	/**
	 * Returns the is active of this budget phase.
	 *
	 * @return the is active of this budget phase
	 */
	public boolean getIsActive();

	/**
	 * Returns <code>true</code> if this budget phase is is active.
	 *
	 * @return <code>true</code> if this budget phase is is active; <code>false</code> otherwise
	 */
	public boolean isIsActive();

	/**
	 * Sets whether this budget phase is is active.
	 *
	 * @param isActive the is active of this budget phase
	 */
	public void setIsActive(boolean isActive);

	/**
	 * Returns the begin date of this budget phase.
	 *
	 * @return the begin date of this budget phase
	 */
	public Date getBeginDate();

	/**
	 * Sets the begin date of this budget phase.
	 *
	 * @param beginDate the begin date of this budget phase
	 */
	public void setBeginDate(Date beginDate);

	/**
	 * Returns the end date of this budget phase.
	 *
	 * @return the end date of this budget phase
	 */
	public Date getEndDate();

	/**
	 * Sets the end date of this budget phase.
	 *
	 * @param endDate the end date of this budget phase
	 */
	public void setEndDate(Date endDate);

	/**
	 * Returns the begin vote date of this budget phase.
	 *
	 * @return the begin vote date of this budget phase
	 */
	public Date getBeginVoteDate();

	/**
	 * Sets the begin vote date of this budget phase.
	 *
	 * @param beginVoteDate the begin vote date of this budget phase
	 */
	public void setBeginVoteDate(Date beginVoteDate);

	/**
	 * Returns the end vote date of this budget phase.
	 *
	 * @return the end vote date of this budget phase
	 */
	public Date getEndVoteDate();

	/**
	 * Sets the end vote date of this budget phase.
	 *
	 * @param endVoteDate the end vote date of this budget phase
	 */
	public void setEndVoteDate(Date endVoteDate);

	/**
	 * Returns the publik ID of this budget phase.
	 *
	 * @return the publik ID of this budget phase
	 */
	@AutoEscape
	public String getPublikId();

	/**
	 * Sets the publik ID of this budget phase.
	 *
	 * @param publikId the publik ID of this budget phase
	 */
	public void setPublikId(String publikId);

	/**
	 * Returns <code>true</code> if this budget phase is approved.
	 *
	 * @return <code>true</code> if this budget phase is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this budget phase is denied.
	 *
	 * @return <code>true</code> if this budget phase is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this budget phase is a draft.
	 *
	 * @return <code>true</code> if this budget phase is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this budget phase is expired.
	 *
	 * @return <code>true</code> if this budget phase is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this budget phase is inactive.
	 *
	 * @return <code>true</code> if this budget phase is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this budget phase is incomplete.
	 *
	 * @return <code>true</code> if this budget phase is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this budget phase is pending.
	 *
	 * @return <code>true</code> if this budget phase is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this budget phase is scheduled.
	 *
	 * @return <code>true</code> if this budget phase is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled();

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
		eu.strasbourg.service.project.model.BudgetPhase budgetPhase);

	@Override
	public int hashCode();

	@Override
	public CacheModel<eu.strasbourg.service.project.model.BudgetPhase> toCacheModel();

	@Override
	public eu.strasbourg.service.project.model.BudgetPhase toEscapedModel();

	@Override
	public eu.strasbourg.service.project.model.BudgetPhase toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}