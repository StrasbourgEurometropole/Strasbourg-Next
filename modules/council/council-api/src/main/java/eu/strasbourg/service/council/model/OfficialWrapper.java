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
 * This class is a wrapper for {@link Official}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Official
 * @generated
 */
public class OfficialWrapper
	extends BaseModelWrapper<Official>
	implements ModelWrapper<Official>, Official {

	public OfficialWrapper(Official official) {
		super(official);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("officialId", getOfficialId());
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
		attributes.put("email", getEmail());
		attributes.put("firstname", getFirstname());
		attributes.put("lastname", getLastname());
		attributes.put("isActive", isIsActive());
		attributes.put("lastActivity", getLastActivity());
		attributes.put("lastSignInDeviceInfo", getLastSignInDeviceInfo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long officialId = (Long)attributes.get("officialId");

		if (officialId != null) {
			setOfficialId(officialId);
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

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String firstname = (String)attributes.get("firstname");

		if (firstname != null) {
			setFirstname(firstname);
		}

		String lastname = (String)attributes.get("lastname");

		if (lastname != null) {
			setLastname(lastname);
		}

		Boolean isActive = (Boolean)attributes.get("isActive");

		if (isActive != null) {
			setIsActive(isActive);
		}

		Date lastActivity = (Date)attributes.get("lastActivity");

		if (lastActivity != null) {
			setLastActivity(lastActivity);
		}

		String lastSignInDeviceInfo = (String)attributes.get(
			"lastSignInDeviceInfo");

		if (lastSignInDeviceInfo != null) {
			setLastSignInDeviceInfo(lastSignInDeviceInfo);
		}
	}

	@Override
	public Official cloneWithOriginalValues() {
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
	 * Returns the company ID of this official.
	 *
	 * @return the company ID of this official
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Renvoie les types de conseil rattachés à cet élu
	 */
	@Override
	public java.util.List<eu.strasbourg.service.council.model.Type>
		getCouncilTypes() {

		return model.getCouncilTypes();
	}

	/**
	 * Renvoie un strind 'id types de conseil rattachés à cet élu
	 */
	@Override
	public String getCouncilTypesIds() {
		return model.getCouncilTypesIds();
	}

	/**
	 * Returns the create date of this official.
	 *
	 * @return the create date of this official
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the email of this official.
	 *
	 * @return the email of this official
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the firstname of this official.
	 *
	 * @return the firstname of this official
	 */
	@Override
	public String getFirstname() {
		return model.getFirstname();
	}

	/**
	 * Renvoie le nom de complet au format "Prénom NOM"
	 */
	@Override
	public String getFullName() {
		return model.getFullName();
	}

	/**
	 * Returns the group ID of this official.
	 *
	 * @return the group ID of this official
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the is active of this official.
	 *
	 * @return the is active of this official
	 */
	@Override
	public boolean getIsActive() {
		return model.getIsActive();
	}

	/**
	 * Returns the last activity of this official.
	 *
	 * @return the last activity of this official
	 */
	@Override
	public Date getLastActivity() {
		return model.getLastActivity();
	}

	/**
	 * Returns the lastname of this official.
	 *
	 * @return the lastname of this official
	 */
	@Override
	public String getLastname() {
		return model.getLastname();
	}

	/**
	 * Returns the last sign in device info of this official.
	 *
	 * @return the last sign in device info of this official
	 */
	@Override
	public String getLastSignInDeviceInfo() {
		return model.getLastSignInDeviceInfo();
	}

	/**
	 * Returns the modified date of this official.
	 *
	 * @return the modified date of this official
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the official ID of this official.
	 *
	 * @return the official ID of this official
	 */
	@Override
	public long getOfficialId() {
		return model.getOfficialId();
	}

	/**
	 * Returns the primary key of this official.
	 *
	 * @return the primary key of this official
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this official.
	 *
	 * @return the status of this official
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this official.
	 *
	 * @return the status by user ID of this official
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this official.
	 *
	 * @return the status by user name of this official
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this official.
	 *
	 * @return the status by user uuid of this official
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this official.
	 *
	 * @return the status date of this official
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the user ID of this official.
	 *
	 * @return the user ID of this official
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this official.
	 *
	 * @return the user name of this official
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this official.
	 *
	 * @return the user uuid of this official
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this official.
	 *
	 * @return the uuid of this official
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this official is approved.
	 *
	 * @return <code>true</code> if this official is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Renvoie le statut de connection de l'utilisateur
	 *
	 * @return True si la dernière connection date de moins de 15sec
	 */
	@Override
	public boolean isConnected() {
		return model.isConnected();
	}

	/**
	 * Returns <code>true</code> if this official is denied.
	 *
	 * @return <code>true</code> if this official is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this official is a draft.
	 *
	 * @return <code>true</code> if this official is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this official is expired.
	 *
	 * @return <code>true</code> if this official is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this official is inactive.
	 *
	 * @return <code>true</code> if this official is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this official is incomplete.
	 *
	 * @return <code>true</code> if this official is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this official is is active.
	 *
	 * @return <code>true</code> if this official is is active; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsActive() {
		return model.isIsActive();
	}

	/**
	 * Renvoie si l'electeur est noté absent pour la session données
	 */
	@Override
	public boolean isNotedAbsent(long councilSessionId) {
		return model.isNotedAbsent(councilSessionId);
	}

	/**
	 * Returns <code>true</code> if this official is pending.
	 *
	 * @return <code>true</code> if this official is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this official is scheduled.
	 *
	 * @return <code>true</code> if this official is scheduled; <code>false</code> otherwise
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
	 * Sets the company ID of this official.
	 *
	 * @param companyId the company ID of this official
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this official.
	 *
	 * @param createDate the create date of this official
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the email of this official.
	 *
	 * @param email the email of this official
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the firstname of this official.
	 *
	 * @param firstname the firstname of this official
	 */
	@Override
	public void setFirstname(String firstname) {
		model.setFirstname(firstname);
	}

	/**
	 * Sets the group ID of this official.
	 *
	 * @param groupId the group ID of this official
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets whether this official is is active.
	 *
	 * @param isActive the is active of this official
	 */
	@Override
	public void setIsActive(boolean isActive) {
		model.setIsActive(isActive);
	}

	/**
	 * Sets the last activity of this official.
	 *
	 * @param lastActivity the last activity of this official
	 */
	@Override
	public void setLastActivity(Date lastActivity) {
		model.setLastActivity(lastActivity);
	}

	/**
	 * Sets the lastname of this official.
	 *
	 * @param lastname the lastname of this official
	 */
	@Override
	public void setLastname(String lastname) {
		model.setLastname(lastname);
	}

	/**
	 * Sets the last sign in device info of this official.
	 *
	 * @param lastSignInDeviceInfo the last sign in device info of this official
	 */
	@Override
	public void setLastSignInDeviceInfo(String lastSignInDeviceInfo) {
		model.setLastSignInDeviceInfo(lastSignInDeviceInfo);
	}

	/**
	 * Sets the modified date of this official.
	 *
	 * @param modifiedDate the modified date of this official
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the official ID of this official.
	 *
	 * @param officialId the official ID of this official
	 */
	@Override
	public void setOfficialId(long officialId) {
		model.setOfficialId(officialId);
	}

	/**
	 * Sets the primary key of this official.
	 *
	 * @param primaryKey the primary key of this official
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this official.
	 *
	 * @param status the status of this official
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this official.
	 *
	 * @param statusByUserId the status by user ID of this official
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this official.
	 *
	 * @param statusByUserName the status by user name of this official
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this official.
	 *
	 * @param statusByUserUuid the status by user uuid of this official
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this official.
	 *
	 * @param statusDate the status date of this official
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the user ID of this official.
	 *
	 * @param userId the user ID of this official
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this official.
	 *
	 * @param userName the user name of this official
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this official.
	 *
	 * @param userUuid the user uuid of this official
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this official.
	 *
	 * @param uuid the uuid of this official
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Renvoie l'élu au format JSON
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONObject toJSON() {
		return model.toJSON();
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
	protected OfficialWrapper wrap(Official official) {
		return new OfficialWrapper(official);
	}

}