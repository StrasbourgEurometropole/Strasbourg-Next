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
 * This class is a wrapper for {@link CsmapCacheJson}.
 * </p>
 *
 * @author BenjaminBini
 * @see CsmapCacheJson
 * @generated
 */
public class CsmapCacheJsonWrapper
	extends BaseModelWrapper<CsmapCacheJson>
	implements CsmapCacheJson, ModelWrapper<CsmapCacheJson> {

	public CsmapCacheJsonWrapper(CsmapCacheJson csmapCacheJson) {
		super(csmapCacheJson);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("eventId", getEventId());
		attributes.put("jsonEvent", getJsonEvent());
		attributes.put("createEvent", getCreateEvent());
		attributes.put("modifiedEvent", getModifiedEvent());
		attributes.put("isActive", isIsActive());
		attributes.put("regeneratedDate", getRegeneratedDate());
		attributes.put("hasSchedules", isHasSchedules());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long eventId = (Long)attributes.get("eventId");

		if (eventId != null) {
			setEventId(eventId);
		}

		String jsonEvent = (String)attributes.get("jsonEvent");

		if (jsonEvent != null) {
			setJsonEvent(jsonEvent);
		}

		Date createEvent = (Date)attributes.get("createEvent");

		if (createEvent != null) {
			setCreateEvent(createEvent);
		}

		Date modifiedEvent = (Date)attributes.get("modifiedEvent");

		if (modifiedEvent != null) {
			setModifiedEvent(modifiedEvent);
		}

		Boolean isActive = (Boolean)attributes.get("isActive");

		if (isActive != null) {
			setIsActive(isActive);
		}

		Date regeneratedDate = (Date)attributes.get("regeneratedDate");

		if (regeneratedDate != null) {
			setRegeneratedDate(regeneratedDate);
		}

		Boolean hasSchedules = (Boolean)attributes.get("hasSchedules");

		if (hasSchedules != null) {
			setHasSchedules(hasSchedules);
		}
	}

	@Override
	public CsmapCacheJson cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the create event of this csmap cache json.
	 *
	 * @return the create event of this csmap cache json
	 */
	@Override
	public Date getCreateEvent() {
		return model.getCreateEvent();
	}

	/**
	 * Returns the event ID of this csmap cache json.
	 *
	 * @return the event ID of this csmap cache json
	 */
	@Override
	public long getEventId() {
		return model.getEventId();
	}

	/**
	 * Returns the has schedules of this csmap cache json.
	 *
	 * @return the has schedules of this csmap cache json
	 */
	@Override
	public boolean getHasSchedules() {
		return model.getHasSchedules();
	}

	/**
	 * Returns the is active of this csmap cache json.
	 *
	 * @return the is active of this csmap cache json
	 */
	@Override
	public boolean getIsActive() {
		return model.getIsActive();
	}

	/**
	 * Returns the json event of this csmap cache json.
	 *
	 * @return the json event of this csmap cache json
	 */
	@Override
	public String getJsonEvent() {
		return model.getJsonEvent();
	}

	/**
	 * Returns the modified event of this csmap cache json.
	 *
	 * @return the modified event of this csmap cache json
	 */
	@Override
	public Date getModifiedEvent() {
		return model.getModifiedEvent();
	}

	/**
	 * Returns the primary key of this csmap cache json.
	 *
	 * @return the primary key of this csmap cache json
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the regenerated date of this csmap cache json.
	 *
	 * @return the regenerated date of this csmap cache json
	 */
	@Override
	public Date getRegeneratedDate() {
		return model.getRegeneratedDate();
	}

	/**
	 * Returns the uuid of this csmap cache json.
	 *
	 * @return the uuid of this csmap cache json
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this csmap cache json is has schedules.
	 *
	 * @return <code>true</code> if this csmap cache json is has schedules; <code>false</code> otherwise
	 */
	@Override
	public boolean isHasSchedules() {
		return model.isHasSchedules();
	}

	/**
	 * Returns <code>true</code> if this csmap cache json is is active.
	 *
	 * @return <code>true</code> if this csmap cache json is is active; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsActive() {
		return model.isIsActive();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the create event of this csmap cache json.
	 *
	 * @param createEvent the create event of this csmap cache json
	 */
	@Override
	public void setCreateEvent(Date createEvent) {
		model.setCreateEvent(createEvent);
	}

	/**
	 * Sets the event ID of this csmap cache json.
	 *
	 * @param eventId the event ID of this csmap cache json
	 */
	@Override
	public void setEventId(long eventId) {
		model.setEventId(eventId);
	}

	/**
	 * Sets whether this csmap cache json is has schedules.
	 *
	 * @param hasSchedules the has schedules of this csmap cache json
	 */
	@Override
	public void setHasSchedules(boolean hasSchedules) {
		model.setHasSchedules(hasSchedules);
	}

	/**
	 * Sets whether this csmap cache json is is active.
	 *
	 * @param isActive the is active of this csmap cache json
	 */
	@Override
	public void setIsActive(boolean isActive) {
		model.setIsActive(isActive);
	}

	/**
	 * Sets the json event of this csmap cache json.
	 *
	 * @param jsonEvent the json event of this csmap cache json
	 */
	@Override
	public void setJsonEvent(String jsonEvent) {
		model.setJsonEvent(jsonEvent);
	}

	/**
	 * Sets the modified event of this csmap cache json.
	 *
	 * @param modifiedEvent the modified event of this csmap cache json
	 */
	@Override
	public void setModifiedEvent(Date modifiedEvent) {
		model.setModifiedEvent(modifiedEvent);
	}

	/**
	 * Sets the primary key of this csmap cache json.
	 *
	 * @param primaryKey the primary key of this csmap cache json
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the regenerated date of this csmap cache json.
	 *
	 * @param regeneratedDate the regenerated date of this csmap cache json
	 */
	@Override
	public void setRegeneratedDate(Date regeneratedDate) {
		model.setRegeneratedDate(regeneratedDate);
	}

	/**
	 * Sets the uuid of this csmap cache json.
	 *
	 * @param uuid the uuid of this csmap cache json
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
	protected CsmapCacheJsonWrapper wrap(CsmapCacheJson csmapCacheJson) {
		return new CsmapCacheJsonWrapper(csmapCacheJson);
	}

}