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

package eu.strasbourg.service.council.model;

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
 * The base model interface for the CouncilSession service. Represents a row in the &quot;council_CouncilSession&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>eu.strasbourg.service.council.model.impl.CouncilSessionModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>eu.strasbourg.service.council.model.impl.CouncilSessionImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CouncilSession
 * @generated
 */
@ProviderType
public interface CouncilSessionModel
	extends BaseModel<CouncilSession>, GroupedModel, ShardedModel,
			StagedAuditedModel, WorkflowedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a council session model instance should use the {@link CouncilSession} interface instead.
	 */

	/**
	 * Returns the primary key of this council session.
	 *
	 * @return the primary key of this council session
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this council session.
	 *
	 * @param primaryKey the primary key of this council session
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this council session.
	 *
	 * @return the uuid of this council session
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this council session.
	 *
	 * @param uuid the uuid of this council session
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the council session ID of this council session.
	 *
	 * @return the council session ID of this council session
	 */
	public long getCouncilSessionId();

	/**
	 * Sets the council session ID of this council session.
	 *
	 * @param councilSessionId the council session ID of this council session
	 */
	public void setCouncilSessionId(long councilSessionId);

	/**
	 * Returns the group ID of this council session.
	 *
	 * @return the group ID of this council session
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this council session.
	 *
	 * @param groupId the group ID of this council session
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this council session.
	 *
	 * @return the company ID of this council session
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this council session.
	 *
	 * @param companyId the company ID of this council session
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this council session.
	 *
	 * @return the user ID of this council session
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this council session.
	 *
	 * @param userId the user ID of this council session
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this council session.
	 *
	 * @return the user uuid of this council session
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this council session.
	 *
	 * @param userUuid the user uuid of this council session
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this council session.
	 *
	 * @return the user name of this council session
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this council session.
	 *
	 * @param userName the user name of this council session
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this council session.
	 *
	 * @return the create date of this council session
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this council session.
	 *
	 * @param createDate the create date of this council session
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this council session.
	 *
	 * @return the modified date of this council session
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this council session.
	 *
	 * @param modifiedDate the modified date of this council session
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the status of this council session.
	 *
	 * @return the status of this council session
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this council session.
	 *
	 * @param status the status of this council session
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this council session.
	 *
	 * @return the status by user ID of this council session
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this council session.
	 *
	 * @param statusByUserId the status by user ID of this council session
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this council session.
	 *
	 * @return the status by user uuid of this council session
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this council session.
	 *
	 * @param statusByUserUuid the status by user uuid of this council session
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this council session.
	 *
	 * @return the status by user name of this council session
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this council session.
	 *
	 * @param statusByUserName the status by user name of this council session
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this council session.
	 *
	 * @return the status date of this council session
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this council session.
	 *
	 * @param statusDate the status date of this council session
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns the title of this council session.
	 *
	 * @return the title of this council session
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this council session.
	 *
	 * @param title the title of this council session
	 */
	public void setTitle(String title);

	/**
	 * Returns the date of this council session.
	 *
	 * @return the date of this council session
	 */
	public Date getDate();

	/**
	 * Sets the date of this council session.
	 *
	 * @param date the date of this council session
	 */
	public void setDate(Date date);

	/**
	 * Returns the last delib processed of this council session.
	 *
	 * @return the last delib processed of this council session
	 */
	public long getLastDelibProcessed();

	/**
	 * Sets the last delib processed of this council session.
	 *
	 * @param lastDelibProcessed the last delib processed of this council session
	 */
	public void setLastDelibProcessed(long lastDelibProcessed);

	/**
	 * Returns the official leader ID of this council session.
	 *
	 * @return the official leader ID of this council session
	 */
	public long getOfficialLeaderId();

	/**
	 * Sets the official leader ID of this council session.
	 *
	 * @param officialLeaderId the official leader ID of this council session
	 */
	public void setOfficialLeaderId(long officialLeaderId);

	/**
	 * Returns the type ID of this council session.
	 *
	 * @return the type ID of this council session
	 */
	public long getTypeId();

	/**
	 * Sets the type ID of this council session.
	 *
	 * @param typeId the type ID of this council session
	 */
	public void setTypeId(long typeId);

	/**
	 * Returns <code>true</code> if this council session is approved.
	 *
	 * @return <code>true</code> if this council session is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this council session is denied.
	 *
	 * @return <code>true</code> if this council session is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this council session is a draft.
	 *
	 * @return <code>true</code> if this council session is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this council session is expired.
	 *
	 * @return <code>true</code> if this council session is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this council session is inactive.
	 *
	 * @return <code>true</code> if this council session is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this council session is incomplete.
	 *
	 * @return <code>true</code> if this council session is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this council session is pending.
	 *
	 * @return <code>true</code> if this council session is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this council session is scheduled.
	 *
	 * @return <code>true</code> if this council session is scheduled; <code>false</code> otherwise
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
		eu.strasbourg.service.council.model.CouncilSession councilSession);

	@Override
	public int hashCode();

	@Override
	public CacheModel<eu.strasbourg.service.council.model.CouncilSession>
		toCacheModel();

	@Override
	public eu.strasbourg.service.council.model.CouncilSession toEscapedModel();

	@Override
	public eu.strasbourg.service.council.model.CouncilSession
		toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();

}