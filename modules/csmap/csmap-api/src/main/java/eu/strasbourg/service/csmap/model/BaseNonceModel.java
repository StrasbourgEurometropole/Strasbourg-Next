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

package eu.strasbourg.service.csmap.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the BaseNonce service. Represents a row in the &quot;csmap_BaseNonce&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>eu.strasbourg.service.csmap.model.impl.BaseNonceModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>eu.strasbourg.service.csmap.model.impl.BaseNonceImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BaseNonce
 * @generated
 */
@ProviderType
public interface BaseNonceModel extends BaseModel<BaseNonce> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a base nonce model instance should use the {@link BaseNonce} interface instead.
	 */

	/**
	 * Returns the primary key of this base nonce.
	 *
	 * @return the primary key of this base nonce
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this base nonce.
	 *
	 * @param primaryKey the primary key of this base nonce
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the base nonce ID of this base nonce.
	 *
	 * @return the base nonce ID of this base nonce
	 */
	public long getBaseNonceId();

	/**
	 * Sets the base nonce ID of this base nonce.
	 *
	 * @param baseNonceId the base nonce ID of this base nonce
	 */
	public void setBaseNonceId(long baseNonceId);

	/**
	 * Returns the create date of this base nonce.
	 *
	 * @return the create date of this base nonce
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this base nonce.
	 *
	 * @param createDate the create date of this base nonce
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the value of this base nonce.
	 *
	 * @return the value of this base nonce
	 */
	@AutoEscape
	public String getValue();

	/**
	 * Sets the value of this base nonce.
	 *
	 * @param value the value of this base nonce
	 */
	public void setValue(String value);

}