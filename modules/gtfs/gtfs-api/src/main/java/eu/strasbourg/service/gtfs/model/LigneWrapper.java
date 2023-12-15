/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
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
 * This class is a wrapper for {@link Ligne}.
 * </p>
 *
 * @author Cedric Henry
 * @see Ligne
 * @generated
 */
public class LigneWrapper
	extends BaseModelWrapper<Ligne> implements Ligne, ModelWrapper<Ligne> {

	public LigneWrapper(Ligne ligne) {
		super(ligne);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("ligneId", getLigneId());
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
		attributes.put("routeId", getRouteId());
		attributes.put("shortName", getShortName());
		attributes.put("title", getTitle());
		attributes.put("type", getType());
		attributes.put("backgroundColor", getBackgroundColor());
		attributes.put("textColor", getTextColor());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long ligneId = (Long)attributes.get("ligneId");

		if (ligneId != null) {
			setLigneId(ligneId);
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

		String routeId = (String)attributes.get("routeId");

		if (routeId != null) {
			setRouteId(routeId);
		}

		String shortName = (String)attributes.get("shortName");

		if (shortName != null) {
			setShortName(shortName);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		Integer type = (Integer)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String backgroundColor = (String)attributes.get("backgroundColor");

		if (backgroundColor != null) {
			setBackgroundColor(backgroundColor);
		}

		String textColor = (String)attributes.get("textColor");

		if (textColor != null) {
			setTextColor(textColor);
		}
	}

	@Override
	public Ligne cloneWithOriginalValues() {
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
	 * Returns the background color of this ligne.
	 *
	 * @return the background color of this ligne
	 */
	@Override
	public String getBackgroundColor() {
		return model.getBackgroundColor();
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
	 * Retourne les couleurs de la ligne au format JSON
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONObject getColors() {
		return model.getColors();
	}

	/**
	 * Returns the company ID of this ligne.
	 *
	 * @return the company ID of this ligne
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this ligne.
	 *
	 * @return the create date of this ligne
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Renvoie la liste des Directions de cette ligne
	 */
	@Override
	public java.util.List<eu.strasbourg.service.gtfs.model.Direction>
		getDirections() {

		return model.getDirections();
	}

	/**
	 * Returns the group ID of this ligne.
	 *
	 * @return the group ID of this ligne
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ligne ID of this ligne.
	 *
	 * @return the ligne ID of this ligne
	 */
	@Override
	public long getLigneId() {
		return model.getLigneId();
	}

	/**
	 * Returns the modified date of this ligne.
	 *
	 * @return the modified date of this ligne
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this ligne.
	 *
	 * @return the primary key of this ligne
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the route ID of this ligne.
	 *
	 * @return the route ID of this ligne
	 */
	@Override
	public String getRouteId() {
		return model.getRouteId();
	}

	/**
	 * Returns the short name of this ligne.
	 *
	 * @return the short name of this ligne
	 */
	@Override
	public String getShortName() {
		return model.getShortName();
	}

	/**
	 * Returns the status of this ligne.
	 *
	 * @return the status of this ligne
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this ligne.
	 *
	 * @return the status by user ID of this ligne
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this ligne.
	 *
	 * @return the status by user name of this ligne
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this ligne.
	 *
	 * @return the status by user uuid of this ligne
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this ligne.
	 *
	 * @return the status date of this ligne
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the text color of this ligne.
	 *
	 * @return the text color of this ligne
	 */
	@Override
	public String getTextColor() {
		return model.getTextColor();
	}

	/**
	 * Returns the title of this ligne.
	 *
	 * @return the title of this ligne
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the type of this ligne.
	 *
	 * @return the type of this ligne
	 */
	@Override
	public int getType() {
		return model.getType();
	}

	/**
	 * Returns the user ID of this ligne.
	 *
	 * @return the user ID of this ligne
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this ligne.
	 *
	 * @return the user name of this ligne
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this ligne.
	 *
	 * @return the user uuid of this ligne
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this ligne.
	 *
	 * @return the uuid of this ligne
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this ligne is approved.
	 *
	 * @return <code>true</code> if this ligne is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this ligne is denied.
	 *
	 * @return <code>true</code> if this ligne is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this ligne is a draft.
	 *
	 * @return <code>true</code> if this ligne is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this ligne is expired.
	 *
	 * @return <code>true</code> if this ligne is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this ligne is inactive.
	 *
	 * @return <code>true</code> if this ligne is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this ligne is incomplete.
	 *
	 * @return <code>true</code> if this ligne is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this ligne is pending.
	 *
	 * @return <code>true</code> if this ligne is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this ligne is scheduled.
	 *
	 * @return <code>true</code> if this ligne is scheduled; <code>false</code> otherwise
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
	 * Sets the background color of this ligne.
	 *
	 * @param backgroundColor the background color of this ligne
	 */
	@Override
	public void setBackgroundColor(String backgroundColor) {
		model.setBackgroundColor(backgroundColor);
	}

	/**
	 * Sets the company ID of this ligne.
	 *
	 * @param companyId the company ID of this ligne
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this ligne.
	 *
	 * @param createDate the create date of this ligne
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this ligne.
	 *
	 * @param groupId the group ID of this ligne
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ligne ID of this ligne.
	 *
	 * @param ligneId the ligne ID of this ligne
	 */
	@Override
	public void setLigneId(long ligneId) {
		model.setLigneId(ligneId);
	}

	/**
	 * Sets the modified date of this ligne.
	 *
	 * @param modifiedDate the modified date of this ligne
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this ligne.
	 *
	 * @param primaryKey the primary key of this ligne
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the route ID of this ligne.
	 *
	 * @param routeId the route ID of this ligne
	 */
	@Override
	public void setRouteId(String routeId) {
		model.setRouteId(routeId);
	}

	/**
	 * Sets the short name of this ligne.
	 *
	 * @param shortName the short name of this ligne
	 */
	@Override
	public void setShortName(String shortName) {
		model.setShortName(shortName);
	}

	/**
	 * Sets the status of this ligne.
	 *
	 * @param status the status of this ligne
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this ligne.
	 *
	 * @param statusByUserId the status by user ID of this ligne
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this ligne.
	 *
	 * @param statusByUserName the status by user name of this ligne
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this ligne.
	 *
	 * @param statusByUserUuid the status by user uuid of this ligne
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this ligne.
	 *
	 * @param statusDate the status date of this ligne
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the text color of this ligne.
	 *
	 * @param textColor the text color of this ligne
	 */
	@Override
	public void setTextColor(String textColor) {
		model.setTextColor(textColor);
	}

	/**
	 * Sets the title of this ligne.
	 *
	 * @param title the title of this ligne
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the type of this ligne.
	 *
	 * @param type the type of this ligne
	 */
	@Override
	public void setType(int type) {
		model.setType(type);
	}

	/**
	 * Sets the user ID of this ligne.
	 *
	 * @param userId the user ID of this ligne
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this ligne.
	 *
	 * @param userName the user name of this ligne
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this ligne.
	 *
	 * @param userUuid the user uuid of this ligne
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this ligne.
	 *
	 * @param uuid the uuid of this ligne
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
	protected LigneWrapper wrap(Ligne ligne) {
		return new LigneWrapper(ligne);
	}

}