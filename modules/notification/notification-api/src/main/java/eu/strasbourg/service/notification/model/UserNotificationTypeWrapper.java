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

package eu.strasbourg.service.notification.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link UserNotificationType}.
 * </p>
 *
 * @author BenjaminBini
 * @see UserNotificationType
 * @generated
 */
public class UserNotificationTypeWrapper
	extends BaseModelWrapper<UserNotificationType>
	implements ModelWrapper<UserNotificationType>, UserNotificationType {

	public UserNotificationTypeWrapper(
		UserNotificationType userNotificationType) {

		super(userNotificationType);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("publikUserId", getPublikUserId());
		attributes.put("typeId", getTypeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String publikUserId = (String)attributes.get("publikUserId");

		if (publikUserId != null) {
			setPublikUserId(publikUserId);
		}

		Long typeId = (Long)attributes.get("typeId");

		if (typeId != null) {
			setTypeId(typeId);
		}
	}

	@Override
	public UserNotificationType cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the primary key of this user notification type.
	 *
	 * @return the primary key of this user notification type
	 */
	@Override
	public eu.strasbourg.service.notification.service.persistence.
		UserNotificationTypePK getPrimaryKey() {

		return model.getPrimaryKey();
	}

	/**
	 * Returns the publik user ID of this user notification type.
	 *
	 * @return the publik user ID of this user notification type
	 */
	@Override
	public String getPublikUserId() {
		return model.getPublikUserId();
	}

	/**
	 * Returns the type ID of this user notification type.
	 *
	 * @return the type ID of this user notification type
	 */
	@Override
	public long getTypeId() {
		return model.getTypeId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the primary key of this user notification type.
	 *
	 * @param primaryKey the primary key of this user notification type
	 */
	@Override
	public void setPrimaryKey(
		eu.strasbourg.service.notification.service.persistence.
			UserNotificationTypePK primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the publik user ID of this user notification type.
	 *
	 * @param publikUserId the publik user ID of this user notification type
	 */
	@Override
	public void setPublikUserId(String publikUserId) {
		model.setPublikUserId(publikUserId);
	}

	/**
	 * Sets the type ID of this user notification type.
	 *
	 * @param typeId the type ID of this user notification type
	 */
	@Override
	public void setTypeId(long typeId) {
		model.setTypeId(typeId);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected UserNotificationTypeWrapper wrap(
		UserNotificationType userNotificationType) {

		return new UserNotificationTypeWrapper(userNotificationType);
	}

}