/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.like.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Like service. Represents a row in the &quot;like_Like&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>eu.strasbourg.service.like.model.impl.LikeModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>eu.strasbourg.service.like.model.impl.LikeImpl</code>.
 * </p>
 *
 * @author Cedric Henry
 * @see Like
 * @generated
 */
@ProviderType
public interface LikeModel extends BaseModel<Like> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a like model instance should use the {@link Like} interface instead.
	 */

	/**
	 * Returns the primary key of this like.
	 *
	 * @return the primary key of this like
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this like.
	 *
	 * @param primaryKey the primary key of this like
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the like ID of this like.
	 *
	 * @return the like ID of this like
	 */
	public long getLikeId();

	/**
	 * Sets the like ID of this like.
	 *
	 * @param likeId the like ID of this like
	 */
	public void setLikeId(long likeId);

	/**
	 * Returns the publik user ID of this like.
	 *
	 * @return the publik user ID of this like
	 */
	@AutoEscape
	public String getPublikUserId();

	/**
	 * Sets the publik user ID of this like.
	 *
	 * @param publikUserId the publik user ID of this like
	 */
	public void setPublikUserId(String publikUserId);

	/**
	 * Returns the title of this like.
	 *
	 * @return the title of this like
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this like.
	 *
	 * @param title the title of this like
	 */
	public void setTitle(String title);

	/**
	 * Returns the is dislike of this like.
	 *
	 * @return the is dislike of this like
	 */
	public boolean getIsDislike();

	/**
	 * Returns <code>true</code> if this like is is dislike.
	 *
	 * @return <code>true</code> if this like is is dislike; <code>false</code> otherwise
	 */
	public boolean isIsDislike();

	/**
	 * Sets whether this like is is dislike.
	 *
	 * @param isDislike the is dislike of this like
	 */
	public void setIsDislike(boolean isDislike);

	/**
	 * Returns the type ID of this like.
	 *
	 * @return the type ID of this like
	 */
	public long getTypeId();

	/**
	 * Sets the type ID of this like.
	 *
	 * @param typeId the type ID of this like
	 */
	public void setTypeId(long typeId);

	/**
	 * Returns the entity ID of this like.
	 *
	 * @return the entity ID of this like
	 */
	public long getEntityId();

	/**
	 * Sets the entity ID of this like.
	 *
	 * @param entityId the entity ID of this like
	 */
	public void setEntityId(long entityId);

	/**
	 * Returns the entity group ID of this like.
	 *
	 * @return the entity group ID of this like
	 */
	public long getEntityGroupId();

	/**
	 * Sets the entity group ID of this like.
	 *
	 * @param entityGroupId the entity group ID of this like
	 */
	public void setEntityGroupId(long entityGroupId);

	@Override
	public Like cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}