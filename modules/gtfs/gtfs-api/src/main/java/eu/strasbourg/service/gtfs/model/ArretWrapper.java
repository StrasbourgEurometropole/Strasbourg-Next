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

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Arret}.
 * </p>
 *
 * @author Cedric Henry
 * @see Arret
 * @generated
 */
public class ArretWrapper
	extends BaseModelWrapper<Arret> implements Arret, ModelWrapper<Arret> {

	public ArretWrapper(Arret arret) {
		super(arret);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("arretId", getArretId());
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
		attributes.put("stopId", getStopId());
		attributes.put("title", getTitle());
		attributes.put("code", getCode());
		attributes.put("latitude", getLatitude());
		attributes.put("longitude", getLongitude());
		attributes.put("type", getType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long arretId = (Long)attributes.get("arretId");

		if (arretId != null) {
			setArretId(arretId);
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

		String stopId = (String)attributes.get("stopId");

		if (stopId != null) {
			setStopId(stopId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String latitude = (String)attributes.get("latitude");

		if (latitude != null) {
			setLatitude(latitude);
		}

		String longitude = (String)attributes.get("longitude");

		if (longitude != null) {
			setLongitude(longitude);
		}

		Integer type = (Integer)attributes.get("type");

		if (type != null) {
			setType(type);
		}
	}

	@Override
	public Arret cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Renvoie la liste des Alertes de cet arret
	 */
	@Override
	public java.util.List<eu.strasbourg.service.gtfs.model.Alert> getAlerts() {
		return model.getAlerts();
	}

	/**
	 * Renvoie la liste des Alertes en cours ou à venir de cet arret
	 */
	@Override
	public java.util.List<eu.strasbourg.service.gtfs.model.Alert>
		getAlertsActives() {

		return model.getAlertsActives();
	}

	/**
	 * Returns the arret ID of this arret.
	 *
	 * @return the arret ID of this arret
	 */
	@Override
	public long getArretId() {
		return model.getArretId();
	}

	/**
	 * Renvoie les prochains passages
	 */
	@Override
	public java.util.List<com.liferay.portal.kernel.json.JSONObject>
		getArretRealTime() {

		return model.getArretRealTime();
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
	 * Returns the code of this arret.
	 *
	 * @return the code of this arret
	 */
	@Override
	public String getCode() {
		return model.getCode();
	}

	/**
	 * Returns the company ID of this arret.
	 *
	 * @return the company ID of this arret
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Renvoie le count des Alertes en cours ou à venir de cet arret
	 */
	@Override
	public long getCountAlertsActives() {
		return _arret.getCountAlertsActives();
	}

	/**
	 * Returns the create date of this arret.
	 *
	 * @return the create date of this arret
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Renvoie la liste des Directions de cet arret
	 */
	@Override
	public java.util.List<eu.strasbourg.service.gtfs.model.Direction>
		getDirections() {

		return model.getDirections();
	}

	/**
	 * Renvoie les directions sans doublon de lignes shortName, [bgColor, textColor, destinationName]
	 */
	@Override
	public Map<String, String[]> getDirectionsUniques() {
		return model.getDirectionsUniques();
	}

	/**
	 * Renvoie le JSON de l'entite au format GeoJSON pour la map
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONObject getGeoJSON(
		long groupId, java.util.Locale locale) {

		return model.getGeoJSON(groupId, locale);
	}

	/**
	 * Returns the group ID of this arret.
	 *
	 * @return the group ID of this arret
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the latitude of this arret.
	 *
	 * @return the latitude of this arret
	 */
	@Override
	public String getLatitude() {
		return model.getLatitude();
	}

	/**
	 * Returns the longitude of this arret.
	 *
	 * @return the longitude of this arret
	 */
	@Override
	public String getLongitude() {
		return model.getLongitude();
	}

	/**
	 * Returns the modified date of this arret.
	 *
	 * @return the modified date of this arret
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this arret.
	 *
	 * @return the primary key of this arret
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this arret.
	 *
	 * @return the status of this arret
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this arret.
	 *
	 * @return the status by user ID of this arret
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this arret.
	 *
	 * @return the status by user name of this arret
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this arret.
	 *
	 * @return the status by user uuid of this arret
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this arret.
	 *
	 * @return the status date of this arret
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the stop ID of this arret.
	 *
	 * @return the stop ID of this arret
	 */
	@Override
	public String getStopId() {
		return model.getStopId();
	}

	/**
	 * Returns the title of this arret.
	 *
	 * @return the title of this arret
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the type of this arret.
	 *
	 * @return the type of this arret
	 */
	@Override
	public int getType() {
		return model.getType();
	}

	/**
	 * Renvoie la correspondance du type d'arret en format texte
	 */
	@Override
	public String getTypeText() {
		return model.getTypeText();
	}

	/**
	 * Returns the user ID of this arret.
	 *
	 * @return the user ID of this arret
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this arret.
	 *
	 * @return the user name of this arret
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this arret.
	 *
	 * @return the user uuid of this arret
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this arret.
	 *
	 * @return the uuid of this arret
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this arret is approved.
	 *
	 * @return <code>true</code> if this arret is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this arret is denied.
	 *
	 * @return <code>true</code> if this arret is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this arret is a draft.
	 *
	 * @return <code>true</code> if this arret is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this arret is expired.
	 *
	 * @return <code>true</code> if this arret is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this arret is inactive.
	 *
	 * @return <code>true</code> if this arret is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this arret is incomplete.
	 *
	 * @return <code>true</code> if this arret is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this arret is pending.
	 *
	 * @return <code>true</code> if this arret is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this arret is scheduled.
	 *
	 * @return <code>true</code> if this arret is scheduled; <code>false</code> otherwise
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
	 * Sets the arret ID of this arret.
	 *
	 * @param arretId the arret ID of this arret
	 */
	@Override
	public void setArretId(long arretId) {
		model.setArretId(arretId);
	}

	/**
	 * Sets the code of this arret.
	 *
	 * @param code the code of this arret
	 */
	@Override
	public void setCode(String code) {
		model.setCode(code);
	}

	/**
	 * Sets the company ID of this arret.
	 *
	 * @param companyId the company ID of this arret
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this arret.
	 *
	 * @param createDate the create date of this arret
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this arret.
	 *
	 * @param groupId the group ID of this arret
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the latitude of this arret.
	 *
	 * @param latitude the latitude of this arret
	 */
	@Override
	public void setLatitude(String latitude) {
		model.setLatitude(latitude);
	}

	/**
	 * Sets the longitude of this arret.
	 *
	 * @param longitude the longitude of this arret
	 */
	@Override
	public void setLongitude(String longitude) {
		model.setLongitude(longitude);
	}

	/**
	 * Sets the modified date of this arret.
	 *
	 * @param modifiedDate the modified date of this arret
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this arret.
	 *
	 * @param primaryKey the primary key of this arret
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this arret.
	 *
	 * @param status the status of this arret
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this arret.
	 *
	 * @param statusByUserId the status by user ID of this arret
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this arret.
	 *
	 * @param statusByUserName the status by user name of this arret
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this arret.
	 *
	 * @param statusByUserUuid the status by user uuid of this arret
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this arret.
	 *
	 * @param statusDate the status date of this arret
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the stop ID of this arret.
	 *
	 * @param stopId the stop ID of this arret
	 */
	@Override
	public void setStopId(String stopId) {
		model.setStopId(stopId);
	}

	/**
	 * Sets the title of this arret.
	 *
	 * @param title the title of this arret
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the type of this arret.
	 *
	 * @param type the type of this arret
	 */
	@Override
	public void setType(int type) {
		model.setType(type);
	}

	/**
	 * Sets the user ID of this arret.
	 *
	 * @param userId the user ID of this arret
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this arret.
	 *
	 * @param userName the user name of this arret
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this arret.
	 *
	 * @param userUuid the user uuid of this arret
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this arret.
	 *
	 * @param uuid the uuid of this arret
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
	protected ArretWrapper wrap(Arret arret) {
		return new ArretWrapper(arret);
	}

}