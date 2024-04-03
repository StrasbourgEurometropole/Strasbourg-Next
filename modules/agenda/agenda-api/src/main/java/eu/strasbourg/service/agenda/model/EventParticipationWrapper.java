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
 * This class is a wrapper for {@link EventParticipation}.
 * </p>
 *
 * @author BenjaminBini
 * @see EventParticipation
 * @generated
 */
public class EventParticipationWrapper
	extends BaseModelWrapper<EventParticipation>
	implements EventParticipation, ModelWrapper<EventParticipation> {

	public EventParticipationWrapper(EventParticipation eventParticipation) {
		super(eventParticipation);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("eventParticipationId", getEventParticipationId());
		attributes.put("createDate", getCreateDate());
		attributes.put("publikUserId", getPublikUserId());
		attributes.put("eventId", getEventId());
		attributes.put("groupId", getGroupId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long eventParticipationId = (Long)attributes.get(
			"eventParticipationId");

		if (eventParticipationId != null) {
			setEventParticipationId(eventParticipationId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		String publikUserId = (String)attributes.get("publikUserId");

		if (publikUserId != null) {
			setPublikUserId(publikUserId);
		}

		Long eventId = (Long)attributes.get("eventId");

		if (eventId != null) {
			setEventId(eventId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}
	}

	@Override
	public EventParticipation cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the create date of this event participation.
	 *
	 * @return the create date of this event participation
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the event ID of this event participation.
	 *
	 * @return the event ID of this event participation
	 */
	@Override
	public long getEventId() {
		return model.getEventId();
	}

	/**
	 * Returns the event participation ID of this event participation.
	 *
	 * @return the event participation ID of this event participation
	 */
	@Override
	public long getEventParticipationId() {
		return model.getEventParticipationId();
	}

	/**
	 * Returns the group ID of this event participation.
	 *
	 * @return the group ID of this event participation
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the primary key of this event participation.
	 *
	 * @return the primary key of this event participation
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the publik user ID of this event participation.
	 *
	 * @return the publik user ID of this event participation
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
	 * Sets the create date of this event participation.
	 *
	 * @param createDate the create date of this event participation
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the event ID of this event participation.
	 *
	 * @param eventId the event ID of this event participation
	 */
	@Override
	public void setEventId(long eventId) {
		model.setEventId(eventId);
	}

	/**
	 * Sets the event participation ID of this event participation.
	 *
	 * @param eventParticipationId the event participation ID of this event participation
	 */
	@Override
	public void setEventParticipationId(long eventParticipationId) {
		model.setEventParticipationId(eventParticipationId);
	}

	/**
	 * Sets the group ID of this event participation.
	 *
	 * @param groupId the group ID of this event participation
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the primary key of this event participation.
	 *
	 * @param primaryKey the primary key of this event participation
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the publik user ID of this event participation.
	 *
	 * @param publikUserId the publik user ID of this event participation
	 */
	@Override
	public void setPublikUserId(String publikUserId) {
		model.setPublikUserId(publikUserId);
	}

	/**
	 * Retourne la version JSON d'une participation d'evenement
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
	protected EventParticipationWrapper wrap(
		EventParticipation eventParticipation) {

		return new EventParticipationWrapper(eventParticipation);
	}

}