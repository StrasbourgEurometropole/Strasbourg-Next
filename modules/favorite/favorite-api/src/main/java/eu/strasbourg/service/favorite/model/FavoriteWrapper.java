/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.favorite.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Favorite}.
 * </p>
 *
 * @author BenjaminBini
 * @see Favorite
 * @generated
 */
public class FavoriteWrapper
	extends BaseModelWrapper<Favorite>
	implements Favorite, ModelWrapper<Favorite> {

	public FavoriteWrapper(Favorite favorite) {
		super(favorite);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("favoriteId", getFavoriteId());
		attributes.put("publikUserId", getPublikUserId());
		attributes.put("title", getTitle());
		attributes.put("url", getUrl());
		attributes.put("typeId", getTypeId());
		attributes.put("entityId", getEntityId());
		attributes.put("entityGroupId", getEntityGroupId());
		attributes.put("onDashboardDate", getOnDashboardDate());
		attributes.put("order", getOrder());
		attributes.put("content", getContent());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long favoriteId = (Long)attributes.get("favoriteId");

		if (favoriteId != null) {
			setFavoriteId(favoriteId);
		}

		String publikUserId = (String)attributes.get("publikUserId");

		if (publikUserId != null) {
			setPublikUserId(publikUserId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}

		Long typeId = (Long)attributes.get("typeId");

		if (typeId != null) {
			setTypeId(typeId);
		}

		Long entityId = (Long)attributes.get("entityId");

		if (entityId != null) {
			setEntityId(entityId);
		}

		Long entityGroupId = (Long)attributes.get("entityGroupId");

		if (entityGroupId != null) {
			setEntityGroupId(entityGroupId);
		}

		Date onDashboardDate = (Date)attributes.get("onDashboardDate");

		if (onDashboardDate != null) {
			setOnDashboardDate(onDashboardDate);
		}

		Integer order = (Integer)attributes.get("order");

		if (order != null) {
			setOrder(order);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public Favorite cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	@Override
	public com.liferay.asset.kernel.model.AssetEntry getAssetEntry() {
		return model.getAssetEntry();
	}

	/**
	 * Returns the content of this favorite.
	 *
	 * @return the content of this favorite
	 */
	@Override
	public String getContent() {
		return model.getContent();
	}

	/**
	 * Returns the create date of this favorite.
	 *
	 * @return the create date of this favorite
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the entity group ID of this favorite.
	 *
	 * @return the entity group ID of this favorite
	 */
	@Override
	public long getEntityGroupId() {
		return model.getEntityGroupId();
	}

	/**
	 * Returns the entity ID of this favorite.
	 *
	 * @return the entity ID of this favorite
	 */
	@Override
	public long getEntityId() {
		return model.getEntityId();
	}

	/**
	 * Returns the favorite ID of this favorite.
	 *
	 * @return the favorite ID of this favorite
	 */
	@Override
	public long getFavoriteId() {
		return model.getFavoriteId();
	}

	@Override
	public eu.strasbourg.service.favorite.model.FavoriteType getFavoriteType() {
		return model.getFavoriteType();
	}

	/**
	 * Returns the modified date of this favorite.
	 *
	 * @return the modified date of this favorite
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the on dashboard date of this favorite.
	 *
	 * @return the on dashboard date of this favorite
	 */
	@Override
	public Date getOnDashboardDate() {
		return model.getOnDashboardDate();
	}

	/**
	 * Returns the order of this favorite.
	 *
	 * @return the order of this favorite
	 */
	@Override
	public int getOrder() {
		return model.getOrder();
	}

	/**
	 * Returns the primary key of this favorite.
	 *
	 * @return the primary key of this favorite
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the publik user ID of this favorite.
	 *
	 * @return the publik user ID of this favorite
	 */
	@Override
	public String getPublikUserId() {
		return model.getPublikUserId();
	}

	/**
	 * Returns the title of this favorite.
	 *
	 * @return the title of this favorite
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the type ID of this favorite.
	 *
	 * @return the type ID of this favorite
	 */
	@Override
	public long getTypeId() {
		return model.getTypeId();
	}

	/**
	 * Returns the url of this favorite.
	 *
	 * @return the url of this favorite
	 */
	@Override
	public String getUrl() {
		return model.getUrl();
	}

	@Override
	public boolean hasAssetEntry() {
		return model.hasAssetEntry();
	}

	@Override
	public boolean isOnDashboard() {
		return model.isOnDashboard();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the content of this favorite.
	 *
	 * @param content the content of this favorite
	 */
	@Override
	public void setContent(String content) {
		model.setContent(content);
	}

	/**
	 * Sets the create date of this favorite.
	 *
	 * @param createDate the create date of this favorite
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the entity group ID of this favorite.
	 *
	 * @param entityGroupId the entity group ID of this favorite
	 */
	@Override
	public void setEntityGroupId(long entityGroupId) {
		model.setEntityGroupId(entityGroupId);
	}

	/**
	 * Sets the entity ID of this favorite.
	 *
	 * @param entityId the entity ID of this favorite
	 */
	@Override
	public void setEntityId(long entityId) {
		model.setEntityId(entityId);
	}

	/**
	 * Sets the favorite ID of this favorite.
	 *
	 * @param favoriteId the favorite ID of this favorite
	 */
	@Override
	public void setFavoriteId(long favoriteId) {
		model.setFavoriteId(favoriteId);
	}

	/**
	 * Sets the modified date of this favorite.
	 *
	 * @param modifiedDate the modified date of this favorite
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the on dashboard date of this favorite.
	 *
	 * @param onDashboardDate the on dashboard date of this favorite
	 */
	@Override
	public void setOnDashboardDate(Date onDashboardDate) {
		model.setOnDashboardDate(onDashboardDate);
	}

	/**
	 * Sets the order of this favorite.
	 *
	 * @param order the order of this favorite
	 */
	@Override
	public void setOrder(int order) {
		model.setOrder(order);
	}

	/**
	 * Sets the primary key of this favorite.
	 *
	 * @param primaryKey the primary key of this favorite
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the publik user ID of this favorite.
	 *
	 * @param publikUserId the publik user ID of this favorite
	 */
	@Override
	public void setPublikUserId(String publikUserId) {
		model.setPublikUserId(publikUserId);
	}

	/**
	 * Sets the title of this favorite.
	 *
	 * @param title the title of this favorite
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the type ID of this favorite.
	 *
	 * @param typeId the type ID of this favorite
	 */
	@Override
	public void setTypeId(long typeId) {
		model.setTypeId(typeId);
	}

	/**
	 * Sets the url of this favorite.
	 *
	 * @param url the url of this favorite
	 */
	@Override
	public void setUrl(String url) {
		model.setUrl(url);
	}

	/**
	 * Retourne la version JSON d'un favoris
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
	protected FavoriteWrapper wrap(Favorite favorite) {
		return new FavoriteWrapper(favorite);
	}

}