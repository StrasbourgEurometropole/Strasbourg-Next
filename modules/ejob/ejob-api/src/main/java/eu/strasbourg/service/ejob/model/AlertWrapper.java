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

package eu.strasbourg.service.ejob.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Alert}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Alert
 * @generated
 */
public class AlertWrapper
	extends BaseModelWrapper<Alert> implements Alert, ModelWrapper<Alert> {

	public AlertWrapper(Alert alert) {
		super(alert);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("alertId", getAlertId());
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
		attributes.put("name", getName());
		attributes.put("keyWord", getKeyWord());
		attributes.put("publikUserId", getPublikUserId());
		attributes.put("language", getLanguage());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long alertId = (Long)attributes.get("alertId");

		if (alertId != null) {
			setAlertId(alertId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String keyWord = (String)attributes.get("keyWord");

		if (keyWord != null) {
			setKeyWord(keyWord);
		}

		String publikUserId = (String)attributes.get("publikUserId");

		if (publikUserId != null) {
			setPublikUserId(publikUserId);
		}

		String language = (String)attributes.get("language");

		if (language != null) {
			setLanguage(language);
		}
	}

	@Override
	public Alert cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the alert ID of this alert.
	 *
	 * @return the alert ID of this alert
	 */
	@Override
	public long getAlertId() {
		return model.getAlertId();
	}

	/**
	 * Retourne l'AssetEntry rattaché cet item
	 */
	@Override
	public com.liferay.asset.kernel.model.AssetEntry getAssetEntry() {
		return model.getAssetEntry();
	}

	/**
	 * Renvoie la liste des AssetCategory rattachées à cet item (via
	 * l'assetEntry)
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCategories() {

		return model.getCategories();
	}

	/**
	 * Returns the company ID of this alert.
	 *
	 * @return the company ID of this alert
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this alert.
	 *
	 * @return the create date of this alert
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this alert.
	 *
	 * @return the group ID of this alert
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the key word of this alert.
	 *
	 * @return the key word of this alert
	 */
	@Override
	public String getKeyWord() {
		return model.getKeyWord();
	}

	/**
	 * Returns the language of this alert.
	 *
	 * @return the language of this alert
	 */
	@Override
	public String getLanguage() {
		return model.getLanguage();
	}

	/**
	 * Returns the modified date of this alert.
	 *
	 * @return the modified date of this alert
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this alert.
	 *
	 * @return the name of this alert
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this alert.
	 *
	 * @return the primary key of this alert
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the publik user ID of this alert.
	 *
	 * @return the publik user ID of this alert
	 */
	@Override
	public String getPublikUserId() {
		return model.getPublikUserId();
	}

	/**
	 * Returns the status of this alert.
	 *
	 * @return the status of this alert
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this alert.
	 *
	 * @return the status by user ID of this alert
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this alert.
	 *
	 * @return the status by user name of this alert
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this alert.
	 *
	 * @return the status by user uuid of this alert
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this alert.
	 *
	 * @return the status date of this alert
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the user ID of this alert.
	 *
	 * @return the user ID of this alert
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this alert.
	 *
	 * @return the user name of this alert
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this alert.
	 *
	 * @return the user uuid of this alert
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this alert.
	 *
	 * @return the uuid of this alert
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this alert is approved.
	 *
	 * @return <code>true</code> if this alert is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this alert is denied.
	 *
	 * @return <code>true</code> if this alert is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this alert is a draft.
	 *
	 * @return <code>true</code> if this alert is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this alert is expired.
	 *
	 * @return <code>true</code> if this alert is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this alert is inactive.
	 *
	 * @return <code>true</code> if this alert is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this alert is incomplete.
	 *
	 * @return <code>true</code> if this alert is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this alert is pending.
	 *
	 * @return <code>true</code> if this alert is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this alert is scheduled.
	 *
	 * @return <code>true</code> if this alert is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
	}

	@Override
	public void persist() {
		model.persist();
	}

	@Override
	public boolean sendMail(
		java.util.List<eu.strasbourg.service.ejob.model.Offer> listOffer) {

		return model.sendMail(listOffer);
	}

	/**
	 * Sets the alert ID of this alert.
	 *
	 * @param alertId the alert ID of this alert
	 */
	@Override
	public void setAlertId(long alertId) {
		model.setAlertId(alertId);
	}

	/**
	 * Sets the company ID of this alert.
	 *
	 * @param companyId the company ID of this alert
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this alert.
	 *
	 * @param createDate the create date of this alert
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this alert.
	 *
	 * @param groupId the group ID of this alert
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the key word of this alert.
	 *
	 * @param keyWord the key word of this alert
	 */
	@Override
	public void setKeyWord(String keyWord) {
		model.setKeyWord(keyWord);
	}

	/**
	 * Sets the language of this alert.
	 *
	 * @param language the language of this alert
	 */
	@Override
	public void setLanguage(String language) {
		model.setLanguage(language);
	}

	/**
	 * Sets the modified date of this alert.
	 *
	 * @param modifiedDate the modified date of this alert
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this alert.
	 *
	 * @param name the name of this alert
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this alert.
	 *
	 * @param primaryKey the primary key of this alert
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the publik user ID of this alert.
	 *
	 * @param publikUserId the publik user ID of this alert
	 */
	@Override
	public void setPublikUserId(String publikUserId) {
		model.setPublikUserId(publikUserId);
	}

	/**
	 * Sets the status of this alert.
	 *
	 * @param status the status of this alert
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this alert.
	 *
	 * @param statusByUserId the status by user ID of this alert
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this alert.
	 *
	 * @param statusByUserName the status by user name of this alert
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this alert.
	 *
	 * @param statusByUserUuid the status by user uuid of this alert
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this alert.
	 *
	 * @param statusDate the status date of this alert
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the user ID of this alert.
	 *
	 * @param userId the user ID of this alert
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this alert.
	 *
	 * @param userName the user name of this alert
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this alert.
	 *
	 * @param userUuid the user uuid of this alert
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this alert.
	 *
	 * @param uuid the uuid of this alert
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
	protected AlertWrapper wrap(Alert alert) {
		return new AlertWrapper(alert);
	}

}