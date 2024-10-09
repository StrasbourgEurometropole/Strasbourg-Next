/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.like.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Like}.
 * </p>
 *
 * @author Cedric Henry
 * @see Like
 * @generated
 */
public class LikeWrapper
	extends BaseModelWrapper<Like> implements Like, ModelWrapper<Like> {

	public LikeWrapper(Like like) {
		super(like);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("likeId", getLikeId());
		attributes.put("publikUserId", getPublikUserId());
		attributes.put("title", getTitle());
		attributes.put("isDislike", isIsDislike());
		attributes.put("typeId", getTypeId());
		attributes.put("entityId", getEntityId());
		attributes.put("entityGroupId", getEntityGroupId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long likeId = (Long)attributes.get("likeId");

		if (likeId != null) {
			setLikeId(likeId);
		}

		String publikUserId = (String)attributes.get("publikUserId");

		if (publikUserId != null) {
			setPublikUserId(publikUserId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		Boolean isDislike = (Boolean)attributes.get("isDislike");

		if (isDislike != null) {
			setIsDislike(isDislike);
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
	}

	@Override
	public Like cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the entity group ID of this like.
	 *
	 * @return the entity group ID of this like
	 */
	@Override
	public long getEntityGroupId() {
		return model.getEntityGroupId();
	}

	/**
	 * Returns the entity ID of this like.
	 *
	 * @return the entity ID of this like
	 */
	@Override
	public long getEntityId() {
		return model.getEntityId();
	}

	/**
	 * Returns the is dislike of this like.
	 *
	 * @return the is dislike of this like
	 */
	@Override
	public boolean getIsDislike() {
		return model.getIsDislike();
	}

	/**
	 * Returns the like ID of this like.
	 *
	 * @return the like ID of this like
	 */
	@Override
	public long getLikeId() {
		return model.getLikeId();
	}

	@Override
	public LikeType getLikeType() {
		return model.getLikeType();
	}

	/**
	 * Returns the primary key of this like.
	 *
	 * @return the primary key of this like
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the publik user ID of this like.
	 *
	 * @return the publik user ID of this like
	 */
	@Override
	public String getPublikUserId() {
		return model.getPublikUserId();
	}

	/**
	 * Returns the title of this like.
	 *
	 * @return the title of this like
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the type ID of this like.
	 *
	 * @return the type ID of this like
	 */
	@Override
	public long getTypeId() {
		return model.getTypeId();
	}

	/**
	 * Returns <code>true</code> if this like is is dislike.
	 *
	 * @return <code>true</code> if this like is is dislike; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsDislike() {
		return model.isIsDislike();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the entity group ID of this like.
	 *
	 * @param entityGroupId the entity group ID of this like
	 */
	@Override
	public void setEntityGroupId(long entityGroupId) {
		model.setEntityGroupId(entityGroupId);
	}

	/**
	 * Sets the entity ID of this like.
	 *
	 * @param entityId the entity ID of this like
	 */
	@Override
	public void setEntityId(long entityId) {
		model.setEntityId(entityId);
	}

	/**
	 * Sets whether this like is is dislike.
	 *
	 * @param isDislike the is dislike of this like
	 */
	@Override
	public void setIsDislike(boolean isDislike) {
		model.setIsDislike(isDislike);
	}

	/**
	 * Sets the like ID of this like.
	 *
	 * @param likeId the like ID of this like
	 */
	@Override
	public void setLikeId(long likeId) {
		model.setLikeId(likeId);
	}

	/**
	 * Sets the primary key of this like.
	 *
	 * @param primaryKey the primary key of this like
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the publik user ID of this like.
	 *
	 * @param publikUserId the publik user ID of this like
	 */
	@Override
	public void setPublikUserId(String publikUserId) {
		model.setPublikUserId(publikUserId);
	}

	/**
	 * Sets the title of this like.
	 *
	 * @param title the title of this like
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the type ID of this like.
	 *
	 * @param typeId the type ID of this like
	 */
	@Override
	public void setTypeId(long typeId) {
		model.setTypeId(typeId);
	}

	/**
	 * Retourne la version JSON d'un like/dislike
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
	protected LikeWrapper wrap(Like like) {
		return new LikeWrapper(like);
	}

}