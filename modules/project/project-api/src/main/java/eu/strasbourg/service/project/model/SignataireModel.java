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
 * The base model interface for the Signataire service. Represents a row in the &quot;project_Signataire&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link eu.strasbourg.service.project.model.impl.SignataireModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link eu.strasbourg.service.project.model.impl.SignataireImpl}.
 * </p>
 *
 * @author Cedric Henry
 * @see Signataire
 * @see eu.strasbourg.service.project.model.impl.SignataireImpl
 * @see eu.strasbourg.service.project.model.impl.SignataireModelImpl
 * @generated
 */
@ProviderType
public interface SignataireModel extends BaseModel<Signataire>, GroupedModel,
	ShardedModel, StagedAuditedModel, WorkflowedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a signataire model instance should use the {@link Signataire} interface instead.
	 */

	/**
	 * Returns the primary key of this signataire.
	 *
	 * @return the primary key of this signataire
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this signataire.
	 *
	 * @param primaryKey the primary key of this signataire
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this signataire.
	 *
	 * @return the uuid of this signataire
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this signataire.
	 *
	 * @param uuid the uuid of this signataire
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the signataire ID of this signataire.
	 *
	 * @return the signataire ID of this signataire
	 */
	public long getSignataireId();

	/**
	 * Sets the signataire ID of this signataire.
	 *
	 * @param signataireId the signataire ID of this signataire
	 */
	public void setSignataireId(long signataireId);

	/**
	 * Returns the group ID of this signataire.
	 *
	 * @return the group ID of this signataire
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this signataire.
	 *
	 * @param groupId the group ID of this signataire
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this signataire.
	 *
	 * @return the company ID of this signataire
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this signataire.
	 *
	 * @param companyId the company ID of this signataire
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this signataire.
	 *
	 * @return the user ID of this signataire
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this signataire.
	 *
	 * @param userId the user ID of this signataire
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this signataire.
	 *
	 * @return the user uuid of this signataire
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this signataire.
	 *
	 * @param userUuid the user uuid of this signataire
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this signataire.
	 *
	 * @return the user name of this signataire
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this signataire.
	 *
	 * @param userName the user name of this signataire
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this signataire.
	 *
	 * @return the create date of this signataire
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this signataire.
	 *
	 * @param createDate the create date of this signataire
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this signataire.
	 *
	 * @return the modified date of this signataire
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this signataire.
	 *
	 * @param modifiedDate the modified date of this signataire
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the status of this signataire.
	 *
	 * @return the status of this signataire
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this signataire.
	 *
	 * @param status the status of this signataire
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this signataire.
	 *
	 * @return the status by user ID of this signataire
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this signataire.
	 *
	 * @param statusByUserId the status by user ID of this signataire
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this signataire.
	 *
	 * @return the status by user uuid of this signataire
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this signataire.
	 *
	 * @param statusByUserUuid the status by user uuid of this signataire
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this signataire.
	 *
	 * @return the status by user name of this signataire
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this signataire.
	 *
	 * @param statusByUserName the status by user name of this signataire
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this signataire.
	 *
	 * @return the status date of this signataire
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this signataire.
	 *
	 * @param statusDate the status date of this signataire
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns the signataire name of this signataire.
	 *
	 * @return the signataire name of this signataire
	 */
	@AutoEscape
	public String getSignataireName();

	/**
	 * Sets the signataire name of this signataire.
	 *
	 * @param signataireName the signataire name of this signataire
	 */
	public void setSignataireName(String signataireName);

	/**
	 * Returns the signataire firstname of this signataire.
	 *
	 * @return the signataire firstname of this signataire
	 */
	@AutoEscape
	public String getSignataireFirstname();

	/**
	 * Sets the signataire firstname of this signataire.
	 *
	 * @param signataireFirstname the signataire firstname of this signataire
	 */
	public void setSignataireFirstname(String signataireFirstname);

	/**
	 * Returns the signature date of this signataire.
	 *
	 * @return the signature date of this signataire
	 */
	public Date getSignatureDate();

	/**
	 * Sets the signature date of this signataire.
	 *
	 * @param signatureDate the signature date of this signataire
	 */
	public void setSignatureDate(Date signatureDate);

	/**
	 * Returns the asset entry ID of this signataire.
	 *
	 * @return the asset entry ID of this signataire
	 */
	public long getAssetEntryId();

	/**
	 * Sets the asset entry ID of this signataire.
	 *
	 * @param assetEntryId the asset entry ID of this signataire
	 */
	public void setAssetEntryId(long assetEntryId);

	/**
	 * Returns the publik ID of this signataire.
	 *
	 * @return the publik ID of this signataire
	 */
	public long getPublikId();

	/**
	 * Sets the publik ID of this signataire.
	 *
	 * @param publikId the publik ID of this signataire
	 */
	public void setPublikId(long publikId);

	/**
	 * Returns the petition ID of this signataire.
	 *
	 * @return the petition ID of this signataire
	 */
	public long getPetitionId();

	/**
	 * Sets the petition ID of this signataire.
	 *
	 * @param petitionId the petition ID of this signataire
	 */
	public void setPetitionId(long petitionId);

	/**
	 * Returns <code>true</code> if this signataire is approved.
	 *
	 * @return <code>true</code> if this signataire is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this signataire is denied.
	 *
	 * @return <code>true</code> if this signataire is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this signataire is a draft.
	 *
	 * @return <code>true</code> if this signataire is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this signataire is expired.
	 *
	 * @return <code>true</code> if this signataire is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this signataire is inactive.
	 *
	 * @return <code>true</code> if this signataire is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this signataire is incomplete.
	 *
	 * @return <code>true</code> if this signataire is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this signataire is pending.
	 *
	 * @return <code>true</code> if this signataire is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this signataire is scheduled.
	 *
	 * @return <code>true</code> if this signataire is scheduled; <code>false</code> otherwise
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
		eu.strasbourg.service.project.model.Signataire signataire);

	@Override
	public int hashCode();

	@Override
	public CacheModel<eu.strasbourg.service.project.model.Signataire> toCacheModel();

	@Override
	public eu.strasbourg.service.project.model.Signataire toEscapedModel();

	@Override
	public eu.strasbourg.service.project.model.Signataire toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}