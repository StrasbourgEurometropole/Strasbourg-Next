/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.activity.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Practice}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Practice
 * @generated
 */
public class PracticeWrapper
	extends BaseModelWrapper<Practice>
	implements ModelWrapper<Practice>, Practice {

	public PracticeWrapper(Practice practice) {
		super(practice);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("practiceId", getPracticeId());
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
		attributes.put("associationId", getAssociationId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long practiceId = (Long)attributes.get("practiceId");

		if (practiceId != null) {
			setPracticeId(practiceId);
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

		Long associationId = (Long)attributes.get("associationId");

		if (associationId != null) {
			setAssociationId(associationId);
		}
	}

	@Override
	public Practice cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Retourne l'accessibilité de l'association
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getAccessibilities() {

		return model.getAccessibilities();
	}

	/**
	 * Retourne l'AssetEntry rattaché à cette entité
	 */
	@Override
	public com.liferay.asset.kernel.model.AssetEntry getAssetEntry() {
		return model.getAssetEntry();
	}

	/**
	 * Retourne les activités de l'association
	 */
	@Override
	public eu.strasbourg.service.activity.model.Association getAssociation() {
		return model.getAssociation();
	}

	/**
	 * Returns the association ID of this practice.
	 *
	 * @return the association ID of this practice
	 */
	@Override
	public long getAssociationId() {
		return model.getAssociationId();
	}

	/**
	 * Renvoie la liste des AssetCategory rattachées à cette entité (via
	 * l'assetEntry)
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCategories() {

		return model.getCategories();
	}

	/**
	 * Returns the company ID of this practice.
	 *
	 * @return the company ID of this practice
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this practice.
	 *
	 * @return the create date of this practice
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Retourne les quartiers de l'association
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getDistricts() {

		return model.getDistricts();
	}

	/**
	 * Returns the group ID of this practice.
	 *
	 * @return the group ID of this practice
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Retourne la version live de cette entité
	 */
	@Override
	public eu.strasbourg.service.activity.model.Practice getLiveVersion() {
		return model.getLiveVersion();
	}

	/**
	 * Returns the modified date of this practice.
	 *
	 * @return the modified date of this practice
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Retourne la pratique de l'association
	 */
	@Override
	public com.liferay.asset.kernel.model.AssetCategory getPractice() {
		return model.getPractice();
	}

	/**
	 * Returns the practice ID of this practice.
	 *
	 * @return the practice ID of this practice
	 */
	@Override
	public long getPracticeId() {
		return model.getPracticeId();
	}

	/**
	 * Returns the primary key of this practice.
	 *
	 * @return the primary key of this practice
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Retourne les publics de l'association
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getPublics() {

		return model.getPublics();
	}

	/**
	 * Returns the status of this practice.
	 *
	 * @return the status of this practice
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this practice.
	 *
	 * @return the status by user ID of this practice
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this practice.
	 *
	 * @return the status by user name of this practice
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this practice.
	 *
	 * @return the status by user uuid of this practice
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this practice.
	 *
	 * @return the status date of this practice
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the user ID of this practice.
	 *
	 * @return the user ID of this practice
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this practice.
	 *
	 * @return the user name of this practice
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this practice.
	 *
	 * @return the user uuid of this practice
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this practice.
	 *
	 * @return the uuid of this practice
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this practice is approved.
	 *
	 * @return <code>true</code> if this practice is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this practice is denied.
	 *
	 * @return <code>true</code> if this practice is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this practice is a draft.
	 *
	 * @return <code>true</code> if this practice is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this practice is expired.
	 *
	 * @return <code>true</code> if this practice is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this practice is inactive.
	 *
	 * @return <code>true</code> if this practice is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this practice is incomplete.
	 *
	 * @return <code>true</code> if this practice is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this practice is pending.
	 *
	 * @return <code>true</code> if this practice is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this practice is scheduled.
	 *
	 * @return <code>true</code> if this practice is scheduled; <code>false</code> otherwise
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
	 * Sets the association ID of this practice.
	 *
	 * @param associationId the association ID of this practice
	 */
	@Override
	public void setAssociationId(long associationId) {
		model.setAssociationId(associationId);
	}

	/**
	 * Sets the company ID of this practice.
	 *
	 * @param companyId the company ID of this practice
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this practice.
	 *
	 * @param createDate the create date of this practice
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this practice.
	 *
	 * @param groupId the group ID of this practice
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this practice.
	 *
	 * @param modifiedDate the modified date of this practice
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the practice ID of this practice.
	 *
	 * @param practiceId the practice ID of this practice
	 */
	@Override
	public void setPracticeId(long practiceId) {
		model.setPracticeId(practiceId);
	}

	/**
	 * Sets the primary key of this practice.
	 *
	 * @param primaryKey the primary key of this practice
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this practice.
	 *
	 * @param status the status of this practice
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this practice.
	 *
	 * @param statusByUserId the status by user ID of this practice
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this practice.
	 *
	 * @param statusByUserName the status by user name of this practice
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this practice.
	 *
	 * @param statusByUserUuid the status by user uuid of this practice
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this practice.
	 *
	 * @param statusDate the status date of this practice
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the user ID of this practice.
	 *
	 * @param userId the user ID of this practice
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this practice.
	 *
	 * @param userName the user name of this practice
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this practice.
	 *
	 * @param userUuid the user uuid of this practice
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this practice.
	 *
	 * @param uuid the uuid of this practice
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
	protected PracticeWrapper wrap(Practice practice) {
		return new PracticeWrapper(practice);
	}

}