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
 * The base model interface for the RefreshToken service. Represents a row in the &quot;csmap_RefreshToken&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>eu.strasbourg.service.csmap.model.impl.RefreshTokenModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>eu.strasbourg.service.csmap.model.impl.RefreshTokenImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RefreshToken
 * @generated
 */
@ProviderType
public interface RefreshTokenModel extends BaseModel<RefreshToken> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a refresh token model instance should use the {@link RefreshToken} interface instead.
	 */

	/**
	 * Returns the primary key of this refresh token.
	 *
	 * @return the primary key of this refresh token
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this refresh token.
	 *
	 * @param primaryKey the primary key of this refresh token
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this refresh token.
	 *
	 * @return the uuid of this refresh token
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this refresh token.
	 *
	 * @param uuid the uuid of this refresh token
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the refresh token ID of this refresh token.
	 *
	 * @return the refresh token ID of this refresh token
	 */
	public long getRefreshTokenId();

	/**
	 * Sets the refresh token ID of this refresh token.
	 *
	 * @param refreshTokenId the refresh token ID of this refresh token
	 */
	public void setRefreshTokenId(long refreshTokenId);

	/**
	 * Returns the create date of this refresh token.
	 *
	 * @return the create date of this refresh token
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this refresh token.
	 *
	 * @param createDate the create date of this refresh token
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the value of this refresh token.
	 *
	 * @return the value of this refresh token
	 */
	@AutoEscape
	public String getValue();

	/**
	 * Sets the value of this refresh token.
	 *
	 * @param value the value of this refresh token
	 */
	public void setValue(String value);

	/**
	 * Returns the publik ID of this refresh token.
	 *
	 * @return the publik ID of this refresh token
	 */
	@AutoEscape
	public String getPublikId();

	/**
	 * Sets the publik ID of this refresh token.
	 *
	 * @param publikId the publik ID of this refresh token
	 */
	public void setPublikId(String publikId);

}