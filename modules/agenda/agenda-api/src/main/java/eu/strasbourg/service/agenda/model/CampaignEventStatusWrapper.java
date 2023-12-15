/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CampaignEventStatus}.
 * </p>
 *
 * @author BenjaminBini
 * @see CampaignEventStatus
 * @generated
 */
public class CampaignEventStatusWrapper
	extends BaseModelWrapper<CampaignEventStatus>
	implements CampaignEventStatus, ModelWrapper<CampaignEventStatus> {

	public CampaignEventStatusWrapper(CampaignEventStatus campaignEventStatus) {
		super(campaignEventStatus);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("statusId", getStatusId());
		attributes.put("status", getStatus());
		attributes.put("comment", getComment());
		attributes.put("deletionDenied", getDeletionDenied());
		attributes.put("date", getDate());
		attributes.put("campaignEventId", getCampaignEventId());
		attributes.put("previousStatusId", getPreviousStatusId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long statusId = (Long)attributes.get("statusId");

		if (statusId != null) {
			setStatusId(statusId);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String comment = (String)attributes.get("comment");

		if (comment != null) {
			setComment(comment);
		}

		Boolean deletionDenied = (Boolean)attributes.get("deletionDenied");

		if (deletionDenied != null) {
			setDeletionDenied(deletionDenied);
		}

		Date date = (Date)attributes.get("date");

		if (date != null) {
			setDate(date);
		}

		Long campaignEventId = (Long)attributes.get("campaignEventId");

		if (campaignEventId != null) {
			setCampaignEventId(campaignEventId);
		}

		Long previousStatusId = (Long)attributes.get("previousStatusId");

		if (previousStatusId != null) {
			setPreviousStatusId(previousStatusId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}
	}

	@Override
	public CampaignEventStatus cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the campaign event ID of this campaign event status.
	 *
	 * @return the campaign event ID of this campaign event status
	 */
	@Override
	public long getCampaignEventId() {
		return model.getCampaignEventId();
	}

	/**
	 * Returns the comment of this campaign event status.
	 *
	 * @return the comment of this campaign event status
	 */
	@Override
	public String getComment() {
		return model.getComment();
	}

	/**
	 * Returns the date of this campaign event status.
	 *
	 * @return the date of this campaign event status
	 */
	@Override
	public Date getDate() {
		return model.getDate();
	}

	/**
	 * Returns the deletion denied of this campaign event status.
	 *
	 * @return the deletion denied of this campaign event status
	 */
	@Override
	public Boolean getDeletionDenied() {
		return model.getDeletionDenied();
	}

	@Override
	public eu.strasbourg.service.agenda.model.CampaignEventStatus
		getPreviousStatus() {

		return model.getPreviousStatus();
	}

	/**
	 * Returns the previous status ID of this campaign event status.
	 *
	 * @return the previous status ID of this campaign event status
	 */
	@Override
	public long getPreviousStatusId() {
		return model.getPreviousStatusId();
	}

	/**
	 * Returns the primary key of this campaign event status.
	 *
	 * @return the primary key of this campaign event status
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this campaign event status.
	 *
	 * @return the status of this campaign event status
	 */
	@Override
	public Integer getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status ID of this campaign event status.
	 *
	 * @return the status ID of this campaign event status
	 */
	@Override
	public long getStatusId() {
		return model.getStatusId();
	}

	/**
	 * Retourne le label correspondant au statut
	 */
	@Override
	public String getStatusLabel() {
		return model.getStatusLabel();
	}

	/**
	 * Returns the user ID of this campaign event status.
	 *
	 * @return the user ID of this campaign event status
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this campaign event status.
	 *
	 * @return the user name of this campaign event status
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this campaign event status.
	 *
	 * @return the user uuid of this campaign event status
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this campaign event status.
	 *
	 * @return the uuid of this campaign event status
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the campaign event ID of this campaign event status.
	 *
	 * @param campaignEventId the campaign event ID of this campaign event status
	 */
	@Override
	public void setCampaignEventId(long campaignEventId) {
		model.setCampaignEventId(campaignEventId);
	}

	/**
	 * Sets the comment of this campaign event status.
	 *
	 * @param comment the comment of this campaign event status
	 */
	@Override
	public void setComment(String comment) {
		model.setComment(comment);
	}

	/**
	 * Sets the date of this campaign event status.
	 *
	 * @param date the date of this campaign event status
	 */
	@Override
	public void setDate(Date date) {
		model.setDate(date);
	}

	/**
	 * Sets the deletion denied of this campaign event status.
	 *
	 * @param deletionDenied the deletion denied of this campaign event status
	 */
	@Override
	public void setDeletionDenied(Boolean deletionDenied) {
		model.setDeletionDenied(deletionDenied);
	}

	/**
	 * Sets the previous status ID of this campaign event status.
	 *
	 * @param previousStatusId the previous status ID of this campaign event status
	 */
	@Override
	public void setPreviousStatusId(long previousStatusId) {
		model.setPreviousStatusId(previousStatusId);
	}

	/**
	 * Sets the primary key of this campaign event status.
	 *
	 * @param primaryKey the primary key of this campaign event status
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this campaign event status.
	 *
	 * @param status the status of this campaign event status
	 */
	@Override
	public void setStatus(Integer status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status ID of this campaign event status.
	 *
	 * @param statusId the status ID of this campaign event status
	 */
	@Override
	public void setStatusId(long statusId) {
		model.setStatusId(statusId);
	}

	/**
	 * Sets the user ID of this campaign event status.
	 *
	 * @param userId the user ID of this campaign event status
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this campaign event status.
	 *
	 * @param userName the user name of this campaign event status
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this campaign event status.
	 *
	 * @param userUuid the user uuid of this campaign event status
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this campaign event status.
	 *
	 * @param uuid the uuid of this campaign event status
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
	protected CampaignEventStatusWrapper wrap(
		CampaignEventStatus campaignEventStatus) {

		return new CampaignEventStatusWrapper(campaignEventStatus);
	}

}