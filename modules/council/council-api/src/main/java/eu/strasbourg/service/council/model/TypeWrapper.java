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
 * This class is a wrapper for {@link Type}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Type
 * @generated
 */
public class TypeWrapper
	extends BaseModelWrapper<Type> implements ModelWrapper<Type>, Type {

	public TypeWrapper(Type type) {
		super(type);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("typeId", getTypeId());
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
		attributes.put("titleLong", getTitleLong());
		attributes.put("roleId", getRoleId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long typeId = (Long)attributes.get("typeId");

		if (typeId != null) {
			setTypeId(typeId);
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

		String titleLong = (String)attributes.get("titleLong");

		if (titleLong != null) {
			setTitleLong(titleLong);
		}

		Long roleId = (Long)attributes.get("roleId");

		if (roleId != null) {
			setRoleId(roleId);
		}
	}

	@Override
	public Type cloneWithOriginalValues() {
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
	 * Returns the company ID of this type.
	 *
	 * @return the company ID of this type
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this type.
	 *
	 * @return the create date of this type
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this type.
	 *
	 * @return the group ID of this type
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this type.
	 *
	 * @return the modified date of this type
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this type.
	 *
	 * @return the primary key of this type
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the role ID of this type.
	 *
	 * @return the role ID of this type
	 */
	@Override
	public long getRoleId() {
		return model.getRoleId();
	}

	/**
	 * Returns the status of this type.
	 *
	 * @return the status of this type
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this type.
	 *
	 * @return the status by user ID of this type
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this type.
	 *
	 * @return the status by user name of this type
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this type.
	 *
	 * @return the status by user uuid of this type
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this type.
	 *
	 * @return the status date of this type
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the title of this type.
	 *
	 * @return the title of this type
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the title long of this type.
	 *
	 * @return the title long of this type
	 */
	@Override
	public String getTitleLong() {
		return model.getTitleLong();
	}

	/**
	 * Returns the type ID of this type.
	 *
	 * @return the type ID of this type
	 */
	@Override
	public long getTypeId() {
		return model.getTypeId();
	}

	/**
	 * Returns the user ID of this type.
	 *
	 * @return the user ID of this type
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this type.
	 *
	 * @return the user name of this type
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this type.
	 *
	 * @return the user uuid of this type
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this type.
	 *
	 * @return the uuid of this type
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this type is approved.
	 *
	 * @return <code>true</code> if this type is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this type is denied.
	 *
	 * @return <code>true</code> if this type is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this type is a draft.
	 *
	 * @return <code>true</code> if this type is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this type is expired.
	 *
	 * @return <code>true</code> if this type is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this type is inactive.
	 *
	 * @return <code>true</code> if this type is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this type is incomplete.
	 *
	 * @return <code>true</code> if this type is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this type is pending.
	 *
	 * @return <code>true</code> if this type is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this type is scheduled.
	 *
	 * @return <code>true</code> if this type is scheduled; <code>false</code> otherwise
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
	 * Sets the company ID of this type.
	 *
	 * @param companyId the company ID of this type
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this type.
	 *
	 * @param createDate the create date of this type
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this type.
	 *
	 * @param groupId the group ID of this type
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this type.
	 *
	 * @param modifiedDate the modified date of this type
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this type.
	 *
	 * @param primaryKey the primary key of this type
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the role ID of this type.
	 *
	 * @param roleId the role ID of this type
	 */
	@Override
	public void setRoleId(long roleId) {
		model.setRoleId(roleId);
	}

	/**
	 * Sets the status of this type.
	 *
	 * @param status the status of this type
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this type.
	 *
	 * @param statusByUserId the status by user ID of this type
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this type.
	 *
	 * @param statusByUserName the status by user name of this type
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this type.
	 *
	 * @param statusByUserUuid the status by user uuid of this type
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this type.
	 *
	 * @param statusDate the status date of this type
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the title of this type.
	 *
	 * @param title the title of this type
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the title long of this type.
	 *
	 * @param titleLong the title long of this type
	 */
	@Override
	public void setTitleLong(String titleLong) {
		model.setTitleLong(titleLong);
	}

	/**
	 * Sets the type ID of this type.
	 *
	 * @param typeId the type ID of this type
	 */
	@Override
	public void setTypeId(long typeId) {
		model.setTypeId(typeId);
	}

	/**
	 * Sets the user ID of this type.
	 *
	 * @param userId the user ID of this type
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this type.
	 *
	 * @param userName the user name of this type
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this type.
	 *
	 * @param userUuid the user uuid of this type
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this type.
	 *
	 * @param uuid the uuid of this type
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
	protected TypeWrapper wrap(Type type) {
		return new TypeWrapper(type);
	}

}