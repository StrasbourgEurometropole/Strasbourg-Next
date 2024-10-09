/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.notification.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link UserNotificationStatus}.
 * </p>
 *
 * @author BenjaminBini
 * @see UserNotificationStatus
 * @generated
 */
public class UserNotificationStatusWrapper
	extends BaseModelWrapper<UserNotificationStatus>
	implements ModelWrapper<UserNotificationStatus>, UserNotificationStatus {

	public UserNotificationStatusWrapper(
		UserNotificationStatus userNotificationStatus) {

		super(userNotificationStatus);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("notificationId", getNotificationId());
		attributes.put("publikUserId", getPublikUserId());
		attributes.put("read", isRead());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long notificationId = (Long)attributes.get("notificationId");

		if (notificationId != null) {
			setNotificationId(notificationId);
		}

		String publikUserId = (String)attributes.get("publikUserId");

		if (publikUserId != null) {
			setPublikUserId(publikUserId);
		}

		Boolean read = (Boolean)attributes.get("read");

		if (read != null) {
			setRead(read);
		}
	}

	@Override
	public UserNotificationStatus cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	@Override
	public Notification getNotification() {
		return model.getNotification();
	}

	/**
	 * Returns the notification ID of this user notification status.
	 *
	 * @return the notification ID of this user notification status
	 */
	@Override
	public long getNotificationId() {
		return model.getNotificationId();
	}

	/**
	 * Returns the primary key of this user notification status.
	 *
	 * @return the primary key of this user notification status
	 */
	@Override
	public eu.strasbourg.service.notification.service.persistence.
		UserNotificationStatusPK getPrimaryKey() {

		return model.getPrimaryKey();
	}

	/**
	 * Returns the publik user ID of this user notification status.
	 *
	 * @return the publik user ID of this user notification status
	 */
	@Override
	public String getPublikUserId() {
		return model.getPublikUserId();
	}

	/**
	 * Returns the read of this user notification status.
	 *
	 * @return the read of this user notification status
	 */
	@Override
	public boolean getRead() {
		return model.getRead();
	}

	/**
	 * Returns <code>true</code> if this user notification status is read.
	 *
	 * @return <code>true</code> if this user notification status is read; <code>false</code> otherwise
	 */
	@Override
	public boolean isRead() {
		return model.isRead();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the notification ID of this user notification status.
	 *
	 * @param notificationId the notification ID of this user notification status
	 */
	@Override
	public void setNotificationId(long notificationId) {
		model.setNotificationId(notificationId);
	}

	/**
	 * Sets the primary key of this user notification status.
	 *
	 * @param primaryKey the primary key of this user notification status
	 */
	@Override
	public void setPrimaryKey(
		eu.strasbourg.service.notification.service.persistence.
			UserNotificationStatusPK primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the publik user ID of this user notification status.
	 *
	 * @param publikUserId the publik user ID of this user notification status
	 */
	@Override
	public void setPublikUserId(String publikUserId) {
		model.setPublikUserId(publikUserId);
	}

	/**
	 * Sets whether this user notification status is read.
	 *
	 * @param read the read of this user notification status
	 */
	@Override
	public void setRead(boolean read) {
		model.setRead(read);
	}

	/**
	 * Retourne la version JSON de l'objet
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
	protected UserNotificationStatusWrapper wrap(
		UserNotificationStatus userNotificationStatus) {

		return new UserNotificationStatusWrapper(userNotificationStatus);
	}

}