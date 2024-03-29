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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link CouncilSession}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CouncilSession
 * @generated
 */
public class CouncilSessionWrapper
	implements CouncilSession, ModelWrapper<CouncilSession> {

	public CouncilSessionWrapper(CouncilSession councilSession) {
		_councilSession = councilSession;
	}

	@Override
	public Class<?> getModelClass() {
		return CouncilSession.class;
	}

	@Override
	public String getModelClassName() {
		return CouncilSession.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("councilSessionId", getCouncilSessionId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("title", getTitle());
		attributes.put("date", getDate());
		attributes.put("lastDelibProcessed", getLastDelibProcessed());
		attributes.put("officialLeaderId", getOfficialLeaderId());
		attributes.put("typeId", getTypeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long councilSessionId = (Long)attributes.get("councilSessionId");

		if (councilSessionId != null) {
			setCouncilSessionId(councilSessionId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		Date date = (Date)attributes.get("date");

		if (date != null) {
			setDate(date);
		}

		Long lastDelibProcessed = (Long)attributes.get("lastDelibProcessed");

		if (lastDelibProcessed != null) {
			setLastDelibProcessed(lastDelibProcessed);
		}

		Long officialLeaderId = (Long)attributes.get("officialLeaderId");

		if (officialLeaderId != null) {
			setOfficialLeaderId(officialLeaderId);
		}

		Long typeId = (Long)attributes.get("typeId");

		if (typeId != null) {
			setTypeId(typeId);
		}
	}

	@Override
	public Object clone() {
		return new CouncilSessionWrapper(
			(CouncilSession)_councilSession.clone());
	}

	@Override
	public int compareTo(
		eu.strasbourg.service.council.model.CouncilSession councilSession) {

		return _councilSession.compareTo(councilSession);
	}

	/**
	 * Retourne l'AssetEntry rattaché cet item
	 */
	@Override
	public com.liferay.asset.kernel.model.AssetEntry getAssetEntry() {
		return _councilSession.getAssetEntry();
	}

	/**
	 * Renvoie la liste des AssetCategory rattachées à cet item (via l'assetEntry)
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCategories() {

		return _councilSession.getCategories();
	}

	/**
	 * Returns the company ID of this council session.
	 *
	 * @return the company ID of this council session
	 */
	@Override
	public long getCompanyId() {
		return _councilSession.getCompanyId();
	}

	/**
	 * Returns the council session ID of this council session.
	 *
	 * @return the council session ID of this council session
	 */
	@Override
	public long getCouncilSessionId() {
		return _councilSession.getCouncilSessionId();
	}

	/**
	 * Returns the create date of this council session.
	 *
	 * @return the create date of this council session
	 */
	@Override
	public Date getCreateDate() {
		return _councilSession.getCreateDate();
	}

	/**
	 * Returns the date of this council session.
	 *
	 * @return the date of this council session
	 */
	@Override
	public Date getDate() {
		return _councilSession.getDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _councilSession.getExpandoBridge();
	}

	/**
	 * Returns the group ID of this council session.
	 *
	 * @return the group ID of this council session
	 */
	@Override
	public long getGroupId() {
		return _councilSession.getGroupId();
	}

	/**
	 * Returns the last delib processed of this council session.
	 *
	 * @return the last delib processed of this council session
	 */
	@Override
	public long getLastDelibProcessed() {
		return _councilSession.getLastDelibProcessed();
	}

	/**
	 * Returns the modified date of this council session.
	 *
	 * @return the modified date of this council session
	 */
	@Override
	public Date getModifiedDate() {
		return _councilSession.getModifiedDate();
	}

	/**
	 * Renvoie l'élu président du conseil rattachées à cette sessions
	 */
	@Override
	public eu.strasbourg.service.council.model.Official getOfficialLeader() {
		return _councilSession.getOfficialLeader();
	}

	/**
	 * Renvoie le nom complet de l'élu président du conseil
	 */
	@Override
	public String getOfficialLeaderFullName() {
		return _councilSession.getOfficialLeaderFullName();
	}

	/**
	 * Returns the official leader ID of this council session.
	 *
	 * @return the official leader ID of this council session
	 */
	@Override
	public long getOfficialLeaderId() {
		return _councilSession.getOfficialLeaderId();
	}

	/**
	 * Returns the primary key of this council session.
	 *
	 * @return the primary key of this council session
	 */
	@Override
	public long getPrimaryKey() {
		return _councilSession.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _councilSession.getPrimaryKeyObj();
	}

	/**
	 * Renvoie la liste des procurations rattachées à cette sessions
	 */
	@Override
	public java.util.List<eu.strasbourg.service.council.model.Procuration>
		getProcurations() {

		return _councilSession.getProcurations();
	}

	/**
	 * Returns the status of this council session.
	 *
	 * @return the status of this council session
	 */
	@Override
	public int getStatus() {
		return _councilSession.getStatus();
	}

	/**
	 * Returns the status by user ID of this council session.
	 *
	 * @return the status by user ID of this council session
	 */
	@Override
	public long getStatusByUserId() {
		return _councilSession.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this council session.
	 *
	 * @return the status by user name of this council session
	 */
	@Override
	public String getStatusByUserName() {
		return _councilSession.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this council session.
	 *
	 * @return the status by user uuid of this council session
	 */
	@Override
	public String getStatusByUserUuid() {
		return _councilSession.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this council session.
	 *
	 * @return the status date of this council session
	 */
	@Override
	public Date getStatusDate() {
		return _councilSession.getStatusDate();
	}

	/**
	 * Returns the title of this council session.
	 *
	 * @return the title of this council session
	 */
	@Override
	public String getTitle() {
		return _councilSession.getTitle();
	}

	/**
	 * Renvoie le type de conseil rattachées à cette sessions
	 */
	@Override
	public eu.strasbourg.service.council.model.Type getTypeCouncil() {
		return _councilSession.getTypeCouncil();
	}

	/**
	 * Returns the type ID of this council session.
	 *
	 * @return the type ID of this council session
	 */
	@Override
	public long getTypeId() {
		return _councilSession.getTypeId();
	}

	/**
	 * Returns the user ID of this council session.
	 *
	 * @return the user ID of this council session
	 */
	@Override
	public long getUserId() {
		return _councilSession.getUserId();
	}

	/**
	 * Returns the user name of this council session.
	 *
	 * @return the user name of this council session
	 */
	@Override
	public String getUserName() {
		return _councilSession.getUserName();
	}

	/**
	 * Returns the user uuid of this council session.
	 *
	 * @return the user uuid of this council session
	 */
	@Override
	public String getUserUuid() {
		return _councilSession.getUserUuid();
	}

	/**
	 * Returns the uuid of this council session.
	 *
	 * @return the uuid of this council session
	 */
	@Override
	public String getUuid() {
		return _councilSession.getUuid();
	}

	@Override
	public int hashCode() {
		return _councilSession.hashCode();
	}

	/**
	 * Returns <code>true</code> if this council session is approved.
	 *
	 * @return <code>true</code> if this council session is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return _councilSession.isApproved();
	}

	@Override
	public boolean isCachedModel() {
		return _councilSession.isCachedModel();
	}

	/**
	 * Returns <code>true</code> if this council session is denied.
	 *
	 * @return <code>true</code> if this council session is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return _councilSession.isDenied();
	}

	/**
	 * Returns <code>true</code> if this council session is a draft.
	 *
	 * @return <code>true</code> if this council session is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return _councilSession.isDraft();
	}

	@Override
	public boolean isEscapedModel() {
		return _councilSession.isEscapedModel();
	}

	/**
	 * Returns <code>true</code> if this council session is expired.
	 *
	 * @return <code>true</code> if this council session is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return _councilSession.isExpired();
	}

	/**
	 * Returns <code>true</code> if this council session is inactive.
	 *
	 * @return <code>true</code> if this council session is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return _councilSession.isInactive();
	}

	/**
	 * Returns <code>true</code> if this council session is incomplete.
	 *
	 * @return <code>true</code> if this council session is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return _councilSession.isIncomplete();
	}

	@Override
	public boolean isNew() {
		return _councilSession.isNew();
	}

	/**
	 * Returns <code>true</code> if this council session is pending.
	 *
	 * @return <code>true</code> if this council session is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return _councilSession.isPending();
	}

	/**
	 * Returns <code>true</code> if this council session is scheduled.
	 *
	 * @return <code>true</code> if this council session is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return _councilSession.isScheduled();
	}

	@Override
	public void persist() {
		_councilSession.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_councilSession.setCachedModel(cachedModel);
	}

	/**
	 * Sets the company ID of this council session.
	 *
	 * @param companyId the company ID of this council session
	 */
	@Override
	public void setCompanyId(long companyId) {
		_councilSession.setCompanyId(companyId);
	}

	/**
	 * Sets the council session ID of this council session.
	 *
	 * @param councilSessionId the council session ID of this council session
	 */
	@Override
	public void setCouncilSessionId(long councilSessionId) {
		_councilSession.setCouncilSessionId(councilSessionId);
	}

	/**
	 * Sets the create date of this council session.
	 *
	 * @param createDate the create date of this council session
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_councilSession.setCreateDate(createDate);
	}

	/**
	 * Sets the date of this council session.
	 *
	 * @param date the date of this council session
	 */
	@Override
	public void setDate(Date date) {
		_councilSession.setDate(date);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_councilSession.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_councilSession.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_councilSession.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the group ID of this council session.
	 *
	 * @param groupId the group ID of this council session
	 */
	@Override
	public void setGroupId(long groupId) {
		_councilSession.setGroupId(groupId);
	}

	/**
	 * Sets the last delib processed of this council session.
	 *
	 * @param lastDelibProcessed the last delib processed of this council session
	 */
	@Override
	public void setLastDelibProcessed(long lastDelibProcessed) {
		_councilSession.setLastDelibProcessed(lastDelibProcessed);
	}

	/**
	 * Sets the modified date of this council session.
	 *
	 * @param modifiedDate the modified date of this council session
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_councilSession.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_councilSession.setNew(n);
	}

	/**
	 * Sets the official leader ID of this council session.
	 *
	 * @param officialLeaderId the official leader ID of this council session
	 */
	@Override
	public void setOfficialLeaderId(long officialLeaderId) {
		_councilSession.setOfficialLeaderId(officialLeaderId);
	}

	/**
	 * Sets the primary key of this council session.
	 *
	 * @param primaryKey the primary key of this council session
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_councilSession.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_councilSession.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the status of this council session.
	 *
	 * @param status the status of this council session
	 */
	@Override
	public void setStatus(int status) {
		_councilSession.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this council session.
	 *
	 * @param statusByUserId the status by user ID of this council session
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_councilSession.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this council session.
	 *
	 * @param statusByUserName the status by user name of this council session
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		_councilSession.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this council session.
	 *
	 * @param statusByUserUuid the status by user uuid of this council session
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		_councilSession.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this council session.
	 *
	 * @param statusDate the status date of this council session
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		_councilSession.setStatusDate(statusDate);
	}

	/**
	 * Sets the title of this council session.
	 *
	 * @param title the title of this council session
	 */
	@Override
	public void setTitle(String title) {
		_councilSession.setTitle(title);
	}

	/**
	 * Sets the type ID of this council session.
	 *
	 * @param typeId the type ID of this council session
	 */
	@Override
	public void setTypeId(long typeId) {
		_councilSession.setTypeId(typeId);
	}

	/**
	 * Sets the user ID of this council session.
	 *
	 * @param userId the user ID of this council session
	 */
	@Override
	public void setUserId(long userId) {
		_councilSession.setUserId(userId);
	}

	/**
	 * Sets the user name of this council session.
	 *
	 * @param userName the user name of this council session
	 */
	@Override
	public void setUserName(String userName) {
		_councilSession.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this council session.
	 *
	 * @param userUuid the user uuid of this council session
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_councilSession.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this council session.
	 *
	 * @param uuid the uuid of this council session
	 */
	@Override
	public void setUuid(String uuid) {
		_councilSession.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<eu.strasbourg.service.council.model.CouncilSession> toCacheModel() {

		return _councilSession.toCacheModel();
	}

	@Override
	public eu.strasbourg.service.council.model.CouncilSession toEscapedModel() {
		return new CouncilSessionWrapper(_councilSession.toEscapedModel());
	}

	@Override
	public String toString() {
		return _councilSession.toString();
	}

	@Override
	public eu.strasbourg.service.council.model.CouncilSession
		toUnescapedModel() {

		return new CouncilSessionWrapper(_councilSession.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _councilSession.toXmlString();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CouncilSessionWrapper)) {
			return false;
		}

		CouncilSessionWrapper councilSessionWrapper =
			(CouncilSessionWrapper)object;

		if (Objects.equals(
				_councilSession, councilSessionWrapper._councilSession)) {

			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _councilSession.getStagedModelType();
	}

	@Override
	public CouncilSession getWrappedModel() {
		return _councilSession;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _councilSession.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _councilSession.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_councilSession.resetOriginalValues();
	}

	private final CouncilSession _councilSession;

}