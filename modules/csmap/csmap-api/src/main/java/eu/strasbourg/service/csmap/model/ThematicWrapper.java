/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.csmap.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Thematic}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Thematic
 * @generated
 */
public class ThematicWrapper
	extends BaseModelWrapper<Thematic>
	implements ModelWrapper<Thematic>, Thematic {

	public ThematicWrapper(Thematic thematic) {
		super(thematic);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("thematicId", getThematicId());
		attributes.put("name", getName());
		attributes.put("favorite", getFavorite());
		attributes.put("topics", getTopics());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long thematicId = (Long)attributes.get("thematicId");

		if (thematicId != null) {
			setThematicId(thematicId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String favorite = (String)attributes.get("favorite");

		if (favorite != null) {
			setFavorite(favorite);
		}

		String topics = (String)attributes.get("topics");

		if (topics != null) {
			setTopics(topics);
		}
	}

	@Override
	public Thematic cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the favorite of this thematic.
	 *
	 * @return the favorite of this thematic
	 */
	@Override
	public String getFavorite() {
		return model.getFavorite();
	}

	/**
	 * Returns the name of this thematic.
	 *
	 * @return the name of this thematic
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this thematic.
	 *
	 * @return the primary key of this thematic
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the thematic ID of this thematic.
	 *
	 * @return the thematic ID of this thematic
	 */
	@Override
	public long getThematicId() {
		return model.getThematicId();
	}

	/**
	 * Returns the topics of this thematic.
	 *
	 * @return the topics of this thematic
	 */
	@Override
	public String getTopics() {
		return model.getTopics();
	}

	/**
	 * Returns the uuid of this thematic.
	 *
	 * @return the uuid of this thematic
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
	 * Sets the favorite of this thematic.
	 *
	 * @param favorite the favorite of this thematic
	 */
	@Override
	public void setFavorite(String favorite) {
		model.setFavorite(favorite);
	}

	/**
	 * Sets the name of this thematic.
	 *
	 * @param name the name of this thematic
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this thematic.
	 *
	 * @param primaryKey the primary key of this thematic
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the thematic ID of this thematic.
	 *
	 * @param thematicId the thematic ID of this thematic
	 */
	@Override
	public void setThematicId(long thematicId) {
		model.setThematicId(thematicId);
	}

	/**
	 * Sets the topics of this thematic.
	 *
	 * @param topics the topics of this thematic
	 */
	@Override
	public void setTopics(String topics) {
		model.setTopics(topics);
	}

	/**
	 * Sets the uuid of this thematic.
	 *
	 * @param uuid the uuid of this thematic
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
	protected ThematicWrapper wrap(Thematic thematic) {
		return new ThematicWrapper(thematic);
	}

}