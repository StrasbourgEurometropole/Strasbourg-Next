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

package eu.strasbourg.service.gtfs.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;
import com.liferay.portal.kernel.model.WorkflowedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Ligne service. Represents a row in the &quot;gtfs_Ligne&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>eu.strasbourg.service.gtfs.model.impl.LigneModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>eu.strasbourg.service.gtfs.model.impl.LigneImpl</code>.
 * </p>
 *
 * @author Cedric Henry
 * @see Ligne
 * @generated
 */
@ProviderType
public interface LigneModel
	extends BaseModel<Ligne>, GroupedModel, ShardedModel, StagedAuditedModel,
			WorkflowedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a ligne model instance should use the {@link Ligne} interface instead.
	 */

	/**
	 * Returns the primary key of this ligne.
	 *
	 * @return the primary key of this ligne
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this ligne.
	 *
	 * @param primaryKey the primary key of this ligne
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this ligne.
	 *
	 * @return the uuid of this ligne
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this ligne.
	 *
	 * @param uuid the uuid of this ligne
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the ligne ID of this ligne.
	 *
	 * @return the ligne ID of this ligne
	 */
	public long getLigneId();

	/**
	 * Sets the ligne ID of this ligne.
	 *
	 * @param ligneId the ligne ID of this ligne
	 */
	public void setLigneId(long ligneId);

	/**
	 * Returns the group ID of this ligne.
	 *
	 * @return the group ID of this ligne
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this ligne.
	 *
	 * @param groupId the group ID of this ligne
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this ligne.
	 *
	 * @return the company ID of this ligne
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this ligne.
	 *
	 * @param companyId the company ID of this ligne
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this ligne.
	 *
	 * @return the user ID of this ligne
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this ligne.
	 *
	 * @param userId the user ID of this ligne
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this ligne.
	 *
	 * @return the user uuid of this ligne
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this ligne.
	 *
	 * @param userUuid the user uuid of this ligne
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this ligne.
	 *
	 * @return the user name of this ligne
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this ligne.
	 *
	 * @param userName the user name of this ligne
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this ligne.
	 *
	 * @return the create date of this ligne
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this ligne.
	 *
	 * @param createDate the create date of this ligne
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this ligne.
	 *
	 * @return the modified date of this ligne
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this ligne.
	 *
	 * @param modifiedDate the modified date of this ligne
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the status of this ligne.
	 *
	 * @return the status of this ligne
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this ligne.
	 *
	 * @param status the status of this ligne
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this ligne.
	 *
	 * @return the status by user ID of this ligne
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this ligne.
	 *
	 * @param statusByUserId the status by user ID of this ligne
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this ligne.
	 *
	 * @return the status by user uuid of this ligne
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this ligne.
	 *
	 * @param statusByUserUuid the status by user uuid of this ligne
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this ligne.
	 *
	 * @return the status by user name of this ligne
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this ligne.
	 *
	 * @param statusByUserName the status by user name of this ligne
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this ligne.
	 *
	 * @return the status date of this ligne
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this ligne.
	 *
	 * @param statusDate the status date of this ligne
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns the route ID of this ligne.
	 *
	 * @return the route ID of this ligne
	 */
	@AutoEscape
	public String getRouteId();

	/**
	 * Sets the route ID of this ligne.
	 *
	 * @param routeId the route ID of this ligne
	 */
	public void setRouteId(String routeId);

	/**
	 * Returns the short name of this ligne.
	 *
	 * @return the short name of this ligne
	 */
	@AutoEscape
	public String getShortName();

	/**
	 * Sets the short name of this ligne.
	 *
	 * @param shortName the short name of this ligne
	 */
	public void setShortName(String shortName);

	/**
	 * Returns the title of this ligne.
	 *
	 * @return the title of this ligne
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this ligne.
	 *
	 * @param title the title of this ligne
	 */
	public void setTitle(String title);

	/**
	 * Returns the type of this ligne.
	 *
	 * @return the type of this ligne
	 */
	public int getType();

	/**
	 * Sets the type of this ligne.
	 *
	 * @param type the type of this ligne
	 */
	public void setType(int type);

	/**
	 * Returns the background color of this ligne.
	 *
	 * @return the background color of this ligne
	 */
	@AutoEscape
	public String getBackgroundColor();

	/**
	 * Sets the background color of this ligne.
	 *
	 * @param backgroundColor the background color of this ligne
	 */
	public void setBackgroundColor(String backgroundColor);

	/**
	 * Returns the text color of this ligne.
	 *
	 * @return the text color of this ligne
	 */
	@AutoEscape
	public String getTextColor();

	/**
	 * Sets the text color of this ligne.
	 *
	 * @param textColor the text color of this ligne
	 */
	public void setTextColor(String textColor);

	/**
	 * Returns <code>true</code> if this ligne is approved.
	 *
	 * @return <code>true</code> if this ligne is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this ligne is denied.
	 *
	 * @return <code>true</code> if this ligne is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this ligne is a draft.
	 *
	 * @return <code>true</code> if this ligne is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this ligne is expired.
	 *
	 * @return <code>true</code> if this ligne is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this ligne is inactive.
	 *
	 * @return <code>true</code> if this ligne is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this ligne is incomplete.
	 *
	 * @return <code>true</code> if this ligne is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this ligne is pending.
	 *
	 * @return <code>true</code> if this ligne is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this ligne is scheduled.
	 *
	 * @return <code>true</code> if this ligne is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled();

	@Override
	public Ligne cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}