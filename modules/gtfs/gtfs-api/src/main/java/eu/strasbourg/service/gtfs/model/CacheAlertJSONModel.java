/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the CacheAlertJSON service. Represents a row in the &quot;gtfs_CacheAlertJSON&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>eu.strasbourg.service.gtfs.model.impl.CacheAlertJSONModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>eu.strasbourg.service.gtfs.model.impl.CacheAlertJSONImpl</code>.
 * </p>
 *
 * @author Cedric Henry
 * @see CacheAlertJSON
 * @generated
 */
@ProviderType
public interface CacheAlertJSONModel extends BaseModel<CacheAlertJSON> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a cache alert json model instance should use the {@link CacheAlertJSON} interface instead.
	 */

	/**
	 * Returns the primary key of this cache alert json.
	 *
	 * @return the primary key of this cache alert json
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this cache alert json.
	 *
	 * @param primaryKey the primary key of this cache alert json
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this cache alert json.
	 *
	 * @return the uuid of this cache alert json
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this cache alert json.
	 *
	 * @param uuid the uuid of this cache alert json
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the cache ID of this cache alert json.
	 *
	 * @return the cache ID of this cache alert json
	 */
	public long getCacheId();

	/**
	 * Sets the cache ID of this cache alert json.
	 *
	 * @param cacheId the cache ID of this cache alert json
	 */
	public void setCacheId(long cacheId);

	/**
	 * Returns the json alert of this cache alert json.
	 *
	 * @return the json alert of this cache alert json
	 */
	@AutoEscape
	public String getJsonAlert();

	/**
	 * Sets the json alert of this cache alert json.
	 *
	 * @param jsonAlert the json alert of this cache alert json
	 */
	public void setJsonAlert(String jsonAlert);

	/**
	 * Returns the creation date of this cache alert json.
	 *
	 * @return the creation date of this cache alert json
	 */
	public Date getCreationDate();

	/**
	 * Sets the creation date of this cache alert json.
	 *
	 * @param creationDate the creation date of this cache alert json
	 */
	public void setCreationDate(Date creationDate);

	/**
	 * Returns the modified date of this cache alert json.
	 *
	 * @return the modified date of this cache alert json
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this cache alert json.
	 *
	 * @param modifiedDate the modified date of this cache alert json
	 */
	public void setModifiedDate(Date modifiedDate);

	@Override
	public CacheAlertJSON cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}