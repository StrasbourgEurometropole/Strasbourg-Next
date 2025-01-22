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
 * This class is a wrapper for {@link CacheJson}.
 * </p>
 *
 * @author BenjaminBini
 * @see CacheJson
 * @generated
 */
public class CacheJsonWrapper
	extends BaseModelWrapper<CacheJson>
	implements CacheJson, ModelWrapper<CacheJson> {

	public CacheJsonWrapper(CacheJson cacheJson) {
		super(cacheJson);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("eventId", getEventId());
		attributes.put("jsonEvent", getJsonEvent());
		attributes.put("jsonEventLegacy", getJsonEventLegacy());
		attributes.put("createEvent", getCreateEvent());
		attributes.put("modifiedEvent", getModifiedEvent());
		attributes.put("isApproved", isIsApproved());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long eventId = (Long)attributes.get("eventId");

		if (eventId != null) {
			setEventId(eventId);
		}

		String jsonEvent = (String)attributes.get("jsonEvent");

		if (jsonEvent != null) {
			setJsonEvent(jsonEvent);
		}

		String jsonEventLegacy = (String)attributes.get("jsonEventLegacy");

		if (jsonEventLegacy != null) {
			setJsonEventLegacy(jsonEventLegacy);
		}

		Date createEvent = (Date)attributes.get("createEvent");

		if (createEvent != null) {
			setCreateEvent(createEvent);
		}

		Date modifiedEvent = (Date)attributes.get("modifiedEvent");

		if (modifiedEvent != null) {
			setModifiedEvent(modifiedEvent);
		}

		Boolean isApproved = (Boolean)attributes.get("isApproved");

		if (isApproved != null) {
			setIsApproved(isApproved);
		}
	}

	@Override
	public CacheJson cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the create event of this cache json.
	 *
	 * @return the create event of this cache json
	 */
	@Override
	public Date getCreateEvent() {
		return model.getCreateEvent();
	}

	/**
	 * Returns the event ID of this cache json.
	 *
	 * @return the event ID of this cache json
	 */
	@Override
	public long getEventId() {
		return model.getEventId();
	}

	/**
	 * Returns the is approved of this cache json.
	 *
	 * @return the is approved of this cache json
	 */
	@Override
	public boolean getIsApproved() {
		return model.getIsApproved();
	}

	/**
	 * Returns the json event of this cache json.
	 *
	 * @return the json event of this cache json
	 */
	@Override
	public String getJsonEvent() {
		return model.getJsonEvent();
	}

	/**
	 * Returns the json event legacy of this cache json.
	 *
	 * @return the json event legacy of this cache json
	 */
	@Override
	public String getJsonEventLegacy() {
		return model.getJsonEventLegacy();
	}

	/**
	 * Returns the modified event of this cache json.
	 *
	 * @return the modified event of this cache json
	 */
	@Override
	public Date getModifiedEvent() {
		return model.getModifiedEvent();
	}

	/**
	 * Returns the primary key of this cache json.
	 *
	 * @return the primary key of this cache json
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns <code>true</code> if this cache json is is approved.
	 *
	 * @return <code>true</code> if this cache json is is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsApproved() {
		return model.isIsApproved();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the create event of this cache json.
	 *
	 * @param createEvent the create event of this cache json
	 */
	@Override
	public void setCreateEvent(Date createEvent) {
		model.setCreateEvent(createEvent);
	}

	/**
	 * Sets the event ID of this cache json.
	 *
	 * @param eventId the event ID of this cache json
	 */
	@Override
	public void setEventId(long eventId) {
		model.setEventId(eventId);
	}

	/**
	 * Sets whether this cache json is is approved.
	 *
	 * @param isApproved the is approved of this cache json
	 */
	@Override
	public void setIsApproved(boolean isApproved) {
		model.setIsApproved(isApproved);
	}

	/**
	 * Sets the json event of this cache json.
	 *
	 * @param jsonEvent the json event of this cache json
	 */
	@Override
	public void setJsonEvent(String jsonEvent) {
		model.setJsonEvent(jsonEvent);
	}

	/**
	 * Sets the json event legacy of this cache json.
	 *
	 * @param jsonEventLegacy the json event legacy of this cache json
	 */
	@Override
	public void setJsonEventLegacy(String jsonEventLegacy) {
		model.setJsonEventLegacy(jsonEventLegacy);
	}

	/**
	 * Sets the modified event of this cache json.
	 *
	 * @param modifiedEvent the modified event of this cache json
	 */
	@Override
	public void setModifiedEvent(Date modifiedEvent) {
		model.setModifiedEvent(modifiedEvent);
	}

	/**
	 * Sets the primary key of this cache json.
	 *
	 * @param primaryKey the primary key of this cache json
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected CacheJsonWrapper wrap(CacheJson cacheJson) {
		return new CacheJsonWrapper(cacheJson);
	}

}