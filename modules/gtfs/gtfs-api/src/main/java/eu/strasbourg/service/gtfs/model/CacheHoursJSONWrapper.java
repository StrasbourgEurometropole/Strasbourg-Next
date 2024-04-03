/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CacheHoursJSON}.
 * </p>
 *
 * @author Cedric Henry
 * @see CacheHoursJSON
 * @generated
 */
public class CacheHoursJSONWrapper
	extends BaseModelWrapper<CacheHoursJSON>
	implements CacheHoursJSON, ModelWrapper<CacheHoursJSON> {

	public CacheHoursJSONWrapper(CacheHoursJSON cacheHoursJSON) {
		super(cacheHoursJSON);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("stopCode", getStopCode());
		attributes.put("type", getType());
		attributes.put("jsonHour", getJsonHour());
		attributes.put("creationDate", getCreationDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		String stopCode = (String)attributes.get("stopCode");

		if (stopCode != null) {
			setStopCode(stopCode);
		}

		Integer type = (Integer)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String jsonHour = (String)attributes.get("jsonHour");

		if (jsonHour != null) {
			setJsonHour(jsonHour);
		}

		Date creationDate = (Date)attributes.get("creationDate");

		if (creationDate != null) {
			setCreationDate(creationDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public CacheHoursJSON cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the creation date of this cache hours json.
	 *
	 * @return the creation date of this cache hours json
	 */
	@Override
	public Date getCreationDate() {
		return model.getCreationDate();
	}

	/**
	 * Returns the json hour of this cache hours json.
	 *
	 * @return the json hour of this cache hours json
	 */
	@Override
	public String getJsonHour() {
		return model.getJsonHour();
	}

	/**
	 * Returns the modified date of this cache hours json.
	 *
	 * @return the modified date of this cache hours json
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this cache hours json.
	 *
	 * @return the primary key of this cache hours json
	 */
	@Override
	public eu.strasbourg.service.gtfs.service.persistence.CacheHoursJSONPK
		getPrimaryKey() {

		return model.getPrimaryKey();
	}

	/**
	 * Returns the stop code of this cache hours json.
	 *
	 * @return the stop code of this cache hours json
	 */
	@Override
	public String getStopCode() {
		return model.getStopCode();
	}

	/**
	 * Returns the type of this cache hours json.
	 *
	 * @return the type of this cache hours json
	 */
	@Override
	public int getType() {
		return model.getType();
	}

	/**
	 * Returns the uuid of this cache hours json.
	 *
	 * @return the uuid of this cache hours json
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
	 * Sets the creation date of this cache hours json.
	 *
	 * @param creationDate the creation date of this cache hours json
	 */
	@Override
	public void setCreationDate(Date creationDate) {
		model.setCreationDate(creationDate);
	}

	/**
	 * Sets the json hour of this cache hours json.
	 *
	 * @param jsonHour the json hour of this cache hours json
	 */
	@Override
	public void setJsonHour(String jsonHour) {
		model.setJsonHour(jsonHour);
	}

	/**
	 * Sets the modified date of this cache hours json.
	 *
	 * @param modifiedDate the modified date of this cache hours json
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this cache hours json.
	 *
	 * @param primaryKey the primary key of this cache hours json
	 */
	@Override
	public void setPrimaryKey(
		eu.strasbourg.service.gtfs.service.persistence.CacheHoursJSONPK
			primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the stop code of this cache hours json.
	 *
	 * @param stopCode the stop code of this cache hours json
	 */
	@Override
	public void setStopCode(String stopCode) {
		model.setStopCode(stopCode);
	}

	/**
	 * Sets the type of this cache hours json.
	 *
	 * @param type the type of this cache hours json
	 */
	@Override
	public void setType(int type) {
		model.setType(type);
	}

	/**
	 * Sets the uuid of this cache hours json.
	 *
	 * @param uuid the uuid of this cache hours json
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
	protected CacheHoursJSONWrapper wrap(CacheHoursJSON cacheHoursJSON) {
		return new CacheHoursJSONWrapper(cacheHoursJSON);
	}

}