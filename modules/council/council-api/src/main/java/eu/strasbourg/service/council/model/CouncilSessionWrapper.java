/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.council.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
	extends BaseModelWrapper<CouncilSession>
	implements CouncilSession, ModelWrapper<CouncilSession> {

	public CouncilSessionWrapper(CouncilSession councilSession) {
		super(councilSession);
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
	public CouncilSession cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Retourne l'AssetEntry rattaché cet item
	 */
	@Override
	public com.liferay.asset.kernel.model.AssetEntry getAssetEntry() {
		return model.getAssetEntry();
	}

	/**
	 * Renvoie la liste des AssetCategory rattachées à cet item (via l'assetEntry)
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCategories() {

		return model.getCategories();
	}

	/**
	 * Returns the company ID of this council session.
	 *
	 * @return the company ID of this council session
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the council session ID of this council session.
	 *
	 * @return the council session ID of this council session
	 */
	@Override
	public long getCouncilSessionId() {
		return model.getCouncilSessionId();
	}

	/**
	 * Returns the create date of this council session.
	 *
	 * @return the create date of this council session
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the date of this council session.
	 *
	 * @return the date of this council session
	 */
	@Override
	public Date getDate() {
		return model.getDate();
	}

	/**
	 * Returns the group ID of this council session.
	 *
	 * @return the group ID of this council session
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the last delib processed of this council session.
	 *
	 * @return the last delib processed of this council session
	 */
	@Override
	public long getLastDelibProcessed() {
		return model.getLastDelibProcessed();
	}

	/**
	 * Returns the modified date of this council session.
	 *
	 * @return the modified date of this council session
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Renvoie l'élu président du conseil rattachées à cette sessions
	 */
	@Override
	public eu.strasbourg.service.council.model.Official getOfficialLeader() {
		return model.getOfficialLeader();
	}

	/**
	 * Renvoie le nom complet de l'élu président du conseil
	 */
	@Override
	public String getOfficialLeaderFullName() {
		return model.getOfficialLeaderFullName();
	}

	/**
	 * Returns the official leader ID of this council session.
	 *
	 * @return the official leader ID of this council session
	 */
	@Override
	public long getOfficialLeaderId() {
		return model.getOfficialLeaderId();
	}

	/**
	 * Returns the primary key of this council session.
	 *
	 * @return the primary key of this council session
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Renvoie la liste des procurations rattachées à cette sessions
	 */
	@Override
	public java.util.List<eu.strasbourg.service.council.model.Procuration>
		getProcurations() {

		return model.getProcurations();
	}

	/**
	 * Returns the status of this council session.
	 *
	 * @return the status of this council session
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this council session.
	 *
	 * @return the status by user ID of this council session
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this council session.
	 *
	 * @return the status by user name of this council session
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this council session.
	 *
	 * @return the status by user uuid of this council session
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this council session.
	 *
	 * @return the status date of this council session
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the title of this council session.
	 *
	 * @return the title of this council session
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Renvoie le type de conseil rattachées à cette sessions
	 */
	@Override
	public eu.strasbourg.service.council.model.Type getTypeCouncil() {
		return model.getTypeCouncil();
	}

	/**
	 * Returns the type ID of this council session.
	 *
	 * @return the type ID of this council session
	 */
	@Override
	public long getTypeId() {
		return model.getTypeId();
	}

	/**
	 * Returns the user ID of this council session.
	 *
	 * @return the user ID of this council session
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this council session.
	 *
	 * @return the user name of this council session
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this council session.
	 *
	 * @return the user uuid of this council session
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this council session.
	 *
	 * @return the uuid of this council session
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this council session is approved.
	 *
	 * @return <code>true</code> if this council session is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this council session is denied.
	 *
	 * @return <code>true</code> if this council session is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this council session is a draft.
	 *
	 * @return <code>true</code> if this council session is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this council session is expired.
	 *
	 * @return <code>true</code> if this council session is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this council session is inactive.
	 *
	 * @return <code>true</code> if this council session is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this council session is incomplete.
	 *
	 * @return <code>true</code> if this council session is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this council session is pending.
	 *
	 * @return <code>true</code> if this council session is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this council session is scheduled.
	 *
	 * @return <code>true</code> if this council session is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this council session.
	 *
	 * @param companyId the company ID of this council session
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the council session ID of this council session.
	 *
	 * @param councilSessionId the council session ID of this council session
	 */
	@Override
	public void setCouncilSessionId(long councilSessionId) {
		model.setCouncilSessionId(councilSessionId);
	}

	/**
	 * Sets the create date of this council session.
	 *
	 * @param createDate the create date of this council session
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the date of this council session.
	 *
	 * @param date the date of this council session
	 */
	@Override
	public void setDate(Date date) {
		model.setDate(date);
	}

	/**
	 * Sets the group ID of this council session.
	 *
	 * @param groupId the group ID of this council session
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the last delib processed of this council session.
	 *
	 * @param lastDelibProcessed the last delib processed of this council session
	 */
	@Override
	public void setLastDelibProcessed(long lastDelibProcessed) {
		model.setLastDelibProcessed(lastDelibProcessed);
	}

	/**
	 * Sets the modified date of this council session.
	 *
	 * @param modifiedDate the modified date of this council session
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the official leader ID of this council session.
	 *
	 * @param officialLeaderId the official leader ID of this council session
	 */
	@Override
	public void setOfficialLeaderId(long officialLeaderId) {
		model.setOfficialLeaderId(officialLeaderId);
	}

	/**
	 * Sets the primary key of this council session.
	 *
	 * @param primaryKey the primary key of this council session
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this council session.
	 *
	 * @param status the status of this council session
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this council session.
	 *
	 * @param statusByUserId the status by user ID of this council session
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this council session.
	 *
	 * @param statusByUserName the status by user name of this council session
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this council session.
	 *
	 * @param statusByUserUuid the status by user uuid of this council session
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this council session.
	 *
	 * @param statusDate the status date of this council session
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the title of this council session.
	 *
	 * @param title the title of this council session
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the type ID of this council session.
	 *
	 * @param typeId the type ID of this council session
	 */
	@Override
	public void setTypeId(long typeId) {
		model.setTypeId(typeId);
	}

	/**
	 * Sets the user ID of this council session.
	 *
	 * @param userId the user ID of this council session
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this council session.
	 *
	 * @param userName the user name of this council session
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this council session.
	 *
	 * @param userUuid the user uuid of this council session
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this council session.
	 *
	 * @param uuid the uuid of this council session
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected CouncilSessionWrapper wrap(CouncilSession councilSession) {
		return new CouncilSessionWrapper(councilSession);
	}

}