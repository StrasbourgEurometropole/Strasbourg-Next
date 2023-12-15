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
 * This class is a wrapper for {@link CacheAlertJSON}.
 * </p>
 *
 * @author Cedric Henry
 * @see CacheAlertJSON
 * @generated
 */
public class CacheAlertJSONWrapper
	extends BaseModelWrapper<CacheAlertJSON>
	implements CacheAlertJSON, ModelWrapper<CacheAlertJSON> {

	public CacheAlertJSONWrapper(CacheAlertJSON cacheAlertJSON) {
		super(cacheAlertJSON);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("cacheId", getCacheId());
		attributes.put("jsonAlert", getJsonAlert());
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

		Long cacheId = (Long)attributes.get("cacheId");

		if (cacheId != null) {
			setCacheId(cacheId);
		}

		String jsonAlert = (String)attributes.get("jsonAlert");

		if (jsonAlert != null) {
			setJsonAlert(jsonAlert);
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
	public CacheAlertJSON cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the cache ID of this cache alert json.
	 *
	 * @return the cache ID of this cache alert json
	 */
	@Override
	public long getCacheId() {
		return model.getCacheId();
	}

	/**
	 * Returns the creation date of this cache alert json.
	 *
	 * @return the creation date of this cache alert json
	 */
	@Override
	public Date getCreationDate() {
		return model.getCreationDate();
	}

	/**
	 * Returns the json alert of this cache alert json.
	 *
	 * @return the json alert of this cache alert json
	 */
	@Override
	public String getJsonAlert() {
		return model.getJsonAlert();
	}

	/**
	 * Returns the modified date of this cache alert json.
	 *
	 * @return the modified date of this cache alert json
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this cache alert json.
	 *
	 * @return the primary key of this cache alert json
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this cache alert json.
	 *
	 * @return the uuid of this cache alert json
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
	 * Sets the cache ID of this cache alert json.
	 *
	 * @param cacheId the cache ID of this cache alert json
	 */
	@Override
	public void setCacheId(long cacheId) {
		model.setCacheId(cacheId);
	}

	/**
	 * Sets the creation date of this cache alert json.
	 *
	 * @param creationDate the creation date of this cache alert json
	 */
	@Override
	public void setCreationDate(Date creationDate) {
		model.setCreationDate(creationDate);
	}

	/**
	 * Sets the json alert of this cache alert json.
	 *
	 * @param jsonAlert the json alert of this cache alert json
	 */
	@Override
	public void setJsonAlert(String jsonAlert) {
		model.setJsonAlert(jsonAlert);
	}

	/**
	 * Sets the modified date of this cache alert json.
	 *
	 * @param modifiedDate the modified date of this cache alert json
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this cache alert json.
	 *
	 * @param primaryKey the primary key of this cache alert json
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this cache alert json.
	 *
	 * @param uuid the uuid of this cache alert json
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
	protected CacheAlertJSONWrapper wrap(CacheAlertJSON cacheAlertJSON) {
		return new CacheAlertJSONWrapper(cacheAlertJSON);
	}

}