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
 * This class is a wrapper for {@link UserNotificationChannel}.
 * </p>
 *
 * @author BenjaminBini
 * @see UserNotificationChannel
 * @generated
 */
public class UserNotificationChannelWrapper
	extends BaseModelWrapper<UserNotificationChannel>
	implements ModelWrapper<UserNotificationChannel>, UserNotificationChannel {

	public UserNotificationChannelWrapper(
		UserNotificationChannel userNotificationChannel) {

		super(userNotificationChannel);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("publikUserId", getPublikUserId());
		attributes.put("channelId", getChannelId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String publikUserId = (String)attributes.get("publikUserId");

		if (publikUserId != null) {
			setPublikUserId(publikUserId);
		}

		Long channelId = (Long)attributes.get("channelId");

		if (channelId != null) {
			setChannelId(channelId);
		}
	}

	@Override
	public UserNotificationChannel cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the channel ID of this user notification channel.
	 *
	 * @return the channel ID of this user notification channel
	 */
	@Override
	public long getChannelId() {
		return model.getChannelId();
	}

	/**
	 * Returns the primary key of this user notification channel.
	 *
	 * @return the primary key of this user notification channel
	 */
	@Override
	public eu.strasbourg.service.notification.service.persistence.
		UserNotificationChannelPK getPrimaryKey() {

		return model.getPrimaryKey();
	}

	/**
	 * Returns the publik user ID of this user notification channel.
	 *
	 * @return the publik user ID of this user notification channel
	 */
	@Override
	public String getPublikUserId() {
		return model.getPublikUserId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the channel ID of this user notification channel.
	 *
	 * @param channelId the channel ID of this user notification channel
	 */
	@Override
	public void setChannelId(long channelId) {
		model.setChannelId(channelId);
	}

	/**
	 * Sets the primary key of this user notification channel.
	 *
	 * @param primaryKey the primary key of this user notification channel
	 */
	@Override
	public void setPrimaryKey(
		eu.strasbourg.service.notification.service.persistence.
			UserNotificationChannelPK primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the publik user ID of this user notification channel.
	 *
	 * @param publikUserId the publik user ID of this user notification channel
	 */
	@Override
	public void setPublikUserId(String publikUserId) {
		model.setPublikUserId(publikUserId);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected UserNotificationChannelWrapper wrap(
		UserNotificationChannel userNotificationChannel) {

		return new UserNotificationChannelWrapper(userNotificationChannel);
	}

}