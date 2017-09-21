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

package eu.strasbourg.service.favorite.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

/**
 * The base model interface for the Favorite service. Represents a row in the &quot;favorite_Favorite&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link eu.strasbourg.service.favorite.model.impl.FavoriteModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link eu.strasbourg.service.favorite.model.impl.FavoriteImpl}.
 * </p>
 *
 * @author BenjaminBini
 * @see Favorite
 * @see eu.strasbourg.service.favorite.model.impl.FavoriteImpl
 * @see eu.strasbourg.service.favorite.model.impl.FavoriteModelImpl
 * @generated
 */
@ProviderType
public interface FavoriteModel extends BaseModel<Favorite> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a favorite model instance should use the {@link Favorite} interface instead.
	 */

	/**
	 * Returns the primary key of this favorite.
	 *
	 * @return the primary key of this favorite
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this favorite.
	 *
	 * @param primaryKey the primary key of this favorite
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the favorite ID of this favorite.
	 *
	 * @return the favorite ID of this favorite
	 */
	public long getFavoriteId();

	/**
	 * Sets the favorite ID of this favorite.
	 *
	 * @param favoriteId the favorite ID of this favorite
	 */
	public void setFavoriteId(long favoriteId);

	/**
	 * Returns the publik user ID of this favorite.
	 *
	 * @return the publik user ID of this favorite
	 */
	@AutoEscape
	public String getPublikUserId();

	/**
	 * Sets the publik user ID of this favorite.
	 *
	 * @param publikUserId the publik user ID of this favorite
	 */
	public void setPublikUserId(String publikUserId);

	/**
	 * Returns the title of this favorite.
	 *
	 * @return the title of this favorite
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this favorite.
	 *
	 * @param title the title of this favorite
	 */
	public void setTitle(String title);

	/**
	 * Returns the url of this favorite.
	 *
	 * @return the url of this favorite
	 */
	@AutoEscape
	public String getUrl();

	/**
	 * Sets the url of this favorite.
	 *
	 * @param url the url of this favorite
	 */
	public void setUrl(String url);

	/**
	 * Returns the type ID of this favorite.
	 *
	 * @return the type ID of this favorite
	 */
	public long getTypeId();

	/**
	 * Sets the type ID of this favorite.
	 *
	 * @param typeId the type ID of this favorite
	 */
	public void setTypeId(long typeId);

	/**
	 * Returns the entity ID of this favorite.
	 *
	 * @return the entity ID of this favorite
	 */
	public long getEntityId();

	/**
	 * Sets the entity ID of this favorite.
	 *
	 * @param entityId the entity ID of this favorite
	 */
	public void setEntityId(long entityId);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(eu.strasbourg.service.favorite.model.Favorite favorite);

	@Override
	public int hashCode();

	@Override
	public CacheModel<eu.strasbourg.service.favorite.model.Favorite> toCacheModel();

	@Override
	public eu.strasbourg.service.favorite.model.Favorite toEscapedModel();

	@Override
	public eu.strasbourg.service.favorite.model.Favorite toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}