/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.csmap.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the CsmapCache service. Represents a row in the &quot;csmap_CsmapCache&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>eu.strasbourg.service.csmap.model.impl.CsmapCacheModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>eu.strasbourg.service.csmap.model.impl.CsmapCacheImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CsmapCache
 * @generated
 */
@ProviderType
public interface CsmapCacheModel extends BaseModel<CsmapCache> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a csmap cache model instance should use the {@link CsmapCache} interface instead.
	 */

	/**
	 * Returns the primary key of this csmap cache.
	 *
	 * @return the primary key of this csmap cache
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this csmap cache.
	 *
	 * @param primaryKey the primary key of this csmap cache
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the cache ID of this csmap cache.
	 *
	 * @return the cache ID of this csmap cache
	 */
	public long getCacheId();

	/**
	 * Sets the cache ID of this csmap cache.
	 *
	 * @param cacheId the cache ID of this csmap cache
	 */
	public void setCacheId(long cacheId);

	/**
	 * Returns the code cache of this csmap cache.
	 *
	 * @return the code cache of this csmap cache
	 */
	public long getCodeCache();

	/**
	 * Sets the code cache of this csmap cache.
	 *
	 * @param codeCache the code cache of this csmap cache
	 */
	public void setCodeCache(long codeCache);

	/**
	 * Returns the description of this csmap cache.
	 *
	 * @return the description of this csmap cache
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this csmap cache.
	 *
	 * @param description the description of this csmap cache
	 */
	public void setDescription(String description);

	/**
	 * Returns the cache json of this csmap cache.
	 *
	 * @return the cache json of this csmap cache
	 */
	@AutoEscape
	public String getCacheJson();

	/**
	 * Sets the cache json of this csmap cache.
	 *
	 * @param cacheJson the cache json of this csmap cache
	 */
	public void setCacheJson(String cacheJson);

	/**
	 * Returns the is last process success of this csmap cache.
	 *
	 * @return the is last process success of this csmap cache
	 */
	public Boolean getIsLastProcessSuccess();

	/**
	 * Sets the is last process success of this csmap cache.
	 *
	 * @param isLastProcessSuccess the is last process success of this csmap cache
	 */
	public void setIsLastProcessSuccess(Boolean isLastProcessSuccess);

	/**
	 * Returns the modified date of this csmap cache.
	 *
	 * @return the modified date of this csmap cache
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this csmap cache.
	 *
	 * @param modifiedDate the modified date of this csmap cache
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the processed date of this csmap cache.
	 *
	 * @return the processed date of this csmap cache
	 */
	public Date getProcessedDate();

	/**
	 * Sets the processed date of this csmap cache.
	 *
	 * @param processedDate the processed date of this csmap cache
	 */
	public void setProcessedDate(Date processedDate);

	@Override
	public CsmapCache cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}